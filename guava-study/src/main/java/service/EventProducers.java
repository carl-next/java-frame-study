package service;

import com.google.common.eventbus.EventBus;
import entity.Cat;
import entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author zhangtao
 * @Title: EventProducers
 * @Package: service
 * @Description: EventProducers - 事件生产者[Producers]
 * @date 2020-12-18 00:00
 */
@Slf4j
@Service
public class EventProducers {

    @Autowired
    EventBus eventBus;
    @Autowired
    CatEventBusChangeRecorder catEventBusChangeRecorder;
    @Autowired
    UserEventBusChangeRecorder userEventBusChangeRecorder;

    public void init() {
        eventBus.register(catEventBusChangeRecorder);
        log.info("事件监听者[CatEventBusChangeRecorder]注册成功！！！");

        eventBus.register(userEventBusChangeRecorder);
        log.info("事件监听者[UserEventBusChangeRecorder]注册成功！！！");
    }

    public void post() {
        log.info("事件生产者[EventProducers]开始生产数据！！！！");
        for (int i = 0; i < 10; i++) {
            eventBus.post(Cat.builder().type("cat-" + i).color("cat-color" + i).name("cat-" + i).build());
            log.debug("cat-" + i + " event post----------");
            eventBus.post(User.builder().age(12 + i).name("name-" + i).sex((i%2==0?"女":"男")).build());
            log.debug("user-" + i + " event post----------");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        }
        log.info("事件生产者[EventProducers]结束生产数据！！！！");
    }

}
