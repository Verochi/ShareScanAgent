package com.anythink.expressad.exoplayer.b;

/* loaded from: classes12.dex */
public final class d {
    com.anythink.expressad.exoplayer.b.c a;
    private final android.content.Context b;
    private final com.anythink.expressad.exoplayer.b.d.b c;
    private final android.content.BroadcastReceiver d;

    public final class a extends android.content.BroadcastReceiver {
        private a() {
        }

        public /* synthetic */ a(com.anythink.expressad.exoplayer.b.d dVar, byte b) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(android.content.Context context, android.content.Intent intent) {
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            if (isInitialStickyBroadcast()) {
                return;
            }
            com.anythink.expressad.exoplayer.b.c a = com.anythink.expressad.exoplayer.b.c.a(intent);
            if (a.equals(com.anythink.expressad.exoplayer.b.d.this.a)) {
                return;
            }
            com.anythink.expressad.exoplayer.b.d dVar = com.anythink.expressad.exoplayer.b.d.this;
            dVar.a = a;
            com.anythink.expressad.exoplayer.b.d.b unused = dVar.c;
        }
    }

    public interface b {
        void a();
    }

    private d(android.content.Context context, com.anythink.expressad.exoplayer.b.d.b bVar) {
        this.b = (android.content.Context) com.anythink.expressad.exoplayer.k.a.a(context);
        this.c = (com.anythink.expressad.exoplayer.b.d.b) com.anythink.expressad.exoplayer.k.a.a(bVar);
        this.d = com.anythink.expressad.exoplayer.k.af.a >= 21 ? new com.anythink.expressad.exoplayer.b.d.a(this, (byte) 0) : null;
    }

    private com.anythink.expressad.exoplayer.b.c a() {
        android.content.BroadcastReceiver broadcastReceiver = this.d;
        com.anythink.expressad.exoplayer.b.c a2 = com.anythink.expressad.exoplayer.b.c.a(broadcastReceiver == null ? null : this.b.registerReceiver(broadcastReceiver, new android.content.IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
        this.a = a2;
        return a2;
    }

    private void b() {
        android.content.BroadcastReceiver broadcastReceiver = this.d;
        if (broadcastReceiver != null) {
            this.b.unregisterReceiver(broadcastReceiver);
        }
    }
}
