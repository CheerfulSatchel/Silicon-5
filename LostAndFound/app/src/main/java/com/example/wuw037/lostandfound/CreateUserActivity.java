package com.example.wuw037.lostandfound;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateUserActivity extends AppCompatActivity {

    EditText createUserName, createUserEmail, createUserPassword, createUserPhone;

    private FirebaseAuth mAuth;
    private DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        createUserName = (EditText) findViewById(R.id.create_user_name);
        createUserEmail = (EditText) findViewById(R.id.create_user_email);
        createUserPassword = (EditText) findViewById(R.id.create_user_password);
        createUserPhone = (EditText) findViewById(R.id.create_user_phone);

        mAuth = FirebaseAuth.getInstance();
        mRef = FirebaseDatabase.getInstance().getReference("users");
    }

    public void CreateNewAccount(View v) {
        final String name = createUserName.getText().toString();
        final String email = createUserEmail.getText().toString();
        final String password = createUserPassword.getText().toString();
        final String phone = createUserPhone.getText().toString();

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(!task.isSuccessful()) {
                    //Notify users if email is already registered
                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                        Toast.makeText(CreateUserActivity.this,
                                "User with this email already exists.",
                                Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(CreateUserActivity.this, "Unable to sign up.",
                                Toast.LENGTH_LONG).show();
                    }
                }

                else {
                    String createdUserUid = mAuth.getCurrentUser().getUid() + "";

                    User newUser = new User(name, email, password, phone);

                    mRef.child(createdUserUid).setValue(newUser);

                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    finish();
                }
            }
        });
    }
}
