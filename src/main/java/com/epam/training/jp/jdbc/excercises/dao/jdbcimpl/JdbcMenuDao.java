package com.epam.training.jp.jdbc.excercises.dao.jdbcimpl;

import javax.sql.DataSource;

import com.epam.training.jp.jdbc.excercises.dao.MenuDao;

public class JdbcMenuDao extends GenericJdbcDao implements MenuDao {

	public JdbcMenuDao(DataSource dataSource) {
		super(dataSource);
	}

	@Override
	public void removeMenu(int id) {
		//TODO: implement
		throw new UnsupportedOperationException();
	}

	
	 
	
}
