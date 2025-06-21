package com.tanx.exposer.achieve.retry;

/* loaded from: classes19.dex */
public class tanxc_if {
    public android.content.Context a;
    public com.tanx.exposer.tanxc_for b;
    public com.tanx.exposer.achieve.retry.tanxc_do c;
    public com.tanx.exposer.achieve.retry.tanxc_if.tanxc_do d;
    public java.util.concurrent.atomic.AtomicInteger e;
    public boolean f;
    public final com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do.InterfaceC0493tanxc_do g;
    public int h;
    public java.util.concurrent.ConcurrentLinkedQueue<com.tanx.exposer.achieve.tanxc_if> i;

    /* renamed from: com.tanx.exposer.achieve.retry.tanxc_if$1, reason: invalid class name */
    public class AnonymousClass1 implements com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do.InterfaceC0493tanxc_do {
        public AnonymousClass1() {
        }

        @Override // com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do.InterfaceC0493tanxc_do
        public void tanxc_do(int i) {
            com.tanx.exposer.achieve.retry.tanxc_if tanxc_ifVar = com.tanx.exposer.achieve.retry.tanxc_if.this;
            boolean z = i != -1;
            tanxc_ifVar.f = z;
            if (z && tanxc_ifVar.b.tanxc_int() != null && com.tanx.exposer.achieve.retry.tanxc_if.this.b.tanxc_int().tanxc_do()) {
                com.tanx.exposer.achieve.retry.tanxc_if.this.tanxc_do();
            }
        }
    }

    /* renamed from: com.tanx.exposer.achieve.retry.tanxc_if$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do.tanxc_if.tanxc_do.tanxc_do(com.tanx.exposer.achieve.retry.tanxc_if.this.g);
        }
    }

    /* renamed from: com.tanx.exposer.achieve.retry.tanxc_if$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tanx.exposer.achieve.retry.tanxc_if.this.c();
            java.lang.String tanxc_do = com.tanx.exposer.tanxc_if.tanxc_for.tanxc_do(java.lang.System.currentTimeMillis(), "yyyy-MM-dd");
            com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do("AdRetryExposeManager", "currentDate=" + tanxc_do);
            com.tanx.exposer.achieve.retry.tanxc_if tanxc_ifVar = com.tanx.exposer.achieve.retry.tanxc_if.this;
            tanxc_ifVar.c.tanxc_do(tanxc_do, tanxc_ifVar.h);
            com.tanx.exposer.achieve.retry.tanxc_if.this.g();
        }
    }

    public static class tanxc_do {
        public int tanxc_do = 500;
        public int tanxc_if = 5;
    }

    /* renamed from: com.tanx.exposer.achieve.retry.tanxc_if$tanxc_if, reason: collision with other inner class name */
    public static class C0489tanxc_if {
        public static final com.tanx.exposer.achieve.retry.tanxc_if tanxc_do = new com.tanx.exposer.achieve.retry.tanxc_if((byte) 0);
    }

    public tanxc_if() {
        this.d = new com.tanx.exposer.achieve.retry.tanxc_if.tanxc_do();
        this.e = new java.util.concurrent.atomic.AtomicInteger(0);
        this.f = true;
        this.g = new com.tanx.exposer.achieve.retry.tanxc_if.AnonymousClass1();
        this.h = 3;
        this.i = new java.util.concurrent.ConcurrentLinkedQueue<>();
    }

    public /* synthetic */ tanxc_if(byte b) {
        this();
    }

    public final void b() {
        com.tanx.exposer.tanxc_do.tanxc_new.tanxc_if.tanxc_do(new com.tanx.exposer.achieve.retry.tanxc_if.AnonymousClass2(), 10000L);
    }

    public synchronized void c() {
        if (this.c == null) {
            this.c = new com.tanx.exposer.achieve.retry.tanxc_do(this.a);
        }
    }

