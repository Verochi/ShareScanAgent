package com.tramini.plugin.a.f;

/* loaded from: classes19.dex */
public final class e extends com.tramini.plugin.a.f.f {

    /* renamed from: com.tramini.plugin.a.f.e$1, reason: invalid class name */
    public class AnonymousClass1 implements com.tramini.plugin.a.f.f.c {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass1(java.lang.String str) {
            this.a = str;
        }

        @Override // com.tramini.plugin.a.f.f.c
        public final boolean a(java.lang.Object obj) {
            return (obj instanceof java.util.List) || obj.getClass().getName().contains(this.a);
        }

        @Override // com.tramini.plugin.a.f.f.c
        public final com.tramini.plugin.a.f.f.a b(java.lang.Object obj) {
            try {
                if (!(obj instanceof java.util.List)) {
                    return com.tramini.plugin.a.f.f.a.a(obj);
                }
                java.util.List list = (java.util.List) obj;
                if (list != null && list.size() > 0) {
                    for (int i = 0; i < list.size(); i++) {
                        java.lang.Object obj2 = list.get(i);
                        if (obj2.getClass().getName().contains(this.a)) {
                            return com.tramini.plugin.a.f.f.a.a(obj2);
                        }
                    }
                    return com.tramini.plugin.a.f.f.a.a();
                }
                return com.tramini.plugin.a.f.f.a.a();
            } catch (java.lang.Throwable unused) {
                return null;
            }
        }
    }

    private static com.tramini.plugin.a.d.a a(java.lang.Object obj, java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject, org.json.JSONArray jSONArray, java.lang.String str3) {
        try {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            if (!android.text.TextUtils.equals(str3, "0")) {
                obj = com.tramini.plugin.a.f.f.a(obj, str, stringBuffer, new com.tramini.plugin.a.f.e.AnonymousClass1(str2));
            }
        } catch (java.lang.Throwable unused) {
        }
        if (obj == null) {
            return null;
        }
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                java.lang.String optString = jSONArray.optString(i);
                java.lang.Object a = com.tramini.plugin.a.f.f.a(obj, jSONObject.optString(optString));
                if (a != null) {
                    java.lang.String obj2 = a.toString();
                    if (!android.text.TextUtils.isEmpty(obj2)) {
                        jSONObject2.put(optString, obj2);
                    }
                }
            } catch (java.lang.Throwable unused2) {
            }
        }
        if (jSONObject2.length() > 0) {
            com.tramini.plugin.a.d.a aVar = new com.tramini.plugin.a.d.a();
            aVar.a = jSONObject2;
            return aVar;
        }
        return null;
    }

    public static com.tramini.plugin.a.d.a a(org.json.JSONObject jSONObject, com.tramini.plugin.a.d.c cVar, java.lang.String str, java.lang.String str2) {
        return a(com.tramini.plugin.a.f.f.a(jSONObject.optString("in_na"), str), jSONObject.optString("pre"), jSONObject.optString("clna"), jSONObject, cVar.e, str2);
    }
}
