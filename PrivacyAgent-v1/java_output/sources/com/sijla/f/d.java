package com.sijla.f;

/* loaded from: classes19.dex */
final class d implements java.io.FileFilter {
    @Override // java.io.FileFilter
    public final boolean accept(java.io.File file) {
        return file.isFile() && file.getName().startsWith("qt.csv.");
    }
}
