package com.ss.android.socialbase.downloader.network.connectionpool;

/* loaded from: classes19.dex */
public class DownloadConnectionPool {
    public static final int MAX_HOLD_CONNECTION = 3;
    private static final java.lang.String TAG = "DownloadConnectionPool";
    private final java.util.Map<java.lang.String, com.ss.android.socialbase.downloader.network.connectionpool.FakeDownloadHttpConnection> mCachedDownloadConnections;
    private final java.util.Map<java.lang.String, com.ss.android.socialbase.downloader.network.connectionpool.FakeDownloadHeadHttpConnection> mCachedHeadConnections;
    protected int maxCacheSize;

    public static final class InstanceHolder {
        private static final com.ss.android.socialbase.downloader.network.connectionpool.DownloadConnectionPool INSTANCE = new com.ss.android.socialbase.downloader.network.connectionpool.DownloadConnectionPool(null);

        private InstanceHolder() {
        }
    }

    private DownloadConnectionPool() {
        this.mCachedHeadConnections = new java.util.HashMap();
        this.mCachedDownloadConnections = new java.util.LinkedHashMap(3);
        this.maxCacheSize = 3;
    }

    public /* synthetic */ DownloadConnectionPool(com.ss.android.socialbase.downloader.network.connectionpool.DownloadConnectionPool.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.ss.android.socialbase.downloader.network.connectionpool.DownloadConnectionPool getInstance() {
        return com.ss.android.socialbase.downloader.network.connectionpool.DownloadConnectionPool.InstanceHolder.INSTANCE;
    }

    public com.ss.android.socialbase.downloader.network.connectionpool.FakeDownloadHttpConnection getCachedDownloadConnection(java.lang.String str, java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> list) {
        com.ss.android.socialbase.downloader.network.connectionpool.FakeDownloadHttpConnection remove;
        synchronized (this.mCachedDownloadConnections) {
            remove = this.mCachedDownloadConnections.remove(str);
        }
        if (remove == null) {
            return null;
        }
        if (com.ss.android.socialbase.downloader.utils.DownloadUtils.isHeaderEqual(remove.getRequestHeaders(), list)) {
            try {
                remove.joinExecute();
            } catch (java.lang.InterruptedException e) {
                e.printStackTrace();
            }
            if (remove.isValid() && remove.isSuccessful()) {
                return remove;
            }
        }
        try {
            remove.end();
            return null;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public com.ss.android.socialbase.downloader.network.connectionpool.FakeDownloadHeadHttpConnection getCachedHeadConnection(java.lang.String str, java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> list) {
        com.ss.android.socialbase.downloader.network.connectionpool.FakeDownloadHeadHttpConnection remove;
        synchronized (this.mCachedHeadConnections) {
            remove = this.mCachedHeadConnections.remove(str);
        }
        if (remove == null) {
            return null;
        }
        if (com.ss.android.socialbase.downloader.utils.DownloadUtils.isHeaderEqual(remove.getRequestHeaders(), list)) {
            try {
                remove.joinExecute();
            } catch (java.lang.InterruptedException e) {
                e.printStackTrace();
            }
            if (remove.isValid() && remove.isSuccessful()) {
                return remove;
            }
        }
        try {
            remove.cancel();
            return null;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public boolean isDownloadConnectionExist(java.lang.String str) {
        com.ss.android.socialbase.downloader.network.connectionpool.FakeDownloadHttpConnection fakeDownloadHttpConnection = this.mCachedDownloadConnections.get(str);
        if (fakeDownloadHttpConnection != null) {
            if (fakeDownloadHttpConnection.isRequesting()) {
                return true;
            }
            if (fakeDownloadHttpConnection.isValid() && fakeDownloadHttpConnection.isSuccessful()) {
                return true;
            }
        }
        return false;
    }

    public boolean isHeadConnectionExist(java.lang.String str) {
        com.ss.android.socialbase.downloader.network.connectionpool.FakeDownloadHeadHttpConnection fakeDownloadHeadHttpConnection = this.mCachedHeadConnections.get(str);
        if (fakeDownloadHeadHttpConnection != null) {
            if (fakeDownloadHeadHttpConnection.isRequesting()) {
                return true;
            }
            if (fakeDownloadHeadHttpConnection.isValid() && fakeDownloadHeadHttpConnection.isSuccessful()) {
                return true;
            }
        }
        return false;
    }

    public void putCachedDownloadConnections(java.lang.String str, com.ss.android.socialbase.downloader.network.connectionpool.FakeDownloadHttpConnection fakeDownloadHttpConnection) {
        com.ss.android.socialbase.downloader.network.connectionpool.FakeDownloadHttpConnection fakeDownloadHttpConnection2;
        java.util.Map.Entry<java.lang.String, com.ss.android.socialbase.downloader.network.connectionpool.FakeDownloadHttpConnection> next;
        synchronized (this.mCachedDownloadConnections) {
            if (this.mCachedDownloadConnections.size() == this.maxCacheSize) {
                java.util.Iterator<java.util.Map.Entry<java.lang.String, com.ss.android.socialbase.downloader.network.connectionpool.FakeDownloadHttpConnection>> it = this.mCachedDownloadConnections.entrySet().iterator();
                if (it.hasNext() && (next = it.next()) != null) {
                    fakeDownloadHttpConnection2 = this.mCachedDownloadConnections.remove(next.getKey());
                    this.mCachedDownloadConnections.put(str, fakeDownloadHttpConnection);
                }
            }
            fakeDownloadHttpConnection2 = null;
            this.mCachedDownloadConnections.put(str, fakeDownloadHttpConnection);
        }
        if (fakeDownloadHttpConnection2 != null) {
            try {
                fakeDownloadHttpConnection2.end();
            } catch (java.lang.Throwable unused) {
            }
        }
        com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "mCachedConnections size = " + this.mCachedDownloadConnections.size() + ", max size = " + this.maxCacheSize);
    }

    public void putCachedHeadConnections(java.lang.String str, com.ss.android.socialbase.downloader.network.connectionpool.FakeDownloadHeadHttpConnection fakeDownloadHeadHttpConnection) {
        synchronized (this.mCachedHeadConnections) {
            this.mCachedHeadConnections.put(str, fakeDownloadHeadHttpConnection);
        }
    }

    public void releaseDownloadConnection(java.lang.String str) {
        com.ss.android.socialbase.downloader.network.connectionpool.FakeDownloadHttpConnection remove;
        synchronized (this.mCachedDownloadConnections) {
            remove = this.mCachedDownloadConnections.remove(str);
        }
        if (remove != null) {
            try {
                remove.end();
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public void releaseHeadConnection(java.lang.String str) {
        com.ss.android.socialbase.downloader.network.connectionpool.FakeDownloadHeadHttpConnection remove;
        synchronized (this.mCachedHeadConnections) {
            remove = this.mCachedHeadConnections.remove(str);
        }
        if (remove != null) {
            remove.cancel();
        }
    }

    public void setMaxCachedDownloadConnectionSize(int i) {
        this.maxCacheSize = i;
    }
}
