package org.apache.commons.codec.net;

/* loaded from: classes24.dex */
abstract class RFC1522Codec {
    protected static final java.lang.String POSTFIX = "?=";
    protected static final java.lang.String PREFIX = "=?";
    protected static final char SEP = '?';

    public java.lang.String decodeText(java.lang.String str) throws org.apache.commons.codec.DecoderException, java.io.UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        if (!str.startsWith(PREFIX) || !str.endsWith(POSTFIX)) {
            throw new org.apache.commons.codec.DecoderException("RFC 1522 violation: malformed encoded content");
        }
        int length = str.length() - 2;
        int indexOf = str.indexOf(63, 2);
        if (indexOf == length) {
            throw new org.apache.commons.codec.DecoderException("RFC 1522 violation: charset token not found");
        }
        java.lang.String substring = str.substring(2, indexOf);
        if (substring.equals("")) {
            throw new org.apache.commons.codec.DecoderException("RFC 1522 violation: charset not specified");
        }
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(63, i);
        if (indexOf2 == length) {
            throw new org.apache.commons.codec.DecoderException("RFC 1522 violation: encoding token not found");
        }
        java.lang.String substring2 = str.substring(i, indexOf2);
        if (getEncoding().equalsIgnoreCase(substring2)) {
            int i2 = indexOf2 + 1;
            return new java.lang.String(doDecoding(org.apache.commons.codec.binary.StringUtils.getBytesUsAscii(str.substring(i2, str.indexOf(63, i2)))), substring);
        }
        throw new org.apache.commons.codec.DecoderException("This codec cannot decode " + substring2 + " encoded content");
    }

    public abstract byte[] doDecoding(byte[] bArr) throws org.apache.commons.codec.DecoderException;

    public abstract byte[] doEncoding(byte[] bArr) throws org.apache.commons.codec.EncoderException;

    public java.lang.String encodeText(java.lang.String str, java.lang.String str2) throws org.apache.commons.codec.EncoderException, java.io.UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(PREFIX);
        stringBuffer.append(str2);
        stringBuffer.append(SEP);
        stringBuffer.append(getEncoding());
        stringBuffer.append(SEP);
        stringBuffer.append(org.apache.commons.codec.binary.StringUtils.newStringUsAscii(doEncoding(str.getBytes(str2))));
        stringBuffer.append(POSTFIX);
        return stringBuffer.toString();
    }

    public abstract java.lang.String getEncoding();
}
