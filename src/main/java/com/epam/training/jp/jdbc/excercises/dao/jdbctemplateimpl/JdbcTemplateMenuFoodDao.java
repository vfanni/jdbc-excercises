package com.epam.training.jp.jdbc.excercises.dao.jdbctemplateimpl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.epam.training.jp.jdbc.excercises.dao.MenuFoodDao;

public class JdbcTemplateMenuFoodDao extends JdbcDaoSupport implements MenuFoodDao {

	public JdbcTemplateMenuFoodDao(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public void removeMenuFoods(int id) {
		String sql = "DELETE FROM menu_food WHERE menu_id = ?";
		if(this.getJdbcTemplate().update(sql, id)==0){
			System.out.println("No menu_food with menu_id="+id);
		}
	}
}
