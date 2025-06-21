package com.anythink.expressad.exoplayer.k;

/* loaded from: classes12.dex */
public final class l {
    private java.lang.String[] a;
    private boolean b;
    private boolean c;

    private l(java.lang.String... strArr) {
        this.a = strArr;
    }

    private void a(java.lang.String... strArr) {
        com.anythink.expressad.exoplayer.k.a.b(!this.b, "Cannot set libraries after loading");
        this.a = strArr;
    }

    private boolean a() {
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
        }
        return this.c;
    }
}
