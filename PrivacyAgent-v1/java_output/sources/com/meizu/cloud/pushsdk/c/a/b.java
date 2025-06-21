package com.meizu.cloud.pushsdk.c.a;

/* loaded from: classes23.dex */
public class b<T extends com.meizu.cloud.pushsdk.c.a.b> {
    private static final java.lang.String a = "b";
    private static final com.meizu.cloud.pushsdk.c.c.g w = com.meizu.cloud.pushsdk.c.c.g.a("application/json; charset=utf-8");
    private static final com.meizu.cloud.pushsdk.c.c.g x = com.meizu.cloud.pushsdk.c.c.g.a("text/x-markdown; charset=utf-8");
    private static final java.lang.Object z = new java.lang.Object();
    private com.meizu.cloud.pushsdk.c.c.a A;
    private int B;
    private boolean C;
    private int D;
    private com.meizu.cloud.pushsdk.c.d.a E;
    private android.graphics.Bitmap.Config F;
    private int G;
    private int H;
    private android.widget.ImageView.ScaleType I;
    private final java.util.concurrent.Executor J;
    private java.lang.String K;
    private java.lang.reflect.Type L;
    private final int b;
    private final com.meizu.cloud.pushsdk.c.a.d c;
    private final int d;
    private final java.lang.String e;
    private int f;
    private final java.lang.Object g;
    private com.meizu.cloud.pushsdk.c.a.e h;
    private final java.util.HashMap<java.lang.String, java.lang.String> i;
    private java.util.HashMap<java.lang.String, java.lang.String> j;
    private java.util.HashMap<java.lang.String, java.lang.String> k;
    private java.util.HashMap<java.lang.String, java.lang.String> l;
    private final java.util.HashMap<java.lang.String, java.lang.String> m;
    private final java.util.HashMap<java.lang.String, java.lang.String> n;
    private java.util.HashMap<java.lang.String, java.io.File> o;
    private java.lang.String p;
    private java.lang.String q;
    private org.json.JSONObject r;

    /* renamed from: s, reason: collision with root package name */
    private org.json.JSONArray f418s;
    private java.lang.String t;
    private byte[] u;
    private java.io.File v;
    private com.meizu.cloud.pushsdk.c.c.g y;

    /* renamed from: com.meizu.cloud.pushsdk.c.a.b$1, reason: invalid class name */
    public class AnonymousClass1 implements com.meizu.cloud.pushsdk.c.d.a {
        public AnonymousClass1() {
        }

