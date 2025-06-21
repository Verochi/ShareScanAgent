package kotlinx.coroutines.flow;

@kotlin.Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/flow/StartedWhileSubscribed;", "Lkotlinx/coroutines/flow/SharingStarted;", "Lkotlinx/coroutines/flow/StateFlow;", "", "subscriptionCount", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharingCommand;", com.heytap.mcssdk.constant.b.y, "", "toString", "", "other", "", "equals", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "", "a", "J", "stopTimeout", "b", "replayExpiration", "<init>", "(JJ)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
final class StartedWhileSubscribed implements kotlinx.coroutines.flow.SharingStarted {

    /* renamed from: a, reason: from kotlin metadata */
    public final long stopTimeout;

    /* renamed from: b, reason: from kotlin metadata */
    public final long replayExpiration;

    public StartedWhileSubscribed(long j, long j2) {
        this.stopTimeout = j;
        this.replayExpiration = j2;
        if (!(j >= 0)) {
            throw new java.lang.IllegalArgumentException(("stopTimeout(" + j + " ms) cannot be negative").toString());
        }
        if (j2 >= 0) {
            return;
        }
        throw new java.lang.IllegalArgumentException(("replayExpiration(" + j2 + " ms) cannot be negative").toString());
    }

    @Override // kotlinx.coroutines.flow.SharingStarted
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<kotlinx.coroutines.flow.SharingCommand> command(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.StateFlow<java.lang.Integer> subscriptionCount) {
        return kotlinx.coroutines.flow.FlowKt.distinctUntilChanged(kotlinx.coroutines.flow.FlowKt.dropWhile(kotlinx.coroutines.flow.FlowKt.transformLatest(subscriptionCount, new kotlinx.coroutines.flow.StartedWhileSubscribed$command$1(this, null)), new kotlinx.coroutines.flow.StartedWhileSubscribed$command$2(null)));
    }

    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object other) {
        if (other instanceof kotlinx.coroutines.flow.StartedWhileSubscribed) {
            kotlinx.coroutines.flow.StartedWhileSubscribed startedWhileSubscribed = (kotlinx.coroutines.flow.StartedWhileSubscribed) other;
            if (this.stopTimeout == startedWhileSubscribed.stopTimeout && this.replayExpiration == startedWhileSubscribed.replayExpiration) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (defpackage.ap0.a(this.stopTimeout) * 31) + defpackage.ap0.a(this.replayExpiration);
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        java.util.List createListBuilder;
        java.util.List build;
        java.lang.String joinToString$default;
        createListBuilder = kotlin.collections.CollectionsKt__CollectionsJVMKt.createListBuilder(2);
        if (this.stopTimeout > 0) {
            createListBuilder.add("stopTimeout=" + this.stopTimeout + "ms");
        }
        if (this.replayExpiration < Long.MAX_VALUE) {
            createListBuilder.add("replayExpiration=" + this.replayExpiration + "ms");
        }
        build = kotlin.collections.CollectionsKt__CollectionsJVMKt.build(createListBuilder);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("SharingStarted.WhileSubscribed(");
        joinToString$default = kotlin.collections.CollectionsKt___CollectionsKt.joinToString$default(build, null, null, null, 0, null, null, 63, null);
        sb.append(joinToString$default);
        sb.append(')');
        return sb.toString();
    }
}
