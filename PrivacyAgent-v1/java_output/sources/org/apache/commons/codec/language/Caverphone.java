package org.apache.commons.codec.language;

/* loaded from: classes24.dex */
public class Caverphone implements org.apache.commons.codec.StringEncoder {
    public final org.apache.commons.codec.language.Caverphone2 a = new org.apache.commons.codec.language.Caverphone2();

    public java.lang.String caverphone(java.lang.String str) {
        return this.a.encode(str);
    }

    @Override // org.apache.commons.codec.Encoder
    public java.lang.Object encode(java.lang.Object obj) throws org.apache.commons.codec.EncoderException {
        if (obj instanceof java.lang.String) {
            return caverphone((java.lang.String) obj);
        }
        throw new org.apache.commons.codec.EncoderException("Parameter supplied to Caverphone encode is not of type java.lang.String");
    }

    @Override // org.apache.commons.codec.StringEncoder
    public java.lang.String encode(java.lang.String str) {
        return caverphone(str);
    }

    public boolean isCaverphoneEqual(java.lang.String str, java.lang.String str2) {
        return caverphone(str).equals(caverphone(str2));
    }
}
