package com.jd.ad.sdk.jad_hk;

/* loaded from: classes23.dex */
public class jad_na {
    public void jad_an() {
        if (java.lang.Thread.interrupted()) {
            java.lang.Thread.currentThread().interrupt();
            throw new java.io.InterruptedIOException("interrupted");
        }
    }
}
