package com.example.project1;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static android.provider.MediaStore.ACTION_IMAGE_CAPTURE;

public class MainActivity extends AppCompatActivity {

     public static final int camera_request=9999;
     ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=(ImageView)findViewById(R.id.imageView2);
    }

    public void camera(View view)
    {
       Intent intent=new Intent(ACTION_IMAGE_CAPTURE);
       startActivityForResult(intent,camera_request);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==camera_request)
        {
          Bitmap bitmap= (Bitmap)data.getExtras().get("data");
          imageView.setImageBitmap(bitmap);
        }
    }
}
