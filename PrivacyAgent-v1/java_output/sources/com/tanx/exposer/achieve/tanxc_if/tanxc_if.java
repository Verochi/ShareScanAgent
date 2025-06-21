package com.tanx.exposer.achieve.tanxc_if;

/* loaded from: classes19.dex */
public class tanxc_if extends com.tanx.exposer.achieve.tanxc_if.tanxc_do {
    public static java.util.Queue<java.lang.String> a = new java.util.concurrent.ConcurrentLinkedQueue();
    public static java.util.Map<java.lang.String, com.tanx.exposer.achieve.tanxc_if> b = new java.util.concurrent.ConcurrentHashMap();

    /* renamed from: com.tanx.exposer.achieve.tanxc_if.tanxc_if$1, reason: invalid class name */
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
            com.tanx.exposer.achieve.tanxc_if.tanxc_if tanxc_ifVar = com.tanx.exposer.achieve.tanxc_if.tanxc_if.this;
            tanxc_ifVar.d(this.n, this.t, this.u, tanxc_ifVar.tanxc_if);
        }
    }

    public static class tanxc_do extends com.tanx.exposer.achieve.tanxc_if.tanxc_do.C0491tanxc_do {

        /* renamed from: com.tanx.exposer.achieve.tanxc_if.tanxc_if$tanxc_do$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.tanx.exposer.achieve.retry.tanxc_if tanxc_ifVar = com.tanx.exposer.achieve.retry.tanxc_if.C0489tanxc_if.tanxc_do;
                com.tanx.exposer.achieve.tanxc_if.tanxc_if.tanxc_do tanxc_doVar = com.tanx.exposer.achieve.tanxc_if.tanxc_if.tanxc_do.this;
                tanxc_ifVar.tanxc_do(tanxc_doVar.tanxc_if, tanxc_doVar.tanxc_do);
                com.tanx.exposer.achieve.tanxc_if.tanxc_if.b.remove(com.tanx.exposer.achieve.tanxc_if.tanxc_if.tanxc_do.this.tanxc_if.tanxc_new());
                if (com.tanx.exposer.achieve.tanxc_if.tanxc_if.a.size() >= 1000) {
                    com.tanx.exposer.achieve.tanxc_if.tanxc_if.a.poll();
                }
                com.tanx.exposer.achieve.tanxc_if.tanxc_if.a.offer(com.tanx.exposer.achieve.tanxc_if.tanxc_if.tanxc_do.this.tanxc_if.tanxc_new());
            }
        }

        /* renamed from: com.tanx.exposer.achieve.tanxc_if.tanxc_if$tanxc_do$2, reason: invalid class name */
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
                com.tanx.exposer.achieve.tanxc_if.tanxc_if.tanxc_do tanxc_doVar = com.tanx.exposer.achieve.tanxc_if.tanxc_if.tanxc_do.this;
                tanxc_ifVar.tanxc_do(tanxc_doVar.tanxc_if, this.n, this.t, tanxc_doVar.tanxc_do);
                if (tanxc_ifVar.tanxc_if(com.tanx.exposer.achieve.tanxc_if.tanxc_if.tanxc_do.this.tanxc_if)) {
                    return;
                }
                com.tanx.exposer.achieve.tanxc_if.tanxc_if.b.remove(com.tanx.exposer.achieve.tanxc_if.tanxc_if.tanxc_do.this.tanxc_if.tanxc_new());
            }
        }

        public tanxc_do(com.tanx.exposer.achieve.tanxc_if tanxc_ifVar, boolean z) {
            super(tanxc_ifVar, z);
        }

        @Override // com.tanx.exposer.achieve.tanxc_if.tanxc_do.C0491tanxc_do, com.tanx.exposer.tanxc_do.tanxc_int.tanxc_if
        public void tanxc_do() {
            com.tanx.exposer.tanxc_do.tanxc_new.tanxc_if.tanxc_do(new com.tanx.exposer.achieve.tanxc_if.tanxc_if.tanxc_do.AnonymousClass1(), 0L);
        }

        @Override // com.tanx.exposer.achieve.tanxc_if.tanxc_do.C0491tanxc_do, com.tanx.exposer.tanxc_do.tanxc_int.tanxc_if
        public void tanxc_do(int i, java.lang.String str) {
            com.tanx.exposer.tanxc_do.tanxc_new.tanxc_if.tanxc_do(new com.tanx.exposer.achieve.tanxc_if.tanxc_if.tanxc_do.AnonymousClass2(i, str), 0L);
        }
    }

    public tanxc_if(com.tanx.exposer.achieve.AdMonitorType adMonitorType, java.util.List<java.lang.String> list, com.tanx.exposer.tanxc_if tanxc_ifVar) {
        super(adMonitorType, list, tanxc_ifVar);
    }

    public final void d(java.lang.String str, java.lang.String str2, java.lang.String str3, com.tanx.exposer.achieve.AdMonitorType adMonitorType) {
        if (a.contains(str3)) {
            com.tanx.exposer.tanxc_do.tanxc_try.tanxc_for.tanxc_if(this.tanxc_for, adMonitorType);
            return;
        }
        com.tanx.exposer.achieve.tanxc_if tanxc_ifVar = b.get(str3);
        if (tanxc_ifVar != null) {
            com.tanx.exposer.achieve.retry.tanxc_if.C0489tanxc_if.tanxc_do.tanxc_do(tanxc_ifVar);
            com.tanx.exposer.tanxc_if tanxc_ifVar2 = this.tanxc_for;
            if (tanxc_ifVar2 != null) {
                com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do("tanx_deduplication_request_pending", tanxc_ifVar2.toString());
                return;
            }
            return;
        }
        com.tanx.exposer.tanxc_do.tanxc_try.tanxc_for.tanxc_do(this.tanxc_for, this.tanxc_if, str2, str3);
        com.tanx.exposer.tanxc_if tanxc_ifVar3 = this.tanxc_for;
        java.lang.String tanxc_do2 = tanxc_ifVar3 == null ? str : com.tanx.exposer.tanxc_if.tanxc_if.tanxc_do(str, tanxc_ifVar3.tanxc_if());
        com.tanx.exposer.achieve.tanxc_if tanxc_ifVar4 = new com.tanx.exposer.achieve.tanxc_if(str, tanxc_do2, this.tanxc_if, str2, str3, this.tanxc_int.tanxc_for());
        tanxc_ifVar4.tanxc_do(this.tanxc_for);
        new com.tanx.exposer.tanxc_do.tanxc_for.tanxc_if(this.tanxc_int.tanxc_int()).tanxc_do(tanxc_do2, new com.tanx.exposer.achieve.tanxc_if.tanxc_if.tanxc_do(tanxc_ifVar4, false));
        b.put(str3, tanxc_ifVar4);
    }

    @Override // com.tanx.exposer.achieve.tanxc_if.tanxc_do
    public com.tanx.exposer.achieve.AdMonitorCommitResult tanxc_do() {
        for (java.lang.String str : this.tanxc_do) {
            java.lang.String tanxc_do2 = com.tanx.exposer.tanxc_if.tanxc_if.tanxc_do(str);
            if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(tanxc_do2)) {
                com.tanx.exposer.tanxc_do.tanxc_try.tanxc_for.tanxc_if(this.tanxc_for, this.tanxc_if, "url_is_empty_or_hash_error");
            } else {
                java.lang.String host = android.net.Uri.parse(str).getHost();
                if (android.text.TextUtils.isEmpty(host)) {
                    com.tanx.exposer.tanxc_do.tanxc_try.tanxc_for.tanxc_if(this.tanxc_for, this.tanxc_if, "domain_not_right");
                } else if (a.contains(tanxc_do2)) {
                    com.tanx.exposer.tanxc_do.tanxc_try.tanxc_for.tanxc_if(this.tanxc_for, this.tanxc_if);
                } else {
                    com.tanx.exposer.tanxc_do.tanxc_new.tanxc_if.tanxc_do(new com.tanx.exposer.achieve.tanxc_if.tanxc_if.AnonymousClass1(str, host, tanxc_do2), 0L);
                }
            }
        }
        return com.tanx.exposer.achieve.AdMonitorCommitResult.COMMITED;
    }
}
