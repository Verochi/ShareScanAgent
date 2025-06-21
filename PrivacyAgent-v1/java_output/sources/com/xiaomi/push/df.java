package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class df implements java.lang.Runnable {
    final /* synthetic */ java.lang.String a;
    final /* synthetic */ android.content.Context b;
    final /* synthetic */ java.lang.String c;
    final /* synthetic */ java.lang.String d;
    final /* synthetic */ com.xiaomi.push.de e;

    public df(com.xiaomi.push.de deVar, java.lang.String str, android.content.Context context, java.lang.String str2, java.lang.String str3) {
        this.e = deVar;
        this.a = str;
        this.b = context;
        this.c = str2;
        this.d = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        android.content.Context context;
        java.lang.String str;
        java.lang.String str2;
        if (android.text.TextUtils.isEmpty(this.a)) {
            context = this.b;
            str = com.igexin.push.core.b.m;
            str2 = "A receive a incorrect message with empty info";
        } else {
            try {
                com.xiaomi.push.cz.a(this.b, this.a, 1001, "get message");
                org.json.JSONObject jSONObject = new org.json.JSONObject(this.a);
                java.lang.String optString = jSONObject.optString("action");
                java.lang.String optString2 = jSONObject.optString("awakened_app_packagename");
                java.lang.String optString3 = jSONObject.optString("awake_app_packagename");
                java.lang.String optString4 = jSONObject.optString("awake_app");
                java.lang.String optString5 = jSONObject.optString("awake_type");
                int optInt = jSONObject.optInt("awake_foreground", 0);
                if (this.c.equals(optString3) && this.d.equals(optString4)) {
                    if (android.text.TextUtils.isEmpty(optString5) || android.text.TextUtils.isEmpty(optString3) || android.text.TextUtils.isEmpty(optString4) || android.text.TextUtils.isEmpty(optString2)) {
                        com.xiaomi.push.cz.a(this.b, this.a, 1008, "A receive a incorrect message with empty type");
                        return;
                    }
                    com.xiaomi.push.de deVar = this.e;
                    deVar.c = optString3;
                    deVar.b = optString4;
                    com.xiaomi.push.dd ddVar = new com.xiaomi.push.dd();
                    ddVar.b = optString;
                    ddVar.a = optString2;
                    ddVar.e = optInt;
                    ddVar.d = this.a;
                    if ("service".equals(optString5)) {
                        if (!android.text.TextUtils.isEmpty(optString)) {
                            com.xiaomi.push.de deVar2 = this.e;
                            deVar2.g.get(com.xiaomi.push.dg.SERVICE_ACTION).a(this.b, ddVar);
                            return;
                        } else {
                            ddVar.c = "com.xiaomi.mipush.sdk.PushMessageHandler";
                            com.xiaomi.push.de deVar3 = this.e;
                            deVar3.g.get(com.xiaomi.push.dg.SERVICE_COMPONENT).a(this.b, ddVar);
                            return;
                        }
                    }
                    com.xiaomi.push.dg dgVar = com.xiaomi.push.dg.ACTIVITY;
                    if (dgVar.e.equals(optString5)) {
                        this.e.g.get(dgVar).a(this.b, ddVar);
                        return;
                    }
                    com.xiaomi.push.dg dgVar2 = com.xiaomi.push.dg.PROVIDER;
                    if (!dgVar2.e.equals(optString5)) {
                        com.xiaomi.push.cz.a(this.b, this.a, 1008, "A receive a incorrect message with unknown type ".concat(java.lang.String.valueOf(optString5)));
                        return;
                    } else {
                        this.e.g.get(dgVar2).a(this.b, ddVar);
                        return;
                    }
                }
                com.xiaomi.push.cz.a(this.b, this.a, 1008, "A receive a incorrect message with incorrect package info".concat(java.lang.String.valueOf(optString3)));
                return;
            } catch (org.json.JSONException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                context = this.b;
                str = this.a;
                str2 = "A meet a exception when receive the message";
            }
        }
        com.xiaomi.push.cz.a(context, str, 1008, str2);
    }
}
