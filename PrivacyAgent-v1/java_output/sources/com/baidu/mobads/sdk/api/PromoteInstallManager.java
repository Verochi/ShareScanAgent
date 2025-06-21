package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class PromoteInstallManager {
    private com.baidu.mobads.sdk.api.PromoteInstallManager.PromoteInstallListener promoteInstallListener;
    private com.baidu.mobads.sdk.internal.ap promoteInstallProd;

    public interface PromoteInstallListener {
        void onFail(java.lang.String str);

        void onSuccess();
    }

    public PromoteInstallManager(android.content.Context context, com.baidu.mobads.sdk.api.PromoteInstallManager.PromoteInstallListener promoteInstallListener) {
        this.promoteInstallListener = promoteInstallListener;
        if (context != null) {
            this.promoteInstallProd = com.baidu.mobads.sdk.internal.ap.a(context, promoteInstallListener);
        } else if (promoteInstallListener != null) {
            promoteInstallListener.onFail("context为空 初始化失败");
        }
    }

    public com.baidu.mobads.sdk.api.IPromoteInstallAdInfo getPromoteInstallAdInfo() {
        com.baidu.mobads.sdk.internal.ap apVar = this.promoteInstallProd;
        if (apVar != null && apVar.b() && this.promoteInstallProd.c() == 1) {
            return this.promoteInstallProd.a(false);
        }
        com.baidu.mobads.sdk.api.PromoteInstallManager.PromoteInstallListener promoteInstallListener = this.promoteInstallListener;
        if (promoteInstallListener != null) {
            promoteInstallListener.onFail("功能暂不可用，请联系商务同学");
        }
        return null;
    }

    public boolean hasPromoteInstallApp() {
        com.baidu.mobads.sdk.internal.ap apVar = this.promoteInstallProd;
        if (apVar != null && apVar.b()) {
            return this.promoteInstallProd.a();
        }
        com.baidu.mobads.sdk.api.PromoteInstallManager.PromoteInstallListener promoteInstallListener = this.promoteInstallListener;
        if (promoteInstallListener == null) {
            return false;
        }
        promoteInstallListener.onFail("功能暂不可用，请联系商务同学");
        return false;
    }

    public void showPromoteInstallDialog() {
        com.baidu.mobads.sdk.internal.ap apVar = this.promoteInstallProd;
        if (apVar != null && apVar.b() && this.promoteInstallProd.c() == 0) {
            this.promoteInstallProd.a(true);
            return;
        }
        com.baidu.mobads.sdk.api.PromoteInstallManager.PromoteInstallListener promoteInstallListener = this.promoteInstallListener;
        if (promoteInstallListener != null) {
            promoteInstallListener.onFail("功能暂不可用，请联系商务同学");
        }
    }
}
