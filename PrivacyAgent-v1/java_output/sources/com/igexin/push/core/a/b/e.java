package com.igexin.push.core.a.b;

/* loaded from: classes23.dex */
public final class e extends com.igexin.push.core.a.b.a {
    private static final java.lang.String a = "PushMessageAction";

    @Override // com.igexin.push.core.a.b.a
    public final boolean a(java.lang.Object obj, org.json.JSONObject jSONObject) {
        byte[] bArr;
        try {
            com.igexin.push.d.c.n nVar = (com.igexin.push.d.c.n) obj;
            if (jSONObject.has("action") && jSONObject.getString("action").equals(com.igexin.push.core.b.D)) {
                java.lang.Object obj2 = nVar.g;
                if (obj2 instanceof byte[]) {
                    try {
                        new java.lang.String((byte[]) obj2, "UTF-8");
                    } catch (java.lang.Exception e) {
                        com.igexin.c.a.c.a.a(a + e.toString(), new java.lang.Object[0]);
                    }
                    bArr = (byte[]) nVar.g;
                } else {
                    bArr = null;
                }
                java.lang.String string = jSONObject.getString("taskid");
                com.igexin.c.a.c.a.a("getui receive message : %s", jSONObject);
                if (bArr == null || !com.igexin.assist.sdk.a.a().c()) {
                    com.igexin.push.core.n.a().a(jSONObject, bArr, true);
                } else {
                    com.igexin.push.core.e.d a2 = com.igexin.push.core.e.d.a(com.igexin.push.core.e.l);
                    if (a2.a(string)) {
                        java.lang.String str = string + "4051" + com.igexin.assist.action.MessageManger.getInstance().getBrandCode();
                        if (!a2.a(str)) {
                            com.igexin.sdk.main.FeedbackImpl.getInstance().feedbackMultiBrandMessageAction(jSONObject, "1" + com.igexin.assist.action.MessageManger.getInstance().getBrandCode());
                            a2.b(str);
                        }
                    } else {
                        a2.b(string);
                        com.igexin.push.core.n.a().a(jSONObject, bArr, true);
                        com.igexin.sdk.main.FeedbackImpl.getInstance().feedbackMultiBrandMessageAction(jSONObject, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
                    }
                }
            }
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            com.igexin.c.a.c.a.a("PushMessageAction|" + e2.toString(), new java.lang.Object[0]);
        }
        return true;
    }
}
