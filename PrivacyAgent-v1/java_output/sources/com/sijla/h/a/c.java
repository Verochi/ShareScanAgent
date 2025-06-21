package com.sijla.h.a;

/* loaded from: classes19.dex */
final class c implements java.io.FileFilter {
    @Override // java.io.FileFilter
    public final boolean accept(java.io.File file) {
        return java.util.regex.Pattern.matches("cpu[0-9]+", file.getName());
    }
}
