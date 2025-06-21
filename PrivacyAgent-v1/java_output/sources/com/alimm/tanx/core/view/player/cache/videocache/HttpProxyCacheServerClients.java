package com.alimm.tanx.core.view.player.cache.videocache;

/* loaded from: classes.dex */
final class HttpProxyCacheServerClients {
    private final java.util.concurrent.atomic.AtomicInteger clientsCount = new java.util.concurrent.atomic.AtomicInteger(0);
    private final com.alimm.tanx.core.view.player.cache.videocache.Config config;
    private final java.util.List<com.alimm.tanx.core.view.player.cache.videocache.CacheListener> listeners;
    private volatile com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCache proxyCache;
    private final com.alimm.tanx.core.view.player.cache.videocache.CacheListener uiCacheListener;
    private final java.lang.String url;

    public static final class UiListenerHandler extends android.os.Handler implements com.alimm.tanx.core.view.player.cache.videocache.CacheListener {
        private final java.util.List<com.alimm.tanx.core.view.player.cache.videocache.CacheListener> listeners;
        private final java.lang.String url;

        public UiListenerHandler(java.lang.String str, java.util.List<com.alimm.tanx.core.view.player.cache.videocache.CacheListener> list) {
            super(android.os.Looper.getMainLooper());
            this.url = str;
            this.listeners = list;
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            java.util.Iterator<com.alimm.tanx.core.view.player.cache.videocache.CacheListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onCacheAvailable((java.io.File) message.obj, this.url, message.arg1);
            }
        }

        @Override // com.alimm.tanx.core.view.player.cache.videocache.CacheListener
        public void onCacheAvailable(java.io.File file, java.lang.String str, int i) {
            android.os.Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
        }
    }

    public HttpProxyCacheServerClients(java.lang.String str, com.alimm.tanx.core.view.player.cache.videocache.Config config) {
        java.util.concurrent.CopyOnWriteArrayList copyOnWriteArrayList = new java.util.concurrent.CopyOnWriteArrayList();
        this.listeners = copyOnWriteArrayList;
        this.url = (java.lang.String) com.alimm.tanx.core.view.player.cache.videocache.Preconditions.checkNotNull(str);
        this.config = (com.alimm.tanx.core.view.player.cache.videocache.Config) com.alimm.tanx.core.view.player.cache.videocache.Preconditions.checkNotNull(config);
        this.uiCacheListener = new com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServerClients.UiListenerHandler(str, copyOnWriteArrayList);
    }

    private synchronized void finishProcessRequest() {
        if (this.clientsCount.decrementAndGet() <= 0) {
            this.proxyCache.shutdown();
            this.proxyCache = null;
        }
    }

    private com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCache newHttpProxyCache() throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
        java.lang.String str = this.url;
        com.alimm.tanx.core.view.player.cache.videocache.Config config = this.config;
        com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCache httpProxyCache = new com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCache(new com.alimm.tanx.core.view.player.cache.videocache.HttpUrlSource(str, config.sourceInfoStorage, config.headerInjector), new com.alimm.tanx.core.view.player.cache.videocache.file.FileCache(this.config.generateCacheFile(this.url), this.config.diskUsage));
        httpProxyCache.registerCacheListener(this.uiCacheListener);
        return httpProxyCache;
    }

    private synchronized void startProcessRequest() throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
        this.proxyCache = this.proxyCache == null ? newHttpProxyCache() : this.proxyCache;
    }

    public int getClientsCount() {
        return this.clientsCount.get();
    }

    public void processRequest(com.alimm.tanx.core.view.player.cache.videocache.GetRequest getRequest, java.net.Socket socket) throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException, java.io.IOException {
        startProcessRequest();
        try {
            this.clientsCount.incrementAndGet();
            this.proxyCache.processRequest(getRequest, socket);
        } finally {
            finishProcessRequest();
        }
    }

    public void registerCacheListener(com.alimm.tanx.core.view.player.cache.videocache.CacheListener cacheListener) {
        this.listeners.add(cacheListener);
    }

    public void shutdown() {
        this.listeners.clear();
        if (this.proxyCache != null) {
            this.proxyCache.registerCacheListener(null);
            this.proxyCache.shutdown();
            this.proxyCache = null;
        }
        this.clientsCount.set(0);
    }

    public void unregisterCacheListener(com.alimm.tanx.core.view.player.cache.videocache.CacheListener cacheListener) {
        this.listeners.remove(cacheListener);
    }
}
