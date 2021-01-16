package com.example.mangarock.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mangarock.R;

public class LoginActivity extends AppCompatActivity {
    EditText user;
    EditText pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login2= (Button) findViewById(R.id.btnlogin2);
        user=(EditText) findViewById(R.id.txtuser);
        pw=(EditText) findViewById(R.id.txtpw);
        login2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, BottomNavigation.class));
                Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

                validate(user.getText().toString(),pw.getText().toString());

            }
        });


        }
            private void validate(String username, String password)
            {
//                if((username.equals("admin"))&& (password.equals("1234")))
//                {
//                    startActivity(new Intent(LoginActivity.this, AdminDash.class));
//                    Toast.makeText(LoginActivity.this, "Welcome admin", Toast.LENGTH_SHORT).show();
//                }

//                if(TextUtils.isEmpty(username)) {
//                    user.setError("Please fill out this form.");
//                    return;
//                }
//                if(TextUtils.isEmpty(password)) {
//                    pw.setError("Please fill out this form.");
//                    return;
//                }

//                    startActivity(new Intent(LoginActivity.this, BottomNavigation.class));
//                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

            }

        }

