package kotlin.text;

@kotlin.Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0017\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\"\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\n\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000e¨\u0006#"}, d2 = {"kotlin/text/DelimitedRangesSequence$iterator$1", "", "Lkotlin/ranges/IntRange;", "next", "", "hasNext", "", "a", "", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "I", "getNextState", "()I", "setNextState", "(I)V", "nextState", "t", "getCurrentStartIndex", "setCurrentStartIndex", "currentStartIndex", com.umeng.analytics.pro.bo.aN, "getNextSearchIndex", "setNextSearchIndex", "nextSearchIndex", "v", "Lkotlin/ranges/IntRange;", "getNextItem", "()Lkotlin/ranges/IntRange;", "setNextItem", "(Lkotlin/ranges/IntRange;)V", "nextItem", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "getCounter", "setCounter", "counter", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class DelimitedRangesSequence$iterator$1 implements java.util.Iterator<kotlin.ranges.IntRange>, kotlin.jvm.internal.markers.KMappedMarker {

    /* renamed from: n, reason: from kotlin metadata */
    public int nextState = -1;

    /* renamed from: t, reason: from kotlin metadata */
    public int currentStartIndex;

    /* renamed from: u, reason: from kotlin metadata */
    public int nextSearchIndex;

    /* renamed from: v, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public kotlin.ranges.IntRange nextItem;

    /* renamed from: w, reason: from kotlin metadata */
    public int counter;
    public final /* synthetic */ kotlin.text.DelimitedRangesSequence x;

    public DelimitedRangesSequence$iterator$1(kotlin.text.DelimitedRangesSequence delimitedRangesSequence) {
        int i;
        java.lang.CharSequence charSequence;
        int coerceIn;
        this.x = delimitedRangesSequence;
        i = delimitedRangesSequence.startIndex;
        charSequence = delimitedRangesSequence.input;
        coerceIn = kotlin.ranges.RangesKt___RangesKt.coerceIn(i, 0, charSequence.length());
        this.currentStartIndex = coerceIn;
        this.nextSearchIndex = coerceIn;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
    
        if (r0 < r4) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        int i;
        java.lang.CharSequence charSequence;
        kotlin.jvm.functions.Function2 function2;
        java.lang.CharSequence charSequence2;
        kotlin.ranges.IntRange until;
        java.lang.CharSequence charSequence3;
        java.lang.CharSequence charSequence4;
        int i2;
        if (this.nextSearchIndex < 0) {
            this.nextState = 0;
            this.nextItem = null;
            return;
        }
        i = this.x.limit;
        if (i > 0) {
            int i3 = this.counter + 1;
            this.counter = i3;
            i2 = this.x.limit;
        }
        int i4 = this.nextSearchIndex;
        charSequence = this.x.input;
        if (i4 <= charSequence.length()) {
            function2 = this.x.getNextMatch;
            charSequence2 = this.x.input;
            kotlin.Pair pair = (kotlin.Pair) function2.mo5invoke(charSequence2, java.lang.Integer.valueOf(this.nextSearchIndex));
            if (pair == null) {
                int i5 = this.currentStartIndex;
                charSequence3 = this.x.input;
                this.nextItem = new kotlin.ranges.IntRange(i5, kotlin.text.StringsKt__StringsKt.getLastIndex(charSequence3));
                this.nextSearchIndex = -1;
            } else {
                int intValue = ((java.lang.Number) pair.component1()).intValue();
                int intValue2 = ((java.lang.Number) pair.component2()).intValue();
                until = kotlin.ranges.RangesKt___RangesKt.until(this.currentStartIndex, intValue);
                this.nextItem = until;
                int i6 = intValue + intValue2;
                this.currentStartIndex = i6;
                this.nextSearchIndex = i6 + (intValue2 == 0 ? 1 : 0);
            }
            this.nextState = 1;
        }
        int i7 = this.currentStartIndex;
        charSequence4 = this.x.input;
        this.nextItem = new kotlin.ranges.IntRange(i7, kotlin.text.StringsKt__StringsKt.getLastIndex(charSequence4));
        this.nextSearchIndex = -1;
        this.nextState = 1;
    }

    public final int getCounter() {
        return this.counter;
    }

    public final int getCurrentStartIndex() {
        return this.currentStartIndex;
    }

    @org.jetbrains.annotations.Nullable
    public final kotlin.ranges.IntRange getNextItem() {
        return this.nextItem;
    }

    public final int getNextSearchIndex() {
        return this.nextSearchIndex;
    }

    public final int getNextState() {
        return this.nextState;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nextState == -1) {
            a();
        }
        return this.nextState == 1;
    }

    @Override // java.util.Iterator
    @org.jetbrains.annotations.NotNull
    public kotlin.ranges.IntRange next() {
        if (this.nextState == -1) {
            a();
        }
        if (this.nextState == 0) {
            throw new java.util.NoSuchElementException();
        }
        kotlin.ranges.IntRange intRange = this.nextItem;
        kotlin.jvm.internal.Intrinsics.checkNotNull(intRange, "null cannot be cast to non-null type kotlin.ranges.IntRange");
        this.nextItem = null;
        this.nextState = -1;
        return intRange;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new java.lang.UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setCounter(int i) {
        this.counter = i;
    }

    public final void setCurrentStartIndex(int i) {
        this.currentStartIndex = i;
    }

    public final void setNextItem(@org.jetbrains.annotations.Nullable kotlin.ranges.IntRange intRange) {
        this.nextItem = intRange;
    }

    public final void setNextSearchIndex(int i) {
        this.nextSearchIndex = i;
    }

    public final void setNextState(int i) {
        this.nextState = i;
    }
}
