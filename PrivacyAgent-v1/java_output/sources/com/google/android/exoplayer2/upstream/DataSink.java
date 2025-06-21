package com.google.android.exoplayer2.upstream;

/* loaded from: classes22.dex */
public interface DataSink {

    public interface Factory {
        com.google.android.exoplayer2.upstream.DataSink createDataSink();
    }

    void close() throws java.io.IOException;

    void open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws java.io.IOException;

    void write(byte[] bArr, int i, int i2) throws java.io.IOException;
}
