package com.cssl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Votes implements Serializable {
    private Integer v_id;
    private Options options;
    private Subject subject;
    private Users users;
}
