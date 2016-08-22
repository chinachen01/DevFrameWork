package com.focus.devframework;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.focus.devframework.Model.Contributor;
import com.focus.devframework.service.ApiService;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Button mSimpleButton;
    private TextView mResultText;
    public static final String API_URL = "https://api.github.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSimpleButton = (Button) findViewById(R.id.simple_request_button);
        mResultText = (TextView) findViewById(R.id.result_text);
        Onclick onclick = new Onclick();
        mSimpleButton.setOnClickListener(onclick);
    }

    private class Onclick implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.simple_request_button:
                    try {
                        sendSimpleRequest();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private void sendSimpleRequest() throws IOException {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_URL).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<Contributor>> listCall = apiService.listContributors("square", "retrofit");
        listCall.enqueue(new Callback<List<Contributor>>() {
            @Override
            public void onResponse(Call<List<Contributor>> call, Response<List<Contributor>> response) {
                StringBuilder builder = new StringBuilder();
                for (Contributor contributor : response.body()) {
                    builder.append(contributor.getContributions() + " | ");
                }
                mResultText.setText(builder.toString());
            }

            @Override
            public void onFailure(Call<List<Contributor>> call, Throwable t) {

            }
        });

    }

}
