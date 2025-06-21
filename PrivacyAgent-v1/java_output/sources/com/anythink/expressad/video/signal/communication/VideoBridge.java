package com.anythink.expressad.video.signal.communication;

/* loaded from: classes12.dex */
public class VideoBridge extends com.anythink.expressad.video.signal.communication.BaseVideoBridge {
    public static final /* synthetic */ int t = 0;
    private android.os.Handler j = new android.os.Handler(android.os.Looper.getMainLooper());

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass1(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.init(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$10, reason: invalid class name */
    public class AnonymousClass10 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass10(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.progressBarOperate(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$11, reason: invalid class name */
    public class AnonymousClass11 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass11(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.getCurrentProgress(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$12, reason: invalid class name */
    public class AnonymousClass12 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass12(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.showVideoClickView(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$13, reason: invalid class name */
    public class AnonymousClass13 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass13(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.setScaleFitXY(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$14, reason: invalid class name */
    public class AnonymousClass14 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass14(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.notifyCloseBtn(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$15, reason: invalid class name */
    public class AnonymousClass15 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass15(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.toggleCloseBtn(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$16, reason: invalid class name */
    public class AnonymousClass16 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass16(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.handlerH5Exception(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$17, reason: invalid class name */
    public class AnonymousClass17 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass17(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.isSystemResume(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$18, reason: invalid class name */
    public class AnonymousClass18 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass18(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.readyStatus(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$19, reason: invalid class name */
    public class AnonymousClass19 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass19(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.playVideoFinishOperate(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass2(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.click(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$20, reason: invalid class name */
    public class AnonymousClass20 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass20(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.openURL(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$21, reason: invalid class name */
    public class AnonymousClass21 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass21(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.cai(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$22, reason: invalid class name */
    public class AnonymousClass22 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass22(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.gial(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$23, reason: invalid class name */
    public class AnonymousClass23 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass23(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.showAlertView(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$24, reason: invalid class name */
    public class AnonymousClass24 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass24(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.closeWeb(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$25, reason: invalid class name */
    public class AnonymousClass25 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass25(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.getSDKInfo(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$26, reason: invalid class name */
    public class AnonymousClass26 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass26(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.getFileInfo(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$27, reason: invalid class name */
    public class AnonymousClass27 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass27(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.loadads(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$28, reason: invalid class name */
    public class AnonymousClass28 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass28(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.reactDeveloper(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$29, reason: invalid class name */
    public class AnonymousClass29 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass29(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.reportUrls(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass3(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.statistics(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$30, reason: invalid class name */
    public class AnonymousClass30 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass30(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.createWebview(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$31, reason: invalid class name */
    public class AnonymousClass31 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass31(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.createView(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$32, reason: invalid class name */
    public class AnonymousClass32 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass32(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.createPlayerView(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$33, reason: invalid class name */
    public class AnonymousClass33 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass33(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.createSubPlayTemplateView(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$34, reason: invalid class name */
    public class AnonymousClass34 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass34(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.destroyComponent(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$35, reason: invalid class name */
    public class AnonymousClass35 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass35(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.getComponentOptions(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$36, reason: invalid class name */
    public class AnonymousClass36 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass36(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.setViewRect(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$37, reason: invalid class name */
    public class AnonymousClass37 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass37(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.removeFromSuperView(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$38, reason: invalid class name */
    public class AnonymousClass38 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass38(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.appendSubView(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$39, reason: invalid class name */
    public class AnonymousClass39 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass39(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.appendViewTo(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass4(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.triggerCloseBtn(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$40, reason: invalid class name */
    public class AnonymousClass40 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass40(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.onlyAppendSubView(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$41, reason: invalid class name */
    public class AnonymousClass41 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass41(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.onlyAppendViewTo(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$42, reason: invalid class name */
    public class AnonymousClass42 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass42(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.bringViewToFront(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$43, reason: invalid class name */
    public class AnonymousClass43 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass43(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.hideView(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$44, reason: invalid class name */
    public class AnonymousClass44 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass44(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.showView(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$45, reason: invalid class name */
    public class AnonymousClass45 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass45(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.setViewBgColor(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$46, reason: invalid class name */
    public class AnonymousClass46 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass46(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.setViewAlpha(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$47, reason: invalid class name */
    public class AnonymousClass47 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass47(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.setViewScale(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$48, reason: invalid class name */
    public class AnonymousClass48 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass48(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.insertViewAbove(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$49, reason: invalid class name */
    public class AnonymousClass49 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass49(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.insertViewBelow(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass5(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.showVideoLocation(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$50, reason: invalid class name */
    public class AnonymousClass50 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass50(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.onlyInsertViewAbove(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$51, reason: invalid class name */
    public class AnonymousClass51 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass51(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.onlyInsertViewBelow(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$52, reason: invalid class name */
    public class AnonymousClass52 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass52(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.webviewLoad(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$53, reason: invalid class name */
    public class AnonymousClass53 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass53(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.webviewReload(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$54, reason: invalid class name */
    public class AnonymousClass54 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass54(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.webviewGoBack(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$55, reason: invalid class name */
    public class AnonymousClass55 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass55(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.webviewGoForward(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$56, reason: invalid class name */
    public class AnonymousClass56 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass56(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.playerPlay(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$57, reason: invalid class name */
    public class AnonymousClass57 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass57(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.playerPause(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$58, reason: invalid class name */
    public class AnonymousClass58 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass58(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.playerResume(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$59, reason: invalid class name */
    public class AnonymousClass59 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass59(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.playerStop(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass6(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.soundOperate(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$60, reason: invalid class name */
    public class AnonymousClass60 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass60(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.playerUpdateFrame(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$61, reason: invalid class name */
    public class AnonymousClass61 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass61(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.playerMute(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$62, reason: invalid class name */
    public class AnonymousClass62 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass62(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.playerUnmute(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$63, reason: invalid class name */
    public class AnonymousClass63 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass63(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.playerGetMuteState(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$64, reason: invalid class name */
    public class AnonymousClass64 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass64(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.playerSetSource(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$65, reason: invalid class name */
    public class AnonymousClass65 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass65(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.playerSetRenderType(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$66, reason: invalid class name */
    public class AnonymousClass66 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass66(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.preloadSubPlayTemplateView(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$67, reason: invalid class name */
    public class AnonymousClass67 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass67(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.closeAd(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$68, reason: invalid class name */
    public class AnonymousClass68 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass68(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.broadcast(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$69, reason: invalid class name */
    public class AnonymousClass69 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass69(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.ivRewardAdsWithoutVideo(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$7, reason: invalid class name */
    public class AnonymousClass7 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass7(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.videoOperate(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$70, reason: invalid class name */
    public class AnonymousClass70 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass70(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.setSubPlayTemplateInfo(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$71, reason: invalid class name */
    public class AnonymousClass71 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass71(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.webviewFireEvent(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$72, reason: invalid class name */
    public class AnonymousClass72 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass72(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.increaseOfferFrequence(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$73, reason: invalid class name */
    public class AnonymousClass73 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass73(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.handleNativeObject(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$74, reason: invalid class name */
    public class AnonymousClass74 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass74(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.loadingResourceStatus(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$75, reason: invalid class name */
    public class AnonymousClass75 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass75(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.createNativeEC(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$76, reason: invalid class name */
    public class AnonymousClass76 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass76(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.setCacheItem(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$77, reason: invalid class name */
    public class AnonymousClass77 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass77(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.removeCacheItem(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$78, reason: invalid class name */
    public class AnonymousClass78 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass78(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.getAllCache(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$79, reason: invalid class name */
    public class AnonymousClass79 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass79(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.clearAllCache(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$8, reason: invalid class name */
    public class AnonymousClass8 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass8(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.closeVideoOperte(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$80, reason: invalid class name */
    public class AnonymousClass80 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass80(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.getCutout(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$81, reason: invalid class name */
    public class AnonymousClass81 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass81(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.getAppSetting(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$82, reason: invalid class name */
    public class AnonymousClass82 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass82(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.getRewardSetting(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$83, reason: invalid class name */
    public class AnonymousClass83 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass83(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.getRewardUnitSetting(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$84, reason: invalid class name */
    public class AnonymousClass84 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass84(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.getUnitSetting(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$85, reason: invalid class name */
    public class AnonymousClass85 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass85(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.getEncryptPrice(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.VideoBridge$9, reason: invalid class name */
    public class AnonymousClass9 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass9(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.VideoBridge.super.progressOperate(this.a, this.b);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void appendSubView(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.appendSubView(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass38(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void appendViewTo(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.appendViewTo(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass39(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void bringViewToFront(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.bringViewToFront(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass42(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void broadcast(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.broadcast(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass68(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void cai(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.cai(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass21(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void clearAllCache(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.clearAllCache(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass79(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void click(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.click(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass2(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void closeAd(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.closeAd(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass67(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void closeVideoOperte(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.closeVideoOperte(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass8(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void closeWeb(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.closeWeb(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass24(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void createNativeEC(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.createNativeEC(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass75(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void createPlayerView(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.createPlayerView(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass32(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void createSubPlayTemplateView(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.createSubPlayTemplateView(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass33(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void createView(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.createView(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass31(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void createWebview(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.createWebview(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass30(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void destroyComponent(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.destroyComponent(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass34(obj, str));
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5
    public void feedbackLayoutOperate(java.lang.Object obj, java.lang.String str) {
        super.feedbackLayoutOperate(obj, str);
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5
    public void feedbackOperate(java.lang.Object obj, java.lang.String str) {
        super.feedbackOperate(obj, str);
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5
    public void feedbackPopupOperate(java.lang.Object obj, java.lang.String str) {
        super.feedbackPopupOperate(obj, str);
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getAllCache(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.getAllCache(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass78(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getAppSetting(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.getAppSetting(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass81(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getComponentOptions(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.getComponentOptions(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass35(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getCurrentProgress(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.getCurrentProgress(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass11(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getCutout(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.getCutout(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass80(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getEncryptPrice(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.getEncryptPrice(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass85(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getFileInfo(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.getFileInfo(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass26(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getRewardSetting(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.getRewardSetting(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass82(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getRewardUnitSetting(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.getRewardUnitSetting(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass83(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getSDKInfo(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.getSDKInfo(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass25(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getUnitSetting(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.getUnitSetting(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass84(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void gial(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.gial(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass22(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void handleNativeObject(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.handleNativeObject(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass73(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void handlerH5Exception(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.handlerH5Exception(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass16(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void hideView(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.hideView(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass43(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void increaseOfferFrequence(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.increaseOfferFrequence(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass72(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void init(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.init(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass1(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void insertViewAbove(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.insertViewAbove(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass48(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void insertViewBelow(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.insertViewBelow(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass49(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void isSystemResume(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.isSystemResume(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass17(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void ivRewardAdsWithoutVideo(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.ivRewardAdsWithoutVideo(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass69(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void loadads(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.loadads(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass27(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void loadingResourceStatus(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.loadingResourceStatus(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass74(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void notifyCloseBtn(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.notifyCloseBtn(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass14(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void onlyAppendSubView(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.onlyAppendSubView(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass40(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void onlyAppendViewTo(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.onlyAppendViewTo(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass41(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void onlyInsertViewAbove(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.onlyInsertViewAbove(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass50(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void onlyInsertViewBelow(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.onlyInsertViewBelow(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass51(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void openURL(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.openURL(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass20(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playVideoFinishOperate(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.playVideoFinishOperate(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass19(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerGetMuteState(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.playerGetMuteState(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass63(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerMute(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.playerMute(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass61(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerPause(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.playerPause(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass57(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerPlay(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.playerPlay(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass56(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerResume(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.playerResume(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass58(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerSetRenderType(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.playerSetRenderType(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass65(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerSetSource(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.playerSetSource(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass64(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerStop(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.playerStop(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass59(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerUnmute(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.playerUnmute(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass62(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerUpdateFrame(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.playerUpdateFrame(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass60(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void preloadSubPlayTemplateView(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.preloadSubPlayTemplateView(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass66(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void progressBarOperate(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.progressBarOperate(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass10(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void progressOperate(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.progressOperate(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass9(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void reactDeveloper(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.reactDeveloper(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass28(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void readyStatus(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.readyStatus(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass18(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void removeCacheItem(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.removeCacheItem(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass77(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void removeFromSuperView(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.removeFromSuperView(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass37(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void reportUrls(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.reportUrls(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass29(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void setCacheItem(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.setCacheItem(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass76(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void setScaleFitXY(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.setScaleFitXY(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass13(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void setSubPlayTemplateInfo(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.setSubPlayTemplateInfo(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass70(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void setViewAlpha(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.setViewAlpha(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass46(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void setViewBgColor(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.setViewBgColor(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass45(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void setViewRect(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.setViewRect(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass36(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void setViewScale(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.setViewScale(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass47(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void showAlertView(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.showAlertView(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass23(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void showVideoClickView(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.showVideoClickView(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass12(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void showVideoLocation(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.showVideoLocation(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass5(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void showView(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.showView(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass44(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void soundOperate(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.soundOperate(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass6(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void statistics(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.statistics(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass3(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void toggleCloseBtn(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.toggleCloseBtn(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass15(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void triggerCloseBtn(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.triggerCloseBtn(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass4(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void videoOperate(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.videoOperate(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass7(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void webviewFireEvent(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.webviewFireEvent(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass71(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void webviewGoBack(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.webviewGoBack(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass54(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void webviewGoForward(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.webviewGoForward(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass55(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void webviewLoad(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.webviewLoad(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass52(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseVideoBridge, com.anythink.expressad.video.signal.communication.IVideoBridge
    public void webviewReload(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.webviewReload(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.VideoBridge.AnonymousClass53(obj, str));
        }
    }
}
