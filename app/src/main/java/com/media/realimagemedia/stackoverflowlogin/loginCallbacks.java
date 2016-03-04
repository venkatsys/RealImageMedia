package com.media.realimagemedia.stackoverflowlogin;

/**
 * Created by Venkat on 03-03-2016.
 */
public interface loginCallbacks {
    void toDisplay(String accessToken);
    void inValidLogin(String errormessage);
    void toDismissDailog();
}
