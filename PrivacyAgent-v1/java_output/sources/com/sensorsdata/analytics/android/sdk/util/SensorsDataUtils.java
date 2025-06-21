package com.sensorsdata.analytics.android.sdk.util;

/* loaded from: classes19.dex */
public final class SensorsDataUtils {
    public static final java.lang.String COMMAND_HARMONYOS_VERSION = "getprop hw_sc.build.platform.version";
    private static final java.lang.String SHARED_PREF_APP_VERSION = "sensorsdata.app.version";
    private static final java.lang.String TAG = "SA.SensorsDataUtils";
    private static java.lang.String androidID = "";
    private static boolean isAndroidIDEnabled = true;
    private static boolean isOAIDEnabled = true;
    private static boolean isUniApp;
    private static final java.util.List<java.lang.String> mInvalidAndroidId = new com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.AnonymousClass1();

    /* renamed from: com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils$1, reason: invalid class name */
    public static class AnonymousClass1 extends java.util.ArrayList<java.lang.String> {
        public AnonymousClass1() {
            add("9774d56d682e549c");
            add("0123456789abcdef");
            add("0000000000000000");
        }
    }

    public static boolean checkVersionIsNew(android.content.Context context, java.lang.String str) {
        try {
            java.lang.String string = com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance().getString(SHARED_PREF_APP_VERSION, "");
            if (android.text.TextUtils.isEmpty(str) || str.equals(string)) {
                return false;
            }
            com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance().setString(SHARED_PREF_APP_VERSION, str);
            return true;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return true;
        }
    }

    private static java.lang.Class<?> compatActivity() {
        java.lang.Class<?> cls;
        try {
            cls = com.sensorsdata.analytics.android.sdk.util.ReflectUtil.getClassByName("androidx.appcompat.app.AppCompatActivity");
        } catch (java.lang.Exception unused) {
            cls = null;
        }
        if (cls != null) {
            return cls;
        }
        try {
            return com.sensorsdata.analytics.android.sdk.util.ReflectUtil.getClassByName("androidx.appcompat.app.AppCompatActivity");
        } catch (java.lang.Exception unused2) {
            return cls;
        }
    }

    public static void enableAndroidId(boolean z) {
        isAndroidIDEnabled = z;
    }

    public static void enableOAID(boolean z) {
        isOAIDEnabled = z;
    }

    public static java.lang.String getActivityTitle(android.app.Activity activity) {
        android.content.pm.PackageManager packageManager;
        if (activity != null) {
            try {
                java.lang.String toolbarTitle = getToolbarTitle(activity);
                if (android.text.TextUtils.isEmpty(toolbarTitle)) {
                    toolbarTitle = null;
                }
                if (android.text.TextUtils.isEmpty(toolbarTitle)) {
                    toolbarTitle = activity.getTitle().toString();
                }
                if (!android.text.TextUtils.isEmpty(toolbarTitle) || (packageManager = activity.getPackageManager()) == null) {
                    return toolbarTitle;
                }
                android.content.pm.ActivityInfo activityInfo = packageManager.getActivityInfo(activity.getComponentName(), 0);
                return !android.text.TextUtils.isEmpty(activityInfo.loadLabel(packageManager)) ? activityInfo.loadLabel(packageManager).toString() : toolbarTitle;
            } catch (java.lang.Exception unused) {
            }
        }
        return null;
    }

