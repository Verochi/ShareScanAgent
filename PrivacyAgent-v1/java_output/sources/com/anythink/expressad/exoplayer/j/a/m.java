package com.anythink.expressad.exoplayer.j.a;

/* loaded from: classes12.dex */
public final class m implements com.anythink.expressad.exoplayer.j.a.a {
    private static final java.lang.String a = "SimpleCache";
    private static final java.util.HashSet<java.io.File> b = new java.util.HashSet<>();
    private static boolean c;
    private final java.io.File d;
    private final com.anythink.expressad.exoplayer.j.a.d e;
    private final com.anythink.expressad.exoplayer.j.a.h f;
    private final java.util.HashMap<java.lang.String, java.util.ArrayList<com.anythink.expressad.exoplayer.j.a.a.b>> g;
    private long h;
    private boolean i;

    /* renamed from: com.anythink.expressad.exoplayer.j.a.m$1, reason: invalid class name */
    public class AnonymousClass1 extends java.lang.Thread {
        final /* synthetic */ android.os.ConditionVariable a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(java.lang.String str, android.os.ConditionVariable conditionVariable) {
            super(str);
            this.a = conditionVariable;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            synchronized (com.anythink.expressad.exoplayer.j.a.m.this) {
                this.a.open();
                com.anythink.expressad.exoplayer.j.a.m.a(com.anythink.expressad.exoplayer.j.a.m.this);
                com.anythink.expressad.exoplayer.j.a.d unused = com.anythink.expressad.exoplayer.j.a.m.this.e;
            }
        }
    }

    private m(java.io.File file, com.anythink.expressad.exoplayer.j.a.d dVar) {
        this(file, dVar, null, false);
    }

    private m(java.io.File file, com.anythink.expressad.exoplayer.j.a.d dVar, com.anythink.expressad.exoplayer.j.a.h hVar) {
        if (!c(file)) {
            throw new java.lang.IllegalStateException("Another SimpleCache instance uses the folder: ".concat(java.lang.String.valueOf(file)));
        }
        this.d = file;
        this.e = dVar;
        this.f = hVar;
        this.g = new java.util.HashMap<>();
        android.os.ConditionVariable conditionVariable = new android.os.ConditionVariable();
        new com.anythink.expressad.exoplayer.j.a.m.AnonymousClass1("SimpleCache.initialize()", conditionVariable).start();
        conditionVariable.block();
    }

    private m(java.io.File file, com.anythink.expressad.exoplayer.j.a.d dVar, byte[] bArr) {
        this(file, dVar, bArr, bArr != null);
    }

    private m(java.io.File file, com.anythink.expressad.exoplayer.j.a.d dVar, byte[] bArr, boolean z) {
        this(file, dVar, new com.anythink.expressad.exoplayer.j.a.h(file, bArr, z));
    }

    private void a(com.anythink.expressad.exoplayer.j.a.e eVar, boolean z) {
        com.anythink.expressad.exoplayer.j.a.g b2 = this.f.b(eVar.a);
        if (b2 == null || !b2.a(eVar)) {
            return;
        }
        this.h -= eVar.c;
        if (z) {
            try {
                this.f.d(b2.b);
                this.f.b();
            } finally {
                c(eVar);
            }
        }
    }

    public static /* synthetic */ void a(com.anythink.expressad.exoplayer.j.a.m mVar) {
        if (!mVar.d.exists()) {
            mVar.d.mkdirs();
            return;
        }
        mVar.f.a();
        java.io.File[] listFiles = mVar.d.listFiles();
        if (listFiles != null) {
            for (java.io.File file : listFiles) {
                if (!file.getName().equals(com.anythink.expressad.exoplayer.j.a.h.a)) {
                    com.anythink.expressad.exoplayer.j.a.n a2 = file.length() > 0 ? com.anythink.expressad.exoplayer.j.a.n.a(file, mVar.f) : null;
                    if (a2 != null) {
                        mVar.a(a2);
                    } else {
                        file.delete();
                    }
                }
            }
            mVar.f.d();
            try {
                mVar.f.b();
            } catch (com.anythink.expressad.exoplayer.j.a.a.C0203a unused) {
            }
        }
    }

    private void a(com.anythink.expressad.exoplayer.j.a.n nVar) {
        this.f.a(nVar.a).a(nVar);
        this.h += nVar.c;
        b(nVar);
    }

