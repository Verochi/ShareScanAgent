package com.alimm.tanx.core.view.player.cache.videocache;

/* loaded from: classes.dex */
class ProxyCache {
    private static final com.alimm.tanx.core.view.player.cache.videocache.log.Logger LOG = com.alimm.tanx.core.view.player.cache.videocache.log.LoggerFactory.getLogger("ProxyCache");
    private static final int MAX_READ_SOURCE_ATTEMPTS = 1;
    private final com.alimm.tanx.core.view.player.cache.videocache.Cache cache;
    private final com.alimm.tanx.core.view.player.cache.videocache.Source source;
    private volatile java.lang.Thread sourceReaderThread;
    private volatile boolean stopped;
    private final java.lang.Object wc = new java.lang.Object();
    private final java.lang.Object stopLock = new java.lang.Object();
    private volatile int percentsAvailable = -1;
    private final java.util.concurrent.atomic.AtomicInteger readSourceErrorsCount = new java.util.concurrent.atomic.AtomicInteger();

    public class SourceReaderRunnable implements java.lang.Runnable {
        private SourceReaderRunnable() {
        }

        public /* synthetic */ SourceReaderRunnable(com.alimm.tanx.core.view.player.cache.videocache.ProxyCache proxyCache, com.alimm.tanx.core.view.player.cache.videocache.ProxyCache.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alimm.tanx.core.view.player.cache.videocache.ProxyCache.this.readSource();
        }
    }

    public ProxyCache(com.alimm.tanx.core.view.player.cache.videocache.Source source, com.alimm.tanx.core.view.player.cache.videocache.Cache cache) {
        this.source = (com.alimm.tanx.core.view.player.cache.videocache.Source) com.alimm.tanx.core.view.player.cache.videocache.Preconditions.checkNotNull(source);
        this.cache = (com.alimm.tanx.core.view.player.cache.videocache.Cache) com.alimm.tanx.core.view.player.cache.videocache.Preconditions.checkNotNull(cache);
    }

    private void checkReadSourceErrorsCount() throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
        int i = this.readSourceErrorsCount.get();
        if (i < 1) {
            return;
        }
        this.readSourceErrorsCount.set(0);
        throw new com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException("Error reading source " + i + " times");
    }

    private void closeSource() {
        try {
            this.source.close();
        } catch (com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException e) {
            onError(new com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException("Error closing source " + this.source, e));
        }
    }

    private boolean isStopped() {
        return java.lang.Thread.currentThread().isInterrupted() || this.stopped;
    }

    private void notifyNewCacheDataAvailable(long j, long j2) {
        onCacheAvailable(j, j2);
        synchronized (this.wc) {
            this.wc.notifyAll();
        }
    }

    private void onSourceRead() {
        this.percentsAvailable = 100;
        onCachePercentsAvailableChanged(this.percentsAvailable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readSource() {
        long j = -1;
        long j2 = 0;
        try {
            LOG.info("开始读取网络数据");
            j2 = this.cache.available();
            this.source.open(j2);
            j = this.source.length();
            byte[] bArr = new byte[8192];
            while (true) {
                int read = this.source.read(bArr);
                if (read == -1) {
                    tryComplete();
                    onSourceRead();
                    LOG.info("读取网络数据结束");
                    break;
                } else {
                    synchronized (this.stopLock) {
                        if (isStopped()) {
                            return;
                        } else {
                            this.cache.append(bArr, read);
                        }
                    }
                    j2 += read;
                    notifyNewCacheDataAvailable(j2, j);
                }
            }
        } catch (java.lang.Throwable th) {
            try {
                com.alimm.tanx.core.view.player.cache.videocache.log.Logger logger = LOG;
                logger.info("读取网络数据异常");
                this.readSourceErrorsCount.incrementAndGet();
                onError(th);
                logger.info("读取网络数据结束");
            } finally {
                LOG.info("读取网络数据结束");
                closeSource();
                notifyNewCacheDataAvailable(j2, j);
            }
        }
        closeSource();
        notifyNewCacheDataAvailable(j2, j);
    }

    private synchronized void readSourceAsync() throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
        LOG.info("一步读取网络数据");
        boolean z = (this.sourceReaderThread == null || this.sourceReaderThread.getState() == java.lang.Thread.State.TERMINATED) ? false : true;
        if (!this.stopped && !this.cache.isCompleted() && !z) {
            this.sourceReaderThread = new java.lang.Thread(new com.alimm.tanx.core.view.player.cache.videocache.ProxyCache.SourceReaderRunnable(this, null), "Source reader for " + this.source);
            this.sourceReaderThread.start();
        }
    }

    private void tryComplete() throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
        synchronized (this.stopLock) {
            if (!isStopped() && this.cache.available() == this.source.length()) {
                this.cache.complete();
            }
        }
    }

    private void waitForSourceData() throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
        synchronized (this.wc) {
            try {
                try {
                    this.wc.wait(1000L);
                } catch (java.lang.InterruptedException e) {
                    throw new com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException("Waiting source data is interrupted!", e);
                }
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }
    }

    public void onCacheAvailable(long j, long j2) {
        int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1)) == 0 ? 100 : (int) ((j / j2) * 100.0f);
        boolean z = i != this.percentsAvailable;
        if ((j2 >= 0) && z) {
            onCachePercentsAvailableChanged(i);
        }
        this.percentsAvailable = i;
    }

    public void onCachePercentsAvailableChanged(int i) {
    }

    public final void onError(java.lang.Throwable th) {
        if (th instanceof com.alimm.tanx.core.view.player.cache.videocache.InterruptedProxyCacheException) {
            LOG.debug("ProxyCache is interrupted");
        } else {
            LOG.error("ProxyCache error", th);
        }
    }

    public int read(byte[] bArr, long j, int i) throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
        com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheUtils.assertBuffer(bArr, j, i);
        while (!this.cache.isCompleted() && this.cache.available() < i + j && !this.stopped) {
            readSourceAsync();
            waitForSourceData();
            checkReadSourceErrorsCount();
        }
        LOG.info("开始从缓存中读取数据");
        int read = this.cache.read(bArr, j, i);
        if (this.cache.isCompleted() && this.percentsAvailable != 100) {
            this.percentsAvailable = 100;
            onCachePercentsAvailableChanged(100);
        }
        return read;
    }

    public void shutdown() {
        synchronized (this.stopLock) {
            LOG.info("Shutdown proxy for " + this.source);
            try {
                this.stopped = true;
                if (this.sourceReaderThread != null) {
                    this.sourceReaderThread.interrupt();
                }
                this.cache.close();
            } catch (com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException e) {
                onError(e);
            }
        }
    }
}
