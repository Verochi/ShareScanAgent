package com.alimm.tanx.core.view.player.cache.videocache.file;

/* loaded from: classes.dex */
public class TotalSizeLruDiskUsage extends com.alimm.tanx.core.view.player.cache.videocache.file.LruDiskUsage {
    private final long maxSize;

    public TotalSizeLruDiskUsage(long j) {
        if (j <= 0) {
            throw new java.lang.IllegalArgumentException("Max size must be positive number!");
        }
        this.maxSize = j;
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.file.LruDiskUsage
    public boolean accept(java.io.File file, long j, int i) {
        return j <= this.maxSize;
    }
}
