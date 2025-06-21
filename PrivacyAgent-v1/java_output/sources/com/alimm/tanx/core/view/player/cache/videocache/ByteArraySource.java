package com.alimm.tanx.core.view.player.cache.videocache;

/* loaded from: classes.dex */
public class ByteArraySource implements com.alimm.tanx.core.view.player.cache.videocache.Source {
    private java.io.ByteArrayInputStream arrayInputStream;
    private final byte[] data;

    public ByteArraySource(byte[] bArr) {
        this.data = bArr;
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Source
    public void close() throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Source
    public long length() throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
        return this.data.length;
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Source
    public void open(long j) throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
        java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(this.data);
        this.arrayInputStream = byteArrayInputStream;
        byteArrayInputStream.skip(j);
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Source
    public int read(byte[] bArr) throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
        return this.arrayInputStream.read(bArr, 0, bArr.length);
    }
}
