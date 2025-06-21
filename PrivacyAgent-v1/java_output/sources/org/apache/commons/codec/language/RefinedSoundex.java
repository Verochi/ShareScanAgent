package org.apache.commons.codec.language;

/* loaded from: classes24.dex */
public class RefinedSoundex implements org.apache.commons.codec.StringEncoder {
    public final char[] a;
    public static final java.lang.String US_ENGLISH_MAPPING_STRING = "01360240043788015936020505";
    public static final char[] b = US_ENGLISH_MAPPING_STRING.toCharArray();
    public static final org.apache.commons.codec.language.RefinedSoundex US_ENGLISH = new org.apache.commons.codec.language.RefinedSoundex();

    public RefinedSoundex() {
        this.a = b;
    }

    public RefinedSoundex(java.lang.String str) {
        this.a = str.toCharArray();
    }

    public RefinedSoundex(char[] cArr) {
        char[] cArr2 = new char[cArr.length];
        this.a = cArr2;
        java.lang.System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
    }

    public char a(char c) {
        if (java.lang.Character.isLetter(c)) {
            return this.a[java.lang.Character.toUpperCase(c) - 'A'];
        }
        return (char) 0;
    }

    public int difference(java.lang.String str, java.lang.String str2) throws org.apache.commons.codec.EncoderException {
        return org.apache.commons.codec.language.SoundexUtils.b(this, str, str2);
    }

    @Override // org.apache.commons.codec.Encoder
    public java.lang.Object encode(java.lang.Object obj) throws org.apache.commons.codec.EncoderException {
        if (obj instanceof java.lang.String) {
            return soundex((java.lang.String) obj);
        }
        throw new org.apache.commons.codec.EncoderException("Parameter supplied to RefinedSoundex encode is not of type java.lang.String");
    }

    @Override // org.apache.commons.codec.StringEncoder
    public java.lang.String encode(java.lang.String str) {
        return soundex(str);
    }

    public java.lang.String soundex(java.lang.String str) {
        if (str == null) {
            return null;
        }
        java.lang.String a = org.apache.commons.codec.language.SoundexUtils.a(str);
        if (a.length() == 0) {
            return a;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(a.charAt(0));
        char c = '*';
        for (int i = 0; i < a.length(); i++) {
            char a2 = a(a.charAt(i));
            if (a2 != c) {
                if (a2 != 0) {
                    stringBuffer.append(a2);
                }
                c = a2;
            }
        }
        return stringBuffer.toString();
    }
}
