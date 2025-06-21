package com.alipay.sdk.m.a0;

/* loaded from: classes.dex */
public final class c implements java.io.FileFilter {
    public final /* synthetic */ com.alipay.sdk.m.a0.b a;

    public c(com.alipay.sdk.m.a0.b bVar) {
        this.a = bVar;
    }

    @Override // java.io.FileFilter
    public final boolean accept(java.io.File file) {
        return java.util.regex.Pattern.matches("cpu[0-9]+", file.getName());
    }
}
