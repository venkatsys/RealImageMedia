package com.media.realimagemedia.utils;

import com.media.realimagemedia.model.StackoverflowData;
import com.media.realimagemedia.model.UserLG;

import java.util.HashMap;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.QueryMap;

/**
 * Created by Venkat on 03-03-2016.
 */
public interface StackoverflowAuthenticationAPI {
    //@GET("/questions/featured?order=desc&sort=activity&site=stackoverflow")
    @GET("/questions/featured")
    public void GetInterest(@QueryMap HashMap<String, String> params,Callback<StackoverflowData> cb);

    //@GET("/questions?order=desc&sort=hot&site=stackoverflow")
    @GET("/questions")
    public void GetHotStacks(@QueryMap HashMap<String, String> params,Callback<StackoverflowData> cb);

    //@GET("/questions?order=desc&sort=week&site=stackoverflow")
    @GET("/questions")
    public void GetWeekStacks(@QueryMap HashMap<String, String> params,Callback<StackoverflowData> cb);

    //@GET("/questions?order=desc&sort=month&site=stackoverflow")
    @GET("/questions")
    public void GetMonthStacks(@QueryMap HashMap<String, String> params,Callback<StackoverflowData> cb);

    @GET("/questions/unanswered")
    public void GetUnAnswered(@QueryMap HashMap<String, String> params,Callback<StackoverflowData> cb);


    @GET("/access-tokens/{accessToken}/invalidate")
    public void ToUserLG(@Path("accessToken") String accessToken, @QueryMap HashMap<String, String> params, Callback<UserLG> cb);
}
