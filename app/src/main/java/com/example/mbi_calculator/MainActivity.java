package com.example.mbi_calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mbi_calculator.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

    public void CalculateBMI(View view) {
        String name = binding.nameEditText.getText().toString();
        int age = Integer.parseInt(binding.ageEditText.getText().toString());
        int height = Integer.parseInt(binding.heightEditText.getText().toString());
        int weight = Integer.parseInt(binding.weightEditText.getText().toString());
        BMIResult.Gender gender;

        if(binding.manRadioBtn.isChecked())
            gender = BMIResult.Gender.MAN;
        else if (binding.womanRadioBtn.isChecked())
            gender = BMIResult.Gender.WOMAN;
        else {
            Toast.makeText(this, "You are not chosed your gender", Toast.LENGTH_LONG).show();
            return;
        }

        BMIResult bmiResult = new BMIResult(name, gender, age, height, weight);

        Intent resultIntent = new Intent(this, ResultActivity.class);

        resultIntent.putExtra("EXTRA_BMI_RESULT", bmiResult);

        startActivity(resultIntent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_bar_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.miExit) {
            finishAffinity();
            return true;
        } else if (id == R.id.miDetail) {
            Intent detailIntent = new Intent(this, DetailActivity.class);

            startActivity(detailIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}