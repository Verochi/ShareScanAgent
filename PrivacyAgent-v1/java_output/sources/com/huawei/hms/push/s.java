package com.huawei.hms.push;

/* loaded from: classes22.dex */
public abstract class s {
    public static final java.lang.Object a = new java.lang.Object();
    public static int b = -1;

    public static boolean a() {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("huawei.cust.HwCfgFilePolicy");
            int intValue = ((java.lang.Integer) cls.getDeclaredField("CUST_TYPE_CONFIG").get(cls)).intValue();
            java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod("getCfgFile", java.lang.String.class, java.lang.Integer.TYPE);
            java.lang.Object[] objArr = new java.lang.Object[2];
            objArr[0] = "jars/hwpush.jar";
            objArr[1] = java.lang.Integer.valueOf(intValue);
            java.io.File file = (java.io.File) declaredMethod.invoke(cls, objArr);
            if (file != null && file.exists()) {
                com.huawei.hms.support.log.HMSLog.d("CommFun", "get push cust File path success.");
                return true;
            }
        } catch (java.lang.ClassNotFoundException unused) {
            com.huawei.hms.support.log.HMSLog.e("CommFun", "HwCfgFilePolicy ClassNotFoundException");
        } catch (java.lang.IllegalAccessException unused2) {
            com.huawei.hms.support.log.HMSLog.e("CommFun", "check cust exist push IllegalAccessException.");
        } catch (java.lang.IllegalArgumentException unused3) {
            com.huawei.hms.support.log.HMSLog.e("CommFun", "check cust exist push IllegalArgumentException.");
        } catch (java.lang.NoSuchFieldException unused4) {
            com.huawei.hms.support.log.HMSLog.e("CommFun", "check cust exist push NoSuchFieldException.");
        } catch (java.lang.NoSuchMethodException unused5) {
            com.huawei.hms.support.log.HMSLog.e("CommFun", "check cust exist push NoSuchMethodException.");
        } catch (java.lang.SecurityException unused6) {
            com.huawei.hms.support.log.HMSLog.e("CommFun", "check cust exist push SecurityException.");
        } catch (java.lang.reflect.InvocationTargetException unused7) {
            com.huawei.hms.support.log.HMSLog.e("CommFun", "check cust exist push InvocationTargetException.");
        }
        return false;
    }

    public static boolean a(android.content.Context context) {
        com.huawei.hms.support.log.HMSLog.d("CommFun", "existFrameworkPush:" + b);
        try {
            java.io.File file = new java.io.File("/system/framework/hwpush.jar");
            if (a()) {
                com.huawei.hms.support.log.HMSLog.d("CommFun", "push jarFile is exist");
                return true;
            }
            if (!file.isFile()) {
                return false;
            }
            com.huawei.hms.support.log.HMSLog.d("CommFun", "push jarFile is exist");
            return true;
        } catch (java.lang.Exception e) {
            com.huawei.hms.support.log.HMSLog.e("CommFun", "get Apk version faild ,Exception e= " + e.toString());
            return false;
        }
    }

    public static boolean a(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2, java.lang.String str) {
        return jSONObject == null || (android.text.TextUtils.isEmpty(str) && jSONObject2 == null);
    }

    public static long b(android.content.Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.huawei.android.pushagent", 16384).versionCode;
        } catch (java.lang.Exception unused) {
            com.huawei.hms.support.log.HMSLog.e("CommFun", "get nc versionCode error");
            return -1L;
        }
    }

    public static boolean b() {
        return com.huawei.hms.android.HwBuildEx.VERSION.EMUI_SDK_INT >= 21;
    }

    public static java.lang.String c(android.content.Context context) {
        return com.huawei.agconnect.config.AGConnectServicesConfig.fromContext(context).getString("client/project_id");
    }

    public static boolean c() {
        return com.huawei.hms.android.HwBuildEx.VERSION.EMUI_SDK_INT < 19;
    }

    public static boolean d(android.content.Context context) {
        com.huawei.hms.support.log.HMSLog.d("CommFun", "existFrameworkPush:" + b);
        synchronized (a) {
            int i = b;
            if (-1 != i) {
                return 1 == i;
            }
            if (a(context)) {
                b = 1;
            } else {
                b = 0;
            }
            return 1 == b;
        }
    }
}
