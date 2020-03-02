package com.example.efarming.ui.marketing;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MarketingViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MarketingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("MARKETING");
    }

    public LiveData<String> getText() {
        return mText;
    }
}