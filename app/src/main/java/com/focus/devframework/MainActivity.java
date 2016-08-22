package com.focus.devframework;

import android.database.Observable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.focus.devframework.Model.AlbumModel;
import com.focus.devframework.Model.ResponseResult;
import com.focus.devframework.Model.User;
import com.focus.devframework.http.ProgressRequestBody;
import com.focus.devframework.http.RetrofitClient;
import com.focus.devframework.service.ApiService;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView mResultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mResultText = (TextView) findViewById(R.id.result_text);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.query_button:
                sendQueryRequest();
                break;
            case R.id.post_button:
                sendPostRequest();
                break;
            case R.id.upload_button:

                break;
            case R.id.rx_query_button:

                break;
            default:
                break;
        }
    }

    private void sendQueryRequest() {
        HashMap<String, String> categories = new HashMap<>();
        categories.put("category", "others");
        categories.put("page", "1");
        categories.put("rows", "1");
        Call<List<AlbumModel>> listCall = RetrofitClient.INSTANCE.getRetrofit().create(ApiService.class).listAlbum(categories);
        listCall.enqueue(new Callback<List<AlbumModel>>() {
            @Override
            public void onResponse(Call<List<AlbumModel>> call, Response<List<AlbumModel>> response) {
                StringBuilder builder = new StringBuilder();
                for (AlbumModel contributor : response.body()) {
                    builder.append(contributor.getName() + " | ");
                }
                mResultText.setText(builder.toString());
            }

            @Override
            public void onFailure(Call<List<AlbumModel>> call, Throwable t) {

            }
        });

    }

    private void sendPostRequest() {
        User user = new User();
        user.userId = "456446431455";
        user.deviceId = "45454564231464";
        Call<ResponseResult<Object>> listCall = RetrofitClient.INSTANCE.getRetrofit().create(ApiService.class).foo(user);
        listCall.enqueue(new Callback<ResponseResult<Object>>() {
            @Override
            public void onResponse(Call<ResponseResult<Object>> call, Response<ResponseResult<Object>> response) {
                Log.d("tag", "Success:" + response.body().api);
            }

            @Override
            public void onFailure(Call<ResponseResult<Object>> call, Throwable t) {
                Log.d("tag", "failed");
            }
        });

    }

    private void uploadFile() {
        File file = null;
        String mimeType = "";
        HashMap<String, RequestBody> map = new HashMap<>();
        ProgressRequestBody.ProgressListener progressListener = new ProgressRequestBody.ProgressListener() {
            @Override
            public void update(long bytesRead, long contentLength, boolean done) {

            }
        };
        map.put("size", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(file.length())));
        map.put("type", RequestBody.create(MediaType.parse("text/plain"), mimeType));
        map.put(String.format("file\"; filename=\"%s", file.getName()), new ProgressRequestBody( RequestBody.create(MediaType.parse("text/plain"), mimeType), progressListener));
    }

    private void rxQuery() {
        Observable<List<AlbumModel>> observable = RetrofitClient.INSTANCE.getRetrofit().create(ApiService.class).rxListAlbum();
    }

}
