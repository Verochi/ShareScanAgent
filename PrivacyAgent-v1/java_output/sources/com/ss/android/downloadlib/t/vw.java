package com.ss.android.downloadlib.t;

/* loaded from: classes19.dex */
public class vw implements com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler {

    /* renamed from: com.ss.android.downloadlib.t.vw$1, reason: invalid class name */
    public class AnonymousClass1 implements android.media.MediaScannerConnection.OnScanCompletedListener {
        final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadInfo vw;

        public AnonymousClass1(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            this.vw = downloadInfo;
        }

        @Override // android.media.MediaScannerConnection.OnScanCompletedListener
        public void onScanCompleted(java.lang.String str, android.net.Uri uri) {
            if (uri != null) {
                this.vw.safePutToDBJsonData(com.ss.android.socialbase.downloader.constants.DbJsonConstants.CONTENT_URI, uri.toString());
                com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadCache().updateDownloadInfo(this.vw);
            }
        }
    }

    private void vw(android.content.Context context, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        java.lang.String str = downloadInfo.getSavePath() + java.io.File.separator + downloadInfo.getName();
        android.database.Cursor query = context.getContentResolver().query(android.provider.MediaStore.Files.getContentUri("external"), new java.lang.String[]{"_id"}, "_data=? ", new java.lang.String[]{str}, null);
        if (query == null || !query.moveToFirst()) {
            android.media.MediaScannerConnection.scanFile(context, new java.lang.String[]{str}, new java.lang.String[]{"application/vnd.android.package-archive"}, new com.ss.android.downloadlib.t.vw.AnonymousClass1(downloadInfo));
        } else {
            downloadInfo.safePutToDBJsonData(com.ss.android.socialbase.downloader.constants.DbJsonConstants.CONTENT_URI, android.content.ContentUris.withAppendedId(android.provider.MediaStore.Files.getContentUri("external"), query.getInt(query.getColumnIndex("_id"))).toString());
        }
        com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(query);
    }

    private boolean vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(downloadInfo.getSavePath());
        java.lang.String str = java.io.File.separator;
        sb.append(str);
        sb.append(downloadInfo.getName());
        java.lang.String sb2 = sb.toString();
        java.io.File file = new java.io.File(sb2);
        java.lang.String vw = com.ss.android.socialbase.appdownloader.kz.vw.yl.vw(com.ss.android.downloadlib.addownload.z.getContext(), com.ss.android.socialbase.appdownloader.t.vw(downloadInfo, file), sb2);
        boolean z = false;
        if (!android.text.TextUtils.isEmpty(vw)) {
            java.lang.String str2 = vw + com.anythink.china.common.a.a.g;
            if (str2.equals(downloadInfo.getName())) {
                return true;
            }
            try {
                z = file.renameTo(new java.io.File(downloadInfo.getSavePath() + str + str2));
                if (z) {
                    downloadInfo.setName(str2);
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return z;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
    public void handle(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws com.ss.android.socialbase.downloader.exception.BaseException {
        if (downloadInfo == null || !vw(downloadInfo)) {
            return;
        }
        vw(com.ss.android.downloadlib.addownload.z.getContext(), downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
    public boolean needHandle(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            return com.ss.android.downloadlib.bt.yl.wg(com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()));
        }
        return false;
    }
}
