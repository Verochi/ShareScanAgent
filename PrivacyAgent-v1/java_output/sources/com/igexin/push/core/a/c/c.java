package com.igexin.push.core.a.c;

/* loaded from: classes23.dex */
public final class c implements com.igexin.push.extension.mod.PushMessageInterface {
    public static final java.lang.String a = "BasicAction";

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final boolean executeAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, com.igexin.push.extension.mod.BaseActionBean baseActionBean) {
        com.igexin.push.core.e.f.a().a(false);
        if (baseActionBean.getDoActionId().equals("")) {
            return true;
        }
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseActionBean.getDoActionId());
        return true;
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final com.igexin.push.extension.mod.BaseActionBean parseAction(org.json.JSONObject jSONObject) {
        try {
            if (!jSONObject.has(com.anythink.expressad.foundation.d.d.f238s) || !jSONObject.has("actionid")) {
                return null;
            }
            com.igexin.push.extension.mod.BaseActionBean baseActionBean = new com.igexin.push.extension.mod.BaseActionBean();
            baseActionBean.setType(jSONObject.getString("type"));
            baseActionBean.setActionId(jSONObject.getString("actionid"));
            baseActionBean.setDoActionId(jSONObject.getString(com.anythink.expressad.foundation.d.d.f238s));
            return baseActionBean;
        } catch (org.json.JSONException e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState prepareExecuteAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, com.igexin.push.extension.mod.BaseActionBean baseActionBean) {
        return com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.success;
    }
}
