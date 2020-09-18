package com.lyz.blog.common.utils;


import com.lyz.blog.common.emun.ResponseCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author intellif
 */

@AllArgsConstructor
@ToString
@Getter
public class ResponseModel<T> {

    private final Integer code;

    private final String message;

    private final T data;

    private final String meaning;

    public static ResponseModel create(ResponseCodeEnum code) {
        return create(code, null);
    }

    public static <T> ResponseModel<T> create(ResponseCodeEnum code, T data) {
//        return new ResponseModel(code.getMapping(), code.getMessage(), data,code.getMeaning());
        return new ResponseModel(code.getMapping(), code.getMessage(), data,code.getMeaning());
    }
}
