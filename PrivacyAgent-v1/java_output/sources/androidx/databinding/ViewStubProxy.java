package androidx.databinding;

/* loaded from: classes.dex */
public class ViewStubProxy {
    private androidx.databinding.ViewDataBinding mContainingBinding;
    private android.view.ViewStub.OnInflateListener mOnInflateListener;
    private android.view.ViewStub.OnInflateListener mProxyListener;
    private android.view.View mRoot;
    private androidx.databinding.ViewDataBinding mViewDataBinding;
    private android.view.ViewStub mViewStub;

    /* renamed from: androidx.databinding.ViewStubProxy$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.ViewStub.OnInflateListener {
        public AnonymousClass1() {
        }

        @Override // android.view.ViewStub.OnInflateListener
        public void onInflate(android.view.ViewStub viewStub, android.view.View view) {
            androidx.databinding.ViewStubProxy.this.mRoot = view;
            androidx.databinding.ViewStubProxy viewStubProxy = androidx.databinding.ViewStubProxy.this;
            viewStubProxy.mViewDataBinding = androidx.databinding.DataBindingUtil.bind(viewStubProxy.mContainingBinding.mBindingComponent, view, viewStub.getLayoutResource());
            androidx.databinding.ViewStubProxy.this.mViewStub = null;
            if (androidx.databinding.ViewStubProxy.this.mOnInflateListener != null) {
                androidx.databinding.ViewStubProxy.this.mOnInflateListener.onInflate(viewStub, view);
                androidx.databinding.ViewStubProxy.this.mOnInflateListener = null;
            }
            androidx.databinding.ViewStubProxy.this.mContainingBinding.invalidateAll();
            androidx.databinding.ViewStubProxy.this.mContainingBinding.forceExecuteBindings();
        }
    }

    public ViewStubProxy(@androidx.annotation.NonNull android.view.ViewStub viewStub) {
        androidx.databinding.ViewStubProxy.AnonymousClass1 anonymousClass1 = new androidx.databinding.ViewStubProxy.AnonymousClass1();
        this.mProxyListener = anonymousClass1;
        this.mViewStub = viewStub;
        viewStub.setOnInflateListener(anonymousClass1);
    }

    @androidx.annotation.Nullable
    public androidx.databinding.ViewDataBinding getBinding() {
        return this.mViewDataBinding;
    }

    public android.view.View getRoot() {
        return this.mRoot;
    }

    @androidx.annotation.Nullable
    public android.view.ViewStub getViewStub() {
        return this.mViewStub;
    }

    public boolean isInflated() {
        return this.mRoot != null;
    }

    public void setContainingBinding(@androidx.annotation.NonNull androidx.databinding.ViewDataBinding viewDataBinding) {
        this.mContainingBinding = viewDataBinding;
    }

    public void setOnInflateListener(@androidx.annotation.Nullable android.view.ViewStub.OnInflateListener onInflateListener) {
        if (this.mViewStub != null) {
            this.mOnInflateListener = onInflateListener;
        }
    }
}
