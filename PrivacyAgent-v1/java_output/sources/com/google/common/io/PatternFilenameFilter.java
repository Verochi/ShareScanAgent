package com.google.common.io;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class PatternFilenameFilter implements java.io.FilenameFilter {
    public final java.util.regex.Pattern a;

    public PatternFilenameFilter(java.lang.String str) {
        this(java.util.regex.Pattern.compile(str));
    }

    public PatternFilenameFilter(java.util.regex.Pattern pattern) {
        this.a = (java.util.regex.Pattern) com.google.common.base.Preconditions.checkNotNull(pattern);
    }

    @Override // java.io.FilenameFilter
    public boolean accept(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.io.File file, java.lang.String str) {
        return this.a.matcher(str).matches();
    }
}
