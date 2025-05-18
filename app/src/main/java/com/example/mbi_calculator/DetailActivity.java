package com.example.mbi_calculator;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mbi_calculator.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.detailLowText.setTypeface(null, Typeface.NORMAL);
        binding.detailMediumText.setTypeface(null, Typeface.NORMAL);
        binding.detailHighText.setTypeface(null, Typeface.NORMAL);

        Intent intent = getIntent();
        BMIResult bmiResult = (BMIResult) intent.getSerializableExtra("EXTRA_BMI_RESULT");
        if(bmiResult != null) {
            BMIResult.BMICategory cat = bmiResult.getBMICategory();
            if(cat == BMIResult.BMICategory.UNDERNUTRITION)
                binding.detailLowText.setTypeface(null, Typeface.BOLD);
            else if(cat == BMIResult.BMICategory.OBESITY)
                binding.detailHighText.setTypeface(null, Typeface.BOLD);
            else
                binding.detailMediumText.setTypeface(null, Typeface.BOLD);
        }
    }
    public void GoHomeBtn(View view) {
        Intent detailIntent = new Intent(this, MainActivity.class);

        startActivity(detailIntent);
    }
}