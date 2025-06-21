package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class ae extends com.umeng.analytics.pro.ab {
    private int a;
    private int b;
    private int c;
    private java.util.ArrayList<android.util.Pair<java.lang.String, java.lang.Integer>> d;

    public ae(java.lang.String str, java.util.ArrayList<com.umeng.analytics.pro.ac> arrayList) {
        super(str, arrayList);
    }

    private void a(org.json.JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                int i = this.a;
                int i2 = 0;
                if (i != 0) {
                    if (i == 1) {
                        int randNumber = com.umeng.commonsdk.statistics.common.DeviceConfig.getRandNumber(0, this.c - 1);
                        java.lang.String str = (java.lang.String) this.d.get(randNumber).first;
                        int intValue = ((java.lang.Integer) this.d.get(randNumber).second).intValue();
                        jSONObject.put(com.umeng.ccg.a.A, str);
                        jSONObject.put(com.umeng.ccg.a.B, intValue);
                        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "selPoclicy: 1, currIndex: " + randNumber);
                        return;
                    }
                    return;
                }
                android.content.SharedPreferences a = com.umeng.analytics.pro.au.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext());
                if (a != null) {
                    int i3 = a.getInt(com.umeng.analytics.pro.au.h, 0);
                    if (i3 < this.c) {
                        java.lang.String str2 = (java.lang.String) this.d.get(i3).first;
                        int intValue2 = ((java.lang.Integer) this.d.get(i3).second).intValue();
                        jSONObject.put(com.umeng.ccg.a.A, str2);
                        jSONObject.put(com.umeng.ccg.a.B, intValue2);
                        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "selPoclicy: 0, currIndex: " + i3);
                        if (i3 < this.c - 1) {
                            i2 = i3 + 1;
                        }
                    } else {
                        java.lang.String str3 = (java.lang.String) this.d.get(0).first;
                        int intValue3 = ((java.lang.Integer) this.d.get(0).second).intValue();
                        jSONObject.put(com.umeng.ccg.a.A, str3);
                        jSONObject.put(com.umeng.ccg.a.B, intValue3);
                    }
                    a.edit().putInt(com.umeng.analytics.pro.au.h, i2).commit();
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    @Override // com.umeng.analytics.pro.ab
    public java.lang.String a() {
        return super.a();
    }

    @Override // com.umeng.analytics.pro.ab, com.umeng.analytics.pro.aj
    public org.json.JSONObject a(java.lang.String str, org.json.JSONObject jSONObject) {
        org.json.JSONObject a = super.a(str, jSONObject);
        if (this.c == 0) {
            return null;
        }
        if (jSONObject != null) {
            try {
                a.put(com.umeng.ccg.a.z, this.b);
                a.put(com.umeng.ccg.a.y, this.a);
                int optInt = jSONObject.optInt(com.umeng.ccg.a.j);
                if (this.b == 0 && optInt == 202) {
                    a(a);
                }
                if (this.b == 1 && optInt == 304) {
                    a(a);
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        return a;
    }

    public void a(int i) {
        this.a = i;
    }

    @Override // com.umeng.analytics.pro.ab
    public void a(java.lang.String str) {
        super.a(str);
    }

    @Override // com.umeng.analytics.pro.ab
    public java.lang.String b() {
        return super.b();
    }

    public void b(int i) {
        this.b = i;
    }

    @Override // com.umeng.analytics.pro.ab
    public void b(java.lang.String str) {
        super.b(str);
    }

    @Override // com.umeng.analytics.pro.ab, com.umeng.analytics.pro.aj
    public void b(java.lang.String str, org.json.JSONObject jSONObject) {
        super.b(str, jSONObject);
        if (jSONObject.has(com.umeng.ccg.a.y)) {
            a(jSONObject.optInt(com.umeng.ccg.a.y));
        }
        if (jSONObject.has(com.umeng.ccg.a.z)) {
            b(jSONObject.optInt(com.umeng.ccg.a.z));
        }
        if (jSONObject.has("signature")) {
            c(jSONObject.optString("signature"));
        }
    }

    @Override // com.umeng.analytics.pro.ab
    public java.lang.String c() {
        return super.c();
    }

    public void c(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            org.json.JSONArray jSONArray = new org.json.JSONArray(new java.lang.String(com.umeng.analytics.pro.ax.a(android.util.Base64.decode(str, 0), com.umeng.commonsdk.utils.UMUtils.genSin())));
            int length = jSONArray.length();
            if (length > 0) {
                this.d = new java.util.ArrayList<>();
            }
            for (int i = 0; i < length; i++) {
                org.json.JSONObject jSONObject = jSONArray.getJSONObject(i);
                java.lang.String optString = jSONObject.has("type") ? jSONObject.optString("type") : "";
                int valueOf = jSONObject.has(com.umeng.ccg.a.B) ? java.lang.Integer.valueOf(jSONObject.optInt(com.umeng.ccg.a.B)) : 1;
                if (!android.text.TextUtils.isEmpty(optString)) {
                    this.d.add(new android.util.Pair<>(optString, valueOf));
                }
            }
            this.c = this.d.size();
        } catch (java.lang.Throwable unused) {
        }
    }

    public int d() {
        return this.c;
    }

    public int e() {
        return this.a;
    }

    public int f() {
        return this.b;
    }

    public java.util.ArrayList<android.util.Pair<java.lang.String, java.lang.Integer>> g() {
        return this.d;
    }
}
