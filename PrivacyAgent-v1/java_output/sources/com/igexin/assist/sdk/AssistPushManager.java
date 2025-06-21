package com.igexin.assist.sdk;

/* loaded from: classes22.dex */
public class AssistPushManager {
    private static final java.lang.String a = "Assist_OtherPushManager";
    private com.igexin.assist.control.AbstractPushManager b;
    private java.util.concurrent.atomic.AtomicBoolean c;

    public static class a {
        private static final com.igexin.assist.sdk.AssistPushManager a = new com.igexin.assist.sdk.AssistPushManager((byte) 0);

        private a() {
        }
    }

    private AssistPushManager() {
        this.c = new java.util.concurrent.atomic.AtomicBoolean(false);
    }

    public /* synthetic */ AssistPushManager(byte b) {
        this();
    }

    public static boolean checkSupportDevice(android.content.Context context) {
        return (com.igexin.push.config.d.U && com.igexin.push.h.b.a(context.getApplicationContext(), com.igexin.assist.util.AssistUtils.BRAND_HON)) || com.igexin.push.h.b.a(context.getApplicationContext(), com.igexin.assist.util.AssistUtils.BRAND_HW) || com.igexin.push.h.b.a(context.getApplicationContext(), com.igexin.assist.util.AssistUtils.BRAND_XIAOMI) || com.igexin.push.h.b.a(context.getApplicationContext(), com.igexin.assist.util.AssistUtils.BRAND_OPPO) || com.igexin.push.h.b.a(context.getApplicationContext(), com.igexin.assist.util.AssistUtils.BRAND_MZ) || com.igexin.push.h.b.a(context.getApplicationContext(), com.igexin.assist.util.AssistUtils.BRAND_VIVO) || com.igexin.push.h.b.a(context);
    }

    public static com.igexin.assist.sdk.AssistPushManager getInstance() {
        return com.igexin.assist.sdk.AssistPushManager.a.a;
    }

    public static java.lang.String getToken() {
        return com.igexin.push.core.e.I;
    }

    public void initialize(android.content.Context context) {
        this.b = com.igexin.assist.sdk.a.a().a(context);
    }

    public void register(android.content.Context context) {
        com.igexin.assist.control.AbstractPushManager abstractPushManager = this.b;
        if (abstractPushManager != null) {
            abstractPushManager.register(context);
        }
    }

    public void saveToken(java.lang.String str) {
        com.igexin.push.core.e.f.a().b(str);
    }

    public void setSilentTime(android.content.Context context, int i, int i2) {
        com.igexin.assist.control.AbstractPushManager abstractPushManager = this.b;
        if (abstractPushManager != null) {
            abstractPushManager.setSilentTime(context, i, i2);
        }
    }

    public void turnOffPush(android.content.Context context) {
        com.igexin.assist.control.AbstractPushManager abstractPushManager = this.b;
        if (abstractPushManager != null) {
            abstractPushManager.turnOffPush(context);
        }
    }

    public void turnOnPush(android.content.Context context) {
        com.igexin.assist.control.AbstractPushManager abstractPushManager = this.b;
        if (abstractPushManager != null) {
            abstractPushManager.turnOnPush(context);
        }
    }

    public void unregister(android.content.Context context) {
        com.igexin.assist.control.AbstractPushManager abstractPushManager = this.b;
        if (abstractPushManager != null) {
            abstractPushManager.unregister(context);
        }
    }
}
