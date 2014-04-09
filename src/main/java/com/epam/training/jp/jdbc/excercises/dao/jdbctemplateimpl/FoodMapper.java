package com.epam.training.jp.jdbc.excercises.dao.jdbctemplateimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.epam.training.jp.jdbc.excercises.domain.Food;

public class FoodMapper implements RowMapper<Food>{

	@Override
	public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
		Food food = new Food();
		food.setId(rs.getInt(1));
		food.setCalories(rs.getInt(2));
		food.setVegan(rs.getBoolean(3));
		food.setName(rs.getString(4));
		food.setPrice(rs.getInt(5));
		return food;
	}
	
	

}
