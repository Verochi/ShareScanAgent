package com.google.android.exoplayer2.upstream;

/* loaded from: classes22.dex */
public final class ResolvingDataSource implements com.google.android.exoplayer2.upstream.DataSource {
    public final com.google.android.exoplayer2.upstream.DataSource a;
    public final com.google.android.exoplayer2.upstream.ResolvingDataSource.Resolver b;
    public boolean c;

    public static final class Factory implements com.google.android.exoplayer2.upstream.DataSource.Factory {
        public final com.google.android.exoplayer2.upstream.DataSource.Factory a;
        public final com.google.android.exoplayer2.upstream.ResolvingDataSource.Resolver b;

        public Factory(com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.upstream.ResolvingDataSource.Resolver resolver) {
            this.a = factory;
            this.b = resolver;
        }

        @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
        public com.google.android.exoplayer2.upstream.ResolvingDataSource createDataSource() {
            return new com.google.android.exoplayer2.upstream.ResolvingDataSource(this.a.createDataSource(), this.b);
        }
    }

    public interface Resolver {
        com.google.android.exoplayer2.upstream.DataSpec resolveDataSpec(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws java.io.IOException;

        android.net.Uri resolveReportedUri(android.net.Uri uri);
    }

    public ResolvingDataSource(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.ResolvingDataSource.Resolver resolver) {
        this.a = dataSource;
        this.b = resolver;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(transferListener);
        this.a.addTransferListener(transferListener);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws java.io.IOException {
        if (this.c) {
            this.c = false;
            this.a.close();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getResponseHeaders() {
        return this.a.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @androidx.annotation.Nullable
    public android.net.Uri getUri() {
        android.net.Uri uri = this.a.getUri();
        if (uri == null) {
            return null;
        }
        return this.b.resolveReportedUri(uri);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws java.io.IOException {
        com.google.android.exoplayer2.upstream.DataSpec resolveDataSpec = this.b.resolveDataSpec(dataSpec);
        this.c = true;
        return this.a.open(resolveDataSpec);
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        return this.a.read(bArr, i, i2);
    }
}
