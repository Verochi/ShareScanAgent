package com.tanx.exposer;

/* loaded from: classes19.dex */
public final class tanxc_do {
    public final int a;
    public final boolean b;
    public final boolean c;
    public final int d;
    public final java.util.List<com.tanx.exposer.achieve.AdMonitorType> e;
    public final com.tanx.exposer.tanxc_do.tanxc_int.tanxc_for f;
    public final com.tanx.exposer.tanxc_do.tanxc_try.tanxc_int g;
    public final com.tanx.exposer.tanxc_do.tanxc_do.tanxc_do h;
    public boolean i;
    public final java.lang.String j;
    public final java.lang.String k;

    /* renamed from: com.tanx.exposer.tanxc_do$tanxc_do, reason: collision with other inner class name */
    public static class C0492tanxc_do {
        public final com.tanx.exposer.tanxc_do.tanxc_int.tanxc_do f;
        public final com.tanx.exposer.tanxc_do.tanxc_try.tanxc_do g;
        public com.tanx.exposer.tanxc_do.tanxc_do.tanxc_do h;
        public java.lang.String j;
        public java.lang.String k;
        public boolean l;
        public int a = com.tanx.exposer.tanxc_do.tanxc_try.tanxc_for.tanxc_do();
        public boolean b = true;
        public boolean c = true;
        public int d = 5;
        public java.util.List<com.tanx.exposer.achieve.AdMonitorType> e = java.util.Arrays.asList(com.tanx.exposer.achieve.AdMonitorType.CLICK, com.tanx.exposer.achieve.AdMonitorType.EXPOSE, com.tanx.exposer.achieve.AdMonitorType.INTERACT, com.tanx.exposer.achieve.AdMonitorType.INTERACT_DEDUPLICATION);
        public boolean i = false;

        public C0492tanxc_do(com.tanx.exposer.tanxc_do.tanxc_int.tanxc_do tanxc_doVar, com.tanx.exposer.tanxc_do.tanxc_try.tanxc_do tanxc_doVar2) {
            this.f = tanxc_doVar;
            this.g = tanxc_doVar2;
        }

        public com.tanx.exposer.tanxc_do.C0492tanxc_do tanxc_do(int i) {
            this.a = i;
            return this;
        }

        public com.tanx.exposer.tanxc_do.C0492tanxc_do tanxc_do(java.lang.String str, java.lang.String str2) {
            this.j = str;
            this.k = str2;
            return this;
        }

        public com.tanx.exposer.tanxc_do.C0492tanxc_do tanxc_do(boolean z) {
            this.b = z;
            return this;
        }

        public com.tanx.exposer.tanxc_do tanxc_do() {
            return new com.tanx.exposer.tanxc_do(this);
        }

        public com.tanx.exposer.tanxc_do.C0492tanxc_do tanxc_for(boolean z) {
            this.l = z;
            return this;
        }

        public com.tanx.exposer.tanxc_do.C0492tanxc_do tanxc_if(boolean z) {
            this.c = z;
            return this;
        }
    }

    public tanxc_do(com.tanx.exposer.tanxc_do.C0492tanxc_do c0492tanxc_do) {
        int i = c0492tanxc_do.a;
        this.a = i;
        this.b = c0492tanxc_do.b;
        this.c = c0492tanxc_do.c;
        this.d = c0492tanxc_do.d;
        this.e = c0492tanxc_do.e;
        this.f = new com.tanx.exposer.tanxc_do.tanxc_int.tanxc_for(c0492tanxc_do.f);
        this.g = new com.tanx.exposer.tanxc_do.tanxc_try.tanxc_int(c0492tanxc_do.g);
        this.h = c0492tanxc_do.h;
        this.i = c0492tanxc_do.i;
        this.j = c0492tanxc_do.j;
        this.k = c0492tanxc_do.k;
        com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do(c0492tanxc_do.l);
        com.tanx.exposer.tanxc_do.tanxc_try.tanxc_for.tanxc_do(i);
    }

    public java.util.List<com.tanx.exposer.achieve.AdMonitorType> tanxc_byte() {
        return this.e;
    }

    public boolean tanxc_case() {
        return this.i;
    }

    public java.lang.String tanxc_char() {
        return this.j;
    }

    public boolean tanxc_do() {
        return this.b;
    }

    public java.lang.String tanxc_else() {
        return this.k;
    }

    public int tanxc_for() {
        return this.d;
    }

    public boolean tanxc_if() {
        return this.c;
    }

    public com.tanx.exposer.tanxc_do.tanxc_int.tanxc_do tanxc_int() {
        return this.f;
    }

    public com.tanx.exposer.tanxc_do.tanxc_try.tanxc_int tanxc_new() {
        return this.g;
    }

    public com.tanx.exposer.tanxc_do.tanxc_do.tanxc_do tanxc_try() {
        return this.h;
    }
}
