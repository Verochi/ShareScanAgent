package com.anythink.core.c;

/* loaded from: classes12.dex */
public final class a {
    private static volatile com.anythink.core.c.a e;
    final java.lang.String a = com.anythink.core.c.a.class.getSimpleName();
    private final java.lang.String b = "sv_request_id";
    private final java.lang.String c = "sv_price";
    private java.util.Map<java.lang.String, java.util.LinkedList<com.anythink.core.c.a.C0162a>> d = new java.util.HashMap();

    /* renamed from: com.anythink.core.c.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.util.LinkedList b;

        public AnonymousClass1(java.lang.String str, java.util.LinkedList linkedList) {
            this.a = str;
            this.b = linkedList;
        }

        @Override // java.lang.Runnable
        public final void run() {
            java.lang.String str;
            if (android.text.TextUtils.isEmpty(this.a) || this.b == null) {
                return;
            }
            try {
                org.json.JSONArray jSONArray = new org.json.JSONArray();
                java.util.Iterator it = this.b.iterator();
                while (it.hasNext()) {
                    com.anythink.core.c.a.C0162a c0162a = (com.anythink.core.c.a.C0162a) it.next();
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    jSONObject.put("sv_request_id", c0162a.a);
                    jSONObject.put("sv_price", c0162a.b);
                    jSONArray.put(jSONObject);
                }
                str = jSONArray.toString();
            } catch (java.lang.Throwable unused) {
                str = "";
            }
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            com.anythink.core.common.o.r.a(com.anythink.core.common.b.o.a().f(), com.anythink.core.common.b.h.M, this.a, str);
        }
    }

    /* renamed from: com.anythink.core.c.a$a, reason: collision with other inner class name */
    public class C0162a {
        public java.lang.String a;
        public double b;

        public C0162a(java.lang.String str, double d) {
            this.a = str;
            this.b = d;
        }
    }

    private a() {
    }

    private double a(java.lang.String str, int i) {
        java.util.LinkedList<com.anythink.core.c.a.C0162a> a = a(str);
        if (a != null) {
            a.toString();
        }
        if (a == null || a.size() == 0 || i == 0) {
            return -1.0d;
        }
        java.util.Iterator<com.anythink.core.c.a.C0162a> it = a.subList(0, java.lang.Math.min(i, a.size())).iterator();
        double d = 0.0d;
        while (it.hasNext()) {
            d += it.next().b;
        }
        return d / r5.size();
    }

    public static com.anythink.core.c.a a() {
        if (e == null) {
            synchronized (com.anythink.core.c.b.class) {
                if (e == null) {
                    e = new com.anythink.core.c.a();
                }
            }
        }
        return e;
    }

