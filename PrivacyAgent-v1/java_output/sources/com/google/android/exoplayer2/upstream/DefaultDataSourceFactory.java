package com.google.android.exoplayer2.upstream;

/* loaded from: classes22.dex */
public final class DefaultDataSourceFactory implements com.google.android.exoplayer2.upstream.DataSource.Factory {
    public final android.content.Context a;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.upstream.TransferListener b;
    public final com.google.android.exoplayer2.upstream.DataSource.Factory c;

    public DefaultDataSourceFactory(android.content.Context context) {
        this(context, com.google.android.exoplayer2.ExoPlayerLibraryInfo.DEFAULT_USER_AGENT, (com.google.android.exoplayer2.upstream.TransferListener) null);
    }

    public DefaultDataSourceFactory(android.content.Context context, com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
        this(context, (com.google.android.exoplayer2.upstream.TransferListener) null, factory);
    }

    public DefaultDataSourceFactory(android.content.Context context, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.TransferListener transferListener, com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
        this.a = context.getApplicationContext();
        this.b = transferListener;
        this.c = factory;
    }

    public DefaultDataSourceFactory(android.content.Context context, java.lang.String str) {
        this(context, str, (com.google.android.exoplayer2.upstream.TransferListener) null);
    }

    public DefaultDataSourceFactory(android.content.Context context, java.lang.String str, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        this(context, transferListener, new com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory(str, transferListener));
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
    public com.google.android.exoplayer2.upstream.DefaultDataSource createDataSource() {
        com.google.android.exoplayer2.upstream.DefaultDataSource defaultDataSource = new com.google.android.exoplayer2.upstream.DefaultDataSource(this.a, this.c.createDataSource());
        com.google.android.exoplayer2.upstream.TransferListener transferListener = this.b;
        if (transferListener != null) {
            defaultDataSource.addTransferListener(transferListener);
        }
        return defaultDataSource;
    }
}
