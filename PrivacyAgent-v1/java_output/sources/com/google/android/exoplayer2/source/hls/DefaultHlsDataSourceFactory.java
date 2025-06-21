package com.google.android.exoplayer2.source.hls;

/* loaded from: classes22.dex */
public final class DefaultHlsDataSourceFactory implements com.google.android.exoplayer2.source.hls.HlsDataSourceFactory {
    public final com.google.android.exoplayer2.upstream.DataSource.Factory a;

    public DefaultHlsDataSourceFactory(com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
        this.a = factory;
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsDataSourceFactory
    public com.google.android.exoplayer2.upstream.DataSource createDataSource(int i) {
        return this.a.createDataSource();
    }
}
