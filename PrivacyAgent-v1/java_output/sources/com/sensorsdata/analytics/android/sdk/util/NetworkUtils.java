package com.sensorsdata.analytics.android.sdk.util;

/* loaded from: classes19.dex */
public class NetworkUtils {
    private static final int HTTP_307 = 307;
    private static final java.lang.String TAG = "SA.NetworkUtils";
    private static com.sensorsdata.analytics.android.sdk.util.NetworkUtils.SABroadcastReceiver mReceiver;
    private static com.sensorsdata.analytics.android.sdk.util.NetworkUtils.SANetworkCallbackImpl networkCallback;
    private static java.lang.String networkType;

    public static class SABroadcastReceiver extends android.content.BroadcastReceiver {
        private SABroadcastReceiver() {
        }

        public /* synthetic */ SABroadcastReceiver(com.sensorsdata.analytics.android.sdk.util.NetworkUtils.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            if (com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(intent.getAction())) {
                com.sensorsdata.analytics.android.sdk.util.NetworkUtils.cleanNetworkTypeCache();
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().flush();
                com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.util.NetworkUtils.TAG, "SABroadcastReceiver is receiving ConnectivityManager.CONNECTIVITY_ACTION broadcast");
            }
        }
    }

    @android.annotation.TargetApi(21)
    public static class SANetworkCallbackImpl extends android.net.ConnectivityManager.NetworkCallback {
        private SANetworkCallbackImpl() {
        }

        public /* synthetic */ SANetworkCallbackImpl(com.sensorsdata.analytics.android.sdk.util.NetworkUtils.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(android.net.Network network) {
            super.onAvailable(network);
            com.sensorsdata.analytics.android.sdk.util.NetworkUtils.cleanNetworkTypeCache();
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().flush();
            com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.util.NetworkUtils.TAG, "onAvailable is calling");
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(android.net.Network network, android.net.NetworkCapabilities networkCapabilities) {
            super.onCapabilitiesChanged(network, networkCapabilities);
            com.sensorsdata.analytics.android.sdk.util.NetworkUtils.cleanNetworkTypeCache();
            com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.util.NetworkUtils.TAG, "onCapabilitiesChanged is calling");
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(android.net.Network network) {
            super.onLost(network);
            com.sensorsdata.analytics.android.sdk.util.NetworkUtils.cleanNetworkTypeCache();
            com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.util.NetworkUtils.TAG, "onLost is calling");
        }
    }

    public static void cleanNetworkTypeCache() {
        networkType = null;
    }

    public static boolean compareMainDomain(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || !str2.contains(".")) {
            return false;
        }
        return str.substring(str.indexOf(".") + 1).equals(str2.substring(str2.indexOf(".") + 1));
    }

    public static java.lang.String getHost(java.lang.String str) {
        return !android.text.TextUtils.isEmpty(str) ? (str.startsWith("http://") || str.startsWith("https://")) ? android.net.Uri.parse(str).getHost() : "" : "";
    }

    public static java.lang.String getLocation(java.net.HttpURLConnection httpURLConnection, java.lang.String str) throws java.net.MalformedURLException {
        if (httpURLConnection == null || android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        java.lang.String headerField = httpURLConnection.getHeaderField("Location");
        if (android.text.TextUtils.isEmpty(headerField)) {
            headerField = httpURLConnection.getHeaderField(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION);
        }
        if (android.text.TextUtils.isEmpty(headerField)) {
            return null;
        }
        if (headerField.startsWith("http://") || headerField.startsWith("https://")) {
            return headerField;
        }
        java.net.URL url = new java.net.URL(str);
        return url.getProtocol() + "://" + url.getHost() + headerField;
    }

    public static java.lang.String getRequestUrl(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            return "";
        }
        android.net.Uri parse = android.net.Uri.parse(str);
        try {
            return new java.net.URI(parse.getScheme(), parse.getUserInfo(), parse.getHost(), parse.getPort(), null, null, null) + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str2;
        } catch (java.net.URISyntaxException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return "";
        }
    }

    @android.annotation.SuppressLint({"WrongConstant"})
    public static boolean isNetworkAvailable(android.content.Context context) {
        if (!com.sensorsdata.analytics.android.sdk.util.PermissionUtils.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return false;
        }
        try {
            return isNetworkAvailable((android.net.ConnectivityManager) context.getSystemService("connectivity"));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return false;
        }
    }

    private static boolean isNetworkAvailable(android.net.ConnectivityManager connectivityManager) {
        android.net.Network activeNetwork;
        android.net.NetworkCapabilities networkCapabilities;
        if (connectivityManager == null) {
            return false;
        }
        if (android.os.Build.VERSION.SDK_INT < 23) {
            android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return isNetworkValid(networkCapabilities);
    }

    @android.annotation.SuppressLint({"WrongConstant"})
    public static boolean isNetworkValid(android.net.NetworkCapabilities networkCapabilities) {
        if (networkCapabilities != null) {
            return networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3) || networkCapabilities.hasTransport(7) || networkCapabilities.hasTransport(4) || networkCapabilities.hasCapability(16);
        }
        return false;
    }

    public static boolean isShouldFlush(java.lang.String str, int i) {
        return (toNetworkType(str) & i) != 0;
    }

    private static boolean isWiFiNetwork(android.net.ConnectivityManager connectivityManager) {
        android.net.Network activeNetwork;
        android.net.NetworkCapabilities networkCapabilities;
        if (android.os.Build.VERSION.SDK_INT < 23) {
            android.net.NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            return networkInfo != null && networkInfo.isConnectedOrConnecting();
        }
        activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasTransport(1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0019, code lost:
    
        if (r2 != false) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @android.annotation.SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static java.lang.String mobileNetworkType(android.content.Context context, android.telephony.TelephonyManager telephonyManager, android.net.ConnectivityManager connectivityManager) {
        int i;
        android.net.NetworkInfo activeNetworkInfo;
        boolean hasCarrierPrivileges;
        if (telephonyManager != null) {
            if (android.os.Build.VERSION.SDK_INT < 30) {
                i = telephonyManager.getNetworkType();
            } else {
                if (!com.sensorsdata.analytics.android.sdk.util.PermissionUtils.checkSelfPermission(context, com.anythink.china.common.d.a)) {
                    hasCarrierPrivileges = telephonyManager.hasCarrierPrivileges();
                }
                i = telephonyManager.getDataNetworkType();
            }
            if (i == 0) {
                if (android.os.Build.VERSION.SDK_INT >= 30) {
                    return "NULL";
                }
                if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                    i = activeNetworkInfo.getSubtype();
                }
            }
            switch (i) {
            }
            return "NULL";
        }
        i = 0;
        if (i == 0) {
        }
        switch (i) {
        }
        return "NULL";
    }

    public static boolean needRedirects(int i) {
        return i == 301 || i == 302 || i == 307;
    }

    public static java.lang.String networkType(android.content.Context context) {
        try {
            if (!android.text.TextUtils.isEmpty(networkType) && !"NULL".equals(networkType)) {
                return networkType;
            }
            if (!com.sensorsdata.analytics.android.sdk.util.PermissionUtils.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                networkType = "NULL";
                return "NULL";
            }
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                if (!isNetworkAvailable(connectivityManager)) {
                    networkType = "NULL";
                    return "NULL";
                }
                if (isWiFiNetwork(connectivityManager)) {
                    networkType = "WIFI";
                    return "WIFI";
                }
            }
            java.lang.String mobileNetworkType = mobileNetworkType(context, (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE), connectivityManager);
            networkType = mobileNetworkType;
            return mobileNetworkType;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            networkType = "NULL";
            return "NULL";
        }
    }

    public static void registerNetworkListener(android.content.Context context) {
        try {
            if (android.os.Build.VERSION.SDK_INT < 23 || com.sensorsdata.analytics.android.sdk.util.PermissionUtils.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                if (networkCallback == null) {
                    networkCallback = new com.sensorsdata.analytics.android.sdk.util.NetworkUtils.SANetworkCallbackImpl(null);
                }
                android.net.NetworkRequest build = new android.net.NetworkRequest.Builder().build();
                android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    connectivityManager.registerNetworkCallback(build, networkCallback);
                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Register ConnectivityManager");
                }
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    private static int toNetworkType(java.lang.String str) {
        if ("NULL".equals(str)) {
            return 255;
        }
        if ("WIFI".equals(str)) {
            return 8;
        }
        if ("2G".equals(str)) {
            return 1;
        }
        if ("3G".equals(str)) {
            return 2;
        }
        if ("4G".equals(str)) {
            return 4;
        }
        return "5G".equals(str) ? 16 : 255;
    }

    public static void unregisterNetworkListener(android.content.Context context) {
        android.net.ConnectivityManager connectivityManager;
        try {
            if (networkCallback == null || (connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity")) == null) {
                return;
            }
            connectivityManager.unregisterNetworkCallback(networkCallback);
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "unregister ConnectivityManager");
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }
}
