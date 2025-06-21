package kotlinx.coroutines.flow;

@kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/flow/SharingStarted;", "", com.heytap.mcssdk.constant.b.y, "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharingCommand;", "subscriptionCount", "Lkotlinx/coroutines/flow/StateFlow;", "", "Companion", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public interface SharingStarted {

    /* renamed from: Companion, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.flow.SharingStarted.Companion INSTANCE = kotlinx.coroutines.flow.SharingStarted.Companion.a;

    @kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002R\u0017\u0010\u000b\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000e\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\n¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/flow/SharingStarted$Companion;", "", "", "stopTimeoutMillis", "replayExpirationMillis", "Lkotlinx/coroutines/flow/SharingStarted;", "WhileSubscribed", "b", "Lkotlinx/coroutines/flow/SharingStarted;", "getEagerly", "()Lkotlinx/coroutines/flow/SharingStarted;", "Eagerly", "c", "getLazily", "Lazily", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        public static final /* synthetic */ kotlinx.coroutines.flow.SharingStarted.Companion a = new kotlinx.coroutines.flow.SharingStarted.Companion();

        /* renamed from: b, reason: from kotlin metadata */
        @org.jetbrains.annotations.NotNull
        public static final kotlinx.coroutines.flow.SharingStarted Eagerly = new kotlinx.coroutines.flow.StartedEagerly();

        /* renamed from: c, reason: from kotlin metadata */
        @org.jetbrains.annotations.NotNull
        public static final kotlinx.coroutines.flow.SharingStarted Lazily = new kotlinx.coroutines.flow.StartedLazily();

        public static /* synthetic */ kotlinx.coroutines.flow.SharingStarted WhileSubscribed$default(kotlinx.coroutines.flow.SharingStarted.Companion companion, long j, long j2, int i, java.lang.Object obj) {
            if ((i & 1) != 0) {
                j = 0;
            }
            if ((i & 2) != 0) {
                j2 = Long.MAX_VALUE;
            }
            return companion.WhileSubscribed(j, j2);
        }

        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.flow.SharingStarted WhileSubscribed(long stopTimeoutMillis, long replayExpirationMillis) {
            return new kotlinx.coroutines.flow.StartedWhileSubscribed(stopTimeoutMillis, replayExpirationMillis);
        }

        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.flow.SharingStarted getEagerly() {
            return Eagerly;
        }

        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.flow.SharingStarted getLazily() {
            return Lazily;
        }
    }

    @org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.Flow<kotlinx.coroutines.flow.SharingCommand> command(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.StateFlow<java.lang.Integer> subscriptionCount);
}
