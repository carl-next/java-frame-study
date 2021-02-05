package entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author zhangtao
 * @Title: Cat
 * @Package: entity
 * @Description: cat entuty
 * @date 2020-12-17 23:56
 */
@Data
@Builder
public class Cat {
    private String name;
    private String color;
    private String type;
}
