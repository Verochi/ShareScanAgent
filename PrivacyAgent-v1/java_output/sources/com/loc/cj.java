package com.loc;

/* loaded from: classes23.dex */
public final class cj extends com.loc.ck {
    public cj() {
    }

    public cj(com.loc.ck ckVar) {
        super(ckVar);
    }

    @Override // com.loc.ck
    public final byte[] a(byte[] bArr) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(new java.text.SimpleDateFormat("yyyyMMdd HHmmss").format(new java.util.Date()));
        stringBuffer.append(" ");
        stringBuffer.append(java.util.UUID.randomUUID().toString());
        stringBuffer.append(" ");
        if (stringBuffer.length() != 53) {
            return new byte[0];
        }
        byte[] a = com.loc.y.a(stringBuffer.toString());
        byte[] bArr2 = new byte[a.length + bArr.length];
        java.lang.System.arraycopy(a, 0, bArr2, 0, a.length);
        java.lang.System.arraycopy(bArr, 0, bArr2, a.length, bArr.length);
        return bArr2;
    }
}
