package com.umeng.umcrash;

/* loaded from: classes19.dex */
public class UMCrashUtils {
    private static final int DEF_CLOSE_RATE = 0;
    private static final int MAX_TRACE_RATE = 100;
    public static final java.lang.String UNKNOW = "";

    /* renamed from: com.umeng.umcrash.UMCrashUtils$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context val$context;
        final /* synthetic */ android.content.SharedPreferences val$sp;

        public AnonymousClass1(android.content.Context context, android.content.SharedPreferences sharedPreferences) {
            this.val$context = context;
            this.val$sp = sharedPreferences;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.val$sp.edit().putBoolean("um_apm_harmony", this.val$context.getString(android.content.res.Resources.getSystem().getIdentifier("config_os_brand", com.anythink.expressad.foundation.h.i.g, com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM)).equals("harmony")).apply();
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static boolean checkPermission(android.content.Context context, java.lang.String str) {
        if (context == null) {
            return false;
        }
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            try {
                if (((java.lang.Integer) java.lang.Class.forName("android.content.Context").getMethod("checkSelfPermission", java.lang.String.class).invoke(context, str)).intValue() != 0) {
                    return false;
                }
            } catch (java.lang.Throwable unused) {
                return false;
            }
        } else if (context.getPackageManager().checkPermission(str, context.getPackageName()) != 0) {
            return false;
        }
        return true;
    }

    public static java.lang.String[] getActiveUser(android.content.Context context) {
        java.lang.Class<com.umeng.commonsdk.utils.UMUtils> cls;
        java.lang.reflect.Method method;
        if (context == null) {
            return null;
        }
        try {
            cls = com.umeng.commonsdk.utils.UMUtils.class;
            java.lang.String str = com.umeng.commonsdk.utils.UMUtils.UNKNOW;
        } catch (java.lang.ClassNotFoundException unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            method = cls.getMethod("getActiveUser", android.content.Context.class);
        } catch (java.lang.NoSuchMethodException unused2) {
            method = null;
        }
        if (method == null) {
            return null;
        }
        try {
            java.lang.Object invoke = method.invoke(null, context);
            if (invoke != null) {
                return (java.lang.String[]) invoke;
            }
            return null;
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused3) {
            return null;
        }
    }

    public static int getInnerConfig(android.content.Context context, java.lang.String str, int i) {
        android.content.SharedPreferences sharedPreferences;
        if (context == null) {
            return i;
        }
        try {
            return (android.text.TextUtils.isEmpty(str) || (sharedPreferences = context.getSharedPreferences(com.umeng.umcrash.UMCrashContent.KEY_SP_UMCRASH, 0)) == null) ? i : sharedPreferences.getInt(str, i);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return i;
        }
    }

    public static java.lang.String getNetworkOperatorName(android.content.Context context) {
        if (context == null) {
            return "";
        }
        try {
            return com.umeng.commonsdk.statistics.common.DeviceConfig.getNetworkOperatorName(context);
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static boolean isHarmony(android.content.Context context) {
        android.content.SharedPreferences sharedPreferences;
        try {
            sharedPreferences = context.getSharedPreferences(com.umeng.umcrash.UMCrashContent.KEY_SP_UMCRASH, 0);
        } catch (java.lang.Throwable unused) {
        }
        if (sharedPreferences.contains("um_apm_harmony")) {
            return sharedPreferences.getBoolean("um_apm_harmony", false);
        }
        com.efs.sdk.base.core.util.concurrent.WorkThreadUtil.submit(new com.umeng.umcrash.UMCrashUtils.AnonymousClass1(context, sharedPreferences));
        return false;
    }

    public static boolean random(int i) {
        if (i == 0) {
            return false;
        }
        return i == 100 || new java.util.Random().nextInt(100) <= i;
    }

    public static void saveInnerConfig(android.content.Context context, java.lang.String str, java.lang.Object obj) {
        android.content.SharedPreferences sharedPreferences;
        android.content.SharedPreferences.Editor edit;
        if (context != null) {
            try {
                if (android.text.TextUtils.isEmpty(str) || obj == null || (sharedPreferences = context.getSharedPreferences(com.umeng.umcrash.UMCrashContent.KEY_SP_UMCRASH, 0)) == null || (edit = sharedPreferences.edit()) == null) {
                    return;
                }
                edit.putInt(str, java.lang.Integer.parseInt(obj.toString()));
                edit.commit();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setCommonTag(java.lang.String str, java.lang.String str2) {
        try {
            com.umeng.commonsdk.debug.UMLog uMLog = com.umeng.commonsdk.UMConfigure.umDebugLog;
            com.umeng.commonsdk.UMConfigure.BS_TYPE bs_type = com.umeng.commonsdk.UMConfigure.BS_TYPE.APM;
            java.lang.reflect.Method declaredMethod = com.umeng.commonsdk.UMConfigure.class.getDeclaredMethod("setModuleTag", com.umeng.commonsdk.UMConfigure.BS_TYPE.class, java.lang.String.class, java.lang.String.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                for (java.lang.Enum r9 : (java.lang.Enum[]) com.umeng.commonsdk.UMConfigure.BS_TYPE.class.getEnumConstants()) {
                    if (r9 != null && r9.name().equals("APM")) {
                        declaredMethod.invoke(com.umeng.commonsdk.UMConfigure.class, r9, str, str2);
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setIntegrationTesingParams(java.lang.String str) {
        if (com.uc.crashsdk.export.CrashApi.getInstance() != null) {
            com.uc.crashsdk.export.CrashApi.getInstance().addHeaderInfo("um_dk", str);
        }
        if (com.umeng.umcrash.UMCrash.getReporter() != null) {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("um_dk", str);
            com.umeng.umcrash.UMCrash.getReporter().addPublicParams(hashMap);
        }
    }

    public static void setPuidAndProvider(java.lang.String str, java.lang.String str2) {
        if (com.uc.crashsdk.export.CrashApi.getInstance() != null) {
            com.uc.crashsdk.export.CrashApi.getInstance().addHeaderInfo(com.umeng.umcrash.UMCrash.KEY_HEADER_PUID, str);
            com.uc.crashsdk.export.CrashApi.getInstance().addHeaderInfo(com.umeng.umcrash.UMCrash.KEY_HEADER_PROVIDER, str2);
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(com.umeng.umcrash.UMCrash.KEY_HEADER_PUID, str);
        hashMap.put(com.umeng.umcrash.UMCrash.KEY_HEADER_PROVIDER, str2);
        if (com.umeng.umcrash.UMCrash.getReporter() != null) {
            com.umeng.umcrash.UMCrash.getReporter().addPublicParams(hashMap);
        }
    }

    public static java.lang.String splitByByte(java.lang.String str, int i) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(i);
        try {
            int length = str.length();
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                java.lang.String valueOf = java.lang.String.valueOf(str.charAt(i3));
                i2 += valueOf.getBytes().length;
                if (i < i2) {
                    break;
                }
                stringBuffer.append(valueOf);
            }
        } catch (java.lang.Throwable unused) {
        }
        return stringBuffer.toString();
    }
}
