package com.cssl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users implements Serializable {
    private Integer userid;
    private String username;
    private String password;
    private Integer isAdmin;
}
