package com.epam.training.jp.jdbc.excercises.dao.jdbctemplateimpl;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.epam.training.jp.jdbc.excercises.dao.RestaurantDao;
import com.epam.training.jp.jdbc.excercises.domain.Food;
import com.epam.training.jp.jdbc.excercises.dto.RestaurantWithAddress;

public class JdbcTemplateRestaurantDao extends JdbcDaoSupport implements RestaurantDao {

	public JdbcTemplateRestaurantDao(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public List<Food> getFoodsAvailable(Date date, String restaurantName) {
		//TODO: implement, use RowMapper
		throw new UnsupportedOperationException();

		
	}

	@Override
	public List<RestaurantWithAddress> getAllRestaurantsWithAddress() {
		//TODO: implement, use RowMapper
		throw new UnsupportedOperationException();
	}
	



}
