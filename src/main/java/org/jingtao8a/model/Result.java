package org.jingtao8a.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    Integer code;
    String message;
    Object extentPack;

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
