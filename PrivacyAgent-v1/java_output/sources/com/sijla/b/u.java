package com.sijla.b;

/* loaded from: classes19.dex */
public final class u {
    private android.content.Context a;
    private com.sijla.b.u.a b = new com.sijla.b.u.a(this, (byte) 0);
    private com.sijla.b.u.b c;

    public class a extends android.content.BroadcastReceiver {
        private java.lang.String a;

        private a() {
            this.a = null;
        }

        public /* synthetic */ a(com.sijla.b.u uVar, byte b) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(android.content.Context context, android.content.Intent intent) {
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            try {
                java.lang.String action = intent.getAction();
                this.a = action;
                if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    com.sijla.b.u.this.c.e();
                } else if (com.igexin.sdk.PushConsts.ACTION_BROADCAST_USER_PRESENT.equals(this.a)) {
                    com.sijla.b.u.this.c.d();
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public interface b {
        void d();

        void e();
    }

    public u(android.content.Context context) {
        this.a = context;
    }

    public final void a(com.sijla.b.u.b bVar) {
        this.c = bVar;
        try {
            android.content.IntentFilter intentFilter = new android.content.IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction(com.igexin.sdk.PushConsts.ACTION_BROADCAST_USER_PRESENT);
            this.a.registerReceiver(this.b, intentFilter);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
