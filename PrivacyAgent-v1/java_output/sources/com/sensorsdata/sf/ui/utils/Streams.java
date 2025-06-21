package com.sensorsdata.sf.ui.utils;

/* loaded from: classes19.dex */
final class Streams {
    private Streams() {
    }

    public static int copy(java.io.InputStream inputStream, java.io.OutputStream outputStream) throws java.io.IOException {
        byte[] bArr = new byte[8192];
        int i = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return i;
            }
            i += read;
            outputStream.write(bArr, 0, read);
        }
    }

    public static java.lang.String readFully(java.io.Reader reader) throws java.io.IOException {
        try {
            java.io.StringWriter stringWriter = new java.io.StringWriter();
            char[] cArr = new char[1024];
            while (true) {
                int read = reader.read(cArr);
                if (read == -1) {
                    return stringWriter.toString();
                }
                stringWriter.write(cArr, 0, read);
            }
        } finally {
            com.sensorsdata.sf.ui.utils.IoUtils.closeQuietly(reader);
        }
    }
}
