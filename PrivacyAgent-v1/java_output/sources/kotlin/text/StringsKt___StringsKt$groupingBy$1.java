package kotlin.text;

/* JADX INFO: Add missing generic type declarations: [K] */
@kotlin.Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001J\u0015\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"kotlin/text/StringsKt___StringsKt$groupingBy$1", "Lkotlin/collections/Grouping;", "", "keyOf", "element", "(C)Ljava/lang/Object;", "sourceIterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 176)
/* loaded from: classes14.dex */
public final class StringsKt___StringsKt$groupingBy$1<K> implements kotlin.collections.Grouping<java.lang.Character, K> {
    public final /* synthetic */ java.lang.CharSequence a;
    public final /* synthetic */ kotlin.jvm.functions.Function1<java.lang.Character, K> b;

    /* JADX WARN: Multi-variable type inference failed */
    public StringsKt___StringsKt$groupingBy$1(java.lang.CharSequence charSequence, kotlin.jvm.functions.Function1<? super java.lang.Character, ? extends K> function1) {
        this.a = charSequence;
        this.b = function1;
    }

    public K keyOf(char element) {
        return this.b.invoke(java.lang.Character.valueOf(element));
    }

    @Override // kotlin.collections.Grouping
    public /* bridge */ /* synthetic */ java.lang.Object keyOf(java.lang.Character ch) {
        return keyOf(ch.charValue());
    }

    @Override // kotlin.collections.Grouping
    @org.jetbrains.annotations.NotNull
    public java.util.Iterator<java.lang.Character> sourceIterator() {
        return kotlin.text.StringsKt__StringsKt.iterator(this.a);
    }
}
