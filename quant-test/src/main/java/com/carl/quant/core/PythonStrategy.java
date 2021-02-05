package com.carl.quant.core;

import com.carl.quant.jyth.Jyth;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangtao
 * @Title: PythonStrategy
 * @Package: com.carl.quant.core
 * @Description: PythonStrategy
 * @date 1/11/21 9:50 PM
 */

@Slf4j
public class PythonStrategy implements Strategy {


    private Jyth jyth;

    private String pythonScript;


    public PythonStrategy(String pythonScript){
        this.pythonScript=pythonScript;
    }

    @Override
    public void init(StrategyContext strategyContext) {
        try{
            // todo
            // jyth.
        }catch (Exception e){

        }
    }

    @Override
    public void onData(StrategyContext strategyContext, Object[] data) {

    }

    @Override
    public void release(StrategyContext strategyContext) {

    }
}
