package com.example.myqr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) { //  main 매소드
        super.onCreate(savedInstanceState); // onCreate 매소드를 호출 -> 실행 -> 오버라이드된 매소드 처리
        // setContentView(R.layout.activity_main);
        new IntentIntegrator(this).initiateScan(); // 객체를 통해 화면을 스캔 (qr 리더기 생성)
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) { // result 널이 아니면
            if (result.getContents() == null) { // null이면 Cancelled 출력 함.
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
                // todo
            } else { // null이 아니면 결과값 출력
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                // todo
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}