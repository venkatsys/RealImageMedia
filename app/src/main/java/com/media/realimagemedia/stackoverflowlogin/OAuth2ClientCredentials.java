package com.media.realimagemedia.stackoverflowlogin;

import android.util.Log;

import com.media.realimagemedia.utils.RestAPI;

import java.util.HashMap;

/**
 * Created by Venkat on 03-03-2016.
 */
public class OAuth2ClientCredentials {
   /** Value of the "Client ID" shown under "Client ID for installed applications". */
    public static final String CLIENT_KEY= "rE5ZYIJi7X7kDv7dZ*RYmg((";
    /** Value of the "Client ID" shown under "Client ID for installed applications". */
    static final String CLIENT_ID = "6608";
    /** Value of the "Client GRANT TYPE" shown under "Client ID for installed applications". */
    final static String GRANT_SCOPE = "no_expiry";
    /** Value of the "Client Redirect URI" shown under "Client ID for installed applications". */
    final static String REDIRECT_URI = "https://stackexchange.com/oauth/login_success";
    /** Value of the "Client OAUTH TYPE URL" shown under "Client ID for installed applications". */
    final static String OAUTH_URL = "https://stackexchange.com/oauth/dialog";
    /** OAuth Type Code*/
    final static String TYPE_CODE = "#access_token";
    /**
     * Method to load URL
     */
    public static String loadWebURL() {
        String webURL = "";
        webURL += OAUTH_URL + "?client_id=" + CLIENT_ID
                + "&scope=" + GRANT_SCOPE + "&redirect_uri=" + REDIRECT_URI;
        Log.i("URL", "webURL =>" + webURL);
        return webURL;
    }
    /**
     * Method to Return the webClient Code
     * @param url
     */
    public static String toGetCodeFromStackOverflowWebClient(String url){
        String[] accessTokensplit = url.split("=");
        Log.i("code", "toGetCodeFromStackOverflowWebClient=>" + accessTokensplit[1]);
        return accessTokensplit[1];
    }
    /**
     * Method to Return HashMap for Stackoverflow user profile information
     */
    public static HashMap<String, String> toGetStackInformation(){
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("key", CLIENT_KEY);
        params.put("filter", "default");
        return params;
    }

    /**
     * Method to Set AccessToken Globally
     */
    public static void toSetAccessToken(String accessToken){
        RestAPI.getInstance().setAccesToken(accessToken);
    }

    /**
     * Method to Return Hashmap for Stackflow types
     */
    public static HashMap<String, String>  toGetStackTypes(String type){
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("key", CLIENT_KEY);
        params.put("order", "desc");
        params.put("sort", type);
        params.put("site", "stackoverflow");
        params.put("access_token", RestAPI.getInstance().getAccesToken());
        return  params;
    }
    /**
     * Method to Return Hashmap for Stackflow types
     */
    public static HashMap<String, String>  toGetStackAnswer(){
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("key", CLIENT_KEY);
        params.put("order", "desc");
        params.put("site", "stackoverflow");
        params.put("access_token", RestAPI.getInstance().getAccesToken());
        return  params;
    }
    /**
     * Method to Return Hashmap for Stackflow types
     */
    public static HashMap<String, String>  toGetStackUserInformation(String type,String userLGname){
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("key", CLIENT_KEY);
        params.put("order", "desc");
        params.put("sort", type);
        params.put("site", "stackoverflow");
        params.put("inname", userLGname);
        params.put("access_token", RestAPI.getInstance().getAccesToken());
        return  params;
    }
}
