package com.alibaba.sdk.android.vod.upload.auth;

/* loaded from: classes.dex */
public class AliyunVodAuth {
    private static final java.lang.String TAG = "AliyunVodAuth";
    private java.lang.String createImageUrl = null;
    private java.lang.String createVideoUrl = null;
    private java.lang.String domainRegion = null;
    private com.aliyun.vod.jasonparse.JSONSupport jsonSupportImpl = new com.aliyun.vod.jasonparse.JSONSupportImpl();
    private com.aliyun.auth.core.VodThreadService mHttpService = new com.aliyun.auth.core.VodThreadService(java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
    private com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.VodAuthCallBack vodAuthCallBack;

    /* renamed from: com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$accessKeyId;
        final /* synthetic */ java.lang.String val$accessKeySecret;
        final /* synthetic */ java.lang.String val$appId;
        final /* synthetic */ boolean val$isCover;
        final /* synthetic */ java.lang.String val$requestID;
        final /* synthetic */ java.lang.String val$securityToken;
        final /* synthetic */ java.lang.String val$storageLocation;
        final /* synthetic */ com.alibaba.sdk.android.vod.upload.model.VodInfo val$vodInfo;

        /* renamed from: com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth$1$1, reason: invalid class name and collision with other inner class name */
        public class C00191 extends com.aliyun.vod.qupaiokhttp.StringHttpRequestCallback {
            public C00191() {
            }

            @Override // com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback
            public void onFailure(int i, java.lang.String str) {
                super.onFailure(i, str);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("code");
                sb.append(i);
                sb.append("msg");
                sb.append(str);
                sb.append("time:");
                sb.append(java.lang.System.currentTimeMillis());
                if (i != 1003 || com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this.vodAuthCallBack == null) {
                    return;
                }
                com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this.vodAuthCallBack.onError(com.aliyun.auth.core.AliyunVodErrorCode.VODERRORCODE_HTTP_ABNORMAL, "http error response unknown.");
            }

            @Override // com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback
            public void onResponse(okhttp3.Response response, java.lang.String str, okhttp3.Headers headers) {
                super.onResponse(response, str, headers);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("httpResponse");
                sb.append(response);
                sb.append("\nmsg");
                sb.append(str);
                sb.append("\nheaders");
                sb.append(headers);
                if (response == null || response.code() == 200) {
                    return;
                }
                try {
                    com.aliyun.auth.model.VodErrorResponse vodErrorResponse = (com.aliyun.auth.model.VodErrorResponse) com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this.jsonSupportImpl.readValue(str, com.aliyun.auth.model.VodErrorResponse.class);
                    if (vodErrorResponse.getCode().equals(com.aliyun.auth.core.AliyunVodErrorCode.VODERRORCODE_INVALIDSECURITYTOKEN_EXPIRED)) {
                        if (com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this.vodAuthCallBack != null) {
                            com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this.vodAuthCallBack.onSTSExpired(com.aliyun.auth.common.AliyunVodUploadType.IMAGE);
                        }
                    } else if (com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this.vodAuthCallBack != null) {
                        com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this.vodAuthCallBack.onError(vodErrorResponse.getCode(), vodErrorResponse.getMessage());
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback
            public void onSuccess(okhttp3.Headers headers, java.lang.String str) {
                super.onSuccess(headers, (okhttp3.Headers) str);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HEADERS);
                sb.append(headers);
                sb.append("\nmsg");
                sb.append(str);
                try {
                    com.aliyun.auth.model.CreateImageForm createImageForm = (com.aliyun.auth.model.CreateImageForm) com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this.jsonSupportImpl.readValue(str, com.aliyun.auth.model.CreateImageForm.class);
                    if (com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this.vodAuthCallBack != null) {
                        com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this.vodAuthCallBack.onCreateUploadImaged(createImageForm);
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                    if (!(e instanceof com.google.gson.JsonSyntaxException) || com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this.vodAuthCallBack == null) {
                        return;
                    }
                    com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this.vodAuthCallBack.onError(com.aliyun.auth.core.AliyunVodErrorCode.VODERRORCODE_HTTP_ABNORMAL, "The network is abnormal, please check your network connection.");
                }
            }
        }

        public AnonymousClass1(java.lang.String str, java.lang.String str2, java.lang.String str3, com.alibaba.sdk.android.vod.upload.model.VodInfo vodInfo, java.lang.String str4, java.lang.String str5, boolean z, java.lang.String str6) {
            this.val$accessKeyId = str;
            this.val$securityToken = str2;
            this.val$requestID = str3;
            this.val$vodInfo = vodInfo;
            this.val$storageLocation = str4;
            this.val$appId = str5;
            this.val$isCover = z;
            this.val$accessKeySecret = str6;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth aliyunVodAuth = com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this;
            aliyunVodAuth.createImageUrl = com.alibaba.sdk.android.vod.upload.auth.AliyunVodParam.generateOpenAPIURL(aliyunVodAuth.domainRegion, com.alibaba.sdk.android.vod.upload.auth.AliyunVodParam.generatePublicParamters(this.val$accessKeyId, this.val$securityToken, this.val$requestID), com.alibaba.sdk.android.vod.upload.auth.AliyunVodParam.generatePrivateParamtersToUploadImage(this.val$vodInfo, this.val$storageLocation, this.val$appId, this.val$isCover), this.val$accessKeySecret);
            com.aliyun.vod.qupaiokhttp.HttpRequest.get(com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this.createImageUrl, new com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.AnonymousClass1.C00191());
        }
    }

    /* renamed from: com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$accessKeyId;
        final /* synthetic */ java.lang.String val$accessKeySecret;
        final /* synthetic */ java.lang.String val$appId;
        final /* synthetic */ java.lang.String val$requestID;
        final /* synthetic */ java.lang.String val$securityToken;
        final /* synthetic */ java.lang.String val$storageLocation;
        final /* synthetic */ java.lang.String val$templateGroupId;
        final /* synthetic */ boolean val$transcodeMode;
        final /* synthetic */ com.alibaba.sdk.android.vod.upload.model.VodInfo val$vodInfo;
        final /* synthetic */ java.lang.String val$workFlowId;

        /* renamed from: com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth$2$1, reason: invalid class name */
        public class AnonymousClass1 extends com.aliyun.vod.qupaiokhttp.StringHttpRequestCallback {
            public AnonymousClass1() {
            }

            @Override // com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback
            public void onFailure(int i, java.lang.String str) {
                super.onFailure(i, str);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("code");
                sb.append(i);
                sb.append("msg");
                sb.append(str);
                if (i == 1003) {
                    com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this.vodAuthCallBack.onError(com.aliyun.auth.core.AliyunVodErrorCode.VODERRORCODE_HTTP_ABNORMAL, "http error response unknown.");
                }
            }

            @Override // com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback
            public void onResponse(okhttp3.Response response, java.lang.String str, okhttp3.Headers headers) {
                super.onResponse(response, str, headers);
                if (response == null || response.code() == 200) {
                    return;
                }
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("onResponse --- createUploadVideo");
                sb.append(response);
                sb.append(str);
                try {
                    com.aliyun.auth.model.VodErrorResponse vodErrorResponse = (com.aliyun.auth.model.VodErrorResponse) com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this.jsonSupportImpl.readValue(str, com.aliyun.auth.model.VodErrorResponse.class);
                    if (com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this.vodAuthCallBack != null) {
                        if (vodErrorResponse.getCode().equals(com.aliyun.auth.core.AliyunVodErrorCode.VODERRORCODE_INVALIDSECURITYTOKEN_EXPIRED)) {
                            com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this.vodAuthCallBack.onSTSExpired(com.aliyun.auth.common.AliyunVodUploadType.VIDEO);
                        } else {
                            com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this.vodAuthCallBack.onError(vodErrorResponse.getCode(), vodErrorResponse.getMessage());
                        }
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback
            public void onSuccess(okhttp3.Headers headers, java.lang.String str) {
                super.onSuccess(headers, (okhttp3.Headers) str);
                try {
                    com.aliyun.auth.model.CreateVideoForm createVideoForm = (com.aliyun.auth.model.CreateVideoForm) com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this.jsonSupportImpl.readValue(str, com.aliyun.auth.model.CreateVideoForm.class);
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("onSuccess --- createUploadVideogetUploadAuth:");
                    sb.append(createVideoForm.getUploadAuth());
                    sb.append("getUploadAddress");
                    sb.append(createVideoForm.getUploadAddress());
                    sb.append("\nrequestID:");
                    sb.append(createVideoForm.getRequestId());
                    if (com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this.vodAuthCallBack != null) {
                        com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this.vodAuthCallBack.onCreateUploadVideoed(createVideoForm, com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.AnonymousClass2.this.val$vodInfo.getCoverUrl());
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                    if (!(e instanceof com.google.gson.JsonSyntaxException) || com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this.vodAuthCallBack == null) {
                        return;
                    }
                    com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this.vodAuthCallBack.onError(com.aliyun.auth.core.AliyunVodErrorCode.VODERRORCODE_HTTP_ABNORMAL, "The network is abnormal. Please check your network connection. Your network may need to log in.");
                }
            }
        }

        public AnonymousClass2(java.lang.String str, java.lang.String str2, java.lang.String str3, com.alibaba.sdk.android.vod.upload.model.VodInfo vodInfo, boolean z, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8) {
            this.val$accessKeyId = str;
            this.val$securityToken = str2;
            this.val$requestID = str3;
            this.val$vodInfo = vodInfo;
            this.val$transcodeMode = z;
            this.val$templateGroupId = str4;
            this.val$storageLocation = str5;
            this.val$workFlowId = str6;
            this.val$appId = str7;
            this.val$accessKeySecret = str8;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth aliyunVodAuth = com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this;
            aliyunVodAuth.createVideoUrl = com.alibaba.sdk.android.vod.upload.auth.AliyunVodParam.generateOpenAPIURL(aliyunVodAuth.domainRegion, com.alibaba.sdk.android.vod.upload.auth.AliyunVodParam.generatePublicParamters(this.val$accessKeyId, this.val$securityToken, this.val$requestID), com.alibaba.sdk.android.vod.upload.auth.AliyunVodParam.generatePrivateParamtersToUploadVideo(this.val$vodInfo, this.val$transcodeMode, this.val$templateGroupId, this.val$storageLocation, this.val$workFlowId, this.val$appId), this.val$accessKeySecret);
            com.aliyun.vod.qupaiokhttp.HttpRequest.get(com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this.createVideoUrl, new com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.AnonymousClass2.AnonymousClass1());
        }
    }

    /* renamed from: com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$accessKeyId;
        final /* synthetic */ java.lang.String val$accessKeySecret;
        final /* synthetic */ java.lang.String val$coverurl;
        final /* synthetic */ java.lang.String val$requestID;
        final /* synthetic */ java.lang.String val$securityToken;
        final /* synthetic */ java.lang.String val$videoId;

        /* renamed from: com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth$3$1, reason: invalid class name */
        public class AnonymousClass1 extends com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback {
            public AnonymousClass1() {
            }

            @Override // com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback
            public void onFailure(int i, java.lang.String str) {
                super.onFailure(i, str);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("code");
                sb.append(i);
                sb.append("msg");
                sb.append(str);
            }

            @Override // com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback
            public void onResponse(okhttp3.Response response, java.lang.String str, okhttp3.Headers headers) {
                java.lang.String str2;
                java.lang.String str3;
                super.onResponse(response, str, headers);
                if (response == null || response.code() == 200) {
                    return;
                }
                try {
                    if (com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this.vodAuthCallBack != null) {
                        com.aliyun.auth.model.VodErrorResponse vodErrorResponse = (com.aliyun.auth.model.VodErrorResponse) com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this.jsonSupportImpl.readValue(str, com.aliyun.auth.model.VodErrorResponse.class);
                        if (vodErrorResponse != null) {
                            str2 = vodErrorResponse.getCode();
                            str3 = vodErrorResponse.getMessage();
                        } else {
                            str2 = com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN;
                            str3 = com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN;
                        }
                        if (com.aliyun.auth.core.AliyunVodErrorCode.VODERRORCODE_INVALIDSECURITYTOKEN_EXPIRED.equals(str2)) {
                            com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this.vodAuthCallBack.onSTSExpired(com.aliyun.auth.common.AliyunVodUploadType.VIDEO);
                        } else {
                            com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this.vodAuthCallBack.onError(str2, str3);
                        }
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback
            public void onSuccess(okhttp3.Headers headers, java.lang.Object obj) {
                super.onSuccess(headers, obj);
                try {
                    if (com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this.vodAuthCallBack != null) {
                        com.aliyun.auth.model.CreateVideoForm createVideoForm = (com.aliyun.auth.model.CreateVideoForm) com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this.jsonSupportImpl.readValue((java.lang.String) obj, com.aliyun.auth.model.CreateVideoForm.class);
                        createVideoForm.setVideoId(com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.AnonymousClass3.this.val$videoId);
                        com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this.vodAuthCallBack.onCreateUploadVideoed(createVideoForm, com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.AnonymousClass3.this.val$coverurl);
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                    if (!(e instanceof com.google.gson.JsonSyntaxException) || com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this.vodAuthCallBack == null) {
                        return;
                    }
                    com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this.vodAuthCallBack.onError(com.aliyun.auth.core.AliyunVodErrorCode.VODERRORCODE_HTTP_ABNORMAL, "The network is abnormal. Please check your network connection. Your network may need to log in.");
                }
            }
        }

        public AnonymousClass3(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6) {
            this.val$accessKeyId = str;
            this.val$securityToken = str2;
            this.val$requestID = str3;
            this.val$videoId = str4;
            this.val$accessKeySecret = str5;
            this.val$coverurl = str6;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth aliyunVodAuth = com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this;
            aliyunVodAuth.createVideoUrl = com.alibaba.sdk.android.vod.upload.auth.AliyunVodParam.generateOpenAPIURL(aliyunVodAuth.domainRegion, com.alibaba.sdk.android.vod.upload.auth.AliyunVodParam.generatePublicParamters(this.val$accessKeyId, this.val$securityToken, this.val$requestID), com.alibaba.sdk.android.vod.upload.auth.AliyunVodParam.generatePrivateParamtersToReUploadVideo(this.val$videoId), this.val$accessKeySecret);
            com.aliyun.vod.qupaiokhttp.HttpRequest.get(com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.this.createVideoUrl, new com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.AnonymousClass3.AnonymousClass1());
        }
    }

    public interface VodAuthCallBack {
        void onCreateUploadImaged(com.aliyun.auth.model.CreateImageForm createImageForm);

        void onCreateUploadVideoed(com.aliyun.auth.model.CreateVideoForm createVideoForm, java.lang.String str);

        void onError(java.lang.String str, java.lang.String str2);

        void onSTSExpired(com.aliyun.auth.common.AliyunVodUploadType aliyunVodUploadType);
    }

    public AliyunVodAuth(com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.VodAuthCallBack vodAuthCallBack) {
        this.vodAuthCallBack = vodAuthCallBack;
    }

    public void cancel() {
        this.vodAuthCallBack = null;
        java.lang.String str = this.createImageUrl;
        if (str != null) {
            com.aliyun.vod.qupaiokhttp.HttpRequest.cancel(str);
        }
        java.lang.String str2 = this.createVideoUrl;
        if (str2 != null) {
            com.aliyun.vod.qupaiokhttp.HttpRequest.cancel(str2);
        }
    }

    public void createUploadImage(java.lang.String str, java.lang.String str2, java.lang.String str3, com.alibaba.sdk.android.vod.upload.model.VodInfo vodInfo, java.lang.String str4, java.lang.String str5, java.lang.String str6, boolean z) {
        this.mHttpService.execute(new com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.AnonymousClass1(str, str3, str6, vodInfo, str4, str5, z, str2));
    }

    public void createUploadVideo(java.lang.String str, java.lang.String str2, java.lang.String str3, com.alibaba.sdk.android.vod.upload.model.VodInfo vodInfo, boolean z, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8) {
        this.mHttpService.execute(new com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.AnonymousClass2(str, str3, str8, vodInfo, z, str4, str5, str6, str7, str2));
    }

    public void refreshUploadVideo(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6) {
        this.mHttpService.execute(new com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.AnonymousClass3(str, str3, str6, str4, str2, str5));
    }

    public void setDomainRegion(java.lang.String str) {
        this.domainRegion = str;
    }
}
