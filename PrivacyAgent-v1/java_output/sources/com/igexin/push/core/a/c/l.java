package com.igexin.push.core.a.c;

/* loaded from: classes23.dex */
public class l implements com.igexin.push.extension.mod.PushMessageInterface {
    private static final java.lang.String a = com.igexin.push.core.b.f + com.igexin.push.core.a.c.l.class.getName();

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public boolean executeAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, com.igexin.push.extension.mod.BaseActionBean baseActionBean) {
        return true;
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public com.igexin.push.extension.mod.BaseActionBean parseAction(org.json.JSONObject jSONObject) {
        try {
            if (!jSONObject.has(com.anythink.expressad.foundation.d.d.f238s) || !jSONObject.has("actionid") || !jSONObject.has("taskid")) {
                return null;
            }
            com.igexin.push.core.b.s sVar = new com.igexin.push.core.b.s();
            sVar.setType(com.igexin.push.core.b.n);
            sVar.setActionId(jSONObject.getString("actionid"));
            sVar.setDoActionId(jSONObject.getString(com.anythink.expressad.foundation.d.d.f238s));
            sVar.a = jSONObject.getString("taskid");
            sVar.b = jSONObject.optBoolean("force");
            return sVar;
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState prepareExecuteAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, com.igexin.push.extension.mod.BaseActionBean baseActionBean) {
        return com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.success;
    }
}
