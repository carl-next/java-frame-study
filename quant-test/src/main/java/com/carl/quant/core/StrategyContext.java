package com.carl.quant.core;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

/**
 * @author zhangtao
 * @Title: StrategyContext
 * @Package: com.carl.quant
 * @Description: 策略上下文环境
 * @date 1/11/21 9:36 PM
 */

@Component("StrategyContext")
@Scope(SCOPE_PROTOTYPE)
public class StrategyContext {
    private long runId;

}
