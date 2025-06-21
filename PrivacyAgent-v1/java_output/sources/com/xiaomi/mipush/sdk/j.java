package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
final class j implements java.lang.Runnable {
    final /* synthetic */ android.content.Context a;

    /* renamed from: a, reason: collision with other field name */
    final /* synthetic */ com.xiaomi.mipush.sdk.e f54a;

    /* renamed from: a, reason: collision with other field name */
    final /* synthetic */ java.lang.String f55a;

    public j(java.lang.String str, android.content.Context context, com.xiaomi.mipush.sdk.e eVar) {
        this.f55a = str;
        this.a = context;
        this.f54a = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        java.lang.String str;
        if (android.text.TextUtils.isEmpty(this.f55a)) {
            return;
        }
        java.lang.String[] split = this.f55a.split(com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR);
        int length = split.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                str = "";
                break;
            }
            java.lang.String str2 = split[i];
            if (!android.text.TextUtils.isEmpty(str2) && str2.startsWith("token:")) {
                str = str2.substring(str2.indexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR) + 1);
                break;
            }
            i++;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.a("ASSEMBLE_PUSH : receive incorrect token");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.a("ASSEMBLE_PUSH : receive correct token");
        com.xiaomi.mipush.sdk.i.d(this.a, this.f54a, str);
        com.xiaomi.mipush.sdk.i.m146a(this.a);
    }
}
