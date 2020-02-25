package com.fsociety.reproductoresteso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterFormActivity extends AppCompatActivity {
    private EditText editTextUser;
    private EditText editTextPassword;
    private EditText editTextConfrimPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_form);
        editTextUser=(EditText)findViewById(R.id.editTextUser);
        editTextPassword=(EditText)findViewById(R.id.editTextPass);
        editTextConfrimPassword=(EditText)findViewById(R.id.editTextConfirmPass);

    }

    public void signUp(View view){
        if(editTextUser.getText().toString().isEmpty()&&editTextPassword.getText().toString().isEmpty()&&editTextConfrimPassword.getText().toString().isEmpty()){
            Toast.makeText(this,"Ingrese los datos correspondientes",Toast.LENGTH_SHORT).show();
            return;
        }
        if(!editTextPassword.getText().toString().equals(editTextConfrimPassword.getText().toString())){
            Toast.makeText(this,"Las contraseñas no coinciden",Toast.LENGTH_SHORT).show();
            editTextPassword.setText("");
            editTextConfrimPassword.setText("");
            return;
        }
        AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this,"admi",null,1);
        SQLiteDatabase database=admin.getWritableDatabase();
        ContentValues newUser=new ContentValues();
        newUser.put("username",editTextUser.getText().toString());
        newUser.put("password",editTextPassword.getText().toString());
        database.insert("users",null,newUser);
        database.close();
        Toast.makeText(this,"Registro Exitoso",Toast.LENGTH_LONG).show();
        finish();
    }

    public void goBackLogin(View view){
        finish();
    }
}
