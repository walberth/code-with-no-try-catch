package com.wgutierrez.logger.repositories.implementation;

import java.util.List;

import com.wgutierrez.logger.model.MasterData;
import com.wgutierrez.logger.repositories.implementation.mapper.MasterDataRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import com.wgutierrez.logger.model.Logger;
import com.wgutierrez.logger.repositories.ILoggerRepository;
import com.wgutierrez.logger.repositories.implementation.mapper.LogRowMapper;

@Repository("LoggerRepository")
public class LoggerRepository implements ILoggerRepository {
	@Autowired
	private JdbcOperations jdbcTemplate;

	@Autowired
	public LoggerRepository(JdbcOperations jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<MasterData> getHostnameList() {
		List<MasterData> hostnames = jdbcTemplate.query("select * from logs.getMachineName()", new MasterDataRowMapper());
		return hostnames;
	}

	@Override
	public List<MasterData> getApplicationList() {
		List<MasterData> applications = jdbcTemplate.query("select * from logs.getApplicationName()", new MasterDataRowMapper());
		return applications;
	}

	@Override
	public List<Logger> getLogs(String where, String limit) {
		return jdbcTemplate.query(String.format("select * from logs.application_logs %s order by id desc %s", where, limit), new LogRowMapper());
	}
}
