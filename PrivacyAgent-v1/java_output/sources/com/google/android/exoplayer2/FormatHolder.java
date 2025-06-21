package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public final class FormatHolder {

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.drm.DrmSession drmSession;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Format format;

    public void clear() {
        this.drmSession = null;
        this.format = null;
    }
}
