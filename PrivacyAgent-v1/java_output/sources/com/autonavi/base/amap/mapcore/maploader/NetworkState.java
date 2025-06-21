package com.autonavi.base.amap.mapcore.maploader;

/* loaded from: classes12.dex */
public class NetworkState {
    private com.autonavi.base.amap.mapcore.maploader.NetworkState.NetworkChangeListener mNetworkListener;
    private boolean isNetReceiverRegistered = false;
    private com.autonavi.base.amap.mapcore.maploader.NetworkState.MyBroadcastReceiver netChangeReceiver = null;

    public static class MyBroadcastReceiver extends android.content.BroadcastReceiver {
        java.lang.ref.WeakReference<com.autonavi.base.amap.mapcore.maploader.NetworkState.NetworkChangeListener> reference;

        public MyBroadcastReceiver(com.autonavi.base.amap.mapcore.maploader.NetworkState.NetworkChangeListener networkChangeListener) {
            this.reference = null;
            this.reference = new java.lang.ref.WeakReference<>(networkChangeListener);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            java.lang.ref.WeakReference<com.autonavi.base.amap.mapcore.maploader.NetworkState.NetworkChangeListener> weakReference = this.reference;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.reference.get().networkStateChanged(context);
        }
    }

    public interface NetworkChangeListener {
        void networkStateChanged(android.content.Context context);
    }

    public static android.net.NetworkInfo getActiveNetworkInfo(android.content.Context context) {
        try {
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return activeNetworkInfo;
            }
            android.net.NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
            if (allNetworkInfo == null) {
                return null;
            }
            for (int i = 0; i < allNetworkInfo.length; i++) {
                android.net.NetworkInfo networkInfo = allNetworkInfo[i];
                if (networkInfo != null && networkInfo.isConnected()) {
                    return allNetworkInfo[i];
                }
            }
            return activeNetworkInfo;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isNetworkConnected(android.content.Context context) {
        android.net.NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void registerNetChangeReceiver(android.content.Context context, boolean z) {
        com.autonavi.base.amap.mapcore.maploader.NetworkState.MyBroadcastReceiver myBroadcastReceiver;
        if (z) {
            if (!this.isNetReceiverRegistered) {
                android.content.IntentFilter intentFilter = new android.content.IntentFilter();
                intentFilter.addAction(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
                if (this.netChangeReceiver == null) {
                    this.netChangeReceiver = new com.autonavi.base.amap.mapcore.maploader.NetworkState.MyBroadcastReceiver(this.mNetworkListener);
                }
                context.registerReceiver(this.netChangeReceiver, intentFilter);
            }
        } else if (this.isNetReceiverRegistered && (myBroadcastReceiver = this.netChangeReceiver) != null) {
            context.unregisterReceiver(myBroadcastReceiver);
            this.netChangeReceiver = null;
        }
        this.isNetReceiverRegistered = z;
    }

    public void setNetworkListener(com.autonavi.base.amap.mapcore.maploader.NetworkState.NetworkChangeListener networkChangeListener) {
        this.mNetworkListener = networkChangeListener;
    }
}
