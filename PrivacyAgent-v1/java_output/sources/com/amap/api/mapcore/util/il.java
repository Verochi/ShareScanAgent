package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class il {
    private com.amap.api.mapcore.util.fh a;

    public il(java.lang.String str) {
        this.a = null;
        try {
            this.a = new com.amap.api.mapcore.util.fh.a(str, "1.0", "1.0.0").a(new java.lang.String[]{"info"}).a();
        } catch (com.amap.api.mapcore.util.eu unused) {
        }
    }

    private static com.amap.api.mapcore.util.fh a(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            java.lang.String optString = jSONObject.optString("a");
            java.lang.String optString2 = jSONObject.optString("b");
            java.lang.String optString3 = jSONObject.optString("c");
            java.util.ArrayList arrayList = new java.util.ArrayList();
            org.json.JSONArray optJSONArray = jSONObject.optJSONArray("d");
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(optJSONArray.getString(i));
            }
            return new com.amap.api.mapcore.util.fh.a(optString, optString2, optString).a(optString3).a((java.lang.String[]) arrayList.toArray(new java.lang.String[0])).a();
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private static java.util.List<com.amap.api.mapcore.util.fh> a(org.json.JSONArray jSONArray) {
        com.amap.api.mapcore.util.fh fhVar;
        if (jSONArray.length() == 0) {
            return new java.util.ArrayList();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                fhVar = a(jSONArray.getJSONObject(i));
            } catch (org.json.JSONException unused) {
                fhVar = null;
            }
            if (fhVar != null) {
                arrayList.add(fhVar);
            }
        }
        return arrayList;
    }

    private static org.json.JSONArray a(java.util.List<com.amap.api.mapcore.util.fh> list) {
        if (list.size() == 0) {
            return new org.json.JSONArray();
        }
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        java.util.Iterator<com.amap.api.mapcore.util.fh> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(a(it.next()));
        }
        return jSONArray;
    }

    private static org.json.JSONObject a(com.amap.api.mapcore.util.fh fhVar) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("a", fhVar.a());
            jSONObject.put("b", fhVar.b());
            jSONObject.put("c", fhVar.c());
            org.json.JSONArray jSONArray = new org.json.JSONArray();
            for (int i = 0; fhVar.g() != null && i < fhVar.g().length; i++) {
                jSONArray.put(fhVar.g()[i]);
            }
            jSONObject.put("d", jSONArray);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public final java.util.List<com.amap.api.mapcore.util.fh> a(android.content.Context context) {
        try {
            return a(new org.json.JSONArray(com.amap.api.mapcore.util.gp.a(context, this.a, "rbck")));
        } catch (org.json.JSONException unused) {
            return new java.util.ArrayList();
        }
    }

    public final void a(android.content.Context context, com.amap.api.mapcore.util.fh fhVar) {
        if (fhVar == null) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(fhVar);
        java.lang.String jSONArray = a(arrayList).toString();
        if (android.text.TextUtils.isEmpty(jSONArray)) {
            return;
        }
        com.amap.api.mapcore.util.gp.a(context, this.a, "rbck", jSONArray);
    }
}
