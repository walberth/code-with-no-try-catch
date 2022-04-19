package com.wgutierrez.logger.service.implementation;

import java.sql.Date;
import java.util.List;
import com.wgutierrez.logger.model.MasterData;
import com.wgutierrez.logger.model.SearchLog;
import com.wgutierrez.logger.transversal.Message;
import com.wgutierrez.logger.transversal.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wgutierrez.logger.model.Logger;
import com.wgutierrez.logger.repositories.ILoggerRepository;
import com.wgutierrez.logger.service.ILoggerService;
import org.springframework.util.StringUtils;

@Service("LoggerService")
public class LoggerService implements ILoggerService {
	private ILoggerRepository loggerRepository;

	@Autowired
	public LoggerService(ILoggerRepository loggerRepository){
		this.loggerRepository = loggerRepository;
	}

	public List<MasterData> getHostnameList() {
		return loggerRepository.getHostnameList();
	}

	public List<MasterData> getApplicationList() {
		return loggerRepository.getApplicationList();
	}

	public List<Logger> getLogInformation() {
		return null;
	}

	@Override
	public Response<List<Logger>> getLogs(SearchLog search) {
		Response<List<Logger>> response = new Response<List<Logger>>();

		String where = getWhereCondition(search);

		if(StringUtils.isEmpty(search.getNumberRows())) {
			search.setNumberRows("10");
		}

		String limit =  String.format("limit %s", search.getNumberRows());

		List<Logger> logs = loggerRepository.getLogs(where, limit);

		if(logs.isEmpty()) {
			response.setMessage(Message.NoSeObtuvieronResultados);

			return response;
		}

		response.setData(logs);
		response.setIsWarning(false);

		return response;
	}

	private String getWhereCondition(SearchLog search) {
		if(!StringUtils.isEmpty(search.getIdLog())) {
			return String.format("where log_id = '%s' ", search.getIdLog());
		}

		String where = "";

		if(!StringUtils.isEmpty(search.getDateRange())) {
			List<Date> rangeDates = search.splitDates(search.getDateRange());

			where = String.format("where logged > '%s' and logged <= '%s'", rangeDates.get(0), rangeDates.get(1));
		}

		if (!search.getHostname().contains("ALL") && !StringUtils.isEmpty(search.getHostname())) {
			List<String> hostnameList = search.splitString(search.getHostname());

			String hostnames = searchBuilder(hostnameList);

			String toAdd = String.format(" and machine_name in (%s)", hostnames);
			where += toAdd;
		}

		if (!search.getApplication().contains("ALL") && !StringUtils.isEmpty(search.getApplication())) {
			List<String> applicationList = search.splitString(search.getApplication());

			String applications = searchBuilder(applicationList);

			String toAdd = String.format(" and application_name in (%s)", applications);
			where += toAdd;

		}

		if(!StringUtils.isEmpty(search.getLike())) {
			if (where.contains("where ")) {
				where += String.format(" and search_field  @@ to_tsquery('%s')", search.getLike());
			} else {
				where += String.format("where search_field  @@ to_tsquery('%s')", search.getLike());
			}
		}

		if(!StringUtils.isEmpty(search.getNotLike())) {
			if (where.contains("where ")) {
				where += String.format(" and search_field  @@ to_tsquery(!'%s')", search.getNotLike());
			} else {
				where += String.format("where search_field  @@ to_tsquery(!'%s')", search.getNotLike());
			}
		}

		return where;
	}

	private String searchBuilder(List<String> items) {
		String stringBuilder = "";

		int i = items.size();
		int j = 0;

		for(String item : items) {
			j++;

			stringBuilder += String.format("'%s'", item);

			if(i != j) {
				stringBuilder += ", ";
			}
		}

		return stringBuilder;
	}
}
