package com.igexin.assist.action;

/* loaded from: classes22.dex */
public final class a {
    byte[] a;
    java.lang.String b;
    java.lang.String c;
    java.lang.String d;
    java.lang.String e;
    java.lang.String f;
    private java.lang.String g;

    private byte[] a() {
        return this.a;
    }

    private java.lang.String b() {
        return this.b;
    }

    private java.lang.String c() {
        return this.c;
    }

    private java.lang.String d() {
        return this.d;
    }

    private java.lang.String e() {
        return this.e;
    }

    private java.lang.String f() {
        return this.g;
    }

    private java.lang.String g() {
        return this.f;
    }

    public final void a(com.igexin.assist.MessageBean messageBean) {
        try {
            android.content.Context context = messageBean.getContext();
            java.lang.String stringMessage = messageBean.getStringMessage();
            if (!android.text.TextUtils.isEmpty(stringMessage) && context != null) {
                android.content.pm.ApplicationInfo b = com.igexin.push.h.n.b(context);
                java.lang.String a = com.igexin.push.h.d.a(b);
                this.d = a;
                if (android.text.TextUtils.isEmpty(a)) {
                    this.d = b.metaData.getString(com.igexin.push.core.b.b);
                }
                if (android.text.TextUtils.isEmpty(this.d)) {
                    this.d = b.metaData.getString("GETUI_APPID");
                }
                if (android.text.TextUtils.isEmpty(this.d)) {
                    return;
                }
                this.g = context.getPackageName();
                this.c = (android.text.TextUtils.isEmpty(messageBean.getMessageSource()) ? "" : messageBean.getMessageSource()) + java.util.UUID.randomUUID().toString();
                java.lang.String a2 = com.igexin.assist.util.a.a(stringMessage, this.d);
                if (android.text.TextUtils.isEmpty(a2)) {
                    return;
                }
                org.json.JSONObject jSONObject = new org.json.JSONObject(a2);
                if (jSONObject.has(com.igexin.assist.sdk.AssistPushConsts.MSG_KEY_TASKID)) {
                    this.b = jSONObject.getString(com.igexin.assist.sdk.AssistPushConsts.MSG_KEY_TASKID);
                }
                if (jSONObject.has(com.igexin.assist.sdk.AssistPushConsts.MSG_KEY_ACTION)) {
                    this.e = jSONObject.getString(com.igexin.assist.sdk.AssistPushConsts.MSG_KEY_ACTION);
                }
                if (jSONObject.has(com.igexin.assist.sdk.AssistPushConsts.MSG_KEY_CONTENT) && !android.text.TextUtils.isEmpty(jSONObject.getString(com.igexin.assist.sdk.AssistPushConsts.MSG_KEY_CONTENT))) {
                    this.a = jSONObject.getString(com.igexin.assist.sdk.AssistPushConsts.MSG_KEY_CONTENT).getBytes();
                }
                if (jSONObject.has(com.igexin.assist.sdk.AssistPushConsts.MSG_KEY_ACTION_CHAINS)) {
                    java.lang.String string = jSONObject.getString(com.igexin.assist.sdk.AssistPushConsts.MSG_KEY_ACTION_CHAINS);
                    this.f = string;
                    if (android.text.TextUtils.isEmpty(string)) {
                        return;
                    }
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject(this.f);
                    jSONObject2.put("extra_actionid", com.igexin.push.core.b.i);
                    this.f = jSONObject2.toString();
                }
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public final boolean a(boolean z) {
        return (this.a != null || (this.f != null && z)) && (com.igexin.push.h.d.a(this.b, this.g, this.d, this.e, this.c) ^ true);
    }
}
