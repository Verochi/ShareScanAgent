package okhttp3.internal;

/* loaded from: classes23.dex */
public final class JavaNetHeaders {
    public static final java.util.Comparator<java.lang.String> a = new okhttp3.internal.JavaNetHeaders.AnonymousClass1();

    /* renamed from: okhttp3.internal.JavaNetHeaders$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.Comparator<java.lang.String> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(java.lang.String str, java.lang.String str2) {
            if (str == str2) {
                return 0;
            }
            if (str == null) {
                return -1;
            }
            if (str2 == null) {
                return 1;
            }
            return java.lang.String.CASE_INSENSITIVE_ORDER.compare(str, str2);
        }
    }

    public static java.util.Map<java.lang.String, java.util.List<java.lang.String>> toMultimap(okhttp3.Headers headers, java.lang.String str) {
        java.util.TreeMap treeMap = new java.util.TreeMap(a);
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            java.lang.String name = headers.name(i);
            java.lang.String value = headers.value(i);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.List list = (java.util.List) treeMap.get(name);
            if (list != null) {
                arrayList.addAll(list);
            }
            arrayList.add(value);
            treeMap.put(name, java.util.Collections.unmodifiableList(arrayList));
        }
        if (str != null) {
            treeMap.put(null, java.util.Collections.unmodifiableList(java.util.Collections.singletonList(str)));
        }
        return java.util.Collections.unmodifiableMap(treeMap);
    }
}
