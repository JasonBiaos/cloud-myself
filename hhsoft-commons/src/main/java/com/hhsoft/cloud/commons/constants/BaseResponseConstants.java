package com.hhsoft.cloud.commons.constants;

/**
 * @ClassName: BaseResponseConstants
 * @Description 返回状态响应类
 * @Author Jason Biao
 * @Date 2019/3/21 10:56
 * @Version 1.0
 **/
public interface BaseResponseConstants {

    /**
     * 响应code
      */
    String HTTP_RES_CODE_NAME = "code";

    /**
     * 响应msg
      */
    String HTTP_RES_CODE_MSG = "msg";

    /**
     * 响应data
      */
    String HTTP_RES_CODE_DATA = "data";

    /**
     * 响应请求成功
      */
    String HTTP_RES_CODE_200_VALUE = "success";

    /**
     * 系统错误
      */
    String HTTP_RES_CODE_500_VALUE = "fail";

    /**
     * 响应请求成功code
      */
    Integer HTTP_RES_CODE_200 = 200;

    /**
     * 系统错误返回码
      */
    Integer HTTP_RES_CODE_500 = 500;

    /**
     *  参数错误返回码
     */
    Integer HTTP_RES_CODE_400 = 400;

}
