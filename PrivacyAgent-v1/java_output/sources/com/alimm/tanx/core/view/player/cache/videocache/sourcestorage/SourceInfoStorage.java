package com.alimm.tanx.core.view.player.cache.videocache.sourcestorage;

/* loaded from: classes.dex */
public interface SourceInfoStorage {
    com.alimm.tanx.core.view.player.cache.videocache.SourceInfo get(java.lang.String str);

    void put(java.lang.String str, com.alimm.tanx.core.view.player.cache.videocache.SourceInfo sourceInfo);

    void release();
}
