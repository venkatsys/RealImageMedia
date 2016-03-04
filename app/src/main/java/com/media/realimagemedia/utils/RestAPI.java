package com.media.realimagemedia.utils;

import android.util.Log;

import com.media.realimagemedia.model.SectionData;
import com.media.realimagemedia.model.SectionLG;
import com.media.realimagemedia.model.StackoverflowData;
import com.media.realimagemedia.model.UserLG;

import java.util.HashMap;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Venkat on 03-03-2016.
 */
public class RestAPI {

    protected static RestAPI mInstance = null;
    public static RestAdapter adapter;
    public static String ENDPOINT = "https://api.stackexchange.com/2.2/";
    private static StackoverflowAuthenticationAPI stackoverflowAuthenticationAPI = null;
    private String accesToken= null;

    private RestAPI() {
        this.adapter = new RestAdapter.Builder().setEndpoint(ENDPOINT).setLogLevel(RestAdapter.LogLevel.FULL).build();
    }

    public String getAccesToken() {
        return accesToken;
    }

    public void setAccesToken(String accesToken) {
        this.accesToken = accesToken;
    }

    public static RestAPI getInstance() {
        if (null == mInstance) {
            synchronized (RestAPI.class) {
                if (null == mInstance) {
                    mInstance = new RestAPI();
                }
            }
        }
        return mInstance;
    }

    /**
     * Method to Send Request to Get Stackoverflow Interest
     * @param sectionDatalistener
     */
    public static void TogetStackoverflowInterest(HashMap<String, String> clientKeyDetails,final SectionData sectionDatalistener){
        stackoverflowAuthenticationAPI = adapter.create(StackoverflowAuthenticationAPI.class);
        stackoverflowAuthenticationAPI.GetInterest(clientKeyDetails , new Callback<StackoverflowData>() {
            @Override
            public void success(StackoverflowData stackoverflowData, Response response) {
                Log.i("retrofit", "dddddddddddddd=>" + stackoverflowData.getItems());
                sectionDatalistener.DisplaySections(stackoverflowData);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("retrofit", "dddddddddddddd=>" + error.getMessage());
                sectionDatalistener.DisplayErrorMessage(error);
            }
        });
    }
    /**
     * Method to Send Request to Get Stackoverflow Hot
     * @param sectionDatalistener
     */
    public static void TogetStackoverflowHot(HashMap<String, String> clientKeyDetails,final SectionData sectionDatalistener){
        stackoverflowAuthenticationAPI = adapter.create(StackoverflowAuthenticationAPI.class);
        stackoverflowAuthenticationAPI.GetHotStacks(clientKeyDetails, new Callback<StackoverflowData>() {
            @Override
            public void success(StackoverflowData stackoverflowData, Response response) {
                sectionDatalistener.DisplaySections(stackoverflowData);
            }

            @Override
            public void failure(RetrofitError error) {
                sectionDatalistener.DisplayErrorMessage(error);
            }
        });
    }
    /**
     * Method to Send Request to Get Stackoverflow Week
     * @param sectionDatalistener
     */
    public static void TogetStackoverflowWeek(HashMap<String, String> clientKeyDetails,final SectionData sectionDatalistener){
        stackoverflowAuthenticationAPI = adapter.create(StackoverflowAuthenticationAPI.class);
        stackoverflowAuthenticationAPI.GetWeekStacks(clientKeyDetails, new Callback<StackoverflowData>() {
            @Override
            public void success(StackoverflowData stackoverflowData, Response response) {
                sectionDatalistener.DisplaySections(stackoverflowData);
            }

            @Override
            public void failure(RetrofitError error) {
                sectionDatalistener.DisplayErrorMessage(error);
            }
        });
    }
    /**
     * Method to Send Request to Get Stackoverflow Month
     * @param sectionDatalistener
     */
    public static void TogetStackoverflowMonth(HashMap<String, String> clientKeyDetails,final SectionData sectionDatalistener){
        stackoverflowAuthenticationAPI = adapter.create(StackoverflowAuthenticationAPI.class);
        stackoverflowAuthenticationAPI.GetMonthStacks(clientKeyDetails, new Callback<StackoverflowData>() {
            @Override
            public void success(StackoverflowData stackoverflowData, Response response) {
                sectionDatalistener.DisplaySections(stackoverflowData);
            }

            @Override
            public void failure(RetrofitError error) {
                sectionDatalistener.DisplayErrorMessage(error);
            }
        });
    }
    /**
     * Method to Send Request to Get Stackoverflow Unswered
     * @param sectionDatalistener
     * @param clientKey
     */
    public static void TogetStackoverflowUnAnswer(HashMap<String, String> clientKey, final SectionData sectionDatalistener){
        stackoverflowAuthenticationAPI = adapter.create(StackoverflowAuthenticationAPI.class);
        stackoverflowAuthenticationAPI.GetUnAnswered(clientKey, new Callback<StackoverflowData>() {
            @Override
            public void success(StackoverflowData stackoverflowData, Response response) {
                sectionDatalistener.DisplaySections(stackoverflowData);
            }

            @Override
            public void failure(RetrofitError error) {
                sectionDatalistener.DisplayErrorMessage(error);
            }
        });

    }
    /**
     * Method to Send Request to Get Logout
     * @param userAccesstoken
     * @param clientKey
     * @param sectionLGlistener
     */
    public static void TouserLG(String userAccesstoken, HashMap<String, String> clientKey, final SectionLG sectionLGlistener){
        stackoverflowAuthenticationAPI = adapter.create(StackoverflowAuthenticationAPI.class);
        stackoverflowAuthenticationAPI.ToUserLG(userAccesstoken, clientKey, new Callback<UserLG>() {
            @Override
            public void success(UserLG userLG, Response response) {
                sectionLGlistener.UserStkLG(userLG);
            }

            @Override
            public void failure(RetrofitError error) {
                sectionLGlistener.DisplayErrorMessage(error);
            }
        });
    }

}
