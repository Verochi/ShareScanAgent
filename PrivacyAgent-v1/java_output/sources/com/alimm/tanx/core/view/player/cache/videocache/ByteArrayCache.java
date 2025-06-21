package com.alimm.tanx.core.view.player.cache.videocache;

/* loaded from: classes.dex */
public class ByteArrayCache implements com.alimm.tanx.core.view.player.cache.videocache.Cache {
    private volatile boolean completed;
    private volatile byte[] data;

    public ByteArrayCache() {
        this(new byte[0]);
    }

    public ByteArrayCache(byte[] bArr) {
        this.data = (byte[]) com.alimm.tanx.core.view.player.cache.videocache.Preconditions.checkNotNull(bArr);
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public void append(byte[] bArr, int i) throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
        com.alimm.tanx.core.view.player.cache.videocache.Preconditions.checkNotNull(this.data);
        com.alimm.tanx.core.view.player.cache.videocache.Preconditions.checkArgument(i >= 0 && i <= bArr.length);
        byte[] copyOf = java.util.Arrays.copyOf(this.data, this.data.length + i);
        java.lang.System.arraycopy(bArr, 0, copyOf, this.data.length, i);
        this.data = copyOf;
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public long available() throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
        return this.data.length;
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public void close() throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public void complete() {
        this.completed = true;
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public boolean isCompleted() {
        return this.completed;
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public int read(byte[] bArr, long j, int i) throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
        if (j >= this.data.length) {
            return -1;
        }
        if (j <= 2147483647L) {
            return new java.io.ByteArrayInputStream(this.data).read(bArr, (int) j, i);
        }
        throw new java.lang.IllegalArgumentException("Too long offset for memory cache " + j);
    }
}
