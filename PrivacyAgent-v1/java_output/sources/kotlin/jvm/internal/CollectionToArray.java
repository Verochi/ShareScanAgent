package kotlin.jvm.internal;

@kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\b\u001a#\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a5\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u00002\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\b\"\u001c\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\t¨\u0006\u000b"}, d2 = {"", "collection", "", "", "toArray", "(Ljava/util/Collection;)[Ljava/lang/Object;", "collectionToArray", "a", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "[Ljava/lang/Object;", "EMPTY", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1})
@kotlin.jvm.JvmName(name = "CollectionToArray")
/* loaded from: classes14.dex */
public final class CollectionToArray {

    @org.jetbrains.annotations.NotNull
    public static final java.lang.Object[] a = new java.lang.Object[0];

    @kotlin.jvm.JvmName(name = "toArray")
    @org.jetbrains.annotations.NotNull
    public static final java.lang.Object[] toArray(@org.jetbrains.annotations.NotNull java.util.Collection<?> collection) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(collection, "collection");
        int size = collection.size();
        if (size != 0) {
            java.util.Iterator<?> it = collection.iterator();
            if (it.hasNext()) {
                java.lang.Object[] objArr = new java.lang.Object[size];
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    objArr[i] = it.next();
                    if (i2 >= objArr.length) {
                        if (!it.hasNext()) {
                            return objArr;
                        }
                        int i3 = ((i2 * 3) + 1) >>> 1;
                        if (i3 <= i2) {
                            i3 = 2147483645;
                            if (i2 >= 2147483645) {
                                throw new java.lang.OutOfMemoryError();
                            }
                        }
                        objArr = java.util.Arrays.copyOf(objArr, i3);
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(objArr, "copyOf(result, newSize)");
                    } else if (!it.hasNext()) {
                        java.lang.Object[] copyOf = java.util.Arrays.copyOf(objArr, i2);
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(result, size)");
                        return copyOf;
                    }
                    i = i2;
                }
            }
        }
        return a;
    }

    @kotlin.jvm.JvmName(name = "toArray")
    @org.jetbrains.annotations.NotNull
    public static final java.lang.Object[] toArray(@org.jetbrains.annotations.NotNull java.util.Collection<?> collection, @org.jetbrains.annotations.Nullable java.lang.Object[] objArr) {
        java.lang.Object[] objArr2;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(collection, "collection");
        objArr.getClass();
        int size = collection.size();
        int i = 0;
        if (size == 0) {
            if (objArr.length <= 0) {
                return objArr;
            }
            objArr[0] = null;
            return objArr;
        }
        java.util.Iterator<?> it = collection.iterator();
        if (!it.hasNext()) {
            if (objArr.length <= 0) {
                return objArr;
            }
            objArr[0] = null;
            return objArr;
        }
        if (size <= objArr.length) {
            objArr2 = objArr;
        } else {
            java.lang.Object newInstance = java.lang.reflect.Array.newInstance(objArr.getClass().getComponentType(), size);
            kotlin.jvm.internal.Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr2 = (java.lang.Object[]) newInstance;
        }
        while (true) {
            int i2 = i + 1;
            objArr2[i] = it.next();
            if (i2 >= objArr2.length) {
                if (!it.hasNext()) {
                    return objArr2;
                }
                int i3 = ((i2 * 3) + 1) >>> 1;
                if (i3 <= i2) {
                    i3 = 2147483645;
                    if (i2 >= 2147483645) {
                        throw new java.lang.OutOfMemoryError();
                    }
                }
                objArr2 = java.util.Arrays.copyOf(objArr2, i3);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(objArr2, "copyOf(result, newSize)");
            } else if (!it.hasNext()) {
                if (objArr2 == objArr) {
                    objArr[i2] = null;
                    return objArr;
                }
                java.lang.Object[] copyOf = java.util.Arrays.copyOf(objArr2, i2);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(result, size)");
                return copyOf;
            }
            i = i2;
        }
    }
}
