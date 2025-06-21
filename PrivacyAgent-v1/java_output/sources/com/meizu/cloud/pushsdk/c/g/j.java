package com.meizu.cloud.pushsdk.c.g;

/* loaded from: classes23.dex */
final class j {
    final byte[] a;
    int b;
    int c;
    boolean d;
    final boolean e;
    com.meizu.cloud.pushsdk.c.g.j f;
    com.meizu.cloud.pushsdk.c.g.j g;

    public j() {
        this.a = new byte[2048];
        this.e = true;
        this.d = false;
    }

    public j(com.meizu.cloud.pushsdk.c.g.j jVar) {
        this(jVar.a, jVar.b, jVar.c);
    }

    public j(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.e = false;
        this.d = true;
    }

    public com.meizu.cloud.pushsdk.c.g.j a() {
        com.meizu.cloud.pushsdk.c.g.j jVar = this.f;
        com.meizu.cloud.pushsdk.c.g.j jVar2 = jVar != this ? jVar : null;
        com.meizu.cloud.pushsdk.c.g.j jVar3 = this.g;
        jVar3.f = jVar;
        this.f.g = jVar3;
        this.f = null;
        this.g = null;
        return jVar2;
    }

    public com.meizu.cloud.pushsdk.c.g.j a(int i) {
        if (i <= 0 || i > this.c - this.b) {
            throw new java.lang.IllegalArgumentException();
        }
        com.meizu.cloud.pushsdk.c.g.j jVar = new com.meizu.cloud.pushsdk.c.g.j(this);
        jVar.c = jVar.b + i;
        this.b += i;
        this.g.a(jVar);
        return jVar;
    }

    public com.meizu.cloud.pushsdk.c.g.j a(com.meizu.cloud.pushsdk.c.g.j jVar) {
        jVar.g = this;
        jVar.f = this.f;
        this.f.g = jVar;
        this.f = jVar;
        return jVar;
    }

    public void a(com.meizu.cloud.pushsdk.c.g.j jVar, int i) {
        if (!jVar.e) {
            throw new java.lang.IllegalArgumentException();
        }
        int i2 = jVar.c;
        if (i2 + i > 2048) {
            if (jVar.d) {
                throw new java.lang.IllegalArgumentException();
            }
            int i3 = jVar.b;
            if ((i2 + i) - i3 > 2048) {
                throw new java.lang.IllegalArgumentException();
            }
            byte[] bArr = jVar.a;
            java.lang.System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
            jVar.c -= jVar.b;
            jVar.b = 0;
        }
        java.lang.System.arraycopy(this.a, this.b, jVar.a, jVar.c, i);
        jVar.c += i;
        this.b += i;
    }

    public void b() {
        com.meizu.cloud.pushsdk.c.g.j jVar = this.g;
        if (jVar == this) {
            throw new java.lang.IllegalStateException();
        }
        if (jVar.e) {
            int i = this.c - this.b;
            if (i > (2048 - jVar.c) + (jVar.d ? 0 : jVar.b)) {
                return;
            }
            a(jVar, i);
            a();
            com.meizu.cloud.pushsdk.c.g.k.a(this);
        }
    }
}
