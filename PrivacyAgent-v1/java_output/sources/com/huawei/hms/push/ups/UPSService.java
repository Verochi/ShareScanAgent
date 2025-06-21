package com.huawei.hms.push.ups;

/* loaded from: classes22.dex */
public final class UPSService {

    /* renamed from: com.huawei.hms.push.ups.UPSService$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.huawei.hmf.tasks.OnCompleteListener<java.lang.Void> {
        public final /* synthetic */ com.huawei.hms.push.ups.entity.UPSTurnCallBack a;

        public AnonymousClass1(com.huawei.hms.push.ups.entity.UPSTurnCallBack uPSTurnCallBack) {
            this.a = uPSTurnCallBack;
        }

        @Override // com.huawei.hmf.tasks.OnCompleteListener
        public void onComplete(com.huawei.hmf.tasks.Task<java.lang.Void> task) {
            if (task.isSuccessful()) {
                this.a.onResult(new com.huawei.hms.push.ups.entity.CodeResult());
            } else {
                com.huawei.hms.common.ApiException apiException = (com.huawei.hms.common.ApiException) task.getException();
                this.a.onResult(new com.huawei.hms.push.ups.entity.CodeResult(apiException.getStatusCode(), apiException.getMessage()));
            }
        }
    }

    /* renamed from: com.huawei.hms.push.ups.UPSService$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.huawei.hmf.tasks.OnCompleteListener<java.lang.Void> {
        public final /* synthetic */ com.huawei.hms.push.ups.entity.UPSTurnCallBack a;

        public AnonymousClass2(com.huawei.hms.push.ups.entity.UPSTurnCallBack uPSTurnCallBack) {
            this.a = uPSTurnCallBack;
        }

        @Override // com.huawei.hmf.tasks.OnCompleteListener
        public void onComplete(com.huawei.hmf.tasks.Task<java.lang.Void> task) {
            if (task.isSuccessful()) {
                this.a.onResult(new com.huawei.hms.push.ups.entity.CodeResult());
            } else {
                com.huawei.hms.common.ApiException apiException = (com.huawei.hms.common.ApiException) task.getException();
                this.a.onResult(new com.huawei.hms.push.ups.entity.CodeResult(apiException.getStatusCode(), apiException.getMessage()));
            }
        }
    }

    public static void registerToken(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, com.huawei.hms.push.ups.entity.UPSRegisterCallBack uPSRegisterCallBack) {
        com.huawei.hms.support.log.HMSLog.i("UPSService", "invoke registerToken");
        com.huawei.hms.common.internal.Preconditions.checkNotNull(uPSRegisterCallBack);
        if (!com.huawei.hms.push.s.b()) {
            uPSRegisterCallBack.onResult(new com.huawei.hms.push.ups.entity.TokenResult(com.huawei.hms.aaid.constant.ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.getExternalCode()));
            return;
        }
        try {
            uPSRegisterCallBack.onResult(new com.huawei.hms.push.ups.entity.TokenResult(com.huawei.hms.aaid.HmsInstanceId.getInstance(context).getToken(str, null)));
        } catch (com.huawei.hms.common.ApiException e) {
            uPSRegisterCallBack.onResult(new com.huawei.hms.push.ups.entity.TokenResult(e.getStatusCode(), e.getMessage()));
        }
    }

    public static void turnOffPush(android.content.Context context, com.huawei.hms.push.ups.entity.UPSTurnCallBack uPSTurnCallBack) {
        com.huawei.hms.support.log.HMSLog.i("UPSService", "invoke turnOffPush");
        com.huawei.hms.common.internal.Preconditions.checkNotNull(uPSTurnCallBack);
        if (com.huawei.hms.push.s.b()) {
            com.huawei.hms.push.HmsMessaging.getInstance(context).turnOffPush().addOnCompleteListener(new com.huawei.hms.push.ups.UPSService.AnonymousClass2(uPSTurnCallBack));
        } else {
            uPSTurnCallBack.onResult(new com.huawei.hms.push.ups.entity.TokenResult(com.huawei.hms.aaid.constant.ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.getExternalCode()));
        }
    }

    public static void turnOnPush(android.content.Context context, com.huawei.hms.push.ups.entity.UPSTurnCallBack uPSTurnCallBack) {
        com.huawei.hms.support.log.HMSLog.i("UPSService", "invoke turnOnPush");
        com.huawei.hms.common.internal.Preconditions.checkNotNull(uPSTurnCallBack);
        if (com.huawei.hms.push.s.b()) {
            com.huawei.hms.push.HmsMessaging.getInstance(context).turnOnPush().addOnCompleteListener(new com.huawei.hms.push.ups.UPSService.AnonymousClass1(uPSTurnCallBack));
        } else {
            uPSTurnCallBack.onResult(new com.huawei.hms.push.ups.entity.TokenResult(com.huawei.hms.aaid.constant.ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.getExternalCode()));
        }
    }

    public static void unRegisterToken(android.content.Context context, com.huawei.hms.push.ups.entity.UPSUnRegisterCallBack uPSUnRegisterCallBack) {
        com.huawei.hms.support.log.HMSLog.i("UPSService", "invoke unRegisterToken");
        com.huawei.hms.common.internal.Preconditions.checkNotNull(uPSUnRegisterCallBack);
        if (!com.huawei.hms.push.s.b()) {
            uPSUnRegisterCallBack.onResult(new com.huawei.hms.push.ups.entity.TokenResult(com.huawei.hms.aaid.constant.ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.getExternalCode()));
            return;
        }
        try {
            com.huawei.hms.aaid.HmsInstanceId.getInstance(context).deleteToken(null, null);
            uPSUnRegisterCallBack.onResult(new com.huawei.hms.push.ups.entity.TokenResult());
        } catch (com.huawei.hms.common.ApiException e) {
            uPSUnRegisterCallBack.onResult(new com.huawei.hms.push.ups.entity.TokenResult(e.getStatusCode(), e.getMessage()));
        }
    }
}
