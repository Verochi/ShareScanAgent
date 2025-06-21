package com.bytedance.pangle.log;

/* loaded from: classes12.dex */
public final class a {
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.String c;
    private long d;
    private long e;

    private a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        this.e = currentTimeMillis;
        this.d = currentTimeMillis;
        com.bytedance.pangle.log.ZeusLogger.i(this.a, this.b + java.lang.String.format(" watcher[%s]-start", str3));
    }

    public static com.bytedance.pangle.log.a a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return new com.bytedance.pangle.log.a(str, str2, str3);
    }

    public final long a() {
        return java.lang.System.currentTimeMillis() - this.d;
    }

    public final long a(java.lang.String str) {
        long currentTimeMillis = java.lang.System.currentTimeMillis() - this.e;
        long currentTimeMillis2 = java.lang.System.currentTimeMillis() - this.d;
        com.bytedance.pangle.log.ZeusLogger.i(this.a, this.b + java.lang.String.format(" watcher[%s]-%s cost=%s, total=%s", this.c, str, java.lang.Long.valueOf(currentTimeMillis), java.lang.Long.valueOf(currentTimeMillis2)));
        return currentTimeMillis2;
    }
}
