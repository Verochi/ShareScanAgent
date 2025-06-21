package com.igexin.sdk.router.site;

/* loaded from: classes23.dex */
public class BridgeMessageSite extends com.igexin.sdk.router.boatman.receive.Site<org.json.JSONObject, org.json.JSONObject> {
    private static final java.lang.String TAG = "BridgeMessageSite";

    @Override // com.igexin.sdk.router.boatman.receive.Site
    public java.lang.String getTag() {
        return "tag_feedback";
    }

    @Override // com.igexin.sdk.router.boatman.receive.Site
    public org.json.JSONObject onArrived(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.igexin.c.a.c.a.a("BridgeMessageSiteboatman_feedback |" + jSONObject.toString(), new java.lang.Object[0]);
        if (jSONObject.has("active")) {
            try {
                java.lang.String string = jSONObject.getString("active");
                if (com.igexin.push.core.b.ax.equals(string)) {
                    java.lang.String string2 = jSONObject.getString("doAction");
                    java.lang.String string3 = jSONObject.getString("taskid");
                    java.lang.String string4 = jSONObject.getString("messageid");
                    com.igexin.push.core.a.b.d();
                    com.igexin.push.core.a.b.a(string3, string4, string2);
                } else if (com.igexin.push.core.b.ay.equals(string)) {
                    com.igexin.push.extension.mod.PushTaskBean pushTaskBean = new com.igexin.push.extension.mod.PushTaskBean();
                    pushTaskBean.parse(jSONObject);
                    if (jSONObject.has("actionid") && !android.text.TextUtils.isEmpty(jSONObject.getString("actionid"))) {
                        if (jSONObject.has("result")) {
                            com.igexin.sdk.main.FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean, jSONObject.getString("actionid"), jSONObject.getString("result"));
                        } else {
                            com.igexin.sdk.main.FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean, jSONObject.getString("actionid"));
                        }
                    }
                }
            } catch (org.json.JSONException e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
        return jSONObject;
    }

    @Override // com.igexin.sdk.router.boatman.receive.Site
    public void onArrived(org.json.JSONObject jSONObject, com.igexin.sdk.router.boatman.receive.IBoatResult<org.json.JSONObject> iBoatResult) {
    }
}
