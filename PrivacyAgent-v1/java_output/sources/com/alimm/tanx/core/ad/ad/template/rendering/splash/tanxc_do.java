package com.alimm.tanx.core.ad.ad.template.rendering.splash;

/* loaded from: classes.dex */
public abstract class tanxc_do extends android.os.Handler {
    protected com.alimm.tanx.core.ad.ad.template.rendering.splash.IRenderCallback tanxc_char;
    protected android.content.Context tanxc_do;
    protected com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener tanxc_else;
    protected com.alimm.tanx.core.ad.bean.BidInfo tanxc_for;
    protected com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do tanxc_goto;
    protected com.alimm.tanx.core.ad.ad.template.rendering.splash.TanxSplashAdView tanxc_if;
    protected com.alimm.tanx.core.ad.ITanxAd tanxc_int;
    protected com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd tanxc_long;
    protected boolean tanxc_new;
    protected long tanxc_try;
    protected boolean tanxc_byte = false;
    protected boolean tanxc_case = false;
    private boolean tanxc_this = false;
    private boolean tanxc_void = false;
    private boolean tanxc_break = false;
    private boolean tanxc_catch = false;

    public tanxc_do(@androidx.annotation.NonNull com.alimm.tanx.core.ad.ad.template.rendering.splash.IRenderCallback iRenderCallback, @androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull com.alimm.tanx.core.ad.ad.template.rendering.splash.TanxSplashAdView tanxSplashAdView, @androidx.annotation.NonNull com.alimm.tanx.core.ad.ITanxAd iTanxAd, boolean z) {
        if (iTanxAd == null || iTanxAd.getBidInfo() == null) {
            return;
        }
        this.tanxc_char = iRenderCallback;
        this.tanxc_do = context;
        this.tanxc_if = tanxSplashAdView;
        this.tanxc_int = iTanxAd;
        com.alimm.tanx.core.ad.bean.BidInfo bidInfo = iTanxAd.getBidInfo();
        this.tanxc_for = bidInfo;
        this.tanxc_new = z;
        if (bidInfo == null || !bidInfo.getInteractType2Shake()) {
            this.tanxc_goto = new com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_if(this, context, tanxSplashAdView, iTanxAd);
        } else {
            this.tanxc_goto = new com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_for(this, context, tanxSplashAdView, iTanxAd);
        }
        com.alimm.tanx.core.utils.LogUtils.d("BaseAdRenderer", "BaseAdRenderer:, mTemplate = " + this.tanxc_goto + ", rootView = " + tanxSplashAdView);
    }

    private void tanxc_class() {
        com.alimm.tanx.core.utils.LogUtils.d("BaseAdRenderer", "checkAdFinished: mContentShowComplete = " + this.tanxc_void + ", mCountDownFinished = " + this.tanxc_break);
        if (this.tanxc_void && this.tanxc_break) {
            this.tanxc_goto.tanxc_if();
        }
    }

    private void tanxc_do(android.view.View view, int i) {
        if (view != null) {
            view.setVisibility(i);
        }
    }

    public void tanxc_break() {
        com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do tanxc_doVar = this.tanxc_goto;
        if (tanxc_doVar != null) {
            tanxc_doVar.tanxc_this();
        }
    }

    public void tanxc_byte() {
        com.alimm.tanx.core.utils.LogUtils.d("BaseAdRenderer", "resume: timerPause = " + this.tanxc_case);
        if (this.tanxc_case) {
            this.tanxc_goto.tanxc_int();
            this.tanxc_case = false;
        }
    }

    public void tanxc_case() {
        com.alimm.tanx.core.utils.LogUtils.d("BaseAdRenderer", "stop: mIsStopped = " + this.tanxc_byte);
        if (this.tanxc_byte) {
            return;
        }
        this.tanxc_byte = true;
        tanxc_char();
    }

    public void tanxc_catch() {
        com.alimm.tanx.core.ad.bean.BidInfo bidInfo = this.tanxc_for;
        if (bidInfo != null) {
            if (android.text.TextUtils.isEmpty(bidInfo.getDeepLinkUrl()) && android.text.TextUtils.isEmpty(this.tanxc_for.getClickThroughUrl())) {
                tanxc_do(tanxc_goto(), 4);
                tanxc_do(tanxc_long(), 4);
            } else {
                tanxc_do(tanxc_goto(), 0);
                tanxc_do(tanxc_long(), 0);
            }
            if (android.text.TextUtils.isEmpty(this.tanxc_for.getAdvLogo())) {
                return;
            }
            tanxc_do(tanxc_void(), 0);
        }
    }

