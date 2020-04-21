package com.endpoint.golden_bench.activities_fragments.activity_home_pro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.endpoint.golden_bench.R;
import com.endpoint.golden_bench.databinding.FragmentVoiceBinding;
import com.endpoint.golden_bench.preferences.Preferences;

import java.util.Locale;

import io.paperdb.Paper;

public class Fragment_Voice extends Fragment {

    private HomeproActivity activity;
    private FragmentVoiceBinding binding;
    private Preferences preferences;

    private String lang;


    public static Fragment_Voice newInstance() {
        return new Fragment_Voice();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_voice,container,false);
        initView();
        return binding.getRoot();
    }

    private void initView() {


        activity = (HomeproActivity) getActivity();
        Paper.init(activity);
        lang = Paper.book().read("lang", Locale.getDefault().getLanguage());preferences = Preferences.getInstance();



    }



    @Override
    public void onResume() {
        super.onResume();
    }
}
