import client.ClientProxy;
import org.apache.thrift.TException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import server.ServerStater;

/**
 * @author zhangtao
 * @Title: AppStarter
 * @Package: PACKAGE_NAME
 * @Description:
 * @date 2020-12-18 23:15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:thrift.xml"})
public class ClientStarter {
    @Autowired
    ClientProxy clientProxy;
    @Test
    public void startClientTest1(){
        clientProxy.startClient("--carl--");
//        try {
//            clientProxy.getClient().sayHello("carl");
//        } catch (TException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void startClientTest2(){
        try {
            clientProxy.getClient().getName(1);
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void startClientTest3() throws TException {
        clientProxy.getClient().isExist("carl");
    }

}
