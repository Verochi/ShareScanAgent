package kotlin.text;

@kotlin.Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "", "Lkotlin/text/CharDirectionality;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class CharDirectionality$Companion$directionalityMap$2 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function0<java.util.Map<java.lang.Integer, ? extends kotlin.text.CharDirectionality>> {
    public static final kotlin.text.CharDirectionality$Companion$directionalityMap$2 INSTANCE = new kotlin.text.CharDirectionality$Companion$directionalityMap$2();

    public CharDirectionality$Companion$directionalityMap$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<java.lang.Integer, ? extends kotlin.text.CharDirectionality> invoke() {
        int mapCapacity;
        int coerceAtLeast;
        kotlin.text.CharDirectionality[] values = kotlin.text.CharDirectionality.values();
        mapCapacity = kotlin.collections.MapsKt__MapsJVMKt.mapCapacity(values.length);
        coerceAtLeast = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(coerceAtLeast);
        for (kotlin.text.CharDirectionality charDirectionality : values) {
            linkedHashMap.put(java.lang.Integer.valueOf(charDirectionality.getValue()), charDirectionality);
        }
        return linkedHashMap;
    }
}
