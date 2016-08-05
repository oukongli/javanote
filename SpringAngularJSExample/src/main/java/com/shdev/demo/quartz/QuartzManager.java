package com.shdev.demo.quartz;

import com.shdev.demo.service.impl.DynamicJobImpl;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

/**
 * Created by ou_ko on 2016/8/6.
 */
public class QuartzManager {
    private Scheduler scheduler;

    private List<String> jobPackages;

    private QuartzManager() {
    }

    private static class QuartzManagerSingletonHolder {
        static QuartzManager instance = new QuartzManager();
    }

    public static QuartzManager getInstance() {
        return QuartzManagerSingletonHolder.instance;
    }

    public void newJob(Class<? extends Job> jobClazz, String jobName, String jobGroupName, String triggerName,
                       String triggerGroupName, String cronPattern, String description) throws Exception {

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        // Retrieve a scheduler from schedule factory
        Scheduler scheduler = schedulerFactory.getScheduler();

        // current time
        long ctime = System.currentTimeMillis();

        // Initiate JobDetail with job name, job group, and executable job class
        JobDetail jobDetail = new JobDetail("jobDetail2", Scheduler.DEFAULT_GROUP, DynamicJobImpl.class);
        // Initiate CronTrigger with its name and group name
        CronTrigger cronTrigger = new CronTrigger("cronTrigger", Scheduler.DEFAULT_GROUP);
        try {
            // setup CronExpression
            CronExpression cexp = new CronExpression("0/5 * * * * ?");
            // Assign the CronExpression to CronTrigger
            cronTrigger.setCronExpression(cexp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // schedule a job with JobDetail and Trigger
        scheduler.scheduleJob(jobDetail, cronTrigger);

        // start the scheduler
        scheduler.start();


    }

}
