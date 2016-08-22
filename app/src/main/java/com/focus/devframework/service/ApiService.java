package com.focus.devframework.service;

import com.focus.devframework.Model.Contributor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by focus on 16/8/16.
 */
public interface ApiService {
    @GET("/repos/{company}/{product}/contributors")
    Call<List<Contributor>> listContributors(@Path("company") String company, @Path("product") String product);
}
