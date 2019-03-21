package com.hhsoft.cloud.commons.utils.response;

import com.hhsoft.cloud.commons.constants.BaseResponseConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: BaseResponse
 * @Description 通用BaseResponse返回响应类
 * @Author Jason Biao
 * @Date 2019/3/21 11:06
 * @Version 1.0
 **/
public class BaseResponse {

    /**
     * @MethodDesc 返回成功
     * @param
     * @return
     */
    public Map<String,Object> setResultSuccessData(Object data){
        return setResult(BaseResponseConstants.HTTP_RES_CODE_200,BaseResponseConstants.HTTP_RES_CODE_MSG,data);
    }

    /**
     * @MethodDesc 返回成功
     * @param
     * @return
     */
    public Map<String,Object> setResultSuccess(String msg){
        return setResult(BaseResponseConstants.HTTP_RES_CODE_200,msg,null);
    }

    /**
     * @MethodDesc 返回成功
     * @param
     * @return
     */
    public Map<String,Object> setResultSuccess(){
        return setResult(BaseResponseConstants.HTTP_RES_CODE_200,BaseResponseConstants.HTTP_RES_CODE_200_VALUE,null);
    }

    /**
     * @MethodDesc 返回错误
     * @param msg
     * @return
     */
    public Map<String,Object> setResultError(String msg){
        return setResult(BaseResponseConstants.HTTP_RES_CODE_500,msg,null);
    }

    /**
     * @MethodDesc 自定义返回响应
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public Map<String,Object> setResult(Integer code, String msg, Object data){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put(BaseResponseConstants.HTTP_RES_CODE_NAME,code);
        map.put(BaseResponseConstants.HTTP_RES_CODE_MSG,msg);

        if (data != null){
            map.put(BaseResponseConstants.HTTP_RES_CODE_DATA,data);
        }
        return map;
    }

    public Map<String,Object> setResultParameterError(String msg){
        return setResult(BaseResponseConstants.HTTP_RES_CODE_400,msg,null);
    }
}
