package com.huawei.hms.support.api.core;

/* loaded from: classes22.dex */
public final class ConnectService {

    public static class a extends com.huawei.hms.support.api.PendingResultImpl<com.huawei.hms.support.api.ResolveResult<com.huawei.hms.support.api.entity.core.ConnectResp>, com.huawei.hms.support.api.entity.core.ConnectResp> {
        public a(com.huawei.hms.support.api.client.ApiClient apiClient, java.lang.String str, com.huawei.hms.core.aidl.IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.huawei.hms.support.api.ResolveResult<com.huawei.hms.support.api.entity.core.ConnectResp> onComplete(com.huawei.hms.support.api.entity.core.ConnectResp connectResp) {
            com.huawei.hms.support.api.ResolveResult<com.huawei.hms.support.api.entity.core.ConnectResp> resolveResult = new com.huawei.hms.support.api.ResolveResult<>(connectResp);
            resolveResult.setStatus(com.huawei.hms.support.api.client.Status.SUCCESS);
            com.huawei.hms.support.log.HMSLog.d("connectservice", "connect - onComplete: success");
            return resolveResult;
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        public boolean checkApiClient(com.huawei.hms.support.api.client.ApiClient apiClient) {
            return apiClient != null;
        }
    }

    public static class b extends com.huawei.hms.support.api.PendingResultImpl<com.huawei.hms.support.api.ResolveResult<com.huawei.hms.support.api.entity.core.ConnectResp>, com.huawei.hms.support.api.entity.core.ConnectResp> {
        public b(com.huawei.hms.support.api.client.ApiClient apiClient, java.lang.String str, com.huawei.hms.core.aidl.IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.huawei.hms.support.api.ResolveResult<com.huawei.hms.support.api.entity.core.ConnectResp> onComplete(com.huawei.hms.support.api.entity.core.ConnectResp connectResp) {
            com.huawei.hms.support.api.ResolveResult<com.huawei.hms.support.api.entity.core.ConnectResp> resolveResult = new com.huawei.hms.support.api.ResolveResult<>(connectResp);
            resolveResult.setStatus(com.huawei.hms.support.api.client.Status.SUCCESS);
            com.huawei.hms.support.log.HMSLog.d("connectservice", "forceConnect - onComplete: success");
            return resolveResult;
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        public boolean checkApiClient(com.huawei.hms.support.api.client.ApiClient apiClient) {
            return apiClient != null;
        }
    }

    public static class c extends com.huawei.hms.support.api.PendingResultImpl<com.huawei.hms.support.api.ResolveResult<com.huawei.hms.support.api.entity.core.JosGetNoticeResp>, com.huawei.hms.support.api.entity.core.JosGetNoticeResp> {
        public c(com.huawei.hms.support.api.client.ApiClient apiClient, java.lang.String str, com.huawei.hms.core.aidl.IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.huawei.hms.support.api.ResolveResult<com.huawei.hms.support.api.entity.core.JosGetNoticeResp> onComplete(com.huawei.hms.support.api.entity.core.JosGetNoticeResp josGetNoticeResp) {
            if (josGetNoticeResp == null) {
                com.huawei.hms.support.log.HMSLog.e("connectservice", "JosNoticeResp is null");
                return null;
            }
            com.huawei.hms.support.log.HMSLog.i("connectservice", "josNoticeResp status code :" + josGetNoticeResp.getStatusCode());
            com.huawei.hms.support.api.ResolveResult<com.huawei.hms.support.api.entity.core.JosGetNoticeResp> resolveResult = new com.huawei.hms.support.api.ResolveResult<>(josGetNoticeResp);
            resolveResult.setStatus(com.huawei.hms.support.api.client.Status.SUCCESS);
            return resolveResult;
        }
    }

    private ConnectService() {
    }

    public static com.huawei.hms.support.api.client.InnerPendingResult<com.huawei.hms.support.api.ResolveResult<com.huawei.hms.support.api.entity.core.CheckConnectResp>> checkconnect(com.huawei.hms.support.api.client.ApiClient apiClient, com.huawei.hms.support.api.entity.core.CheckConnectInfo checkConnectInfo) {
        return com.huawei.hms.support.api.ResolvePendingResult.build(apiClient, com.huawei.hms.support.api.entity.core.CoreNaming.CHECKCONNECT, checkConnectInfo, com.huawei.hms.support.api.entity.core.CheckConnectResp.class);
    }

    public static com.huawei.hms.support.api.client.PendingResult<com.huawei.hms.support.api.ResolveResult<com.huawei.hms.support.api.entity.core.ConnectResp>> connect(com.huawei.hms.support.api.client.ApiClient apiClient, com.huawei.hms.support.api.entity.core.ConnectInfo connectInfo) {
        return new com.huawei.hms.support.api.core.ConnectService.a(apiClient, com.huawei.hms.support.api.entity.core.CoreNaming.CONNECT, connectInfo);
    }

    public static com.huawei.hms.support.api.ResolvePendingResult<com.huawei.hms.support.api.entity.core.DisconnectResp> disconnect(com.huawei.hms.support.api.client.ApiClient apiClient, com.huawei.hms.support.api.entity.core.DisconnectInfo disconnectInfo) {
        return com.huawei.hms.support.api.ResolvePendingResult.build(apiClient, com.huawei.hms.support.api.entity.core.CoreNaming.DISCONNECT, disconnectInfo, com.huawei.hms.support.api.entity.core.DisconnectResp.class);
    }

    public static com.huawei.hms.support.api.client.PendingResult<com.huawei.hms.support.api.ResolveResult<com.huawei.hms.support.api.entity.core.ConnectResp>> forceConnect(com.huawei.hms.support.api.client.ApiClient apiClient, com.huawei.hms.support.api.entity.core.ConnectInfo connectInfo) {
        return new com.huawei.hms.support.api.core.ConnectService.b(apiClient, com.huawei.hms.support.api.entity.core.CoreNaming.FORECONNECT, connectInfo);
    }

    public static com.huawei.hms.support.api.client.PendingResult<com.huawei.hms.support.api.ResolveResult<com.huawei.hms.support.api.entity.core.JosGetNoticeResp>> getNotice(com.huawei.hms.support.api.client.ApiClient apiClient, int i, java.lang.String str) {
        com.huawei.hms.support.api.entity.core.JosGetNoticeReq josGetNoticeReq = new com.huawei.hms.support.api.entity.core.JosGetNoticeReq();
        josGetNoticeReq.setNoticeType(i);
        josGetNoticeReq.setHmsSdkVersionName(str);
        if (!android.text.TextUtils.isEmpty(apiClient.getCpID())) {
            josGetNoticeReq.setCpID(apiClient.getCpID());
        }
        return new com.huawei.hms.support.api.core.ConnectService.c(apiClient, com.huawei.hms.support.api.entity.core.CoreNaming.GETNOTICE, josGetNoticeReq);
    }
}
