package com.loc;

/* loaded from: classes23.dex */
public final class dx {

    public static class a implements com.loc.dv {
        private int a;
        private int b;
        private int c;

        public a(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        @Override // com.loc.dv
        public final long a() {
            return com.loc.dx.a(this.a, this.b);
        }

        @Override // com.loc.dv
        public final int b() {
            return this.c;
        }
    }

    public static class b implements com.loc.dv {
        private long a;
        private int b;

        public b(long j, int i) {
            this.a = j;
            this.b = i;
        }

        @Override // com.loc.dv
        public final long a() {
            return this.a;
        }

        @Override // com.loc.dv
        public final int b() {
            return this.b;
        }
    }

    public static long a(int i, int i2) {
        return (i2 & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT) | ((i & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT) << 32);
    }

    public static synchronized short a(long j) {
        short a2;
        synchronized (com.loc.dx.class) {
            a2 = com.loc.dw.a().a(j);
        }
        return a2;
    }

    public static synchronized void a(java.util.List<com.loc.eb> list) {
        com.loc.dx.a aVar;
        synchronized (com.loc.dx.class) {
            if (list != null) {
                if (!list.isEmpty()) {
                    java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
                    for (com.loc.eb ebVar : list) {
                        if (ebVar instanceof com.loc.ed) {
                            com.loc.ed edVar = (com.loc.ed) ebVar;
                            aVar = new com.loc.dx.a(edVar.j, edVar.k, edVar.c);
                        } else if (ebVar instanceof com.loc.ee) {
                            com.loc.ee eeVar = (com.loc.ee) ebVar;
                            aVar = new com.loc.dx.a(eeVar.j, eeVar.k, eeVar.c);
                        } else if (ebVar instanceof com.loc.ef) {
                            com.loc.ef efVar = (com.loc.ef) ebVar;
                            aVar = new com.loc.dx.a(efVar.j, efVar.k, efVar.c);
                        } else if (ebVar instanceof com.loc.ec) {
                            com.loc.ec ecVar = (com.loc.ec) ebVar;
                            aVar = new com.loc.dx.a(ecVar.k, ecVar.l, ecVar.c);
                        }
                        arrayList.add(aVar);
                    }
                    com.loc.dw.a().a(arrayList);
                }
            }
        }
    }

    public static synchronized short b(long j) {
        short b2;
        synchronized (com.loc.dx.class) {
            b2 = com.loc.dw.a().b(j);
        }
        return b2;
    }

    public static synchronized void b(java.util.List<com.loc.ei> list) {
        synchronized (com.loc.dx.class) {
            if (list != null) {
                if (!list.isEmpty()) {
                    java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
                    for (com.loc.ei eiVar : list) {
                        arrayList.add(new com.loc.dx.b(eiVar.a, eiVar.c));
                    }
                    com.loc.dw.a().b(arrayList);
                }
            }
        }
    }
}
