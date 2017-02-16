package apidez.com.lab1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import apidez.com.lab1.R;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText tvEmail;
    private EditText tvPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        tvEmail = (EditText) findViewById(R.id.edtEmail);
        tvPassword = (EditText) findViewById(R.id.edtPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Email: " + tvEmail.getText().toString()
                + "Password: " + tvPassword.getText().toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, StreamActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
