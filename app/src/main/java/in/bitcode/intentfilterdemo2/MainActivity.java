package in.bitcode.intentfilterdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mEdtFilePath;
    private Button mBtnShowImage, mBtnShowImageInGal;

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

    }
}