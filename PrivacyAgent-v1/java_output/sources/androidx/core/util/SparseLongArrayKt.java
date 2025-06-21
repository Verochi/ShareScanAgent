package androidx.core.util;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0087\b\u001aE\u0010\f\u001a\u00020\r*\u00020\u000226\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\r0\u000fH\u0087\b\u001a\u001d\u0010\u0012\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u000bH\u0087\b\u001a#\u0010\u0014\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015H\u0087\b\u001a\r\u0010\u0016\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\f\u0010\u0018\u001a\u00020\u0019*\u00020\u0002H\u0007\u001a\u0015\u0010\u001a\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0087\u0002\u001a\u0014\u0010\u001c\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0007\u001a\u001c\u0010\u001d\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a\u001d\u0010\u001e\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0087\n\u001a\f\u0010\u001f\u001a\u00020 *\u00020\u0002H\u0007\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006!"}, d2 = {com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "", "Landroid/util/SparseLongArray;", "getSize", "(Landroid/util/SparseLongArray;)I", "contains", "", "key", "containsKey", "containsValue", "value", "", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getOrDefault", "defaultValue", "getOrElse", "Lkotlin/Function0;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", "plus", "other", "putAll", "remove", "set", "valueIterator", "Lkotlin/collections/LongIterator;", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class SparseLongArrayKt {
    @androidx.annotation.RequiresApi(18)
    public static final boolean contains(@org.jetbrains.annotations.NotNull android.util.SparseLongArray contains, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return contains.indexOfKey(i) >= 0;
    }

    @androidx.annotation.RequiresApi(18)
    public static final boolean containsKey(@org.jetbrains.annotations.NotNull android.util.SparseLongArray containsKey, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(containsKey, "$this$containsKey");
        return containsKey.indexOfKey(i) >= 0;
    }

    @androidx.annotation.RequiresApi(18)
    public static final boolean containsValue(@org.jetbrains.annotations.NotNull android.util.SparseLongArray containsValue, long j) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(containsValue, "$this$containsValue");
        return containsValue.indexOfValue(j) >= 0;
    }

    @androidx.annotation.RequiresApi(18)
    public static final void forEach(@org.jetbrains.annotations.NotNull android.util.SparseLongArray forEach, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Long, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(forEach, "$this$forEach");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action");
        int size = forEach.size();
        for (int i = 0; i < size; i++) {
            action.mo5invoke(java.lang.Integer.valueOf(forEach.keyAt(i)), java.lang.Long.valueOf(forEach.valueAt(i)));
        }
    }

    @androidx.annotation.RequiresApi(18)
    public static final long getOrDefault(@org.jetbrains.annotations.NotNull android.util.SparseLongArray getOrDefault, int i, long j) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(getOrDefault, "$this$getOrDefault");
        return getOrDefault.get(i, j);
    }

    @androidx.annotation.RequiresApi(18)
    public static final long getOrElse(@org.jetbrains.annotations.NotNull android.util.SparseLongArray getOrElse, int i, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<java.lang.Long> defaultValue) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(getOrElse, "$this$getOrElse");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(defaultValue, "defaultValue");
        int indexOfKey = getOrElse.indexOfKey(i);
        return indexOfKey >= 0 ? getOrElse.valueAt(indexOfKey) : defaultValue.invoke().longValue();
    }

    @androidx.annotation.RequiresApi(18)
    public static final int getSize(@org.jetbrains.annotations.NotNull android.util.SparseLongArray size) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(size, "$this$size");
        return size.size();
    }

    @androidx.annotation.RequiresApi(18)
    public static final boolean isEmpty(@org.jetbrains.annotations.NotNull android.util.SparseLongArray isEmpty) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(isEmpty, "$this$isEmpty");
        return isEmpty.size() == 0;
    }

    @androidx.annotation.RequiresApi(18)
    public static final boolean isNotEmpty(@org.jetbrains.annotations.NotNull android.util.SparseLongArray isNotEmpty) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(isNotEmpty, "$this$isNotEmpty");
        return isNotEmpty.size() != 0;
    }

    @androidx.annotation.RequiresApi(18)
    @org.jetbrains.annotations.NotNull
    public static final kotlin.collections.IntIterator keyIterator(@org.jetbrains.annotations.NotNull android.util.SparseLongArray keyIterator) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(keyIterator, "$this$keyIterator");
        return new androidx.core.util.SparseLongArrayKt$keyIterator$1(keyIterator);
    }

    @androidx.annotation.RequiresApi(18)
    @org.jetbrains.annotations.NotNull
    public static final android.util.SparseLongArray plus(@org.jetbrains.annotations.NotNull android.util.SparseLongArray plus, @org.jetbrains.annotations.NotNull android.util.SparseLongArray other) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(other, "other");
        android.util.SparseLongArray sparseLongArray = new android.util.SparseLongArray(plus.size() + other.size());
        putAll(sparseLongArray, plus);
        putAll(sparseLongArray, other);
        return sparseLongArray;
    }

    @androidx.annotation.RequiresApi(18)
    public static final void putAll(@org.jetbrains.annotations.NotNull android.util.SparseLongArray putAll, @org.jetbrains.annotations.NotNull android.util.SparseLongArray other) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(putAll, "$this$putAll");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(other, "other");
        int size = other.size();
        for (int i = 0; i < size; i++) {
            putAll.put(other.keyAt(i), other.valueAt(i));
        }
    }

    @androidx.annotation.RequiresApi(18)
    public static final boolean remove(@org.jetbrains.annotations.NotNull android.util.SparseLongArray remove, int i, long j) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(remove, "$this$remove");
        int indexOfKey = remove.indexOfKey(i);
        if (indexOfKey < 0 || j != remove.valueAt(indexOfKey)) {
            return false;
        }
        remove.removeAt(indexOfKey);
        return true;
    }

    @androidx.annotation.RequiresApi(18)
    public static final void set(@org.jetbrains.annotations.NotNull android.util.SparseLongArray set, int i, long j) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(set, "$this$set");
        set.put(i, j);
    }

    @androidx.annotation.RequiresApi(18)
    @org.jetbrains.annotations.NotNull
    public static final kotlin.collections.LongIterator valueIterator(@org.jetbrains.annotations.NotNull android.util.SparseLongArray valueIterator) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(valueIterator, "$this$valueIterator");
        return new androidx.core.util.SparseLongArrayKt$valueIterator$1(valueIterator);
    }
}
