package org.apache.tools.zip;

/* loaded from: classes26.dex */
public interface ZipEncoding {
    boolean canEncode(java.lang.String str);

    java.lang.String decode(byte[] bArr) throws java.io.IOException;

    java.nio.ByteBuffer encode(java.lang.String str) throws java.io.IOException;
}
