package androidx.fragment.app;

/* loaded from: classes.dex */
public abstract class FragmentHostCallback<E> extends androidx.fragment.app.FragmentContainer {

    @androidx.annotation.Nullable
    private final android.app.Activity mActivity;

    @androidx.annotation.NonNull
    private final android.content.Context mContext;
    final androidx.fragment.app.FragmentManager mFragmentManager;

    @androidx.annotation.NonNull
    private final android.os.Handler mHandler;
    private final int mWindowAnimations;

    public FragmentHostCallback(@androidx.annotation.Nullable android.app.Activity activity, @androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.os.Handler handler, int i) {
        this.mFragmentManager = new androidx.fragment.app.FragmentManagerImpl();
        this.mActivity = activity;
        this.mContext = (android.content.Context) androidx.core.util.Preconditions.checkNotNull(context, "context == null");
        this.mHandler = (android.os.Handler) androidx.core.util.Preconditions.checkNotNull(handler, "handler == null");
        this.mWindowAnimations = i;
    }

    public FragmentHostCallback(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.os.Handler handler, int i) {
        this(context instanceof android.app.Activity ? (android.app.Activity) context : null, context, handler, i);
    }

    public FragmentHostCallback(@androidx.annotation.NonNull androidx.fragment.app.FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, new android.os.Handler(), 0);
    }

    @androidx.annotation.Nullable
    android.app.Activity getActivity() {
        return this.mActivity;
    }

    @androidx.annotation.NonNull
    android.content.Context getContext() {
        return this.mContext;
    }

    @androidx.annotation.NonNull
    android.os.Handler getHandler() {
        return this.mHandler;
    }

    public void onDump(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.io.FileDescriptor fileDescriptor, @androidx.annotation.NonNull java.io.PrintWriter printWriter, @androidx.annotation.Nullable java.lang.String[] strArr) {
    }

    @Override // androidx.fragment.app.FragmentContainer
    @androidx.annotation.Nullable
    public android.view.View onFindViewById(int i) {
        return null;
    }

    @androidx.annotation.Nullable
    public abstract E onGetHost();

    @androidx.annotation.NonNull
    public android.view.LayoutInflater onGetLayoutInflater() {
        return android.view.LayoutInflater.from(this.mContext);
    }

    public int onGetWindowAnimations() {
        return this.mWindowAnimations;
    }

    @Override // androidx.fragment.app.FragmentContainer
    public boolean onHasView() {
        return true;
    }

    public boolean onHasWindowAnimations() {
        return true;
    }

    @java.lang.Deprecated
    public void onRequestPermissionsFromFragment(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @androidx.annotation.NonNull java.lang.String[] strArr, int i) {
    }

    public boolean onShouldSaveFragmentState(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        return true;
    }

    public boolean onShouldShowRequestPermissionRationale(@androidx.annotation.NonNull java.lang.String str) {
        return false;
    }

    public void onStartActivityFromFragment(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @android.annotation.SuppressLint({"UnknownNullness"}) android.content.Intent intent, int i) {
        onStartActivityFromFragment(fragment, intent, i, null);
    }

    public void onStartActivityFromFragment(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @android.annotation.SuppressLint({"UnknownNullness"}) android.content.Intent intent, int i, @androidx.annotation.Nullable android.os.Bundle bundle) {
        if (i != -1) {
            throw new java.lang.IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        androidx.core.content.ContextCompat.startActivity(this.mContext, intent, bundle);
    }

    @java.lang.Deprecated
    public void onStartIntentSenderFromFragment(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @android.annotation.SuppressLint({"UnknownNullness"}) android.content.IntentSender intentSender, int i, @androidx.annotation.Nullable android.content.Intent intent, int i2, int i3, int i4, @androidx.annotation.Nullable android.os.Bundle bundle) throws android.content.IntentSender.SendIntentException {
        if (i != -1) {
            throw new java.lang.IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        androidx.core.app.ActivityCompat.startIntentSenderForResult(this.mActivity, intentSender, i, intent, i2, i3, i4, bundle);
    }

    public void onSupportInvalidateOptionsMenu() {
    }
}
