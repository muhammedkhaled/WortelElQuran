package com.example.ertaqiwratel.presentation.activities.destinations.navUi.extra;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ExtraSessionViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ExtraSessionViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}