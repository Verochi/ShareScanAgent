package org.apache.commons.codec.language;

/* loaded from: classes24.dex */
public class Soundex implements org.apache.commons.codec.StringEncoder {
    public int a;
    public final char[] b;
    public static final java.lang.String US_ENGLISH_MAPPING_STRING = "01230120022455012623010202";
    public static final char[] c = US_ENGLISH_MAPPING_STRING.toCharArray();
    public static final org.apache.commons.codec.language.Soundex US_ENGLISH = new org.apache.commons.codec.language.Soundex();

    public Soundex() {
        this.a = 4;
        this.b = c;
    }

    public Soundex(java.lang.String str) {
        this.a = 4;
        this.b = str.toCharArray();
    }

    public Soundex(char[] cArr) {
        this.a = 4;
        char[] cArr2 = new char[cArr.length];
        this.b = cArr2;
        java.lang.System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
    }

    public final char a(java.lang.String str, int i) {
        char charAt;
        char c2 = c(str.charAt(i));
        if (i > 1 && c2 != '0' && ('H' == (charAt = str.charAt(i - 1)) || 'W' == charAt)) {
            char charAt2 = str.charAt(i - 2);
            if (c(charAt2) == c2 || 'H' == charAt2 || 'W' == charAt2) {
                return (char) 0;
            }
        }
        return c2;
    }

    public final char[] b() {
        return this.b;
    }

    public final char c(char c2) {
        int i = c2 - 'A';
        if (i >= 0 && i < b().length) {
            return b()[i];
        }
        throw new java.lang.IllegalArgumentException("The character is not mapped: " + c2);
    }

    public int difference(java.lang.String str, java.lang.String str2) throws org.apache.commons.codec.EncoderException {
        return org.apache.commons.codec.language.SoundexUtils.b(this, str, str2);
    }

    @Override // org.apache.commons.codec.Encoder
    public java.lang.Object encode(java.lang.Object obj) throws org.apache.commons.codec.EncoderException {
        if (obj instanceof java.lang.String) {
            return soundex((java.lang.String) obj);
        }
        throw new org.apache.commons.codec.EncoderException("Parameter supplied to Soundex encode is not of type java.lang.String");
    }

    @Override // org.apache.commons.codec.StringEncoder
    public java.lang.String encode(java.lang.String str) {
        return soundex(str);
    }

    public int getMaxLength() {
        return this.a;
    }

    public void setMaxLength(int i) {
        this.a = i;
    }

    public java.lang.String soundex(java.lang.String str) {
        if (str == null) {
            return null;
        }
        java.lang.String a = org.apache.commons.codec.language.SoundexUtils.a(str);
        if (a.length() == 0) {
            return a;
        }
        char[] cArr = {'0', '0', '0', '0'};
        cArr[0] = a.charAt(0);
        char a2 = a(a, 0);
        int i = 1;
        int i2 = 1;
        while (i < a.length() && i2 < 4) {
            int i3 = i + 1;
            char a3 = a(a, i);
            if (a3 != 0) {
                if (a3 != '0' && a3 != a2) {
                    cArr[i2] = a3;
                    i2++;
                }
                a2 = a3;
            }
            i = i3;
        }
        return new java.lang.String(cArr);
    }
}
