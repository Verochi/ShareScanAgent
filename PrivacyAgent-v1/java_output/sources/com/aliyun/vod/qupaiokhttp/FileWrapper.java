package com.aliyun.vod.qupaiokhttp;

/* loaded from: classes12.dex */
public class FileWrapper {
    public java.io.File file;
    public java.lang.String fileName;
    private long fileSize;
    public okhttp3.MediaType mediaType;

    public FileWrapper(java.io.File file, okhttp3.MediaType mediaType) {
        this.file = file;
        this.fileName = file.getName();
        this.mediaType = mediaType;
        this.fileSize = file.length();
    }

    public java.io.File getFile() {
        return this.file;
    }

    public java.lang.String getFileName() {
        java.lang.String str = this.fileName;
        return str != null ? str : "nofilename";
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public okhttp3.MediaType getMediaType() {
        return this.mediaType;
    }
}
