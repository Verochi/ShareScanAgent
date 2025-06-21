package com.google.android.exoplayer2.upstream;

/* loaded from: classes22.dex */
public interface DataSource extends com.google.android.exoplayer2.upstream.DataReader {

    public interface Factory {
        com.google.android.exoplayer2.upstream.DataSource createDataSource();
    }

    void addTransferListener(com.google.android.exoplayer2.upstream.TransferListener transferListener);

    void close() throws java.io.IOException;

    java.util.Map<java.lang.String, java.util.List<java.lang.String>> getResponseHeaders();

    @androidx.annotation.Nullable
    android.net.Uri getUri();

    long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws java.io.IOException;
}
