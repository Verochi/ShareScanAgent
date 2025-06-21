package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public final class RendererConfiguration {
    public static final com.google.android.exoplayer2.RendererConfiguration DEFAULT = new com.google.android.exoplayer2.RendererConfiguration(0);
    public final int tunnelingAudioSessionId;

    public RendererConfiguration(int i) {
        this.tunnelingAudioSessionId = i;
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && com.google.android.exoplayer2.RendererConfiguration.class == obj.getClass() && this.tunnelingAudioSessionId == ((com.google.android.exoplayer2.RendererConfiguration) obj).tunnelingAudioSessionId;
    }

    public int hashCode() {
        return this.tunnelingAudioSessionId;
    }
}
