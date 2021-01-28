package com.yello.task.receiver;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class MainActivity extends AppCompatActivity {
    UserReceiverFromMiddleMan userReceiverFromMiddleMan = new UserReceiverFromMiddleMan();
    TextView usersNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Backendless.initApp(this, "1CCE9B85-A216-7E72-FFDA-DBD023A03A00",
                "CF905AA3-73C0-40DC-9EB3-49CDB6BBD86E");
        Backendless.Data.of(User.class)
                .getObjectCount(new AsyncCallback<Integer>() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void handleResponse(Integer response) {
                        usersNum = findViewById(R.id.currentNum);
                        usersNum.setText("total Users in the Database is : " + response.toString());
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                    }
                });

        setContentView(R.layout.activity_main);
        IntentFilter filter = new IntentFilter("com.yello.task.emitter");
        registerReceiver(userReceiverFromMiddleMan, filter);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(userReceiverFromMiddleMan);
    }

    public void validateBtn(View view) {
        Backendless.Data.of(User.class)
                .getObjectCount(new AsyncCallback<Integer>() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void handleResponse(Integer response) {
                        usersNum.setText("total Users in the Database is : " + response.toString());
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                    }
                });
    }
}