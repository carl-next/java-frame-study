/**
 * @author zhangtao
 * @Title: ThreadAcid
 * @Package: PACKAGE_NAME
 * @Description:
 * @date 2/2/21 9:40 PM
 */

public class ThreadAcid {

    public static void main(String[] args) throws InterruptedException {
        final Counter counter = new Counter();
        for (int i = 0; i < 6; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        counter.increament2();
                    }
                    System.out.println("done.....");
                }
            }).start();
        }

        Thread.sleep(6000L);
        System.out.println(counter.getI());
    }
}
