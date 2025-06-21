package androidx.core.util;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010(\n\u0000\u001a!\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u0001H\u0086\n\u001a!\u0010\t\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u0001H\u0086\b\u001a&\u0010\n\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u000b\u001a\u0002H\u0002H\u0086\b¢\u0006\u0002\u0010\f\u001aQ\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000326\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\b\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0086\b\u001a.\u0010\u0013\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u0002H\u0002H\u0086\b¢\u0006\u0002\u0010\u0015\u001a4\u0010\u0016\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0017H\u0086\b¢\u0006\u0002\u0010\u0018\u001a\u0019\u0010\u0019\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\b\u001a\u0019\u0010\u001a\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\b\u001a\u0016\u0010\u001b\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a-\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0002\u001a$\u0010\u001f\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a+\u0010 \u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u0002H\u0002¢\u0006\u0002\u0010!\u001a.\u0010\"\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u0002H\u0002H\u0086\n¢\u0006\u0002\u0010#\u001a\u001c\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00020%\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\"\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006&"}, d2 = {com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Landroid/util/SparseArray;", "getSize", "(Landroid/util/SparseArray;)I", "contains", "", "key", "containsKey", "containsValue", "value", "(Landroid/util/SparseArray;Ljava/lang/Object;)Z", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getOrDefault", "defaultValue", "(Landroid/util/SparseArray;ILjava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(Landroid/util/SparseArray;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", "plus", "other", "putAll", "remove", "(Landroid/util/SparseArray;ILjava/lang/Object;)Z", "set", "(Landroid/util/SparseArray;ILjava/lang/Object;)V", "valueIterator", "", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class SparseArrayKt {
    public static final <T> boolean contains(@org.jetbrains.annotations.NotNull android.util.SparseArray<T> contains, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return contains.indexOfKey(i) >= 0;
    }

    public static final <T> boolean containsKey(@org.jetbrains.annotations.NotNull android.util.SparseArray<T> containsKey, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(containsKey, "$this$containsKey");
        return containsKey.indexOfKey(i) >= 0;
    }

    public static final <T> boolean containsValue(@org.jetbrains.annotations.NotNull android.util.SparseArray<T> containsValue, T t) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(containsValue, "$this$containsValue");
        return containsValue.indexOfValue(t) >= 0;
    }

    public static final <T> void forEach(@org.jetbrains.annotations.NotNull android.util.SparseArray<T> forEach, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super T, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(forEach, "$this$forEach");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action");
        int size = forEach.size();
        for (int i = 0; i < size; i++) {
            action.mo5invoke(java.lang.Integer.valueOf(forEach.keyAt(i)), forEach.valueAt(i));
        }
    }

    public static final <T> T getOrDefault(@org.jetbrains.annotations.NotNull android.util.SparseArray<T> getOrDefault, int i, T t) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(getOrDefault, "$this$getOrDefault");
        T t2 = getOrDefault.get(i);
        return t2 != null ? t2 : t;
    }

    public static final <T> T getOrElse(@org.jetbrains.annotations.NotNull android.util.SparseArray<T> getOrElse, int i, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends T> defaultValue) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(getOrElse, "$this$getOrElse");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(defaultValue, "defaultValue");
        T t = getOrElse.get(i);
        return t != null ? t : defaultValue.invoke();
    }

    public static final <T> int getSize(@org.jetbrains.annotations.NotNull android.util.SparseArray<T> size) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(size, "$this$size");
        return size.size();
    }

    public static final <T> boolean isEmpty(@org.jetbrains.annotations.NotNull android.util.SparseArray<T> isEmpty) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(isEmpty, "$this$isEmpty");
        return isEmpty.size() == 0;
    }

    public static final <T> boolean isNotEmpty(@org.jetbrains.annotations.NotNull android.util.SparseArray<T> isNotEmpty) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(isNotEmpty, "$this$isNotEmpty");
        return isNotEmpty.size() != 0;
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlin.collections.IntIterator keyIterator(@org.jetbrains.annotations.NotNull android.util.SparseArray<T> keyIterator) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(keyIterator, "$this$keyIterator");
        return new androidx.core.util.SparseArrayKt$keyIterator$1(keyIterator);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> android.util.SparseArray<T> plus(@org.jetbrains.annotations.NotNull android.util.SparseArray<T> plus, @org.jetbrains.annotations.NotNull android.util.SparseArray<T> other) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(other, "other");
        android.util.SparseArray<T> sparseArray = new android.util.SparseArray<>(plus.size() + other.size());
        putAll(sparseArray, plus);
        putAll(sparseArray, other);
        return sparseArray;
    }

    public static final <T> void putAll(@org.jetbrains.annotations.NotNull android.util.SparseArray<T> putAll, @org.jetbrains.annotations.NotNull android.util.SparseArray<T> other) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(putAll, "$this$putAll");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(other, "other");
        int size = other.size();
        for (int i = 0; i < size; i++) {
            putAll.put(other.keyAt(i), other.valueAt(i));
        }
    }

    public static final <T> boolean remove(@org.jetbrains.annotations.NotNull android.util.SparseArray<T> remove, int i, T t) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(remove, "$this$remove");
        int indexOfKey = remove.indexOfKey(i);
        if (indexOfKey < 0 || !kotlin.jvm.internal.Intrinsics.areEqual(t, remove.valueAt(indexOfKey))) {
            return false;
        }
        remove.removeAt(indexOfKey);
        return true;
    }

    public static final <T> void set(@org.jetbrains.annotations.NotNull android.util.SparseArray<T> set, int i, T t) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(set, "$this$set");
        set.put(i, t);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.Iterator<T> valueIterator(@org.jetbrains.annotations.NotNull android.util.SparseArray<T> valueIterator) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(valueIterator, "$this$valueIterator");
        return new androidx.core.util.SparseArrayKt$valueIterator$1(valueIterator);
    }
}
