package com.wgutierrez.logger.transversal;

import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;

public class Helper {
    static public List<String> readProfileLog(String fileName) throws IOException {
        ArrayList<String> stringList = new ArrayList<String>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line = "";

            while ((line = br.readLine()) != null) {
                stringList.add(line);
            }
        } catch(IOException e) {
            throw e;
        }

        return stringList;
    }
}
