package com.media.realimagemedia.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.media.realimagemedia.R;
import com.media.realimagemedia.model.ItemElement;
import com.media.realimagemedia.model.Owner;
import com.media.realimagemedia.model.SectionData;
import com.media.realimagemedia.model.StackoverflowData;
import com.media.realimagemedia.stackoverflowlogin.Constants;

import retrofit.RetrofitError;

/**
 * Created by Venkat on 03-03-2016.
 */
public class InterestFragment extends Fragment {
    public InterestFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main,container,false);
        init(view);
        return view;
    }

    /**
     * Method to use initialization
     * @param view
     */
    private void init(View view) {
        SectionData sectionData = new SectionData() {
            @Override
            public void DisplaySections(StackoverflowData sectionDatas) {

                Log.i("retrofit", "dddddddddddddd=>" + sectionDatas.getItems());
                ItemElement[] itemElement = sectionDatas.getItems();
                for(int i = 0 ; i < itemElement.length ; i++){
                    Owner myOwner = itemElement[i].getOwner();
                    Log.i("Title is", "this" + itemElement[i].getTitle());

                }

            }

            @Override
            public void DisplayErrorMessage(RetrofitError failure) {

            }
        };
        Constants.ShowValidationMessage(getActivity(), "InterestFragment");
        //RestAPI.getInstance().TogetStackoverflowInterest(sectionData);
    }

}
