package com.efs.sdk.net.a.a;

/* loaded from: classes22.dex */
public final class i {
    public static void a(java.io.InputStream inputStream, java.io.OutputStream outputStream, byte[] bArr) {
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }
}
