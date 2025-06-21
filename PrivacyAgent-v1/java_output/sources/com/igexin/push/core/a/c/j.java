package com.igexin.push.core.a.c;

/* loaded from: classes23.dex */
public final class j implements com.igexin.push.extension.mod.PushMessageInterface {
    private static final java.lang.String a = com.igexin.push.config.c.a;

    public static void a(java.lang.String str, android.content.Context context) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            android.content.Intent a2 = com.igexin.push.h.d.a(str);
            a2.setPackage(context.getPackageName());
            a2.addFlags(268435456);
            context.startActivity(a2);
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final boolean executeAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, com.igexin.push.extension.mod.BaseActionBean baseActionBean) {
        java.lang.String id;
        java.lang.String messageId;
        java.lang.String str;
        com.igexin.push.core.b.q qVar = (com.igexin.push.core.b.q) baseActionBean;
        try {
            android.content.Intent a2 = com.igexin.push.h.d.a(qVar.b);
            a2.setPackage(com.igexin.push.core.e.l.getPackageName());
            a2.addFlags(268435456);
            if (com.igexin.push.h.c.b(a2, com.igexin.push.core.e.l)) {
                com.igexin.push.core.e.l.startActivity(a2);
                com.igexin.push.core.a.b.d();
                id = pushTaskBean.getTaskId();
                messageId = pushTaskBean.getMessageId();
                str = qVar.getDoActionId();
            } else {
                java.lang.String str2 = a;
                com.igexin.c.a.c.a.a(str2, "execute failed, activity not exist");
                com.igexin.c.a.c.a.a(str2 + "|execute failed, activity not exist", new java.lang.Object[0]);
                com.igexin.push.core.a.b.d();
                id = pushTaskBean.getId();
                messageId = pushTaskBean.getMessageId();
                str = qVar.a;
            }
            com.igexin.push.core.a.b.a(id, messageId, str);
            return true;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.push.core.a.b.d();
            com.igexin.push.core.a.b.a(pushTaskBean.getId(), pushTaskBean.getMessageId(), qVar.a);
            return true;
        }
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final com.igexin.push.extension.mod.BaseActionBean parseAction(org.json.JSONObject jSONObject) {
        try {
            if (!jSONObject.has(com.anythink.expressad.foundation.d.d.f238s) || !jSONObject.has("actionid") || !jSONObject.has("type") || !jSONObject.has("uri") || !jSONObject.has("do_failed")) {
                return null;
            }
            java.lang.String optString = jSONObject.optString("uri");
            if (android.text.TextUtils.isEmpty(optString)) {
                return null;
            }
            com.igexin.push.core.b.q qVar = new com.igexin.push.core.b.q();
            qVar.setType(com.igexin.push.core.b.o);
            qVar.setActionId(jSONObject.getString("actionid"));
            qVar.setDoActionId(jSONObject.getString(com.anythink.expressad.foundation.d.d.f238s));
            qVar.b = optString;
            qVar.a = jSONObject.optString("do_failed");
            return qVar;
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState prepareExecuteAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, com.igexin.push.extension.mod.BaseActionBean baseActionBean) {
        com.igexin.push.core.b.q qVar = (com.igexin.push.core.b.q) baseActionBean;
        try {
            android.content.Intent a2 = com.igexin.push.h.d.a(qVar.b);
            a2.setPackage(com.igexin.push.core.e.l.getPackageName());
            a2.addFlags(268435456);
            if (com.igexin.push.h.c.b(a2, com.igexin.push.core.e.l)) {
                return com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.success;
            }
            java.lang.String str = a;
            com.igexin.c.a.c.a.a(str, "execute failed, activity not exist");
            com.igexin.c.a.c.a.a(str + "|execute failed, activity not exist", new java.lang.Object[0]);
            com.igexin.push.core.a.b.d();
            com.igexin.push.core.a.b.a(pushTaskBean.getId(), pushTaskBean.getMessageId(), qVar.a);
            return com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.stop;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.push.core.a.b.d();
            com.igexin.push.core.a.b.a(pushTaskBean.getId(), pushTaskBean.getMessageId(), qVar.a);
            return com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.stop;
        }
    }
}
