package com.getui.gtc.extension.distribution.gbd.n.a;

/* loaded from: classes22.dex */
public final class c {
    private static int a(java.lang.Object obj, java.lang.String str) {
        try {
            java.lang.reflect.Field declaredField = obj.getClass().getEnclosingClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            return ((java.lang.Integer) declaredField.get(obj)).intValue();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return 0;
        }
    }

    private static java.lang.String a(java.lang.Object obj) {
        try {
            return (java.lang.String) obj.getClass().getDeclaredMethod("getInterfaceDescriptor", new java.lang.Class[0]).invoke(obj, new java.lang.Object[0]);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return "";
        }
    }
}
