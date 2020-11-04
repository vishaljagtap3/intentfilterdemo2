package in.bitcode.intentfilterdemo2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private EditText mEdtFilePath;
    private Button mBtnShowImage, mBtnShowImageInGal;
    private Button mBtnAudio, mBtnVideo, mBtnWeb, mBtnCallPhone, mBtnShare, mBtnPickImage;
    private ImageView mImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.setVmPolicy(
                new StrictMode.VmPolicy.Builder().build()
        );

        mBtnShowImage = findViewById(R.id.btnShowImage);
        mEdtFilePath = findViewById(R.id.edtFilePath);
        mBtnShowImageInGal = findViewById(R.id.btnShowImageInGal);
        mBtnAudio = findViewById(R.id.btnAudio);
        mBtnVideo = findViewById(R.id.btnVideo);
        mBtnCallPhone = findViewById(R.id.btnCallPhone);
        mBtnWeb = findViewById(R.id.btnWeb);
        mBtnShare = findViewById(R.id.btnShare);
        mBtnPickImage = findViewById(R.id.btnPickImage);
        mImg = findViewById(R.id.img);


        mBtnShowImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Intent intent = new Intent("in.bitcode.media.image.VIEW");
                Intent intent = new Intent();
                intent.setAction("in.bitcode.media.image.VIEW");
                intent.addCategory("in.bitcode.type.EDU");
                intent.setDataAndType(
                        Uri.parse(mEdtFilePath.getText().toString()),
                        "image/jpg"
                );
                //intent.putExtra("path", mEdtFilePath.getText().toString());
                startActivity(intent);

            }
        });

        mBtnShowImageInGal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(
                        Uri.parse(mEdtFilePath.getText().toString()),
                        "image/jpg"
                );
                startActivity(intent);
            }
        });

        mBtnAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(
                        Uri.parse(mEdtFilePath.getText().toString()),
                        "audio/mp3"
                );
                startActivity(intent);
            }
        });

        mBtnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(
                        Uri.parse(mEdtFilePath.getText().toString()),
                        "video/mp4"
                );
                startActivity(intent);
            }
        });

        mBtnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(mEdtFilePath.getText().toString()));
                startActivity(intent);
            }
        });

        mBtnCallPhone.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(Intent.ACTION_DIAL);
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel://" + mEdtFilePath.getText().toString()));
                startActivity(intent);
            }
        });


        mBtnShare.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(Intent.ACTION_DIAL);
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setDataAndType(
                        Uri.parse(mEdtFilePath.getText().toString()),
                        "image/jpg"
                );
                startActivity(intent);
            }
        });


        mBtnPickImage.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data != null) {
            mImg.setImageURI(data.getData());
            Log.e("tag", data.getData().toString());
        }
    }
}