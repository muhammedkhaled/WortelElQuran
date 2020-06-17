package com.example.ertaqiwratel.presentation.activities.navUi.admin;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AdminChatViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AdminChatViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}