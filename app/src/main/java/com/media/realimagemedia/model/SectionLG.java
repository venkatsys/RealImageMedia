package com.media.realimagemedia.model;

import retrofit.RetrofitError;

/**
 * Created by Venkat on 04-03-2016.
 */
public interface SectionLG {
    void UserStkLG(UserLG userLG);
    void DisplayErrorMessage(RetrofitError failure);
}
