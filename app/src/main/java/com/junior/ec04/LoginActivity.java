package com.junior.ec04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.widget.Toast;

import com.junior.ec04.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding; //BINDING
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Base_Theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); //BINDING

        binding = ActivityLoginBinding.inflate(getLayoutInflater()); //BINDING
        setContentView(binding.getRoot()); //BINDING

        binding.btnLogin.setOnClickListener(v -> {
            if (isCredentialsValidate(binding.titleEmail.getEditText().getText().toString(), binding.tilPassword.getEditText().getText().toString())) {
                Intent intent = new Intent(this, PrincipalActivity.class);
                intent.putExtra(PrincipalActivity.EMAIL, binding.titleEmail.getEditText().getText().toString());
                startActivity(intent);
                finish(); //Para no dar atrás
            } else {
                Toast.makeText(this, "Datos incorrectos. Por favor, intenta nuevamente.", Toast.LENGTH_LONG).show();
            }
        });
        binding.titleEmail.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                boolean isOk = isCredentialsValidate(s.toString(),binding.tilPassword.getEditText().getText().toString());
                binding.btnLogin.setEnabled(isOk);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.tilPassword.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int before) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                boolean isOk = isCredentialsValidate(binding.titleEmail.getEditText().getText().toString(), s.toString());
                binding.btnLogin.setEnabled(isOk);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });
    }

    private Boolean isCredentialsValidate(String email, String password){
        boolean isEmailOk = email.equals("ejemploe@idat.com.pe") && Patterns.EMAIL_ADDRESS.matcher(email).matches();
        boolean isPasswordOk = password.equals("Peru123");

        return isEmailOk && isPasswordOk;
    }
}