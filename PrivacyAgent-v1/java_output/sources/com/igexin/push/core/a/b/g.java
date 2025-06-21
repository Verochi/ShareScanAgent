package com.igexin.push.core.a.b;

/* loaded from: classes23.dex */
public final class g extends com.igexin.push.core.a.b.a {
    private static final java.lang.String a = "ReceivedAction";

    @Override // com.igexin.push.core.a.b.a
    public final boolean a(java.lang.Object obj, org.json.JSONObject jSONObject) {
        try {
            if (!jSONObject.has("action") || !jSONObject.getString("action").equals(com.igexin.push.core.b.E)) {
                return true;
            }
            java.lang.String string = jSONObject.getString("id");
            com.igexin.c.a.c.a.a("ReceivedAction received, cmd id :".concat(java.lang.String.valueOf(string)), new java.lang.Object[0]);
            try {
                com.igexin.push.core.e.e.a().a(java.lang.Long.parseLong(string), false);
                com.igexin.push.core.a.b.d();
                com.igexin.push.core.a.b.g();
                return true;
            } catch (java.lang.NumberFormatException e) {
                com.igexin.c.a.c.a.a("ReceivedAction|" + e.toString(), new java.lang.Object[0]);
                return true;
            }
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            com.igexin.c.a.c.a.a("ReceivedAction|" + e2.toString(), new java.lang.Object[0]);
            return true;
        }
    }
}
