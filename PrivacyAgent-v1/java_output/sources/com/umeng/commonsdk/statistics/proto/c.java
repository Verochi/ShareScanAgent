package com.umeng.commonsdk.statistics.proto;

/* loaded from: classes19.dex */
public class c implements com.umeng.analytics.pro.cc<com.umeng.commonsdk.statistics.proto.c, com.umeng.commonsdk.statistics.proto.c.e>, java.io.Serializable, java.lang.Cloneable {
    public static final java.util.Map<com.umeng.commonsdk.statistics.proto.c.e, com.umeng.analytics.pro.co> d;
    private static final long e = -5764118265293965743L;
    private static final com.umeng.analytics.pro.dg f = new com.umeng.analytics.pro.dg("IdTracking");
    private static final com.umeng.analytics.pro.cw g = new com.umeng.analytics.pro.cw("snapshots", (byte) 13, 1);
    private static final com.umeng.analytics.pro.cw h = new com.umeng.analytics.pro.cw("journals", (byte) 15, 2);
    private static final com.umeng.analytics.pro.cw i = new com.umeng.analytics.pro.cw("checksum", (byte) 11, 3);
    private static final java.util.Map<java.lang.Class<? extends com.umeng.analytics.pro.dj>, com.umeng.analytics.pro.dk> j;
    public java.util.Map<java.lang.String, com.umeng.commonsdk.statistics.proto.b> a;
    public java.util.List<com.umeng.commonsdk.statistics.proto.a> b;
    public java.lang.String c;
    private com.umeng.commonsdk.statistics.proto.c.e[] k;

    public static class a extends com.umeng.analytics.pro.dl<com.umeng.commonsdk.statistics.proto.c> {
        private a() {
        }

