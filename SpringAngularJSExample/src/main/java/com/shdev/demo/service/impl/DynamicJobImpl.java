package com.shdev.demo.service.impl;

import com.shdev.demo.service.DynamicJob;
import org.apache.log4j.Logger;

import java.util.Date;

/**
 * Created by ou_ko on 2016/8/6.
 */
public class DynamicJobImpl implements DynamicJob {

    private Logger logger = Logger.getLogger(DynamicJobImpl.class);

    public void execute() {
        logger.info(new Date());
    }
}
