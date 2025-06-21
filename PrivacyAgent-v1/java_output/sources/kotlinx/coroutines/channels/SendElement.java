package kotlinx.coroutines.channels;

@kotlin.Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0012\u001a\u00028\u0000\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0014\u0010\u000b\u001a\u00020\u00072\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u001a\u0010\u0012\u001a\u00028\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00138\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/channels/SendElement;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "Lkotlinx/coroutines/internal/Symbol;", "tryResumeSend", "", "completeResumeSend", "Lkotlinx/coroutines/channels/Closed;", "closed", "resumeSendClosed", "", "toString", "v", "Ljava/lang/Object;", "getPollResult", "()Ljava/lang/Object;", "pollResult", "Lkotlinx/coroutines/CancellableContinuation;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public class SendElement<E> extends kotlinx.coroutines.channels.Send {

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.CancellableContinuation<kotlin.Unit> cont;

    /* renamed from: v, reason: from kotlin metadata */
    public final E pollResult;

    /* JADX WARN: Multi-variable type inference failed */
    public SendElement(E e, @org.jetbrains.annotations.NotNull kotlinx.coroutines.CancellableContinuation<? super kotlin.Unit> cancellableContinuation) {
        this.pollResult = e;
        this.cont = cancellableContinuation;
    }

    @Override // kotlinx.coroutines.channels.Send
    public void completeResumeSend() {
        this.cont.completeResume(kotlinx.coroutines.CancellableContinuationImplKt.RESUME_TOKEN);
    }

    @Override // kotlinx.coroutines.channels.Send
    /* renamed from: getPollResult */
    public E getElement() {
        return this.pollResult;
    }

    @Override // kotlinx.coroutines.channels.Send
    public void resumeSendClosed(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.Closed<?> closed) {
        kotlinx.coroutines.CancellableContinuation<kotlin.Unit> cancellableContinuation = this.cont;
        java.lang.Throwable sendException = closed.getSendException();
        kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
        cancellableContinuation.resumeWith(kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(sendException)));
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return kotlinx.coroutines.DebugStringsKt.getClassSimpleName(this) + '@' + kotlinx.coroutines.DebugStringsKt.getHexAddress(this) + '(' + getElement() + ')';
    }

    @Override // kotlinx.coroutines.channels.Send
    @org.jetbrains.annotations.Nullable
    public kotlinx.coroutines.internal.Symbol tryResumeSend(@org.jetbrains.annotations.Nullable kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp otherOp) {
        if (this.cont.tryResume(kotlin.Unit.INSTANCE, otherOp == null ? null : otherOp.desc) == null) {
            return null;
        }
        if (otherOp != null) {
            otherOp.finishPrepare();
        }
        return kotlinx.coroutines.CancellableContinuationImplKt.RESUME_TOKEN;
    }
}
