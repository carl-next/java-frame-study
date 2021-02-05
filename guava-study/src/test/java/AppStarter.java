import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.EventProducers;

/**
 * @author zhangtao
 * @Title: AppStarter
 * @Package: PACKAGE_NAME
 * @Description: AppStarter
 * @date 2020-12-18 00:32
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:eventbus.xml"})
public class AppStarter {
    @Autowired
    EventProducers eventProducers;
    @Test
    public void start(){
        eventProducers.init();
        eventProducers.post();
    }
}
