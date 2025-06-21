package com.getui.gtc;

/* loaded from: classes22.dex */
public class SdkLoader {
    private static void load(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) throws java.lang.Throwable {
        try {
            java.lang.reflect.Constructor<?>[] declaredConstructors = java.lang.Class.forName(new java.lang.String(android.util.Base64.decode("ZGFsdmlrLnN5c3RlbS5EZXhDbGFzc0xvYWRlcg==", 0))).getDeclaredConstructors();
            java.lang.reflect.AccessibleObject.setAccessible(declaredConstructors, true);
            java.lang.reflect.Constructor<?> constructor = declaredConstructors[0];
            java.io.File file = new java.io.File(str);
            if (file.exists()) {
                java.io.File file2 = new java.io.File(str2, com.getui.gtc.extension.a.a(file.getName()));
                if (file2.exists()) {
                    java.io.File file3 = new java.io.File(str2, file.getName().replace(com.getui.gtc.c.a.b, com.getui.gtc.c.a.a));
                    if (file3.exists()) {
                        file3.delete();
                    }
                    file2.renameTo(file3);
                }
            }
            if (android.os.Build.VERSION.SDK_INT >= 34) {
                new java.io.File(str).setReadOnly();
            }
            java.lang.ClassLoader classLoader = (java.lang.ClassLoader) constructor.newInstance(str, str2, null, context.getClassLoader());
            java.io.File file4 = new java.io.File(str);
            if (file4.exists()) {
                java.io.File file5 = new java.io.File(str2, file4.getName().replace(com.getui.gtc.c.a.b, com.getui.gtc.c.a.a));
                if (file5.exists()) {
                    java.io.File file6 = new java.io.File(str2, com.getui.gtc.extension.a.a(file4.getName()));
                    if (file6.exists()) {
                        file6.delete();
                    }
                    file5.renameTo(file6);
                }
            }
            com.getui.gtc.h.c.a.a(" ---load--- :".concat(java.lang.String.valueOf(str)));
            com.getui.gtc.extension.b.a(context, classLoader, str3, str4, str5);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.h.c.a.c(th);
            throw th;
        }
    }
}
