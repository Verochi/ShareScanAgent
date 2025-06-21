package com.tanx.exposer.achieve.tanxc_if;

/* loaded from: classes19.dex */
public class tanxc_do {
    protected java.util.List<java.lang.String> tanxc_do;
    protected com.tanx.exposer.tanxc_if tanxc_for;
    protected com.tanx.exposer.achieve.AdMonitorType tanxc_if;
    protected com.tanx.exposer.tanxc_do tanxc_int = com.tanx.exposer.tanxc_for.tanxc_do().tanxc_int();

    /* renamed from: com.tanx.exposer.achieve.tanxc_if.tanxc_do$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public final /* synthetic */ java.lang.String n;
        public final /* synthetic */ java.lang.String t;
        public final /* synthetic */ java.lang.String u;

        public AnonymousClass1(java.lang.String str, java.lang.String str2, java.lang.String str3) {
            this.n = str;
            this.t = str2;
            this.u = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tanx.exposer.achieve.tanxc_if.tanxc_do.this.b(this.n, this.t, this.u);
        }
    }

    /* renamed from: com.tanx.exposer.achieve.tanxc_if.tanxc_do$tanxc_do, reason: collision with other inner class name */
    public static class C0491tanxc_do implements com.tanx.exposer.tanxc_do.tanxc_int.tanxc_if {
        protected final boolean tanxc_do;
        protected com.tanx.exposer.achieve.tanxc_if tanxc_if;

        /* renamed from: com.tanx.exposer.achieve.tanxc_if.tanxc_do$tanxc_do$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.tanx.exposer.achieve.retry.tanxc_if tanxc_ifVar = com.tanx.exposer.achieve.retry.tanxc_if.C0489tanxc_if.tanxc_do;
                com.tanx.exposer.achieve.tanxc_if.tanxc_do.C0491tanxc_do c0491tanxc_do = com.tanx.exposer.achieve.tanxc_if.tanxc_do.C0491tanxc_do.this;
                tanxc_ifVar.tanxc_do(c0491tanxc_do.tanxc_if, c0491tanxc_do.tanxc_do);
            }
        }

        /* renamed from: com.tanx.exposer.achieve.tanxc_if.tanxc_do$tanxc_do$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            public final /* synthetic */ int n;
            public final /* synthetic */ java.lang.String t;

            public AnonymousClass2(int i, java.lang.String str) {
                this.n = i;
                this.t = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.tanx.exposer.achieve.retry.tanxc_if tanxc_ifVar = com.tanx.exposer.achieve.retry.tanxc_if.C0489tanxc_if.tanxc_do;
                com.tanx.exposer.achieve.tanxc_if.tanxc_do.C0491tanxc_do c0491tanxc_do = com.tanx.exposer.achieve.tanxc_if.tanxc_do.C0491tanxc_do.this;
                tanxc_ifVar.tanxc_do(c0491tanxc_do.tanxc_if, this.n, this.t, c0491tanxc_do.tanxc_do);
            }
        }

        public C0491tanxc_do(com.tanx.exposer.achieve.tanxc_if tanxc_ifVar, boolean z) {
            this.tanxc_if = tanxc_ifVar;
            this.tanxc_do = z;
        }

        @Override // com.tanx.exposer.tanxc_do.tanxc_int.tanxc_if
        public void tanxc_do() {
            com.tanx.exposer.tanxc_do.tanxc_new.tanxc_if.tanxc_do(new com.tanx.exposer.achieve.tanxc_if.tanxc_do.C0491tanxc_do.AnonymousClass1(), 0L);
        }

        @Override // com.tanx.exposer.tanxc_do.tanxc_int.tanxc_if
        public void tanxc_do(int i, java.lang.String str) {
            com.tanx.exposer.tanxc_do.tanxc_new.tanxc_if.tanxc_do(new com.tanx.exposer.achieve.tanxc_if.tanxc_do.C0491tanxc_do.AnonymousClass2(i, str), 0L);
        }
    }

    public tanxc_do(com.tanx.exposer.achieve.AdMonitorType adMonitorType, java.util.List<java.lang.String> list, com.tanx.exposer.tanxc_if tanxc_ifVar) {
        this.tanxc_if = adMonitorType;
        this.tanxc_do = list;
        this.tanxc_for = tanxc_ifVar;
    }

    public final void b(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.tanx.exposer.tanxc_if tanxc_ifVar = this.tanxc_for;
        java.lang.String tanxc_do = tanxc_ifVar == null ? str : com.tanx.exposer.tanxc_if.tanxc_if.tanxc_do(str, tanxc_ifVar.tanxc_if());
        com.tanx.exposer.tanxc_do.tanxc_try.tanxc_for.tanxc_do(this.tanxc_for, this.tanxc_if, str2, str3);
        com.tanx.exposer.achieve.tanxc_if tanxc_ifVar2 = new com.tanx.exposer.achieve.tanxc_if(str, tanxc_do, this.tanxc_if, str2, str3, this.tanxc_int.tanxc_for());
        tanxc_ifVar2.tanxc_do(this.tanxc_for);
        new com.tanx.exposer.tanxc_do.tanxc_for.tanxc_if(this.tanxc_int.tanxc_int()).tanxc_do(tanxc_do, new com.tanx.exposer.achieve.tanxc_if.tanxc_do.C0491tanxc_do(tanxc_ifVar2, false));
    }

    public com.tanx.exposer.achieve.AdMonitorCommitResult tanxc_do() {
        for (java.lang.String str : this.tanxc_do) {
            java.lang.String tanxc_do = com.tanx.exposer.tanxc_if.tanxc_if.tanxc_do(str);
            if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(tanxc_do)) {
                com.tanx.exposer.tanxc_do.tanxc_try.tanxc_for.tanxc_if(this.tanxc_for, this.tanxc_if, "url_is_empty_or_hash_error");
            } else {
                java.lang.String host = android.net.Uri.parse(str).getHost();
                if (android.text.TextUtils.isEmpty(host)) {
                    com.tanx.exposer.tanxc_do.tanxc_try.tanxc_for.tanxc_if(this.tanxc_for, this.tanxc_if, "domain_not_right");
                } else {
                    com.tanx.exposer.tanxc_do.tanxc_new.tanxc_if.tanxc_do(new com.tanx.exposer.achieve.tanxc_if.tanxc_do.AnonymousClass1(str, host, tanxc_do), 0L);
                }
            }
        }
        return com.tanx.exposer.achieve.AdMonitorCommitResult.COMMITED;
    }
}
