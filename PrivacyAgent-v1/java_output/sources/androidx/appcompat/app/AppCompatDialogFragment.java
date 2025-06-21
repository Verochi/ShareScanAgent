package androidx.appcompat.app;

/* loaded from: classes.dex */
public class AppCompatDialogFragment extends androidx.fragment.app.DialogFragment {
    @Override // androidx.fragment.app.DialogFragment
    @androidx.annotation.NonNull
    public android.app.Dialog onCreateDialog(@androidx.annotation.Nullable android.os.Bundle bundle) {
        return new androidx.appcompat.app.AppCompatDialog(getContext(), getTheme());
    }

    @Override // androidx.fragment.app.DialogFragment
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setupDialog(@androidx.annotation.NonNull android.app.Dialog dialog, int i) {
        if (!(dialog instanceof androidx.appcompat.app.AppCompatDialog)) {
            super.setupDialog(dialog, i);
            return;
        }
        androidx.appcompat.app.AppCompatDialog appCompatDialog = (androidx.appcompat.app.AppCompatDialog) dialog;
        if (i != 1 && i != 2) {
            if (i != 3) {
                return;
            } else {
                dialog.getWindow().addFlags(24);
            }
        }
        appCompatDialog.supportRequestWindowFeature(1);
    }
}
