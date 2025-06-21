package com.huawei.hms.common;

/* loaded from: classes22.dex */
public class ErrorDialogFragment extends android.app.DialogFragment {
    private android.app.Dialog myDialog = null;
    private android.content.DialogInterface.OnCancelListener myCancelLister = null;

    public static com.huawei.hms.common.ErrorDialogFragment newInstance(android.app.Dialog dialog) {
        return newInstance(dialog, null);
    }

    public static com.huawei.hms.common.ErrorDialogFragment newInstance(android.app.Dialog dialog, android.content.DialogInterface.OnCancelListener onCancelListener) {
        com.huawei.hms.common.internal.Preconditions.checkNotNull(dialog, "Dialog cannot be null!");
        com.huawei.hms.common.ErrorDialogFragment errorDialogFragment = new com.huawei.hms.common.ErrorDialogFragment();
        errorDialogFragment.myDialog = dialog;
        dialog.setOnCancelListener(null);
        errorDialogFragment.myDialog.setOnDismissListener(null);
        if (onCancelListener != null) {
            errorDialogFragment.myCancelLister = onCancelListener;
        }
        return errorDialogFragment;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(android.content.DialogInterface dialogInterface) {
        android.content.DialogInterface.OnCancelListener onCancelListener = this.myCancelLister;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public android.app.Dialog onCreateDialog(android.os.Bundle bundle) {
        if (this.myDialog == null) {
            setShowsDialog(false);
        }
        return this.myDialog;
    }

    @Override // android.app.DialogFragment
    public void show(android.app.FragmentManager fragmentManager, java.lang.String str) {
        com.huawei.hms.common.internal.Preconditions.checkNotNull(fragmentManager, "FragmentManager cannot be null!");
        super.show(fragmentManager, str);
    }
}
