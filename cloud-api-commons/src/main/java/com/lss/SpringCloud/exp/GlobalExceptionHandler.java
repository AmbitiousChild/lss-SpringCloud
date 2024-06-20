package com.lss.SpringCloud.exp;


import com.lss.SpringCloud.resp.ResultData;
import com.lss.SpringCloud.resp.ReturnCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice  //底层拦截器相关知识
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)//捕捉
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  //回应状态符合规定
    public ResultData<String> exception(Exception e){

    System.out.println("#####come in GlobalExceptionHandler");
    log.error("全局异常信息：{}",e.getMessage(),e);

    return ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
    }
}
