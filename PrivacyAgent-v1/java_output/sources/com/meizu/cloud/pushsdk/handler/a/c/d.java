package com.meizu.cloud.pushsdk.handler.a.c;

/* loaded from: classes23.dex */
public class d {
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.String c;
    private java.lang.String d;

    public static class a {
        private java.lang.String a;
        private java.lang.String b;
        private java.lang.String c;
        private java.lang.String d;

        public com.meizu.cloud.pushsdk.handler.a.c.d.a a(java.lang.String str) {
            this.a = str;
            return this;
        }

        public com.meizu.cloud.pushsdk.handler.a.c.d a() {
            return new com.meizu.cloud.pushsdk.handler.a.c.d(this);
        }

        public com.meizu.cloud.pushsdk.handler.a.c.d.a b(java.lang.String str) {
            this.b = str;
            return this;
        }

        public com.meizu.cloud.pushsdk.handler.a.c.d.a c(java.lang.String str) {
            this.c = str;
            return this;
        }

        public com.meizu.cloud.pushsdk.handler.a.c.d.a d(java.lang.String str) {
            this.d = str;
            return this;
        }
    }

    public d() {
    }

    public d(com.meizu.cloud.pushsdk.handler.a.c.d.a aVar) {
        this.a = !android.text.TextUtils.isEmpty(aVar.a) ? aVar.a : "";
        this.b = !android.text.TextUtils.isEmpty(aVar.b) ? aVar.b : "";
        this.c = !android.text.TextUtils.isEmpty(aVar.c) ? aVar.c : "";
        this.d = android.text.TextUtils.isEmpty(aVar.d) ? "" : aVar.d;
    }

    public static com.meizu.cloud.pushsdk.handler.a.c.d.a a() {
        return new com.meizu.cloud.pushsdk.handler.a.c.d.a();
    }

    public java.lang.String b() {
        com.meizu.cloud.pushsdk.d.a.c cVar = new com.meizu.cloud.pushsdk.d.a.c();
        cVar.a("task_id", this.a);
        cVar.a(com.meizu.cloud.pushsdk.constants.PushConstants.SEQ_ID, this.b);
        cVar.a(com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_TIMESTAMP, this.c);
        cVar.a("device_id", this.d);
        return cVar.toString();
    }

    public java.lang.String c() {
        return this.a;
    }

    public java.lang.String d() {
        return this.b;
    }

    public java.lang.String e() {
        return this.c;
    }

    public java.lang.String f() {
        return this.d;
    }
}
