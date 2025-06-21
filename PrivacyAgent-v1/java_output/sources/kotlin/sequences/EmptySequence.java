package kotlin.sequences;

@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0096\u0002J\u0010\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\f"}, d2 = {"Lkotlin/sequences/EmptySequence;", "Lkotlin/sequences/Sequence;", "", "Lkotlin/sequences/DropTakeSequence;", "", "iterator", "", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "a", "b", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
final class EmptySequence implements kotlin.sequences.Sequence, kotlin.sequences.DropTakeSequence {

    @org.jetbrains.annotations.NotNull
    public static final kotlin.sequences.EmptySequence a = new kotlin.sequences.EmptySequence();

    @Override // kotlin.sequences.DropTakeSequence
    @org.jetbrains.annotations.NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public kotlin.sequences.EmptySequence drop(int n) {
        return a;
    }

    @Override // kotlin.sequences.DropTakeSequence
    @org.jetbrains.annotations.NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public kotlin.sequences.EmptySequence take(int n) {
        return a;
    }

    @Override // kotlin.sequences.Sequence
    @org.jetbrains.annotations.NotNull
    public java.util.Iterator iterator() {
        return kotlin.collections.EmptyIterator.INSTANCE;
    }
}
