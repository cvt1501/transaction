package com.testbe.transaction.core.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DefaultResponse<T> {

    private T data;

    private String message;

    private Integer code;

}
