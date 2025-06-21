package com.igexin.push.core;

/* loaded from: classes23.dex */
public class i extends android.content.BroadcastReceiver {
    public static final java.lang.String a = "GTReceiver";
    private static volatile com.igexin.push.core.i b;

    private i() {
    }

    public static com.igexin.push.core.i a() {
        if (b == null) {
            synchronized (com.igexin.push.core.i.class) {
                if (b == null) {
                    b = new com.igexin.push.core.i();
                }
            }
        }
        return b;
    }

    private static void a(android.content.Intent intent) {
        try {
            intent.getAction();
            intent.getComponent();
            com.igexin.c.a.c.a.a("----------------------------------------------------------------------------------", new java.lang.Object[0]);
            com.igexin.c.a.c.a.a("GTReceiver|action = " + intent.getAction() + ", component = " + intent.getComponent(), new java.lang.Object[0]);
            android.os.Bundle extras = intent.getExtras();
            if (extras == null) {
                com.igexin.c.a.c.a.a("GTReceiver|no extras", new java.lang.Object[0]);
                return;
            }
            for (java.lang.String str : extras.keySet()) {
                extras.get(str);
                com.igexin.c.a.c.a.a("GTReceiver|key [" + str + "]: " + extras.get(str), new java.lang.Object[0]);
            }
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        if (intent != null && intent.getAction() != null && intent.getAction().equals(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE)) {
            try {
                intent.getAction();
                intent.getComponent();
                com.igexin.c.a.c.a.a("----------------------------------------------------------------------------------", new java.lang.Object[0]);
                com.igexin.c.a.c.a.a("GTReceiver|action = " + intent.getAction() + ", component = " + intent.getComponent(), new java.lang.Object[0]);
                android.os.Bundle extras = intent.getExtras();
                if (extras != null) {
                    for (java.lang.String str : extras.keySet()) {
                        extras.get(str);
                        com.igexin.c.a.c.a.a("GTReceiver|key [" + str + "]: " + extras.get(str), new java.lang.Object[0]);
                    }
                } else {
                    com.igexin.c.a.c.a.a("GTReceiver|no extras", new java.lang.Object[0]);
                }
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("GTReceiver InternalPublicReceiver:");
        sb.append(intent != null ? intent.getAction() : com.igexin.push.core.b.m);
        com.igexin.c.a.c.a.a(sb.toString(), new java.lang.Object[0]);
        if (intent != null) {
            intent.getAction();
        }
        android.os.Message obtain = android.os.Message.obtain();
        obtain.what = "com.igexin.action.notification.click".equals(intent.getAction()) ? com.igexin.push.core.b.P : com.igexin.push.core.b.Q;
        obtain.obj = intent;
        com.igexin.push.core.d.a.a.a(obtain);
    }
}
