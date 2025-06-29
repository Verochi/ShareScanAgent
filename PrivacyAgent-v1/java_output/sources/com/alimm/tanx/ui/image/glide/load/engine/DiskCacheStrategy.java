package com.alimm.tanx.ui.image.glide.load.engine;

/* loaded from: classes.dex */
public enum DiskCacheStrategy {
    ALL(true, true),
    NONE(false, false),
    SOURCE(true, false),
    RESULT(false, true);

    private final boolean cacheResult;
    private final boolean cacheSource;

    DiskCacheStrategy(boolean z, boolean z2) {
        this.cacheSource = z;
        this.cacheResult = z2;
    }

    public boolean cacheResult() {
        return this.cacheResult;
    }

    public boolean cacheSource() {
        return this.cacheSource;
    }
}
