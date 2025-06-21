package com.umeng.analytics;

/* loaded from: classes19.dex */
public class MobclickAgent {

    public enum EScenarioType {
        E_UM_NORMAL(0),
        E_UM_GAME(1);

        private int a;

        EScenarioType(int i) {
            this.a = i;
        }

        public int toValue() {
            return this.a;
        }
    }

    public enum PageMode {
        AUTO,
        MANUAL,
        LEGACY_AUTO,
        LEGACY_MANUAL
    }

    public static void clearPreProperties(android.content.Context context) {
        getAgent().g(context);
    }

    public static void disable() {
        com.umeng.analytics.AnalyticsConfig.enable = false;
    }

    private static void disableExceptionCatch() {
        com.umeng.analytics.b.a().a(false);
        com.umeng.analytics.AnalyticsConfig.CHANGE_CATCH_EXCEPTION_NOTALLOW = true;
    }

    @java.lang.Deprecated
    public static void enableEncrypt(boolean z) {
    }

    public static com.umeng.analytics.b getAgent() {
        return com.umeng.analytics.b.a();
    }

    public static org.json.JSONObject getPreProperties(android.content.Context context) {
        return getAgent().h(context);
    }

    private static void init(android.content.Context context) {
        com.umeng.analytics.b.a().a(context);
    }

    public static void onEvent(android.content.Context context, java.lang.String str) {
        com.umeng.analytics.b.a().a(context, str, (java.lang.String) null, -1L, 1);
    }

