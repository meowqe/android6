package com.example.myapplication6;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import static android.content.ContentValues.TAG;
import static com.example.myapplication6.Constants.FORM_REQUEST_CODE;
import static com.example.myapplication6.Constants.OPEN_DOCUMENT_REQUEST_CODE;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


public class AnotherActivity extends Activity {


    TextView receive;
    TextView receive2;
    Button btnCam;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.another_activity);
        receive = (TextView) findViewById(R.id.some_text);
        receive.setText(getIntent().getStringExtra("EdiTtEXTvALUE"));

        imageView = findViewById(R.id.cameramen);
        btnCam = findViewById(R.id.button_camera);

        if (ContextCompat.checkSelfPermission(AnotherActivity.this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(AnotherActivity.this, new String[]{
                    Manifest.permission.CAMERA
            },
            100);
        }

        btnCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 100);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100) {
            Bitmap captureImage = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(captureImage);
        }
    }

}








