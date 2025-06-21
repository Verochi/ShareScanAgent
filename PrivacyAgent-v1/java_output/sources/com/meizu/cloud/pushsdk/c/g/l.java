package com.meizu.cloud.pushsdk.c.g;

/* loaded from: classes23.dex */
public interface l extends java.io.Closeable, java.io.Flushable {
    void a(com.meizu.cloud.pushsdk.c.g.b bVar, long j) throws java.io.IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.c.g.m
    void close() throws java.io.IOException;

    void flush() throws java.io.IOException;
}
