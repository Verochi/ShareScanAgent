package kotlin.collections.builders;

@kotlin.Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a#\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a1\u0010\n\u001a\u00020\t\"\u0004\b\u0000\u0010\u0006*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00032\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a/\u0010\f\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\f\u0010\r\u001a;\u0010\u0011\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a-\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0013\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a'\u0010\u0018\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0016\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a/\u0010\u001c\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "", com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "", "arrayOfUninitializedElements", "(I)[Ljava/lang/Object;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "offset", "length", "", "c", "([Ljava/lang/Object;II)Ljava/lang/String;", "b", "([Ljava/lang/Object;II)I", "", "other", "", "a", "([Ljava/lang/Object;IILjava/util/List;)Z", "newSize", "copyOfUninitializedElements", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "index", "", "resetAt", "([Ljava/lang/Object;I)V", "fromIndex", "toIndex", "resetRange", "([Ljava/lang/Object;II)V", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ListBuilderKt {
    public static final <T> boolean a(T[] tArr, int i, int i2, java.util.List<?> list) {
        if (i2 != list.size()) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (!kotlin.jvm.internal.Intrinsics.areEqual(tArr[i + i3], list.get(i3))) {
                return false;
            }
        }
        return true;
    }

    @org.jetbrains.annotations.NotNull
    public static final <E> E[] arrayOfUninitializedElements(int i) {
        if (i >= 0) {
            return (E[]) new java.lang.Object[i];
        }
        throw new java.lang.IllegalArgumentException("capacity must be non-negative.".toString());
    }

    public static final <T> int b(T[] tArr, int i, int i2) {
        int i3 = 1;
        for (int i4 = 0; i4 < i2; i4++) {
            T t = tArr[i + i4];
            i3 = (i3 * 31) + (t != null ? t.hashCode() : 0);
        }
        return i3;
    }

    public static final <T> java.lang.String c(T[] tArr, int i, int i2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder((i2 * 3) + 2);
        sb.append("[");
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            sb.append(tArr[i + i3]);
        }
        sb.append("]");
        java.lang.String sb2 = sb.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> T[] copyOfUninitializedElements(@org.jetbrains.annotations.NotNull T[] tArr, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(tArr, "<this>");
        T[] tArr2 = (T[]) java.util.Arrays.copyOf(tArr, i);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(tArr2, "copyOf(this, newSize)");
        kotlin.jvm.internal.Intrinsics.checkNotNull(tArr2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.builders.ListBuilderKt.copyOfUninitializedElements>");
        return tArr2;
    }

    public static final <E> void resetAt(@org.jetbrains.annotations.NotNull E[] eArr, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(eArr, "<this>");
        eArr[i] = null;
    }

    public static final <E> void resetRange(@org.jetbrains.annotations.NotNull E[] eArr, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(eArr, "<this>");
        while (i < i2) {
            resetAt(eArr, i);
            i++;
        }
    }
}
