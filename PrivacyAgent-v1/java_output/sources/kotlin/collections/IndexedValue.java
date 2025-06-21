package kotlin.collections;

@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0004\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0005\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J*\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00028\u0000HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÖ\u0003R\u0017\u0010\u0007\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\b\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0006¨\u0006\u001a"}, d2 = {"Lkotlin/collections/IndexedValue;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", "", "component1", "component2", "()Ljava/lang/Object;", "index", "value", com.sensorsdata.sf.ui.view.UIProperty.action_type_copy, "(ILjava/lang/Object;)Lkotlin/collections/IndexedValue;", "", "toString", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "other", "", "equals", "a", "I", "getIndex", "()I", "b", "Ljava/lang/Object;", "getValue", "<init>", "(ILjava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final /* data */ class IndexedValue<T> {

    /* renamed from: a, reason: from kotlin metadata and from toString */
    public final int index;

    /* renamed from: b, reason: from kotlin metadata and from toString */
    public final T value;

    public IndexedValue(int i, T t) {
        this.index = i;
        this.value = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ kotlin.collections.IndexedValue copy$default(kotlin.collections.IndexedValue indexedValue, int i, java.lang.Object obj, int i2, java.lang.Object obj2) {
        if ((i2 & 1) != 0) {
            i = indexedValue.index;
        }
        if ((i2 & 2) != 0) {
            obj = indexedValue.value;
        }
        return indexedValue.copy(i, obj);
    }

    /* renamed from: component1, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    public final T component2() {
        return this.value;
    }

    @org.jetbrains.annotations.NotNull
    public final kotlin.collections.IndexedValue<T> copy(int index, T value) {
        return new kotlin.collections.IndexedValue<>(index, value);
    }

    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof kotlin.collections.IndexedValue)) {
            return false;
        }
        kotlin.collections.IndexedValue indexedValue = (kotlin.collections.IndexedValue) other;
        return this.index == indexedValue.index && kotlin.jvm.internal.Intrinsics.areEqual(this.value, indexedValue.value);
    }

    public final int getIndex() {
        return this.index;
    }

    public final T getValue() {
        return this.value;
    }

    public int hashCode() {
        int i = this.index * 31;
        T t = this.value;
        return i + (t == null ? 0 : t.hashCode());
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return "IndexedValue(index=" + this.index + ", value=" + this.value + ')';
    }
}
