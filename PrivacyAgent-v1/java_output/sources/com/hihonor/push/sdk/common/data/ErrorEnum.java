package com.hihonor.push.sdk.common.data;

/* loaded from: classes22.dex */
public enum ErrorEnum {
    SUCCESS(0, "success"),
    ERROR_NOT_SUPPORT_PUSH(com.hihonor.push.sdk.common.data.ErrorCode.ERROR_NOT_SUPPORT_PUSH, "device is not support push."),
    ERROR_MAIN_THREAD(com.hihonor.push.sdk.common.data.ErrorCode.ERROR_MAIN_THREAD, "operation in MAIN thread prohibited."),
    ERROR_NO_TOKEN(com.hihonor.push.sdk.common.data.ErrorCode.ERROR_NO_TOKEN, "token missing."),
    ERROR_NO_APPID(com.hihonor.push.sdk.common.data.ErrorCode.ERROR_NO_APPID, "app id missing."),
    ERROR_CERT_FINGERPRINT_EMPTY(com.hihonor.push.sdk.common.data.ErrorCode.CERT_FINGERPRINT_EMPTY, "certificate fingerprint empty."),
    ERROR_BIND_SERVICE(com.hihonor.push.sdk.common.data.ErrorCode.BindService.ERROR_BIND_SERVICE, "bind service failed."),
    ERROR_SERVICE_DISCONNECTED(com.hihonor.push.sdk.common.data.ErrorCode.BindService.ERROR_SERVICE_DISCONNECTED, "service disconnected."),
    ERROR_SERVICE_TIME_OUT(com.hihonor.push.sdk.common.data.ErrorCode.BindService.ERROR_SERVICE_TIME_OUT, "service connect time out."),
    ERROR_SERVICE_ARGUMENTS_INVALID(com.hihonor.push.sdk.common.data.ErrorCode.BindService.ERROR_SERVICE_ARGUMENTS_INVALID, "service arguments invalid."),
    ERROR_SERVICE_NULL_BINDING(com.hihonor.push.sdk.common.data.ErrorCode.BindService.ERROR_SERVICE_NULL_BINDING, "service being bound has return null."),
    ERROR_SERVICE_INVALID(com.hihonor.push.sdk.common.data.ErrorCode.BindService.ERROR_SERVICE_INVALID, "service invalid."),
    ERROR_SERVICE_DISABLED(com.hihonor.push.sdk.common.data.ErrorCode.BindService.ERROR_SERVICE_DISABLED, "service disabled."),
    ERROR_SERVICE_MISSING(com.hihonor.push.sdk.common.data.ErrorCode.BindService.ERROR_SERVICE_MISSING, "service missing."),
    ERROR_PUSH_SERVER(com.hihonor.push.sdk.common.data.ErrorCode.PushService.ERROR_PUSH_SERVER, "push server error."),
    ERROR_UNKNOWN(com.hihonor.push.sdk.common.data.ErrorCode.PushService.ERROR_UNKNOWN, "unknown error."),
    ERROR_INTERNAL_ERROR(com.hihonor.push.sdk.common.data.ErrorCode.PushService.ERROR_INTERNAL, "internal error."),
    ERROR_ARGUMENTS_INVALID(com.hihonor.push.sdk.common.data.ErrorCode.PushService.ERROR_ARGUMENTS_INVALID, "arguments invalid."),
    ERROR_OPERATION_FREQUENTLY(com.hihonor.push.sdk.common.data.ErrorCode.PushService.ERROR_OPERATION_FREQUENTLY, "operation too frequently."),
    ERROR_NETWORK_NONE(com.hihonor.push.sdk.common.data.ErrorCode.PushService.ERROR_NETWORK_NONE, "no network."),
    ERROR_STATEMENT_AGREEMENT(com.hihonor.push.sdk.common.data.ErrorCode.PushService.ERROR_STATEMENT_AGREEMENT, "not statement agreement."),
    ERROR_SERVICE_REQUEST_TIME_OUT(com.hihonor.push.sdk.common.data.ErrorCode.PushService.ERROR_SERVICE_REQUEST_TIME_OUT, "service request time out."),
    ERROR_HTTP_OPERATION_FREQUENTLY(com.hihonor.push.sdk.common.data.ErrorCode.HttpService.ERROR_HTTP_OPERATION_FREQUENTLY, "http operation too frequently.");

    public static final android.util.SparseArray<com.hihonor.push.sdk.common.data.ErrorEnum> ENUM_MAPPER = new android.util.SparseArray<>();
    public java.lang.String message;
    public int statusCode;

    static {
        com.hihonor.push.sdk.common.data.ErrorEnum[] values = values();
        for (int i = 0; i < 23; i++) {
            com.hihonor.push.sdk.common.data.ErrorEnum errorEnum = values[i];
            ENUM_MAPPER.put(errorEnum.statusCode, errorEnum);
        }
    }

    ErrorEnum(int i, java.lang.String str) {
        this.statusCode = i;
        this.message = str;
    }

    public static com.hihonor.push.sdk.common.data.ErrorEnum fromCode(int i) {
        return ENUM_MAPPER.get(i, ERROR_UNKNOWN);
    }

    public final int getErrorCode() {
        return this.statusCode;
    }

    public final java.lang.String getMessage() {
        return this.message;
    }

    public final com.hihonor.push.sdk.common.data.ApiException toApiException() {
        return new com.hihonor.push.sdk.common.data.ApiException(getErrorCode(), getMessage());
    }
}
