package com.igexin.push.b;

/* loaded from: classes.dex */
public class a extends com.igexin.c.a.d.f {
    public static int a = 0;
    public static final int b = -980948;
    public static final int g = -2147483639;
    private static final java.lang.String h = "com.igexin.push.b.a";
    protected android.database.sqlite.SQLiteDatabase c;
    protected android.database.Cursor d;
    java.util.List<com.igexin.push.core.e.a> e;
    boolean f;

    public a() {
        super(1);
        this.e = new java.util.LinkedList();
    }

    private void b(boolean z) {
        this.f = z;
    }

    public final void a(com.igexin.push.core.e.a aVar) {
        this.e.add(aVar);
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void b_() throws java.lang.Exception {
        super.b_();
        android.database.sqlite.SQLiteDatabase writableDatabase = com.igexin.push.core.d.a.a.i.getWritableDatabase();
        this.c = writableDatabase;
        writableDatabase.setVersion(7);
        java.util.Iterator<com.igexin.push.core.e.a> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().a(this.c);
        }
        for (com.igexin.push.core.e.a aVar : this.e) {
            if (this.f) {
                aVar.c(this.c);
            } else {
                aVar.b(this.c);
            }
        }
        com.igexin.c.a.b.e.a().a(new com.igexin.push.b.c());
        com.igexin.c.a.b.e.a().b();
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return -2147483639;
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void d() {
        super.d();
        this.o = true;
        this.L = true;
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void d_() {
        super.d_();
        android.database.Cursor cursor = this.d;
        if (cursor != null) {
            try {
                cursor.close();
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
    }

    @Override // com.igexin.c.a.d.f
    public final void e() {
    }

    @Override // com.igexin.c.a.d.f
    public final void f() {
    }
}
