package androidx.core.util;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\b\u001a\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006H\u0086\b\u001aE\u0010\u000b\u001a\u00020\f*\u00020\u000226\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\f0\u000eH\u0086\b\u001a\u001d\u0010\u0011\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0006H\u0086\b\u001a#\u0010\u0013\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014H\u0086\b\u001a\r\u0010\u0015\u001a\u00020\u0006*\u00020\u0002H\u0086\b\u001a\r\u0010\u0016\u001a\u00020\u0006*\u00020\u0002H\u0086\b\u001a\n\u0010\u0017\u001a\u00020\u0018*\u00020\u0002\u001a\u0015\u0010\u0019\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0086\u0002\u001a\u0012\u0010\u001b\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u001a\u0010\u001c\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0006\u001a\u001d\u0010\u001d\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0006H\u0086\n\u001a\n\u0010\u001e\u001a\u00020\u001f*\u00020\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006 "}, d2 = {com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "", "Landroid/util/SparseBooleanArray;", "getSize", "(Landroid/util/SparseBooleanArray;)I", "contains", "", "key", "containsKey", "containsValue", "value", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getOrDefault", "defaultValue", "getOrElse", "Lkotlin/Function0;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", "plus", "other", "putAll", "remove", "set", "valueIterator", "Lkotlin/collections/BooleanIterator;", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class SparseBooleanArrayKt {
    public static final boolean contains(@org.jetbrains.annotations.NotNull android.util.SparseBooleanArray contains, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return contains.indexOfKey(i) >= 0;
    }

    public static final boolean containsKey(@org.jetbrains.annotations.NotNull android.util.SparseBooleanArray containsKey, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(containsKey, "$this$containsKey");
        return containsKey.indexOfKey(i) >= 0;
    }

    public static final boolean containsValue(@org.jetbrains.annotations.NotNull android.util.SparseBooleanArray containsValue, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(containsValue, "$this$containsValue");
        return containsValue.indexOfValue(z) >= 0;
    }

    public static final void forEach(@org.jetbrains.annotations.NotNull android.util.SparseBooleanArray forEach, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Boolean, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(forEach, "$this$forEach");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action");
        int size = forEach.size();
        for (int i = 0; i < size; i++) {
            action.mo5invoke(java.lang.Integer.valueOf(forEach.keyAt(i)), java.lang.Boolean.valueOf(forEach.valueAt(i)));
        }
    }

    public static final boolean getOrDefault(@org.jetbrains.annotations.NotNull android.util.SparseBooleanArray getOrDefault, int i, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(getOrDefault, "$this$getOrDefault");
        return getOrDefault.get(i, z);
    }

    public static final boolean getOrElse(@org.jetbrains.annotations.NotNull android.util.SparseBooleanArray getOrElse, int i, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<java.lang.Boolean> defaultValue) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(getOrElse, "$this$getOrElse");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(defaultValue, "defaultValue");
        int indexOfKey = getOrElse.indexOfKey(i);
        return indexOfKey >= 0 ? getOrElse.valueAt(indexOfKey) : defaultValue.invoke().booleanValue();
    }

    public static final int getSize(@org.jetbrains.annotations.NotNull android.util.SparseBooleanArray size) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(size, "$this$size");
        return size.size();
    }

    public static final boolean isEmpty(@org.jetbrains.annotations.NotNull android.util.SparseBooleanArray isEmpty) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(isEmpty, "$this$isEmpty");
        return isEmpty.size() == 0;
    }

    public static final boolean isNotEmpty(@org.jetbrains.annotations.NotNull android.util.SparseBooleanArray isNotEmpty) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(isNotEmpty, "$this$isNotEmpty");
        return isNotEmpty.size() != 0;
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.collections.IntIterator keyIterator(@org.jetbrains.annotations.NotNull android.util.SparseBooleanArray keyIterator) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(keyIterator, "$this$keyIterator");
        return new androidx.core.util.SparseBooleanArrayKt$keyIterator$1(keyIterator);
    }

    @org.jetbrains.annotations.NotNull
    public static final android.util.SparseBooleanArray plus(@org.jetbrains.annotations.NotNull android.util.SparseBooleanArray plus, @org.jetbrains.annotations.NotNull android.util.SparseBooleanArray other) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(other, "other");
        android.util.SparseBooleanArray sparseBooleanArray = new android.util.SparseBooleanArray(plus.size() + other.size());
        putAll(sparseBooleanArray, plus);
        putAll(sparseBooleanArray, other);
        return sparseBooleanArray;
    }

    public static final void putAll(@org.jetbrains.annotations.NotNull android.util.SparseBooleanArray putAll, @org.jetbrains.annotations.NotNull android.util.SparseBooleanArray other) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(putAll, "$this$putAll");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(other, "other");
        int size = other.size();
        for (int i = 0; i < size; i++) {
            putAll.put(other.keyAt(i), other.valueAt(i));
        }
    }

    public static final boolean remove(@org.jetbrains.annotations.NotNull android.util.SparseBooleanArray remove, int i, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(remove, "$this$remove");
        int indexOfKey = remove.indexOfKey(i);
        if (indexOfKey < 0 || z != remove.valueAt(indexOfKey)) {
            return false;
        }
        remove.delete(i);
        return true;
    }

    public static final void set(@org.jetbrains.annotations.NotNull android.util.SparseBooleanArray set, int i, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(set, "$this$set");
        set.put(i, z);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.collections.BooleanIterator valueIterator(@org.jetbrains.annotations.NotNull android.util.SparseBooleanArray valueIterator) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(valueIterator, "$this$valueIterator");
        return new androidx.core.util.SparseBooleanArrayKt$valueIterator$1(valueIterator);
    }
}
