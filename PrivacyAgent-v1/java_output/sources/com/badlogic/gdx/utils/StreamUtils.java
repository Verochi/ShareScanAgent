package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public final class StreamUtils {
    public static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final byte[] EMPTY_BYTES = new byte[0];

    public static class OptimizedByteArrayOutputStream extends java.io.ByteArrayOutputStream {
        public OptimizedByteArrayOutputStream(int i) {
            super(i);
        }

        public byte[] getBuffer() {
            return ((java.io.ByteArrayOutputStream) this).buf;
        }

        @Override // java.io.ByteArrayOutputStream
        public synchronized byte[] toByteArray() {
            int i = ((java.io.ByteArrayOutputStream) this).count;
            byte[] bArr = ((java.io.ByteArrayOutputStream) this).buf;
            if (i == bArr.length) {
                return bArr;
            }
            return super.toByteArray();
        }
    }

    public static void closeQuietly(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static int copyStream(java.io.InputStream inputStream, java.nio.ByteBuffer byteBuffer, byte[] bArr) throws java.io.IOException {
        int position = byteBuffer.position();
        int i = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                byteBuffer.position(position);
                return i;
            }
            com.badlogic.gdx.utils.BufferUtils.copy(bArr, 0, (java.nio.Buffer) byteBuffer, read);
            i += read;
            byteBuffer.position(position + i);
        }
    }

    public static void copyStream(java.io.InputStream inputStream, java.io.OutputStream outputStream) throws java.io.IOException {
        copyStream(inputStream, outputStream, new byte[4096]);
    }

    public static void copyStream(java.io.InputStream inputStream, java.io.OutputStream outputStream, int i) throws java.io.IOException {
        copyStream(inputStream, outputStream, new byte[i]);
    }

    public static void copyStream(java.io.InputStream inputStream, java.io.OutputStream outputStream, byte[] bArr) throws java.io.IOException {
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }

    public static void copyStream(java.io.InputStream inputStream, java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
        copyStream(inputStream, byteBuffer, new byte[4096]);
    }

    public static void copyStream(java.io.InputStream inputStream, java.nio.ByteBuffer byteBuffer, int i) throws java.io.IOException {
        copyStream(inputStream, byteBuffer, new byte[i]);
    }

    public static byte[] copyStreamToByteArray(java.io.InputStream inputStream) throws java.io.IOException {
        return copyStreamToByteArray(inputStream, inputStream.available());
    }

    public static byte[] copyStreamToByteArray(java.io.InputStream inputStream, int i) throws java.io.IOException {
        com.badlogic.gdx.utils.StreamUtils.OptimizedByteArrayOutputStream optimizedByteArrayOutputStream = new com.badlogic.gdx.utils.StreamUtils.OptimizedByteArrayOutputStream(java.lang.Math.max(0, i));
        copyStream(inputStream, optimizedByteArrayOutputStream);
        return optimizedByteArrayOutputStream.toByteArray();
    }

    public static java.lang.String copyStreamToString(java.io.InputStream inputStream) throws java.io.IOException {
        return copyStreamToString(inputStream, inputStream.available(), null);
    }

    public static java.lang.String copyStreamToString(java.io.InputStream inputStream, int i) throws java.io.IOException {
        return copyStreamToString(inputStream, i, null);
    }

    public static java.lang.String copyStreamToString(java.io.InputStream inputStream, int i, java.lang.String str) throws java.io.IOException {
        java.io.InputStreamReader inputStreamReader = str == null ? new java.io.InputStreamReader(inputStream) : new java.io.InputStreamReader(inputStream, str);
        java.io.StringWriter stringWriter = new java.io.StringWriter(java.lang.Math.max(0, i));
        char[] cArr = new char[4096];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read == -1) {
                return stringWriter.toString();
            }
            stringWriter.write(cArr, 0, read);
        }
    }
}
