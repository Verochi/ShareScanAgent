package com.igexin.push.core.a.c;

/* loaded from: classes23.dex */
public final class g implements com.igexin.push.extension.mod.PushMessageInterface {
    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final boolean executeAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, com.igexin.push.extension.mod.BaseActionBean baseActionBean) {
        com.igexin.push.core.b.j jVar = (com.igexin.push.core.b.j) baseActionBean;
        com.igexin.push.config.e.a(jVar.b, jVar.a);
        com.igexin.push.core.e.a();
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
            com.igexin.push.core.b.j jVar = new com.igexin.push.core.b.j();
            jVar.setType(com.igexin.push.core.b.y);
            jVar.setActionId(jSONObject.optString("actionid"));
            jVar.setDoActionId(jSONObject.optString(com.anythink.expressad.foundation.d.d.f238s));
            jVar.a = jSONObject.optBoolean("gdOther", true);
            jVar.b = jSONObject.optBoolean("gdMe", true);
            return jVar;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return null;
        }
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState prepareExecuteAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, com.igexin.push.extension.mod.BaseActionBean baseActionBean) {
        return com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.success;
    }
}
