package com.anythink.core.common.f;

/* loaded from: classes12.dex */
public class a {
    public static final java.lang.String a = "a";
    public android.content.Context b;
    public com.anythink.core.common.f.v c;
    public java.lang.String d;
    public java.lang.String e;
    public int f;
    public long g;
    public long h;
    public long i;
    public java.util.List<com.anythink.core.common.f.au> j;
    public java.util.List<com.anythink.core.common.f.au> k;
    public java.lang.String l;
    public boolean m;
    public com.anythink.core.common.f.az n;
    public java.lang.String o;
    public java.lang.String p;
    public java.util.Map<java.lang.String, java.lang.Object> q;
    public org.json.JSONObject r;

    /* renamed from: s, reason: collision with root package name */
    public com.anythink.core.common.f.h f167s;
    public double u;
    public com.anythink.core.common.f.ay v;
    public com.anythink.core.common.f.ap w;
    public com.anythink.core.common.f.p x;
    public com.anythink.core.common.p.h y;
    public int t = 2;
    public int z = 0;

    private com.anythink.core.common.f.a d(java.util.List<com.anythink.core.common.f.au> list) {
        com.anythink.core.common.f.a aVar = new com.anythink.core.common.f.a();
        aVar.b = this.b;
        aVar.d = this.d;
        aVar.e = this.e;
        aVar.f = this.f;
        aVar.h = this.h;
        aVar.n = this.n;
        long j = this.g;
        if (j < 0) {
            aVar.g = 10000L;
        } else {
            aVar.g = j;
        }
        aVar.m = this.m;
        aVar.o = this.o;
        aVar.p = this.p;
        aVar.j = list;
        aVar.q = this.q;
        aVar.i = this.i;
        aVar.c = this.c;
        aVar.f167s = this.f167s;
        aVar.t = this.t;
        aVar.u = this.u;
        aVar.z = this.z;
        aVar.y = this.y;
        aVar.x = this.x;
        return aVar;
    }

    public final com.anythink.core.common.f.a a(java.util.List<com.anythink.core.common.f.au> list) {
        return d(list);
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0091, code lost:
    
        if (r5.equals("2") != false) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ca A[Catch: all -> 0x013f, TryCatch #0 {all -> 0x013f, blocks: (B:16:0x006d, B:25:0x009d, B:26:0x00c0, B:28:0x00ca, B:29:0x00cd, B:31:0x00dd, B:32:0x00eb, B:34:0x00f1, B:36:0x00fd, B:37:0x0108, B:40:0x010e, B:45:0x011a, B:47:0x0120, B:48:0x0125, B:50:0x012b, B:51:0x0130, B:54:0x00a1, B:56:0x00bd, B:57:0x0081, B:60:0x008b), top: B:15:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00dd A[Catch: all -> 0x013f, TryCatch #0 {all -> 0x013f, blocks: (B:16:0x006d, B:25:0x009d, B:26:0x00c0, B:28:0x00ca, B:29:0x00cd, B:31:0x00dd, B:32:0x00eb, B:34:0x00f1, B:36:0x00fd, B:37:0x0108, B:40:0x010e, B:45:0x011a, B:47:0x0120, B:48:0x0125, B:50:0x012b, B:51:0x0130, B:54:0x00a1, B:56:0x00bd, B:57:0x0081, B:60:0x008b), top: B:15:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a1 A[Catch: all -> 0x013f, TryCatch #0 {all -> 0x013f, blocks: (B:16:0x006d, B:25:0x009d, B:26:0x00c0, B:28:0x00ca, B:29:0x00cd, B:31:0x00dd, B:32:0x00eb, B:34:0x00f1, B:36:0x00fd, B:37:0x0108, B:40:0x010e, B:45:0x011a, B:47:0x0120, B:48:0x0125, B:50:0x012b, B:51:0x0130, B:54:0x00a1, B:56:0x00bd, B:57:0x0081, B:60:0x008b), top: B:15:0x006d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.anythink.core.common.f.a a(java.util.List<com.anythink.core.common.f.au> list, java.util.List<com.anythink.core.common.f.au> list2) {
        java.lang.String valueOf;
        int hashCode;
        java.util.List<com.anythink.core.common.f.ae> a2;
        com.anythink.core.common.f.a d = d(list);
        d.l = this.l;
        if (list2.size() > 0) {
            java.util.Collections.sort(list2);
            java.util.List<com.anythink.core.common.f.au> a3 = com.anythink.core.common.o.h.a(list2, (com.anythink.core.common.g.d) null);
            d.k = a3;
            char c = 0;
            com.anythink.core.common.f.au auVar = a3.get(0);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            for (com.anythink.core.common.f.au auVar2 : a3) {
                if (auVar2.m() == 7) {
                    arrayList.add(java.lang.Integer.valueOf(java.lang.Integer.parseInt(auVar2.u())));
                    arrayList2.add(auVar2.u());
                }
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            com.anythink.core.api.ATBidRequestInfo.fillBaseCommonParams(jSONObject, java.lang.String.valueOf(d.f), this.n.a(), auVar);
            try {
                valueOf = java.lang.String.valueOf(d.f);
                hashCode = valueOf.hashCode();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            if (hashCode != 50) {
                if (hashCode == 52 && valueOf.equals("4")) {
                    c = 1;
                    if (c != 0) {
                        java.lang.String obj = d.n.a().a(d.e, d.d, auVar).get(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE).toString();
                        if (!android.text.TextUtils.isEmpty(obj)) {
                            jSONObject.put(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, obj);
                        }
                    } else if (c == 1) {
                        jSONObject.put(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.GET_OFFER, 2);
                    }
                    if (d.z == d.k.size()) {
                        jSONObject.put(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.GET_OFFER, 2);
                    }
                    a2 = com.anythink.core.common.d.c.a(d.b).a(arrayList2);
                    if (a2.size() > 0) {
                        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                        org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                        for (com.anythink.core.common.f.ae aeVar : a2) {
                            if (aeVar.d() > 0) {
                                jSONObject2.put(aeVar.a(), aeVar.d());
                            }
                            if (aeVar.c() > 0) {
                                jSONObject3.put(aeVar.a(), aeVar.c());
                            }
                        }
                        if (jSONObject2.length() > 0) {
                            jSONObject.put(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.DIRECTLY_DA_OFFER_CLICK, jSONObject2);
                        }
                        if (jSONObject3.length() > 0) {
                            jSONObject.put(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.DIRECTLY_DA_OFFER_IMPRESSION, jSONObject3);
                        }
                    }
                    jSONObject.put("unit_ids", new org.json.JSONArray(arrayList.toString()));
                    d.r = jSONObject;
                }
                c = 65535;
                if (c != 0) {
                }
                if (d.z == d.k.size()) {
                }
                a2 = com.anythink.core.common.d.c.a(d.b).a(arrayList2);
                if (a2.size() > 0) {
                }
                jSONObject.put("unit_ids", new org.json.JSONArray(arrayList.toString()));
                d.r = jSONObject;
            }
            th.printStackTrace();
            d.r = jSONObject;
        }
        d.v = this.v;
        d.w = this.w;
        return d;
    }

    public final com.anythink.core.common.f.a b(java.util.List<com.anythink.core.common.f.au> list) {
        com.anythink.core.common.f.a d = d(list);
        d.o = this.o;
        d.h = this.h;
        return d;
    }

    public final com.anythink.core.common.f.a c(java.util.List<com.anythink.core.common.f.au> list) {
        com.anythink.core.common.f.a d = d(list);
        d.p = this.p;
        return d;
    }
}
