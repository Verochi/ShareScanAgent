package kotlinx.coroutines.sync;

@kotlin.Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0006\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/sync/Empty;", "", "", "toString", "a", "Ljava/lang/Object;", "locked", "<init>", "(Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
final class Empty {

    /* renamed from: a, reason: from kotlin metadata */
    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object locked;

    public Empty(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        this.locked = obj;
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return "Empty[" + this.locked + ']';
    }
}
