package com.alipay.sdk.m.k;

/* loaded from: classes.dex */
public class a {

    /* renamed from: com.alipay.sdk.m.k.a$a, reason: collision with other inner class name */
    public static final class C0032a {
        public static final java.lang.String a = "RecordPref";
        public static final java.lang.String b = "alipay_cashier_statistic_record";

        /* renamed from: com.alipay.sdk.m.k.a$a$a, reason: collision with other inner class name */
        public static final class C0033a {
            public final java.util.LinkedHashMap<java.lang.String, java.lang.String> a = new java.util.LinkedHashMap<>();

            public C0033a() {
            }

            public C0033a(java.lang.String str) {
                try {
                    org.json.JSONArray jSONArray = new org.json.JSONArray(str);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        org.json.JSONArray jSONArray2 = jSONArray.getJSONArray(i);
                        this.a.put(jSONArray2.getString(0), jSONArray2.getString(1));
                    }
                } catch (java.lang.Throwable th) {
                    com.alipay.sdk.m.u.e.a(th);
                }
            }

            public java.lang.String a() {
                try {
                    org.json.JSONArray jSONArray = new org.json.JSONArray();
                    for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : this.a.entrySet()) {
                        org.json.JSONArray jSONArray2 = new org.json.JSONArray();
                        jSONArray2.put(entry.getKey()).put(entry.getValue());
                        jSONArray.put(jSONArray2);
                    }
                    return jSONArray.toString();
                } catch (java.lang.Throwable th) {
                    com.alipay.sdk.m.u.e.a(th);
                    return new org.json.JSONArray().toString();
                }
            }
        }

        public static synchronized int a(android.content.Context context, java.lang.String str) {
            synchronized (com.alipay.sdk.m.k.a.C0032a.class) {
                com.alipay.sdk.m.u.e.b(a, "stat remove " + str);
                if (context != null && !android.text.TextUtils.isEmpty(str)) {
                    com.alipay.sdk.m.k.a.C0032a.C0033a a2 = a(context);
                    if (a2.a.isEmpty()) {
                        return 0;
                    }
                    try {
                        java.util.ArrayList arrayList = new java.util.ArrayList();
                        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : a2.a.entrySet()) {
                            if (str.equals(entry.getValue())) {
                                arrayList.add(entry.getKey());
                            }
                        }
                        java.util.Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            a2.a.remove((java.lang.String) it.next());
                        }
                        a(context, a2);
                        return arrayList.size();
                    } catch (java.lang.Throwable th) {
                        com.alipay.sdk.m.u.e.a(th);
                        int size = a2.a.size();
                        a(context, new com.alipay.sdk.m.k.a.C0032a.C0033a());
                        return size;
                    }
                }
                return 0;
            }
        }

        public static synchronized com.alipay.sdk.m.k.a.C0032a.C0033a a(android.content.Context context) {
            synchronized (com.alipay.sdk.m.k.a.C0032a.class) {
                try {
                    java.lang.String a2 = com.alipay.sdk.m.u.j.a(null, context, b, null);
                    if (android.text.TextUtils.isEmpty(a2)) {
                        return new com.alipay.sdk.m.k.a.C0032a.C0033a();
                    }
                    return new com.alipay.sdk.m.k.a.C0032a.C0033a(a2);
                } catch (java.lang.Throwable th) {
                    com.alipay.sdk.m.u.e.a(th);
                    return new com.alipay.sdk.m.k.a.C0032a.C0033a();
                }
            }
        }

        public static synchronized java.lang.String a(android.content.Context context, java.lang.String str, java.lang.String str2) {
            synchronized (com.alipay.sdk.m.k.a.C0032a.class) {
                com.alipay.sdk.m.u.e.b(a, "stat append " + str2 + " , " + str);
                if (context != null && !android.text.TextUtils.isEmpty(str)) {
                    if (android.text.TextUtils.isEmpty(str2)) {
                        str2 = java.util.UUID.randomUUID().toString();
                    }
                    com.alipay.sdk.m.k.a.C0032a.C0033a a2 = a(context);
                    if (a2.a.size() > 20) {
                        a2.a.clear();
                    }
                    a2.a.put(str2, str);
                    a(context, a2);
                    return str2;
                }
                return null;
            }
        }

        public static synchronized void a(android.content.Context context, com.alipay.sdk.m.k.a.C0032a.C0033a c0033a) {
            synchronized (com.alipay.sdk.m.k.a.C0032a.class) {
                if (c0033a == null) {
                    try {
                        c0033a = new com.alipay.sdk.m.k.a.C0032a.C0033a();
                    } catch (java.lang.Throwable th) {
                        com.alipay.sdk.m.u.e.a(th);
                    }
                }
                com.alipay.sdk.m.u.j.b(null, context, b, c0033a.a());
            }
        }

        public static synchronized java.lang.String b(android.content.Context context) {
            synchronized (com.alipay.sdk.m.k.a.C0032a.class) {
                com.alipay.sdk.m.u.e.b(a, "stat peek");
                if (context == null) {
                    return null;
                }
                com.alipay.sdk.m.k.a.C0032a.C0033a a2 = a(context);
                if (a2.a.isEmpty()) {
                    return null;
                }
                try {
                    return a2.a.entrySet().iterator().next().getValue();
                } catch (java.lang.Throwable th) {
                    com.alipay.sdk.m.u.e.a(th);
                    return null;
                }
            }
        }
    }

    public static final class b {

        /* renamed from: com.alipay.sdk.m.k.a$b$a, reason: collision with other inner class name */
        public static class RunnableC0034a implements java.lang.Runnable {
            public final /* synthetic */ java.lang.String a;
            public final /* synthetic */ android.content.Context b;

            public RunnableC0034a(java.lang.String str, android.content.Context context) {
                this.a = str;
                this.b = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (android.text.TextUtils.isEmpty(this.a) || com.alipay.sdk.m.k.a.b.b(this.b, this.a)) {
                    for (int i = 0; i < 4; i++) {
                        java.lang.String b = com.alipay.sdk.m.k.a.C0032a.b(this.b);
                        if (android.text.TextUtils.isEmpty(b) || !com.alipay.sdk.m.k.a.b.b(this.b, b)) {
                            return;
                        }
                    }
                }
            }
        }

        public static synchronized void a(android.content.Context context) {
            synchronized (com.alipay.sdk.m.k.a.b.class) {
                a(context, null, null);
            }
        }

        public static synchronized void a(android.content.Context context, com.alipay.sdk.m.k.b bVar, java.lang.String str, java.lang.String str2) {
            synchronized (com.alipay.sdk.m.k.a.b.class) {
                if (context == null || bVar == null || str == null) {
                    return;
                }
                a(context, bVar.a(str), str2);
            }
        }

        public static synchronized void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
            synchronized (com.alipay.sdk.m.k.a.b.class) {
                if (context == null) {
                    return;
                }
                if (!android.text.TextUtils.isEmpty(str)) {
                    com.alipay.sdk.m.k.a.C0032a.a(context, str, str2);
                }
                new java.lang.Thread(new com.alipay.sdk.m.k.a.b.RunnableC0034a(str, context)).start();
            }
        }

        public static synchronized boolean b(android.content.Context context, java.lang.String str) {
            synchronized (com.alipay.sdk.m.k.a.b.class) {
                com.alipay.sdk.m.u.e.b(com.alipay.sdk.m.l.a.z, "stat sub " + str);
                try {
                    if ((com.alipay.sdk.m.m.a.D().e() ? new com.alipay.sdk.m.q.d() : new com.alipay.sdk.m.q.e()).a((com.alipay.sdk.m.s.a) null, context, str) == null) {
                        return false;
                    }
                    com.alipay.sdk.m.k.a.C0032a.a(context, str);
                    return true;
                } catch (java.lang.Throwable th) {
                    com.alipay.sdk.m.u.e.a(th);
                    return false;
                }
            }
        }
    }

    public static final class c {
        public static final java.lang.String a = "alipay_cashier_ap_seq_v";

        public static synchronized long a(android.content.Context context) {
            long a2;
            synchronized (com.alipay.sdk.m.k.a.c.class) {
                a2 = com.alipay.sdk.m.k.a.d.a(context, a);
            }
            return a2;
        }
    }

    public static final class d {
        /* JADX WARN: Can't wrap try/catch for region: R(9:3|4|5|(5:7|8|9|10|11)|17|8|9|10|11) */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static synchronized long a(android.content.Context context, java.lang.String str) {
            long j;
            long j2;
            java.lang.String a;
            synchronized (com.alipay.sdk.m.k.a.d.class) {
                try {
                    a = com.alipay.sdk.m.u.j.a(null, context, str, null);
                } catch (java.lang.Throwable unused) {
                }
                if (!android.text.TextUtils.isEmpty(a)) {
                    j = java.lang.Long.parseLong(a);
                    j2 = j + 1;
                    com.alipay.sdk.m.u.j.b(null, context, str, java.lang.Long.toString(j2));
                }
                j = 0;
                j2 = j + 1;
                com.alipay.sdk.m.u.j.b(null, context, str, java.lang.Long.toString(j2));
            }
            return j2;
        }
    }

    public static final class e {
        public static final java.lang.String a = "alipay_cashier_statistic_v";

        public static synchronized long a(android.content.Context context) {
            long a2;
            synchronized (com.alipay.sdk.m.k.a.e.class) {
                a2 = com.alipay.sdk.m.k.a.d.a(context, a);
            }
            return a2;
        }
    }

    public static synchronized void a(android.content.Context context) {
        synchronized (com.alipay.sdk.m.k.a.class) {
            com.alipay.sdk.m.k.a.b.a(context);
        }
    }

    public static synchronized void a(android.content.Context context, com.alipay.sdk.m.s.a aVar, java.lang.String str, java.lang.String str2) {
        synchronized (com.alipay.sdk.m.k.a.class) {
            if (context == null || aVar == null) {
                return;
            }
            try {
                com.alipay.sdk.m.k.a.C0032a.a(context, aVar.l.a(str), str2);
            } catch (java.lang.Throwable th) {
                com.alipay.sdk.m.u.e.a(th);
            }
        }
    }

    public static void a(com.alipay.sdk.m.s.a aVar, java.lang.String str, java.lang.String str2) {
        if (aVar == null) {
            return;
        }
        aVar.l.a(str, str2);
    }

    public static void a(com.alipay.sdk.m.s.a aVar, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (aVar == null) {
            return;
        }
        aVar.l.a(str, str2, str3);
    }

    public static void a(com.alipay.sdk.m.s.a aVar, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (aVar == null) {
            return;
        }
        aVar.l.a(str, str2, th);
    }

    public static void a(com.alipay.sdk.m.s.a aVar, java.lang.String str, java.lang.String str2, java.lang.Throwable th, java.lang.String str3) {
        if (aVar == null) {
            return;
        }
        aVar.l.a(str, str2, th, str3);
    }

    public static void a(com.alipay.sdk.m.s.a aVar, java.lang.String str, java.lang.Throwable th) {
        if (aVar == null || th == null) {
            return;
        }
        aVar.l.a(str, th.getClass().getSimpleName(), th);
    }

    public static synchronized void b(android.content.Context context, com.alipay.sdk.m.s.a aVar, java.lang.String str, java.lang.String str2) {
        synchronized (com.alipay.sdk.m.k.a.class) {
            if (context == null || aVar == null) {
                return;
            }
            com.alipay.sdk.m.k.a.b.a(context, aVar.l, str, str2);
        }
    }

    public static void b(com.alipay.sdk.m.s.a aVar, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (aVar == null) {
            return;
        }
        aVar.l.b(str, str2, str3);
    }
}
