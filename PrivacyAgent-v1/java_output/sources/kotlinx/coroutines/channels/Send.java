package kotlinx.coroutines.channels;

@kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH&J\u0014\u0010\t\u001a\u00020\b2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH&J\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\b\u0010\u0010\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "()V", "pollResult", "", "getPollResult", "()Ljava/lang/Object;", "completeResumeSend", "", "resumeSendClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "tryResumeSend", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "undeliveredElement", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public abstract class Send extends kotlinx.coroutines.internal.LockFreeLinkedListNode {
    public abstract void completeResumeSend();

    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getPollResult();

    public abstract void resumeSendClosed(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.Closed<?> closed);

    @org.jetbrains.annotations.Nullable
    public abstract kotlinx.coroutines.internal.Symbol tryResumeSend(@org.jetbrains.annotations.Nullable kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp otherOp);

    public void undeliveredElement() {
    }
}
