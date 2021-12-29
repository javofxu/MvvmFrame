
package com.ilop.architecture.data.response.manager;

import android.content.IntentFilter;
import android.net.ConnectivityManager;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

import com.ilop.architecture.utils.Utils;

public class NetworkStateManager implements DefaultLifecycleObserver {

    private static final NetworkStateManager S_MANAGER = new NetworkStateManager();
    private NetworkStateReceive mNetworkStateReceive;
    private OnNetworkCallBack mCallBack;

    private NetworkStateManager() {
    }

    public static NetworkStateManager getInstance() {
        return S_MANAGER;
    }

    public void setCallBack(OnNetworkCallBack mCallBack) {
        this.mCallBack = mCallBack;
    }

    @Override
    public void onStart(@NonNull LifecycleOwner owner) {
        mNetworkStateReceive = new NetworkStateReceive();
        mNetworkStateReceive.setCallBack(mCallBack);
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        Utils.getApp().getApplicationContext().registerReceiver(mNetworkStateReceive, filter);
    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {
        Utils.getApp().getApplicationContext().unregisterReceiver(mNetworkStateReceive);
    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
        mNetworkStateReceive.removeCallBack();
        mCallBack = null;
    }
}
