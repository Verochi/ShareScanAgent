package com.tramini.plugin.a.c;

/* loaded from: classes19.dex */
public abstract class a<T> {
    private com.tramini.plugin.a.c.b a;

    private a(com.tramini.plugin.a.c.b bVar) {
        this.a = bVar;
    }

    private android.database.sqlite.SQLiteDatabase d() {
        return this.a.a();
    }

    private android.database.sqlite.SQLiteDatabase e() {
        return this.a.b();
    }

    public abstract long a();

    public abstract long b();

    public abstract boolean c();
}
