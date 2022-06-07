package com.joe.quartz;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.ParseException;
import java.util.Random;

@Controller
@RequestMapping("/")
public class ScheduleInfoAction {
    /*@Autowired
    private Scheduler scheduler;
    @Autowired
    private SimpleTriggerFactoryBean oldTrigger;

    @RequestMapping(value="/rereshSheduleTrigger",method= RequestMethod.GET)
    public void retScheduleJob() throws SchedulerException, ParseException {
        TriggerBuilder tb = oldTrigger.getObject().getTriggerBuilder();
        int number = new Random().nextInt(10) + 1;
        System.out.println("动态改变执行时间为" + number + "秒");
        Trigger newTrigger = tb.withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(number)).build();
        //Trigger trigger = tb.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();
        scheduler.rescheduleJob(oldTrigger.getObject().getKey(), newTrigger);
    }*/
}
