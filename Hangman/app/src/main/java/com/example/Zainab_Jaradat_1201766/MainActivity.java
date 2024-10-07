package com.example.Zainab_Jaradat_1201766;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Zainab Application 1201766");

        EditText firstNameEditText = findViewById(R.id.FirstName);
        EditText secondNameEditText = findViewById(R.id.SecondName);
        EditText idNumEditText = findViewById(R.id.idNum);
        Button loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = firstNameEditText.getText().toString().trim();
                String secondName = secondNameEditText.getText().toString().trim();
                String idNum = idNumEditText.getText().toString().trim();

                if (!isValidInput(firstName, secondName, idNum)) {
                    return; // Stop here if the input isn't valid
                }

                // Everything is fine, let's move to the HangmanActivity
                Intent intent = new Intent(MainActivity.this, HangmanActivity.class);
                intent.putExtra("FIRST_NAME", firstName);
                intent.putExtra("SECOND_NAME", secondName);
                intent.putExtra("ID_NUM", idNum);
                MainActivity.this.startActivity(intent);
                finish();
            }
        });
    }

    private boolean isValidInput(String firstName, String secondName, String idNum) {   // This method checks if all the input fields are valid

        if (firstName.isEmpty()) {
            showToast("Please enter your first name.");
            return false;
        }

        if (secondName.isEmpty()) {
            showToast("Please enter your second name.");
            return false;
        }

        if (idNum.isEmpty()) {
            showToast("Please enter your ID number.");
            return false;
        }

        if (!idNum.matches("\\d+")) { // Check if the ID number contains only digits
            showToast("ID number should contain only numbers.");
            return false;
        }
        return true;
    }

    private void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
