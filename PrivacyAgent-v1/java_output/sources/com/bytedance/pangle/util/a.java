package com.bytedance.pangle.util;

/* loaded from: classes.dex */
public final class a {
    public static void a(com.bytedance.pangle.activity.IPluginActivity iPluginActivity, android.app.Activity activity) {
        try {
            com.bytedance.pangle.util.FieldUtils.writeField(iPluginActivity, "mTheme", (java.lang.Object) null);
            com.bytedance.pangle.util.FieldUtils.writeField((java.lang.Object) iPluginActivity, "mThemeResource", (java.lang.Object) 0);
            int[] a = a(activity);
            if (a == null) {
                return;
            }
            for (int i : a) {
                if (i != 0) {
                    iPluginActivity.setProxyTheme2Plugin(i);
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(com.bytedance.pangle.wrapper.a aVar, android.app.Activity activity) {
        try {
            com.bytedance.pangle.util.FieldUtils.writeField(aVar, "mTheme", (java.lang.Object) null);
            com.bytedance.pangle.util.FieldUtils.writeField((java.lang.Object) aVar, "mThemeResource", (java.lang.Object) 0);
            int[] a = a(activity);
            if (a == null) {
                return;
            }
            for (int i : a) {
                if (i != 0) {
                    aVar.setWrapperActivityTheme(i);
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private static int[] a(android.app.Activity activity) {
        android.content.res.Resources.Theme theme = activity.getTheme();
        if (theme == null) {
            return null;
        }
        try {
            if (com.bytedance.pangle.util.i.h()) {
                java.lang.Object readField = com.bytedance.pangle.util.FieldUtils.readField(theme, "mThemeImpl");
                if (readField == null) {
                    return null;
                }
                try {
                    java.lang.Object invokeMethod = com.bytedance.pangle.util.MethodUtils.invokeMethod(readField, "getKey", new java.lang.Object[0]);
                    if (invokeMethod != null) {
                        return (int[]) com.bytedance.pangle.util.FieldUtils.readField(invokeMethod, "mResId");
                    }
                } catch (java.lang.Exception unused) {
                }
                java.lang.Object invoke = com.bytedance.pangle.b.b.a.a(readField.getClass(), "getKey", new java.lang.Class[0]).invoke(readField, new java.lang.Object[0]);
                if (invoke == null) {
                    com.bytedance.pangle.log.ZeusLogger.d(com.bytedance.pangle.log.ZeusLogger.TAG_ACTIVITY, "getKey failed!");
                    return null;
                }
                com.bytedance.pangle.log.ZeusLogger.d(com.bytedance.pangle.log.ZeusLogger.TAG_ACTIVITY, "getKey success by doubleReflector!");
                return (int[]) com.bytedance.pangle.b.b.a.a(invoke.getClass(), "mResId").get(invoke);
            }
            if (android.os.Build.VERSION.SDK_INT > 22) {
                java.lang.Object invokeMethod2 = com.bytedance.pangle.util.MethodUtils.invokeMethod(theme, "getKey", new java.lang.Object[0]);
                if (invokeMethod2 == null) {
                    return null;
                }
                return (int[]) com.bytedance.pangle.util.FieldUtils.readField(invokeMethod2, "mResId");
            }
            java.lang.String str = (java.lang.String) com.bytedance.pangle.util.MethodUtils.invokeMethod(theme, "getKey", new java.lang.Object[0]);
            if (str == null) {
                return null;
            }
            java.lang.String[] split = str.trim().replace("!", "").split(" ");
            int[] iArr = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                iArr[i] = java.lang.Integer.parseInt(split[i], 16);
            }
            return iArr;
        } catch (java.lang.Throwable th) {
            com.bytedance.pangle.log.ZeusLogger.d(com.bytedance.pangle.log.ZeusLogger.TAG_ACTIVITY, "getKey exception!" + th.getMessage());
            return null;
        }
    }
}
