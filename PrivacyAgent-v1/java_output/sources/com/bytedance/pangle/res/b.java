package com.bytedance.pangle.res;

/* loaded from: classes.dex */
public final class b {
    public static void a(android.view.LayoutInflater layoutInflater) {
        try {
            com.bytedance.pangle.util.FieldUtils.writeField(layoutInflater, "mFactory", (java.lang.Object) null);
        } catch (java.lang.Throwable unused) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_RESOURCES, "clearFactory failed.");
        }
        try {
            com.bytedance.pangle.util.FieldUtils.writeField(layoutInflater, "mFactory2", (java.lang.Object) null);
        } catch (java.lang.Throwable unused2) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_RESOURCES, "clearFactory failed.");
        }
    }
}
