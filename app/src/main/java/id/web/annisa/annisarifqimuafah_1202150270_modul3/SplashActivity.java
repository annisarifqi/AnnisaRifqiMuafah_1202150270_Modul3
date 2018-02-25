package id.web.annisa.annisarifqimuafah_1202150270_modul3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Mengatur letak layout splash
        setContentView(R.layout.activity_splash);
        //mengatur thread saat splash
        Thread thread = new Thread() {
            public void run (){
                try {
                    sleep(4000); //splash selama 4 detik
                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class)); //menuju activity selanjutnya
                    finish();
                }
            }
        };
        thread.start();
    }
}
