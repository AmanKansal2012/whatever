package com.example.whatever;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;




        import android.app.ActivityOptions;
        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Pair;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.RelativeLayout;
        import android.widget.TextView;

        import androidx.appcompat.app.AppCompatActivity;

public class AboutD extends AppCompatActivity {
    private RelativeLayout mlayout;
    private TextView mtextview;
    private TextView ntextview;
    private ImageView doctor_image;
    private RelativeLayout mlayout1, mlayout2, mlayout3, mlayout4, mlayout5;
    private TextView mtextview1;
    private TextView ntextview1;
    private ImageView doctor_image1, getDoctor_image2, getDoctor_image3, getDoctor_image4, getDoctor_image5;
    private TextView mtextview2, ntextview2, mtextview3, ntextview3, mtextview4, ntextview4, mtextview5, ntextview5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_d);
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


        mlayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                Intent intent = new Intent(AboutD.this, Profile2.class);
                Pair[] pairs = new Pair[3];
                pairs[0] = new Pair<View, String>(doctor_image1, "imageTransition");
                pairs[1] = new Pair<View, String>(mtextview1, "nameTransition");
                pairs[2] = new Pair<View, String>(ntextview1, "descTransition");


                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(AboutD.this, pairs);


                startActivity(intent, options.toBundle());

            }
        });
        mlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutD.this, Profile1.class);
                Pair[] pairs = new Pair[3];
                pairs[0] = new Pair<View, String>(doctor_image, "imageTransition");
                pairs[1] = new Pair<View, String>(mtextview, "nameTransition");
                pairs[2] = new Pair<View, String>(ntextview, "descTransition");


                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(AboutD.this, pairs);


                startActivity(intent, options.toBundle());
            }
        });


        mlayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(AboutD.this, Profile3.class);
                Pair[] pairs = new Pair[3];
                pairs[0] = new Pair<View, String>(getDoctor_image2, "imageTransition");
                pairs[1] = new Pair<View, String>(mtextview2, "nameTransition");
                pairs[2] = new Pair<View, String>(ntextview2, "descTransition");


                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(AboutD.this, pairs);


                startActivity(intent, options.toBundle());

            }
        });
        mlayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutD.this, Profile4.class);
                Pair[] pairs = new Pair[3];
                pairs[0] = new Pair<View, String>(getDoctor_image3, "imageTransition");
                pairs[1] = new Pair<View, String>(mtextview3, "nameTransition");
                pairs[2] = new Pair<View, String>(ntextview3, "descTransition");


                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(AboutD.this, pairs);


                startActivity(intent, options.toBundle());
            }
        });







    }


}
