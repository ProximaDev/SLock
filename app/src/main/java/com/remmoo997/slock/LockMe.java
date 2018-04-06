package com.remmoo997.slock;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.widget.Toast;

public class LockMe extends Activity {
    private static final String TAG = LockMe.class.getSimpleName();
    private DevicePolicyManager DevicePolicy;
    private ComponentName ComponentName;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == -1)
            DevicePolicy.lockNow();
        else
            Toast.makeText(this, getString(R.string.fail), Toast.LENGTH_SHORT).show();

        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DevicePolicy = (DevicePolicyManager) getSystemService(DEVICE_POLICY_SERVICE);
        ComponentName = new ComponentName(this,Admin.class);

        if (DevicePolicy.isAdminActive(ComponentName)) {
            DevicePolicy.lockNow();
            finish();
        } else {
            Intent intent = new Intent("android.app.action.ADD_DEVICE_ADMIN");
            intent.putExtra("android.app.extra.DEVICE_ADMIN", ComponentName);
            intent.putExtra("android.app.extra.ADD_EXPLANATION", getString(R.string.AdminMsg));
            startActivityForResult(intent, 0);
        }
        Process.killProcess(Process.myPid());

    }
}
