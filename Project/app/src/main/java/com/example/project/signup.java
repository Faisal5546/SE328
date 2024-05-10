package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.*;

import com.google.android.material.textfield.TextInputEditText;

public class signup extends AppCompatActivity {

    TextInputEditText idEditText;
    TextInputEditText userEditText;
    TextInputEditText passEditText;

    Button signupButton;

    Spinner userTypeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        idEditText = findViewById(R.id.userId);
        userEditText = findViewById(R.id.userName);
        passEditText = findViewById(R.id.userPass);
        signupButton = findViewById(R.id.signup);

        userTypeSpinner = findViewById(R.id.userType);

        ImageView backImage = findViewById(R.id.back);

        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the current activity to go back to the previous activity
                finish();
            }
        });

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Check if both user and pass EditText fields have text
                String idText = idEditText.getText().toString();
                String userText = userEditText.getText().toString();
                String passText = passEditText.getText().toString();
                boolean hasText = !userText.isEmpty() && !passText.isEmpty() && !idText.isEmpty();

                // Check if something is selected in the spinner
                Spinner userTypeSpinner = findViewById(R.id.userType);
                boolean hasSelection = userTypeSpinner.getSelectedItemPosition() != AdapterView.INVALID_POSITION;

                // Update login button's foreground drawable based on the condition
                if (hasText && hasSelection) {
                    // Set foreground drawable for active state
                    signupButton.setForeground(getResources().getDrawable(R.drawable.signup___active));
                } else {
                    // Set foreground drawable for inactive state
                    signupButton.setForeground(getResources().getDrawable(R.drawable.signup___inactive));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };

        idEditText.addTextChangedListener(textWatcher);
        userEditText.addTextChangedListener(textWatcher);
        passEditText.addTextChangedListener(textWatcher);
    }
}