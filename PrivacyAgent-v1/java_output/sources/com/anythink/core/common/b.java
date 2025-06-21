package com.anythink.core.common;

/* loaded from: classes12.dex */
public class b {
    public static final java.lang.String a = "1";
    private static volatile com.anythink.core.common.b c;
    java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.List<com.anythink.core.common.b.a>> b = new java.util.concurrent.ConcurrentHashMap<>();

    /* renamed from: com.anythink.core.common.b$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ com.anythink.core.common.b.a b;

        public AnonymousClass1(java.lang.String str, com.anythink.core.common.b.a aVar) {
            this.a = str;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (com.anythink.core.common.b.this) {
                java.util.List<com.anythink.core.common.b.a> list = com.anythink.core.common.b.this.b.get(this.a);
                if (list == null) {
                    list = new java.util.ArrayList<>();
                    com.anythink.core.common.b.this.b.put(this.a, list);
                }
                list.add(this.b);
            }
        }
    }

    /* renamed from: com.anythink.core.common.b$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ com.anythink.core.common.b.a b;

        public AnonymousClass2(java.lang.String str, com.anythink.core.common.b.a aVar) {
            this.a = str;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (com.anythink.core.common.b.this) {
                java.util.List<com.anythink.core.common.b.a> list = com.anythink.core.common.b.this.b.get(this.a);
                if (list != null) {
                    list.remove(this.b);
                }
            }
        }
    }

    /* renamed from: com.anythink.core.common.b$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.lang.Object b;

        public AnonymousClass3(java.lang.String str, java.lang.Object obj) {
            this.a = str;
            this.b = obj;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (com.anythink.core.common.b.this) {
                java.util.List<com.anythink.core.common.b.a> list = com.anythink.core.common.b.this.b.get(this.a);
                if (list == null) {
                    return;
                }
                for (com.anythink.core.common.b.a aVar : list) {
                    if (aVar != null) {
                        aVar.a(this.b);
                    }
                }
            }
        }
    }

    public interface a {
        void a(java.lang.Object obj);
    }

    private b() {
    }

    public static com.anythink.core.common.b a() {
        if (c == null) {
            synchronized (com.anythink.core.common.b.class) {
                if (c == null) {
                    c = new com.anythink.core.common.b();
                }
            }
        }
        return c;
    }

    public final synchronized void a(java.lang.String str, com.anythink.core.common.b.a aVar) {
        if (!android.text.TextUtils.isEmpty(str) && aVar != null) {
            com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.core.common.b.AnonymousClass1(str, aVar), 2, true);
        }
    }

    public final synchronized void a(java.lang.String str, java.lang.Object obj) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.core.common.b.AnonymousClass3(str, obj), 2, true);
    }

    public final synchronized void b(java.lang.String str, com.anythink.core.common.b.a aVar) {
        if (!android.text.TextUtils.isEmpty(str) && aVar != null) {
            com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.core.common.b.AnonymousClass2(str, aVar), 2, true);
        }
    }
}
