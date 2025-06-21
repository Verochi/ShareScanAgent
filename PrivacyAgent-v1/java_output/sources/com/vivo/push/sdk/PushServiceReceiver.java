package com.vivo.push.sdk;

/* loaded from: classes19.dex */
public class PushServiceReceiver extends android.content.BroadcastReceiver {
    private static android.os.HandlerThread a;
    private static android.os.Handler b;
    private static com.vivo.push.sdk.PushServiceReceiver.a c = new com.vivo.push.sdk.PushServiceReceiver.a();

    public static class a implements java.lang.Runnable {
        private android.content.Context a;
        private java.lang.String b;

        public static /* synthetic */ void a(com.vivo.push.sdk.PushServiceReceiver.a aVar, android.content.Context context, java.lang.String str) {
            aVar.a = com.vivo.push.util.ContextDelegate.getContext(context);
            aVar.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.net.NetworkInfo a = com.vivo.push.util.r.a(this.a);
            if (!(a != null ? a.isConnectedOrConnecting() : false)) {
                com.vivo.push.util.p.d("PushServiceReceiver", this.a.getPackageName() + ": 无网络  by " + this.b);
                com.vivo.push.util.p.a(this.a, "触发静态广播:无网络(" + this.b + "," + this.a.getPackageName() + ")");
                return;
            }
            com.vivo.push.util.p.d("PushServiceReceiver", this.a.getPackageName() + ": 执行开始出发动作: " + this.b);
            com.vivo.push.util.p.a(this.a, "触发静态广播(" + this.b + "," + this.a.getPackageName() + ")");
            com.vivo.push.e.a().a(this.a);
            if (com.vivo.push.cache.ClientConfigManagerImpl.getInstance(this.a).isCancleBroadcastReceiver()) {
                return;
            }
            try {
                com.vivo.push.PushClient.getInstance(this.a).initialize();
            } catch (com.vivo.push.util.VivoPushException e) {
                e.printStackTrace();
                com.vivo.push.util.p.a(this.a, " 初始化异常 error= " + e.getMessage());
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        android.content.Context context2 = com.vivo.push.util.ContextDelegate.getContext(context);
        java.lang.String action = intent.getAction();
        if (com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(action) || "android.intent.action.ACTION_POWER_CONNECTED".equals(action) || "android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
            if (a == null) {
                android.os.HandlerThread handlerThread = new android.os.HandlerThread("PushServiceReceiver");
                a = handlerThread;
                handlerThread.start();
                b = new android.os.Handler(a.getLooper());
            }
            com.vivo.push.util.p.d("PushServiceReceiver", context2.getPackageName() + ": start PushSerevice for by " + action + "  ; handler : " + b);
            com.vivo.push.sdk.PushServiceReceiver.a.a(c, context2, action);
            b.removeCallbacks(c);
            b.postDelayed(c, 2000L);
        }
    }
}
