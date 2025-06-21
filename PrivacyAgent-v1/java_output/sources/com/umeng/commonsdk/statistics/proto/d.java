package com.umeng.commonsdk.statistics.proto;

/* loaded from: classes19.dex */
public class d implements com.umeng.analytics.pro.cc<com.umeng.commonsdk.statistics.proto.d, com.umeng.commonsdk.statistics.proto.d.e>, java.io.Serializable, java.lang.Cloneable {
    public static final java.util.Map<com.umeng.commonsdk.statistics.proto.d.e, com.umeng.analytics.pro.co> d;
    private static final long e = 2846460275012375038L;
    private static final com.umeng.analytics.pro.dg f = new com.umeng.analytics.pro.dg("Imprint");
    private static final com.umeng.analytics.pro.cw g = new com.umeng.analytics.pro.cw(org.apache.tools.ant.taskdefs.condition.ParserSupports.PROPERTY, (byte) 13, 1);
    private static final com.umeng.analytics.pro.cw h = new com.umeng.analytics.pro.cw("version", (byte) 8, 2);
    private static final com.umeng.analytics.pro.cw i = new com.umeng.analytics.pro.cw("checksum", (byte) 11, 3);
    private static final java.util.Map<java.lang.Class<? extends com.umeng.analytics.pro.dj>, com.umeng.analytics.pro.dk> j;
    private static final int k = 0;
    public java.util.Map<java.lang.String, com.umeng.commonsdk.statistics.proto.e> a;
    public int b;
    public java.lang.String c;
    private byte l;

    public static class a extends com.umeng.analytics.pro.dl<com.umeng.commonsdk.statistics.proto.d> {
        private a() {
        }

