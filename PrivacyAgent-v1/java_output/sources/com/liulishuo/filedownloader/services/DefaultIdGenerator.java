package com.liulishuo.filedownloader.services;

/* loaded from: classes23.dex */
public class DefaultIdGenerator implements com.liulishuo.filedownloader.util.FileDownloadHelper.IdGenerator {
    @Override // com.liulishuo.filedownloader.util.FileDownloadHelper.IdGenerator
    public int generateId(java.lang.String str, java.lang.String str2, boolean z) {
        return z ? com.liulishuo.filedownloader.util.FileDownloadUtils.md5(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("%sp%s@dir", str, str2)).hashCode() : com.liulishuo.filedownloader.util.FileDownloadUtils.md5(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("%sp%s", str, str2)).hashCode();
    }

    @Override // com.liulishuo.filedownloader.util.FileDownloadHelper.IdGenerator
    public int transOldId(int i, java.lang.String str, java.lang.String str2, boolean z) {
        return generateId(str, str2, z);
    }
}
