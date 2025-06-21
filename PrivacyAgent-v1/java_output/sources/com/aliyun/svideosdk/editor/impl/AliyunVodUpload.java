package com.aliyun.svideosdk.editor.impl;

/* loaded from: classes12.dex */
public class AliyunVodUpload implements com.aliyun.svideosdk.editor.AliyunIVodUpload {
    private com.alibaba.sdk.android.vod.upload.VODUploadClient a;
    private java.util.Map<java.lang.String, java.lang.String> b = new java.util.HashMap();
    private java.util.Map<java.lang.String, java.lang.String> c = new java.util.HashMap();

    @com.aliyun.Visible
    public final class VodUploadCallbackImpl extends com.alibaba.sdk.android.vod.upload.VODUploadCallback {
        com.aliyun.svideosdk.editor.AliyunIVodUpload.AliyunIVodUploadCallBack mAliyunIVodUploadCallBack;

        public VodUploadCallbackImpl(com.aliyun.svideosdk.editor.AliyunIVodUpload.AliyunIVodUploadCallBack aliyunIVodUploadCallBack) {
            this.mAliyunIVodUploadCallBack = aliyunIVodUploadCallBack;
        }

        @Override // com.alibaba.sdk.android.vod.upload.VODUploadCallback
        public void onUploadFailed(com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo, java.lang.String str, java.lang.String str2) {
            super.onUploadFailed(uploadFileInfo, str, str2);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Bucket:");
            sb.append(uploadFileInfo.getBucket());
            sb.append("\nObjectKey:");
            sb.append(uploadFileInfo.getObject());
            com.aliyun.svideosdk.editor.AliyunIVodUpload.AliyunIVodUploadCallBack aliyunIVodUploadCallBack = this.mAliyunIVodUploadCallBack;
            if (aliyunIVodUploadCallBack != null) {
                aliyunIVodUploadCallBack.onUploadFailed(str, str2);
            }
        }

        @Override // com.alibaba.sdk.android.vod.upload.VODUploadCallback
        public void onUploadProgress(com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo, long j, long j2) {
            super.onUploadProgress(uploadFileInfo, j, j2);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("onUploadProgress:uploadedSize:");
            sb.append(j);
            sb.append("\ntotalSize:");
            sb.append(j2);
            com.aliyun.svideosdk.editor.AliyunIVodUpload.AliyunIVodUploadCallBack aliyunIVodUploadCallBack = this.mAliyunIVodUploadCallBack;
            if (aliyunIVodUploadCallBack != null) {
                aliyunIVodUploadCallBack.onUploadProgress(j, j2);
            }
        }

        @Override // com.alibaba.sdk.android.vod.upload.VODUploadCallback
        public void onUploadRetry(java.lang.String str, java.lang.String str2) {
            super.onUploadRetry(str, str2);
        }

        @Override // com.alibaba.sdk.android.vod.upload.VODUploadCallback
        public void onUploadRetryResume() {
            super.onUploadRetryResume();
        }

        @Override // com.alibaba.sdk.android.vod.upload.VODUploadCallback
        public void onUploadStarted(com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo) {
            super.onUploadStarted(uploadFileInfo);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("onUploadStarted:");
            sb.append(com.aliyun.common.utils.MD5Util.getMD5(uploadFileInfo.getFilePath()));
            java.lang.String str = (java.lang.String) com.aliyun.svideosdk.editor.impl.AliyunVodUpload.this.c.get(com.aliyun.common.utils.MD5Util.getMD5(uploadFileInfo.getFilePath()));
            java.lang.String str2 = (java.lang.String) com.aliyun.svideosdk.editor.impl.AliyunVodUpload.this.b.get(com.aliyun.common.utils.MD5Util.getMD5(uploadFileInfo.getFilePath()));
            if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
                throw new java.lang.RuntimeException("upload status error!");
            }
            com.aliyun.svideosdk.editor.impl.AliyunVodUpload.this.a.setUploadAuthAndAddress(uploadFileInfo, str, str2);
        }

        @Override // com.alibaba.sdk.android.vod.upload.VODUploadCallback
        public void onUploadSucceed(com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo) {
            super.onUploadSucceed(uploadFileInfo);
        }