    public static void onEvent(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str2)) {
            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.k, 0, "\\|");
        } else {
            com.umeng.analytics.b.a().a(context, str, str2, -1L, 1);
        }
    }

    public static void onEvent(android.content.Context context, java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null) {
            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.a, 0, "\\|");
        } else {
            com.umeng.analytics.b.a().a(context, str, new java.util.HashMap(map), -1L);
        }
    }

    public static void onEventObject(android.content.Context context, java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        if (map == null) {
            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.a, 0, "\\|");
        } else {
            com.umeng.analytics.b.a().a(context, str, map, -1L);
        }
    }

    public static void onEventValue(android.content.Context context, java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, int i) {
        java.util.HashMap hashMap = map == null ? new java.util.HashMap() : new java.util.HashMap(map);
        hashMap.put("__ct__", java.lang.Integer.valueOf(i));
        com.umeng.analytics.b.a().a(context, str, hashMap, -1L);
    }

    private static void onGKVEvent(android.content.Context context, java.lang.String str, java.util.HashMap<java.lang.String, java.lang.Object> hashMap) {
        com.umeng.analytics.b.a().a(context, str, hashMap);
    }

    public static void onKillProcess(android.content.Context context) {
        com.umeng.analytics.b.a().d(context);
    }

    public static void onPageEnd(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.D, 0, "\\|");
        } else {
            com.umeng.analytics.b.a().b(str);
        }
    }

    public static void onPageStart(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.C, 0, "\\|");
        } else {
            com.umeng.analytics.b.a().a(str);
        }
    }

    public static void onPause(android.content.Context context) {
        com.umeng.analytics.b.a().c(context);
    }

    public static void onProfileSignIn(java.lang.String str) {
        onProfileSignIn("_adhoc", str);
    }

    public static void onProfileSignIn(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str2)) {
            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.t, 0, "\\|");
            return;
        }
        if (str2.length() > 64) {
            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.u, 0, "\\|");
            return;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            com.umeng.analytics.b.a().a("_adhoc", str2);
        } else if (str.length() > 32) {
            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.v, 0, "\\|");
        } else {
            com.umeng.analytics.b.a().a(str, str2);
        }
    }

    public static void onProfileSignOff() {
        com.umeng.analytics.b.a().j();
    }

    public static void onResume(android.content.Context context) {
        if (context == null) {
            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.n, 0, "\\|");
        } else {
            com.umeng.analytics.b.a().b(context);
        }
    }

    public static void registerPreProperties(android.content.Context context, org.json.JSONObject jSONObject) {
        getAgent().a(context, jSONObject);
    }

    public static void reportError(android.content.Context context, java.lang.String str) {
        try {
            com.efs.sdk.base.EfsReporter efsReporter = com.umeng.umcrash.UMCrash.sReporter;
            java.lang.reflect.Method declaredMethod = com.umeng.umcrash.UMCrash.class.getDeclaredMethod("generateCustomLog", java.lang.String.class, java.lang.String.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(com.umeng.umcrash.UMCrash.class, str, "DEFAULT");
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void reportError(android.content.Context context, java.lang.Throwable th) {
        try {
            com.efs.sdk.base.EfsReporter efsReporter = com.umeng.umcrash.UMCrash.sReporter;
            java.lang.reflect.Method declaredMethod = com.umeng.umcrash.UMCrash.class.getDeclaredMethod("generateCustomLog", java.lang.Throwable.class, java.lang.String.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(com.umeng.umcrash.UMCrash.class, th, "DEFAULT");
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void setCatchUncaughtExceptions(boolean z) {
        com.umeng.analytics.b.a().a(z);
    }

    @java.lang.Deprecated
    public static void setCheckDevice(boolean z) {
    }

    @java.lang.Deprecated
    public static void setDebugMode(boolean z) {
    }

    public static void setFirstLaunchEvent(android.content.Context context, java.util.List<java.lang.String> list) {
        getAgent().a(context, list);
    }

    private static void setGameScenarioType(android.content.Context context) {
        com.umeng.analytics.b.a().a(context, com.umeng.analytics.MobclickAgent.EScenarioType.E_UM_GAME);
    }

    @java.lang.Deprecated
    public static void setLatencyWindow(long j) {
    }

    public static void setLocation(double d, double d2) {
        com.umeng.analytics.b.a().a(d, d2);
    }

    public static void setOpenGLContext(javax.microedition.khronos.opengles.GL10 gl10) {
        com.umeng.analytics.b.a().a(gl10);
    }

    public static void setPageCollectionMode(com.umeng.analytics.MobclickAgent.PageMode pageMode) {
        com.umeng.commonsdk.UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION = pageMode;
    }

    @java.lang.Deprecated
    public static void setScenarioType(android.content.Context context, com.umeng.analytics.MobclickAgent.EScenarioType eScenarioType) {
    }

    public static void setSecret(android.content.Context context, java.lang.String str) {
        com.umeng.analytics.b.a().c(context, str);
    }

    public static void setSessionContinueMillis(long j) {
        if (j <= 30000) {
            j = 30000;
        }
        com.umeng.analytics.b.a().a(j);
    }

    private static void setSysListener(com.umeng.common.ISysListener iSysListener) {
        com.umeng.analytics.b.a().a(iSysListener);
    }

    public static void unregisterPreProperty(android.content.Context context, java.lang.String str) {
        getAgent().f(context, str);
    }

    public static void userProfile(java.lang.String str, java.lang.Object obj) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.umeng.commonsdk.statistics.common.MLog.e("userProfile: key is null or empty, please check!");
            return;
        }
        if (str.startsWith("_")) {
            com.umeng.commonsdk.statistics.common.MLog.e("userProfile: The user-defined key cannot start with an underscore, please check!");
            return;
        }
        boolean z = false;
        if (java.lang.Character.isDigit(str.charAt(0))) {
            com.umeng.commonsdk.statistics.common.MLog.e("userProfile: The user-defined key cannot start with an number, please check!");
            return;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            char c = charArray[i];
            if ((c < 'a' || c > 'z') && !((c >= 'A' && c <= 'Z') || java.lang.Character.isDigit(c) || c == '_')) {
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            com.umeng.commonsdk.statistics.common.MLog.e("userProfile: The user-defined key contains invalid characters, please check!");
        } else if (obj == null) {
            com.umeng.commonsdk.statistics.common.MLog.e("userProfile: value is null, please check!");
        } else {
            com.umeng.analytics.b.a().a(str, obj);
        }
    }

    public static void userProfileEMail(java.lang.String str) {
        if (str == null) {
            com.umeng.commonsdk.statistics.common.MLog.e("userProfileEMail: email value is null, please check!");
        } else {
            com.umeng.analytics.b.a().d(str);
        }
    }

    public static void userProfileMobile(java.lang.String str) {
        if (str == null) {
            com.umeng.commonsdk.statistics.common.MLog.e("userProfileMobile: mobile value is null, please check!");
        } else {
            com.umeng.analytics.b.a().c(str);
        }
    }
}
