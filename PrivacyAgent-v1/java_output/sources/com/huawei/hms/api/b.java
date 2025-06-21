package com.huawei.hms.api;

/* loaded from: classes22.dex */
final class b extends com.huawei.hms.api.HuaweiApiAvailability {
    private static final com.huawei.hms.api.b a = new com.huawei.hms.api.b();

    public class a implements com.huawei.hms.activity.internal.BusResponseCallback {
        final /* synthetic */ com.huawei.hmf.tasks.TaskCompletionSource[] a;

        public a(com.huawei.hms.api.b bVar, com.huawei.hmf.tasks.TaskCompletionSource[] taskCompletionSourceArr) {
            this.a = taskCompletionSourceArr;
        }

        @Override // com.huawei.hms.activity.internal.BusResponseCallback
        public com.huawei.hms.activity.internal.BusResponseResult innerError(android.app.Activity activity, int i, java.lang.String str) {
            com.huawei.hms.support.log.HMSLog.e("HuaweiApiAvailabilityImpl", "Test foreground bus error: resultCode " + i + ", errMessage" + str);
            this.a[0].setException(new com.huawei.hms.common.api.AvailabilityException());
            return null;
        }

        @Override // com.huawei.hms.activity.internal.BusResponseCallback
        public com.huawei.hms.activity.internal.BusResponseResult succeedReturn(android.app.Activity activity, int i, android.content.Intent intent) {
            com.huawei.hms.support.log.HMSLog.i("HuaweiApiAvailabilityImpl", "Test foreground bus success: resultCode " + i + ", data" + intent);
            return null;
        }
    }

    private b() {
    }

