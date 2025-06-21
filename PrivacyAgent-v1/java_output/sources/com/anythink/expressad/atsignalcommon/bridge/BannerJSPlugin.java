package com.anythink.expressad.atsignalcommon.bridge;

/* loaded from: classes12.dex */
public class BannerJSPlugin extends com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5 {
    public static final /* synthetic */ int t = 0;
    private final java.lang.String h = "BannerJSBridge";
    private com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge i;

    public void cai(java.lang.Object obj, java.lang.String str) {
        try {
            com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge iBannerJSBridge = this.i;
            if (iBannerJSBridge != null) {
                iBannerJSBridge.cai(obj, str);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void click(java.lang.Object obj, java.lang.String str) {
        try {
            com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge iBannerJSBridge = this.i;
            if (iBannerJSBridge != null) {
                iBannerJSBridge.click(obj, str);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void getFileInfo(java.lang.Object obj, java.lang.String str) {
        try {
            com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge iBannerJSBridge = this.i;
            if (iBannerJSBridge != null) {
                iBannerJSBridge.getFileInfo(obj, str);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void getNetstat(java.lang.Object obj, java.lang.String str) {
        try {
            com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge iBannerJSBridge = this.i;
            if (iBannerJSBridge != null) {
                iBannerJSBridge.getNetstat(obj, str);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void gial(java.lang.Object obj, java.lang.String str) {
        try {
            com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge iBannerJSBridge = this.i;
            if (iBannerJSBridge != null) {
                iBannerJSBridge.gial(obj, str);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void handlerH5Exception(java.lang.Object obj, java.lang.String str) {
        try {
            com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge iBannerJSBridge = this.i;
            if (iBannerJSBridge != null) {
                iBannerJSBridge.handlerH5Exception(obj, str);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void increaseOfferFrequence(java.lang.Object obj, java.lang.String str) {
        try {
            com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge iBannerJSBridge = this.i;
            if (iBannerJSBridge != null) {
                iBannerJSBridge.increaseOfferFrequence(obj, str);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void init(java.lang.Object obj, java.lang.String str) {
        try {
            com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge iBannerJSBridge = this.i;
            if (iBannerJSBridge != null) {
                iBannerJSBridge.init(obj, str);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.anythink.expressad.atsignalcommon.windvane.l
    public void initialize(android.content.Context context, com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView) {
        super.initialize(context, windVaneWebView);
        try {
            if (context instanceof com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge) {
                this.i = (com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge) context;
            } else {
                if (windVaneWebView.getObject() == null || !(windVaneWebView.getObject() instanceof com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge)) {
                    return;
                }
                this.i = (com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge) windVaneWebView.getObject();
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void install(java.lang.Object obj, java.lang.String str) {
        try {
            com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge iBannerJSBridge = this.i;
            if (iBannerJSBridge != null) {
                iBannerJSBridge.install(obj, str);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void onJSBridgeConnect(java.lang.Object obj, java.lang.String str) {
        try {
            com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge iBannerJSBridge = this.i;
            if (iBannerJSBridge != null) {
                iBannerJSBridge.onJSBridgeConnect(obj, str);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void openURL(java.lang.Object obj, java.lang.String str) {
        try {
            com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge iBannerJSBridge = this.i;
            if (iBannerJSBridge != null) {
                iBannerJSBridge.openURL(obj, str);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void readyStatus(java.lang.Object obj, java.lang.String str) {
        try {
            com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge iBannerJSBridge = this.i;
            if (iBannerJSBridge != null) {
                iBannerJSBridge.readyStatus(obj, str);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void reportUrls(java.lang.Object obj, java.lang.String str) {
        try {
            com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge iBannerJSBridge = this.i;
            if (iBannerJSBridge != null) {
                iBannerJSBridge.reportUrls(obj, str);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void resetCountdown(java.lang.Object obj, java.lang.String str) {
        try {
            com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge iBannerJSBridge = this.i;
            if (iBannerJSBridge != null) {
                iBannerJSBridge.resetCountdown(obj, str);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void sendImpressions(java.lang.Object obj, java.lang.String str) {
        try {
            com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge iBannerJSBridge = this.i;
            if (iBannerJSBridge != null) {
                iBannerJSBridge.sendImpressions(obj, str);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void toggleCloseBtn(java.lang.Object obj, java.lang.String str) {
        try {
            com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge iBannerJSBridge = this.i;
            if (iBannerJSBridge != null) {
                iBannerJSBridge.toggleCloseBtn(obj, str);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void triggerCloseBtn(java.lang.Object obj, java.lang.String str) {
        try {
            com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge iBannerJSBridge = this.i;
            if (iBannerJSBridge != null) {
                iBannerJSBridge.triggerCloseBtn(obj, str);
            }
        } catch (java.lang.Throwable unused) {
        }
    }
}
