package com.anythink.core.b;

/* loaded from: classes12.dex */
public final class f {
    private static com.anythink.core.b.f e;
    java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> b;
    private com.anythink.core.api.MediationBidManager f;
    private final java.lang.String d = com.anythink.core.b.f.class.getSimpleName();
    java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.core.common.f.q> a = new java.util.concurrent.ConcurrentHashMap<>();
    java.util.List<java.lang.Integer> c = new java.util.concurrent.CopyOnWriteArrayList();

    private f() {
    }

    public static com.anythink.core.b.f a() {
        if (e == null) {
            e = new com.anythink.core.b.f();
        }
        return e;
    }

    private void a(java.lang.String str) {
        if (this.b == null) {
            this.b = new java.util.concurrent.ConcurrentHashMap<>();
        }
        this.b.put(str + "_c2sfirstStatus", 1);
    }

    private void a(java.lang.String str, com.anythink.core.common.f.au auVar, com.anythink.core.common.f.q qVar) {
        this.a.put(str + qVar.k, qVar);
        if (auVar.Y()) {
            com.anythink.core.common.a.a.a().a(str, qVar);
        }
    }

    private boolean b(java.lang.String str) {
        java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> concurrentHashMap = this.b;
        if (concurrentHashMap == null) {
            return true;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append("_c2sfirstStatus");
        return concurrentHashMap.get(sb.toString()) == null;
    }

    public final com.anythink.core.common.f.q a(java.lang.String str, com.anythink.core.common.f.au auVar) {
        com.anythink.core.common.f.q qVar = this.a.get(str + auVar.u());
        if (auVar.Y() && qVar == null) {
            qVar = com.anythink.core.common.a.a.a().a(str, auVar.u());
            if (qVar != null) {
                auVar.toString();
                this.a.put(str + auVar.u(), qVar);
            } else {
                auVar.toString();
            }
        }
        return qVar;
    }

    public final void a(int i) {
        synchronized (this.c) {
            if (!this.c.contains(java.lang.Integer.valueOf(i))) {
                this.c.add(java.lang.Integer.valueOf(i));
            }
        }
    }

    public final void a(com.anythink.core.api.MediationBidManager mediationBidManager) {
        this.f = mediationBidManager;
    }

    public final void a(java.lang.String str, com.anythink.core.common.f.q qVar) {
        if (qVar == null) {
            return;
        }
        com.anythink.core.common.f.q qVar2 = this.a.get(str + qVar.k);
        if (qVar2 == null || !android.text.TextUtils.equals(qVar.token, qVar2.token)) {
            return;
        }
        this.a.remove(str + qVar.k);
    }

    public final com.anythink.core.api.MediationBidManager b() {
        return this.f;
    }

    public final boolean b(int i) {
        boolean z;
        synchronized (this.c) {
            z = !this.c.contains(java.lang.Integer.valueOf(i));
        }
        return z;
    }
}
