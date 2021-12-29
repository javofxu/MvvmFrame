package com.ilop.architecture.data.response.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

import com.ilop.architecture.utils.NetworkUtils;

import java.util.Objects;

public class NetworkStateReceive extends BroadcastReceiver {

    private OnNetworkCallBack mCallBack;

    public void setCallBack(OnNetworkCallBack mCallBack) {
        this.mCallBack = mCallBack;
    }

    public void removeCallBack() {
        mCallBack = null;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Objects.equals(intent.getAction(), ConnectivityManager.CONNECTIVITY_ACTION)) {
            if (mCallBack != null) mCallBack.getNetWorkState(NetworkUtils.getNetworkType());
        }
    }
}
