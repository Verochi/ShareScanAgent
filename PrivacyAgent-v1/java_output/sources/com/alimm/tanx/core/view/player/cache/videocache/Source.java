package com.alimm.tanx.core.view.player.cache.videocache;

/* loaded from: classes.dex */
public interface Source {
    void close() throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException;

    long length() throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException;

    void open(long j) throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException;

    int read(byte[] bArr) throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException;
}
