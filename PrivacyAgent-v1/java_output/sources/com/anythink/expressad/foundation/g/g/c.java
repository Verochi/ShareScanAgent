package com.anythink.expressad.foundation.g.g;

/* loaded from: classes12.dex */
public final class c {
    java.util.concurrent.ThreadPoolExecutor a;
    java.util.HashMap<java.lang.Long, com.anythink.expressad.foundation.g.g.a> b;
    java.lang.ref.WeakReference<android.content.Context> c;

    /* renamed from: com.anythink.expressad.foundation.g.g.c$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.expressad.foundation.g.g.a.b {
        final /* synthetic */ com.anythink.expressad.foundation.g.g.a a;
        final /* synthetic */ com.anythink.expressad.foundation.g.g.a.b b;

        public AnonymousClass1(com.anythink.expressad.foundation.g.g.a aVar, com.anythink.expressad.foundation.g.g.a.b bVar) {
            this.a = aVar;
            this.b = bVar;
        }

        @Override // com.anythink.expressad.foundation.g.g.a.b
        public final void a(com.anythink.expressad.foundation.g.g.a.EnumC0213a enumC0213a) {
            if (enumC0213a == com.anythink.expressad.foundation.g.g.a.EnumC0213a.CANCEL) {
                com.anythink.expressad.foundation.g.g.c.this.b.remove(java.lang.Long.valueOf(com.anythink.expressad.foundation.g.g.a.e()));
            } else if (enumC0213a == com.anythink.expressad.foundation.g.g.a.EnumC0213a.FINISH) {
                com.anythink.expressad.foundation.g.g.c.this.b.remove(java.lang.Long.valueOf(com.anythink.expressad.foundation.g.g.a.e()));
            } else if (enumC0213a == com.anythink.expressad.foundation.g.g.a.EnumC0213a.RUNNING && com.anythink.expressad.foundation.g.g.c.this.c.get() == null) {
                com.anythink.expressad.foundation.g.g.c.this.a();
            }
            com.anythink.expressad.foundation.g.g.a.b bVar = this.b;
            if (bVar != null) {
                bVar.a(enumC0213a);
            }
        }
    }

    @android.annotation.SuppressLint({"UseSparseArrays"})
    public c(android.content.Context context) {
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(0, Integer.MAX_VALUE, 15L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingDeque(), new java.util.concurrent.ThreadPoolExecutor.DiscardPolicy());
        this.a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.b = new java.util.HashMap<>();
        this.c = new java.lang.ref.WeakReference<>(context);
    }

    @android.annotation.SuppressLint({"UseSparseArrays"})
    private c(android.content.Context context, byte b) {
        int availableProcessors = (java.lang.Runtime.getRuntime().availableProcessors() * 2) + 1;
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(availableProcessors, availableProcessors, 1L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingDeque(), new java.util.concurrent.ThreadPoolExecutor.DiscardPolicy());
        this.a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.b = new java.util.HashMap<>();
        this.c = new java.lang.ref.WeakReference<>(context);
    }

    @android.annotation.SuppressLint({"UseSparseArrays"})
    public c(android.content.Context context, int i) {
        if (i == 0) {
            this.a = new java.util.concurrent.ThreadPoolExecutor(1, 5, 15L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingDeque(), new java.util.concurrent.ThreadPoolExecutor.DiscardPolicy());
        } else {
            this.a = new java.util.concurrent.ThreadPoolExecutor(i, (i * 2) + 1, 15L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingDeque(), new java.util.concurrent.ThreadPoolExecutor.DiscardPolicy());
        }
        this.a.allowCoreThreadTimeOut(true);
        this.b = new java.util.HashMap<>();
        this.c = new java.lang.ref.WeakReference<>(context);
    }

    private void b() {
        java.util.Iterator<java.util.Map.Entry<java.lang.Long, com.anythink.expressad.foundation.g.g.a>> it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            com.anythink.expressad.foundation.g.g.a value = it.next().getValue();
            com.anythink.expressad.foundation.g.g.a.EnumC0213a enumC0213a = value.c;
            if (enumC0213a == com.anythink.expressad.foundation.g.g.a.EnumC0213a.PAUSE) {
                value.g();
            } else if (enumC0213a == com.anythink.expressad.foundation.g.g.a.EnumC0213a.READY) {
                this.a.execute(value);
            }
        }
    }

    private synchronized void b(com.anythink.expressad.foundation.g.g.a aVar) {
        if (aVar != null) {
            if (this.b.containsKey(java.lang.Long.valueOf(com.anythink.expressad.foundation.g.g.a.e()))) {
                com.anythink.expressad.foundation.g.g.a aVar2 = this.b.get(java.lang.Long.valueOf(com.anythink.expressad.foundation.g.g.a.e()));
                if (aVar2 != null) {
                    aVar2.f();
                }
                this.b.remove(java.lang.Long.valueOf(com.anythink.expressad.foundation.g.g.a.e()));
            }
        }
    }

    private synchronized void b(com.anythink.expressad.foundation.g.g.a aVar, com.anythink.expressad.foundation.g.g.a.b bVar) {
        this.b.put(java.lang.Long.valueOf(com.anythink.expressad.foundation.g.g.a.e()), aVar);
        aVar.d = new com.anythink.expressad.foundation.g.g.c.AnonymousClass1(aVar, bVar);
    }

    public final synchronized void a() {
        try {
            java.util.Iterator<java.util.Map.Entry<java.lang.Long, com.anythink.expressad.foundation.g.g.a>> it = this.b.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().f();
            }
            this.b.clear();
        } catch (java.lang.Exception unused) {
        }
    }

    public final void a(com.anythink.expressad.foundation.g.g.a aVar) {
        b(aVar, null);
        this.a.execute(aVar);
    }

    public final void a(com.anythink.expressad.foundation.g.g.a aVar, com.anythink.expressad.foundation.g.g.a.b bVar) {
        b(aVar, bVar);
        this.a.execute(aVar);
    }
}
