package com.wgutierrez.logger.repositories.implementation.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.wgutierrez.logger.model.Logger;

public class LogRowMapper implements RowMapper<Logger>{
	@Override
	public Logger mapRow(ResultSet rs, int rowNum) throws SQLException {
		Logger log = new Logger();
		log.setId(rs.getInt("id"));
		log.setTimestamp(rs.getDate("logged"));
		log.setProduct(rs.getString("application_name"));
		log.setLayer(rs.getString("action"));
		log.setLocation(rs.getString("call_site"));
		log.setMessage(rs.getString("message"));
		log.setHostname(rs.getString("machine_name"));
		log.setUserId(rs.getString("level"));
		log.setUsername(rs.getString("username"));
		log.setCorrelationId(rs.getString("log_id"));
		log.setException(rs.getString("exception"));
		log.setCustomException(rs.getString("payload"));
		log.setAditionalInfo(rs.getString("method_name"));
		
		return log;
	}
}
