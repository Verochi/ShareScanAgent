package cn.fly.verify.pure.entity;

/* loaded from: classes.dex */
public abstract class a implements java.io.Serializable {
    protected final java.lang.String tag = getClass().getSimpleName();

    private void genCmUiElement(cn.fly.verify.pure.entity.UiElement uiElement) {
        if (uiElement != null) {
            uiElement.setPrivacyUrl("https://wap.cmpassport.com/resources/html/contract.html");
            uiElement.setPrivacyName("中国移动认证服务条款");
            uiElement.setSlogan("中国移动提供认证服务");
        }
    }

    private void genCtUiElement(cn.fly.verify.pure.entity.UiElement uiElement) {
        if (uiElement != null) {
            uiElement.setPrivacyUrl("https://e.189.cn/sdk/agreement/detail.do");
            uiElement.setPrivacyName("中国电信服务与隐私协议");
            uiElement.setSlogan("中国电信提供认证服务");
        }
    }

    private void genCuUiElement(cn.fly.verify.pure.entity.UiElement uiElement) {
        if (uiElement != null) {
            uiElement.setPrivacyUrl("https://ms.zzx9.cn/html/oauth/protocol2.html");
            uiElement.setPrivacyName("中国联通认证服务协议");
            uiElement.setSlogan("中国联通提供认证服务");
        }
    }

    public cn.fly.verify.pure.entity.UiElement genUiElement(java.lang.String str) {
        cn.fly.verify.pure.entity.UiElement uiElement = new cn.fly.verify.pure.entity.UiElement();
        if ("CMCC".equals(str)) {
            genCmUiElement(uiElement);
        }
        if ("CUCC".equals(str)) {
            genCuUiElement(uiElement);
        }
        if ("CTCC".equals(str)) {
            genCtUiElement(uiElement);
        }
        return uiElement;
    }

    public abstract java.lang.String toJson();
}
