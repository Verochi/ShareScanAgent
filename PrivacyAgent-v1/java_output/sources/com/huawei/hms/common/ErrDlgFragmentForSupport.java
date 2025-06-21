package com.huawei.hms.common;

/* loaded from: classes22.dex */
public class ErrDlgFragmentForSupport extends android.app.DialogFragment {
    private android.app.Dialog log = null;
    private android.content.DialogInterface.OnCancelListener listener = null;

    public static com.huawei.hms.common.ErrDlgFragmentForSupport newInstance(android.app.Dialog dialog) {
        return newInstance(dialog, null);
    }

    public static com.huawei.hms.common.ErrDlgFragmentForSupport newInstance(android.app.Dialog dialog, android.content.DialogInterface.OnCancelListener onCancelListener) {
        com.huawei.hms.common.internal.Preconditions.checkNotNull(dialog, "Dialog cannot be null!");
        com.huawei.hms.common.ErrDlgFragmentForSupport errDlgFragmentForSupport = new com.huawei.hms.common.ErrDlgFragmentForSupport();
        errDlgFragmentForSupport.log = dialog;
        dialog.setOnCancelListener(null);
        errDlgFragmentForSupport.log.setOnDismissListener(null);
        errDlgFragmentForSupport.listener = onCancelListener;
        return errDlgFragmentForSupport;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(android.content.DialogInterface dialogInterface) {
        android.content.DialogInterface.OnCancelListener onCancelListener = this.listener;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public android.app.Dialog onCreateDialog(android.os.Bundle bundle) {
        if (this.log == null) {
            setShowsDialog(false);
        }
        return this.log;
    }

    @Override // android.app.DialogFragment
    public void show(android.app.FragmentManager fragmentManager, java.lang.String str) {
        com.huawei.hms.common.internal.Preconditions.checkNotNull(fragmentManager, "FragmentManager cannot be null!");
        super.show(fragmentManager, str);
    }
}
