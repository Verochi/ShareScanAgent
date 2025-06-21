package com.bytedance.sdk.openadsdk.api.vw;

/* loaded from: classes22.dex */
public class vw implements com.bykv.vk.openvk.api.proto.Bridge {
    private com.ss.android.download.api.download.DownloadController vw;

    public vw(com.ss.android.download.api.download.DownloadController downloadController) {
        this.vw = downloadController;
    }

    public java.lang.Object bt() {
        com.ss.android.download.api.download.DownloadController downloadController = this.vw;
        if (downloadController != null) {
            return downloadController.getExtraClickOperation();
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, com.bykv.vk.openvk.api.proto.ValueSet valueSet, java.lang.Class<T> cls) {
        if (i == 223317) {
            if (valueSet == null) {
                return null;
            }
            wg(((java.lang.Boolean) valueSet.objectValue(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_PARAMETER_ENABLE_NEW_ACTIVITY, java.lang.Boolean.class)).booleanValue());
            return null;
        }
        switch (i) {
            case com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_SET_DOWNLOAD_MODE /* 223311 */:
                if (valueSet != null) {
                    vw(((java.lang.Integer) valueSet.objectValue(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_PARAMETER_MODE, java.lang.Integer.class)).intValue());
                    break;
                }
                break;
            case com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_SET_LINK_MODE /* 223312 */:
                if (valueSet != null) {
                    wg(((java.lang.Integer) valueSet.objectValue(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_PARAMETER_LINK_MODE, java.lang.Integer.class)).intValue());
                    break;
                }
                break;
            case com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_SET_ENABLE_SHOW_COMPLIANCE_DIALOG /* 223313 */:
                if (valueSet != null) {
                    vw(((java.lang.Boolean) valueSet.objectValue(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_PARAMETER_ENABLE_SHOW_COMPLIANCE_DIALOG, java.lang.Boolean.class)).booleanValue());
                    break;
                }
                break;
        }
        return null;
    }

    public boolean cp() {
        com.ss.android.download.api.download.DownloadController downloadController = this.vw;
        if (downloadController != null) {
            return downloadController.enableNewActivity();
        }
        return false;
    }

    public boolean d() {
        com.ss.android.download.api.download.DownloadController downloadController = this.vw;
        if (downloadController != null) {
            return downloadController.enableAH();
        }
        return false;
    }

    public org.json.JSONObject es() {
        com.ss.android.download.api.download.DownloadController downloadController = this.vw;
        if (downloadController != null) {
            return downloadController.getExtraJson();
        }
        return null;
    }

    public boolean j() {
        com.ss.android.download.api.download.DownloadController downloadController = this.vw;
        if (downloadController != null) {
            return downloadController.enableAM();
        }
        return false;
    }

    public int kz() {
        com.ss.android.download.api.download.DownloadController downloadController = this.vw;
        if (downloadController != null) {
            return downloadController.getDowloadChunkCount();
        }
        return 0;
    }

    public boolean o() {
        com.ss.android.download.api.download.DownloadController downloadController = this.vw;
        if (downloadController != null) {
            return downloadController.shouldUseNewWebView();
        }
        return false;
    }

    public boolean t() {
        com.ss.android.download.api.download.DownloadController downloadController = this.vw;
        if (downloadController != null) {
            return downloadController.isEnableBackDialog();
        }
        return false;
    }

    public boolean u() {
        com.ss.android.download.api.download.DownloadController downloadController = this.vw;
        if (downloadController != null) {
            return downloadController.isAutoDownloadOnCardShow();
        }
        return false;
    }

    public boolean v() {
        com.ss.android.download.api.download.DownloadController downloadController = this.vw;
        if (downloadController != null) {
            return downloadController.isAddToDownloadManage();
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public com.bykv.vk.openvk.api.proto.ValueSet values() {
        return com.bykv.vw.vw.vw.vw.wg.vw().vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_LINK_MODE, vw()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_DOWNLOAD_MODE, wg()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_IS_ENABLE_BACK_DIALOG, t()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_IS_ADD_TO_DOWNLOAD_MANAGE, v()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_IS_ENABLE_MULTIPLE_DOWNLOAD, yl()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_DOWNLOAD_CHUNK_COUNT, kz()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_EXTRA_CLICK_OPERATION, bt()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_SHOULD_USE_NEW_WEB_VIEW, o()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_INTERCEPT_FLAG, x()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_EXTRA_JSON, es()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_EXTRA_OBJECT, z()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_EXTRA_JSON, es()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_ENABLE_SHOW_COMPLIANCE_DIALOG, vl()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_IS_AUTO_DOWNLOAD_ON_CARD_SHOW, u()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_ENABLE_NEW_ACTIVITY, cp()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_ENABLE_AH, d()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_ENABLE_AM, j()).wg();
    }

    public boolean vl() {
        com.ss.android.download.api.download.DownloadController downloadController = this.vw;
        if (downloadController != null) {
            return downloadController.enableShowComplianceDialog();
        }
        return false;
    }

    public int vw() {
        com.ss.android.download.api.download.DownloadController downloadController = this.vw;
        if (downloadController != null) {
            return downloadController.getLinkMode();
        }
        return 0;
    }

    public void vw(int i) {
        com.ss.android.download.api.download.DownloadController downloadController = this.vw;
        if (downloadController != null) {
            downloadController.setDownloadMode(i);
        }
    }

    public void vw(boolean z) {
        com.ss.android.download.api.download.DownloadController downloadController = this.vw;
        if (downloadController != null) {
            downloadController.setEnableShowComplianceDialog(z);
        }
    }

    public int wg() {
        com.ss.android.download.api.download.DownloadController downloadController = this.vw;
        if (downloadController != null) {
            return downloadController.getDownloadMode();
        }
        return 0;
    }

    public void wg(int i) {
        com.ss.android.download.api.download.DownloadController downloadController = this.vw;
        if (downloadController != null) {
            downloadController.setLinkMode(i);
        }
    }

    public void wg(boolean z) {
        com.ss.android.download.api.download.DownloadController downloadController = this.vw;
        if (downloadController != null) {
            downloadController.setEnableNewActivity(z);
        }
    }

    public int x() {
        com.ss.android.download.api.download.DownloadController downloadController = this.vw;
        if (downloadController != null) {
            return downloadController.getInterceptFlag();
        }
        return 0;
    }

    public boolean yl() {
        com.ss.android.download.api.download.DownloadController downloadController = this.vw;
        if (downloadController != null) {
            return downloadController.isEnableMultipleDownload();
        }
        return false;
    }

    public java.lang.Object z() {
        com.ss.android.download.api.download.DownloadController downloadController = this.vw;
        if (downloadController != null) {
            return downloadController.getExtraObject();
        }
        return null;
    }
}
