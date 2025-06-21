package com.alimm.tanx.core.view.player.cache.videocache;

/* loaded from: classes.dex */
public class ProxyCacheException extends java.lang.Exception {
    private static final java.lang.String LIBRARY_VERSION = ". Version:1.0";

    public ProxyCacheException(java.lang.String str) {
        super(str + LIBRARY_VERSION);
    }

    public ProxyCacheException(java.lang.String str, java.lang.Throwable th) {
        super(str + LIBRARY_VERSION, th);
    }

    public ProxyCacheException(java.lang.Throwable th) {
        super("No explanation error. Version:1.0", th);
    }
}
