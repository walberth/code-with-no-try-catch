package com.wgutierrez.logger.service;

import com.wgutierrez.logger.transversal.Response;
import java.util.List;

public interface IProfileService {
    Response<List<String>> getQueries(int limit);
}
