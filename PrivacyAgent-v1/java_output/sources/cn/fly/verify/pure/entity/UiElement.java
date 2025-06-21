package cn.fly.verify.pure.entity;

/* loaded from: classes.dex */
public class UiElement extends cn.fly.verify.pure.entity.a {
    private java.lang.String privacyName;
    private java.lang.String privacyUrl;
    private java.lang.String slogan;

    public java.lang.String getPrivacyName() {
        return this.privacyName;
    }

    public java.lang.String getPrivacyUrl() {
        return this.privacyUrl;
    }

    public java.lang.String getSlogan() {
        return this.slogan;
    }

    public void setPrivacyName(java.lang.String str) {
        this.privacyName = str;
    }

    public void setPrivacyUrl(java.lang.String str) {
        this.privacyUrl = str;
    }

    public void setSlogan(java.lang.String str) {
        this.slogan = str;
    }

    @Override // cn.fly.verify.pure.entity.a
    public java.lang.String toJson() {
        try {
            cn.fly.verify.fl flVar = new cn.fly.verify.fl();
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("privacyName", this.privacyName);
            hashMap.put("privacyUrl", this.privacyUrl);
            hashMap.put("slogan", this.slogan);
            return flVar.a(hashMap);
        } catch (java.lang.Throwable th) {
            cn.fly.verify.f.a().a(th, "[FlyVerify][%s][%s] ==>%s", this.tag, "toJson", "Error parse entity to json");
            return "";
        }
    }
}
