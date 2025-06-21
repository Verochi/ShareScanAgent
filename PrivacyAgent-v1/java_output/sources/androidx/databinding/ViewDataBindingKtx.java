package androidx.databinding;

@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/databinding/ViewDataBindingKtx;", "", "()V", "CREATE_STATE_FLOW_LISTENER", "Landroidx/databinding/CreateWeakListener;", "updateStateFlowRegistration", "", "viewDataBinding", "Landroidx/databinding/ViewDataBinding;", "localFieldId", "", "observable", "Lkotlinx/coroutines/flow/Flow;", "StateFlowListener", "databindingKtx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class ViewDataBindingKtx {

    @org.jetbrains.annotations.NotNull
    public static final androidx.databinding.ViewDataBindingKtx INSTANCE = new androidx.databinding.ViewDataBindingKtx();

    @org.jetbrains.annotations.NotNull
    private static final androidx.databinding.CreateWeakListener CREATE_STATE_FLOW_LISTENER = new androidx.databinding.a();

    @kotlin.Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001B%\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0002\u0010\nJ\u001a\u0010\u0012\u001a\u00020\u00132\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016J\u0016\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u000fH\u0016J\u001a\u0010\u0016\u001a\u00020\u00132\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016J\u0012\u0010\u0017\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\rH\u0016J \u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\r2\u000e\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0002R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/databinding/ViewDataBindingKtx$StateFlowListener;", "Landroidx/databinding/ObservableReference;", "Lkotlinx/coroutines/flow/Flow;", "", "binder", "Landroidx/databinding/ViewDataBinding;", "localFieldId", "", "referenceQueue", "Ljava/lang/ref/ReferenceQueue;", "(Landroidx/databinding/ViewDataBinding;ILjava/lang/ref/ReferenceQueue;)V", "_lifecycleOwnerRef", "Ljava/lang/ref/WeakReference;", "Landroidx/lifecycle/LifecycleOwner;", com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/databinding/WeakListener;", "observerJob", "Lkotlinx/coroutines/Job;", "addListener", "", com.umeng.ccg.a.A, "getListener", "removeListener", "setLifecycleOwner", "lifecycleOwner", "startCollection", "owner", com.alimm.tanx.core.constant.TanxAdType.FEED_STRING, "databindingKtx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class StateFlowListener implements androidx.databinding.ObservableReference<kotlinx.coroutines.flow.Flow<? extends java.lang.Object>> {

        @org.jetbrains.annotations.Nullable
        private java.lang.ref.WeakReference<androidx.lifecycle.LifecycleOwner> _lifecycleOwnerRef;

        @org.jetbrains.annotations.NotNull
        private final androidx.databinding.WeakListener<kotlinx.coroutines.flow.Flow<java.lang.Object>> listener;

        @org.jetbrains.annotations.Nullable
        private kotlinx.coroutines.Job observerJob;

        public StateFlowListener(@org.jetbrains.annotations.Nullable androidx.databinding.ViewDataBinding viewDataBinding, int i, @org.jetbrains.annotations.NotNull java.lang.ref.ReferenceQueue<androidx.databinding.ViewDataBinding> referenceQueue) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(referenceQueue, "referenceQueue");
            this.listener = new androidx.databinding.WeakListener<>(viewDataBinding, i, this, referenceQueue);
        }

        private final void startCollection(androidx.lifecycle.LifecycleOwner owner, kotlinx.coroutines.flow.Flow<? extends java.lang.Object> flow) {
            kotlinx.coroutines.Job e;
            kotlinx.coroutines.Job job = this.observerJob;
            if (job != null) {
                kotlinx.coroutines.Job.DefaultImpls.cancel$default(job, (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
            }
            e = kotlinx.coroutines.BuildersKt__Builders_commonKt.e(androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(owner), null, null, new androidx.databinding.ViewDataBindingKtx$StateFlowListener$startCollection$1(owner, flow, this, null), 3, null);
            this.observerJob = e;
        }

        @Override // androidx.databinding.ObservableReference
        public void addListener(@org.jetbrains.annotations.Nullable kotlinx.coroutines.flow.Flow<? extends java.lang.Object> target) {
            androidx.lifecycle.LifecycleOwner lifecycleOwner;
            java.lang.ref.WeakReference<androidx.lifecycle.LifecycleOwner> weakReference = this._lifecycleOwnerRef;
            if (weakReference == null || (lifecycleOwner = weakReference.get()) == null || target == null) {
                return;
            }
            startCollection(lifecycleOwner, target);
        }

        @Override // androidx.databinding.ObservableReference
        @org.jetbrains.annotations.NotNull
        public androidx.databinding.WeakListener<kotlinx.coroutines.flow.Flow<? extends java.lang.Object>> getListener() {
            return this.listener;
        }

        @Override // androidx.databinding.ObservableReference
        public void removeListener(@org.jetbrains.annotations.Nullable kotlinx.coroutines.flow.Flow<? extends java.lang.Object> target) {
            kotlinx.coroutines.Job job = this.observerJob;
            if (job != null) {
                kotlinx.coroutines.Job.DefaultImpls.cancel$default(job, (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
            }
            this.observerJob = null;
        }

        @Override // androidx.databinding.ObservableReference
        public void setLifecycleOwner(@org.jetbrains.annotations.Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
            java.lang.ref.WeakReference<androidx.lifecycle.LifecycleOwner> weakReference = this._lifecycleOwnerRef;
            if ((weakReference != null ? weakReference.get() : null) == lifecycleOwner) {
                return;
            }
            kotlinx.coroutines.Job job = this.observerJob;
            if (job != null) {
                kotlinx.coroutines.Job.DefaultImpls.cancel$default(job, (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
            }
            if (lifecycleOwner == null) {
                this._lifecycleOwnerRef = null;
                return;
            }
            this._lifecycleOwnerRef = new java.lang.ref.WeakReference<>(lifecycleOwner);
            kotlinx.coroutines.flow.Flow<? extends java.lang.Object> flow = (kotlinx.coroutines.flow.Flow) this.listener.getTarget();
            if (flow != null) {
                startCollection(lifecycleOwner, flow);
            }
        }
    }

    private ViewDataBindingKtx() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: CREATE_STATE_FLOW_LISTENER$lambda-0, reason: not valid java name */
    public static final androidx.databinding.WeakListener m7CREATE_STATE_FLOW_LISTENER$lambda0(androidx.databinding.ViewDataBinding viewDataBinding, int i, java.lang.ref.ReferenceQueue referenceQueue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(referenceQueue, "referenceQueue");
        return new androidx.databinding.ViewDataBindingKtx.StateFlowListener(viewDataBinding, i, referenceQueue).getListener();
    }

    @kotlin.jvm.JvmStatic
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean updateStateFlowRegistration(@org.jetbrains.annotations.NotNull androidx.databinding.ViewDataBinding viewDataBinding, int localFieldId, @org.jetbrains.annotations.Nullable kotlinx.coroutines.flow.Flow<?> observable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(viewDataBinding, "viewDataBinding");
        viewDataBinding.mInStateFlowRegisterObserver = true;
        try {
            return viewDataBinding.updateRegistration(localFieldId, observable, CREATE_STATE_FLOW_LISTENER);
        } finally {
            viewDataBinding.mInStateFlowRegisterObserver = false;
        }
    }
}
