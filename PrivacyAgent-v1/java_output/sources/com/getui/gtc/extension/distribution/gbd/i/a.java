package com.getui.gtc.extension.distribution.gbd.i;

/* loaded from: classes22.dex */
public final class a extends android.content.BroadcastReceiver {
    private static final java.lang.String a = "GBD_PKGRR";

    @Override // android.content.BroadcastReceiver
    public final void onReceive(android.content.Context context, android.content.Intent intent) {
        com.getui.gtc.extension.distribution.gbd.n.j.a(a, "onReceive 114: " + intent.getAction());
        if (com.getui.gtc.extension.distribution.gbd.f.g.a.a.a()) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "gbd cron ido closed, PKGRRT can't be executed");
            return;
        }
        if (com.getui.gtc.extension.distribution.gbd.d.h.b == null || !com.getui.gtc.extension.distribution.gbd.d.d.B) {
            return;
        }
        android.os.Message message = new android.os.Message();
        message.what = 3;
        message.obj = intent;
        com.getui.gtc.extension.distribution.gbd.d.h.b.sendMessage(message);
    }
}
