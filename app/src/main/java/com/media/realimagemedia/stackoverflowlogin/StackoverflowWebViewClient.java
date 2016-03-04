package com.media.realimagemedia.stackoverflowlogin;

import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Venkat on 03-03-2016.
 */
public class StackoverflowWebViewClient extends WebViewClient {
    private int i = 0;
    private loginCallbacks mycallbacks;

    public StackoverflowWebViewClient(loginCallbacks callbackListener) {
        this.mycallbacks = callbackListener;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        this.mycallbacks.toDismissDailog();
        i++;
        if (url.startsWith(OAuth2ClientCredentials.REDIRECT_URI)) {
            try {
                if (url.indexOf("#access_token")!= -1){
                        this.mycallbacks.toDisplay(OAuth2ClientCredentials.toGetCodeFromStackOverflowWebClient(url));
                        i=0;
                } else if (url.indexOf("error=") != -1) {
                    this.mycallbacks.inValidLogin(Constants.invalidLogin);
                } else if (url.indexOf("access_denied") != -1) {

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(i==3){
            this.mycallbacks.inValidLogin(Constants.invalidLogin);
            i=0;
        }
        super.onPageFinished(view, url);
    }

    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        Log.i("code", "code=>" + error);
        super.onReceivedError(view, request, error);
    }
}
