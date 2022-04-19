package com.wgutierrez.logger.repositories.implementation.mapper;

import com.wgutierrez.logger.model.MasterData;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MasterDataRowMapper implements RowMapper<MasterData> {
    @Override
    public MasterData mapRow(ResultSet rs, int rowNum) throws SQLException {
        MasterData masterData = new MasterData();
        masterData.setName(rs.getString("name"));

        return masterData;
    }
}
