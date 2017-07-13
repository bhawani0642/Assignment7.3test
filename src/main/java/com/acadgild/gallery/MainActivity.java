package com.acadgild.gallery;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView Txt;
private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Txt= (ImageView) findViewById(R.id.imageView);
         imageView= (ImageView) findViewById(R.id.imageView);
    }

    public void ClickMe(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, 100);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && resultCode == RESULT_OK) {
            Uri uri= data.getData();

            Toast.makeText(this, "Captured sucessfully", Toast.LENGTH_LONG);


            Bitmap map=(Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(map);
        } else {

            Toast.makeText(this, "Failed to capture", Toast.LENGTH_LONG);

        }
    }
}