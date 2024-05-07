package com.example.lab5.ui.sign_out;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Sign_Out_ViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public Sign_Out_ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}