    public final void d(com.tanx.exposer.achieve.tanxc_if tanxc_ifVar, int i, java.lang.String str, boolean z) {
        com.tanx.exposer.achieve.tanxc_do.tanxc_if tanxc_if = com.tanx.exposer.tanxc_for.tanxc_do().tanxc_if();
        if (tanxc_if == null || tanxc_ifVar.tanxc_long() == com.tanx.exposer.achieve.retry.AdMonitorRetryType.DB) {
            return;
        }
        if (z) {
            tanxc_if.tanxc_if(i, str, tanxc_ifVar.tanxc_for(), tanxc_ifVar.tanxc_int(), tanxc_ifVar.tanxc_goto());
        } else {
            tanxc_if.tanxc_do(i, str, tanxc_ifVar.tanxc_for(), tanxc_ifVar.tanxc_int(), tanxc_ifVar.tanxc_goto());
        }
    }

    public final void e(com.tanx.exposer.achieve.tanxc_if tanxc_ifVar, boolean z) {
        if (tanxc_ifVar == null) {
            return;
        }
        if (z) {
            tanxc_ifVar.tanxc_else().incrementAndGet();
            this.e.incrementAndGet();
        }
        new com.tanx.exposer.tanxc_do.tanxc_for.tanxc_if(this.b.tanxc_int().tanxc_int()).tanxc_do(tanxc_ifVar.tanxc_if(), tanxc_ifVar.tanxc_int() == com.tanx.exposer.achieve.AdMonitorType.EXPOSE ? new com.tanx.exposer.achieve.tanxc_if.tanxc_if.tanxc_do(tanxc_ifVar, z) : new com.tanx.exposer.achieve.tanxc_if.tanxc_do.C0491tanxc_do(tanxc_ifVar, z));
    }

    public final void f() {
        com.tanx.exposer.tanxc_do.tanxc_new.tanxc_if.tanxc_do(new com.tanx.exposer.achieve.retry.tanxc_if.AnonymousClass3(), 0L);
    }

    public final void g() {
        c();
        java.util.List<com.tanx.exposer.achieve.tanxc_if> tanxc_do2 = this.c.tanxc_do(com.tanx.exposer.tanxc_if.tanxc_for.tanxc_do(java.lang.System.currentTimeMillis(), "yyyy-MM-dd"));
        if (tanxc_do2.isEmpty()) {
            if (com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do) {
                com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do("AdRetryExposeManager", "sendRetryMonitor return because no retry monitor info.");
                return;
            }
            return;
        }
        int size = tanxc_do2.size();
        if (com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do) {
            com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do("AdRetryExposeManager", "sendRetryMonitor: count = " + size);
        }
        for (int i = 0; i < size; i++) {
            com.tanx.exposer.achieve.tanxc_if tanxc_ifVar = tanxc_do2.get(i);
            tanxc_ifVar.tanxc_do(com.tanx.exposer.achieve.retry.AdMonitorRetryType.DB);
            if (!tanxc_if(tanxc_ifVar)) {
                this.c.tanxc_do(tanxc_ifVar.tanxc_do());
            } else if (this.i.contains(tanxc_ifVar)) {
                this.c.tanxc_do(tanxc_ifVar.tanxc_do());
            } else {
                h();
                this.i.add(tanxc_ifVar);
            }
        }
        if (com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do.tanxc_if.tanxc_do.tanxc_do()) {
            tanxc_do();
        } else if (com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do) {
            com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do("AdRetryExposeManager", "sendRetryMonitor return because no net.");
        }
    }

