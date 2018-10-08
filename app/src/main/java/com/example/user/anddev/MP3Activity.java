package com.example.user.anddev;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MP3Activity extends AppCompatActivity {
    private MediaPlayer mp = null;
    private Button btn_3 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp3);
        btn_3 = findViewById(R.id.btn_3);
    }

    public void clkBtn(View v) {
        Log.i("test", "clkBtn : " + v.getId());

        switch (v.getId()) {
            case R.id.btn_1:
                _doStop();
                mp = MediaPlayer.create(MP3Activity.this, R.raw.adult);
                mp.start();
                Toast.makeText(MP3Activity.this, "adult", Toast.LENGTH_SHORT).show();
                btn_3.setText(R.string.pause);
                break;

            case R.id.btn_2:
                _doStop();
                mp = MediaPlayer.create(MP3Activity.this, R.raw.moonmoon);
                mp.start();
                Toast.makeText(MP3Activity.this, "marry", Toast.LENGTH_SHORT).show();
                btn_3.setText(R.string.pause);
                break;

            case R.id.btn_3:
                if (mp == null) {
                    return;
                }

                Button btn = (Button) v;
                String txt = btn.getText().toString();

                if (txt.equals(getString(R.string.pause))) {//음악 재생 중
                    btn.setText(R.string.play);//재생
                    //일시정지 시킴
                    mp.pause();
                } else { //음악 일시 정지 중
                    btn.setText(R.string.pause);//일시정지
                    //재생 시킴
                    mp.start();
                }
                break;

            case R.id.btn_4:
                _doStop();
                btn_3.setText(R.string.pause);
                break;
        }
    }

    private void _doStop() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }
}