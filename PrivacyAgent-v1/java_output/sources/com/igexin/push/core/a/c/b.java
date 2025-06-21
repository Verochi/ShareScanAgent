package com.igexin.push.core.a.c;

/* loaded from: classes23.dex */
public final class b implements com.igexin.push.extension.mod.PushMessageInterface {
    private static final java.lang.String a = "CleanExtAction";

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final boolean executeAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, com.igexin.push.extension.mod.BaseActionBean baseActionBean) {
        com.igexin.push.core.b.g gVar;
        int[] iArr;
        if (pushTaskBean != null && baseActionBean != null && (iArr = (gVar = (com.igexin.push.core.b.g) baseActionBean).a) != null && iArr.length > 0) {
            java.util.Arrays.toString(iArr);
            com.getui.gtc.api.GtcManager.getInstance().removeExt(com.igexin.push.core.b.j, gVar.a);
        }
        if ("".equals(baseActionBean.getDoActionId())) {
            return true;
        }
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseActionBean.getDoActionId());
        return true;
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final com.igexin.push.extension.mod.BaseActionBean parseAction(org.json.JSONObject jSONObject) {
        if (!jSONObject.has("ids")) {
            return null;
        }
        try {
            org.json.JSONArray jSONArray = new org.json.JSONArray(jSONObject.getString("ids"));
            if (jSONArray.length() <= 0) {
                return null;
            }
            int[] iArr = new int[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                iArr[i] = jSONArray.getInt(i);
            }
            com.igexin.push.core.b.g gVar = new com.igexin.push.core.b.g();
            gVar.setType(com.igexin.push.core.b.v);
            gVar.a = iArr;
            gVar.setActionId(jSONObject.getString("actionid"));
            gVar.setDoActionId(jSONObject.getString(com.anythink.expressad.foundation.d.d.f238s));
            return gVar;
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
