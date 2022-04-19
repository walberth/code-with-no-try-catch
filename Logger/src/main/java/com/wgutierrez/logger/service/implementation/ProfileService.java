package com.wgutierrez.logger.service.implementation;

import java.io.*;
import java.util.List;
import org.springframework.stereotype.Service;
import com.wgutierrez.logger.transversal.Helper;
import org.springframework.core.env.Environment;
import com.wgutierrez.logger.transversal.Message;
import com.wgutierrez.logger.transversal.Response;
import com.wgutierrez.logger.service.IProfileService;
import com.wgutierrez.logger.repositories.IProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service("ProfileService")
public class ProfileService implements IProfileService {
    private IProfileRepository profileRepository;
    private Environment environment;

    @Autowired
    public ProfileService(IProfileRepository profileRepository, Environment environment){
        this.profileRepository = profileRepository;
        this.environment = environment;
    }

    @Override
    public Response<List<String>> getQueries(int limit) {
        Response<List<String>> response = new Response<List<String>>();
        List<String> stringList;

        try {
            String completePath = getPathLog(environment.getProperty("logger.name"));
            stringList = Helper.readProfileLog(completePath);

            if(stringList.isEmpty()) {
                response.setMessage(Message.NoSeObtuvieronResultados);

                return response;
            }

            int size = stringList.size();

            response.setData(stringList.subList(size - limit, size));
        } catch (IOException e) {
            e.printStackTrace();
        }

        response.setIsWarning(false);

        return response;
    }

    private String getPathLog(String fileName) {
        return profileRepository.getPathProfileFile(fileName);
    }
}
