package com.google.android.exoplayer2.upstream.cache;

/* loaded from: classes22.dex */
public interface ContentMetadata {
    public static final java.lang.String KEY_CONTENT_LENGTH = "exo_len";
    public static final java.lang.String KEY_CUSTOM_PREFIX = "custom_";
    public static final java.lang.String KEY_REDIRECTED_URI = "exo_redir";

    boolean contains(java.lang.String str);

    long get(java.lang.String str, long j);

    @androidx.annotation.Nullable
    java.lang.String get(java.lang.String str, @androidx.annotation.Nullable java.lang.String str2);

    @androidx.annotation.Nullable
    byte[] get(java.lang.String str, @androidx.annotation.Nullable byte[] bArr);
}
