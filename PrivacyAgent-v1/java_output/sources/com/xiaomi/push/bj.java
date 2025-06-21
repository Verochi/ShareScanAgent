package com.xiaomi.push;

/* loaded from: classes19.dex */
public class bj {
    private static volatile com.xiaomi.push.bj e;
    android.content.Context a;
    com.xiaomi.push.bi b;
    final java.util.HashMap<java.lang.String, com.xiaomi.push.bh> c = new java.util.HashMap<>();
    java.util.concurrent.ThreadPoolExecutor d = new java.util.concurrent.ThreadPoolExecutor(1, 1, 15, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue());
    private final java.util.ArrayList<com.xiaomi.push.bj.a> f = new java.util.ArrayList<>();

    public static abstract class a implements java.lang.Runnable {
        private java.lang.ref.WeakReference<android.content.Context> a;
        protected java.lang.String b;
        java.lang.String d;
        com.xiaomi.push.bj.a e;
        protected com.xiaomi.push.bh c = null;
        private java.util.Random f = new java.util.Random();
        private int g = 0;

        public a(java.lang.String str) {
            this.d = str;
        }

        public java.lang.Object a() {
            return null;
        }

        public void a(android.content.Context context) {
            com.xiaomi.push.bj.a aVar = this.e;
            if (aVar != null) {
                aVar.a(context, a());
            }
        }

        public abstract void a(android.content.Context context, android.database.sqlite.SQLiteDatabase sQLiteDatabase);

        public void a(android.content.Context context, java.lang.Object obj) {
            com.xiaomi.push.bj.a(context).a(this);
        }

        public final void a(com.xiaomi.push.bh bhVar, android.content.Context context) {
            this.c = bhVar;
            this.b = bhVar.a();
            this.a = new java.lang.ref.WeakReference<>(context);
        }

        public final boolean b() {
            return this.c == null || android.text.TextUtils.isEmpty(this.b) || this.a == null;
        }

        public android.database.sqlite.SQLiteDatabase c() {
            return this.c.getWritableDatabase();
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.content.Context context;
            java.lang.ref.WeakReference<android.content.Context> weakReference = this.a;
            if (weakReference == null || (context = weakReference.get()) == null || context.getFilesDir() == null || this.c == null || android.text.TextUtils.isEmpty(this.d)) {
                return;
            }
            java.io.File file = new java.io.File(this.d);
            new com.xiaomi.push.jg(context, new java.io.File(file.getParentFile(), com.xiaomi.push.an.b(file.getAbsolutePath())), new com.xiaomi.push.bl(this, context)).run();
        }
    }

    public static abstract class b<T> extends com.xiaomi.push.bj.a {
        private java.util.List<java.lang.String> a;
        private java.lang.String f;
        private java.lang.String[] g;
        private java.lang.String h;
        private java.lang.String i;
        private java.lang.String j;
        private int k;
        private java.util.List<T> l;

        public b(java.lang.String str, java.util.List<java.lang.String> list) {
            super(str);
            this.l = new java.util.ArrayList();
            this.a = list;
            this.f = null;
            this.g = null;
            this.h = null;
            this.i = null;
            this.j = null;
            this.k = 0;
        }

        public abstract T a(android.database.Cursor cursor);

        @Override // com.xiaomi.push.bj.a
        public final void a(android.content.Context context, android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
            java.lang.String[] strArr;
            this.l.clear();
            java.util.List<java.lang.String> list = this.a;
            if (list == null || list.size() <= 0) {
                strArr = null;
            } else {
                java.lang.String[] strArr2 = new java.lang.String[this.a.size()];
                this.a.toArray(strArr2);
                strArr = strArr2;
            }
            int i = this.k;
            android.database.Cursor query = sQLiteDatabase.query(this.b, strArr, this.f, this.g, this.h, this.i, this.j, i > 0 ? java.lang.String.valueOf(i) : null);
            if (query != null && query.moveToFirst()) {
                do {
                    T a = a(query);
                    if (a != null) {
                        this.l.add(a);
                    }
                } while (query.moveToNext());
                query.close();
            }
            a(context, (java.util.List) this.l);
        }

        public abstract void a(android.content.Context context, java.util.List<T> list);

        @Override // com.xiaomi.push.bj.a
        public final android.database.sqlite.SQLiteDatabase c() {
            return this.c.getReadableDatabase();
        }
    }

    public static class c extends com.xiaomi.push.bj.a {
        private java.util.ArrayList<com.xiaomi.push.bj.a> a;

        public c(java.lang.String str, java.util.ArrayList<com.xiaomi.push.bj.a> arrayList) {
            super(str);
            java.util.ArrayList<com.xiaomi.push.bj.a> arrayList2 = new java.util.ArrayList<>();
            this.a = arrayList2;
            arrayList2.addAll(arrayList);
        }

