package com.media.realimagemedia;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.media.realimagemedia.fragments.ActivityToFragmentCommunicator;
import com.media.realimagemedia.fragments.SwipeFragment;
import com.media.realimagemedia.model.SectionLG;
import com.media.realimagemedia.model.UserLG;
import com.media.realimagemedia.stackoverflowlogin.Constants;
import com.media.realimagemedia.stackoverflowlogin.OAuth2ClientCredentials;
import com.media.realimagemedia.utils.ConnectionDetector;
import com.media.realimagemedia.utils.RestAPI;

import retrofit.RetrofitError;

/**
 * Created by Venkat on 03-03-2016.
 */
public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView drawerListView;
    private ArrayAdapter<String> navigationItems;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar mToolbar;
    private String[] stackOverflowItems;
    private ActivityToFragmentCommunicator activityToFragmentCommunicator;
    private String userAccesstoken = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        toInit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.userAccesstoken = getIntent().getStringExtra("CurrentUserAccessToken");
        OAuth2ClientCredentials.toSetAccessToken(this.userAccesstoken);
    }

    /**
     * Method to used for Initialization
     */
    private void toInit() {
        this.drawerListView = (ListView) this.findViewById(R.id.drawerListItems);
        this.mDrawerLayout = (DrawerLayout) this.findViewById(R.id.drawerLayout);
        stackOverflowItems = getResources().getStringArray(R.array.stackItems);
        navigationItems = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, stackOverflowItems);
        this.drawerListView.setAdapter(navigationItems);
        this.drawerListView.setOnItemClickListener(this);
        toInitdrawerToggle();
    }

    /**
     * Method to Init Drawer Toggle
     */
    private void toInitdrawerToggle() {
        this.mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        this.mDrawerLayout.setDrawerListener(this.mDrawerToggle);
        toLoadHomeScreen();
    }

    /**
     * Method to load Home Screen
     */
    private void toLoadHomeScreen() {
        FragmentManager mfragmentManager= getSupportFragmentManager();
        mfragmentManager.beginTransaction().replace(R.id.content_frame, new SwipeFragment()).commit();
    }
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        this.mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.mDrawerToggle.onConfigurationChanged(newConfig);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Constants.ShowValidationMessage(HomeActivity.this, stackOverflowItems[position]);
        mDrawerLayout.closeDrawer(drawerListView);
        if(stackOverflowItems[position].contentEquals("Logout")) {
            Constants.ShowValidationMessage(HomeActivity.this, "Logout");
            onLogoutOfUser();
        }
        else {
            activityToFragmentCommunicator.passDataToFragment(position);
        }

    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        activityToFragmentCommunicator = (ActivityToFragmentCommunicator) fragment;
    }

    @Override
    public void onBackPressed() {
        if(this.mDrawerLayout.isDrawerOpen(drawerListView)){
            mDrawerLayout.closeDrawer(drawerListView);
        }else {
            super.onBackPressed();
        }
    }
    /**
     * Method to Logout of the User
     */
    private void onLogoutOfUser(){
        SectionLG sectionLG = new SectionLG() {
            @Override
            public void UserStkLG(UserLG userLG) {
                Constants.ShowValidationMessage(HomeActivity.this, "onLogoutOfUser");
                finish();
            }

            @Override
            public void DisplayErrorMessage(RetrofitError failure) {

            }
        };
        if(ConnectionDetector.isConnectingToInternet(MyApplication.getAppContext())) {
            RestAPI.getInstance().TouserLG(this.userAccesstoken, OAuth2ClientCredentials.toGetStackInformation(),sectionLG);
        }else {
            Constants.ShowValidationMessage(this, "Please Check Internet Connection");
        }
    }
}
