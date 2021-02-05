import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangtao
 * @Title: Singler
 * @Package: PACKAGE_NAME
 * @Description:
 * @date 2/3/21 6:27 PM
 */

public class Singler {

    private static String X="--";
    @Scheduled(cron = "*/5 * * * * ?")//每隔5秒执行一次
    public void singing(){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(sdf.format(date)+X+Thread.currentThread()+"--5");
    }


    @Scheduled(cron = "*/4 * * * * ?")//每隔5秒执行一次
    public void singing4(){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(sdf.format(date)+X+Thread.currentThread()+"--4");
    }


    @Scheduled(cron = "*/3 * * * * ?")//每隔5秒执行一次
    public void singing3(){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(sdf.format(date)+X+Thread.currentThread()+"--3");
    }


    @Scheduled(cron = "*/2 * * * * ?")//每隔5秒执行一次
    public void singing2(){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(sdf.format(date)+X+Thread.currentThread()+"--2");
    }
}
