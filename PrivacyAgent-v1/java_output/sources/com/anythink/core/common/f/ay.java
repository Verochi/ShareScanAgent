package com.anythink.core.common.f;

/* loaded from: classes12.dex */
public final class ay {
    static final java.lang.String e = "reqId";
    static final java.lang.String f = "reqDatetime";
    static final java.lang.String g = "fillOffers";
    static final java.lang.String h = "bidResps";
    static final java.lang.String i = "adSourceId";
    static final java.lang.String j = "price";
    static final java.lang.String k = "networkFirmId";
    static final java.lang.String l = "demandType";
    static final java.lang.String m = "tp_bid_id";
    java.lang.String a;
    long b;
    java.util.List<com.anythink.core.common.f.ay.a> c = new java.util.ArrayList(3);
    java.util.List<com.anythink.core.common.f.ay.a> d = new java.util.ArrayList(3);

    /* renamed from: com.anythink.core.common.f.ay$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.Comparator<com.anythink.core.common.f.ay.a> {
        public AnonymousClass1() {
        }

        private static int a(com.anythink.core.common.f.ay.a aVar, com.anythink.core.common.f.ay.a aVar2) {
            double d = aVar.d;
            double d2 = aVar2.d;
            if (d > d2) {
                return -1;
            }
            return d == d2 ? 0 : 1;
        }

        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(com.anythink.core.common.f.ay.a aVar, com.anythink.core.common.f.ay.a aVar2) {
            double d = aVar.d;
            double d2 = aVar2.d;
            if (d > d2) {
                return -1;
            }
            return d == d2 ? 0 : 1;
        }
    }

    public static class a {
        public int a;
        public java.lang.String b;
        public int c;
        public double d;
        public java.lang.String e;

        public a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
        
            if (r0 != 8) goto L23;
         */
        /* JADX WARN: Removed duplicated region for block: B:18:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0052  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public a(com.anythink.core.common.f.au auVar, com.anythink.core.common.f.q qVar) {
            this.b = auVar.u();
            if (qVar != null) {
                this.d = qVar.getPrice();
            } else {
                this.d = auVar.y();
            }
            this.c = auVar.d();
            int m = auVar.m();
            if (m != 0) {
                if (m != 1) {
                    if (m == 2) {
                        this.a = 3;
                    } else if (m == 3) {
                        this.a = 4;
                    } else if (m != 4 && m != 7) {
                    }
                    if (35 == auVar.d()) {
                        this.a = 2;
                    }
                    this.e = qVar != null ? qVar.g : "";
                }
                this.a = 2;
                if (35 == auVar.d()) {
                }
                this.e = qVar != null ? qVar.g : "";
            }
            this.a = 1;
            if (35 == auVar.d()) {
            }
            this.e = qVar != null ? qVar.g : "";
        }

        public final synchronized org.json.JSONObject a() {
            org.json.JSONObject jSONObject;
            jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put(com.anythink.core.common.f.ay.i, this.b);
                jSONObject.put("price", this.d);
                jSONObject.put(com.anythink.core.common.f.ay.k, this.c);
                jSONObject.put(com.anythink.core.common.f.ay.l, this.a);
                jSONObject.put(com.anythink.core.common.f.ay.m, this.e);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            return jSONObject;
        }
    }

    public static com.anythink.core.common.f.ay a(java.lang.String str) {
        com.anythink.core.common.f.ay ayVar = new com.anythink.core.common.f.ay();
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            ayVar.b(jSONObject.getString(e));
            ayVar.a(jSONObject.getLong(f));
            ayVar.a(ayVar.c(jSONObject.getString(g)));
            ayVar.b(ayVar.c(jSONObject.getString(h)));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return ayVar;
    }

    private synchronized void a(java.util.List<com.anythink.core.common.f.ay.a> list) {
        this.c = list;
    }

    private synchronized void a(java.util.List<com.anythink.core.common.f.ay.a> list, com.anythink.core.common.f.ay.a aVar) {
        if (aVar != null) {
            if (list.size() == 0) {
                list.add(aVar);
                return;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= list.size()) {
                    i2 = -1;
                    break;
                } else if (aVar.d > list.get(i2).d) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 != -1) {
                list.add(i2, aVar);
                return;
            }
            list.add(aVar);
        }
    }

    private synchronized void b(java.util.List<com.anythink.core.common.f.ay.a> list) {
        this.d = list;
    }

    private synchronized long c() {
        return this.b;
    }

    private synchronized java.util.List<com.anythink.core.common.f.ay.a> c(java.lang.String str) {
        java.util.ArrayList arrayList;
        arrayList = new java.util.ArrayList();
        try {
            if (!android.text.TextUtils.isEmpty(str)) {
                org.json.JSONArray jSONArray = new org.json.JSONArray(str);
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    com.anythink.core.common.f.ay.a aVar = new com.anythink.core.common.f.ay.a();
                    org.json.JSONObject jSONObject = new org.json.JSONObject(jSONArray.optString(i2));
                    aVar.b = jSONObject.getString(i);
                    aVar.d = jSONObject.getDouble("price");
                    aVar.c = jSONObject.getInt(k);
                    aVar.a = jSONObject.getInt(l);
                    if (jSONObject.has(m)) {
                        aVar.e = jSONObject.getString(m);
                    }
                    arrayList.add(aVar);
                }
                java.util.Collections.sort(arrayList, new com.anythink.core.common.f.ay.AnonymousClass1());
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return arrayList;
    }

    private synchronized org.json.JSONArray c(java.util.List<com.anythink.core.common.f.ay.a> list) {
        org.json.JSONArray jSONArray;
        jSONArray = new org.json.JSONArray();
        if (list != null) {
            java.util.Iterator<com.anythink.core.common.f.ay.a> it = list.iterator();
            while (it.hasNext()) {
                try {
                    jSONArray.put(it.next().a());
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        return jSONArray;
    }

    private synchronized org.json.JSONArray d() {
        return c(this.c);
    }

    private synchronized org.json.JSONArray e() {
        return c(this.d);
    }

    public final synchronized org.json.JSONObject a() {
        org.json.JSONObject jSONObject;
        jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put(e, this.a);
            jSONObject.put(f, this.b);
            jSONObject.put(g, d());
            jSONObject.put(h, e());
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public final synchronized void a(long j2) {
        this.b = j2;
    }

    public final synchronized void a(com.anythink.core.common.f.ay.a aVar) {
        a(this.c, aVar);
    }

    public final synchronized java.lang.String b() {
        return this.a;
    }

    public final synchronized void b(com.anythink.core.common.f.ay.a aVar) {
        a(this.d, aVar);
    }

    public final synchronized void b(java.lang.String str) {
        this.a = str;
    }
}
