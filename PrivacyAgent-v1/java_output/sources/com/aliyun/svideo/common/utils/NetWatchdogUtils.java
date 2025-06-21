package com.aliyun.svideo.common.utils;

/* loaded from: classes.dex */
public class NetWatchdogUtils {
    private boolean isReconnect;
    private android.content.Context mContext;
    private com.aliyun.svideo.common.utils.NetWatchdogUtils.NetChangeListener mNetChangeListener;
    private android.content.IntentFilter mNetIntentFilter = new android.content.IntentFilter();
    private android.content.BroadcastReceiver mReceiver = new com.aliyun.svideo.common.utils.NetWatchdogUtils.AnonymousClass1();

    /* renamed from: com.aliyun.svideo.common.utils.NetWatchdogUtils$1, reason: invalid class name */
    public class AnonymousClass1 extends android.content.BroadcastReceiver {
        public AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return;
            }
            android.net.NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            android.net.NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
            android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            android.net.NetworkInfo.State state = android.net.NetworkInfo.State.UNKNOWN;
            android.net.NetworkInfo.State state2 = networkInfo != null ? networkInfo.getState() : state;
            if (networkInfo2 != null) {
                state = networkInfo2.getState();
            }
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
                if (activeNetworkInfo == null && com.aliyun.svideo.common.utils.NetWatchdogUtils.this.mNetChangeListener != null) {
                    com.aliyun.svideo.common.utils.NetWatchdogUtils.this.isReconnect = true;
                    com.aliyun.svideo.common.utils.NetWatchdogUtils.this.mNetChangeListener.onNetUnConnected();
                }
            } else if (com.aliyun.svideo.common.utils.NetWatchdogUtils.this.mNetChangeListener != null) {
                com.aliyun.svideo.common.utils.NetWatchdogUtils.this.mNetChangeListener.onReNetConnected(com.aliyun.svideo.common.utils.NetWatchdogUtils.this.isReconnect);
                com.aliyun.svideo.common.utils.NetWatchdogUtils.this.isReconnect = false;
            }
            android.net.NetworkInfo.State state3 = android.net.NetworkInfo.State.CONNECTED;
            if (state3 != state2 && state3 == state) {
                if (com.aliyun.svideo.common.utils.NetWatchdogUtils.this.mNetChangeListener != null) {
                    com.aliyun.svideo.common.utils.NetWatchdogUtils.this.mNetChangeListener.onWifiTo4G();
                }
            } else if (state3 == state2 && state3 != state) {
                if (com.aliyun.svideo.common.utils.NetWatchdogUtils.this.mNetChangeListener != null) {
                    com.aliyun.svideo.common.utils.NetWatchdogUtils.this.mNetChangeListener.on4GToWifi();
                }
            } else {
                if (state3 == state2 || com.aliyun.svideo.common.utils.NetWatchdogUtils.this.mNetChangeListener == null) {
                    return;
                }
                com.aliyun.svideo.common.utils.NetWatchdogUtils.this.mNetChangeListener.onNetUnConnected();
            }
        }
    }

    public interface NetChangeListener {
        void on4GToWifi();

        void onNetUnConnected();

        void onReNetConnected(boolean z);

        void onWifiTo4G();
    }

    public NetWatchdogUtils(android.content.Context context) {
        this.mContext = context.getApplicationContext();
        this.mNetIntentFilter.addAction(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
    }

    public static boolean hasNet(android.content.Context context) {
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        android.net.NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        android.net.NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        android.net.NetworkInfo.State state = android.net.NetworkInfo.State.UNKNOWN;
        android.net.NetworkInfo.State state2 = networkInfo != null ? networkInfo.getState() : state;
        if (networkInfo2 != null) {
            state = networkInfo2.getState();
        }
        android.net.NetworkInfo.State state3 = android.net.NetworkInfo.State.CONNECTED;
        return (state3 == state2 || state3 == state) && activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static boolean is4GConnected(android.content.Context context) {
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        android.net.NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
        android.net.NetworkInfo.State state = android.net.NetworkInfo.State.UNKNOWN;
        if (networkInfo != null) {
            state = networkInfo.getState();
        }
        return android.net.NetworkInfo.State.CONNECTED == state;
    }

    public void setNetChangeListener(com.aliyun.svideo.common.utils.NetWatchdogUtils.NetChangeListener netChangeListener) {
        this.mNetChangeListener = netChangeListener;
    }

    public void startWatch() {
        try {
            this.mContext.registerReceiver(this.mReceiver, this.mNetIntentFilter);
        } catch (java.lang.Exception unused) {
        }
    }

    public void stopWatch() {
        try {
            this.mContext.unregisterReceiver(this.mReceiver);
        } catch (java.lang.Exception unused) {
        }
    }
}
