package com.example.bmiapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BMI extends AppCompatActivity {

    android.widget.Button mrecalculatebmi;

    TextView mbmidisplay,mbmicategory,mgender;
    Intent intent;
    ImageView mimageview;
    String mbmi;
    float intbmi;

    String height;
    String weight;
    float intheight, intweight;
    RelativeLayout mbackground;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_i);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"</font>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);


        intent=getIntent();

        mbmidisplay=findViewById(R.id.bmidisplay);
        mbmicategory=findViewById(R.id.bmicategory);
        mgender=findViewById(R.id.genderdisplay);
        mbackground=findViewById(R.id.contentlayout);
        mimageview=findViewById(R.id.imageview);
        mrecalculatebmi=findViewById(R.id.recalculatebmi);



        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");

        intheight=Float.parseFloat(height);
        intweight=Float.parseFloat(weight);

        intheight=intheight/100;

        intbmi=intweight/(intheight*intheight);

        mbmi=Float.toString(intbmi);

         if(intbmi<18.4)
        {
            mbmicategory.setText("Underweight");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }
        else if(intbmi<24.9 && intbmi>18.5)
        {
            mbmicategory.setText("Normal");
            mbackground.setBackgroundColor(Color.GREEN);
            mimageview.setImageResource(R.drawable.ok);
        }
        else if(intbmi<29.9 && intbmi>25)
        {
            mbmicategory.setText("Overweight");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }
        else if(intbmi<34.9 && intbmi>30)
        {
            mbmicategory.setText("Moderately Obese");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }
        else if(intbmi<39.9 && intbmi>35)
        {
            mbmicategory.setText("Severely Obese");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }
        else {
            mbmicategory.setText("Very Severely Obese");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }


        mgender.setText(intent.getStringExtra("gender"));
        mbmidisplay.setText(mbmi);

        mrecalculatebmi=findViewById(R.id.recalculatebmi);

        mrecalculatebmi.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                Intent intent= new Intent(BMI.this,MainActivity.class);
                startActivity(intent);
                finish() ;

            }

        });

    }
}