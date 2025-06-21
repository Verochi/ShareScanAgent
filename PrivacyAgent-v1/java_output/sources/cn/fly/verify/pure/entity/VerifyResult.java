package cn.fly.verify.pure.entity;

/* loaded from: classes.dex */
public class VerifyResult extends cn.fly.verify.pure.entity.a {
    private java.lang.String opToken;
    private java.lang.String operator;
    private java.lang.String securityPhone;
    private java.lang.String token;
    private cn.fly.verify.pure.entity.UiElement uiElement;

    public VerifyResult(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this(str, str2, null, str3);
    }

    public VerifyResult(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        this.securityPhone = str;
        this.opToken = str2;
        this.token = str3;
        this.operator = str4;
        this.uiElement = genUiElement(str4);
    }

    public java.lang.String getOpToken() {
        return this.opToken;
    }

    public java.lang.String getOperator() {
        return this.operator;
    }

    public java.lang.String getSecurityPhone() {
        return this.securityPhone;
    }

    public java.lang.String getToken() {
        return this.token;
    }

    public cn.fly.verify.pure.entity.UiElement getUiElement() {
        return this.uiElement;
    }

    public void setSecurityPhone(java.lang.String str) {
        this.securityPhone = str;
    }

    public void setToken(java.lang.String str) {
        this.token = str;
    }

    @Override // cn.fly.verify.pure.entity.a
    public java.lang.String toJson() {
        try {
            cn.fly.verify.fl flVar = new cn.fly.verify.fl();
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("securityPhone", this.securityPhone);
            hashMap.put("opToken", this.opToken);
            hashMap.put("token", this.token);
            hashMap.put("operator", this.operator);
            hashMap.put("uiElement", flVar.a(this.uiElement.toJson()));
            return flVar.a(hashMap);
        } catch (java.lang.Throwable th) {
            cn.fly.verify.f.a().a(th, "[FlyVerify][%s][%s] ==>%s", this.tag, "toJson", "Error parse entity to json");
            return "";
        }
    }
}
