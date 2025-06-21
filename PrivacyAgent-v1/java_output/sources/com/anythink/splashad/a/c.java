package com.anythink.splashad.a;

/* loaded from: classes12.dex */
public class c {
    private static java.util.Map<java.lang.String, com.anythink.splashad.a.c> e = new java.util.concurrent.ConcurrentHashMap(3);
    private final com.anythink.splashad.a.e a;
    private android.content.Context b;
    private java.lang.String c;
    private com.anythink.core.common.f d;

    /* renamed from: com.anythink.splashad.a.c$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.common.f.b a;
        final /* synthetic */ android.app.Activity b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ java.util.Map d;
        final /* synthetic */ com.anythink.core.api.ATEventInterface e;
        final /* synthetic */ com.anythink.splashad.api.ATSplashSkipInfo f;
        final /* synthetic */ android.view.ViewGroup g;
        final /* synthetic */ com.anythink.splashad.a.a h;
        final /* synthetic */ long i;

        /* renamed from: com.anythink.splashad.a.c$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC02431 implements java.lang.Runnable {
            final /* synthetic */ com.anythink.splashad.unitgroup.api.CustomSplashAdapter a;
            final /* synthetic */ com.anythink.core.common.f.h b;

            /* renamed from: com.anythink.splashad.a.c$1$1$1, reason: invalid class name and collision with other inner class name */
            public class ViewOnClickListenerC02441 implements android.view.View.OnClickListener {
                final /* synthetic */ com.anythink.splashad.a.h a;

                public ViewOnClickListenerC02441(com.anythink.splashad.a.h hVar) {
                    this.a = hVar;
                }

                @Override // android.view.View.OnClickListener
                @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
                public final void onClick(android.view.View view) {
                    com.anythink.splashad.a.h hVar = this.a;
                    if (hVar != null) {
                        hVar.a(2);
                        this.a.onSplashAdDismiss();
                    }
                    com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            }

            public RunnableC02431(com.anythink.splashad.unitgroup.api.CustomSplashAdapter customSplashAdapter, com.anythink.core.common.f.h hVar) {
                this.a = customSplashAdapter;
                this.b = hVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.core.api.IExHandler b = com.anythink.core.common.b.o.a().b();
                if (b != null) {
                    com.anythink.splashad.unitgroup.api.CustomSplashAdapter customSplashAdapter = this.a;
                    customSplashAdapter.setAdDownloadListener(b.createDownloadListener(customSplashAdapter, null, com.anythink.splashad.a.c.AnonymousClass1.this.e));
                }
                com.anythink.splashad.api.ATSplashSkipInfo aTSplashSkipInfo = com.anythink.splashad.a.c.AnonymousClass1.this.f;
                boolean z = aTSplashSkipInfo != null && aTSplashSkipInfo.canUseCustomSkipView();
                boolean isSupportCustomSkipView = this.a.isSupportCustomSkipView();
                if (z && isSupportCustomSkipView) {
                    com.anythink.splashad.a.c.AnonymousClass1 anonymousClass1 = com.anythink.splashad.a.c.AnonymousClass1.this;
                    anonymousClass1.f.setContainer(anonymousClass1.g);
                    this.a.setSplashSkipInfo(com.anythink.splashad.a.c.AnonymousClass1.this.f);
                }
                com.anythink.splashad.a.h hVar = new com.anythink.splashad.a.h(this.a, com.anythink.splashad.a.c.AnonymousClass1.this.h);
                if (this.a.getMixedFormatAdType() == 0) {
                    com.anythink.splashad.a.c.AnonymousClass1 anonymousClass12 = com.anythink.splashad.a.c.AnonymousClass1.this;
                    com.anythink.splashad.a.c.a(com.anythink.splashad.a.c.this, anonymousClass12.b, anonymousClass12.g, hVar, z, anonymousClass12.a.e(), this.b);
                } else {
                    com.anythink.splashad.unitgroup.api.CustomSplashAdapter customSplashAdapter2 = this.a;
                    com.anythink.splashad.a.c.AnonymousClass1 anonymousClass13 = com.anythink.splashad.a.c.AnonymousClass1.this;
                    customSplashAdapter2.internalShow(anonymousClass13.b, anonymousClass13.g, new com.anythink.splashad.a.g(hVar));
                }
                com.anythink.core.common.f.h trackingInfo = this.a.getTrackingInfo();
                com.anythink.core.common.n.c.a("4", trackingInfo.ad(), trackingInfo.ac(), trackingInfo.C(), trackingInfo.M(), 4, android.os.SystemClock.elapsedRealtime() - com.anythink.splashad.a.c.AnonymousClass1.this.i);
                if (!z) {
                    com.anythink.splashad.api.ATSplashSkipInfo aTSplashSkipInfo2 = com.anythink.splashad.a.c.AnonymousClass1.this.f;
                    return;
                }
                com.anythink.splashad.api.ATSplashSkipAdListener aTSplashSkipAdListener = com.anythink.splashad.a.c.AnonymousClass1.this.f.getATSplashSkipAdListener();
                if (aTSplashSkipAdListener != null) {
                    aTSplashSkipAdListener.isSupportCustomSkipView(isSupportCustomSkipView);
                }
                if (isSupportCustomSkipView) {
                    com.anythink.splashad.a.c.AnonymousClass1.this.f.getSkipView().setOnClickListener(new com.anythink.splashad.a.c.AnonymousClass1.RunnableC02431.ViewOnClickListenerC02441(hVar));
                }
            }
        }

