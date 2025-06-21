package com.alimm.tanx.core.view.player.cache.videocache.sourcestorage;

/* loaded from: classes.dex */
public class SourceInfoStorageFactory {
    public static com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.SourceInfoStorage newEmptySourceInfoStorage() {
        return new com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.NoSourceInfoStorage();
    }

    public static com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.SourceInfoStorage newSourceInfoStorage(android.content.Context context) {
        return new com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.DatabaseSourceInfoStorage(context);
    }
}
