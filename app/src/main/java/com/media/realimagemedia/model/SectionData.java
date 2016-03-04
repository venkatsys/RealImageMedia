package com.media.realimagemedia.model;

import retrofit.RetrofitError;

/**
 * Created by Venkat on 03-03-2016.
 */
public interface SectionData {
    void DisplaySections(StackoverflowData sectionDatas);
    void DisplayErrorMessage(RetrofitError failure);
}
