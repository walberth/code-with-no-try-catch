package com.project.loggingdoitright.repository.mapper;

import com.project.loggingdoitright.model.Person;
import com.project.loggingdoitright.transversal.TimeHelper;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person = new Person();
        person.setId(rs.getInt("id"));
        person.setFirstName(rs.getString("firstName"));
        person.setFatherLastName(rs.getString("fatherLastName"));
        person.setMotherLastName(rs.getString("motherLastName"));
        person.setSex(rs.getBoolean("sex"));
        person.setBirthDate(rs.getDate("birthDate").toLocalDate());
        person.setDocument(rs.getString("document"));
        person.setEmail(rs.getString("email"));
        person.setTelephone(rs.getString("telephone"));
        person.setMobile(rs.getString("mobile"));
        person.setUserRegister(rs.getString("userRegister"));
        person.setTimeStamp(rs.getTimestamp("timeStamp"));

        return person;
    }
}
