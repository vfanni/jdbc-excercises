package com.epam.training.jp.jdbc.excercises.dao.jdbcimpl;

import static com.google.common.collect.Lists.newArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.epam.training.jp.jdbc.excercises.dao.RestaurantDao;
import com.epam.training.jp.jdbc.excercises.domain.Address;
import com.epam.training.jp.jdbc.excercises.domain.Food;
import com.epam.training.jp.jdbc.excercises.domain.Restaurant;
import com.epam.training.jp.jdbc.excercises.dto.RestaurantWithAddress;

public class JdbcRestaurantDao extends GenericJdbcDao implements RestaurantDao {

	public JdbcRestaurantDao(DataSource dataSource) {
		super(dataSource);
	}

	@Override
	public List<Food> getFoodsAvailable(Date date, String restaurantName) {
		String sql = "SELECT FOOD.ID, FOOD.CALORIES, FOOD.ISVEGAN, FOOD.NAME, FOOD.PRICE "
				+ "FROM FOOD "
				+ "JOIN MENU_FOOD ON FOOD.ID = MENU_FOOD.FOOD_ID "
				+ "JOIN MENU ON MENU.ID = MENU_FOOD.MENU_ID "
				+ "JOIN RESTAURANT ON RESTAURANT.ID = MENU.RESTAURANT_ID "
				+ "WHERE RESTAURANT.NAME = ? AND ? BETWEEN FROMDATE AND TODATE";
		
		try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1,  restaurantName);
			ps.setDate(2, new java.sql.Date(date.getTime()));
			
			
			List<Food> foods = newArrayList();
			try (ResultSet rs = ps.executeQuery()) {
				Food food;
				while (rs.next()) {
					food = new Food();					
					food.setId(rs.getInt(1));
					food.setCalories(rs.getInt(2));
					food.setVegan(rs.getBoolean(3));
					food.setName(rs.getString(4));
					food.setPrice(rs.getInt(5));
					foods.add(food);
				}
			}
			return foods;
		} 
		catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public List<RestaurantWithAddress> getAllRestaurantsWithAddress() {
		String sql = "SELECT RESTAURANT.ID, RESTAURANT.NAME, "
				+ "	ADDRESS.ID, ADDRESS.CITY, ADDRESS.COUNTRY, ADDRESS.STREET, ADDRESS.ZIPCODE "
				+ "FROM RESTAURANT "
				+ "JOIN ADDRESS ON ADDRESS.ID = RESTAURANT.ADDRESS_ID ";
		
		try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {			
			List<RestaurantWithAddress> restaurantWithAddresses = newArrayList();
			try (ResultSet rs = ps.executeQuery()) {
				Restaurant restaurant;
				Address address;
				while (rs.next()) {
					restaurant = new Restaurant();
					restaurant.setId(rs.getInt("RESTAURANT.ID"));
					restaurant.setName(rs.getString("RESTAURANT.NAME"));
					address = new Address();
					address.setCity(rs.getString("ADDRESS.CITY"));
					address.setCountry(rs.getString("ADDRESS.COUNTRY"));
					address.setStreet(rs.getString("ADDRESS.STREET"));
					address.setZipCode(rs.getString("ADDRESS.ZIPCODE"));
					restaurantWithAddresses.add(new RestaurantWithAddress(restaurant, address));
				}
			}
			return restaurantWithAddresses;
		} 
		catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
	



}
