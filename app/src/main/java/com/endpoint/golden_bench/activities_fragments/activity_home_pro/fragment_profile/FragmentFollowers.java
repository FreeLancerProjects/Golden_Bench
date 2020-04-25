package com.endpoint.golden_bench.activities_fragments.activity_home_pro.fragment_profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.endpoint.golden_bench.R;
import com.endpoint.golden_bench.activities_fragments.activity_home_pro.HomeproActivity;
import com.endpoint.golden_bench.databinding.FragmentFollowerBinding;
import com.endpoint.golden_bench.databinding.FragmentOrdersBinding;
import com.endpoint.golden_bench.models.UserModel;
import com.endpoint.golden_bench.preferences.Preferences;

import io.paperdb.Paper;

public class FragmentFollowers extends Fragment {
    private HomeproActivity activity;
    private FragmentFollowerBinding binding;
    private Preferences preferences;

private UserModel userModel;

    public static FragmentFollowers newInstance()
    {
        return new FragmentFollowers();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_follower,container,false);
        initView();

        return binding.getRoot();
    }

    private void initView() {

        preferences = Preferences.getInstance();
        activity = (HomeproActivity) getActivity();
        Paper.init(activity);


    }

}
