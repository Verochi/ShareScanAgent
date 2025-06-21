package com.ss.android.socialbase.downloader.network.connectionpool;

/* loaded from: classes19.dex */
public class DownloadPreconnecter {
    private static final long DEFAULT_CONNECTION_OUTDATE_TIME = 300000;
    private static final long DEFAULT_HEAD_INFO_OUTDATE_TIME = 300000;
    private static java.lang.Runnable sCancelRunnable;
    static long sConnectionOutdatedTime;
    private static final android.os.Handler sHandler;
    static long sHeadInfoOutdatedTime;
    private static final android.os.HandlerThread sPreconnectThread;

    /* renamed from: com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                android.os.Process.setThreadPriority(10);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter$2, reason: invalid class name */
    public static class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.ss.android.socialbase.downloader.network.IFetchHttpHeadInfoListener val$listener;
        final /* synthetic */ java.lang.String val$url;

        public AnonymousClass2(java.lang.String str, com.ss.android.socialbase.downloader.network.IFetchHttpHeadInfoListener iFetchHttpHeadInfoListener) {
            this.val$url = str;
            this.val$listener = iFetchHttpHeadInfoListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (android.text.TextUtils.isEmpty(this.val$url)) {
                com.ss.android.socialbase.downloader.network.IFetchHttpHeadInfoListener iFetchHttpHeadInfoListener = this.val$listener;
                if (iFetchHttpHeadInfoListener != null) {
                    iFetchHttpHeadInfoListener.onFetchFinished(null);
                    return;
                }
                return;
            }
            try {
                try {
                    java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> extraHeaders = com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter.getExtraHeaders(0L, null, null);
                    r1 = com.ss.android.socialbase.downloader.network.connectionpool.DownloadConnectionPool.getInstance().isHeadConnectionExist(this.val$url) ? com.ss.android.socialbase.downloader.network.connectionpool.DownloadConnectionPool.getInstance().getCachedHeadConnection(this.val$url, extraHeaders) : null;
                    if (r1 == null) {
                        com.ss.android.socialbase.downloader.network.connectionpool.FakeDownloadHeadHttpConnection fakeDownloadHeadHttpConnection = new com.ss.android.socialbase.downloader.network.connectionpool.FakeDownloadHeadHttpConnection(this.val$url, extraHeaders, 0L);
                        try {
                            fakeDownloadHeadHttpConnection.execute();
                            if (fakeDownloadHeadHttpConnection.isSuccessful()) {
                                com.ss.android.socialbase.downloader.network.connectionpool.DownloadConnectionPool.getInstance().putCachedHeadConnections(this.val$url, fakeDownloadHeadHttpConnection);
                            }
                            r1 = fakeDownloadHeadHttpConnection;
                        } catch (java.lang.Exception e) {
                            e = e;
                            r1 = fakeDownloadHeadHttpConnection;
                            e.printStackTrace();
                            try {
                                r1.cancel();
                                return;
                            } catch (java.lang.Throwable unused) {
                                return;
                            }
                        } catch (java.lang.Throwable th) {
                            th = th;
                            r1 = fakeDownloadHeadHttpConnection;
                            try {
                                r1.cancel();
                            } catch (java.lang.Throwable unused2) {
                            }
                            throw th;
                        }
                    }
                    java.util.Map<java.lang.String, java.lang.String> responseHeaders = r1.getResponseHeaders();
                    com.ss.android.socialbase.downloader.network.IFetchHttpHeadInfoListener iFetchHttpHeadInfoListener2 = this.val$listener;
                    if (iFetchHttpHeadInfoListener2 != null) {
                        iFetchHttpHeadInfoListener2.onFetchFinished(responseHeaders);
                    }
                    try {
                        r1.cancel();
                    } catch (java.lang.Throwable unused3) {
                    }
                } catch (java.lang.Exception e2) {
                    e = e2;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter$3, reason: invalid class name */
    public static class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ java.util.List val$extra_headers;
        final /* synthetic */ boolean val$holdConnection;
        final /* synthetic */ boolean val$isHeadMethodAvailable;
        final /* synthetic */ int val$maxLength;
        final /* synthetic */ long val$startOffset;
        final /* synthetic */ java.lang.String val$url;

        public AnonymousClass3(boolean z, java.lang.String str, java.util.List list, long j, boolean z2, int i) {
            this.val$isHeadMethodAvailable = z;
            this.val$url = str;
            this.val$extra_headers = list;
            this.val$startOffset = j;
            this.val$holdConnection = z2;
            this.val$maxLength = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.val$isHeadMethodAvailable) {
                    com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter.fetchHeadInfo(this.val$url, this.val$extra_headers, this.val$startOffset);
                }
                if (this.val$holdConnection) {
                    com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter.createConnection(this.val$maxLength, this.val$url, this.val$extra_headers, this.val$startOffset);
                    java.lang.Runnable unused = com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter.sCancelRunnable = new com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter.CancelRunnable(this.val$url);
                    com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter.sHandler.postDelayed(com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter.sCancelRunnable, com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter.sConnectionOutdatedTime);
                }
            } catch (java.lang.Throwable unused2) {
            }
        }
    }

