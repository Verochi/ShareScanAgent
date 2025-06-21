package com.aliyun.common.stream;

/* loaded from: classes.dex */
public class ClosedInputStream extends java.io.InputStream {
    public static final com.aliyun.common.stream.ClosedInputStream CLOSED_INPUT_STREAM = new com.aliyun.common.stream.ClosedInputStream();

    @Override // java.io.InputStream
    public int read() {
        return -1;
    }
}
