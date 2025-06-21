package cn.fly.verify.pure.entity;

/* loaded from: classes.dex */
public class PreVerifyResult extends cn.fly.verify.pure.entity.a {
    public java.lang.String channel;
    private final long expireAt;
    private final java.lang.String operator;
    private final java.lang.String securityPhone;
    private final cn.fly.verify.pure.entity.UiElement uiElement;

    public PreVerifyResult(java.lang.String str, java.lang.String str2) {
        this.operator = str2;
        this.securityPhone = str;
        this.uiElement = genUiElement(str2);
        this.expireAt = setExpireAt();
    }

    public PreVerifyResult(java.lang.String str, java.lang.String str2, long j, java.lang.String str3) {
        this.operator = str2;
        this.securityPhone = str;
        this.expireAt = j;
        this.uiElement = genUiElement(str2);
        this.channel = str3;
    }

    private long setExpireAt() {
        return java.lang.System.currentTimeMillis() + 3600000;
    }

    public java.lang.String getChannel() {
        return this.channel;
    }

    public long getExpireAt() {
        return this.expireAt;
    }

    public java.lang.String getOperator() {
        return this.operator;
    }

    public java.lang.String getSecurityPhone() {
        return this.securityPhone;
    }

    public cn.fly.verify.pure.entity.UiElement getUiElement() {
        return this.uiElement;
    }

    @Override // cn.fly.verify.pure.entity.a
    public java.lang.String toJson() {
        try {
            cn.fly.verify.fl flVar = new cn.fly.verify.fl();
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("operator", this.operator);
            hashMap.put("securityPhone", this.securityPhone);
            hashMap.put("uiElement", flVar.a(this.uiElement.toJson()));
            return flVar.a(hashMap);
        } catch (java.lang.Throwable th) {
            cn.fly.verify.f.a().a(th, "[FlyVerify][%s][%s] ==>%s", this.tag, "toJson", "Error parse entity to json");
            return "";
        }
    }
}
