package service;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import entity.Cat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangtao
 * @Title: CatEventBusChangeRecorder
 * @Package: service
 * @Description: Cat 事件监听者[Listeners]
 * @date 2020-12-17 23:58
 */
@Service
@Slf4j
public class CatEventBusChangeRecorder {
    @Autowired
    EventBus eventBus;

    @Subscribe
    public void consume(Cat cat) {
        log.info("====cat info consume====" + cat.toString());
    }
}
