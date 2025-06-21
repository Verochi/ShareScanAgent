package com.anythink.core.common.res;

/* loaded from: classes12.dex */
public class b {
    private static final java.lang.String b = "ImageLoader";
    private static volatile com.anythink.core.common.res.b c;
    android.content.Context a;
    private java.util.Map<java.lang.String, java.lang.Integer> d;
    private final java.lang.Object f = new java.lang.Object();
    private final java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.List<com.anythink.core.common.res.b.a>> g = new java.util.concurrent.ConcurrentHashMap<>();
    private com.anythink.core.common.res.c<java.lang.String, java.lang.ref.SoftReference<android.graphics.Bitmap>> e = new com.anythink.core.common.res.b.AnonymousClass3(((int) java.lang.Runtime.getRuntime().maxMemory()) / 5);

    /* renamed from: com.anythink.core.common.res.b$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.graphics.Bitmap a;
        final /* synthetic */ com.anythink.core.common.res.b.a b;
        final /* synthetic */ java.lang.String c;

        public AnonymousClass1(android.graphics.Bitmap bitmap, com.anythink.core.common.res.b.a aVar, java.lang.String str) {
            this.a = bitmap;
            this.b = aVar;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.graphics.Bitmap bitmap = this.a;
            if (bitmap != null) {
                this.b.onSuccess(this.c, bitmap);
            } else {
                this.b.onFail(this.c, "Bitmap load fail");
            }
        }
    }

    /* renamed from: com.anythink.core.common.res.b$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.common.res.b.a a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;

        public AnonymousClass2(com.anythink.core.common.res.b.a aVar, java.lang.String str, java.lang.String str2) {
            this.a = aVar;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.onFail(this.b, this.c);
        }
    }

    /* renamed from: com.anythink.core.common.res.b$3, reason: invalid class name */
    public class AnonymousClass3 extends com.anythink.core.common.res.c<java.lang.String, java.lang.ref.SoftReference<android.graphics.Bitmap>> {
        public AnonymousClass3(int i) {
            super(i);
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private int a2(java.lang.String str, java.lang.ref.SoftReference<android.graphics.Bitmap> softReference) {
            android.graphics.Bitmap bitmap = softReference != null ? softReference.get() : null;
            if (com.anythink.core.common.res.b.this.d == null) {
                com.anythink.core.common.res.b.this.d = new java.util.HashMap(8);
            }
            if (bitmap != null) {
                int rowBytes = bitmap.getRowBytes() * bitmap.getHeight();
                com.anythink.core.common.res.b.this.d.put(str, java.lang.Integer.valueOf(rowBytes));
                return rowBytes;
            }
            java.lang.Integer num = (java.lang.Integer) com.anythink.core.common.res.b.this.d.get(str);
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private void a2(boolean z, java.lang.String str, java.lang.ref.SoftReference<android.graphics.Bitmap> softReference, java.lang.ref.SoftReference<android.graphics.Bitmap> softReference2) {
            android.graphics.Bitmap bitmap;
            super.a(z, (boolean) str, softReference, softReference2);
            if (softReference != null) {
                try {
                    bitmap = softReference.get();
                } catch (java.lang.Exception unused) {
                    return;
                }
            } else {
                bitmap = null;
            }
            if (com.anythink.core.common.res.b.this.d != null) {
                com.anythink.core.common.res.b.this.d.remove(str);
            }
            if (softReference == null || softReference.equals(softReference2) || bitmap == null || bitmap.isRecycled()) {
                return;
            }
            bitmap.recycle();
        }

        @Override // com.anythink.core.common.res.c
        public final /* synthetic */ int a(java.lang.String str, java.lang.ref.SoftReference<android.graphics.Bitmap> softReference) {
            java.lang.String str2 = str;
            java.lang.ref.SoftReference<android.graphics.Bitmap> softReference2 = softReference;
            android.graphics.Bitmap bitmap = softReference2 != null ? softReference2.get() : null;
            if (com.anythink.core.common.res.b.this.d == null) {
                com.anythink.core.common.res.b.this.d = new java.util.HashMap(8);
            }
            if (bitmap != null) {
                int rowBytes = bitmap.getRowBytes() * bitmap.getHeight();
                com.anythink.core.common.res.b.this.d.put(str2, java.lang.Integer.valueOf(rowBytes));
                return rowBytes;
            }
            java.lang.Integer num = (java.lang.Integer) com.anythink.core.common.res.b.this.d.get(str2);
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }

        @Override // com.anythink.core.common.res.c
        public final /* synthetic */ void a(boolean z, java.lang.String str, java.lang.ref.SoftReference<android.graphics.Bitmap> softReference, java.lang.ref.SoftReference<android.graphics.Bitmap> softReference2) {
            android.graphics.Bitmap bitmap;
            java.lang.String str2 = str;
            java.lang.ref.SoftReference<android.graphics.Bitmap> softReference3 = softReference;
            java.lang.ref.SoftReference<android.graphics.Bitmap> softReference4 = softReference2;
            super.a(z, (boolean) str2, softReference3, softReference4);
            if (softReference3 != null) {
                try {
                    bitmap = softReference3.get();
                } catch (java.lang.Exception unused) {
                    return;
                }
            } else {
                bitmap = null;
            }
            if (com.anythink.core.common.res.b.this.d != null) {
                com.anythink.core.common.res.b.this.d.remove(str2);
            }
            if (softReference3 == null || softReference3.equals(softReference4) || bitmap == null || bitmap.isRecycled()) {
                return;
            }
            bitmap.recycle();
        }
    }

    /* renamed from: com.anythink.core.common.res.b$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.common.res.e a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ com.anythink.core.common.res.b.a d;

        public AnonymousClass4(com.anythink.core.common.res.e eVar, int i, int i2, com.anythink.core.common.res.b.a aVar) {
            this.a = eVar;
            this.b = i;
            this.c = i2;
            this.d = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.graphics.Bitmap a = com.anythink.core.common.res.b.this.a(this.a, this.b, this.c);
            if (a == null || a.isRecycled()) {
                com.anythink.core.common.res.b.a(com.anythink.core.common.res.b.this, this.a, this.b, this.c, this.d);
                return;
            }
            com.anythink.core.common.res.b.this.a(this.a.f, a);
            if (this.d != null) {
                java.util.LinkedList linkedList = new java.util.LinkedList();
                linkedList.add(this.d);
                com.anythink.core.common.res.b.this.g.put(this.a.f, linkedList);
            }
            com.anythink.core.common.res.b.a(com.anythink.core.common.res.b.this, this.a.f, a);
        }
    }

    /* renamed from: com.anythink.core.common.res.b$5, reason: invalid class name */
    public class AnonymousClass5 implements com.anythink.core.common.res.image.a.InterfaceC0172a {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ com.anythink.core.common.res.e c;

        public AnonymousClass5(int i, int i2, com.anythink.core.common.res.e eVar) {
            this.a = i;
            this.b = i2;
            this.c = eVar;
        }

        @Override // com.anythink.core.common.res.image.a.InterfaceC0172a
        public final void a(com.anythink.core.common.res.e eVar) {
            java.lang.String str = eVar.f;
            android.graphics.Bitmap a = com.anythink.core.common.res.b.this.a(eVar, this.a, this.b);
            if (a != null) {
                com.anythink.core.common.res.b.this.a(eVar.f, a);
            }
            com.anythink.core.common.res.b.a(com.anythink.core.common.res.b.this, this.c.f, a);
        }

        @Override // com.anythink.core.common.res.image.a.InterfaceC0172a
        public final void a(com.anythink.core.common.res.e eVar, java.lang.String str) {
            com.anythink.core.common.res.b.a(com.anythink.core.common.res.b.this, eVar.f, str);
        }
    }

    public interface a {
        void onFail(java.lang.String str, java.lang.String str2);

        void onSuccess(java.lang.String str, android.graphics.Bitmap bitmap);
    }

    private b(android.content.Context context) {
        this.a = context.getApplicationContext();
    }

    private android.graphics.Bitmap a(java.lang.String str) {
        java.lang.ref.SoftReference<android.graphics.Bitmap> a2 = this.e.a((com.anythink.core.common.res.c<java.lang.String, java.lang.ref.SoftReference<android.graphics.Bitmap>>) str);
        if (a2 != null) {
            return a2.get();
        }
        return null;
    }

    public static com.anythink.core.common.res.b a(android.content.Context context) {
        if (c == null) {
            synchronized (com.anythink.core.common.res.b.class) {
                if (c == null) {
                    c = new com.anythink.core.common.res.b(context);
                }
            }
        }
        return c;
    }

    private void a() {
        try {
            com.anythink.core.common.res.c<java.lang.String, java.lang.ref.SoftReference<android.graphics.Bitmap>> cVar = this.e;
            if (cVar != null) {
                cVar.a();
            }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.List<com.anythink.core.common.res.b.a>> concurrentHashMap = this.g;
            if (concurrentHashMap != null) {
                concurrentHashMap.clear();
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public static /* synthetic */ void a(com.anythink.core.common.res.b bVar, com.anythink.core.common.res.e eVar, int i, int i2, com.anythink.core.common.res.b.a aVar) {
        synchronized (bVar.g) {
            if (bVar.g.containsKey(eVar.f)) {
                java.util.LinkedList linkedList = (java.util.LinkedList) bVar.g.get(eVar.f);
                if (linkedList != null && aVar != null && !linkedList.contains(aVar)) {
                    linkedList.add(aVar);
                }
            } else {
                if (aVar != null) {
                    java.util.LinkedList linkedList2 = new java.util.LinkedList();
                    linkedList2.add(aVar);
                    bVar.g.put(eVar.f, linkedList2);
                }
                com.anythink.core.common.res.image.a aVar2 = new com.anythink.core.common.res.image.a(eVar);
                aVar2.a(bVar.new AnonymousClass5(i, i2, eVar));
                aVar2.d();
            }
        }
    }

    public static /* synthetic */ void a(com.anythink.core.common.res.b bVar, java.lang.String str, android.graphics.Bitmap bitmap) {
        synchronized (bVar.g) {
            try {
                java.util.LinkedList linkedList = (java.util.LinkedList) bVar.g.remove(str);
                if (linkedList != null) {
                    java.util.Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        com.anythink.core.common.res.b.a aVar = (com.anythink.core.common.res.b.a) it.next();
                        if (aVar != null) {
                            com.anythink.core.common.b.o.a().b(bVar.new AnonymousClass1(bitmap, aVar, str));
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static /* synthetic */ void a(com.anythink.core.common.res.b bVar, java.lang.String str, java.lang.String str2) {
        synchronized (bVar.g) {
            try {
                java.util.LinkedList linkedList = (java.util.LinkedList) bVar.g.remove(str);
                if (linkedList != null) {
                    java.util.Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        com.anythink.core.common.res.b.a aVar = (com.anythink.core.common.res.b.a) it.next();
                        if (aVar != null) {
                            com.anythink.core.common.b.o.a().b(bVar.new AnonymousClass2(aVar, str, str2));
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void a(java.lang.String str, java.lang.String str2) {
        synchronized (this.g) {
            try {
                java.util.LinkedList linkedList = (java.util.LinkedList) this.g.remove(str);
                if (linkedList != null) {
                    java.util.Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        com.anythink.core.common.res.b.a aVar = (com.anythink.core.common.res.b.a) it.next();
                        if (aVar != null) {
                            com.anythink.core.common.b.o.a().b(new com.anythink.core.common.res.b.AnonymousClass2(aVar, str, str2));
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void b(com.anythink.core.common.res.e eVar, int i, int i2, com.anythink.core.common.res.b.a aVar) {
        synchronized (this.g) {
            if (this.g.containsKey(eVar.f)) {
                java.util.LinkedList linkedList = (java.util.LinkedList) this.g.get(eVar.f);
                if (linkedList != null && aVar != null && !linkedList.contains(aVar)) {
                    linkedList.add(aVar);
                }
            } else {
                if (aVar != null) {
                    java.util.LinkedList linkedList2 = new java.util.LinkedList();
                    linkedList2.add(aVar);
                    this.g.put(eVar.f, linkedList2);
                }
                com.anythink.core.common.res.image.a aVar2 = new com.anythink.core.common.res.image.a(eVar);
                aVar2.a(new com.anythink.core.common.res.b.AnonymousClass5(i, i2, eVar));
                aVar2.d();
            }
        }
    }

    private void b(java.lang.String str, android.graphics.Bitmap bitmap) {
        synchronized (this.g) {
            try {
                java.util.LinkedList linkedList = (java.util.LinkedList) this.g.remove(str);
                if (linkedList != null) {
                    java.util.Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        com.anythink.core.common.res.b.a aVar = (com.anythink.core.common.res.b.a) it.next();
                        if (aVar != null) {
                            com.anythink.core.common.b.o.a().b(new com.anythink.core.common.res.b.AnonymousClass1(bitmap, aVar, str));
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final android.graphics.Bitmap a(com.anythink.core.common.res.e eVar, int i, int i2) {
        android.graphics.Bitmap bitmap = null;
        if (eVar == null || android.text.TextUtils.isEmpty(eVar.f)) {
            return null;
        }
        java.lang.String a2 = com.anythink.core.common.o.g.a(eVar.f);
        if (i <= 0) {
            try {
                i = this.a.getResources().getDisplayMetrics().widthPixels;
            } catch (java.lang.Throwable unused) {
            }
        }
        if (i2 <= 0) {
            i2 = this.a.getResources().getDisplayMetrics().heightPixels;
        }
        synchronized (this.f) {
            java.io.FileInputStream a3 = com.anythink.core.common.res.d.a(this.a).a(eVar.e, a2);
            if (a3 == null) {
                return null;
            }
            try {
                bitmap = com.anythink.core.common.o.c.a(a3.getFD(), i, i2);
            } catch (java.lang.Throwable unused2) {
            }
            try {
                a3.close();
            } catch (java.lang.Exception unused3) {
            }
            return bitmap;
        }
    }

    public final void a(com.anythink.core.common.res.e eVar, int i, int i2, com.anythink.core.common.res.b.a aVar) {
        if (eVar == null || android.text.TextUtils.isEmpty(eVar.f)) {
            if (aVar != null) {
                aVar.onFail("", "No url info.");
                return;
            }
            return;
        }
        android.graphics.Bitmap a2 = a(eVar.f);
        if (a2 == null || a2.isRecycled()) {
            com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.core.common.res.b.AnonymousClass4(eVar, i, i2, aVar), 2, true);
        } else if (aVar != null) {
            aVar.onSuccess(eVar.f, a2);
        }
    }

    public final void a(com.anythink.core.common.res.e eVar, com.anythink.core.common.res.b.a aVar) {
        a(eVar, -1, -1, aVar);
    }

    public final void a(java.lang.String str, android.graphics.Bitmap bitmap) {
        if (a(str) != null || bitmap == null) {
            return;
        }
        this.e.b(str, new java.lang.ref.SoftReference<>(bitmap));
    }

    public final android.graphics.Bitmap b(com.anythink.core.common.res.e eVar, int i, int i2) {
        if (android.text.TextUtils.isEmpty(eVar.f)) {
            return null;
        }
        android.graphics.Bitmap a2 = a(eVar.f);
        if (a2 != null && !a2.isRecycled()) {
            return a2;
        }
        android.graphics.Bitmap a3 = a(eVar, i, i2);
        if (a3 != null && !a3.isRecycled()) {
            a(eVar.f, a3);
        }
        return a3;
    }
}