        public /* synthetic */ a(com.umeng.commonsdk.statistics.proto.c.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.dj
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(com.umeng.analytics.pro.db dbVar, com.umeng.commonsdk.statistics.proto.c cVar) throws com.umeng.analytics.pro.ci {
            dbVar.j();
            while (true) {
                com.umeng.analytics.pro.cw l = dbVar.l();
                byte b = l.b;
                if (b == 0) {
                    dbVar.k();
                    cVar.n();
                    return;
                }
                short s2 = l.c;
                int i = 0;
                if (s2 != 1) {
                    if (s2 != 2) {
                        if (s2 != 3) {
                            com.umeng.analytics.pro.de.a(dbVar, b);
                        } else if (b == 11) {
                            cVar.c = dbVar.z();
                            cVar.c(true);
                        } else {
                            com.umeng.analytics.pro.de.a(dbVar, b);
                        }
                    } else if (b == 15) {
                        com.umeng.analytics.pro.cx p = dbVar.p();
                        cVar.b = new java.util.ArrayList(p.b);
                        while (i < p.b) {
                            com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                            aVar.read(dbVar);
                            cVar.b.add(aVar);
                            i++;
                        }
                        dbVar.q();
                        cVar.b(true);
                    } else {
                        com.umeng.analytics.pro.de.a(dbVar, b);
                    }
                } else if (b == 13) {
                    com.umeng.analytics.pro.cy n = dbVar.n();
                    cVar.a = new java.util.HashMap(n.c * 2);
                    while (i < n.c) {
                        java.lang.String z = dbVar.z();
                        com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                        bVar.read(dbVar);
                        cVar.a.put(z, bVar);
                        i++;
                    }
                    dbVar.o();
                    cVar.a(true);
                } else {
                    com.umeng.analytics.pro.de.a(dbVar, b);
                }
                dbVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.dj
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(com.umeng.analytics.pro.db dbVar, com.umeng.commonsdk.statistics.proto.c cVar) throws com.umeng.analytics.pro.ci {
            cVar.n();
            dbVar.a(com.umeng.commonsdk.statistics.proto.c.f);
            if (cVar.a != null) {
                dbVar.a(com.umeng.commonsdk.statistics.proto.c.g);
                dbVar.a(new com.umeng.analytics.pro.cy((byte) 11, (byte) 12, cVar.a.size()));
                for (java.util.Map.Entry<java.lang.String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.a.entrySet()) {
                    dbVar.a(entry.getKey());
                    entry.getValue().write(dbVar);
                }
                dbVar.e();
                dbVar.c();
            }
            if (cVar.b != null && cVar.j()) {
                dbVar.a(com.umeng.commonsdk.statistics.proto.c.h);
                dbVar.a(new com.umeng.analytics.pro.cx((byte) 12, cVar.b.size()));
                java.util.Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.b.iterator();
                while (it.hasNext()) {
                    it.next().write(dbVar);
                }
                dbVar.f();
                dbVar.c();
            }
            if (cVar.c != null && cVar.m()) {
                dbVar.a(com.umeng.commonsdk.statistics.proto.c.i);
                dbVar.a(cVar.c);
                dbVar.c();
            }
            dbVar.d();
            dbVar.b();
        }
    }

    public static class b implements com.umeng.analytics.pro.dk {
        private b() {
        }

        public /* synthetic */ b(com.umeng.commonsdk.statistics.proto.c.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.dk
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.umeng.commonsdk.statistics.proto.c.a b() {
            return new com.umeng.commonsdk.statistics.proto.c.a(null);
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.c$c, reason: collision with other inner class name */
    public static class C0525c extends com.umeng.analytics.pro.dm<com.umeng.commonsdk.statistics.proto.c> {
        private C0525c() {
        }

        public /* synthetic */ C0525c(com.umeng.commonsdk.statistics.proto.c.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.dj
        public void a(com.umeng.analytics.pro.db dbVar, com.umeng.commonsdk.statistics.proto.c cVar) throws com.umeng.analytics.pro.ci {
            com.umeng.analytics.pro.dh dhVar = (com.umeng.analytics.pro.dh) dbVar;
            dhVar.a(cVar.a.size());
            for (java.util.Map.Entry<java.lang.String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.a.entrySet()) {
                dhVar.a(entry.getKey());
                entry.getValue().write(dhVar);
            }
            java.util.BitSet bitSet = new java.util.BitSet();
            if (cVar.j()) {
                bitSet.set(0);
            }
            if (cVar.m()) {
                bitSet.set(1);
            }
            dhVar.a(bitSet, 2);
            if (cVar.j()) {
                dhVar.a(cVar.b.size());
                java.util.Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.b.iterator();
                while (it.hasNext()) {
                    it.next().write(dhVar);
                }
            }
            if (cVar.m()) {
                dhVar.a(cVar.c);
            }
        }

        @Override // com.umeng.analytics.pro.dj
        public void b(com.umeng.analytics.pro.db dbVar, com.umeng.commonsdk.statistics.proto.c cVar) throws com.umeng.analytics.pro.ci {
            com.umeng.analytics.pro.dh dhVar = (com.umeng.analytics.pro.dh) dbVar;
            com.umeng.analytics.pro.cy cyVar = new com.umeng.analytics.pro.cy((byte) 11, (byte) 12, dhVar.w());
            cVar.a = new java.util.HashMap(cyVar.c * 2);
            for (int i = 0; i < cyVar.c; i++) {
                java.lang.String z = dhVar.z();
                com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                bVar.read(dhVar);
                cVar.a.put(z, bVar);
            }
            cVar.a(true);
            java.util.BitSet b = dhVar.b(2);
            if (b.get(0)) {
                com.umeng.analytics.pro.cx cxVar = new com.umeng.analytics.pro.cx((byte) 12, dhVar.w());
                cVar.b = new java.util.ArrayList(cxVar.b);
                for (int i2 = 0; i2 < cxVar.b; i2++) {
                    com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                    aVar.read(dhVar);
                    cVar.b.add(aVar);
                }
                cVar.b(true);
            }
            if (b.get(1)) {
                cVar.c = dhVar.z();
                cVar.c(true);
            }
        }
    }

    public static class d implements com.umeng.analytics.pro.dk {
        private d() {
        }

        public /* synthetic */ d(com.umeng.commonsdk.statistics.proto.c.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.dk
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.umeng.commonsdk.statistics.proto.c.C0525c b() {
            return new com.umeng.commonsdk.statistics.proto.c.C0525c(null);
        }
    }

    public enum e implements com.umeng.analytics.pro.cj {
        SNAPSHOTS(1, "snapshots"),
        JOURNALS(2, "journals"),
        CHECKSUM(3, "checksum");

        private static final java.util.Map<java.lang.String, com.umeng.commonsdk.statistics.proto.c.e> d = new java.util.HashMap();
        private final short e;
        private final java.lang.String f;

        static {
            java.util.Iterator it = java.util.EnumSet.allOf(com.umeng.commonsdk.statistics.proto.c.e.class).iterator();
            while (it.hasNext()) {
                com.umeng.commonsdk.statistics.proto.c.e eVar = (com.umeng.commonsdk.statistics.proto.c.e) it.next();
                d.put(eVar.b(), eVar);
            }
        }

        e(short s2, java.lang.String str) {
            this.e = s2;
            this.f = str;
        }

        public static com.umeng.commonsdk.statistics.proto.c.e a(int i) {
            if (i == 1) {
                return SNAPSHOTS;
            }
            if (i == 2) {
                return JOURNALS;
            }
            if (i != 3) {
                return null;
            }
            return CHECKSUM;
        }

        public static com.umeng.commonsdk.statistics.proto.c.e a(java.lang.String str) {
            return d.get(str);
        }

        public static com.umeng.commonsdk.statistics.proto.c.e b(int i) {
            com.umeng.commonsdk.statistics.proto.c.e a = a(i);
            if (a != null) {
                return a;
            }
            throw new java.lang.IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.cj
        public short a() {
            return this.e;
        }

        @Override // com.umeng.analytics.pro.cj
        public java.lang.String b() {
            return this.f;
        }
    }

    static {
        java.util.HashMap hashMap = new java.util.HashMap();
        j = hashMap;
        hashMap.put(com.umeng.analytics.pro.dl.class, new com.umeng.commonsdk.statistics.proto.c.b(null));
        hashMap.put(com.umeng.analytics.pro.dm.class, new com.umeng.commonsdk.statistics.proto.c.d(null));
        java.util.EnumMap enumMap = new java.util.EnumMap(com.umeng.commonsdk.statistics.proto.c.e.class);
        enumMap.put((java.util.EnumMap) com.umeng.commonsdk.statistics.proto.c.e.SNAPSHOTS, (com.umeng.commonsdk.statistics.proto.c.e) new com.umeng.analytics.pro.co("snapshots", (byte) 1, new com.umeng.analytics.pro.cr((byte) 13, new com.umeng.analytics.pro.cp((byte) 11), new com.umeng.analytics.pro.ct((byte) 12, com.umeng.commonsdk.statistics.proto.b.class))));
        enumMap.put((java.util.EnumMap) com.umeng.commonsdk.statistics.proto.c.e.JOURNALS, (com.umeng.commonsdk.statistics.proto.c.e) new com.umeng.analytics.pro.co("journals", (byte) 2, new com.umeng.analytics.pro.cq((byte) 15, new com.umeng.analytics.pro.ct((byte) 12, com.umeng.commonsdk.statistics.proto.a.class))));
        enumMap.put((java.util.EnumMap) com.umeng.commonsdk.statistics.proto.c.e.CHECKSUM, (com.umeng.commonsdk.statistics.proto.c.e) new com.umeng.analytics.pro.co("checksum", (byte) 2, new com.umeng.analytics.pro.cp((byte) 11)));
        java.util.Map<com.umeng.commonsdk.statistics.proto.c.e, com.umeng.analytics.pro.co> unmodifiableMap = java.util.Collections.unmodifiableMap(enumMap);
        d = unmodifiableMap;
        com.umeng.analytics.pro.co.a(com.umeng.commonsdk.statistics.proto.c.class, unmodifiableMap);
    }

    public c() {
        this.k = new com.umeng.commonsdk.statistics.proto.c.e[]{com.umeng.commonsdk.statistics.proto.c.e.JOURNALS, com.umeng.commonsdk.statistics.proto.c.e.CHECKSUM};
    }

    public c(com.umeng.commonsdk.statistics.proto.c cVar) {
        this.k = new com.umeng.commonsdk.statistics.proto.c.e[]{com.umeng.commonsdk.statistics.proto.c.e.JOURNALS, com.umeng.commonsdk.statistics.proto.c.e.CHECKSUM};
        if (cVar.e()) {
            java.util.HashMap hashMap = new java.util.HashMap();
            for (java.util.Map.Entry<java.lang.String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.a.entrySet()) {
                hashMap.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.b(entry.getValue()));
            }
            this.a = hashMap;
        }
        if (cVar.j()) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.b.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.umeng.commonsdk.statistics.proto.a(it.next()));
            }
            this.b = arrayList;
        }
        if (cVar.m()) {
            this.c = cVar.c;
        }
    }

    public c(java.util.Map<java.lang.String, com.umeng.commonsdk.statistics.proto.b> map) {
        this();
        this.a = map;
    }

    private void a(java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
        try {
            read(new com.umeng.analytics.pro.cv(new com.umeng.analytics.pro.dn(objectInputStream)));
        } catch (com.umeng.analytics.pro.ci e2) {
            throw new java.io.IOException(e2.getMessage());
        }
    }

    private void a(java.io.ObjectOutputStream objectOutputStream) throws java.io.IOException {
        try {
            write(new com.umeng.analytics.pro.cv(new com.umeng.analytics.pro.dn(objectOutputStream)));
        } catch (com.umeng.analytics.pro.ci e2) {
            throw new java.io.IOException(e2.getMessage());
        }
    }

    @Override // com.umeng.analytics.pro.cc
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.umeng.commonsdk.statistics.proto.c.e fieldForId(int i2) {
        return com.umeng.commonsdk.statistics.proto.c.e.a(i2);
    }

    @Override // com.umeng.analytics.pro.cc
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.umeng.commonsdk.statistics.proto.c deepCopy() {
        return new com.umeng.commonsdk.statistics.proto.c(this);
    }

    public com.umeng.commonsdk.statistics.proto.c a(java.lang.String str) {
        this.c = str;
        return this;
    }

    public com.umeng.commonsdk.statistics.proto.c a(java.util.List<com.umeng.commonsdk.statistics.proto.a> list) {
        this.b = list;
        return this;
    }

    public com.umeng.commonsdk.statistics.proto.c a(java.util.Map<java.lang.String, com.umeng.commonsdk.statistics.proto.b> map) {
        this.a = map;
        return this;
    }

    public void a(com.umeng.commonsdk.statistics.proto.a aVar) {
        if (this.b == null) {
            this.b = new java.util.ArrayList();
        }
        this.b.add(aVar);
    }

    public void a(java.lang.String str, com.umeng.commonsdk.statistics.proto.b bVar) {
        if (this.a == null) {
            this.a = new java.util.HashMap();
        }
        this.a.put(str, bVar);
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
    }

    public int b() {
        java.util.Map<java.lang.String, com.umeng.commonsdk.statistics.proto.b> map = this.a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public void b(boolean z) {
        if (z) {
            return;
        }
        this.b = null;
    }

    public java.util.Map<java.lang.String, com.umeng.commonsdk.statistics.proto.b> c() {
        return this.a;
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.c = null;
    }

    @Override // com.umeng.analytics.pro.cc
    public void clear() {
        this.a = null;
        this.b = null;
        this.c = null;
    }

    public void d() {
        this.a = null;
    }

    public boolean e() {
        return this.a != null;
    }

    public int f() {
        java.util.List<com.umeng.commonsdk.statistics.proto.a> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public java.util.Iterator<com.umeng.commonsdk.statistics.proto.a> g() {
        java.util.List<com.umeng.commonsdk.statistics.proto.a> list = this.b;
        if (list == null) {
            return null;
        }
        return list.iterator();
    }

    public java.util.List<com.umeng.commonsdk.statistics.proto.a> h() {
        return this.b;
    }

    public void i() {
        this.b = null;
    }

    public boolean j() {
        return this.b != null;
    }

    public java.lang.String k() {
        return this.c;
    }

    public void l() {
        this.c = null;
    }

    public boolean m() {
        return this.c != null;
    }

    public void n() throws com.umeng.analytics.pro.ci {
        if (this.a != null) {
            return;
        }
        throw new com.umeng.analytics.pro.dc("Required field 'snapshots' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.cc
    public void read(com.umeng.analytics.pro.db dbVar) throws com.umeng.analytics.pro.ci {
        j.get(dbVar.D()).b().b(dbVar, this);
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("IdTracking(");
        sb.append("snapshots:");
        java.util.Map<java.lang.String, com.umeng.commonsdk.statistics.proto.b> map = this.a;
        if (map == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(map);
        }
        if (j()) {
            sb.append(", ");
            sb.append("journals:");
            java.util.List<com.umeng.commonsdk.statistics.proto.a> list = this.b;
            if (list == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(list);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("checksum:");
            java.lang.String str = this.c;
            if (str == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.cc
    public void write(com.umeng.analytics.pro.db dbVar) throws com.umeng.analytics.pro.ci {
        j.get(dbVar.D()).b().a(dbVar, this);
    }
}
