package kotlinx.coroutines.sync;

@kotlin.Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"R", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class MutexImpl$LockSelect$completeResumeLockWaiter$2 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> {
    final /* synthetic */ kotlinx.coroutines.sync.MutexImpl this$0;
    final /* synthetic */ kotlinx.coroutines.sync.MutexImpl.LockSelect<R> this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutexImpl$LockSelect$completeResumeLockWaiter$2(kotlinx.coroutines.sync.MutexImpl mutexImpl, kotlinx.coroutines.sync.MutexImpl.LockSelect<R> lockSelect) {
        super(1);
        this.this$0 = mutexImpl;
        this.this$1 = lockSelect;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kotlin.Unit invoke(java.lang.Throwable th) {
        invoke2(th);
        return kotlin.Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@org.jetbrains.annotations.NotNull java.lang.Throwable th) {
        this.this$0.unlock(this.this$1.owner);
    }
}
