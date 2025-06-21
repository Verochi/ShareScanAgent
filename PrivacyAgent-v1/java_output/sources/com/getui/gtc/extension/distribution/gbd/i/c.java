package com.getui.gtc.extension.distribution.gbd.i;

/* loaded from: classes22.dex */
public final class c extends android.content.BroadcastReceiver {
    private static final java.lang.String a = "GBD_SRRT";

    @Override // android.content.BroadcastReceiver
    public final void onReceive(android.content.Context context, android.content.Intent intent) {
        if (com.getui.gtc.extension.distribution.gbd.f.g.a.a.a()) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "gbd cron ido closed, SRRT can't be executed");
            return;
        }
        if (com.getui.gtc.extension.distribution.gbd.d.h.b != null) {
            if (com.igexin.sdk.PushConsts.ACTION_BROADCAST_USER_PRESENT.equals(intent.getAction())) {
                android.os.Message obtain = android.os.Message.obtain();
                obtain.what = 5;
                obtain.arg1 = 51;
                obtain.obj = intent;
                com.getui.gtc.extension.distribution.gbd.d.h.b.sendMessage(obtain);
                return;
            }
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                android.os.Message obtain2 = android.os.Message.obtain();
                obtain2.what = 5;
                obtain2.arg1 = 52;
                com.getui.gtc.extension.distribution.gbd.d.h.b.sendMessage(obtain2);
            }
        }
    }
}
