package com.example.admin.call;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActivityChooserView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=(EditText) findViewById(R.id.edt);
        btn=(Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String phoneno=ed1.getText().toString();
                Intent callIntent =new Intent(Intent.ACTION_CALL);

                callIntent.setData(Uri.parse("tel:"+phoneno));

                Toast.makeText(getBaseContext(),"calling",Toast.LENGTH_SHORT).show();
                if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(getBaseContext(),"please give the call permission",Toast.LENGTH_SHORT).show();
                    requestPermission();
                }
                else {


                    startActivity(callIntent);
                }

            }
        });


    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},1);
    }


}
