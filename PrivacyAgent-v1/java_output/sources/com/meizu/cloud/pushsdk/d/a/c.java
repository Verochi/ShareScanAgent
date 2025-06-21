package com.meizu.cloud.pushsdk.d.a;

/* loaded from: classes23.dex */
public class c implements com.meizu.cloud.pushsdk.d.a.a {
    private final java.lang.String a = com.meizu.cloud.pushsdk.d.a.c.class.getSimpleName();
    private final java.util.HashMap<java.lang.String, java.lang.Object> b = new java.util.HashMap<>();

    @Override // com.meizu.cloud.pushsdk.d.a.a
    public java.util.Map a() {
        return this.b;
    }

    public void a(java.lang.String str, java.lang.Object obj) {
        if (obj != null) {
            this.b.put(str, obj);
            return;
        }
        com.meizu.cloud.pushsdk.d.f.c.c(this.a, "The keys value is empty, returning without adding key: " + str, new java.lang.Object[0]);
    }

    @Override // com.meizu.cloud.pushsdk.d.a.a
    public void a(java.lang.String str, java.lang.String str2) {
        if (str2 != null && !str2.isEmpty()) {
            this.b.put(str, str2);
            return;
        }
        com.meizu.cloud.pushsdk.d.f.c.c(this.a, "The keys value is empty, returning without adding key: " + str, new java.lang.Object[0]);
    }

    public void a(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (map == null) {
            com.meizu.cloud.pushsdk.d.f.c.c(this.a, "Map passed in is null, returning without adding map.", new java.lang.Object[0]);
        } else {
            this.b.putAll(map);
        }
    }

    @Override // com.meizu.cloud.pushsdk.d.a.a
    public long b() {
        return com.meizu.cloud.pushsdk.d.f.e.a(toString());
    }

    public java.lang.String toString() {
        return com.meizu.cloud.pushsdk.d.f.e.a((java.util.Map) this.b).toString();
    }
}
