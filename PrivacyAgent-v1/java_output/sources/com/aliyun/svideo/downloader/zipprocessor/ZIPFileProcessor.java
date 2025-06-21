package com.aliyun.svideo.downloader.zipprocessor;

/* loaded from: classes.dex */
public class ZIPFileProcessor implements com.aliyun.svideo.downloader.zipprocessor.FileProcessor {
    private final long id;
    private final java.io.File mPackageDir;

    public ZIPFileProcessor(java.io.File file, long j) {
        this.mPackageDir = file;
        this.id = j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0016, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0017, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.aliyun.svideo.downloader.zipprocessor.FileProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.io.File process(java.io.File file) {
        com.aliyun.svideo.downloader.zipprocessor.AssetPackageFileExtractor assetPackageFileExtractor;
        com.aliyun.svideo.downloader.zipprocessor.AssetPackageFileExtractor assetPackageFileExtractor2 = null;
        if (file == null) {
            return null;
        }
        try {
            assetPackageFileExtractor = new com.aliyun.svideo.downloader.zipprocessor.AssetPackageFileExtractor(file, this.mPackageDir);
            do {
                try {
                    try {
                    } catch (java.lang.Exception e) {
                        e = e;
                        e.printStackTrace();
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("AssetPackageFileExtractor error");
                        sb.append(e.getMessage());
                        file.delete();
                        com.aliyun.common.utils.FileUtils.deleteDirectory(this.mPackageDir);
                        if (assetPackageFileExtractor != null) {
                            try {
                                assetPackageFileExtractor.close();
                            } catch (java.io.IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        return null;
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    assetPackageFileExtractor2 = assetPackageFileExtractor;
                    if (assetPackageFileExtractor2 != null) {
                        try {
                            assetPackageFileExtractor2.close();
                        } catch (java.io.IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } while (assetPackageFileExtractor.extractNext());
            assetPackageFileExtractor.close();
            file.delete();
            return this.mPackageDir;
        } catch (java.lang.Exception e4) {
            e = e4;
            assetPackageFileExtractor = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (assetPackageFileExtractor2 != null) {
            }
            throw th;
        }
    }
}
