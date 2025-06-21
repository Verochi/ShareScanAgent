package com.loc;

/* loaded from: classes23.dex */
public final class cy extends com.loc.cx {
    public cy() {
        super(2048);
    }

    private int a(long j, java.util.List<com.loc.ei> list) {
        b(list);
        int size = list.size();
        if (size <= 0) {
            return -1;
        }
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            com.loc.ei eiVar = list.get(i);
            int a = this.a.a(eiVar.b);
            long j2 = eiVar.a;
            iArr[i] = com.loc.du.a(this.a, j2 == j && j2 != -1, j2, (short) eiVar.c, a, eiVar.g, (short) eiVar.d);
        }
        return com.loc.dt.a(this.a, com.loc.dt.a(this.a, iArr));
    }

    private int a(com.loc.db.a aVar) {
        int i;
        int i2;
        com.loc.cz czVar;
        int i3;
        int i4;
        int i5;
        byte b;
        int i6;
        a(aVar.f);
        int size = aVar.f.size();
        int[] iArr = new int[size];
        for (int i7 = 0; i7 < size; i7++) {
            com.loc.eb ebVar = aVar.f.get(i7);
            if (ebVar instanceof com.loc.ed) {
                com.loc.ed edVar = (com.loc.ed) ebVar;
                i6 = !edVar.i ? com.loc.Cdo.a(this.a, edVar.j, edVar.k, edVar.c, edVar.l) : com.loc.Cdo.a(this.a, edVar.b(), edVar.c(), edVar.j, edVar.k, edVar.c, edVar.m, edVar.n, edVar.d, edVar.l);
                i5 = -1;
                b = 1;
            } else if (ebVar instanceof com.loc.ee) {
                com.loc.ee eeVar = (com.loc.ee) ebVar;
                i6 = com.loc.dp.a(this.a, eeVar.b(), eeVar.c(), eeVar.j, eeVar.k, eeVar.l, eeVar.c, eeVar.m, eeVar.d);
                i5 = -1;
                b = 3;
            } else if (ebVar instanceof com.loc.ec) {
                com.loc.ec ecVar = (com.loc.ec) ebVar;
                boolean z = ecVar.i;
                com.loc.cz czVar2 = this.a;
                int i8 = ecVar.j;
                int i9 = ecVar.k;
                int i10 = ecVar.l;
                int i11 = ecVar.m;
                int i12 = ecVar.n;
                int i13 = ecVar.c;
                i6 = !z ? com.loc.di.a(czVar2, i8, i9, i10, i11, i12, i13) : com.loc.di.a(czVar2, i8, i9, i10, i11, i12, i13, ecVar.d);
                i5 = -1;
                b = 2;
            } else if (ebVar instanceof com.loc.ef) {
                com.loc.ef efVar = (com.loc.ef) ebVar;
                i6 = com.loc.ds.a(this.a, efVar.b(), efVar.c(), efVar.j, efVar.k, efVar.l, efVar.c, efVar.m, efVar.d);
                i5 = -1;
                b = 4;
            } else {
                i5 = -1;
                b = 0;
                i6 = -1;
            }
            if (i6 == i5) {
                return i5;
            }
            iArr[i7] = com.loc.dl.a(this.a, ebVar.h ? (byte) 1 : (byte) 0, ebVar.i ? (byte) 1 : (byte) 0, (short) ebVar.g, b, i6);
        }
        int a = this.a.a(aVar.b);
        int a2 = com.loc.dj.a(this.a, iArr);
        int size2 = aVar.g.size();
        int[] iArr2 = new int[size2];
        for (int i14 = 0; i14 < size2; i14++) {
            com.loc.eb ebVar2 = aVar.g.get(i14);
            long elapsedRealtime = (android.os.SystemClock.elapsedRealtime() - ebVar2.e) / 1000;
            if (elapsedRealtime > 32767 || elapsedRealtime < 0) {
                elapsedRealtime = 32767;
            }
            if (ebVar2 instanceof com.loc.ed) {
                com.loc.ed edVar2 = (com.loc.ed) ebVar2;
                czVar = this.a;
                i3 = edVar2.j;
                i4 = edVar2.k;
            } else if (ebVar2 instanceof com.loc.ee) {
                com.loc.ee eeVar2 = (com.loc.ee) ebVar2;
                czVar = this.a;
                i3 = eeVar2.j;
                i4 = eeVar2.k;
            } else {
                if (ebVar2 instanceof com.loc.ec) {
                    com.loc.ec ecVar2 = (com.loc.ec) ebVar2;
                    i = com.loc.dq.a(this.a, ecVar2.j, ecVar2.k, ecVar2.l, (short) elapsedRealtime);
                    i2 = 2;
                } else if (ebVar2 instanceof com.loc.ef) {
                    com.loc.ef efVar2 = (com.loc.ef) ebVar2;
                    czVar = this.a;
                    i3 = efVar2.j;
                    i4 = efVar2.k;
                } else {
                    i = 0;
                    i2 = 0;
                }
                iArr2[i14] = com.loc.dk.a(this.a, (byte) i2, i);
            }
            i = com.loc.dr.a(czVar, i3, i4, (short) elapsedRealtime);
            i2 = 1;
            iArr2[i14] = com.loc.dk.a(this.a, (byte) i2, i);
        }
        return com.loc.dj.a(this.a, a, aVar.a, a2, com.loc.dj.b(this.a, iArr2));
    }

    private int a(com.loc.eh ehVar) {
        return com.loc.dn.a(this.a, ehVar.c, ehVar.k, (int) (ehVar.e * 1000000.0d), (int) (ehVar.d * 1000000.0d), (int) ehVar.f, (int) ehVar.i, (int) ehVar.g, (short) ehVar.h, ehVar.l);
    }

    private static void a(java.util.List<com.loc.eb> list) {
        int i;
        int i2;
        if (list == null || list.size() == 0) {
            return;
        }
        for (com.loc.eb ebVar : list) {
            if (ebVar instanceof com.loc.ed) {
                com.loc.ed edVar = (com.loc.ed) ebVar;
                i = edVar.j;
                i2 = edVar.k;
            } else if (ebVar instanceof com.loc.ee) {
                com.loc.ee eeVar = (com.loc.ee) ebVar;
                i = eeVar.j;
                i2 = eeVar.k;
            } else if (ebVar instanceof com.loc.ef) {
                com.loc.ef efVar = (com.loc.ef) ebVar;
                i = efVar.j;
                i2 = efVar.k;
            } else if (ebVar instanceof com.loc.ec) {
                com.loc.ec ecVar = (com.loc.ec) ebVar;
                i = ecVar.k;
                i2 = ecVar.l;
            }
            ebVar.g = com.loc.dx.a(com.loc.dx.a(i, i2));
        }
    }

    private static void b(java.util.List<com.loc.ei> list) {
        for (com.loc.ei eiVar : list) {
            eiVar.g = com.loc.dx.b(eiVar.a);
        }
    }

    public final byte[] a(com.loc.eh ehVar, com.loc.db.a aVar, long j, java.util.List<com.loc.ei> list) {
        java.util.List<com.loc.eb> list2;
        super.a();
        try {
            int a = a(ehVar);
            int i = -1;
            int a2 = (aVar == null || (list2 = aVar.f) == null || list2.size() <= 0) ? -1 : a(aVar);
            if (list != null && list.size() > 0) {
                i = a(j, list);
            }
            com.loc.dg.a(this.a);
            com.loc.dg.a(this.a, a);
            if (a2 > 0) {
                com.loc.dg.c(this.a, a2);
            }
            if (i > 0) {
                com.loc.dg.b(this.a, i);
            }
            this.a.c(com.loc.dg.b(this.a));
            return this.a.c();
        } catch (java.lang.Throwable th) {
            com.loc.el.a(th);
            return null;
        }
    }
}
