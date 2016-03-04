package com.media.realimagemedia.stackoverflowlogin;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

/**
 * Created by Venkat on 03-03-2016.
 */
public class StackWebView extends WebView {
    private loginCallbacks mycallbacks;

    public StackWebView(Context context) {
        super(context);
    }

    public StackWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StackWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    /**
     * Method to load the AuthDialog
     *
     * @param listener
     */
    public void init(loginCallbacks listener) {
        this.mycallbacks = listener;
        this.getSettings().setJavaScriptEnabled(true);
        this.loadUrl(OAuth2ClientCredentials.loadWebURL());
        this.setWebViewClient(new StackoverflowWebViewClient(this.mycallbacks));
    }
}
