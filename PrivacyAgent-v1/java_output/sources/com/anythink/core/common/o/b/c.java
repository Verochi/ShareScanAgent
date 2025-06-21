package com.anythink.core.common.o.b;

/* loaded from: classes12.dex */
public final class c implements java.util.concurrent.ThreadFactory {
    private static java.lang.Thread a(java.lang.Runnable runnable) {
        return java.util.concurrent.Executors.defaultThreadFactory().newThread(runnable);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final java.lang.Thread newThread(java.lang.Runnable runnable) {
        return java.util.concurrent.Executors.defaultThreadFactory().newThread(runnable);
    }
}
