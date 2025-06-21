package kotlinx.coroutines.channels;

@kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\"\u0014\u0010\u0001\u001a\u00020\u00008\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0014\u0010\u0003\u001a\u00020\u00008\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0002\"\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\u0007\u0010\b\"\u001a\u0010\t\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\t\u0010\u0006\u0012\u0004\b\n\u0010\b\"\u001a\u0010\u000b\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u0012\u0004\b\f\u0010\b\"\u001a\u0010\r\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\r\u0010\u0006\u0012\u0004\b\u000e\u0010\b\"\u001a\u0010\u000f\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0006\u0012\u0004\b\u0010\u0010\b\"\u001a\u0010\u0011\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0006\u0012\u0004\b\u0012\u0010\b*(\b\u0000\u0010\u0016\"\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u00150\u00132\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u00150\u0013¨\u0006\u0017"}, d2 = {"", "RECEIVE_THROWS_ON_CLOSE", "I", "RECEIVE_RESULT", "Lkotlinx/coroutines/internal/Symbol;", "EMPTY", "Lkotlinx/coroutines/internal/Symbol;", "getEMPTY$annotations", "()V", "OFFER_SUCCESS", "getOFFER_SUCCESS$annotations", "OFFER_FAILED", "getOFFER_FAILED$annotations", "POLL_FAILED", "getPOLL_FAILED$annotations", "ENQUEUE_FAILED", "getENQUEUE_FAILED$annotations", "HANDLER_INVOKED", "getHANDLER_INVOKED$annotations", "Lkotlin/Function1;", "", "", "Handler", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class AbstractChannelKt {
    public static final int RECEIVE_RESULT = 1;
    public static final int RECEIVE_THROWS_ON_CLOSE = 0;

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.internal.Symbol EMPTY = new kotlinx.coroutines.internal.Symbol("EMPTY");

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.internal.Symbol OFFER_SUCCESS = new kotlinx.coroutines.internal.Symbol("OFFER_SUCCESS");

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.internal.Symbol OFFER_FAILED = new kotlinx.coroutines.internal.Symbol("OFFER_FAILED");

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.internal.Symbol POLL_FAILED = new kotlinx.coroutines.internal.Symbol("POLL_FAILED");

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.internal.Symbol ENQUEUE_FAILED = new kotlinx.coroutines.internal.Symbol("ENQUEUE_FAILED");

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.internal.Symbol HANDLER_INVOKED = new kotlinx.coroutines.internal.Symbol("ON_CLOSE_HANDLER_INVOKED");

    public static /* synthetic */ void getEMPTY$annotations() {
    }

    public static /* synthetic */ void getENQUEUE_FAILED$annotations() {
    }

    public static /* synthetic */ void getHANDLER_INVOKED$annotations() {
    }

    public static /* synthetic */ void getOFFER_FAILED$annotations() {
    }

    public static /* synthetic */ void getOFFER_SUCCESS$annotations() {
    }

    public static /* synthetic */ void getPOLL_FAILED$annotations() {
    }
}
