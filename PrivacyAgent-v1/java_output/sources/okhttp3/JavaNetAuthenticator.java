package okhttp3;

@okhttp3.internal.annotations.EverythingIsNonNull
/* loaded from: classes23.dex */
public final class JavaNetAuthenticator implements okhttp3.Authenticator {
    public final java.net.InetAddress a(java.net.Proxy proxy, okhttp3.HttpUrl httpUrl) throws java.io.IOException {
        return (proxy == null || proxy.type() == java.net.Proxy.Type.DIRECT) ? java.net.InetAddress.getByName(httpUrl.host()) : ((java.net.InetSocketAddress) proxy.address()).getAddress();
    }

    @Override // okhttp3.Authenticator
    public okhttp3.Request authenticate(okhttp3.Route route, okhttp3.Response response) throws java.io.IOException {
        java.net.PasswordAuthentication requestPasswordAuthentication;
        java.util.List<okhttp3.Challenge> challenges = response.challenges();
        okhttp3.Request request = response.request();
        okhttp3.HttpUrl url = request.url();
        boolean z = response.code() == 407;
        java.net.Proxy proxy = route.proxy();
        int size = challenges.size();
        for (int i = 0; i < size; i++) {
            okhttp3.Challenge challenge = challenges.get(i);
            if ("Basic".equalsIgnoreCase(challenge.scheme())) {
                if (z) {
                    java.net.InetSocketAddress inetSocketAddress = (java.net.InetSocketAddress) proxy.address();
                    requestPasswordAuthentication = java.net.Authenticator.requestPasswordAuthentication(inetSocketAddress.getHostName(), a(proxy, url), inetSocketAddress.getPort(), url.scheme(), challenge.realm(), challenge.scheme(), url.url(), java.net.Authenticator.RequestorType.PROXY);
                } else {
                    requestPasswordAuthentication = java.net.Authenticator.requestPasswordAuthentication(url.host(), a(proxy, url), url.port(), url.scheme(), challenge.realm(), challenge.scheme(), url.url(), java.net.Authenticator.RequestorType.SERVER);
                }
                if (requestPasswordAuthentication != null) {
                    return request.newBuilder().header(z ? com.google.common.net.HttpHeaders.PROXY_AUTHORIZATION : "Authorization", okhttp3.Credentials.basic(requestPasswordAuthentication.getUserName(), new java.lang.String(requestPasswordAuthentication.getPassword()), challenge.charset())).build();
                }
            }
        }
        return null;
    }
}
