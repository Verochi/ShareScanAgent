package com.ss.android.socialbase.downloader.impls;

/* loaded from: classes19.dex */
public class DefaultIdGenerator implements com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator {
    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator
    public int generate(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return 0;
        }
        java.lang.String md5Hex = com.ss.android.socialbase.downloader.utils.DownloadUtils.md5Hex(java.lang.String.format("%s_%s", str, str2));
        if (android.text.TextUtils.isEmpty(md5Hex)) {
            return 0;
        }
        return md5Hex.hashCode();
    }
}
