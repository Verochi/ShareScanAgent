package com.anythink.expressad.foundation.g.d;

/* loaded from: classes12.dex */
public final class b {
    private static final java.lang.String a = "ImageLoader";
    private static final int b = 1;
    private static final int c = 2;
    private static final java.lang.String d = "message_key";
    private static final java.lang.String e = "message_bitmap";
    private static final java.lang.String f = "message_message";
    private static com.anythink.expressad.foundation.g.d.b g;
    private com.anythink.expressad.foundation.g.g.c h;
    private final java.util.LinkedHashMap<java.lang.String, java.util.List<com.anythink.expressad.foundation.g.d.c>> j = new java.util.LinkedHashMap<>();
    private com.anythink.expressad.foundation.g.a.e<java.lang.String, android.graphics.Bitmap> i = new com.anythink.expressad.foundation.g.a.c(((int) java.lang.Runtime.getRuntime().maxMemory()) / 5);

    /* renamed from: com.anythink.expressad.foundation.g.d.b$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ com.anythink.expressad.foundation.g.d.c d;
        final /* synthetic */ boolean e = false;

        public AnonymousClass1(java.lang.String str, java.lang.String str2, java.lang.String str3, com.anythink.expressad.foundation.g.d.c cVar) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            java.io.File file = new java.io.File(this.a);
            android.graphics.Bitmap a = com.anythink.expressad.foundation.g.d.b.this.a(this.b);
            if (a != null && !a.isRecycled()) {
                com.anythink.expressad.foundation.g.d.b.a(com.anythink.expressad.foundation.g.d.b.this, this.c, a, this.d);
                return;
            }
            if (file.length() <= 0) {
                com.anythink.expressad.foundation.g.d.b.a(com.anythink.expressad.foundation.g.d.b.this, this.c, this.b, this.a, false, this.d);
                return;
            }
            android.graphics.Bitmap a2 = com.anythink.expressad.foundation.g.d.a.a(this.a);
            if (a2 == null || a2.isRecycled()) {
                com.anythink.expressad.foundation.g.d.b.a(com.anythink.expressad.foundation.g.d.b.this, this.c, this.b, this.a, true, this.d);
            } else {
                com.anythink.expressad.foundation.g.d.b.this.a(this.b, a2);
                com.anythink.expressad.foundation.g.d.b.a(com.anythink.expressad.foundation.g.d.b.this, this.c, a2, this.d);
            }
        }
    }

    /* renamed from: com.anythink.expressad.foundation.g.d.b$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.expressad.foundation.g.d.d.a {
        final /* synthetic */ java.lang.String a;

        /* renamed from: com.anythink.expressad.foundation.g.d.b$2$1, reason: invalid class name */
        public class AnonymousClass1 extends com.anythink.core.common.o.b.d {
            final /* synthetic */ java.lang.String a;
            final /* synthetic */ java.lang.String b;

            public AnonymousClass1(java.lang.String str, java.lang.String str2) {
                this.a = str;
                this.b = str2;
            }

            @Override // com.anythink.core.common.o.b.d
            public final void a() {
                synchronized (com.anythink.expressad.foundation.g.d.b.this.j) {
                    android.graphics.Bitmap a = com.anythink.expressad.foundation.g.d.a.a(this.a);
                    com.anythink.expressad.foundation.g.d.b.this.a(this.b, a);
                    java.util.LinkedList linkedList = (java.util.LinkedList) com.anythink.expressad.foundation.g.d.b.this.j.remove(this.b);
                    if (linkedList != null) {
                        java.util.Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            com.anythink.expressad.foundation.g.d.c cVar = (com.anythink.expressad.foundation.g.d.c) it.next();
                            com.anythink.expressad.foundation.g.d.b.AnonymousClass2 anonymousClass2 = com.anythink.expressad.foundation.g.d.b.AnonymousClass2.this;
                            com.anythink.expressad.foundation.g.d.b.a(com.anythink.expressad.foundation.g.d.b.this, anonymousClass2.a, a, cVar);
                        }
                    }
                }
            }
        }

        /* renamed from: com.anythink.expressad.foundation.g.d.b$2$2, reason: invalid class name and collision with other inner class name */
        public class C02112 extends com.anythink.core.common.o.b.d {
            final /* synthetic */ java.lang.String a;
            final /* synthetic */ java.lang.String b;

            public C02112(java.lang.String str, java.lang.String str2) {
                this.a = str;
                this.b = str2;
            }

            @Override // com.anythink.core.common.o.b.d
            public final void a() {
                synchronized (com.anythink.expressad.foundation.g.d.b.this.j) {
                    java.util.LinkedList linkedList = (java.util.LinkedList) com.anythink.expressad.foundation.g.d.b.this.j.remove(this.a);
                    if (linkedList != null) {
                        java.util.Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            com.anythink.expressad.foundation.g.d.c cVar = (com.anythink.expressad.foundation.g.d.c) it.next();
                            com.anythink.expressad.foundation.g.d.b.AnonymousClass2 anonymousClass2 = com.anythink.expressad.foundation.g.d.b.AnonymousClass2.this;
                            com.anythink.expressad.foundation.g.d.b bVar = com.anythink.expressad.foundation.g.d.b.this;
                            java.lang.String str = anonymousClass2.a;
                            com.anythink.core.common.b.o.a().b(bVar.new AnonymousClass4(cVar, this.b, str));
                        }
                    }
                }
            }
        }

        public AnonymousClass2(java.lang.String str) {
            this.a = str;
        }

        @Override // com.anythink.expressad.foundation.g.d.d.a
        public final void a(java.lang.String str, java.lang.String str2) {
            com.anythink.core.common.o.b.b.a().a(new com.anythink.expressad.foundation.g.d.b.AnonymousClass2.AnonymousClass1(str2, str));
        }

        @Override // com.anythink.expressad.foundation.g.d.d.a
        public final void b(java.lang.String str, java.lang.String str2) {
            com.anythink.core.common.o.b.b.a().a(new com.anythink.expressad.foundation.g.d.b.AnonymousClass2.C02112(str, str2));
        }
    }

    /* renamed from: com.anythink.expressad.foundation.g.d.b$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.expressad.foundation.g.d.c a;
        final /* synthetic */ android.graphics.Bitmap b;
        final /* synthetic */ java.lang.String c;

        public AnonymousClass3(com.anythink.expressad.foundation.g.d.c cVar, android.graphics.Bitmap bitmap, java.lang.String str) {
            this.a = cVar;
            this.b = bitmap;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.a != null) {
                android.graphics.Bitmap bitmap = this.b;
                if (bitmap == null || bitmap.isRecycled()) {
                    this.a.a("bitmap no available", this.c);
                } else {
                    this.a.a(this.b, this.c);
                }
            }
        }
    }

    /* renamed from: com.anythink.expressad.foundation.g.d.b$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.expressad.foundation.g.d.c a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;

        public AnonymousClass4(com.anythink.expressad.foundation.g.d.c cVar, java.lang.String str, java.lang.String str2) {
            this.a = cVar;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.foundation.g.d.c cVar = this.a;
            if (cVar != null) {
                cVar.a(this.b, this.c);
            }
        }
    }

    private b(android.content.Context context) {
        this.h = new com.anythink.expressad.foundation.g.g.c(context);
    }

    public static com.anythink.expressad.foundation.g.d.b a(android.content.Context context) {
        if (g == null) {
            g = new com.anythink.expressad.foundation.g.d.b(context);
        }
        return g;
    }

    private com.anythink.expressad.foundation.g.d.d a(java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z) {
        com.anythink.expressad.foundation.g.d.b.AnonymousClass2 anonymousClass2 = new com.anythink.expressad.foundation.g.d.b.AnonymousClass2(str);
        com.anythink.expressad.foundation.g.d.d dVar = new com.anythink.expressad.foundation.g.d.d(str, str2, str3);
        dVar.a(z);
        dVar.a(anonymousClass2);
        return dVar;
    }

    public static void a() {
        com.anythink.expressad.foundation.g.a.e<java.lang.String, android.graphics.Bitmap> eVar = g.i;
        if (eVar != null) {
            eVar.b();
        }
    }

    public static /* synthetic */ void a(com.anythink.expressad.foundation.g.d.b bVar, java.lang.String str, android.graphics.Bitmap bitmap, com.anythink.expressad.foundation.g.d.c cVar) {
        com.anythink.core.common.b.o.a().b(bVar.new AnonymousClass3(cVar, bitmap, str));
    }

    public static /* synthetic */ void a(com.anythink.expressad.foundation.g.d.b bVar, java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z, com.anythink.expressad.foundation.g.d.c cVar) {
        synchronized (bVar.j) {
            if (bVar.j.containsKey(str2)) {
                java.util.LinkedList linkedList = (java.util.LinkedList) bVar.j.get(str2);
                if (linkedList != null && cVar != null && !linkedList.contains(cVar)) {
                    linkedList.add(cVar);
                }
            } else {
                if (cVar != null) {
                    java.util.LinkedList linkedList2 = new java.util.LinkedList();
                    linkedList2.add(cVar);
                    bVar.j.put(str2, linkedList2);
                }
                com.anythink.expressad.foundation.g.d.b.AnonymousClass2 anonymousClass2 = bVar.new AnonymousClass2(str);
                com.anythink.expressad.foundation.g.d.d dVar = new com.anythink.expressad.foundation.g.d.d(str, str2, str3);
                dVar.a(z);
                dVar.a(anonymousClass2);
                bVar.h.a(dVar);
            }
        }
    }

    private void a(java.lang.String str, android.graphics.Bitmap bitmap, com.anythink.expressad.foundation.g.d.c cVar) {
        com.anythink.core.common.b.o.a().b(new com.anythink.expressad.foundation.g.d.b.AnonymousClass3(cVar, bitmap, str));
    }

    private void a(java.lang.String str, java.lang.String str2, com.anythink.expressad.foundation.g.d.c cVar) {
        com.anythink.core.common.b.o.a().b(new com.anythink.expressad.foundation.g.d.b.AnonymousClass4(cVar, str2, str));
    }

    private void a(java.lang.String str, java.lang.String str2, java.lang.String str3, com.anythink.expressad.foundation.g.d.c cVar) {
        if (com.anythink.expressad.foundation.h.t.a(str) || com.anythink.expressad.foundation.h.t.a(str2) || com.anythink.expressad.foundation.h.t.a(str3)) {
            return;
        }
        com.anythink.core.common.o.b.b.a().a(new com.anythink.expressad.foundation.g.d.b.AnonymousClass1(str3, str2, str, cVar));
    }

    private void a(java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z, com.anythink.expressad.foundation.g.d.c cVar) {
        synchronized (this.j) {
            if (this.j.containsKey(str2)) {
                java.util.LinkedList linkedList = (java.util.LinkedList) this.j.get(str2);
                if (linkedList != null && cVar != null && !linkedList.contains(cVar)) {
                    linkedList.add(cVar);
                }
            } else {
                if (cVar != null) {
                    java.util.LinkedList linkedList2 = new java.util.LinkedList();
                    linkedList2.add(cVar);
                    this.j.put(str2, linkedList2);
                }
                com.anythink.expressad.foundation.g.d.b.AnonymousClass2 anonymousClass2 = new com.anythink.expressad.foundation.g.d.b.AnonymousClass2(str);
                com.anythink.expressad.foundation.g.d.d dVar = new com.anythink.expressad.foundation.g.d.d(str, str2, str3);
                dVar.a(z);
                dVar.a(anonymousClass2);
                this.h.a(dVar);
            }
        }
    }

    private void b() {
        this.i.b();
        java.util.LinkedHashMap<java.lang.String, java.util.List<com.anythink.expressad.foundation.g.d.c>> linkedHashMap = this.j;
        if (linkedHashMap != null) {
            linkedHashMap.clear();
        }
    }

    private void c() {
        com.anythink.expressad.foundation.g.a.e<java.lang.String, android.graphics.Bitmap> eVar = this.i;
        if (eVar != null) {
            eVar.b();
        }
    }

    private android.graphics.Bitmap d(java.lang.String str) {
        android.graphics.Bitmap a2;
        if (com.anythink.expressad.foundation.h.t.a(str)) {
            return null;
        }
        java.lang.String a3 = com.anythink.expressad.foundation.h.s.a(str);
        java.io.File file = new java.io.File(a3);
        if (a(str) != null) {
            return a(str);
        }
        if (!file.exists() || (a2 = com.anythink.expressad.foundation.g.d.a.a(a3)) == null) {
            return null;
        }
        a(str, a2);
        return a2;
    }

    public final android.graphics.Bitmap a(java.lang.String str) {
        return this.i.b(str);
    }

    public final void a(java.lang.String str, android.graphics.Bitmap bitmap) {
        if (a(str) != null || bitmap == null) {
            return;
        }
        this.i.a(str, bitmap);
    }

    public final void a(java.lang.String str, com.anythink.expressad.foundation.g.d.c cVar) {
        java.lang.String a2 = com.anythink.expressad.foundation.h.s.a(str);
        if (com.anythink.expressad.foundation.h.t.a(str) || com.anythink.expressad.foundation.h.t.a(str) || com.anythink.expressad.foundation.h.t.a(a2)) {
            return;
        }
        com.anythink.core.common.o.b.b.a().a(new com.anythink.expressad.foundation.g.d.b.AnonymousClass1(a2, str, str, cVar));
    }

    public final boolean b(java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.a(str)) {
            return false;
        }
        return a(str) != null || new java.io.File(com.anythink.expressad.foundation.h.s.a(str)).exists();
    }

    public final void c(java.lang.String str) {
        try {
            com.anythink.expressad.foundation.g.a.e<java.lang.String, android.graphics.Bitmap> eVar = this.i;
            if (eVar == null || !eVar.a().contains(str)) {
                return;
            }
            this.i.a(str);
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }
}
