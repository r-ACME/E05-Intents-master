package com.example.e05_intents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static int PHOTO_CODE = 1;
    private int EDIT = 1;
    private int SCANNER_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imgProfile = findViewById(R.id.img_profile);

        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(EDIT == 1) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, PHOTO_CODE);
                }

                if(EDIT == 0){
                    imgProfile.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
            }
        });

        EditText txtName = findViewById(R.id.txt_name);

        txtName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(EDIT == 0){

                }
            }
        });

        EditText txtBirthday = findViewById(R.id.txt_birthday);

        txtBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        EditText txtEmail = findViewById(R.id.txt_email);

        txtEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (EDIT == 0){
                    Uri uri = Uri.parse("mailto:" + txtEmail.getText().toString());
                    Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Contato");
                    startActivity(intent);
                }
            }
        });

        EditText txtPhone = findViewById(R.id.txt_phone);

        txtPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(EDIT == 0){
                    Uri uri = Uri.parse("tel:" + txtPhone.getText().toString());
                    Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                    startActivity(intent);
                }
            }
        });

        Button btnEdit = findViewById(R.id.btn_edit);
        Button btnSave = findViewById(R.id.btn_save);
        Button btnScanner = findViewById(R.id.btn_scanner);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EDIT = 1;
                imgProfile.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 900));
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EDIT = 0;
                imgProfile.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 300));

            }
        });

        btnScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.google.zxing.client.android.SCAN");
                startActivityForResult(intent, SCANNER_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PHOTO_CODE && resultCode == Activity.RESULT_OK){
            Bitmap photo = (Bitmap) data.getExtras().get("data");

            ImageView imgProfile = findViewById(R.id.img_profile);
            imgProfile.setImageBitmap(photo);
        }

        if(requestCode == SCANNER_CODE && resultCode == Activity.RESULT_OK){
            String contents = data.getStringExtra("SCAN_RESULT");
            String format = data.getStringExtra("SCAN_RESULT_FORMAT");
            TextView lbl_code = findViewById(R.id.lbl_code);
            lbl_code.setText(contents);
        }
    }
}