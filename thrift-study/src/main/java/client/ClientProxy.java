package client;

import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import thrift.UserService;

import javax.annotation.PostConstruct;

/**
 * @author zhangtao
 * @Title: Client
 * @Package: client
 * @Description: Client
 * @date 2020-12-18 23:49
 */
@Component
@Slf4j
public class ClientProxy {
    @Value("${thrift.ip}")
    private String ip;
    @Value("${thrift.port}")
    private int port;
    @Value("${thrift.timeout}")
    private int timeout;

    private UserService.Client client;

    //@PostConstruct
    public void startClient(String userName) {
        TTransport transport = null;
        try {
            transport = new TSocket(ip, port, timeout);
            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(transport);
            client = new UserService.Client(protocol);
            transport.open();
            for (int i = 0; i < 25; i++) {
                log.info(client.sayHello("carl"));
                log.info(client.getName(1));
                log.info(client.isExist("carl")+"");
            }
        } catch (TTransportException e) {
            log.error("thrift客户端启动失败", e);
        } catch (TException e) {
            log.error("thrift客户端启动失败", e);
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
    }

    public UserService.Client getClient() {
        return client;
    }

}
