package com.epam.training.jp.jdbc.excercises.dao.jdbcimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.epam.training.jp.jdbc.excercises.dao.FoodDao;
import com.epam.training.jp.jdbc.excercises.domain.Food;

public class JdbcFoodDao extends GenericJdbcDao implements FoodDao {

	public JdbcFoodDao(DataSource dataSource) {
		super(dataSource);
	}
	
	
	@Override
	public Food findFoodByName(String name) {
		String sql = "SELECT ID, CALORIES, ISVEGAN, NAME, PRICE from FOOD WHERE NAME = ? ";
		
		try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1,  name);			
						
			try (ResultSet rs = ps.executeQuery()) {
				if (!rs.next()) {
					throw new RuntimeException("Food not found");
				}
				else {
					Food food = new Food();					
					food.setId(rs.getInt(1));
					food.setCalories(rs.getInt(2));
					food.setVegan(rs.getBoolean(3));
					food.setName(rs.getString(4));
					food.setPrice(rs.getInt(5));
					return food;
				}
			}
		} 
		catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	@Override
	public void updateFoodPriceByName(String name, int newPrice) {
		String sql = "UPDATE food SET PRICE = ? WHERE NAME = ?";   


		try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, newPrice);			
			ps.setString(2, name);
			int rowsUpdated = ps.executeUpdate();
			if (rowsUpdated != 1) {
				throw new RuntimeException("Zero or more than one row updated.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}


	@Override
	public void save(List<Food> foods) {

		String sql = "insert INTO food VALUES(null, ?, ?, ?, ?);";

		try (Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			conn.setAutoCommit(false);
			for (Food actualFood : foods) {
				ps.setInt(1, actualFood.getCalories());
				ps.setBoolean(2, actualFood.isVegan());
				ps.setString(3, actualFood.getName());
				ps.setInt(4, actualFood.getPrice());
				ps.addBatch();
			}

			ps.executeBatch();
			ps.clearBatch();
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	

}
