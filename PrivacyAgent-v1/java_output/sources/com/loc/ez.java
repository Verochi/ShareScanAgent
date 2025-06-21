package com.loc;

/* loaded from: classes23.dex */
public abstract class ez<T> {
    public java.lang.String a;
    private java.io.File b;
    private android.os.Handler e;
    private java.lang.String f;
    private boolean g;
    private boolean c = false;
    private java.util.Map<java.lang.String, com.loc.ez.a> d = new java.util.concurrent.ConcurrentHashMap();
    private java.lang.Runnable h = new com.loc.ez.AnonymousClass2();

    /* renamed from: com.loc.ez$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.Comparator<java.lang.String> {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(java.lang.String str, java.lang.String str2) {
            return com.loc.ez.a(((com.loc.ez.a) com.loc.ez.this.d.get(str2)).c, ((com.loc.ez.a) com.loc.ez.this.d.get(str)).c);
        }
    }

    /* renamed from: com.loc.ez$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.loc.ez.this.c) {
                if (com.loc.ez.this.g) {
                    com.loc.ez.this.e();
                    com.loc.ez.e(com.loc.ez.this);
                }
                if (com.loc.ez.this.e != null) {
                    com.loc.ez.this.e.postDelayed(com.loc.ez.this.h, 60000L);
                }
            }
        }
    }

    public static class a {
        int a;
        long b;
        long c;

        public a(int i, long j, long j2) {
            this.a = i;
            this.b = j;
            this.c = j2;
        }
    }

    public ez(android.content.Context context, java.lang.String str, android.os.Handler handler) {
        this.f = null;
        if (context == null) {
            return;
        }
        this.e = handler;
        this.a = android.text.TextUtils.isEmpty(str) ? "unknow" : str;
        this.f = com.loc.gd.l(context);
        try {
            this.b = new java.io.File(context.getFilesDir().getPath(), this.a);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        d();
    }

    public static int a(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    private void b(T t, long j) {
        if (t == null || d((com.loc.ez<T>) t) < 0) {
            return;
        }
        java.lang.String b = b((com.loc.ez<T>) t);
        com.loc.ez.a aVar = this.d.get(b);
        if (aVar == null) {
            a((com.loc.ez<T>) t, j);
            this.d.put(b, new com.loc.ez.a(c((com.loc.ez<T>) t), d((com.loc.ez<T>) t), j));
            this.g = true;
            return;
        }
        aVar.c = j;
        if (aVar.a == c((com.loc.ez<T>) t)) {
            a((com.loc.ez<T>) t, aVar.b);
            return;
        }
        a((com.loc.ez<T>) t, j);
        aVar.a = c((com.loc.ez<T>) t);
        aVar.b = d((com.loc.ez<T>) t);
        this.g = true;
    }

    private void d() {
        try {
            java.util.Iterator<java.lang.String> it = com.loc.gd.a(this.b).iterator();
            while (it.hasNext()) {
                try {
                    java.lang.String[] split = new java.lang.String(com.loc.fk.b(com.loc.q.b(it.next()), this.f), "UTF-8").split(",");
                    this.d.put(split[0], new com.loc.ez.a(java.lang.Integer.parseInt(split[1]), java.lang.Long.parseLong(split[2]), split.length >= 4 ? java.lang.Long.parseLong(split[3]) : com.loc.gd.b()));
                } catch (java.lang.Throwable th) {
                    if (this.b.exists()) {
                        this.b.delete();
                    }
                    th.printStackTrace();
                }
            }
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (c() > 0) {
            this.d.size();
            if (b() > 0) {
                long b = com.loc.gd.b();
                java.util.Iterator<java.util.Map.Entry<java.lang.String, com.loc.ez.a>> it = this.d.entrySet().iterator();
                while (it.hasNext()) {
                    if (b - this.d.get(it.next().getKey()).c > b()) {
                        it.remove();
                    }
                }
            }
            if (this.d.size() > c()) {
                java.util.ArrayList arrayList = new java.util.ArrayList(this.d.keySet());
                java.util.Collections.sort(arrayList, new com.loc.ez.AnonymousClass1());
                for (int c = (int) c(); c < arrayList.size(); c++) {
                    this.d.remove(arrayList.get(c));
                }
            }
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.util.Map.Entry<java.lang.String, com.loc.ez.a> entry : this.d.entrySet()) {
            try {
                sb.append(com.loc.q.b(com.loc.fk.a((entry.getKey() + "," + entry.getValue().a + "," + entry.getValue().b + "," + entry.getValue().c).getBytes("UTF-8"), this.f)) + "\n");
            } catch (java.io.UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        java.lang.String sb2 = sb.toString();
        if (android.text.TextUtils.isEmpty(sb2)) {
            return;
        }
        com.loc.gd.a(this.b, sb2);
    }

    public static /* synthetic */ boolean e(com.loc.ez ezVar) {
        ezVar.g = false;
        return false;
    }

    public final void a() {
        android.os.Handler handler;
        if (!this.c && (handler = this.e) != null) {
            handler.removeCallbacks(this.h);
            this.e.postDelayed(this.h, 60000L);
        }
        this.c = true;
    }

    public final void a(T t) {
        b(t, com.loc.gd.b());
    }

    public abstract void a(T t, long j);

    public final void a(java.util.List<T> list) {
        long b = com.loc.gd.b();
        java.util.Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            b(it.next(), b);
        }
        if (this.d.size() >= list.size()) {
            this.g = true;
        }
        if (this.d.size() > 16384 || c() <= 0) {
            this.d.clear();
            for (T t : list) {
                this.d.put(b((com.loc.ez<T>) t), new com.loc.ez.a(c((com.loc.ez<T>) t), d((com.loc.ez<T>) t), b));
            }
        }
    }

    public final void a(boolean z) {
        android.os.Handler handler = this.e;
        if (handler != null) {
            handler.removeCallbacks(this.h);
        }
        if (!z) {
            this.h.run();
        }
        this.c = false;
    }

    public abstract long b();

    public abstract java.lang.String b(T t);

    public abstract int c(T t);

    public abstract long c();

    public abstract long d(T t);

    public final long e(T t) {
        return (com.loc.gd.b() - d((com.loc.ez<T>) t)) / 1000;
    }
}
