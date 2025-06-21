package com.anythink.core.activity;

/* loaded from: classes29.dex */
public class ATGdprAuthActivity extends android.app.Activity {
    public static com.anythink.core.api.ATGDPRAuthCallback mCallback;
    java.lang.String a;
    com.anythink.core.activity.component.PrivacyPolicyView b;
    boolean c = false;

    /* renamed from: com.anythink.core.activity.ATGdprAuthActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.activity.component.PrivacyPolicyView.a {
        public AnonymousClass1() {
        }

        @Override // com.anythink.core.activity.component.PrivacyPolicyView.a
        public final void onLevelSelect(int i) {
            com.anythink.core.api.ATGDPRAuthCallback aTGDPRAuthCallback = com.anythink.core.activity.ATGdprAuthActivity.mCallback;
            if (aTGDPRAuthCallback != null) {
                aTGDPRAuthCallback.onAuthResult(i);
                com.anythink.core.activity.ATGdprAuthActivity.mCallback = null;
            }
            com.anythink.core.activity.ATGdprAuthActivity.this.finish();
        }

        @Override // com.anythink.core.activity.component.PrivacyPolicyView.a
        public final void onPageLoadFail() {
            com.anythink.core.activity.ATGdprAuthActivity.this.c = true;
            com.anythink.core.api.ATGDPRAuthCallback aTGDPRAuthCallback = com.anythink.core.activity.ATGdprAuthActivity.mCallback;
            if (aTGDPRAuthCallback != null) {
                aTGDPRAuthCallback.onPageLoadFail();
            }
        }

        @Override // com.anythink.core.activity.component.PrivacyPolicyView.a
        public final void onPageLoadSuccess() {
            com.anythink.core.activity.ATGdprAuthActivity.this.c = false;
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.c) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.anythink.core.common.h.a();
        this.a = com.anythink.core.common.h.l();
        if (getResources().getConfiguration().orientation == 2) {
            setRequestedOrientation(6);
        } else {
            setRequestedOrientation(7);
        }
        try {
            com.anythink.core.activity.component.PrivacyPolicyView privacyPolicyView = new com.anythink.core.activity.component.PrivacyPolicyView(this);
            this.b = privacyPolicyView;
            privacyPolicyView.setResultCallbackListener(new com.anythink.core.activity.ATGdprAuthActivity.AnonymousClass1());
            setContentView(this.b);
            this.b.loadPolicyUrl(this.a);
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        com.anythink.core.activity.component.PrivacyPolicyView privacyPolicyView = this.b;
        if (privacyPolicyView != null) {
            privacyPolicyView.destory();
        }
        mCallback = null;
        super.onDestroy();
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
    }
}
