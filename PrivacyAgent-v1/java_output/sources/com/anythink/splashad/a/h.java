package com.anythink.splashad.a;

/* loaded from: classes12.dex */
public final class h implements com.anythink.splashad.unitgroup.api.CustomSplashEventListener {
    com.anythink.splashad.unitgroup.api.CustomSplashAdapter a;
    com.anythink.splashad.a.a b;
    long c;
    private java.util.Timer d;
    private boolean e = false;
    private int f = 0;

    /* renamed from: com.anythink.splashad.a.h$1, reason: invalid class name */
    public class AnonymousClass1 extends java.util.TimerTask {
        final /* synthetic */ android.view.ViewGroup a;
        final /* synthetic */ com.anythink.core.common.o.a.f.b b;
        final /* synthetic */ com.anythink.splashad.api.ATSplashSkipAdListener c;
        final /* synthetic */ long d;
        final /* synthetic */ long e;

        /* renamed from: com.anythink.splashad.a.h$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC02451 implements java.lang.Runnable {
            public RunnableC02451() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.splashad.a.h.AnonymousClass1 anonymousClass1 = com.anythink.splashad.a.h.AnonymousClass1.this;
                com.anythink.splashad.a.h hVar = com.anythink.splashad.a.h.this;
                long j = hVar.c;
                if (j <= 0) {
                    hVar.a(3);
                    com.anythink.splashad.a.h.this.onSplashAdDismiss();
                } else {
                    com.anythink.splashad.api.ATSplashSkipAdListener aTSplashSkipAdListener = anonymousClass1.c;
                    if (aTSplashSkipAdListener != null) {
                        aTSplashSkipAdListener.onAdTick(anonymousClass1.d, j);
                    }
                }
                com.anythink.splashad.a.h.AnonymousClass1 anonymousClass12 = com.anythink.splashad.a.h.AnonymousClass1.this;
                com.anythink.splashad.a.h.this.c -= anonymousClass12.e;
            }
        }

        public AnonymousClass1(android.view.ViewGroup viewGroup, com.anythink.core.common.o.a.f.b bVar, com.anythink.splashad.api.ATSplashSkipAdListener aTSplashSkipAdListener, long j, long j2) {
            this.a = viewGroup;
            this.b = bVar;
            this.c = aTSplashSkipAdListener;
            this.d = j;
            this.e = j2;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            android.view.ViewGroup viewGroup = this.a;
            if (viewGroup == null || com.anythink.core.common.o.w.a(viewGroup, this.b)) {
                com.anythink.core.common.b.o.a().b(new com.anythink.splashad.a.h.AnonymousClass1.RunnableC02451());
            }
        }
    }

    /* renamed from: com.anythink.splashad.a.h$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.splashad.api.ATSplashSkipAdListener a;
        final /* synthetic */ long b;
        final /* synthetic */ long c;

        public AnonymousClass2(com.anythink.splashad.api.ATSplashSkipAdListener aTSplashSkipAdListener, long j, long j2) {
            this.a = aTSplashSkipAdListener;
            this.b = j;
            this.c = j2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.splashad.api.ATSplashSkipAdListener aTSplashSkipAdListener = this.a;
            if (aTSplashSkipAdListener != null) {
                aTSplashSkipAdListener.onAdTick(this.b, com.anythink.splashad.a.h.this.c);
                com.anythink.splashad.a.h.this.c -= this.c;
            }
        }
    }

    public h(com.anythink.splashad.unitgroup.api.CustomSplashAdapter customSplashAdapter, com.anythink.splashad.a.a aVar) {
        this.a = customSplashAdapter;
        this.b = aVar;
    }

    private void a() {
        java.util.Timer timer = this.d;
        if (timer != null) {
            timer.cancel();
            this.d = null;
        }
    }

    private void a(com.anythink.splashad.api.ATSplashSkipInfo aTSplashSkipInfo) {
        if (this.d == null) {
            long callbackInterval = aTSplashSkipInfo.getCallbackInterval();
            long countDownDuration = aTSplashSkipInfo.getCountDownDuration();
            android.view.ViewGroup container = aTSplashSkipInfo.getContainer();
            com.anythink.core.common.o.a.f.b bVar = new com.anythink.core.common.o.a.f.b();
            com.anythink.splashad.api.ATSplashSkipAdListener aTSplashSkipAdListener = aTSplashSkipInfo.getATSplashSkipAdListener();
            this.c = countDownDuration;
            java.util.Timer timer = new java.util.Timer();
            this.d = timer;
            timer.schedule(new com.anythink.splashad.a.h.AnonymousClass1(container, bVar, aTSplashSkipAdListener, countDownDuration, callbackInterval), callbackInterval, callbackInterval);
            com.anythink.core.common.b.o.a().b(new com.anythink.splashad.a.h.AnonymousClass2(aTSplashSkipAdListener, countDownDuration, callbackInterval));
        }
    }

