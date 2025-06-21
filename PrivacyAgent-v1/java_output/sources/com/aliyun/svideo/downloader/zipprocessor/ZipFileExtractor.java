package com.aliyun.svideo.downloader.zipprocessor;

/* loaded from: classes.dex */
public abstract class ZipFileExtractor {
    private final java.util.Enumeration<?> entries;
    private final org.apache.tools.zip.ZipFile zipFile;

    public ZipFileExtractor(java.io.File file) throws java.io.IOException {
        org.apache.tools.zip.ZipFile zipFile = new org.apache.tools.zip.ZipFile(file, "gbk");
        this.zipFile = zipFile;
        this.entries = zipFile.getEntries();
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
        org.apache.tools.zip.ZipFile zipFile = this.zipFile;
        if (zipFile != null) {
            zipFile.close();
        }
    }

    public boolean extractNext() throws java.io.IOException {
        org.apache.tools.zip.ZipEntry zipEntry;
        java.io.File outputFile;
        if (!this.entries.hasMoreElements() || (zipEntry = (org.apache.tools.zip.ZipEntry) this.entries.nextElement()) == null) {
            return false;
        }
        if (zipEntry.isDirectory() || (outputFile = getOutputFile(zipEntry)) == null) {
            return true;
        }
        java.io.File parentFile = outputFile.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        java.io.InputStream inputStream = this.zipFile.getInputStream(zipEntry);
        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(outputFile);
        try {
            copy(inputStream, fileOutputStream);
            return true;
        } finally {
            inputStream.close();
            fileOutputStream.close();
        }
    }

    public abstract java.io.File getOutputFile(org.apache.tools.zip.ZipEntry zipEntry);
}
