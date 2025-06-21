package com.tanx.exposer.tanxc_do.tanxc_int;

/* loaded from: classes19.dex */
public class tanxc_int {
    public java.lang.String a;
    public int b;
    public int c;
    public int d;
    public java.util.Map<java.lang.String, java.lang.String> e;

    public static class tanxc_do {
        public java.lang.String a;
        public int b = 3;
        public int c;
        public int d;
        public java.util.Map<java.lang.String, java.lang.String> e;

        public tanxc_do(java.lang.String str) {
            this.a = str;
        }

        public com.tanx.exposer.tanxc_do.tanxc_int.tanxc_int.tanxc_do tanxc_do(int i) {
            this.b = i;
            return this;
        }

        public com.tanx.exposer.tanxc_do.tanxc_int.tanxc_int.tanxc_do tanxc_do(java.lang.String str, java.lang.String str2) {
            if (this.e == null) {
                this.e = new java.util.HashMap(16);
            }
            this.e.put(str, str2);
            return this;
        }

        public com.tanx.exposer.tanxc_do.tanxc_int.tanxc_int tanxc_do() {
            return new com.tanx.exposer.tanxc_do.tanxc_int.tanxc_int(this);
        }

        public com.tanx.exposer.tanxc_do.tanxc_int.tanxc_int.tanxc_do tanxc_for(int i) {
            this.d = i;
            return this;
        }

        public com.tanx.exposer.tanxc_do.tanxc_int.tanxc_int.tanxc_do tanxc_if(int i) {
            this.c = i;
            return this;
        }
    }

    public tanxc_int(com.tanx.exposer.tanxc_do.tanxc_int.tanxc_int.tanxc_do tanxc_doVar) {
        this.a = tanxc_doVar.a;
        this.b = tanxc_doVar.b;
        this.c = tanxc_doVar.c;
        this.d = tanxc_doVar.d;
        this.e = tanxc_doVar.e;
    }

    public java.lang.String tanxc_do() {
        return this.a;
    }

    public int tanxc_if() {
        return this.b;
    }
}
