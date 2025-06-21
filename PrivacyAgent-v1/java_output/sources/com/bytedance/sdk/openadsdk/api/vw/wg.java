package com.bytedance.sdk.openadsdk.api.vw;

/* loaded from: classes22.dex */
public class wg implements com.bykv.vk.openvk.api.proto.Bridge {
    private com.ss.android.download.api.download.DownloadEventConfig vw;

    public wg(com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig) {
        this.vw = downloadEventConfig;
    }

    public java.lang.String bt() {
        com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig = this.vw;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickContinueLabel();
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, com.bykv.vk.openvk.api.proto.ValueSet valueSet, java.lang.Class<T> cls) {
        if (i == 223515) {
            if (valueSet == null) {
                return null;
            }
            vw(((java.lang.Integer) valueSet.objectValue(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_SET_DOWNLOAD_SCENE_PARAMETER, java.lang.Integer.class)).intValue());
            return null;
        }
        if (i != 223517 || valueSet == null) {
            return null;
        }
        vw((java.lang.String) valueSet.objectValue(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_SET_REFER_PARAMETER, java.lang.String.class));
        return null;
    }

    public org.json.JSONObject cp() {
        com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig = this.vw;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getExtraJson();
        }
        return null;
    }

    public org.json.JSONObject d() {
        com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig = this.vw;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getParamsJson();
        }
        return null;
    }

    public java.lang.Object es() {
        com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig = this.vw;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getExtraEventObject();
        }
        return null;
    }

    public java.lang.String kz() {
        com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig = this.vw;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickPauseLabel();
        }
        return null;
    }

    public java.lang.String o() {
        com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig = this.vw;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickInstallLabel();
        }
        return null;
    }

    public java.lang.String t() {
        com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig = this.vw;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickItemTag();
        }
        return null;
    }

    public boolean u() {
        com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig = this.vw;
        if (downloadEventConfig != null) {
            return downloadEventConfig.isEnableV3Event();
        }
        return false;
    }

    public java.lang.String v() {
        com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig = this.vw;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickLabel();
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public com.bykv.vk.openvk.api.proto.ValueSet values() {
        return com.bykv.vw.vw.vw.vw.wg.vw().vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_REFER, vw()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_BUTTON_TAG, wg()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_ITEM_TAG, t()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_LABEL, v()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_START_LABEL, yl()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_PAUSE_LABEL, kz()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_CONTINUE_LABEL, bt()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_INSTALL_LABEL, o()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_STORAGE_DENY_LABEL, x()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_EXTRA_EVENT_OBJECT, es()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_DOWNLOAD_SCENE, z()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_IS_ENABLE_CLICK_EVENT, vl()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_IS_ENABLE_V3_EVENT, u()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_EXTRA_JSON, cp()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_PARAMS_JSON, d()).wg();
    }

    public boolean vl() {
        com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig = this.vw;
        if (downloadEventConfig != null) {
            return downloadEventConfig.isEnableClickEvent();
        }
        return false;
    }

    public java.lang.String vw() {
        com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig = this.vw;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getRefer();
        }
        return null;
    }

    public void vw(int i) {
        com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig = this.vw;
        if (downloadEventConfig != null) {
            downloadEventConfig.setDownloadScene(i);
        }
    }

    public void vw(java.lang.String str) {
        com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig = this.vw;
        if (downloadEventConfig != null) {
            downloadEventConfig.setRefer(str);
        }
    }

    public java.lang.String wg() {
        com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig = this.vw;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickButtonTag();
        }
        return null;
    }

    public java.lang.String x() {
        com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig = this.vw;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getStorageDenyLabel();
        }
        return null;
    }

    public java.lang.String yl() {
        com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig = this.vw;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickStartLabel();
        }
        return null;
    }

    public int z() {
        com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig = this.vw;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getDownloadScene();
        }
        return 0;
    }
}
