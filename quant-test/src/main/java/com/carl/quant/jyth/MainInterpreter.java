package com.carl.quant.jyth;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author zhangtao
 * @Title: MainInterpreter
 * @Package: com.carl.quant.jyth
 * @Description: 主解释器
 * @date 1/11/21 10:39 PM
 * todo
 */

public final class MainInterpreter implements AutoCloseable{

    private static MainInterpreter instance=null;
    private static PyConfig pyConfig=null;

    private static String[] sharedMoudlesArgv=null;
    private Thread thread;
    private BlockingQueue<String> importQueue=new SynchronousQueue<>();
    private BlockingQueue<Object> importResults=new SynchronousQueue<>();

    private Throwable error;

    /**
     * 单例
     */
    private MainInterpreter(){}

    /**
     * python解释器初始化
     * @return
     * @throws Exception
     */
    protected static synchronized MainInterpreter getMainInterpreter() throws Exception {
        if(null==instance){
            try {
                instance=new MainInterpreter();
                instance.initialize();
            }catch (Exception e){
                instance.close();
            }
        }else if(null!=instance.error){
            throw new Exception("python解释器前一次初始化失败！",instance.error);
        }
        return instance;
    }

    /**
     * python解释器初始化实现  todo
     */
    private void initialize() {

    }


    @Override
    public void close() throws Exception {

    }
}
