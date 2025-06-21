package com.sensorsdata.analytics.android.sdk.util;

/* loaded from: classes19.dex */
public class PermissionUtils {
    private static final java.lang.String TAG = "SA.PermissionUtils";
    private static final java.util.Set<java.lang.String> mPermissionGrantedSet = new java.util.HashSet();
    private static final java.util.Set<java.lang.String> mPermissionGrantedOnceSet = new com.sensorsdata.analytics.android.sdk.util.PermissionUtils.AnonymousClass1();

    /* renamed from: com.sensorsdata.analytics.android.sdk.util.PermissionUtils$1, reason: invalid class name */
    public static class AnonymousClass1 extends java.util.HashSet<java.lang.String> {
        public AnonymousClass1() {
            add("android.permission.ACCESS_WIFI_STATE");
            add("android.permission.ACCESS_NETWORK_STATE");
        }
    }

    public static boolean checkSelfPermission(android.content.Context context, java.lang.String str) {
        int checkSelfPermission;
        boolean z = true;
        if (android.os.Build.VERSION.SDK_INT < 23) {
            try {
                if (context.getPackageManager().checkPermission(str, context.getPackageName()) != 0) {
                    z = false;
                }
                if (z) {
                    mPermissionGrantedSet.add(str);
                }
                return z;
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                return false;
            }
        }
        java.util.Set<java.lang.String> set = mPermissionGrantedSet;
        if (set.contains(str)) {
            return true;
        }
        checkSelfPermission = context.checkSelfPermission(str);
        boolean z2 = checkSelfPermission == 0;
        if (z2 && mPermissionGrantedOnceSet.contains(str)) {
            set.add(str);
        }
        return z2;
    }

    public static boolean hasReadPhoneStatePermission(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT > 28) {
            if (checkSelfPermission(context, "android.permission.READ_PRECISE_PHONE_STATE")) {
                return true;
            }
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Don't have permission android.permission.READ_PRECISE_PHONE_STATE,getDeviceID failed");
            return false;
        }
        if (checkSelfPermission(context, com.anythink.china.common.d.a)) {
            return true;
        }
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Don't have permission android.permission.READ_PHONE_STATE,getDeviceID failed");
        return false;
    }
}
