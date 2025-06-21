package com.igexin.push.core.a.c;

/* loaded from: classes23.dex */
public final class a implements com.igexin.push.extension.mod.PushMessageInterface {
    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final boolean executeAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, com.igexin.push.extension.mod.BaseActionBean baseActionBean) {
        java.lang.String str;
        com.igexin.push.core.b.e eVar = (com.igexin.push.core.b.e) baseActionBean;
        java.lang.String taskId = pushTaskBean.getTaskId();
        java.lang.String messageId = pushTaskBean.getMessageId();
        if (com.igexin.push.h.c.d(eVar.a)) {
            java.lang.String str2 = eVar.b;
            if (str2 == null || str2.equals("")) {
                return true;
            }
            com.igexin.push.core.a.b.d();
            str = eVar.b;
        } else {
            java.lang.String str3 = eVar.c;
            if (str3 == null || str3.equals("")) {
                return true;
            }
            com.igexin.push.core.a.b.d();
            str = eVar.c;
        }
        com.igexin.push.core.a.b.a(taskId, messageId, str);
        return true;
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final com.igexin.push.extension.mod.BaseActionBean parseAction(org.json.JSONObject jSONObject) {
        try {
            if (!jSONObject.has("type") || !jSONObject.has("actionid")) {
                return null;
            }
            com.igexin.push.core.b.e eVar = new com.igexin.push.core.b.e();
            eVar.setType(com.igexin.push.core.b.u);
            eVar.setActionId(jSONObject.getString("actionid"));
            if (!jSONObject.has("appstartupid")) {
                return null;
            }
            org.json.JSONObject jSONObject2 = jSONObject.getJSONObject("appstartupid");
            if (!jSONObject2.has(com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM)) {
                return null;
            }
            eVar.a = jSONObject2.getString(com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM);
            if (!jSONObject.has("do_installed") && !jSONObject.has("do_uninstalled")) {
                return null;
            }
            if (jSONObject.has("do_installed")) {
                eVar.b = jSONObject.getString("do_installed");
            }
            if (jSONObject.has("do_uninstalled")) {
                eVar.c = jSONObject.getString("do_uninstalled");
            }
            return eVar;
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState prepareExecuteAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, com.igexin.push.extension.mod.BaseActionBean baseActionBean) {
        return com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.success;
    }
}
