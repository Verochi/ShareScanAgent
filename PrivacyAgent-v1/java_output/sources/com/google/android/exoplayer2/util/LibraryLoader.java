package com.google.android.exoplayer2.util;

/* loaded from: classes22.dex */
public final class LibraryLoader {
    public java.lang.String[] a;
    public boolean b;
    public boolean c;

    public LibraryLoader(java.lang.String... strArr) {
        this.a = strArr;
    }

    public synchronized boolean isAvailable() {
        if (this.b) {
            return this.c;
        }
        this.b = true;
        try {
            for (java.lang.String str : this.a) {
                java.lang.System.loadLibrary(str);
            }
            this.c = true;
        } catch (java.lang.UnsatisfiedLinkError unused) {
            java.lang.String valueOf = java.lang.String.valueOf(java.util.Arrays.toString(this.a));
            com.google.android.exoplayer2.util.Log.w("LibraryLoader", valueOf.length() != 0 ? "Failed to load ".concat(valueOf) : new java.lang.String("Failed to load "));
        }
        return this.c;
    }

    public synchronized void setLibraries(java.lang.String... strArr) {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.b, "Cannot set libraries after loading");
        this.a = strArr;
    }
}
