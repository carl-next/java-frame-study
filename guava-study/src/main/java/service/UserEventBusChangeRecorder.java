package service;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangtao
 * @Title: UserEventBusChangeRecorder
 * @Package: service
 * @Description: user 事件监听者[Listeners]
 * @date 2020-12-17 23:59
 */
@Service
@Slf4j
public class UserEventBusChangeRecorder {
    @Autowired
    EventBus eventBus;

    @Subscribe
    public void consume(User user) {
        log.info("=====user info consume====" + user.toString());
    }
}
