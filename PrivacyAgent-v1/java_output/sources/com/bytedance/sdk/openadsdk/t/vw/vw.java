package com.bytedance.sdk.openadsdk.t.vw;

/* loaded from: classes22.dex */
public abstract class vw {

    /* renamed from: com.bytedance.sdk.openadsdk.t.vw.vw$vw, reason: collision with other inner class name */
    public static class C0278vw implements com.bytedance.sdk.openadsdk.TTAdNative {
        private final com.bytedance.sdk.openadsdk.t.vw.vw vw;

        /* renamed from: com.bytedance.sdk.openadsdk.t.vw.vw$vw$1, reason: invalid class name */
        public class AnonymousClass1 extends com.bytedance.sdk.openadsdk.CSJAdError {
            final /* synthetic */ android.util.Pair vw;

            public AnonymousClass1(android.util.Pair pair) {
                this.vw = pair;
            }

            @Override // com.bytedance.sdk.openadsdk.CSJAdError
            public int getCode() {
                return ((java.lang.Integer) this.vw.first).intValue();
            }

            @Override // com.bytedance.sdk.openadsdk.CSJAdError
            public java.lang.String getMsg() {
                return (java.lang.String) this.vw.second;
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.t.vw.vw$vw$2, reason: invalid class name */
        public class AnonymousClass2 implements com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener {
            final /* synthetic */ com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener vw;

            public AnonymousClass2(com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener splashAdListener) {
                this.vw = splashAdListener;
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashLoadFail(com.bytedance.sdk.openadsdk.CSJAdError cSJAdError) {
                int i;
                java.lang.String str;
                if (this.vw != null) {
                    if (cSJAdError != null) {
                        i = cSJAdError.getCode();
                        str = cSJAdError.getMsg();
                    } else {
                        i = -1;
                        str = "splash load fail";
                    }
                    if (i == 23) {
                        this.vw.onTimeout();
                    } else {
                        this.vw.onError(i, str);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashLoadSuccess(com.bytedance.sdk.openadsdk.CSJSplashAd cSJSplashAd) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashRenderFail(com.bytedance.sdk.openadsdk.CSJSplashAd cSJSplashAd, com.bytedance.sdk.openadsdk.CSJAdError cSJAdError) {
                int i;
                java.lang.String str;
                if (this.vw != null) {
                    if (cSJAdError != null) {
                        i = cSJAdError.getCode();
                        str = cSJAdError.getMsg();
                    } else {
                        i = -1;
                        str = "splash render fail";
                    }
                    if (i == 23) {
                        this.vw.onTimeout();
                    } else {
                        this.vw.onError(i, str);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashRenderSuccess(com.bytedance.sdk.openadsdk.CSJSplashAd cSJSplashAd) {
                if (this.vw == null) {
                    return;
                }
                this.vw.onSplashAdLoad(com.bytedance.sdk.openadsdk.t.vw.vw.C0278vw.this.vw(cSJSplashAd));
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.t.vw.vw$vw$3, reason: invalid class name */
        public class AnonymousClass3 implements com.bytedance.sdk.openadsdk.TTSplashAd {
            final /* synthetic */ com.bytedance.sdk.openadsdk.CSJSplashAd vw;
            final /* synthetic */ com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener[] wg;

            /* renamed from: com.bytedance.sdk.openadsdk.t.vw.vw$vw$3$1, reason: invalid class name */
            public class AnonymousClass1 implements com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener {
                final /* synthetic */ com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener vw;

                public AnonymousClass1(com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener adInteractionListener) {
                    this.vw = adInteractionListener;
                }

                @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                public void onSplashAdClick(com.bytedance.sdk.openadsdk.CSJSplashAd cSJSplashAd) {
                    if (cSJSplashAd == null) {
                        this.vw.onAdClicked(null, -1);
                    } else {
                        this.vw.onAdClicked(cSJSplashAd.getSplashView(), cSJSplashAd.getInteractionType());
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                public void onSplashAdClose(com.bytedance.sdk.openadsdk.CSJSplashAd cSJSplashAd, int i) {
                    if (i == 1) {
                        this.vw.onAdSkip();
                    } else if (i == 2 || i == 4) {
                        this.vw.onAdTimeOver();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                public void onSplashAdShow(com.bytedance.sdk.openadsdk.CSJSplashAd cSJSplashAd) {
                    if (cSJSplashAd == null) {
                        this.vw.onAdShow(null, -1);
                    } else {
                        this.vw.onAdShow(cSJSplashAd.getSplashView(), cSJSplashAd.getInteractionType());
                    }
                }
            }

            /* renamed from: com.bytedance.sdk.openadsdk.t.vw.vw$vw$3$2, reason: invalid class name */
            public class AnonymousClass2 implements com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener {
                final /* synthetic */ com.bytedance.sdk.openadsdk.ISplashClickEyeListener vw;

                public AnonymousClass2(com.bytedance.sdk.openadsdk.ISplashClickEyeListener iSplashClickEyeListener) {
                    this.vw = iSplashClickEyeListener;
                }

                @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener
                public void onSplashClickEyeClick() {
                    com.bytedance.sdk.openadsdk.t.vw.vw.C0278vw.AnonymousClass3 anonymousClass3 = com.bytedance.sdk.openadsdk.t.vw.vw.C0278vw.AnonymousClass3.this;
                    com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener adInteractionListener = anonymousClass3.wg[0];
                    if (adInteractionListener != null) {
                        adInteractionListener.onAdClicked(anonymousClass3.vw.getSplashView(), com.bytedance.sdk.openadsdk.t.vw.vw.C0278vw.AnonymousClass3.this.vw.getInteractionType());
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener
                public void onSplashClickEyeClose() {
                    this.vw.onSplashClickEyeAnimationFinish();
                }

                @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener
                public void onSplashClickEyeReadyToShow(com.bytedance.sdk.openadsdk.CSJSplashAd cSJSplashAd) {
                    this.vw.isSupportSplashClickEye(true);
                    this.vw.onSplashClickEyeAnimationStart();
                }
            }

            /* renamed from: com.bytedance.sdk.openadsdk.t.vw.vw$vw$3$3, reason: invalid class name and collision with other inner class name */
            public class C02793 implements com.bytedance.sdk.openadsdk.CSJSplashAd.SplashCardListener {
                final /* synthetic */ com.bytedance.sdk.openadsdk.ISplashCardListener vw;

                public C02793(com.bytedance.sdk.openadsdk.ISplashCardListener iSplashCardListener) {
                    this.vw = iSplashCardListener;
                }

                @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashCardListener
                public void onSplashCardClick() {
                    com.bytedance.sdk.openadsdk.t.vw.vw.C0278vw.AnonymousClass3 anonymousClass3 = com.bytedance.sdk.openadsdk.t.vw.vw.C0278vw.AnonymousClass3.this;
                    com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener adInteractionListener = anonymousClass3.wg[0];
                    if (adInteractionListener != null) {
                        adInteractionListener.onAdClicked(anonymousClass3.vw.getSplashView(), com.bytedance.sdk.openadsdk.t.vw.vw.C0278vw.AnonymousClass3.this.vw.getInteractionType());
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashCardListener
                public void onSplashCardClose() {
                    this.vw.onSplashClickEyeClose();
                }

                @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashCardListener
                public void onSplashCardReadyToShow(com.bytedance.sdk.openadsdk.CSJSplashAd cSJSplashAd) {
                    this.vw.setSupportSplashClickEye(true);
                    this.vw.onSplashEyeReady();
                }
            }

            public AnonymousClass3(com.bytedance.sdk.openadsdk.CSJSplashAd cSJSplashAd, com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener[] adInteractionListenerArr) {
                this.vw = cSJSplashAd;
                this.wg = adInteractionListenerArr;
            }

            @Override // com.bytedance.sdk.openadsdk.TTSplashAd
            public int getInteractionType() {
                com.bytedance.sdk.openadsdk.CSJSplashAd cSJSplashAd = this.vw;
                if (cSJSplashAd == null) {
                    return 0;
                }
                return cSJSplashAd.getInteractionType();
            }

            @Override // com.bytedance.sdk.openadsdk.TTSplashAd
            public java.util.Map<java.lang.String, java.lang.Object> getMediaExtraInfo() {
                return this.vw.getMediaExtraInfo();
            }

            @Override // com.bytedance.sdk.openadsdk.TTSplashAd
            public int[] getSplashClickEyeSizeToDp() {
                return this.vw.getSplashClickEyeSizeToDp();
            }

            @Override // com.bytedance.sdk.openadsdk.TTSplashAd
            public android.view.View getSplashView() {
                com.bytedance.sdk.openadsdk.CSJSplashAd cSJSplashAd = this.vw;
                if (cSJSplashAd == null) {
                    return null;
                }
                return cSJSplashAd.getSplashView();
            }

            @Override // com.bytedance.sdk.openadsdk.TTClientBidding
            public void loss(java.lang.Double d, java.lang.String str, java.lang.String str2) {
                this.vw.loss(d, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.TTSplashAd
            public void renderExpressAd(com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTClientBidding
            public void setAdInteractionListener(com.bytedance.sdk.openadsdk.TTAdInteractionListener tTAdInteractionListener) {
                this.vw.setAdInteractionListener(tTAdInteractionListener);
            }

            @Override // com.bytedance.sdk.openadsdk.TTSplashAd
            public void setDownloadListener(com.bytedance.sdk.openadsdk.TTAppDownloadListener tTAppDownloadListener) {
                if (tTAppDownloadListener == null) {
                    return;
                }
                this.vw.setDownloadListener(tTAppDownloadListener);
            }

            @Override // com.bytedance.sdk.openadsdk.TTSplashAd
            public void setNotAllowSdkCountdown() {
                this.vw.hideSkipButton();
            }

            @Override // com.bytedance.sdk.openadsdk.TTClientBidding
            public void setPrice(java.lang.Double d) {
                this.vw.setPrice(d);
            }

            @Override // com.bytedance.sdk.openadsdk.TTSplashAd
            public void setSplashCardListener(com.bytedance.sdk.openadsdk.ISplashCardListener iSplashCardListener) {
                if (iSplashCardListener == null) {
                    return;
                }
                this.vw.setSplashCardListener(new com.bytedance.sdk.openadsdk.t.vw.vw.C0278vw.AnonymousClass3.C02793(iSplashCardListener));
            }

            @Override // com.bytedance.sdk.openadsdk.TTSplashAd
            public void setSplashClickEyeListener(com.bytedance.sdk.openadsdk.ISplashClickEyeListener iSplashClickEyeListener) {
                if (iSplashClickEyeListener == null) {
                    return;
                }
                this.vw.setSplashClickEyeListener(new com.bytedance.sdk.openadsdk.t.vw.vw.C0278vw.AnonymousClass3.AnonymousClass2(iSplashClickEyeListener));
            }

            @Override // com.bytedance.sdk.openadsdk.TTSplashAd
            public void setSplashInteractionListener(com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener adInteractionListener) {
                com.bytedance.sdk.openadsdk.CSJSplashAd cSJSplashAd;
                if (adInteractionListener == null || (cSJSplashAd = this.vw) == null) {
                    return;
                }
                this.wg[0] = adInteractionListener;
                cSJSplashAd.setSplashAdListener(new com.bytedance.sdk.openadsdk.t.vw.vw.C0278vw.AnonymousClass3.AnonymousClass1(adInteractionListener));
            }

            @Override // com.bytedance.sdk.openadsdk.TTSplashAd
            public void splashClickEyeAnimationFinish() {
                this.vw.showSplashClickEyeView(null);
            }

            @Override // com.bytedance.sdk.openadsdk.TTSplashAd
            public void startClickEye() {
                this.vw.startClickEye();
            }

            @Override // com.bytedance.sdk.openadsdk.TTSplashAd
            public void startClickEye(boolean z) {
                this.vw.startClickEye();
            }

            @Override // com.bytedance.sdk.openadsdk.TTClientBidding
            public void win(java.lang.Double d) {
                this.vw.win(d);
            }
        }

        public C0278vw(com.bytedance.sdk.openadsdk.t.vw.vw vwVar) {
            this.vw = vwVar;
        }

        private void vw(com.bytedance.sdk.openadsdk.AdSlot adSlot, com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener splashAdListener, int i) {
            loadSplashAd(adSlot, new com.bytedance.sdk.openadsdk.t.vw.vw.C0278vw.AnonymousClass2(splashAdListener), i);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadBannerExpressAd(com.bytedance.sdk.openadsdk.AdSlot adSlot, com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.vw.x(com.bytedance.sdk.openadsdk.t.vw.t.wg.vw(adSlot), new com.bytedance.sdk.openadsdk.bt.vw.vw.vw.yl(nativeExpressAdListener));
            } catch (java.lang.Exception e) {
                if (nativeExpressAdListener != null) {
                    android.util.Pair<java.lang.Integer, java.lang.String> vw = this.vw.vw(e);
                    nativeExpressAdListener.onError(((java.lang.Integer) vw.first).intValue(), (java.lang.String) vw.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadDrawFeedAd(com.bytedance.sdk.openadsdk.AdSlot adSlot, com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener drawFeedAdListener) {
            try {
                this.vw.t(com.bytedance.sdk.openadsdk.t.vw.t.wg.vw(adSlot), new com.bytedance.sdk.openadsdk.bt.vw.vw.vw.vw(drawFeedAdListener));
            } catch (java.lang.Exception e) {
                if (drawFeedAdListener != null) {
                    android.util.Pair<java.lang.Integer, java.lang.String> vw = this.vw.vw(e);
                    drawFeedAdListener.onError(((java.lang.Integer) vw.first).intValue(), (java.lang.String) vw.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadExpressDrawFeedAd(com.bytedance.sdk.openadsdk.AdSlot adSlot, com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.vw.o(com.bytedance.sdk.openadsdk.t.vw.t.wg.vw(adSlot), new com.bytedance.sdk.openadsdk.bt.vw.vw.vw.yl(nativeExpressAdListener));
            } catch (java.lang.Exception e) {
                if (nativeExpressAdListener != null) {
                    android.util.Pair<java.lang.Integer, java.lang.String> vw = this.vw.vw(e);
                    nativeExpressAdListener.onError(((java.lang.Integer) vw.first).intValue(), (java.lang.String) vw.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFeedAd(com.bytedance.sdk.openadsdk.AdSlot adSlot, com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener feedAdListener) {
            try {
                this.vw.vw(com.bytedance.sdk.openadsdk.t.vw.t.wg.vw(adSlot), new com.bytedance.sdk.openadsdk.bt.vw.vw.vw.wg(feedAdListener));
            } catch (java.lang.Exception e) {
                if (feedAdListener != null) {
                    android.util.Pair<java.lang.Integer, java.lang.String> vw = this.vw.vw(e);
                    feedAdListener.onError(((java.lang.Integer) vw.first).intValue(), (java.lang.String) vw.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFullScreenVideoAd(com.bytedance.sdk.openadsdk.AdSlot adSlot, com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
            try {
                this.vw.kz(com.bytedance.sdk.openadsdk.t.vw.t.wg.vw(adSlot), new com.bytedance.sdk.openadsdk.bt.vw.vw.vw.t(fullScreenVideoAdListener));
            } catch (java.lang.Exception e) {
                if (fullScreenVideoAdListener != null) {
                    android.util.Pair<java.lang.Integer, java.lang.String> vw = this.vw.vw(e);
                    fullScreenVideoAdListener.onError(((java.lang.Integer) vw.first).intValue(), (java.lang.String) vw.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadInteractionExpressAd(com.bytedance.sdk.openadsdk.AdSlot adSlot, com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeAd(com.bytedance.sdk.openadsdk.AdSlot adSlot, com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener nativeAdListener) {
            try {
                this.vw.v(com.bytedance.sdk.openadsdk.t.vw.t.wg.vw(adSlot), new com.bytedance.sdk.openadsdk.bt.vw.vw.vw.v(nativeAdListener));
            } catch (java.lang.Exception e) {
                if (nativeAdListener != null) {
                    android.util.Pair<java.lang.Integer, java.lang.String> vw = this.vw.vw(e);
                    nativeAdListener.onError(((java.lang.Integer) vw.first).intValue(), (java.lang.String) vw.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeExpressAd(com.bytedance.sdk.openadsdk.AdSlot adSlot, com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.vw.bt(com.bytedance.sdk.openadsdk.t.vw.t.wg.vw(adSlot), new com.bytedance.sdk.openadsdk.bt.vw.vw.vw.yl(nativeExpressAdListener));
            } catch (java.lang.Exception e) {
                if (nativeExpressAdListener != null) {
                    android.util.Pair<java.lang.Integer, java.lang.String> vw = this.vw.vw(e);
                    nativeExpressAdListener.onError(((java.lang.Integer) vw.first).intValue(), (java.lang.String) vw.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadRewardVideoAd(com.bytedance.sdk.openadsdk.AdSlot adSlot, com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
            try {
                this.vw.yl(com.bytedance.sdk.openadsdk.t.vw.t.wg.vw(adSlot), new com.bytedance.sdk.openadsdk.bt.vw.vw.vw.kz(rewardVideoAdListener));
            } catch (java.lang.Exception e) {
                if (rewardVideoAdListener != null) {
                    android.util.Pair<java.lang.Integer, java.lang.String> vw = this.vw.vw(e);
                    rewardVideoAdListener.onError(((java.lang.Integer) vw.first).intValue(), (java.lang.String) vw.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(com.bytedance.sdk.openadsdk.AdSlot adSlot, com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener cSJSplashAdListener, int i) {
            try {
                this.vw.vw(com.bytedance.sdk.openadsdk.t.vw.t.wg.vw(adSlot), new com.bytedance.sdk.openadsdk.t.vw.wg(cSJSplashAdListener), i);
            } catch (java.lang.Exception e) {
                if (cSJSplashAdListener != null) {
                    cSJSplashAdListener.onSplashLoadFail(new com.bytedance.sdk.openadsdk.t.vw.vw.C0278vw.AnonymousClass1(this.vw.vw(e)));
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(com.bytedance.sdk.openadsdk.AdSlot adSlot, com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener splashAdListener) {
            vw(adSlot, splashAdListener, -1);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(com.bytedance.sdk.openadsdk.AdSlot adSlot, com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener splashAdListener, int i) {
            vw(adSlot, splashAdListener, i);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadStream(com.bytedance.sdk.openadsdk.AdSlot adSlot, com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener feedAdListener) {
            try {
                this.vw.wg(com.bytedance.sdk.openadsdk.t.vw.t.wg.vw(adSlot), new com.bytedance.sdk.openadsdk.bt.vw.vw.vw.wg(feedAdListener));
            } catch (java.lang.Exception e) {
                if (feedAdListener != null) {
                    android.util.Pair<java.lang.Integer, java.lang.String> vw = this.vw.vw(e);
                    feedAdListener.onError(((java.lang.Integer) vw.first).intValue(), (java.lang.String) vw.second);
                }
            }
        }

        public com.bytedance.sdk.openadsdk.TTSplashAd vw(com.bytedance.sdk.openadsdk.CSJSplashAd cSJSplashAd) {
            if (cSJSplashAd == null) {
                return null;
            }
            return new com.bytedance.sdk.openadsdk.t.vw.vw.C0278vw.AnonymousClass3(cSJSplashAd, new com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener[1]);
        }
    }

    public abstract void bt(com.bykv.vk.openvk.api.proto.ValueSet valueSet, com.bykv.vk.openvk.api.proto.Bridge bridge);

    public abstract void kz(com.bykv.vk.openvk.api.proto.ValueSet valueSet, com.bykv.vk.openvk.api.proto.Bridge bridge);

    public abstract void o(com.bykv.vk.openvk.api.proto.ValueSet valueSet, com.bykv.vk.openvk.api.proto.Bridge bridge);

    public abstract void t(com.bykv.vk.openvk.api.proto.ValueSet valueSet, com.bykv.vk.openvk.api.proto.Bridge bridge);

    public abstract void v(com.bykv.vk.openvk.api.proto.ValueSet valueSet, com.bykv.vk.openvk.api.proto.Bridge bridge);

    public abstract android.util.Pair<java.lang.Integer, java.lang.String> vw(java.lang.Exception exc);

    public com.bytedance.sdk.openadsdk.TTAdNative vw() {
        return new com.bytedance.sdk.openadsdk.t.vw.vw.C0278vw(this);
    }

    public abstract void vw(com.bykv.vk.openvk.api.proto.ValueSet valueSet, com.bykv.vk.openvk.api.proto.Bridge bridge);

    public abstract void vw(com.bykv.vk.openvk.api.proto.ValueSet valueSet, com.bykv.vk.openvk.api.proto.Bridge bridge, int i);

    public abstract void wg(com.bykv.vk.openvk.api.proto.ValueSet valueSet, com.bykv.vk.openvk.api.proto.Bridge bridge);

    public abstract void x(com.bykv.vk.openvk.api.proto.ValueSet valueSet, com.bykv.vk.openvk.api.proto.Bridge bridge);

    public abstract void yl(com.bykv.vk.openvk.api.proto.ValueSet valueSet, com.bykv.vk.openvk.api.proto.Bridge bridge);
}
