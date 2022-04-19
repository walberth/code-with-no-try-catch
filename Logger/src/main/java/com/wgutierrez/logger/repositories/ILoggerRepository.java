package com.wgutierrez.logger.repositories;

import java.util.List;

import com.wgutierrez.logger.model.Logger;
import com.wgutierrez.logger.model.MasterData;

public interface ILoggerRepository {
	List<MasterData> getHostnameList();
	List<MasterData> getApplicationList();
	List<Logger> getLogs(String where, String limit);
}
