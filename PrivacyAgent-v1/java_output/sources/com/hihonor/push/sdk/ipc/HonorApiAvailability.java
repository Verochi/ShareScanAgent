package com.hihonor.push.sdk.ipc;

/* loaded from: classes22.dex */
public class HonorApiAvailability {

    public enum PackageStates {
        ENABLED,
        DISABLED,
        NOT_INSTALLED
    }

    public static com.hihonor.push.sdk.bean.RemoteServiceBean a(android.content.Context context) {
        com.hihonor.push.sdk.bean.RemoteServiceBean remoteServiceBean = new com.hihonor.push.sdk.bean.RemoteServiceBean();
        android.content.Intent intent = new android.content.Intent();
        intent.setComponent(new android.content.ComponentName(com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM, "com.hihonor.android.pushagentproxy.HiPushService"));
        java.util.List<android.content.pm.ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 128);
        if (queryIntentServices.size() > 0) {
            java.util.Iterator<android.content.pm.ResolveInfo> it = queryIntentServices.iterator();
            if (it.hasNext()) {
                android.content.pm.ResolveInfo next = it.next();
                java.lang.String str = next.serviceInfo.applicationInfo.packageName;
                java.lang.String certFingerprint = com.hihonor.push.sdk.utils.ConfigUtils.getCertFingerprint(context, str);
                remoteServiceBean.setPackageName(str);
                remoteServiceBean.setPackageServiceName(next.serviceInfo.name);
                remoteServiceBean.setPackageSignature(certFingerprint);
            }
        }
        return remoteServiceBean;
    }

    public static int isHonorMobileServicesAvailable(android.content.Context context) {
        com.hihonor.push.sdk.ipc.HonorApiAvailability.PackageStates packageStates;
        com.hihonor.push.sdk.utils.Preconditions.checkNotNull(context, "context must not be null.");
        com.hihonor.push.sdk.bean.RemoteServiceBean a = a(context);
        java.lang.String packageName = a.getPackageName();
        com.hihonor.push.sdk.common.logger.Logger.d("HonorApiAvailability", "service package name is ".concat(java.lang.String.valueOf(packageName)));
        if (android.text.TextUtils.isEmpty(packageName)) {
            packageStates = com.hihonor.push.sdk.ipc.HonorApiAvailability.PackageStates.NOT_INSTALLED;
        } else {
            try {
                packageStates = context.getPackageManager().getApplicationInfo(packageName, 0).enabled ? com.hihonor.push.sdk.ipc.HonorApiAvailability.PackageStates.ENABLED : com.hihonor.push.sdk.ipc.HonorApiAvailability.PackageStates.DISABLED;
            } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
                packageStates = com.hihonor.push.sdk.ipc.HonorApiAvailability.PackageStates.NOT_INSTALLED;
            }
        }
        if (com.hihonor.push.sdk.ipc.HonorApiAvailability.PackageStates.NOT_INSTALLED.equals(packageStates)) {
            com.hihonor.push.sdk.common.logger.Logger.i("HonorApiAvailability", "push service is not installed");
            return com.hihonor.push.sdk.common.data.ErrorCode.BindService.ERROR_SERVICE_MISSING;
        }
        if (!com.hihonor.push.sdk.ipc.HonorApiAvailability.PackageStates.DISABLED.equals(packageStates)) {
            return (!android.text.TextUtils.equals(packageName, com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM) || android.text.TextUtils.isEmpty(a.getPackageSignature())) ? com.hihonor.push.sdk.common.data.ErrorCode.BindService.ERROR_SERVICE_INVALID : com.hihonor.push.sdk.common.data.ErrorEnum.SUCCESS.statusCode;
        }
        com.hihonor.push.sdk.common.logger.Logger.i("HonorApiAvailability", "push service is disabled");
        return com.hihonor.push.sdk.common.data.ErrorCode.BindService.ERROR_SERVICE_DISABLED;
    }
}
