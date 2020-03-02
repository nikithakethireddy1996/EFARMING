package com.example.efarming.ui.crop_analysis;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CropAnalysisViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CropAnalysisViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is crop analysis fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}