package com.epam.training.jp.jdbc.excercises.dao.jdbctemplateimpl;

import static org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils.createBatch;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.epam.training.jp.jdbc.excercises.dao.FoodDao;
import com.epam.training.jp.jdbc.excercises.domain.Food;

public class JdbcTemplateFoodDao extends JdbcDaoSupport implements FoodDao {

	public JdbcTemplateFoodDao(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public Food findFoodByName(String name) {
		String sql = "SELECT ID, CALORIES, ISVEGAN, NAME, PRICE from FOOD WHERE NAME = ?";
		Food food = getJdbcTemplate().queryForObject(sql,
				new Object[] { name }, new RowMapper<Food>() {
					@Override
					public Food mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Food food = new Food();
						food.setId(rs.getInt(1));
						food.setCalories(rs.getInt(2));
						food.setVegan(rs.getBoolean(3));
						food.setName(rs.getString(4));
						food.setPrice(rs.getInt(5));
						return food;
					}
				});
		return food;
	}

	@Override
	public void updateFoodPriceByName(String name, int newPrice) {
		String sql = "UPDATE food SET PRICE = ? WHERE NAME = ?";

		this.getJdbcTemplate().update(sql, newPrice, name);
	}

	@Override
	public void save(List<Food> foods) {

		SqlParameterSource[] batch = createBatch(foods.toArray());
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(
				getDataSource());
		String sql = "INSERT INTO food VALUES(null, :Calories, :Vegan, :Name , :Price)";
		template.batchUpdate(sql, batch);

		
		SimpleJdbcInsert insert = new SimpleJdbcInsert(getDataSource())
				.withTableName("food");
		insert.executeBatch(batch);
	}

}
