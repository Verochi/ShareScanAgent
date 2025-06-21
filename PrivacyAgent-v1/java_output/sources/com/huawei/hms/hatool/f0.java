package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public class f0 {
    public long a = 1800000;
    public volatile boolean b = false;
    public com.huawei.hms.hatool.f0.a c = null;

    public class a {
        public java.lang.String a = java.util.UUID.randomUUID().toString().replace(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
        public boolean b;
        public long c;

        public a(long j) {
            this.a += "_" + j;
            this.c = j;
            this.b = true;
            com.huawei.hms.hatool.f0.this.b = false;
        }

        public void a(long j) {
            if (com.huawei.hms.hatool.f0.this.b) {
                com.huawei.hms.hatool.f0.this.b = false;
                b(j);
            } else if (b(this.c, j) || a(this.c, j)) {
                b(j);
            } else {
                this.c = j;
                this.b = false;
            }
        }

        public final boolean a(long j, long j2) {
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            calendar.setTimeInMillis(j);
            java.util.Calendar calendar2 = java.util.Calendar.getInstance();
            calendar2.setTimeInMillis(j2);
            return (calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) ? false : true;
        }

        public final void b(long j) {
            com.huawei.hms.hatool.y.c("hmsSdk", "getNewSession() session is flush!");
            java.lang.String uuid = java.util.UUID.randomUUID().toString();
            this.a = uuid;
            this.a = uuid.replace(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
            this.a += "_" + j;
            this.c = j;
            this.b = true;
        }

        public final boolean b(long j, long j2) {
            return j2 - j >= com.huawei.hms.hatool.f0.this.a;
        }
    }

    public java.lang.String a() {
        com.huawei.hms.hatool.f0.a aVar = this.c;
        if (aVar != null) {
            return aVar.a;
        }
        com.huawei.hms.hatool.y.f("hmsSdk", "getSessionName(): session not prepared. onEvent() must be called first.");
        return "";
    }

    public void a(long j) {
        com.huawei.hms.hatool.f0.a aVar = this.c;
        if (aVar != null) {
            aVar.a(j);
        } else {
            com.huawei.hms.hatool.y.c("hmsSdk", "Session is first flush");
            this.c = new com.huawei.hms.hatool.f0.a(j);
        }
    }

    public boolean b() {
        com.huawei.hms.hatool.f0.a aVar = this.c;
        if (aVar != null) {
            return aVar.b;
        }
        com.huawei.hms.hatool.y.f("hmsSdk", "isFirstEvent(): session not prepared. onEvent() must be called first.");
        return false;
    }
}