    public final void h() {
        if (this.i.size() < this.d.tanxc_do) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(this.i.size() - this.d.tanxc_do);
        while (this.i.size() >= this.d.tanxc_do) {
            com.tanx.exposer.achieve.tanxc_if poll = this.i.poll();
            if (poll != null) {
                arrayList.add(poll);
                c();
                this.c.tanxc_do(poll.tanxc_do());
            }
        }
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            d((com.tanx.exposer.achieve.tanxc_if) it.next(), -2, "retry fail,exceed max retry count", false);
        }
    }

    public synchronized void tanxc_do() {
        int i = this.d.tanxc_if - this.e.get();
        com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do("AdRetryExposeManager", "availableRetryCount=" + i);
        if (i <= 0) {
            return;
        }
        if (this.i.size() <= 0) {
            return;
        }
        com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do("AdRetryExposeManager", "failedRequestQueue.size=" + this.i.size());
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                break;
            }
            com.tanx.exposer.achieve.tanxc_if poll = this.i.poll();
            if (poll != null) {
                arrayList.add(poll);
                c();
                this.c.tanxc_do(poll.tanxc_do());
            }
            i = i2;
        }
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            e((com.tanx.exposer.achieve.tanxc_if) it.next(), true);
        }
    }

    public void tanxc_do(android.content.Context context, com.tanx.exposer.tanxc_for tanxc_forVar) {
        this.a = context;
        this.b = tanxc_forVar;
        if (tanxc_forVar.tanxc_int() != null) {
            this.h = tanxc_forVar.tanxc_int().tanxc_for();
        }
        f();
        b();
    }

    public void tanxc_do(com.tanx.exposer.achieve.tanxc_if tanxc_ifVar) {
        if (tanxc_ifVar != null && this.i.contains(tanxc_ifVar) && this.i.remove(tanxc_ifVar)) {
            e(tanxc_ifVar, false);
        }
    }

    public void tanxc_do(com.tanx.exposer.achieve.tanxc_if tanxc_ifVar, int i, java.lang.String str, boolean z) {
        if (tanxc_ifVar == null) {
            return;
        }
        if (z) {
            this.e.decrementAndGet();
        } else {
            tanxc_ifVar.tanxc_do(com.tanx.exposer.achieve.retry.AdMonitorRetryType.NONE);
            com.tanx.exposer.tanxc_do.tanxc_do.tanxc_if.tanxc_do().tanxc_do("TanxExposer", "EXPOSER_SUCCESS_POINT", java.lang.String.valueOf(i), str, tanxc_ifVar.tanxc_goto() == null ? "" : tanxc_ifVar.tanxc_goto().toString());
        }
        com.tanx.exposer.tanxc_do.tanxc_try.tanxc_for.tanxc_do(tanxc_ifVar, i, str, z, tanxc_ifVar.tanxc_long().name());
        c();
        if (!tanxc_if(tanxc_ifVar)) {
            d(tanxc_ifVar, i, str, false);
        } else {
            if (this.i.contains(tanxc_ifVar)) {
                return;
            }
            h();
            this.i.add(tanxc_ifVar);
            this.c.tanxc_do(tanxc_ifVar);
            d(tanxc_ifVar, i, str, true);
        }
    }

    public void tanxc_do(com.tanx.exposer.achieve.tanxc_if tanxc_ifVar, boolean z) {
        if (z) {
            this.e.decrementAndGet();
        }
        if (tanxc_ifVar == null) {
            return;
        }
        if (!z) {
            tanxc_ifVar.tanxc_do(com.tanx.exposer.achieve.retry.AdMonitorRetryType.NONE);
            com.tanx.exposer.tanxc_do.tanxc_do.tanxc_if.tanxc_do().tanxc_do("TanxExposer", "EXPOSER_SUCCESS_POINT", tanxc_ifVar.tanxc_goto() == null ? "" : tanxc_ifVar.tanxc_goto().toString());
        }
        com.tanx.exposer.tanxc_do.tanxc_try.tanxc_for.tanxc_do(tanxc_ifVar, z, tanxc_ifVar.tanxc_long().name());
        com.tanx.exposer.achieve.tanxc_do.tanxc_if tanxc_if = com.tanx.exposer.tanxc_for.tanxc_do().tanxc_if();
        if (tanxc_if != null && tanxc_ifVar.tanxc_long() != com.tanx.exposer.achieve.retry.AdMonitorRetryType.DB) {
            tanxc_if.tanxc_do(tanxc_ifVar.tanxc_for(), tanxc_ifVar.tanxc_int(), tanxc_ifVar.tanxc_goto());
        }
        tanxc_do();
    }

    public boolean tanxc_if(com.tanx.exposer.achieve.tanxc_if tanxc_ifVar) {
        com.tanx.exposer.tanxc_do tanxc_int = this.b.tanxc_int();
        return tanxc_int != null && tanxc_int.tanxc_if() && tanxc_int.tanxc_byte().contains(tanxc_ifVar.tanxc_int()) && tanxc_ifVar.tanxc_char() > 0 && tanxc_ifVar.tanxc_else().get() < tanxc_ifVar.tanxc_char();
    }
}