        @Override // com.alibaba.sdk.android.vod.upload.VODUploadCallback
        public void onUploadSucceed(com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo, com.alibaba.sdk.android.vod.upload.model.VodUploadResult vodUploadResult) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Bucket:");
            sb.append(uploadFileInfo.getBucket());
            sb.append("\nObjectKey:");
            sb.append(uploadFileInfo.getObject());
            com.aliyun.svideosdk.editor.AliyunIVodUpload.AliyunIVodUploadCallBack aliyunIVodUploadCallBack = this.mAliyunIVodUploadCallBack;
            if (aliyunIVodUploadCallBack != null) {
                aliyunIVodUploadCallBack.onUploadSucceed();
            }
        }

        @Override // com.alibaba.sdk.android.vod.upload.VODUploadCallback
        public void onUploadTokenExpired() {
            super.onUploadTokenExpired();
            com.aliyun.svideosdk.editor.AliyunIVodUpload.AliyunIVodUploadCallBack aliyunIVodUploadCallBack = this.mAliyunIVodUploadCallBack;
            if (aliyunIVodUploadCallBack != null) {
                aliyunIVodUploadCallBack.onUploadTokenExpired();
            }
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodUpload
    public int cancelUpload() {
        com.alibaba.sdk.android.vod.upload.VODUploadClient vODUploadClient = this.a;
        if (vODUploadClient == null) {
            return 0;
        }
        vODUploadClient.stop();
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodUpload
    public int init(android.content.Context context, com.aliyun.svideosdk.editor.AliyunIVodUpload.AliyunIVodUploadCallBack aliyunIVodUploadCallBack) {
        if (this.a == null) {
            this.a = new com.alibaba.sdk.android.vod.upload.VODUploadClientImpl(context);
        }
        this.a.init(new com.aliyun.svideosdk.editor.impl.AliyunVodUpload.VodUploadCallbackImpl(aliyunIVodUploadCallBack));
        this.a.setPartSize(1048576L);
        this.a.setRecordUploadProgressEnabled(false);
        this.a.setVodHttpClientConfig(com.alibaba.sdk.android.vod.upload.session.VodHttpClientConfig.builder().setMaxRetryCount(Integer.MAX_VALUE).setConnectionTimeout(15000).setSocketTimeout(15000).build());
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodUpload
    public int init(android.content.Context context, com.aliyun.svideosdk.editor.AliyunIVodUpload.AliyunIVodUploadCallBack aliyunIVodUploadCallBack, boolean z) {
        if (this.a == null) {
            this.a = new com.alibaba.sdk.android.vod.upload.VODUploadClientImpl(context);
        }
        ((com.alibaba.sdk.android.vod.upload.VODUploadClientImpl) this.a).setReportEnabled(z);
        this.a.init(new com.aliyun.svideosdk.editor.impl.AliyunVodUpload.VodUploadCallbackImpl(aliyunIVodUploadCallBack));
        this.a.setPartSize(1048576L);
        this.a.setRecordUploadProgressEnabled(false);
        this.a.setVodHttpClientConfig(com.alibaba.sdk.android.vod.upload.session.VodHttpClientConfig.builder().setMaxRetryCount(Integer.MAX_VALUE).setConnectionTimeout(15000).setSocketTimeout(15000).build());
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodUpload
    public int pauseUpload() {
        com.alibaba.sdk.android.vod.upload.VODUploadClient vODUploadClient = this.a;
        if (vODUploadClient == null) {
            return 0;
        }
        vODUploadClient.pause();
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodUpload
    public int refreshWithUploadAuth(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return -20003001;
        }
        this.a.resumeWithAuth(str);
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodUpload
    public void release() {
        com.alibaba.sdk.android.vod.upload.VODUploadClient vODUploadClient = this.a;
        if (vODUploadClient != null) {
            vODUploadClient.stop();
            this.a = null;
        }
        this.b.clear();
        this.c.clear();
        this.b = null;
        this.c = null;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodUpload
    public int resumeUpload() {
        com.alibaba.sdk.android.vod.upload.VODUploadClient vODUploadClient = this.a;
        if (vODUploadClient == null) {
            return 0;
        }
        vODUploadClient.resume();
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodUpload
    public void updatePartInfoList(java.lang.String str, java.util.List<com.alibaba.sdk.android.vod.upload.model.FilePartInfo> list, boolean z) {
        for (com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo : new java.util.ArrayList(this.a.listFiles())) {
            if (uploadFileInfo.getFilePath().equals(str)) {
                if (uploadFileInfo.getPartInfoList().size() < list.size()) {
                    uploadFileInfo.getPartInfoList().addAll(list.subList(uploadFileInfo.getPartInfoList().size(), list.size()));
                }
                if (z) {
                    com.alibaba.sdk.android.vod.upload.model.FilePartInfo filePartInfo = uploadFileInfo.getPartInfoList().get(uploadFileInfo.getPartInfoList().size() - 1);
                    uploadFileInfo.setFileLength(filePartInfo.getSeek() + filePartInfo.getSize());
                }
                if (uploadFileInfo.getStatus() == com.alibaba.sdk.android.vod.upload.common.UploadStateType.PAUSED || uploadFileInfo.getStatus() == com.alibaba.sdk.android.vod.upload.common.UploadStateType.PAUSING) {
                    this.a.pause();
                    this.a.resume();
                    return;
                }
                return;
            }
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodUpload
    public int uploadImageWithVod(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (!new java.io.File(str).exists()) {
            return -20003005;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("uploadImageWithVod:");
        sb.append(java.lang.String.valueOf(str));
        this.b.put(com.aliyun.common.utils.MD5Util.getMD5(str), str2);
        this.c.put(com.aliyun.common.utils.MD5Util.getMD5(str), str3);
        this.a.addFile(str, null);
        this.a.start();
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodUpload
    public int uploadVideoWithVod(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (!new java.io.File(str).exists()) {
            return -20003005;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("uploadVideoWithVod:");
        sb.append(java.lang.String.valueOf(str));
        this.b.put(com.aliyun.common.utils.MD5Util.getMD5(str), str2);
        this.c.put(com.aliyun.common.utils.MD5Util.getMD5(str), str3);
        this.a.addFile(str, null);
        this.a.start();
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodUpload
    public int uploadVideoWithVod(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.List<com.alibaba.sdk.android.vod.upload.model.FilePartInfo> list) {
        if (!new java.io.File(str).exists()) {
            return -20003005;
        }
        this.b.put(com.aliyun.common.utils.MD5Util.getMD5(str), str2);
        this.c.put(com.aliyun.common.utils.MD5Util.getMD5(str), str3);
        this.a.addFile(str, null, list);
        this.a.start();
        return 0;
    }
}
