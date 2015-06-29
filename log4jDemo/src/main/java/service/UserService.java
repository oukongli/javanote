package service;


import org.apache.log4j.Logger;

/**
 * Created by kouyang on 6/19/2015.
 */
public class UserService {
    public static final Logger logger = Logger.getLogger(UserService.class);

    public void add() {
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        logger.fatal("fatal");
    }
}
