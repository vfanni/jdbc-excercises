package com.epam.training.jp.jdbc.excercises.dao.jdbcimpl;

import javax.sql.DataSource;

import com.epam.training.jp.jdbc.excercises.dao.AddressDao;
import com.epam.training.jp.jdbc.excercises.domain.Address;

public class JdbcAddressDao extends GenericJdbcDao implements AddressDao {

	public JdbcAddressDao(DataSource dataSource) {
		super(dataSource);
	}

	@Override
	public void save(Address address) {
		//TODO: implement
		throw new UnsupportedOperationException();
	}

}
