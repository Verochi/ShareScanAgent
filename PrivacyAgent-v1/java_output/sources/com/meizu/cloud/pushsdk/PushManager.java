package com.meizu.cloud.pushsdk;

/* loaded from: classes23.dex */
public class PushManager {
    private static final java.lang.String KEY_PUSH_ID = "pushId";
    private static final java.lang.String PUSH_ID_PREFERENCE_NAME = "com.meizu.flyme.push";
    private static final int PUSH_SUPPORT_CHECK_NOTIFICATION_MSG_VERSION_START = 6;
    public static final java.lang.String TAG = "4.1.4";

    public static void checkNotificationMessage(android.content.Context context) {
        java.lang.String appVersionName = com.meizu.cloud.pushsdk.util.MzSystemUtils.getAppVersionName(context, com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_PACKAGE_NAME);
        com.meizu.cloud.pushinternal.DebugLogger.i(TAG, context.getPackageName() + " checkNotificationMessage cloudVersion_name " + appVersionName);
        if (android.text.TextUtils.isEmpty(appVersionName) || java.lang.Integer.parseInt(appVersionName.substring(0, 1)) < 6) {
            return;
        }
        android.content.Intent intent = new android.content.Intent(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_GET_NOTIFICATION_MESSAGE);
        intent.putExtra(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_GET_NOTIFICATION_PACKAGE_NAME, context.getPackageName());
        intent.setClassName(com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_PACKAGE_NAME, com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_SERVICE_NAME);
        try {
            context.startService(intent);
        } catch (java.lang.Exception e) {
            com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "start check notification message service error " + e.getMessage());
        }
    }

    public static void checkPush(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (com.meizu.cloud.pushsdk.util.MzSystemUtils.isBrandMeizu(context)) {
            com.meizu.cloud.pushsdk.platform.a.b.a(context).a(str, str2, context.getPackageName(), str3);
        } else {
            com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "please invoke checkPush on meizu device Build-in FlymeOS");
        }
    }

    public static void checkSubScribeAlias(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (com.meizu.cloud.pushsdk.util.MzSystemUtils.isBrandMeizu(context)) {
            com.meizu.cloud.pushsdk.platform.a.b.a(context).d(str, str2, context.getPackageName(), str3);
        } else {
            com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "please invoke checkSubScribeAlias on meizu device Build-in FlymeOS");
        }
    }

    public static void checkSubScribeTags(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (com.meizu.cloud.pushsdk.util.MzSystemUtils.isBrandMeizu(context)) {
            com.meizu.cloud.pushsdk.platform.a.b.a(context).c(str, str2, context.getPackageName(), str3);
        } else {
            com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "please invoke checkSubScribeTags on meizu device Build-in FlymeOS");
        }
    }

    public static void clearNotification(android.content.Context context) {
        com.meizu.cloud.pushsdk.platform.a.b.a(context).a(context.getPackageName());
    }

    public static void clearNotification(android.content.Context context, int... iArr) {
        com.meizu.cloud.pushsdk.platform.a.b.a(context).a(context.getPackageName(), iArr);
    }

    public static void enableCacheRequest(android.content.Context context, boolean z) {
        com.meizu.cloud.pushsdk.platform.a.b.a(context).a(z);
    }

    public static java.lang.String getPushId(android.content.Context context) {
        int b = com.meizu.cloud.pushsdk.util.b.b(context, context.getPackageName());
        if (b == 0 || java.lang.System.currentTimeMillis() / 1000 <= b) {
            return com.meizu.cloud.pushsdk.util.b.a(context, context.getPackageName());
        }
        return null;
    }

    @java.lang.Deprecated
    public static void register(android.content.Context context) {
        com.meizu.cloud.pushinternal.DebugLogger.init(context);
        if (!com.meizu.cloud.pushsdk.util.MzSystemUtils.isBrandMeizu(context)) {
            com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "please invoke register on meizu device Build-in FlymeOS");
            return;
        }
        java.lang.String str = com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_PACKAGE_NAME;
        java.lang.String appVersionName = com.meizu.cloud.pushsdk.util.MzSystemUtils.getAppVersionName(context, com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_PACKAGE_NAME);
        com.meizu.cloud.pushinternal.DebugLogger.i(TAG, context.getPackageName() + " start register cloudVersion_name " + appVersionName);
        android.content.Intent intent = new android.content.Intent(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_START_PUSH_REGISTER);
        try {
            if (!com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_PACKAGE_NAME.equals(com.meizu.cloud.pushsdk.util.MzSystemUtils.getMzPushServicePackageName(context))) {
                if (!android.text.TextUtils.isEmpty(appVersionName) && com.meizu.cloud.pushsdk.util.MzSystemUtils.compareVersion(appVersionName, com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_FLYME_4_CHANGE_VERSION)) {
                    com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "flyme 4.x start register cloud versionName " + appVersionName);
                } else if (android.text.TextUtils.isEmpty(appVersionName) || !appVersionName.startsWith("3")) {
                    com.meizu.cloud.pushinternal.DebugLogger.e(TAG, context.getPackageName() + " start register ");
                    str = context.getPackageName();
                } else {
                    com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "flyme 3.x start register cloud versionName " + appVersionName);
                    intent.setAction(com.meizu.cloud.pushsdk.constants.PushConstants.REQUEST_REGISTER_INTENT);
                }
                intent.setPackage(com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_PACKAGE_NAME);
                intent.putExtra("sender", context.getPackageName());
                context.startService(intent);
                return;
            }
            context.startService(intent);
            return;
        } catch (java.lang.Exception e) {
            com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "start register service error " + e.getMessage());
            return;
        }
        intent.setClassName(str, com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_SERVICE_NAME);
        intent.putExtra("sender", context.getPackageName());
    }

    public static void register(android.content.Context context, java.lang.String str, java.lang.String str2) {
        com.meizu.cloud.pushinternal.DebugLogger.init(context);
        if (com.meizu.cloud.pushsdk.util.MzSystemUtils.isBrandMeizu(context)) {
            com.meizu.cloud.pushsdk.platform.a.b.a(context).a(str, str2, context.getPackageName());
        } else {
            com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "please invoke register on meizu device Build-in FlymeOS");
        }
    }

    public static void subScribeAlias(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        if (com.meizu.cloud.pushsdk.util.MzSystemUtils.isBrandMeizu(context)) {
            com.meizu.cloud.pushsdk.platform.a.b.a(context).c(str, str2, context.getPackageName(), str3, str4);
        } else {
            com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "please invoke subScribeAlias on meizu device Build-in FlymeOS");
        }
    }

    public static void subScribeTags(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        if (com.meizu.cloud.pushsdk.util.MzSystemUtils.isBrandMeizu(context)) {
            com.meizu.cloud.pushsdk.platform.a.b.a(context).a(str, str2, context.getPackageName(), str3, str4);
        } else {
            com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "please invoke subScribeTags on meizu device Build-in FlymeOS");
        }
    }

    public static void switchPush(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, int i, boolean z) {
        if (com.meizu.cloud.pushsdk.util.MzSystemUtils.isBrandMeizu(context)) {
            com.meizu.cloud.pushsdk.platform.a.b.a(context).a(str, str2, context.getPackageName(), str3, i, z);
        } else {
            com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "please invoke switchPush on meizu device Build-in FlymeOS");
        }
    }

    public static void switchPush(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z) {
        if (com.meizu.cloud.pushsdk.util.MzSystemUtils.isBrandMeizu(context)) {
            com.meizu.cloud.pushsdk.platform.a.b.a(context).a(str, str2, context.getPackageName(), str3, z);
        } else {
            com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "please invoke switchPush on meizu device Build-in FlymeOS");
        }
    }

    @java.lang.Deprecated
    public static void unRegister(android.content.Context context) {
        if (!com.meizu.cloud.pushsdk.util.MzSystemUtils.isBrandMeizu(context)) {
            com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "please invoke unRegister on meizu device Build-in FlymeOS");
            return;
        }
        java.lang.String str = com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_PACKAGE_NAME;
        java.lang.String appVersionName = com.meizu.cloud.pushsdk.util.MzSystemUtils.getAppVersionName(context, com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_PACKAGE_NAME);
        com.meizu.cloud.pushinternal.DebugLogger.e(TAG, context.getPackageName() + " start unRegister cloud versionName " + appVersionName);
        android.content.Intent intent = new android.content.Intent(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_STOP_PUSH_REGISTER);
        try {
            if (!com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_PACKAGE_NAME.equals(com.meizu.cloud.pushsdk.util.MzSystemUtils.getMzPushServicePackageName(context))) {
                if (android.text.TextUtils.isEmpty(appVersionName) || !com.meizu.cloud.pushsdk.util.MzSystemUtils.compareVersion(appVersionName, com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_FLYME_4_CHANGE_VERSION)) {
                    if (android.text.TextUtils.isEmpty(appVersionName) || !appVersionName.startsWith("3")) {
                        com.meizu.cloud.pushinternal.DebugLogger.e(TAG, context.getPackageName() + " start unRegister ");
                        str = context.getPackageName();
                    } else {
                        intent.setAction(com.meizu.cloud.pushsdk.constants.PushConstants.REQUEST_UNREGISTER_INTENT);
                    }
                }
                intent.setPackage(com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_PACKAGE_NAME);
                intent.putExtra("sender", context.getPackageName());
                context.startService(intent);
                return;
            }
            context.startService(intent);
            return;
        } catch (java.lang.Exception e) {
            com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "start unRegister service error " + e.getMessage());
            return;
        }
        intent.setClassName(str, com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_SERVICE_NAME);
        intent.putExtra("sender", context.getPackageName());
    }

    public static void unRegister(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (com.meizu.cloud.pushsdk.util.MzSystemUtils.isBrandMeizu(context)) {
            com.meizu.cloud.pushsdk.platform.a.b.a(context).b(str, str2, context.getPackageName());
        } else {
            com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "please invoke unRegister on meizu device Build-in FlymeOS");
        }
    }

    public static void unSubScribeAlias(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        if (com.meizu.cloud.pushsdk.util.MzSystemUtils.isBrandMeizu(context)) {
            com.meizu.cloud.pushsdk.platform.a.b.a(context).d(str, str2, context.getPackageName(), str3, str4);
        } else {
            com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "please invoke unSubScribeAlias on meizu device Build-in FlymeOS");
        }
    }

    public static void unSubScribeAllTags(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (com.meizu.cloud.pushsdk.util.MzSystemUtils.isBrandMeizu(context)) {
            com.meizu.cloud.pushsdk.platform.a.b.a(context).b(str, str2, context.getPackageName(), str3);
        } else {
            com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "please invoke unSubScribeAllTags on meizu device Build-in FlymeOS");
        }
    }

    public static void unSubScribeTags(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        if (com.meizu.cloud.pushsdk.util.MzSystemUtils.isBrandMeizu(context)) {
            com.meizu.cloud.pushsdk.platform.a.b.a(context).b(str, str2, context.getPackageName(), str3, str4);
        } else {
            com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "please invoke unSubScribeTags on meizu device Build-in FlymeOS");
        }
    }
}
