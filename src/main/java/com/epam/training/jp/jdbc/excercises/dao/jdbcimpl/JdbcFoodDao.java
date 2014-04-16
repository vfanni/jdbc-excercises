package com.epam.training.jp.jdbc.excercises.dao.jdbcimpl;

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
		//TODO: implement
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void updateFoodPriceByName(String name, int newPrice) {
		//TODO: implement
		throw new UnsupportedOperationException();

	}


	@Override
	public void save(List<Food> foods) {
		//TODO: implement with batch
		throw new UnsupportedOperationException();
	}
	
	



	

}
