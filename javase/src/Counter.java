import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangtao
 * @Title: Counter
 * @Package: PACKAGE_NAME
 * @Description:
 * @date 2/2/21 9:41 PM
 */

public class Counter {
    private volatile int i=0;
    Lock lock=new ReentrantLock();

    private static Unsafe unsafe=null;
    //i的地址
    private static long valuOffset;

//    public void increament(){
//        lock.lock();
//        i++;
//        lock.unlock();
//    }

    static {
        try{
            Field field=Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe=(Unsafe) field.get(null);

            Field field1=Counter.class.getDeclaredField("i");
            valuOffset=unsafe.objectFieldOffset(field1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void increament2(){
        for(;;){
            int current=unsafe.getIntVolatile(this,valuOffset);
            if(unsafe.compareAndSwapInt(this,valuOffset,current,current+1)){
                break;
            }
        }
    }

    public int getI() {
        return i;
    }
}
