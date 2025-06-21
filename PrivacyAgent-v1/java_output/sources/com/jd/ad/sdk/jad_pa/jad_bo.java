package com.jd.ad.sdk.jad_pa;

/* loaded from: classes23.dex */
public class jad_bo implements java.io.FilenameFilter {
    public final /* synthetic */ java.util.regex.Pattern jad_an;

    public jad_bo(java.util.regex.Pattern pattern) {
        this.jad_an = pattern;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(java.io.File file, java.lang.String str) {
        return this.jad_an.matcher(str).matches();
    }
}
