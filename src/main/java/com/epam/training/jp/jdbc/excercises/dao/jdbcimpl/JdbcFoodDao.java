package com.epam.training.jp.jdbc.excercises.dao.jdbcimpl;

import javax.sql.DataSource;

import com.epam.training.jp.jdbc.excercises.dao.FoodDao;
import com.epam.training.jp.jdbc.excercises.domain.Food;

public class JdbcFoodDao extends GenericJdbcDao implements FoodDao {

	public JdbcFoodDao(DataSource dataSource) {
		super(dataSource);
	}
	
	
	@Override
	public Food findFoodByName(String name) {
		//TODO: implement
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void updateFoodPriceByName(String name, int newPrice) {
		//TODO: implement
		throw new UnsupportedOperationException();

	}



	

}
