package com.wgutierrez.logger.controllers;

import java.util.List;
import com.wgutierrez.logger.model.Logger;
import com.wgutierrez.logger.model.SearchLog;
import org.springframework.web.bind.annotation.*;
import com.wgutierrez.logger.transversal.Response;
import com.wgutierrez.logger.service.ILoggerService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/v1/logger")
public class LoggerController  {
	private ILoggerService loggerService;

	@Autowired
	public LoggerController(ILoggerService loggerService){
		this.loggerService = loggerService;
	}

	@GetMapping("/logs")
	public Response<List<Logger>> getLogs(SearchLog search) {
		return loggerService.getLogs(search);
	}
}
