package com.wgutierrez.logger.repositories.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcOperations;
import com.wgutierrez.logger.repositories.IProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.wgutierrez.logger.repositories.implementation.mapper.ProfileRowMapper;

@Repository("ProfileRepository")
public class ProfileRepository implements IProfileRepository {
    private JdbcOperations jdbcTemplate;

    @Autowired
    public ProfileRepository(JdbcOperations jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String getPathProfileFile(String fileName) {
        return jdbcTemplate.query(String.format("CALL getPathProfileFile('%s');", fileName), new ProfileRowMapper()).get(0);
    }
}
