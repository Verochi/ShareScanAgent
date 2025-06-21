package kotlin.collections;

@kotlin.Metadata(d1 = {"kotlin/collections/ArraysKt__ArraysJVMKt", "kotlin/collections/ArraysKt__ArraysKt", "kotlin/collections/ArraysKt___ArraysJvmKt", "kotlin/collections/ArraysKt___ArraysKt"}, k = 4, mv = {1, 7, 1}, xi = 49)
/* loaded from: classes14.dex */
public final class ArraysKt extends kotlin.collections.ArraysKt___ArraysKt {
    public static /* bridge */ /* synthetic */ java.lang.Appendable joinTo$default(java.lang.Object[] objArr, java.lang.Appendable appendable, java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, int i, java.lang.CharSequence charSequence4, kotlin.jvm.functions.Function1 function1, int i2, java.lang.Object obj) {
        java.lang.Appendable joinTo;
        joinTo = kotlin.collections.ArraysKt___ArraysKt.joinTo(objArr, appendable, (r14 & 2) != 0 ? ", " : charSequence, (r14 & 4) != 0 ? "" : charSequence2, (r14 & 8) == 0 ? charSequence3 : "", (r14 & 16) != 0 ? -1 : i, (r14 & 32) != 0 ? "..." : charSequence4, (r14 & 64) != 0 ? null : function1);
        return joinTo;
    }
}
