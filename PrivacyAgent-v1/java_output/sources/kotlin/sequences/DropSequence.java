package kotlin.sequences;

@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\n\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001d\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096\u0002R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lkotlin/sequences/DropSequence;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "drop", "take", "", "iterator", "a", "Lkotlin/sequences/Sequence;", "sequence", "b", "I", me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT, "<init>", "(Lkotlin/sequences/Sequence;I)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class DropSequence<T> implements kotlin.sequences.Sequence<T>, kotlin.sequences.DropTakeSequence<T> {

    /* renamed from: a, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.sequences.Sequence<T> sequence;

    /* renamed from: b, reason: from kotlin metadata */
    public final int count;

    /* JADX WARN: Multi-variable type inference failed */
    public DropSequence(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends T> sequence, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "sequence");
        this.sequence = sequence;
        this.count = i;
        if (i >= 0) {
            return;
        }
        throw new java.lang.IllegalArgumentException(("count must be non-negative, but was " + i + '.').toString());
    }

    @Override // kotlin.sequences.DropTakeSequence
    @org.jetbrains.annotations.NotNull
    public kotlin.sequences.Sequence<T> drop(int n) {
        int i = this.count + n;
        return i < 0 ? new kotlin.sequences.DropSequence(this, n) : new kotlin.sequences.DropSequence(this.sequence, i);
    }

    @Override // kotlin.sequences.Sequence
    @org.jetbrains.annotations.NotNull
    public java.util.Iterator<T> iterator() {
        return new kotlin.sequences.DropSequence$iterator$1(this);
    }

    @Override // kotlin.sequences.DropTakeSequence
    @org.jetbrains.annotations.NotNull
    public kotlin.sequences.Sequence<T> take(int n) {
        int i = this.count;
        int i2 = i + n;
        return i2 < 0 ? new kotlin.sequences.TakeSequence(this, n) : new kotlin.sequences.SubSequence(this.sequence, i, i2);
    }
}
