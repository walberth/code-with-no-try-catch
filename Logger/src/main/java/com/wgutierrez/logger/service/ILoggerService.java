package com.wgutierrez.logger.service;

import java.util.List;
import com.wgutierrez.logger.model.Logger;
import com.wgutierrez.logger.model.SearchLog;
import com.wgutierrez.logger.transversal.Response;

public interface ILoggerService {
	Response<List<Logger>> getLogs(SearchLog search);
}
