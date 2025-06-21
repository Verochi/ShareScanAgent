package com.xiaomi.push;

/* loaded from: classes19.dex */
final class bx extends com.xiaomi.push.br {
    com.xiaomi.push.br m;
    final /* synthetic */ com.xiaomi.push.br n;
    final /* synthetic */ com.xiaomi.push.bv o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bx(com.xiaomi.push.bv bvVar, java.lang.String str, com.xiaomi.push.br brVar) {
        super(str);
        this.o = bvVar;
        this.n = brVar;
        this.m = brVar;
        this.c = this.c;
        if (brVar != null) {
            this.g = brVar.g;
        }
    }

    @Override // com.xiaomi.push.br
    public final synchronized java.util.ArrayList<java.lang.String> a(boolean z) {
        java.util.ArrayList<java.lang.String> arrayList;
        arrayList = new java.util.ArrayList<>();
        com.xiaomi.push.br brVar = this.m;
        if (brVar != null) {
            arrayList.addAll(brVar.a(true));
        }
        java.util.Map<java.lang.String, com.xiaomi.push.br> map = com.xiaomi.push.bv.b;
        synchronized (map) {
            com.xiaomi.push.br brVar2 = map.get(this.c);
            if (brVar2 != null) {
                java.util.Iterator<java.lang.String> it = brVar2.a(true).iterator();
                while (it.hasNext()) {
                    java.lang.String next = it.next();
                    if (arrayList.indexOf(next) == -1) {
                        arrayList.add(next);
                    }
                }
                arrayList.remove(this.c);
                arrayList.add(this.c);
            }
        }
        return arrayList;
    }

    @Override // com.xiaomi.push.br
    public final synchronized void a(java.lang.String str, com.xiaomi.push.bq bqVar) {
        com.xiaomi.push.br brVar = this.m;
        if (brVar != null) {
            brVar.a(str, bqVar);
        }
    }

    @Override // com.xiaomi.push.br
    public final boolean a() {
        return false;
    }
}
