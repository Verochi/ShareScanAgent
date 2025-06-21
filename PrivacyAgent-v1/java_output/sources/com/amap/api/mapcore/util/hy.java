package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class hy extends com.amap.api.mapcore.util.hz {
    public hy() {
    }

    public hy(com.amap.api.mapcore.util.hz hzVar) {
        super(hzVar);
    }

    @Override // com.amap.api.mapcore.util.hz
    public final byte[] a(byte[] bArr) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(new java.text.SimpleDateFormat("yyyyMMdd HHmmss").format(new java.util.Date()));
        stringBuffer.append(" ");
        stringBuffer.append(java.util.UUID.randomUUID().toString());
        stringBuffer.append(" ");
        if (stringBuffer.length() != 53) {
            return new byte[0];
        }
        byte[] a = com.amap.api.mapcore.util.fi.a(stringBuffer.toString());
        byte[] bArr2 = new byte[a.length + bArr.length];
        java.lang.System.arraycopy(a, 0, bArr2, 0, a.length);
        java.lang.System.arraycopy(bArr, 0, bArr2, a.length, bArr.length);
        return bArr2;
    }
}
