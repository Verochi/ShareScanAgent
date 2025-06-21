package com.github.moduth.blockcanary;

/* loaded from: classes22.dex */
public final class BlockCanary {
    public static com.github.moduth.blockcanary.BlockCanary a;

    public static com.github.moduth.blockcanary.BlockCanary get() {
        if (a == null) {
            synchronized (com.github.moduth.blockcanary.BlockCanary.class) {
                if (a == null) {
                    a = new com.github.moduth.blockcanary.BlockCanary();
                }
            }
        }
        return a;
    }

    public static com.github.moduth.blockcanary.BlockCanary install(android.content.Context context, com.github.moduth.blockcanary.BlockCanaryContext blockCanaryContext) {
        com.github.moduth.blockcanary.BlockCanaryContext.a(context, blockCanaryContext);
        return get();
    }

    public boolean isMonitorDurationEnd() {
        return true;
    }

    public void recordStartTime() {
    }

    public void start() {
    }

    public void stop() {
    }

    public void upload() {
    }
}
