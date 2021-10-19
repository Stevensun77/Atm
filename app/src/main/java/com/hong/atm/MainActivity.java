package com.hong.atm;

import static android.content.ContentValues.TAG;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends AppCompatActivity {
//    private static final int REQUEST_LOGIN = 100;
    boolean login = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (!login) {
            Intent intent = new Intent(this, LoginActivity.class);
            launcher.launch(intent);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() != RESULT_OK) {
//                        Log.d(TAG, "RESULT OK");
                        finish();
                    }
                }
            }
    );

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == REQUEST_LOGIN) {
//            if (resultCode != RESULT_OK) {
//                finish();
//            }
//        }
//    }
}