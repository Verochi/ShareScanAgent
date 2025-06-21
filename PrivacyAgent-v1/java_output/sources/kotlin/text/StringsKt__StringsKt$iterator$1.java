package kotlin.text;

@kotlin.Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0002R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"kotlin/text/StringsKt__StringsKt$iterator$1", "Lkotlin/collections/CharIterator;", "", "nextChar", "", "hasNext", "", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "I", "index", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class StringsKt__StringsKt$iterator$1 extends kotlin.collections.CharIterator {

    /* renamed from: n, reason: from kotlin metadata */
    public int index;
    public final /* synthetic */ java.lang.CharSequence t;

    public StringsKt__StringsKt$iterator$1(java.lang.CharSequence charSequence) {
        this.t = charSequence;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.t.length();
    }

    @Override // kotlin.collections.CharIterator
    public char nextChar() {
        java.lang.CharSequence charSequence = this.t;
        int i = this.index;
        this.index = i + 1;
        return charSequence.charAt(i);
    }
}
