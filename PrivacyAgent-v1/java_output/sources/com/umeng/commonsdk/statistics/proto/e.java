package com.umeng.commonsdk.statistics.proto;

/* loaded from: classes19.dex */
public class e implements com.umeng.analytics.pro.cc<com.umeng.commonsdk.statistics.proto.e, com.umeng.commonsdk.statistics.proto.e.EnumC0527e>, java.io.Serializable, java.lang.Cloneable {
    public static final java.util.Map<com.umeng.commonsdk.statistics.proto.e.EnumC0527e, com.umeng.analytics.pro.co> d;
    private static final long e = 7501688097813630241L;
    private static final com.umeng.analytics.pro.dg f = new com.umeng.analytics.pro.dg("ImprintValue");
    private static final com.umeng.analytics.pro.cw g = new com.umeng.analytics.pro.cw("value", (byte) 11, 1);
    private static final com.umeng.analytics.pro.cw h = new com.umeng.analytics.pro.cw("ts", (byte) 10, 2);
    private static final com.umeng.analytics.pro.cw i = new com.umeng.analytics.pro.cw("guid", (byte) 11, 3);
    private static final java.util.Map<java.lang.Class<? extends com.umeng.analytics.pro.dj>, com.umeng.analytics.pro.dk> j;
    private static final int k = 0;
    public java.lang.String a;
    public long b;
    public java.lang.String c;
    private byte l;
    private com.umeng.commonsdk.statistics.proto.e.EnumC0527e[] m;

    public static class a extends com.umeng.analytics.pro.dl<com.umeng.commonsdk.statistics.proto.e> {
        private a() {
        }

