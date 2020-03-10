package com.example.user.heroapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TujuanActivity extends AppCompatActivity {
    private TextView nama, detail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tujuan);
        nama = findViewById(R.id.nama);
        detail = findViewById(R.id.detail);
        Bundle bundle = getIntent().getExtras();
        String nameHero = bundle.getString("name");
        String detailHero = bundle.getString("detail");
        nama.setText(nameHero);
        detail.setText(detailHero);
    }
}
