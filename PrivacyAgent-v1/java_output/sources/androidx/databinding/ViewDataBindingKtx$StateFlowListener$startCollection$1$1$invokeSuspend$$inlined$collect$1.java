package androidx.databinding;

@kotlin.Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ViewDataBindingKtx$StateFlowListener$startCollection$1$1$invokeSuspend$$inlined$collect$1 implements kotlinx.coroutines.flow.FlowCollector<java.lang.Object> {
    final /* synthetic */ androidx.databinding.ViewDataBindingKtx.StateFlowListener this$0;

    public ViewDataBindingKtx$StateFlowListener$startCollection$1$1$invokeSuspend$$inlined$collect$1(androidx.databinding.ViewDataBindingKtx.StateFlowListener stateFlowListener) {
        this.this$0 = stateFlowListener;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @org.jetbrains.annotations.Nullable
    public java.lang.Object emit(java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        androidx.databinding.WeakListener weakListener;
        androidx.databinding.WeakListener weakListener2;
        androidx.databinding.WeakListener weakListener3;
        weakListener = this.this$0.listener;
        androidx.databinding.ViewDataBinding binder = weakListener.getBinder();
        if (binder != null) {
            weakListener2 = this.this$0.listener;
            int i = weakListener2.mLocalFieldId;
            weakListener3 = this.this$0.listener;
            binder.handleFieldChange(i, weakListener3.getTarget(), 0);
        }
        return kotlin.Unit.INSTANCE;
    }
}