    private void b(com.anythink.expressad.exoplayer.j.a.n nVar) {
        java.util.ArrayList<com.anythink.expressad.exoplayer.j.a.a.b> arrayList = this.g.get(nVar.a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size);
            }
        }
    }

    private static synchronized boolean b(java.io.File file) {
        boolean contains;
        synchronized (com.anythink.expressad.exoplayer.j.a.m.class) {
            contains = b.contains(file.getAbsoluteFile());
        }
        return contains;
    }

    private void c(com.anythink.expressad.exoplayer.j.a.e eVar) {
        java.util.ArrayList<com.anythink.expressad.exoplayer.j.a.a.b> arrayList = this.g.get(eVar.a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size);
            }
        }
    }

    private void c(com.anythink.expressad.exoplayer.j.a.n nVar) {
        java.util.ArrayList<com.anythink.expressad.exoplayer.j.a.a.b> arrayList = this.g.get(nVar.a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size);
            }
        }
    }

    private static synchronized boolean c(java.io.File file) {
        synchronized (com.anythink.expressad.exoplayer.j.a.m.class) {
            if (c) {
                return true;
            }
            return b.add(file.getAbsoluteFile());
        }
    }

    @java.lang.Deprecated
    private static synchronized void d() {
        synchronized (com.anythink.expressad.exoplayer.j.a.m.class) {
            c = true;
            b.clear();
        }
    }

    private static synchronized void d(java.io.File file) {
        synchronized (com.anythink.expressad.exoplayer.j.a.m.class) {
            if (!c) {
                b.remove(file.getAbsoluteFile());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.anythink.expressad.exoplayer.j.a.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public synchronized com.anythink.expressad.exoplayer.j.a.n a(java.lang.String str, long j) {
        com.anythink.expressad.exoplayer.j.a.n b2;
        while (true) {
            b2 = b(str, j);
            if (b2 == null) {
                wait();
            }
        }
        return b2;
    }

    private void e() {
        if (!this.d.exists()) {
            this.d.mkdirs();
            return;
        }
        this.f.a();
        java.io.File[] listFiles = this.d.listFiles();
        if (listFiles == null) {
            return;
        }
        for (java.io.File file : listFiles) {
            if (!file.getName().equals(com.anythink.expressad.exoplayer.j.a.h.a)) {
                com.anythink.expressad.exoplayer.j.a.n a2 = file.length() > 0 ? com.anythink.expressad.exoplayer.j.a.n.a(file, this.f) : null;
                if (a2 != null) {
                    a(a2);
                } else {
                    file.delete();
                }
            }
        }
        this.f.d();
        try {
            this.f.b();
        } catch (com.anythink.expressad.exoplayer.j.a.a.C0203a unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.anythink.expressad.exoplayer.j.a.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public synchronized com.anythink.expressad.exoplayer.j.a.n b(java.lang.String str, long j) {
        com.anythink.expressad.exoplayer.j.a.n a2;
        com.anythink.expressad.exoplayer.j.a.n nVar;
        com.anythink.expressad.exoplayer.k.a.b(!this.i);
        com.anythink.expressad.exoplayer.j.a.g b2 = this.f.b(str);
        if (b2 == null) {
            nVar = com.anythink.expressad.exoplayer.j.a.n.b(str, j);
        } else {
            while (true) {
                a2 = b2.a(j);
                if (!a2.d || a2.e.exists()) {
                    break;
                }
                f();
            }
            nVar = a2;
        }
        if (!nVar.d) {
            com.anythink.expressad.exoplayer.j.a.g a3 = this.f.a(str);
            if (a3.b()) {
                return null;
            }
            a3.a(true);
            return nVar;
        }
        com.anythink.expressad.exoplayer.j.a.n b3 = this.f.b(str).b(nVar);
        java.util.ArrayList<com.anythink.expressad.exoplayer.j.a.a.b> arrayList = this.g.get(nVar.a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size);
            }
        }
        return b3;
    }

    private void f() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<com.anythink.expressad.exoplayer.j.a.g> it = this.f.c().iterator();
        while (it.hasNext()) {
            java.util.Iterator<com.anythink.expressad.exoplayer.j.a.n> it2 = it.next().c().iterator();
            while (it2.hasNext()) {
                com.anythink.expressad.exoplayer.j.a.n next = it2.next();
                if (!next.e.exists()) {
                    arrayList.add(next);
                }
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            a((com.anythink.expressad.exoplayer.j.a.e) arrayList.get(i), false);
        }
        this.f.d();
        this.f.b();
    }

    private com.anythink.expressad.exoplayer.j.a.n g(java.lang.String str, long j) {
        com.anythink.expressad.exoplayer.j.a.n a2;
        com.anythink.expressad.exoplayer.j.a.g b2 = this.f.b(str);
        if (b2 == null) {
            return com.anythink.expressad.exoplayer.j.a.n.b(str, j);
        }
        while (true) {
            a2 = b2.a(j);
            if (!a2.d || a2.e.exists()) {
                break;
            }
            f();
        }
        return a2;
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    @androidx.annotation.NonNull
    public final synchronized java.util.NavigableSet<com.anythink.expressad.exoplayer.j.a.e> a(java.lang.String str) {
        com.anythink.expressad.exoplayer.k.a.b(!this.i);
        com.anythink.expressad.exoplayer.j.a.g b2 = this.f.b(str);
        if (b2 != null && !b2.d()) {
            return new java.util.TreeSet((java.util.Collection) b2.c());
        }
        return new java.util.TreeSet();
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final synchronized java.util.NavigableSet<com.anythink.expressad.exoplayer.j.a.e> a(java.lang.String str, com.anythink.expressad.exoplayer.j.a.a.b bVar) {
        com.anythink.expressad.exoplayer.k.a.b(!this.i);
        java.util.ArrayList<com.anythink.expressad.exoplayer.j.a.a.b> arrayList = this.g.get(str);
        if (arrayList == null) {
            arrayList = new java.util.ArrayList<>();
            this.g.put(str, arrayList);
        }
        arrayList.add(bVar);
        return a(str);
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final synchronized void a() {
        if (this.i) {
            return;
        }
        this.g.clear();
        try {
            f();
        } finally {
            d(this.d);
            this.i = true;
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final synchronized void a(com.anythink.expressad.exoplayer.j.a.e eVar) {
        com.anythink.expressad.exoplayer.k.a.b(!this.i);
        com.anythink.expressad.exoplayer.j.a.g b2 = this.f.b(eVar.a);
        com.anythink.expressad.exoplayer.k.a.a(b2);
        com.anythink.expressad.exoplayer.k.a.b(b2.b());
        b2.a(false);
        this.f.d(b2.b);
        notifyAll();
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final synchronized void a(java.io.File file) {
        boolean z = true;
        com.anythink.expressad.exoplayer.k.a.b(!this.i);
        com.anythink.expressad.exoplayer.j.a.n a2 = com.anythink.expressad.exoplayer.j.a.n.a(file, this.f);
        com.anythink.expressad.exoplayer.k.a.b(a2 != null);
        com.anythink.expressad.exoplayer.j.a.g b2 = this.f.b(a2.a);
        com.anythink.expressad.exoplayer.k.a.a(b2);
        com.anythink.expressad.exoplayer.k.a.b(b2.b());
        if (file.exists()) {
            if (file.length() == 0) {
                file.delete();
                return;
            }
            long a3 = com.anythink.expressad.exoplayer.j.a.j.a(b2.a());
            if (a3 != -1) {
                if (a2.b + a2.c > a3) {
                    z = false;
                }
                com.anythink.expressad.exoplayer.k.a.b(z);
            }
            a(a2);
            this.f.b();
            notifyAll();
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final synchronized void a(java.lang.String str, com.anythink.expressad.exoplayer.j.a.k kVar) {
        com.anythink.expressad.exoplayer.k.a.b(!this.i);
        this.f.a(str, kVar);
        this.f.b();
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final synchronized boolean a(java.lang.String str, long j, long j2) {
        com.anythink.expressad.exoplayer.k.a.b(!this.i);
        com.anythink.expressad.exoplayer.j.a.g b2 = this.f.b(str);
        if (b2 != null) {
            if (b2.a(j, j2) >= j2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final synchronized long b(java.lang.String str) {
        return com.anythink.expressad.exoplayer.j.a.j.a(c(str));
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final synchronized long b(java.lang.String str, long j, long j2) {
        com.anythink.expressad.exoplayer.k.a.b(!this.i);
        com.anythink.expressad.exoplayer.j.a.g b2 = this.f.b(str);
        if (b2 != null) {
            return b2.a(j, j2);
        }
        return -j2;
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final synchronized java.util.Set<java.lang.String> b() {
        com.anythink.expressad.exoplayer.k.a.b(!this.i);
        return new java.util.HashSet(this.f.e());
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final synchronized void b(com.anythink.expressad.exoplayer.j.a.e eVar) {
        com.anythink.expressad.exoplayer.k.a.b(!this.i);
        a(eVar, true);
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final synchronized void b(java.lang.String str, com.anythink.expressad.exoplayer.j.a.a.b bVar) {
        if (this.i) {
            return;
        }
        java.util.ArrayList<com.anythink.expressad.exoplayer.j.a.a.b> arrayList = this.g.get(str);
        if (arrayList != null) {
            arrayList.remove(bVar);
            if (arrayList.isEmpty()) {
                this.g.remove(str);
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final synchronized long c() {
        com.anythink.expressad.exoplayer.k.a.b(!this.i);
        return this.h;
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final synchronized com.anythink.expressad.exoplayer.j.a.i c(java.lang.String str) {
        com.anythink.expressad.exoplayer.k.a.b(!this.i);
        return this.f.e(str);
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final synchronized java.io.File c(java.lang.String str, long j) {
        com.anythink.expressad.exoplayer.j.a.g b2;
        com.anythink.expressad.exoplayer.k.a.b(!this.i);
        b2 = this.f.b(str);
        com.anythink.expressad.exoplayer.k.a.a(b2);
        com.anythink.expressad.exoplayer.k.a.b(b2.b());
        if (!this.d.exists()) {
            this.d.mkdirs();
            f();
        }
        return com.anythink.expressad.exoplayer.j.a.n.a(this.d, b2.a, j, java.lang.System.currentTimeMillis());
    }

    @Override // com.anythink.expressad.exoplayer.j.a.a
    public final synchronized void d(java.lang.String str, long j) {
        com.anythink.expressad.exoplayer.j.a.k kVar = new com.anythink.expressad.exoplayer.j.a.k();
        com.anythink.expressad.exoplayer.j.a.j.a(kVar, j);
        a(str, kVar);
    }
}
