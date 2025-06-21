package kotlinx.coroutines.sync;

@kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class MutexImpl$LockCont$tryResumeLockWaiter$1 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> {
    final /* synthetic */ kotlinx.coroutines.sync.MutexImpl this$0;
    final /* synthetic */ kotlinx.coroutines.sync.MutexImpl.LockCont this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutexImpl$LockCont$tryResumeLockWaiter$1(kotlinx.coroutines.sync.MutexImpl mutexImpl, kotlinx.coroutines.sync.MutexImpl.LockCont lockCont) {
        super(1);
        this.this$0 = mutexImpl;
        this.this$1 = lockCont;
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
