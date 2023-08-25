package com.junior.ec04;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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
    private SharedPreferences sharedPreferences;
    private String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrincipalBinding.inflate(getLayoutInflater());//BINDING
        setContentView(binding.getRoot());//BINDING
        setSession();
        addHomeFragment();
        binding.fabAddMovie.setOnClickListener(v -> {
        Snackbar.make(binding.getRoot(),"Add a movie",Snackbar.LENGTH_SHORT).show();
        });
        setSupportActionBar(binding.tbPlayzoom);
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
        if (item.getItemId() == R.id.settings) {
            Snackbar.make(binding.getRoot(), "Settings", Snackbar.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.logout) {
            {
                // Mostrar cuadro de diálogo de confirmación
                new AlertDialog.Builder(this)
                        .setTitle("Cerrar sesión")
                        .setMessage("¿Deseas cerrar la sesión?")
                        .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                sharedPreferences.edit().clear().apply();
                                Intent intent = new Intent(PrincipalActivity.this, LoginActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // No hacer nada, simplemente cerrar el cuadro de diálogo
                            }
                        })
                        .show();

                return true;
            }
        }
        return false;

    }

}