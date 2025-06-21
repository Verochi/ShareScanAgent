package com.igexin.c.a.b;

/* loaded from: classes22.dex */
public abstract class d {
    protected java.lang.String c;
    protected com.igexin.c.a.b.d d;
    protected com.igexin.c.a.b.d e;
    protected boolean f;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class a {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        private static final /* synthetic */ int[] d = {1, 2, 3};

        private a(java.lang.String str, int i) {
        }

        private static int[] a() {
            return (int[]) d.clone();
        }
    }

    private d(java.lang.String str) {
        this.c = str;
    }

    public d(java.lang.String str, byte b) {
        this.c = str;
        this.f = true;
    }

    private static int a() {
        return com.igexin.c.a.b.d.a.c;
    }

    private static void a(com.igexin.c.a.b.d dVar, java.lang.String str, java.lang.String str2, com.igexin.c.a.b.d dVar2) {
        if (str2 == null) {
            throw new java.lang.NullPointerException("filter name can't be NULL");
        }
        if (dVar != null) {
            com.igexin.c.a.b.d dVar3 = dVar.e;
            if (dVar.c.equals(str)) {
                dVar2.d = dVar;
                dVar.e = dVar2;
                dVar2.e = dVar3;
                if (dVar3 != null) {
                    dVar3.d = dVar2;
                }
            } else {
                while (dVar3.e != null && !dVar3.c.equals(str)) {
                    dVar3 = dVar3.e;
                }
                com.igexin.c.a.b.d dVar4 = dVar3.e;
                if (dVar4 == null) {
                    dVar3.e = dVar2;
                    dVar2.d = dVar3;
                } else {
                    dVar2.e = dVar4;
                    dVar3.e.d = dVar2;
                    dVar2.d = dVar3;
                    dVar3.e = dVar2;
                }
            }
        }
        dVar2.c = str2;
    }

    private static void b(com.igexin.c.a.b.d dVar, java.lang.String str, java.lang.String str2, com.igexin.c.a.b.d dVar2) {
        if (str2 == null) {
            throw new java.lang.NullPointerException("filter name can't be NULL");
        }
        if (dVar != null) {
            com.igexin.c.a.b.d dVar3 = dVar.d;
            if (dVar.c.equals(str)) {
                dVar.d = dVar2;
                dVar2.e = dVar;
                dVar2.d = dVar3;
                dVar3.e = dVar2;
            } else {
                while (dVar3.d != null && !dVar3.c.equals(str)) {
                    dVar3 = dVar3.d;
                }
                com.igexin.c.a.b.d dVar4 = dVar3.d;
                if (dVar4 == null) {
                    dVar3.d = dVar2;
                    dVar2.e = dVar3;
                } else {
                    dVar4.e = dVar2;
                    dVar2.d = dVar4;
                    dVar2.e = dVar3;
                    dVar3.d = dVar2;
                }
            }
        }
        dVar2.c = str2;
    }

    private static int c() {
        return com.igexin.c.a.b.d.a.c;
    }

    private java.lang.String d() {
        return this.c;
    }

    public final java.lang.Object a(com.igexin.c.a.b.f fVar, java.lang.Object obj) throws java.lang.Exception {
        if (obj == null) {
            throw new java.lang.NullPointerException("Nothing to encode!");
        }
        com.igexin.c.a.b.d dVar = this.d;
        if (dVar != null) {
            obj = dVar.a(fVar, obj);
        }
        return a(obj);
    }

    public abstract java.lang.Object a(java.lang.Object obj) throws java.lang.Exception;

    public final void a(com.igexin.c.a.b.d dVar) {
        if (dVar == null) {
            return;
        }
        com.igexin.c.a.b.d dVar2 = dVar.d;
        dVar.d = this;
        this.e = dVar;
        this.d = dVar2;
    }

    public final com.igexin.c.a.d.a.e b(com.igexin.c.a.b.f fVar, java.lang.Object obj) throws java.lang.Exception {
        java.lang.Object b = b(obj);
        com.igexin.c.a.b.d dVar = this.d;
        if (dVar != null && b != null) {
            b = dVar.b(fVar, b);
        }
        return (com.igexin.c.a.d.a.e) b;
    }

    public abstract java.lang.Object b(java.lang.Object obj) throws java.lang.Exception;

    public final void b() {
        if (this.f) {
            return;
        }
        while (true) {
            com.igexin.c.a.b.d dVar = this.d;
            if (dVar == null) {
                return;
            }
            com.igexin.c.a.b.d dVar2 = dVar.d;
            dVar.d = null;
            this.d = dVar2;
        }
    }
}
