package com.google.android.exoplayer2.upstream;

/* loaded from: classes22.dex */
public final class DefaultDataSource implements com.google.android.exoplayer2.upstream.DataSource {
    public final android.content.Context a;
    public final java.util.List<com.google.android.exoplayer2.upstream.TransferListener> b;
    public final com.google.android.exoplayer2.upstream.DataSource c;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.upstream.DataSource d;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.upstream.DataSource e;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.upstream.DataSource f;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.upstream.DataSource g;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.upstream.DataSource h;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.upstream.DataSource i;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.upstream.DataSource j;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.upstream.DataSource k;

    public DefaultDataSource(android.content.Context context, com.google.android.exoplayer2.upstream.DataSource dataSource) {
        this.a = context.getApplicationContext();
        this.c = (com.google.android.exoplayer2.upstream.DataSource) com.google.android.exoplayer2.util.Assertions.checkNotNull(dataSource);
        this.b = new java.util.ArrayList();
    }

    public DefaultDataSource(android.content.Context context, java.lang.String str, int i, int i2, boolean z) {
        this(context, new com.google.android.exoplayer2.upstream.DefaultHttpDataSource(str, i, i2, z, null));
    }

    public DefaultDataSource(android.content.Context context, java.lang.String str, boolean z) {
        this(context, str, 8000, 8000, z);
    }

    public DefaultDataSource(android.content.Context context, boolean z) {
        this(context, com.google.android.exoplayer2.ExoPlayerLibraryInfo.DEFAULT_USER_AGENT, 8000, 8000, z);
    }

    public final void a(com.google.android.exoplayer2.upstream.DataSource dataSource) {
        for (int i = 0; i < this.b.size(); i++) {
            dataSource.addTransferListener(this.b.get(i));
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(transferListener);
        this.c.addTransferListener(transferListener);
        this.b.add(transferListener);
        i(this.d, transferListener);
        i(this.e, transferListener);
        i(this.f, transferListener);
        i(this.g, transferListener);
        i(this.h, transferListener);
        i(this.i, transferListener);
        i(this.j, transferListener);
    }

    public final com.google.android.exoplayer2.upstream.DataSource b() {
        if (this.e == null) {
            com.google.android.exoplayer2.upstream.AssetDataSource assetDataSource = new com.google.android.exoplayer2.upstream.AssetDataSource(this.a);
            this.e = assetDataSource;
            a(assetDataSource);
        }
        return this.e;
    }

    public final com.google.android.exoplayer2.upstream.DataSource c() {
        if (this.f == null) {
            com.google.android.exoplayer2.upstream.ContentDataSource contentDataSource = new com.google.android.exoplayer2.upstream.ContentDataSource(this.a);
            this.f = contentDataSource;
            a(contentDataSource);
        }
        return this.f;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws java.io.IOException {
        com.google.android.exoplayer2.upstream.DataSource dataSource = this.k;
        if (dataSource != null) {
            try {
                dataSource.close();
            } finally {
                this.k = null;
            }
        }
    }

    public final com.google.android.exoplayer2.upstream.DataSource d() {
        if (this.i == null) {
            com.google.android.exoplayer2.upstream.DataSchemeDataSource dataSchemeDataSource = new com.google.android.exoplayer2.upstream.DataSchemeDataSource();
            this.i = dataSchemeDataSource;
            a(dataSchemeDataSource);
        }
        return this.i;
    }

    public final com.google.android.exoplayer2.upstream.DataSource e() {
        if (this.d == null) {
            com.google.android.exoplayer2.upstream.FileDataSource fileDataSource = new com.google.android.exoplayer2.upstream.FileDataSource();
            this.d = fileDataSource;
            a(fileDataSource);
        }
        return this.d;
    }

    public final com.google.android.exoplayer2.upstream.DataSource f() {
        if (this.j == null) {
            com.google.android.exoplayer2.upstream.RawResourceDataSource rawResourceDataSource = new com.google.android.exoplayer2.upstream.RawResourceDataSource(this.a);
            this.j = rawResourceDataSource;
            a(rawResourceDataSource);
        }
        return this.j;
    }

    public final com.google.android.exoplayer2.upstream.DataSource g() {
        if (this.g == null) {
            try {
                com.google.android.exoplayer2.upstream.DataSource dataSource = (com.google.android.exoplayer2.upstream.DataSource) java.lang.Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]);
                this.g = dataSource;
                a(dataSource);
            } catch (java.lang.ClassNotFoundException unused) {
                com.google.android.exoplayer2.util.Log.w("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (java.lang.Exception e) {
                throw new java.lang.RuntimeException("Error instantiating RTMP extension", e);
            }
            if (this.g == null) {
                this.g = this.c;
            }
        }
        return this.g;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getResponseHeaders() {
        com.google.android.exoplayer2.upstream.DataSource dataSource = this.k;
        return dataSource == null ? java.util.Collections.emptyMap() : dataSource.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @androidx.annotation.Nullable
    public android.net.Uri getUri() {
        com.google.android.exoplayer2.upstream.DataSource dataSource = this.k;
        if (dataSource == null) {
            return null;
        }
        return dataSource.getUri();
    }

    public final com.google.android.exoplayer2.upstream.DataSource h() {
        if (this.h == null) {
            com.google.android.exoplayer2.upstream.UdpDataSource udpDataSource = new com.google.android.exoplayer2.upstream.UdpDataSource();
            this.h = udpDataSource;
            a(udpDataSource);
        }
        return this.h;
    }

    public final void i(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        if (dataSource != null) {
            dataSource.addTransferListener(transferListener);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws java.io.IOException {
        com.google.android.exoplayer2.util.Assertions.checkState(this.k == null);
        java.lang.String scheme = dataSpec.uri.getScheme();
        if (com.google.android.exoplayer2.util.Util.isLocalFileUri(dataSpec.uri)) {
            java.lang.String path = dataSpec.uri.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                this.k = e();
            } else {
                this.k = b();
            }
        } else if ("asset".equals(scheme)) {
            this.k = b();
        } else if ("content".equals(scheme)) {
            this.k = c();
        } else if ("rtmp".equals(scheme)) {
            this.k = g();
        } else if ("udp".equals(scheme)) {
            this.k = h();
        } else if ("data".equals(scheme)) {
            this.k = d();
        } else if ("rawresource".equals(scheme) || "android.resource".equals(scheme)) {
            this.k = f();
        } else {
            this.k = this.c;
        }
        return this.k.open(dataSpec);
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        return ((com.google.android.exoplayer2.upstream.DataSource) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.k)).read(bArr, i, i2);
    }
}
