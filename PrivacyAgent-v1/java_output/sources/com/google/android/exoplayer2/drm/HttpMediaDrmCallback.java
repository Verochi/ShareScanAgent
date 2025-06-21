package com.google.android.exoplayer2.drm;

/* loaded from: classes22.dex */
public final class HttpMediaDrmCallback implements com.google.android.exoplayer2.drm.MediaDrmCallback {
    public final com.google.android.exoplayer2.upstream.HttpDataSource.Factory a;
    public final java.lang.String b;
    public final boolean c;
    public final java.util.Map<java.lang.String, java.lang.String> d;

    public HttpMediaDrmCallback(java.lang.String str, com.google.android.exoplayer2.upstream.HttpDataSource.Factory factory) {
        this(str, false, factory);
    }

    public HttpMediaDrmCallback(java.lang.String str, boolean z, com.google.android.exoplayer2.upstream.HttpDataSource.Factory factory) {
        this.a = factory;
        this.b = str;
        this.c = z;
        this.d = new java.util.HashMap();
    }

    public static byte[] a(com.google.android.exoplayer2.upstream.HttpDataSource.Factory factory, java.lang.String str, @androidx.annotation.Nullable byte[] bArr, java.util.Map<java.lang.String, java.lang.String> map) throws com.google.android.exoplayer2.drm.MediaDrmCallbackException {
        com.google.android.exoplayer2.upstream.StatsDataSource statsDataSource = new com.google.android.exoplayer2.upstream.StatsDataSource(factory.createDataSource());
        com.google.android.exoplayer2.upstream.DataSpec build = new com.google.android.exoplayer2.upstream.DataSpec.Builder().setUri(str).setHttpRequestHeaders(map).setHttpMethod(2).setHttpBody(bArr).setFlags(1).build();
        int i = 0;
        com.google.android.exoplayer2.upstream.DataSpec dataSpec = build;
        while (true) {
            try {
                com.google.android.exoplayer2.upstream.DataSourceInputStream dataSourceInputStream = new com.google.android.exoplayer2.upstream.DataSourceInputStream(statsDataSource, dataSpec);
                try {
                    return com.google.android.exoplayer2.util.Util.toByteArray(dataSourceInputStream);
                } catch (com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException e) {
                    java.lang.String b = b(e, i);
                    if (b == null) {
                        throw e;
                    }
                    i++;
                    dataSpec = dataSpec.buildUpon().setUri(b).build();
                } finally {
                    com.google.android.exoplayer2.util.Util.closeQuietly(dataSourceInputStream);
                }
            } catch (java.lang.Exception e2) {
                throw new com.google.android.exoplayer2.drm.MediaDrmCallbackException(build, (android.net.Uri) com.google.android.exoplayer2.util.Assertions.checkNotNull(statsDataSource.getLastOpenedUri()), statsDataSource.getResponseHeaders(), statsDataSource.getBytesRead(), e2);
            }
        }
    }

    @androidx.annotation.Nullable
    public static java.lang.String b(com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException invalidResponseCodeException, int i) {
        java.util.Map<java.lang.String, java.util.List<java.lang.String>> map;
        java.util.List<java.lang.String> list;
        int i2 = invalidResponseCodeException.responseCode;
        if (!((i2 == 307 || i2 == 308) && i < 5) || (map = invalidResponseCodeException.headerFields) == null || (list = map.get("Location")) == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public void clearAllKeyRequestProperties() {
        synchronized (this.d) {
            this.d.clear();
        }
    }

    public void clearKeyRequestProperty(java.lang.String str) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(str);
        synchronized (this.d) {
            this.d.remove(str);
        }
    }

    @Override // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] executeKeyRequest(java.util.UUID uuid, com.google.android.exoplayer2.drm.ExoMediaDrm.KeyRequest keyRequest) throws com.google.android.exoplayer2.drm.MediaDrmCallbackException {
        java.lang.String licenseServerUrl = keyRequest.getLicenseServerUrl();
        if (this.c || android.text.TextUtils.isEmpty(licenseServerUrl)) {
            licenseServerUrl = this.b;
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        java.util.UUID uuid2 = com.google.android.exoplayer2.C.PLAYREADY_UUID;
        hashMap.put("Content-Type", uuid2.equals(uuid) ? "text/xml" : com.google.android.exoplayer2.C.CLEARKEY_UUID.equals(uuid) ? com.baidu.mobads.sdk.internal.am.d : com.alibaba.sdk.android.oss.common.OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        if (uuid2.equals(uuid)) {
            hashMap.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (this.d) {
            hashMap.putAll(this.d);
        }
        return a(this.a, licenseServerUrl, keyRequest.getData(), hashMap);
    }

    @Override // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] executeProvisionRequest(java.util.UUID uuid, com.google.android.exoplayer2.drm.ExoMediaDrm.ProvisionRequest provisionRequest) throws com.google.android.exoplayer2.drm.MediaDrmCallbackException {
        java.lang.String defaultUrl = provisionRequest.getDefaultUrl();
        java.lang.String fromUtf8Bytes = com.google.android.exoplayer2.util.Util.fromUtf8Bytes(provisionRequest.getData());
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(defaultUrl).length() + 15 + java.lang.String.valueOf(fromUtf8Bytes).length());
        sb.append(defaultUrl);
        sb.append("&signedRequest=");
        sb.append(fromUtf8Bytes);
        return a(this.a, sb.toString(), null, java.util.Collections.emptyMap());
    }

    public void setKeyRequestProperty(java.lang.String str, java.lang.String str2) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(str);
        com.google.android.exoplayer2.util.Assertions.checkNotNull(str2);
        synchronized (this.d) {
            this.d.put(str, str2);
        }
    }
}
