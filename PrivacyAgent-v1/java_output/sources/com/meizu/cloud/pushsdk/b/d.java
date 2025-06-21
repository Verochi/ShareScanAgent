package com.meizu.cloud.pushsdk.b;

/* loaded from: classes23.dex */
class d {
    private static final char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', com.aliyun.svideo.editor.guide.customView.MultiLamp.LEFT, 'm', 'n', 'o', 'p', 'q', com.aliyun.svideo.editor.guide.customView.MultiLamp.RIGHT, 's', com.aliyun.svideo.editor.guide.customView.MultiLamp.TOP, 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static final char b = (char) java.lang.Integer.parseInt("00000011", 2);
    private static final char c = (char) java.lang.Integer.parseInt("00001111", 2);
    private static final char d = (char) java.lang.Integer.parseInt("00111111", 2);
    private final java.lang.String e;
    private char[] f;
    private int g = 0;

    public d(java.lang.String str) {
        this.e = str;
        a();
    }

    private void a() {
        char[] cArr = new char[a.length];
        int i = 0;
        this.g = this.e.charAt(0) % '\r';
        while (true) {
            char[] cArr2 = a;
            if (i >= cArr2.length) {
                this.f = cArr;
                return;
            } else {
                cArr[i] = cArr2[(this.g + i) % cArr2.length];
                i++;
            }
        }
    }

    public java.lang.String a(byte[] bArr) {
        java.lang.String str;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(((bArr.length + 2) / 3) * 4);
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            int i3 = bArr[i] & 255;
            if (i2 == length) {
                sb.append(this.f[i3 >>> 2]);
                sb.append(this.f[(b & i3) << 4]);
                str = "==";
            } else {
                int i4 = i2 + 1;
                int i5 = bArr[i2] & 255;
                if (i4 == length) {
                    sb.append(this.f[i3 >>> 2]);
                    sb.append(this.f[((b & i3) << 4) | (i5 >>> 4)]);
                    sb.append(this.f[(c & i5) << 2]);
                    str = com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER;
                } else {
                    int i6 = i4 + 1;
                    int i7 = bArr[i4] & 255;
                    sb.append(this.f[i3 >>> 2]);
                    sb.append(this.f[((i3 & b) << 4) | (i5 >>> 4)]);
                    sb.append(this.f[((i5 & c) << 2) | (i7 >>> 6)]);
                    sb.append(this.f[d & i7]);
                    i = i6;
                }
            }
            sb.append(str);
            break;
        }
        return sb.toString();
    }
}