    public static class CancelRunnable implements java.lang.Runnable {
        private final java.lang.String mUrl;

        public CancelRunnable(java.lang.String str) {
            this.mUrl = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.ss.android.socialbase.downloader.network.connectionpool.DownloadConnectionPool.getInstance().releaseDownloadConnection(this.mUrl);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    static {
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("Downloader-preconnecter");
        sPreconnectThread = handlerThread;
        init();
        handlerThread.start();
        android.os.Handler handler = new android.os.Handler(handlerThread.getLooper());
        sHandler = handler;
        handler.post(new com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter.AnonymousClass1());
    }

    public static void asyncFetchHttpHeadInfo(java.lang.String str, com.ss.android.socialbase.downloader.network.IFetchHttpHeadInfoListener iFetchHttpHeadInfoListener) {
        sHandler.post(new com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter.AnonymousClass2(str, iFetchHttpHeadInfoListener));
    }

    private static void asyncPreconnect(int i, java.lang.String str, java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> list, long j, boolean z, boolean z2) {
        sHandler.post(new com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter.AnonymousClass3(z2, str, list, j, z, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void createConnection(int i, java.lang.String str, java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> list, long j) {
        if (com.ss.android.socialbase.downloader.network.connectionpool.DownloadConnectionPool.getInstance().isDownloadConnectionExist(str)) {
            return;
        }
        com.ss.android.socialbase.downloader.network.connectionpool.FakeDownloadHttpConnection fakeDownloadHttpConnection = new com.ss.android.socialbase.downloader.network.connectionpool.FakeDownloadHttpConnection(i, str, list, j);
        com.ss.android.socialbase.downloader.network.connectionpool.DownloadConnectionPool.getInstance().putCachedDownloadConnections(str, fakeDownloadHttpConnection);
        try {
            fakeDownloadHttpConnection.execute();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fetchHeadInfo(java.lang.String str, java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> list, long j) {
        if (com.ss.android.socialbase.downloader.network.connectionpool.DownloadConnectionPool.getInstance().isHeadConnectionExist(str)) {
            return;
        }
        com.ss.android.socialbase.downloader.network.connectionpool.FakeDownloadHeadHttpConnection fakeDownloadHeadHttpConnection = new com.ss.android.socialbase.downloader.network.connectionpool.FakeDownloadHeadHttpConnection(str, list, j);
        com.ss.android.socialbase.downloader.network.connectionpool.DownloadConnectionPool.getInstance().putCachedHeadConnections(str, fakeDownloadHeadHttpConnection);
        try {
            try {
                fakeDownloadHeadHttpConnection.execute();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                try {
                    fakeDownloadHeadHttpConnection.cancel();
                } catch (java.lang.Throwable unused) {
                }
            }
        } finally {
            try {
                fakeDownloadHeadHttpConnection.cancel();
            } catch (java.lang.Throwable unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> getExtraHeaders(long j, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> list) {
        return com.ss.android.socialbase.downloader.utils.DownloadUtils.addRangeHeader(list, downloadInfo == null ? null : downloadInfo.geteTag(), j, 0L);
    }

    public static android.os.Looper getLooper() {
        return sPreconnectThread.getLooper();
    }

    private static void init() {
        sConnectionOutdatedTime = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optLong(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.GLOBAL_KEY_PRECONNECT_CONNECTION_OUTDATE_TIME, 300000L);
        sHeadInfoOutdatedTime = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optLong(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.GLOBAL_KEY_PRECONNECT_HEAD_INFO_OUTDATE_TIME, 300000L);
        com.ss.android.socialbase.downloader.network.connectionpool.DownloadConnectionPool.getInstance().setMaxCachedDownloadConnectionSize(com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.GLOBAL_KEY_PRECONNECT_MAX_CACHE_SIZE, 3));
    }

    public static void preconnect(int i, java.lang.String str, java.lang.String str2, java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> list, boolean z, boolean z2) {
        long j;
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()).getDownloadInfo(str, str2);
        if (downloadInfo == null) {
            j = 0;
        } else if (downloadInfo.isDownloadingStatus() || downloadInfo.isDownloaded() || downloadInfo.getChunkCount() > 1) {
            return;
        } else {
            j = com.ss.android.socialbase.downloader.utils.DownloadUtils.getFirstOffset(downloadInfo);
        }
        long j2 = j;
        asyncPreconnect(i, str, getExtraHeaders(j2, downloadInfo, list), j2, z, z2);
    }

    public static void preconnect(java.lang.String str, java.lang.String str2, boolean z) {
        preconnect(-1, str, str2, null, z, true);
    }
}
