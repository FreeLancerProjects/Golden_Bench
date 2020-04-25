package com.endpoint.golden_bench.activities_fragments.activity_home_pro.fragment_profile.fragmentmyprofile;

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
import com.endpoint.golden_bench.databinding.FragmentMyvoiceBinding;
import com.endpoint.golden_bench.databinding.FragmentOrdersBinding;
import com.endpoint.golden_bench.models.UserModel;
import com.endpoint.golden_bench.preferences.Preferences;

import io.paperdb.Paper;

public class FragmentMyVoice extends Fragment {
    private HomeproActivity activity;
    private FragmentMyvoiceBinding binding;
    private Preferences preferences;

private UserModel userModel;

    public static FragmentMyVoice newInstance()
    {
        return new FragmentMyVoice();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_myvoice,container,false);
        initView();

        return binding.getRoot();
    }

    private void initView() {

        preferences = Preferences.getInstance();
        activity = (HomeproActivity) getActivity();
        Paper.init(activity);


    }

}
