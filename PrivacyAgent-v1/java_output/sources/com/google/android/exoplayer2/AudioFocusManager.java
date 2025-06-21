package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
final class AudioFocusManager {
    public final android.media.AudioManager a;
    public final com.google.android.exoplayer2.AudioFocusManager.AudioFocusListener b;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.AudioFocusManager.PlayerControl c;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.audio.AudioAttributes d;
    public int f;
    public android.media.AudioFocusRequest h;
    public boolean i;
    public float g = 1.0f;
    public int e = 0;

    public class AudioFocusListener implements android.media.AudioManager.OnAudioFocusChangeListener {
        public final android.os.Handler a;

        public AudioFocusListener(android.os.Handler handler) {
            this.a = handler;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(int i) {
            com.google.android.exoplayer2.AudioFocusManager.this.h(i);
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            this.a.post(new com.google.android.exoplayer2.a(this, i));
        }
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface PlayerCommand {
    }

    public interface PlayerControl {
        void executePlayerCommand(int i);

        void setVolumeMultiplier(float f);
    }

    public AudioFocusManager(android.content.Context context, android.os.Handler handler, com.google.android.exoplayer2.AudioFocusManager.PlayerControl playerControl) {
        this.a = (android.media.AudioManager) com.google.android.exoplayer2.util.Assertions.checkNotNull((android.media.AudioManager) context.getApplicationContext().getSystemService("audio"));
        this.c = playerControl;
        this.b = new com.google.android.exoplayer2.AudioFocusManager.AudioFocusListener(handler);
    }

    public static int e(@androidx.annotation.Nullable com.google.android.exoplayer2.audio.AudioAttributes audioAttributes) {
        if (audioAttributes == null) {
            return 0;
        }
        int i = audioAttributes.usage;
        switch (i) {
            case 0:
                com.google.android.exoplayer2.util.Log.w("AudioFocusManager", "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default.");
                return 1;
            case 1:
            case 14:
                return 1;
            case 2:
            case 4:
                return 2;
            case 3:
                return 0;
            case 11:
                if (audioAttributes.contentType == 1) {
                    return 2;
                }
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
                return 3;
            case 15:
            default:
                java.lang.StringBuilder sb = new java.lang.StringBuilder(37);
                sb.append("Unidentified audio usage: ");
                sb.append(i);
                com.google.android.exoplayer2.util.Log.w("AudioFocusManager", sb.toString());
                return 0;
            case 16:
                return com.google.android.exoplayer2.util.Util.SDK_INT >= 19 ? 4 : 2;
        }
    }

    public final void a() {
        if (this.e == 0) {
            return;
        }
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 26) {
            c();
        } else {
            b();
        }
        n(0);
    }

    public final void b() {
        this.a.abandonAudioFocus(this.b);
    }

    @androidx.annotation.RequiresApi(26)
    public final void c() {
        android.media.AudioFocusRequest audioFocusRequest = this.h;
        if (audioFocusRequest != null) {
            this.a.abandonAudioFocusRequest(audioFocusRequest);
        }
    }

    public final void f(int i) {
        com.google.android.exoplayer2.AudioFocusManager.PlayerControl playerControl = this.c;
        if (playerControl != null) {
            playerControl.executePlayerCommand(i);
        }
    }

    public float g() {
        return this.g;
    }

    public final void h(int i) {
        if (i == -3 || i == -2) {
            if (i != -2 && !q()) {
                n(3);
                return;
            } else {
                f(0);
                n(2);
                return;
            }
        }
        if (i == -1) {
            f(-1);
            a();
        } else if (i == 1) {
            n(1);
            f(1);
        } else {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(38);
            sb.append("Unknown focus change type: ");
            sb.append(i);
            com.google.android.exoplayer2.util.Log.w("AudioFocusManager", sb.toString());
        }
    }

    public void i() {
        this.c = null;
        a();
    }

    public final int j() {
        if (this.e == 1) {
            return 1;
        }
        if ((com.google.android.exoplayer2.util.Util.SDK_INT >= 26 ? l() : k()) == 1) {
            n(1);
            return 1;
        }
        n(0);
        return -1;
    }

    public final int k() {
        return this.a.requestAudioFocus(this.b, com.google.android.exoplayer2.util.Util.getStreamTypeForAudioUsage(((com.google.android.exoplayer2.audio.AudioAttributes) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.d)).usage), this.f);
    }

    @androidx.annotation.RequiresApi(26)
    public final int l() {
        android.media.AudioFocusRequest.Builder audioAttributes;
        android.media.AudioFocusRequest.Builder willPauseWhenDucked;
        android.media.AudioFocusRequest.Builder onAudioFocusChangeListener;
        android.media.AudioFocusRequest build;
        int requestAudioFocus;
        android.media.AudioFocusRequest audioFocusRequest = this.h;
        if (audioFocusRequest == null || this.i) {
            android.media.AudioFocusRequest.Builder builder = audioFocusRequest == null ? new android.media.AudioFocusRequest.Builder(this.f) : new android.media.AudioFocusRequest.Builder(this.h);
            boolean q = q();
            audioAttributes = builder.setAudioAttributes(((com.google.android.exoplayer2.audio.AudioAttributes) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.d)).getAudioAttributesV21());
            willPauseWhenDucked = audioAttributes.setWillPauseWhenDucked(q);
            onAudioFocusChangeListener = willPauseWhenDucked.setOnAudioFocusChangeListener(this.b);
            build = onAudioFocusChangeListener.build();
            this.h = build;
            this.i = false;
        }
        requestAudioFocus = this.a.requestAudioFocus(this.h);
        return requestAudioFocus;
    }

    public void m(@androidx.annotation.Nullable com.google.android.exoplayer2.audio.AudioAttributes audioAttributes) {
        if (com.google.android.exoplayer2.util.Util.areEqual(this.d, audioAttributes)) {
            return;
        }
        this.d = audioAttributes;
        int e = e(audioAttributes);
        this.f = e;
        boolean z = true;
        if (e != 1 && e != 0) {
            z = false;
        }
        com.google.android.exoplayer2.util.Assertions.checkArgument(z, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
    }

    public final void n(int i) {
        if (this.e == i) {
            return;
        }
        this.e = i;
        float f = i == 3 ? 0.2f : 1.0f;
        if (this.g == f) {
            return;
        }
        this.g = f;
        com.google.android.exoplayer2.AudioFocusManager.PlayerControl playerControl = this.c;
        if (playerControl != null) {
            playerControl.setVolumeMultiplier(f);
        }
    }

    public final boolean o(int i) {
        return i == 1 || this.f != 1;
    }

    public int p(boolean z, int i) {
        if (o(i)) {
            a();
            return z ? 1 : -1;
        }
        if (z) {
            return j();
        }
        return -1;
    }

    public final boolean q() {
        com.google.android.exoplayer2.audio.AudioAttributes audioAttributes = this.d;
        return audioAttributes != null && audioAttributes.contentType == 1;
    }
}
