package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
final class StreamVolumeManager {
    public final android.content.Context a;
    public final android.os.Handler b;
    public final com.google.android.exoplayer2.StreamVolumeManager.Listener c;
    public final android.media.AudioManager d;
    public final com.google.android.exoplayer2.StreamVolumeManager.VolumeChangeReceiver e;
    public int f;
    public int g;
    public boolean h;
    public boolean i;

    public interface Listener {
        void onStreamTypeChanged(int i);

        void onStreamVolumeChanged(int i, boolean z);
    }

    public final class VolumeChangeReceiver extends android.content.BroadcastReceiver {
        public VolumeChangeReceiver() {
        }

        public /* synthetic */ VolumeChangeReceiver(com.google.android.exoplayer2.StreamVolumeManager streamVolumeManager, com.google.android.exoplayer2.StreamVolumeManager.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            com.google.android.exoplayer2.StreamVolumeManager.this.b.post(new com.google.android.exoplayer2.c0(com.google.android.exoplayer2.StreamVolumeManager.this));
        }
    }

    public StreamVolumeManager(android.content.Context context, android.os.Handler handler, com.google.android.exoplayer2.StreamVolumeManager.Listener listener) {
        android.content.Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = handler;
        this.c = listener;
        android.media.AudioManager audioManager = (android.media.AudioManager) com.google.android.exoplayer2.util.Assertions.checkStateNotNull((android.media.AudioManager) applicationContext.getSystemService("audio"));
        this.d = audioManager;
        this.f = 3;
        this.g = h(audioManager, 3);
        this.h = f(audioManager, this.f);
        com.google.android.exoplayer2.StreamVolumeManager.VolumeChangeReceiver volumeChangeReceiver = new com.google.android.exoplayer2.StreamVolumeManager.VolumeChangeReceiver(this, null);
        this.e = volumeChangeReceiver;
        applicationContext.registerReceiver(volumeChangeReceiver, new android.content.IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
    }

    public static /* synthetic */ void b(com.google.android.exoplayer2.StreamVolumeManager streamVolumeManager) {
        streamVolumeManager.o();
    }

    public static boolean f(android.media.AudioManager audioManager, int i) {
        boolean isStreamMute;
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 23) {
            return audioManager.getStreamVolume(i) == 0;
        }
        isStreamMute = audioManager.isStreamMute(i);
        return isStreamMute;
    }

    public static int h(android.media.AudioManager audioManager, int i) {
        return audioManager.getStreamVolume(i);
    }

    public void c() {
        if (this.g <= e()) {
            return;
        }
        this.d.adjustStreamVolume(this.f, -1, 1);
        o();
    }

    public int d() {
        return this.d.getStreamMaxVolume(this.f);
    }

    public int e() {
        int streamMinVolume;
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 28) {
            return 0;
        }
        streamMinVolume = this.d.getStreamMinVolume(this.f);
        return streamMinVolume;
    }

    public int g() {
        return this.g;
    }

    public void i() {
        if (this.g >= d()) {
            return;
        }
        this.d.adjustStreamVolume(this.f, 1, 1);
        o();
    }

    public boolean j() {
        return this.h;
    }

    public void k() {
        if (this.i) {
            return;
        }
        this.a.unregisterReceiver(this.e);
        this.i = true;
    }

    public void l(boolean z) {
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 23) {
            this.d.adjustStreamVolume(this.f, z ? -100 : 100, 1);
        } else {
            this.d.setStreamMute(this.f, z);
        }
        o();
    }

    public void m(int i) {
        if (this.f == i) {
            return;
        }
        this.f = i;
        o();
        this.c.onStreamTypeChanged(i);
    }

    public void n(int i) {
        if (i < e() || i > d()) {
            return;
        }
        this.d.setStreamVolume(this.f, i, 1);
        o();
    }

    public final void o() {
        int h = h(this.d, this.f);
        boolean f = f(this.d, this.f);
        if (this.g == h && this.h == f) {
            return;
        }
        this.g = h;
        this.h = f;
        this.c.onStreamVolumeChanged(h, f);
    }
}
