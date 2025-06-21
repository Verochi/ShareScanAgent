package com.igexin.push.b;

/* loaded from: classes.dex */
public abstract class d extends com.igexin.c.a.d.f {
    public static final int l = -2147483640;
    private final java.lang.String a;
    protected android.database.sqlite.SQLiteDatabase d;
    protected android.database.Cursor e;
    android.content.Context f;
    protected java.lang.String[] g;
    protected android.content.ContentValues h;
    protected android.content.ContentValues[] i;
    protected java.lang.Object j;
    public com.igexin.push.b.c k;

    public d() {
        super(1);
        this.a = getClass().getName();
    }

    public d(android.content.ContentValues contentValues) {
        super(1);
        this.a = getClass().getName();
        this.h = contentValues;
    }

    private d(android.content.Context context) {
        super(1);
        this.a = getClass().getName();
        this.f = context;
    }

    private d(android.content.Context context, android.content.ContentValues contentValues) {
        super(1);
        this.a = getClass().getName();
        this.f = context;
        this.h = contentValues;
    }

    private d(android.content.Context context, com.igexin.push.b.c cVar) {
        super(1);
        this.a = getClass().getName();
        this.f = context;
        this.k = cVar;
    }

    private d(android.content.Context context, java.lang.Object obj) {
        super(1);
        this.a = getClass().getName();
        this.f = context;
        this.j = obj;
    }

    private d(android.content.Context context, android.content.ContentValues[] contentValuesArr) {
        super(1);
        this.a = getClass().getName();
        this.f = context;
        this.i = contentValuesArr;
    }

    private d(android.content.Context context, java.lang.String[] strArr) {
        super(1);
        this.a = getClass().getName();
        this.f = context;
        this.g = strArr;
    }

    private void a(com.igexin.push.b.c cVar) {
        this.k = cVar;
    }

    public abstract void a_() throws java.lang.Exception;

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void b_() throws java.lang.Exception {
        super.b_();
        this.d = com.igexin.push.core.d.a.a.i.getWritableDatabase();
        a_();
        if (this.k != null) {
            com.igexin.c.a.b.e.a().a(this.k);
            com.igexin.c.a.b.e.a().b();
        }
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return l;
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void d() {
        this.o = true;
        this.L = true;
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void d_() {
        super.d_();
        android.database.Cursor cursor = this.e;
        if (cursor == null || cursor.isClosed()) {
            return;
        }
        try {
            this.e.close();
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    @Override // com.igexin.c.a.d.f
    public final void e() {
    }

    @Override // com.igexin.c.a.d.f
    public final void f() {
    }
}
