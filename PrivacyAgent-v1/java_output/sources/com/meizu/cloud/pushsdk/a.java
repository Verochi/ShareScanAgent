package com.meizu.cloud.pushsdk;

/* loaded from: classes23.dex */
public class a {
    public static void a(android.content.Context context) {
        if (context.getPackageName().equalsIgnoreCase(com.meizu.cloud.pushsdk.util.MzSystemUtils.isWatch() ? com.meizu.cloud.pushsdk.constants.PushConstants.WEARABLE_PUSH_PACKAGE_NAME : com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_PACKAGE_NAME)) {
            return;
        }
        b(context);
        c(context);
    }

    private static void b(android.content.Context context) {
        java.lang.String str = com.meizu.cloud.pushsdk.util.MzSystemUtils.isWatch() ? com.meizu.cloud.pushsdk.constants.PushConstants.WEARABLE_PUSH_PACKAGE_NAME : com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_PACKAGE_NAME;
        java.lang.String appVersionName = com.meizu.cloud.pushsdk.util.MzSystemUtils.getAppVersionName(context, str);
        com.meizu.cloud.pushinternal.DebugLogger.i("PullUpPush", context.getPackageName() + " start register cloudVersion_name " + appVersionName);
        android.content.Intent intent = new android.content.Intent();
        if (str.equals(com.meizu.cloud.pushsdk.util.MzSystemUtils.getMzPushServicePackageName(context))) {
            com.meizu.cloud.pushinternal.DebugLogger.e("PullUpPush", "cloud pushService start");
            intent.setAction(com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_SERVICE_ACTION);
            intent.setClassName(str, com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_SERVICE_NAME);
        } else if (!android.text.TextUtils.isEmpty(appVersionName) && com.meizu.cloud.pushsdk.util.MzSystemUtils.compareVersion(appVersionName, com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_FLYME_4_CHANGE_VERSION)) {
            com.meizu.cloud.pushinternal.DebugLogger.e("PullUpPush", "flyme 4.x start register cloud versionName " + appVersionName);
            intent.setPackage(str);
            intent.setAction(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_START_PUSH_REGISTER);
        } else if (android.text.TextUtils.isEmpty(appVersionName) || !appVersionName.startsWith("3")) {
            com.meizu.cloud.pushinternal.DebugLogger.e("PullUpPush", context.getPackageName() + " start register ");
            intent.setClassName(context.getPackageName(), com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_SERVICE_NAME);
            intent.setAction(com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_SERVICE_ACTION);
        } else {
            com.meizu.cloud.pushinternal.DebugLogger.e("PullUpPush", "flyme 3.x start register cloud versionName " + appVersionName);
            intent.setAction(com.meizu.cloud.pushsdk.constants.PushConstants.REQUEST_REGISTER_INTENT);
            intent.setPackage(str);
        }
        try {
            context.startService(intent);
        } catch (java.lang.Exception e) {
            com.meizu.cloud.pushinternal.DebugLogger.e("PullUpPush", "start service error " + e.getMessage());
        }
    }

    private static void c(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT > 22) {
            return;
        }
        java.util.List<android.content.pm.ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new android.content.Intent(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_TRACKER_SERVICE_ACTION), 0);
        if (queryIntentServices == null || queryIntentServices.size() == 0) {
            com.meizu.cloud.pushsdk.d.a.a(context, false).a();
        }
    }
}
