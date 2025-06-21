package com.aliyun.svideo.downloader.zipprocessor;

/* loaded from: classes.dex */
public abstract class ZipStreamExtractor {
    private final java.util.zip.ZipInputStream _Input;

    public ZipStreamExtractor(java.io.InputStream inputStream) {
        this._Input = new java.util.zip.ZipInputStream(inputStream);
    }

    public static long copy(java.io.InputStream inputStream, java.io.OutputStream outputStream) throws java.io.IOException {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += read;
        }
    }

    public void close() throws java.io.IOException {
        this._Input.close();
    }

    public boolean extractNext() throws java.io.IOException {
        java.util.zip.ZipEntry nextEntry = this._Input.getNextEntry();
        if (nextEntry == null) {
            return false;
        }
        if (nextEntry.isDirectory()) {
            this._Input.closeEntry();
            return true;
        }
        java.io.File outputFile = getOutputFile(nextEntry);
        if (outputFile == null) {
            return true;
        }
        java.io.File parentFile = outputFile.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(outputFile);
        try {
            copy(this._Input, fileOutputStream);
            return true;
        } finally {
            fileOutputStream.close();
        }
    }

    public abstract java.io.File getOutputFile(java.util.zip.ZipEntry zipEntry);
}
