package kotlin.collections;

@kotlin.Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a-\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001aI\u0010\u0007\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0005*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a5\u0010\r\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u00012\u0010\u0010\t\u001a\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u0001H\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a#\u0010\u0011\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0000*\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u0001H\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u001a?\u0010\u0018\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\n\u0010\u0014\u001a\u00060\u0012j\u0002`\u00132\u0010\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", "", "flatten", "([[Ljava/lang/Object;)Ljava/util/List;", "R", "Lkotlin/Pair;", "unzip", "([Lkotlin/Pair;)Lkotlin/Pair;", "other", "", "contentDeepEquals", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "contentDeepEqualsImpl", "", "contentDeepToString", "([Ljava/lang/Object;)Ljava/lang/String;", "contentDeepToStringImpl", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "result", "", "processed", "", "a", "([Ljava/lang/Object;Ljava/lang/StringBuilder;Ljava/util/List;)V", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/collections/ArraysKt")
/* loaded from: classes14.dex */
class ArraysKt__ArraysKt extends kotlin.collections.ArraysKt__ArraysJVMKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void a(T[] tArr, java.lang.StringBuilder sb, java.util.List<java.lang.Object[]> list) {
        java.lang.String m357contentToStringuLth9ew;
        java.lang.String m354contentToStringXUkPCBk;
        java.lang.String m355contentToStringd6D3K8;
        java.lang.String m351contentToString2csIQuQ;
        if (list.contains(tArr)) {
            sb.append("[...]");
            return;
        }
        list.add(tArr);
        sb.append('[');
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            java.lang.Object[] objArr = tArr[i];
            if (objArr == 0) {
                sb.append(com.igexin.push.core.b.m);
            } else if (objArr instanceof java.lang.Object[]) {
                a(objArr, sb, list);
            } else if (objArr instanceof byte[]) {
                java.lang.String arrays = java.util.Arrays.toString((byte[]) objArr);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
                sb.append(arrays);
            } else if (objArr instanceof short[]) {
                java.lang.String arrays2 = java.util.Arrays.toString((short[]) objArr);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(arrays2, "toString(this)");
                sb.append(arrays2);
            } else if (objArr instanceof int[]) {
                java.lang.String arrays3 = java.util.Arrays.toString((int[]) objArr);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(arrays3, "toString(this)");
                sb.append(arrays3);
            } else if (objArr instanceof long[]) {
                java.lang.String arrays4 = java.util.Arrays.toString((long[]) objArr);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(arrays4, "toString(this)");
                sb.append(arrays4);
            } else if (objArr instanceof float[]) {
                java.lang.String arrays5 = java.util.Arrays.toString((float[]) objArr);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(arrays5, "toString(this)");
                sb.append(arrays5);
            } else if (objArr instanceof double[]) {
                java.lang.String arrays6 = java.util.Arrays.toString((double[]) objArr);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(arrays6, "toString(this)");
                sb.append(arrays6);
            } else if (objArr instanceof char[]) {
                java.lang.String arrays7 = java.util.Arrays.toString((char[]) objArr);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(arrays7, "toString(this)");
                sb.append(arrays7);
            } else if (objArr instanceof boolean[]) {
                java.lang.String arrays8 = java.util.Arrays.toString((boolean[]) objArr);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(arrays8, "toString(this)");
                sb.append(arrays8);
            } else if (objArr instanceof kotlin.UByteArray) {
                m351contentToString2csIQuQ = kotlin.collections.unsigned.UArraysKt___UArraysKt.m351contentToString2csIQuQ(((kotlin.UByteArray) objArr).getStorage());
                sb.append(m351contentToString2csIQuQ);
            } else if (objArr instanceof kotlin.UShortArray) {
                m355contentToStringd6D3K8 = kotlin.collections.unsigned.UArraysKt___UArraysKt.m355contentToStringd6D3K8(((kotlin.UShortArray) objArr).getStorage());
                sb.append(m355contentToStringd6D3K8);
            } else if (objArr instanceof kotlin.UIntArray) {
                m354contentToStringXUkPCBk = kotlin.collections.unsigned.UArraysKt___UArraysKt.m354contentToStringXUkPCBk(((kotlin.UIntArray) objArr).getStorage());
                sb.append(m354contentToStringXUkPCBk);
            } else if (objArr instanceof kotlin.ULongArray) {
                m357contentToStringuLth9ew = kotlin.collections.unsigned.UArraysKt___UArraysKt.m357contentToStringuLth9ew(((kotlin.ULongArray) objArr).getStorage());
                sb.append(m357contentToStringuLth9ew);
            } else {
                sb.append(objArr.toString());
            }
        }
        sb.append(']');
        list.remove(kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(list));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.PublishedApi
    @kotlin.jvm.JvmName(name = "contentDeepEquals")
    public static final <T> boolean contentDeepEquals(@org.jetbrains.annotations.Nullable T[] tArr, @org.jetbrains.annotations.Nullable T[] tArr2) {
        boolean m339contentEqualslec5QzE;
        boolean m335contentEqualsKJPZfPQ;
        boolean m334contentEqualsFGO6Aew;
        boolean m337contentEqualskV0jMPg;
        if (tArr == tArr2) {
            return true;
        }
        if (tArr == 0 || tArr2 == 0 || tArr.length != tArr2.length) {
            return false;
        }
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            java.lang.Object[] objArr = tArr[i];
            java.lang.Object[] objArr2 = tArr2[i];
            if (objArr != objArr2) {
                if (objArr == 0 || objArr2 == 0) {
                    return false;
                }
                if ((objArr instanceof java.lang.Object[]) && (objArr2 instanceof java.lang.Object[])) {
                    if (!contentDeepEquals(objArr, objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof byte[]) && (objArr2 instanceof byte[])) {
                    if (!java.util.Arrays.equals((byte[]) objArr, (byte[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof short[]) && (objArr2 instanceof short[])) {
                    if (!java.util.Arrays.equals((short[]) objArr, (short[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof int[]) && (objArr2 instanceof int[])) {
                    if (!java.util.Arrays.equals((int[]) objArr, (int[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof long[]) && (objArr2 instanceof long[])) {
                    if (!java.util.Arrays.equals((long[]) objArr, (long[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof float[]) && (objArr2 instanceof float[])) {
                    if (!java.util.Arrays.equals((float[]) objArr, (float[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof double[]) && (objArr2 instanceof double[])) {
                    if (!java.util.Arrays.equals((double[]) objArr, (double[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof char[]) && (objArr2 instanceof char[])) {
                    if (!java.util.Arrays.equals((char[]) objArr, (char[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof boolean[]) && (objArr2 instanceof boolean[])) {
                    if (!java.util.Arrays.equals((boolean[]) objArr, (boolean[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof kotlin.UByteArray) && (objArr2 instanceof kotlin.UByteArray)) {
                    m337contentEqualskV0jMPg = kotlin.collections.unsigned.UArraysKt___UArraysKt.m337contentEqualskV0jMPg(((kotlin.UByteArray) objArr).getStorage(), ((kotlin.UByteArray) objArr2).getStorage());
                    if (!m337contentEqualskV0jMPg) {
                        return false;
                    }
                } else if ((objArr instanceof kotlin.UShortArray) && (objArr2 instanceof kotlin.UShortArray)) {
                    m334contentEqualsFGO6Aew = kotlin.collections.unsigned.UArraysKt___UArraysKt.m334contentEqualsFGO6Aew(((kotlin.UShortArray) objArr).getStorage(), ((kotlin.UShortArray) objArr2).getStorage());
                    if (!m334contentEqualsFGO6Aew) {
                        return false;
                    }
                } else if ((objArr instanceof kotlin.UIntArray) && (objArr2 instanceof kotlin.UIntArray)) {
                    m335contentEqualsKJPZfPQ = kotlin.collections.unsigned.UArraysKt___UArraysKt.m335contentEqualsKJPZfPQ(((kotlin.UIntArray) objArr).getStorage(), ((kotlin.UIntArray) objArr2).getStorage());
                    if (!m335contentEqualsKJPZfPQ) {
                        return false;
                    }
                } else if ((objArr instanceof kotlin.ULongArray) && (objArr2 instanceof kotlin.ULongArray)) {
                    m339contentEqualslec5QzE = kotlin.collections.unsigned.UArraysKt___UArraysKt.m339contentEqualslec5QzE(((kotlin.ULongArray) objArr).getStorage(), ((kotlin.ULongArray) objArr2).getStorage());
                    if (!m339contentEqualslec5QzE) {
                        return false;
                    }
                } else if (!kotlin.jvm.internal.Intrinsics.areEqual(objArr, objArr2)) {
                    return false;
                }
            }
        }
        return true;
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.jvm.JvmName(name = "contentDeepToString")
    @org.jetbrains.annotations.NotNull
    @kotlin.PublishedApi
    public static final <T> java.lang.String contentDeepToString(@org.jetbrains.annotations.Nullable T[] tArr) {
        int coerceAtMost;
        if (tArr == null) {
            return com.igexin.push.core.b.m;
        }
        coerceAtMost = kotlin.ranges.RangesKt___RangesKt.coerceAtMost(tArr.length, 429496729);
        java.lang.StringBuilder sb = new java.lang.StringBuilder((coerceAtMost * 5) + 2);
        a(tArr, sb, new java.util.ArrayList());
        java.lang.String sb2 = sb.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.List<T> flatten(@org.jetbrains.annotations.NotNull T[][] tArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(tArr, "<this>");
        int i = 0;
        for (T[] tArr2 : tArr) {
            i += tArr2.length;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(i);
        for (T[] tArr3 : tArr) {
            kotlin.collections.CollectionsKt__MutableCollectionsKt.addAll(arrayList, tArr3);
        }
        return arrayList;
    }

    @org.jetbrains.annotations.NotNull
    public static final <T, R> kotlin.Pair<java.util.List<T>, java.util.List<R>> unzip(@org.jetbrains.annotations.NotNull kotlin.Pair<? extends T, ? extends R>[] pairArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pairArr, "<this>");
        java.util.ArrayList arrayList = new java.util.ArrayList(pairArr.length);
        java.util.ArrayList arrayList2 = new java.util.ArrayList(pairArr.length);
        for (kotlin.Pair<? extends T, ? extends R> pair : pairArr) {
            arrayList.add(pair.getFirst());
            arrayList2.add(pair.getSecond());
        }
        return kotlin.TuplesKt.to(arrayList, arrayList2);
    }
}
