package com.igexin.push.h;

/* loaded from: classes23.dex */
public final class b {
    private static final java.lang.String a = "com.igexin.assist.control.stp.ManufacturePushManager";

    public static boolean a(android.content.Context context) {
        try {
            java.lang.reflect.Method declaredMethod = java.lang.Class.forName(a).getDeclaredMethod("checkDevice", android.content.Context.class);
            declaredMethod.setAccessible(true);
            boolean booleanValue = ((java.lang.Boolean) declaredMethod.invoke(null, context)).booleanValue();
            com.igexin.c.a.c.a.b("Assist_UPS", "isSupportStp: ".concat(java.lang.String.valueOf(booleanValue)));
            return booleanValue;
        } catch (java.lang.Exception e) {
            e.getMessage();
            try {
                java.lang.Class<?> cls = java.lang.Class.forName(a);
                java.lang.Object newInstance = cls.getConstructor(android.content.Context.class).newInstance(context);
                java.lang.reflect.Method declaredMethod2 = cls.getDeclaredMethod("isSupport", new java.lang.Class[0]);
                declaredMethod2.setAccessible(true);
                com.igexin.c.a.c.a.b("Assist_UPS", "isSupportStp: ".concat(java.lang.String.valueOf(((java.lang.Boolean) declaredMethod2.invoke(newInstance, new java.lang.Object[0])).booleanValue())));
            } catch (java.lang.Exception unused) {
            }
            return false;
        }
    }

    public static boolean a(android.content.Context context, java.lang.String str) {
        java.lang.String concat = com.igexin.assist.sdk.AssistPushConsts.LOG_TAG.concat(java.lang.String.valueOf(str));
        boolean z = false;
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.igexin.assist.control." + str + ".ManufacturePushManager");
            java.lang.Object newInstance = cls.getConstructor(android.content.Context.class).newInstance(context);
            java.lang.reflect.Field declaredField = cls.getDeclaredField("context");
            boolean isAccessible = declaredField.isAccessible();
            declaredField.setAccessible(true);
            declaredField.set(newInstance, context);
            declaredField.setAccessible(isAccessible);
            z = ((java.lang.Boolean) cls.getDeclaredMethod("isSupport", new java.lang.Class[0]).invoke(newInstance, new java.lang.Object[0])).booleanValue();
            com.igexin.c.a.c.a.e.a(concat, "isSupport " + str + " = " + z);
            return z;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.e.a(concat, "class non-existent  " + th.getMessage());
            return z;
        }
    }
}