    public void tanxc_char() {
        com.alimm.tanx.core.utils.LogUtils.d("BaseAdRenderer", "dispose: type = " + this.tanxc_new + ", this = " + this);
        this.tanxc_catch = false;
        this.tanxc_goto.tanxc_new();
    }

    public void tanxc_do() {
        tanxc_if();
    }

    public void tanxc_do(int i) {
        tanxc_do(i, "");
    }

    public void tanxc_do(int i, java.lang.String str) {
        com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd iTanxSplashExpressAd = this.tanxc_long;
        if (iTanxSplashExpressAd != null) {
            com.alimm.tanx.core.ut.impl.TanxSplashUt.utSplashViewCreate(iTanxSplashExpressAd, iTanxSplashExpressAd.getFromType(), false, i, str);
        }
        tanxc_char();
        com.alimm.tanx.core.ad.ad.template.rendering.splash.IRenderCallback iRenderCallback = this.tanxc_char;
        if (iRenderCallback != null) {
            iRenderCallback.onAdShowError(i);
        }
    }

    public void tanxc_do(com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd iTanxSplashExpressAd) {
        this.tanxc_long = iTanxSplashExpressAd;
    }

    public void tanxc_do(com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener iTanxSplashInteractionListener) {
        this.tanxc_else = iTanxSplashInteractionListener;
        com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do tanxc_doVar = this.tanxc_goto;
        if (tanxc_doVar == null || !(tanxc_doVar instanceof com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_if)) {
            return;
        }
        ((com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_if) tanxc_doVar).tanxc_do(iTanxSplashInteractionListener);
    }

    public void tanxc_else() {
        if (this.tanxc_this) {
            return;
        }
        this.tanxc_this = true;
        com.alimm.tanx.core.ad.ad.template.rendering.splash.IRenderCallback iRenderCallback = this.tanxc_char;
        if (iRenderCallback != null) {
            iRenderCallback.onAdFinished(this.tanxc_new, this.tanxc_for, android.os.SystemClock.elapsedRealtime() - this.tanxc_try);
        }
    }

    public void tanxc_for() {
        com.alimm.tanx.core.utils.LogUtils.d("BaseAdRenderer", "tanx_splash: ======= onContentShowStart ======" + java.lang.System.currentTimeMillis());
        this.tanxc_catch = true;
        this.tanxc_goto.tanxc_do();
        com.alimm.tanx.core.ad.ad.template.rendering.splash.IRenderCallback iRenderCallback = this.tanxc_char;
        if (iRenderCallback != null) {
            iRenderCallback.onAdStarted(this.tanxc_new, this.tanxc_for);
        }
        com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd iTanxSplashExpressAd = this.tanxc_long;
        if (iTanxSplashExpressAd != null) {
            com.alimm.tanx.core.ut.impl.TanxSplashUt.utSplashViewCreate(iTanxSplashExpressAd, iTanxSplashExpressAd.getFromType(), true, 0);
        }
    }

    public android.view.View tanxc_goto() {
        com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do tanxc_doVar = this.tanxc_goto;
        if (tanxc_doVar != null) {
            return tanxc_doVar.tanxc_else();
        }
        return null;
    }

    public void tanxc_if() {
        com.alimm.tanx.core.utils.LogUtils.d("BaseAdRenderer", "doStart()");
    }

    public void tanxc_int() {
        this.tanxc_void = true;
        tanxc_class();
    }

    public android.view.View tanxc_long() {
        com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do tanxc_doVar = this.tanxc_goto;
        if (tanxc_doVar != null) {
            return tanxc_doVar.tanxc_char();
        }
        return null;
    }

    public void tanxc_new() {
        this.tanxc_break = true;
        tanxc_class();
    }

    public android.view.View tanxc_this() {
        com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do tanxc_doVar = this.tanxc_goto;
        if (tanxc_doVar != null) {
            return tanxc_doVar.tanxc_goto();
        }
        return null;
    }

    public void tanxc_try() {
        com.alimm.tanx.core.utils.LogUtils.d("BaseAdRenderer", "pause: timerPause = " + this.tanxc_case);
        if (this.tanxc_case) {
            return;
        }
        this.tanxc_goto.tanxc_for();
        this.tanxc_case = true;
    }

    public android.view.View tanxc_void() {
        com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do tanxc_doVar = this.tanxc_goto;
        if (tanxc_doVar != null) {
            return tanxc_doVar.tanxc_long();
        }
        return null;
    }
}
