package com.efs.sdk.base.core.cache;

/* loaded from: classes22.dex */
public final class a {
    private java.util.concurrent.ConcurrentHashMap<java.lang.Byte, com.efs.sdk.base.core.cache.d> a = new java.util.concurrent.ConcurrentHashMap<>();

    @androidx.annotation.Nullable
    public final com.efs.sdk.base.core.cache.d a(byte b) {
        if (!this.a.containsKey(java.lang.Byte.valueOf(b))) {
            if (b == 1) {
                this.a.putIfAbsent(java.lang.Byte.valueOf(b), new com.efs.sdk.base.core.cache.e());
            } else if (b != 2) {
                com.efs.sdk.base.core.util.Log.w("efs.cache", "Cache module not support protocol ".concat(java.lang.String.valueOf((int) b)));
            } else {
                this.a.putIfAbsent(java.lang.Byte.valueOf(b), new com.efs.sdk.base.core.cache.c());
            }
        }
        return this.a.get(java.lang.Byte.valueOf(b));
    }
}
