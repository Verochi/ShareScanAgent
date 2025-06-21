package kotlin.sequences;

/* JADX INFO: Add missing generic type declarations: [T] */
@kotlin.Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class SequencesKt__SequencesKt$flatten$2<T> extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function1<java.lang.Iterable<? extends T>, java.util.Iterator<? extends T>> {
    public static final kotlin.sequences.SequencesKt__SequencesKt$flatten$2 INSTANCE = new kotlin.sequences.SequencesKt__SequencesKt$flatten$2();

    public SequencesKt__SequencesKt$flatten$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    @org.jetbrains.annotations.NotNull
    public final java.util.Iterator<T> invoke(@org.jetbrains.annotations.NotNull java.lang.Iterable<? extends T> it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return it.iterator();
    }
}
