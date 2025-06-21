package kotlin.sequences;

@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u000e\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B%\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096\u0002R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0012¨\u0006\u0016"}, d2 = {"Lkotlin/sequences/SubSequence;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "drop", "take", "", "iterator", "a", "Lkotlin/sequences/Sequence;", "sequence", "b", "I", "startIndex", "c", "endIndex", "()I", me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT, "<init>", "(Lkotlin/sequences/Sequence;II)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class SubSequence<T> implements kotlin.sequences.Sequence<T>, kotlin.sequences.DropTakeSequence<T> {

    /* renamed from: a, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.sequences.Sequence<T> sequence;

    /* renamed from: b, reason: from kotlin metadata */
    public final int startIndex;

    /* renamed from: c, reason: from kotlin metadata */
    public final int endIndex;

    /* JADX WARN: Multi-variable type inference failed */
    public SubSequence(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends T> sequence, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "sequence");
        this.sequence = sequence;
        this.startIndex = i;
        this.endIndex = i2;
        if (!(i >= 0)) {
            throw new java.lang.IllegalArgumentException(("startIndex should be non-negative, but is " + i).toString());
        }
        if (!(i2 >= 0)) {
            throw new java.lang.IllegalArgumentException(("endIndex should be non-negative, but is " + i2).toString());
        }
        if (i2 >= i) {
            return;
        }
        throw new java.lang.IllegalArgumentException(("endIndex should be not less than startIndex, but was " + i2 + " < " + i).toString());
    }

    public final int a() {
        return this.endIndex - this.startIndex;
    }

    @Override // kotlin.sequences.DropTakeSequence
    @org.jetbrains.annotations.NotNull
    public kotlin.sequences.Sequence<T> drop(int n) {
        return n >= a() ? kotlin.sequences.SequencesKt__SequencesKt.emptySequence() : new kotlin.sequences.SubSequence(this.sequence, this.startIndex + n, this.endIndex);
    }

    @Override // kotlin.sequences.Sequence
    @org.jetbrains.annotations.NotNull
    public java.util.Iterator<T> iterator() {
        return new kotlin.sequences.SubSequence$iterator$1(this);
    }

    @Override // kotlin.sequences.DropTakeSequence
    @org.jetbrains.annotations.NotNull
    public kotlin.sequences.Sequence<T> take(int n) {
        if (n >= a()) {
            return this;
        }
        kotlin.sequences.Sequence<T> sequence = this.sequence;
        int i = this.startIndex;
        return new kotlin.sequences.SubSequence(sequence, i, n + i);
    }
}
