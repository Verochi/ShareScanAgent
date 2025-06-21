package com.google.android.exoplayer2.upstream;

@java.lang.Deprecated
/* loaded from: classes22.dex */
public final class FileDataSourceFactory implements com.google.android.exoplayer2.upstream.DataSource.Factory {
    public final com.google.android.exoplayer2.upstream.FileDataSource.Factory a;

    public FileDataSourceFactory() {
        this(null);
    }

    public FileDataSourceFactory(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        this.a = new com.google.android.exoplayer2.upstream.FileDataSource.Factory().setListener(transferListener);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
    public com.google.android.exoplayer2.upstream.FileDataSource createDataSource() {
        return this.a.createDataSource();
    }
}
