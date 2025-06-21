package com.aliyun.common.aio_util;

/* loaded from: classes.dex */
class NetworkObserver extends android.content.BroadcastReceiver {
    private android.content.Context a;
    private volatile java.lang.String b = "";
    private volatile boolean c = false;

    public static class a {
        private static final com.aliyun.common.aio_util.NetworkObserver a = new com.aliyun.common.aio_util.NetworkObserver();
    }

    private static com.aliyun.common.aio_util.NetworkObserver a() {
        return com.aliyun.common.aio_util.NetworkObserver.a.a;
    }

    private synchronized void a(android.content.Context context) {
        if (!this.c) {
            this.a = context;
            try {
                context.registerReceiver(this, new android.content.IntentFilter(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE));
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            this.c = true;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void b(android.content.Context context) {
        try {
            android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                this.b = "NoActive";
                return;
            }
            java.lang.String subtypeName = activeNetworkInfo.getSubtypeName();
            if (activeNetworkInfo.getType() != 1) {
                if (activeNetworkInfo.getType() == 0) {
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                        case 16:
                            subtypeName = "2G";
                            break;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            subtypeName = "3G";
                        case 13:
                        case 19:
                            subtypeName = "4G";
                            break;
                        case 17:
                        case 18:
                        default:
                            if (!"TD-SCDMA".equalsIgnoreCase(subtypeName) && !"WCDMA".equalsIgnoreCase(subtypeName) && !"CDMA2000".equalsIgnoreCase(subtypeName)) {
                                subtypeName = "Mobile:" + subtypeName;
                                break;
                            }
                            subtypeName = "3G";
                            break;
                        case 20:
                            subtypeName = "5G";
                            break;
                    }
                }
            } else {
                subtypeName = "WIFI";
            }
            this.b = subtypeName;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @com.aliyun.aio.keep.CalledByNative
    public static java.lang.String getNetworkType(android.content.Context context) {
        com.aliyun.common.aio_util.NetworkObserver a2 = a();
        if (!a2.c && context != null) {
            a2.a(context);
            a2.b(context);
        }
        return a2.b;
    }

    @com.aliyun.aio.keep.CalledByNative
    public static boolean isNetworkAvailable(android.content.Context context) {
        try {
            android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnectedOrConnecting()) {
                    return true;
                }
            }
            return false;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        b(this.a);
    }
}
