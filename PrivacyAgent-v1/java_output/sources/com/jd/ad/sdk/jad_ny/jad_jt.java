package com.jd.ad.sdk.jad_ny;

/* loaded from: classes23.dex */
public final class jad_jt implements com.jd.ad.sdk.jad_ny.jad_an<byte[]> {
    @Override // com.jd.ad.sdk.jad_ny.jad_an
    public int jad_an(byte[] bArr) {
        return bArr.length;
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_an
    public java.lang.String jad_an() {
        return "ByteArrayPool";
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_an
    public int jad_bo() {
        return 1;
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_an
    public byte[] newArray(int i) {
        return new byte[i];
    }
}
