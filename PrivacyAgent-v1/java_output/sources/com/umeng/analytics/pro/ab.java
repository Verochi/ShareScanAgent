package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class ab implements com.umeng.analytics.pro.aj {
    private java.lang.String a;
    private java.util.ArrayList<com.umeng.analytics.pro.ac> b;
    private java.lang.String c;
    private java.lang.String d;
    private java.lang.String e;
    private java.lang.String f;

    public ab(java.lang.String str, java.util.ArrayList<com.umeng.analytics.pro.ac> arrayList) {
        this.a = null;
        new java.util.ArrayList();
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.a = str;
        this.b = arrayList;
    }

    private java.lang.String c(java.lang.String str) {
        java.lang.String[] split = str.split(",");
        java.lang.String str2 = "";
        if (split.length <= 0) {
            return "";
        }
        java.util.ArrayList<java.lang.String> forbidSdkArray = com.umeng.ccg.CcgAgent.getForbidSdkArray(this.a);
        if (forbidSdkArray != null && forbidSdkArray.size() > 0) {
            this.f = forbidSdkArray.toString();
            for (java.lang.String str3 : split) {
                if (com.umeng.ccg.CcgAgent.getActionInfo(str3) != null && !forbidSdkArray.contains(str3)) {
                    return str3;
                }
            }
            return "";
        }
        for (java.lang.String str4 : split) {
            com.umeng.ccg.ActionInfo actionInfo = com.umeng.ccg.CcgAgent.getActionInfo(str4);
            if (actionInfo != null) {
                java.lang.String[] supportAction = actionInfo.getSupportAction(com.umeng.commonsdk.service.UMGlobalContext.getAppContext());
                if (supportAction.length > 0) {
                    int i = 0;
                    while (true) {
                        if (i >= supportAction.length) {
                            break;
                        }
                        if (this.a.equals(supportAction[i])) {
                            str2 = str4;
                            break;
                        }
                        i++;
                    }
                    if (!android.text.TextUtils.isEmpty(str2)) {
                        return str2;
                    }
                } else {
                    continue;
                }
            }
        }
        return str2;
    }

    public java.lang.String a() {
        return this.a;
    }

    @Override // com.umeng.analytics.pro.aj
    public org.json.JSONObject a(java.lang.String str, org.json.JSONObject jSONObject) {
        try {
            int size = this.b.size();
            if (size == 0) {
                return null;
            }
            for (int i = 0; i < size; i++) {
                if (this.b.get(i).b()) {
                    return null;
                }
            }
            if (com.umeng.ccg.CcgAgent.hasRegistedActionInfo() && !android.text.TextUtils.isEmpty(this.d)) {
                java.lang.String c = c(this.d);
                this.e = c;
                if (android.text.TextUtils.isEmpty(c)) {
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "采集项：" + this.a + "; 未选中可用Module ; sdk: " + this.d);
                } else {
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "采集项：" + this.a + "; 选中Module: " + this.e + "; sdk: " + this.d);
                }
            }
            com.umeng.analytics.pro.ac acVar = this.b.get(size - 1);
            if (acVar == null || !(acVar instanceof com.umeng.analytics.pro.af)) {
                return null;
            }
            long c2 = acVar.c();
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            try {
                jSONObject2.put("actionName", this.a);
                jSONObject2.put("sdk", this.d);
                jSONObject2.put(com.umeng.ccg.a.r, this.c);
                jSONObject2.put("delay", c2);
                jSONObject2.put(com.umeng.ccg.a.f451s, this.e);
                jSONObject2.put(com.umeng.ccg.a.t, this.f);
            } catch (java.lang.Throwable unused) {
            }
            return jSONObject2;
        } catch (java.lang.Throwable unused2) {
            return null;
        }
    }

    public void a(java.lang.String str) {
        this.c = str;
    }

    public java.lang.String b() {
        return this.c;
    }

    public void b(java.lang.String str) {
        this.d = str;
    }

    @Override // com.umeng.analytics.pro.aj
    public void b(java.lang.String str, org.json.JSONObject jSONObject) {
    }

    public java.lang.String c() {
        return this.d;
    }
}
