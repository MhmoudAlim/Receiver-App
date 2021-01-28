package com.yello.task.receiver;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import org.json.JSONException;
import org.json.JSONObject;

public class UserReceiverFromMiddleMan extends BroadcastReceiver {
    JSONObject userObject;
    User user;


    @Override
    public void onReceive(Context context, Intent intent) {
        if ("com.yello.task.emitter".equals((intent.getAction()))) {
            try {
                userObject = new JSONObject(intent.getStringExtra("com.yello.task.emitter"));

                Toast.makeText(context, "(Receiver App)\nData received, Navigate to the App now!" , Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Hello there \nUser (" + userObject.getString("name")
                        + ")has been received from MiddleMan App\nPersist the received data?")
                        .setPositiveButton("yes", (dialog, which) -> {
                            //creating a new user instance and uploading it to cloud
                            newUserInstance();
                            Intent responseIntent = new Intent();
                            Backendless.Data.of(User.class).save(user, new AsyncCallback<User>() {
                                @Override
                                public void handleResponse(User response) {
                                    Toast.makeText(context, "User : "+ user.getName() + " uploaded to Cloud Successfully"  , Toast.LENGTH_SHORT).show();
                                    responseIntent.setAction("com.yello.task.MiddleMan.response");
                                    responseIntent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                                    responseIntent.putExtra("Status" , "OK xD");
                                    context.sendBroadcast(responseIntent);
                                }

                                @Override
                                public void handleFault(BackendlessFault fault) {
                                    Toast.makeText(context, "error" , Toast.LENGTH_SHORT).show();
                                    responseIntent.setAction("com.yello.task.MiddleMan.response");
                                    responseIntent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                                    responseIntent.putExtra("Status" , "SORRY BUT NOK");
                                    context.sendBroadcast(responseIntent);
                                }
                            });
                        })
                        .setNegativeButton("no", null)
                        .setCancelable(true);
                AlertDialog alert = builder.create();
                alert.show();

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void newUserInstance(){
        user = new User();
        try {
            user.setId(userObject.getInt("id"));
            user.setName(userObject.getString("name"));
            user.setUsername(userObject.getString("username"));
            user.setEmail(userObject.getString("email"));
            user.setAddress_city(userObject.getJSONObject("address").getString("city"));
            user.setAddress_street(userObject.getJSONObject("address").getString("street"));
            user.setAddress_zipcode(userObject.getJSONObject("address").getString("zipcode"));
            user.setAddress_suite(userObject.getJSONObject("address").getString("suite"));
            user.setGeo_lat(userObject.getJSONObject("geo").getString("lat"));
            user.setGeo_lng(userObject.getJSONObject("geo").getString("lng"));
            user.setCompany_name(userObject.getJSONObject("company").getString("name"));
            user.setCompany_catchPhrase(userObject.getJSONObject("company").getString("catchPhrase"));
            user.setCompany_bs(userObject.getJSONObject("company").getString("bs"));
            user.setPhone(userObject.getString("phone"));
            user.setWebsite(userObject.getString("website"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
