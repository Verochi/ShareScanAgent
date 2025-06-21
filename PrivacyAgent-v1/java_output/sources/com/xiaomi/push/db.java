package com.xiaomi.push;

/* loaded from: classes19.dex */
final class db implements java.lang.Runnable {
    final /* synthetic */ android.content.Context a;
    final /* synthetic */ java.lang.String b;
    final /* synthetic */ int c;
    final /* synthetic */ java.lang.String d;

    public db(android.content.Context context, java.lang.String str, int i, java.lang.String str2) {
        this.a = context;
        this.b = str;
        this.c = i;
        this.d = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        android.content.Context context = this.a;
        java.lang.String str = this.b;
        int i = this.c;
        java.lang.String str2 = this.d;
        if (context == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
            hashMap.put("awake_info", str);
            hashMap.put(com.hihonor.push.sdk.common.constants.PushApiKeys.EVENT_TYPE, java.lang.String.valueOf(i));
            hashMap.put("description", str2);
            int i2 = com.xiaomi.push.de.a(context).d;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        com.xiaomi.push.cz.a(context, hashMap);
                    }
                }
                com.xiaomi.push.cz.b(context, hashMap);
            } else {
                com.xiaomi.push.cz.a(context, hashMap);
            }
            com.xiaomi.push.di diVar = com.xiaomi.push.de.a(context).e;
            if (diVar != null) {
                diVar.c(context, hashMap);
            }
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }
}
