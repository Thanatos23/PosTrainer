package com.bracketcove.postrainer.settings;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bracketcove.postrainer.PostrainerApplication;
import com.bracketcove.postrainer.R;
import com.bracketcove.postrainer.reminderdetail.ReminderDetailPresenterModule;

import javax.inject.Inject;

/**
 * Created by Ryan on 05/03/2017.
 */

public class SettingsFragment extends Fragment implements SettingsContract.View {

    @Inject
    SettingsContract.Presenter presenter;

    public SettingsFragment() {

    }

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //This is important for Orientation Change handling!!!
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings, container, false);
        Button contact = (Button) v.findViewById(R.id.btn_settings_contact);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onContactButtonClick();
            }
        });
        return v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        if (presenter == null) {
            DaggerSettingsComponent.builder()
                    .settingsPresenterModule(new SettingsPresenterModule(this))
                    .build();
            presenter.subscribe();
        }

        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        presenter.unsubscribe();
        super.onDestroy();
    }

    @Override
    public void setPresenter(SettingsContract.Presenter presenter) {

    }

    @Override
    public void makeToast(String message) {

    }

}
