package com.google.android.exoplayer2.audio;

/* loaded from: classes22.dex */
public final class AudioAttributes {
    public static final com.google.android.exoplayer2.audio.AudioAttributes DEFAULT = new com.google.android.exoplayer2.audio.AudioAttributes.Builder().build();

    @androidx.annotation.Nullable
    public android.media.AudioAttributes a;
    public final int allowedCapturePolicy;
    public final int contentType;
    public final int flags;
    public final int usage;

    public static final class Builder {
        public int a = 0;
        public int b = 0;
        public int c = 1;
        public int d = 1;

        public com.google.android.exoplayer2.audio.AudioAttributes build() {
            return new com.google.android.exoplayer2.audio.AudioAttributes(this.a, this.b, this.c, this.d, null);
        }

        public com.google.android.exoplayer2.audio.AudioAttributes.Builder setAllowedCapturePolicy(int i) {
            this.d = i;
            return this;
        }

        public com.google.android.exoplayer2.audio.AudioAttributes.Builder setContentType(int i) {
            this.a = i;
            return this;
        }

        public com.google.android.exoplayer2.audio.AudioAttributes.Builder setFlags(int i) {
            this.b = i;
            return this;
        }

        public com.google.android.exoplayer2.audio.AudioAttributes.Builder setUsage(int i) {
            this.c = i;
            return this;
        }
    }

    public AudioAttributes(int i, int i2, int i3, int i4) {
        this.contentType = i;
        this.flags = i2;
        this.usage = i3;
        this.allowedCapturePolicy = i4;
    }

    public /* synthetic */ AudioAttributes(int i, int i2, int i3, int i4, com.google.android.exoplayer2.audio.AudioAttributes.AnonymousClass1 anonymousClass1) {
        this(i, i2, i3, i4);
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.google.android.exoplayer2.audio.AudioAttributes.class != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.audio.AudioAttributes audioAttributes = (com.google.android.exoplayer2.audio.AudioAttributes) obj;
        return this.contentType == audioAttributes.contentType && this.flags == audioAttributes.flags && this.usage == audioAttributes.usage && this.allowedCapturePolicy == audioAttributes.allowedCapturePolicy;
    }

    @androidx.annotation.RequiresApi(21)
    public android.media.AudioAttributes getAudioAttributesV21() {
        if (this.a == null) {
            android.media.AudioAttributes.Builder usage = new android.media.AudioAttributes.Builder().setContentType(this.contentType).setFlags(this.flags).setUsage(this.usage);
            if (com.google.android.exoplayer2.util.Util.SDK_INT >= 29) {
                usage.setAllowedCapturePolicy(this.allowedCapturePolicy);
            }
            this.a = usage.build();
        }
        return this.a;
    }

    public int hashCode() {
        return ((((((527 + this.contentType) * 31) + this.flags) * 31) + this.usage) * 31) + this.allowedCapturePolicy;
    }
}
