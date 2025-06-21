package com.anythink.basead.f.a;

/* loaded from: classes12.dex */
public final class a {
    private static com.anythink.basead.f.a.a a;
    private android.content.Context b;

    /* renamed from: com.anythink.basead.f.a.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.Comparator<com.anythink.basead.c.c> {
        public AnonymousClass1() {
        }

        private static int a(com.anythink.basead.c.c cVar, com.anythink.basead.c.c cVar2) {
            return java.lang.Integer.valueOf(cVar.d).compareTo(java.lang.Integer.valueOf(cVar2.d));
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(com.anythink.basead.c.c cVar, com.anythink.basead.c.c cVar2) {
            return java.lang.Integer.valueOf(cVar.d).compareTo(java.lang.Integer.valueOf(cVar2.d));
        }
    }

    private a(android.content.Context context) {
        this.b = context.getApplicationContext();
    }

    public static com.anythink.basead.f.a.a a(android.content.Context context) {
        if (a == null) {
            a = new com.anythink.basead.f.a.a(context);
        }
        return a;
    }

    private static boolean a(com.anythink.core.common.f.z zVar) {
        java.util.List<java.lang.String> j = com.anythink.core.common.b.o.a().j();
        if (j == null) {
            return false;
        }
        java.util.Iterator<java.lang.String> it = j.iterator();
        while (it.hasNext()) {
            if (android.text.TextUtils.equals(zVar.E(), it.next())) {
                return true;
            }
        }
        return false;
    }

    public final com.anythink.core.common.f.z a(java.lang.String str, java.lang.String str2) {
        com.anythink.core.d.e a2 = com.anythink.core.d.f.a(this.b).a(str);
        if (a2 == null) {
            return null;
        }
        return a2.b(str2);
    }

    public final void a(java.lang.String str) {
        java.util.List<com.anythink.core.common.f.z> Q;
        com.anythink.core.common.f.ab P;
        com.anythink.core.d.e a2 = com.anythink.core.d.f.a(this.b).a(str);
        if (a2 == null || (Q = a2.Q()) == null || (P = a2.P()) == null) {
            return;
        }
        com.anythink.basead.a.e.a();
        int size = Q.size();
        for (int i = 0; i < size; i++) {
            com.anythink.core.common.f.m mVar = new com.anythink.core.common.f.m();
            mVar.n = P;
            com.anythink.basead.a.e.a(str, true, Q.get(i), mVar, null);
        }
    }

    public final void a(java.lang.String str, com.anythink.core.common.f.z zVar, com.anythink.core.common.f.m mVar, com.anythink.basead.a.b.b.InterfaceC0129b interfaceC0129b) {
        if (a(zVar)) {
            interfaceC0129b.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.h, com.anythink.basead.c.f.H));
            return;
        }
        if (com.anythink.basead.f.a.b.a(this.b).b(zVar)) {
            interfaceC0129b.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.e, com.anythink.basead.c.f.A));
        } else if (com.anythink.basead.f.a.b.a(this.b).c(zVar)) {
            interfaceC0129b.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.f, com.anythink.basead.c.f.B));
        } else {
            com.anythink.basead.a.e.a();
            com.anythink.basead.a.e.a(str, zVar, mVar, interfaceC0129b);
        }
    }

    public final boolean a(com.anythink.core.common.f.z zVar, com.anythink.core.common.f.m mVar, boolean z) {
        if (this.b == null || zVar == null || a(zVar)) {
            return false;
        }
        if (z) {
            com.anythink.basead.a.e.a();
            return com.anythink.basead.a.e.a(zVar, mVar);
        }
        if (!com.anythink.basead.f.a.b.a(this.b).b(zVar) && !com.anythink.basead.f.a.b.a(this.b).c(zVar)) {
            com.anythink.basead.a.e.a();
            if (com.anythink.basead.a.e.a(zVar, mVar)) {
                return true;
            }
        }
        return false;
    }

    public final java.lang.String b(java.lang.String str) {
        com.anythink.core.d.e a2 = com.anythink.core.d.f.a(this.b).a(str);
        if (a2 == null) {
            return "";
        }
        java.util.List<com.anythink.core.common.f.z> Q = a2.Q();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (Q == null || Q.size() == 0) {
            return "";
        }
        for (int size = Q.size() - 1; size >= 0; size--) {
            com.anythink.core.common.f.z zVar = Q.get(size);
            com.anythink.basead.a.e.a();
            if (com.anythink.basead.a.e.a(zVar, a2.ag(), a2.P())) {
                arrayList.add(com.anythink.basead.f.a.b.a(this.b).d(zVar));
            } else {
                Q.remove(size);
            }
        }
        if (arrayList.size() == 0) {
            return "";
        }
        java.util.Collections.sort(arrayList, new com.anythink.basead.f.a.a.AnonymousClass1());
        return ((com.anythink.basead.c.c) arrayList.get(0)).a;
    }
}
