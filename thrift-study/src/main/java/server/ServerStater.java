package server;

import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import thrift.UserService;

import javax.annotation.PostConstruct;

/**
 * @author zhangtao
 * @Title: ServerStater
 * @Package: server
 * @Description: 服务器启动类 : ServerStater
 * @date 2020-12-18 22:35
 */
@Slf4j
@Controller
public class ServerStater {
    @Autowired
    UserServiceImpl userService;

    @Value("${thrift.port}")
    private int port;

//    @PostConstruct
    public void startServer(){
        log.info("服务启动中------");
        UserService.Processor processor=new UserService.Processor<UserService.Iface>(userService);
        try{
            TServerTransport transport = new TServerSocket(port);
            TThreadPoolServer.Args tArgs = new TThreadPoolServer.Args(transport);
            tArgs.processor(processor);
            tArgs.protocolFactory(new TBinaryProtocol.Factory());
            tArgs.transportFactory(new TTransportFactory());
            tArgs.minWorkerThreads(10);
            tArgs.maxWorkerThreads(20);
            TServer server = new TThreadPoolServer(tArgs);
            server.serve();
        }catch (Exception e){
            log.error("thrift服务启动失败", e);
        }
    }
}
