package com.unfbx.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 描述：
 *
 * @author grt
 * @date 2020-06-29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {

    private Integer code;
    private String msg;
    private T data;

    public CommonResult (Integer code,String msg){
        this.msg = msg;
        this.code = code;
    }
}
