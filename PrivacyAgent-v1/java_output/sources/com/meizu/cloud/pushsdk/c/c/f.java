package com.meizu.cloud.pushsdk.c.c;

/* loaded from: classes23.dex */
public class f {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final java.lang.String b;
    private final java.lang.String c;
    private final java.lang.String d;
    private final java.lang.String e;
    private final int f;
    private final java.util.List<java.lang.String> g;
    private final java.util.List<java.lang.String> h;
    private final java.lang.String i;
    private final java.lang.String j;

    /* renamed from: com.meizu.cloud.pushsdk.c.c.f$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.meizu.cloud.pushsdk.c.c.f.a.EnumC0423a.values().length];
            a = iArr;
            try {
                iArr[com.meizu.cloud.pushsdk.c.c.f.a.EnumC0423a.SUCCESS.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.meizu.cloud.pushsdk.c.c.f.a.EnumC0423a.INVALID_HOST.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.meizu.cloud.pushsdk.c.c.f.a.EnumC0423a.UNSUPPORTED_SCHEME.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[com.meizu.cloud.pushsdk.c.c.f.a.EnumC0423a.MISSING_SCHEME.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                a[com.meizu.cloud.pushsdk.c.c.f.a.EnumC0423a.INVALID_PORT.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
        }
    }

    public static final class a {
        java.lang.String a;
        java.lang.String d;
        final java.util.List<java.lang.String> f;
        java.util.List<java.lang.String> g;
        java.lang.String h;
        java.lang.String b = "";
        java.lang.String c = "";
        int e = -1;

        /* renamed from: com.meizu.cloud.pushsdk.c.c.f$a$a, reason: collision with other inner class name */
        public enum EnumC0423a {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public a() {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            this.f = arrayList;
            arrayList.add("");
        }

        private static java.lang.String a(byte[] bArr) {
            int i = -1;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (i3 < bArr.length) {
                int i5 = i3;
                while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                    i5 += 2;
                }
                int i6 = i5 - i3;
                if (i6 > i4) {
                    i = i3;
                    i4 = i6;
                }
                i3 = i5 + 2;
            }
            com.meizu.cloud.pushsdk.c.g.b bVar = new com.meizu.cloud.pushsdk.c.g.b();
            while (i2 < bArr.length) {
                if (i2 == i) {
                    bVar.b(58);
                    i2 += i4;
                    if (i2 == 16) {
                        bVar.b(58);
                    }
                } else {
                    if (i2 > 0) {
                        bVar.b(58);
                    }
                    bVar.d(((bArr[i2] & 255) << 8) | (bArr[i2 + 1] & 255));
                    i2 += 2;
                }
            }
            return bVar.h();
        }

        private void a(java.lang.String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char charAt = str.charAt(i);
            if (charAt == '/' || charAt == '\\') {
                this.f.clear();
                this.f.add("");
                i++;
            } else {
                java.util.List<java.lang.String> list = this.f;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i3 = i;
                if (i3 >= i2) {
                    return;
                }
                i = com.meizu.cloud.pushsdk.c.c.m.a(str, i3, i2, "/\\");
                boolean z = i < i2;
                a(str, i3, i, z, true);
                if (z) {
                    i++;
                }
            }
        }

        private void a(java.lang.String str, int i, int i2, boolean z, boolean z2) {
            java.lang.String b = com.meizu.cloud.pushsdk.c.c.f.b(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true);
            if (b(b)) {
                return;
            }
            if (c(b)) {
                c();
                return;
            }
            if (this.f.get(r10.size() - 1).isEmpty()) {
                this.f.set(r10.size() - 1, b);
            } else {
                this.f.add(b);
            }
            if (z) {
                this.f.add("");
            }
        }

