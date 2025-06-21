package com.anythink.expressad.exoplayer.j;

/* loaded from: classes12.dex */
public final class l implements com.anythink.expressad.exoplayer.j.b {
    private static final int a = 100;
    private final boolean b;
    private final int c;
    private final byte[] d;
    private final com.anythink.expressad.exoplayer.j.a[] e;
    private int f;
    private int g;
    private int h;
    private com.anythink.expressad.exoplayer.j.a[] i;

    private l() {
        com.anythink.expressad.exoplayer.k.a.a(true);
        com.anythink.expressad.exoplayer.k.a.a(true);
        this.b = true;
        this.c = 65536;
        this.h = 0;
        this.i = new com.anythink.expressad.exoplayer.j.a[100];
        this.d = null;
        this.e = new com.anythink.expressad.exoplayer.j.a[1];
    }

    public l(byte b) {
        this();
    }

    @Override // com.anythink.expressad.exoplayer.j.b
    public final synchronized com.anythink.expressad.exoplayer.j.a a() {
        com.anythink.expressad.exoplayer.j.a aVar;
        this.g++;
        int i = this.h;
        if (i > 0) {
            com.anythink.expressad.exoplayer.j.a[] aVarArr = this.i;
            int i2 = i - 1;
            this.h = i2;
            aVar = aVarArr[i2];
            aVarArr[i2] = null;
        } else {
            aVar = new com.anythink.expressad.exoplayer.j.a(new byte[this.c]);
        }
        return aVar;
    }

    public final synchronized void a(int i) {
        boolean z = i < this.f;
        this.f = i;
        if (z) {
            b();
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.b
    public final synchronized void a(com.anythink.expressad.exoplayer.j.a aVar) {
        com.anythink.expressad.exoplayer.j.a[] aVarArr = this.e;
        aVarArr[0] = aVar;
        a(aVarArr);
    }

    @Override // com.anythink.expressad.exoplayer.j.b
    public final synchronized void a(com.anythink.expressad.exoplayer.j.a[] aVarArr) {
        int i = this.h;
        int length = aVarArr.length + i;
        com.anythink.expressad.exoplayer.j.a[] aVarArr2 = this.i;
        if (length >= aVarArr2.length) {
            this.i = (com.anythink.expressad.exoplayer.j.a[]) java.util.Arrays.copyOf(aVarArr2, java.lang.Math.max(aVarArr2.length * 2, i + aVarArr.length));
        }
        for (com.anythink.expressad.exoplayer.j.a aVar : aVarArr) {
            byte[] bArr = aVar.a;
            if (bArr != this.d && bArr.length != this.c) {
                throw new java.lang.IllegalArgumentException("Unexpected allocation: " + java.lang.System.identityHashCode(aVar.a) + ", " + java.lang.System.identityHashCode(this.d) + ", " + aVar.a.length + ", " + this.c);
            }
            com.anythink.expressad.exoplayer.j.a[] aVarArr3 = this.i;
            int i2 = this.h;
            this.h = i2 + 1;
            aVarArr3[i2] = aVar;
        }
        this.g -= aVarArr.length;
        notifyAll();
    }

    @Override // com.anythink.expressad.exoplayer.j.b
    public final synchronized void b() {
        int i = 0;
        int max = java.lang.Math.max(0, com.anythink.expressad.exoplayer.k.af.a(this.f, this.c) - this.g);
        int i2 = this.h;
        if (max >= i2) {
            return;
        }
        if (this.d != null) {
            int i3 = i2 - 1;
            while (i <= i3) {
                com.anythink.expressad.exoplayer.j.a[] aVarArr = this.i;
                com.anythink.expressad.exoplayer.j.a aVar = aVarArr[i];
                byte[] bArr = aVar.a;
                byte[] bArr2 = this.d;
                if (bArr == bArr2) {
                    i++;
                } else {
                    com.anythink.expressad.exoplayer.j.a aVar2 = aVarArr[i3];
                    if (aVar2.a != bArr2) {
                        i3--;
                    } else {
                        aVarArr[i] = aVar2;
                        aVarArr[i3] = aVar;
                        i3--;
                        i++;
                    }
                }
            }
            max = java.lang.Math.max(max, i);
            if (max >= this.h) {
                return;
            }
        }
        java.util.Arrays.fill(this.i, max, this.h, (java.lang.Object) null);
        this.h = max;
    }

    @Override // com.anythink.expressad.exoplayer.j.b
    public final synchronized int c() {
        return this.g * this.c;
    }

    @Override // com.anythink.expressad.exoplayer.j.b
    public final int d() {
        return this.c;
    }

    public final synchronized void e() {
        if (this.b) {
            a(0);
        }
    }
}
