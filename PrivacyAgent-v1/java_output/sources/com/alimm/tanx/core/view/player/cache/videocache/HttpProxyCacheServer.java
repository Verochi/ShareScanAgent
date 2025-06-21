package com.alimm.tanx.core.view.player.cache.videocache;

/* loaded from: classes.dex */
public class HttpProxyCacheServer {
    private static final com.alimm.tanx.core.view.player.cache.videocache.log.Logger LOG = com.alimm.tanx.core.view.player.cache.videocache.log.LoggerFactory.getLogger("HttpProxyCacheServer");
    private static final java.lang.String PROXY_HOST = "127.0.0.1";
    private final java.lang.Object clientsLock;
    private final java.util.Map<java.lang.String, com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServerClients> clientsMap;
    private final com.alimm.tanx.core.view.player.cache.videocache.Config config;
    private final com.alimm.tanx.core.view.player.cache.videocache.Pinger pinger;
    private final int port;
    private final java.net.ServerSocket serverSocket;
    private final java.util.concurrent.ExecutorService socketProcessor;
    private final java.lang.Thread waitConnectionThread;

    public static final class Builder {
        private static final long DEFAULT_MAX_SIZE = 536870912;
        private java.io.File cacheRoot;
        private com.alimm.tanx.core.view.player.cache.videocache.file.DiskUsage diskUsage = new com.alimm.tanx.core.view.player.cache.videocache.file.TotalSizeLruDiskUsage(536870912);
        private com.alimm.tanx.core.view.player.cache.videocache.file.FileNameGenerator fileNameGenerator = new com.alimm.tanx.core.view.player.cache.videocache.file.Md5FileNameGenerator();
        private com.alimm.tanx.core.view.player.cache.videocache.headers.HeaderInjector headerInjector = new com.alimm.tanx.core.view.player.cache.videocache.headers.EmptyHeadersInjector();
        private final com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.SourceInfoStorage sourceInfoStorage;

