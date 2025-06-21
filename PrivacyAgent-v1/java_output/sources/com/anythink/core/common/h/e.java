package com.anythink.core.common.h;

/* loaded from: classes12.dex */
public final class e extends com.anythink.core.common.h.a {
    @Override // com.anythink.core.common.h.a
    public final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.Object a(java.lang.Object obj) {
        return obj;
    }

    @Override // com.anythink.core.common.h.a
    public final void a(com.anythink.core.api.AdError adError) {
    }

    @Override // com.anythink.core.common.h.a
    public final boolean a(int i) {
        return false;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String b() {
        com.anythink.core.common.h.a();
        return com.anythink.core.common.h.e();
    }

    @Override // com.anythink.core.common.h.a
    public final void b(com.anythink.core.api.AdError adError) {
    }

    @Override // com.anythink.core.common.h.a
    public final java.util.Map<java.lang.String, java.lang.String> c() {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("Content-Encoding", "gzip");
        hashMap.put("Content-Type", "application/json;charset=utf-8");
        return hashMap;
    }

    @Override // com.anythink.core.common.h.a
    public final byte[] d() {
        try {
            return g().getBytes("utf-8");
        } catch (java.lang.Exception unused) {
            return g().getBytes();
        }
    }

    @Override // com.anythink.core.common.h.a
    public final org.json.JSONObject e() {
        org.json.JSONObject e = super.e();
        try {
            e.put("app_id", com.anythink.core.common.b.o.a().o());
            e.put("curr_ts", java.lang.System.currentTimeMillis());
        } catch (java.lang.Exception unused) {
        }
        return e;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String g() {
        java.util.HashMap hashMap = new java.util.HashMap();
        java.lang.String a = com.anythink.core.common.o.d.a(e().toString());
        hashMap.put(com.anythink.core.common.h.c.O, "1.0");
        hashMap.put("p", a);
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList(hashMap.size());
        arrayList.addAll(hashMap.keySet());
        java.util.Collections.sort(arrayList);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.String str : arrayList) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(str);
            sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(hashMap.get(str));
        }
        try {
            hashMap.put("sign", java.net.URLEncoder.encode(com.anythink.core.common.o.g.c(com.anythink.core.common.b.o.a().p() + sb.toString()), "utf-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new org.json.JSONObject(hashMap).toString();
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String h() {
        return com.anythink.core.common.b.o.a().o();
    }

    @Override // com.anythink.core.common.h.a
    public final android.content.Context i() {
        return null;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String j() {
        return com.anythink.core.common.b.o.a().p();
    }

    @Override // com.anythink.core.common.h.a
    public final java.util.Map<java.lang.String, java.lang.Object> k() {
        return null;
    }

    @Override // com.anythink.core.common.h.a
    public final boolean n() {
        return true;
    }
}
