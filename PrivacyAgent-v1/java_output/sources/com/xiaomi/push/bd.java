package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class bd extends com.xiaomi.push.bf {
    public bd(java.lang.String str, java.lang.String str2, java.lang.String[] strArr, java.lang.String str3) {
        super(str, str2, strArr, str3);
    }

    @Override // com.xiaomi.push.bj.a
    public final void a(android.content.Context context, java.lang.Object obj) {
        com.xiaomi.push.bg bgVar;
        if (obj instanceof java.lang.Long) {
            long longValue = ((java.lang.Long) obj).longValue();
            long a = com.xiaomi.push.bp.a(this.d);
            long j = com.xiaomi.push.bb.b;
            if (a <= j) {
                com.xiaomi.channel.commonutils.logger.b.b("db size is suitable");
                return;
            }
            long j2 = (long) ((((a - j) * 1.2d) / j) * longValue);
            java.lang.String[] strArr = ((com.xiaomi.push.bj.d) this).f;
            if (strArr != null && strArr.length > 0) {
                strArr[0] = java.lang.String.valueOf(j2);
            }
            com.xiaomi.push.aw a2 = com.xiaomi.push.aw.a(context);
            java.lang.String str = "begin delete " + j2 + "noUpload messages , because db size is " + a + "B";
            if (a2.a() && !android.text.TextUtils.isEmpty(str)) {
                com.xiaomi.push.go a3 = com.xiaomi.push.bo.a(a2.a, str);
                if (a2.a() && com.xiaomi.push.service.bc.a(a3.k)) {
                    java.lang.String b = a2.b();
                    android.content.Context context2 = a2.a;
                    byte[] a4 = com.xiaomi.push.hv.a(a3);
                    if (a4 == null || a4.length <= 0) {
                        bgVar = null;
                    } else {
                        android.content.ContentValues contentValues = new android.content.ContentValues();
                        contentValues.put("status", (java.lang.Integer) 0);
                        contentValues.put("messageId", "");
                        contentValues.put("messageItemId", a3.i);
                        contentValues.put("messageItem", a4);
                        contentValues.put(com.anythink.expressad.videocommon.e.b.u, com.xiaomi.push.aw.a(context2).c);
                        contentValues.put("packageName", com.xiaomi.push.aw.a(context2).b);
                        contentValues.put("createTimeStamp", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
                        contentValues.put("uploadTimestamp", (java.lang.Integer) 0);
                        bgVar = new com.xiaomi.push.bg(b, contentValues, "a job build to insert message to db");
                    }
                    com.xiaomi.push.bj.a(a2.a).a((com.xiaomi.push.bj.a) bgVar);
                }
            }
            super.a(context, obj);
        }
    }
}