        public /* synthetic */ a(com.umeng.commonsdk.statistics.proto.d.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.dj
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(com.umeng.analytics.pro.db dbVar, com.umeng.commonsdk.statistics.proto.d dVar) throws com.umeng.analytics.pro.ci {
            dbVar.j();
            while (true) {
                com.umeng.analytics.pro.cw l = dbVar.l();
                byte b = l.b;
                if (b == 0) {
                    break;
                }
                short s2 = l.c;
                if (s2 != 1) {
                    if (s2 != 2) {
                        if (s2 != 3) {
                            com.umeng.analytics.pro.de.a(dbVar, b);
                        } else if (b == 11) {
                            dVar.c = dbVar.z();
                            dVar.c(true);
                        } else {
                            com.umeng.analytics.pro.de.a(dbVar, b);
                        }
                    } else if (b == 8) {
                        dVar.b = dbVar.w();
                        dVar.b(true);
                    } else {
                        com.umeng.analytics.pro.de.a(dbVar, b);
                    }
                } else if (b == 13) {
                    com.umeng.analytics.pro.cy n = dbVar.n();
                    dVar.a = new java.util.HashMap(n.c * 2);
                    for (int i = 0; i < n.c; i++) {
                        java.lang.String z = dbVar.z();
                        com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                        eVar.read(dbVar);
                        dVar.a.put(z, eVar);
                    }
                    dbVar.o();
                    dVar.a(true);
                } else {
                    com.umeng.analytics.pro.de.a(dbVar, b);
                }
                dbVar.m();
            }
            dbVar.k();
            if (dVar.h()) {
                dVar.l();
                return;
            }
            throw new com.umeng.analytics.pro.dc("Required field 'version' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.dj
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(com.umeng.analytics.pro.db dbVar, com.umeng.commonsdk.statistics.proto.d dVar) throws com.umeng.analytics.pro.ci {
            dVar.l();
            dbVar.a(com.umeng.commonsdk.statistics.proto.d.f);
            if (dVar.a != null) {
                dbVar.a(com.umeng.commonsdk.statistics.proto.d.g);
                dbVar.a(new com.umeng.analytics.pro.cy((byte) 11, (byte) 12, dVar.a.size()));
                for (java.util.Map.Entry<java.lang.String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.a.entrySet()) {
                    dbVar.a(entry.getKey());
                    entry.getValue().write(dbVar);
                }
                dbVar.e();
                dbVar.c();
            }
            dbVar.a(com.umeng.commonsdk.statistics.proto.d.h);
            dbVar.a(dVar.b);
            dbVar.c();
            if (dVar.c != null) {
                dbVar.a(com.umeng.commonsdk.statistics.proto.d.i);
                dbVar.a(dVar.c);
                dbVar.c();
            }
            dbVar.d();
            dbVar.b();
        }
    }

    public static class b implements com.umeng.analytics.pro.dk {
        private b() {
        }

        public /* synthetic */ b(com.umeng.commonsdk.statistics.proto.d.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.dk
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.umeng.commonsdk.statistics.proto.d.a b() {
            return new com.umeng.commonsdk.statistics.proto.d.a(null);
        }
    }

    public static class c extends com.umeng.analytics.pro.dm<com.umeng.commonsdk.statistics.proto.d> {
        private c() {
        }

        public /* synthetic */ c(com.umeng.commonsdk.statistics.proto.d.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.dj
        public void a(com.umeng.analytics.pro.db dbVar, com.umeng.commonsdk.statistics.proto.d dVar) throws com.umeng.analytics.pro.ci {
            com.umeng.analytics.pro.dh dhVar = (com.umeng.analytics.pro.dh) dbVar;
            dhVar.a(dVar.a.size());
            for (java.util.Map.Entry<java.lang.String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.a.entrySet()) {
                dhVar.a(entry.getKey());
                entry.getValue().write(dhVar);
            }
            dhVar.a(dVar.b);
            dhVar.a(dVar.c);
        }

        @Override // com.umeng.analytics.pro.dj
        public void b(com.umeng.analytics.pro.db dbVar, com.umeng.commonsdk.statistics.proto.d dVar) throws com.umeng.analytics.pro.ci {
            com.umeng.analytics.pro.dh dhVar = (com.umeng.analytics.pro.dh) dbVar;
            com.umeng.analytics.pro.cy cyVar = new com.umeng.analytics.pro.cy((byte) 11, (byte) 12, dhVar.w());
            dVar.a = new java.util.HashMap(cyVar.c * 2);
            for (int i = 0; i < cyVar.c; i++) {
                java.lang.String z = dhVar.z();
                com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                eVar.read(dhVar);
                dVar.a.put(z, eVar);
            }
            dVar.a(true);
            dVar.b = dhVar.w();
            dVar.b(true);
            dVar.c = dhVar.z();
            dVar.c(true);
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.d$d, reason: collision with other inner class name */
    public static class C0526d implements com.umeng.analytics.pro.dk {
        private C0526d() {
        }

        public /* synthetic */ C0526d(com.umeng.commonsdk.statistics.proto.d.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.dk
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.umeng.commonsdk.statistics.proto.d.c b() {
            return new com.umeng.commonsdk.statistics.proto.d.c(null);
        }
    }

    public enum e implements com.umeng.analytics.pro.cj {
        PROPERTY(1, org.apache.tools.ant.taskdefs.condition.ParserSupports.PROPERTY),
        VERSION(2, "version"),
        CHECKSUM(3, "checksum");

        private static final java.util.Map<java.lang.String, com.umeng.commonsdk.statistics.proto.d.e> d = new java.util.HashMap();
        private final short e;
        private final java.lang.String f;

        static {
            java.util.Iterator it = java.util.EnumSet.allOf(com.umeng.commonsdk.statistics.proto.d.e.class).iterator();
            while (it.hasNext()) {
                com.umeng.commonsdk.statistics.proto.d.e eVar = (com.umeng.commonsdk.statistics.proto.d.e) it.next();
                d.put(eVar.b(), eVar);
            }
        }

        e(short s2, java.lang.String str) {
            this.e = s2;
            this.f = str;
        }

        public static com.umeng.commonsdk.statistics.proto.d.e a(int i) {
            if (i == 1) {
                return PROPERTY;
            }
            if (i == 2) {
                return VERSION;
            }
            if (i != 3) {
                return null;
            }
            return CHECKSUM;
        }

        public static com.umeng.commonsdk.statistics.proto.d.e a(java.lang.String str) {
            return d.get(str);
        }

        public static com.umeng.commonsdk.statistics.proto.d.e b(int i) {
            com.umeng.commonsdk.statistics.proto.d.e a = a(i);
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
        hashMap.put(com.umeng.analytics.pro.dl.class, new com.umeng.commonsdk.statistics.proto.d.b(null));
        hashMap.put(com.umeng.analytics.pro.dm.class, new com.umeng.commonsdk.statistics.proto.d.C0526d(null));
        java.util.EnumMap enumMap = new java.util.EnumMap(com.umeng.commonsdk.statistics.proto.d.e.class);
        enumMap.put((java.util.EnumMap) com.umeng.commonsdk.statistics.proto.d.e.PROPERTY, (com.umeng.commonsdk.statistics.proto.d.e) new com.umeng.analytics.pro.co(org.apache.tools.ant.taskdefs.condition.ParserSupports.PROPERTY, (byte) 1, new com.umeng.analytics.pro.cr((byte) 13, new com.umeng.analytics.pro.cp((byte) 11), new com.umeng.analytics.pro.ct((byte) 12, com.umeng.commonsdk.statistics.proto.e.class))));
        enumMap.put((java.util.EnumMap) com.umeng.commonsdk.statistics.proto.d.e.VERSION, (com.umeng.commonsdk.statistics.proto.d.e) new com.umeng.analytics.pro.co("version", (byte) 1, new com.umeng.analytics.pro.cp((byte) 8)));
        enumMap.put((java.util.EnumMap) com.umeng.commonsdk.statistics.proto.d.e.CHECKSUM, (com.umeng.commonsdk.statistics.proto.d.e) new com.umeng.analytics.pro.co("checksum", (byte) 1, new com.umeng.analytics.pro.cp((byte) 11)));
        java.util.Map<com.umeng.commonsdk.statistics.proto.d.e, com.umeng.analytics.pro.co> unmodifiableMap = java.util.Collections.unmodifiableMap(enumMap);
        d = unmodifiableMap;
        com.umeng.analytics.pro.co.a(com.umeng.commonsdk.statistics.proto.d.class, unmodifiableMap);
    }

    public d() {
        this.l = (byte) 0;
    }

    public d(com.umeng.commonsdk.statistics.proto.d dVar) {
        this.l = (byte) 0;
        this.l = dVar.l;
        if (dVar.e()) {
            java.util.HashMap hashMap = new java.util.HashMap();
            for (java.util.Map.Entry<java.lang.String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.a.entrySet()) {
                hashMap.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.e(entry.getValue()));
            }
            this.a = hashMap;
        }
        this.b = dVar.b;
        if (dVar.k()) {
            this.c = dVar.c;
        }
    }

    public d(java.util.Map<java.lang.String, com.umeng.commonsdk.statistics.proto.e> map, int i2, java.lang.String str) {
        this();
        this.a = map;
        this.b = i2;
        b(true);
        this.c = str;
    }

    private void a(java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
        try {
            this.l = (byte) 0;
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
    public com.umeng.commonsdk.statistics.proto.d deepCopy() {
        return new com.umeng.commonsdk.statistics.proto.d(this);
    }

    public com.umeng.commonsdk.statistics.proto.d a(int i2) {
        this.b = i2;
        b(true);
        return this;
    }

    public com.umeng.commonsdk.statistics.proto.d a(java.lang.String str) {
        this.c = str;
        return this;
    }

    public com.umeng.commonsdk.statistics.proto.d a(java.util.Map<java.lang.String, com.umeng.commonsdk.statistics.proto.e> map) {
        this.a = map;
        return this;
    }

    public void a(java.lang.String str, com.umeng.commonsdk.statistics.proto.e eVar) {
        if (this.a == null) {
            this.a = new java.util.HashMap();
        }
        this.a.put(str, eVar);
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
    }

    public int b() {
        java.util.Map<java.lang.String, com.umeng.commonsdk.statistics.proto.e> map = this.a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    @Override // com.umeng.analytics.pro.cc
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.umeng.commonsdk.statistics.proto.d.e fieldForId(int i2) {
        return com.umeng.commonsdk.statistics.proto.d.e.a(i2);
    }

    public void b(boolean z) {
        this.l = com.umeng.analytics.pro.bz.a(this.l, 0, z);
    }

    public java.util.Map<java.lang.String, com.umeng.commonsdk.statistics.proto.e> c() {
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
        b(false);
        this.b = 0;
        this.c = null;
    }

    public void d() {
        this.a = null;
    }

    public boolean e() {
        return this.a != null;
    }

    public int f() {
        return this.b;
    }

    public void g() {
        this.l = com.umeng.analytics.pro.bz.b(this.l, 0);
    }

    public boolean h() {
        return com.umeng.analytics.pro.bz.a(this.l, 0);
    }

    public java.lang.String i() {
        return this.c;
    }

    public void j() {
        this.c = null;
    }

    public boolean k() {
        return this.c != null;
    }

    public void l() throws com.umeng.analytics.pro.ci {
        if (this.a == null) {
            throw new com.umeng.analytics.pro.dc("Required field 'property' was not present! Struct: " + toString());
        }
        if (this.c != null) {
            return;
        }
        throw new com.umeng.analytics.pro.dc("Required field 'checksum' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.cc
    public void read(com.umeng.analytics.pro.db dbVar) throws com.umeng.analytics.pro.ci {
        j.get(dbVar.D()).b().b(dbVar, this);
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Imprint(");
        sb.append("property:");
        java.util.Map<java.lang.String, com.umeng.commonsdk.statistics.proto.e> map = this.a;
        if (map == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(map);
        }
        sb.append(", ");
        sb.append("version:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("checksum:");
        java.lang.String str = this.c;
        if (str == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.cc
    public void write(com.umeng.analytics.pro.db dbVar) throws com.umeng.analytics.pro.ci {
        j.get(dbVar.D()).b().a(dbVar, this);
    }
}
