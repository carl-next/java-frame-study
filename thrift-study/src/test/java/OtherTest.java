import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangtao
 * @Title: OtherTest
 * @Package: PACKAGE_NAME
 * @Description:
 * @date 1/12/21 9:04 PM
 */
//@RunWith(SpringJUnit4ClassRunner.class)

public class OtherTest {
    @Test
    public void testThread(){
        CountDownLatch countDownLatch=new CountDownLatch(10);
        List<String> list=new ArrayList<>();
        for(int i=0;i<10;i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString());
                System.out.println("list="+list);
            },String.valueOf(i)).start();
        }

        try {
            countDownLatch.await(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
