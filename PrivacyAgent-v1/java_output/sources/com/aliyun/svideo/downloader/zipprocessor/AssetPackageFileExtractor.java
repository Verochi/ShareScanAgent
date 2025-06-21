package com.aliyun.svideo.downloader.zipprocessor;

/* loaded from: classes.dex */
public final class AssetPackageFileExtractor extends com.aliyun.svideo.downloader.zipprocessor.ZipFileExtractor {
    private final java.io.File _OutputDir;

    public AssetPackageFileExtractor(java.io.File file, java.io.File file2) throws java.io.IOException {
        super(file);
        this._OutputDir = file2;
    }

    @Override // com.aliyun.svideo.downloader.zipprocessor.ZipFileExtractor
    public java.io.File getOutputFile(org.apache.tools.zip.ZipEntry zipEntry) {
        java.lang.String name = zipEntry.getName();
        int indexOf = name.indexOf(47);
        if (indexOf >= 0) {
            name = name.substring(indexOf + 1);
        }
        return new java.io.File(this._OutputDir, name);
    }
}
