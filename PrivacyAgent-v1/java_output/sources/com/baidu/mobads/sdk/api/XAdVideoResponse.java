package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class XAdVideoResponse implements com.baidu.mobads.sdk.api.PrerollVideoResponse {
    com.baidu.mobads.sdk.api.XAdNativeResponse adNativeResponse;

    /* renamed from: com.baidu.mobads.sdk.api.XAdVideoResponse$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$mobads$sdk$api$NativeResponse$MaterialType;

        static {
            int[] iArr = new int[com.baidu.mobads.sdk.api.NativeResponse.MaterialType.values().length];
            $SwitchMap$com$baidu$mobads$sdk$api$NativeResponse$MaterialType = iArr;
            try {
                iArr[com.baidu.mobads.sdk.api.NativeResponse.MaterialType.VIDEO.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$mobads$sdk$api$NativeResponse$MaterialType[com.baidu.mobads.sdk.api.NativeResponse.MaterialType.NORMAL.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    public XAdVideoResponse(com.baidu.mobads.sdk.api.NativeResponse nativeResponse) {
        this.adNativeResponse = (com.baidu.mobads.sdk.api.XAdNativeResponse) nativeResponse;
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public java.lang.String getAdLogoUrl() {
        com.baidu.mobads.sdk.api.XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
        if (xAdNativeResponse != null) {
            return xAdNativeResponse.getAdLogoUrl();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public java.lang.String getBaiduLogoUrl() {
        com.baidu.mobads.sdk.api.XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
        if (xAdNativeResponse != null) {
            return xAdNativeResponse.getBaiduLogoUrl();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public java.lang.String getDesc() {
        com.baidu.mobads.sdk.api.XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
        if (xAdNativeResponse != null) {
            return xAdNativeResponse.getDesc();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public java.lang.String getIconUrl() {
        com.baidu.mobads.sdk.api.XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
        if (xAdNativeResponse != null) {
            return xAdNativeResponse.getIconUrl();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public java.lang.String getImageUrl() {
        com.baidu.mobads.sdk.api.XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
        if (xAdNativeResponse != null) {
            return xAdNativeResponse.getImageUrl();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public java.lang.String getMaterialType() {
        com.baidu.mobads.sdk.api.XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
        if (xAdNativeResponse != null) {
            int i = com.baidu.mobads.sdk.api.XAdVideoResponse.AnonymousClass1.$SwitchMap$com$baidu$mobads$sdk$api$NativeResponse$MaterialType[xAdNativeResponse.getMaterialType().ordinal()];
            if (i == 1) {
                return "video";
            }
            if (i == 2 && this.adNativeResponse.getImageUrl().contains(".gif")) {
                return "gif";
            }
        }
        return "normal";
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public java.lang.String getTitle() {
        com.baidu.mobads.sdk.api.XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
        if (xAdNativeResponse != null) {
            return xAdNativeResponse.getTitle();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public java.lang.String getVideoUrl() {
        com.baidu.mobads.sdk.api.XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
        if (xAdNativeResponse != null) {
            return xAdNativeResponse.getVideoUrl();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public void handleClick(android.view.View view) {
        com.baidu.mobads.sdk.api.XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
        if (xAdNativeResponse != null) {
            xAdNativeResponse.handleClick(view);
        }
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public void handleClick(android.view.View view, int i) {
        com.baidu.mobads.sdk.api.XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
        if (xAdNativeResponse != null) {
            xAdNativeResponse.handleClick(view, i);
        }
    }

    @Override // com.baidu.mobads.sdk.api.PrerollVideoResponse
    public void recordImpression(android.view.View view) {
        com.baidu.mobads.sdk.api.XAdNativeResponse xAdNativeResponse = this.adNativeResponse;
        if (xAdNativeResponse != null) {
            xAdNativeResponse.recordImpression(view);
        }
    }
}
