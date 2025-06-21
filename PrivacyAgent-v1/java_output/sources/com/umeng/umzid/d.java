package com.umeng.umzid;

/* loaded from: classes19.dex */
public class d {
    public static java.lang.String[] a = {"com.bly.dkplat", "com.by.chaos", "com.lbe.parallel", "com.excelliance.dualaid", "com.excelliance.multiaccounts", "com.lody.virtual", "com.qihoo.magic"};

    public static java.lang.String a(android.content.Context context) {
        try {
            java.lang.String str = com.umeng.commonsdk.statistics.common.DeviceConfig.UNKNOW;
            java.lang.reflect.Method declaredMethod = com.umeng.commonsdk.statistics.common.DeviceConfig.class.getDeclaredMethod("getAndroidId", android.content.Context.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                java.lang.Object invoke = declaredMethod.invoke(com.umeng.commonsdk.statistics.common.DeviceConfig.class, context);
                if (invoke != null && (invoke instanceof java.lang.String)) {
                    return (java.lang.String) invoke;
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        return "";
    }

    public static java.lang.String a(java.lang.String str) {
        try {
            return new java.lang.String(android.util.Base64.decode(str.getBytes("UTF-8"), 2));
        } catch (java.io.UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static void a(android.content.Context context, java.lang.String str) {
        android.content.SharedPreferences a2;
        android.content.SharedPreferences.Editor edit;
        java.lang.String b = b(str);
        if (context == null || b == null || android.text.TextUtils.isEmpty(b) || (a2 = com.umeng.umzid.a.a(context)) == null || (edit = a2.edit()) == null) {
            return;
        }
        edit.putString("mac", b).commit();
    }

    public static java.lang.String b(android.content.Context context) {
        android.content.SharedPreferences a2;
        if (context == null || (a2 = com.umeng.umzid.a.a(context)) == null) {
            return "";
        }
        java.lang.String string = a2.getString("inputDomain", "");
        return c(string) ? a(string) : string;
    }

    public static java.lang.String b(java.lang.String str) {
        try {
            return android.util.Base64.encodeToString(str.getBytes("UTF-8"), 2);
        } catch (java.io.UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static void b(android.content.Context context, java.lang.String str) {
        android.content.SharedPreferences a2;
        android.content.SharedPreferences.Editor edit;
        java.lang.String b = b(str);
        if (context == null || b == null || android.text.TextUtils.isEmpty(b) || (a2 = com.umeng.umzid.a.a(context)) == null || (edit = a2.edit()) == null) {
            return;
        }
        edit.putString("oaid", b).commit();
    }

    public static java.lang.String c(android.content.Context context) {
        android.content.SharedPreferences a2;
        return (context == null || (a2 = com.umeng.umzid.a.a(context)) == null) ? "" : a2.getString("uabc", "");
    }

    public static void c(android.content.Context context, java.lang.String str) {
        android.content.SharedPreferences a2;
        android.content.SharedPreferences.Editor edit;
        if (context == null || android.text.TextUtils.isEmpty(str) || (a2 = com.umeng.umzid.a.a(context)) == null || (edit = a2.edit()) == null) {
            return;
        }
        edit.putString("resetToken", str).commit();
    }

    public static boolean c(java.lang.String str) {
        return !android.text.TextUtils.isEmpty(str) && str.equals(b(a(str)));
    }

    public static java.lang.String d(android.content.Context context) {
        android.content.SharedPreferences a2;
        if (context == null || (a2 = com.umeng.umzid.a.a(context)) == null) {
            return null;
        }
        return a2.getString("aaid", null);
    }

    public static void d(android.content.Context context, java.lang.String str) {
        android.content.SharedPreferences a2;
        android.content.SharedPreferences.Editor edit;
        if (context == null || android.text.TextUtils.isEmpty(str) || (a2 = com.umeng.umzid.a.a(context)) == null || (edit = a2.edit()) == null) {
            return;
        }
        edit.putString("uabc", str).commit();
    }

    public static java.lang.String e(android.content.Context context) {
        try {
            java.lang.String str = com.umeng.commonsdk.statistics.common.DeviceConfig.UNKNOW;
            java.lang.reflect.Method declaredMethod = com.umeng.commonsdk.statistics.common.DeviceConfig.class.getDeclaredMethod("getMac", android.content.Context.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                java.lang.Object invoke = declaredMethod.invoke(com.umeng.commonsdk.statistics.common.DeviceConfig.class, context);
                if (invoke != null && (invoke instanceof java.lang.String)) {
                    return (java.lang.String) invoke;
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        return "";
    }

    public static void e(android.content.Context context, java.lang.String str) {
        android.content.SharedPreferences a2;
        android.content.SharedPreferences.Editor edit;
        if (context == null || str == null || android.text.TextUtils.isEmpty(str) || (a2 = com.umeng.umzid.a.a(context)) == null || (edit = a2.edit()) == null) {
            return;
        }
        edit.putString("aaid", str).commit();
    }

    public static java.lang.String f(android.content.Context context) {
        try {
            java.lang.String str = com.umeng.commonsdk.statistics.common.DeviceConfig.UNKNOW;
            java.lang.reflect.Method declaredMethod = com.umeng.commonsdk.statistics.common.DeviceConfig.class.getDeclaredMethod("getOaid", android.content.Context.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                java.lang.Object invoke = declaredMethod.invoke(com.umeng.commonsdk.statistics.common.DeviceConfig.class, context);
                if (invoke != null && (invoke instanceof java.lang.String)) {
                    return (java.lang.String) invoke;
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        return "";
    }

    public static void f(android.content.Context context, java.lang.String str) {
        android.content.SharedPreferences a2;
        android.content.SharedPreferences.Editor edit;
        if (context == null || str == null || android.text.TextUtils.isEmpty(str) || (a2 = com.umeng.umzid.a.a(context)) == null || (edit = a2.edit()) == null) {
            return;
        }
        edit.putString("zdata", str).commit();
    }

    public static boolean g(android.content.Context context) {
        boolean z;
        try {
            java.lang.String path = context.getFilesDir().getPath();
            for (java.lang.String str : a) {
                if (path.contains(str)) {
                    z = true;
                    break;
                }
            }
        } catch (java.lang.Throwable th) {
            try {
                th.printStackTrace();
            } catch (java.lang.Throwable th2) {
                th2.printStackTrace();
                return false;
            }
        }
        z = false;
        return z;
    }

    public static boolean h(android.content.Context context) {
        try {
            java.lang.String str = com.umeng.commonsdk.utils.UMUtils.UNKNOW;
            java.lang.reflect.Method declaredMethod = com.umeng.commonsdk.utils.UMUtils.class.getDeclaredMethod("isMainProgress", android.content.Context.class);
            if (declaredMethod == null) {
                return true;
            }
            declaredMethod.setAccessible(true);
            return ((java.lang.Boolean) declaredMethod.invoke(com.umeng.commonsdk.utils.UMUtils.class, context)).booleanValue();
        } catch (java.lang.Throwable unused) {
            return true;
        }
    }

    public static boolean i(android.content.Context context) {
        android.net.NetworkInfo networkInfo;
        if (context != null) {
            try {
                android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null && (networkInfo = connectivityManager.getNetworkInfo(17)) != null) {
                    return networkInfo.isConnected();
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static boolean j(android.content.Context context) {
        try {
            java.lang.String property = java.lang.System.getProperty(org.apache.tools.ant.util.ProxySetup.HTTP_PROXY_HOST);
            java.lang.String property2 = java.lang.System.getProperty(org.apache.tools.ant.util.ProxySetup.HTTP_PROXY_PORT);
            if (property2 == null) {
                property2 = "-1";
            }
            return (android.text.TextUtils.isEmpty(property) || java.lang.Integer.parseInt(property2) == -1) ? false : true;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
