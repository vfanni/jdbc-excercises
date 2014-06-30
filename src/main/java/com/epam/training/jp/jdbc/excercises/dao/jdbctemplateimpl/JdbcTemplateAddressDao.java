package com.epam.training.jp.jdbc.excercises.dao.jdbctemplateimpl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.epam.training.jp.jdbc.excercises.dao.AddressDao;
import com.epam.training.jp.jdbc.excercises.domain.Address;

public class JdbcTemplateAddressDao extends JdbcDaoSupport implements
		AddressDao {

	public JdbcTemplateAddressDao(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public void save(Address address) {
		/*
		 * NamedParameterJdbcTemplate namedParameterJdbcTemplate = new
		 * NamedParameterJdbcTemplate( getDataSource()); KeyHolder keyHolder = new GeneratedKeyHolder();
		 * 
		 * String sql ="INSERT INTO ADDRESS (CITY, COUNTRY, STREET, ZIPCODE) VALUES (:city, :country, :street, :zipCode)"; 
		 * namedParameterJdbcTemplate.update(sql, namedParameters, keyHolder);
		 * 
		 * address.setId(keyHolder.getKey().intValue());
		 */

		SimpleJdbcInsert insert = new SimpleJdbcInsert(getDataSource())
				.withTableName(address.getClass().getSimpleName().toLowerCase())
				.usingGeneratedKeyColumns("id");

		address.setId(insert
				.execute(new BeanPropertySqlParameterSource(address)));
	}

}
