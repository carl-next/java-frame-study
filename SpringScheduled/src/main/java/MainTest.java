import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhangtao
 * @Title: MainTest
 * @Package: PACKAGE_NAME
 * @Description:
 * @date 2/3/21 6:32 PM
 */

public class MainTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("scheduler.xml");
    }
}