    private synchronized java.util.LinkedList<com.anythink.core.c.a.C0162a> a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        java.util.LinkedList<com.anythink.core.c.a.C0162a> linkedList = this.d.get(str);
        if (linkedList == null) {
            linkedList = b(str);
            if (linkedList == null) {
                linkedList = new java.util.LinkedList<>();
            }
            this.d.put(str, linkedList);
        }
        return linkedList;
    }

    private synchronized void a(java.lang.String str, java.lang.String str2, double d, int i) {
        java.util.LinkedList<com.anythink.core.c.a.C0162a> a = a(str);
        if (a != null) {
            a.toString();
        }
        if (a == null) {
            return;
        }
        if (i == 0) {
            a.clear();
        } else {
            if (a.size() >= i - 1) {
                int size = (a.size() - i) + 1;
                for (int i2 = 0; i2 < size; i2++) {
                    a.removeLast();
                }
            }
            if (a.size() < i) {
                a.addFirst(new com.anythink.core.c.a.C0162a(str2, d));
            }
        }
        a.toString();
        com.anythink.core.common.o.b.b.a().a(new com.anythink.core.c.a.AnonymousClass1(str, a));
    }

    private void a(java.lang.String str, java.util.LinkedList<com.anythink.core.c.a.C0162a> linkedList) {
        com.anythink.core.common.o.b.b.a().a(new com.anythink.core.c.a.AnonymousClass1(str, linkedList));
    }

    private java.util.LinkedList<com.anythink.core.c.a.C0162a> b(java.lang.String str) {
        try {
            java.lang.String b = com.anythink.core.common.o.r.b(com.anythink.core.common.b.o.a().f(), com.anythink.core.common.b.h.M, str, "");
            if (android.text.TextUtils.isEmpty(b)) {
                return null;
            }
            java.util.LinkedList<com.anythink.core.c.a.C0162a> linkedList = new java.util.LinkedList<>();
            try {
                org.json.JSONArray jSONArray = new org.json.JSONArray(b);
                for (int i = 0; i < jSONArray.length(); i++) {
                    org.json.JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        linkedList.add(new com.anythink.core.c.a.C0162a(optJSONObject.optString("sv_request_id"), optJSONObject.optDouble("sv_price", 0.0d)));
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
            return linkedList;
        } catch (java.lang.Throwable unused2) {
            return null;
        }
    }

    private java.lang.String c(java.lang.String str) {
        java.util.LinkedList<com.anythink.core.c.a.C0162a> a = a(str);
        if (a.size() > 0) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                for (com.anythink.core.c.a.C0162a c0162a : a) {
                    jSONObject.put(c0162a.a, c0162a.b);
                }
                return jSONObject.toString();
            } catch (java.lang.Throwable unused) {
            }
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00a9 A[Catch: all -> 0x00c0, TRY_LEAVE, TryCatch #0 {all -> 0x00c0, blocks: (B:11:0x0026, B:17:0x00a9, B:21:0x0033, B:33:0x006d, B:36:0x0078, B:27:0x008a, B:29:0x0090, B:41:0x003a), top: B:10:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(com.anythink.core.common.f.h hVar, com.anythink.core.common.f.au auVar) {
        com.anythink.core.d.e b;
        double parseDouble;
        if (hVar == null || auVar == null || (b = com.anythink.core.d.f.a(com.anythink.core.common.b.o.a().f()).b(hVar.ac())) == null || auVar.an() != 1) {
            return;
        }
        try {
            if (auVar.d() == 2) {
                java.util.Map<java.lang.String, java.lang.Object> c = hVar.c();
                if (c != null) {
                    c.toString();
                }
                if (c == null) {
                    try {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append(auVar.d());
                        java.lang.String sb2 = sb.toString();
                        java.lang.String u = auVar.u();
                        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                        sb3.append(auVar.af());
                        com.anythink.core.common.n.c.a(hVar, b, sb2, u, sb3.toString(), a(auVar.u(), b.i()) > 0.0d ? 2 : 1);
                    } catch (java.lang.Throwable unused) {
                        return;
                    }
                }
                if (c != null && c.containsKey("value_micros")) {
                    parseDouble = java.lang.Double.parseDouble(c.get("value_micros").toString()) / 1000.0d;
                    if (parseDouble <= 0.0d) {
                        auVar.e(parseDouble);
                        a(auVar.u(), hVar.ad(), parseDouble, b.i());
                        return;
                    }
                    return;
                }
            }
            parseDouble = -1.0d;
            if (parseDouble <= 0.0d) {
            }
        } catch (java.lang.Throwable unused2) {
        }
    }

    public final void a(com.anythink.core.common.f.h hVar, java.util.List<com.anythink.core.common.f.au> list, com.anythink.core.d.e eVar) {
        java.util.ListIterator<com.anythink.core.common.f.au> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            com.anythink.core.common.f.au next = listIterator.next();
            if (next.an() == 1) {
                int i = eVar.i();
                double a = a(next.u(), i);
                next.u();
                if (a > 0.0d) {
                    next.ap();
                    next.a(a);
                    next.d(a);
                    next.b(hVar.l() * a);
                    next.i("estimated");
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append(next.d());
                    com.anythink.core.common.n.c.a(hVar, eVar, sb.toString(), next.u(), java.lang.String.valueOf(a), java.lang.String.valueOf(i), c(next.u()));
                }
            }
        }
    }
}
