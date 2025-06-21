package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public final class dh extends com.umeng.analytics.pro.cv {

    public static class a implements com.umeng.analytics.pro.dd {
        @Override // com.umeng.analytics.pro.dd
        public com.umeng.analytics.pro.db a(com.umeng.analytics.pro.dp dpVar) {
            return new com.umeng.analytics.pro.dh(dpVar);
        }
    }

    public dh(com.umeng.analytics.pro.dp dpVar) {
        super(dpVar);
    }

    public static java.util.BitSet a(byte[] bArr) {
        java.util.BitSet bitSet = new java.util.BitSet();
        for (int i = 0; i < bArr.length * 8; i++) {
            if ((bArr[(bArr.length - (i / 8)) - 1] & (1 << (i % 8))) > 0) {
                bitSet.set(i);
            }
        }
        return bitSet;
    }

    public static byte[] b(java.util.BitSet bitSet, int i) {
        int ceil = (int) java.lang.Math.ceil(i / 8.0d);
        byte[] bArr = new byte[ceil];
        for (int i2 = 0; i2 < bitSet.length(); i2++) {
            if (bitSet.get(i2)) {
                int i3 = (ceil - (i2 / 8)) - 1;
                bArr[i3] = (byte) ((1 << (i2 % 8)) | bArr[i3]);
            }
        }
        return bArr;
    }

    @Override // com.umeng.analytics.pro.db
    public java.lang.Class<? extends com.umeng.analytics.pro.dj> D() {
        return com.umeng.analytics.pro.dm.class;
    }

    public void a(java.util.BitSet bitSet, int i) throws com.umeng.analytics.pro.ci {
        for (byte b : b(bitSet, i)) {
            a(b);
        }
    }

    public java.util.BitSet b(int i) throws com.umeng.analytics.pro.ci {
        int ceil = (int) java.lang.Math.ceil(i / 8.0d);
        byte[] bArr = new byte[ceil];
        for (int i2 = 0; i2 < ceil; i2++) {
            bArr[i2] = u();
        }
        return a(bArr);
    }
}
