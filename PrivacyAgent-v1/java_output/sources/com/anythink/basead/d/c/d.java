package com.anythink.basead.d.c;

/* loaded from: classes12.dex */
public class d {
    private static volatile com.anythink.basead.d.c.d b;
    java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.ArrayList<java.lang.String>> a = new java.util.concurrent.ConcurrentHashMap<>();

    private d() {
    }

    public static com.anythink.basead.d.c.d a() {
        if (b == null) {
            synchronized (com.anythink.basead.d.c.d.class) {
                if (b == null) {
                    b = new com.anythink.basead.d.c.d();
                }
            }
        }
        return b;
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        return str + str2;
    }

    public final synchronized void a(android.content.Context context, java.lang.String str, com.anythink.core.common.f.l lVar, com.anythink.core.common.f.n nVar) {
        if (lVar.d() == 3 && (nVar instanceof com.anythink.core.common.f.aj)) {
            if (((com.anythink.core.common.f.aj) nVar).as() <= 0) {
                return;
            }
            com.anythink.core.common.f.aj ajVar = (com.anythink.core.common.f.aj) nVar;
            java.util.ArrayList<java.lang.String> arrayList = this.a.get(str);
            if (arrayList == null) {
                arrayList = new java.util.ArrayList<>();
                try {
                    org.json.JSONArray jSONArray = new org.json.JSONArray(com.anythink.core.common.o.r.b(context, com.anythink.core.common.b.h.D, str, ""));
                    if (jSONArray.length() > 0) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            arrayList.add(jSONArray.optString(i));
                        }
                    }
                } catch (java.lang.Exception unused) {
                }
                this.a.put(str, arrayList);
            }
            if (arrayList.size() >= ajVar.as()) {
                arrayList.remove(arrayList.size() - 1);
            }
            arrayList.add(0, lVar.s());
            com.anythink.core.common.o.r.a(context, com.anythink.core.common.b.h.D, str, new org.json.JSONArray((java.util.Collection) arrayList).toString());
        }
    }

    public final java.lang.String[] a(android.content.Context context, java.lang.String str) {
        java.util.ArrayList<java.lang.String> arrayList = this.a.get(str);
        if (arrayList == null) {
            try {
                org.json.JSONArray jSONArray = new org.json.JSONArray(com.anythink.core.common.o.r.b(context, com.anythink.core.common.b.h.D, str, ""));
                if (jSONArray.length() > 0) {
                    java.util.ArrayList<java.lang.String> arrayList2 = new java.util.ArrayList<>();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            arrayList2.add(jSONArray.optString(i));
                        } catch (java.lang.Exception unused) {
                        }
                    }
                    arrayList = arrayList2;
                }
            } catch (java.lang.Exception unused2) {
            }
        }
        if (arrayList == null) {
            return null;
        }
        this.a.put(str, arrayList);
        java.lang.String[] strArr = new java.lang.String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }
}
