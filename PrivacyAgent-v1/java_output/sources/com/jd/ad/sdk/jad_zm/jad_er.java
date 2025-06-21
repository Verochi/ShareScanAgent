package com.jd.ad.sdk.jad_zm;

/* loaded from: classes23.dex */
public class jad_er {
    public final byte[] jad_an;

    public jad_er(byte[] bArr) {
        this(bArr, java.nio.charset.Charset.forName("UTF-8"));
    }

    public jad_er(byte[] bArr, java.nio.charset.Charset charset) {
        this(bArr, charset, "application/stream");
    }

    public jad_er(byte[] bArr, java.nio.charset.Charset charset, java.lang.String str) {
        this.jad_an = bArr;
    }
}
