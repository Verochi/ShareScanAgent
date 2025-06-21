package com.google.android.exoplayer2.offline;

/* loaded from: classes22.dex */
public final class ActionFileUpgradeUtil {

    public interface DownloadIdProvider {
        java.lang.String getId(com.google.android.exoplayer2.offline.DownloadRequest downloadRequest);
    }

    public static void a(com.google.android.exoplayer2.offline.DownloadRequest downloadRequest, com.google.android.exoplayer2.offline.DefaultDownloadIndex defaultDownloadIndex, boolean z, long j) throws java.io.IOException {
        com.google.android.exoplayer2.offline.Download download;
        com.google.android.exoplayer2.offline.Download download2 = defaultDownloadIndex.getDownload(downloadRequest.id);
        if (download2 != null) {
            download = com.google.android.exoplayer2.offline.DownloadManager.d(download2, downloadRequest, download2.stopReason, j);
        } else {
            download = new com.google.android.exoplayer2.offline.Download(downloadRequest, z ? 3 : 0, j, j, -1L, 0, 0);
        }
        defaultDownloadIndex.putDownload(download);
    }

    @androidx.annotation.WorkerThread
    public static void upgradeAndDelete(java.io.File file, @androidx.annotation.Nullable com.google.android.exoplayer2.offline.ActionFileUpgradeUtil.DownloadIdProvider downloadIdProvider, com.google.android.exoplayer2.offline.DefaultDownloadIndex defaultDownloadIndex, boolean z, boolean z2) throws java.io.IOException {
        com.google.android.exoplayer2.offline.ActionFile actionFile = new com.google.android.exoplayer2.offline.ActionFile(file);
        if (actionFile.a()) {
            try {
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                for (com.google.android.exoplayer2.offline.DownloadRequest downloadRequest : actionFile.d()) {
                    if (downloadIdProvider != null) {
                        downloadRequest = downloadRequest.copyWithId(downloadIdProvider.getId(downloadRequest));
                    }
                    a(downloadRequest, defaultDownloadIndex, z2, currentTimeMillis);
                }
                actionFile.delete();
            } catch (java.lang.Throwable th) {
                if (z) {
                    actionFile.delete();
                }
                throw th;
            }
        }
    }
}
