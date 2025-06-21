package com.alimm.tanx.core.view.player.cache.videocache;

/* loaded from: classes.dex */
class HttpProxyCache extends com.alimm.tanx.core.view.player.cache.videocache.ProxyCache {
    private static final float NO_CACHE_BARRIER = 0.2f;
    private final com.alimm.tanx.core.view.player.cache.videocache.file.FileCache cache;
    private com.alimm.tanx.core.view.player.cache.videocache.CacheListener listener;
    private final com.alimm.tanx.core.view.player.cache.videocache.HttpUrlSource source;

    public HttpProxyCache(com.alimm.tanx.core.view.player.cache.videocache.HttpUrlSource httpUrlSource, com.alimm.tanx.core.view.player.cache.videocache.file.FileCache fileCache) {
        super(httpUrlSource, fileCache);
        this.cache = fileCache;
        this.source = httpUrlSource;
    }

    private java.lang.String format(java.lang.String str, java.lang.Object... objArr) {
        return java.lang.String.format(java.util.Locale.US, str, objArr);
    }

    private boolean isUseCache(com.alimm.tanx.core.view.player.cache.videocache.GetRequest getRequest) throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
        long length = this.source.length();
        return (((length > 0L ? 1 : (length == 0L ? 0 : -1)) > 0) && getRequest.partial && ((float) getRequest.rangeOffset) > ((float) this.cache.available()) + (((float) length) * 0.2f)) ? false : true;
    }

    private java.lang.String newResponseHeaders(com.alimm.tanx.core.view.player.cache.videocache.GetRequest getRequest) throws java.io.IOException, com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
        java.lang.String mime = this.source.getMime();
        boolean z = !android.text.TextUtils.isEmpty(mime);
        long available = this.cache.isCompleted() ? this.cache.available() : this.source.length();
        boolean z2 = available >= 0;
        boolean z3 = getRequest.partial;
        long j = z3 ? available - getRequest.rangeOffset : available;
        boolean z4 = z2 && z3;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(getRequest.partial ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        sb.append(z2 ? format("Content-Length: %d\n", java.lang.Long.valueOf(j)) : "");
        sb.append(z4 ? format("Content-Range: bytes %d-%d/%d\n", java.lang.Long.valueOf(getRequest.rangeOffset), java.lang.Long.valueOf(available - 1), java.lang.Long.valueOf(available)) : "");
        sb.append(z ? format("Content-Type: %s\n", mime) : "");
        sb.append("\n");
        return sb.toString();
    }

    private void responseWithCache(java.io.OutputStream outputStream, long j) throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException, java.io.IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int read = read(bArr, j, 8192);
            if (read == -1) {
                outputStream.flush();
                return;
            } else {
                outputStream.write(bArr, 0, read);
                j += read;
            }
        }
    }

    private void responseWithoutCache(java.io.OutputStream outputStream, long j) throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException, java.io.IOException {
        com.alimm.tanx.core.view.player.cache.videocache.HttpUrlSource httpUrlSource = new com.alimm.tanx.core.view.player.cache.videocache.HttpUrlSource(this.source);
        try {
            httpUrlSource.open((int) j);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = httpUrlSource.read(bArr);
                if (read == -1) {
                    outputStream.flush();
                    return;
                }
                outputStream.write(bArr, 0, read);
            }
        } finally {
            httpUrlSource.close();
        }
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.ProxyCache
    public void onCachePercentsAvailableChanged(int i) {
        com.alimm.tanx.core.view.player.cache.videocache.CacheListener cacheListener = this.listener;
        if (cacheListener != null) {
            cacheListener.onCacheAvailable(this.cache.file, this.source.getUrl(), i);
        }
    }

    public void processRequest(com.alimm.tanx.core.view.player.cache.videocache.GetRequest getRequest, java.net.Socket socket) throws java.io.IOException, com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
        java.io.BufferedOutputStream bufferedOutputStream = new java.io.BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(newResponseHeaders(getRequest).getBytes(java.nio.charset.StandardCharsets.UTF_8));
        long j = getRequest.rangeOffset;
        if (isUseCache(getRequest)) {
            responseWithCache(bufferedOutputStream, j);
        } else {
            responseWithoutCache(bufferedOutputStream, j);
        }
    }

    public void registerCacheListener(com.alimm.tanx.core.view.player.cache.videocache.CacheListener cacheListener) {
        this.listener = cacheListener;
    }
}
