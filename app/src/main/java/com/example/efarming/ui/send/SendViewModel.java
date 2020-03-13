package com.example.efarming.ui.send;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SendViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SendViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This page will be having the options to send messages to the users in their private inbox");
    }

    public LiveData<String> getText() {
        return mText;
    }
}