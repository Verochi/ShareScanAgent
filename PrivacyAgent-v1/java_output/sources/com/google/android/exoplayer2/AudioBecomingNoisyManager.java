package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
final class AudioBecomingNoisyManager {
    public final android.content.Context a;
    public final com.google.android.exoplayer2.AudioBecomingNoisyManager.AudioBecomingNoisyReceiver b;
    public boolean c;

    public final class AudioBecomingNoisyReceiver extends android.content.BroadcastReceiver implements java.lang.Runnable {
        public final com.google.android.exoplayer2.AudioBecomingNoisyManager.EventListener n;
        public final android.os.Handler t;

        public AudioBecomingNoisyReceiver(android.os.Handler handler, com.google.android.exoplayer2.AudioBecomingNoisyManager.EventListener eventListener) {
            this.t = handler;
            this.n = eventListener;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.t.post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.google.android.exoplayer2.AudioBecomingNoisyManager.this.c) {
                this.n.onAudioBecomingNoisy();
            }
        }
    }

    public interface EventListener {
        void onAudioBecomingNoisy();
    }

    public AudioBecomingNoisyManager(android.content.Context context, android.os.Handler handler, com.google.android.exoplayer2.AudioBecomingNoisyManager.EventListener eventListener) {
        this.a = context.getApplicationContext();
        this.b = new com.google.android.exoplayer2.AudioBecomingNoisyManager.AudioBecomingNoisyReceiver(handler, eventListener);
    }

    public void b(boolean z) {
        if (z && !this.c) {
            this.a.registerReceiver(this.b, new android.content.IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
            this.c = true;
        } else {
            if (z || !this.c) {
                return;
            }
            this.a.unregisterReceiver(this.b);
            this.c = false;
        }
    }
}
