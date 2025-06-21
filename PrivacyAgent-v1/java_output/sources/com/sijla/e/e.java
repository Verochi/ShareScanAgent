package com.sijla.e;

/* loaded from: classes19.dex */
final class e implements java.io.FileFilter {
    private /* synthetic */ com.sijla.e.d a;

    public e(com.sijla.e.d dVar) {
        this.a = dVar;
    }

    @Override // java.io.FileFilter
    public final boolean accept(java.io.File file) {
        java.lang.String name = file.getName();
        return name.startsWith("qfs") && name.endsWith("gz");
    }
}
