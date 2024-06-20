package com.lss.SpringCloud.resp;


import lombok.Data;
import lombok.experimental.Accessors;

//统一定义返回对象ResultData,通过ResultData.success()对返回结果进行包装后返回给前端
@Data
@Accessors(chain = true) //链式编程
public class ResultData<T> {


    private String code; //结果状态
    private String message;
    private T data;//查询成功，将值塞进T里给前台显示
    private long timestamp;//时间戳，显示查询时间


    //构造方法
    public ResultData() {
        this.timestamp = System.currentTimeMillis();
    }

    //如何返回成功
    public static <T> ResultData<T> success(T data){ //泛型基本功，如果成功返回 <T> ResultData <T>

        ResultData<T> ResultData = new ResultData<>();
        ResultData.setCode(ReturnCodeEnum.RC200.getCode());
        ResultData.setMessage(ReturnCodeEnum.RC200.getMessage());
        ResultData.setData(data);
        return ResultData;
    }

    public static <T> ResultData<T> fail(String code, String message) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(code);
        resultData.setMessage(message);

        return resultData;
    }

}

