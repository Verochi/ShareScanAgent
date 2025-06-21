package com.google.android.gms.common;

/* loaded from: classes22.dex */
final class zzn extends com.google.android.gms.common.zzl {
    public final java.util.concurrent.Callable<java.lang.String> e;

    public zzn(java.util.concurrent.Callable<java.lang.String> callable) {
        super(false, null, null);
        this.e = callable;
    }

    public /* synthetic */ zzn(java.util.concurrent.Callable callable, com.google.android.gms.common.zzo zzoVar) {
        this(callable);
    }

    @Override // com.google.android.gms.common.zzl
    public final java.lang.String f() {
        try {
            return this.e.call();
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }
}
