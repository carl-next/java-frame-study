package com.carl.quant.core;

/**
 * @author zhangtao
 * @Title: Strategy
 * @Package: com.carl.quant
 * @Description: 策略接口
 * @date 1/11/21 9:44 PM
 */

public interface Strategy {
    /**
     * 策略初始化
     * @param strategyContext
     */
    void init(StrategyContext strategyContext);

    /**
     * 数据更新触发调用
     * @param strategyContext
     */
    void onData(StrategyContext strategyContext,Object[] data);

    /**
     * 策略结束清理
     * @param strategyContext
     */
    void release(StrategyContext strategyContext);
}
