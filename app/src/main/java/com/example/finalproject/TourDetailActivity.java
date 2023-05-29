package com.example.finalproject;

import static java.lang.Math.sqrt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TourDetailActivity extends AppCompatActivity {
    ImageView imgTour;
    TextView nameTour, descTour, priceTour;
    Button btnPay ;
    ImageButton btnLoc;
    Integer KeyImageTour;
    String KeyNameTour,KeyPriceTour,KeyDescTour,sentNameTour,sentPriceTour;
    SharedPreferences preferences;
    Intent checkLocIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_detail);
        preferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        imgTour = findViewById(R.id.imgTour);
        nameTour = findViewById(R.id.nameTour);
        descTour = findViewById(R.id.descTour);
        priceTour = findViewById(R.id.priceTour);
        btnPay = findViewById(R.id.btnPay);
        btnLoc = findViewById(R.id.btnLoc);

        KeyImageTour=getIntent().getIntExtra("image",1);
        KeyNameTour=getIntent().getStringExtra("cityName");
        KeyPriceTour=getIntent().getStringExtra("cityPrice");
        KeyDescTour=getIntent().getStringExtra("cityDesc");

        nameTour.setText(KeyNameTour);
        priceTour.setText(KeyPriceTour);
        imgTour.setImageResource(KeyImageTour);
        descTour.setText(KeyDescTour);
        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sentNameTour=nameTour.getText().toString();
                sentPriceTour=priceTour.getText().toString();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("nameTour",sentNameTour);
                editor.putString("priceTour",sentPriceTour);

                editor.commit();
                Intent outIntent=new Intent(TourDetailActivity.this,ReceiptActivity.class);
                startActivity(outIntent);
            }

        });
        btnLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkLocIntent=new Intent(TourDetailActivity.this,fragLocation.class);
                startActivity(checkLocIntent);
            }
        });
    }

}