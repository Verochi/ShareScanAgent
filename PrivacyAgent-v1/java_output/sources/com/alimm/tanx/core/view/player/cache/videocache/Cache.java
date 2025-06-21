package com.alimm.tanx.core.view.player.cache.videocache;

/* loaded from: classes.dex */
public interface Cache {
    void append(byte[] bArr, int i) throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException;

    long available() throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException;

    void close() throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException;

    void complete() throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException;

    boolean isCompleted();

    int read(byte[] bArr, long j, int i) throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException;
}
