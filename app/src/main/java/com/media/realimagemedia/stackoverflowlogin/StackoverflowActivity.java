package com.media.realimagemedia.stackoverflowlogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.media.realimagemedia.HomeActivity;
import com.media.realimagemedia.R;
import com.media.realimagemedia.utils.CustomProgressDialog;

/**
 * Created by Venkat on 03-03-2016.
 */
public class StackoverflowActivity extends AppCompatActivity{

    private StackWebView stackWebView;
    private CustomProgressDialog pDialog;
    private Intent homeScreenIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stackebview_dialog);
        this.pDialog = new CustomProgressDialog(this);
        this.pDialog.setTitle("loading");
        this.pDialog.show();
        this.stackWebView = (StackWebView) this.findViewById(R.id.stackoverflowWebview);
       this.init();
    }

    /**
     * Method to Handle Initialization and Callbacks
     */
    private void init() {
        loginCallbacks loginCallbacks = new loginCallbacks() {
            @Override
            public void toDisplay(String accessToken) {
                toHideWebview();
                toGotoHomeScreen(accessToken);
                Constants.ShowValidationMessage(StackoverflowActivity.this, "success");
            }

            @Override
            public void inValidLogin(String errormessage) {
                Constants.ShowValidationMessage(StackoverflowActivity.this,errormessage);
                init();
            }

            @Override
            public void toDismissDailog() {
                pDialog.dismiss();
            }
        };
        this.stackWebView.init(loginCallbacks);
    }
    /**
     * Method to Hide Webview
     */
    private void toHideWebview(){
        stackWebView.setVisibility(View.INVISIBLE);
    }
    /**
     * Method to Go to Home Screen
     * @param accessToken
     */
    private void toGotoHomeScreen(String accessToken){
        this.homeScreenIntent = new Intent(this, HomeActivity.class);
        this.homeScreenIntent.putExtra("CurrentUserAccessToken",accessToken);
        startActivity(this.homeScreenIntent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
        this.homeScreenIntent = null;
        this.stackWebView = null;
        this.pDialog = null;
    }
}
