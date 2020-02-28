package com.fsociety.reproductoresteso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private boolean userInSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextUsername=(EditText)findViewById(R.id.editTextUsername);
        editTextPassword=(EditText)findViewById(R.id.editTextPassword);
        SharedPreferences prefe = getSharedPreferences("userSesion", Context.MODE_PRIVATE);
        userInSesion = prefe.getBoolean("user",false);
        if(userInSesion){
            Intent i = new Intent(this, ListAlbumActivity.class);
            startActivity(i);
            finish();
        }
    }

    public void login(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "admi", null, 1);
        SQLiteDatabase database=admin.getWritableDatabase();
        String query="select * from users where username='"+editTextUsername.getText().toString()+"'"+ "and password='"+editTextPassword.getText().toString()+"'";
        Cursor row=database.rawQuery(query,null);
        if(row.moveToFirst()){
            SharedPreferences myShared = getSharedPreferences("userSesion",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = myShared.edit();
            editor.putBoolean("user",true);
            editor.apply();
            Toast.makeText(this,"Iniciando",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,ListAlbumActivity.class);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(this,"Usuario incorrecto",Toast.LENGTH_SHORT).show();
        }
        cleanField();
        database.close();
    }

    public void goToSignUp(View view){
        Intent intent=new Intent(this,RegisterFormActivity.class);
        startActivity(intent);
    }

    public void cleanField(){
        editTextUsername.setText("");
        editTextPassword.setText("");
    }
}
