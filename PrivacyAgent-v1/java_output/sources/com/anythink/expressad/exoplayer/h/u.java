package com.anythink.expressad.exoplayer.h;

/* loaded from: classes12.dex */
final class u implements com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.r.a {
    public final com.anythink.expressad.exoplayer.h.r[] a;
    private final com.anythink.expressad.exoplayer.h.h c;
    private com.anythink.expressad.exoplayer.h.r.a e;
    private com.anythink.expressad.exoplayer.h.af f;
    private com.anythink.expressad.exoplayer.h.r[] g;
    private com.anythink.expressad.exoplayer.h.z h;
    private final java.util.ArrayList<com.anythink.expressad.exoplayer.h.r> d = new java.util.ArrayList<>();
    private final java.util.IdentityHashMap<com.anythink.expressad.exoplayer.h.y, java.lang.Integer> b = new java.util.IdentityHashMap<>();

    public u(com.anythink.expressad.exoplayer.h.h hVar, com.anythink.expressad.exoplayer.h.r... rVarArr) {
        this.c = hVar;
        this.a = rVarArr;
        this.h = hVar.a(new com.anythink.expressad.exoplayer.h.z[0]);
    }

    private void f() {
        this.e.a((com.anythink.expressad.exoplayer.h.r.a) this);
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long a(long j, com.anythink.expressad.exoplayer.ac acVar) {
        return this.g[0].a(j, acVar);
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long a(com.anythink.expressad.exoplayer.i.f[] fVarArr, boolean[] zArr, com.anythink.expressad.exoplayer.h.y[] yVarArr, boolean[] zArr2, long j) {
        com.anythink.expressad.exoplayer.h.y[] yVarArr2 = yVarArr;
        int[] iArr = new int[fVarArr.length];
        int[] iArr2 = new int[fVarArr.length];
        for (int i = 0; i < fVarArr.length; i++) {
            com.anythink.expressad.exoplayer.h.y yVar = yVarArr2[i];
            iArr[i] = yVar == null ? -1 : this.b.get(yVar).intValue();
            iArr2[i] = -1;
            com.anythink.expressad.exoplayer.i.f fVar = fVarArr[i];
            if (fVar != null) {
                com.anythink.expressad.exoplayer.h.ae f = fVar.f();
                int i2 = 0;
                while (true) {
                    com.anythink.expressad.exoplayer.h.r[] rVarArr = this.a;
                    if (i2 >= rVarArr.length) {
                        break;
                    }
                    if (rVarArr[i2].b().a(f) != -1) {
                        iArr2[i] = i2;
                        break;
                    }
                    i2++;
                }
            }
        }
        this.b.clear();
        int length = fVarArr.length;
        com.anythink.expressad.exoplayer.h.y[] yVarArr3 = new com.anythink.expressad.exoplayer.h.y[length];
        com.anythink.expressad.exoplayer.h.y[] yVarArr4 = new com.anythink.expressad.exoplayer.h.y[fVarArr.length];
        com.anythink.expressad.exoplayer.i.f[] fVarArr2 = new com.anythink.expressad.exoplayer.i.f[fVarArr.length];
        java.util.ArrayList arrayList = new java.util.ArrayList(this.a.length);
        long j2 = j;
        int i3 = 0;
        while (i3 < this.a.length) {
            for (int i4 = 0; i4 < fVarArr.length; i4++) {
                com.anythink.expressad.exoplayer.i.f fVar2 = null;
                yVarArr4[i4] = iArr[i4] == i3 ? yVarArr2[i4] : null;
                if (iArr2[i4] == i3) {
                    fVar2 = fVarArr[i4];
                }
                fVarArr2[i4] = fVar2;
            }
            int i5 = i3;
            com.anythink.expressad.exoplayer.i.f[] fVarArr3 = fVarArr2;
            java.util.ArrayList arrayList2 = arrayList;
            long a = this.a[i3].a(fVarArr2, zArr, yVarArr4, zArr2, j2);
            if (i5 == 0) {
                j2 = a;
            } else if (a != j2) {
                throw new java.lang.IllegalStateException("Children enabled at different positions.");
            }
            boolean z = false;
            for (int i6 = 0; i6 < fVarArr.length; i6++) {
                if (iArr2[i6] == i5) {
                    com.anythink.expressad.exoplayer.k.a.b(yVarArr4[i6] != null);
                    yVarArr3[i6] = yVarArr4[i6];
                    this.b.put(yVarArr4[i6], java.lang.Integer.valueOf(i5));
                    z = true;
                } else if (iArr[i6] == i5) {
                    com.anythink.expressad.exoplayer.k.a.b(yVarArr4[i6] == null);
                }
            }
            if (z) {
                arrayList2.add(this.a[i5]);
            }
            i3 = i5 + 1;
            arrayList = arrayList2;
            fVarArr2 = fVarArr3;
            yVarArr2 = yVarArr;
        }
        com.anythink.expressad.exoplayer.h.y[] yVarArr5 = yVarArr2;
        java.util.ArrayList arrayList3 = arrayList;
        java.lang.System.arraycopy(yVarArr3, 0, yVarArr5, 0, length);
        com.anythink.expressad.exoplayer.h.r[] rVarArr2 = new com.anythink.expressad.exoplayer.h.r[arrayList3.size()];
        this.g = rVarArr2;
        arrayList3.toArray(rVarArr2);
        this.h = this.c.a(this.g);
        return j2;
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a() {
        for (com.anythink.expressad.exoplayer.h.r rVar : this.a) {
            rVar.a();
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a(long j, boolean z) {
        for (com.anythink.expressad.exoplayer.h.r rVar : this.g) {
            rVar.a(j, z);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a(com.anythink.expressad.exoplayer.h.r.a aVar, long j) {
        this.e = aVar;
        java.util.Collections.addAll(this.d, this.a);
        for (com.anythink.expressad.exoplayer.h.r rVar : this.a) {
            rVar.a(this, j);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.anythink.expressad.exoplayer.h.r.a
    public final void a(com.anythink.expressad.exoplayer.h.r rVar) {
        this.d.remove(rVar);
        if (this.d.isEmpty()) {
            int i = 0;
            for (com.anythink.expressad.exoplayer.h.r rVar2 : this.a) {
                i += rVar2.b().b;
            }
            com.anythink.expressad.exoplayer.h.ae[] aeVarArr = new com.anythink.expressad.exoplayer.h.ae[i];
            int i2 = 0;
            for (com.anythink.expressad.exoplayer.h.r rVar3 : this.a) {
                com.anythink.expressad.exoplayer.h.af b = rVar3.b();
                int i3 = b.b;
                int i4 = 0;
                while (i4 < i3) {
                    aeVarArr[i2] = b.a(i4);
                    i4++;
                    i2++;
                }
            }
            this.f = new com.anythink.expressad.exoplayer.h.af(aeVarArr);
            this.e.a((com.anythink.expressad.exoplayer.h.r) this);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.z.a
    public final /* bridge */ /* synthetic */ void a(com.anythink.expressad.exoplayer.h.r rVar) {
        this.e.a((com.anythink.expressad.exoplayer.h.r.a) this);
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final void a_(long j) {
        this.h.a_(j);
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long b(long j) {
        long b = this.g[0].b(j);
        int i = 1;
        while (true) {
            com.anythink.expressad.exoplayer.h.r[] rVarArr = this.g;
            if (i >= rVarArr.length) {
                return b;
            }
            if (rVarArr[i].b(b) != b) {
                throw new java.lang.IllegalStateException("Unexpected child seekToUs result.");
            }
            i++;
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final com.anythink.expressad.exoplayer.h.af b() {
        return this.f;
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long c() {
        long c = this.a[0].c();
        int i = 1;
        while (true) {
            com.anythink.expressad.exoplayer.h.r[] rVarArr = this.a;
            if (i >= rVarArr.length) {
                if (c != -9223372036854775807L) {
                    for (com.anythink.expressad.exoplayer.h.r rVar : this.g) {
                        if (rVar != this.a[0] && rVar.b(c) != c) {
                            throw new java.lang.IllegalStateException("Unexpected child seekToUs result.");
                        }
                    }
                }
                return c;
            }
            if (rVarArr[i].c() != -9223372036854775807L) {
                throw new java.lang.IllegalStateException("Child reported discontinuity.");
            }
            i++;
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final boolean c(long j) {
        if (this.d.isEmpty()) {
            return this.h.c(j);
        }
        int size = this.d.size();
        for (int i = 0; i < size; i++) {
            this.d.get(i).c(j);
        }
        return false;
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final long d() {
        return this.h.d();
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final long e() {
        return this.h.e();
    }
}
