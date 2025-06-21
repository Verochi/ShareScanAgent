package com.qq.e.comm.managers.plugin;

/* loaded from: classes19.dex */
class d {
    private static final java.lang.String[] a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static java.lang.String a(byte[] bArr) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (int i : bArr) {
            if (i < 0) {
                i += 256;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.lang.String[] strArr = a;
            sb.append(strArr[i / 16]);
            sb.append(strArr[i % 16]);
            stringBuffer.append(sb.toString());
        }
        return stringBuffer.toString();
    }
}
