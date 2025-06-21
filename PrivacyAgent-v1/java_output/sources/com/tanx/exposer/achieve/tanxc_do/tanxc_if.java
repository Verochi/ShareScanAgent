package com.tanx.exposer.achieve.tanxc_do;

/* loaded from: classes19.dex */
public class tanxc_if implements com.tanx.exposer.achieve.tanxc_do.tanxc_do {
    public com.tanx.exposer.achieve.tanxc_do.tanxc_do a;
    public android.os.Handler b;

    /* renamed from: com.tanx.exposer.achieve.tanxc_do.tanxc_if$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public final /* synthetic */ java.lang.String n;
        public final /* synthetic */ com.tanx.exposer.achieve.AdMonitorType t;
        public final /* synthetic */ com.tanx.exposer.tanxc_if u;

        public AnonymousClass1(java.lang.String str, com.tanx.exposer.achieve.AdMonitorType adMonitorType, com.tanx.exposer.tanxc_if tanxc_ifVar) {
            this.n = str;
            this.t = adMonitorType;
            this.u = tanxc_ifVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.tanx.exposer.achieve.tanxc_do.tanxc_if.this.a != null) {
                com.tanx.exposer.achieve.tanxc_do.tanxc_if.this.a.tanxc_do(this.n, this.t, this.u);
            }
        }
    }

    /* renamed from: com.tanx.exposer.achieve.tanxc_do.tanxc_if$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public final /* synthetic */ int n;
        public final /* synthetic */ java.lang.String t;
        public final /* synthetic */ java.lang.String u;
        public final /* synthetic */ com.tanx.exposer.achieve.AdMonitorType v;
        public final /* synthetic */ com.tanx.exposer.tanxc_if w;

        public AnonymousClass2(int i, java.lang.String str, java.lang.String str2, com.tanx.exposer.achieve.AdMonitorType adMonitorType, com.tanx.exposer.tanxc_if tanxc_ifVar) {
            this.n = i;
            this.t = str;
            this.u = str2;
            this.v = adMonitorType;
            this.w = tanxc_ifVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.tanx.exposer.achieve.tanxc_do.tanxc_if.this.a != null) {
                com.tanx.exposer.achieve.tanxc_do.tanxc_if.this.a.tanxc_do(this.n, this.t, this.u, this.v, this.w);
            }
        }
    }

    /* renamed from: com.tanx.exposer.achieve.tanxc_do.tanxc_if$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public final /* synthetic */ int n;
        public final /* synthetic */ java.lang.String t;
        public final /* synthetic */ java.lang.String u;
        public final /* synthetic */ com.tanx.exposer.achieve.AdMonitorType v;
        public final /* synthetic */ com.tanx.exposer.tanxc_if w;

        public AnonymousClass3(int i, java.lang.String str, java.lang.String str2, com.tanx.exposer.achieve.AdMonitorType adMonitorType, com.tanx.exposer.tanxc_if tanxc_ifVar) {
            this.n = i;
            this.t = str;
            this.u = str2;
            this.v = adMonitorType;
            this.w = tanxc_ifVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.tanx.exposer.achieve.tanxc_do.tanxc_if.this.a != null) {
                com.tanx.exposer.achieve.tanxc_do.tanxc_if.this.a.tanxc_if(this.n, this.t, this.u, this.v, this.w);
            }
        }
    }

    public final synchronized android.os.Handler b() {
        if (this.b == null) {
            this.b = new android.os.Handler(tanxc_do());
        }
        return this.b;
    }

    @Override // com.tanx.exposer.achieve.tanxc_do.tanxc_do
    public android.os.Looper tanxc_do() {
        com.tanx.exposer.achieve.tanxc_do.tanxc_do tanxc_doVar = this.a;
        return (tanxc_doVar == null || tanxc_doVar.tanxc_do() == null) ? android.os.Looper.myLooper() : this.a.tanxc_do();
    }

    @Override // com.tanx.exposer.achieve.tanxc_do.tanxc_do
    public void tanxc_do(int i, java.lang.String str, java.lang.String str2, com.tanx.exposer.achieve.AdMonitorType adMonitorType, com.tanx.exposer.tanxc_if tanxc_ifVar) {
        if (this.a != null) {
            b().post(new com.tanx.exposer.achieve.tanxc_do.tanxc_if.AnonymousClass2(i, str, str2, adMonitorType, tanxc_ifVar));
        }
    }

    public void tanxc_do(com.tanx.exposer.achieve.tanxc_do.tanxc_do tanxc_doVar) {
        this.a = tanxc_doVar;
    }

    @Override // com.tanx.exposer.achieve.tanxc_do.tanxc_do
    public void tanxc_do(java.lang.String str, com.tanx.exposer.achieve.AdMonitorType adMonitorType, com.tanx.exposer.tanxc_if tanxc_ifVar) {
        if (this.a != null) {
            b().post(new com.tanx.exposer.achieve.tanxc_do.tanxc_if.AnonymousClass1(str, adMonitorType, tanxc_ifVar));
        }
    }

    @Override // com.tanx.exposer.achieve.tanxc_do.tanxc_do
    public void tanxc_if(int i, java.lang.String str, java.lang.String str2, com.tanx.exposer.achieve.AdMonitorType adMonitorType, com.tanx.exposer.tanxc_if tanxc_ifVar) {
        if (this.a != null) {
            b().post(new com.tanx.exposer.achieve.tanxc_do.tanxc_if.AnonymousClass3(i, str, str2, adMonitorType, tanxc_ifVar));
        }
    }
}
