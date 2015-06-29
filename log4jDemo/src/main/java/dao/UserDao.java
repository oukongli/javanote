package dao;


import org.apache.log4j.Logger;

/**
 * Created by kouyang on 6/19/2015.
 */
public class UserDao {
    public static final Logger logger = Logger.getLogger(UserDao.class);

    public void add() {
        /**
         * debug < info < warn < error < fatal
         */
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        logger.fatal("fatal");
    }
}
