package com.alimm.tanx.core.view.player.cache.videocache;

/* loaded from: classes.dex */
class Config {
    public final java.io.File cacheRoot;
    public final com.alimm.tanx.core.view.player.cache.videocache.file.DiskUsage diskUsage;
    public final com.alimm.tanx.core.view.player.cache.videocache.file.FileNameGenerator fileNameGenerator;
    public final com.alimm.tanx.core.view.player.cache.videocache.headers.HeaderInjector headerInjector;
    public final com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.SourceInfoStorage sourceInfoStorage;

    public Config(java.io.File file, com.alimm.tanx.core.view.player.cache.videocache.file.FileNameGenerator fileNameGenerator, com.alimm.tanx.core.view.player.cache.videocache.file.DiskUsage diskUsage, com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.SourceInfoStorage sourceInfoStorage, com.alimm.tanx.core.view.player.cache.videocache.headers.HeaderInjector headerInjector) {
        this.cacheRoot = file;
        this.fileNameGenerator = fileNameGenerator;
        this.diskUsage = diskUsage;
        this.sourceInfoStorage = sourceInfoStorage;
        this.headerInjector = headerInjector;
    }

    public java.io.File generateCacheFile(java.lang.String str) {
        return new java.io.File(this.cacheRoot, this.fileNameGenerator.generate(str));
    }
}
