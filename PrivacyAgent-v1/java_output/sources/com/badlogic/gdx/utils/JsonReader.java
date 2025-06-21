package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public class JsonReader implements com.badlogic.gdx.utils.BaseJsonReader {
    public static final byte[] e = b();
    public static final short[] f = f();
    public static final char[] g = j();
    public static final byte[] h = h();
    public static final byte[] i = g();
    public static final short[] j = d();
    public static final byte[] k = e();
    public static final byte[] l = k();
    public static final byte[] m = i();
    public static final byte[] n = c();
    public final com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.JsonValue> a = new com.badlogic.gdx.utils.Array<>(8);
    public final com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.JsonValue> b = new com.badlogic.gdx.utils.Array<>(8);
    public com.badlogic.gdx.utils.JsonValue c;
    public com.badlogic.gdx.utils.JsonValue d;

    public static byte[] b() {
        return new byte[]{0, 1, 1, 1, 2, 1, 3, 1, 4, 1, 5, 1, 6, 1, 7, 1, 8, 2, 0, 7, 2, 0, 8, 2, 1, 3, 2, 1, 5};
    }

    public static byte[] c() {
        return new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0};
    }

    public static short[] d() {
        return new short[]{0, 0, 11, 14, 16, 19, 28, 34, 40, 43, 54, 62, 70, 79, 81, 90, 93, 96, 105, 108, 111, 113, 116, 119, 130, 138, 146, 157, 159, 170, 173, 176, 187, 190, 193, 196, 201, 206, 207};
    }

    public static byte[] e() {
        return new byte[]{1, 1, 2, 3, 4, 3, 5, 3, 6, 1, 0, 7, 7, 3, 8, 3, 9, 9, 3, 11, 11, 12, 13, 14, 3, 15, 11, 10, 16, 16, 17, com.google.common.base.Ascii.DC2, 16, 3, 19, 19, com.google.common.base.Ascii.DC4, com.google.common.base.Ascii.NAK, 19, 3, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.SYN, 3, com.google.common.base.Ascii.NAK, com.google.common.base.Ascii.NAK, com.google.common.base.Ascii.CAN, 3, com.google.common.base.Ascii.EM, 3, com.google.common.base.Ascii.SUB, 3, com.google.common.base.Ascii.ESC, com.google.common.base.Ascii.NAK, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.GS, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.RS, com.google.common.base.Ascii.US, 32, 3, 33, 34, 33, 33, 13, 35, 15, 3, 34, 34, 12, 36, 37, 3, 15, 34, 10, 16, 3, 36, 36, 12, 3, 38, 3, 3, 36, 10, 39, 39, 3, 40, 40, 3, 13, 13, 12, 3, 41, 3, 15, 13, 10, 42, 42, 3, 43, 43, 3, com.google.common.base.Ascii.FS, 3, 44, 44, 3, 45, 45, 3, 47, 47, org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_LINK, org.apache.tools.tar.TarConstants.LF_SYMLINK, 3, org.apache.tools.tar.TarConstants.LF_CHR, org.apache.tools.tar.TarConstants.LF_BLK, org.apache.tools.tar.TarConstants.LF_DIR, 47, 46, org.apache.tools.tar.TarConstants.LF_FIFO, org.apache.tools.tar.TarConstants.LF_CONTIG, org.apache.tools.tar.TarConstants.LF_FIFO, org.apache.tools.tar.TarConstants.LF_FIFO, 56, 57, 58, 3, 59, 60, 59, 59, org.apache.tools.tar.TarConstants.LF_LINK, 61, org.apache.tools.tar.TarConstants.LF_BLK, 3, 60, 60, org.apache.tools.tar.TarConstants.LF_NORMAL, 62, 63, 3, org.apache.tools.tar.TarConstants.LF_CHR, org.apache.tools.tar.TarConstants.LF_BLK, org.apache.tools.tar.TarConstants.LF_DIR, 60, 46, org.apache.tools.tar.TarConstants.LF_FIFO, 3, 62, 62, org.apache.tools.tar.TarConstants.LF_NORMAL, 3, com.google.common.primitives.SignedBytes.MAX_POWER_OF_TWO, 3, org.apache.tools.tar.TarConstants.LF_CHR, 3, org.apache.tools.tar.TarConstants.LF_DIR, 62, 46, 65, 65, 3, 66, 66, 3, org.apache.tools.tar.TarConstants.LF_LINK, org.apache.tools.tar.TarConstants.LF_LINK, org.apache.tools.tar.TarConstants.LF_NORMAL, 3, 67, 3, org.apache.tools.tar.TarConstants.LF_CHR, org.apache.tools.tar.TarConstants.LF_BLK, org.apache.tools.tar.TarConstants.LF_DIR, org.apache.tools.tar.TarConstants.LF_LINK, 46, 68, 68, 3, 69, 69, 3, 70, 70, 3, 8, 8, 71, 8, 3, 72, 72, 73, 72, 3, 3, 3, 0};
    }

    public static short[] f() {
        return new short[]{0, 0, 11, 13, 14, 16, 25, 31, 37, 39, 50, 57, 64, 73, 74, 83, 85, 87, 96, 98, 100, 101, 103, 105, 116, 123, 130, 141, 142, 153, 155, 157, 168, 170, 172, 174, 179, 184, 184};
    }

    public static byte[] g() {
        return new byte[]{0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0};
    }

    public static byte[] h() {
        return new byte[]{0, 9, 2, 1, 2, 7, 4, 4, 2, 9, 7, 7, 7, 1, 7, 2, 2, 7, 2, 2, 1, 2, 2, 9, 7, 7, 9, 1, 9, 2, 2, 9, 2, 2, 2, 3, 3, 0, 0};
    }

    public static byte[] i() {
        return new byte[]{13, 0, 15, 0, 0, 7, 3, 11, 1, 11, 17, 0, com.google.common.base.Ascii.DC4, 0, 0, 5, 1, 1, 1, 0, 0, 0, 11, 13, 15, 0, 7, 3, 1, 1, 1, 1, com.google.common.base.Ascii.ETB, 0, 0, 0, 0, 0, 0, 11, 11, 0, 11, 11, 11, 11, 13, 0, 15, 0, 0, 7, 9, 3, 1, 1, 1, 1, com.google.common.base.Ascii.SUB, 0, 0, 0, 0, 0, 0, 11, 11, 0, 11, 11, 11, 1, 0, 0};
    }

    public static char[] j() {
        return new char[]{'\r', ' ', kotlin.text.Typography.quote, ',', '/', ':', '[', ']', '{', '\t', '\n', '*', '/', kotlin.text.Typography.quote, '*', '/', '\r', ' ', kotlin.text.Typography.quote, ',', '/', ':', '}', '\t', '\n', '\r', ' ', '/', ':', '\t', '\n', '\r', ' ', '/', ':', '\t', '\n', '*', '/', '\r', ' ', kotlin.text.Typography.quote, ',', '/', ':', '[', ']', '{', '\t', '\n', '\t', '\n', '\r', ' ', ',', '/', '}', '\t', '\n', '\r', ' ', ',', '/', '}', '\r', ' ', kotlin.text.Typography.quote, ',', '/', ':', '}', '\t', '\n', kotlin.text.Typography.quote, '\r', ' ', kotlin.text.Typography.quote, ',', '/', ':', '}', '\t', '\n', '*', '/', '*', '/', '\r', ' ', kotlin.text.Typography.quote, ',', '/', ':', '}', '\t', '\n', '*', '/', '*', '/', kotlin.text.Typography.quote, '*', '/', '*', '/', '\r', ' ', kotlin.text.Typography.quote, ',', '/', ':', '[', ']', '{', '\t', '\n', '\t', '\n', '\r', ' ', ',', '/', ']', '\t', '\n', '\r', ' ', ',', '/', ']', '\r', ' ', kotlin.text.Typography.quote, ',', '/', ':', '[', ']', '{', '\t', '\n', kotlin.text.Typography.quote, '\r', ' ', kotlin.text.Typography.quote, ',', '/', ':', '[', ']', '{', '\t', '\n', '*', '/', '*', '/', '\r', ' ', kotlin.text.Typography.quote, ',', '/', ':', '[', ']', '{', '\t', '\n', '*', '/', '*', '/', '*', '/', '\r', ' ', '/', '\t', '\n', '\r', ' ', '/', '\t', '\n', 0};
    }

    public static byte[] k() {
        return new byte[]{35, 1, 3, 0, 4, 36, 36, 36, 36, 1, 6, 5, 13, 17, com.google.common.base.Ascii.SYN, 37, 7, 8, 9, 7, 8, 9, 7, 10, com.google.common.base.Ascii.DC4, com.google.common.base.Ascii.NAK, 11, 11, 11, 12, 17, 19, 37, 11, 12, 19, 14, 16, 15, 14, 12, com.google.common.base.Ascii.DC2, 17, 11, 9, 5, com.google.common.base.Ascii.CAN, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.ESC, com.google.common.base.Ascii.US, 34, com.google.common.base.Ascii.EM, 38, com.google.common.base.Ascii.EM, com.google.common.base.Ascii.EM, com.google.common.base.Ascii.SUB, com.google.common.base.Ascii.US, 33, 38, com.google.common.base.Ascii.EM, com.google.common.base.Ascii.SUB, 33, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.RS, com.google.common.base.Ascii.GS, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.SUB, 32, com.google.common.base.Ascii.US, com.google.common.base.Ascii.EM, com.google.common.base.Ascii.ETB, 2, 36, 2};
    }

    public final void a(java.lang.String str, com.badlogic.gdx.utils.JsonValue jsonValue) {
        jsonValue.setName(str);
        com.badlogic.gdx.utils.JsonValue jsonValue2 = this.d;
        if (jsonValue2 == null) {
            this.d = jsonValue;
            this.c = jsonValue;
            return;
        }
        if (!jsonValue2.isArray() && !this.d.isObject()) {
            this.c = this.d;
            return;
        }
        com.badlogic.gdx.utils.JsonValue jsonValue3 = this.d;
        jsonValue.parent = jsonValue3;
        if (jsonValue3.size == 0) {
            jsonValue3.child = jsonValue;
        } else {
            com.badlogic.gdx.utils.JsonValue pop = this.b.pop();
            pop.next = jsonValue;
            jsonValue.prev = pop;
        }
        this.b.add(jsonValue);
        this.d.size++;
    }

    public void bool(java.lang.String str, boolean z) {
        a(str, new com.badlogic.gdx.utils.JsonValue(z));
    }

    public final java.lang.String l(java.lang.String str) {
        int length = str.length();
        com.badlogic.gdx.utils.StringBuilder stringBuilder = new com.badlogic.gdx.utils.StringBuilder(length + 16);
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            char charAt = str.charAt(i2);
            if (charAt != '\\') {
                stringBuilder.append(charAt);
            } else {
                if (i3 == length) {
                    break;
                }
                i2 = i3 + 1;
                char charAt2 = str.charAt(i3);
                if (charAt2 == 'u') {
                    i3 = i2 + 4;
                    stringBuilder.append(java.lang.Character.toChars(java.lang.Integer.parseInt(str.substring(i2, i3), 16)));
                } else {
                    if (charAt2 != '\"' && charAt2 != '/' && charAt2 != '\\') {
                        if (charAt2 == 'b') {
                            charAt2 = '\b';
                        } else if (charAt2 == 'f') {
                            charAt2 = '\f';
                        } else if (charAt2 == 'n') {
                            charAt2 = '\n';
                        } else if (charAt2 == 'r') {
                            charAt2 = '\r';
                        } else {
                            if (charAt2 != 't') {
                                throw new com.badlogic.gdx.utils.SerializationException("Illegal escaped character: \\" + charAt2);
                            }
                            charAt2 = '\t';
                        }
                    }
                    stringBuilder.append(charAt2);
                }
            }
            i2 = i3;
        }
        return stringBuilder.toString();
    }

    public void number(java.lang.String str, double d, java.lang.String str2) {
        a(str, new com.badlogic.gdx.utils.JsonValue(d, str2));
    }

    public void number(java.lang.String str, long j2, java.lang.String str2) {
        a(str, new com.badlogic.gdx.utils.JsonValue(j2, str2));
    }

    @Override // com.badlogic.gdx.utils.BaseJsonReader
    public com.badlogic.gdx.utils.JsonValue parse(com.badlogic.gdx.files.FileHandle fileHandle) {
        try {
            return parse(fileHandle.reader("UTF-8"));
        } catch (java.lang.Exception e2) {
            throw new com.badlogic.gdx.utils.SerializationException("Error parsing file: " + fileHandle, e2);
        }
    }

    @Override // com.badlogic.gdx.utils.BaseJsonReader
    public com.badlogic.gdx.utils.JsonValue parse(java.io.InputStream inputStream) {
        try {
            try {
                return parse(new java.io.InputStreamReader(inputStream, "UTF-8"));
            } catch (java.io.IOException e2) {
                throw new com.badlogic.gdx.utils.SerializationException(e2);
            }
        } finally {
            com.badlogic.gdx.utils.StreamUtils.closeQuietly(inputStream);
        }
    }

    public com.badlogic.gdx.utils.JsonValue parse(java.io.Reader reader) {
        try {
            try {
                char[] cArr = new char[1024];
                int i2 = 0;
                while (true) {
                    int read = reader.read(cArr, i2, cArr.length - i2);
                    if (read == -1) {
                        return parse(cArr, 0, i2);
                    }
                    if (read == 0) {
                        char[] cArr2 = new char[cArr.length * 2];
                        java.lang.System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        cArr = cArr2;
                    } else {
                        i2 += read;
                    }
                }
            } catch (java.io.IOException e2) {
                throw new com.badlogic.gdx.utils.SerializationException(e2);
            }
        } finally {
            com.badlogic.gdx.utils.StreamUtils.closeQuietly(reader);
        }
    }

    public com.badlogic.gdx.utils.JsonValue parse(java.lang.String str) {
        char[] charArray = str.toCharArray();
        return parse(charArray, 0, charArray.length);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x023b, code lost:
    
        r4 = r10;
        r12 = r22;
        r9 = 2;
        r10 = r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01b1 A[Catch: RuntimeException -> 0x008e, LOOP:6: B:106:0x01a9->B:108:0x01b1, LOOP_END, TryCatch #7 {RuntimeException -> 0x008e, blocks: (B:308:0x0375, B:311:0x037b, B:317:0x038a, B:322:0x039b, B:328:0x03ad, B:332:0x03b8, B:42:0x0104, B:106:0x01a9, B:108:0x01b1, B:166:0x01bf, B:169:0x01c9, B:18:0x0073), top: B:41:0x0104 }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01a1 A[LOOP:7: B:132:0x0168->B:148:0x01a1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x015f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0342 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e2 A[Catch: RuntimeException -> 0x0430, TRY_LEAVE, TryCatch #8 {RuntimeException -> 0x0430, blocks: (B:395:0x00b6, B:397:0x00ba, B:400:0x00c1, B:402:0x00c7, B:405:0x00ca, B:28:0x00d4, B:30:0x00e2), top: B:394:0x00b6 }] */
    /* JADX WARN: Removed duplicated region for block: B:377:0x033c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:381:0x032e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0497  */
    /* JADX WARN: Type inference failed for: r0v49, types: [int[], java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v61, types: [int[], java.lang.Object] */
    /* JADX WARN: Type inference failed for: r16v11, types: [int] */
    /* JADX WARN: Type inference failed for: r16v12, types: [int] */
    /* JADX WARN: Type inference failed for: r16v14, types: [int] */
    /* JADX WARN: Type inference failed for: r16v16, types: [int] */
    /* JADX WARN: Type inference failed for: r16v17, types: [int] */
    /* JADX WARN: Type inference failed for: r21v22, types: [int] */
    /* JADX WARN: Type inference failed for: r4v0, types: [int[]] */
    /* JADX WARN: Type inference failed for: r9v4, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.badlogic.gdx.utils.JsonValue parse(char[] cArr, int i2, int i3) {
        java.lang.String str;
        byte[] bArr;
        java.lang.RuntimeException runtimeException;
        java.lang.String str2;
        int i4;
        com.badlogic.gdx.utils.Array array;
        short s2;
        short s3;
        byte b;
        boolean z;
        short s4;
        int i5;
        short s5;
        byte b2;
        byte b3;
        byte[] bArr2;
        byte b4;
        int i6;
        boolean z2;
        boolean z3;
        int i7;
        int i8;
        int i9;
        short s6;
        com.badlogic.gdx.utils.Array array2 = new com.badlogic.gdx.utils.Array(8);
        byte[] bArr3 = new int[4];
        char c = 0;
        byte b5 = 1;
        int i10 = 0;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int i11 = 0;
        int i12 = i2;
        while (true) {
            str = com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE;
            int i13 = i10;
            try {
                if (c != 0) {
                    if (c != 1) {
                        if (c == 2) {
                            bArr = bArr3;
                            i10 = i13;
                            if (b5 != 0) {
                                bArr3 = bArr;
                                c = 5;
                            } else {
                                i12++;
                                if (i12 != i3) {
                                    bArr3 = bArr;
                                    c = 1;
                                }
                            }
                        } else if (c == 4) {
                            i10 = i13;
                        }
                    }
                } else if (i12 == i3) {
                    i10 = i13;
                    c = 4;
                } else if (b5 == 0) {
                    i10 = i13;
                    c = 5;
                }
                s2 = f[b5];
                s3 = j[b5];
                b = h[b5];
            } catch (java.lang.RuntimeException e2) {
                e = e2;
            }
            if (b > 0) {
                ?? r21 = s2 + b;
                int i14 = r21 - 1;
                z = z4;
                int i15 = s2;
                while (i14 >= i15) {
                    int i16 = i15 + ((i14 - i15) >> 1);
                    int i17 = i14;
                    char c2 = cArr[i12];
                    int i18 = i15;
                    char c3 = g[i16];
                    if (c2 < c3) {
                        i14 = i16 - 1;
                        i15 = i18;
                    } else if (c2 > c3) {
                        i15 = i16 + 1;
                        i14 = i17;
                    } else {
                        s6 = s3 + (i16 - s2);
                        i5 = i12;
                        s5 = s6;
                        byte b6 = k[s5];
                        byte b7 = l[b6];
                        b2 = m[b6];
                        if (b2 != 0) {
                            int i19 = b2 + 1;
                            byte b8 = e[b2];
                            int i20 = i19;
                            i10 = i13;
                            int i21 = i5;
                            while (true) {
                                ?? r16 = b8 - 1;
                                if (b8 > 0) {
                                    try {
                                        int i22 = i20 + 1;
                                        switch (e[i20]) {
                                            case 0:
                                                bArr2 = bArr3;
                                                b4 = b7;
                                                z5 = true;
                                                b8 = r16;
                                                i20 = i22;
                                                bArr3 = bArr2;
                                                b7 = b4;
                                            case 1:
                                                java.lang.String str3 = new java.lang.String(cArr, i10, i21 - i10);
                                                if (z) {
                                                    str3 = l(str3);
                                                }
                                                if (z5) {
                                                    array2.add(str3);
                                                    bArr2 = bArr3;
                                                    b4 = b7;
                                                    z5 = false;
                                                } else {
                                                    java.lang.String str4 = array2.size > 0 ? (java.lang.String) array2.pop() : null;
                                                    if (z6) {
                                                        if (str3.equals(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE)) {
                                                            bool(str4, true);
                                                        } else if (str3.equals(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE)) {
                                                            bool(str4, false);
                                                        } else if (str3.equals(com.igexin.push.core.b.m)) {
                                                            string(str4, null);
                                                        } else {
                                                            boolean z7 = false;
                                                            boolean z8 = true;
                                                            while (true) {
                                                                if (i10 < i21) {
                                                                    bArr2 = bArr3;
                                                                    char c4 = cArr[i10];
                                                                    b4 = b7;
                                                                    if (c4 != '+') {
                                                                        if (c4 != 'E' && c4 != 'e') {
                                                                            if (c4 == '-') {
                                                                                continue;
                                                                            } else if (c4 != '.') {
                                                                                switch (c4) {
                                                                                    case '0':
                                                                                    case '1':
                                                                                    case '2':
                                                                                    case '3':
                                                                                    case '4':
                                                                                    case '5':
                                                                                    case '6':
                                                                                    case '7':
                                                                                    case '8':
                                                                                    case '9':
                                                                                        break;
                                                                                    default:
                                                                                        z7 = false;
                                                                                        z8 = false;
                                                                                        break;
                                                                                }
                                                                            }
                                                                        }
                                                                        z7 = true;
                                                                        z8 = false;
                                                                    }
                                                                    i10++;
                                                                    bArr3 = bArr2;
                                                                    b7 = b4;
                                                                } else {
                                                                    bArr2 = bArr3;
                                                                    b4 = b7;
                                                                }
                                                            }
                                                            if (z7) {
                                                                try {
                                                                    number(str4, java.lang.Double.parseDouble(str3), str3);
                                                                } catch (java.lang.NumberFormatException unused) {
                                                                }
                                                            } else if (z8) {
                                                                number(str4, java.lang.Long.parseLong(str3), str3);
                                                            }
                                                        }
                                                        bArr2 = bArr3;
                                                        b4 = b7;
                                                    } else {
                                                        bArr2 = bArr3;
                                                        b4 = b7;
                                                    }
                                                    string(str4, str3);
                                                }
                                                i10 = i21;
                                                z6 = false;
                                                b8 = r16;
                                                i20 = i22;
                                                bArr3 = bArr2;
                                                b7 = b4;
                                                break;
                                            case 2:
                                                startObject(array2.size > 0 ? (java.lang.String) array2.pop() : null);
                                                if (i11 == bArr3.length) {
                                                    ?? r0 = new int[bArr3.length * 2];
                                                    java.lang.System.arraycopy(bArr3, 0, r0, 0, bArr3.length);
                                                    bArr3 = r0;
                                                }
                                                bArr3[i11] = b7;
                                                i11++;
                                                i12 = i21;
                                                z4 = z;
                                                c = 2;
                                                b5 = 5;
                                                break;
                                            case 3:
                                                pop();
                                                i11--;
                                                b3 = bArr3[i11];
                                                break;
                                            case 4:
                                                startArray(array2.size > 0 ? (java.lang.String) array2.pop() : null);
                                                if (i11 == bArr3.length) {
                                                    ?? r02 = new int[bArr3.length * 2];
                                                    java.lang.System.arraycopy(bArr3, 0, r02, 0, bArr3.length);
                                                    bArr3 = r02;
                                                }
                                                bArr3[i11] = b7;
                                                i11++;
                                                i12 = i21;
                                                z4 = z;
                                                c = 2;
                                                b5 = com.google.common.base.Ascii.ETB;
                                                break;
                                            case 5:
                                                pop();
                                                i11--;
                                                b3 = bArr3[i11];
                                                break;
                                            case 6:
                                                i12 = i21 + 1;
                                                if (cArr[i21] == '/') {
                                                    while (i12 != i3 && cArr[i12] != '\n') {
                                                        i12++;
                                                    }
                                                    i21 = i12 - 1;
                                                } else {
                                                    while (true) {
                                                        i21 = i12 + 1;
                                                        try {
                                                            if (i21 < i3) {
                                                                try {
                                                                    i6 = i12;
                                                                    if (cArr[i12] != '*') {
                                                                        i12 = i21;
                                                                    }
                                                                } catch (java.lang.RuntimeException e3) {
                                                                    e = e3;
                                                                    runtimeException = e;
                                                                    com.badlogic.gdx.utils.JsonValue jsonValue = this.c;
                                                                    this.c = null;
                                                                    this.d = null;
                                                                    this.b.clear();
                                                                    if (i12 >= i3) {
                                                                    }
                                                                }
                                                            } else {
                                                                i6 = i12;
                                                            }
                                                            if (cArr[i21] != '/') {
                                                                i12 = i21;
                                                            }
                                                        } catch (java.lang.RuntimeException e4) {
                                                            runtimeException = e4;
                                                            i12 = i6;
                                                        }
                                                    }
                                                }
                                                bArr2 = bArr3;
                                                b4 = b7;
                                                b8 = r16;
                                                i20 = i22;
                                                bArr3 = bArr2;
                                                b7 = b4;
                                                break;
                                            case 7:
                                                char c5 = '\r';
                                                int i23 = i21;
                                                if (z5) {
                                                    z3 = false;
                                                    do {
                                                        try {
                                                            char c6 = cArr[i23];
                                                            z2 = z3;
                                                            if (c6 != '\n' && c6 != '\r') {
                                                                if (c6 == '/') {
                                                                    int i24 = i23 + 1;
                                                                    if (i24 != i3) {
                                                                        char c7 = cArr[i24];
                                                                        if (c7 != '/') {
                                                                            if (c7 == '*') {
                                                                            }
                                                                        }
                                                                    }
                                                                    z3 = z2;
                                                                    i23++;
                                                                } else if (c6 != ':') {
                                                                    if (c6 != '\\') {
                                                                        z3 = z2;
                                                                        i23++;
                                                                    } else {
                                                                        z3 = true;
                                                                        i23++;
                                                                    }
                                                                }
                                                                b8 = r16;
                                                                i20 = i22;
                                                                bArr3 = bArr2;
                                                                b7 = b4;
                                                            }
                                                        } catch (java.lang.RuntimeException e5) {
                                                            runtimeException = e5;
                                                            i12 = i23;
                                                            break;
                                                        }
                                                    } while (i23 != i3);
                                                    i7 = i23 - 1;
                                                    while (java.lang.Character.isSpace(cArr[i7])) {
                                                        i7--;
                                                    }
                                                    bArr2 = bArr3;
                                                    b4 = b7;
                                                    i10 = i21;
                                                    z = z3;
                                                    z6 = true;
                                                    i21 = i7;
                                                    b8 = r16;
                                                    i20 = i22;
                                                    bArr3 = bArr2;
                                                    b7 = b4;
                                                } else {
                                                    boolean z9 = false;
                                                    while (true) {
                                                        char c8 = cArr[i23];
                                                        z2 = z9;
                                                        if (c8 != '\n' && c8 != c5 && c8 != ',') {
                                                            if (c8 == '/') {
                                                                int i25 = i23 + 1;
                                                                if (i25 != i3) {
                                                                    char c9 = cArr[i25];
                                                                    if (c9 != '/') {
                                                                        if (c9 == '*') {
                                                                        }
                                                                    }
                                                                }
                                                                i23++;
                                                                if (i23 == i3) {
                                                                }
                                                            } else if (c8 != '}') {
                                                                if (c8 == '\\') {
                                                                    z2 = true;
                                                                } else if (c8 != ']') {
                                                                }
                                                                i23++;
                                                                if (i23 == i3) {
                                                                    z9 = z2;
                                                                    c5 = '\r';
                                                                }
                                                            }
                                                            b8 = r16;
                                                            i20 = i22;
                                                            bArr3 = bArr2;
                                                            b7 = b4;
                                                        }
                                                    }
                                                }
                                                z3 = z2;
                                                i7 = i23 - 1;
                                                while (java.lang.Character.isSpace(cArr[i7])) {
                                                }
                                                bArr2 = bArr3;
                                                b4 = b7;
                                                i10 = i21;
                                                z = z3;
                                                z6 = true;
                                                i21 = i7;
                                                b8 = r16;
                                                i20 = i22;
                                                bArr3 = bArr2;
                                                b7 = b4;
                                                break;
                                            case 8:
                                                int i26 = i21 + 1;
                                                i12 = i26;
                                                boolean z10 = false;
                                                while (true) {
                                                    try {
                                                        char c10 = cArr[i12];
                                                        i8 = i26;
                                                        if (c10 != '\"') {
                                                            if (c10 != '\\') {
                                                                i9 = 1;
                                                            } else {
                                                                i12++;
                                                                i9 = 1;
                                                                z10 = true;
                                                            }
                                                            i12 += i9;
                                                            if (i12 != i3) {
                                                                i26 = i8;
                                                            }
                                                        }
                                                    } catch (java.lang.RuntimeException e6) {
                                                        e = e6;
                                                        runtimeException = e;
                                                        com.badlogic.gdx.utils.JsonValue jsonValue2 = this.c;
                                                        this.c = null;
                                                        this.d = null;
                                                        this.b.clear();
                                                        if (i12 >= i3) {
                                                        }
                                                    }
                                                }
                                                i21 = i12 - 1;
                                                bArr2 = bArr3;
                                                b4 = b7;
                                                z = z10;
                                                i10 = i8;
                                                b8 = r16;
                                                i20 = i22;
                                                bArr3 = bArr2;
                                                b7 = b4;
                                                break;
                                            default:
                                                bArr2 = bArr3;
                                                b4 = b7;
                                                b8 = r16;
                                                i20 = i22;
                                                bArr3 = bArr2;
                                                b7 = b4;
                                        }
                                    } catch (java.lang.RuntimeException e7) {
                                        runtimeException = e7;
                                        i12 = i21;
                                    }
                                    com.badlogic.gdx.utils.JsonValue jsonValue22 = this.c;
                                    this.c = null;
                                    this.d = null;
                                    this.b.clear();
                                    if (i12 >= i3) {
                                        com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.JsonValue> array3 = this.a;
                                        if (array3.size != 0) {
                                            com.badlogic.gdx.utils.JsonValue peek = array3.peek();
                                            this.a.clear();
                                            if (peek == null || !peek.isObject()) {
                                                throw new com.badlogic.gdx.utils.SerializationException("Error parsing JSON, unmatched bracket.");
                                            }
                                            throw new com.badlogic.gdx.utils.SerializationException("Error parsing JSON, unmatched brace.");
                                        }
                                        if (runtimeException == null) {
                                            return jsonValue22;
                                        }
                                        throw new com.badlogic.gdx.utils.SerializationException("Error parsing JSON: " + new java.lang.String(cArr), runtimeException);
                                    }
                                    int i27 = 1;
                                    for (int i28 = 0; i28 < i12; i28++) {
                                        if (cArr[i28] == '\n') {
                                            i27++;
                                        }
                                    }
                                    int max = java.lang.Math.max(0, i12 - 32);
                                    throw new com.badlogic.gdx.utils.SerializationException("Error parsing JSON on line " + i27 + " near: " + new java.lang.String(cArr, max, i12 - max) + "*ERROR*" + new java.lang.String(cArr, i12, java.lang.Math.min(64, i3 - i12)), runtimeException);
                                }
                                bArr = bArr3;
                                i12 = i21;
                                z4 = z;
                                b5 = b7;
                            }
                        } else {
                            bArr = bArr3;
                            i10 = i13;
                            z4 = z;
                            b5 = b7;
                            i12 = i5;
                        }
                        if (b5 != 0) {
                        }
                    }
                }
                s2 = r21;
                s4 = s3 + b;
            } else {
                z = z4;
                s4 = s3;
            }
            byte b9 = i[b5];
            s6 = s4;
            if (b9 > 0) {
                int i29 = ((b9 << 1) + s2) - 2;
                int i30 = s2;
                while (i29 >= i30) {
                    int i31 = i30 + (((i29 - i30) >> 1) & (-2));
                    byte b10 = b9;
                    char c11 = cArr[i12];
                    char[] cArr2 = g;
                    i5 = i12;
                    try {
                        if (c11 < cArr2[i31]) {
                            i29 = i31 - 2;
                        } else if (c11 > cArr2[i31 + 1]) {
                            i30 = i31 + 2;
                        } else {
                            s5 = s4 + ((i31 - s2) >> 1);
                            byte b62 = k[s5];
                            byte b72 = l[b62];
                            b2 = m[b62];
                            if (b2 != 0) {
                            }
                            if (b5 != 0) {
                            }
                        }
                        b9 = b10;
                        i12 = i5;
                    } catch (java.lang.RuntimeException e8) {
                        runtimeException = e8;
                        i12 = i5;
                    }
                }
                s6 = s4 + b9;
            }
            i5 = i12;
            s5 = s6;
            byte b622 = k[s5];
            byte b722 = l[b622];
            b2 = m[b622];
            if (b2 != 0) {
            }
            if (b5 != 0) {
            }
        }
        if (i12 == i3) {
            try {
                byte b11 = n[b5];
                int i32 = b11 + 1;
                byte b12 = e[b11];
                while (true) {
                    ?? r9 = b12 - 1;
                    if (b12 > 0) {
                        int i33 = i32 + 1;
                        if (e[i32] != 1) {
                            str2 = str;
                            i4 = i12;
                            array = array2;
                        } else {
                            java.lang.String str5 = new java.lang.String(cArr, i10, i12 - i10);
                            if (z4) {
                                str5 = l(str5);
                            }
                            if (z5) {
                                array2.add(str5);
                                str2 = str;
                                i4 = i12;
                                array = array2;
                                z5 = false;
                            } else {
                                java.lang.String str6 = array2.size > 0 ? (java.lang.String) array2.pop() : null;
                                if (z6) {
                                    if (str5.equals(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE)) {
                                        bool(str6, true);
                                    } else if (str5.equals(str)) {
                                        bool(str6, false);
                                    } else if (str5.equals(com.igexin.push.core.b.m)) {
                                        string(str6, null);
                                    } else {
                                        boolean z11 = false;
                                        boolean z12 = true;
                                        while (true) {
                                            if (i10 < i12) {
                                                str2 = str;
                                                char c12 = cArr[i10];
                                                i4 = i12;
                                                if (c12 != '+') {
                                                    if (c12 != 'E' && c12 != 'e') {
                                                        if (c12 != '-') {
                                                            if (c12 != '.') {
                                                                switch (c12) {
                                                                    case '0':
                                                                    case '1':
                                                                    case '2':
                                                                    case '3':
                                                                    case '4':
                                                                    case '5':
                                                                    case '6':
                                                                    case '7':
                                                                    case '8':
                                                                    case '9':
                                                                        i10++;
                                                                        str = str2;
                                                                        i12 = i4;
                                                                    default:
                                                                        z11 = false;
                                                                        z12 = false;
                                                                        break;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    z11 = true;
                                                    z12 = false;
                                                    i10++;
                                                    str = str2;
                                                    i12 = i4;
                                                }
                                                i10++;
                                                str = str2;
                                                i12 = i4;
                                            } else {
                                                str2 = str;
                                                i4 = i12;
                                            }
                                        }
                                        if (z11) {
                                            array = array2;
                                            try {
                                                try {
                                                    number(str6, java.lang.Double.parseDouble(str5), str5);
                                                } catch (java.lang.RuntimeException e9) {
                                                    runtimeException = e9;
                                                    i12 = i4;
                                                }
                                            } catch (java.lang.NumberFormatException unused2) {
                                            }
                                        } else {
                                            array = array2;
                                            if (z12) {
                                                number(str6, java.lang.Long.parseLong(str5), str5);
                                            }
                                        }
                                    }
                                    str2 = str;
                                    i4 = i12;
                                    array = array2;
                                } else {
                                    str2 = str;
                                    i4 = i12;
                                    array = array2;
                                }
                                string(str6, str5);
                            }
                            i10 = i4;
                            z6 = false;
                        }
                        array2 = array;
                        b12 = r9;
                        i32 = i33;
                        str = str2;
                        i12 = i4;
                    }
                }
            } catch (java.lang.RuntimeException e10) {
                e = e10;
                runtimeException = e;
                com.badlogic.gdx.utils.JsonValue jsonValue222 = this.c;
                this.c = null;
                this.d = null;
                this.b.clear();
                if (i12 >= i3) {
                }
            }
        }
        i12 = i12;
        runtimeException = null;
        com.badlogic.gdx.utils.JsonValue jsonValue2222 = this.c;
        this.c = null;
        this.d = null;
        this.b.clear();
        if (i12 >= i3) {
        }
    }

    public void pop() {
        this.c = this.a.pop();
        if (this.d.size > 0) {
            this.b.pop();
        }
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.JsonValue> array = this.a;
        this.d = array.size > 0 ? array.peek() : null;
    }

    public void startArray(java.lang.String str) {
        com.badlogic.gdx.utils.JsonValue jsonValue = new com.badlogic.gdx.utils.JsonValue(com.badlogic.gdx.utils.JsonValue.ValueType.array);
        if (this.d != null) {
            a(str, jsonValue);
        }
        this.a.add(jsonValue);
        this.d = jsonValue;
    }

    public void startObject(java.lang.String str) {
        com.badlogic.gdx.utils.JsonValue jsonValue = new com.badlogic.gdx.utils.JsonValue(com.badlogic.gdx.utils.JsonValue.ValueType.object);
        if (this.d != null) {
            a(str, jsonValue);
        }
        this.a.add(jsonValue);
        this.d = jsonValue;
    }

    public void string(java.lang.String str, java.lang.String str2) {
        a(str, new com.badlogic.gdx.utils.JsonValue(str2));
    }
}
