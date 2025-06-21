package com.xiaomi.push;

/* loaded from: classes19.dex */
final class cl implements java.lang.Runnable {
    final /* synthetic */ java.lang.String a;
    final /* synthetic */ java.lang.Throwable b;
    final /* synthetic */ com.xiaomi.push.ck c;

    public cl(com.xiaomi.push.ck ckVar, java.lang.String str, java.lang.Throwable th) {
        this.c = ckVar;
        this.a = str;
        this.b = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        java.util.List list;
        java.text.SimpleDateFormat simpleDateFormat;
        java.lang.String str;
        java.util.List list2;
        java.util.List list3;
        java.util.List list4;
        java.text.SimpleDateFormat simpleDateFormat2;
        java.lang.String str2;
        java.util.List list5;
        java.util.List list6;
        java.lang.String unused;
        java.lang.String unused2;
        list = com.xiaomi.push.ck.f;
        simpleDateFormat = com.xiaomi.push.ck.b;
        str = this.c.c;
        list.add(new android.util.Pair(java.lang.String.format("%1$s %2$s %3$s ", simpleDateFormat.format(new java.util.Date()), str, this.a), this.b));
        list2 = com.xiaomi.push.ck.f;
        if (list2.size() > 20000) {
            list3 = com.xiaomi.push.ck.f;
            int size = (list3.size() - 20000) + 50;
            for (int i = 0; i < size; i++) {
                try {
                    list5 = com.xiaomi.push.ck.f;
                    if (list5.size() > 0) {
                        list6 = com.xiaomi.push.ck.f;
                        list6.remove(0);
                    }
                } catch (java.lang.IndexOutOfBoundsException unused3) {
                }
            }
            list4 = com.xiaomi.push.ck.f;
            simpleDateFormat2 = com.xiaomi.push.ck.b;
            str2 = this.c.c;
            list4.add(new android.util.Pair(java.lang.String.format("%1$s %2$s %3$s ", simpleDateFormat2.format(new java.util.Date()), str2, "flush " + size + " lines logs."), null));
        }
        try {
            if (com.xiaomi.push.e.c()) {
                com.xiaomi.push.ck.b(this.c);
            } else {
                unused = this.c.c;
            }
        } catch (java.lang.Exception unused4) {
            unused2 = this.c.c;
        }
    }
}
