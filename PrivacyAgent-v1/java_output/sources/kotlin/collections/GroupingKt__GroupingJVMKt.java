package kotlin.collections;

@kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\u001a0\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00040\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0007¨\u0006\u0006"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "K", "Lkotlin/collections/Grouping;", "", "", "eachCount", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/collections/GroupingKt")
/* loaded from: classes14.dex */
class GroupingKt__GroupingJVMKt {
    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.NotNull
    public static final <T, K> java.util.Map<K, java.lang.Integer> eachCount(@org.jetbrains.annotations.NotNull kotlin.collections.Grouping<T, ? extends K> grouping) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(grouping, "<this>");
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        java.util.Iterator<T> sourceIterator = grouping.sourceIterator();
        while (sourceIterator.hasNext()) {
            K keyOf = grouping.keyOf(sourceIterator.next());
            java.lang.Object obj = linkedHashMap.get(keyOf);
            if (obj == null && !linkedHashMap.containsKey(keyOf)) {
                obj = new kotlin.jvm.internal.Ref.IntRef();
            }
            kotlin.jvm.internal.Ref.IntRef intRef = (kotlin.jvm.internal.Ref.IntRef) obj;
            intRef.element++;
            linkedHashMap.put(keyOf, intRef);
        }
        for (java.util.Map.Entry entry : linkedHashMap.entrySet()) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(entry, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda-4, R of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda-4>");
            kotlin.jvm.internal.TypeIntrinsics.asMutableMapEntry(entry).setValue(java.lang.Integer.valueOf(((kotlin.jvm.internal.Ref.IntRef) entry.getValue()).element));
        }
        return kotlin.jvm.internal.TypeIntrinsics.asMutableMap(linkedHashMap);
    }
}
