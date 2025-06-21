package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class bq implements com.baidu.mobads.sdk.api.ExpressResponse {
    private android.content.Context a;
    private int b = 1;
    private com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener c;
    private com.baidu.mobads.sdk.api.ExpressResponse.ExpressAdDownloadWindowListener d;
    private com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener e;
    private com.baidu.mobads.sdk.api.ExpressResponse.ExpressCloseListener f;
    private final com.baidu.mobads.sdk.internal.de g;
    private final com.baidu.mobads.sdk.internal.a h;
    private android.view.ViewGroup i;
    private com.baidu.mobads.sdk.api.ExpressAdData j;
    private java.lang.String k;

    public bq(android.content.Context context, com.baidu.mobads.sdk.internal.de deVar, com.baidu.mobads.sdk.internal.a aVar) {
        this.a = context;
        this.g = deVar;
        this.h = aVar;
    }

    public java.lang.String a() {
        com.baidu.mobads.sdk.internal.a aVar = this.h;
        return aVar != null ? aVar.I() : "";
    }

    public void a(int i) {
        this.b = i;
    }

    public void a(android.view.View view, int i, int i2) {
        com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener expressInteractionListener = this.c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdRenderSuccess(view, i, i2);
        }
    }

    public void a(android.view.View view, java.lang.String str, int i) {
        com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener expressInteractionListener = this.c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdRenderFail(view, str, i);
        }
    }

    public void a(com.baidu.mobads.sdk.api.ExpressResponse expressResponse) {
        com.baidu.mobads.sdk.api.ExpressResponse.ExpressCloseListener expressCloseListener = this.f;
        if (expressCloseListener != null) {
            expressCloseListener.onAdClose(expressResponse);
        }
    }

    public void a(java.lang.String str) {
        this.k = str;
    }

    public void a(boolean z) {
        com.baidu.mobads.sdk.api.ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.d;
        if (expressAdDownloadWindowListener != null) {
            if (z) {
                expressAdDownloadWindowListener.onADPermissionShow();
            } else {
                expressAdDownloadWindowListener.onADPermissionClose();
            }
        }
    }

    public void b() {
        com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener expressInteractionListener = this.c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdClick();
        }
    }

    public void b(java.lang.String str) {
        com.baidu.mobads.sdk.internal.de deVar;
        com.baidu.mobads.sdk.internal.a aVar = this.h;
        if (aVar != null && (deVar = this.g) != null) {
            this.j = new com.baidu.mobads.sdk.api.ExpressAdData(aVar, deVar.g());
        }
        com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener expressDislikeListener = this.e;
        if (expressDislikeListener != null) {
            expressDislikeListener.onDislikeItemClick(str);
        }
    }

    public void b(boolean z) {
        com.baidu.mobads.sdk.api.ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.d;
        if (expressAdDownloadWindowListener != null) {
            if (z) {
                expressAdDownloadWindowListener.adDownloadWindowShow();
            } else {
                expressAdDownloadWindowListener.adDownloadWindowClose();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void biddingFail(java.util.LinkedHashMap<java.lang.String, java.lang.Object> linkedHashMap, com.baidu.mobads.sdk.api.BiddingListener biddingListener) {
        if (this.g != null) {
            java.lang.String str = this.k;
            com.baidu.mobads.sdk.internal.a aVar = this.h;
            if (aVar != null) {
                str = aVar.I();
            }
            this.g.a(str, false, linkedHashMap, biddingListener);
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void biddingSuccess(java.util.LinkedHashMap<java.lang.String, java.lang.Object> linkedHashMap, com.baidu.mobads.sdk.api.BiddingListener biddingListener) {
        com.baidu.mobads.sdk.internal.de deVar;
        com.baidu.mobads.sdk.internal.a aVar = this.h;
        if (aVar == null || (deVar = this.g) == null) {
            return;
        }
        deVar.a(aVar.I(), true, linkedHashMap, biddingListener);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void bindInteractionActivity(android.app.Activity activity) {
        com.baidu.mobads.sdk.internal.de deVar = this.g;
        if (deVar != null) {
            deVar.b(activity);
        }
    }

    public void c() {
        com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener expressInteractionListener = this.c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdExposed();
        }
    }

    public void d() {
        com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener expressDislikeListener = this.e;
        if (expressDislikeListener != null) {
            expressDislikeListener.onDislikeWindowShow();
        }
    }

    public void e() {
        com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener expressDislikeListener = this.e;
        if (expressDislikeListener != null) {
            expressDislikeListener.onDislikeWindowClose();
        }
    }

    public void f() {
        com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener expressInteractionListener = this.c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdUnionClick();
        }
    }

    public void g() {
        com.baidu.mobads.sdk.api.ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.d;
        if (expressAdDownloadWindowListener != null) {
            expressAdDownloadWindowListener.onADPrivacyClick();
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public int getAdActionType() {
        return this.b;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public com.baidu.mobads.sdk.api.ExpressAdData getAdData() {
        return this.j;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public java.lang.Object getAdDataForKey(java.lang.String str) {
        if (this.h != null) {
            return "request_id".equals(str) ? this.h.V() : this.h.a(str);
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public java.lang.String getECPMLevel() {
        com.baidu.mobads.sdk.internal.a aVar = this.h;
        return aVar != null ? aVar.z() : "";
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public android.view.View getExpressAdView() {
        com.baidu.mobads.sdk.internal.a aVar;
        if (this.i == null && (aVar = this.h) != null) {
            this.i = this.g.a(aVar);
        }
        return this.i;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public java.lang.String getPECPM() {
        com.baidu.mobads.sdk.internal.a aVar = this.h;
        return aVar != null ? aVar.A() : "";
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public int getStyleType() {
        com.baidu.mobads.sdk.internal.a aVar = this.h;
        if (aVar != null) {
            return aVar.v();
        }
        return 0;
    }

    public void h() {
        com.baidu.mobads.sdk.api.ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.d;
        if (expressAdDownloadWindowListener != null) {
            expressAdDownloadWindowListener.onADFunctionClick();
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public boolean isAdAvailable() {
        return this.h != null && java.lang.System.currentTimeMillis() - this.h.y() <= this.h.G();
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void render() {
        com.baidu.mobads.sdk.internal.a aVar;
        com.baidu.mobads.sdk.internal.de deVar = this.g;
        if (deVar == null || (aVar = this.h) == null) {
            return;
        }
        if (this.i == null) {
            this.i = deVar.a(aVar);
        }
        this.g.a(this.i, this.h);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setAdCloseListener(com.baidu.mobads.sdk.api.ExpressResponse.ExpressCloseListener expressCloseListener) {
        this.f = expressCloseListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setAdDislikeListener(com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener expressDislikeListener) {
        this.e = expressDislikeListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setAdPrivacyListener(com.baidu.mobads.sdk.api.ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener) {
        this.d = expressAdDownloadWindowListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setExpectedSizePixel(int i, int i2) {
        com.baidu.mobads.sdk.internal.de deVar = this.g;
        if (deVar != null) {
            deVar.a(i, i2);
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setInteractionListener(com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener expressInteractionListener) {
        this.c = expressInteractionListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public boolean switchTheme(int i) {
        com.baidu.mobads.sdk.internal.de deVar = this.g;
        if (deVar != null) {
            return deVar.a(this.i, this.h, i);
        }
        return false;
    }
}
