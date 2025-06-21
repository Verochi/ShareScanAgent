package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public class DefaultLoadControl implements com.google.android.exoplayer2.LoadControl {
    public static final int DEFAULT_AUDIO_BUFFER_SIZE = 13107200;
    public static final int DEFAULT_BACK_BUFFER_DURATION_MS = 0;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS = 5000;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_MS = 2500;
    public static final int DEFAULT_CAMERA_MOTION_BUFFER_SIZE = 131072;
    public static final int DEFAULT_MAX_BUFFER_MS = 50000;
    public static final int DEFAULT_METADATA_BUFFER_SIZE = 131072;
    public static final int DEFAULT_MIN_BUFFER_MS = 50000;
    public static final int DEFAULT_MIN_BUFFER_SIZE = 13107200;
    public static final int DEFAULT_MUXED_BUFFER_SIZE = 144310272;
    public static final boolean DEFAULT_PRIORITIZE_TIME_OVER_SIZE_THRESHOLDS = false;
    public static final boolean DEFAULT_RETAIN_BACK_BUFFER_FROM_KEYFRAME = false;
    public static final int DEFAULT_TARGET_BUFFER_BYTES = -1;
    public static final int DEFAULT_TEXT_BUFFER_SIZE = 131072;
    public static final int DEFAULT_VIDEO_BUFFER_SIZE = 131072000;
    public final com.google.android.exoplayer2.upstream.DefaultAllocator a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final int f;
    public final boolean g;
    public final long h;
    public final boolean i;
    public int j;
    public boolean k;

    public static final class Builder {

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.upstream.DefaultAllocator a;
        public int b = 50000;
        public int c = 50000;
        public int d = 2500;
        public int e = 5000;
        public int f = -1;
        public boolean g = false;
        public int h = 0;
        public boolean i = false;
        public boolean j;

        public com.google.android.exoplayer2.DefaultLoadControl build() {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.j);
            this.j = true;
            if (this.a == null) {
                this.a = new com.google.android.exoplayer2.upstream.DefaultAllocator(true, 65536);
            }
            return new com.google.android.exoplayer2.DefaultLoadControl(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.DefaultLoadControl createDefaultLoadControl() {
            return build();
        }

        public com.google.android.exoplayer2.DefaultLoadControl.Builder setAllocator(com.google.android.exoplayer2.upstream.DefaultAllocator defaultAllocator) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.j);
            this.a = defaultAllocator;
            return this;
        }

        public com.google.android.exoplayer2.DefaultLoadControl.Builder setBackBuffer(int i, boolean z) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.j);
            com.google.android.exoplayer2.DefaultLoadControl.b(i, 0, "backBufferDurationMs", "0");
            this.h = i;
            this.i = z;
            return this;
        }

        public com.google.android.exoplayer2.DefaultLoadControl.Builder setBufferDurationsMs(int i, int i2, int i3, int i4) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.j);
            com.google.android.exoplayer2.DefaultLoadControl.b(i3, 0, "bufferForPlaybackMs", "0");
            com.google.android.exoplayer2.DefaultLoadControl.b(i4, 0, "bufferForPlaybackAfterRebufferMs", "0");
            com.google.android.exoplayer2.DefaultLoadControl.b(i, i3, "minBufferMs", "bufferForPlaybackMs");
            com.google.android.exoplayer2.DefaultLoadControl.b(i, i4, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
            com.google.android.exoplayer2.DefaultLoadControl.b(i2, i, "maxBufferMs", "minBufferMs");
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            return this;
        }

        public com.google.android.exoplayer2.DefaultLoadControl.Builder setPrioritizeTimeOverSizeThresholds(boolean z) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.j);
            this.g = z;
            return this;
        }

        public com.google.android.exoplayer2.DefaultLoadControl.Builder setTargetBufferBytes(int i) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.j);
            this.f = i;
            return this;
        }
    }

    public DefaultLoadControl() {
        this(new com.google.android.exoplayer2.upstream.DefaultAllocator(true, 65536));
    }

    @java.lang.Deprecated
    public DefaultLoadControl(com.google.android.exoplayer2.upstream.DefaultAllocator defaultAllocator) {
        this(defaultAllocator, 50000, 50000, 2500, 5000, -1, false, 0, false);
    }

    @java.lang.Deprecated
    public DefaultLoadControl(com.google.android.exoplayer2.upstream.DefaultAllocator defaultAllocator, int i, int i2, int i3, int i4, int i5, boolean z) {
        this(defaultAllocator, i, i2, i3, i4, i5, z, 0, false);
    }

    public DefaultLoadControl(com.google.android.exoplayer2.upstream.DefaultAllocator defaultAllocator, int i, int i2, int i3, int i4, int i5, boolean z, int i6, boolean z2) {
        b(i3, 0, "bufferForPlaybackMs", "0");
        b(i4, 0, "bufferForPlaybackAfterRebufferMs", "0");
        b(i, i3, "minBufferMs", "bufferForPlaybackMs");
        b(i, i4, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        b(i2, i, "maxBufferMs", "minBufferMs");
        b(i6, 0, "backBufferDurationMs", "0");
        this.a = defaultAllocator;
        this.b = com.google.android.exoplayer2.C.msToUs(i);
        this.c = com.google.android.exoplayer2.C.msToUs(i2);
        this.d = com.google.android.exoplayer2.C.msToUs(i3);
        this.e = com.google.android.exoplayer2.C.msToUs(i4);
        this.f = i5;
        this.j = i5 == -1 ? 13107200 : i5;
        this.g = z;
        this.h = com.google.android.exoplayer2.C.msToUs(i6);
        this.i = z2;
    }

    public static void b(int i, int i2, java.lang.String str, java.lang.String str2) {
        boolean z = i >= i2;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 21 + java.lang.String.valueOf(str2).length());
        sb.append(str);
        sb.append(" cannot be less than ");
        sb.append(str2);
        com.google.android.exoplayer2.util.Assertions.checkArgument(z, sb.toString());
    }

    public static int c(int i) {
        switch (i) {
            case 0:
                return DEFAULT_MUXED_BUFFER_SIZE;
            case 1:
                return 13107200;
            case 2:
                return DEFAULT_VIDEO_BUFFER_SIZE;
            case 3:
            case 4:
            case 5:
                return 131072;
            case 6:
                return 0;
            default:
                throw new java.lang.IllegalArgumentException();
        }
    }

    public int calculateTargetBufferBytes(com.google.android.exoplayer2.Renderer[] rendererArr, com.google.android.exoplayer2.trackselection.TrackSelectionArray trackSelectionArray) {
        int i = 0;
        for (int i2 = 0; i2 < rendererArr.length; i2++) {
            if (trackSelectionArray.get(i2) != null) {
                i += c(rendererArr[i2].getTrackType());
            }
        }
        return java.lang.Math.max(13107200, i);
    }

    public final void d(boolean z) {
        int i = this.f;
        if (i == -1) {
            i = 13107200;
        }
        this.j = i;
        this.k = false;
        if (z) {
            this.a.reset();
        }
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public com.google.android.exoplayer2.upstream.Allocator getAllocator() {
        return this.a;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public long getBackBufferDurationUs() {
        return this.h;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onPrepared() {
        d(false);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onReleased() {
        d(true);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onStopped() {
        d(true);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onTracksSelected(com.google.android.exoplayer2.Renderer[] rendererArr, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.TrackSelectionArray trackSelectionArray) {
        int i = this.f;
        if (i == -1) {
            i = calculateTargetBufferBytes(rendererArr, trackSelectionArray);
        }
        this.j = i;
        this.a.setTargetBufferSize(i);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public boolean retainBackBufferFromKeyframe() {
        return this.i;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public boolean shouldContinueLoading(long j, long j2, float f) {
        boolean z = true;
        boolean z2 = this.a.getTotalBytesAllocated() >= this.j;
        long j3 = this.b;
        if (f > 1.0f) {
            j3 = java.lang.Math.min(com.google.android.exoplayer2.util.Util.getMediaDurationForPlayoutDuration(j3, f), this.c);
        }
        if (j2 < java.lang.Math.max(j3, 500000L)) {
            if (!this.g && z2) {
                z = false;
            }
            this.k = z;
            if (!z && j2 < 500000) {
                com.google.android.exoplayer2.util.Log.w("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j2 >= this.c || z2) {
            this.k = false;
        }
        return this.k;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public boolean shouldStartPlayback(long j, float f, boolean z) {
        long playoutDurationForMediaDuration = com.google.android.exoplayer2.util.Util.getPlayoutDurationForMediaDuration(j, f);
        long j2 = z ? this.e : this.d;
        return j2 <= 0 || playoutDurationForMediaDuration >= j2 || (!this.g && this.a.getTotalBytesAllocated() >= this.j);
    }
}
