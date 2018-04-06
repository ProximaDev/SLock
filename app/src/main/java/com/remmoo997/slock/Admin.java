package com.remmoo997.slock;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Admin extends DeviceAdminReceiver {


    @Override
    public void onDisabled(Context context, Intent intent) {
        super.onDisabled(context, intent);
        Toast.makeText(context, context.getString(R.string.disabled), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEnabled(Context context, Intent intent) {
        super.onEnabled(context, intent);
        Toast.makeText(context, context.getString(R.string.enabled), Toast.LENGTH_SHORT).show();
    }

}
