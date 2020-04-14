package com.endpoint.golden_bench.activities_fragments.activity_signin.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;


import com.endpoint.golden_bench.R;
import com.endpoint.golden_bench.activities_fragments.activity_signin.SigninActivity;
import com.endpoint.golden_bench.activities_fragments.activity_signup.SignupActivity;
import com.endpoint.golden_bench.activities_fragments.activity_user_type.UserTypeActivity;
import com.endpoint.golden_bench.databinding.FragmentSignInBinding;
import com.endpoint.golden_bench.preferences.Preferences;

public class Fragment_Signin extends Fragment {

    private SigninActivity activity;
    private FragmentSignInBinding binding;
    private Preferences preferences;


    public static Fragment_Signin newInstance() {
        return new Fragment_Signin();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_in, container, false);
        initView();

        return binding.getRoot();
    }

    private void initView() {
        activity=(SigninActivity)getActivity();
binding.btnNewAccount.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(activity, UserTypeActivity.class);
        startActivity(intent);
    }
});
    }


}
