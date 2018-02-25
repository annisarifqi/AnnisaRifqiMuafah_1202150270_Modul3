package id.web.annisa.annisarifqimuafah_1202150270_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    // inisiasi username, password, dan button
    private EditText mUsername, mPassword;
    private Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsername = (EditText) findViewById(R.id.editTextUsername);//memanggil id username dari layout LoginActivity
        mPassword = (EditText) findViewById(R.id.editTextPassword);//memanggil id passord dari layout LoginActivity
        mLogin = (Button) findViewById(R.id.buttonLogin);//memanggil id button dari layout LoginActivity

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mUsername.getText().toString();//mengubah tipe data ke string
                String pass = mPassword.getText().toString();//mengubah tipe data ke string

                if((user.equals("EAD") && pass.equals("MOBILE"))){//inisiasi username & password statik
                    Toast.makeText(LoginActivity.this, "Berhasil Login",Toast.LENGTH_LONG).show();//memunculkan toast
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);//menuju activity selanjutnya
                    startActivity(intent);
                }else {
                   Toast.makeText(LoginActivity.this, "Gagal Login",Toast.LENGTH_SHORT).show();//toast saat username dan password salah
        };
    }});

}
}






