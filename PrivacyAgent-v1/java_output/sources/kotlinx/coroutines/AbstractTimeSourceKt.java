package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\b\"$\u0010\u0007\u001a\u0004\u0018\u00010\u00008\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/AbstractTimeSource;", "a", "Lkotlinx/coroutines/AbstractTimeSource;", "getTimeSource", "()Lkotlinx/coroutines/AbstractTimeSource;", "setTimeSource", "(Lkotlinx/coroutines/AbstractTimeSource;)V", "timeSource", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes15.dex */
public final class AbstractTimeSourceKt {

    @org.jetbrains.annotations.Nullable
    public static kotlinx.coroutines.AbstractTimeSource a;

    @org.jetbrains.annotations.Nullable
    public static final kotlinx.coroutines.AbstractTimeSource getTimeSource() {
        return a;
    }

    public static final void setTimeSource(@org.jetbrains.annotations.Nullable kotlinx.coroutines.AbstractTimeSource abstractTimeSource) {
        a = abstractTimeSource;
    }
}
