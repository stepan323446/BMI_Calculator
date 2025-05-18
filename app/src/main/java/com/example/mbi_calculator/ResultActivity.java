package com.example.mbi_calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mbi_calculator.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity {

    private ActivityResultBinding binding;
    private BMIResult bmiResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityResultBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        bmiResult = (BMIResult) intent.getSerializableExtra("EXTRA_BMI_RESULT");
        assert bmiResult != null;
        binding.nameText.setText(bmiResult.getUserInfo());
        binding.categoryBMIResult.setText(bmiResult.getBMICategoryString() + "(" + String.format("%.2f", bmiResult.getBMIValue())  + ")");
    }

    public void DetailBtn(View view) {
        Intent detailIntent = new Intent(this, DetailActivity.class);

        detailIntent.putExtra("EXTRA_BMI_RESULT", bmiResult);

        startActivity(detailIntent);

        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}