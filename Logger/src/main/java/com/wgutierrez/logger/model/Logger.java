package com.wgutierrez.logger.model;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Logger {
	private int Id;
	private Date Timestamp;
	private String Product;
	private String Layer;
	private String Location;
	private String Message;
	private String Hostname;
	private String UserId;
	private String Username;
	private String CorrelationId;
	private String Exception;
	private String CustomException;
	private String AditionalInfo;
}
