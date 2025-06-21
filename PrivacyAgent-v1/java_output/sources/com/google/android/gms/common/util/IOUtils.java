package com.google.android.gms.common.util;

@com.google.android.gms.common.internal.ShowFirstParty
@com.google.android.gms.common.annotation.KeepForSdk
@java.lang.Deprecated
/* loaded from: classes22.dex */
public final class IOUtils {
    @java.lang.Deprecated
    public static long a(java.io.InputStream inputStream, java.io.OutputStream outputStream, boolean z) throws java.io.IOException {
        return copyStream(inputStream, outputStream, z, 1024);
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public static void closeQuietly(@javax.annotation.Nullable android.os.ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public static void closeQuietly(@javax.annotation.Nullable java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    public static long copyStream(@androidx.annotation.RecentlyNonNull java.io.InputStream inputStream, @androidx.annotation.RecentlyNonNull java.io.OutputStream outputStream) throws java.io.IOException {
        return a(inputStream, outputStream, false);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    public static long copyStream(@androidx.annotation.RecentlyNonNull java.io.InputStream inputStream, @androidx.annotation.RecentlyNonNull java.io.OutputStream outputStream, @androidx.annotation.RecentlyNonNull boolean z, @androidx.annotation.RecentlyNonNull int i) throws java.io.IOException {
        byte[] bArr = new byte[i];
        long j = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, i);
                if (read == -1) {
                    break;
                }
                j += read;
                outputStream.write(bArr, 0, read);
            } finally {
                if (z) {
                    closeQuietly(inputStream);
                    closeQuietly(outputStream);
                }
            }
        }
        return j;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static boolean isGzipByteBuffer(@androidx.annotation.RecentlyNonNull byte[] bArr) {
        if (bArr.length > 1) {
            if ((((bArr[1] & 255) << 8) | (bArr[0] & 255)) == 35615) {
                return true;
            }
        }
        return false;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    public static byte[] readInputStreamFully(@androidx.annotation.RecentlyNonNull java.io.InputStream inputStream) throws java.io.IOException {
        return readInputStreamFully(inputStream, true);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    public static byte[] readInputStreamFully(@androidx.annotation.RecentlyNonNull java.io.InputStream inputStream, @androidx.annotation.RecentlyNonNull boolean z) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        a(inputStream, byteArrayOutputStream, z);
        return byteArrayOutputStream.toByteArray();
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    public static byte[] toByteArray(@androidx.annotation.RecentlyNonNull java.io.InputStream inputStream) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        com.google.android.gms.common.internal.Preconditions.checkNotNull(inputStream);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(byteArrayOutputStream);
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }
}
