package okhttp3.internal.proxy;

/* loaded from: classes24.dex */
public class NullProxySelector extends java.net.ProxySelector {
    @Override // java.net.ProxySelector
    public void connectFailed(java.net.URI uri, java.net.SocketAddress socketAddress, java.io.IOException iOException) {
    }

    @Override // java.net.ProxySelector
    public java.util.List<java.net.Proxy> select(java.net.URI uri) {
        if (uri != null) {
            return java.util.Collections.singletonList(java.net.Proxy.NO_PROXY);
        }
        throw new java.lang.IllegalArgumentException("uri must not be null");
    }
}
