package com.igexin.push.extension.mod;

/* loaded from: classes23.dex */
public interface PushMessageInterface {

    public enum ActionPrepareState {
        success,
        wait,
        stop
    }

    boolean executeAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, com.igexin.push.extension.mod.BaseActionBean baseActionBean);

    com.igexin.push.extension.mod.BaseActionBean parseAction(org.json.JSONObject jSONObject);

    com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState prepareExecuteAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, com.igexin.push.extension.mod.BaseActionBean baseActionBean);
}
