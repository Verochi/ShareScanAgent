package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0010\u0010\u0001\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u0000H\u0000\u001a\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u0000H\u0000\"\u001a\u0010\b\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u0012\u0004\b\u0006\u0010\u0007\"\u001a\u0010\t\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u0012\u0004\b\n\u0010\u0007\"\u001a\u0010\r\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u0012\u0004\b\f\u0010\u0007\"\u001a\u0010\u0010\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u0012\u0004\b\u000f\u0010\u0007\"\u001a\u0010\u0013\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u0012\u0004\b\u0012\u0010\u0007\"\u001a\u0010\u0018\u001a\u00020\u00148\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u0012\u0004\b\u0017\u0010\u0007\"\u001a\u0010\u001b\u001a\u00020\u00148\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u0012\u0004\b\u001a\u0010\u0007¨\u0006\u001c"}, d2 = {"", "boxIncomplete", "unboxState", "Lkotlinx/coroutines/internal/Symbol;", "a", "Lkotlinx/coroutines/internal/Symbol;", "getCOMPLETING_ALREADY$annotations", "()V", "COMPLETING_ALREADY", "COMPLETING_WAITING_CHILDREN", "getCOMPLETING_WAITING_CHILDREN$annotations", "b", "getCOMPLETING_RETRY$annotations", "COMPLETING_RETRY", "c", "getTOO_LATE_TO_CANCEL$annotations", "TOO_LATE_TO_CANCEL", "d", "getSEALED$annotations", "SEALED", "Lkotlinx/coroutines/Empty;", "e", "Lkotlinx/coroutines/Empty;", "getEMPTY_NEW$annotations", "EMPTY_NEW", "f", "getEMPTY_ACTIVE$annotations", "EMPTY_ACTIVE", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes15.dex */
public final class JobSupportKt {

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.internal.Symbol a = new kotlinx.coroutines.internal.Symbol("COMPLETING_ALREADY");

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.internal.Symbol COMPLETING_WAITING_CHILDREN = new kotlinx.coroutines.internal.Symbol("COMPLETING_WAITING_CHILDREN");

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.internal.Symbol b = new kotlinx.coroutines.internal.Symbol("COMPLETING_RETRY");

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.internal.Symbol c = new kotlinx.coroutines.internal.Symbol("TOO_LATE_TO_CANCEL");

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.internal.Symbol d = new kotlinx.coroutines.internal.Symbol("SEALED");

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.Empty e = new kotlinx.coroutines.Empty(false);

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.Empty f = new kotlinx.coroutines.Empty(true);

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object boxIncomplete(@org.jetbrains.annotations.Nullable java.lang.Object obj) {
        return obj instanceof kotlinx.coroutines.Incomplete ? new kotlinx.coroutines.IncompleteStateBox((kotlinx.coroutines.Incomplete) obj) : obj;
    }

    public static /* synthetic */ void getCOMPLETING_WAITING_CHILDREN$annotations() {
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object unboxState(@org.jetbrains.annotations.Nullable java.lang.Object obj) {
        kotlinx.coroutines.Incomplete incomplete;
        kotlinx.coroutines.IncompleteStateBox incompleteStateBox = obj instanceof kotlinx.coroutines.IncompleteStateBox ? (kotlinx.coroutines.IncompleteStateBox) obj : null;
        return (incompleteStateBox == null || (incomplete = incompleteStateBox.com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b java.lang.String) == null) ? obj : incomplete;
    }
}
