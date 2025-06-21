package com.aliyun.vod.common.stream;

/* loaded from: classes12.dex */
public class ClosedInputStream extends java.io.InputStream {
    public static final com.aliyun.vod.common.stream.ClosedInputStream CLOSED_INPUT_STREAM = new com.aliyun.vod.common.stream.ClosedInputStream();

    @Override // java.io.InputStream
    public int read() {
        return -1;
    }
}
