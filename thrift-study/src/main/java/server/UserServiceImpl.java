package server;

import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import thrift.UserService;

/**
 * @author zhangtao
 * @Title: UserServiceImpl
 * @Package: server
 * @Description: 实现接口UserService.IFACE : thrift-server
 * @date 2020-12-18 22:28
 */
@Slf4j
@Component
public class UserServiceImpl implements UserService.Iface {

    private final static String CARL = "carl";

    @Override
    public String getName(int id) throws TException {
        log.info("received getName, id = {}:", id);
        return CARL;
    }

    @Override
    public boolean isExist(String name) throws TException {
        return CARL.equals(name);
    }

    @Override
    public String sayHello(String name) throws TException {
        return "Hi," + name + " welcome to thrift demo world";
    }
}
