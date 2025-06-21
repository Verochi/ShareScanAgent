package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public class StringBuilder implements java.lang.Appendable, java.lang.CharSequence {
    public static final char[] n = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public char[] chars;
    public int length;

    public StringBuilder() {
        this.chars = new char[16];
    }

    public StringBuilder(int i) {
        if (i < 0) {
            throw new java.lang.NegativeArraySizeException();
        }
        this.chars = new char[i];
    }

    public StringBuilder(com.badlogic.gdx.utils.StringBuilder stringBuilder) {
        int i = stringBuilder.length;
        this.length = i;
        char[] cArr = new char[i + 16];
        this.chars = cArr;
        java.lang.System.arraycopy(stringBuilder.chars, 0, cArr, 0, i);
    }

    public StringBuilder(java.lang.CharSequence charSequence) {
        this(charSequence.toString());
    }

    public StringBuilder(java.lang.String str) {
        int length = str.length();
        this.length = length;
        char[] cArr = new char[length + 16];
        this.chars = cArr;
        str.getChars(0, length, cArr, 0);
    }

    public static int numChars(int i, int i2) {
        int i3 = i < 0 ? 2 : 1;
        while (true) {
            i /= i2;
            if (i == 0) {
                return i3;
            }
            i3++;
        }
    }

    public static int numChars(long j, int i) {
        int i2 = j < 0 ? 2 : 1;
        while (true) {
            j /= i;
            if (j == 0) {
                return i2;
            }
            i2++;
        }
    }

    public final void a(char c) {
        int i = this.length;
        if (i == this.chars.length) {
            i(i + 1);
        }
        char[] cArr = this.chars;
        int i2 = this.length;
        this.length = i2 + 1;
        cArr[i2] = c;
    }

    @Override // java.lang.Appendable
    public com.badlogic.gdx.utils.StringBuilder append(char c) {
        a(c);
        return this;
    }

    public com.badlogic.gdx.utils.StringBuilder append(double d) {
        c(java.lang.Double.toString(d));
        return this;
    }

    public com.badlogic.gdx.utils.StringBuilder append(float f) {
        c(java.lang.Float.toString(f));
        return this;
    }

    public com.badlogic.gdx.utils.StringBuilder append(int i) {
        return append(i, 0);
    }

    public com.badlogic.gdx.utils.StringBuilder append(int i, int i2) {
        return append(i, i2, '0');
    }

    public com.badlogic.gdx.utils.StringBuilder append(int i, int i2, char c) {
        if (i == Integer.MIN_VALUE) {
            c("-2147483648");
            return this;
        }
        if (i < 0) {
            a('-');
            i = -i;
        }
        if (i2 > 1) {
            for (int numChars = i2 - numChars(i, 10); numChars > 0; numChars--) {
                append(c);
            }
        }
        if (i >= 10000) {
            if (i >= 1000000000) {
                a(n[(int) ((i % 10000000000L) / 1000000000)]);
            }
            if (i >= 100000000) {
                a(n[(i % com.airbnb.lottie.utils.Utils.SECOND_IN_NANOS) / 100000000]);
            }
            if (i >= 10000000) {
                a(n[(i % 100000000) / com.huawei.hms.framework.common.ExceptionCode.CRASH_EXCEPTION]);
            }
            if (i >= 1000000) {
                a(n[(i % com.huawei.hms.framework.common.ExceptionCode.CRASH_EXCEPTION) / 1000000]);
            }
            if (i >= 100000) {
                a(n[(i % 1000000) / 100000]);
            }
            a(n[(i % 100000) / 10000]);
        }
        if (i >= 1000) {
            a(n[(i % 10000) / 1000]);
        }
        if (i >= 100) {
            a(n[(i % 1000) / 100]);
        }
        if (i >= 10) {
            a(n[(i % 100) / 10]);
        }
        a(n[i % 10]);
        return this;
    }

    public com.badlogic.gdx.utils.StringBuilder append(long j) {
        return append(j, 0);
    }

    public com.badlogic.gdx.utils.StringBuilder append(long j, int i) {
        return append(j, i, '0');
    }

    public com.badlogic.gdx.utils.StringBuilder append(long j, int i, char c) {
        if (j == Long.MIN_VALUE) {
            c("-9223372036854775808");
            return this;
        }
        if (j < 0) {
            a('-');
            j = -j;
        }
        if (i > 1) {
            for (int numChars = i - numChars(j, 10); numChars > 0; numChars--) {
                append(c);
            }
        }
        if (j >= 10000) {
            if (j >= 1000000000000000000L) {
                a(n[(int) ((j % 1.0E19d) / 1.0E18d)]);
            }
            if (j >= 100000000000000000L) {
                a(n[(int) ((j % 1000000000000000000L) / 100000000000000000L)]);
            }
            if (j >= 10000000000000000L) {
                a(n[(int) ((j % 100000000000000000L) / 10000000000000000L)]);
            }
            if (j >= 1000000000000000L) {
                a(n[(int) ((j % 10000000000000000L) / 1000000000000000L)]);
            }
            if (j >= 100000000000000L) {
                a(n[(int) ((j % 1000000000000000L) / 100000000000000L)]);
            }
            if (j >= 10000000000000L) {
                a(n[(int) ((j % 100000000000000L) / 10000000000000L)]);
            }
            if (j >= 1000000000000L) {
                a(n[(int) ((j % 10000000000000L) / 1000000000000L)]);
            }
            if (j >= 100000000000L) {
                a(n[(int) ((j % 1000000000000L) / 100000000000L)]);
            }
            if (j >= 10000000000L) {
                a(n[(int) ((j % 100000000000L) / 10000000000L)]);
            }
            if (j >= 1000000000) {
                a(n[(int) ((j % 10000000000L) / 1000000000)]);
            }
            if (j >= 100000000) {
                a(n[(int) ((j % 1000000000) / 100000000)]);
            }
            if (j >= 10000000) {
                a(n[(int) ((j % 100000000) / 10000000)]);
            }
            if (j >= 1000000) {
                a(n[(int) ((j % 10000000) / 1000000)]);
            }
            if (j >= 100000) {
                a(n[(int) ((j % 1000000) / 100000)]);
            }
            a(n[(int) ((j % 100000) / 10000)]);
        }
        if (j >= 1000) {
            a(n[(int) ((j % 10000) / 1000)]);
        }
        if (j >= 100) {
            a(n[(int) ((j % 1000) / 100)]);
        }
        if (j >= 10) {
            a(n[(int) ((j % 100) / 10)]);
        }
        a(n[(int) (j % 10)]);
        return this;
    }

    public com.badlogic.gdx.utils.StringBuilder append(com.badlogic.gdx.utils.StringBuilder stringBuilder) {
        if (stringBuilder == null) {
            f();
        } else {
            e(stringBuilder.chars, 0, stringBuilder.length);
        }
        return this;
    }

    public com.badlogic.gdx.utils.StringBuilder append(com.badlogic.gdx.utils.StringBuilder stringBuilder, int i, int i2) {
        if (stringBuilder == null) {
            f();
        } else {
            e(stringBuilder.chars, i, i2);
        }
        return this;
    }

    @Override // java.lang.Appendable
    public com.badlogic.gdx.utils.StringBuilder append(java.lang.CharSequence charSequence) {
        if (charSequence == null) {
            f();
        } else if (charSequence instanceof com.badlogic.gdx.utils.StringBuilder) {
            com.badlogic.gdx.utils.StringBuilder stringBuilder = (com.badlogic.gdx.utils.StringBuilder) charSequence;
            e(stringBuilder.chars, 0, stringBuilder.length);
        } else {
            c(charSequence.toString());
        }
        return this;
    }

    @Override // java.lang.Appendable
    public com.badlogic.gdx.utils.StringBuilder append(java.lang.CharSequence charSequence, int i, int i2) {
        b(charSequence, i, i2);
        return this;
    }

    public com.badlogic.gdx.utils.StringBuilder append(java.lang.Object obj) {
        if (obj == null) {
            f();
        } else {
            c(obj.toString());
        }
        return this;
    }

    public com.badlogic.gdx.utils.StringBuilder append(java.lang.String str) {
        c(str);
        return this;
    }

    public com.badlogic.gdx.utils.StringBuilder append(boolean z) {
        c(z ? com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE : com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        return this;
    }

    public com.badlogic.gdx.utils.StringBuilder append(char[] cArr) {
        d(cArr);
        return this;
    }

    public com.badlogic.gdx.utils.StringBuilder append(char[] cArr, int i, int i2) {
        e(cArr, i, i2);
        return this;
    }

    public com.badlogic.gdx.utils.StringBuilder appendCodePoint(int i) {
        d(java.lang.Character.toChars(i));
        return this;
    }

    public final void b(java.lang.CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            charSequence = com.igexin.push.core.b.m;
        }
        if (i < 0 || i2 < 0 || i > i2 || i2 > charSequence.length()) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        c(charSequence.subSequence(i, i2).toString());
    }

    public final void c(java.lang.String str) {
        if (str == null) {
            f();
            return;
        }
        int length = str.length();
        int i = this.length + length;
        if (i > this.chars.length) {
            i(i);
        }
        str.getChars(0, length, this.chars, this.length);
        this.length = i;
    }

    public int capacity() {
        return this.chars.length;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        if (i < 0 || i >= this.length) {
            throw new java.lang.StringIndexOutOfBoundsException(i);
        }
        return this.chars[i];
    }

    public int codePointAt(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this.length)) {
            throw new java.lang.StringIndexOutOfBoundsException(i);
        }
        return java.lang.Character.codePointAt(this.chars, i, i2);
    }

    public int codePointBefore(int i) {
        if (i < 1 || i > this.length) {
            throw new java.lang.StringIndexOutOfBoundsException(i);
        }
        return java.lang.Character.codePointBefore(this.chars, i);
    }

    public int codePointCount(int i, int i2) {
        if (i < 0 || i2 > this.length || i > i2) {
            throw new java.lang.StringIndexOutOfBoundsException();
        }
        return java.lang.Character.codePointCount(this.chars, i, i2 - i);
    }

    public final void d(char[] cArr) {
        int length = this.length + cArr.length;
        if (length > this.chars.length) {
            i(length);
        }
        java.lang.System.arraycopy(cArr, 0, this.chars, this.length, cArr.length);
        this.length = length;
    }

    public com.badlogic.gdx.utils.StringBuilder delete(int i, int i2) {
        g(i, i2);
        return this;
    }

    public com.badlogic.gdx.utils.StringBuilder deleteCharAt(int i) {
        h(i);
        return this;
    }

    public final void e(char[] cArr, int i, int i2) {
        if (i > cArr.length || i < 0) {
            throw new java.lang.ArrayIndexOutOfBoundsException("Offset out of bounds: " + i);
        }
        if (i2 < 0 || cArr.length - i < i2) {
            throw new java.lang.ArrayIndexOutOfBoundsException("Length out of bounds: " + i2);
        }
        int i3 = this.length + i2;
        if (i3 > this.chars.length) {
            i(i3);
        }
        java.lang.System.arraycopy(cArr, i, this.chars, this.length, i2);
        this.length = i3;
    }

    public void ensureCapacity(int i) {
        char[] cArr = this.chars;
        if (i > cArr.length) {
            int length = (cArr.length << 1) + 2;
            if (length > i) {
                i = length;
            }
            i(i);
        }
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.badlogic.gdx.utils.StringBuilder stringBuilder = (com.badlogic.gdx.utils.StringBuilder) obj;
        int i = this.length;
        if (i != stringBuilder.length) {
            return false;
        }
        char[] cArr = this.chars;
        char[] cArr2 = stringBuilder.chars;
        if (cArr == cArr2) {
            return true;
        }
        if (cArr == null || cArr2 == null) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (cArr[i2] != cArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public final void f() {
        int i = this.length + 4;
        if (i > this.chars.length) {
            i(i);
        }
        char[] cArr = this.chars;
        int i2 = this.length;
        int i3 = i2 + 1;
        cArr[i2] = 'n';
        int i4 = i3 + 1;
        cArr[i3] = 'u';
        int i5 = i4 + 1;
        cArr[i4] = com.aliyun.svideo.editor.guide.customView.MultiLamp.LEFT;
        this.length = i5 + 1;
        cArr[i5] = com.aliyun.svideo.editor.guide.customView.MultiLamp.LEFT;
    }

    public final void g(int i, int i2) {
        if (i >= 0) {
            int i3 = this.length;
            if (i2 > i3) {
                i2 = i3;
            }
            if (i2 == i) {
                return;
            }
            if (i2 > i) {
                int i4 = i3 - i2;
                if (i4 >= 0) {
                    char[] cArr = this.chars;
                    java.lang.System.arraycopy(cArr, i2, cArr, i, i4);
                }
                this.length -= i2 - i;
                return;
            }
        }
        throw new java.lang.StringIndexOutOfBoundsException();
    }

    public void getChars(int i, int i2, char[] cArr, int i3) {
        int i4 = this.length;
        if (i > i4 || i2 > i4 || i > i2) {
            throw new java.lang.StringIndexOutOfBoundsException();
        }
        java.lang.System.arraycopy(this.chars, i, cArr, i3, i2 - i);
    }

    public final void h(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this.length)) {
            throw new java.lang.StringIndexOutOfBoundsException(i);
        }
        int i3 = (i2 - i) - 1;
        if (i3 > 0) {
            char[] cArr = this.chars;
            java.lang.System.arraycopy(cArr, i + 1, cArr, i, i3);
        }
        this.length--;
    }

    public int hashCode() {
        return ((this.length + 31) * 31) + java.util.Arrays.hashCode(this.chars);
    }

    public final void i(int i) {
        char[] cArr = this.chars;
        int length = (cArr.length >> 1) + cArr.length + 2;
        if (i <= length) {
            i = length;
        }
        char[] cArr2 = new char[i];
        java.lang.System.arraycopy(cArr, 0, cArr2, 0, this.length);
        this.chars = cArr2;
    }

    public int indexOf(java.lang.String str) {
        return indexOf(str, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0042, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int indexOf(java.lang.String str, int i) {
        boolean z;
        if (i < 0) {
            i = 0;
        }
        int length = str.length();
        if (length <= 0) {
            int i2 = this.length;
            return (i < i2 || i == 0) ? i : i2;
        }
        if (length + i > this.length) {
            return -1;
        }
        char charAt = str.charAt(0);
        while (true) {
            int i3 = this.length;
            if (i >= i3) {
                z = false;
            } else if (this.chars[i] == charAt) {
                z = true;
            } else {
                continue;
                i++;
            }
            if (!z || length + i > i3) {
                break;
            }
            int i4 = i;
            int i5 = 0;
            do {
                i5++;
                if (i5 >= length) {
                    break;
                }
                i4++;
            } while (this.chars[i4] == str.charAt(i5));
            if (i5 == length) {
                return i;
            }
            i++;
        }
    }

    public com.badlogic.gdx.utils.StringBuilder insert(int i, char c) {
        j(i, c);
        return this;
    }

    public com.badlogic.gdx.utils.StringBuilder insert(int i, double d) {
        l(i, java.lang.Double.toString(d));
        return this;
    }

    public com.badlogic.gdx.utils.StringBuilder insert(int i, float f) {
        l(i, java.lang.Float.toString(f));
        return this;
    }

    public com.badlogic.gdx.utils.StringBuilder insert(int i, int i2) {
        l(i, java.lang.Integer.toString(i2));
        return this;
    }

    public com.badlogic.gdx.utils.StringBuilder insert(int i, long j) {
        l(i, java.lang.Long.toString(j));
        return this;
    }

    public com.badlogic.gdx.utils.StringBuilder insert(int i, java.lang.CharSequence charSequence) {
        l(i, charSequence == null ? com.igexin.push.core.b.m : charSequence.toString());
        return this;
    }

    public com.badlogic.gdx.utils.StringBuilder insert(int i, java.lang.CharSequence charSequence, int i2, int i3) {
        k(i, charSequence, i2, i3);
        return this;
    }

    public com.badlogic.gdx.utils.StringBuilder insert(int i, java.lang.Object obj) {
        l(i, obj == null ? com.igexin.push.core.b.m : obj.toString());
        return this;
    }

    public com.badlogic.gdx.utils.StringBuilder insert(int i, java.lang.String str) {
        l(i, str);
        return this;
    }

    public com.badlogic.gdx.utils.StringBuilder insert(int i, boolean z) {
        l(i, z ? com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE : com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        return this;
    }

    public com.badlogic.gdx.utils.StringBuilder insert(int i, char[] cArr) {
        m(i, cArr);
        return this;
    }

    public com.badlogic.gdx.utils.StringBuilder insert(int i, char[] cArr, int i2, int i3) {
        n(i, cArr, i2, i3);
        return this;
    }

    public final void j(int i, char c) {
        if (i < 0 || i > this.length) {
            throw new java.lang.ArrayIndexOutOfBoundsException(i);
        }
        o(1, i);
        this.chars[i] = c;
        this.length++;
    }

    public final void k(int i, java.lang.CharSequence charSequence, int i2, int i3) {
        if (charSequence == null) {
            charSequence = com.igexin.push.core.b.m;
        }
        if (i < 0 || i > this.length || i2 < 0 || i3 < 0 || i2 > i3 || i3 > charSequence.length()) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        l(i, charSequence.subSequence(i2, i3).toString());
    }

    public final void l(int i, java.lang.String str) {
        if (i < 0 || i > this.length) {
            throw new java.lang.StringIndexOutOfBoundsException(i);
        }
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        int length = str.length();
        if (length != 0) {
            o(length, i);
            str.getChars(0, length, this.chars, i);
            this.length += length;
        }
    }

    public int lastIndexOf(java.lang.String str) {
        return lastIndexOf(str, this.length);
    }

    public int lastIndexOf(java.lang.String str, int i) {
        boolean z;
        int length = str.length();
        int i2 = this.length;
        if (length > i2 || i < 0) {
            return -1;
        }
        if (length <= 0) {
            return i < i2 ? i : i2;
        }
        if (i > i2 - length) {
            i = i2 - length;
        }
        char charAt = str.charAt(0);
        while (true) {
            if (i < 0) {
                z = false;
            } else if (this.chars[i] == charAt) {
                z = true;
            } else {
                i--;
            }
            if (!z) {
                return -1;
            }
            int i3 = i;
            int i4 = 0;
            do {
                i4++;
                if (i4 >= length) {
                    break;
                }
                i3++;
            } while (this.chars[i3] == str.charAt(i4));
            if (i4 == length) {
                return i;
            }
            i--;
        }
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.length;
    }

    public final void m(int i, char[] cArr) {
        if (i < 0 || i > this.length) {
            throw new java.lang.StringIndexOutOfBoundsException(i);
        }
        if (cArr.length != 0) {
            o(cArr.length, i);
            java.lang.System.arraycopy(cArr, 0, cArr, i, cArr.length);
            this.length += cArr.length;
        }
    }

    public final void n(int i, char[] cArr, int i2, int i3) {
        if (i < 0 || i > i3) {
            throw new java.lang.StringIndexOutOfBoundsException(i);
        }
        if (i2 >= 0 && i3 >= 0 && i3 <= cArr.length - i2) {
            if (i3 != 0) {
                o(i3, i);
                java.lang.System.arraycopy(cArr, i2, this.chars, i, i3);
                this.length += i3;
                return;
            }
            return;
        }
        throw new java.lang.StringIndexOutOfBoundsException("offset " + i2 + ", length " + i3 + ", char[].length " + cArr.length);
    }

    public final void o(int i, int i2) {
        char[] cArr = this.chars;
        int length = cArr.length;
        int i3 = this.length;
        if (length - i3 >= i) {
            java.lang.System.arraycopy(cArr, i2, cArr, i + i2, i3 - i2);
            return;
        }
        int i4 = i3 + i;
        int length2 = (cArr.length << 1) + 2;
        if (i4 <= length2) {
            i4 = length2;
        }
        char[] cArr2 = new char[i4];
        java.lang.System.arraycopy(cArr, 0, cArr2, 0, i2);
        java.lang.System.arraycopy(this.chars, i2, cArr2, i + i2, this.length - i2);
        this.chars = cArr2;
    }

    public int offsetByCodePoints(int i, int i2) {
        return java.lang.Character.offsetByCodePoints(this.chars, 0, this.length, i, i2);
    }

    public final void p(int i, int i2, java.lang.String str) {
        if (i >= 0) {
            int i3 = this.length;
            if (i2 > i3) {
                i2 = i3;
            }
            if (i2 > i) {
                int length = str.length();
                int i4 = (i2 - i) - length;
                if (i4 > 0) {
                    char[] cArr = this.chars;
                    java.lang.System.arraycopy(cArr, i2, cArr, i + length, this.length - i2);
                } else if (i4 < 0) {
                    o(-i4, i2);
                }
                str.getChars(0, length, this.chars, i);
                this.length -= i4;
                return;
            }
            if (i == i2) {
                str.getClass();
                l(i, str);
                return;
            }
        }
        throw new java.lang.StringIndexOutOfBoundsException();
    }

    public final void q() {
        int i;
        int i2 = this.length;
        if (i2 < 2) {
            return;
        }
        int i3 = i2 - 1;
        char[] cArr = this.chars;
        char c = cArr[0];
        char c2 = cArr[i3];
        int i4 = i2 / 2;
        int i5 = 0;
        boolean z = true;
        boolean z2 = true;
        while (i5 < i4) {
            char[] cArr2 = this.chars;
            int i6 = i5 + 1;
            char c3 = cArr2[i6];
            int i7 = i3 - 1;
            char c4 = cArr2[i7];
            boolean z3 = z && c3 >= 56320 && c3 <= 57343 && c >= 55296 && c <= 56319;
            if (z3 && this.length < 3) {
                return;
            }
            if (z3 == (z2 && c4 >= 55296 && c4 <= 56319 && c2 >= 56320 && c2 <= 57343)) {
                if (z3) {
                    cArr2[i3] = c3;
                    cArr2[i7] = c;
                    cArr2[i5] = c4;
                    cArr2[i6] = c2;
                    char c5 = cArr2[i5 + 2];
                    c2 = cArr2[i3 - 2];
                    i3--;
                    c = c5;
                    i5 = i6;
                } else {
                    cArr2[i3] = c;
                    cArr2[i5] = c2;
                    c = c3;
                    c2 = c4;
                }
                i = 1;
                z = true;
            } else if (z3) {
                cArr2[i3] = c3;
                cArr2[i5] = c2;
                c2 = c4;
                i = 1;
                z = false;
            } else {
                cArr2[i3] = c;
                cArr2[i5] = c4;
                c = c3;
                i = 1;
                z = true;
                z2 = false;
                i5 += i;
                i3--;
            }
            z2 = true;
            i5 += i;
            i3--;
        }
        if ((this.length & 1) == 1) {
            if (z && z2) {
                return;
            }
            char[] cArr3 = this.chars;
            if (!z) {
                c2 = c;
            }
            cArr3[i3] = c2;
        }
    }

    public com.badlogic.gdx.utils.StringBuilder replace(char c, java.lang.String str) {
        int length = str.length();
        int i = 0;
        while (i != this.length) {
            if (this.chars[i] == c) {
                p(i, i + 1, str);
                i += length;
            } else {
                i++;
            }
        }
        return this;
    }

    public com.badlogic.gdx.utils.StringBuilder replace(int i, int i2, java.lang.String str) {
        p(i, i2, str);
        return this;
    }

    public com.badlogic.gdx.utils.StringBuilder replace(java.lang.String str, java.lang.String str2) {
        int length = str.length();
        int length2 = str2.length();
        int i = 0;
        while (true) {
            int indexOf = indexOf(str, i);
            if (indexOf == -1) {
                return this;
            }
            p(indexOf, indexOf + length, str2);
            i = indexOf + length2;
        }
    }

    public com.badlogic.gdx.utils.StringBuilder reverse() {
        q();
        return this;
    }

    public void setCharAt(int i, char c) {
        if (i < 0 || i >= this.length) {
            throw new java.lang.StringIndexOutOfBoundsException(i);
        }
        this.chars[i] = c;
    }

    public void setLength(int i) {
        if (i < 0) {
            throw new java.lang.StringIndexOutOfBoundsException(i);
        }
        char[] cArr = this.chars;
        if (i > cArr.length) {
            i(i);
        } else {
            int i2 = this.length;
            if (i2 < i) {
                java.util.Arrays.fill(cArr, i2, i, (char) 0);
            }
        }
        this.length = i;
    }

    @Override // java.lang.CharSequence
    public java.lang.CharSequence subSequence(int i, int i2) {
        return substring(i, i2);
    }

    public java.lang.String substring(int i) {
        int i2;
        if (i < 0 || i > (i2 = this.length)) {
            throw new java.lang.StringIndexOutOfBoundsException(i);
        }
        return i == i2 ? "" : new java.lang.String(this.chars, i, i2 - i);
    }

    public java.lang.String substring(int i, int i2) {
        if (i < 0 || i > i2 || i2 > this.length) {
            throw new java.lang.StringIndexOutOfBoundsException();
        }
        return i == i2 ? "" : new java.lang.String(this.chars, i, i2 - i);
    }

    @Override // java.lang.CharSequence
    public java.lang.String toString() {
        int i = this.length;
        return i == 0 ? "" : new java.lang.String(this.chars, 0, i);
    }

    public void trimToSize() {
        int i = this.length;
        char[] cArr = this.chars;
        if (i < cArr.length) {
            char[] cArr2 = new char[i];
            java.lang.System.arraycopy(cArr, 0, cArr2, 0, i);
            this.chars = cArr2;
        }
    }
}
