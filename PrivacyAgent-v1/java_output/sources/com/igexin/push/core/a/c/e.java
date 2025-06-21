package com.igexin.push.core.a.c;

/* loaded from: classes23.dex */
public final class e implements com.igexin.push.extension.mod.PushMessageInterface {
    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final boolean executeAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, com.igexin.push.extension.mod.BaseActionBean baseActionBean) {
        com.igexin.push.core.a.b.d();
        java.lang.String a = com.igexin.push.core.a.b.a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId());
        com.igexin.c.a.c.a.a("EndAction execute, remove pushMessage from pushMessageMap, key = ".concat(java.lang.String.valueOf(a)), new java.lang.Object[0]);
        try {
            com.igexin.push.core.e.ah.remove(a);
            return true;
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
            com.igexin.c.a.c.a.a("EndAction|" + e.toString(), new java.lang.Object[0]);
            return true;
        }
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final com.igexin.push.extension.mod.BaseActionBean parseAction(org.json.JSONObject jSONObject) {
        try {
            com.igexin.push.extension.mod.BaseActionBean baseActionBean = new com.igexin.push.extension.mod.BaseActionBean();
            baseActionBean.setType(com.igexin.push.core.b.m);
            baseActionBean.setActionId(jSONObject.getString("actionid"));
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
