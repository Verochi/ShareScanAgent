package com.getui.gtc.extension;

import com.getui.gtc.extension.a.a.AnonymousClass2;

/* loaded from: classes22.dex */
public final class b {
    private static final java.util.Map<java.lang.String, java.lang.ClassLoader> a = new java.util.HashMap();

    public static java.lang.ClassLoader a(android.os.Bundle bundle) {
        return a.get(bundle.getString(com.meizu.cloud.pushsdk.notification.model.AdvanceSetting.CLEAR_NOTIFICATION));
    }

    public static void a(android.content.Context context, java.lang.ClassLoader classLoader, java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.lang.Throwable {
        java.lang.Class<?> loadClass = classLoader.loadClass(str);
        com.getui.gtc.h.c.a.a("start load for class:" + str + ", appId: " + str2 + ", cid: " + str3);
        loadClass.getDeclaredMethod("onCreate", android.content.Context.class, java.lang.String.class, java.lang.String.class).invoke(loadClass.newInstance(), context, str2, str3);
        com.getui.gtc.h.c.a.a("load success for class:".concat(java.lang.String.valueOf(str)));
        a.put(str, classLoader);
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.lang.Throwable {
        a(context, context.getClassLoader(), str, str2, str3);
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) throws java.lang.Throwable {
        java.lang.reflect.Method declaredMethod = com.getui.gtc.SdkLoader.class.getDeclaredMethod("load", android.content.Context.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(com.getui.gtc.SdkLoader.class, context, str, str2, str3, str4, str5);
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, com.getui.gtc.extension.a.b bVar) {
        com.getui.gtc.extension.a.a aVar = new com.getui.gtc.extension.a.a(bVar);
        if (aVar.b != null) {
            aVar.a(str, str2, str3, str4, str5);
            return;
        }
        try {
            int i = com.igexin.sdk.PushService.n;
            java.lang.Class<com.igexin.sdk.PushService> cls = com.igexin.sdk.PushService.class;
            java.lang.Class<com.igexin.sdk.PushService> cls2 = (java.lang.Class) com.getui.gtc.extension.a.a.a(context, cls).second;
            if (cls2 != null) {
                cls = cls2;
            }
            android.content.Intent intent = new android.content.Intent(context, cls);
            intent.setType(com.getui.gtc.BuildConfig.VERSION_NAME);
            context.bindService(intent, aVar.new AnonymousClass2(str, str2, str3, str4, str5), 1);
        } catch (java.lang.Exception e) {
            com.getui.gtc.h.c.a.c(e);
        }
    }

    public static boolean a(android.content.Context context, android.os.Bundle bundle) {
        try {
            java.lang.String string = bundle.getString("dp");
            java.lang.String string2 = bundle.getString(com.umeng.analytics.pro.bo.aC);
            java.lang.String string3 = bundle.getString("gd");
            java.lang.String string4 = bundle.getString("od");
            java.lang.String string5 = bundle.getString(com.meizu.cloud.pushsdk.notification.model.AdvanceSetting.CLEAR_NOTIFICATION);
            if (string == null) {
                a(context, string5, string2, string3);
                return true;
            }
            a(context, string, string4, string5, string2, string3);
            return true;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.h.c.a.c(th.toString());
            return false;
        }
    }
}
