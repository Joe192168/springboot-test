package com.joe.quartz;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/")
public class ScheduleInfoAction {

    @Autowired
    private Scheduler scheduler;

    @RequestMapping(value="/rereshSheduleTrigger",method= RequestMethod.GET)
    public void retScheduleJob() throws SchedulerException {
        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
        TriggerBuilder tb = factoryBean.getObject().getTriggerBuilder();
        int number = new Random().nextInt(10) + 1;
        System.out.println("动态改变执行时间为" + number + "秒");
        Trigger newTrigger = tb.withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(number)).build();
        //Trigger trigger = tb.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();
        scheduler.rescheduleJob(factoryBean.getObject().getKey(), newTrigger);
    }
}
