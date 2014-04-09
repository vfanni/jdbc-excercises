package com.epam.training.jp.jdbc.excercises.dao.jdbctemplateimpl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.epam.training.jp.jdbc.excercises.dao.AddressDao;
import com.epam.training.jp.jdbc.excercises.domain.Address;

public class JdbcTemplateAddressDao extends JdbcDaoSupport implements AddressDao {

	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public JdbcTemplateAddressDao(DataSource dataSource) {		
		setDataSource(dataSource);
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public void save(Address address) {
		String sql = "INSERT INTO ADDRESS " + " (CITY, COUNTRY, STREET, ZIPCODE) VALUES (:city, :country, :street, :zipCode)";
		
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(address);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		namedParameterJdbcTemplate.update(sql, namedParameters, keyHolder);
		
		address.setId(keyHolder.getKey().intValue());
	}

}
