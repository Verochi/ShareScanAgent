package com.ss.android.socialbase.downloader.utils;

/* loaded from: classes19.dex */
public class DownloadListenerUtils {
    public static void notifyListener(int i, android.util.SparseArray<com.ss.android.socialbase.downloader.depend.IDownloadListener> sparseArray, boolean z, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException) {
        android.util.SparseArray<com.ss.android.socialbase.downloader.depend.IDownloadListener> clone;
        if (!z || sparseArray == null) {
            return;
        }
        try {
            if (sparseArray.size() <= 0) {
                return;
            }
            synchronized (sparseArray) {
                clone = sparseArray.clone();
            }
            for (int i2 = 0; i2 < clone.size(); i2++) {
                com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener = clone.get(clone.keyAt(i2));
                if (iDownloadListener != null) {
                    if (i == 1) {
                        iDownloadListener.onPrepare(downloadInfo);
                    } else if (i == 2) {
                        iDownloadListener.onStart(downloadInfo);
                    } else if (i == 4) {
                        iDownloadListener.onProgress(downloadInfo);
                    } else if (i == 5) {
                        iDownloadListener.onRetry(downloadInfo, baseException);
                    } else if (i == 6) {
                        iDownloadListener.onFirstStart(downloadInfo);
                    } else if (i == 7) {
                        iDownloadListener.onRetryDelay(downloadInfo, baseException);
                    } else if (i != 11) {
                        switch (i) {
                            case -7:
                                if (iDownloadListener instanceof com.ss.android.socialbase.downloader.depend.AbsDownloadListener) {
                                    ((com.ss.android.socialbase.downloader.depend.AbsDownloadListener) iDownloadListener).onIntercept(downloadInfo);
                                    break;
                                } else {
                                    break;
                                }
                            case -6:
                                iDownloadListener.onFirstSuccess(downloadInfo);
                                break;
                            case -5:
                            case -2:
                                iDownloadListener.onPause(downloadInfo);
                                break;
                            case -4:
                                iDownloadListener.onCanceled(downloadInfo);
                                break;
                            case -3:
                                iDownloadListener.onSuccessed(downloadInfo);
                                break;
                            case -1:
                                iDownloadListener.onFailed(downloadInfo, baseException);
                                break;
                        }
                    } else if (iDownloadListener instanceof com.ss.android.socialbase.downloader.depend.IDownloadExtListener) {
                        ((com.ss.android.socialbase.downloader.depend.IDownloadExtListener) iDownloadListener).onWaitingDownloadCompleteHandler(downloadInfo);
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
