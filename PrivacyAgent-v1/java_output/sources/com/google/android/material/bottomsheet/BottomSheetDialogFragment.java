package com.google.android.material.bottomsheet;

/* loaded from: classes22.dex */
public class BottomSheetDialogFragment extends androidx.appcompat.app.AppCompatDialogFragment {
    private boolean waitingForDismissAllowingStateLoss;

    public class BottomSheetDismissCallback extends com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback {
        private BottomSheetDismissCallback() {
        }

        public /* synthetic */ BottomSheetDismissCallback(com.google.android.material.bottomsheet.BottomSheetDialogFragment bottomSheetDialogFragment, com.google.android.material.bottomsheet.BottomSheetDialogFragment.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(@androidx.annotation.NonNull android.view.View view, float f) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(@androidx.annotation.NonNull android.view.View view, int i) {
            if (i == 5) {
                com.google.android.material.bottomsheet.BottomSheetDialogFragment.this.dismissAfterAnimation();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissAfterAnimation() {
        if (this.waitingForDismissAllowingStateLoss) {
            super.dismissAllowingStateLoss();
        } else {
            super.dismiss();
        }
    }

    private void dismissWithAnimation(@androidx.annotation.NonNull com.google.android.material.bottomsheet.BottomSheetBehavior<?> bottomSheetBehavior, boolean z) {
        this.waitingForDismissAllowingStateLoss = z;
        if (bottomSheetBehavior.getState() == 5) {
            dismissAfterAnimation();
            return;
        }
        if (getDialog() instanceof com.google.android.material.bottomsheet.BottomSheetDialog) {
            ((com.google.android.material.bottomsheet.BottomSheetDialog) getDialog()).removeDefaultCallback();
        }
        bottomSheetBehavior.addBottomSheetCallback(new com.google.android.material.bottomsheet.BottomSheetDialogFragment.BottomSheetDismissCallback(this, null));
        bottomSheetBehavior.setState(5);
    }

    private boolean tryDismissWithAnimation(boolean z) {
        android.app.Dialog dialog = getDialog();
        if (!(dialog instanceof com.google.android.material.bottomsheet.BottomSheetDialog)) {
            return false;
        }
        com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = (com.google.android.material.bottomsheet.BottomSheetDialog) dialog;
        com.google.android.material.bottomsheet.BottomSheetBehavior<android.widget.FrameLayout> behavior = bottomSheetDialog.getBehavior();
        if (!behavior.isHideable() || !bottomSheetDialog.getDismissWithAnimation()) {
            return false;
        }
        dismissWithAnimation(behavior, z);
        return true;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        if (tryDismissWithAnimation(false)) {
            return;
        }
        super.dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismissAllowingStateLoss() {
        if (tryDismissWithAnimation(true)) {
            return;
        }
        super.dismissAllowingStateLoss();
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    @androidx.annotation.NonNull
    public android.app.Dialog onCreateDialog(@androidx.annotation.Nullable android.os.Bundle bundle) {
        return new com.google.android.material.bottomsheet.BottomSheetDialog(getContext(), getTheme());
    }
}
