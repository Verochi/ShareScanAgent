package org.apache.commons.codec.language;

/* loaded from: classes24.dex */
public class ColognePhonetic implements org.apache.commons.codec.StringEncoder {
    public static final char[][] a = {new char[]{196, 'A'}, new char[]{220, 'U'}, new char[]{214, 'O'}, new char[]{223, 'S'}};

    public abstract class CologneBuffer {
        public final char[] a;
        public int b;

        public CologneBuffer(int i) {
            this.b = 0;
            this.a = new char[i];
            this.b = 0;
        }

        public CologneBuffer(char[] cArr) {
            this.b = 0;
            this.a = cArr;
            this.b = cArr.length;
        }

        public abstract char[] a(int i, int i2);

        public int b() {
            return this.b;
        }

        public java.lang.String toString() {
            return new java.lang.String(a(0, this.b));
        }
    }

    public class CologneInputBuffer extends org.apache.commons.codec.language.ColognePhonetic.CologneBuffer {
        public CologneInputBuffer(char[] cArr) {
            super(cArr);
        }

        @Override // org.apache.commons.codec.language.ColognePhonetic.CologneBuffer
        public char[] a(int i, int i2) {
            char[] cArr = new char[i2];
            char[] cArr2 = this.a;
            java.lang.System.arraycopy(cArr2, (cArr2.length - this.b) + i, cArr, 0, i2);
            return cArr;
        }

        public void c(char c) {
            this.b++;
            this.a[e()] = c;
        }

        public char d() {
            return this.a[e()];
        }

        public int e() {
            return this.a.length - this.b;
        }

        public char f() {
            this.b--;
            return d();
        }
    }

    public class CologneOutputBuffer extends org.apache.commons.codec.language.ColognePhonetic.CologneBuffer {
        public CologneOutputBuffer(int i) {
            super(i);
        }

        @Override // org.apache.commons.codec.language.ColognePhonetic.CologneBuffer
        public char[] a(int i, int i2) {
            char[] cArr = new char[i2];
            java.lang.System.arraycopy(this.a, i, cArr, 0, i2);
            return cArr;
        }

        public void c(char c) {
            char[] cArr = this.a;
            int i = this.b;
            cArr[i] = c;
            this.b = i + 1;
        }
    }

    public static boolean a(char[] cArr, char c) {
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }

    public final java.lang.String b(java.lang.String str) {
        char[] charArray = str.toUpperCase(java.util.Locale.GERMAN).toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] > 'Z') {
                char[][] cArr = a;
                int length = cArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length) {
                        char[] cArr2 = cArr[i2];
                        if (charArray[i] == cArr2[0]) {
                            charArray[i] = cArr2[1];
                            break;
                        }
                        i2++;
                    }
                }
            }
        }
        return new java.lang.String(charArray);
    }

    public java.lang.String colognePhonetic(java.lang.String str) {
        char c;
        if (str == null) {
            return null;
        }
        java.lang.String b = b(str);
        org.apache.commons.codec.language.ColognePhonetic.CologneOutputBuffer cologneOutputBuffer = new org.apache.commons.codec.language.ColognePhonetic.CologneOutputBuffer(b.length() * 2);
        org.apache.commons.codec.language.ColognePhonetic.CologneInputBuffer cologneInputBuffer = new org.apache.commons.codec.language.ColognePhonetic.CologneInputBuffer(b.toCharArray());
        int b2 = cologneInputBuffer.b();
        char c2 = '/';
        char c3 = '-';
        while (b2 > 0) {
            char f = cologneInputBuffer.f();
            int b3 = cologneInputBuffer.b();
            char d = b3 > 0 ? cologneInputBuffer.d() : '-';
            if (a(new char[]{'A', 'E', 'I', 'J', 'O', 'U', 'Y'}, f)) {
                c = '0';
            } else if (f == 'H' || f < 'A' || f > 'Z') {
                if (c2 == '/') {
                    b2 = b3;
                } else {
                    c = '-';
                }
            } else if (f == 'B' || (f == 'P' && d != 'H')) {
                c = '1';
            } else if ((f == 'D' || f == 'T') && !a(new char[]{'S', 'C', 'Z'}, d)) {
                c = '2';
            } else if (a(new char[]{'W', 'F', 'P', 'V'}, f)) {
                c = '3';
            } else {
                if (!a(new char[]{'G', 'K', 'Q'}, f)) {
                    if (f != 'X' || a(new char[]{'C', 'K', 'Q'}, c3)) {
                        if (f != 'S' && f != 'Z') {
                            if (f == 'C') {
                                if (c2 != '/') {
                                }
                            } else if (!a(new char[]{'T', 'D', 'X'}, f)) {
                                c = f == 'R' ? '7' : f == 'L' ? '5' : (f == 'M' || f == 'N') ? '6' : f;
                            }
                        }
                        c = '8';
                    } else {
                        cologneInputBuffer.c('S');
                        b3++;
                    }
                }
                c = '4';
            }
            if (c != '-' && ((c2 != c && (c != '0' || c2 == '/')) || c < '0' || c > '8')) {
                cologneOutputBuffer.c(c);
            }
            c2 = c;
            c3 = f;
            b2 = b3;
        }
        return cologneOutputBuffer.toString();
    }

    @Override // org.apache.commons.codec.Encoder
    public java.lang.Object encode(java.lang.Object obj) throws org.apache.commons.codec.EncoderException {
        if (obj instanceof java.lang.String) {
            return encode((java.lang.String) obj);
        }
        throw new org.apache.commons.codec.EncoderException("This method's parameter was expected to be of the type " + java.lang.String.class.getName() + ". But actually it was of the type " + obj.getClass().getName() + ".");
    }

    @Override // org.apache.commons.codec.StringEncoder
    public java.lang.String encode(java.lang.String str) {
        return colognePhonetic(str);
    }

    public boolean isEncodeEqual(java.lang.String str, java.lang.String str2) {
        return colognePhonetic(str).equals(colognePhonetic(str2));
    }
}
