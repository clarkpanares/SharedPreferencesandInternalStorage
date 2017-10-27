package com.panares.labexer10262017;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText et_username;
    EditText et_password;
    Button btn_save1;
    SharedPreferences preferences;
    Button btn_save2;
    FileOutputStream fos;
    Context c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_username = (EditText) findViewById(R.id.editText2);
        et_password = (EditText) findViewById(R.id.editText3);
        btn_save1 = (Button) findViewById(R.id.button);
        btn_save2 = (Button) findViewById(R.id.button2);
        preferences = (getPreferences(Context.MODE_PRIVATE));

    }

    public void saveInfo(View view){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", et_username.getText().toString());
        editor.putString("password", et_password.getText().toString());
        editor.commit();
        Toast.makeText(this, "Data Saved!", Toast.LENGTH_SHORT).show();

    }

    public void savemessage (View view) {
        String message1 = " " + et_username.getText().toString() + " ";
        String message2 = " " + et_password.getText().toString() + " ";
        try {
            fos = openFileOutput("output.txt", Context.MODE_PRIVATE);
            fos.write(message1.getBytes());
            fos.write(message2.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        Toast.makeText(this, "Message saved!", Toast.LENGTH_SHORT).show();
    }

    public void nextActivity(View view)
    {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);

    }
}
