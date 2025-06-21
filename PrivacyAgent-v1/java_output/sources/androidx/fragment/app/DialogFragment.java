package androidx.fragment.app;

/* loaded from: classes.dex */
public class DialogFragment extends androidx.fragment.app.Fragment implements android.content.DialogInterface.OnCancelListener, android.content.DialogInterface.OnDismissListener {
    private static final java.lang.String SAVED_BACK_STACK_ID = "android:backStackId";
    private static final java.lang.String SAVED_CANCELABLE = "android:cancelable";
    private static final java.lang.String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
    private static final java.lang.String SAVED_INTERNAL_DIALOG_SHOWING = "android:dialogShowing";
    private static final java.lang.String SAVED_SHOWS_DIALOG = "android:showsDialog";
    private static final java.lang.String SAVED_STYLE = "android:style";
    private static final java.lang.String SAVED_THEME = "android:theme";
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NO_FRAME = 2;
    public static final int STYLE_NO_INPUT = 3;
    public static final int STYLE_NO_TITLE = 1;
    private int mBackStackId;
    private boolean mCancelable;
    private boolean mCreatingDialog;

    @androidx.annotation.Nullable
    private android.app.Dialog mDialog;
    private boolean mDialogCreated;
    private java.lang.Runnable mDismissRunnable;
    private boolean mDismissed;
    private android.os.Handler mHandler;
    private androidx.lifecycle.Observer<androidx.lifecycle.LifecycleOwner> mObserver;
    private android.content.DialogInterface.OnCancelListener mOnCancelListener;
    private android.content.DialogInterface.OnDismissListener mOnDismissListener;
    private boolean mShownByMe;
    private boolean mShowsDialog;
    private int mStyle;
    private int mTheme;
    private boolean mViewDestroyed;

    /* renamed from: androidx.fragment.app.DialogFragment$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        @android.annotation.SuppressLint({"SyntheticAccessor"})
        public void run() {
            androidx.fragment.app.DialogFragment.this.mOnDismissListener.onDismiss(androidx.fragment.app.DialogFragment.this.mDialog);
        }
    }

    /* renamed from: androidx.fragment.app.DialogFragment$2, reason: invalid class name */
    public class AnonymousClass2 implements android.content.DialogInterface.OnCancelListener {
        public AnonymousClass2() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        @android.annotation.SuppressLint({"SyntheticAccessor"})
        public void onCancel(@androidx.annotation.Nullable android.content.DialogInterface dialogInterface) {
            if (androidx.fragment.app.DialogFragment.this.mDialog != null) {
                androidx.fragment.app.DialogFragment dialogFragment = androidx.fragment.app.DialogFragment.this;
                dialogFragment.onCancel(dialogFragment.mDialog);
            }
        }
    }

    /* renamed from: androidx.fragment.app.DialogFragment$3, reason: invalid class name */
    public class AnonymousClass3 implements android.content.DialogInterface.OnDismissListener {
        public AnonymousClass3() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        @android.annotation.SuppressLint({"SyntheticAccessor"})
        public void onDismiss(@androidx.annotation.Nullable android.content.DialogInterface dialogInterface) {
            if (androidx.fragment.app.DialogFragment.this.mDialog != null) {
                androidx.fragment.app.DialogFragment dialogFragment = androidx.fragment.app.DialogFragment.this;
                dialogFragment.onDismiss(dialogFragment.mDialog);
            }
        }
    }

    /* renamed from: androidx.fragment.app.DialogFragment$4, reason: invalid class name */
    public class AnonymousClass4 implements androidx.lifecycle.Observer<androidx.lifecycle.LifecycleOwner> {
        public AnonymousClass4() {
        }

