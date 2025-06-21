package org.apache.commons.codec.net;

/* loaded from: classes24.dex */
class Utils {
    public static int a(byte b) throws org.apache.commons.codec.DecoderException {
        int digit = java.lang.Character.digit((char) b, 16);
        if (digit != -1) {
            return digit;
        }
        throw new org.apache.commons.codec.DecoderException("Invalid URL encoding: not a valid digit (radix 16): " + ((int) b));
    }
}
