package com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do;

/* loaded from: classes.dex */
public abstract class tanxc_do {
    protected com.alimm.tanx.core.utils.CountDownComponent tanxc_byte;
    protected boolean tanxc_case = true;
    protected boolean tanxc_char = false;
    protected android.content.Context tanxc_do;
    protected android.view.View tanxc_else;
    protected com.alimm.tanx.core.ad.bean.BidInfo tanxc_for;
    protected android.view.View tanxc_goto;
    protected android.view.ViewGroup tanxc_if;
    protected com.alimm.tanx.core.ad.ITanxAd tanxc_int;
    protected android.view.ViewStub tanxc_new;
    protected com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do tanxc_try;

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.ViewTreeObserver.OnWindowFocusChangeListener {
        public AnonymousClass1() {
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean z) {
            com.alimm.tanx.core.utils.LogUtils.d("BaseTemplate", "onWindowFocusChanged:" + z);
            if (z) {
                com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do.this.tanxc_int();
            } else {
                com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do.this.tanxc_for();
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do$2, reason: invalid class name */
    public class AnonymousClass2 implements com.alimm.tanx.core.utils.CountDownComponent.OnFinishListener {
        public AnonymousClass2() {
        }

        @Override // com.alimm.tanx.core.utils.CountDownComponent.OnFinishListener
        public void onFinish() {
            com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do.this.tanxc_try.tanxc_new();
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public tanxc_do(@androidx.annotation.NonNull com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do tanxc_doVar, @androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.view.ViewGroup viewGroup, @androidx.annotation.NonNull com.alimm.tanx.core.ad.ITanxAd iTanxAd) {
        if (iTanxAd == null || iTanxAd.getBidInfo() == null) {
            return;
        }
        this.tanxc_do = context;
        this.tanxc_if = viewGroup;
        this.tanxc_int = iTanxAd;
        this.tanxc_for = iTanxAd.getBidInfo();
        this.tanxc_try = tanxc_doVar;
        this.tanxc_if.getViewTreeObserver().addOnWindowFocusChangeListener(new com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do.AnonymousClass1());
        if (this.tanxc_new == null) {
            android.view.ViewStub viewStub = (android.view.ViewStub) this.tanxc_if.findViewById(tanxc_try());
            this.tanxc_new = viewStub;
            viewStub.inflate();
            this.tanxc_new.setVisibility(4);
        }
        tanxc_byte();
        tanxc_case();
    }

    private void tanxc_void() {
        if (this.tanxc_byte == null) {
            this.tanxc_byte = new com.alimm.tanx.core.utils.CountDownComponent((android.widget.TextView) this.tanxc_if.findViewById(com.alimm.tanx.core.R.id.splash_ad_txt_count_down), 5, new com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do.AnonymousClass2());
        }
        this.tanxc_byte.tanxc_do();
    }

    public void tanxc_byte() {
        this.tanxc_goto = tanxc_else();
        this.tanxc_else = tanxc_goto();
        com.alimm.tanx.core.utils.LogUtils.d("BaseTemplate", "initView mTemplateViewStub.getVisibility" + this.tanxc_new.getVisibility());
    }

    public void tanxc_case() {
        this.tanxc_goto.setOnClickListener(new com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do.AnonymousClass3());
    }

    public abstract android.view.View tanxc_char();

    public void tanxc_do() {
        if (this.tanxc_new != null) {
            com.alimm.tanx.core.utils.LogUtils.d("BaseTemplate", "onContentShowStart mTemplateViewStub.getVisibility" + this.tanxc_new.getVisibility());
            this.tanxc_new.setVisibility(0);
            tanxc_void();
        }
    }

    public abstract android.view.View tanxc_else();

    public void tanxc_for() {
        com.alimm.tanx.core.utils.CountDownComponent countDownComponent = this.tanxc_byte;
        if (countDownComponent != null) {
            countDownComponent.tanxc_for();
        }
    }

    public abstract android.view.View tanxc_goto();

    public void tanxc_if() {
        this.tanxc_try.tanxc_else();
    }

    public void tanxc_int() {
        com.alimm.tanx.core.utils.CountDownComponent countDownComponent = this.tanxc_byte;
        if (countDownComponent != null) {
            countDownComponent.tanxc_int();
        }
    }

    public abstract android.view.View tanxc_long();

    public void tanxc_new() {
        com.alimm.tanx.core.utils.CountDownComponent countDownComponent = this.tanxc_byte;
        if (countDownComponent != null) {
            countDownComponent.tanxc_if();
        }
    }

    public void tanxc_this() {
        com.alimm.tanx.core.utils.LogUtils.d("BaseTemplate", "notifyViewClick: mClickedOnce = " + this.tanxc_char + "mAdClickable = " + this.tanxc_case);
        if (this.tanxc_char) {
            return;
        }
        this.tanxc_char = true;
        if (this.tanxc_case) {
            tanxc_for();
        }
    }

    public abstract int tanxc_try();
}
