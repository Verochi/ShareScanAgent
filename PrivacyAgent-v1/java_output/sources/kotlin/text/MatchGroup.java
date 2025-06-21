package kotlin.text;

@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\t\u0010\t\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lkotlin/text/MatchGroup;", "", "", "component1", "Lkotlin/ranges/IntRange;", "component2", "value", "range", com.sensorsdata.sf.ui.view.UIProperty.action_type_copy, "toString", "", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "other", "", "equals", "a", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "b", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "<init>", "(Ljava/lang/String;Lkotlin/ranges/IntRange;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final /* data */ class MatchGroup {

    /* renamed from: a, reason: from kotlin metadata and from toString */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String value;

    /* renamed from: b, reason: from kotlin metadata and from toString */
    @org.jetbrains.annotations.NotNull
    public final kotlin.ranges.IntRange range;

    public MatchGroup(@org.jetbrains.annotations.NotNull java.lang.String value, @org.jetbrains.annotations.NotNull kotlin.ranges.IntRange range) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(range, "range");
        this.value = value;
        this.range = range;
    }

    public static /* synthetic */ kotlin.text.MatchGroup copy$default(kotlin.text.MatchGroup matchGroup, java.lang.String str, kotlin.ranges.IntRange intRange, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            str = matchGroup.value;
        }
        if ((i & 2) != 0) {
            intRange = matchGroup.range;
        }
        return matchGroup.copy(str, intRange);
    }

    @org.jetbrains.annotations.NotNull
    /* renamed from: component1, reason: from getter */
    public final java.lang.String getValue() {
        return this.value;
    }

    @org.jetbrains.annotations.NotNull
    /* renamed from: component2, reason: from getter */
    public final kotlin.ranges.IntRange getRange() {
        return this.range;
    }

    @org.jetbrains.annotations.NotNull
    public final kotlin.text.MatchGroup copy(@org.jetbrains.annotations.NotNull java.lang.String value, @org.jetbrains.annotations.NotNull kotlin.ranges.IntRange range) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(range, "range");
        return new kotlin.text.MatchGroup(value, range);
    }

    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof kotlin.text.MatchGroup)) {
            return false;
        }
        kotlin.text.MatchGroup matchGroup = (kotlin.text.MatchGroup) other;
        return kotlin.jvm.internal.Intrinsics.areEqual(this.value, matchGroup.value) && kotlin.jvm.internal.Intrinsics.areEqual(this.range, matchGroup.range);
    }

    @org.jetbrains.annotations.NotNull
    public final kotlin.ranges.IntRange getRange() {
        return this.range;
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String getValue() {
        return this.value;
    }

    public int hashCode() {
        return (this.value.hashCode() * 31) + this.range.hashCode();
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return "MatchGroup(value=" + this.value + ", range=" + this.range + ')';
    }
}
