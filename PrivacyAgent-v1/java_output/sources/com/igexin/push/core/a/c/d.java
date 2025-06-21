package com.igexin.push.core.a.c;

import com.igexin.push.core.e.f.AnonymousClass5;

/* loaded from: classes23.dex */
public final class d implements com.igexin.push.extension.mod.PushMessageInterface {
    public static final java.lang.String a = "BasicAction";

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final boolean executeAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, com.igexin.push.extension.mod.BaseActionBean baseActionBean) {
        long currentTimeMillis = java.lang.System.currentTimeMillis() + (((com.igexin.push.core.b.h) baseActionBean).a * 1000);
        com.igexin.push.core.e.f.a().a(true);
        com.igexin.push.core.e.f a2 = com.igexin.push.core.e.f.a();
        if (com.igexin.push.core.e.X != currentTimeMillis) {
            com.igexin.push.core.e.X = currentTimeMillis;
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) a2.new AnonymousClass5(), false, true);
        }
        if (!baseActionBean.getDoActionId().equals("")) {
            com.igexin.push.core.a.b.d();
            com.igexin.push.core.a.b.a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseActionBean.getDoActionId());
        }
        return true;
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final com.igexin.push.extension.mod.BaseActionBean parseAction(org.json.JSONObject jSONObject) {
        try {
            if (!jSONObject.has(com.anythink.expressad.foundation.d.d.f238s) || !jSONObject.has("actionid") || !jSONObject.has("duration")) {
                return null;
            }
            com.igexin.push.core.b.h hVar = new com.igexin.push.core.b.h();
            hVar.setType(jSONObject.getString("type"));
            hVar.setActionId(jSONObject.getString("actionid"));
            hVar.setDoActionId(jSONObject.getString(com.anythink.expressad.foundation.d.d.f238s));
            if (jSONObject.has("duration")) {
                hVar.a = java.lang.Long.valueOf(jSONObject.getString("duration")).longValue();
            }
            return hVar;
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
