package com.google.protobuf;

/* loaded from: classes22.dex */
public class Internal {

    public interface EnumLite {
        int getNumber();
    }

    public interface EnumLiteMap<T extends com.google.protobuf.Internal.EnumLite> {
        T findValueByNumber(int i);
    }

    public static com.google.protobuf.ByteString bytesDefaultValue(java.lang.String str) {
        try {
            return com.google.protobuf.ByteString.copyFrom(str.getBytes("ISO-8859-1"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new java.lang.IllegalStateException("Java VM does not support a standard character set.", e);
        }
    }

    public static boolean isValidUtf8(com.google.protobuf.ByteString byteString) {
        int size = byteString.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int byteAt = byteString.byteAt(i) & 255;
            if (byteAt >= 128) {
                if (byteAt < 194 || byteAt > 244 || i2 >= size) {
                    return false;
                }
                int i3 = i2 + 1;
                int byteAt2 = byteString.byteAt(i2) & 255;
                if (byteAt2 >= 128 && byteAt2 <= 191) {
                    if (byteAt > 223) {
                        if (i3 >= size) {
                            return false;
                        }
                        int i4 = i3 + 1;
                        int byteAt3 = byteString.byteAt(i3) & 255;
                        if (byteAt3 >= 128 && byteAt3 <= 191) {
                            if (byteAt <= 239) {
                                if ((byteAt == 224 && byteAt2 < 160) || (byteAt == 237 && byteAt2 > 159)) {
                                    return false;
                                }
                                i = i4;
                            } else {
                                if (i4 >= size) {
                                    return false;
                                }
                                i3 = i4 + 1;
                                int byteAt4 = byteString.byteAt(i4) & 255;
                                if (byteAt4 >= 128) {
                                    if (byteAt4 <= 191) {
                                        if (byteAt == 240) {
                                            if (byteAt2 < 144) {
                                            }
                                        }
                                        if (byteAt == 244 && byteAt2 > 143) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                    i = i3;
                }
                return false;
            }
            i = i2;
        }
        return true;
    }

    public static java.lang.String stringDefaultValue(java.lang.String str) {
        try {
            return new java.lang.String(str.getBytes("ISO-8859-1"), "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            throw new java.lang.IllegalStateException("Java VM does not support a standard character set.", e);
        }
    }
}
