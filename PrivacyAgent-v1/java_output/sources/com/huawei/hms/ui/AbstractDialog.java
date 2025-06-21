package com.huawei.hms.ui;

/* loaded from: classes22.dex */
public abstract class AbstractDialog {
    public android.app.Activity a;
    public android.app.AlertDialog b;
    public com.huawei.hms.ui.AbstractDialog.Callback c;

    public interface Callback {
        void onCancel(com.huawei.hms.ui.AbstractDialog abstractDialog);

        void onDoWork(com.huawei.hms.ui.AbstractDialog abstractDialog);
    }

    public class a implements android.content.DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            com.huawei.hms.ui.AbstractDialog.this.fireDoWork();
        }
    }

    public class b implements android.content.DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            com.huawei.hms.ui.AbstractDialog.this.cancel();
        }
    }

    public class c implements android.content.DialogInterface.OnCancelListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(android.content.DialogInterface dialogInterface) {
            com.huawei.hms.ui.AbstractDialog.this.fireCancel();
        }
    }

    public class d implements android.content.DialogInterface.OnKeyListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(android.content.DialogInterface dialogInterface, int i, android.view.KeyEvent keyEvent) {
            if (4 != i || keyEvent.getAction() != 1) {
                return false;
            }
            com.huawei.hms.ui.AbstractDialog.this.cancel();
            return true;
        }
    }

    public static int a(android.content.Context context) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null);
    }

    public void cancel() {
        android.app.AlertDialog alertDialog = this.b;
        if (alertDialog != null) {
            alertDialog.cancel();
        }
    }

    public void dismiss() {
        android.app.AlertDialog alertDialog = this.b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public void fireCancel() {
        com.huawei.hms.ui.AbstractDialog.Callback callback = this.c;
        if (callback != null) {
            callback.onCancel(this);
        }
    }

    public void fireDoWork() {
        com.huawei.hms.ui.AbstractDialog.Callback callback = this.c;
        if (callback != null) {
            callback.onDoWork(this);
        }
    }

    public android.app.Activity getActivity() {
        return this.a;
    }

    public int getDialogThemeId() {
        return a(this.a) != 0 ? 0 : 3;
    }

    public android.app.AlertDialog onCreateDialog(android.app.Activity activity) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity(), getDialogThemeId());
        java.lang.String onGetTitleString = onGetTitleString(activity);
        if (onGetTitleString != null) {
            builder.setTitle(onGetTitleString);
        }
        java.lang.String onGetMessageString = onGetMessageString(activity);
        if (onGetMessageString != null) {
            builder.setMessage(onGetMessageString);
        }
        java.lang.String onGetPositiveButtonString = onGetPositiveButtonString(activity);
        if (onGetPositiveButtonString != null) {
            builder.setPositiveButton(onGetPositiveButtonString, new com.huawei.hms.ui.AbstractDialog.a());
        }
        java.lang.String onGetNegativeButtonString = onGetNegativeButtonString(activity);
        if (onGetNegativeButtonString != null) {
            builder.setNegativeButton(onGetNegativeButtonString, new com.huawei.hms.ui.AbstractDialog.b());
        }
        return builder.create();
    }

    public abstract java.lang.String onGetMessageString(android.content.Context context);

    public abstract java.lang.String onGetNegativeButtonString(android.content.Context context);

    public abstract java.lang.String onGetPositiveButtonString(android.content.Context context);

    public abstract java.lang.String onGetTitleString(android.content.Context context);

    public void setMessage(java.lang.CharSequence charSequence) {
        android.app.AlertDialog alertDialog = this.b;
        if (alertDialog != null) {
            alertDialog.setMessage(charSequence);
        }
    }

    public void setTitle(java.lang.CharSequence charSequence) {
        android.app.AlertDialog alertDialog = this.b;
        if (alertDialog != null) {
            alertDialog.setTitle(charSequence);
        }
    }

    public void show(android.app.Activity activity, com.huawei.hms.ui.AbstractDialog.Callback callback) {
        this.a = activity;
        this.c = callback;
        if (activity == null || activity.isFinishing()) {
            com.huawei.hms.support.log.HMSLog.e("AbstractDialog", "In show, The activity is null or finishing.");
            return;
        }
        android.app.AlertDialog onCreateDialog = onCreateDialog(this.a);
        this.b = onCreateDialog;
        onCreateDialog.setCanceledOnTouchOutside(false);
        this.b.setOnCancelListener(new com.huawei.hms.ui.AbstractDialog.c());
        this.b.setOnKeyListener(new com.huawei.hms.ui.AbstractDialog.d());
        this.b.show();
    }
}
