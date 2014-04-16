package com.epam.training.jp.jdbc.excercises.dao.jdbctemplateimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.epam.training.jp.jdbc.excercises.dao.FoodDao;
import com.epam.training.jp.jdbc.excercises.domain.Food;

public class JdbcTemplateFoodDao extends JdbcDaoSupport implements FoodDao {

	public JdbcTemplateFoodDao(DataSource dataSource) {
		setDataSource(dataSource);
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
