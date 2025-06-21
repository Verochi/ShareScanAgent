package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public abstract class cm<T extends com.umeng.analytics.pro.cm<?, ?>, F extends com.umeng.analytics.pro.cj> implements com.umeng.analytics.pro.cc<T, F> {
    private static final java.util.Map<java.lang.Class<? extends com.umeng.analytics.pro.dj>, com.umeng.analytics.pro.dk> c;
    protected java.lang.Object a;
    protected F b;

    public static class a extends com.umeng.analytics.pro.dl<com.umeng.analytics.pro.cm> {
        private a() {
        }

        public /* synthetic */ a(com.umeng.analytics.pro.cm.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.dj
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(com.umeng.analytics.pro.db dbVar, com.umeng.analytics.pro.cm cmVar) throws com.umeng.analytics.pro.ci {
            cmVar.b = null;
            cmVar.a = null;
            dbVar.j();
            com.umeng.analytics.pro.cw l = dbVar.l();
            java.lang.Object a = cmVar.a(dbVar, l);
            cmVar.a = a;
            if (a != null) {
                cmVar.b = (F) cmVar.a(l.c);
            }
            dbVar.m();
            dbVar.l();
            dbVar.k();
        }

        @Override // com.umeng.analytics.pro.dj
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(com.umeng.analytics.pro.db dbVar, com.umeng.analytics.pro.cm cmVar) throws com.umeng.analytics.pro.ci {
            if (cmVar.a() == null || cmVar.b() == null) {
                throw new com.umeng.analytics.pro.dc("Cannot write a TUnion with no set value!");
            }
            dbVar.a(cmVar.d());
            dbVar.a(cmVar.c(cmVar.b));
            cmVar.a(dbVar);
            dbVar.c();
            dbVar.d();
            dbVar.b();
        }
    }

    public static class b implements com.umeng.analytics.pro.dk {
        private b() {
        }

        public /* synthetic */ b(com.umeng.analytics.pro.cm.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.dk
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.umeng.analytics.pro.cm.a b() {
            return new com.umeng.analytics.pro.cm.a(null);
        }
    }

    public static class c extends com.umeng.analytics.pro.dm<com.umeng.analytics.pro.cm> {
        private c() {
        }

        public /* synthetic */ c(com.umeng.analytics.pro.cm.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.dj
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(com.umeng.analytics.pro.db dbVar, com.umeng.analytics.pro.cm cmVar) throws com.umeng.analytics.pro.ci {
            cmVar.b = null;
            cmVar.a = null;
            short v = dbVar.v();
            java.lang.Object a = cmVar.a(dbVar, v);
            cmVar.a = a;
            if (a != null) {
                cmVar.b = (F) cmVar.a(v);
            }
        }

        @Override // com.umeng.analytics.pro.dj
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(com.umeng.analytics.pro.db dbVar, com.umeng.analytics.pro.cm cmVar) throws com.umeng.analytics.pro.ci {
            if (cmVar.a() == null || cmVar.b() == null) {
                throw new com.umeng.analytics.pro.dc("Cannot write a TUnion with no set value!");
            }
            dbVar.a(cmVar.b.a());
            cmVar.b(dbVar);
        }
    }

    public static class d implements com.umeng.analytics.pro.dk {
        private d() {
        }

        public /* synthetic */ d(com.umeng.analytics.pro.cm.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.dk
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.umeng.analytics.pro.cm.c b() {
            return new com.umeng.analytics.pro.cm.c(null);
        }
    }

    static {
        java.util.HashMap hashMap = new java.util.HashMap();
        c = hashMap;
        hashMap.put(com.umeng.analytics.pro.dl.class, new com.umeng.analytics.pro.cm.b(null));
        hashMap.put(com.umeng.analytics.pro.dm.class, new com.umeng.analytics.pro.cm.d(null));
    }

    public cm() {
        this.b = null;
        this.a = null;
    }

    public cm(F f, java.lang.Object obj) {
        a((com.umeng.analytics.pro.cm<T, F>) f, obj);
    }

    public cm(com.umeng.analytics.pro.cm<T, F> cmVar) {
        if (!cmVar.getClass().equals(getClass())) {
            throw new java.lang.ClassCastException();
        }
        this.b = cmVar.b;
        this.a = a(cmVar.a);
    }

    private static java.lang.Object a(java.lang.Object obj) {
        return obj instanceof com.umeng.analytics.pro.cc ? ((com.umeng.analytics.pro.cc) obj).deepCopy() : obj instanceof java.nio.ByteBuffer ? com.umeng.analytics.pro.cd.d((java.nio.ByteBuffer) obj) : obj instanceof java.util.List ? a((java.util.List) obj) : obj instanceof java.util.Set ? a((java.util.Set) obj) : obj instanceof java.util.Map ? a((java.util.Map<java.lang.Object, java.lang.Object>) obj) : obj;
    }

    private static java.util.List a(java.util.List list) {
        java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return arrayList;
    }

    private static java.util.Map a(java.util.Map<java.lang.Object, java.lang.Object> map) {
        java.util.HashMap hashMap = new java.util.HashMap();
        for (java.util.Map.Entry<java.lang.Object, java.lang.Object> entry : map.entrySet()) {
            hashMap.put(a(entry.getKey()), a(entry.getValue()));
        }
        return hashMap;
    }

    private static java.util.Set a(java.util.Set set) {
        java.util.HashSet hashSet = new java.util.HashSet();
        java.util.Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(a(it.next()));
        }
        return hashSet;
    }

    public F a() {
        return this.b;
    }

    public abstract F a(short s2);

    public java.lang.Object a(int i) {
        return a((com.umeng.analytics.pro.cm<T, F>) a((short) i));
    }

    public java.lang.Object a(F f) {
        if (f == this.b) {
            return b();
        }
        throw new java.lang.IllegalArgumentException("Cannot get the value of field " + f + " because union's set field is " + this.b);
    }

    public abstract java.lang.Object a(com.umeng.analytics.pro.db dbVar, com.umeng.analytics.pro.cw cwVar) throws com.umeng.analytics.pro.ci;

    public abstract java.lang.Object a(com.umeng.analytics.pro.db dbVar, short s2) throws com.umeng.analytics.pro.ci;

    public void a(int i, java.lang.Object obj) {
        a((com.umeng.analytics.pro.cm<T, F>) a((short) i), obj);
    }

    public void a(F f, java.lang.Object obj) {
        b(f, obj);
        this.b = f;
        this.a = obj;
    }

    public abstract void a(com.umeng.analytics.pro.db dbVar) throws com.umeng.analytics.pro.ci;

    public java.lang.Object b() {
        return this.a;
    }

    public abstract void b(F f, java.lang.Object obj) throws java.lang.ClassCastException;

    public abstract void b(com.umeng.analytics.pro.db dbVar) throws com.umeng.analytics.pro.ci;

    public boolean b(int i) {
        return b((com.umeng.analytics.pro.cm<T, F>) a((short) i));
    }

    public boolean b(F f) {
        return this.b == f;
    }

    public abstract com.umeng.analytics.pro.cw c(F f);

    public boolean c() {
        return this.b != null;
    }

    @Override // com.umeng.analytics.pro.cc
    public final void clear() {
        this.b = null;
        this.a = null;
    }

    public abstract com.umeng.analytics.pro.dg d();

    @Override // com.umeng.analytics.pro.cc
    public void read(com.umeng.analytics.pro.db dbVar) throws com.umeng.analytics.pro.ci {
        c.get(dbVar.D()).b().b(dbVar, this);
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("<");
        sb.append(getClass().getSimpleName());
        sb.append(" ");
        if (a() != null) {
            java.lang.Object b2 = b();
            sb.append(c(a()).a);
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            if (b2 instanceof java.nio.ByteBuffer) {
                com.umeng.analytics.pro.cd.a((java.nio.ByteBuffer) b2, sb);
            } else {
                sb.append(b2.toString());
            }
        }
        sb.append(">");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.cc
    public void write(com.umeng.analytics.pro.db dbVar) throws com.umeng.analytics.pro.ci {
        c.get(dbVar.D()).b().a(dbVar, this);
    }
}
