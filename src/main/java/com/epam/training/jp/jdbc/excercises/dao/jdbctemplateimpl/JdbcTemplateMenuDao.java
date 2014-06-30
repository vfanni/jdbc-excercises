package com.epam.training.jp.jdbc.excercises.dao.jdbctemplateimpl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.epam.training.jp.jdbc.excercises.dao.MenuDao;

public class JdbcTemplateMenuDao extends JdbcDaoSupport implements MenuDao {

	public JdbcTemplateMenuDao(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public void removeMenu(int id) {
		String sql = "DELETE FROM menu WHERE id = ?";
		if(this.getJdbcTemplate().update(sql, id)==0){
			System.out.println("No menu with id=" + id);
		}
	}

	
	 
	
}
