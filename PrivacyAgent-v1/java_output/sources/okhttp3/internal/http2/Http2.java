package okhttp3.internal.http2;

/* loaded from: classes24.dex */
public final class Http2 {
    public static final okio.ByteString a = okio.ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    public static final java.lang.String[] b = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    public static final java.lang.String[] c = new java.lang.String[64];
    public static final java.lang.String[] d = new java.lang.String[256];

    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            java.lang.String[] strArr = d;
            if (i2 >= strArr.length) {
                break;
            }
            strArr[i2] = okhttp3.internal.Util.format("%8s", java.lang.Integer.toBinaryString(i2)).replace(' ', '0');
            i2++;
        }
        java.lang.String[] strArr2 = c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        strArr2[1 | 8] = strArr2[1] + "|PADDED";
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i3 = 0; i3 < 3; i3++) {
            int i4 = iArr2[i3];
            int i5 = iArr[0];
            java.lang.String[] strArr3 = c;
            int i6 = i5 | i4;
            strArr3[i6] = strArr3[i5] + '|' + strArr3[i4];
            strArr3[i6 | 8] = strArr3[i5] + '|' + strArr3[i4] + "|PADDED";
        }
        while (true) {
            java.lang.String[] strArr4 = c;
            if (i >= strArr4.length) {
                return;
            }
            if (strArr4[i] == null) {
                strArr4[i] = d[i];
            }
            i++;
        }
    }

    public static java.lang.String a(byte b2, byte b3) {
        if (b3 == 0) {
            return "";
        }
        if (b2 != 2 && b2 != 3) {
            if (b2 == 4 || b2 == 6) {
                return b3 == 1 ? "ACK" : d[b3];
            }
            if (b2 != 7 && b2 != 8) {
                java.lang.String[] strArr = c;
                java.lang.String str = b3 < strArr.length ? strArr[b3] : d[b3];
                return (b2 != 5 || (b3 & 4) == 0) ? (b2 != 0 || (b3 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED") : str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return d[b3];
    }

    public static java.lang.String b(boolean z, int i, int i2, byte b2, byte b3) {
        java.lang.String[] strArr = b;
        java.lang.String format = b2 < strArr.length ? strArr[b2] : okhttp3.internal.Util.format("0x%02x", java.lang.Byte.valueOf(b2));
        java.lang.String a2 = a(b2, b3);
        java.lang.Object[] objArr = new java.lang.Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = java.lang.Integer.valueOf(i);
        objArr[2] = java.lang.Integer.valueOf(i2);
        objArr[3] = format;
        objArr[4] = a2;
        return okhttp3.internal.Util.format("%s 0x%08x %5d %-13s %s", objArr);
    }

    public static java.lang.IllegalArgumentException c(java.lang.String str, java.lang.Object... objArr) {
        throw new java.lang.IllegalArgumentException(okhttp3.internal.Util.format(str, objArr));
    }

    public static java.io.IOException d(java.lang.String str, java.lang.Object... objArr) throws java.io.IOException {
        throw new java.io.IOException(okhttp3.internal.Util.format(str, objArr));
    }
}
