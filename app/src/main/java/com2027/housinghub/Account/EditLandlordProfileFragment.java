package com2027.housinghub.Account;
/**
 * Fragment that will hold the user accounts (both student and landlord
 */

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com2027.housinghub.R;

public class EditLandlordProfileFragment extends Fragment implements View.OnClickListener {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_landlord_profile, container, false);
        Button button = (Button) view.findViewById(R.id.BtnELProfile);
        button.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new LandlordProfileFragment()).commit();
    }

}