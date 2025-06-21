package com.bytedance.sdk.openadsdk.live.core;

/* loaded from: classes22.dex */
public class TTHostPermissionInner implements com.bytedance.android.live.base.api.IHostPermission {
    private com.bytedance.sdk.openadsdk.TTCustomController vw;

    /* renamed from: com.bytedance.sdk.openadsdk.live.core.TTHostPermissionInner$1, reason: invalid class name */
    public class AnonymousClass1 extends com.bytedance.sdk.openadsdk.TTCustomController {
        public AnonymousClass1() {
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.live.core.TTHostPermissionInner$2, reason: invalid class name */
    public class AnonymousClass2 implements com.bytedance.android.live.base.api.LocationProvider {
        final /* synthetic */ com.bytedance.sdk.openadsdk.LocationProvider vw;

        public AnonymousClass2(com.bytedance.sdk.openadsdk.LocationProvider locationProvider) {
            this.vw = locationProvider;
        }

        @Override // com.bytedance.android.live.base.api.LocationProvider
        public double getLatitude() {
            return this.vw.getLatitude();
        }

        @Override // com.bytedance.android.live.base.api.LocationProvider
        public double getLongitude() {
            return this.vw.getLongitude();
        }
    }

    public TTHostPermissionInner(com.bytedance.sdk.openadsdk.TTCustomController tTCustomController) {
        if (tTCustomController == null) {
            this.vw = new com.bytedance.sdk.openadsdk.live.core.TTHostPermissionInner.AnonymousClass1();
        } else {
            this.vw = tTCustomController;
        }
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean alist() {
        com.bytedance.sdk.openadsdk.TTCustomController tTCustomController = this.vw;
        if (tTCustomController == null) {
            return false;
        }
        return tTCustomController.alist();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public java.lang.String getAndroidID() {
        com.bytedance.sdk.openadsdk.TTCustomController tTCustomController = this.vw;
        if (tTCustomController == null) {
            return null;
        }
        return tTCustomController.getAndroidId();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public java.lang.String getDevImei() {
        com.bytedance.sdk.openadsdk.TTCustomController tTCustomController = this.vw;
        if (tTCustomController == null) {
            return null;
        }
        return tTCustomController.getDevImei();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public java.lang.String getDevOaid() {
        com.bytedance.sdk.openadsdk.TTCustomController tTCustomController = this.vw;
        if (tTCustomController == null) {
            return null;
        }
        return tTCustomController.getDevOaid();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public java.lang.String getMacAddress() {
        com.bytedance.sdk.openadsdk.TTCustomController tTCustomController = this.vw;
        if (tTCustomController == null) {
            return null;
        }
        return tTCustomController.getMacAddress();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public com.bytedance.android.live.base.api.LocationProvider getTTLocation() {
        com.bytedance.sdk.openadsdk.LocationProvider tTLocation;
        com.bytedance.sdk.openadsdk.TTCustomController tTCustomController = this.vw;
        if (tTCustomController == null || (tTLocation = tTCustomController.getTTLocation()) == null) {
            return null;
        }
        return new com.bytedance.sdk.openadsdk.live.core.TTHostPermissionInner.AnonymousClass2(tTLocation);
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanGetAndUseAndroidID() {
        com.bytedance.sdk.openadsdk.TTCustomController tTCustomController = this.vw;
        if (tTCustomController == null) {
            return false;
        }
        return tTCustomController.isCanUseAndroidId();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUseLocation() {
        com.bytedance.sdk.openadsdk.TTCustomController tTCustomController = this.vw;
        if (tTCustomController == null) {
            return true;
        }
        return tTCustomController.isCanUseLocation();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUsePhoneState() {
        com.bytedance.sdk.openadsdk.TTCustomController tTCustomController = this.vw;
        if (tTCustomController == null) {
            return false;
        }
        return tTCustomController.isCanUsePhoneState();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUseWifiState() {
        com.bytedance.sdk.openadsdk.TTCustomController tTCustomController = this.vw;
        if (tTCustomController == null) {
            return false;
        }
        return tTCustomController.isCanUseWifiState();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUseWriteExternal() {
        com.bytedance.sdk.openadsdk.TTCustomController tTCustomController = this.vw;
        if (tTCustomController == null) {
            return false;
        }
        return tTCustomController.isCanUseWriteExternal();
    }
}
