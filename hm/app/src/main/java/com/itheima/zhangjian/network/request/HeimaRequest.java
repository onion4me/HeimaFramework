package com.itheima.zhangjian.network.request;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 作者：ZHANGJ   on 16/5/6
 * 邮箱：anddevelopment@sina.com
 * 说明：处理请求动作
 */
public class HeimaRequest {

    public static HashMap<String, String> headers;

    /**
     * @param requestQueue
     * @param params
     * @param headersMap
     * @param listener
     * @param errorListener
     */
    public static void MapRequest(int method, int actionKey, RequestQueue requestQueue, String url,
                                  final Map<String, String> params, final Map<String, String> headersMap,
                                  Response.Listener<String> listener, Response.ErrorListener errorListener) {
        if (url == null) {
            url = "";
        }

        List<NameValuePair> pairs = new ArrayList<>();
        if (params != null) {
            Set<Map.Entry<String, String>> entrySet = params.entrySet();
            Iterator<Map.Entry<String, String>> iterator = entrySet.iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                String key = entry.getKey();
                String value = entry.getValue();
                NameValuePair pair = new BasicNameValuePair(key, value);
                pairs.add(pair);
            }
        }

        StringRequest strRequest = new StringRequest(method, url, pairs, listener, errorListener) {

            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                HashMap<String, String> headers = (HashMap<String, String>) response.headers;
                HeimaRequest.headers = headers;
                return super.parseNetworkResponse(response);
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                // 请求头
                return headersMap;
            }

            @Override
            public RetryPolicy getRetryPolicy() {
                RetryPolicy retryPolicy = new DefaultRetryPolicy(10 * 1000, 0,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                return retryPolicy;
            }
        };

        //标识 REQUEST对象
        strRequest.setTag(actionKey);
        //将请求对象添加带QUEUE里面
        requestQueue.add(strRequest);
    }

    @SuppressWarnings("unused")
    private static Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            error.printStackTrace();
        }
    };
}