    @android.annotation.SuppressLint({"HardwareIds"})
    public static java.lang.String getIdentifier(android.content.Context context) {
        try {
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        if (!isAndroidIDEnabled) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "SensorsData getAndroidID is disabled");
            return "";
        }
        if (com.sensorsdata.analytics.android.sdk.core.business.SAPropertyManager.getInstance().isLimitKey(com.sensorsdata.analytics.android.sdk.internal.beans.LimitKey.ANDROID_ID)) {
            return com.sensorsdata.analytics.android.sdk.core.business.SAPropertyManager.getInstance().getLimitValue(com.sensorsdata.analytics.android.sdk.internal.beans.LimitKey.ANDROID_ID);
        }
        if (android.text.TextUtils.isEmpty(androidID)) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "SensorsData getIdentifier");
            java.lang.String string = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
            androidID = string;
            if (!isValidAndroidId(string)) {
                androidID = "";
            }
        }
        return androidID;
    }

    public static java.lang.String getToolbarTitle(android.app.Activity activity) {
        java.lang.Object invoke;
        java.lang.CharSequence charSequence;
        try {
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        if ("com.tencent.connect.common.AssistActivity".equals(com.sensorsdata.analytics.android.sdk.util.SnapCache.getInstance().getCanonicalName(activity.getClass()))) {
            if (android.text.TextUtils.isEmpty(activity.getTitle())) {
                return null;
            }
            return activity.getTitle().toString();
        }
        android.app.ActionBar actionBar = activity.getActionBar();
        if (actionBar == null) {
            try {
                java.lang.Class<?> compatActivity = compatActivity();
                if (compatActivity != null && compatActivity.isInstance(activity) && (invoke = activity.getClass().getMethod("getSupportActionBar", new java.lang.Class[0]).invoke(activity, new java.lang.Object[0])) != null && (charSequence = (java.lang.CharSequence) invoke.getClass().getMethod("getTitle", new java.lang.Class[0]).invoke(invoke, new java.lang.Object[0])) != null) {
                    return charSequence.toString();
                }
            } catch (java.lang.Exception unused) {
            }
        } else if (!android.text.TextUtils.isEmpty(actionBar.getTitle())) {
            return actionBar.getTitle().toString();
        }
        return null;
    }

    public static void handleSchemeUrl(android.app.Activity activity, android.content.Intent intent) {
        com.sensorsdata.analytics.android.sdk.util.SASchemeHelper.handleSchemeUrl(activity, intent);
    }

    public static void initUniAppStatus() {
        try {
            java.lang.Class.forName("io.dcloud.application.DCloudApplication");
            isUniApp = true;
        } catch (java.lang.ClassNotFoundException unused) {
        }
    }

    public static boolean isOAIDEnabled() {
        return isOAIDEnabled;
    }

    public static boolean isUniApp() {
        return isUniApp;
    }

    public static boolean isValidAndroidId(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return !mInvalidAndroidId.contains(str.toLowerCase(java.util.Locale.getDefault()));
    }

    @java.lang.Deprecated
    public static void mergeJSONObject(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        try {
            com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(jSONObject, jSONObject2);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public static void showUpWebView(android.content.Context context, java.lang.Object obj, org.json.JSONObject jSONObject, boolean z, boolean z2) {
        try {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "SensorsDataUtils.showUpWebView called.x5WebView = " + obj + ", isSupportJellyBean = " + z + ", enableVerify = " + z2);
            if (obj == null) {
                return;
            }
            try {
                java.lang.Class<?> cls = obj.getClass();
                try {
                    java.lang.Object invoke = cls.getMethod("getSettings", new java.lang.Class[0]).invoke(obj, new java.lang.Object[0]);
                    if (invoke != null) {
                        invoke.getClass().getMethod("setJavaScriptEnabled", java.lang.Boolean.TYPE).invoke(invoke, java.lang.Boolean.TRUE);
                    }
                } catch (java.lang.Exception unused) {
                }
                cls.getMethod("addJavascriptInterface", java.lang.Object.class, java.lang.String.class).invoke(obj, new com.sensorsdata.analytics.android.sdk.jsbridge.AppWebViewInterface(context, jSONObject, z2), "SensorsData_APP_JS_Bridge");
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
            com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.METHOD_ADD_VISUAL_JAVASCRIPTINTERFACE, obj);
        } catch (java.lang.Exception e2) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
        }
    }
}
