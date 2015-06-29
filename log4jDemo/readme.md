1. 导入包
2. 创建Logger对象
        public static final Logger logger = Logger.getLogger(UserDao.class);
3. 编写相应的日志
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        logger.fatal("fatal");
4. 编写日志配置文件，说明logger显示方式和级别
        创建appender: log4j.appender.stout=org.apache.log4j.ConsoleAppender
        布局: log4j.appender.stout.layout=org.apache.log4j.PatternLayout
        格式: log4j.appender.stout.layout.ConversionPattern=[%p](%1)-->%m(%d)
        日志级别: log4j.rootLogger=DEBUG, stout  级别：DEBUG, appender 为 stout, rootLogger是根目录的Logger，每一个项目的classpath就是根目录，只要运行到输出日志的位置，并且日志的级别大于DEBUG时就会调用stout输出
