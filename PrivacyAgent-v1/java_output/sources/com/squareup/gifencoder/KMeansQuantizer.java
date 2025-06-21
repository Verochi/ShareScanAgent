package com.squareup.gifencoder;

/* loaded from: classes19.dex */
public final class KMeansQuantizer implements com.squareup.gifencoder.ColorQuantizer {
    public static final com.squareup.gifencoder.KMeansQuantizer INSTANCE = new com.squareup.gifencoder.KMeansQuantizer();

    public static java.util.Set<com.squareup.gifencoder.Color> a(com.squareup.gifencoder.Multiset<com.squareup.gifencoder.Color> multiset, int i) {
        java.util.ArrayList arrayList = new java.util.ArrayList(multiset.getDistinctElements());
        java.util.Collections.shuffle(arrayList);
        return new java.util.HashSet(arrayList.subList(0, i));
    }

    public static void b(java.util.Map<com.squareup.gifencoder.Color, com.squareup.gifencoder.Multiset<com.squareup.gifencoder.Color>> map, java.util.Set<com.squareup.gifencoder.Color> set) {
        for (com.squareup.gifencoder.Color color : set) {
            com.squareup.gifencoder.Multiset<com.squareup.gifencoder.Color> multiset = map.get(color);
            com.squareup.gifencoder.Color centroid = com.squareup.gifencoder.Color.getCentroid(multiset);
            map.remove(color);
            map.put(centroid, multiset);
        }
    }

    @Override // com.squareup.gifencoder.ColorQuantizer
    public java.util.Set<com.squareup.gifencoder.Color> quantize(com.squareup.gifencoder.Multiset<com.squareup.gifencoder.Color> multiset, int i) {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        java.util.Set<com.squareup.gifencoder.Color> a = a(multiset, i);
        java.util.Iterator<com.squareup.gifencoder.Color> it = a.iterator();
        while (it.hasNext()) {
            linkedHashMap.put(it.next(), new com.squareup.gifencoder.HashMultiset());
        }
        for (com.squareup.gifencoder.Color color : multiset.getDistinctElements()) {
            ((com.squareup.gifencoder.Multiset) linkedHashMap.get(color.getNearestColor(a))).add(color, multiset.count(color));
        }
        while (!a.isEmpty()) {
            b(linkedHashMap, a);
            a.clear();
            java.util.Set keySet = linkedHashMap.keySet();
            for (com.squareup.gifencoder.Color color2 : linkedHashMap.keySet()) {
                com.squareup.gifencoder.Multiset multiset2 = (com.squareup.gifencoder.Multiset) linkedHashMap.get(color2);
                java.util.Iterator it2 = new java.util.ArrayList(multiset2.getDistinctElements()).iterator();
                while (it2.hasNext()) {
                    com.squareup.gifencoder.Color color3 = (com.squareup.gifencoder.Color) it2.next();
                    com.squareup.gifencoder.Color nearestColor = color3.getNearestColor(keySet);
                    if (nearestColor != color2) {
                        int count = multiset2.count(color3);
                        com.squareup.gifencoder.Multiset multiset3 = (com.squareup.gifencoder.Multiset) linkedHashMap.get(nearestColor);
                        multiset2.remove(color3, count);
                        multiset3.add(color3, count);
                        a.add(color2);
                        a.add(nearestColor);
                    }
                }
            }
        }
        return linkedHashMap.keySet();
    }
}
