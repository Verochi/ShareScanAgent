package com.anythink.core.common.h.a;

/* loaded from: classes12.dex */
public final class a extends com.anythink.core.common.h.a.c {
    java.util.List<java.lang.String> a;
    int b;
    boolean c;
    private final java.lang.String k = com.anythink.core.common.h.a.a.class.getSimpleName();

    public a(java.util.List<java.lang.String> list) {
        this.a = list;
        this.b = list.size();
    }

    private java.lang.String j() {
        org.json.JSONObject h = super.h();
        org.json.JSONObject i = super.i();
        if (h != null) {
            try {
                h.put("app_id", com.anythink.core.common.b.o.a().o());
                h.put("nw_ver", com.anythink.core.common.o.e.h());
                org.json.JSONArray jSONArray = new org.json.JSONArray();
                java.util.List<java.lang.String> list = this.a;
                if (list != null && list.size() > 0) {
                    for (java.lang.String str : this.a) {
                        if (!android.text.TextUtils.isEmpty(str)) {
                            jSONArray.put(new org.json.JSONObject(str));
                        }
                    }
                }
                h.put("data", jSONArray);
            } catch (java.lang.Exception unused) {
            }
        }
        if (i != null) {
            try {
                i.put(com.anythink.core.common.h.c.T, this.i);
                i.put(com.anythink.core.common.h.c.V, this.j);
            } catch (java.lang.Exception unused2) {
            }
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        java.lang.String a = com.anythink.core.common.o.d.a(h.toString());
        java.lang.String a2 = com.anythink.core.common.o.d.a(i.toString());
        hashMap.put(com.anythink.core.common.h.c.O, "1.0");
        hashMap.put("p", a);
        hashMap.put(com.anythink.core.common.h.c.X, a2);
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList(hashMap.size());
        arrayList.addAll(hashMap.keySet());
        java.util.Collections.sort(arrayList);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.String str2 : arrayList) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(str2);
            sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(hashMap.get(str2));
        }
        hashMap.put("sign", com.anythink.core.common.o.g.c(com.anythink.core.common.b.o.a().p() + sb.toString()));
        return new org.json.JSONObject(hashMap).toString();
    }

    public final void a() {
        this.c = true;
    }

    @Override // com.anythink.core.common.h.a.c
    public final void a(java.lang.String str, java.lang.String str2, java.lang.String str3, int i) {
        if (this.c) {
            com.anythink.core.common.t.a().a(3, "", "", j(), com.anythink.core.common.f.u.a(1001));
        }
    }

    public final int b() {
        return this.b;
    }

    @Override // com.anythink.core.common.h.a.c
    public final int c() {
        return 2;
    }

    @Override // com.anythink.core.common.h.a.c
    public final int d() {
        return 3;
    }

    @Override // com.anythink.core.common.h.a.c
    public final byte[] e() {
        return com.anythink.core.common.h.a.c.a(j());
    }

    @Override // com.anythink.core.common.h.a.c
    public final boolean f() {
        return false;
    }

    @Override // com.anythink.core.common.h.a.c
    public final int g() {
        return 4;
    }
}
