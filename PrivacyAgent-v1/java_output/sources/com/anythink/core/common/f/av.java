package com.anythink.core.common.f;

/* loaded from: classes12.dex */
public final class av {
    private java.lang.String c;
    private final java.lang.String a = "anythink_" + com.anythink.core.common.f.av.class.getSimpleName();
    private int b = 1;
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.core.common.f.aq> d = new java.util.concurrent.ConcurrentHashMap<>(3);

    /* renamed from: com.anythink.core.common.f.av$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.common.f.av.a {
        final /* synthetic */ com.anythink.core.common.f.aq[] a;

        public AnonymousClass1(com.anythink.core.common.f.aq[] aqVarArr) {
            this.a = aqVarArr;
        }

        /* JADX WARN: Removed duplicated region for block: B:6:0x0041  */
        @Override // com.anythink.core.common.f.av.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean a(com.anythink.core.common.f.aq aqVar) {
            boolean z;
            com.anythink.core.common.f.aq[] aqVarArr = this.a;
            if (aqVarArr[0] == null) {
                aqVarArr[0] = aqVar;
            } else if (aqVar.e() >= this.a[0].e() && (aqVar.e() != this.a[0].e() || aqVar.f() >= this.a[0].f())) {
                z = false;
                if (z) {
                    this.a[0] = aqVar;
                }
                return true;
            }
            z = true;
            if (z) {
            }
            return true;
        }
    }

    /* renamed from: com.anythink.core.common.f.av$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.core.common.f.av.a {
        final /* synthetic */ com.anythink.core.common.f.f a;
        final /* synthetic */ java.util.List b;
        final /* synthetic */ com.anythink.core.common.f.q c;

        public AnonymousClass2(com.anythink.core.common.f.f fVar, java.util.List list, com.anythink.core.common.f.q qVar) {
            this.a = fVar;
            this.b = list;
            this.c = qVar;
        }

        @Override // com.anythink.core.common.f.av.a
        public final boolean a(com.anythink.core.common.f.aq aqVar) {
            if (!this.a.c && aqVar.d()) {
                this.a.c = true;
            }
            com.anythink.core.common.f.b c = aqVar.c();
            if (c != null) {
                if (this.b.size() != 0) {
                    int i = 0;
                    while (true) {
                        if (i >= this.b.size()) {
                            break;
                        }
                        if (com.anythink.core.common.o.h.a(c.d().getUnitGroupInfo()) > com.anythink.core.common.o.h.a(((com.anythink.core.common.f.b) this.b.get(i)).d().getUnitGroupInfo())) {
                            this.b.add(i, c);
                            break;
                        }
                        if (i == this.b.size() - 1) {
                            this.b.add(c);
                            break;
                        }
                        i++;
                    }
                } else {
                    this.b.add(c);
                }
                com.anythink.core.common.f.q M = c.d().getUnitGroupInfo().M();
                com.anythink.core.common.f.q qVar = this.c;
                if (qVar != null && M != null && android.text.TextUtils.equals(qVar.token, M.token)) {
                    this.a.b = c;
                }
            }
            return true;
        }
    }

    /* renamed from: com.anythink.core.common.f.av$3, reason: invalid class name */
    public class AnonymousClass3 implements com.anythink.core.common.f.av.a {
        final /* synthetic */ int a;

        public AnonymousClass3(int i) {
            this.a = i;
        }

        @Override // com.anythink.core.common.f.av.a
        public final boolean a(com.anythink.core.common.f.aq aqVar) {
            aqVar.a(this.a);
            return true;
        }
    }

    public interface a {
        boolean a(com.anythink.core.common.f.aq aqVar);
    }

    public av(java.lang.String str, java.lang.String str2) {
        this.c = str + "_" + str2;
    }

    private synchronized void a() {
        if (this.d.entrySet() == null) {
            return;
        }
        if (this.d.size() < this.b) {
            return;
        }
        this.d.size();
        com.anythink.core.common.f.aq[] aqVarArr = new com.anythink.core.common.f.aq[1];
        a(new com.anythink.core.common.f.av.AnonymousClass1(aqVarArr));
        if (this.d.size() < this.b) {
            this.d.size();
        } else if (aqVarArr[0] != null) {
            aqVarArr[0].a();
            this.d.remove(aqVarArr[0].a());
            aqVarArr[0].g();
        }
    }

    private synchronized void a(com.anythink.core.common.f.av.a aVar) {
        boolean z;
        java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.core.common.f.aq> concurrentHashMap = this.d;
        if (concurrentHashMap == null) {
            return;
        }
        java.util.Set<java.util.Map.Entry<java.lang.String, com.anythink.core.common.f.aq>> entrySet = concurrentHashMap.entrySet();
        if (entrySet == null) {
            return;
        }
        for (java.util.Map.Entry<java.lang.String, com.anythink.core.common.f.aq> entry : entrySet) {
            com.anythink.core.common.f.aq value = entry.getValue();
            com.anythink.core.common.f.b c = value.c();
            if (c == null || !c.j()) {
                entry.getKey();
                z = false;
            } else {
                entry.getKey();
                value.e();
                c.toString();
                entry.getKey();
                aVar.a(value);
                z = true;
            }
            if (!z) {
                entry.getKey();
                this.d.remove(entry.getKey());
            }
        }
    }

    public final com.anythink.core.common.f.f a(com.anythink.core.common.f.q qVar) {
        com.anythink.core.common.f.f fVar = new com.anythink.core.common.f.f();
        java.util.ArrayList arrayList = new java.util.ArrayList(3);
        fVar.a = arrayList;
        a(new com.anythink.core.common.f.av.AnonymousClass2(fVar, arrayList, qVar));
        return fVar;
    }

    public final void a(int i) {
        if (i <= 0) {
            return;
        }
        this.b = i;
    }

    public final synchronized void a(com.anythink.core.common.f.b bVar) {
        if (this.d == null) {
            return;
        }
        if (bVar != null) {
            com.anythink.core.common.f.aq aqVar = this.d.get(bVar.h().ad());
            if (aqVar != null) {
                aqVar.a(bVar);
                if (aqVar.b() == 0) {
                    this.d.remove(aqVar.a());
                    aqVar.a();
                }
            }
        }
    }

    public final synchronized void a(java.lang.String str, com.anythink.core.common.f.aq aqVar) {
        a();
        this.d.put(str, aqVar);
    }

    public final synchronized void b(int i) {
        a(new com.anythink.core.common.f.av.AnonymousClass3(i));
    }
}
