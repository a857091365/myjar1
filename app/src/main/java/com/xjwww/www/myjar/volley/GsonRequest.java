/*
 * Created by sangxiang, nov 19, 2014.
 */

package com.xjwww.www.myjar.volley;


import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.xjwww.www.myjar.config.Mlog;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class GsonRequest<T> extends Request<T> {
    private boolean showLog=false;
	private final Gson mGson = new Gson();
	private final Class<T> mClazz;
	private final Listener<T> mListener;
	private final Map<String, String> mHeaders;
	private final Map<String,String> mParams;


	public static Response.ErrorListener errorListener = new Response.ErrorListener() {
		@Override
		public void onErrorResponse(VolleyError volleyError) {
			String json = "";
			try {
				json = new String(volleyError.networkResponse.data, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			Mlog.e("onErrorResponse!" + json);
		}
	};

	public GsonRequest(String url, Class<T> clazz, Listener<T> listener, ErrorListener errorListener) {
		this(Method.GET, url, clazz, null, listener);
	}
	//不带Header和paramer的请求(get请求)统一的错误处理
	public  GsonRequest(String url, Class<T> clazz, Listener<T> listener) {
		this(Method.GET, url, clazz, null, listener, errorListener);
	}


	public GsonRequest(int method, String url, Class<T> clazz, Map<String, String> headers,
			Listener<T> listener, ErrorListener errorListener) {
		super(method, url, errorListener);
		this.mClazz = clazz;
		this.mHeaders = headers;
		this.mListener = listener;
		this.mParams=null;
        if(showLog){
            Mlog.e("Get请求  url=" + url);
            if(null!=headers)
                Mlog.e("Header是:" + headers.toString());
        }


	}
	//带header的请求(post和get)统一的错误处理
	public GsonRequest(int method, String url, Class<T> clazz, Map<String, String> headers,
					   Listener<T> listener) {
		this(method, url, clazz, headers, listener, errorListener);
	}


	public GsonRequest(int method, String url, Class<T> clazz, Map<String, String> headers,Map<String,String> mparams,
						Listener<T> listener, ErrorListener errorListener) {
		super(method, url, errorListener);
		this.mClazz = clazz;
		this.mHeaders = headers;
		this.mListener = listener;
		this.mParams=mparams;
        if(showLog){
            Mlog.e("Post请求  url=" + url);
            if(null!=headers)
                Mlog.e("Header是:" + headers.toString());
            if(null!=mparams)
                Mlog.e("params是:" + mparams.toString());
        }


	}
	//带header和paramter请求(get和post)统一的错误处理
	public GsonRequest(int method, String url, Class<T> clazz, Map<String, String> headers,Map<String,String> mparams,
					   Listener<T> listener) {
		this(method,url,clazz,headers,mparams,listener,errorListener);
	}



	@Override
      protected Map<String,String> getParams() throws AuthFailureError {
		return mParams!=null?mParams:super.getParams();
      }


	@Override
	public Map<String, String> getHeaders() throws AuthFailureError {
		return mHeaders != null ? mHeaders : super.getHeaders();

	}

	@Override
	protected void deliverResponse(T response) {
		mListener.onResponse(response);
	}

	@Override
	protected Response<T> parseNetworkResponse(NetworkResponse response) {
		try {
			//如果在服务器的返回数据的header中没有指定字符集那么就会默认使用 ISO-8859-1 字符集
			//String json = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
			String json = new String(response.data, "UTF-8");
            if(showLog){
                Mlog.e("请求结果＝"+json);
            }

			return Response.success(mGson.fromJson(json, mClazz),
                HttpHeaderParser.parseCacheHeaders(response));
		} catch (UnsupportedEncodingException e) {
			return Response.error(new ParseError(e));
		} catch (JsonSyntaxException e) {
			return Response.error(new ParseError(e));
		}
	}

}
