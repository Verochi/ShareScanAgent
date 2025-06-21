package com.anythink.network.toutiao;

/* loaded from: classes12.dex */
public class TTATAdapter extends com.anythink.nativead.unitgroup.api.CustomNativeAdapter {
    java.lang.String a;
    java.lang.String b;
    java.lang.String c;
    private final java.lang.String g = getClass().getSimpleName();
    int d = 0;
    java.lang.String e = "";
    boolean f = false;

    /* renamed from: com.anythink.network.toutiao.TTATAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.api.MediationInitCallback {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.util.Map b;
        final /* synthetic */ java.util.Map c;

        public AnonymousClass1(android.content.Context context, java.util.Map map, java.util.Map map2) {
            this.a = context;
            this.b = map;
            this.c = map2;
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public final void onFail(java.lang.String str) {
            com.anythink.network.toutiao.TTATAdapter.this.notifyATLoadFail("", str);
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public final void onSuccess() {
            com.anythink.network.toutiao.TTATAdapter tTATAdapter = com.anythink.network.toutiao.TTATAdapter.this;
            com.anythink.network.toutiao.TTATAdapter.a(tTATAdapter, this.a, this.b, this.c, tTATAdapter.f ? 1 : ((com.anythink.core.api.ATBaseAdAdapter) tTATAdapter).mRequestNum);
        }
    }

    /* renamed from: com.anythink.network.toutiao.TTATAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.util.Map b;
        final /* synthetic */ java.util.Map c;
        final /* synthetic */ int d;

        /* renamed from: com.anythink.network.toutiao.TTATAdapter$2$1, reason: invalid class name */
        public class AnonymousClass1 implements com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener {
            final /* synthetic */ boolean a;

            public AnonymousClass1(boolean z) {
                this.a = z;
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public final void onError(int i, java.lang.String str) {
                com.anythink.network.toutiao.TTATAdapter.this.notifyATLoadFail(java.lang.String.valueOf(i), str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public final void onNativeExpressAdLoad(java.util.List<com.bytedance.sdk.openadsdk.TTNativeExpressAd> list) {
                com.anythink.network.toutiao.TTATAdapter.AnonymousClass2 anonymousClass2 = com.anythink.network.toutiao.TTATAdapter.AnonymousClass2.this;
                com.anythink.network.toutiao.TTATAdapter.a(com.anythink.network.toutiao.TTATAdapter.this, anonymousClass2.a, (java.util.List) list, this.a, false);
            }
        }

        /* renamed from: com.anythink.network.toutiao.TTATAdapter$2$2, reason: invalid class name and collision with other inner class name */
        public class C02402 implements com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener {
            final /* synthetic */ boolean a;

            public C02402(boolean z) {
                this.a = z;
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public final void onError(int i, java.lang.String str) {
                com.anythink.network.toutiao.TTATAdapter.this.notifyATLoadFail(java.lang.String.valueOf(i), str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public final void onNativeExpressAdLoad(java.util.List<com.bytedance.sdk.openadsdk.TTNativeExpressAd> list) {
                com.anythink.network.toutiao.TTATAdapter.AnonymousClass2 anonymousClass2 = com.anythink.network.toutiao.TTATAdapter.AnonymousClass2.this;
                com.anythink.network.toutiao.TTATAdapter.a(com.anythink.network.toutiao.TTATAdapter.this, anonymousClass2.a, (java.util.List) list, this.a, true);
            }
        }

        /* renamed from: com.anythink.network.toutiao.TTATAdapter$2$3, reason: invalid class name */
        public class AnonymousClass3 implements com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener {
            final /* synthetic */ boolean a;
            final /* synthetic */ android.graphics.Bitmap b;
            final /* synthetic */ int c;

            public AnonymousClass3(boolean z, android.graphics.Bitmap bitmap, int i) {
                this.a = z;
                this.b = bitmap;
                this.c = i;
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public final void onError(int i, java.lang.String str) {
                com.anythink.network.toutiao.TTATAdapter.this.notifyATLoadFail(java.lang.String.valueOf(i), str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public final void onFeedAdLoad(java.util.List<com.bytedance.sdk.openadsdk.TTFeedAd> list) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (com.bytedance.sdk.openadsdk.TTFeedAd tTFeedAd : list) {
                    com.anythink.network.toutiao.TTATAdapter.AnonymousClass2 anonymousClass2 = com.anythink.network.toutiao.TTATAdapter.AnonymousClass2.this;
                    arrayList.add(new com.anythink.network.toutiao.TTATNativeAd(anonymousClass2.a, com.anythink.network.toutiao.TTATAdapter.this.a, tTFeedAd, this.a, this.b, this.c));
                }
                com.anythink.network.toutiao.TTATAdapter.a(com.anythink.network.toutiao.TTATAdapter.this, list, (com.anythink.nativead.unitgroup.api.CustomNativeAd[]) arrayList.toArray(new com.anythink.nativead.unitgroup.api.CustomNativeAd[arrayList.size()]));
            }
        }

        /* renamed from: com.anythink.network.toutiao.TTATAdapter$2$4, reason: invalid class name */
        public class AnonymousClass4 implements com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener {
            final /* synthetic */ boolean a;
            final /* synthetic */ android.graphics.Bitmap b;
            final /* synthetic */ int c;

            public AnonymousClass4(boolean z, android.graphics.Bitmap bitmap, int i) {
                this.a = z;
                this.b = bitmap;
                this.c = i;
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener
            public final void onDrawFeedAdLoad(java.util.List<com.bytedance.sdk.openadsdk.TTDrawFeedAd> list) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (com.bytedance.sdk.openadsdk.TTDrawFeedAd tTDrawFeedAd : list) {
                    com.anythink.network.toutiao.TTATAdapter.AnonymousClass2 anonymousClass2 = com.anythink.network.toutiao.TTATAdapter.AnonymousClass2.this;
                    arrayList.add(new com.anythink.network.toutiao.TTATNativeAd(anonymousClass2.a, com.anythink.network.toutiao.TTATAdapter.this.a, tTDrawFeedAd, this.a, this.b, this.c));
                }
                com.anythink.network.toutiao.TTATAdapter.a(com.anythink.network.toutiao.TTATAdapter.this, list, (com.anythink.nativead.unitgroup.api.CustomNativeAd[]) arrayList.toArray(new com.anythink.nativead.unitgroup.api.CustomNativeAd[arrayList.size()]));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener
            public final void onError(int i, java.lang.String str) {
                com.anythink.network.toutiao.TTATAdapter.this.notifyATLoadFail(java.lang.String.valueOf(i), str);
            }
        }

        /* renamed from: com.anythink.network.toutiao.TTATAdapter$2$5, reason: invalid class name */
        public class AnonymousClass5 implements com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener {
            final /* synthetic */ boolean a;
            final /* synthetic */ android.graphics.Bitmap b;
            final /* synthetic */ int c;

            public AnonymousClass5(boolean z, android.graphics.Bitmap bitmap, int i) {
                this.a = z;
                this.b = bitmap;
                this.c = i;
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener
            public final void onError(int i, java.lang.String str) {
                com.anythink.network.toutiao.TTATAdapter.this.notifyATLoadFail(java.lang.String.valueOf(i), str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener
            public final void onNativeAdLoad(java.util.List<com.bytedance.sdk.openadsdk.TTNativeAd> list) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (com.bytedance.sdk.openadsdk.TTNativeAd tTNativeAd : list) {
                    com.anythink.network.toutiao.TTATAdapter.AnonymousClass2 anonymousClass2 = com.anythink.network.toutiao.TTATAdapter.AnonymousClass2.this;
                    arrayList.add(new com.anythink.network.toutiao.TTATNativeAd(anonymousClass2.a, com.anythink.network.toutiao.TTATAdapter.this.a, tTNativeAd, this.a, this.b, this.c));
                }
                com.anythink.network.toutiao.TTATAdapter.a(com.anythink.network.toutiao.TTATAdapter.this, list, (com.anythink.nativead.unitgroup.api.CustomNativeAd[]) arrayList.toArray(new com.anythink.nativead.unitgroup.api.CustomNativeAd[arrayList.size()]));
            }
        }

        /* renamed from: com.anythink.network.toutiao.TTATAdapter$2$6, reason: invalid class name */
        public class AnonymousClass6 implements com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener {
            final /* synthetic */ boolean a;
            final /* synthetic */ android.graphics.Bitmap b;
            final /* synthetic */ int c;

            public AnonymousClass6(boolean z, android.graphics.Bitmap bitmap, int i) {
                this.a = z;
                this.b = bitmap;
                this.c = i;
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener
            public final void onError(int i, java.lang.String str) {
                com.anythink.network.toutiao.TTATAdapter.this.notifyATLoadFail(java.lang.String.valueOf(i), str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener
            public final void onNativeAdLoad(java.util.List<com.bytedance.sdk.openadsdk.TTNativeAd> list) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (com.bytedance.sdk.openadsdk.TTNativeAd tTNativeAd : list) {
                    com.anythink.network.toutiao.TTATAdapter.AnonymousClass2 anonymousClass2 = com.anythink.network.toutiao.TTATAdapter.AnonymousClass2.this;
                    arrayList.add(new com.anythink.network.toutiao.TTATNativeAd(anonymousClass2.a, com.anythink.network.toutiao.TTATAdapter.this.a, tTNativeAd, this.a, this.b, this.c));
                }
                com.anythink.network.toutiao.TTATAdapter.a(com.anythink.network.toutiao.TTATAdapter.this, list, (com.anythink.nativead.unitgroup.api.CustomNativeAd[]) arrayList.toArray(new com.anythink.nativead.unitgroup.api.CustomNativeAd[arrayList.size()]));
            }
        }

        /* renamed from: com.anythink.network.toutiao.TTATAdapter$2$7, reason: invalid class name */
        public class AnonymousClass7 implements com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener {
            final /* synthetic */ boolean a;
            final /* synthetic */ android.graphics.Bitmap b;
            final /* synthetic */ int c;

            public AnonymousClass7(boolean z, android.graphics.Bitmap bitmap, int i) {
                this.a = z;
                this.b = bitmap;
                this.c = i;
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public final void onError(int i, java.lang.String str) {
                com.anythink.network.toutiao.TTATAdapter.this.notifyATLoadFail(java.lang.String.valueOf(i), str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public final void onFeedAdLoad(java.util.List<com.bytedance.sdk.openadsdk.TTFeedAd> list) {
                if (list == null || list.isEmpty()) {
                    com.anythink.network.toutiao.TTATAdapter.this.notifyATLoadFail("", "Ad list is empty.");
                    return;
                }
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (com.bytedance.sdk.openadsdk.TTFeedAd tTFeedAd : list) {
                    com.anythink.network.toutiao.TTATAdapter.AnonymousClass2 anonymousClass2 = com.anythink.network.toutiao.TTATAdapter.AnonymousClass2.this;
                    arrayList.add(new com.anythink.network.toutiao.TTATNativePatchAd(anonymousClass2.a, com.anythink.network.toutiao.TTATAdapter.this.a, tTFeedAd, this.a, this.b, this.c));
                }
                com.anythink.network.toutiao.TTATAdapter.a(com.anythink.network.toutiao.TTATAdapter.this, list, (com.anythink.nativead.unitgroup.api.CustomNativeAd[]) arrayList.toArray(new com.anythink.nativead.unitgroup.api.CustomNativeAd[arrayList.size()]));
            }
        }

        public AnonymousClass2(android.content.Context context, java.util.Map map, java.util.Map map2, int i) {
            this.a = context;
            this.b = map;
            this.c = map2;
            this.d = i;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public final void run() {
            boolean z;
            int i;
            android.graphics.Bitmap bitmap;
            char c;
            com.bytedance.sdk.openadsdk.TTAdManager adManager = com.bytedance.sdk.openadsdk.TTAdSdk.getAdManager();
            int i2 = this.a.getResources().getDisplayMetrics().widthPixels;
            int i3 = this.a.getResources().getDisplayMetrics().heightPixels;
            java.util.Map map = this.b;
            if (map != null) {
                java.lang.Object obj = map.containsKey(com.anythink.core.api.ATAdConst.KEY.AD_WIDTH) ? this.b.get(com.anythink.core.api.ATAdConst.KEY.AD_WIDTH) : null;
                java.lang.Object obj2 = this.b.containsKey(com.anythink.network.toutiao.TTATConst.NATIVE_AD_IMAGE_HEIGHT) ? this.b.get(com.anythink.network.toutiao.TTATConst.NATIVE_AD_IMAGE_HEIGHT) : this.b.containsKey(com.anythink.core.api.ATAdConst.KEY.AD_HEIGHT) ? this.b.get(com.anythink.core.api.ATAdConst.KEY.AD_HEIGHT) : null;
                java.lang.Object obj3 = this.b.get(com.anythink.network.toutiao.TTATConst.NATIVE_AD_INTERRUPT_VIDEOPLAY);
                java.lang.Object obj4 = this.b.get(com.anythink.network.toutiao.TTATConst.NATIVE_AD_VIDEOPLAY_BTN_BITMAP);
                java.lang.Object obj5 = this.b.get(com.anythink.network.toutiao.TTATConst.NATIVE_AD_VIDEOPLAY_BTN_SIZE);
                if (obj == null || obj2 == null) {
                    int i4 = com.anythink.network.toutiao.TTATAdapter.this.d;
                    if (i4 == 1) {
                        i2 = 690;
                        i3 = 388;
                    } else if (i4 == 2) {
                        i2 = 228;
                        i3 = 150;
                    } else if (i4 == 3) {
                        i2 = 1280;
                        i3 = 720;
                    } else if (i4 == 4) {
                        i2 = com.amap.api.services.core.AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS;
                        i3 = 628;
                    } else if (i4 == 5) {
                        i2 = com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH;
                        i3 = com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH;
                    }
                } else {
                    try {
                        i2 = (int) java.lang.Double.parseDouble(obj.toString());
                    } catch (java.lang.Throwable th) {
                        th.printStackTrace();
                    }
                    try {
                        i3 = (int) java.lang.Double.parseDouble(obj2.toString());
                    } catch (java.lang.Throwable th2) {
                        th2.printStackTrace();
                    }
                }
                z = obj3 instanceof java.lang.Boolean ? java.lang.Boolean.parseBoolean(obj3.toString()) : true;
                android.graphics.Bitmap bitmap2 = obj4 instanceof android.graphics.Bitmap ? (android.graphics.Bitmap) obj4 : null;
                if (obj5 instanceof java.lang.Integer) {
                    i = java.lang.Integer.parseInt(obj5.toString());
                    bitmap = bitmap2;
                } else {
                    bitmap = bitmap2;
                    i = 0;
                }
            } else {
                z = true;
                i = 0;
                bitmap = null;
            }
            com.bytedance.sdk.openadsdk.TTAdNative createAdNative = adManager.createAdNative(this.a);
            com.anythink.network.toutiao.TTATCustomAdSlotBuilder tTATCustomAdSlotBuilder = new com.anythink.network.toutiao.TTATCustomAdSlotBuilder(com.anythink.network.toutiao.TTATAdapter.this.a, this.c, this.b);
            tTATCustomAdSlotBuilder.setAdCount(java.lang.Math.min(this.d, 3));
            tTATCustomAdSlotBuilder.setSupportDeepLink(true);
            if (android.text.TextUtils.equals("0", com.anythink.network.toutiao.TTATAdapter.this.c) && android.text.TextUtils.equals("0", com.anythink.network.toutiao.TTATAdapter.this.b)) {
                java.lang.String unused = com.anythink.network.toutiao.TTATAdapter.this.g;
                tTATCustomAdSlotBuilder.setExpressViewAcceptedSize(com.anythink.network.toutiao.TTATAdapter.a(this.a, i2), com.anythink.network.toutiao.TTATAdapter.a(this.a, i3));
                createAdNative.loadNativeExpressAd(tTATCustomAdSlotBuilder.build(), new com.anythink.network.toutiao.TTATAdapter.AnonymousClass2.AnonymousClass1(z));
            }
            if (android.text.TextUtils.equals("1", com.anythink.network.toutiao.TTATAdapter.this.c) && android.text.TextUtils.equals("0", com.anythink.network.toutiao.TTATAdapter.this.b)) {
                java.lang.String unused2 = com.anythink.network.toutiao.TTATAdapter.this.g;
                tTATCustomAdSlotBuilder.setExpressViewAcceptedSize(com.anythink.network.toutiao.TTATAdapter.a(this.a, i2), com.anythink.network.toutiao.TTATAdapter.a(this.a, i3));
                createAdNative.loadExpressDrawFeedAd(tTATCustomAdSlotBuilder.build(), new com.anythink.network.toutiao.TTATAdapter.AnonymousClass2.C02402(z));
                return;
            }
            if (i2 <= 0 || i3 <= 0) {
                tTATCustomAdSlotBuilder.setImageAcceptedSize(com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH, 320);
            } else {
                tTATCustomAdSlotBuilder.setImageAcceptedSize(i2, i3);
            }
            java.lang.String str = com.anythink.network.toutiao.TTATAdapter.this.c;
            str.hashCode();
            switch (str.hashCode()) {
                case 48:
                    if (str.equals("0")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 49:
                    if (str.equals("1")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 50:
                    if (str.equals("2")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 51:
                    if (str.equals("3")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 52:
                    if (str.equals("4")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    createAdNative.loadFeedAd(tTATCustomAdSlotBuilder.build(), new com.anythink.network.toutiao.TTATAdapter.AnonymousClass2.AnonymousClass3(z, bitmap, i));
                    break;
                case 1:
                    createAdNative.loadDrawFeedAd(tTATCustomAdSlotBuilder.build(), new com.anythink.network.toutiao.TTATAdapter.AnonymousClass2.AnonymousClass4(z, bitmap, i));
                    break;
                case 2:
                    tTATCustomAdSlotBuilder.setNativeAdType(1);
                    createAdNative.loadNativeAd(tTATCustomAdSlotBuilder.build(), new com.anythink.network.toutiao.TTATAdapter.AnonymousClass2.AnonymousClass5(z, bitmap, i));
                    break;
                case 3:
                    tTATCustomAdSlotBuilder.setNativeAdType(2);
                    createAdNative.loadNativeAd(tTATCustomAdSlotBuilder.build(), new com.anythink.network.toutiao.TTATAdapter.AnonymousClass2.AnonymousClass6(z, bitmap, i));
                    break;
                case 4:
                    createAdNative.loadStream(tTATCustomAdSlotBuilder.build(), new com.anythink.network.toutiao.TTATAdapter.AnonymousClass2.AnonymousClass7(z, bitmap, i));
                    break;
                default:
                    com.anythink.network.toutiao.TTATAdapter.this.notifyATLoadFail("", "The Native type is not exit.");
                    break;
            }
        }
    }

    /* renamed from: com.anythink.network.toutiao.TTATAdapter$3, reason: invalid class name */
    public class AnonymousClass3 implements com.anythink.network.toutiao.TTATNativeExpressHandler.RenderCallback {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ boolean b;
        final /* synthetic */ boolean c;

        public AnonymousClass3(android.content.Context context, boolean z, boolean z2) {
            this.a = context;
            this.b = z;
            this.c = z2;
        }

        @Override // com.anythink.network.toutiao.TTATNativeExpressHandler.RenderCallback
        public final void onRenderFail(java.lang.String str, int i) {
            com.anythink.network.toutiao.TTATAdapter.this.notifyATLoadFail(java.lang.String.valueOf(i), str);
        }

        @Override // com.anythink.network.toutiao.TTATNativeExpressHandler.RenderCallback
        public final void onRenderSuccess(java.util.List<com.anythink.network.toutiao.TTATNativeExpressHandler.TTNativeExpressAdWrapper> list) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            for (com.anythink.network.toutiao.TTATNativeExpressHandler.TTNativeExpressAdWrapper tTNativeExpressAdWrapper : list) {
                arrayList.add(new com.anythink.network.toutiao.TTATNativeExpressAd(this.a, com.anythink.network.toutiao.TTATAdapter.this.a, tTNativeExpressAdWrapper.ttNativeExpressAd, this.b, this.c, tTNativeExpressAdWrapper.expressWidth, tTNativeExpressAdWrapper.expressHeight));
                arrayList2.add(tTNativeExpressAdWrapper.ttNativeExpressAd);
            }
            com.anythink.network.toutiao.TTATAdapter.a(com.anythink.network.toutiao.TTATAdapter.this, arrayList2, (com.anythink.nativead.unitgroup.api.CustomNativeAd[]) arrayList.toArray(new com.anythink.nativead.unitgroup.api.CustomNativeAd[arrayList.size()]));
        }
    }

    public static /* synthetic */ int a(android.content.Context context, float f) {
        float f2 = context.getResources().getDisplayMetrics().density;
        if (f2 <= 0.0f) {
            f2 = 1.0f;
        }
        return (int) ((f / f2) + 0.5f);
    }

    private void a(android.content.Context context, java.util.List<com.bytedance.sdk.openadsdk.TTNativeExpressAd> list, boolean z, boolean z2) {
        new com.anythink.network.toutiao.TTATNativeExpressHandler(list).startRender(new com.anythink.network.toutiao.TTATAdapter.AnonymousClass3(context, z, z2));
    }

    private void a(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, int i) {
        android.content.Context applicationContext = context.getApplicationContext();
        if (android.text.TextUtils.isEmpty(this.c)) {
            notifyATLoadFail("", "nativeType is empty");
        } else {
            runOnNetworkRequestThread(new com.anythink.network.toutiao.TTATAdapter.AnonymousClass2(applicationContext, map2, map, i));
        }
    }

    public static /* synthetic */ void a(com.anythink.network.toutiao.TTATAdapter tTATAdapter, android.content.Context context, java.util.List list, boolean z, boolean z2) {
        new com.anythink.network.toutiao.TTATNativeExpressHandler(list).startRender(tTATAdapter.new AnonymousClass3(context, z, z2));
    }

    public static /* synthetic */ void a(com.anythink.network.toutiao.TTATAdapter tTATAdapter, android.content.Context context, java.util.Map map, java.util.Map map2, int i) {
        android.content.Context applicationContext = context.getApplicationContext();
        if (android.text.TextUtils.isEmpty(tTATAdapter.c)) {
            tTATAdapter.notifyATLoadFail("", "nativeType is empty");
        } else {
            tTATAdapter.runOnNetworkRequestThread(tTATAdapter.new AnonymousClass2(applicationContext, map2, map, i));
        }
    }

    public static /* synthetic */ void a(com.anythink.network.toutiao.TTATAdapter tTATAdapter, java.util.List list, com.anythink.nativead.unitgroup.api.CustomNativeAd[] customNativeAdArr) {
        if (list.size() == 0 || customNativeAdArr.length == 0) {
            tTATAdapter.notifyATLoadFail("", "Ad list is empty.");
            return;
        }
        java.lang.Object obj = list.get(0);
        java.util.HashMap hashMap = new java.util.HashMap(3);
        if (obj instanceof com.bytedance.sdk.openadsdk.TTNativeAd) {
            try {
                java.util.Map<java.lang.String, java.lang.Object> mediaExtraInfo = ((com.bytedance.sdk.openadsdk.TTNativeAd) obj).getMediaExtraInfo();
                if (mediaExtraInfo != null) {
                    hashMap.putAll(mediaExtraInfo);
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        if (obj instanceof com.bytedance.sdk.openadsdk.TTNativeExpressAd) {
            try {
                java.util.Map<java.lang.String, java.lang.Object> mediaExtraInfo2 = ((com.bytedance.sdk.openadsdk.TTNativeExpressAd) obj).getMediaExtraInfo();
                if (mediaExtraInfo2 != null) {
                    hashMap.putAll(mediaExtraInfo2);
                }
            } catch (java.lang.Throwable th2) {
                th2.printStackTrace();
            }
        }
        if (tTATAdapter.f) {
            if (tTATAdapter.mBiddingListener != null) {
                com.anythink.network.toutiao.TTATInitManager.getInstance().a(hashMap, customNativeAdArr[0], (com.bytedance.sdk.openadsdk.TTClientBidding) list.get(0), tTATAdapter.mBiddingListener);
                tTATAdapter.mBiddingListener = null;
                return;
            }
            return;
        }
        com.anythink.core.api.ATCustomLoadListener aTCustomLoadListener = tTATAdapter.mLoadListener;
        if (aTCustomLoadListener != null) {
            aTCustomLoadListener.onAdCacheLoaded(customNativeAdArr);
        }
    }

    private void a(java.util.List<? extends com.bytedance.sdk.openadsdk.TTClientBidding> list, com.anythink.nativead.unitgroup.api.CustomNativeAd... customNativeAdArr) {
        if (list.size() == 0 || customNativeAdArr.length == 0) {
            notifyATLoadFail("", "Ad list is empty.");
            return;
        }
        com.bytedance.sdk.openadsdk.TTClientBidding tTClientBidding = list.get(0);
        java.util.HashMap hashMap = new java.util.HashMap(3);
        if (tTClientBidding instanceof com.bytedance.sdk.openadsdk.TTNativeAd) {
            try {
                java.util.Map<java.lang.String, java.lang.Object> mediaExtraInfo = ((com.bytedance.sdk.openadsdk.TTNativeAd) tTClientBidding).getMediaExtraInfo();
                if (mediaExtraInfo != null) {
                    hashMap.putAll(mediaExtraInfo);
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        if (tTClientBidding instanceof com.bytedance.sdk.openadsdk.TTNativeExpressAd) {
            try {
                java.util.Map<java.lang.String, java.lang.Object> mediaExtraInfo2 = ((com.bytedance.sdk.openadsdk.TTNativeExpressAd) tTClientBidding).getMediaExtraInfo();
                if (mediaExtraInfo2 != null) {
                    hashMap.putAll(mediaExtraInfo2);
                }
            } catch (java.lang.Throwable th2) {
                th2.printStackTrace();
            }
        }
        if (this.f) {
            if (this.mBiddingListener != null) {
                com.anythink.network.toutiao.TTATInitManager.getInstance().a(hashMap, customNativeAdArr[0], list.get(0), this.mBiddingListener);
                this.mBiddingListener = null;
                return;
            }
            return;
        }
        com.anythink.core.api.ATCustomLoadListener aTCustomLoadListener = this.mLoadListener;
        if (aTCustomLoadListener != null) {
            aTCustomLoadListener.onAdCacheLoaded(customNativeAdArr);
        }
    }

    private boolean a(java.util.Map<java.lang.String, java.lang.Object> map) {
        java.lang.String str = (java.lang.String) map.get("app_id");
        this.a = (java.lang.String) map.get("slot_id");
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(this.a)) {
            return false;
        }
        this.b = "1";
        if (map.containsKey("layout_type")) {
            this.b = (java.lang.String) map.get("layout_type");
        } else {
            this.b = "0";
        }
        if (map.containsKey("is_video")) {
            this.c = map.get("is_video").toString();
        }
        try {
            if (map.containsKey("media_size")) {
                this.d = java.lang.Integer.parseInt(map.get("media_size").toString());
            }
        } catch (java.lang.Exception unused) {
        }
        if (!map.containsKey("payload")) {
            return true;
        }
        this.e = map.get("payload").toString();
        return true;
    }

    private static int b(android.content.Context context, float f) {
        float f2 = context.getResources().getDisplayMetrics().density;
        if (f2 <= 0.0f) {
            f2 = 1.0f;
        }
        return (int) ((f / f2) + 0.5f);
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public java.lang.String getNetworkName() {
        return com.anythink.network.toutiao.TTATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public java.lang.String getNetworkPlacementId() {
        return this.a;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public java.lang.String getNetworkSDKVersion() {
        return com.anythink.network.toutiao.TTATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        if (a(map)) {
            com.anythink.network.toutiao.TTATInitManager.getInstance().initSDK(context, map, new com.anythink.network.toutiao.TTATAdapter.AnonymousClass1(context, map, map2));
        } else {
            notifyATLoadFail("", "app_id or slot_id is empty!");
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean startBiddingRequest(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, com.anythink.core.api.ATBiddingListener aTBiddingListener) {
        this.f = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }
}
