package com.itheima.zhangjian.network.request;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import org.apache.http.NameValuePair;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 作者：ZHANGJ   on 16/5/6
 * 邮箱：anddevelopment@sina.com
 * 说明：改造volley的请求
 */
public class StringRequest extends Request<String> {

    private final Response.Listener<String> mListener;

    private String reqStr;

    public StringRequest(int method, String url, List<NameValuePair> params,
                         Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        mListener = listener;
        String reqStr = "";
        for (int i = 0; i < params.size(); i++) {
            NameValuePair nameValuePair = params.get(i);
            reqStr = reqStr + nameValuePair.getName() + "=" + nameValuePair.getValue();
            if (i != params.size() - 1)
                reqStr += "&";
        }
        this.reqStr = reqStr;
    }

    @Override
    protected void deliverResponse(String response) {
        //发送响应给响应监听
        mListener.onResponse(response);
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        String parsed;
        try {
            parsed = new String(response.data, HttpHeaderParser.parseCharset(response.headers)); // 将返回的内容与编码拼接字符串
        } catch (UnsupportedEncodingException e) {
            parsed = new String(response.data);
        }
        return Response.success(parsed, HttpHeaderParser.parseCacheHeaders(response));
    }

    @Override
    public byte[] getBody() {
        try {
            return reqStr == null ? null : reqStr.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}