        public AnonymousClass1(com.anythink.core.common.f.b bVar, android.app.Activity activity, java.lang.String str, java.util.Map map, com.anythink.core.api.ATEventInterface aTEventInterface, com.anythink.splashad.api.ATSplashSkipInfo aTSplashSkipInfo, android.view.ViewGroup viewGroup, com.anythink.splashad.a.a aVar, long j) {
            this.a = bVar;
            this.b = activity;
            this.c = str;
            this.d = map;
            this.e = aTEventInterface;
            this.f = aTSplashSkipInfo;
            this.g = viewGroup;
            this.h = aVar;
            this.i = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.splashad.unitgroup.api.CustomSplashAdapter customSplashAdapter = (com.anythink.splashad.unitgroup.api.CustomSplashAdapter) this.a.d();
            android.app.Activity activity = this.b;
            if (activity != null) {
                customSplashAdapter.refreshActivityContext(activity);
            }
            com.anythink.core.common.f.h trackingInfo = this.a.d().getTrackingInfo();
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            if (trackingInfo != null) {
                trackingInfo.B = this.c;
                trackingInfo.h(com.anythink.core.common.o.h.a(trackingInfo.ad(), trackingInfo.C(), currentTimeMillis));
                com.anythink.core.common.o.u.a(com.anythink.splashad.a.c.this.b, trackingInfo);
                com.anythink.core.common.o.u.a((java.util.Map<java.lang.String, java.lang.Object>) this.d, trackingInfo);
                com.anythink.core.common.o.u.a(com.anythink.splashad.a.c.this.c, trackingInfo);
            }
            com.anythink.core.common.a.a().a(com.anythink.splashad.a.c.this.b, this.a);
            com.anythink.core.common.n.a.a(com.anythink.splashad.a.c.this.b).a(13, trackingInfo, customSplashAdapter.getUnitGroupInfo(), currentTimeMillis);
            com.anythink.core.common.b.o.a().b(new com.anythink.splashad.a.c.AnonymousClass1.RunnableC02431(customSplashAdapter, trackingInfo));
        }
    }

    /* renamed from: com.anythink.splashad.a.c$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.core.common.b.m {
        final /* synthetic */ boolean[] a;
        final /* synthetic */ com.anythink.splashad.a.h b;

        public AnonymousClass2(boolean[] zArr, com.anythink.splashad.a.h hVar) {
            this.a = zArr;
            this.b = hVar;
        }

        @Override // com.anythink.core.common.b.m
        public final void onAdClicked(android.view.View view) {
            this.b.onSplashAdClicked();
        }

        @Override // com.anythink.core.common.b.m
        public final void onAdDislikeButtonClick() {
        }

        @Override // com.anythink.core.common.b.m
        public final void onAdImpressed() {
            boolean[] zArr = this.a;
            if (zArr[0]) {
                return;
            }
            zArr[0] = true;
            this.b.onSplashAdShow();
        }

        @Override // com.anythink.core.common.b.m
        public final void onAdVideoEnd() {
        }

        @Override // com.anythink.core.common.b.m
        public final void onAdVideoProgress(int i) {
        }

        @Override // com.anythink.core.common.b.m
        public final void onAdVideoStart() {
        }

        @Override // com.anythink.core.common.b.m
        public final void onDeeplinkCallback(boolean z) {
            this.b.onDeeplinkCallback(z);
        }

        @Override // com.anythink.core.common.b.m
        public final void onDownloadConfirmCallback(android.content.Context context, android.view.View view, com.anythink.core.api.ATNetworkConfirmInfo aTNetworkConfirmInfo) {
            this.b.onDownloadConfirm(context, aTNetworkConfirmInfo);
        }
    }

    /* renamed from: com.anythink.splashad.a.c$3, reason: invalid class name */
    public class AnonymousClass3 implements com.anythink.basead.e.a {
        final /* synthetic */ com.anythink.splashad.a.h a;
        final /* synthetic */ com.anythink.core.api.BaseAd b;
        final /* synthetic */ android.view.ViewGroup c;

        public AnonymousClass3(com.anythink.splashad.a.h hVar, com.anythink.core.api.BaseAd baseAd, android.view.ViewGroup viewGroup) {
            this.a = hVar;
            this.b = baseAd;
            this.c = viewGroup;
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClick(com.anythink.basead.e.i iVar) {
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClosed() {
            this.a.onSplashAdDismiss();
            com.anythink.core.api.BaseAd baseAd = this.b;
            if (baseAd != null) {
                baseAd.clear(this.c);
                this.b.destroy();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onAdShow(com.anythink.basead.e.i iVar) {
        }

        @Override // com.anythink.basead.e.a
        public final void onDeeplinkCallback(boolean z) {
        }

        @Override // com.anythink.basead.e.a
        public final void onShowFailed(com.anythink.basead.c.e eVar) {
        }
    }

    private c(android.content.Context context, java.lang.String str) {
        this.b = context.getApplicationContext();
        this.c = str;
        com.anythink.core.common.f a = com.anythink.core.common.f.a(context, str, "4");
        this.d = a;
        a.a(new com.anythink.splashad.a.d());
        com.anythink.splashad.a.e eVar = new com.anythink.splashad.a.e();
        this.a = eVar;
        this.d.a(eVar);
    }

    public static com.anythink.splashad.a.c a(android.content.Context context, java.lang.String str) {
        com.anythink.splashad.a.c cVar = e.get(str);
        if (cVar == null) {
            synchronized (com.anythink.splashad.a.c.class) {
                if (cVar == null) {
                    cVar = new com.anythink.splashad.a.c(context, str);
                    e.put(str, cVar);
                }
            }
        }
        return cVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(android.app.Activity activity, android.view.ViewGroup viewGroup, com.anythink.splashad.a.h hVar, boolean z, com.anythink.core.api.BaseAd baseAd, com.anythink.core.common.f.h hVar2) {
        if (baseAd == 0 || !(baseAd instanceof com.anythink.core.common.f.a.e)) {
            if (hVar != null) {
                hVar.a(99);
                hVar.onSplashAdShowFail(com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.adShowError, "", "showThirdPartyNativeSplash fail,AdCache return illegal type adObject"));
                hVar.onSplashAdDismiss();
                return;
            }
            return;
        }
        com.anythink.core.common.f.a.b bVar = new com.anythink.core.common.f.a.b((com.anythink.core.common.f.a.e) baseAd);
        com.anythink.core.common.f.a.c cVar = new com.anythink.core.common.f.a.c((com.anythink.core.common.f.a.a) baseAd, hVar2, java.lang.Integer.parseInt("4"));
        java.lang.String a = com.anythink.core.common.f.a(cVar);
        baseAd.setNativeEventListener(new com.anythink.splashad.a.c.AnonymousClass2(new boolean[]{false}, hVar));
        com.anythink.basead.d.i.a().a(a, baseAd);
        com.anythink.basead.ui.ThirdPartySplashATView thirdPartySplashATView = new com.anythink.basead.ui.ThirdPartySplashATView(activity.getApplicationContext(), cVar, bVar, new com.anythink.splashad.a.c.AnonymousClass3(hVar, baseAd, viewGroup), a);
        thirdPartySplashATView.setDontCountDown(z);
        android.view.ViewGroup customAdContainer = baseAd.getCustomAdContainer();
        if (customAdContainer != null) {
            com.anythink.core.common.o.w.a(customAdContainer);
            customAdContainer.addView(thirdPartySplashATView);
        } else {
            customAdContainer = thirdPartySplashATView;
        }
        thirdPartySplashATView.registerNativeClickListener(viewGroup);
        viewGroup.addView(customAdContainer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void a(com.anythink.splashad.a.c cVar, android.app.Activity activity, android.view.ViewGroup viewGroup, com.anythink.splashad.a.h hVar, boolean z, com.anythink.core.api.BaseAd baseAd, com.anythink.core.common.f.h hVar2) {
        if (baseAd == 0 || !(baseAd instanceof com.anythink.core.common.f.a.e)) {
            hVar.a(99);
            hVar.onSplashAdShowFail(com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.adShowError, "", "showThirdPartyNativeSplash fail,AdCache return illegal type adObject"));
            hVar.onSplashAdDismiss();
            return;
        }
        com.anythink.core.common.f.a.b bVar = new com.anythink.core.common.f.a.b((com.anythink.core.common.f.a.e) baseAd);
        com.anythink.core.common.f.a.c cVar2 = new com.anythink.core.common.f.a.c((com.anythink.core.common.f.a.a) baseAd, hVar2, java.lang.Integer.parseInt("4"));
        java.lang.String a = com.anythink.core.common.f.a(cVar2);
        baseAd.setNativeEventListener(cVar.new AnonymousClass2(new boolean[]{false}, hVar));
        com.anythink.basead.d.i.a().a(a, baseAd);
        com.anythink.basead.ui.ThirdPartySplashATView thirdPartySplashATView = new com.anythink.basead.ui.ThirdPartySplashATView(activity.getApplicationContext(), cVar2, bVar, cVar.new AnonymousClass3(hVar, baseAd, viewGroup), a);
        thirdPartySplashATView.setDontCountDown(z);
        android.view.ViewGroup customAdContainer = baseAd.getCustomAdContainer();
        if (customAdContainer != null) {
            com.anythink.core.common.o.w.a(customAdContainer);
            customAdContainer.addView(thirdPartySplashATView);
        } else {
            customAdContainer = thirdPartySplashATView;
        }
        thirdPartySplashATView.registerNativeClickListener(viewGroup);
        viewGroup.addView(customAdContainer);
    }

    public final com.anythink.core.api.ATAdStatusInfo a(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map) {
        return this.d.a(context, map);
    }

    public final com.anythink.core.common.g a(java.lang.String str) {
        return this.d.b(str);
    }

    public final java.util.List<com.anythink.core.api.ATAdInfo> a(android.content.Context context) {
        return this.d.b(context);
    }

    public final synchronized void a(android.app.Activity activity, android.view.ViewGroup viewGroup, com.anythink.splashad.a.a aVar, com.anythink.core.api.ATEventInterface aTEventInterface, com.anythink.splashad.api.ATSplashSkipInfo aTSplashSkipInfo, java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        com.anythink.splashad.a.f fVar;
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        com.anythink.core.common.f.b a = this.d.a((android.content.Context) activity, false, true, map);
        if (a == null) {
            return;
        }
        if (a.d() instanceof com.anythink.splashad.unitgroup.api.CustomSplashAdapter) {
            this.d.a(a);
            a.a(a.c() + 1);
            com.anythink.splashad.a.e eVar = this.a;
            if (eVar != null && (fVar = eVar.a) != null && fVar.d == a) {
                fVar.d = null;
            }
            com.anythink.core.common.o.b.b.a().a(new com.anythink.splashad.a.c.AnonymousClass1(a, activity, str, map, aTEventInterface, aTSplashSkipInfo, viewGroup, aVar, elapsedRealtime));
        }
    }

    public final void a(android.content.Context context, com.anythink.core.api.ATMediationRequestInfo aTMediationRequestInfo, java.lang.String str, com.anythink.splashad.a.b bVar, int i, boolean z, int i2, com.anythink.core.common.b.c cVar, java.util.Map<java.lang.String, java.lang.Object> map) {
        com.anythink.core.common.f.v vVar = new com.anythink.core.common.f.v();
        vVar.a(context);
        vVar.b = aTMediationRequestInfo;
        vVar.c = str;
        vVar.h = i;
        vVar.j = z;
        vVar.d = i2;
        vVar.e = cVar;
        if (map != null) {
            try {
                vVar.g = new java.util.HashMap(map);
            } catch (java.lang.Throwable unused) {
            }
        }
        com.anythink.core.common.f fVar = this.d;
        if (fVar != null) {
            fVar.b(this.b, "4", this.c, vVar, bVar);
        }
    }

    public final boolean a(com.anythink.core.api.ATAdStatusInfo aTAdStatusInfo) {
        return this.d.a(aTAdStatusInfo);
    }

    public final com.anythink.core.common.f.b b(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map) {
        return this.d.a(context, false, false, map);
    }
}
