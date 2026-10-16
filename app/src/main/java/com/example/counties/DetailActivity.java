package com.example.counties;

import android.os.Build;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_COUNTY = "EXTRA_COUNTY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.detail_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageButton btnBack = findViewById(R.id.btn_back);
        MaterialButton btnBackBottom = findViewById(R.id.btn_back_bottom);
        TextView tvCode = findViewById(R.id.detail_tv_code);
        TextView tvIcon = findViewById(R.id.detail_tv_icon);
        TextView tvName = findViewById(R.id.detail_tv_name);
        TextView tvRegion = findViewById(R.id.detail_tv_region);
        TextView tvCapital = findViewById(R.id.detail_tv_capital);
        TextView tvPopulation = findViewById(R.id.detail_tv_population);
        TextView tvEconomy = findViewById(R.id.detail_tv_economy);
        TextView tvDescription = findViewById(R.id.detail_tv_description);

        btnBack.setOnClickListener(v -> finish());
        btnBackBottom.setOnClickListener(v -> finish());

        County county = null;
        if (getIntent() != null && getIntent().hasExtra(EXTRA_COUNTY)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                county = getIntent().getSerializableExtra(EXTRA_COUNTY, County.class);
            } else {
                county = (County) getIntent().getSerializableExtra(EXTRA_COUNTY);
            }
        }

        if (county != null) {
            tvCode.setText(getString(R.string.county_code_format, county.getCode()));
            tvIcon.setText(county.getIconEmoji());
            tvName.setText(county.getName());
            tvRegion.setText(county.getRegion());
            tvCapital.setText(getString(R.string.capital_format, county.getCapital()));
            tvPopulation.setText(getString(R.string.population_format, county.getPopulation()));
            tvEconomy.setText(getString(R.string.economy_format, county.getMainEconomy()));
            tvDescription.setText(county.getDescription());
        }
    }
}