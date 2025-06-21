package okhttp3.internal.http;

/* loaded from: classes24.dex */
public final class RetryAndFollowUpInterceptor implements okhttp3.Interceptor {
    public final okhttp3.OkHttpClient a;

    public RetryAndFollowUpInterceptor(okhttp3.OkHttpClient okHttpClient) {
        this.a = okHttpClient;
    }

    public final okhttp3.Request a(okhttp3.Response response, @javax.annotation.Nullable okhttp3.Route route) throws java.io.IOException {
        java.lang.String header;
        okhttp3.HttpUrl resolve;
        if (response == null) {
            throw new java.lang.IllegalStateException();
        }
        int code = response.code();
        java.lang.String method = response.request().method();
        if (code == 307 || code == 308) {
            if (!method.equals("GET") && !method.equals("HEAD")) {
                return null;
            }
        } else {
            if (code == 401) {
                return this.a.authenticator().authenticate(route, response);
            }
            if (code == 503) {
                if ((response.priorResponse() == null || response.priorResponse().code() != 503) && e(response, Integer.MAX_VALUE) == 0) {
                    return response.request();
                }
                return null;
            }
            if (code == 407) {
                if ((route != null ? route.proxy() : this.a.proxy()).type() == java.net.Proxy.Type.HTTP) {
                    return this.a.proxyAuthenticator().authenticate(route, response);
                }
                throw new java.net.ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (code == 408) {
                if (!this.a.retryOnConnectionFailure()) {
                    return null;
                }
                okhttp3.RequestBody body = response.request().body();
                if (body != null && body.isOneShot()) {
                    return null;
                }
                if ((response.priorResponse() == null || response.priorResponse().code() != 408) && e(response, 0) <= 0) {
                    return response.request();
                }
                return null;
            }
            switch (code) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        if (!this.a.followRedirects() || (header = response.header("Location")) == null || (resolve = response.request().url().resolve(header)) == null) {
            return null;
        }
        if (!resolve.scheme().equals(response.request().url().scheme()) && !this.a.followSslRedirects()) {
            return null;
        }
        okhttp3.Request.Builder newBuilder = response.request().newBuilder();
        if (okhttp3.internal.http.HttpMethod.permitsRequestBody(method)) {
            boolean redirectsWithBody = okhttp3.internal.http.HttpMethod.redirectsWithBody(method);
            if (okhttp3.internal.http.HttpMethod.redirectsToGet(method)) {
                newBuilder.method("GET", null);
            } else {
                newBuilder.method(method, redirectsWithBody ? response.request().body() : null);
            }
            if (!redirectsWithBody) {
                newBuilder.removeHeader("Transfer-Encoding");
                newBuilder.removeHeader("Content-Length");
                newBuilder.removeHeader("Content-Type");
            }
        }
        if (!okhttp3.internal.Util.sameConnection(response.request().url(), resolve)) {
            newBuilder.removeHeader("Authorization");
        }
        return newBuilder.url(resolve).build();
    }

    public final boolean b(java.io.IOException iOException, boolean z) {
        if (iOException instanceof java.net.ProtocolException) {
            return false;
        }
        return iOException instanceof java.io.InterruptedIOException ? (iOException instanceof java.net.SocketTimeoutException) && !z : (((iOException instanceof javax.net.ssl.SSLHandshakeException) && (iOException.getCause() instanceof java.security.cert.CertificateException)) || (iOException instanceof javax.net.ssl.SSLPeerUnverifiedException)) ? false : true;
    }

    public final boolean c(java.io.IOException iOException, okhttp3.internal.connection.Transmitter transmitter, boolean z, okhttp3.Request request) {
        if (this.a.retryOnConnectionFailure()) {
            return !(z && d(iOException, request)) && b(iOException, z) && transmitter.canRetry();
        }
        return false;
    }

    public final boolean d(java.io.IOException iOException, okhttp3.Request request) {
        okhttp3.RequestBody body = request.body();
        return (body != null && body.isOneShot()) || (iOException instanceof java.io.FileNotFoundException);
    }

    public final int e(okhttp3.Response response, int i) {
        java.lang.String header = response.header(com.google.common.net.HttpHeaders.RETRY_AFTER);
        if (header == null) {
            return i;
        }
        if (header.matches("\\d+")) {
            return java.lang.Integer.valueOf(header).intValue();
        }
        return Integer.MAX_VALUE;
    }

    @Override // okhttp3.Interceptor
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws java.io.IOException {
        okhttp3.internal.connection.Exchange exchange;
        okhttp3.Request a;
        okhttp3.Request request = chain.request();
        okhttp3.internal.http.RealInterceptorChain realInterceptorChain = (okhttp3.internal.http.RealInterceptorChain) chain;
        okhttp3.internal.connection.Transmitter transmitter = realInterceptorChain.transmitter();
        okhttp3.Response response = null;
        int i = 0;
        while (true) {
            transmitter.prepareToConnect(request);
            if (transmitter.isCanceled()) {
                throw new java.io.IOException("Canceled");
            }
            try {
                try {
                    okhttp3.Response proceed = realInterceptorChain.proceed(request, transmitter, null);
                    if (response != null) {
                        proceed = proceed.newBuilder().priorResponse(response.newBuilder().body(null).build()).build();
                    }
                    response = proceed;
                    exchange = okhttp3.internal.Internal.instance.exchange(response);
                    a = a(response, exchange != null ? exchange.connection().route() : null);
                } catch (java.io.IOException e) {
                    if (!c(e, transmitter, !(e instanceof okhttp3.internal.http2.ConnectionShutdownException), request)) {
                        throw e;
                    }
                } catch (okhttp3.internal.connection.RouteException e2) {
                    if (!c(e2.getLastConnectException(), transmitter, false, request)) {
                        throw e2.getFirstConnectException();
                    }
                }
                if (a == null) {
                    if (exchange != null && exchange.isDuplex()) {
                        transmitter.timeoutEarlyExit();
                    }
                    return response;
                }
                okhttp3.RequestBody body = a.body();
                if (body != null && body.isOneShot()) {
                    return response;
                }
                okhttp3.internal.Util.closeQuietly(response.body());
                if (transmitter.hasExchange()) {
                    exchange.detachWithViolence();
                }
                i++;
                if (i > 20) {
                    throw new java.net.ProtocolException("Too many follow-up requests: " + i);
                }
                request = a;
            } finally {
                transmitter.exchangeDoneDueToException();
            }
        }
    }
}
