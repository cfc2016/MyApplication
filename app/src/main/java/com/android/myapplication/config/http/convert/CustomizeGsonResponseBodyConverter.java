package com.android.myapplication.config.http.convert;

import com.android.myapplication.config.http.CustomException;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Converter;

import java.io.IOException;

/**
 *自定义Gson转化类-响应
 *@time 2019/9/9 10:03
 */
public class CustomizeGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private static final String TAG = "CustomizeGsonResponseBo";

    private final Gson gson;
    private final TypeAdapter<T> adapter;

    public CustomizeGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }


    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        try {
            JSONObject json = new JSONObject(response);
            int code = json.optInt("code");
            String info = json.optString("message");
            if(code != 200){
                value.close();
                throw new CustomException(code,info);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            return adapter.fromJson(response);
        } finally {
            value.close();
        }

    }
}
