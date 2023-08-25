package com.junior.ec04;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.junior.ec04.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnGetStarted.setOnClickListener(v -> {
            //Toast.makeText(this, "Presiono el boton", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish(); //Para no dar atras
        });
        binding.txtMoviewPhrase.setText("Mira tu pelicula \nfavorita.");
        binding.btnGetStarted.setText("Presiona boton");

        //setContentView(R.layout.activity_main);

        // btnGetStarted = findViewById(R.id.btn_get_started);
        //btnGetStarted.setOnClickListener(v -> {
        //    Toast.makeText(this, "Presiono el boton", Toast.LENGTH_LONG).show();
        //});
    }
}