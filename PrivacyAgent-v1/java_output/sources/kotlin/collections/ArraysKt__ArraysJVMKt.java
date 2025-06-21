package kotlin.collections;

@kotlin.Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a.\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u0001H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a(\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a1\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0001\u001a#\u0010\u0011\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u0001H\u0001¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", "orEmpty", "([Ljava/lang/Object;)[Ljava/lang/Object;", "", "toTypedArray", "(Ljava/util/Collection;)[Ljava/lang/Object;", "reference", "", com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "arrayOfNulls", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "toIndex", "", "copyOfRangeToIndexCheck", "contentDeepHashCode", "([Ljava/lang/Object;)I", "contentDeepHashCodeImpl", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/collections/ArraysKt")
/* loaded from: classes14.dex */
class ArraysKt__ArraysJVMKt {
    @org.jetbrains.annotations.NotNull
    public static final <T> T[] arrayOfNulls(@org.jetbrains.annotations.NotNull T[] reference, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(reference, "reference");
        java.lang.Object newInstance = java.lang.reflect.Array.newInstance(reference.getClass().getComponentType(), i);
        kotlin.jvm.internal.Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (T[]) ((java.lang.Object[]) newInstance);
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.PublishedApi
    @kotlin.jvm.JvmName(name = "contentDeepHashCode")
    public static final <T> int contentDeepHashCode(@org.jetbrains.annotations.Nullable T[] tArr) {
        return java.util.Arrays.deepHashCode(tArr);
    }

    @kotlin.SinceKotlin(version = "1.3")
    public static final void copyOfRangeToIndexCheck(int i, int i2) {
        if (i <= i2) {
            return;
        }
        throw new java.lang.IndexOutOfBoundsException("toIndex (" + i + ") is greater than size (" + i2 + ").");
    }

    public static final /* synthetic */ <T> T[] orEmpty(T[] tArr) {
        if (tArr != null) {
            return tArr;
        }
        kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(0, "T?");
        return (T[]) new java.lang.Object[0];
    }

    public static final /* synthetic */ <T> T[] toTypedArray(java.util.Collection<? extends T> collection) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(collection, "<this>");
        kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(0, "T?");
        T[] tArr = (T[]) collection.toArray(new java.lang.Object[0]);
        kotlin.jvm.internal.Intrinsics.checkNotNull(tArr, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return tArr;
    }
}
