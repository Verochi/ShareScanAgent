package com.anythink.expressad.atsignalcommon.mraid;

/* loaded from: classes12.dex */
public class MraidJSBridge extends com.anythink.expressad.atsignalcommon.windvane.l {
    protected static final java.lang.String a = "MraidJSBridge";
    private com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge b;

    public void close(java.lang.Object obj, java.lang.String str) {
        if (obj instanceof com.anythink.expressad.atsignalcommon.windvane.a) {
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireNativeMethodCompleteEvent(((com.anythink.expressad.atsignalcommon.windvane.a) obj).a, "close");
        }
        try {
            com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge iMraidJSBridge = this.b;
            if (iMraidJSBridge != null) {
                iMraidJSBridge.close();
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void expand(java.lang.Object obj, java.lang.String str) {
        if (obj instanceof com.anythink.expressad.atsignalcommon.windvane.a) {
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireNativeMethodCompleteEvent(((com.anythink.expressad.atsignalcommon.windvane.a) obj).a, "expand");
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            java.lang.String optString = jSONObject.optString("url");
            java.lang.String optString2 = jSONObject.optString("shouldUseCustomClose");
            if (android.text.TextUtils.isEmpty(optString) || android.text.TextUtils.isEmpty(optString2) || this.b == null) {
                return;
            }
            this.b.expand(optString, optString2.toLowerCase().equals(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE));
        } catch (java.lang.Throwable unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.anythink.expressad.atsignalcommon.windvane.l
    public void initialize(android.content.Context context, com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView) {
        super.initialize(context, windVaneWebView);
        try {
            if (context instanceof com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge) {
                this.b = (com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge) context;
                return;
            }
            if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge)) {
                this.b = (com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge) windVaneWebView.getObject();
            }
            if (windVaneWebView.getMraidObject() == null || !(windVaneWebView.getMraidObject() instanceof com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge)) {
                return;
            }
            this.b = (com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge) windVaneWebView.getMraidObject();
        } catch (java.lang.Exception e) {
            if (com.anythink.expressad.a.a) {
                e.printStackTrace();
            }
        }
    }

    public void open(java.lang.Object obj, java.lang.String str) {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
        if (obj instanceof com.anythink.expressad.atsignalcommon.windvane.a) {
            windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a;
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireNativeMethodCompleteEvent(windVaneWebView, com.igexin.sdk.PushBuildConfig.sdk_conf_channelid);
        } else {
            windVaneWebView = null;
        }
        try {
            java.lang.String optString = new org.json.JSONObject(str).optString("url");
            if (this.b == null || android.text.TextUtils.isEmpty(optString)) {
                return;
            }
            if (windVaneWebView != null && java.lang.System.currentTimeMillis() - windVaneWebView.lastTouchTime > com.anythink.expressad.a.b.a.c) {
                com.anythink.expressad.foundation.d.c mraidCampaign = this.b.getMraidCampaign();
                windVaneWebView.getUrl();
                if (com.anythink.expressad.a.b.a.a(mraidCampaign)) {
                    return;
                }
            }
            this.b.open(optString);
        } catch (java.lang.Throwable unused) {
        }
    }

    public void setOrientationProperties(java.lang.Object obj, java.lang.String str) {
        if (obj instanceof com.anythink.expressad.atsignalcommon.windvane.a) {
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireNativeMethodCompleteEvent(((com.anythink.expressad.atsignalcommon.windvane.a) obj).a, "setOrientationProperties");
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            java.lang.String optString = jSONObject.optString("allowOrientationChange");
            java.lang.String optString2 = jSONObject.optString(com.alimm.tanx.core.constant.AdClickConstants.FORCE_ORIENTATION);
            if (android.text.TextUtils.isEmpty(optString) || android.text.TextUtils.isEmpty(optString2) || this.b == null) {
                return;
            }
            optString.toLowerCase().equals(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
            java.lang.String lowerCase = optString2.toLowerCase();
            int hashCode = lowerCase.hashCode();
            if (hashCode == 729267099) {
                lowerCase.equals("portrait");
            } else {
                if (hashCode != 1430647483) {
                    return;
                }
                lowerCase.equals("landscape");
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void unload(java.lang.Object obj, java.lang.String str) {
        if (obj instanceof com.anythink.expressad.atsignalcommon.windvane.a) {
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireNativeMethodCompleteEvent(((com.anythink.expressad.atsignalcommon.windvane.a) obj).a, "unload");
        }
        try {
            com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge iMraidJSBridge = this.b;
            if (iMraidJSBridge != null) {
                iMraidJSBridge.unload();
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void useCustomClose(java.lang.Object obj, java.lang.String str) {
        if (obj instanceof com.anythink.expressad.atsignalcommon.windvane.a) {
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireNativeMethodCompleteEvent(((com.anythink.expressad.atsignalcommon.windvane.a) obj).a, "useCustomClose");
        }
        try {
            java.lang.String optString = new org.json.JSONObject(str).optString("shouldUseCustomClose");
            if (android.text.TextUtils.isEmpty(optString) || this.b == null) {
                return;
            }
            this.b.useCustomClose(optString.toLowerCase().equals(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE));
        } catch (java.lang.Throwable unused) {
        }
    }
}
