import org.junit.Before;
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
public class ServerStarter {
    @Autowired
    ServerStater serverStater;
    @Test
    public void startServer(){
        serverStater.startServer();
    }

}
