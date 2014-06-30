package com.epam.training.jp.jdbc.excercises.dao.jdbctemplateimpl;

import static org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils.createBatch;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.epam.training.jp.jdbc.excercises.dao.FoodDao;
import com.epam.training.jp.jdbc.excercises.domain.Food;

public class JdbcTemplateFoodDao extends JdbcDaoSupport implements FoodDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public JdbcTemplateFoodDao(DataSource dataSource) {
		setDataSource(dataSource);
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getJdbcTemplate());
	}

	@Override
	public Food findFoodByName(String name) {
		Food food = getJdbcTemplate().queryForObject("SELECT ID, CALORIES, ISVEGAN, NAME, PRICE from FOOD WHERE NAME = ?", new Object[] { name }, new FoodMapper());
		return food;
	}

	@Override
	public void updateFoodPriceByName(String name, int newPrice) {
		String sql = "UPDATE food SET PRICE = ? WHERE NAME = ?";

		if (getJdbcTemplate().update(sql, newPrice, name) != 1) {
			throw new RuntimeException("Zero or more than one row updated.");
		}
	}
	
	@Override
	public void save(List<Food> foods) {
		SqlParameterSource[] batch = createBatch(foods.toArray());
		String sql = "insert INTO food VALUES(null, :Calories, :Vegan, :Name , :Price)";
		namedParameterJdbcTemplate.batchUpdate(sql, batch);
	}

}
