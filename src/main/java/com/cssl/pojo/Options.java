package com.cssl.pojo;

import lombok.*;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Options implements Serializable {
    private Integer o_id;
    @NonNull
    private String o_content;
    @NonNull
    private Subject subject;
}
