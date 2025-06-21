package com.anythink.expressad.video.signal.communication;

/* loaded from: classes12.dex */
public class RewardJs extends com.anythink.expressad.video.signal.communication.BaseRewardJs {
    public static final /* synthetic */ int t = 0;
    private android.os.Handler j = new android.os.Handler(android.os.Looper.getMainLooper());

    /* renamed from: com.anythink.expressad.video.signal.communication.RewardJs$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass1(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.RewardJs.super.getEndScreenInfo(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.RewardJs$10, reason: invalid class name */
    public class AnonymousClass10 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass10(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.RewardJs.super.gial(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.RewardJs$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass2(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.RewardJs.super.install(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.RewardJs$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass3(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.RewardJs.super.notifyCloseBtn(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.RewardJs$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass4(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.RewardJs.super.toggleCloseBtn(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.RewardJs$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass5(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.RewardJs.super.getEndScreenInfo(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.RewardJs$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass6(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.RewardJs.super.setOrientation(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.RewardJs$7, reason: invalid class name */
    public class AnonymousClass7 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass7(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.RewardJs.super.handlerPlayableException(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.RewardJs$8, reason: invalid class name */
    public class AnonymousClass8 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass8(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.RewardJs.super.openURL(this.a, this.b);
        }
    }

    /* renamed from: com.anythink.expressad.video.signal.communication.RewardJs$9, reason: invalid class name */
    public class AnonymousClass9 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass9(java.lang.Object obj, java.lang.String str) {
            this.a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.video.signal.communication.RewardJs.super.cai(this.a, this.b);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseRewardJs, com.anythink.expressad.video.signal.communication.IRewardBridge
    public void cai(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.cai(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.RewardJs.AnonymousClass9(obj, str));
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

    @Override // com.anythink.expressad.video.signal.communication.BaseRewardJs, com.anythink.expressad.video.signal.communication.IRewardBridge
    public void getEndScreenInfo(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.getEndScreenInfo(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.RewardJs.AnonymousClass1(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseRewardJs, com.anythink.expressad.video.signal.communication.IRewardBridge
    public void gial(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.gial(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.RewardJs.AnonymousClass10(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseRewardJs, com.anythink.expressad.video.signal.communication.IRewardBridge
    public void handlerPlayableException(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.handlerPlayableException(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.RewardJs.AnonymousClass7(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseRewardJs, com.anythink.expressad.video.signal.communication.IRewardBridge
    public void install(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.install(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.RewardJs.AnonymousClass2(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseRewardJs, com.anythink.expressad.video.signal.communication.IRewardBridge
    public void notifyCloseBtn(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.notifyCloseBtn(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.RewardJs.AnonymousClass3(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseRewardJs, com.anythink.expressad.video.signal.communication.IRewardBridge
    public void openURL(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.openURL(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.RewardJs.AnonymousClass8(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseRewardJs, com.anythink.expressad.video.signal.communication.IRewardBridge
    public void setOrientation(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.setOrientation(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.RewardJs.AnonymousClass6(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseRewardJs, com.anythink.expressad.video.signal.communication.IRewardBridge
    public void toggleCloseBtn(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.toggleCloseBtn(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.RewardJs.AnonymousClass4(obj, str));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.BaseRewardJs, com.anythink.expressad.video.signal.communication.IRewardBridge
    public void triggerCloseBtn(java.lang.Object obj, java.lang.String str) {
        if (com.anythink.expressad.foundation.h.t.b()) {
            super.triggerCloseBtn(obj, str);
        } else {
            this.j.post(new com.anythink.expressad.video.signal.communication.RewardJs.AnonymousClass5(obj, str));
        }
    }
}
