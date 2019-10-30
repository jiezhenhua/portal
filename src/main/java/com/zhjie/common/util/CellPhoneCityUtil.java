package com.zhjie.common.util;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.google.i18n.phonenumbers.geocoding.PhoneNumberOfflineGeocoder;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Locale;

/**
 * 根据号码获取号码归属地
 * @author 70975
 *
 */
public class CellPhoneCityUtil {
	/**
	 * 
	 * @param phoneNum
	 * @return
	 */
    public static String getCity(String phoneNum){
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        PhoneNumberOfflineGeocoder phoneNumberOfflineGeocoder = PhoneNumberOfflineGeocoder.getInstance();
        String language ="CN";
        Phonenumber.PhoneNumber referencePhonenumber = null;
        try {
            referencePhonenumber = phoneUtil.parse(phoneNum, language);
        } catch (NumberParseException e) {
            e.printStackTrace();
        }
//手机号码归属城市 city
        String city= phoneNumberOfflineGeocoder.getDescriptionForNumber(referencePhonenumber,Locale.CHINA);
        return city;
    }

    /**
     * 从www.ip138.com返回的结果网页内容中获取手机号码归属地,结果为：省份 城市
     *	选用这个的原因。是这个在尝试的数个获取api里面是比较精确的。
     * @param htmlSource
     * @return
     */
    public static String getCityUrl(String mobile) {
        String url = "http://www.ip138.com:8080/search.asp";
        StringBuffer sb = new StringBuffer(url);
        sb.append("?mobile="+mobile);
        sb.append("&action=mobile");
        // 指定get请求
        HttpGet httpGet = new HttpGet(sb.toString());
        // 创建httpclient
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 发送请求
        HttpResponse httpResponse;
        //返回的json
        String result = null;
        try {
            httpResponse = httpClient.execute(httpGet);
            // 验证请求是否成功
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 得到请求响应信息
                String str = EntityUtils.toString(httpResponse.getEntity(),
                        "GB2312");
                // 返回json
                if(str!=null&&!str.equals("")){
                    result=parseMobileFrom(str);
                }
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static String parseMobileFrom(String htmlSource){
        String result = "";
        String[] htmls = htmlSource.split("\n");
        for (int i = 0; i < htmls.length; i++) {
            String thisHtml = htmls[i];
            if(thisHtml.indexOf("卡号归属地")>0){
                if(thisHtml.indexOf("tdc2")>0){
                    thisHtml = thisHtml.substring(0,thisHtml.lastIndexOf("<"));
                    result = thisHtml.substring(thisHtml.lastIndexOf(">")+1);
                }else{
                    thisHtml = htmls[i+1];
                    thisHtml = thisHtml.substring(0,thisHtml.lastIndexOf("<"));
                    result = thisHtml.substring(thisHtml.lastIndexOf(">")+1);
                }
            }
        }
        return result.replaceAll("&nbsp;","");
    }

    public static void main(String[] args) {
        System.out.println("getCityUrl");
        System.out.println(getCityUrl("13569122222"));
        System.out.println("getCity");
        System.out.println(getCity("13569122222"));
    }
}

