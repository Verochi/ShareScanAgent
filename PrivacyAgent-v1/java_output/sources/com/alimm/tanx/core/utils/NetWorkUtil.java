package com.alimm.tanx.core.utils;

/* loaded from: classes.dex */
public class NetWorkUtil implements com.alimm.tanx.core.utils.NotConfused {
    private static final android.content.BroadcastReceiver Receiver = new com.alimm.tanx.core.utils.NetWorkUtil.AnonymousClass1();
    static final java.lang.String TAG = "NetWorkUtil";
    private static com.alimm.tanx.core.utils.NetWorkUtil.NetStateChangeListener listener;

    /* renamed from: com.alimm.tanx.core.utils.NetWorkUtil$1, reason: invalid class name */
    public static class AnonymousClass1 extends android.content.BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            if (com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(intent.getAction())) {
                android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    if (com.alimm.tanx.core.utils.NetWorkUtil.listener != null) {
                        com.alimm.tanx.core.utils.NetWorkUtil.listener.onDisconnect();
                    }
                } else if (activeNetworkInfo.getType() == 1) {
                    if (com.alimm.tanx.core.utils.NetWorkUtil.listener != null) {
                        com.alimm.tanx.core.utils.NetWorkUtil.listener.onWifiConnect();
                    }
                } else if (activeNetworkInfo.getType() == 0) {
                    if (com.alimm.tanx.core.utils.NetWorkUtil.listener != null) {
                        com.alimm.tanx.core.utils.NetWorkUtil.listener.onMobileConnect();
                    }
                } else if (com.alimm.tanx.core.utils.NetWorkUtil.listener != null) {
                    com.alimm.tanx.core.utils.NetWorkUtil.listener.onDisconnect();
                }
            }
        }
    }

    public interface NetStateChangeListener {
        void onDisconnect();

        void onMobileConnect();

        void onWifiConnect();
    }

    private NetWorkUtil() {
        throw new java.lang.UnsupportedOperationException("u can't instantiate me...");
    }

    private static android.net.NetworkInfo getActiveNetworkInfo(android.content.Context context) {
        return ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static com.alimm.tanx.core.net.constant.NetWorkType getNetworkType(android.content.Context context) {
        com.alimm.tanx.core.net.constant.NetWorkType netWorkType;
        com.alimm.tanx.core.net.constant.NetWorkType netWorkType2 = com.alimm.tanx.core.net.constant.NetWorkType.NETWORK_NO;
        android.net.NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return netWorkType2;
        }
        if (activeNetworkInfo.getType() == 1) {
            return com.alimm.tanx.core.net.constant.NetWorkType.NETWORK_WIFI;
        }
        if (activeNetworkInfo.getType() != 0) {
            return com.alimm.tanx.core.net.constant.NetWorkType.NETWORK_UNKNOWN;
        }
        switch (activeNetworkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                netWorkType = com.alimm.tanx.core.net.constant.NetWorkType.NETWORK_2G;
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
            case 17:
                netWorkType = com.alimm.tanx.core.net.constant.NetWorkType.NETWORK_3G;
                break;
            case 13:
            case 18:
                netWorkType = com.alimm.tanx.core.net.constant.NetWorkType.NETWORK_4G;
                break;
            default:
                java.lang.String subtypeName = activeNetworkInfo.getSubtypeName();
                if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA") && !subtypeName.equalsIgnoreCase("CDMA2000")) {
                    netWorkType = com.alimm.tanx.core.net.constant.NetWorkType.NETWORK_UNKNOWN;
                    break;
                } else {
                    netWorkType = com.alimm.tanx.core.net.constant.NetWorkType.NETWORK_3G;
                    break;
                }
                break;
        }
        return netWorkType;
    }

    public static int getOperatorType(android.content.Context context) {
        android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
        java.lang.String simOperatorName = telephonyManager.getSimOperatorName();
        if (simOperatorName != null) {
            if (simOperatorName.equals("46000") || simOperatorName.equals("46002") || simOperatorName.equals("46007")) {
                return 1;
            }
            if (simOperatorName.equals("46001")) {
                return 2;
            }
            return simOperatorName.equals("46003") ? 3 : 0;
        }
        try {
            java.lang.String subscriberId = telephonyManager.getSubscriberId();
            if (subscriberId == null) {
                return 0;
            }
            if (!subscriberId.startsWith("46000") && !subscriberId.startsWith("46002") && !subscriberId.startsWith("46007")) {
                if (subscriberId.startsWith("46001")) {
                    return 2;
                }
                return subscriberId.startsWith("46003") ? 3 : 0;
            }
            return 1;
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(e);
            return 0;
        }
    }

    public static boolean isNetworkConnected(android.content.Context context) {
        android.net.NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isAvailable();
    }

    public static void registerReceiver(com.alimm.tanx.core.utils.NetWorkUtil.NetStateChangeListener netStateChangeListener) {
        listener = netStateChangeListener;
        com.alimm.tanx.core.TanxCoreSdk.getApplication().getApplicationContext().registerReceiver(Receiver, new android.content.IntentFilter(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE));
    }

    public static void unRegisterReceiver() {
        try {
            com.alimm.tanx.core.TanxCoreSdk.getApplication().getApplicationContext().unregisterReceiver(Receiver);
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(TAG, "网络注册监听——解除监听报错" + e);
        }
    }
}
