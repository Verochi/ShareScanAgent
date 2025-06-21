package com.alimm.tanx.core.view.player.cache.videocache;

/* loaded from: classes.dex */
class Pinger {
    private static final com.alimm.tanx.core.view.player.cache.videocache.log.Logger LOG = com.alimm.tanx.core.view.player.cache.videocache.log.LoggerFactory.getLogger("Pinger");
    private static final java.lang.String PING_REQUEST = "ping";
    private static final java.lang.String PING_RESPONSE = "ping ok";
    private final java.lang.String host;
    private final java.util.concurrent.ExecutorService pingExecutor = java.util.concurrent.Executors.newSingleThreadExecutor();
    private final int port;

    public class PingCallable implements java.util.concurrent.Callable<java.lang.Boolean> {
        private PingCallable() {
        }

        public /* synthetic */ PingCallable(com.alimm.tanx.core.view.player.cache.videocache.Pinger pinger, com.alimm.tanx.core.view.player.cache.videocache.Pinger.AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public java.lang.Boolean call() throws java.lang.Exception {
            return java.lang.Boolean.valueOf(com.alimm.tanx.core.view.player.cache.videocache.Pinger.this.pingServer());
        }
    }

    public Pinger(java.lang.String str, int i) {
        this.host = (java.lang.String) com.alimm.tanx.core.view.player.cache.videocache.Preconditions.checkNotNull(str);
        this.port = i;
    }

    private java.util.List<java.net.Proxy> getDefaultProxies() {
        try {
            return java.net.ProxySelector.getDefault().select(new java.net.URI(getPingUrl()));
        } catch (java.net.URISyntaxException e) {
            throw new java.lang.IllegalStateException(e);
        }
    }

    private java.lang.String getPingUrl() {
        return java.lang.String.format(java.util.Locale.US, "http://%s:%d/%s", this.host, java.lang.Integer.valueOf(this.port), PING_REQUEST);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pingServer() throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
        com.alimm.tanx.core.view.player.cache.videocache.HttpUrlSource httpUrlSource = new com.alimm.tanx.core.view.player.cache.videocache.HttpUrlSource(getPingUrl());
        try {
            byte[] bytes = PING_RESPONSE.getBytes();
            httpUrlSource.open(0L);
            byte[] bArr = new byte[bytes.length];
            httpUrlSource.read(bArr);
            boolean equals = java.util.Arrays.equals(bytes, bArr);
            LOG.info("Ping response: `" + new java.lang.String(bArr) + "`, pinged? " + equals);
            return equals;
        } catch (com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException e) {
            LOG.error("Error reading ping response", e);
            return false;
        } finally {
            httpUrlSource.close();
        }
    }

    public boolean isPingRequest(java.lang.String str) {
        return PING_REQUEST.equals(str);
    }

    public boolean ping(int i, int i2) {
        com.alimm.tanx.core.view.player.cache.videocache.Preconditions.checkArgument(i >= 1);
        com.alimm.tanx.core.view.player.cache.videocache.Preconditions.checkArgument(i2 > 0);
        int i3 = 0;
        while (i3 < i) {
            try {
            } catch (java.lang.InterruptedException e) {
                e = e;
                LOG.error("Error pinging server due to unexpected error", e);
            } catch (java.util.concurrent.ExecutionException e2) {
                e = e2;
                LOG.error("Error pinging server due to unexpected error", e);
            } catch (java.util.concurrent.TimeoutException unused) {
                LOG.warn("Error pinging server (attempt: " + i3 + ", timeout: " + i2 + "). ");
            }
            if (((java.lang.Boolean) this.pingExecutor.submit(new com.alimm.tanx.core.view.player.cache.videocache.Pinger.PingCallable(this, null)).get(i2, java.util.concurrent.TimeUnit.MILLISECONDS)).booleanValue()) {
                return true;
            }
            i3++;
            i2 *= 2;
        }
        java.lang.String format = java.lang.String.format(java.util.Locale.US, "Error pinging server (attempts: %d, max timeout: %d). If you see this message, please, report at https://github.com/danikula/AndroidVideoCache/issues/134. Default proxies are: %s", java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i2 / 2), getDefaultProxies());
        LOG.error(format, new com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException(format));
        return false;
    }

    public void responseToPing(java.net.Socket socket) throws java.io.IOException {
        java.io.OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write(PING_RESPONSE.getBytes());
    }
}
