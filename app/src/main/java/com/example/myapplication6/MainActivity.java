package com.example.myapplication6;

import static android.content.ContentValues.TAG;
import static com.example.myapplication6.Constants.FORM_REQUEST_CODE;
import static com.example.myapplication6.Constants.OPEN_DOCUMENT_REQUEST_CODE;

import static java.nio.file.Files.createDirectory;
import java.io.File;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.provider.MediaStore;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.BreakIterator;
import java.util.Random;



public class MainActivity extends AppCompatActivity {


    EditText SendValue;
    Button SendEditTextValue;
    Intent intent;

    private ImageView imageView;
    private Button button_photo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SendEditTextValue = (Button)findViewById(R.id.button);
        SendValue = (EditText)findViewById(R.id.exit_text);

        SendEditTextValue.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                intent = new Intent(getApplicationContext(),AnotherActivity.class);
                intent.putExtra("EdiTtEXTvALUE", SendValue.getText().toString());
                startActivity(intent);

            }
        });
    }




    private int getRandomColor () {
            int color;
            switch (new Random().nextInt(7)) {
                case 1:
                    color = getColor(R.color.black);
                    break;
                case 2:
                    color = getColor(R.color.teal_200);
                    break;
                case 3:
                    color = getColor(R.color.teal_700);
                    break;
                case 4:
                    color = getColor(R.color.white);
                    break;
                case 5:
                    color = getColor(R.color.purple_200);
                    break;
                case 6:
                    color = getColor(R.color.purple_500);
                    break;
                default:
                    color = getColor(R.color.purple_700);
            }
             return color;
        }
    }






