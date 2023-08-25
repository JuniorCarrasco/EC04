package com.junior.ec04;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;
import com.junior.ec04.databinding.ActivityPrincipalBinding;
import com.junior.ec04.fragments.HomeFragment;

public class PrincipalActivity extends AppCompatActivity {
    private ActivityPrincipalBinding binding;//BINDING
    public static String EMAIL = "EMAIL";
    private String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrincipalBinding.inflate(getLayoutInflater());//BINDING
        setContentView(binding.getRoot());//BINDING
        setSession();
        addHomeFragment();
        //binding.fabAddMovie.setOnClickListener(v -> {
        //Snackbar.make(binding.getRoot(),"Add a movie",Snackbar.LENGTH_SHORT).show();
        //});
    }

    private void addHomeFragment() {
        getSupportFragmentManager()
                .beginTransaction().add(binding.fcvMain.getId(), new HomeFragment()).commit();

    }

    private void setSession() {
        Intent getIntent = getIntent();
        email = ((Intent) getIntent).getStringExtra(EMAIL);
        binding.txtEmail.setText(email);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.movies_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.search ){
            Snackbar.make(binding.getRoot(),"Search",Snackbar.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.settings) {
            Snackbar.make(binding.getRoot(),"Settings",Snackbar.LENGTH_SHORT).show();
            return true;
        } else {
            return false;
        }
    }


}