        public Builder(android.content.Context context) {
            this.sourceInfoStorage = com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.SourceInfoStorageFactory.newSourceInfoStorage(context);
            this.cacheRoot = com.alimm.tanx.core.view.player.cache.videocache.StorageUtils.getIndividualCacheDirectory(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.alimm.tanx.core.view.player.cache.videocache.Config buildConfig() {
            return new com.alimm.tanx.core.view.player.cache.videocache.Config(this.cacheRoot, this.fileNameGenerator, this.diskUsage, this.sourceInfoStorage, this.headerInjector);
        }

        public com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer build() {
            return new com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer(buildConfig(), null);
        }

        public com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer.Builder cacheDirectory(java.io.File file) {
            this.cacheRoot = (java.io.File) com.alimm.tanx.core.view.player.cache.videocache.Preconditions.checkNotNull(file);
            return this;
        }

        public com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer.Builder diskUsage(com.alimm.tanx.core.view.player.cache.videocache.file.DiskUsage diskUsage) {
            this.diskUsage = (com.alimm.tanx.core.view.player.cache.videocache.file.DiskUsage) com.alimm.tanx.core.view.player.cache.videocache.Preconditions.checkNotNull(diskUsage);
            return this;
        }

        public com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer.Builder fileNameGenerator(com.alimm.tanx.core.view.player.cache.videocache.file.FileNameGenerator fileNameGenerator) {
            this.fileNameGenerator = (com.alimm.tanx.core.view.player.cache.videocache.file.FileNameGenerator) com.alimm.tanx.core.view.player.cache.videocache.Preconditions.checkNotNull(fileNameGenerator);
            return this;
        }

        public com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer.Builder headerInjector(com.alimm.tanx.core.view.player.cache.videocache.headers.HeaderInjector headerInjector) {
            this.headerInjector = (com.alimm.tanx.core.view.player.cache.videocache.headers.HeaderInjector) com.alimm.tanx.core.view.player.cache.videocache.Preconditions.checkNotNull(headerInjector);
            return this;
        }

        public com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer.Builder maxCacheFilesCount(int i) {
            this.diskUsage = new com.alimm.tanx.core.view.player.cache.videocache.file.TotalCountLruDiskUsage(i);
            return this;
        }

        public com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer.Builder maxCacheSize(long j) {
            this.diskUsage = new com.alimm.tanx.core.view.player.cache.videocache.file.TotalSizeLruDiskUsage(j);
            return this;
        }
    }

    public final class SocketProcessorRunnable implements java.lang.Runnable {
        private final java.net.Socket socket;

        public SocketProcessorRunnable(java.net.Socket socket) {
            this.socket = socket;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer.this.processSocket(this.socket);
        }
    }

    public final class WaitRequestsRunnable implements java.lang.Runnable {
        private final java.util.concurrent.CountDownLatch startSignal;

        public WaitRequestsRunnable(java.util.concurrent.CountDownLatch countDownLatch) {
            this.startSignal = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.startSignal.countDown();
            com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer.this.waitForRequest();
        }
    }

    public HttpProxyCacheServer(android.content.Context context) {
        this(new com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer.Builder(context).buildConfig());
    }

    private HttpProxyCacheServer(com.alimm.tanx.core.view.player.cache.videocache.Config config) {
        this.clientsLock = new java.lang.Object();
        this.socketProcessor = java.util.concurrent.Executors.newFixedThreadPool(8);
        this.clientsMap = new java.util.concurrent.ConcurrentHashMap();
        this.config = (com.alimm.tanx.core.view.player.cache.videocache.Config) com.alimm.tanx.core.view.player.cache.videocache.Preconditions.checkNotNull(config);
        try {
            java.net.ServerSocket serverSocket = new java.net.ServerSocket(0, 8, java.net.InetAddress.getByName(PROXY_HOST));
            this.serverSocket = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.port = localPort;
            com.alimm.tanx.core.view.player.cache.videocache.IgnoreHostProxySelector.install(PROXY_HOST, localPort);
            java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
            java.lang.Thread thread = new java.lang.Thread(new com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer.WaitRequestsRunnable(countDownLatch));
            this.waitConnectionThread = thread;
            thread.start();
            countDownLatch.await();
            this.pinger = new com.alimm.tanx.core.view.player.cache.videocache.Pinger(PROXY_HOST, localPort);
            com.alimm.tanx.core.utils.LogUtils.d("Proxy cache server started. Is it alive? " + isAlive(), new java.lang.String[0]);
        } catch (java.io.IOException | java.lang.InterruptedException e) {
            this.socketProcessor.shutdown();
            com.alimm.tanx.core.utils.LogUtils.e("Error starting local proxy server", e);
            throw new java.lang.IllegalStateException("Error starting local proxy server", e);
        }
    }

    public /* synthetic */ HttpProxyCacheServer(com.alimm.tanx.core.view.player.cache.videocache.Config config, com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer.AnonymousClass1 anonymousClass1) {
        this(config);
    }

    private java.lang.String appendToProxyUrl(java.lang.String str) {
        return java.lang.String.format(java.util.Locale.US, "http://%s:%d/%s", PROXY_HOST, java.lang.Integer.valueOf(this.port), com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheUtils.encode(str));
    }

    private void closeSocket(java.net.Socket socket) {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (java.io.IOException e) {
            onError(new com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException("Error closing socket", e));
        }
    }

    private void closeSocketInput(java.net.Socket socket) {
        try {
            if (socket.isInputShutdown()) {
                return;
            }
            socket.shutdownInput();
        } catch (java.net.SocketException unused) {
            LOG.debug("Releasing input stream… Socket is closed by client.");
        } catch (java.io.IOException e) {
            onError(new com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException("Error closing socket input stream", e));
        }
    }

    private void closeSocketOutput(java.net.Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (java.io.IOException e) {
            LOG.warn("Failed to close socket on proxy side: {}. It seems client have already closed connection.", e.getMessage());
        }
    }

    private com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServerClients getClients(java.lang.String str) throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
        com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServerClients httpProxyCacheServerClients;
        synchronized (this.clientsLock) {
            httpProxyCacheServerClients = this.clientsMap.get(str);
            if (httpProxyCacheServerClients == null) {
                httpProxyCacheServerClients = new com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServerClients(str, this.config);
                this.clientsMap.put(str, httpProxyCacheServerClients);
            }
        }
        return httpProxyCacheServerClients;
    }

    private int getClientsCount() {
        int i;
        synchronized (this.clientsLock) {
            java.util.Iterator<com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServerClients> it = this.clientsMap.values().iterator();
            i = 0;
            while (it.hasNext()) {
                i += it.next().getClientsCount();
            }
        }
        return i;
    }

    private boolean isAlive() {
        return this.pinger.ping(3, 70);
    }

