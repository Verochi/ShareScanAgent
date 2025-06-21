package com.anythink.core.api;

/* loaded from: classes12.dex */
public abstract class ATInitMediation {
    public static final java.lang.String KEY_LOCAL = "anythink_local";

    public static boolean getBooleanFromMap(java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str) {
        return getBooleanFromMap(map, str, false);
    }

    public static boolean getBooleanFromMap(java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str, boolean z) {
        return ((java.lang.Boolean) getValueFromMap(map, str, java.lang.Boolean.valueOf(z))).booleanValue();
    }

    public static double getDoubleFromMap(java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str) {
        return getDoubleFromMap(map, str, 0.0d);
    }

    public static double getDoubleFromMap(java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str, double d) {
        return ((java.lang.Double) getValueFromMap(map, str, java.lang.Double.valueOf(d))).doubleValue();
    }

    public static int getIntFromMap(java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str) {
        return getIntFromMap(map, str, 0);
    }

    public static int getIntFromMap(java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str, int i) {
        return ((java.lang.Integer) getValueFromMap(map, str, java.lang.Integer.valueOf(i))).intValue();
    }

    public static long getLongFromMap(java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str) {
        return getLongFromMap(map, str, 0L);
    }

    public static long getLongFromMap(java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str, long j) {
        return ((java.lang.Long) getValueFromMap(map, str, java.lang.Long.valueOf(j))).longValue();
    }

    public static java.lang.String getStringFromMap(java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str) {
        return getStringFromMap(map, str, "");
    }

    public static java.lang.String getStringFromMap(java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str, java.lang.String str2) {
        return (java.lang.String) getValueFromMap(map, str, str2);
    }

    private static <T> T getValueFromMap(java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str, T t) {
        java.lang.Object obj;
        try {
            if (android.text.TextUtils.isEmpty(str) || map == null || map.size() <= 0 || (obj = map.get(str)) == null) {
                return t;
            }
            java.lang.String str2 = (T) obj.toString();
            java.lang.Object obj2 = t instanceof java.lang.String ? str2 : t instanceof java.lang.Integer ? (T) java.lang.Integer.valueOf(java.lang.Integer.parseInt(str2)) : t instanceof java.lang.Long ? (T) java.lang.Long.valueOf(java.lang.Long.parseLong(str2)) : t instanceof java.lang.Double ? (T) java.lang.Double.valueOf(java.lang.Double.parseDouble(str2)) : t instanceof java.lang.Float ? (T) java.lang.Float.valueOf(java.lang.Float.parseFloat(str2)) : t instanceof java.lang.Boolean ? (T) java.lang.Boolean.valueOf(java.lang.Boolean.parseBoolean(str2)) : t;
            if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder("key = ");
                sb.append(str);
                sb.append(" getValueFromMap() >>> result = ");
                sb.append(obj2);
                sb.append(" defaultValue = ");
                sb.append(t);
            }
            return (T) obj2;
        } catch (java.lang.Exception e) {
            if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
                new java.lang.StringBuilder("getValueFromMap() >>> errorMsg = ").append(e.getMessage());
            }
            return t;
        }
    }

    public final void checkToSaveInitData(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String... strArr) {
        com.anythink.core.common.b.o.a().a(str, map, strArr);
    }

    public java.util.List getActivityStatus() {
        return null;
    }

    public java.lang.String getAdapterVersion() {
        return "";
    }

    public java.util.List getMetaValutStatus() {
        return null;
    }

    public java.lang.String getNetworkName() {
        return "";
    }

    public java.lang.String getNetworkSDKClass() {
        return "";
    }

    public java.lang.String getNetworkVersion() {
        return "";
    }

    public java.util.List getPermissionStatus() {
        return null;
    }

    public java.util.Map<java.lang.String, java.lang.Boolean> getPluginClassStatus() {
        return null;
    }

    public java.util.List getProviderStatus() {
        return null;
    }

    public java.util.List getResourceStatus() {
        return null;
    }

    public java.util.List getServiceStatus() {
        return null;
    }

    public abstract void initSDK(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, com.anythink.core.api.MediationInitCallback mediationInitCallback);

    public boolean needCheckAdapterVersion() {
        return true;
    }

    public final void runOnMainThread(java.lang.Runnable runnable) {
        com.anythink.core.common.b.o.a().b(runnable);
    }

    public final void runOnThreadPool(java.lang.Runnable runnable) {
        com.anythink.core.common.b.o.a();
        com.anythink.core.common.b.o.c(runnable);
    }

    public boolean setUserDataConsent(android.content.Context context, boolean z, boolean z2) {
        return false;
    }
}
