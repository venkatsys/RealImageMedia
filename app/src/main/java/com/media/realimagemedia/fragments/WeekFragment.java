package com.media.realimagemedia.fragments;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.media.realimagemedia.MyApplication;
import com.media.realimagemedia.R;
import com.media.realimagemedia.adapter.StackTagAdapter;
import com.media.realimagemedia.adapter.StackoverflowAdapter;
import com.media.realimagemedia.model.SectionData;
import com.media.realimagemedia.model.StackOverflow;
import com.media.realimagemedia.model.StackoverflowData;
import com.media.realimagemedia.stackoverflowlogin.Constants;
import com.media.realimagemedia.stackoverflowlogin.OAuth2ClientCredentials;
import com.media.realimagemedia.utils.AppConstants;
import com.media.realimagemedia.utils.ConnectionDetector;
import com.media.realimagemedia.utils.DisplayResults;
import com.media.realimagemedia.utils.LocalUpdate;
import com.media.realimagemedia.utils.RestAPI;
import com.media.realimagemedia.utils.StringManipulation;

import java.util.List;

import retrofit.RetrofitError;

/**
 * Created by Venkat on 04-03-2016.
 */
public class WeekFragment extends Fragment {

    private Uri todoUri = null;
    private List<StackOverflow> stackItems;
    private List<String> tagNameList;
    private LocalUpdate localUpdateff = null;
    private Cursor SelectedSections = null;
    private StackoverflowAdapter customAdapter;
    private RecyclerView stackMultipleItemsList;
    private StackTagAdapter stackTagAdapter;
    private AlertDialog _tagdialog;
    private AlertDialog.Builder builder;

    public WeekFragment(){
        this.localUpdateff = new LocalUpdate(GetDisplay());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.stack_adapter_layout,container,false);
        init(view);
        return view;
    }

    /**
     * Method to use initialization
     * @param view
     */
    private void init(View view) {
        this.stackMultipleItemsList = (RecyclerView) view.findViewById(R.id.stackAdapterList);
        LinearLayoutManager mLinear = new LinearLayoutManager(getActivity());
        mLinear.setOrientation(LinearLayoutManager.VERTICAL);
        this.stackMultipleItemsList.setLayoutManager(mLinear);
        SectionData sectionData = new SectionData() {
            @Override
            public void DisplaySections(StackoverflowData sectionDatas) {

                /*Log.i("retrofit", "dddddddddddddd=>" + sectionDatas.getItems());
                ItemElement[] itemElement = sectionDatas.getItems();
                for(int i = 0 ; i < itemElement.length ; i++){
                    Owner myOwner = itemElement[i].getOwner();
                    Log.i("Title is", "this" + itemElement[i].getTitle());

                }*/
                Constants.EmptyTable(AppConstants.DONE_QUESTION_SECTION_WEEK);
                localUpdateff.TogetStackoverflowResults(sectionDatas,AppConstants.DONE_QUESTION_SECTION_WEEK);
                localUpdateff.run();
            }

            @Override
            public void DisplayErrorMessage(RetrofitError failure) {

            }
        };
        if(ConnectionDetector.isConnectingToInternet(MyApplication.getAppContext())&& Constants.TotalRecords(AppConstants.DONE_QUESTION_SECTION_WEEK) <= 0) {
            RestAPI.getInstance().TogetStackoverflowWeek(OAuth2ClientCredentials.toGetStackTypes(AppConstants.SECTION_WEEK),sectionData);
        }else {
            Constants.ShowValidationMessage(getActivity(), "Please Check Internet Connection");
            ToCheckRecords();
        }
    }
    /**
     * Method to Return Callbacks to Display the results
     */
    private DisplayResults GetDisplay(){
        DisplayResults displayResults = new DisplayResults() {
            @Override
            public void onSuccess(boolean status) {
                ToCheckRecords();
            }
        };
        return displayResults;
    }

    /**
     * Method to get and check Records in the Database
     */
    private void ToCheckRecords() {
        this.todoUri = null;
        this.todoUri = Uri.parse("content://com.realmedia/week/question/get");
        this.SelectedSections = MyApplication.getAppContext().getContentResolver().query(todoUri, null,
                null, null, null);
        this.stackItems = StringManipulation.SelectedCursorResults(this.SelectedSections);
        this.customAdapter = new StackoverflowAdapter(getActivity(),this.stackItems);
        this.stackMultipleItemsList.setAdapter(this.customAdapter);
        toHandleItemClick();
    }
    /**
     * Method to Handle Item Click
     */
    private void toHandleItemClick() {
        this.customAdapter.SetonItemClickListener(new StackoverflowAdapter.onItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                tagNameList = StringManipulation.toGetTagObjects(stackItems.get(position).getQuestiontagname());
                builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Tag Names");
                RecyclerView tagCyclerView = new RecyclerView(getActivity());
                LinearLayoutManager mLinear = new LinearLayoutManager(getActivity());
                mLinear.setOrientation(LinearLayoutManager.VERTICAL);
                tagCyclerView.setLayoutManager(mLinear);
                stackTagAdapter = new StackTagAdapter(getActivity(),tagNameList);
                tagCyclerView.setAdapter(stackTagAdapter);
                builder.setView(tagCyclerView);
                _tagdialog = builder.create();
                _tagdialog.show();
                toHandleTagItemClick();
            }
        });
    }

    /**
     * To Handle Tag Adapter Item Click
     */
    private void toHandleTagItemClick() {
        stackTagAdapter.SetonItemClickListener(new StackTagAdapter.onTagItemClickListerner() {
            @Override
            public void onItemClick(View v, int position) {
                if (_tagdialog.isShowing())
                    _tagdialog.dismiss();
                Constants.ShowValidationMessage(getActivity(), tagNameList.get(position));
            }
        });
    }
}
