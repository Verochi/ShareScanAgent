package cn.fly.verify;

/* loaded from: classes.dex */
public class a extends cn.fly.verify.b {
    public java.lang.String a;
    public java.lang.String b;
    public boolean c;
    public long d;
    public java.lang.String e;
    public int f;

    @Override // cn.fly.verify.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public cn.fly.verify.a b(java.lang.String str) {
        try {
            super.b(str);
            this.a = java.lang.String.valueOf(this.h.get("opToken"));
            this.b = java.lang.String.valueOf(this.h.get(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE));
            this.c = ((java.lang.Boolean) this.h.get("use")).booleanValue();
            this.d = java.lang.System.currentTimeMillis() + 3600000;
        } catch (java.lang.Throwable th) {
            cn.fly.verify.f.a().a(th, "[FlyVerify] ==>%s", "Entity analyse exception.");
        }
        return this;
    }

    public java.lang.String toString() {
        return "Cache{opToken='" + this.a + "', phone='" + this.b + "', use=" + this.c + ", expireTime=" + this.d + '}';
    }
}
