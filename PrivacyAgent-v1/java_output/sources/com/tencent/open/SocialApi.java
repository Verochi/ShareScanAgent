package com.tencent.open;

/* loaded from: classes19.dex */
public class SocialApi {
    private com.tencent.open.SocialApiIml a;

    public SocialApi(com.tencent.connect.auth.QQToken qQToken) {
        this.a = new com.tencent.open.SocialApiIml(qQToken);
    }

    public void ask(android.app.Activity activity, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener) {
        this.a.ask(activity, bundle, iUiListener);
    }

    public void gift(android.app.Activity activity, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener) {
        this.a.gift(activity, bundle, iUiListener);
    }

    public void invite(android.app.Activity activity, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener) {
        this.a.invite(activity, bundle, iUiListener);
    }

    public void story(android.app.Activity activity, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener) {
        this.a.story(activity, bundle, iUiListener);
    }
}
