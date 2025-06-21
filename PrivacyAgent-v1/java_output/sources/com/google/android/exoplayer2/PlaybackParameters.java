package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public final class PlaybackParameters {
    public static final com.google.android.exoplayer2.PlaybackParameters DEFAULT = new com.google.android.exoplayer2.PlaybackParameters(1.0f);
    public final int a;
    public final float pitch;
    public final float speed;

    public PlaybackParameters(float f) {
        this(f, 1.0f);
    }

    public PlaybackParameters(float f, float f2) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(f > 0.0f);
        com.google.android.exoplayer2.util.Assertions.checkArgument(f2 > 0.0f);
        this.speed = f;
        this.pitch = f2;
        this.a = java.lang.Math.round(f * 1000.0f);
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.google.android.exoplayer2.PlaybackParameters.class != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.PlaybackParameters playbackParameters = (com.google.android.exoplayer2.PlaybackParameters) obj;
        return this.speed == playbackParameters.speed && this.pitch == playbackParameters.pitch;
    }

    public long getMediaTimeUsForPlayoutTimeMs(long j) {
        return j * this.a;
    }

    public int hashCode() {
        return ((527 + java.lang.Float.floatToRawIntBits(this.speed)) * 31) + java.lang.Float.floatToRawIntBits(this.pitch);
    }

    public java.lang.String toString() {
        return com.google.android.exoplayer2.util.Util.formatInvariant("PlaybackParameters(speed=%.2f, pitch=%.2f)", java.lang.Float.valueOf(this.speed), java.lang.Float.valueOf(this.pitch));
    }
}
