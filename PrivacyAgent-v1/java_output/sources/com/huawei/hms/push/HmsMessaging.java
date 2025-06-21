package com.huawei.hms.push;

/* loaded from: classes22.dex */
public class HmsMessaging {
    public static final java.lang.String DEFAULT_TOKEN_SCOPE = "HCM";
    public static final java.util.regex.Pattern a = java.util.regex.Pattern.compile("[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
    public android.content.Context b;
    public com.huawei.hms.common.HuaweiApi<com.huawei.hms.api.Api.ApiOptions.NoOptions> c;

    public HmsMessaging(android.content.Context context) {
        com.huawei.hms.common.internal.Preconditions.checkNotNull(context);
        this.b = context;
        com.huawei.hms.common.HuaweiApi<com.huawei.hms.api.Api.ApiOptions.NoOptions> huaweiApi = new com.huawei.hms.common.HuaweiApi<>(context, (com.huawei.hms.api.Api<com.huawei.hms.api.Api.ApiOptions>) new com.huawei.hms.api.Api(com.huawei.hms.api.HuaweiApiAvailability.HMS_API_NAME_PUSH), (com.huawei.hms.api.Api.ApiOptions) null, new com.huawei.hms.aaid.task.PushClientBuilder());
        this.c = huaweiApi;
        huaweiApi.setKitSdkVersion(60500300);
    }

    public static synchronized com.huawei.hms.push.HmsMessaging getInstance(android.content.Context context) {
        com.huawei.hms.push.HmsMessaging hmsMessaging;
        synchronized (com.huawei.hms.push.HmsMessaging.class) {
            hmsMessaging = new com.huawei.hms.push.HmsMessaging(context);
        }
        return hmsMessaging;
    }

    public final com.huawei.hmf.tasks.Task<java.lang.Void> a(java.lang.String str, java.lang.String str2) {
        java.lang.String reportEntry = com.huawei.hms.push.utils.PushBiUtil.reportEntry(this.b, com.huawei.hms.support.api.entity.push.PushNaming.SUBSCRIBE);
        if (str == null || !a.matcher(str).matches()) {
            com.huawei.hms.push.utils.PushBiUtil.reportExit(this.b, com.huawei.hms.support.api.entity.push.PushNaming.SUBSCRIBE, reportEntry, com.huawei.hms.aaid.constant.ErrorEnum.ERROR_ARGUMENTS_INVALID);
            com.huawei.hms.support.log.HMSLog.e("HmsMessaging", "Invalid topic: topic should match the format:[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
            throw new java.lang.IllegalArgumentException("Invalid topic: topic should match the format:[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
        }
        if (com.huawei.hms.aaid.plugin.ProxyCenter.getProxy() != null) {
            com.huawei.hms.support.log.HMSLog.i("HmsMessaging", "use proxy subscribe.");
            return android.text.TextUtils.equals(str2, "Sub") ? com.huawei.hms.aaid.plugin.ProxyCenter.getProxy().subscribe(this.b, str, reportEntry) : com.huawei.hms.aaid.plugin.ProxyCenter.getProxy().unsubscribe(this.b, str, reportEntry);
        }
        try {
            com.huawei.hms.aaid.constant.ErrorEnum a2 = com.huawei.hms.push.d.a(this.b);
            if (a2 != com.huawei.hms.aaid.constant.ErrorEnum.SUCCESS) {
                throw a2.toApiException();
            }
            if (com.huawei.hms.utils.NetWorkUtil.getNetworkType(this.b) == 0) {
                com.huawei.hms.support.log.HMSLog.e("HmsMessaging", "no network");
                throw com.huawei.hms.aaid.constant.ErrorEnum.ERROR_NO_NETWORK.toApiException();
            }
            com.huawei.hms.support.api.entity.push.SubscribeReq subscribeReq = new com.huawei.hms.support.api.entity.push.SubscribeReq(this.b, str2, str);
            subscribeReq.setToken(com.huawei.hms.aaid.utils.BaseUtils.getLocalToken(this.b, null));
            return com.huawei.hms.push.s.b() ? this.c.doWrite(new com.huawei.hms.push.task.BaseVoidTask(com.huawei.hms.support.api.entity.push.PushNaming.SUBSCRIBE, com.huawei.hms.utils.JsonUtil.createJsonString(subscribeReq), reportEntry)) : this.c.doWrite(new com.huawei.hms.push.task.SubscribeTask(com.huawei.hms.support.api.entity.push.PushNaming.SUBSCRIBE, com.huawei.hms.utils.JsonUtil.createJsonString(subscribeReq), reportEntry));
        } catch (com.huawei.hms.common.ApiException e) {
            com.huawei.hmf.tasks.TaskCompletionSource taskCompletionSource = new com.huawei.hmf.tasks.TaskCompletionSource();
            taskCompletionSource.setException(e);
            com.huawei.hms.push.utils.PushBiUtil.reportExit(this.b, com.huawei.hms.support.api.entity.push.PushNaming.SUBSCRIBE, reportEntry, e.getStatusCode());
            return taskCompletionSource.getTask();
        } catch (java.lang.Exception unused) {
            com.huawei.hmf.tasks.TaskCompletionSource taskCompletionSource2 = new com.huawei.hmf.tasks.TaskCompletionSource();
            com.huawei.hms.aaid.constant.ErrorEnum errorEnum = com.huawei.hms.aaid.constant.ErrorEnum.ERROR_INTERNAL_ERROR;
            taskCompletionSource2.setException(errorEnum.toApiException());
            com.huawei.hms.push.utils.PushBiUtil.reportExit(this.b, com.huawei.hms.support.api.entity.push.PushNaming.SUBSCRIBE, reportEntry, errorEnum);
            return taskCompletionSource2.getTask();
        }
    }

    public final com.huawei.hmf.tasks.Task<java.lang.Void> a(boolean z) {
        java.lang.String reportEntry = com.huawei.hms.push.utils.PushBiUtil.reportEntry(this.b, com.huawei.hms.support.api.entity.push.PushNaming.SET_NOTIFY_FLAG);
        if (!com.huawei.hms.push.s.d(this.b) || com.huawei.hms.push.s.b()) {
            com.huawei.hms.support.log.HMSLog.i("HmsMessaging", "turn on/off with AIDL");
            com.huawei.hms.support.api.entity.push.EnableNotifyReq enableNotifyReq = new com.huawei.hms.support.api.entity.push.EnableNotifyReq();
            enableNotifyReq.setPackageName(this.b.getPackageName());
            enableNotifyReq.setEnable(z);
            return this.c.doWrite(new com.huawei.hms.push.task.BaseVoidTask(com.huawei.hms.support.api.entity.push.PushNaming.SET_NOTIFY_FLAG, com.huawei.hms.utils.JsonUtil.createJsonString(enableNotifyReq), reportEntry));
        }
        if (com.huawei.hms.android.HwBuildEx.VERSION.EMUI_SDK_INT < 12) {
            com.huawei.hms.support.log.HMSLog.e("HmsMessaging", "operation not available on Huawei device with EMUI lower than 5.1");
            com.huawei.hmf.tasks.TaskCompletionSource taskCompletionSource = new com.huawei.hmf.tasks.TaskCompletionSource();
            com.huawei.hms.aaid.constant.ErrorEnum errorEnum = com.huawei.hms.aaid.constant.ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED;
            taskCompletionSource.setException(errorEnum.toApiException());
            com.huawei.hms.push.utils.PushBiUtil.reportExit(this.b, com.huawei.hms.support.api.entity.push.PushNaming.SET_NOTIFY_FLAG, reportEntry, errorEnum);
            return taskCompletionSource.getTask();
        }
        if (com.huawei.hms.push.s.b(this.b) < 90101310) {
            com.huawei.hms.support.log.HMSLog.i("HmsMessaging", "turn on/off with broadcast v1");
            android.content.Intent putExtra = new android.content.Intent("com.huawei.intent.action.SELF_SHOW_FLAG").putExtra("enalbeFlag", com.huawei.hms.aaid.encrypt.PushEncrypter.encrypterOld(this.b, this.b.getPackageName() + "#" + z));
            putExtra.setPackage(com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM);
            return com.huawei.hmf.tasks.Tasks.callInBackground(new com.huawei.hms.push.task.IntentCallable(this.b, putExtra, reportEntry));
        }
        com.huawei.hms.support.log.HMSLog.i("HmsMessaging", "turn on/off with broadcast v2");
        new com.huawei.hms.aaid.utils.PushPreferences(this.b, "push_notify_flag").saveBoolean("notify_msg_enable", !z);
        android.net.Uri parse = android.net.Uri.parse("content://" + this.b.getPackageName() + ".huawei.push.provider/push_notify_flag.xml");
        android.content.Intent intent = new android.content.Intent("com.huawei.android.push.intent.SDK_COMMAND");
        intent.putExtra("type", "enalbeFlag");
        intent.putExtra(com.vivo.push.PushClientConstants.TAG_PKG_NAME, this.b.getPackageName());
        intent.putExtra("url", parse);
        intent.setPackage(com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM);
        return com.huawei.hmf.tasks.Tasks.callInBackground(new com.huawei.hms.push.task.IntentCallable(this.b, intent, reportEntry));
    }

    public final void a(com.huawei.hms.push.RemoteMessage remoteMessage) {
        java.lang.String reportEntry = com.huawei.hms.push.utils.PushBiUtil.reportEntry(this.b, com.huawei.hms.support.api.entity.push.PushNaming.UPSEND_MSG);
        com.huawei.hms.aaid.constant.ErrorEnum a2 = com.huawei.hms.push.d.a(this.b);
        if (a2 != com.huawei.hms.aaid.constant.ErrorEnum.SUCCESS) {
            com.huawei.hms.support.log.HMSLog.e("HmsMessaging", "Message sent failed:" + a2.getExternalCode() + ':' + a2.getMessage());
            com.huawei.hms.push.utils.PushBiUtil.reportExit(this.b, com.huawei.hms.support.api.entity.push.PushNaming.UPSEND_MSG, reportEntry, a2);
            throw new java.lang.UnsupportedOperationException(a2.getMessage());
        }
        if (android.text.TextUtils.isEmpty(remoteMessage.getTo())) {
            com.huawei.hms.support.log.HMSLog.e("HmsMessaging", "Mandatory parameter 'to' missing");
            com.huawei.hms.push.utils.PushBiUtil.reportExit(this.b, com.huawei.hms.support.api.entity.push.PushNaming.UPSEND_MSG, reportEntry, com.huawei.hms.aaid.constant.ErrorEnum.ERROR_ARGUMENTS_INVALID);
            throw new java.lang.IllegalArgumentException("Mandatory parameter 'to' missing");
        }
        if (android.text.TextUtils.isEmpty(remoteMessage.getMessageId())) {
            com.huawei.hms.support.log.HMSLog.e("HmsMessaging", "Mandatory parameter 'message_id' missing");
            com.huawei.hms.push.utils.PushBiUtil.reportExit(this.b, com.huawei.hms.support.api.entity.push.PushNaming.UPSEND_MSG, reportEntry, com.huawei.hms.aaid.constant.ErrorEnum.ERROR_ARGUMENTS_INVALID);
            throw new java.lang.IllegalArgumentException("Mandatory parameter 'message_id' missing");
        }
        if (android.text.TextUtils.isEmpty(remoteMessage.getData())) {
            com.huawei.hms.support.log.HMSLog.e("HmsMessaging", "Mandatory parameter 'data' missing");
            com.huawei.hms.push.utils.PushBiUtil.reportExit(this.b, com.huawei.hms.support.api.entity.push.PushNaming.UPSEND_MSG, reportEntry, com.huawei.hms.aaid.constant.ErrorEnum.ERROR_ARGUMENTS_INVALID);
            throw new java.lang.IllegalArgumentException("Mandatory parameter 'data' missing");
        }
        com.huawei.hms.support.api.entity.push.UpSendMsgReq upSendMsgReq = new com.huawei.hms.support.api.entity.push.UpSendMsgReq();
        upSendMsgReq.setPackageName(this.b.getPackageName());
        upSendMsgReq.setMessageId(remoteMessage.getMessageId());
        upSendMsgReq.setTo(remoteMessage.getTo());
        upSendMsgReq.setData(remoteMessage.getData());
        upSendMsgReq.setMessageType(remoteMessage.getMessageType());
        upSendMsgReq.setTtl(remoteMessage.getTtl());
        upSendMsgReq.setCollapseKey(remoteMessage.getCollapseKey());
        upSendMsgReq.setSendMode(remoteMessage.getSendMode());
        upSendMsgReq.setReceiptMode(remoteMessage.getReceiptMode());
        if (com.huawei.hms.push.s.b()) {
            this.c.doWrite(new com.huawei.hms.push.task.BaseVoidTask(com.huawei.hms.support.api.entity.push.PushNaming.UPSEND_MSG, com.huawei.hms.utils.JsonUtil.createJsonString(upSendMsgReq), reportEntry));
        } else {
            a(upSendMsgReq, reportEntry);
        }
    }

    public final void a(com.huawei.hms.support.api.entity.push.UpSendMsgReq upSendMsgReq, java.lang.String str) {
        upSendMsgReq.setToken(com.huawei.hms.aaid.utils.BaseUtils.getLocalToken(this.b, null));
        try {
            this.c.doWrite(new com.huawei.hms.push.task.SendUpStreamTask(com.huawei.hms.support.api.entity.push.PushNaming.UPSEND_MSG, com.huawei.hms.utils.JsonUtil.createJsonString(upSendMsgReq), str, upSendMsgReq.getPackageName(), upSendMsgReq.getMessageId()));
        } catch (java.lang.Exception e) {
            if (!(e.getCause() instanceof com.huawei.hms.common.ApiException)) {
                com.huawei.hms.push.utils.PushBiUtil.reportExit(this.b, com.huawei.hms.support.api.entity.push.PushNaming.UPSEND_MSG, str, com.huawei.hms.aaid.constant.ErrorEnum.ERROR_INTERNAL_ERROR);
            } else {
                com.huawei.hms.push.utils.PushBiUtil.reportExit(this.b, com.huawei.hms.support.api.entity.push.PushNaming.UPSEND_MSG, str, ((com.huawei.hms.common.ApiException) e.getCause()).getStatusCode());
            }
        }
    }

    public boolean isAutoInitEnabled() {
        return com.huawei.hms.aaid.init.AutoInitHelper.isAutoInitEnabled(this.b);
    }

    public void send(com.huawei.hms.push.RemoteMessage remoteMessage) {
        if (com.huawei.hms.aaid.plugin.ProxyCenter.getProxy() != null) {
            com.huawei.hms.support.log.HMSLog.e("HmsMessaging", "Operation(send) unsupported");
            throw new java.lang.UnsupportedOperationException("Operation(send) unsupported");
        }
        com.huawei.hms.support.log.HMSLog.i("HmsMessaging", "send upstream message");
        a(remoteMessage);
    }

    public void setAutoInitEnabled(boolean z) {
        com.huawei.hms.aaid.init.AutoInitHelper.setAutoInitEnabled(this.b, z);
    }

    public com.huawei.hmf.tasks.Task<java.lang.Void> subscribe(java.lang.String str) {
        com.huawei.hms.support.log.HMSLog.i("HmsMessaging", "invoke subscribe");
        return a(str, "Sub");
    }

    public com.huawei.hmf.tasks.Task<java.lang.Void> turnOffPush() {
        if (com.huawei.hms.aaid.plugin.ProxyCenter.getProxy() != null) {
            com.huawei.hms.support.log.HMSLog.i("HmsMessaging", "turn off for proxy");
            return com.huawei.hms.aaid.plugin.ProxyCenter.getProxy().turnOff(this.b, null);
        }
        com.huawei.hms.support.log.HMSLog.i("HmsMessaging", "invoke turnOffPush");
        return a(false);
    }

    public com.huawei.hmf.tasks.Task<java.lang.Void> turnOnPush() {
        if (com.huawei.hms.aaid.plugin.ProxyCenter.getProxy() != null) {
            com.huawei.hms.support.log.HMSLog.i("HmsMessaging", "turn on for proxy");
            return com.huawei.hms.aaid.plugin.ProxyCenter.getProxy().turnOn(this.b, null);
        }
        com.huawei.hms.support.log.HMSLog.i("HmsMessaging", "invoke turnOnPush");
        return a(true);
    }

    public com.huawei.hmf.tasks.Task<java.lang.Void> unsubscribe(java.lang.String str) {
        com.huawei.hms.support.log.HMSLog.i("HmsMessaging", "invoke unsubscribe");
        return a(str, "UnSub");
    }
}
