package com.huawei.secure.android.common.util;

/* loaded from: classes22.dex */
public class SafeBase64 {
    public static byte[] decode(java.lang.String str, int i) {
        try {
            return android.util.Base64.decode(str, i);
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(e.getClass().getSimpleName());
            sb.append(" , message2 : ");
            sb.append(e.getMessage());
            return new byte[0];
        }
    }

    public static byte[] decode(byte[] bArr, int i) {
        try {
            return android.util.Base64.decode(bArr, i);
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(e.getClass().getSimpleName());
            sb.append(" , message0 : ");
            sb.append(e.getMessage());
            return new byte[0];
        }
    }

    public static byte[] decode(byte[] bArr, int i, int i2, int i3) {
        try {
            return android.util.Base64.decode(bArr, i, i2, i3);
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(e.getClass().getSimpleName());
            sb.append(" , message1 : ");
            sb.append(e.getMessage());
            return new byte[0];
        }
    }

    public static byte[] encode(byte[] bArr, int i) {
        try {
            return android.util.Base64.encode(bArr, i);
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(e.getClass().getSimpleName());
            sb.append(" , message3 : ");
            sb.append(e.getMessage());
            return new byte[0];
        }
    }

    public static byte[] encode(byte[] bArr, int i, int i2, int i3) {
        try {
            return android.util.Base64.encode(bArr, i, i2, i3);
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(e.getClass().getSimpleName());
            sb.append(" , message4 : ");
            sb.append(e.getMessage());
            return new byte[0];
        }
    }

    public static java.lang.String encodeToString(byte[] bArr, int i) {
        try {
            return android.util.Base64.encodeToString(bArr, i);
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(e.getClass().getSimpleName());
            sb.append(" , message5 : ");
            sb.append(e.getMessage());
            return "";
        }
    }

    public static java.lang.String encodeToString(byte[] bArr, int i, int i2, int i3) {
        try {
            return android.util.Base64.encodeToString(bArr, i, i2, i3);
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(e.getClass().getSimpleName());
            sb.append(" , message6 : ");
            sb.append(e.getMessage());
            return "";
        }
    }
}
