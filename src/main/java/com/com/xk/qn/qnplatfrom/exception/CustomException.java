package com.com.xk.qn.qnplatfrom.exception;

import com.com.xk.qn.qnplatfrom.result.ResultJson;
import lombok.Getter;

/**
 * @author Joetao
 * Created at 2018/8/24.
 */
@Getter
public class CustomException extends RuntimeException{
    private ResultJson resultJson;

    public CustomException(ResultJson resultJson) {
        this.resultJson = resultJson;
    }
}