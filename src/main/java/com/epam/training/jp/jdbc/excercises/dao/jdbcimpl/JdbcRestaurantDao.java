package com.epam.training.jp.jdbc.excercises.dao.jdbcimpl;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.epam.training.jp.jdbc.excercises.dao.RestaurantDao;
import com.epam.training.jp.jdbc.excercises.domain.Food;
import com.epam.training.jp.jdbc.excercises.dto.RestaurantWithAddress;

public class JdbcRestaurantDao extends GenericJdbcDao implements RestaurantDao {

	public JdbcRestaurantDao(DataSource dataSource) {
		super(dataSource);
	}

	@Override
	public List<Food> getFoodsAvailable(Date date, String restaurantName) {
		//TODO: implement
		throw new UnsupportedOperationException();
	}

	@Override
	public List<RestaurantWithAddress> getAllRestaurantsWithAddress() {
		//TODO: implement
		throw new UnsupportedOperationException();
	}
	



}
