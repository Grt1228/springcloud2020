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
public class Payment implements Serializable {


    private Long id;
    private String serial;
}
