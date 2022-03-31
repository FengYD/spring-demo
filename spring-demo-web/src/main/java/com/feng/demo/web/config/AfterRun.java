package com.feng.demo.web.config;

import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;

/**
 * @author fengyadong
 * @Date: 2022/3/31 22:49
 */
@Slf4j
@Component
public class AfterRun implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    @Qualifier(value = "syncDataTaskExecutor")
    private Executor executor;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        try {
            executor.execute(() ->
                            System.out.println(
                                    ",------.  ,--. ,--. ,--.  ,--. ,--.  ,--. ,--. ,--.  ,--.  ,----.    \n" +
                                            "|  .--. ' |  | |  | |  ,'.|  | |  ,'.|  | |  | |  ,'.|  | '  .-./    \n" +
                                            "|  '--'.' |  | |  | |  |' '  | |  |' '  | |  | |  |' '  | |  | .---. \n" +
                                            "|  |\\  \\  '  '-'  ' |  | `   | |  | `   | |  | |  | `   | '  '--'  | \n" +
                                            "`--' '--'  `-----'  `--'  `--' `--'  `--' `--' `--'  `--'  `------'  "
                            )
                    );
        } catch (Exception e) {
            log.error("项目启动时发生错误,", e);
        }
    }
}