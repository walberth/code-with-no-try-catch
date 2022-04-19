package com.wgutierrez.logger.transversal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {
    protected static final Logger logger = LogManager.getLogger(BaseClass.class);
    protected static String Username = Constant.Empty;
    protected static String Payload = Constant.Empty;
    protected static String CallSite = Constant.Empty;
    protected static String Action = Constant.Empty;
    protected static String MethodName = Constant.Empty;

    protected void setLogVariables(String username, String payload, String callSite, String action) {
        Username = username;
        Payload = payload;
        CallSite = callSite;
        Action = action;
    }

    protected void setLogVariables(String username, String callSite, String action) {
        Username = username;
        CallSite = callSite;
        Action = action;
    }
}
