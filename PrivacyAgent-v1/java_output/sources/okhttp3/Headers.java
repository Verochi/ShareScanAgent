package okhttp3;

/* loaded from: classes23.dex */
public final class Headers {
    public final java.lang.String[] a;

    public static final class Builder {
        public final java.util.List<java.lang.String> a = new java.util.ArrayList(20);

        public okhttp3.Headers.Builder a(java.lang.String str) {
            int indexOf = str.indexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, 1);
            return indexOf != -1 ? b(str.substring(0, indexOf), str.substring(indexOf + 1)) : str.startsWith(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR) ? b("", str.substring(1)) : b("", str);
        }

        public okhttp3.Headers.Builder add(java.lang.String str) {
            int indexOf = str.indexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            if (indexOf != -1) {
                return add(str.substring(0, indexOf).trim(), str.substring(indexOf + 1));
            }
            throw new java.lang.IllegalArgumentException("Unexpected header: " + str);
        }

        public okhttp3.Headers.Builder add(java.lang.String str, java.lang.String str2) {
            okhttp3.Headers.a(str);
            okhttp3.Headers.b(str2, str);
            return b(str, str2);
        }

        @org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
        public okhttp3.Headers.Builder add(java.lang.String str, java.time.Instant instant) {
            long epochMilli;
            if (instant != null) {
                epochMilli = instant.toEpochMilli();
                return add(str, new java.util.Date(epochMilli));
            }
            throw new java.lang.NullPointerException("value for name " + str + " == null");
        }

        public okhttp3.Headers.Builder add(java.lang.String str, java.util.Date date) {
            if (date != null) {
                add(str, okhttp3.internal.http.HttpDate.format(date));
                return this;
            }
            throw new java.lang.NullPointerException("value for name " + str + " == null");
        }

        public okhttp3.Headers.Builder addAll(okhttp3.Headers headers) {
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                b(headers.name(i), headers.value(i));
            }
            return this;
        }

        public okhttp3.Headers.Builder addUnsafeNonAscii(java.lang.String str, java.lang.String str2) {
            okhttp3.Headers.a(str);
            return b(str, str2);
        }

        public okhttp3.Headers.Builder b(java.lang.String str, java.lang.String str2) {
            this.a.add(str);
            this.a.add(str2.trim());
            return this;
        }

        public okhttp3.Headers build() {
            return new okhttp3.Headers(this);
        }

        @javax.annotation.Nullable
        public java.lang.String get(java.lang.String str) {
            for (int size = this.a.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase(this.a.get(size))) {
                    return this.a.get(size + 1);
                }
            }
            return null;
        }

        public okhttp3.Headers.Builder removeAll(java.lang.String str) {
            int i = 0;
            while (i < this.a.size()) {
                if (str.equalsIgnoreCase(this.a.get(i))) {
                    this.a.remove(i);
                    this.a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public okhttp3.Headers.Builder set(java.lang.String str, java.lang.String str2) {
            okhttp3.Headers.a(str);
            okhttp3.Headers.b(str2, str);
            removeAll(str);
            b(str, str2);
            return this;
        }

        @org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
        public okhttp3.Headers.Builder set(java.lang.String str, java.time.Instant instant) {
            long epochMilli;
            if (instant != null) {
                epochMilli = instant.toEpochMilli();
                return set(str, new java.util.Date(epochMilli));
            }
            throw new java.lang.NullPointerException("value for name " + str + " == null");
        }

        public okhttp3.Headers.Builder set(java.lang.String str, java.util.Date date) {
            if (date != null) {
                set(str, okhttp3.internal.http.HttpDate.format(date));
                return this;
            }
            throw new java.lang.NullPointerException("value for name " + str + " == null");
        }
    }

    public Headers(okhttp3.Headers.Builder builder) {
        java.util.List<java.lang.String> list = builder.a;
        this.a = (java.lang.String[]) list.toArray(new java.lang.String[list.size()]);
    }

    public Headers(java.lang.String[] strArr) {
        this.a = strArr;
    }

    public static void a(java.lang.String str) {
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
                throw new java.lang.IllegalArgumentException(okhttp3.internal.Util.format("Unexpected char %#04x at %d in header name: %s", java.lang.Integer.valueOf(charAt), java.lang.Integer.valueOf(i), str));
            }
        }
    }

    public static void b(java.lang.String str, java.lang.String str2) {
        if (str == null) {
            throw new java.lang.NullPointerException("value for name " + str2 + " == null");
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                throw new java.lang.IllegalArgumentException(okhttp3.internal.Util.format("Unexpected char %#04x at %d in %s value: %s", java.lang.Integer.valueOf(charAt), java.lang.Integer.valueOf(i), str2, str));
            }
        }
    }

    @javax.annotation.Nullable
    public static java.lang.String c(java.lang.String[] strArr, java.lang.String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static okhttp3.Headers of(java.util.Map<java.lang.String, java.lang.String> map) {
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
            a(trim);
            b(trim2, trim);
            strArr[i] = trim;
            strArr[i + 1] = trim2;
            i += 2;
        }
        return new okhttp3.Headers(strArr);
    }

    public static okhttp3.Headers of(java.lang.String... strArr) {
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
            a(str2);
            b(str3, str2);
        }
        return new okhttp3.Headers(strArr2);
    }

    public long byteCount() {
        java.lang.String[] strArr = this.a;
        long length = strArr.length * 2;
        for (int i = 0; i < strArr.length; i++) {
            length += this.a[i].length();
        }
        return length;
    }

    public boolean equals(@javax.annotation.Nullable java.lang.Object obj) {
        return (obj instanceof okhttp3.Headers) && java.util.Arrays.equals(((okhttp3.Headers) obj).a, this.a);
    }

    @javax.annotation.Nullable
    public java.lang.String get(java.lang.String str) {
        return c(this.a, str);
    }

    @javax.annotation.Nullable
    public java.util.Date getDate(java.lang.String str) {
        java.lang.String str2 = get(str);
        if (str2 != null) {
            return okhttp3.internal.http.HttpDate.parse(str2);
        }
        return null;
    }

    @javax.annotation.Nullable
    @org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
    public java.time.Instant getInstant(java.lang.String str) {
        java.time.Instant instant;
        java.util.Date date = getDate(str);
        if (date == null) {
            return null;
        }
        instant = date.toInstant();
        return instant;
    }

    public int hashCode() {
        return java.util.Arrays.hashCode(this.a);
    }

    public java.lang.String name(int i) {
        return this.a[i * 2];
    }

    public java.util.Set<java.lang.String> names() {
        java.util.TreeSet treeSet = new java.util.TreeSet(java.lang.String.CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i = 0; i < size; i++) {
            treeSet.add(name(i));
        }
        return java.util.Collections.unmodifiableSet(treeSet);
    }

    public okhttp3.Headers.Builder newBuilder() {
        okhttp3.Headers.Builder builder = new okhttp3.Headers.Builder();
        java.util.Collections.addAll(builder.a, this.a);
        return builder;
    }

    public int size() {
        return this.a.length / 2;
    }

    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> toMultimap() {
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

    public java.lang.String toString() {
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

    public java.lang.String value(int i) {
        return this.a[(i * 2) + 1];
    }

    public java.util.List<java.lang.String> values(java.lang.String str) {
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
