package com.igexin.push.core.a.c;

/* loaded from: classes23.dex */
public final class k implements com.igexin.push.extension.mod.PushMessageInterface {
    private static final java.lang.String a = com.igexin.push.config.c.a;

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
    
        if (r11.contains(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER) != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
    
        r6 = r11.substring(r11.indexOf(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER) + 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005f, code lost:
    
        if (r11.contains(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(com.igexin.push.core.b.r rVar, java.lang.String str) {
        int indexOf;
        java.lang.String str2;
        java.lang.String substring;
        java.lang.String str3 = rVar.a;
        if (str3 == null || (indexOf = str3.indexOf(str)) == -1) {
            return;
        }
        int indexOf2 = str3.indexOf("&");
        java.lang.String str4 = null;
        if (indexOf2 != -1) {
            int i = indexOf - 1;
            if (str3.charAt(i) == '?') {
                str2 = str3.substring(0, indexOf) + str3.substring(indexOf2 + 1);
                substring = str3.substring(indexOf, indexOf2);
            } else {
                java.lang.String str5 = "";
                if (str3.charAt(i) == '&') {
                    java.lang.String substring2 = str3.substring(0, i);
                    java.lang.String substring3 = str3.substring(indexOf);
                    int indexOf3 = substring3.indexOf("&");
                    if (indexOf3 != -1) {
                        str5 = substring3.substring(indexOf3);
                        substring3 = substring3.substring(0, indexOf3);
                    }
                    str4 = substring3.substring(substring3.indexOf(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER) + 1);
                    str2 = substring2 + str5;
                } else {
                    str2 = "";
                }
            }
            rVar.a = str2;
            rVar.d = str4;
            return;
        }
        str2 = str3.substring(0, indexOf - 1);
        substring = str3.substring(indexOf);
    }

    private static void a(java.lang.String str, android.content.Context context) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            com.igexin.push.core.b.r rVar = new com.igexin.push.core.b.r();
            rVar.a = str;
            a(rVar, com.igexin.push.core.b.z);
            android.content.Intent intent = new android.content.Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setFlags(268435456);
            intent.setPackage(rVar.d);
            intent.setData(android.net.Uri.parse(rVar.a()));
            context.startActivity(intent);
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final boolean executeAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, com.igexin.push.extension.mod.BaseActionBean baseActionBean) {
        com.igexin.push.core.b.r rVar = (com.igexin.push.core.b.r) baseActionBean;
        a(rVar, com.igexin.push.core.b.z);
        android.content.Intent intent = new android.content.Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setFlags(268435456);
        intent.setPackage(rVar.d);
        intent.setData(android.net.Uri.parse(rVar.a()));
        try {
            com.igexin.push.core.e.l.startActivity(intent);
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
        rVar.a();
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
            if (!jSONObject.has("url") || !jSONObject.has(com.anythink.expressad.foundation.d.d.f238s) || !jSONObject.has("actionid")) {
                return null;
            }
            java.lang.String string = jSONObject.getString("url");
            if (string.equals("")) {
                return null;
            }
            com.igexin.push.core.b.r rVar = new com.igexin.push.core.b.r();
            rVar.setType(com.igexin.push.core.b.t);
            rVar.setActionId(jSONObject.getString("actionid"));
            rVar.setDoActionId(jSONObject.getString(com.anythink.expressad.foundation.d.d.f238s));
            rVar.a = string;
            if (jSONObject.has("is_withcid") && com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE.equals(jSONObject.getString("is_withcid"))) {
                rVar.b = true;
            }
            if (jSONObject.has("is_withnettype") && com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE.equals(jSONObject.getString("is_withnettype"))) {
                rVar.c = true;
            }
            return rVar;
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
