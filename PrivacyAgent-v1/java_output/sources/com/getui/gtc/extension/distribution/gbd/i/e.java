package com.getui.gtc.extension.distribution.gbd.i;

/* loaded from: classes22.dex */
public final class e extends android.content.BroadcastReceiver {
    private static final java.lang.String a = "GBD_TransmissionReceiver";

    @Override // android.content.BroadcastReceiver
    public final void onReceive(android.content.Context context, android.content.Intent intent) {
        try {
            android.os.Bundle extras = intent.getExtras();
            if (extras != null && extras.containsKey("action") && extras.containsKey("payload")) {
                extras.getString("taskid");
                extras.getString("messageid");
                com.getui.gtc.extension.distribution.gbd.n.h.a();
            }
        } catch (java.lang.Exception e) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e);
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, e.toString());
        }
    }
}
