package com.anythink.basead.g;

/* loaded from: classes12.dex */
public final class b extends com.anythink.core.common.h.a {
    java.lang.String a;
    org.json.JSONObject b;

    public b(int i, com.anythink.core.common.f.z zVar, java.lang.String str) {
        java.lang.String str2 = "";
        try {
            switch (i) {
                case 1:
                    str2 = zVar.X();
                    break;
                case 2:
                    str2 = zVar.Y();
                    break;
                case 3:
                    str2 = zVar.Z();
                    break;
                case 4:
                    str2 = zVar.aa();
                    break;
                case 5:
                    str2 = zVar.ab();
                    break;
                case 6:
                    str2 = zVar.ac();
                    break;
                case 7:
                    str2 = zVar.ad();
                    break;
                case 8:
                    str2 = zVar.ae();
                    break;
                case 9:
                    str2 = zVar.af();
                    break;
            }
            android.net.Uri parse = android.net.Uri.parse(zVar.S(str2));
            this.a = parse.getScheme() + "://" + parse.getAuthority() + parse.getPath();
            this.b = new org.json.JSONObject();
            for (java.lang.String str3 : parse.getQueryParameterNames()) {
                this.b.put(str3, java.net.URLEncoder.encode(parse.getQueryParameter(str3)));
            }
            this.b.put(com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.reqId, str);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.anythink.core.common.h.a
    public final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.Object a(java.lang.Object obj) {
        return null;
    }

    @Override // com.anythink.core.common.h.a
    public final void a(com.anythink.core.api.AdError adError) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        java.util.Map<java.lang.String, java.lang.String> c = c();
        if (c != null) {
            try {
                for (java.lang.String str : c.keySet()) {
                    jSONObject.put(str, c.get(str));
                }
            } catch (java.lang.Exception unused) {
            }
        }
        java.lang.String jSONObject2 = jSONObject.toString();
        org.json.JSONObject jSONObject3 = this.b;
        java.lang.String jSONObject4 = jSONObject3 != null ? jSONObject3.toString() : "";
        com.anythink.core.common.t.a().a(1, b(), jSONObject2, jSONObject4, com.anythink.core.common.f.u.a(1000));
        com.anythink.core.common.n.c.a("tk", adError.getPlatformCode(), adError.getPlatformMSG(), this.a, "", "1", "");
    }

    public final void a(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            this.b.put("scenario", str);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.anythink.core.common.h.a
    public final boolean a(int i) {
        return false;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String b() {
        return this.a;
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
        org.json.JSONObject jSONObject = this.b;
        if (jSONObject == null) {
            return new byte[0];
        }
        try {
            jSONObject.put("t", java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
        } catch (java.lang.Exception unused) {
        }
        return com.anythink.core.common.h.a.b(this.b.toString());
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String g() {
        return "";
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String h() {
        return null;
    }

    @Override // com.anythink.core.common.h.a
    public final android.content.Context i() {
        return null;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String j() {
        return null;
    }

    @Override // com.anythink.core.common.h.a
    public final java.util.Map<java.lang.String, java.lang.Object> k() {
        return null;
    }
}
