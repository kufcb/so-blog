package com.commons.pojo.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yys
 * @date 2023/8/19 21:05
 * @desc
 */
@Table("user")
@Getter
@Setter
public class User {
    @Id(keyType = KeyType.Auto)
    private Long id;
    private String userName;
    private String password;
    private String email;
    private Integer userRole;
}
