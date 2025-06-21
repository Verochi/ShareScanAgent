package com.loc;

/* loaded from: classes23.dex */
public final class db {
    private com.loc.eb a;
    private com.loc.eb b;
    private com.loc.eh c;
    private com.loc.db.a d = new com.loc.db.a();
    private final java.util.List<com.loc.eb> e = new java.util.ArrayList(3);

    public static class a {
        public byte a;
        public java.lang.String b;
        public com.loc.eb c;
        public com.loc.eb d;
        public com.loc.eb e;
        public java.util.List<com.loc.eb> f = new java.util.ArrayList();
        public java.util.List<com.loc.eb> g = new java.util.ArrayList();

        public static boolean a(com.loc.eb ebVar, com.loc.eb ebVar2) {
            if (ebVar == null || ebVar2 == null) {
                return (ebVar == null) == (ebVar2 == null);
            }
            if ((ebVar instanceof com.loc.ed) && (ebVar2 instanceof com.loc.ed)) {
                com.loc.ed edVar = (com.loc.ed) ebVar;
                com.loc.ed edVar2 = (com.loc.ed) ebVar2;
                return edVar.j == edVar2.j && edVar.k == edVar2.k;
            }
            if ((ebVar instanceof com.loc.ec) && (ebVar2 instanceof com.loc.ec)) {
                com.loc.ec ecVar = (com.loc.ec) ebVar;
                com.loc.ec ecVar2 = (com.loc.ec) ebVar2;
                return ecVar.l == ecVar2.l && ecVar.k == ecVar2.k && ecVar.j == ecVar2.j;
            }
            if ((ebVar instanceof com.loc.ee) && (ebVar2 instanceof com.loc.ee)) {
                com.loc.ee eeVar = (com.loc.ee) ebVar;
                com.loc.ee eeVar2 = (com.loc.ee) ebVar2;
                return eeVar.j == eeVar2.j && eeVar.k == eeVar2.k;
            }
            if ((ebVar instanceof com.loc.ef) && (ebVar2 instanceof com.loc.ef)) {
                com.loc.ef efVar = (com.loc.ef) ebVar;
                com.loc.ef efVar2 = (com.loc.ef) ebVar2;
                if (efVar.j == efVar2.j && efVar.k == efVar2.k) {
                    return true;
                }
            }
            return false;
        }

        public final void a() {
            this.a = (byte) 0;
            this.b = "";
            this.c = null;
            this.d = null;
            this.e = null;
            this.f.clear();
            this.g.clear();
        }

        public final void a(byte b, java.lang.String str, java.util.List<com.loc.eb> list) {
            a();
            this.a = b;
            this.b = str;
            if (list != null) {
                this.f.addAll(list);
                for (com.loc.eb ebVar : this.f) {
                    boolean z = ebVar.i;
                    if (!z && ebVar.h) {
                        this.d = ebVar;
                    } else if (z && ebVar.h) {
                        this.e = ebVar;
                    }
                }
            }
            com.loc.eb ebVar2 = this.d;
            if (ebVar2 == null) {
                ebVar2 = this.e;
            }
            this.c = ebVar2;
        }

        public final java.lang.String toString() {
            return "CellInfo{radio=" + ((int) this.a) + ", operator='" + this.b + "', mainCell=" + this.c + ", mainOldInterCell=" + this.d + ", mainNewInterCell=" + this.e + ", cells=" + this.f + ", historyMainCellList=" + this.g + '}';
        }
    }

    private void a(com.loc.db.a aVar) {
        synchronized (this.e) {
            for (com.loc.eb ebVar : aVar.f) {
                if (ebVar != null && ebVar.h) {
                    com.loc.eb clone = ebVar.clone();
                    clone.e = android.os.SystemClock.elapsedRealtime();
                    a(clone);
                }
            }
            this.d.g.clear();
            this.d.g.addAll(this.e);
        }
    }

    private void a(com.loc.eb ebVar) {
        if (ebVar == null) {
            return;
        }
        int size = this.e.size();
        if (size != 0) {
            int i = -1;
            long j = Long.MAX_VALUE;
            int i2 = 0;
            int i3 = -1;
            while (true) {
                if (i2 >= size) {
                    i = i3;
                    break;
                }
                com.loc.eb ebVar2 = this.e.get(i2);
                if (ebVar.equals(ebVar2)) {
                    int i4 = ebVar.c;
                    if (i4 != ebVar2.c) {
                        ebVar2.e = i4;
                        ebVar2.c = i4;
                    }
                } else {
                    j = java.lang.Math.min(j, ebVar2.e);
                    if (j == ebVar2.e) {
                        i3 = i2;
                    }
                    i2++;
                }
            }
            if (i < 0) {
                return;
            }
            if (size >= 3) {
                if (ebVar.e <= j || i >= size) {
                    return;
                }
                this.e.remove(i);
                this.e.add(ebVar);
                return;
            }
        }
        this.e.add(ebVar);
    }

    private boolean a(com.loc.eh ehVar) {
        float f = ehVar.g;
        return ehVar.a(this.c) > ((double) ((f > 10.0f ? 1 : (f == 10.0f ? 0 : -1)) > 0 ? 2000.0f : (f > 2.0f ? 1 : (f == 2.0f ? 0 : -1)) > 0 ? 500.0f : 100.0f));
    }

    public final com.loc.db.a a(com.loc.eh ehVar, boolean z, byte b, java.lang.String str, java.util.List<com.loc.eb> list) {
        if (z) {
            this.d.a();
            return null;
        }
        this.d.a(b, str, list);
        if (this.d.c == null) {
            return null;
        }
        if (!(this.c == null || a(ehVar) || !com.loc.db.a.a(this.d.d, this.a) || !com.loc.db.a.a(this.d.e, this.b))) {
            return null;
        }
        com.loc.db.a aVar = this.d;
        this.a = aVar.d;
        this.b = aVar.e;
        this.c = ehVar;
        com.loc.dx.a(aVar.f);
        a(this.d);
        return this.d;
    }
}