    private static android.app.Dialog a(android.app.Activity activity, int i, com.huawei.hms.common.internal.DialogRedirect dialogRedirect, android.content.DialogInterface.OnCancelListener onCancelListener) {
        if (i == 0) {
            return null;
        }
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity, com.huawei.hms.update.ui.NotInstalledHmsDialogHelper.getDialogThemeId(activity));
        builder.setMessage(com.huawei.hms.common.internal.ConnectionErrorMessages.getErrorMessage(activity, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        builder.setPositiveButton(com.huawei.hms.common.internal.ConnectionErrorMessages.getErrorDialogButtonMessage(activity, i), dialogRedirect);
        java.lang.String errorTitle = com.huawei.hms.common.internal.ConnectionErrorMessages.getErrorTitle(activity, i);
        if (errorTitle != null) {
            builder.setTitle(errorTitle);
        }
        return builder.create();
    }

    private android.content.Intent a(android.app.Activity activity, int i) {
        com.huawei.hms.support.log.HMSLog.i("HuaweiApiAvailabilityImpl", "getErrorResolutionIntent, errorCode: " + i);
        if (i == 1 || i == 2) {
            return com.huawei.hms.activity.BridgeActivity.getIntentStartBridgeActivity(activity, com.huawei.hms.update.note.DoNothingResolution.class.getName());
        }
        if (i == 6) {
            return com.huawei.hms.activity.BridgeActivity.getIntentStartBridgeActivity(activity, com.huawei.hms.api.BindingFailedResolution.class.getName());
        }
        if (i == 9 && com.huawei.hms.utils.Util.isAvailableLibExist(activity)) {
            return com.huawei.hms.activity.BridgeActivity.getIntentStartBridgeActivity(activity, com.huawei.hms.update.note.AppSpoofResolution.class.getName());
        }
        return null;
    }

    private static android.content.Intent a(android.app.Activity activity, java.lang.String str) {
        return com.huawei.hms.activity.BridgeActivity.getIntentStartBridgeActivity(activity, str);
    }

    private static android.content.Intent a(android.content.Context context, java.lang.String str) {
        return com.huawei.hms.activity.BridgeActivity.getIntentStartBridgeActivity(context, str);
    }

    private static void a(android.app.Activity activity, android.app.Dialog dialog, java.lang.String str, android.content.DialogInterface.OnCancelListener onCancelListener) {
        com.huawei.hms.utils.Checker.checkNonNull(activity, "activity must not be null.");
        com.huawei.hms.common.ErrorDialogFragment.newInstance(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    private void a(java.lang.Object obj) throws com.huawei.hms.common.api.AvailabilityException {
        com.huawei.hms.common.api.AvailabilityException availabilityException = new com.huawei.hms.common.api.AvailabilityException();
        if ((obj instanceof com.huawei.hms.common.HuaweiApi ? availabilityException.getConnectionResult((com.huawei.hms.common.HuaweiApi<? extends com.huawei.hms.api.Api.ApiOptions>) obj) : availabilityException.getConnectionResult((com.huawei.hms.common.api.HuaweiApiCallable) obj)).getErrorCode() == 0) {
            return;
        }
        com.huawei.hms.support.log.HMSLog.i("HuaweiApiAvailabilityImpl", "The service is unavailable: " + availabilityException.getMessage());
        throw availabilityException;
    }

    public static com.huawei.hms.api.b getInstance() {
        return a;
    }

    public android.content.Intent a(android.content.Context context, int i) {
        com.huawei.hms.support.log.HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getResolveErrorIntent, errorCode: " + i);
        if (i == 1 || i == 2) {
            return a(context, com.huawei.hms.update.note.NotInstalledHmsResolution.class.getName());
        }
        if (i == 6) {
            return a(context, com.huawei.hms.api.BindingFailedResolution.class.getName());
        }
        if (i == 9 && com.huawei.hms.utils.Util.isAvailableLibExist(context)) {
            return a(context, com.huawei.hms.update.note.AppSpoofResolution.class.getName());
        }
        return null;
    }

    public android.app.PendingIntent b(android.content.Context context, int i) {
        com.huawei.hms.support.log.HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getResolveErrorPendingIntent, errorCode: " + i);
        android.content.Intent a2 = a(context, i);
        if (a2 != null) {
            return android.app.PendingIntent.getActivity(context, 0, a2, 67108864);
        }
        return null;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public com.huawei.hmf.tasks.Task<java.lang.Void> checkApiAccessible(com.huawei.hms.common.HuaweiApi<?> huaweiApi, com.huawei.hms.common.HuaweiApi<?>... huaweiApiArr) {
        com.huawei.hmf.tasks.Task<java.lang.Void> task = new com.huawei.hmf.tasks.TaskCompletionSource().getTask();
        if (huaweiApi != null) {
            try {
                a(huaweiApi);
            } catch (com.huawei.hms.common.api.AvailabilityException e) {
                com.huawei.hms.support.log.HMSLog.i("HuaweiApiAvailabilityImpl", "checkApi has AvailabilityException " + e.getMessage());
            }
        }
        if (huaweiApiArr != null) {
            for (com.huawei.hms.common.HuaweiApi<?> huaweiApi2 : huaweiApiArr) {
                a(huaweiApi2);
            }
        }
        return task;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public com.huawei.hmf.tasks.Task<java.lang.Void> checkApiAccessible(com.huawei.hms.common.api.HuaweiApiCallable huaweiApiCallable, com.huawei.hms.common.api.HuaweiApiCallable... huaweiApiCallableArr) {
        com.huawei.hmf.tasks.Task<java.lang.Void> task = new com.huawei.hmf.tasks.TaskCompletionSource().getTask();
        if (huaweiApiCallable != null) {
            try {
                a(huaweiApiCallable);
            } catch (com.huawei.hms.common.api.AvailabilityException e) {
                com.huawei.hms.support.log.HMSLog.i("HuaweiApiAvailabilityImpl", "HuaweiApiCallable checkApi has AvailabilityException " + e.getMessage());
            }
        }
        if (huaweiApiCallableArr != null) {
            for (com.huawei.hms.common.api.HuaweiApiCallable huaweiApiCallable2 : huaweiApiCallableArr) {
                a(huaweiApiCallable2);
            }
        }
        return task;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public android.app.PendingIntent getErrPendingIntent(android.content.Context context, int i, int i2) {
        com.huawei.hms.support.log.HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getResolveErrorPendingIntent, errorCode: " + i + " requestCode: " + i2);
        android.content.Intent a2 = a(context, i);
        if (a2 != null) {
            return android.app.PendingIntent.getActivity(context, i2, a2, 67108864);
        }
        return null;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public android.app.PendingIntent getErrPendingIntent(android.content.Context context, com.huawei.hms.api.ConnectionResult connectionResult) {
        com.huawei.hms.common.internal.Preconditions.checkNotNull(context);
        com.huawei.hms.common.internal.Preconditions.checkNotNull(connectionResult);
        return b(context, connectionResult.getErrorCode());
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public android.app.Dialog getErrorDialog(android.app.Activity activity, int i, int i2) {
        com.huawei.hms.utils.Checker.checkNonNull(activity, "activity must not be null.");
        com.huawei.hms.support.log.HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getErrorDialog, errorCode: " + i);
        return getErrorDialog(activity, i, i2, null);
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public android.app.Dialog getErrorDialog(android.app.Activity activity, int i, int i2, android.content.DialogInterface.OnCancelListener onCancelListener) {
        com.huawei.hms.utils.Checker.checkNonNull(activity, "activity must not be null.");
        com.huawei.hms.support.log.HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getErrorDialog, errorCode: " + i);
        return a(activity, i, com.huawei.hms.common.internal.DialogRedirect.getInstance(activity, a(activity, i), i2), onCancelListener);
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public java.lang.String getErrorString(int i) {
        com.huawei.hms.support.log.HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getErrorString, errorCode: " + i);
        return com.huawei.hms.api.ConnectionResult.getErrorString(i);
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public com.huawei.hmf.tasks.Task<java.lang.Void> getHuaweiServicesReady(android.app.Activity activity) {
        com.huawei.hms.common.internal.Preconditions.checkNotNull(activity);
        com.huawei.hmf.tasks.TaskCompletionSource taskCompletionSource = new com.huawei.hmf.tasks.TaskCompletionSource();
        com.huawei.hmf.tasks.TaskCompletionSource[] taskCompletionSourceArr = {taskCompletionSource};
        com.huawei.hmf.tasks.Task<java.lang.Void> task = taskCompletionSource.getTask();
        int isHuaweiMobileServicesAvailable = isHuaweiMobileServicesAvailable(activity.getApplicationContext(), 30000000);
        android.content.Intent resolveErrorIntent = getResolveErrorIntent(activity, isHuaweiMobileServicesAvailable);
        android.content.Intent intentStartBridgeActivity = com.huawei.hms.activity.BridgeActivity.getIntentStartBridgeActivity(activity, com.huawei.hms.api.ResolutionDelegate.class.getName());
        if (resolveErrorIntent != null) {
            com.huawei.hms.activity.ForegroundIntentBuilder.registerResponseCallback(com.huawei.hms.api.ResolutionDelegate.CALLBACK_METHOD, new com.huawei.hms.api.b.a(this, taskCompletionSourceArr));
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putParcelable("resolution", resolveErrorIntent);
            intentStartBridgeActivity.putExtras(bundle);
            activity.startActivity(intentStartBridgeActivity);
        } else if (isHuaweiMobileServicesAvailable == 3) {
            android.content.Intent intent = new android.content.Intent();
            intent.setClass(activity, com.huawei.hms.activity.EnableServiceActivity.class);
            activity.startActivity(intent);
        } else if (isHuaweiMobileServicesAvailable == 0) {
            com.huawei.hms.support.log.HMSLog.i("HuaweiApiAvailabilityImpl", "The HMS service is available.");
        } else {
            com.huawei.hms.support.log.HMSLog.e("HuaweiApiAvailabilityImpl", "Framework can not solve the availability problem.");
            taskCompletionSourceArr[0].setException(new com.huawei.hms.common.api.AvailabilityException());
        }
        return task;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public android.content.Intent getResolveErrorIntent(android.app.Activity activity, int i) {
        com.huawei.hms.support.log.HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getResolveErrorIntent, errorCode: " + i);
        if (i == 1 || i == 2) {
            return a(activity, com.huawei.hms.update.note.NotInstalledHmsResolution.class.getName());
        }
        if (i == 6) {
            return a(activity, com.huawei.hms.api.BindingFailedResolution.class.getName());
        }
        if (i == 9 && com.huawei.hms.utils.Util.isAvailableLibExist(activity)) {
            return a(activity, com.huawei.hms.update.note.AppSpoofResolution.class.getName());
        }
        return null;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public android.app.PendingIntent getResolveErrorPendingIntent(android.app.Activity activity, int i) {
        com.huawei.hms.support.log.HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getResolveErrorPendingIntent, errorCode: " + i);
        android.content.Intent resolveErrorIntent = getResolveErrorIntent(activity, i);
        if (resolveErrorIntent != null) {
            return android.app.PendingIntent.getActivity(activity, 0, resolveErrorIntent, 67108864);
        }
        return null;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public int isHuaweiMobileNoticeAvailable(android.content.Context context) {
        com.huawei.hms.utils.Checker.checkNonNull(context, "context must not be null.");
        if (com.huawei.hms.utils.PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(new com.huawei.hms.utils.PackageManagerHelper(context).getPackageStates(com.huawei.hms.utils.HMSPackageManager.getInstance(context).getHMSPackageNameForMultiService()))) {
            return 1;
        }
        return com.huawei.hms.utils.HMSPackageManager.getInstance(context).isApkUpdateNecessary(20600000) ? 2 : 0;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public int isHuaweiMobileServicesAvailable(android.content.Context context) {
        com.huawei.hms.utils.Checker.checkNonNull(context, "context must not be null.");
        return com.huawei.hms.api.HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(context, com.huawei.hms.api.HuaweiApiAvailability.getServicesVersionCode());
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public int isHuaweiMobileServicesAvailable(android.content.Context context, int i) {
        com.huawei.hms.utils.Checker.checkNonNull(context, "context must not be null.");
        return com.huawei.hms.api.HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(context, i);
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public boolean isUserResolvableError(int i) {
        return isUserResolvableError(i, null);
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public boolean isUserResolvableError(int i, android.app.PendingIntent pendingIntent) {
        if (i == 0) {
            return false;
        }
        return pendingIntent != null || i == 1 || i == 2 || i == 6 || i == 9;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public void popupErrNotification(android.content.Context context, com.huawei.hms.api.ConnectionResult connectionResult) {
        com.huawei.hms.common.internal.Preconditions.checkNotNull(context);
        com.huawei.hms.common.internal.Preconditions.checkNotNull(connectionResult);
        showErrorNotification(context, connectionResult.getErrorCode());
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public void resolveError(android.app.Activity activity, int i, int i2) {
        resolveError(activity, i, i2, null);
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public void resolveError(android.app.Activity activity, int i, int i2, android.app.PendingIntent pendingIntent) {
        com.huawei.hms.utils.Checker.checkNonNull(activity, "activity must not be null.");
        if (pendingIntent != null) {
            com.huawei.hms.support.log.HMSLog.i("HuaweiApiAvailabilityImpl", "Enter resolveError, param pendingIntent is not null. and.errorCode: " + i);
        } else {
            com.huawei.hms.support.log.HMSLog.i("HuaweiApiAvailabilityImpl", "Enter resolveError, param pendingIntent is  null. get pendingIntent from error code.and.errorCode: " + i);
            pendingIntent = getResolveErrorPendingIntent(activity, i);
        }
        if (pendingIntent != null) {
            com.huawei.hms.support.log.HMSLog.i("HuaweiApiAvailabilityImpl", "In resolveError, start pendingIntent.errorCode: " + i);
            try {
                activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i2, null, 0, 0, 0);
            } catch (android.content.IntentSender.SendIntentException unused) {
                com.huawei.hms.support.log.HMSLog.e("HuaweiApiAvailabilityImpl", "Enter resolveError, start pendingIntent failed.errorCode: " + i);
            }
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public boolean showErrorDialogFragment(android.app.Activity activity, int i, int i2) {
        return showErrorDialogFragment(activity, i, i2, null);
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public boolean showErrorDialogFragment(android.app.Activity activity, int i, int i2, android.content.DialogInterface.OnCancelListener onCancelListener) {
        android.app.Dialog errorDialog = getErrorDialog(activity, i, i2, onCancelListener);
        if (errorDialog == null) {
            return false;
        }
        a(activity, errorDialog, com.huawei.hms.api.HuaweiMobileServicesUtil.HMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public boolean showErrorDialogFragment(android.app.Activity activity, int i, android.app.Fragment fragment, int i2, android.content.DialogInterface.OnCancelListener onCancelListener) {
        return showErrorDialogFragment(activity, i, i2, onCancelListener);
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public void showErrorNotification(android.content.Context context, int i) {
        com.huawei.hms.utils.Checker.checkNonNull(context, "context must not be null.");
        com.huawei.hms.support.log.HMSLog.i("HuaweiApiAvailabilityImpl", "Enter showErrorNotification, errorCode: " + i);
        if (!(context instanceof android.app.Activity)) {
            com.huawei.hms.support.log.HMSLog.i("HuaweiApiAvailabilityImpl", "context not instanceof Activity");
            return;
        }
        android.app.Dialog errorDialog = getErrorDialog((android.app.Activity) context, i, 0);
        if (errorDialog == null) {
            com.huawei.hms.support.log.HMSLog.i("HuaweiApiAvailabilityImpl", "showErrorNotification errorDialog can not be null");
        } else {
            errorDialog.show();
        }
    }
}
