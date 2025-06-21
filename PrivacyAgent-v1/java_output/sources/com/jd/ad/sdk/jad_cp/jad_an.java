package com.jd.ad.sdk.jad_cp;

/* loaded from: classes23.dex */
public final class jad_an implements java.io.FileFilter {
    @Override // java.io.FileFilter
    public final boolean accept(java.io.File file) {
        return java.util.regex.Pattern.matches("cpu[0-9]+", file.getName());
    }
}