        @Override // com.xiaomi.push.bj.a
        public final void a(android.content.Context context) {
            super.a(context);
            java.util.Iterator<com.xiaomi.push.bj.a> it = this.a.iterator();
            while (it.hasNext()) {
                com.xiaomi.push.bj.a next = it.next();
                if (next != null) {
                    next.a(context);
                }
            }
        }

        @Override // com.xiaomi.push.bj.a
        public final void a(android.content.Context context, android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
            java.util.Iterator<com.xiaomi.push.bj.a> it = this.a.iterator();
            while (it.hasNext()) {
                com.xiaomi.push.bj.a next = it.next();
                if (next != null) {
                    next.a(context, sQLiteDatabase);
                }
            }
        }
    }

    public static class d extends com.xiaomi.push.bj.a {
        private java.lang.String a;
        protected java.lang.String[] f;

        public d(java.lang.String str, java.lang.String str2, java.lang.String[] strArr) {
            super(str);
            this.a = str2;
            this.f = strArr;
        }

        @Override // com.xiaomi.push.bj.a
        public final void a(android.content.Context context, android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.b, this.a, this.f);
        }
    }

    public static class e extends com.xiaomi.push.bj.a {
        private android.content.ContentValues a;

        public e(java.lang.String str, android.content.ContentValues contentValues) {
            super(str);
            this.a = contentValues;
        }

        @Override // com.xiaomi.push.bj.a
        public final void a(android.content.Context context, android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.insert(this.b, null, this.a);
        }
    }

    private bj(android.content.Context context) {
        this.a = context;
    }

    public static com.xiaomi.push.bj a(android.content.Context context) {
        if (e == null) {
            synchronized (com.xiaomi.push.bj.class) {
                if (e == null) {
                    e = new com.xiaomi.push.bj(context);
                }
            }
        }
        return e;
    }

    private void a() {
        com.xiaomi.push.m.a(this.a).a((com.xiaomi.push.m.a) new com.xiaomi.push.bk(this), com.xiaomi.push.service.ad.a(this.a).a(com.xiaomi.push.gp.StatDataProcessFrequency.bw, 5));
    }

    public final com.xiaomi.push.bh a(java.lang.String str) {
        com.xiaomi.push.bh bhVar = this.c.get(str);
        if (bhVar == null) {
            synchronized (this.c) {
                if (bhVar == null) {
                    bhVar = this.b.a();
                    this.c.put(str, bhVar);
                }
            }
        }
        return bhVar;
    }

    public final void a(com.xiaomi.push.bj.a aVar) {
        com.xiaomi.push.bh bhVar;
        if (aVar == null) {
            return;
        }
        if (this.b == null) {
            throw new java.lang.IllegalStateException("should exec init method first!");
        }
        java.lang.String str = aVar.d;
        synchronized (this.c) {
            bhVar = this.c.get(str);
            if (bhVar == null) {
                bhVar = this.b.a();
                this.c.put(str, bhVar);
            }
        }
        if (this.d.isShutdown()) {
            return;
        }
        aVar.a(bhVar, this.a);
        synchronized (this.f) {
            this.f.add(aVar);
            a();
        }
    }

    public final void a(java.lang.Runnable runnable) {
        if (this.d.isShutdown()) {
            return;
        }
        this.d.execute(runnable);
    }

    public final void a(java.util.ArrayList<com.xiaomi.push.bj.a> arrayList) {
        if (this.b == null) {
            throw new java.lang.IllegalStateException("should exec setDbHelperFactory method first!");
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        if (this.d.isShutdown()) {
            return;
        }
        java.util.Iterator<com.xiaomi.push.bj.a> it = arrayList.iterator();
        while (it.hasNext()) {
            com.xiaomi.push.bj.a next = it.next();
            if (next.b()) {
                next.a(a(next.d), this.a);
            }
            java.util.ArrayList arrayList2 = (java.util.ArrayList) hashMap.get(next.d);
            if (arrayList2 == null) {
                arrayList2 = new java.util.ArrayList();
                hashMap.put(next.d, arrayList2);
            }
            arrayList2.add(next);
        }
        for (java.lang.String str : hashMap.keySet()) {
            java.util.ArrayList arrayList3 = (java.util.ArrayList) hashMap.get(str);
            if (arrayList3 != null && arrayList3.size() > 0) {
                com.xiaomi.push.bj.c cVar = new com.xiaomi.push.bj.c(str, arrayList3);
                cVar.a(((com.xiaomi.push.bj.a) arrayList3.get(0)).c, this.a);
                this.d.execute(cVar);
            }
        }
    }
}
