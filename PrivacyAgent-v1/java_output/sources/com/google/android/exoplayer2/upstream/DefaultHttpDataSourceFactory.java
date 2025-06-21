package com.google.android.exoplayer2.upstream;

/* loaded from: classes22.dex */
public final class DefaultHttpDataSourceFactory extends com.google.android.exoplayer2.upstream.HttpDataSource.BaseFactory {
    public final java.lang.String b;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.upstream.TransferListener c;
    public final int d;
    public final int e;
    public final boolean f;

    public DefaultHttpDataSourceFactory() {
        this(com.google.android.exoplayer2.ExoPlayerLibraryInfo.DEFAULT_USER_AGENT);
    }

    public DefaultHttpDataSourceFactory(java.lang.String str) {
        this(str, null);
    }

    public DefaultHttpDataSourceFactory(java.lang.String str, int i, int i2, boolean z) {
        this(str, null, i, i2, z);
    }

    public DefaultHttpDataSourceFactory(java.lang.String str, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        this(str, transferListener, 8000, 8000, false);
    }

    public DefaultHttpDataSourceFactory(java.lang.String str, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.TransferListener transferListener, int i, int i2, boolean z) {
        this.b = com.google.android.exoplayer2.util.Assertions.checkNotEmpty(str);
        this.c = transferListener;
        this.d = i;
        this.e = i2;
        this.f = z;
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource.BaseFactory
    public com.google.android.exoplayer2.upstream.DefaultHttpDataSource createDataSourceInternal(com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties requestProperties) {
        com.google.android.exoplayer2.upstream.DefaultHttpDataSource defaultHttpDataSource = new com.google.android.exoplayer2.upstream.DefaultHttpDataSource(this.b, this.d, this.e, this.f, requestProperties);
        com.google.android.exoplayer2.upstream.TransferListener transferListener = this.c;
        if (transferListener != null) {
            defaultHttpDataSource.addTransferListener(transferListener);
        }
        return defaultHttpDataSource;
    }
}
