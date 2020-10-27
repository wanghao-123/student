package com.cssl.pojo;

import lombok.*;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Subject implements Serializable {
    @NonNull
    private Integer sid;
    private String s_title;
    private Integer s_type;
}
