package com.google.android.exoplayer2.source.hls;

/* loaded from: classes22.dex */
public final class SampleQueueMappingException extends java.io.IOException {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SampleQueueMappingException(@androidx.annotation.Nullable java.lang.String str) {
        super(r1.toString());
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 60);
        sb.append("Unable to bind a sample queue to TrackGroup with mime type ");
        sb.append(str);
        sb.append(".");
    }
}
