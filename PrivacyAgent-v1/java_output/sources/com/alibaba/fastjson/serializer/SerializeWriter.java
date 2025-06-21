package com.alibaba.fastjson.serializer;

/* loaded from: classes.dex */
public final class SerializeWriter extends java.io.Writer {
    public static final char[] DIGITS;
    static final byte[] specicalFlags_doubleQuotes;
    static final byte[] specicalFlags_singleQuotes;
    protected char[] buf;
    protected int count;
    protected int features;
    protected final java.io.Writer writer;
    private static final java.lang.ThreadLocal<char[]> bufLocal = new java.lang.ThreadLocal<>();
    static final int[] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
    static final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', com.aliyun.svideo.editor.guide.customView.MultiLamp.LEFT, 'm', 'n', 'o', 'p', 'q', com.aliyun.svideo.editor.guide.customView.MultiLamp.RIGHT, 's', com.aliyun.svideo.editor.guide.customView.MultiLamp.TOP, 'u', 'v', 'w', 'x', 'y', 'z'};
    static final char[] DigitTens = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
    static final char[] DigitOnes = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    static final char[] ascii_chars = {'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};
    static final char[] replaceChars = new char[93];

    static {
        byte[] bArr = new byte[161];
        specicalFlags_doubleQuotes = bArr;
        byte[] bArr2 = new byte[161];
        specicalFlags_singleQuotes = bArr2;
        bArr[0] = 4;
        bArr[1] = 4;
        bArr[2] = 4;
        bArr[3] = 4;
        bArr[4] = 4;
        bArr[5] = 4;
        bArr[6] = 4;
        bArr[7] = 4;
        bArr[8] = 1;
        bArr[9] = 1;
        bArr[10] = 1;
        bArr[11] = 4;
        bArr[12] = 1;
        bArr[13] = 1;
        bArr[34] = 1;
        bArr[92] = 1;
        bArr2[0] = 4;
        bArr2[1] = 4;
        bArr2[2] = 4;
        bArr2[3] = 4;
        bArr2[4] = 4;
        bArr2[5] = 4;
        bArr2[6] = 4;
        bArr2[7] = 4;
        bArr2[8] = 1;
        bArr2[9] = 1;
        bArr2[10] = 1;
        bArr2[11] = 4;
        bArr2[12] = 1;
        bArr2[13] = 1;
        bArr2[92] = 1;
        bArr2[39] = 1;
        for (int i = 14; i <= 31; i++) {
            specicalFlags_doubleQuotes[i] = 4;
            specicalFlags_singleQuotes[i] = 4;
        }
        for (int i2 = 127; i2 < 160; i2++) {
            specicalFlags_doubleQuotes[i2] = 4;
            specicalFlags_singleQuotes[i2] = 4;
        }
        char[] cArr = replaceChars;
        cArr[0] = '0';
        cArr[1] = '1';
        cArr[2] = '2';
        cArr[3] = '3';
        cArr[4] = '4';
        cArr[5] = '5';
        cArr[6] = '6';
        cArr[7] = '7';
        cArr[8] = com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM;
        cArr[9] = com.aliyun.svideo.editor.guide.customView.MultiLamp.TOP;
        cArr[10] = 'n';
        cArr[11] = 'v';
        cArr[12] = 'f';
        cArr[13] = com.aliyun.svideo.editor.guide.customView.MultiLamp.RIGHT;
        cArr[34] = kotlin.text.Typography.quote;
        cArr[39] = '\'';
        cArr[47] = '/';
        cArr[92] = '\\';
        DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public SerializeWriter() {
        this((java.io.Writer) null);
    }

    public SerializeWriter(int i) {
        this(null, i);
    }

    public SerializeWriter(java.io.Writer writer) {
        this.writer = writer;
        this.features = com.alibaba.fastjson.JSON.DEFAULT_GENERATE_FEATURE;
        java.lang.ThreadLocal<char[]> threadLocal = bufLocal;
        this.buf = threadLocal.get();
        if (threadLocal != null) {
            threadLocal.set(null);
        }
        if (this.buf == null) {
            this.buf = new char[1024];
        }
    }

    public SerializeWriter(java.io.Writer writer, int i) {
        this.writer = writer;
        if (i > 0) {
            this.buf = new char[i];
            return;
        }
        throw new java.lang.IllegalArgumentException("Negative initial size: " + i);
    }

    public SerializeWriter(java.io.Writer writer, int i, com.alibaba.fastjson.serializer.SerializerFeature[] serializerFeatureArr) {
        this.writer = writer;
        java.lang.ThreadLocal<char[]> threadLocal = bufLocal;
        char[] cArr = threadLocal.get();
        this.buf = cArr;
        if (cArr != null) {
            threadLocal.set(null);
        }
        if (this.buf == null) {
            this.buf = new char[1024];
        }
        for (com.alibaba.fastjson.serializer.SerializerFeature serializerFeature : serializerFeatureArr) {
            i |= serializerFeature.mask;
        }
        this.features = i;
    }

    public SerializeWriter(com.alibaba.fastjson.serializer.SerializerFeature... serializerFeatureArr) {
        this(null, 0, serializerFeatureArr);
    }

    public static void getChars(long j, int i, char[] cArr) {
        char c;
        if (j < 0) {
            j = -j;
            c = '-';
        } else {
            c = 0;
        }
        while (j > 2147483647L) {
            long j2 = j / 100;
            int i2 = (int) (j - (((j2 << 6) + (j2 << 5)) + (j2 << 2)));
            int i3 = i - 1;
            cArr[i3] = DigitOnes[i2];
            i = i3 - 1;
            cArr[i] = DigitTens[i2];
            j = j2;
        }
        int i4 = (int) j;
        while (i4 >= 65536) {
            int i5 = i4 / 100;
            int i6 = i4 - (((i5 << 6) + (i5 << 5)) + (i5 << 2));
            int i7 = i - 1;
            cArr[i7] = DigitOnes[i6];
            i = i7 - 1;
            cArr[i] = DigitTens[i6];
            i4 = i5;
        }
        while (true) {
            int i8 = (52429 * i4) >>> 19;
            i--;
            cArr[i] = digits[i4 - ((i8 << 3) + (i8 << 1))];
            if (i8 == 0) {
                break;
            } else {
                i4 = i8;
            }
        }
        if (c != 0) {
            cArr[i - 1] = c;
        }
    }

    private void writeKeyWithDoubleQuoteIfHasSpecial(java.lang.String str) {
        int length = str.length();
        boolean z = true;
        int i = this.count + length + 1;
        if (i > this.buf.length) {
            if (this.writer != null) {
                if (length == 0) {
                    write(34);
                    write(34);
                    write(58);
                    return;
                }
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = false;
                        break;
                    }
                    char charAt = str.charAt(i2);
                    byte[] bArr = specicalFlags_doubleQuotes;
                    if (charAt < bArr.length && bArr[charAt] != 0) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z) {
                    write(34);
                }
                for (int i3 = 0; i3 < length; i3++) {
                    char charAt2 = str.charAt(i3);
                    byte[] bArr2 = specicalFlags_doubleQuotes;
                    if (charAt2 >= bArr2.length || bArr2[charAt2] == 0) {
                        write(charAt2);
                    } else {
                        write(92);
                        write(replaceChars[charAt2]);
                    }
                }
                if (z) {
                    write(34);
                }
                write(58);
                return;
            }
            expandCapacity(i);
        }
        if (length == 0) {
            int i4 = this.count;
            if (i4 + 3 > this.buf.length) {
                expandCapacity(i4 + 3);
            }
            char[] cArr = this.buf;
            int i5 = this.count;
            int i6 = i5 + 1;
            cArr[i5] = kotlin.text.Typography.quote;
            int i7 = i6 + 1;
            cArr[i6] = kotlin.text.Typography.quote;
            this.count = i7 + 1;
            cArr[i7] = ':';
            return;
        }
        int i8 = this.count;
        int i9 = i8 + length;
        str.getChars(0, length, this.buf, i8);
        this.count = i;
        int i10 = i8;
        boolean z2 = false;
        while (i10 < i9) {
            char[] cArr2 = this.buf;
            char c = cArr2[i10];
            byte[] bArr3 = specicalFlags_doubleQuotes;
            if (c < bArr3.length && bArr3[c] != 0) {
                if (z2) {
                    i++;
                    if (i > cArr2.length) {
                        expandCapacity(i);
                    }
                    this.count = i;
                    char[] cArr3 = this.buf;
                    int i11 = i10 + 1;
                    java.lang.System.arraycopy(cArr3, i11, cArr3, i10 + 2, i9 - i10);
                    char[] cArr4 = this.buf;
                    cArr4[i10] = '\\';
                    cArr4[i11] = replaceChars[c];
                    i9++;
                    i10 = i11;
                } else {
                    i += 3;
                    if (i > cArr2.length) {
                        expandCapacity(i);
                    }
                    this.count = i;
                    char[] cArr5 = this.buf;
                    int i12 = i10 + 1;
                    java.lang.System.arraycopy(cArr5, i12, cArr5, i10 + 3, (i9 - i10) - 1);
                    char[] cArr6 = this.buf;
                    java.lang.System.arraycopy(cArr6, 0, cArr6, 1, i10);
                    char[] cArr7 = this.buf;
                    cArr7[i8] = kotlin.text.Typography.quote;
                    cArr7[i12] = '\\';
                    int i13 = i12 + 1;
                    cArr7[i13] = replaceChars[c];
                    i9 += 2;
                    cArr7[this.count - 2] = kotlin.text.Typography.quote;
                    i10 = i13;
                    z2 = true;
                }
            }
            i10++;
        }
        this.buf[this.count - 1] = ':';
    }