        public /* synthetic */ a(com.umeng.commonsdk.statistics.proto.e.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.dj
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(com.umeng.analytics.pro.db dbVar, com.umeng.commonsdk.statistics.proto.e eVar) throws com.umeng.analytics.pro.ci {
            dbVar.j();
            while (true) {
                com.umeng.analytics.pro.cw l = dbVar.l();
                byte b = l.b;
                if (b == 0) {
                    dbVar.k();
                    eVar.k();
                    return;
                }
                short s2 = l.c;
                if (s2 != 1) {
                    if (s2 != 2) {
                        if (s2 != 3) {
                            com.umeng.analytics.pro.de.a(dbVar, b);
                        } else if (b == 11) {
                            eVar.c = dbVar.z();
                            eVar.c(true);
                        } else {
                            com.umeng.analytics.pro.de.a(dbVar, b);
                        }
                    } else if (b == 10) {
                        eVar.b = dbVar.x();
                        eVar.b(true);
                    } else {
                        com.umeng.analytics.pro.de.a(dbVar, b);
                    }
                } else if (b == 11) {
                    eVar.a = dbVar.z();
                    eVar.a(true);
                } else {
                    com.umeng.analytics.pro.de.a(dbVar, b);
                }
                dbVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.dj
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(com.umeng.analytics.pro.db dbVar, com.umeng.commonsdk.statistics.proto.e eVar) throws com.umeng.analytics.pro.ci {
            eVar.k();
            dbVar.a(com.umeng.commonsdk.statistics.proto.e.f);
            if (eVar.a != null && eVar.d()) {
                dbVar.a(com.umeng.commonsdk.statistics.proto.e.g);
                dbVar.a(eVar.a);
                dbVar.c();
            }
            if (eVar.g()) {
                dbVar.a(com.umeng.commonsdk.statistics.proto.e.h);
                dbVar.a(eVar.b);
                dbVar.c();
            }
            if (eVar.c != null && eVar.j()) {
                dbVar.a(com.umeng.commonsdk.statistics.proto.e.i);
                dbVar.a(eVar.c);
                dbVar.c();
            }
            dbVar.d();
            dbVar.b();
        }
    }

    public static class b implements com.umeng.analytics.pro.dk {
        private b() {
        }

        public /* synthetic */ b(com.umeng.commonsdk.statistics.proto.e.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.dk
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.umeng.commonsdk.statistics.proto.e.a b() {
            return new com.umeng.commonsdk.statistics.proto.e.a(null);
        }
    }

    public static class c extends com.umeng.analytics.pro.dm<com.umeng.commonsdk.statistics.proto.e> {
        private c() {
        }

        public /* synthetic */ c(com.umeng.commonsdk.statistics.proto.e.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.dj
        public void a(com.umeng.analytics.pro.db dbVar, com.umeng.commonsdk.statistics.proto.e eVar) throws com.umeng.analytics.pro.ci {
            com.umeng.analytics.pro.dh dhVar = (com.umeng.analytics.pro.dh) dbVar;
            java.util.BitSet bitSet = new java.util.BitSet();
            if (eVar.d()) {
                bitSet.set(0);
            }
            if (eVar.g()) {
                bitSet.set(1);
            }
            if (eVar.j()) {
                bitSet.set(2);
            }
            dhVar.a(bitSet, 3);
            if (eVar.d()) {
                dhVar.a(eVar.a);
            }
            if (eVar.g()) {
                dhVar.a(eVar.b);
            }
            if (eVar.j()) {
                dhVar.a(eVar.c);
            }
        }

        @Override // com.umeng.analytics.pro.dj
        public void b(com.umeng.analytics.pro.db dbVar, com.umeng.commonsdk.statistics.proto.e eVar) throws com.umeng.analytics.pro.ci {
            com.umeng.analytics.pro.dh dhVar = (com.umeng.analytics.pro.dh) dbVar;
            java.util.BitSet b = dhVar.b(3);
            if (b.get(0)) {
                eVar.a = dhVar.z();
                eVar.a(true);
            }
            if (b.get(1)) {
                eVar.b = dhVar.x();
                eVar.b(true);
            }
            if (b.get(2)) {
                eVar.c = dhVar.z();
                eVar.c(true);
            }
        }
    }

    public static class d implements com.umeng.analytics.pro.dk {
        private d() {
        }

        public /* synthetic */ d(com.umeng.commonsdk.statistics.proto.e.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.dk
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.umeng.commonsdk.statistics.proto.e.c b() {
            return new com.umeng.commonsdk.statistics.proto.e.c(null);
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.e$e, reason: collision with other inner class name */
    public enum EnumC0527e implements com.umeng.analytics.pro.cj {
        VALUE(1, "value"),
        TS(2, "ts"),
        GUID(3, "guid");

        private static final java.util.Map<java.lang.String, com.umeng.commonsdk.statistics.proto.e.EnumC0527e> d = new java.util.HashMap();
        private final short e;
        private final java.lang.String f;

        static {
            java.util.Iterator it = java.util.EnumSet.allOf(com.umeng.commonsdk.statistics.proto.e.EnumC0527e.class).iterator();
            while (it.hasNext()) {
                com.umeng.commonsdk.statistics.proto.e.EnumC0527e enumC0527e = (com.umeng.commonsdk.statistics.proto.e.EnumC0527e) it.next();
                d.put(enumC0527e.b(), enumC0527e);
            }
        }

        EnumC0527e(short s2, java.lang.String str) {
            this.e = s2;
            this.f = str;
        }

        public static com.umeng.commonsdk.statistics.proto.e.EnumC0527e a(int i) {
            if (i == 1) {
                return VALUE;
            }
            if (i == 2) {
                return TS;
            }
            if (i != 3) {
                return null;
            }
            return GUID;
        }

        public static com.umeng.commonsdk.statistics.proto.e.EnumC0527e a(java.lang.String str) {
            return d.get(str);
        }

        public static com.umeng.commonsdk.statistics.proto.e.EnumC0527e b(int i) {
            com.umeng.commonsdk.statistics.proto.e.EnumC0527e a = a(i);
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
        hashMap.put(com.umeng.analytics.pro.dl.class, new com.umeng.commonsdk.statistics.proto.e.b(null));
        hashMap.put(com.umeng.analytics.pro.dm.class, new com.umeng.commonsdk.statistics.proto.e.d(null));
        java.util.EnumMap enumMap = new java.util.EnumMap(com.umeng.commonsdk.statistics.proto.e.EnumC0527e.class);
        enumMap.put((java.util.EnumMap) com.umeng.commonsdk.statistics.proto.e.EnumC0527e.VALUE, (com.umeng.commonsdk.statistics.proto.e.EnumC0527e) new com.umeng.analytics.pro.co("value", (byte) 2, new com.umeng.analytics.pro.cp((byte) 11)));
        enumMap.put((java.util.EnumMap) com.umeng.commonsdk.statistics.proto.e.EnumC0527e.TS, (com.umeng.commonsdk.statistics.proto.e.EnumC0527e) new com.umeng.analytics.pro.co("ts", (byte) 2, new com.umeng.analytics.pro.cp((byte) 10)));
        enumMap.put((java.util.EnumMap) com.umeng.commonsdk.statistics.proto.e.EnumC0527e.GUID, (com.umeng.commonsdk.statistics.proto.e.EnumC0527e) new com.umeng.analytics.pro.co("guid", (byte) 2, new com.umeng.analytics.pro.cp((byte) 11)));
        java.util.Map<com.umeng.commonsdk.statistics.proto.e.EnumC0527e, com.umeng.analytics.pro.co> unmodifiableMap = java.util.Collections.unmodifiableMap(enumMap);
        d = unmodifiableMap;
        com.umeng.analytics.pro.co.a(com.umeng.commonsdk.statistics.proto.e.class, unmodifiableMap);
    }

    public e() {
        this.l = (byte) 0;
        this.m = new com.umeng.commonsdk.statistics.proto.e.EnumC0527e[]{com.umeng.commonsdk.statistics.proto.e.EnumC0527e.VALUE, com.umeng.commonsdk.statistics.proto.e.EnumC0527e.TS, com.umeng.commonsdk.statistics.proto.e.EnumC0527e.GUID};
    }

    public e(long j2, java.lang.String str) {
        this();
        this.b = j2;
        b(true);
        this.c = str;
    }

    public e(com.umeng.commonsdk.statistics.proto.e eVar) {
        this.l = (byte) 0;
        this.m = new com.umeng.commonsdk.statistics.proto.e.EnumC0527e[]{com.umeng.commonsdk.statistics.proto.e.EnumC0527e.VALUE, com.umeng.commonsdk.statistics.proto.e.EnumC0527e.TS, com.umeng.commonsdk.statistics.proto.e.EnumC0527e.GUID};
        this.l = eVar.l;
        if (eVar.d()) {
            this.a = eVar.a;
        }
        this.b = eVar.b;
        if (eVar.j()) {
            this.c = eVar.c;
        }
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
    public com.umeng.commonsdk.statistics.proto.e.EnumC0527e fieldForId(int i2) {
        return com.umeng.commonsdk.statistics.proto.e.EnumC0527e.a(i2);
    }

    @Override // com.umeng.analytics.pro.cc
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.umeng.commonsdk.statistics.proto.e deepCopy() {
        return new com.umeng.commonsdk.statistics.proto.e(this);
    }

    public com.umeng.commonsdk.statistics.proto.e a(long j2) {
        this.b = j2;
        b(true);
        return this;
    }

    public com.umeng.commonsdk.statistics.proto.e a(java.lang.String str) {
        this.a = str;
        return this;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
    }

    public com.umeng.commonsdk.statistics.proto.e b(java.lang.String str) {
        this.c = str;
        return this;
    }

    public java.lang.String b() {
        return this.a;
    }

    public void b(boolean z) {
        this.l = com.umeng.analytics.pro.bz.a(this.l, 0, z);
    }

    public void c() {
        this.a = null;
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
        this.b = 0L;
        this.c = null;
    }

    public boolean d() {
        return this.a != null;
    }

    public long e() {
        return this.b;
    }

    public void f() {
        this.l = com.umeng.analytics.pro.bz.b(this.l, 0);
    }

    public boolean g() {
        return com.umeng.analytics.pro.bz.a(this.l, 0);
    }

    public java.lang.String h() {
        return this.c;
    }

    public void i() {
        this.c = null;
    }

    public boolean j() {
        return this.c != null;
    }

    public void k() throws com.umeng.analytics.pro.ci {
    }

    @Override // com.umeng.analytics.pro.cc
    public void read(com.umeng.analytics.pro.db dbVar) throws com.umeng.analytics.pro.ci {
        j.get(dbVar.D()).b().b(dbVar, this);
    }

    public java.lang.String toString() {
        boolean z;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("ImprintValue(");
        if (d()) {
            sb.append("value:");
            java.lang.String str = this.a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("ts:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("guid:");
        java.lang.String str2 = this.c;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str2);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.cc
    public void write(com.umeng.analytics.pro.db dbVar) throws com.umeng.analytics.pro.ci {
        j.get(dbVar.D()).b().a(dbVar, this);
    }
}
