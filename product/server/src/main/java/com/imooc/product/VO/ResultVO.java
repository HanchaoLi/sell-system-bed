package com.imooc.product.VO;

import lombok.Data;

/**
 * 2017-12-09 22:09
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;
}