    private void writeKeyWithSingleQuoteIfHasSpecial(java.lang.String str) {
        int length = str.length();
        boolean z = true;
        int i = this.count + length + 1;
        if (i > this.buf.length) {
            if (this.writer != null) {
                if (length == 0) {
                    write(39);
                    write(39);
                    write(58);
                    return;
                }
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = false;
                        break;
                    }
                    char charAt = str.charAt(i2);
                    byte[] bArr = specicalFlags_singleQuotes;
                    if (charAt < bArr.length && bArr[charAt] != 0) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z) {
                    write(39);
                }
                for (int i3 = 0; i3 < length; i3++) {
                    char charAt2 = str.charAt(i3);
                    byte[] bArr2 = specicalFlags_singleQuotes;
                    if (charAt2 >= bArr2.length || bArr2[charAt2] == 0) {
                        write(charAt2);
                    } else {
                        write(92);
                        write(replaceChars[charAt2]);
                    }
                }
                if (z) {
                    write(39);
                }
                write(58);
                return;
            }
            expandCapacity(i);
        }
        if (length == 0) {
            int i4 = this.count;
            if (i4 + 3 > this.buf.length) {
                expandCapacity(i4 + 3);
            }
            char[] cArr = this.buf;
            int i5 = this.count;
            int i6 = i5 + 1;
            cArr[i5] = '\'';
            int i7 = i6 + 1;
            cArr[i6] = '\'';
            this.count = i7 + 1;
            cArr[i7] = ':';
            return;
        }
        int i8 = this.count;
        int i9 = i8 + length;
        str.getChars(0, length, this.buf, i8);
        this.count = i;
        int i10 = i8;
        boolean z2 = false;
        while (i10 < i9) {
            char[] cArr2 = this.buf;
            char c = cArr2[i10];
            byte[] bArr3 = specicalFlags_singleQuotes;
            if (c < bArr3.length && bArr3[c] != 0) {
                if (z2) {
                    i++;
                    if (i > cArr2.length) {
                        expandCapacity(i);
                    }
                    this.count = i;
                    char[] cArr3 = this.buf;
                    int i11 = i10 + 1;
                    java.lang.System.arraycopy(cArr3, i11, cArr3, i10 + 2, i9 - i10);
                    char[] cArr4 = this.buf;
                    cArr4[i10] = '\\';
                    cArr4[i11] = replaceChars[c];
                    i9++;
                    i10 = i11;
                } else {
                    i += 3;
                    if (i > cArr2.length) {
                        expandCapacity(i);
                    }
                    this.count = i;
                    char[] cArr5 = this.buf;
                    int i12 = i10 + 1;
                    java.lang.System.arraycopy(cArr5, i12, cArr5, i10 + 3, (i9 - i10) - 1);
                    char[] cArr6 = this.buf;
                    java.lang.System.arraycopy(cArr6, 0, cArr6, 1, i10);
                    char[] cArr7 = this.buf;
                    cArr7[i8] = '\'';
                    cArr7[i12] = '\\';
                    int i13 = i12 + 1;
                    cArr7[i13] = replaceChars[c];
                    i9 += 2;
                    cArr7[this.count - 2] = '\'';
                    i10 = i13;
                    z2 = true;
                }
            }
            i10++;
        }
        this.buf[i - 1] = ':';
    }

    @Override // java.io.Writer, java.lang.Appendable
    public com.alibaba.fastjson.serializer.SerializeWriter append(char c) {
        write(c);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public com.alibaba.fastjson.serializer.SerializeWriter append(java.lang.CharSequence charSequence) {
        java.lang.String charSequence2 = charSequence == null ? com.igexin.push.core.b.m : charSequence.toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public com.alibaba.fastjson.serializer.SerializeWriter append(java.lang.CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            charSequence = com.igexin.push.core.b.m;
        }
        java.lang.String charSequence2 = charSequence.subSequence(i, i2).toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.writer != null && this.count > 0) {
            flush();
        }
        char[] cArr = this.buf;
        if (cArr.length <= 8192) {
            bufLocal.set(cArr);
        }
        this.buf = null;
    }

    public void config(com.alibaba.fastjson.serializer.SerializerFeature serializerFeature, boolean z) {
        if (z) {
            this.features = serializerFeature.mask | this.features;
        } else {
            this.features = (~serializerFeature.mask) & this.features;
        }
    }

    public void expandCapacity(int i) {
        char[] cArr = this.buf;
        int length = ((cArr.length * 3) / 2) + 1;
        if (length >= i) {
            i = length;
        }
        char[] cArr2 = new char[i];
        java.lang.System.arraycopy(cArr, 0, cArr2, 0, this.count);
        this.buf = cArr2;
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        java.io.Writer writer = this.writer;
        if (writer == null) {
            return;
        }
        try {
            writer.write(this.buf, 0, this.count);
            this.writer.flush();
            this.count = 0;
        } catch (java.io.IOException e) {
            throw new com.alibaba.fastjson.JSONException(e.getMessage(), e);
        }
    }

    public boolean isEnabled(com.alibaba.fastjson.serializer.SerializerFeature serializerFeature) {
        return (serializerFeature.mask & this.features) != 0;
    }

    public byte[] toBytes(java.lang.String str) {
        if (this.writer != null) {
            throw new java.lang.UnsupportedOperationException("writer not null");
        }
        if (str == null) {
            str = "UTF-8";
        }
        try {
            return new java.lang.String(this.buf, 0, this.count).getBytes(str);
        } catch (java.io.UnsupportedEncodingException e) {
            throw new com.alibaba.fastjson.JSONException("toBytes error", e);
        }
    }

    public java.lang.String toString() {
        return new java.lang.String(this.buf, 0, this.count);
    }

    @Override // java.io.Writer
    public void write(int i) {
        int i2 = 1;
        int i3 = this.count + 1;
        if (i3 > this.buf.length) {
            if (this.writer != null) {
                flush();
                this.buf[this.count] = (char) i;
                this.count = i2;
            }
            expandCapacity(i3);
        }
        i2 = i3;
        this.buf[this.count] = (char) i;
        this.count = i2;
    }

    @Override // java.io.Writer
    public void write(java.lang.String str) {
        if (str == null) {
            writeNull();
        } else {
            write(str, 0, str.length());
        }
    }

    @Override // java.io.Writer
    public void write(java.lang.String str, int i, int i2) {
        int i3;
        int i4 = this.count + i2;
        if (i4 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i4);
            } else {
                while (true) {
                    char[] cArr = this.buf;
                    int length = cArr.length;
                    int i5 = this.count;
                    int i6 = length - i5;
                    i3 = i + i6;
                    str.getChars(i, i3, cArr, i5);
                    this.count = this.buf.length;
                    flush();
                    i2 -= i6;
                    if (i2 <= this.buf.length) {
                        break;
                    } else {
                        i = i3;
                    }
                }
                i4 = i2;
                i = i3;
            }
        }
        str.getChars(i, i2 + i, this.buf, this.count);
        this.count = i4;
    }

    public void write(boolean z) {
        write(z ? com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE : com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        int i3;
        if (i < 0 || i > cArr.length || i2 < 0 || (i3 = i + i2) > cArr.length || i3 < 0) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return;
        }
        int i4 = this.count + i2;
        if (i4 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i4);
            } else {
                do {
                    char[] cArr2 = this.buf;
                    int length = cArr2.length;
                    int i5 = this.count;
                    int i6 = length - i5;
                    java.lang.System.arraycopy(cArr, i, cArr2, i5, i6);
                    this.count = this.buf.length;
                    flush();
                    i2 -= i6;
                    i += i6;
                } while (i2 > this.buf.length);
                i4 = i2;
            }
        }
        java.lang.System.arraycopy(cArr, i, this.buf, this.count, i2);
        this.count = i4;
    }

    public void writeByteArray(byte[] bArr) {
        int length = bArr.length;
        boolean z = (this.features & com.alibaba.fastjson.serializer.SerializerFeature.UseSingleQuotes.mask) != 0;
        char c = z ? '\'' : kotlin.text.Typography.quote;
        if (length == 0) {
            write(z ? "''" : "\"\"");
            return;
        }
        char[] cArr = com.alibaba.fastjson.parser.JSONLexer.CA;
        int i = (length / 3) * 3;
        int i2 = length - 1;
        int i3 = this.count;
        int i4 = (((i2 / 3) + 1) << 2) + i3 + 2;
        if (i4 > this.buf.length) {
            if (this.writer != null) {
                write(c);
                int i5 = 0;
                while (i5 < i) {
                    int i6 = i5 + 1;
                    int i7 = i6 + 1;
                    int i8 = ((bArr[i5] & 255) << 16) | ((bArr[i6] & 255) << 8) | (bArr[i7] & 255);
                    write(cArr[(i8 >>> 18) & 63]);
                    write(cArr[(i8 >>> 12) & 63]);
                    write(cArr[(i8 >>> 6) & 63]);
                    write(cArr[i8 & 63]);
                    i5 = i7 + 1;
                }
                int i9 = length - i;
                if (i9 > 0) {
                    int i10 = ((bArr[i] & 255) << 10) | (i9 == 2 ? (bArr[i2] & 255) << 2 : 0);
                    write(cArr[i10 >> 12]);
                    write(cArr[(i10 >>> 6) & 63]);
                    write(i9 == 2 ? cArr[i10 & 63] : com.alipay.sdk.m.n.a.h);
                    write(61);
                }
                write(c);
                return;
            }
            expandCapacity(i4);
        }
        this.count = i4;
        int i11 = i3 + 1;
        this.buf[i3] = c;
        int i12 = 0;
        while (i12 < i) {
            int i13 = i12 + 1;
            int i14 = i13 + 1;
            int i15 = ((bArr[i12] & 255) << 16) | ((bArr[i13] & 255) << 8);
            int i16 = i14 + 1;
            int i17 = i15 | (bArr[i14] & 255);
            char[] cArr2 = this.buf;
            int i18 = i11 + 1;
            cArr2[i11] = cArr[(i17 >>> 18) & 63];
            int i19 = i18 + 1;
            cArr2[i18] = cArr[(i17 >>> 12) & 63];
            int i20 = i19 + 1;
            cArr2[i19] = cArr[(i17 >>> 6) & 63];
            i11 = i20 + 1;
            cArr2[i20] = cArr[i17 & 63];
            i12 = i16;
        }
        int i21 = length - i;
        if (i21 > 0) {
            int i22 = ((bArr[i] & 255) << 10) | (i21 == 2 ? (bArr[i2] & 255) << 2 : 0);
            char[] cArr3 = this.buf;
            cArr3[i4 - 5] = cArr[i22 >> 12];
            cArr3[i4 - 4] = cArr[(i22 >>> 6) & 63];
            cArr3[i4 - 3] = i21 == 2 ? cArr[i22 & 63] : com.alipay.sdk.m.n.a.h;
            cArr3[i4 - 2] = com.alipay.sdk.m.n.a.h;
        }
        this.buf[i4 - 1] = c;
    }

    public void writeFieldName(java.lang.String str, boolean z) {
        int i = this.features;
        if ((com.alibaba.fastjson.serializer.SerializerFeature.UseSingleQuotes.mask & i) == 0) {
            if ((i & com.alibaba.fastjson.serializer.SerializerFeature.QuoteFieldNames.mask) != 0) {
                writeStringWithDoubleQuote(str, ':', z);
                return;
            } else {
                writeKeyWithDoubleQuoteIfHasSpecial(str);
                return;
            }
        }
        if ((com.alibaba.fastjson.serializer.SerializerFeature.QuoteFieldNames.mask & i) == 0) {
            writeKeyWithSingleQuoteIfHasSpecial(str);
        } else {
            writeStringWithSingleQuote(str);
            write(58);
        }
    }

    public void writeInt(int i) {
        if (i == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        int i2 = 0;
        while ((i < 0 ? -i : i) > sizeTable[i2]) {
            i2++;
        }
        int i3 = i2 + 1;
        if (i < 0) {
            i3++;
        }
        int i4 = this.count + i3;
        if (i4 > this.buf.length) {
            if (this.writer != null) {
                char[] cArr = new char[i3];
                getChars(i, i3, cArr);
                write(cArr, 0, i3);
                return;
            }
            expandCapacity(i4);
        }
        getChars(i, i4, this.buf);
        this.count = i4;
    }

    public void writeLong(long j) {
        if (j == Long.MIN_VALUE) {
            write("-9223372036854775808");
            return;
        }
        long j2 = j < 0 ? -j : j;
        int i = 1;
        long j3 = 10;
        while (true) {
            if (i >= 19) {
                i = 0;
                break;
            } else {
                if (j2 < j3) {
                    break;
                }
                j3 *= 10;
                i++;
            }
        }
        int i2 = i != 0 ? i : 19;
        if (j < 0) {
            i2++;
        }
        int i3 = this.count + i2;
        if (i3 > this.buf.length) {
            if (this.writer != null) {
                char[] cArr = new char[i2];
                getChars(j, i2, cArr);
                write(cArr, 0, i2);
                return;
            }
            expandCapacity(i3);
        }
        getChars(j, i3, this.buf);
        this.count = i3;
    }

    public void writeNull() {
        write(com.igexin.push.core.b.m);
    }

    public void writeString(java.lang.String str) {
        if ((this.features & com.alibaba.fastjson.serializer.SerializerFeature.UseSingleQuotes.mask) != 0) {
            writeStringWithSingleQuote(str);
        } else {
            writeStringWithDoubleQuote(str, (char) 0, true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0092, code lost:
    
        if (r14 == (-1)) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0094, code lost:
    
        r15 = r3;
        r14 = r12;
        r16 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00e4, code lost:
    
        if (r14 == (-1)) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00c0, code lost:
    
        if ((com.alibaba.fastjson.serializer.SerializerFeature.WriteSlashAsSpecial.mask & r17.features) != 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00c8, code lost:
    
        if (r3 != '\\') goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00d1, code lost:
    
        if (r3 != '\"') goto L55;
     */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00e7 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void writeStringWithDoubleQuote(java.lang.String str, char c, boolean z) {
        int i;
        boolean z2;
        if (str == null) {
            writeNull();
            if (c != 0) {
                write(c);
                return;
            }
            return;
        }
        int length = str.length();
        int i2 = this.count + length + 2;
        if (c != 0) {
            i2++;
        }
        char c2 = '/';
        if (i2 > this.buf.length) {
            if (this.writer != null) {
                write(34);
                for (int i3 = 0; i3 < str.length(); i3++) {
                    char charAt = str.charAt(i3);
                    byte[] bArr = specicalFlags_doubleQuotes;
                    if ((charAt >= bArr.length || bArr[charAt] == 0) && (charAt != '/' || (this.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteSlashAsSpecial.mask) == 0)) {
                        write(charAt);
                    } else {
                        write(92);
                        write(replaceChars[charAt]);
                    }
                }
                write(34);
                if (c != 0) {
                    write(c);
                    return;
                }
                return;
            }
            expandCapacity(i2);
        }
        int i4 = this.count;
        int i5 = i4 + 1;
        int i6 = i5 + length;
        char[] cArr = this.buf;
        cArr[i4] = kotlin.text.Typography.quote;
        str.getChars(0, length, cArr, i5);
        this.count = i2;
        if (z) {
            int i7 = i5;
            int i8 = 0;
            int i9 = -1;
            char c3 = 0;
            int i10 = -1;
            while (i7 < i6) {
                char c4 = this.buf[i7];
                if (c4 == 8232) {
                    i8++;
                    i2 += 4;
                } else if (c4 < ']') {
                    if (c4 != ' ') {
                        if (c4 == c2) {
                        }
                        if (c4 > '#') {
                        }
                        if (c4 > 31) {
                            if (c4 != '\\') {
                            }
                        }
                        z2 = true;
                        if (!z2) {
                            i8++;
                            byte[] bArr2 = specicalFlags_doubleQuotes;
                            if (c4 < bArr2.length && bArr2[c4] == 4) {
                                i2 += 4;
                            }
                        }
                    }
                    z2 = false;
                    if (!z2) {
                    }
                } else if (c4 >= 127 && c4 < 160) {
                    if (i9 == -1) {
                        i9 = i7;
                    }
                    i8++;
                    i2 += 4;
                    c3 = c4;
                    i10 = i7;
                }
                i7++;
                c2 = '/';
            }
            if (i8 > 0) {
                int i11 = i2 + i8;
                if (i11 > this.buf.length) {
                    expandCapacity(i11);
                }
                this.count = i11;
                if (i8 == 1) {
                    if (c3 == 8232) {
                        int i12 = i10 + 1;
                        char[] cArr2 = this.buf;
                        java.lang.System.arraycopy(cArr2, i12, cArr2, i10 + 6, (i6 - i10) - 1);
                        char[] cArr3 = this.buf;
                        cArr3[i10] = '\\';
                        cArr3[i12] = 'u';
                        int i13 = i12 + 1;
                        cArr3[i13] = '2';
                        int i14 = i13 + 1;
                        cArr3[i14] = '0';
                        int i15 = i14 + 1;
                        cArr3[i15] = '2';
                        cArr3[i15 + 1] = '8';
                    } else {
                        byte[] bArr3 = specicalFlags_doubleQuotes;
                        if (c3 >= bArr3.length || bArr3[c3] != 4) {
                            int i16 = i10 + 1;
                            char[] cArr4 = this.buf;
                            java.lang.System.arraycopy(cArr4, i16, cArr4, i10 + 2, (i6 - i10) - 1);
                            char[] cArr5 = this.buf;
                            cArr5[i10] = '\\';
                            cArr5[i16] = replaceChars[c3];
                        } else {
                            int i17 = i10 + 1;
                            char[] cArr6 = this.buf;
                            java.lang.System.arraycopy(cArr6, i17, cArr6, i10 + 6, (i6 - i10) - 1);
                            char[] cArr7 = this.buf;
                            cArr7[i10] = '\\';
                            int i18 = i17 + 1;
                            cArr7[i17] = 'u';
                            int i19 = i18 + 1;
                            char[] cArr8 = DIGITS;
                            cArr7[i18] = cArr8[(c3 >>> '\f') & 15];
                            int i20 = i19 + 1;
                            cArr7[i19] = cArr8[(c3 >>> '\b') & 15];
                            cArr7[i20] = cArr8[(c3 >>> 4) & 15];
                            cArr7[i20 + 1] = cArr8[c3 & 15];
                        }
                    }
                } else if (i8 > 1) {
                    for (int i21 = i9 - i5; i21 < str.length(); i21++) {
                        char charAt2 = str.charAt(i21);
                        byte[] bArr4 = specicalFlags_doubleQuotes;
                        if ((charAt2 >= bArr4.length || bArr4[charAt2] == 0) && (charAt2 != '/' || (this.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteSlashAsSpecial.mask) == 0)) {
                            if (charAt2 == 8232) {
                                char[] cArr9 = this.buf;
                                int i22 = i9 + 1;
                                cArr9[i9] = '\\';
                                int i23 = i22 + 1;
                                cArr9[i22] = 'u';
                                int i24 = i23 + 1;
                                char[] cArr10 = DIGITS;
                                cArr9[i23] = cArr10[(charAt2 >>> '\f') & 15];
                                int i25 = i24 + 1;
                                cArr9[i24] = cArr10[(charAt2 >>> '\b') & 15];
                                int i26 = i25 + 1;
                                cArr9[i25] = cArr10[(charAt2 >>> 4) & 15];
                                cArr9[i26] = cArr10[charAt2 & 15];
                                i9 = i26 + 1;
                            } else {
                                this.buf[i9] = charAt2;
                                i9++;
                            }
                        }
                        char[] cArr11 = this.buf;
                        int i27 = i9 + 1;
                        cArr11[i9] = '\\';
                        if (bArr4[charAt2] == 4) {
                            int i28 = i27 + 1;
                            cArr11[i27] = 'u';
                            int i29 = i28 + 1;
                            char[] cArr12 = DIGITS;
                            cArr11[i28] = cArr12[(charAt2 >>> '\f') & 15];
                            int i30 = i29 + 1;
                            cArr11[i29] = cArr12[(charAt2 >>> '\b') & 15];
                            int i31 = i30 + 1;
                            cArr11[i30] = cArr12[(charAt2 >>> 4) & 15];
                            i = i31 + 1;
                            cArr11[i31] = cArr12[charAt2 & 15];
                        } else {
                            i = i27 + 1;
                            cArr11[i27] = replaceChars[charAt2];
                        }
                        i9 = i;
                    }
                }
            }
        }
        if (c == 0) {
            this.buf[this.count - 1] = kotlin.text.Typography.quote;
            return;
        }
        char[] cArr13 = this.buf;
        int i32 = this.count;
        cArr13[i32 - 2] = kotlin.text.Typography.quote;
        cArr13[i32 - 1] = c;
    }

    public void writeStringWithSingleQuote(java.lang.String str) {
        int i = 0;
        if (str == null) {
            int i2 = this.count + 4;
            if (i2 > this.buf.length) {
                expandCapacity(i2);
            }
            com.igexin.push.core.b.m.getChars(0, 4, this.buf, this.count);
            this.count = i2;
            return;
        }
        int length = str.length();
        int i3 = this.count + length + 2;
        if (i3 > this.buf.length) {
            if (this.writer != null) {
                write(39);
                while (i < str.length()) {
                    char charAt = str.charAt(i);
                    if (charAt <= '\r' || charAt == '\\' || charAt == '\'' || (charAt == '/' && (this.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteSlashAsSpecial.mask) != 0)) {
                        write(92);
                        write(replaceChars[charAt]);
                    } else {
                        write(charAt);
                    }
                    i++;
                }
                write(39);
                return;
            }
            expandCapacity(i3);
        }
        int i4 = this.count;
        int i5 = i4 + 1;
        int i6 = i5 + length;
        char[] cArr = this.buf;
        cArr[i4] = '\'';
        str.getChars(0, length, cArr, i5);
        this.count = i3;
        int i7 = -1;
        char c = 0;
        for (int i8 = i5; i8 < i6; i8++) {
            char c2 = this.buf[i8];
            if (c2 <= '\r' || c2 == '\\' || c2 == '\'' || (c2 == '/' && (this.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteSlashAsSpecial.mask) != 0)) {
                i++;
                i7 = i8;
                c = c2;
            }
        }
        int i9 = i3 + i;
        if (i9 > this.buf.length) {
            expandCapacity(i9);
        }
        this.count = i9;
        if (i == 1) {
            char[] cArr2 = this.buf;
            int i10 = i7 + 1;
            java.lang.System.arraycopy(cArr2, i10, cArr2, i7 + 2, (i6 - i7) - 1);
            char[] cArr3 = this.buf;
            cArr3[i7] = '\\';
            cArr3[i10] = replaceChars[c];
        } else if (i > 1) {
            char[] cArr4 = this.buf;
            int i11 = i7 + 1;
            java.lang.System.arraycopy(cArr4, i11, cArr4, i7 + 2, (i6 - i7) - 1);
            char[] cArr5 = this.buf;
            cArr5[i7] = '\\';
            cArr5[i11] = replaceChars[c];
            int i12 = i6 + 1;
            for (int i13 = i11 - 2; i13 >= i5; i13--) {
                char[] cArr6 = this.buf;
                char c3 = cArr6[i13];
                if (c3 <= '\r' || c3 == '\\' || c3 == '\'' || (c3 == '/' && (this.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteSlashAsSpecial.mask) != 0)) {
                    int i14 = i13 + 1;
                    java.lang.System.arraycopy(cArr6, i14, cArr6, i13 + 2, (i12 - i13) - 1);
                    char[] cArr7 = this.buf;
                    cArr7[i13] = '\\';
                    cArr7[i14] = replaceChars[c3];
                    i12++;
                }
            }
        }
        this.buf[this.count - 1] = '\'';
    }

    public void writeTo(java.io.OutputStream outputStream, java.lang.String str) throws java.io.IOException {
        writeTo(outputStream, java.nio.charset.Charset.forName(str));
    }

    public void writeTo(java.io.OutputStream outputStream, java.nio.charset.Charset charset) throws java.io.IOException {
        if (this.writer != null) {
            throw new java.lang.UnsupportedOperationException("writer not null");
        }
        outputStream.write(new java.lang.String(this.buf, 0, this.count).getBytes(charset.name()));
    }

    public void writeTo(java.io.Writer writer) throws java.io.IOException {
        if (this.writer != null) {
            throw new java.lang.UnsupportedOperationException("writer not null");
        }
        writer.write(this.buf, 0, this.count);
    }
}
