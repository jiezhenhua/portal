package com.zhjie.common.util;

/**
 * 
 * <p>Title: ResultUtil</p>  
 * <p>Description: 返回对象工具类</p>  
 * @author zhjie  
 * @date 2019年8月17日
 */
public class ResultUtil {

	/**
	 * 
	 * <p>Title: success</p>  
	 * <p>Description: 成功</p>  
	 * @param object
	 * @return
	 */
    public static AjaxJson success(Object object) {
        AjaxJson result = new AjaxJson();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    /**
     * 
     * <p>Title: success</p>  
     * <p>Description: 成功</p>  
     * @return
     */
    public static AjaxJson success() {
        return success(null);
    }

    /**
     * 
     * <p>Title: error</p>  
     * <p>Description: 失败</p>  
     * @param code
     * @param msg
     * @param object
     * @return
     */
    public static AjaxJson error(Integer code, String msg, Object object) {
        AjaxJson result = new AjaxJson();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(object);
        return result;
    }

}