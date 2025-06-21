package com.alimm.tanx.core.view.player.cache.videocache;

/* loaded from: classes.dex */
class IgnoreHostProxySelector extends java.net.ProxySelector {
    private static final java.util.List<java.net.Proxy> NO_PROXY_LIST = java.util.Arrays.asList(java.net.Proxy.NO_PROXY);
    private final java.net.ProxySelector defaultProxySelector;
    private final java.lang.String hostToIgnore;
    private final int portToIgnore;

    public IgnoreHostProxySelector(java.net.ProxySelector proxySelector, java.lang.String str, int i) {
        this.defaultProxySelector = (java.net.ProxySelector) com.alimm.tanx.core.view.player.cache.videocache.Preconditions.checkNotNull(proxySelector);
        this.hostToIgnore = (java.lang.String) com.alimm.tanx.core.view.player.cache.videocache.Preconditions.checkNotNull(str);
        this.portToIgnore = i;
    }

    public static void install(java.lang.String str, int i) {
        java.net.ProxySelector.setDefault(new com.alimm.tanx.core.view.player.cache.videocache.IgnoreHostProxySelector(java.net.ProxySelector.getDefault(), str, i));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(java.net.URI uri, java.net.SocketAddress socketAddress, java.io.IOException iOException) {
        this.defaultProxySelector.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public java.util.List<java.net.Proxy> select(java.net.URI uri) {
        return this.hostToIgnore.equals(uri.getHost()) && this.portToIgnore == uri.getPort() ? NO_PROXY_LIST : this.defaultProxySelector.select(uri);
    }
}