        private static boolean a(java.lang.String str, int i, int i2, byte[] bArr, int i3) {
            int i4 = i3;
            while (i < i2) {
                if (i4 == bArr.length) {
                    return false;
                }
                if (i4 != i3) {
                    if (str.charAt(i) != '.') {
                        return false;
                    }
                    i++;
                }
                int i5 = i;
                int i6 = 0;
                while (i5 < i2) {
                    char charAt = str.charAt(i5);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + charAt) - 48) > 255) {
                        return false;
                    }
                    i5++;
                }
                if (i5 - i == 0) {
                    return false;
                }
                bArr[i4] = (byte) i6;
                i4++;
                i = i5;
            }
            return i4 == i3 + 4;
        }

        private static int b(java.lang.String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            boolean z = charAt < 'a' || charAt > 'z';
            boolean z2 = charAt < 'A' || charAt > 'Z';
            if (z && z2) {
                return -1;
            }
            for (int i3 = i + 1; i3 < i2; i3++) {
                char charAt2 = str.charAt(i3);
                if ((charAt2 < 'a' || charAt2 > 'z') && ((charAt2 < 'A' || charAt2 > 'Z') && !((charAt2 >= '0' && charAt2 <= '9') || charAt2 == '+' || charAt2 == '-' || charAt2 == '.'))) {
                    if (charAt2 == ':') {
                        return i3;
                    }
                    return -1;
                }
            }
            return -1;
        }

        private boolean b(java.lang.String str) {
            return ".".equals(str) || "%2e".equalsIgnoreCase(str);
        }

        private static int c(java.lang.String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        private void c() {
            if (!this.f.remove(r0.size() - 1).isEmpty() || this.f.isEmpty()) {
                this.f.add("");
            } else {
                this.f.set(r0.size() - 1, "");
            }
        }

        private boolean c(java.lang.String str) {
            return "..".equals(str) || "%2e.".equalsIgnoreCase(str) || ".%2e".equalsIgnoreCase(str) || "%2e%2e".equalsIgnoreCase(str);
        }

        private static int d(java.lang.String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt == '[') {
                    do {
                        i++;
                        if (i < i2) {
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        private static java.lang.String e(java.lang.String str, int i, int i2) {
            java.lang.String b = com.meizu.cloud.pushsdk.c.c.f.b(str, i, i2, false);
            if (!b.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
                return com.meizu.cloud.pushsdk.c.c.m.a(b);
            }
            java.net.InetAddress f = (b.startsWith("[") && b.endsWith("]")) ? f(b, 1, b.length() - 1) : f(b, 0, b.length());
            if (f == null) {
                return null;
            }
            byte[] address = f.getAddress();
            if (address.length == 16) {
                return a(address);
            }
            throw new java.lang.AssertionError();
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0079, code lost:
        
            return null;
         */
        /* JADX WARN: Removed duplicated region for block: B:15:0x004f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static java.net.InetAddress f(java.lang.String str, int i, int i2) {
            int i3;
            byte[] bArr = new byte[16];
            int i4 = 0;
            int i5 = -1;
            int i6 = -1;
            while (true) {
                if (i < i2) {
                    if (i4 != 16) {
                        int i7 = i + 2;
                        if (i7 <= i2 && str.regionMatches(i, "::", 0, 2)) {
                            if (i5 == -1) {
                                i4 += 2;
                                i5 = i4;
                                if (i7 != i2) {
                                    i6 = i7;
                                    i = i6;
                                    int i8 = 0;
                                    while (i < i2) {
                                    }
                                    i3 = i - i6;
                                    if (i3 == 0) {
                                        break;
                                    }
                                    break;
                                }
                                break;
                            }
                            return null;
                        }
                        if (i4 != 0) {
                            if (str.regionMatches(i, com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, 0, 1)) {
                                i++;
                            } else {
                                if (!str.regionMatches(i, ".", 0, 1) || !a(str, i6, i2, bArr, i4 - 2)) {
                                    return null;
                                }
                                i4 += 2;
                            }
                        }
                        i6 = i;
                        i = i6;
                        int i82 = 0;
                        while (i < i2) {
                            int b = com.meizu.cloud.pushsdk.c.c.f.b(str.charAt(i));
                            if (b == -1) {
                                break;
                            }
                            i82 = (i82 << 4) + b;
                            i++;
                        }
                        i3 = i - i6;
                        if (i3 == 0 || i3 > 4) {
                            break;
                        }
                        int i9 = i4 + 1;
                        bArr[i4] = (byte) ((i82 >>> 8) & 255);
                        i4 = i9 + 1;
                        bArr[i9] = (byte) (i82 & 255);
                    } else {
                        return null;
                    }
                } else {
                    break;
                }
            }
            if (i4 != 16) {
                if (i5 == -1) {
                    return null;
                }
                int i10 = i4 - i5;
                java.lang.System.arraycopy(bArr, i5, bArr, 16 - i10, i10);
                java.util.Arrays.fill(bArr, i5, (16 - i4) + i5, (byte) 0);
            }
            try {
                return java.net.InetAddress.getByAddress(bArr);
            } catch (java.net.UnknownHostException unused) {
                throw new java.lang.AssertionError();
            }
        }

        private static int g(java.lang.String str, int i, int i2) {
            int parseInt;
            try {
                parseInt = java.lang.Integer.parseInt(com.meizu.cloud.pushsdk.c.c.f.b(str, i, i2, "", false, false, false, true));
            } catch (java.lang.NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }

        public int a() {
            int i = this.e;
            return i != -1 ? i : com.meizu.cloud.pushsdk.c.c.f.a(this.a);
        }

        public com.meizu.cloud.pushsdk.c.c.f.a.EnumC0423a a(com.meizu.cloud.pushsdk.c.c.f fVar, java.lang.String str) {
            int a;
            int i;
            int a2 = com.meizu.cloud.pushsdk.c.c.m.a(str, 0, str.length());
            int b = com.meizu.cloud.pushsdk.c.c.m.b(str, a2, str.length());
            if (b(str, a2, b) != -1) {
                if (str.regionMatches(true, a2, "https:", 0, 6)) {
                    this.a = "https";
                    a2 += 6;
                } else {
                    if (!str.regionMatches(true, a2, "http:", 0, 5)) {
                        return com.meizu.cloud.pushsdk.c.c.f.a.EnumC0423a.UNSUPPORTED_SCHEME;
                    }
                    this.a = com.alipay.sdk.m.l.a.q;
                    a2 += 5;
                }
            } else {
                if (fVar == null) {
                    return com.meizu.cloud.pushsdk.c.c.f.a.EnumC0423a.MISSING_SCHEME;
                }
                this.a = fVar.b;
            }
            int c = c(str, a2, b);
            char c2 = '?';
            char c3 = '#';
            if (c >= 2 || fVar == null || !fVar.b.equals(this.a)) {
                int i2 = a2 + c;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    a = com.meizu.cloud.pushsdk.c.c.m.a(str, i2, b, "@/\\?#");
                    char charAt = a != b ? str.charAt(a) : (char) 65535;
                    if (charAt == 65535 || charAt == c3 || charAt == '/' || charAt == '\\' || charAt == c2) {
                        break;
                    }
                    if (charAt == '@') {
                        if (z) {
                            i = a;
                            this.c += "%40" + com.meizu.cloud.pushsdk.c.c.f.b(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                        } else {
                            int a3 = com.meizu.cloud.pushsdk.c.c.m.a(str, i2, a, ':');
                            i = a;
                            java.lang.String b2 = com.meizu.cloud.pushsdk.c.c.f.b(str, i2, a3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                            if (z2) {
                                b2 = this.b + "%40" + b2;
                            }
                            this.b = b2;
                            if (a3 != i) {
                                this.c = com.meizu.cloud.pushsdk.c.c.f.b(str, a3 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                z = true;
                            }
                            z2 = true;
                        }
                        i2 = i + 1;
                    }
                    c2 = '?';
                    c3 = '#';
                }
                int d = d(str, i2, a);
                int i3 = d + 1;
                this.d = e(str, i2, d);
                if (i3 < a) {
                    int g = g(str, i3, a);
                    this.e = g;
                    if (g == -1) {
                        return com.meizu.cloud.pushsdk.c.c.f.a.EnumC0423a.INVALID_PORT;
                    }
                } else {
                    this.e = com.meizu.cloud.pushsdk.c.c.f.a(this.a);
                }
                if (this.d == null) {
                    return com.meizu.cloud.pushsdk.c.c.f.a.EnumC0423a.INVALID_HOST;
                }
                a2 = a;
            } else {
                this.b = fVar.a();
                this.c = fVar.b();
                this.d = fVar.e;
                this.e = fVar.f;
                this.f.clear();
                this.f.addAll(fVar.c());
                if (a2 == b || str.charAt(a2) == '#') {
                    a(fVar.d());
                }
            }
            int a4 = com.meizu.cloud.pushsdk.c.c.m.a(str, a2, b, "?#");
            a(str, a2, a4);
            if (a4 < b && str.charAt(a4) == '?') {
                int a5 = com.meizu.cloud.pushsdk.c.c.m.a(str, a4, b, '#');
                this.g = com.meizu.cloud.pushsdk.c.c.f.b(com.meizu.cloud.pushsdk.c.c.f.b(str, a4 + 1, a5, " \"'<>#", true, false, true, true));
                a4 = a5;
            }
            if (a4 < b && str.charAt(a4) == '#') {
                this.h = com.meizu.cloud.pushsdk.c.c.f.b(str, 1 + a4, b, "", true, false, false, false);
            }
            return com.meizu.cloud.pushsdk.c.c.f.a.EnumC0423a.SUCCESS;
        }

        public com.meizu.cloud.pushsdk.c.c.f.a a(java.lang.String str) {
            this.g = str != null ? com.meizu.cloud.pushsdk.c.c.f.b(com.meizu.cloud.pushsdk.c.c.f.a(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public com.meizu.cloud.pushsdk.c.c.f.a a(java.lang.String str, java.lang.String str2) {
            if (str == null) {
                throw new java.lang.IllegalArgumentException("name == null");
            }
            if (this.g == null) {
                this.g = new java.util.ArrayList();
            }
            this.g.add(com.meizu.cloud.pushsdk.c.c.f.a(str, " \"'<>#&=", false, false, true, true));
            this.g.add(str2 != null ? com.meizu.cloud.pushsdk.c.c.f.a(str2, " \"'<>#&=", false, false, true, true) : null);
            return this;
        }

        public com.meizu.cloud.pushsdk.c.c.f b() {
            if (this.a == null) {
                throw new java.lang.IllegalStateException("scheme == null");
            }
            if (this.d != null) {
                return new com.meizu.cloud.pushsdk.c.c.f(this, null);
            }
            throw new java.lang.IllegalStateException("host == null");
        }

        public java.lang.String toString() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(this.a);
            sb.append("://");
            if (!this.b.isEmpty() || !this.c.isEmpty()) {
                sb.append(this.b);
                if (!this.c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.c);
                }
                sb.append('@');
            }
            if (this.d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.d);
                sb.append(']');
            } else {
                sb.append(this.d);
            }
            int a = a();
            if (a != com.meizu.cloud.pushsdk.c.c.f.a(this.a)) {
                sb.append(':');
                sb.append(a);
            }
            com.meizu.cloud.pushsdk.c.c.f.a(sb, this.f);
            if (this.g != null) {
                sb.append('?');
                com.meizu.cloud.pushsdk.c.c.f.b(sb, this.g);
            }
            if (this.h != null) {
                sb.append('#');
                sb.append(this.h);
            }
            return sb.toString();
        }
    }

    private f(com.meizu.cloud.pushsdk.c.c.f.a aVar) {
        this.b = aVar.a;
        this.c = a(aVar.b, false);
        this.d = a(aVar.c, false);
        this.e = aVar.d;
        this.f = aVar.a();
        this.g = a(aVar.f, false);
        java.util.List<java.lang.String> list = aVar.g;
        this.h = list != null ? a(list, true) : null;
        java.lang.String str = aVar.h;
        this.i = str != null ? a(str, false) : null;
        this.j = aVar.toString();
    }

    public /* synthetic */ f(com.meizu.cloud.pushsdk.c.c.f.a aVar, com.meizu.cloud.pushsdk.c.c.f.AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    public static int a(java.lang.String str) {
        if (com.alipay.sdk.m.l.a.q.equals(str)) {
            return 80;
        }
        return "https".equals(str) ? 443 : -1;
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return b(str, 0, str.length(), str2, z, z2, z3, z4);
    }

    public static java.lang.String a(java.lang.String str, boolean z) {
        return b(str, 0, str.length(), z);
    }

    private java.util.List<java.lang.String> a(java.util.List<java.lang.String> list, boolean z) {
        java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
        java.util.Iterator<java.lang.String> it = list.iterator();
        while (it.hasNext()) {
            java.lang.String next = it.next();
            arrayList.add(next != null ? a(next, z) : null);
        }
        return java.util.Collections.unmodifiableList(arrayList);
    }

    private static void a(com.meizu.cloud.pushsdk.c.g.b bVar, java.lang.String str, int i, int i2, java.lang.String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        com.meizu.cloud.pushsdk.c.g.b bVar2 = null;
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt == 43 && z3) {
                bVar.b(z ? "+" : "%2B");
            } else if (a(codePointAt, i3, str, i2, str2, z, z2, z3, z4)) {
                if (bVar2 == null) {
                    bVar2 = new com.meizu.cloud.pushsdk.c.g.b();
                }
                bVar2.a(codePointAt);
                while (!bVar2.c()) {
                    int f = bVar2.f() & 255;
                    bVar.b(37);
                    char[] cArr = a;
                    bVar.b((int) cArr[(f >> 4) & 15]);
                    bVar.b((int) cArr[f & 15]);
                }
            } else {
                bVar.a(codePointAt);
            }
            i3 += java.lang.Character.charCount(codePointAt);
        }
    }

    private static void a(com.meizu.cloud.pushsdk.c.g.b bVar, java.lang.String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt != 37 || (i3 = i + 2) >= i2) {
                if (codePointAt == 43 && z) {
                    bVar.b(32);
                }
                bVar.a(codePointAt);
            } else {
                int b = b(str.charAt(i + 1));
                int b2 = b(str.charAt(i3));
                if (b != -1 && b2 != -1) {
                    bVar.b((b << 4) + b2);
                    i = i3;
                }
                bVar.a(codePointAt);
            }
            i += java.lang.Character.charCount(codePointAt);
        }
    }

    public static void a(java.lang.StringBuilder sb, java.util.List<java.lang.String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    private static boolean a(int i, int i2, java.lang.String str, int i3, java.lang.String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        if (i < 32 || i == 127) {
            return true;
        }
        if ((i >= 128 && z4) || str2.indexOf(i) != -1) {
            return true;
        }
        boolean z5 = !z || (z2 && !a(str, i2, i3));
        if (i == 37 && z5) {
            return true;
        }
        return i == 43 && z3;
    }

    private static boolean a(java.lang.String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && b(str.charAt(i + 1)) != -1 && b(str.charAt(i3)) != -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'a';
        if (c < 'a' || c > 'f') {
            c2 = 'A';
            if (c < 'A' || c > 'F') {
                return -1;
            }
        }
        return (c - c2) + 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String b(java.lang.String str, int i, int i2, java.lang.String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (a(codePointAt, i3, str, i2, str2, z, z2, z3, z4)) {
                com.meizu.cloud.pushsdk.c.g.b bVar = new com.meizu.cloud.pushsdk.c.g.b();
                bVar.a(str, i, i3);
                a(bVar, str, i3, i2, str2, z, z2, z3, z4);
                return bVar.h();
            }
            i3 += java.lang.Character.charCount(codePointAt);
        }
        return str.substring(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String b(java.lang.String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            boolean z2 = false;
            boolean z3 = charAt == '%';
            if (charAt == '+' && z) {
                z2 = true;
            }
            if (z3 || z2) {
                com.meizu.cloud.pushsdk.c.g.b bVar = new com.meizu.cloud.pushsdk.c.g.b();
                bVar.a(str, i, i3);
                a(bVar, str, i3, i2, z);
                return bVar.h();
            }
        }
        return str.substring(i, i2);
    }

    public static java.util.List<java.lang.String> b(java.lang.String str) {
        java.lang.String str2;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i, indexOf));
                str2 = null;
            } else {
                arrayList.add(str.substring(i, indexOf2));
                str2 = str.substring(indexOf2 + 1, indexOf);
            }
            arrayList.add(str2);
            i = indexOf + 1;
        }
        return arrayList;
    }

    public static void b(java.lang.StringBuilder sb, java.util.List<java.lang.String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            java.lang.String str = list.get(i);
            java.lang.String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append(kotlin.text.Typography.amp);
            }
            sb.append(str);
            if (str2 != null) {
                sb.append(com.alipay.sdk.m.n.a.h);
                sb.append(str2);
            }
        }
    }

    public static com.meizu.cloud.pushsdk.c.c.f c(java.lang.String str) {
        com.meizu.cloud.pushsdk.c.c.f.a aVar = new com.meizu.cloud.pushsdk.c.c.f.a();
        if (aVar.a((com.meizu.cloud.pushsdk.c.c.f) null, str) == com.meizu.cloud.pushsdk.c.c.f.a.EnumC0423a.SUCCESS) {
            return aVar.b();
        }
        return null;
    }

    public java.lang.String a() {
        if (this.c.isEmpty()) {
            return "";
        }
        int length = this.b.length() + 3;
        java.lang.String str = this.j;
        return this.j.substring(length, com.meizu.cloud.pushsdk.c.c.m.a(str, length, str.length(), ":@"));
    }

    public java.lang.String b() {
        if (this.d.isEmpty()) {
            return "";
        }
        return this.j.substring(this.j.indexOf(58, this.b.length() + 3) + 1, this.j.indexOf(64));
    }

    public java.util.List<java.lang.String> c() {
        int indexOf = this.j.indexOf(47, this.b.length() + 3);
        java.lang.String str = this.j;
        int a2 = com.meizu.cloud.pushsdk.c.c.m.a(str, indexOf, str.length(), "?#");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (indexOf < a2) {
            int i = indexOf + 1;
            int a3 = com.meizu.cloud.pushsdk.c.c.m.a(this.j, i, a2, '/');
            arrayList.add(this.j.substring(i, a3));
            indexOf = a3;
        }
        return arrayList;
    }

    public java.lang.String d() {
        if (this.h == null) {
            return null;
        }
        int indexOf = this.j.indexOf(63) + 1;
        java.lang.String str = this.j;
        return this.j.substring(indexOf, com.meizu.cloud.pushsdk.c.c.m.a(str, indexOf + 1, str.length(), '#'));
    }

    public java.lang.String e() {
        if (this.i == null) {
            return null;
        }
        return this.j.substring(this.j.indexOf(35) + 1);
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof com.meizu.cloud.pushsdk.c.c.f) && ((com.meizu.cloud.pushsdk.c.c.f) obj).j.equals(this.j);
    }

    public com.meizu.cloud.pushsdk.c.c.f.a f() {
        com.meizu.cloud.pushsdk.c.c.f.a aVar = new com.meizu.cloud.pushsdk.c.c.f.a();
        aVar.a = this.b;
        aVar.b = a();
        aVar.c = b();
        aVar.d = this.e;
        aVar.e = this.f != a(this.b) ? this.f : -1;
        aVar.f.clear();
        aVar.f.addAll(c());
        aVar.a(d());
        aVar.h = e();
        return aVar;
    }

    public int hashCode() {
        return this.j.hashCode();
    }

    public java.lang.String toString() {
        return this.j;
    }
}
