package kotlinx.coroutines.test;

@kotlin.Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u00032\u00020\u0004B'\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b#\u0010$J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0011\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0000H\u0096\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0018\u0010\u0006\u001a\u00060\u0002j\u0002`\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R(\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00148\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\"\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006%"}, d2 = {"Lkotlinx/coroutines/test/TimedRunnableObsolete;", "", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "run", "other", "", "a", "", "toString", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Ljava/lang/Runnable;", "", "t", "J", me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT, com.umeng.analytics.pro.bo.aN, "time", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "v", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "heap", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "I", "getIndex", "()I", "setIndex", "(I)V", "index", "<init>", "(Ljava/lang/Runnable;JJ)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* renamed from: kotlinx.coroutines.test.TimedRunnableObsolete, reason: from toString */
/* loaded from: classes16.dex */
final class TimedRunnable implements java.lang.Comparable<kotlinx.coroutines.test.TimedRunnable>, java.lang.Runnable, kotlinx.coroutines.internal.ThreadSafeHeapNode {

    /* renamed from: n, reason: from kotlin metadata and from toString */
    @org.jetbrains.annotations.NotNull
    public final java.lang.Runnable run;

    /* renamed from: t, reason: from kotlin metadata */
    public final long count;

    /* renamed from: u, reason: from kotlin metadata and from toString */
    @kotlin.jvm.JvmField
    public final long time;

    /* renamed from: v, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public kotlinx.coroutines.internal.ThreadSafeHeap<?> heap;

    /* renamed from: w, reason: from kotlin metadata */
    public int index;

    public TimedRunnable(@org.jetbrains.annotations.NotNull java.lang.Runnable runnable, long j, long j2) {
        this.run = runnable;
        this.count = j;
        this.time = j2;
    }

    public /* synthetic */ TimedRunnable(java.lang.Runnable runnable, long j, long j2, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(runnable, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? 0L : j2);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@org.jetbrains.annotations.NotNull kotlinx.coroutines.test.TimedRunnable other) {
        long j = this.time;
        long j2 = other.time;
        return j == j2 ? kotlin.jvm.internal.Intrinsics.compare(this.count, other.count) : kotlin.jvm.internal.Intrinsics.compare(j, j2);
    }

    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    @org.jetbrains.annotations.Nullable
    public kotlinx.coroutines.internal.ThreadSafeHeap<?> getHeap() {
        return this.heap;
    }

    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    public int getIndex() {
        return this.index;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.run.run();
    }

    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    public void setHeap(@org.jetbrains.annotations.Nullable kotlinx.coroutines.internal.ThreadSafeHeap<?> threadSafeHeap) {
        this.heap = threadSafeHeap;
    }

    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    public void setIndex(int i) {
        this.index = i;
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return "TimedRunnable(time=" + this.time + ", run=" + this.run + ')';
    }
}
