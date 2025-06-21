package com.anythink.expressad.foundation.h;

/* loaded from: classes12.dex */
public final class h {
    private static final java.lang.String a = "JSONUtils";

    public static java.lang.String a(int i, int i2, int i3, int i4, int i5) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            try {
                jSONObject.put("code", 0);
                jSONObject.put("message", "Sucess");
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                jSONObject2.put("rotateAngle", i);
                org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                jSONObject3.put(com.sensorsdata.sf.ui.view.UIProperty.left, i2);
                jSONObject3.put(com.sensorsdata.sf.ui.view.UIProperty.right, i3);
                jSONObject3.put(com.sensorsdata.sf.ui.view.UIProperty.top, i4);
                jSONObject3.put(com.sensorsdata.sf.ui.view.UIProperty.bottom, i5);
                jSONObject2.put("cutoutInfo", jSONObject3);
                jSONObject.put("data", jSONObject2);
            } catch (java.lang.Throwable th) {
                th.getMessage();
                try {
                    jSONObject.put("code", 1);
                    jSONObject.put("message", "Fail");
                } catch (org.json.JSONException e) {
                    e.getMessage();
                }
            }
        } catch (java.lang.Exception e2) {
            e2.getMessage();
        }
        return jSONObject.toString();
    }

    public static java.util.ArrayList<java.lang.String> a(org.json.JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            arrayList.add(jSONArray.optString(i));
        }
        return arrayList;
    }
}
