package com.yello.task.receiver;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;

import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyTag";
    UserReceiverFromMiddleMan userReceiverFromMiddleMan = new UserReceiverFromMiddleMan();
    TextView usersNum, usersText;
    ListView currUsersInDBLV;
    List<String> currUsersInDBNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Backendless.initApp(this, "1CCE9B85-A216-7E72-FFDA-DBD023A03A00",
                "CF905AA3-73C0-40DC-9EB3-49CDB6BBD86E");
        setContentView(R.layout.activity_main);
        IntentFilter filter = new IntentFilter("com.yello.task.emitter");
        registerReceiver(userReceiverFromMiddleMan, filter);
        currUsersInDBLV = findViewById(R.id.usersList_lv);
        usersText = findViewById(R.id.users);

        Backendless.Data.of(User.class)
                .getObjectCount(new AsyncCallback<Integer>() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void handleResponse(Integer response) {
                        usersNum = findViewById(R.id.currentNum);
                        usersNum.setText( response.toString());
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        Log.i(TAG, "CLOUD RESPONSE ERROR: " + fault.getCode());

                    }
                });
    }


    public void validateBtn(View view) {

        DataQueryBuilder queryBuilder = DataQueryBuilder.create();
        queryBuilder.setPageSize(50);
        Backendless.Persistence.of(User.class).find(queryBuilder, new AsyncCallback<List<User>>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void handleResponse(List<User> allUSers) {

                currUsersInDBLV.setVisibility(View.VISIBLE);
                   // filter Stream on the List of users >> List of user names
                currUsersInDBNames = allUSers.parallelStream().map(User::getName).collect(Collectors.toList());
                Log.i("All users", currUsersInDBNames.toString());
                ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,
                        android.R.layout.simple_list_item_1, currUsersInDBNames);
                currUsersInDBLV.setAdapter(adapter);
            }
            @Override
            public void handleFault(BackendlessFault fault) {
                Log.i(TAG, "CLOUD RESPONSE ERROR: " + fault.getCode());

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(userReceiverFromMiddleMan);
    }

}