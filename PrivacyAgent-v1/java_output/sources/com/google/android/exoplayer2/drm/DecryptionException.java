package com.google.android.exoplayer2.drm;

/* loaded from: classes22.dex */
public class DecryptionException extends java.lang.Exception {
    public final int errorCode;

    public DecryptionException(int i, java.lang.String str) {
        super(str);
        this.errorCode = i;
    }
}
