package entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author zhangtao
 * @Title: User
 * @Package: entity
 * @Description: user entity
 * @date 2020-12-17 23:40
 */
@Data
@Builder
public class User {
    private String name;
    private String sex;
    private int age;
}
