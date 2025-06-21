package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class fw {
    private com.amap.api.mapcore.util.fh a;

    public static class a {
        public static java.util.Map<java.lang.String, com.amap.api.mapcore.util.fw> a = new java.util.HashMap();
    }

    public static class b {
        private java.lang.String a;
        private java.lang.String b;
        private java.lang.String c;

        public b(java.lang.String str, java.lang.String str2, java.lang.String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        private static com.amap.api.mapcore.util.fw.b a(org.json.JSONObject jSONObject) {
            try {
                return new com.amap.api.mapcore.util.fw.b(jSONObject.optString(com.heytap.mcssdk.constant.b.C), jSONObject.optString("cpuType"), jSONObject.optString("content"));
            } catch (java.lang.Throwable unused) {
                return null;
            }
        }

        public static java.util.List<com.amap.api.mapcore.util.fw.b> a(java.lang.String str) {
            if (android.text.TextUtils.isEmpty(str)) {
                return new java.util.ArrayList();
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            try {
                org.json.JSONArray jSONArray = new org.json.JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(a(jSONArray.getJSONObject(i)));
                }
                return arrayList;
            } catch (java.lang.Throwable unused) {
                return new java.util.ArrayList();
            }
        }

        public static org.json.JSONArray a(java.util.List<com.amap.api.mapcore.util.fw.b> list) {
            if (list == null) {
                return new org.json.JSONArray();
            }
            org.json.JSONArray jSONArray = new org.json.JSONArray();
            for (com.amap.api.mapcore.util.fw.b bVar : list) {
                if (bVar != null) {
                    if (!android.text.TextUtils.isEmpty(bVar.c)) {
                        jSONArray.put(bVar.a());
                    }
                }
            }
            return jSONArray;
        }

        private org.json.JSONObject a() {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put(com.heytap.mcssdk.constant.b.C, this.a);
                jSONObject.put("cpuType", this.b);
                jSONObject.put("content", this.c);
                return jSONObject;
            } catch (java.lang.Throwable unused) {
                return new org.json.JSONObject();
            }
        }

        public final boolean a(java.lang.String str, java.lang.String str2) {
            if (android.text.TextUtils.isEmpty(str)) {
                str = this.a;
            }
            if (android.text.TextUtils.isEmpty(str2)) {
                str2 = this.b;
            }
            return this.a.equals(str) && this.b.equals(str2);
        }
    }

    private fw(com.amap.api.mapcore.util.fh fhVar) {
        this.a = fhVar;
    }

    public static com.amap.api.mapcore.util.fw a(com.amap.api.mapcore.util.fh fhVar) {
        if (fhVar == null || android.text.TextUtils.isEmpty(fhVar.a())) {
            return null;
        }
        if (com.amap.api.mapcore.util.fw.a.a.get(fhVar.a()) == null) {
            com.amap.api.mapcore.util.fw.a.a.put(fhVar.a(), new com.amap.api.mapcore.util.fw(fhVar));
        }
        return com.amap.api.mapcore.util.fw.a.a.get(fhVar.a());
    }

    private static java.lang.String a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        return b(context, "C7ADB20F22F238708BA5EE26D0401DB9" + com.amap.api.mapcore.util.fd.b(str), "ik".concat(java.lang.String.valueOf(str2)));
    }

    private static java.lang.String b(android.content.Context context, java.lang.String str, java.lang.String str2) {
        return (context == null || android.text.TextUtils.isEmpty(str2)) ? "" : com.amap.api.mapcore.util.fi.a(com.amap.api.mapcore.util.et.b(com.amap.api.mapcore.util.fi.e(context.getSharedPreferences(str, 0).getString(str2, ""))));
    }

    private static void b(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (str3 == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        c(context, "C7ADB20F22F238708BA5EE26D0401DB9" + com.amap.api.mapcore.util.fd.b(str), "ik".concat(java.lang.String.valueOf(str2)), str3);
    }

    private static void c(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (context == null || android.text.TextUtils.isEmpty(str2) || android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str3)) {
            return;
        }
        java.lang.String g = com.amap.api.mapcore.util.fi.g(com.amap.api.mapcore.util.et.a(com.amap.api.mapcore.util.fi.a(str3)));
        android.content.SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, g);
        edit.commit();
    }

    public final java.lang.String a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.amap.api.mapcore.util.fh fhVar;
        if (context != null && (fhVar = this.a) != null && !android.text.TextUtils.isEmpty(fhVar.a())) {
            java.util.List<com.amap.api.mapcore.util.fw.b> a2 = com.amap.api.mapcore.util.fw.b.a(a(context, this.a.a(), str3));
            if (a2.size() == 0) {
                return "";
            }
            for (int i = 0; i < a2.size(); i++) {
                com.amap.api.mapcore.util.fw.b bVar = a2.get(i);
                if (bVar.a(str, str2)) {
                    return bVar.c;
                }
            }
        }
        return null;
    }

    public final void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        com.amap.api.mapcore.util.fh fhVar;
        if (context == null || (fhVar = this.a) == null || android.text.TextUtils.isEmpty(fhVar.a())) {
            return;
        }
        java.util.List<com.amap.api.mapcore.util.fw.b> a2 = com.amap.api.mapcore.util.fw.b.a(a(context, this.a.a(), str3));
        for (int i = 0; i < a2.size(); i++) {
            com.amap.api.mapcore.util.fw.b bVar = a2.get(i);
            if (bVar.a(str, str2)) {
                bVar.c = str4;
                b(context, this.a.a(), str3, com.amap.api.mapcore.util.fw.b.a(a2).toString());
                return;
            }
        }
        a2.add(new com.amap.api.mapcore.util.fw.b(str, str2, str4));
        b(context, this.a.a(), str3, com.amap.api.mapcore.util.fw.b.a(a2).toString());
    }
}