    private static void a(java.lang.String str) {
        com.anythink.core.common.f.e c;
        if (android.text.TextUtils.isEmpty(str) || (c = com.anythink.core.common.u.a().c(str)) == null) {
            return;
        }
        com.anythink.core.common.u.a().d(str);
        com.anythink.core.common.f.a(com.anythink.core.common.b.o.a().f(), str, "4").c(com.anythink.core.common.u.a().b(str, c.a()));
    }

    public final void a(int i) {
        this.f = i;
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
    public final void onDeeplinkCallback(boolean z) {
        com.anythink.splashad.a.a aVar = this.b;
        if (aVar != null) {
            aVar.onDeeplinkCallback(com.anythink.core.common.b.k.a(this.a), z);
        }
        com.anythink.splashad.unitgroup.api.CustomSplashAdapter customSplashAdapter = this.a;
        if (customSplashAdapter != null) {
            com.anythink.core.common.o.o.a(customSplashAdapter.getTrackingInfo(), com.anythink.core.common.b.h.m.i, z ? com.anythink.core.common.b.h.m.l : com.anythink.core.common.b.h.m.m, "");
        }
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
    public final void onDownloadConfirm(android.content.Context context, com.anythink.core.api.ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        com.anythink.splashad.a.a aVar = this.b;
        if (aVar != null) {
            aVar.onDownloadConfirm(context, com.anythink.core.common.b.k.a(this.a), aTNetworkConfirmInfo);
        }
        com.anythink.splashad.unitgroup.api.CustomSplashAdapter customSplashAdapter = this.a;
        if (customSplashAdapter != null) {
            com.anythink.core.common.o.o.a(customSplashAdapter.getTrackingInfo(), com.anythink.core.common.b.h.m.j, com.anythink.core.common.b.h.m.l, "");
        }
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
    public final void onSplashAdClicked() {
        com.anythink.splashad.unitgroup.api.CustomSplashAdapter customSplashAdapter = this.a;
        if (customSplashAdapter != null) {
            com.anythink.core.common.f.h trackingInfo = customSplashAdapter.getTrackingInfo();
            com.anythink.core.common.n.a.a(com.anythink.core.common.b.o.a().f()).a(6, trackingInfo);
            com.anythink.core.common.o.o.a(trackingInfo, com.anythink.core.common.b.h.m.d, com.anythink.core.common.b.h.m.l, "");
        }
        com.anythink.splashad.a.a aVar = this.b;
        if (aVar != null) {
            aVar.onAdClick(com.anythink.core.common.b.k.a(this.a));
        }
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
    public final void onSplashAdDismiss() {
        com.anythink.core.common.f.e c;
        java.util.Timer timer = this.d;
        if (timer != null) {
            timer.cancel();
        }
        com.anythink.splashad.unitgroup.api.CustomSplashAdapter customSplashAdapter = this.a;
        if (customSplashAdapter != null) {
            com.anythink.core.common.f.h trackingInfo = customSplashAdapter.getTrackingInfo();
            int i = this.f;
            if (i != 0) {
                trackingInfo.D(i);
            } else {
                i = this.a.getDismissType();
                if (i == 0) {
                    i = 1;
                }
                trackingInfo.D(i);
            }
            com.anythink.core.common.n.c.a(trackingInfo, false);
            com.anythink.splashad.api.ATSplashSkipInfo splashSkipInfo = this.a.getSplashSkipInfo();
            if (splashSkipInfo != null && splashSkipInfo.canUseCustomSkipView()) {
                this.a.startSplashCustomSkipViewClickEye();
                java.util.Timer timer2 = this.d;
                if (timer2 != null) {
                    timer2.cancel();
                    this.d = null;
                }
                splashSkipInfo.destroy();
                this.a.setSplashSkipInfo(null);
            }
            com.anythink.core.common.o.o.a(trackingInfo, com.anythink.core.common.b.h.m.e, com.anythink.core.common.b.h.m.l, "");
            java.lang.String ac = trackingInfo.ac();
            if (!android.text.TextUtils.isEmpty(ac) && (c = com.anythink.core.common.u.a().c(ac)) != null) {
                com.anythink.core.common.u.a().d(ac);
                com.anythink.core.common.f.a(com.anythink.core.common.b.o.a().f(), ac, "4").c(com.anythink.core.common.u.a().b(ac, c.a()));
            }
            com.anythink.splashad.unitgroup.api.CustomSplashAdapter customSplashAdapter2 = this.a;
            com.anythink.splashad.api.IATSplashEyeAd splashEyeAd = customSplashAdapter2 instanceof com.anythink.splashad.unitgroup.api.CustomSplashAdapter ? customSplashAdapter2.getSplashEyeAd() : null;
            com.anythink.splashad.a.a aVar = this.b;
            if (aVar != null && !this.e) {
                this.e = true;
                aVar.onCallbackAdDismiss(com.anythink.core.common.b.k.a(trackingInfo, this.a), new com.anythink.splashad.api.ATSplashAdExtraInfo(i, splashEyeAd));
            }
            if (splashEyeAd == null) {
                com.anythink.splashad.unitgroup.api.CustomSplashAdapter customSplashAdapter3 = this.a;
                if (customSplashAdapter3 != null) {
                    customSplashAdapter3.cleanImpressionListener();
                }
                com.anythink.splashad.unitgroup.api.CustomSplashAdapter customSplashAdapter4 = this.a;
                if (customSplashAdapter4 != null) {
                    customSplashAdapter4.internalDestory();
                }
            }
        }
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
    public final void onSplashAdShow() {
        com.anythink.core.common.b.k a = com.anythink.core.common.b.k.a(this.a);
        com.anythink.splashad.unitgroup.api.CustomSplashAdapter customSplashAdapter = this.a;
        if (customSplashAdapter != null) {
            com.anythink.core.common.f.h trackingInfo = customSplashAdapter.getTrackingInfo();
            trackingInfo.a(this.a.getNetworkInfoMap());
            com.anythink.core.common.n.a.a(com.anythink.core.common.b.o.a().f()).a(4, trackingInfo, this.a.getUnitGroupInfo());
            com.anythink.core.common.o.o.a(trackingInfo, com.anythink.core.common.b.h.m.c, com.anythink.core.common.b.h.m.l, "");
            com.anythink.splashad.api.ATSplashSkipInfo splashSkipInfo = this.a.getSplashSkipInfo();
            if (splashSkipInfo != null && splashSkipInfo.canUseCustomSkipView() && this.a.isSupportCustomSkipView() && this.d == null) {
                long callbackInterval = splashSkipInfo.getCallbackInterval();
                long countDownDuration = splashSkipInfo.getCountDownDuration();
                android.view.ViewGroup container = splashSkipInfo.getContainer();
                com.anythink.core.common.o.a.f.b bVar = new com.anythink.core.common.o.a.f.b();
                com.anythink.splashad.api.ATSplashSkipAdListener aTSplashSkipAdListener = splashSkipInfo.getATSplashSkipAdListener();
                this.c = countDownDuration;
                java.util.Timer timer = new java.util.Timer();
                this.d = timer;
                timer.schedule(new com.anythink.splashad.a.h.AnonymousClass1(container, bVar, aTSplashSkipAdListener, countDownDuration, callbackInterval), callbackInterval, callbackInterval);
                com.anythink.core.common.b.o.a().b(new com.anythink.splashad.a.h.AnonymousClass2(aTSplashSkipAdListener, countDownDuration, callbackInterval));
            }
            com.anythink.core.common.u.a().a(trackingInfo.ac(), a);
        }
        if (this.b != null) {
            if (a.getNetworkFirmId() == -1) {
                com.anythink.core.common.n.e.a(com.anythink.core.common.b.h.i.e, this.a, null);
            }
            this.b.onAdShow(a);
        }
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
    public final void onSplashAdShowFail(com.anythink.core.api.AdError adError) {
        com.anythink.splashad.unitgroup.api.CustomSplashAdapter customSplashAdapter = this.a;
        if (customSplashAdapter != null) {
            com.anythink.core.common.f.h trackingInfo = customSplashAdapter.getTrackingInfo();
            com.anythink.core.common.n.c.a(trackingInfo, adError, this.a.getNetworkInfoMap());
            com.anythink.core.common.o.o.a(trackingInfo, com.anythink.core.common.b.h.m.k, com.anythink.core.common.b.h.m.m, adError != null ? adError.getFullErrorInfo() : "");
        }
    }
}
