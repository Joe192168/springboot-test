package com.test;

import com.alijob.MyHelloJob;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScheduleInfoTest {

    @Autowired
    public MyHelloJob myHelloJob;

    @Test
    public void scheduleTest() throws Exception {
        myHelloJob.process(null);
    }

}
