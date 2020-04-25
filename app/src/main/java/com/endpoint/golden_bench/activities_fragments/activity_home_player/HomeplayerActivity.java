package com.endpoint.golden_bench.activities_fragments.activity_home_player;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.endpoint.golden_bench.R;
import com.endpoint.golden_bench.activities_fragments.activity_home_player.fragments.Fragment_Main;
import com.endpoint.golden_bench.activities_fragments.activity_home_player.fragments.Fragment_Voice;
import com.endpoint.golden_bench.activities_fragments.activity_home_player.fragments.fragment_bench.fragments.Fragment_Bench;
import com.endpoint.golden_bench.activities_fragments.activity_home_player.fragments.fragment_profile.Fragment_Profile;
import com.endpoint.golden_bench.activities_fragments.activity_signin.SigninActivity;
import com.endpoint.golden_bench.language.Language;
import com.endpoint.golden_bench.models.UserModel;
import com.endpoint.golden_bench.preferences.Preferences;
import com.endpoint.golden_bench.tags.Tags;

import java.util.Locale;

import io.paperdb.Paper;

public class HomeplayerActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private Fragment_Main fragment_main;
    private Fragment_Bench fragment_bench;
    private Fragment_Voice fragment_voice;
    private Fragment_Profile fragment_profile;
    private AHBottomNavigation ahBottomNav;
    private LinearLayoutManager manager;
    private DrawerLayout drawer;
    private Preferences preferences;
    private UserModel userModel;
    private ActionBarDrawerToggle toggle;
    private Toolbar toolbar;
    private String lang;


    protected void attachBaseContext(Context newBase) {
        Paper.init(newBase);
        super.attachBaseContext(Language.updateResources(newBase, Paper.book().read("lang", Locale.getDefault().getLanguage())));}


  


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    
        setContentView(R.layout.activity_home);
        initView();

        if (savedInstanceState == null) {

            displayFragmentMain();
        }


    }

    @SuppressLint("RestrictedApi")
    private void initView() {
        preferences = Preferences.getInstance();
        userModel = preferences.getUserData(this);
        Paper.init(this);
               lang = Paper.book().read("lang", Locale.getDefault().getLanguage());Log.e("ldlmfmmvm",lang);
        ahBottomNav = findViewById(R.id.ah_bottom_nav);
        drawer = findViewById(R.id.drawer_layout);
        fragmentManager = getSupportFragmentManager();
        toolbar = findViewById(R.id.toolbar);
        
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        manager = new LinearLayoutManager(this);
       

        toggle.syncState();
        setUpBottomNavigation();
       

    }

    public void Logout() {
        userModel = null;
        preferences.create_update_userdata(this, userModel);
        preferences.create_update_session(this, Tags.session_logout);
        Intent intent = new Intent(HomeplayerActivity.this, SigninActivity.class);
        startActivity(intent);
        finish();
    }



    private void setUpBottomNavigation() {

        AHBottomNavigationItem item1 = new AHBottomNavigationItem("", R.drawable.ic_lhome);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("", R.drawable.ic_playernav);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("", R.drawable.ic_mick);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem("", R.drawable.ic_chat);
        AHBottomNavigationItem item5 = new AHBottomNavigationItem("", R.drawable.ic_usernav);

        ahBottomNav.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        ahBottomNav.setDefaultBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));
        ahBottomNav.setTitleTextSizeInSp(14, 12);
        ahBottomNav.setForceTint(true);
        ahBottomNav.setAccentColor(ContextCompat.getColor(this, R.color.black));
        ahBottomNav.setInactiveColor(ContextCompat.getColor(this, R.color.gray8));

        ahBottomNav.addItem(item1);
        ahBottomNav.addItem(item2);
        ahBottomNav.addItem(item3);
        ahBottomNav.addItem(item4);
        ahBottomNav.addItem(item5);

        updateBottomNavigationPosition(0);

        ahBottomNav.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                switch (position) {
                    case 0:
                        displayFragmentMain();
                        break;
                    case 1:
                        displayFragmentBench();

                        break;
                    case 2:
                        displayFragmentvoice();
                        break;
                    case 4:
                            displayFragmentProfile();
                      
                        break;
                  
                }
                return false;
            }
        });


    }

    private void updateBottomNavigationPosition(int pos) {

        ahBottomNav.setCurrentItem(pos, false);

    }

    public void displayFragmentMain() {
        try {
            if (fragment_main == null) {
                fragment_main = Fragment_Main.newInstance();
            }

            if (fragment_voice != null && fragment_voice.isAdded()) {
                fragmentManager.beginTransaction().hide(fragment_voice).commit();
            }
            if (fragment_bench != null && fragment_bench.isAdded()) {
                fragmentManager.beginTransaction().hide(fragment_bench).commit();
            }
            if (fragment_voice != null && fragment_voice.isAdded()) {
                fragmentManager.beginTransaction().hide(fragment_voice).commit();
            }
            if (fragment_profile != null && fragment_profile.isAdded()) {
                fragmentManager.beginTransaction().hide(fragment_profile).commit();
            }
            if (fragment_main.isAdded()) {
                fragmentManager.beginTransaction().show(fragment_main).commit();

            } else {
                fragmentManager.beginTransaction().add(R.id.fragment_home_container, fragment_main, "fragment_main").addToBackStack("fragment_main").commit();

            }
            updateBottomNavigationPosition(0);
        } catch (Exception e) {
        }

    }

    private void displayFragmentBench() {
        try {
            if (fragment_bench == null) {
                fragment_bench = Fragment_Bench.newInstance();
            }
            if (fragment_main != null && fragment_main.isAdded()) {
                fragmentManager.beginTransaction().hide(fragment_main).commit();
            }
            if (fragment_voice != null && fragment_voice.isAdded()) {
                fragmentManager.beginTransaction().hide(fragment_voice).commit();
            }
            if (fragment_voice != null && fragment_voice.isAdded()) {
                fragmentManager.beginTransaction().hide(fragment_voice).commit();
            }
            if (fragment_profile != null && fragment_profile.isAdded()) {
                fragmentManager.beginTransaction().hide(fragment_profile).commit();
            }
            if (fragment_bench.isAdded()) {
                fragmentManager.beginTransaction().show(fragment_bench).commit();

            } else {
                fragmentManager.beginTransaction().add(R.id.fragment_home_container, fragment_bench, "fragment_require").addToBackStack("fragment_require").commit();

            }
            updateBottomNavigationPosition(2);
        } catch (Exception e) {
        }
        


    }

    private void displayFragmentvoice() {

        try {
            if (fragment_voice == null) {
                fragment_voice = Fragment_Voice.newInstance();
            }
            if (fragment_main != null && fragment_main.isAdded()) {
                fragmentManager.beginTransaction().hide(fragment_main).commit();
            }
            if (fragment_bench != null && fragment_bench.isAdded()) {
                fragmentManager.beginTransaction().hide(fragment_bench).commit();
            }
            if (fragment_voice != null && fragment_voice.isAdded()) {
                fragmentManager.beginTransaction().hide(fragment_voice).commit();
            }
            if (fragment_profile != null && fragment_profile.isAdded()) {
                fragmentManager.beginTransaction().hide(fragment_profile).commit();
            }
            if (fragment_voice.isAdded()) {
                fragmentManager.beginTransaction().show(fragment_voice).commit();

            } else {
                fragmentManager.beginTransaction().add(R.id.fragment_home_container, fragment_voice, "fragment_voice").addToBackStack("fragment_voice").commit();

            }
            updateBottomNavigationPosition(1);
        } catch (Exception e) {
        }
    }

    private void displayFragmentProfile() {
        try {
            if (fragment_profile == null) {
                fragment_profile = Fragment_Profile.newInstance();
            }
            if (fragment_main != null && fragment_main.isAdded()) {
                fragmentManager.beginTransaction().hide(fragment_main).commit();
            }
            if (fragment_bench != null && fragment_bench.isAdded()) {
                fragmentManager.beginTransaction().hide(fragment_bench).commit();
            }
            if (fragment_voice != null && fragment_voice.isAdded()) {
                fragmentManager.beginTransaction().hide(fragment_voice).commit();
            }
            if (fragment_voice != null && fragment_voice.isAdded()) {
                fragmentManager.beginTransaction().hide(fragment_voice).commit();
            }
            if (fragment_profile.isAdded()) {
                fragmentManager.beginTransaction().show(fragment_profile).commit();

            } else {
                fragmentManager.beginTransaction().add(R.id.fragment_home_container, fragment_profile, "fragment_profile").addToBackStack("fragment_profile").commit();

            }
            updateBottomNavigationPosition(4);
        } catch (Exception e) {
        }
    }


    public void NavigateToSignInActivity(boolean isSignIn) {
//Log.e("data",isSignIn+"");
        Intent intent = new Intent(HomeplayerActivity.this, SigninActivity.class);
        intent.putExtra("sign_up", isSignIn);
        startActivity(intent);
        finish();

    }

    public void RefreshActivity(String lang) {
        Paper.book().write("lang", lang);
        Language.setNewLocale(this, lang);
        new Handler()
                .postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                    }
                }, 1050);


    }


    @SuppressLint("RestrictedApi")
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (fragment_main != null && fragment_main.isAdded() && fragment_main.isVisible()) {
                finish();
            } else {
                displayFragmentMain();
            }

        }
    }




    @Override
    protected void onResume() {
        super.onResume();
    }
}
