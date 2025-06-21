package com.getui.gtc.base.http;

/* loaded from: classes22.dex */
public final class Headers {
    private final java.lang.String[] namesAndValues;

    public static final class Builder {
        final java.util.List<java.lang.String> namesAndValues = new java.util.ArrayList(20);

        public final com.getui.gtc.base.http.Headers.Builder add(java.lang.String str) {
            int indexOf = str.indexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            if (indexOf != -1) {
                return add(str.substring(0, indexOf).trim(), str.substring(indexOf + 1));
            }
            throw new java.lang.IllegalArgumentException("Unexpected header: ".concat(str));
        }

        public final com.getui.gtc.base.http.Headers.Builder add(java.lang.String str, java.lang.String str2) {
            com.getui.gtc.base.http.Headers.checkName(str);
            com.getui.gtc.base.http.Headers.checkValue(str2, str);
            return addLenient(str, str2);
        }

        public final com.getui.gtc.base.http.Headers.Builder addAll(com.getui.gtc.base.http.Headers headers) {
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                addLenient(headers.name(i), headers.value(i));
            }
            return this;
        }

        public final com.getui.gtc.base.http.Headers.Builder addLenient(java.lang.String str) {
            int indexOf = str.indexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, 1);
            return indexOf != -1 ? addLenient(str.substring(0, indexOf), str.substring(indexOf + 1)) : str.startsWith(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR) ? addLenient("", str.substring(1)) : addLenient("", str);
        }

        public final com.getui.gtc.base.http.Headers.Builder addLenient(java.lang.String str, java.lang.String str2) {
            this.namesAndValues.add(str);
            this.namesAndValues.add(str2.trim());
            return this;
        }

        public final com.getui.gtc.base.http.Headers.Builder addUnsafeNonAscii(java.lang.String str, java.lang.String str2) {
            com.getui.gtc.base.http.Headers.checkName(str);
            return addLenient(str, str2);
        }

        public final com.getui.gtc.base.http.Headers build() {
            return new com.getui.gtc.base.http.Headers(this);
        }

        public final java.lang.String get(java.lang.String str) {
            for (int size = this.namesAndValues.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase(this.namesAndValues.get(size))) {
                    return this.namesAndValues.get(size + 1);
                }
            }
            return null;
        }

        public final com.getui.gtc.base.http.Headers.Builder removeAll(java.lang.String str) {
            int i = 0;
            while (i < this.namesAndValues.size()) {
                if (str.equalsIgnoreCase(this.namesAndValues.get(i))) {
                    this.namesAndValues.remove(i);
                    this.namesAndValues.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public final com.getui.gtc.base.http.Headers.Builder set(java.lang.String str, java.lang.String str2) {
            com.getui.gtc.base.http.Headers.checkName(str);
            com.getui.gtc.base.http.Headers.checkValue(str2, str);
            removeAll(str);
            addLenient(str, str2);
            return this;
        }
    }

    public static class Util {
        private Util() {
        }

        public static java.lang.String format(java.lang.String str, java.lang.Object... objArr) {
            return java.lang.String.format(java.util.Locale.US, str, objArr);
        }
    }

    public Headers(com.getui.gtc.base.http.Headers.Builder builder) {
        java.util.List<java.lang.String> list = builder.namesAndValues;
        this.namesAndValues = (java.lang.String[]) list.toArray(new java.lang.String[list.size()]);
    }

    private Headers(java.lang.String[] strArr) {
        this.namesAndValues = strArr;
    }

    public static void checkName(java.lang.String str) {
        if (str == null) {
            throw new java.lang.NullPointerException("name == null");
        }
        if (str.isEmpty()) {
            throw new java.lang.IllegalArgumentException("name is empty");
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= ' ' || charAt >= 127) {
                throw new java.lang.IllegalArgumentException(com.getui.gtc.base.http.Headers.Util.format("Unexpected char %#04x at %d in header name: %s", java.lang.Integer.valueOf(charAt), java.lang.Integer.valueOf(i), str));
            }
        }
    }

    public static void checkValue(java.lang.String str, java.lang.String str2) {
        if (str == null) {
            throw new java.lang.NullPointerException("value for name " + str2 + " == null");
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                throw new java.lang.IllegalArgumentException(com.getui.gtc.base.http.Headers.Util.format("Unexpected char %#04x at %d in %s value: %s", java.lang.Integer.valueOf(charAt), java.lang.Integer.valueOf(i), str2, str));
            }
        }
    }

    private static java.lang.String get(java.lang.String[] strArr, java.lang.String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static com.getui.gtc.base.http.Headers of(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null) {
            throw new java.lang.NullPointerException("headers == null");
        }
        java.lang.String[] strArr = new java.lang.String[map.size() * 2];
        int i = 0;
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            if (entry.getKey() == null || entry.getValue() == null) {
                throw new java.lang.IllegalArgumentException("Headers cannot be null");
            }
            java.lang.String trim = entry.getKey().trim();
            java.lang.String trim2 = entry.getValue().trim();
            checkName(trim);
            checkValue(trim2, trim);
            strArr[i] = trim;
            strArr[i + 1] = trim2;
            i += 2;
        }
        return new com.getui.gtc.base.http.Headers(strArr);
    }

    public static com.getui.gtc.base.http.Headers of(java.lang.String... strArr) {
        if (strArr == null) {
            throw new java.lang.NullPointerException("namesAndValues == null");
        }
        if (strArr.length % 2 != 0) {
            throw new java.lang.IllegalArgumentException("Expected alternating header names and values");
        }
        java.lang.String[] strArr2 = (java.lang.String[]) strArr.clone();
        for (int i = 0; i < strArr2.length; i++) {
            java.lang.String str = strArr2[i];
            if (str == null) {
                throw new java.lang.IllegalArgumentException("Headers cannot be null");
            }
            strArr2[i] = str.trim();
        }
        for (int i2 = 0; i2 < strArr2.length; i2 += 2) {
            java.lang.String str2 = strArr2[i2];
            java.lang.String str3 = strArr2[i2 + 1];
            checkName(str2);
            checkValue(str3, str2);
        }
        return new com.getui.gtc.base.http.Headers(strArr2);
    }

    public final long byteCount() {
        java.lang.String[] strArr = this.namesAndValues;
        long length = strArr.length * 2;
        for (int i = 0; i < strArr.length; i++) {
            length += this.namesAndValues[i].length();
        }
        return length;
    }

    public final boolean equals(java.lang.Object obj) {
        return (obj instanceof com.getui.gtc.base.http.Headers) && java.util.Arrays.equals(((com.getui.gtc.base.http.Headers) obj).namesAndValues, this.namesAndValues);
    }

    public final java.lang.String get(java.lang.String str) {
        return get(this.namesAndValues, str);
    }

    public final int hashCode() {
        return java.util.Arrays.hashCode(this.namesAndValues);
    }

    public final java.lang.String name(int i) {
        return this.namesAndValues[i * 2];
    }

    public final java.util.Set<java.lang.String> names() {
        java.util.TreeSet treeSet = new java.util.TreeSet(java.lang.String.CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i = 0; i < size; i++) {
            treeSet.add(name(i));
        }
        return java.util.Collections.unmodifiableSet(treeSet);
    }

    public final com.getui.gtc.base.http.Headers.Builder newBuilder() {
        com.getui.gtc.base.http.Headers.Builder builder = new com.getui.gtc.base.http.Headers.Builder();
        java.util.Collections.addAll(builder.namesAndValues, this.namesAndValues);
        return builder;
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    public final java.util.Map<java.lang.String, java.util.List<java.lang.String>> toMultimap() {
        java.util.TreeMap treeMap = new java.util.TreeMap(java.lang.String.CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i = 0; i < size; i++) {
            java.lang.String lowerCase = name(i).toLowerCase(java.util.Locale.US);
            java.util.List list = (java.util.List) treeMap.get(lowerCase);
            if (list == null) {
                list = new java.util.ArrayList(2);
                treeMap.put(lowerCase, list);
            }
            list.add(value(i));
        }
        return treeMap;
    }

    public final java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int size = size();
        for (int i = 0; i < size; i++) {
            sb.append(name(i));
            sb.append(": ");
            sb.append(value(i));
            sb.append("\n");
        }
        return sb.toString();
    }

    public final java.lang.String value(int i) {
        return this.namesAndValues[(i * 2) + 1];
    }

    public final java.util.List<java.lang.String> values(java.lang.String str) {
        int size = size();
        java.util.ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(name(i))) {
                if (arrayList == null) {
                    arrayList = new java.util.ArrayList(2);
                }
                arrayList.add(value(i));
            }
        }
        return arrayList != null ? java.util.Collections.unmodifiableList(arrayList) : java.util.Collections.emptyList();
    }
}
