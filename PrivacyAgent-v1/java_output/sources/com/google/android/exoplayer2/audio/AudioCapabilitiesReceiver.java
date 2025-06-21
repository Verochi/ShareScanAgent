package com.google.android.exoplayer2.audio;

/* loaded from: classes22.dex */
public final class AudioCapabilitiesReceiver {
    public final android.content.Context a;
    public final com.google.android.exoplayer2.audio.AudioCapabilitiesReceiver.Listener b;
    public final android.os.Handler c;

    @androidx.annotation.Nullable
    public final android.content.BroadcastReceiver d;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.audio.AudioCapabilitiesReceiver.ExternalSurroundSoundSettingObserver e;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.audio.AudioCapabilities f;
    public boolean g;

    public final class ExternalSurroundSoundSettingObserver extends android.database.ContentObserver {
        public final android.content.ContentResolver a;
        public final android.net.Uri b;

        public ExternalSurroundSoundSettingObserver(android.os.Handler handler, android.content.ContentResolver contentResolver, android.net.Uri uri) {
            super(handler);
            this.a = contentResolver;
            this.b = uri;
        }

        public void a() {
            this.a.registerContentObserver(this.b, false, this);
        }

        public void b() {
            this.a.unregisterContentObserver(this);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            com.google.android.exoplayer2.audio.AudioCapabilitiesReceiver audioCapabilitiesReceiver = com.google.android.exoplayer2.audio.AudioCapabilitiesReceiver.this;
            audioCapabilitiesReceiver.c(com.google.android.exoplayer2.audio.AudioCapabilities.getCapabilities(audioCapabilitiesReceiver.a));
        }
    }

    public final class HdmiAudioPlugBroadcastReceiver extends android.content.BroadcastReceiver {
        public HdmiAudioPlugBroadcastReceiver() {
        }

        public /* synthetic */ HdmiAudioPlugBroadcastReceiver(com.google.android.exoplayer2.audio.AudioCapabilitiesReceiver audioCapabilitiesReceiver, com.google.android.exoplayer2.audio.AudioCapabilitiesReceiver.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            if (isInitialStickyBroadcast()) {
                return;
            }
            com.google.android.exoplayer2.audio.AudioCapabilitiesReceiver.this.c(com.google.android.exoplayer2.audio.AudioCapabilities.b(context, intent));
        }
    }

    public interface Listener {
        void onAudioCapabilitiesChanged(com.google.android.exoplayer2.audio.AudioCapabilities audioCapabilities);
    }

    public AudioCapabilitiesReceiver(android.content.Context context, com.google.android.exoplayer2.audio.AudioCapabilitiesReceiver.Listener listener) {
        android.content.Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = (com.google.android.exoplayer2.audio.AudioCapabilitiesReceiver.Listener) com.google.android.exoplayer2.util.Assertions.checkNotNull(listener);
        android.os.Handler createHandlerForCurrentOrMainLooper = com.google.android.exoplayer2.util.Util.createHandlerForCurrentOrMainLooper();
        this.c = createHandlerForCurrentOrMainLooper;
        this.d = com.google.android.exoplayer2.util.Util.SDK_INT >= 21 ? new com.google.android.exoplayer2.audio.AudioCapabilitiesReceiver.HdmiAudioPlugBroadcastReceiver(this, null) : null;
        android.net.Uri c = com.google.android.exoplayer2.audio.AudioCapabilities.c();
        this.e = c != null ? new com.google.android.exoplayer2.audio.AudioCapabilitiesReceiver.ExternalSurroundSoundSettingObserver(createHandlerForCurrentOrMainLooper, applicationContext.getContentResolver(), c) : null;
    }

    public final void c(com.google.android.exoplayer2.audio.AudioCapabilities audioCapabilities) {
        if (!this.g || audioCapabilities.equals(this.f)) {
            return;
        }
        this.f = audioCapabilities;
        this.b.onAudioCapabilitiesChanged(audioCapabilities);
    }

    public com.google.android.exoplayer2.audio.AudioCapabilities register() {
        if (this.g) {
            return (com.google.android.exoplayer2.audio.AudioCapabilities) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.f);
        }
        this.g = true;
        com.google.android.exoplayer2.audio.AudioCapabilitiesReceiver.ExternalSurroundSoundSettingObserver externalSurroundSoundSettingObserver = this.e;
        if (externalSurroundSoundSettingObserver != null) {
            externalSurroundSoundSettingObserver.a();
        }
        android.content.Intent intent = null;
        if (this.d != null) {
            intent = this.a.registerReceiver(this.d, new android.content.IntentFilter("android.media.action.HDMI_AUDIO_PLUG"), null, this.c);
        }
        com.google.android.exoplayer2.audio.AudioCapabilities b = com.google.android.exoplayer2.audio.AudioCapabilities.b(this.a, intent);
        this.f = b;
        return b;
    }

    public void unregister() {
        if (this.g) {
            this.f = null;
            android.content.BroadcastReceiver broadcastReceiver = this.d;
            if (broadcastReceiver != null) {
                this.a.unregisterReceiver(broadcastReceiver);
            }
            com.google.android.exoplayer2.audio.AudioCapabilitiesReceiver.ExternalSurroundSoundSettingObserver externalSurroundSoundSettingObserver = this.e;
            if (externalSurroundSoundSettingObserver != null) {
                externalSurroundSoundSettingObserver.b();
            }
            this.g = false;
        }
    }
}