    private void onError(java.lang.Throwable th) {
        LOG.error("HttpProxyCacheServer error", th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processSocket(java.net.Socket socket) {
        try {
            try {
                com.alimm.tanx.core.view.player.cache.videocache.GetRequest read = com.alimm.tanx.core.view.player.cache.videocache.GetRequest.read(socket.getInputStream());
                com.alimm.tanx.core.view.player.cache.videocache.log.Logger logger = LOG;
                logger.debug("Request to cache proxy:" + read);
                java.lang.String decode = com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheUtils.decode(read.uri);
                logger.info("此时的url为：" + decode);
                if (this.pinger.isPingRequest(decode)) {
                    this.pinger.responseToPing(socket);
                } else {
                    getClients(decode).processRequest(read, socket);
                }
                releaseSocket(socket);
                logger.debug("Opened connections: " + getClientsCount());
            } catch (com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException e) {
                e = e;
                onError(new com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException("Error processing request", e));
                releaseSocket(socket);
                LOG.debug("Opened connections: " + getClientsCount());
            } catch (java.net.SocketException unused) {
                com.alimm.tanx.core.view.player.cache.videocache.log.Logger logger2 = LOG;
                logger2.debug("Closing socket… Socket is closed by client.");
                releaseSocket(socket);
                logger2.debug("Opened connections: " + getClientsCount());
            } catch (java.io.IOException e2) {
                e = e2;
                onError(new com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException("Error processing request", e));
                releaseSocket(socket);
                LOG.debug("Opened connections: " + getClientsCount());
            }
        } catch (java.lang.Throwable th) {
            releaseSocket(socket);
            LOG.debug("Opened connections: " + getClientsCount());
            throw th;
        }
    }

    private void releaseSocket(java.net.Socket socket) {
        closeSocketInput(socket);
        closeSocketOutput(socket);
        closeSocket(socket);
    }

    private void shutdownClients() {
        synchronized (this.clientsLock) {
            java.util.Iterator<com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServerClients> it = this.clientsMap.values().iterator();
            while (it.hasNext()) {
                it.next().shutdown();
            }
            this.clientsMap.clear();
        }
    }

    private void touchFileSafely(java.io.File file) {
        try {
            this.config.diskUsage.touch(file);
        } catch (java.io.IOException e) {
            LOG.error("Error touching file " + file, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void waitForRequest() {
        while (!java.lang.Thread.currentThread().isInterrupted()) {
            try {
                java.net.Socket accept = this.serverSocket.accept();
                LOG.info("Accept new socket " + accept);
                this.socketProcessor.submit(new com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer.SocketProcessorRunnable(accept));
            } catch (java.io.IOException e) {
                onError(new com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException("Error during waiting connection", e));
                return;
            }
        }
    }

    public java.io.File getCacheFile(java.lang.String str) {
        com.alimm.tanx.core.view.player.cache.videocache.Config config = this.config;
        return new java.io.File(config.cacheRoot, config.fileNameGenerator.generate(str));
    }

    public java.io.File getCacheRoot() {
        return this.config.cacheRoot;
    }

    public java.lang.String getProxyUrl(java.lang.String str) {
        return getProxyUrl(str, true);
    }

    public java.lang.String getProxyUrl(java.lang.String str, boolean z) {
        if (!z || !isCached(str)) {
            return isAlive() ? appendToProxyUrl(str) : str;
        }
        java.io.File cacheFile = getCacheFile(str);
        touchFileSafely(cacheFile);
        return android.net.Uri.fromFile(cacheFile).toString();
    }

    public java.io.File getTempCacheFile(java.lang.String str) {
        return new java.io.File(this.config.cacheRoot, this.config.fileNameGenerator.generate(str) + ".download");
    }

    public boolean isCached(java.lang.String str) {
        com.alimm.tanx.core.view.player.cache.videocache.Preconditions.checkNotNull(str, "Url can't be null!");
        return getCacheFile(str).exists();
    }

    public void registerCacheListener(com.alimm.tanx.core.view.player.cache.videocache.CacheListener cacheListener, java.lang.String str) {
        com.alimm.tanx.core.view.player.cache.videocache.Preconditions.checkAllNotNull(cacheListener, str);
        synchronized (this.clientsLock) {
            try {
                getClients(str).registerCacheListener(cacheListener);
            } catch (com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException e) {
                LOG.warn("Error registering cache listener", e);
            }
        }
    }

    public void shutdown() {
        LOG.info("Shutdown proxy server");
        shutdownClients();
        this.config.sourceInfoStorage.release();
        this.waitConnectionThread.interrupt();
        try {
            if (this.serverSocket.isClosed()) {
                return;
            }
            this.serverSocket.close();
        } catch (java.io.IOException e) {
            onError(new com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException("Error shutting down proxy server", e));
        }
    }

    public void unregisterCacheListener(com.alimm.tanx.core.view.player.cache.videocache.CacheListener cacheListener) {
        com.alimm.tanx.core.view.player.cache.videocache.Preconditions.checkNotNull(cacheListener);
        synchronized (this.clientsLock) {
            java.util.Iterator<com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServerClients> it = this.clientsMap.values().iterator();
            while (it.hasNext()) {
                it.next().unregisterCacheListener(cacheListener);
            }
        }
    }

    public void unregisterCacheListener(com.alimm.tanx.core.view.player.cache.videocache.CacheListener cacheListener, java.lang.String str) {
        com.alimm.tanx.core.view.player.cache.videocache.Preconditions.checkAllNotNull(cacheListener, str);
        synchronized (this.clientsLock) {
            try {
                getClients(str).unregisterCacheListener(cacheListener);
            } catch (com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException e) {
                LOG.warn("Error registering cache listener", e);
            }
        }
    }
}
