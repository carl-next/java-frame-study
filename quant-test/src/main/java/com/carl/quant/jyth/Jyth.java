package com.carl.quant.jyth;


/**
 * @author zhangtao
 * @Title: Jyth
 * @Package: com.carl.quant.jyth
 * @Description: Java调c++
 * @date 1/11/21 10:11 PM
 * todo
 */

public class Jyth implements AutoCloseable {

    private boolean closed;
    private long tstate;
    private Thread thread;
    private ClassLoader classLoader;
    private StringBuilder evalLines;
    private boolean interactive;
    private final MemoryManager memoryManager;

    private static final String LINE_SEP="\n";
    private static final ThreadLocal<Boolean> threadUsed=new ThreadLocal<Boolean>(){
        @Override
        protected Boolean initialValue() {
            return false;
        }
    };



    public Jyth(JythConfig jythConfig,boolean useSubInterpreter){
        this.closed=false;
        this.memoryManager=new MemoryManager();
        this.tstate=0L;
        this.thread=null;
        this.evalLines=null;
        this.interactive=false;
        this.classLoader=null;




    }

    /**
     * 执行初始化方法
     * @param classLoader
     * @param var2
     * @param var3
     * @return tstate
     */
    private native long init(ClassLoader classLoader,boolean var2,boolean var3);

    /**
     * 方法调用
     * @param tstate
     * @param methodName
     * @param params
     * @return
     */
    private native Object invoke(long tstate,String methodName,Object[] params);
    /**
     * 整体代码初始化
     * @param script
     */
    private native void eval(long tstate,String script);


    @Override
    public void close() throws Exception {

    }

}
