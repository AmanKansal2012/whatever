package com.example.whatever;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


        import android.widget.ImageView;
        import android.widget.RelativeLayout;
        import android.widget.TextView;


public class hospital extends AppCompatActivity {
    RelativeLayout mlayout;
    TextView mtextview;
    TextView ntextview;
    ImageView doctor_image;
    RelativeLayout mlayout1, mlayout2, mlayout3, mlayout4, mlayout5;
    TextView mtextview1;
    TextView ntextview1;
    ImageView doctor_image1, getDoctor_image2, getDoctor_image3, getDoctor_image4, getDoctor_image5;
    TextView mtextview2, ntextview2, mtextview3, ntextview3, mtextview4, ntextview4, mtextview5, ntextview5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);
        mlayout = findViewById(R.id.doctor_view);
        mtextview = findViewById(R.id.txt_name);
        ntextview = findViewById(R.id.doctor_desc);
        doctor_image = findViewById(R.id.doctor_image);
        mlayout1 = findViewById(R.id.doctor_view1);
        mtextview1 = findViewById(R.id.txt_name1);
        ntextview1 = findViewById(R.id.doctor_desc1);
        doctor_image1 = findViewById(R.id.doctor_image1);
        mlayout2 = findViewById(R.id.doctor_view2);
        mtextview2 = findViewById(R.id.txt_name2);
        ntextview2 = findViewById(R.id.doctor_desc2);
        getDoctor_image2 = findViewById(R.id.doctor_image2);
        mlayout3 = findViewById(R.id.doctor_view3);
        mtextview3 = findViewById(R.id.txt_name3);
        ntextview3 = findViewById(R.id.doctor_desc3);
        getDoctor_image3 = findViewById(R.id.doctor_image3);
        mlayout4 = findViewById(R.id.doctor_view4);
        mtextview4 = findViewById(R.id.txt_name4);
        ntextview4 = findViewById(R.id.doctor_desc4);
        getDoctor_image4 = findViewById(R.id.doctor_image4);
        mlayout5 = findViewById(R.id.doctor_view5);
        mtextview5 = findViewById(R.id.txt_name5);
        ntextview5 = findViewById(R.id.doctor_desc5);
        getDoctor_image5 = findViewById(R.id.doctor_image5);



    }


}
