package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class zr2 implements java.util.function.Supplier {
    public final /* synthetic */ kotlin.sequences.Sequence a;

    public /* synthetic */ zr2(kotlin.sequences.Sequence sequence) {
        this.a = sequence;
    }

    @Override // java.util.function.Supplier
    public final java.lang.Object get() {
        java.util.Spliterator b;
        b = kotlin.streams.jdk8.StreamsKt.b(this.a);
        return b;
    }
}
