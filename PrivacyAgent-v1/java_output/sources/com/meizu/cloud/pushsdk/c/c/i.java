package com.meizu.cloud.pushsdk.c.c;

/* loaded from: classes23.dex */
public class i {
    private final com.meizu.cloud.pushsdk.c.c.f a;
    private final java.lang.String b;
    private final com.meizu.cloud.pushsdk.c.c.c c;
    private final com.meizu.cloud.pushsdk.c.c.j d;
    private final java.lang.Object e;

    public static class a {
        private com.meizu.cloud.pushsdk.c.c.f a;
        private java.lang.String b = "GET";
        private com.meizu.cloud.pushsdk.c.c.c.a c = new com.meizu.cloud.pushsdk.c.c.c.a();
        private com.meizu.cloud.pushsdk.c.c.j d;
        private java.lang.Object e;

        public com.meizu.cloud.pushsdk.c.c.i.a a() {
            return a("GET", (com.meizu.cloud.pushsdk.c.c.j) null);
        }

        public com.meizu.cloud.pushsdk.c.c.i.a a(com.meizu.cloud.pushsdk.c.c.c cVar) {
            this.c = cVar.c();
            return this;
        }

        public com.meizu.cloud.pushsdk.c.c.i.a a(com.meizu.cloud.pushsdk.c.c.f fVar) {
            if (fVar == null) {
                throw new java.lang.IllegalArgumentException("url == null");
            }
            this.a = fVar;
            return this;
        }

        public com.meizu.cloud.pushsdk.c.c.i.a a(com.meizu.cloud.pushsdk.c.c.j jVar) {
            return a("POST", jVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0045  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public com.meizu.cloud.pushsdk.c.c.i.a a(java.lang.String str) {
            java.lang.StringBuilder sb;
            int i;
            com.meizu.cloud.pushsdk.c.c.f c;
            if (str == null) {
                throw new java.lang.IllegalArgumentException("url == null");
            }
            if (!str.regionMatches(true, 0, "ws:", 0, 3)) {
                if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    sb = new java.lang.StringBuilder();
                    sb.append("https:");
                    i = 4;
                }
                c = com.meizu.cloud.pushsdk.c.c.f.c(str);
                if (c == null) {
                    return a(c);
                }
                throw new java.lang.IllegalArgumentException("unexpected url: " + str);
            }
            sb = new java.lang.StringBuilder();
            sb.append("http:");
            i = 3;
            sb.append(str.substring(i));
            str = sb.toString();
            c = com.meizu.cloud.pushsdk.c.c.f.c(str);
            if (c == null) {
            }
        }

        public com.meizu.cloud.pushsdk.c.c.i.a a(java.lang.String str, com.meizu.cloud.pushsdk.c.c.j jVar) {
            if (str == null || str.length() == 0) {
                throw new java.lang.IllegalArgumentException("method == null || method.length() == 0");
            }
            if (jVar != null && !com.meizu.cloud.pushsdk.c.c.d.b(str)) {
                throw new java.lang.IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (jVar != null || !com.meizu.cloud.pushsdk.c.c.d.a(str)) {
                this.b = str;
                this.d = jVar;
                return this;
            }
            throw new java.lang.IllegalArgumentException("method " + str + " must have a request body.");
        }

        public com.meizu.cloud.pushsdk.c.c.i.a a(java.lang.String str, java.lang.String str2) {
            this.c.a(str, str2);
            return this;
        }

        public com.meizu.cloud.pushsdk.c.c.i.a b() {
            return a("HEAD", (com.meizu.cloud.pushsdk.c.c.j) null);
        }

        public com.meizu.cloud.pushsdk.c.c.i.a b(com.meizu.cloud.pushsdk.c.c.j jVar) {
            return a("DELETE", jVar);
        }

        public com.meizu.cloud.pushsdk.c.c.i.a c(com.meizu.cloud.pushsdk.c.c.j jVar) {
            return a("PUT", jVar);
        }

        public com.meizu.cloud.pushsdk.c.c.i c() {
            if (this.a != null) {
                return new com.meizu.cloud.pushsdk.c.c.i(this, null);
            }
            throw new java.lang.IllegalStateException("url == null");
        }

        public com.meizu.cloud.pushsdk.c.c.i.a d(com.meizu.cloud.pushsdk.c.c.j jVar) {
            return a("PATCH", jVar);
        }
    }

    private i(com.meizu.cloud.pushsdk.c.c.i.a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c.a();
        this.d = aVar.d;
        this.e = aVar.e != null ? aVar.e : this;
    }

    public /* synthetic */ i(com.meizu.cloud.pushsdk.c.c.i.a aVar, com.meizu.cloud.pushsdk.c.c.i.AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    public com.meizu.cloud.pushsdk.c.c.f a() {
        return this.a;
    }

    public java.lang.String a(java.lang.String str) {
        return this.c.a(str);
    }

    public java.lang.String b() {
        return this.b;
    }

    public int c() {
        if ("POST".equals(b())) {
            return 1;
        }
        if ("PUT".equals(b())) {
            return 2;
        }
        if ("DELETE".equals(b())) {
            return 3;
        }
        if ("HEAD".equals(b())) {
            return 4;
        }
        return "PATCH".equals(b()) ? 5 : 0;
    }

    public com.meizu.cloud.pushsdk.c.c.c d() {
        return this.c;
    }

    public com.meizu.cloud.pushsdk.c.c.j e() {
        return this.d;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Request{method=");
        sb.append(this.b);
        sb.append(", url=");
        sb.append(this.a);
        sb.append(", tag=");
        java.lang.Object obj = this.e;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }
}
