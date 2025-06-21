package com.alimm.tanx.core.view.player.cache.videocache.file;

/* loaded from: classes.dex */
public class TotalCountLruDiskUsage extends com.alimm.tanx.core.view.player.cache.videocache.file.LruDiskUsage {
    private final int maxCount;

    public TotalCountLruDiskUsage(int i) {
        if (i <= 0) {
            throw new java.lang.IllegalArgumentException("Max count must be positive number!");
        }
        this.maxCount = i;
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.file.LruDiskUsage
    public boolean accept(java.io.File file, long j, int i) {
        return i <= this.maxCount;
    }
}
