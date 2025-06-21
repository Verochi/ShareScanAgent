package com.meizu.cloud.pushsdk.c.c;

/* loaded from: classes23.dex */
public final class c {
    private final java.lang.String[] a;

    public static final class a {
        private final java.util.List<java.lang.String> a = new java.util.ArrayList(20);

        private void c(java.lang.String str, java.lang.String str2) {
            if (str == null) {
                throw new java.lang.IllegalArgumentException("name == null");
            }
            if (str.isEmpty()) {
                throw new java.lang.IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt <= 31 || charAt >= 127) {
                    throw new java.lang.IllegalArgumentException(java.lang.String.format("Unexpected char %#04x at %d in header name: %s", java.lang.Integer.valueOf(charAt), java.lang.Integer.valueOf(i), str));
                }
            }
            if (str2 == null) {
                throw new java.lang.IllegalArgumentException("value == null");
            }
            int length2 = str2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                char charAt2 = str2.charAt(i2);
                if (charAt2 <= 31 || charAt2 >= 127) {
                    throw new java.lang.IllegalArgumentException(java.lang.String.format("Unexpected char %#04x at %d in %s value: %s", java.lang.Integer.valueOf(charAt2), java.lang.Integer.valueOf(i2), str, str2));
                }
            }
        }

        public com.meizu.cloud.pushsdk.c.c.c.a a(java.lang.String str, java.lang.String str2) {
            c(str, str2);
            return b(str, str2);
        }

        public com.meizu.cloud.pushsdk.c.c.c a() {
            return new com.meizu.cloud.pushsdk.c.c.c(this, null);
        }

        public com.meizu.cloud.pushsdk.c.c.c.a b(java.lang.String str, java.lang.String str2) {
            this.a.add(str);
            this.a.add(str2.trim());
            return this;
        }
    }

    private c(com.meizu.cloud.pushsdk.c.c.c.a aVar) {
        this.a = (java.lang.String[]) aVar.a.toArray(new java.lang.String[aVar.a.size()]);
    }

    public /* synthetic */ c(com.meizu.cloud.pushsdk.c.c.c.a aVar, com.meizu.cloud.pushsdk.c.c.c.AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    private c(java.lang.String[] strArr) {
        this.a = strArr;
    }

    public static com.meizu.cloud.pushsdk.c.c.c a(java.lang.String... strArr) {
        if (strArr == null || strArr.length % 2 != 0) {
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
            if (str2.length() == 0 || str2.indexOf(0) != -1 || str3.indexOf(0) != -1) {
                throw new java.lang.IllegalArgumentException("Unexpected header: " + str2 + ": " + str3);
            }
        }
        return new com.meizu.cloud.pushsdk.c.c.c(strArr2);
    }

    private static java.lang.String a(java.lang.String[] strArr, java.lang.String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public int a() {
        return this.a.length / 2;
    }

    public java.lang.String a(int i) {
        return this.a[i * 2];
    }

    public java.lang.String a(java.lang.String str) {
        return a(this.a, str);
    }

    public java.lang.String b(int i) {
        return this.a[(i * 2) + 1];
    }

    public java.util.Set<java.lang.String> b() {
        java.util.TreeSet treeSet = new java.util.TreeSet(java.lang.String.CASE_INSENSITIVE_ORDER);
        int a2 = a();
        for (int i = 0; i < a2; i++) {
            treeSet.add(a(i));
        }
        return java.util.Collections.unmodifiableSet(treeSet);
    }

    public com.meizu.cloud.pushsdk.c.c.c.a c() {
        com.meizu.cloud.pushsdk.c.c.c.a aVar = new com.meizu.cloud.pushsdk.c.c.c.a();
        java.util.Collections.addAll(aVar.a, this.a);
        return aVar;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int a2 = a();
        for (int i = 0; i < a2; i++) {
            sb.append(a(i));
            sb.append(": ");
            sb.append(b(i));
            sb.append("\n");
        }
        return sb.toString();
    }
}
