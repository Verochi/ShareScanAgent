package com.anythink.expressad.splash.js;

/* loaded from: classes12.dex */
public class SplashJs extends com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5 {
    private static java.lang.String h = "SplashJs";
    public static final /* synthetic */ int t = 0;
    private com.anythink.expressad.splash.js.SplashJSBridgeImpl i;

    public void cai(java.lang.Object obj, java.lang.String str) {
        com.anythink.expressad.splash.js.SplashJSBridgeImpl splashJSBridgeImpl = this.i;
        if (splashJSBridgeImpl != null) {
            splashJSBridgeImpl.cai(obj, str);
        }
    }

    public void getFileInfo(java.lang.Object obj, java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            com.anythink.expressad.splash.js.SplashJsUtils.getFileInfo(obj, new org.json.JSONObject(str));
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    public void gial(java.lang.Object obj, java.lang.String str) {
        com.anythink.expressad.splash.js.SplashJSBridgeImpl splashJSBridgeImpl = this.i;
        if (splashJSBridgeImpl != null) {
            splashJSBridgeImpl.gial(obj, str);
        }
    }

    public void handlerH5Exception(java.lang.Object obj, java.lang.String str) {
        if (obj != null) {
            try {
                com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a;
                if (windVaneWebView == null || windVaneWebView.getWebViewListener() == null) {
                    return;
                }
                windVaneWebView.getWebViewListener().onReceivedError(windVaneWebView, 0, str.toString(), windVaneWebView.getUrl());
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public void increaseOfferFrequence(java.lang.Object obj, java.lang.String str) {
        try {
            com.anythink.expressad.splash.js.SplashJsUtils.increaseOfferFrequence(obj, new org.json.JSONObject(str));
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    public void init(java.lang.Object obj, java.lang.String str) {
        com.anythink.expressad.splash.js.SplashJSBridgeImpl splashJSBridgeImpl = this.i;
        if (splashJSBridgeImpl != null) {
            splashJSBridgeImpl.init(obj, str);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.l
    public void initialize(android.content.Context context, com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView) {
        super.initialize(context, windVaneWebView);
        try {
            if (windVaneWebView.getObject() == null || !(windVaneWebView.getObject() instanceof com.anythink.expressad.splash.js.SplashJSBridgeImpl)) {
                return;
            }
            this.i = (com.anythink.expressad.splash.js.SplashJSBridgeImpl) windVaneWebView.getObject();
        } catch (java.lang.Throwable unused) {
        }
    }

    public void install(java.lang.Object obj, java.lang.String str) {
        com.anythink.expressad.splash.js.SplashJSBridgeImpl splashJSBridgeImpl = this.i;
        if (splashJSBridgeImpl != null) {
            splashJSBridgeImpl.install(obj, str);
        }
    }

    public void onJSBridgeConnect(java.lang.Object obj, java.lang.String str) {
        try {
            com.anythink.expressad.splash.js.SplashJSBridgeImpl splashJSBridgeImpl = this.i;
            if (splashJSBridgeImpl != null) {
                splashJSBridgeImpl.onJSBridgeConnect(obj, str);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void openURL(java.lang.Object obj, java.lang.String str) {
        com.anythink.expressad.splash.js.SplashJSBridgeImpl splashJSBridgeImpl = this.i;
        if (splashJSBridgeImpl != null) {
            splashJSBridgeImpl.openURL(obj, str);
        }
    }

    public void pauseCountDown(java.lang.Object obj, java.lang.String str) {
        try {
            com.anythink.expressad.splash.js.SplashJSBridgeImpl splashJSBridgeImpl = this.i;
            if (splashJSBridgeImpl != null) {
                splashJSBridgeImpl.pauseCountDown(obj, str);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void readyStatus(java.lang.Object obj, java.lang.String str) {
        if (obj != null) {
            try {
                int optInt = new org.json.JSONObject(str).optInt("isReady", 1);
                com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a;
                if (windVaneWebView == null || windVaneWebView.getWebViewListener() == null) {
                    return;
                }
                windVaneWebView.getWebViewListener().readyState(windVaneWebView, optInt);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public void reportUrls(java.lang.Object obj, java.lang.String str) {
        try {
            com.anythink.expressad.splash.js.SplashJSBridgeImpl splashJSBridgeImpl = this.i;
            if (splashJSBridgeImpl != null) {
                splashJSBridgeImpl.reportUrls(obj, str);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void resetCountdown(java.lang.Object obj, java.lang.String str) {
        com.anythink.expressad.splash.js.SplashJSBridgeImpl splashJSBridgeImpl = this.i;
        if (splashJSBridgeImpl != null) {
            splashJSBridgeImpl.resetCountdown(obj, str);
        }
    }

    public void resumeCountDown(java.lang.Object obj, java.lang.String str) {
        try {
            com.anythink.expressad.splash.js.SplashJSBridgeImpl splashJSBridgeImpl = this.i;
            if (splashJSBridgeImpl != null) {
                splashJSBridgeImpl.resumeCountDown(obj, str);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void sendImpressions(java.lang.Object obj, java.lang.String str) {
        try {
            com.anythink.expressad.splash.js.SplashJSBridgeImpl splashJSBridgeImpl = this.i;
            if (splashJSBridgeImpl != null) {
                splashJSBridgeImpl.sendImpressions(obj, str);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void toggleCloseBtn(java.lang.Object obj, java.lang.String str) {
        com.anythink.expressad.splash.js.SplashJSBridgeImpl splashJSBridgeImpl = this.i;
        if (splashJSBridgeImpl != null) {
            splashJSBridgeImpl.toggleCloseBtn(obj, str);
        }
    }

    public void triggerCloseBtn(java.lang.Object obj, java.lang.String str) {
        com.anythink.expressad.splash.js.SplashJSBridgeImpl splashJSBridgeImpl = this.i;
        if (splashJSBridgeImpl != null) {
            splashJSBridgeImpl.triggerCloseBtn(obj, str);
        }
    }
}