        @Override // androidx.lifecycle.Observer
        @android.annotation.SuppressLint({"SyntheticAccessor"})
        public void onChanged(androidx.lifecycle.LifecycleOwner lifecycleOwner) {
            if (lifecycleOwner == null || !androidx.fragment.app.DialogFragment.this.mShowsDialog) {
                return;
            }
            android.view.View requireView = androidx.fragment.app.DialogFragment.this.requireView();
            if (requireView.getParent() != null) {
                throw new java.lang.IllegalStateException("DialogFragment can not be attached to a container view");
            }
            if (androidx.fragment.app.DialogFragment.this.mDialog != null) {
                if (androidx.fragment.app.FragmentManager.isLoggingEnabled(3)) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("DialogFragment ");
                    sb.append(this);
                    sb.append(" setting the content view on ");
                    sb.append(androidx.fragment.app.DialogFragment.this.mDialog);
                }
                androidx.fragment.app.DialogFragment.this.mDialog.setContentView(requireView);
            }
        }
    }

    /* renamed from: androidx.fragment.app.DialogFragment$5, reason: invalid class name */
    public class AnonymousClass5 extends androidx.fragment.app.FragmentContainer {
        final /* synthetic */ androidx.fragment.app.FragmentContainer val$fragmentContainer;

        public AnonymousClass5(androidx.fragment.app.FragmentContainer fragmentContainer) {
            this.val$fragmentContainer = fragmentContainer;
        }

        @Override // androidx.fragment.app.FragmentContainer
        @androidx.annotation.Nullable
        public android.view.View onFindViewById(int i) {
            return this.val$fragmentContainer.onHasView() ? this.val$fragmentContainer.onFindViewById(i) : androidx.fragment.app.DialogFragment.this.onFindViewById(i);
        }

        @Override // androidx.fragment.app.FragmentContainer
        public boolean onHasView() {
            return this.val$fragmentContainer.onHasView() || androidx.fragment.app.DialogFragment.this.onHasView();
        }
    }

    public DialogFragment() {
        this.mDismissRunnable = new androidx.fragment.app.DialogFragment.AnonymousClass1();
        this.mOnCancelListener = new androidx.fragment.app.DialogFragment.AnonymousClass2();
        this.mOnDismissListener = new androidx.fragment.app.DialogFragment.AnonymousClass3();
        this.mStyle = 0;
        this.mTheme = 0;
        this.mCancelable = true;
        this.mShowsDialog = true;
        this.mBackStackId = -1;
        this.mObserver = new androidx.fragment.app.DialogFragment.AnonymousClass4();
        this.mDialogCreated = false;
    }

    public DialogFragment(@androidx.annotation.LayoutRes int i) {
        super(i);
        this.mDismissRunnable = new androidx.fragment.app.DialogFragment.AnonymousClass1();
        this.mOnCancelListener = new androidx.fragment.app.DialogFragment.AnonymousClass2();
        this.mOnDismissListener = new androidx.fragment.app.DialogFragment.AnonymousClass3();
        this.mStyle = 0;
        this.mTheme = 0;
        this.mCancelable = true;
        this.mShowsDialog = true;
        this.mBackStackId = -1;
        this.mObserver = new androidx.fragment.app.DialogFragment.AnonymousClass4();
        this.mDialogCreated = false;
    }

    private void dismissInternal(boolean z, boolean z2) {
        if (this.mDismissed) {
            return;
        }
        this.mDismissed = true;
        this.mShownByMe = false;
        android.app.Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.mDialog.dismiss();
            if (!z2) {
                if (android.os.Looper.myLooper() == this.mHandler.getLooper()) {
                    onDismiss(this.mDialog);
                } else {
                    this.mHandler.post(this.mDismissRunnable);
                }
            }
        }
        this.mViewDestroyed = true;
        if (this.mBackStackId >= 0) {
            getParentFragmentManager().popBackStack(this.mBackStackId, 1);
            this.mBackStackId = -1;
            return;
        }
        androidx.fragment.app.FragmentTransaction beginTransaction = getParentFragmentManager().beginTransaction();
        beginTransaction.remove(this);
        if (z) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    private void prepareDialog(@androidx.annotation.Nullable android.os.Bundle bundle) {
        if (this.mShowsDialog && !this.mDialogCreated) {
            try {
                this.mCreatingDialog = true;
                android.app.Dialog onCreateDialog = onCreateDialog(bundle);
                this.mDialog = onCreateDialog;
                if (this.mShowsDialog) {
                    setupDialog(onCreateDialog, this.mStyle);
                    android.content.Context context = getContext();
                    if (context instanceof android.app.Activity) {
                        this.mDialog.setOwnerActivity((android.app.Activity) context);
                    }
                    this.mDialog.setCancelable(this.mCancelable);
                    this.mDialog.setOnCancelListener(this.mOnCancelListener);
                    this.mDialog.setOnDismissListener(this.mOnDismissListener);
                    this.mDialogCreated = true;
                } else {
                    this.mDialog = null;
                }
            } finally {
                this.mCreatingDialog = false;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    @androidx.annotation.NonNull
    public androidx.fragment.app.FragmentContainer createFragmentContainer() {
        return new androidx.fragment.app.DialogFragment.AnonymousClass5(super.createFragmentContainer());
    }

    public void dismiss() {
        dismissInternal(false, false);
    }

    public void dismissAllowingStateLoss() {
        dismissInternal(true, false);
    }

    @androidx.annotation.Nullable
    public android.app.Dialog getDialog() {
        return this.mDialog;
    }

    public boolean getShowsDialog() {
        return this.mShowsDialog;
    }

    @androidx.annotation.StyleRes
    public int getTheme() {
        return this.mTheme;
    }

    public boolean isCancelable() {
        return this.mCancelable;
    }

    @Override // androidx.fragment.app.Fragment
    @androidx.annotation.MainThread
    public void onAttach(@androidx.annotation.NonNull android.content.Context context) {
        super.onAttach(context);
        getViewLifecycleOwnerLiveData().observeForever(this.mObserver);
        if (this.mShownByMe) {
            return;
        }
        this.mDismissed = false;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(@androidx.annotation.NonNull android.content.DialogInterface dialogInterface) {
    }

    @Override // androidx.fragment.app.Fragment
    @androidx.annotation.MainThread
    public void onCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.mHandler = new android.os.Handler();
        this.mShowsDialog = this.mContainerId == 0;
        if (bundle != null) {
            this.mStyle = bundle.getInt(SAVED_STYLE, 0);
            this.mTheme = bundle.getInt(SAVED_THEME, 0);
            this.mCancelable = bundle.getBoolean(SAVED_CANCELABLE, true);
            this.mShowsDialog = bundle.getBoolean(SAVED_SHOWS_DIALOG, this.mShowsDialog);
            this.mBackStackId = bundle.getInt(SAVED_BACK_STACK_ID, -1);
        }
    }

    @androidx.annotation.NonNull
    @androidx.annotation.MainThread
    public android.app.Dialog onCreateDialog(@androidx.annotation.Nullable android.os.Bundle bundle) {
        if (androidx.fragment.app.FragmentManager.isLoggingEnabled(3)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("onCreateDialog called for DialogFragment ");
            sb.append(this);
        }
        return new android.app.Dialog(requireContext(), getTheme());
    }

    @Override // androidx.fragment.app.Fragment
    @androidx.annotation.MainThread
    public void onDestroyView() {
        super.onDestroyView();
        android.app.Dialog dialog = this.mDialog;
        if (dialog != null) {
            this.mViewDestroyed = true;
            dialog.setOnDismissListener(null);
            this.mDialog.dismiss();
            if (!this.mDismissed) {
                onDismiss(this.mDialog);
            }
            this.mDialog = null;
            this.mDialogCreated = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    @androidx.annotation.MainThread
    public void onDetach() {
        super.onDetach();
        if (!this.mShownByMe && !this.mDismissed) {
            this.mDismissed = true;
        }
        getViewLifecycleOwnerLiveData().removeObserver(this.mObserver);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(@androidx.annotation.NonNull android.content.DialogInterface dialogInterface) {
        if (this.mViewDestroyed) {
            return;
        }
        if (androidx.fragment.app.FragmentManager.isLoggingEnabled(3)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("onDismiss called for DialogFragment ");
            sb.append(this);
        }
        dismissInternal(true, true);
    }

    @androidx.annotation.Nullable
    public android.view.View onFindViewById(int i) {
        android.app.Dialog dialog = this.mDialog;
        if (dialog != null) {
            return dialog.findViewById(i);
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    @androidx.annotation.NonNull
    public android.view.LayoutInflater onGetLayoutInflater(@androidx.annotation.Nullable android.os.Bundle bundle) {
        android.view.LayoutInflater onGetLayoutInflater = super.onGetLayoutInflater(bundle);
        if (this.mShowsDialog && !this.mCreatingDialog) {
            prepareDialog(bundle);
            if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("get layout inflater for DialogFragment ");
                sb.append(this);
                sb.append(" from dialog context");
            }
            android.app.Dialog dialog = this.mDialog;
            return dialog != null ? onGetLayoutInflater.cloneInContext(dialog.getContext()) : onGetLayoutInflater;
        }
        if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
            java.lang.String str = "getting layout inflater for DialogFragment " + this;
            if (this.mShowsDialog) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("mCreatingDialog = true: ");
                sb2.append(str);
            } else {
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                sb3.append("mShowsDialog = false: ");
                sb3.append(str);
            }
        }
        return onGetLayoutInflater;
    }

    public boolean onHasView() {
        return this.mDialogCreated;
    }

    @Override // androidx.fragment.app.Fragment
    @androidx.annotation.MainThread
    public void onSaveInstanceState(@androidx.annotation.NonNull android.os.Bundle bundle) {
        super.onSaveInstanceState(bundle);
        android.app.Dialog dialog = this.mDialog;
        if (dialog != null) {
            android.os.Bundle onSaveInstanceState = dialog.onSaveInstanceState();
            onSaveInstanceState.putBoolean(SAVED_INTERNAL_DIALOG_SHOWING, false);
            bundle.putBundle(SAVED_DIALOG_STATE_TAG, onSaveInstanceState);
        }
        int i = this.mStyle;
        if (i != 0) {
            bundle.putInt(SAVED_STYLE, i);
        }
        int i2 = this.mTheme;
        if (i2 != 0) {
            bundle.putInt(SAVED_THEME, i2);
        }
        boolean z = this.mCancelable;
        if (!z) {
            bundle.putBoolean(SAVED_CANCELABLE, z);
        }
        boolean z2 = this.mShowsDialog;
        if (!z2) {
            bundle.putBoolean(SAVED_SHOWS_DIALOG, z2);
        }
        int i3 = this.mBackStackId;
        if (i3 != -1) {
            bundle.putInt(SAVED_BACK_STACK_ID, i3);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @androidx.annotation.MainThread
    public void onStart() {
        super.onStart();
        android.app.Dialog dialog = this.mDialog;
        if (dialog != null) {
            this.mViewDestroyed = false;
            dialog.show();
            android.view.View decorView = this.mDialog.getWindow().getDecorView();
            androidx.lifecycle.ViewTreeLifecycleOwner.set(decorView, this);
            androidx.lifecycle.ViewTreeViewModelStoreOwner.set(decorView, this);
            androidx.savedstate.ViewTreeSavedStateRegistryOwner.set(decorView, this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @androidx.annotation.MainThread
    public void onStop() {
        super.onStop();
        android.app.Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @androidx.annotation.MainThread
    public void onViewStateRestored(@androidx.annotation.Nullable android.os.Bundle bundle) {
        android.os.Bundle bundle2;
        super.onViewStateRestored(bundle);
        if (this.mDialog == null || bundle == null || (bundle2 = bundle.getBundle(SAVED_DIALOG_STATE_TAG)) == null) {
            return;
        }
        this.mDialog.onRestoreInstanceState(bundle2);
    }

    @Override // androidx.fragment.app.Fragment
    public void performCreateView(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, @androidx.annotation.Nullable android.os.Bundle bundle) {
        android.os.Bundle bundle2;
        super.performCreateView(layoutInflater, viewGroup, bundle);
        if (this.mView != null || this.mDialog == null || bundle == null || (bundle2 = bundle.getBundle(SAVED_DIALOG_STATE_TAG)) == null) {
            return;
        }
        this.mDialog.onRestoreInstanceState(bundle2);
    }

    @androidx.annotation.NonNull
    public final android.app.Dialog requireDialog() {
        android.app.Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog;
        }
        throw new java.lang.IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void setCancelable(boolean z) {
        this.mCancelable = z;
        android.app.Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.setCancelable(z);
        }
    }

    public void setShowsDialog(boolean z) {
        this.mShowsDialog = z;
    }

    public void setStyle(int i, @androidx.annotation.StyleRes int i2) {
        if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Setting style and theme for DialogFragment ");
            sb.append(this);
            sb.append(" to ");
            sb.append(i);
            sb.append(", ");
            sb.append(i2);
        }
        this.mStyle = i;
        if (i == 2 || i == 3) {
            this.mTheme = android.R.style.Theme.Panel;
        }
        if (i2 != 0) {
            this.mTheme = i2;
        }
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setupDialog(@androidx.annotation.NonNull android.app.Dialog dialog, int i) {
        if (i != 1 && i != 2) {
            if (i != 3) {
                return;
            }
            android.view.Window window = dialog.getWindow();
            if (window != null) {
                window.addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }

    public int show(@androidx.annotation.NonNull androidx.fragment.app.FragmentTransaction fragmentTransaction, @androidx.annotation.Nullable java.lang.String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        fragmentTransaction.add(this, str);
        this.mViewDestroyed = false;
        int commit = fragmentTransaction.commit();
        this.mBackStackId = commit;
        return commit;
    }

    public void show(@androidx.annotation.NonNull androidx.fragment.app.FragmentManager fragmentManager, @androidx.annotation.Nullable java.lang.String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        androidx.fragment.app.FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(this, str);
        beginTransaction.commit();
    }

    public void showNow(@androidx.annotation.NonNull androidx.fragment.app.FragmentManager fragmentManager, @androidx.annotation.Nullable java.lang.String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        androidx.fragment.app.FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(this, str);
        beginTransaction.commitNow();
    }
}