        @Override // com.meizu.cloud.pushsdk.c.d.a
        public void a(long j, long j2) {
            com.meizu.cloud.pushsdk.c.a.b.this.B = (int) ((100 * j) / j2);
            if (com.meizu.cloud.pushsdk.c.a.b.this.E == null || com.meizu.cloud.pushsdk.c.a.b.this.C) {
                return;
            }
            com.meizu.cloud.pushsdk.c.a.b.this.E.a(j, j2);
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.c.a.b$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.meizu.cloud.pushsdk.c.a.e.values().length];
            a = iArr;
            try {
                iArr[com.meizu.cloud.pushsdk.c.a.e.JSON_ARRAY.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.meizu.cloud.pushsdk.c.a.e.JSON_OBJECT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.meizu.cloud.pushsdk.c.a.e.STRING.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[com.meizu.cloud.pushsdk.c.a.e.BITMAP.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                a[com.meizu.cloud.pushsdk.c.a.e.PREFETCH.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
        }
    }

    public static class a<T extends com.meizu.cloud.pushsdk.c.a.b.a> {
        private final java.lang.String b;
        private java.lang.Object c;
        private final java.lang.String g;
        private final java.lang.String h;
        private java.util.concurrent.Executor j;
        private java.lang.String k;
        private com.meizu.cloud.pushsdk.c.a.d a = com.meizu.cloud.pushsdk.c.a.d.MEDIUM;
        private final java.util.HashMap<java.lang.String, java.lang.String> d = new java.util.HashMap<>();
        private final java.util.HashMap<java.lang.String, java.lang.String> e = new java.util.HashMap<>();
        private final java.util.HashMap<java.lang.String, java.lang.String> f = new java.util.HashMap<>();
        private int i = 0;

        public a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
            this.b = str;
            this.g = str2;
            this.h = str3;
        }

        public com.meizu.cloud.pushsdk.c.a.b a() {
            return new com.meizu.cloud.pushsdk.c.a.b(this);
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.c.a.b$b, reason: collision with other inner class name */
    public static class C0422b<T extends com.meizu.cloud.pushsdk.c.a.b.C0422b> {
        private final java.lang.String c;
        private java.lang.Object d;
        private android.graphics.Bitmap.Config e;
        private int f;
        private int g;
        private android.widget.ImageView.ScaleType h;
        private java.util.concurrent.Executor l;
        private java.lang.String m;
        private com.meizu.cloud.pushsdk.c.a.d a = com.meizu.cloud.pushsdk.c.a.d.MEDIUM;
        private final java.util.HashMap<java.lang.String, java.lang.String> i = new java.util.HashMap<>();
        private final java.util.HashMap<java.lang.String, java.lang.String> j = new java.util.HashMap<>();
        private final java.util.HashMap<java.lang.String, java.lang.String> k = new java.util.HashMap<>();
        private final int b = 0;

        public C0422b(java.lang.String str) {
            this.c = str;
        }

        public T a(java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
            if (hashMap != null) {
                for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : hashMap.entrySet()) {
                    this.j.put(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        public com.meizu.cloud.pushsdk.c.a.b a() {
            return new com.meizu.cloud.pushsdk.c.a.b(this);
        }
    }

    public static class c<T extends com.meizu.cloud.pushsdk.c.a.b.c> {
        private final java.lang.String b;
        private java.lang.Object c;
        private java.util.concurrent.Executor j;
        private java.lang.String k;
        private java.lang.String l;
        private com.meizu.cloud.pushsdk.c.a.d a = com.meizu.cloud.pushsdk.c.a.d.MEDIUM;
        private final java.util.HashMap<java.lang.String, java.lang.String> d = new java.util.HashMap<>();
        private final java.util.HashMap<java.lang.String, java.lang.String> e = new java.util.HashMap<>();
        private final java.util.HashMap<java.lang.String, java.lang.String> f = new java.util.HashMap<>();
        private final java.util.HashMap<java.lang.String, java.lang.String> g = new java.util.HashMap<>();
        private final java.util.HashMap<java.lang.String, java.io.File> h = new java.util.HashMap<>();
        private int i = 0;

        public c(java.lang.String str) {
            this.b = str;
        }

        public T a(java.lang.String str, java.io.File file) {
            this.h.put(str, file);
            return this;
        }

        public T a(java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
            if (hashMap != null) {
                for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : hashMap.entrySet()) {
                    this.e.put(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        public com.meizu.cloud.pushsdk.c.a.b a() {
            return new com.meizu.cloud.pushsdk.c.a.b(this);
        }
    }

    public static class d<T extends com.meizu.cloud.pushsdk.c.a.b.d> {
        private final java.lang.String c;
        private java.lang.Object d;
        private java.util.concurrent.Executor o;
        private java.lang.String p;
        private java.lang.String q;
        private com.meizu.cloud.pushsdk.c.a.d a = com.meizu.cloud.pushsdk.c.a.d.MEDIUM;
        private org.json.JSONObject e = null;
        private org.json.JSONArray f = null;
        private java.lang.String g = null;
        private byte[] h = null;
        private java.io.File i = null;
        private final java.util.HashMap<java.lang.String, java.lang.String> j = new java.util.HashMap<>();
        private final java.util.HashMap<java.lang.String, java.lang.String> k = new java.util.HashMap<>();
        private final java.util.HashMap<java.lang.String, java.lang.String> l = new java.util.HashMap<>();
        private final java.util.HashMap<java.lang.String, java.lang.String> m = new java.util.HashMap<>();
        private final java.util.HashMap<java.lang.String, java.lang.String> n = new java.util.HashMap<>();
        private final int b = 1;

        public d(java.lang.String str) {
            this.c = str;
        }

        public T a(java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
            if (hashMap != null) {
                for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : hashMap.entrySet()) {
                    this.k.put(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        public com.meizu.cloud.pushsdk.c.a.b a() {
            return new com.meizu.cloud.pushsdk.c.a.b(this);
        }
    }

    public b(com.meizu.cloud.pushsdk.c.a.b.a aVar) {
        this.j = new java.util.HashMap<>();
        this.k = new java.util.HashMap<>();
        this.l = new java.util.HashMap<>();
        this.o = new java.util.HashMap<>();
        this.r = null;
        this.f418s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.y = null;
        this.D = 0;
        this.L = null;
        this.d = 1;
        this.b = 0;
        this.c = aVar.a;
        this.e = aVar.b;
        this.g = aVar.c;
        this.p = aVar.g;
        this.q = aVar.h;
        this.i = aVar.d;
        this.m = aVar.e;
        this.n = aVar.f;
        this.D = aVar.i;
        this.J = aVar.j;
        this.K = aVar.k;
    }

    public b(com.meizu.cloud.pushsdk.c.a.b.C0422b c0422b) {
        this.j = new java.util.HashMap<>();
        this.k = new java.util.HashMap<>();
        this.l = new java.util.HashMap<>();
        this.o = new java.util.HashMap<>();
        this.r = null;
        this.f418s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.y = null;
        this.D = 0;
        this.L = null;
        this.d = 0;
        this.b = c0422b.b;
        this.c = c0422b.a;
        this.e = c0422b.c;
        this.g = c0422b.d;
        this.i = c0422b.i;
        this.F = c0422b.e;
        this.H = c0422b.g;
        this.G = c0422b.f;
        this.I = c0422b.h;
        this.m = c0422b.j;
        this.n = c0422b.k;
        this.J = c0422b.l;
        this.K = c0422b.m;
    }

    public b(com.meizu.cloud.pushsdk.c.a.b.c cVar) {
        this.j = new java.util.HashMap<>();
        this.k = new java.util.HashMap<>();
        this.l = new java.util.HashMap<>();
        this.o = new java.util.HashMap<>();
        this.r = null;
        this.f418s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.y = null;
        this.D = 0;
        this.L = null;
        this.d = 2;
        this.b = 1;
        this.c = cVar.a;
        this.e = cVar.b;
        this.g = cVar.c;
        this.i = cVar.d;
        this.m = cVar.f;
        this.n = cVar.g;
        this.l = cVar.e;
        this.o = cVar.h;
        this.D = cVar.i;
        this.J = cVar.j;
        this.K = cVar.k;
        if (cVar.l != null) {
            this.y = com.meizu.cloud.pushsdk.c.c.g.a(cVar.l);
        }
    }

    public b(com.meizu.cloud.pushsdk.c.a.b.d dVar) {
        this.j = new java.util.HashMap<>();
        this.k = new java.util.HashMap<>();
        this.l = new java.util.HashMap<>();
        this.o = new java.util.HashMap<>();
        this.r = null;
        this.f418s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.y = null;
        this.D = 0;
        this.L = null;
        this.d = 0;
        this.b = dVar.b;
        this.c = dVar.a;
        this.e = dVar.c;
        this.g = dVar.d;
        this.i = dVar.j;
        this.j = dVar.k;
        this.k = dVar.l;
        this.m = dVar.m;
        this.n = dVar.n;
        this.r = dVar.e;
        this.f418s = dVar.f;
        this.t = dVar.g;
        this.v = dVar.i;
        this.u = dVar.h;
        this.J = dVar.o;
        this.K = dVar.p;
        if (dVar.q != null) {
            this.y = com.meizu.cloud.pushsdk.c.c.g.a(dVar.q);
        }
    }

    public com.meizu.cloud.pushsdk.c.a.c a() {
        this.h = com.meizu.cloud.pushsdk.c.a.e.STRING;
        return com.meizu.cloud.pushsdk.c.e.c.a(this);
    }

    public com.meizu.cloud.pushsdk.c.a.c a(com.meizu.cloud.pushsdk.c.c.k kVar) {
        com.meizu.cloud.pushsdk.c.a.c<android.graphics.Bitmap> a2;
        int i = com.meizu.cloud.pushsdk.c.a.b.AnonymousClass2.a[this.h.ordinal()];
        if (i == 1) {
            try {
                return com.meizu.cloud.pushsdk.c.a.c.a(new org.json.JSONArray(com.meizu.cloud.pushsdk.c.g.g.a(kVar.b().a()).h()));
            } catch (java.lang.Exception e) {
                return com.meizu.cloud.pushsdk.c.a.c.a(com.meizu.cloud.pushsdk.c.h.b.b(new com.meizu.cloud.pushsdk.c.b.a(e)));
            }
        }
        if (i == 2) {
            try {
                return com.meizu.cloud.pushsdk.c.a.c.a(new org.json.JSONObject(com.meizu.cloud.pushsdk.c.g.g.a(kVar.b().a()).h()));
            } catch (java.lang.Exception e2) {
                return com.meizu.cloud.pushsdk.c.a.c.a(com.meizu.cloud.pushsdk.c.h.b.b(new com.meizu.cloud.pushsdk.c.b.a(e2)));
            }
        }
        if (i == 3) {
            try {
                return com.meizu.cloud.pushsdk.c.a.c.a(com.meizu.cloud.pushsdk.c.g.g.a(kVar.b().a()).h());
            } catch (java.lang.Exception e3) {
                return com.meizu.cloud.pushsdk.c.a.c.a(com.meizu.cloud.pushsdk.c.h.b.b(new com.meizu.cloud.pushsdk.c.b.a(e3)));
            }
        }
        if (i != 4) {
            if (i != 5) {
                return null;
            }
            return com.meizu.cloud.pushsdk.c.a.c.a("prefetch");
        }
        synchronized (z) {
            try {
                try {
                    a2 = com.meizu.cloud.pushsdk.c.h.b.a(kVar, this.G, this.H, this.F, this.I);
                } catch (java.lang.Throwable th) {
                    throw th;
                }
            } catch (java.lang.Exception e4) {
                return com.meizu.cloud.pushsdk.c.a.c.a(com.meizu.cloud.pushsdk.c.h.b.b(new com.meizu.cloud.pushsdk.c.b.a(e4)));
            }
        }
        return a2;
    }

    public com.meizu.cloud.pushsdk.c.b.a a(com.meizu.cloud.pushsdk.c.b.a aVar) {
        try {
            if (aVar.a() != null && aVar.a().b() != null && aVar.a().b().a() != null) {
                aVar.b(com.meizu.cloud.pushsdk.c.g.g.a(aVar.a().b().a()).h());
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return aVar;
    }

    public void a(com.meizu.cloud.pushsdk.c.c.a aVar) {
        this.A = aVar;
    }

    public void a(java.lang.String str) {
        this.K = str;
    }

    public com.meizu.cloud.pushsdk.c.a.c b() {
        this.h = com.meizu.cloud.pushsdk.c.a.e.BITMAP;
        return com.meizu.cloud.pushsdk.c.e.c.a(this);
    }

    public com.meizu.cloud.pushsdk.c.a.c c() {
        return com.meizu.cloud.pushsdk.c.e.c.a(this);
    }

    public int d() {
        return this.b;
    }

    public java.lang.String e() {
        java.lang.String str = this.e;
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : this.n.entrySet()) {
            str = str.replace("{" + entry.getKey() + com.alipay.sdk.m.u.i.d, java.lang.String.valueOf(entry.getValue()));
        }
        com.meizu.cloud.pushsdk.c.c.f.a f = com.meizu.cloud.pushsdk.c.c.f.c(str).f();
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry2 : this.m.entrySet()) {
            f.a(entry2.getKey(), entry2.getValue());
        }
        return f.b().toString();
    }

    public boolean equals(java.lang.Object obj) {
        return super.equals(obj);
    }

    public com.meizu.cloud.pushsdk.c.a.e f() {
        return this.h;
    }

    public int g() {
        return this.d;
    }

    public java.lang.String h() {
        return this.K;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public com.meizu.cloud.pushsdk.c.d.a i() {
        return new com.meizu.cloud.pushsdk.c.a.b.AnonymousClass1();
    }

    public java.lang.String j() {
        return this.p;
    }

    public java.lang.String k() {
        return this.q;
    }

    public com.meizu.cloud.pushsdk.c.c.a l() {
        return this.A;
    }

    public com.meizu.cloud.pushsdk.c.c.j m() {
        org.json.JSONObject jSONObject = this.r;
        if (jSONObject != null) {
            com.meizu.cloud.pushsdk.c.c.g gVar = this.y;
            return gVar != null ? com.meizu.cloud.pushsdk.c.c.j.a(gVar, jSONObject.toString()) : com.meizu.cloud.pushsdk.c.c.j.a(w, jSONObject.toString());
        }
        org.json.JSONArray jSONArray = this.f418s;
        if (jSONArray != null) {
            com.meizu.cloud.pushsdk.c.c.g gVar2 = this.y;
            return gVar2 != null ? com.meizu.cloud.pushsdk.c.c.j.a(gVar2, jSONArray.toString()) : com.meizu.cloud.pushsdk.c.c.j.a(w, jSONArray.toString());
        }
        java.lang.String str = this.t;
        if (str != null) {
            com.meizu.cloud.pushsdk.c.c.g gVar3 = this.y;
            return gVar3 != null ? com.meizu.cloud.pushsdk.c.c.j.a(gVar3, str) : com.meizu.cloud.pushsdk.c.c.j.a(x, str);
        }
        java.io.File file = this.v;
        if (file != null) {
            com.meizu.cloud.pushsdk.c.c.g gVar4 = this.y;
            return gVar4 != null ? com.meizu.cloud.pushsdk.c.c.j.a(gVar4, file) : com.meizu.cloud.pushsdk.c.c.j.a(x, file);
        }
        byte[] bArr = this.u;
        if (bArr != null) {
            com.meizu.cloud.pushsdk.c.c.g gVar5 = this.y;
            return gVar5 != null ? com.meizu.cloud.pushsdk.c.c.j.a(gVar5, bArr) : com.meizu.cloud.pushsdk.c.c.j.a(x, bArr);
        }
        com.meizu.cloud.pushsdk.c.c.b.a aVar = new com.meizu.cloud.pushsdk.c.c.b.a();
        try {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : this.j.entrySet()) {
                if (!android.text.TextUtils.isEmpty(entry.getKey()) && !android.text.TextUtils.isEmpty(entry.getValue())) {
                    aVar.a(entry.getKey(), entry.getValue());
                }
            }
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry2 : this.k.entrySet()) {
                if (!android.text.TextUtils.isEmpty(entry2.getKey()) && !android.text.TextUtils.isEmpty(entry2.getValue())) {
                    aVar.b(entry2.getKey(), entry2.getValue());
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return aVar.a();
    }

    public com.meizu.cloud.pushsdk.c.c.j n() {
        com.meizu.cloud.pushsdk.c.c.h.a a2 = new com.meizu.cloud.pushsdk.c.c.h.a().a(com.meizu.cloud.pushsdk.c.c.h.e);
        try {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : this.l.entrySet()) {
                a2.a(com.meizu.cloud.pushsdk.c.c.c.a("Content-Disposition", "form-data; name=\"" + entry.getKey() + "\""), com.meizu.cloud.pushsdk.c.c.j.a((com.meizu.cloud.pushsdk.c.c.g) null, entry.getValue()));
            }
            for (java.util.Map.Entry<java.lang.String, java.io.File> entry2 : this.o.entrySet()) {
                if (entry2.getValue() != null) {
                    java.lang.String name = entry2.getValue().getName();
                    a2.a(com.meizu.cloud.pushsdk.c.c.c.a("Content-Disposition", "form-data; name=\"" + entry2.getKey() + "\"; filename=\"" + name + "\""), com.meizu.cloud.pushsdk.c.c.j.a(com.meizu.cloud.pushsdk.c.c.g.a(com.meizu.cloud.pushsdk.c.h.b.a(name)), entry2.getValue()));
                    com.meizu.cloud.pushsdk.c.c.g gVar = this.y;
                    if (gVar != null) {
                        a2.a(gVar);
                    }
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return a2.a();
    }

    public com.meizu.cloud.pushsdk.c.c.c o() {
        com.meizu.cloud.pushsdk.c.c.c.a aVar = new com.meizu.cloud.pushsdk.c.c.c.a();
        try {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : this.i.entrySet()) {
                aVar.a(entry.getKey(), entry.getValue());
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return aVar.a();
    }

    public java.lang.String toString() {
        return "ANRequest{sequenceNumber='" + this.f + ", mMethod=" + this.b + ", mPriority=" + this.c + ", mRequestType=" + this.d + ", mUrl=" + this.e + '}';
    }
}
