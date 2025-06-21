package com.igexin.push.core.a.c;

/* loaded from: classes23.dex */
public class i implements com.igexin.push.extension.mod.PushMessageInterface {
    private static final java.lang.String a = "com.igexin.push.core.a.c.i";

    private static void a(android.content.Context context, java.lang.String str) {
        try {
            android.content.Intent launchIntentForPackage = context.getApplicationContext().getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                android.content.Intent intent = new android.content.Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setFlags(270532608);
                intent.setComponent(launchIntentForPackage.getComponent());
                context.startActivity(intent);
            }
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0043 A[Catch: Exception -> 0x00cf, TRY_ENTER, TryCatch #0 {Exception -> 0x00cf, blocks: (B:11:0x0043, B:13:0x005c, B:14:0x0063, B:16:0x0069, B:17:0x0078, B:19:0x007c, B:21:0x0093, B:23:0x009b, B:25:0x00a7, B:27:0x00ad, B:28:0x00bd, B:30:0x00c1), top: B:9:0x0041 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007c A[Catch: Exception -> 0x00cf, TryCatch #0 {Exception -> 0x00cf, blocks: (B:11:0x0043, B:13:0x005c, B:14:0x0063, B:16:0x0069, B:17:0x0078, B:19:0x007c, B:21:0x0093, B:23:0x009b, B:25:0x00a7, B:27:0x00ad, B:28:0x00bd, B:30:0x00c1), top: B:9:0x0041 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a7 A[Catch: Exception -> 0x00cf, TryCatch #0 {Exception -> 0x00cf, blocks: (B:11:0x0043, B:13:0x005c, B:14:0x0063, B:16:0x0069, B:17:0x0078, B:19:0x007c, B:21:0x0093, B:23:0x009b, B:25:0x00a7, B:27:0x00ad, B:28:0x00bd, B:30:0x00c1), top: B:9:0x0041 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00bd A[Catch: Exception -> 0x00cf, TryCatch #0 {Exception -> 0x00cf, blocks: (B:11:0x0043, B:13:0x005c, B:14:0x0063, B:16:0x0069, B:17:0x0078, B:19:0x007c, B:21:0x0093, B:23:0x009b, B:25:0x00a7, B:27:0x00ad, B:28:0x00bd, B:30:0x00c1), top: B:9:0x0041 }] */
    @Override // com.igexin.push.extension.mod.PushMessageInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean executeAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, com.igexin.push.extension.mod.BaseActionBean baseActionBean) {
        boolean z;
        java.lang.String taskId;
        java.lang.String messageId;
        java.lang.String str;
        if (pushTaskBean != null && baseActionBean != null) {
            com.igexin.push.core.b.o oVar = (com.igexin.push.core.b.o) baseActionBean;
            java.lang.String str2 = oVar.b;
            boolean z2 = false;
            try {
                if (str2.equals("")) {
                    str2 = com.igexin.push.core.e.a;
                } else if (!com.igexin.push.core.e.a.equals(oVar.b)) {
                    z = false;
                    com.igexin.c.a.c.a.a("doStartApp|" + z + "|" + str2, new java.lang.Object[0]);
                    if (z) {
                        com.igexin.push.core.l.a().a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), str2, (java.lang.String) null);
                        if (oVar.d.equals(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE)) {
                            if (com.igexin.push.h.c.a(oVar.a)) {
                                a(com.igexin.push.core.e.l, ((com.igexin.push.core.b.o) baseActionBean).a);
                            }
                            if (z2) {
                                if (oVar.c != null) {
                                    com.igexin.push.core.a.b.d();
                                    taskId = pushTaskBean.getTaskId();
                                    messageId = pushTaskBean.getMessageId();
                                    str = oVar.c;
                                }
                            } else if (oVar.getDoActionId() != null) {
                                com.igexin.push.core.a.b.d();
                                taskId = pushTaskBean.getTaskId();
                                messageId = pushTaskBean.getMessageId();
                                str = oVar.getDoActionId();
                            }
                        }
                        z2 = true;
                        if (z2) {
                        }
                    } else {
                        com.igexin.push.core.l.a().a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), str2, (java.lang.String) null);
                        if (((com.igexin.push.core.b.o) baseActionBean).d.equals(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE)) {
                            a(com.igexin.push.core.e.l, com.igexin.push.core.e.g);
                        }
                        if (oVar.getDoActionId() != null) {
                            com.igexin.push.core.a.b.d();
                            taskId = pushTaskBean.getTaskId();
                            messageId = pushTaskBean.getMessageId();
                            str = oVar.getDoActionId();
                        }
                    }
                    com.igexin.push.core.a.b.a(taskId, messageId, str);
                }
                if (z) {
                }
                com.igexin.push.core.a.b.a(taskId, messageId, str);
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
            z = true;
            com.igexin.c.a.c.a.a("doStartApp|" + z + "|" + str2, new java.lang.Object[0]);
        }
        return true;
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public com.igexin.push.extension.mod.BaseActionBean parseAction(org.json.JSONObject jSONObject) {
        try {
            com.igexin.push.core.b.o oVar = new com.igexin.push.core.b.o();
            oVar.setType(com.igexin.push.core.b.p);
            oVar.setActionId(jSONObject.getString("actionid"));
            oVar.setDoActionId(jSONObject.getString(com.anythink.expressad.foundation.d.d.f238s));
            if (jSONObject.has("appstartupid")) {
                oVar.a = jSONObject.getJSONObject("appstartupid").getString(com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM);
            }
            if (jSONObject.has("is_autostart")) {
                oVar.d = jSONObject.getString("is_autostart");
            }
            if (jSONObject.has("appid")) {
                oVar.b = jSONObject.getString("appid");
            }
            if (jSONObject.has("noinstall_action")) {
                oVar.c = jSONObject.getString("noinstall_action");
            }
            return oVar;
        } catch (org.json.JSONException e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState prepareExecuteAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, com.igexin.push.extension.mod.BaseActionBean baseActionBean) {
        return com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.success;
    }
}
