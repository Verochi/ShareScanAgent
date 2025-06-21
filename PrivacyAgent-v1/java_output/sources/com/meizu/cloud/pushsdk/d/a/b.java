package com.meizu.cloud.pushsdk.d.a;

/* loaded from: classes23.dex */
public class b implements com.meizu.cloud.pushsdk.d.a.a {
    private final java.lang.String a = com.meizu.cloud.pushsdk.d.a.b.class.getSimpleName();
    private final java.util.HashMap<java.lang.String, java.lang.Object> b = new java.util.HashMap<>();

    public b(java.lang.String str, java.lang.Object obj) {
        a(str);
        a(obj);
    }

    public com.meizu.cloud.pushsdk.d.a.b a(java.lang.Object obj) {
        if (obj == null) {
            return this;
        }
        this.b.put(com.amap.api.mapcore.util.dt.a, obj);
        return this;
    }

    public com.meizu.cloud.pushsdk.d.a.b a(java.lang.String str) {
        com.meizu.cloud.pushsdk.d.f.d.a(str, "schema cannot be null");
        com.meizu.cloud.pushsdk.d.f.d.a(!str.isEmpty(), "schema cannot be empty.");
        this.b.put("sa", str);
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.d.a.a
    public java.util.Map<java.lang.String, java.lang.Object> a() {
        return this.b;
    }

    @Override // com.meizu.cloud.pushsdk.d.a.a
    @java.lang.Deprecated
    public void a(java.lang.String str, java.lang.String str2) {
        com.meizu.cloud.pushsdk.d.f.c.c(this.a, "Payload: add(String, String) method called - Doing nothing.", new java.lang.Object[0]);
    }

    @Override // com.meizu.cloud.pushsdk.d.a.a
    public long b() {
        return com.meizu.cloud.pushsdk.d.f.e.a(toString());
    }

    public java.lang.String toString() {
        return com.meizu.cloud.pushsdk.d.f.e.a((java.util.Map) this.b).toString();
    }
}
