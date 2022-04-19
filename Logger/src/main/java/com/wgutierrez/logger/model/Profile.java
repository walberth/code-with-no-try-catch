package com.wgutierrez.logger.model;

import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
public class Profile {
    private String Datname;
    private String Username;
    private String ApplicationName;
    private String ClientAddres;
    private Timestamp BackendStart;
    private Timestamp QueryStart;
    private String State;
    private String Query;
    private String BackendType;
}
