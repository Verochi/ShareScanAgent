package com.anythink.expressad.exoplayer.i;

/* loaded from: classes12.dex */
public final class c extends com.anythink.expressad.exoplayer.i.e {
    private static final float a = 0.98f;
    private static final int[] b = new int[0];
    private static final int c = 1000;

    @androidx.annotation.Nullable
    private final com.anythink.expressad.exoplayer.i.f.a d;
    private final java.util.concurrent.atomic.AtomicReference<com.anythink.expressad.exoplayer.i.c.C0201c> e;

    public static final class a {
        public final int a;
        public final int b;

        @androidx.annotation.Nullable
        public final java.lang.String c;

        public a(int i, int i2, @androidx.annotation.Nullable java.lang.String str) {
            this.a = i;
            this.b = i2;
            this.c = str;
        }

        public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && com.anythink.expressad.exoplayer.i.c.a.class == obj.getClass()) {
                com.anythink.expressad.exoplayer.i.c.a aVar = (com.anythink.expressad.exoplayer.i.c.a) obj;
                if (this.a == aVar.a && this.b == aVar.b && android.text.TextUtils.equals(this.c, aVar.c)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            int i = ((this.a * 31) + this.b) * 31;
            java.lang.String str = this.c;
            return i + (str != null ? str.hashCode() : 0);
        }
    }

    public static final class b implements java.lang.Comparable<com.anythink.expressad.exoplayer.i.c.b> {
        private final com.anythink.expressad.exoplayer.i.c.C0201c a;
        private final int b;
        private final int c;
        private final int d;
        private final int e;
        private final int f;
        private final int g;

        public b(com.anythink.expressad.exoplayer.m mVar, com.anythink.expressad.exoplayer.i.c.C0201c c0201c, int i) {
            this.a = c0201c;
            this.b = com.anythink.expressad.exoplayer.i.c.a(i, false) ? 1 : 0;
            this.c = com.anythink.expressad.exoplayer.i.c.a(mVar, c0201c.b) ? 1 : 0;
            this.d = (mVar.z & 1) != 0 ? 1 : 0;
            this.e = mVar.u;
            this.f = mVar.v;
            this.g = mVar.d;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final int compareTo(com.anythink.expressad.exoplayer.i.c.b bVar) {
            int a;
            int i = this.b;
            int i2 = bVar.b;
            if (i != i2) {
                return com.anythink.expressad.exoplayer.i.c.a(i, i2);
            }
            int i3 = this.c;
            int i4 = bVar.c;
            if (i3 != i4) {
                return com.anythink.expressad.exoplayer.i.c.a(i3, i4);
            }
            int i5 = this.d;
            int i6 = bVar.d;
            if (i5 != i6) {
                return com.anythink.expressad.exoplayer.i.c.a(i5, i6);
            }
            if (this.a.m) {
                return com.anythink.expressad.exoplayer.i.c.a(bVar.g, this.g);
            }
            int i7 = i != 1 ? -1 : 1;
            int i8 = this.e;
            int i9 = bVar.e;
            if (i8 != i9) {
                a = com.anythink.expressad.exoplayer.i.c.a(i8, i9);
            } else {
                int i10 = this.f;
                int i11 = bVar.f;
                a = i10 != i11 ? com.anythink.expressad.exoplayer.i.c.a(i10, i11) : com.anythink.expressad.exoplayer.i.c.a(this.g, bVar.g);
            }
            return i7 * a;
        }

        public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && com.anythink.expressad.exoplayer.i.c.b.class == obj.getClass()) {
                com.anythink.expressad.exoplayer.i.c.b bVar = (com.anythink.expressad.exoplayer.i.c.b) obj;
                if (this.b == bVar.b && this.c == bVar.c && this.d == bVar.d && this.e == bVar.e && this.f == bVar.f && this.g == bVar.g) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return (((((((((this.b * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g;
        }
    }

    /* renamed from: com.anythink.expressad.exoplayer.i.c$c, reason: collision with other inner class name */
    public static final class C0201c implements android.os.Parcelable {

        @androidx.annotation.Nullable
        public final java.lang.String b;

        @androidx.annotation.Nullable
        public final java.lang.String c;
        public final boolean d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final boolean i;
        public final int j;
        public final int k;
        public final boolean l;
        public final boolean m;
        public final boolean n;
        public final boolean o;
        public final boolean p;
        public final int q;
        private final android.util.SparseArray<java.util.Map<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e>> r;

        /* renamed from: s, reason: collision with root package name */
        private final android.util.SparseBooleanArray f225s;
        public static final com.anythink.expressad.exoplayer.i.c.C0201c a = new com.anythink.expressad.exoplayer.i.c.C0201c();
        public static final android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.i.c.C0201c> CREATOR = new com.anythink.expressad.exoplayer.i.c.C0201c.AnonymousClass1();

        /* renamed from: com.anythink.expressad.exoplayer.i.c$c$1, reason: invalid class name */
        public class AnonymousClass1 implements android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.i.c.C0201c> {
            private static com.anythink.expressad.exoplayer.i.c.C0201c a(android.os.Parcel parcel) {
                return new com.anythink.expressad.exoplayer.i.c.C0201c(parcel);
            }

            private static com.anythink.expressad.exoplayer.i.c.C0201c[] a(int i) {
                return new com.anythink.expressad.exoplayer.i.c.C0201c[i];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ com.anythink.expressad.exoplayer.i.c.C0201c createFromParcel(android.os.Parcel parcel) {
                return new com.anythink.expressad.exoplayer.i.c.C0201c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ com.anythink.expressad.exoplayer.i.c.C0201c[] newArray(int i) {
                return new com.anythink.expressad.exoplayer.i.c.C0201c[i];
            }
        }

        private C0201c() {
            this(new android.util.SparseArray(), new android.util.SparseBooleanArray(), null, null, false, 0, false, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true, 0);
        }

        public C0201c(android.os.Parcel parcel) {
            this.r = a(parcel);
            this.f225s = parcel.readSparseBooleanArray();
            this.b = parcel.readString();
            this.c = parcel.readString();
            this.d = com.anythink.expressad.exoplayer.k.af.a(parcel);
            this.e = parcel.readInt();
            this.m = com.anythink.expressad.exoplayer.k.af.a(parcel);
            this.n = com.anythink.expressad.exoplayer.k.af.a(parcel);
            this.o = com.anythink.expressad.exoplayer.k.af.a(parcel);
            this.f = parcel.readInt();
            this.g = parcel.readInt();
            this.h = parcel.readInt();
            this.i = com.anythink.expressad.exoplayer.k.af.a(parcel);
            this.p = com.anythink.expressad.exoplayer.k.af.a(parcel);
            this.j = parcel.readInt();
            this.k = parcel.readInt();
            this.l = com.anythink.expressad.exoplayer.k.af.a(parcel);
            this.q = parcel.readInt();
        }

        public C0201c(android.util.SparseArray<java.util.Map<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e>> sparseArray, android.util.SparseBooleanArray sparseBooleanArray, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, boolean z, int i, boolean z2, boolean z3, boolean z4, int i2, int i3, int i4, boolean z5, boolean z6, int i5, int i6, boolean z7, int i7) {
            this.r = sparseArray;
            this.f225s = sparseBooleanArray;
            this.b = com.anythink.expressad.exoplayer.k.af.b(str);
            this.c = com.anythink.expressad.exoplayer.k.af.b(str2);
            this.d = z;
            this.e = i;
            this.m = z2;
            this.n = z3;
            this.o = z4;
            this.f = i2;
            this.g = i3;
            this.h = i4;
            this.i = z5;
            this.p = z6;
            this.j = i5;
            this.k = i6;
            this.l = z7;
            this.q = i7;
        }

        private static android.util.SparseArray<java.util.Map<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e>> a(android.os.Parcel parcel) {
            int readInt = parcel.readInt();
            android.util.SparseArray<java.util.Map<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e>> sparseArray = new android.util.SparseArray<>(readInt);
            for (int i = 0; i < readInt; i++) {
                int readInt2 = parcel.readInt();
                int readInt3 = parcel.readInt();
                java.util.HashMap hashMap = new java.util.HashMap(readInt3);
                for (int i2 = 0; i2 < readInt3; i2++) {
                    hashMap.put((com.anythink.expressad.exoplayer.h.af) parcel.readParcelable(com.anythink.expressad.exoplayer.h.af.class.getClassLoader()), (com.anythink.expressad.exoplayer.i.c.e) parcel.readParcelable(com.anythink.expressad.exoplayer.i.c.e.class.getClassLoader()));
                }
                sparseArray.put(readInt2, hashMap);
            }
            return sparseArray;
        }

        private com.anythink.expressad.exoplayer.i.c.d a() {
            return new com.anythink.expressad.exoplayer.i.c.d(this, (byte) 0);
        }

        private static void a(android.os.Parcel parcel, android.util.SparseArray<java.util.Map<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e>> sparseArray) {
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i = 0; i < size; i++) {
                int keyAt = sparseArray.keyAt(i);
                java.util.Map<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e> valueAt = sparseArray.valueAt(i);
                int size2 = valueAt.size();
                parcel.writeInt(keyAt);
                parcel.writeInt(size2);
                for (java.util.Map.Entry<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e> entry : valueAt.entrySet()) {
                    parcel.writeParcelable(entry.getKey(), 0);
                    parcel.writeParcelable(entry.getValue(), 0);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0064 A[LOOP:0: B:6:0x000d->B:14:0x0064, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0067 A[EDGE_INSN: B:15:0x0067->B:16:0x0067 BREAK  A[LOOP:0: B:6:0x000d->B:14:0x0064], SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static boolean a(android.util.SparseArray<java.util.Map<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e>> sparseArray, android.util.SparseArray<java.util.Map<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e>> sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            int i = 0;
            while (true) {
                boolean z = true;
                if (i >= size) {
                    return true;
                }
                int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i));
                if (indexOfKey < 0) {
                    break;
                }
                java.util.Map<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e> valueAt = sparseArray.valueAt(i);
                java.util.Map<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e> valueAt2 = sparseArray2.valueAt(indexOfKey);
                if (valueAt2.size() == valueAt.size()) {
                    for (java.util.Map.Entry<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e> entry : valueAt.entrySet()) {
                        com.anythink.expressad.exoplayer.h.af key = entry.getKey();
                        if (valueAt2.containsKey(key) && com.anythink.expressad.exoplayer.k.af.a(entry.getValue(), valueAt2.get(key))) {
                        }
                    }
                    if (z) {
                        break;
                    }
                    i++;
                }
                z = false;
                if (z) {
                }
            }
            return false;
        }

        private static boolean a(android.util.SparseBooleanArray sparseBooleanArray, android.util.SparseBooleanArray sparseBooleanArray2) {
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) < 0) {
                    return false;
                }
            }
            return true;
        }

        private static boolean a(java.util.Map<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e> map, java.util.Map<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e> map2) {
            if (map2.size() != map.size()) {
                return false;
            }
            for (java.util.Map.Entry<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e> entry : map.entrySet()) {
                com.anythink.expressad.exoplayer.h.af key = entry.getKey();
                if (!map2.containsKey(key) || !com.anythink.expressad.exoplayer.k.af.a(entry.getValue(), map2.get(key))) {
                    return false;
                }
            }
            return true;
        }

        public final boolean a(int i) {
            return this.f225s.get(i);
        }

        public final boolean a(int i, com.anythink.expressad.exoplayer.h.af afVar) {
            java.util.Map<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e> map = this.r.get(i);
            return map != null && map.containsKey(afVar);
        }

        @androidx.annotation.Nullable
        public final com.anythink.expressad.exoplayer.i.c.e b(int i, com.anythink.expressad.exoplayer.h.af afVar) {
            java.util.Map<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e> map = this.r.get(i);
            if (map != null) {
                return map.get(afVar);
            }
            return null;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        /* JADX WARN: Removed duplicated region for block: B:45:0x009f  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x010d A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0107 A[LOOP:0: B:51:0x00b0->B:58:0x0107, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:59:0x00ad A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            boolean z;
            boolean z2;
            boolean z3;
            if (this == obj) {
                return true;
            }
            if (obj != null && com.anythink.expressad.exoplayer.i.c.C0201c.class == obj.getClass()) {
                com.anythink.expressad.exoplayer.i.c.C0201c c0201c = (com.anythink.expressad.exoplayer.i.c.C0201c) obj;
                if (this.d == c0201c.d && this.e == c0201c.e && this.m == c0201c.m && this.n == c0201c.n && this.o == c0201c.o && this.f == c0201c.f && this.g == c0201c.g && this.i == c0201c.i && this.p == c0201c.p && this.l == c0201c.l && this.j == c0201c.j && this.k == c0201c.k && this.h == c0201c.h && this.q == c0201c.q && android.text.TextUtils.equals(this.b, c0201c.b) && android.text.TextUtils.equals(this.c, c0201c.c)) {
                    android.util.SparseBooleanArray sparseBooleanArray = this.f225s;
                    android.util.SparseBooleanArray sparseBooleanArray2 = c0201c.f225s;
                    int size = sparseBooleanArray.size();
                    if (sparseBooleanArray2.size() == size) {
                        for (int i = 0; i < size; i++) {
                            if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) >= 0) {
                            }
                        }
                        z = true;
                        if (z) {
                            android.util.SparseArray<java.util.Map<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e>> sparseArray = this.r;
                            android.util.SparseArray<java.util.Map<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e>> sparseArray2 = c0201c.r;
                            int size2 = sparseArray.size();
                            if (sparseArray2.size() == size2) {
                                for (int i2 = 0; i2 < size2; i2++) {
                                    int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i2));
                                    if (indexOfKey >= 0) {
                                        java.util.Map<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e> valueAt = sparseArray.valueAt(i2);
                                        java.util.Map<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e> valueAt2 = sparseArray2.valueAt(indexOfKey);
                                        if (valueAt2.size() == valueAt.size()) {
                                            for (java.util.Map.Entry<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e> entry : valueAt.entrySet()) {
                                                com.anythink.expressad.exoplayer.h.af key = entry.getKey();
                                                if (valueAt2.containsKey(key) && com.anythink.expressad.exoplayer.k.af.a(entry.getValue(), valueAt2.get(key))) {
                                                }
                                            }
                                            z3 = true;
                                            if (!z3) {
                                            }
                                        }
                                        z3 = false;
                                        if (!z3) {
                                        }
                                    }
                                }
                                z2 = true;
                                if (!z2) {
                                    return true;
                                }
                            }
                            z2 = false;
                            if (!z2) {
                            }
                        }
                    }
                    z = false;
                    if (z) {
                    }
                }
            }
            return false;
        }

        public final int hashCode() {
            int i = (((((((((((((((((((((((((((this.d ? 1 : 0) * 31) + this.e) * 31) + (this.m ? 1 : 0)) * 31) + (this.n ? 1 : 0)) * 31) + (this.o ? 1 : 0)) * 31) + this.f) * 31) + this.g) * 31) + (this.i ? 1 : 0)) * 31) + (this.p ? 1 : 0)) * 31) + (this.l ? 1 : 0)) * 31) + this.j) * 31) + this.k) * 31) + this.h) * 31) + this.q) * 31;
            java.lang.String str = this.b;
            int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
            java.lang.String str2 = this.c;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(android.os.Parcel parcel, int i) {
            android.util.SparseArray<java.util.Map<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e>> sparseArray = this.r;
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt = sparseArray.keyAt(i2);
                java.util.Map<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e> valueAt = sparseArray.valueAt(i2);
                int size2 = valueAt.size();
                parcel.writeInt(keyAt);
                parcel.writeInt(size2);
                for (java.util.Map.Entry<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e> entry : valueAt.entrySet()) {
                    parcel.writeParcelable(entry.getKey(), 0);
                    parcel.writeParcelable(entry.getValue(), 0);
                }
            }
            parcel.writeSparseBooleanArray(this.f225s);
            parcel.writeString(this.b);
            parcel.writeString(this.c);
            com.anythink.expressad.exoplayer.k.af.a(parcel, this.d);
            parcel.writeInt(this.e);
            com.anythink.expressad.exoplayer.k.af.a(parcel, this.m);
            com.anythink.expressad.exoplayer.k.af.a(parcel, this.n);
            com.anythink.expressad.exoplayer.k.af.a(parcel, this.o);
            parcel.writeInt(this.f);
            parcel.writeInt(this.g);
            parcel.writeInt(this.h);
            com.anythink.expressad.exoplayer.k.af.a(parcel, this.i);
            com.anythink.expressad.exoplayer.k.af.a(parcel, this.p);
            parcel.writeInt(this.j);
            parcel.writeInt(this.k);
            com.anythink.expressad.exoplayer.k.af.a(parcel, this.l);
            parcel.writeInt(this.q);
        }
    }

    public static final class d {
        private final android.util.SparseArray<java.util.Map<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e>> a;
        private final android.util.SparseBooleanArray b;

        @androidx.annotation.Nullable
        private java.lang.String c;

        @androidx.annotation.Nullable
        private java.lang.String d;
        private boolean e;
        private int f;
        private boolean g;
        private boolean h;
        private boolean i;
        private int j;
        private int k;
        private int l;
        private boolean m;
        private boolean n;
        private int o;
        private int p;
        private boolean q;
        private int r;

        public d() {
            this(com.anythink.expressad.exoplayer.i.c.C0201c.a);
        }

        private d(com.anythink.expressad.exoplayer.i.c.C0201c c0201c) {
            this.a = a((android.util.SparseArray<java.util.Map<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e>>) c0201c.r);
            this.b = c0201c.f225s.clone();
            this.c = c0201c.b;
            this.d = c0201c.c;
            this.e = c0201c.d;
            this.f = c0201c.e;
            this.g = c0201c.m;
            this.h = c0201c.n;
            this.i = c0201c.o;
            this.j = c0201c.f;
            this.k = c0201c.g;
            this.l = c0201c.h;
            this.m = c0201c.i;
            this.n = c0201c.p;
            this.o = c0201c.j;
            this.p = c0201c.k;
            this.q = c0201c.l;
            this.r = c0201c.q;
        }

        public /* synthetic */ d(com.anythink.expressad.exoplayer.i.c.C0201c c0201c, byte b) {
            this(c0201c);
        }

        private static android.util.SparseArray<java.util.Map<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e>> a(android.util.SparseArray<java.util.Map<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e>> sparseArray) {
            android.util.SparseArray<java.util.Map<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e>> sparseArray2 = new android.util.SparseArray<>();
            for (int i = 0; i < sparseArray.size(); i++) {
                sparseArray2.put(sparseArray.keyAt(i), new java.util.HashMap(sparseArray.valueAt(i)));
            }
            return sparseArray2;
        }

        private com.anythink.expressad.exoplayer.i.c.d a(int i, int i2) {
            this.j = i;
            this.k = i2;
            return this;
        }

        private com.anythink.expressad.exoplayer.i.c.d a(int i, int i2, boolean z) {
            this.o = i;
            this.p = i2;
            this.q = z;
            return this;
        }

        private com.anythink.expressad.exoplayer.i.c.d a(android.content.Context context, boolean z) {
            android.graphics.Point a = com.anythink.expressad.exoplayer.k.af.a(context);
            return a(a.x, a.y, z);
        }

        private com.anythink.expressad.exoplayer.i.c.d a(java.lang.String str) {
            this.c = str;
            return this;
        }

        private com.anythink.expressad.exoplayer.i.c.d a(boolean z) {
            this.e = z;
            return this;
        }

        private com.anythink.expressad.exoplayer.i.c.d b(java.lang.String str) {
            this.d = str;
            return this;
        }

        private com.anythink.expressad.exoplayer.i.c.d b(boolean z) {
            this.g = z;
            return this;
        }

        private com.anythink.expressad.exoplayer.i.c.d c() {
            return a(1279, 719);
        }

        private com.anythink.expressad.exoplayer.i.c.d c(int i) {
            this.f = i;
            return this;
        }

        private com.anythink.expressad.exoplayer.i.c.d c(boolean z) {
            this.h = z;
            return this;
        }

        private com.anythink.expressad.exoplayer.i.c.d d() {
            return a(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        private com.anythink.expressad.exoplayer.i.c.d d(int i) {
            this.l = i;
            return this;
        }

        private com.anythink.expressad.exoplayer.i.c.d d(boolean z) {
            this.i = z;
            return this;
        }

        private com.anythink.expressad.exoplayer.i.c.d e() {
            return a(Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        private com.anythink.expressad.exoplayer.i.c.d e(boolean z) {
            this.m = z;
            return this;
        }

        private com.anythink.expressad.exoplayer.i.c.d f(boolean z) {
            this.n = z;
            return this;
        }

        public final com.anythink.expressad.exoplayer.i.c.d a() {
            if (this.a.size() == 0) {
                return this;
            }
            this.a.clear();
            return this;
        }

        public final com.anythink.expressad.exoplayer.i.c.d a(int i) {
            java.util.Map<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e> map = this.a.get(i);
            if (map != null && !map.isEmpty()) {
                this.a.remove(i);
            }
            return this;
        }

        public final com.anythink.expressad.exoplayer.i.c.d a(int i, com.anythink.expressad.exoplayer.h.af afVar) {
            java.util.Map<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e> map = this.a.get(i);
            if (map != null && map.containsKey(afVar)) {
                map.remove(afVar);
                if (map.isEmpty()) {
                    this.a.remove(i);
                }
            }
            return this;
        }

        public final com.anythink.expressad.exoplayer.i.c.d a(int i, com.anythink.expressad.exoplayer.h.af afVar, com.anythink.expressad.exoplayer.i.c.e eVar) {
            java.util.Map<com.anythink.expressad.exoplayer.h.af, com.anythink.expressad.exoplayer.i.c.e> map = this.a.get(i);
            if (map == null) {
                map = new java.util.HashMap<>();
                this.a.put(i, map);
            }
            if (map.containsKey(afVar) && com.anythink.expressad.exoplayer.k.af.a(map.get(afVar), eVar)) {
                return this;
            }
            map.put(afVar, eVar);
            return this;
        }

        public final com.anythink.expressad.exoplayer.i.c.d a(int i, boolean z) {
            if (this.b.get(i) == z) {
                return this;
            }
            if (z) {
                this.b.put(i, true);
            } else {
                this.b.delete(i);
            }
            return this;
        }

        public final com.anythink.expressad.exoplayer.i.c.C0201c b() {
            return new com.anythink.expressad.exoplayer.i.c.C0201c(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r);
        }

        public final com.anythink.expressad.exoplayer.i.c.d b(int i) {
            if (this.r != i) {
                this.r = i;
            }
            return this;
        }
    }

    public static final class e implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.i.c.e> CREATOR = new com.anythink.expressad.exoplayer.i.c.e.AnonymousClass1();
        public final int a;
        public final int[] b;
        public final int c;

        /* renamed from: com.anythink.expressad.exoplayer.i.c$e$1, reason: invalid class name */
        public class AnonymousClass1 implements android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.i.c.e> {
            private static com.anythink.expressad.exoplayer.i.c.e a(android.os.Parcel parcel) {
                return new com.anythink.expressad.exoplayer.i.c.e(parcel);
            }

            private static com.anythink.expressad.exoplayer.i.c.e[] a(int i) {
                return new com.anythink.expressad.exoplayer.i.c.e[i];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ com.anythink.expressad.exoplayer.i.c.e createFromParcel(android.os.Parcel parcel) {
                return new com.anythink.expressad.exoplayer.i.c.e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ com.anythink.expressad.exoplayer.i.c.e[] newArray(int i) {
                return new com.anythink.expressad.exoplayer.i.c.e[i];
            }
        }

        private e(int i, int... iArr) {
            this.a = i;
            int[] copyOf = java.util.Arrays.copyOf(iArr, iArr.length);
            this.b = copyOf;
            this.c = iArr.length;
            java.util.Arrays.sort(copyOf);
        }

        public e(android.os.Parcel parcel) {
            this.a = parcel.readInt();
            int readByte = parcel.readByte();
            this.c = readByte;
            int[] iArr = new int[readByte];
            this.b = iArr;
            parcel.readIntArray(iArr);
        }

        private boolean a(int i) {
            for (int i2 : this.b) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && com.anythink.expressad.exoplayer.i.c.e.class == obj.getClass()) {
                com.anythink.expressad.exoplayer.i.c.e eVar = (com.anythink.expressad.exoplayer.i.c.e) obj;
                if (this.a == eVar.a && java.util.Arrays.equals(this.b, eVar.b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return (this.a * 31) + java.util.Arrays.hashCode(this.b);
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(android.os.Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.b.length);
            parcel.writeIntArray(this.b);
        }
    }

    public c() {
        this((com.anythink.expressad.exoplayer.i.f.a) null);
    }

    private c(@androidx.annotation.Nullable com.anythink.expressad.exoplayer.i.f.a aVar) {
        this.d = aVar;
        this.e = new java.util.concurrent.atomic.AtomicReference<>(com.anythink.expressad.exoplayer.i.c.C0201c.a);
    }

    private c(com.anythink.expressad.exoplayer.j.d dVar) {
        this(new com.anythink.expressad.exoplayer.i.a.C0200a(dVar));
    }

    public static /* synthetic */ int a(int i, int i2) {
        if (i > i2) {
            return 1;
        }
        return i2 > i ? -1 : 0;
    }

    private static int a(com.anythink.expressad.exoplayer.h.ae aeVar, int[] iArr, int i, @androidx.annotation.Nullable java.lang.String str, int i2, int i3, int i4, java.util.List<java.lang.Integer> list) {
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            int intValue = list.get(i6).intValue();
            if (a(aeVar.a(intValue), str, iArr[intValue], i, i2, i3, i4)) {
                i5++;
            }
        }
        return i5;
    }

    private static int a(com.anythink.expressad.exoplayer.h.ae aeVar, int[] iArr, com.anythink.expressad.exoplayer.i.c.a aVar) {
        int i = 0;
        for (int i2 = 0; i2 < aeVar.a; i2++) {
            if (a(aeVar.a(i2), iArr[i2], aVar)) {
                i++;
            }
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
    
        if ((r6 > r7) != (r4 > r5)) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static android.graphics.Point a(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
        }
        i2 = i;
        i = i2;
        int i5 = i3 * i;
        int i6 = i4 * i2;
        return i5 >= i6 ? new android.graphics.Point(i2, com.anythink.expressad.exoplayer.k.af.a(i6, i3)) : new android.graphics.Point(com.anythink.expressad.exoplayer.k.af.a(i5, i4), i);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00ff A[LOOP:0: B:13:0x0022->B:21:0x00ff, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00f1 A[SYNTHETIC] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static com.anythink.expressad.exoplayer.i.f a(com.anythink.expressad.exoplayer.h.af afVar, int[][] iArr, int i, com.anythink.expressad.exoplayer.i.c.C0201c c0201c, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.i.f.a aVar) {
        com.anythink.expressad.exoplayer.i.f fVar;
        java.util.List<java.lang.Integer> list;
        int i2;
        int i3;
        int i4;
        com.anythink.expressad.exoplayer.h.ae aeVar;
        java.lang.String str;
        int[] a2;
        int i5;
        java.util.HashSet hashSet;
        java.util.List<java.lang.Integer> list2;
        int i6;
        int i7;
        int i8;
        com.anythink.expressad.exoplayer.h.ae aeVar2;
        if (!c0201c.m && aVar != null) {
            int i9 = c0201c.o ? 24 : 16;
            boolean z = c0201c.n && (i & i9) != 0;
            for (int i10 = 0; i10 < afVar.b; i10++) {
                com.anythink.expressad.exoplayer.h.ae a3 = afVar.a(i10);
                int[] iArr2 = iArr[i10];
                int i11 = c0201c.f;
                int i12 = c0201c.g;
                int i13 = c0201c.h;
                int i14 = c0201c.j;
                int i15 = c0201c.k;
                boolean z2 = c0201c.l;
                if (a3.a < 2) {
                    a2 = b;
                } else {
                    java.util.List<java.lang.Integer> a4 = a(a3, i14, i15, z2);
                    if (a4.size() < 2) {
                        a2 = b;
                    } else {
                        if (z) {
                            list = a4;
                            i2 = i13;
                            i3 = i12;
                            i4 = i11;
                            aeVar = a3;
                            str = null;
                        } else {
                            java.util.HashSet hashSet2 = new java.util.HashSet();
                            int i16 = 0;
                            int i17 = 0;
                            java.lang.String str2 = null;
                            while (i17 < a4.size()) {
                                java.lang.String str3 = a3.a(a4.get(i17).intValue()).h;
                                int i18 = i16;
                                if (hashSet2.add(str3)) {
                                    i5 = i17;
                                    hashSet = hashSet2;
                                    list2 = a4;
                                    i6 = i13;
                                    i7 = i12;
                                    i8 = i11;
                                    aeVar2 = a3;
                                    i16 = a(a3, iArr2, i9, str3, i11, i12, i6, list2);
                                    if (i16 > i18) {
                                        str2 = str3;
                                        i17 = i5 + 1;
                                        hashSet2 = hashSet;
                                        a4 = list2;
                                        i13 = i6;
                                        i12 = i7;
                                        i11 = i8;
                                        a3 = aeVar2;
                                    }
                                } else {
                                    i5 = i17;
                                    hashSet = hashSet2;
                                    list2 = a4;
                                    i6 = i13;
                                    i7 = i12;
                                    i8 = i11;
                                    aeVar2 = a3;
                                }
                                i16 = i18;
                                i17 = i5 + 1;
                                hashSet2 = hashSet;
                                a4 = list2;
                                i13 = i6;
                                i12 = i7;
                                i11 = i8;
                                a3 = aeVar2;
                            }
                            list = a4;
                            i2 = i13;
                            i3 = i12;
                            i4 = i11;
                            aeVar = a3;
                            str = str2;
                        }
                        b(aeVar, iArr2, i9, str, i4, i3, i2, list);
                        a2 = list.size() < 2 ? b : com.anythink.expressad.exoplayer.k.af.a(list);
                        if (a2.length <= 0) {
                            fVar = ((com.anythink.expressad.exoplayer.i.f.a) com.anythink.expressad.exoplayer.k.a.a(aVar)).a(aeVar, a2);
                            break;
                        }
                    }
                }
                aeVar = a3;
                if (a2.length <= 0) {
                }
            }
        }
        fVar = null;
        return fVar == null ? a(afVar, iArr, c0201c) : fVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0082, code lost:
    
        if (b(r2.d, r10) < 0) goto L45;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static com.anythink.expressad.exoplayer.i.f a(com.anythink.expressad.exoplayer.h.af afVar, int[][] iArr, com.anythink.expressad.exoplayer.i.c.C0201c c0201c) {
        int i;
        int i2;
        int i3;
        com.anythink.expressad.exoplayer.h.af afVar2 = afVar;
        int i4 = -1;
        int i5 = 0;
        com.anythink.expressad.exoplayer.h.ae aeVar = null;
        int i6 = 0;
        int i7 = 0;
        int i8 = -1;
        int i9 = -1;
        while (i5 < afVar2.b) {
            com.anythink.expressad.exoplayer.h.ae a2 = afVar2.a(i5);
            java.util.List<java.lang.Integer> a3 = a(a2, c0201c.j, c0201c.k, c0201c.l);
            int[] iArr2 = iArr[i5];
            int i10 = 0;
            while (i10 < a2.a) {
                if (a(iArr2[i10], c0201c.p)) {
                    com.anythink.expressad.exoplayer.m a4 = a2.a(i10);
                    boolean z = true;
                    boolean z2 = a3.contains(java.lang.Integer.valueOf(i10)) && ((i = a4.m) == i4 || i <= c0201c.f) && (((i2 = a4.n) == i4 || i2 <= c0201c.g) && ((i3 = a4.d) == i4 || i3 <= c0201c.h));
                    if (z2 || c0201c.i) {
                        int i11 = z2 ? 2 : 1;
                        boolean a5 = a(iArr2[i10], false);
                        if (a5) {
                            i11 += 1000;
                        }
                        boolean z3 = i11 > i7;
                        if (i11 == i7) {
                            if (!c0201c.m) {
                                int a6 = a4.a();
                                int b2 = a6 != i8 ? b(a6, i8) : b(a4.d, i9);
                                if (a5) {
                                }
                                z = false;
                                z3 = z;
                            }
                        }
                        if (z3) {
                            i9 = a4.d;
                            i8 = a4.a();
                            aeVar = a2;
                            i6 = i10;
                            i7 = i11;
                        }
                    }
                }
                i10++;
                i4 = -1;
            }
            i5++;
            afVar2 = afVar;
            i4 = -1;
        }
        if (aeVar == null) {
            return null;
        }
        return new com.anythink.expressad.exoplayer.i.d(aeVar, i6);
    }

    @androidx.annotation.Nullable
    private static com.anythink.expressad.exoplayer.i.f a(com.anythink.expressad.exoplayer.h.af afVar, int[][] iArr, com.anythink.expressad.exoplayer.i.c.C0201c c0201c, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.i.f.a aVar) {
        int[] iArr2;
        int a2;
        com.anythink.expressad.exoplayer.i.c.b bVar = null;
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < afVar.b; i3++) {
            com.anythink.expressad.exoplayer.h.ae a3 = afVar.a(i3);
            int[] iArr3 = iArr[i3];
            for (int i4 = 0; i4 < a3.a; i4++) {
                if (a(iArr3[i4], c0201c.p)) {
                    com.anythink.expressad.exoplayer.i.c.b bVar2 = new com.anythink.expressad.exoplayer.i.c.b(a3.a(i4), c0201c, iArr3[i4]);
                    if (bVar == null || bVar2.compareTo(bVar) > 0) {
                        i = i3;
                        i2 = i4;
                        bVar = bVar2;
                    }
                }
            }
        }
        if (i == -1) {
            return null;
        }
        com.anythink.expressad.exoplayer.h.ae a4 = afVar.a(i);
        if (!c0201c.m && aVar != null) {
            int[] iArr4 = iArr[i];
            boolean z = c0201c.n;
            java.util.HashSet hashSet = new java.util.HashSet();
            com.anythink.expressad.exoplayer.i.c.a aVar2 = null;
            int i5 = 0;
            for (int i6 = 0; i6 < a4.a; i6++) {
                com.anythink.expressad.exoplayer.m a5 = a4.a(i6);
                com.anythink.expressad.exoplayer.i.c.a aVar3 = new com.anythink.expressad.exoplayer.i.c.a(a5.u, a5.v, z ? null : a5.h);
                if (hashSet.add(aVar3) && (a2 = a(a4, iArr4, aVar3)) > i5) {
                    i5 = a2;
                    aVar2 = aVar3;
                }
            }
            if (i5 > 1) {
                iArr2 = new int[i5];
                int i7 = 0;
                for (int i8 = 0; i8 < a4.a; i8++) {
                    if (a(a4.a(i8), iArr4[i8], (com.anythink.expressad.exoplayer.i.c.a) com.anythink.expressad.exoplayer.k.a.a(aVar2))) {
                        iArr2[i7] = i8;
                        i7++;
                    }
                }
            } else {
                iArr2 = b;
            }
            if (iArr2.length > 0) {
                return aVar.a(a4, iArr2);
            }
        }
        return new com.anythink.expressad.exoplayer.i.d(a4, i2);
    }

    private static java.util.List<java.lang.Integer> a(com.anythink.expressad.exoplayer.h.ae aeVar, int i, int i2, boolean z) {
        int i3;
        java.util.ArrayList arrayList = new java.util.ArrayList(aeVar.a);
        for (int i4 = 0; i4 < aeVar.a; i4++) {
            arrayList.add(java.lang.Integer.valueOf(i4));
        }
        if (i != Integer.MAX_VALUE && i2 != Integer.MAX_VALUE) {
            int i5 = Integer.MAX_VALUE;
            for (int i6 = 0; i6 < aeVar.a; i6++) {
                com.anythink.expressad.exoplayer.m a2 = aeVar.a(i6);
                int i7 = a2.m;
                if (i7 > 0 && (i3 = a2.n) > 0) {
                    android.graphics.Point a3 = a(z, i, i2, i7, i3);
                    int i8 = a2.m;
                    int i9 = a2.n;
                    int i10 = i8 * i9;
                    if (i8 >= ((int) (a3.x * a)) && i9 >= ((int) (a3.y * a)) && i10 < i5) {
                        i5 = i10;
                    }
                }
            }
            if (i5 != Integer.MAX_VALUE) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    int a4 = aeVar.a(((java.lang.Integer) arrayList.get(size)).intValue()).a();
                    if (a4 == -1 || a4 > i5) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }

    @java.lang.Deprecated
    private void a(int i, com.anythink.expressad.exoplayer.h.af afVar, com.anythink.expressad.exoplayer.i.c.e eVar) {
        a(d().a(i, afVar, eVar));
    }

    private void a(com.anythink.expressad.exoplayer.i.c.C0201c c0201c) {
        com.anythink.expressad.exoplayer.k.a.a(c0201c);
        if (this.e.getAndSet(c0201c).equals(c0201c)) {
            return;
        }
        b();
    }

    private void a(com.anythink.expressad.exoplayer.i.c.d dVar) {
        com.anythink.expressad.exoplayer.i.c.C0201c b2 = dVar.b();
        com.anythink.expressad.exoplayer.k.a.a(b2);
        if (this.e.getAndSet(b2).equals(b2)) {
            return;
        }
        b();
    }

    private static void a(com.anythink.expressad.exoplayer.i.e.a aVar, int[][][] iArr, com.anythink.expressad.exoplayer.aa[] aaVarArr, com.anythink.expressad.exoplayer.i.f[] fVarArr, int i) {
        boolean z;
        boolean z2;
        if (i == 0) {
            return;
        }
        boolean z3 = false;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < aVar.a(); i4++) {
            int a2 = aVar.a(i4);
            com.anythink.expressad.exoplayer.i.f fVar = fVarArr[i4];
            if ((a2 == 1 || a2 == 2) && fVar != null) {
                int[][] iArr2 = iArr[i4];
                int a3 = aVar.b(i4).a(fVar.f());
                int i5 = 0;
                while (true) {
                    if (i5 >= fVar.g()) {
                        z2 = true;
                        break;
                    } else {
                        if ((iArr2[a3][fVar.b(i5)] & 32) != 32) {
                            z2 = false;
                            break;
                        }
                        i5++;
                    }
                }
                if (!z2) {
                    continue;
                } else if (a2 == 1) {
                    if (i3 != -1) {
                        z = false;
                        break;
                    }
                    i3 = i4;
                } else {
                    if (i2 != -1) {
                        z = false;
                        break;
                    }
                    i2 = i4;
                }
            }
        }
        z = true;
        if (i3 != -1 && i2 != -1) {
            z3 = true;
        }
        if (z && z3) {
            com.anythink.expressad.exoplayer.aa aaVar = new com.anythink.expressad.exoplayer.aa(i);
            aaVarArr[i3] = aaVar;
            aaVarArr[i2] = aaVar;
        }
    }

    @java.lang.Deprecated
    private boolean a(int i) {
        return c().a(i);
    }

    @java.lang.Deprecated
    private boolean a(int i, com.anythink.expressad.exoplayer.h.af afVar) {
        return c().a(i, afVar);
    }

    public static boolean a(int i, boolean z) {
        int i2 = i & 7;
        if (i2 != 4) {
            return z && i2 == 3;
        }
        return true;
    }

    private static boolean a(com.anythink.expressad.exoplayer.m mVar) {
        return android.text.TextUtils.isEmpty(mVar.A) || a(mVar, "und");
    }

    private static boolean a(com.anythink.expressad.exoplayer.m mVar, int i, com.anythink.expressad.exoplayer.i.c.a aVar) {
        java.lang.String str;
        return a(i, false) && mVar.u == aVar.a && mVar.v == aVar.b && ((str = aVar.c) == null || android.text.TextUtils.equals(str, mVar.h));
    }

    public static boolean a(com.anythink.expressad.exoplayer.m mVar, @androidx.annotation.Nullable java.lang.String str) {
        return str != null && android.text.TextUtils.equals(str, com.anythink.expressad.exoplayer.k.af.b(mVar.A));
    }

    private static boolean a(com.anythink.expressad.exoplayer.m mVar, @androidx.annotation.Nullable java.lang.String str, int i, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        return a(i, false) && (i & i2) != 0 && (str == null || com.anythink.expressad.exoplayer.k.af.a((java.lang.Object) mVar.h, (java.lang.Object) str)) && (((i6 = mVar.m) == -1 || i6 <= i3) && (((i7 = mVar.n) == -1 || i7 <= i4) && ((i8 = mVar.d) == -1 || i8 <= i5)));
    }

    private static boolean a(int[][] iArr, com.anythink.expressad.exoplayer.h.af afVar, com.anythink.expressad.exoplayer.i.f fVar) {
        if (fVar == null) {
            return false;
        }
        int a2 = afVar.a(fVar.f());
        for (int i = 0; i < fVar.g(); i++) {
            if ((iArr[a2][fVar.b(i)] & 32) != 32) {
                return false;
            }
        }
        return true;
    }

    private static int[] a(com.anythink.expressad.exoplayer.h.ae aeVar, int[] iArr, boolean z) {
        int a2;
        java.util.HashSet hashSet = new java.util.HashSet();
        com.anythink.expressad.exoplayer.i.c.a aVar = null;
        int i = 0;
        for (int i2 = 0; i2 < aeVar.a; i2++) {
            com.anythink.expressad.exoplayer.m a3 = aeVar.a(i2);
            com.anythink.expressad.exoplayer.i.c.a aVar2 = new com.anythink.expressad.exoplayer.i.c.a(a3.u, a3.v, z ? null : a3.h);
            if (hashSet.add(aVar2) && (a2 = a(aeVar, iArr, aVar2)) > i) {
                i = a2;
                aVar = aVar2;
            }
        }
        if (i <= 1) {
            return b;
        }
        int[] iArr2 = new int[i];
        int i3 = 0;
        for (int i4 = 0; i4 < aeVar.a; i4++) {
            if (a(aeVar.a(i4), iArr[i4], (com.anythink.expressad.exoplayer.i.c.a) com.anythink.expressad.exoplayer.k.a.a(aVar))) {
                iArr2[i3] = i4;
                i3++;
            }
        }
        return iArr2;
    }

    private static int[] a(com.anythink.expressad.exoplayer.h.ae aeVar, int[] iArr, boolean z, int i, int i2, int i3, int i4, int i5, int i6, boolean z2) {
        java.lang.String str;
        int a2;
        if (aeVar.a < 2) {
            return b;
        }
        java.util.List<java.lang.Integer> a3 = a(aeVar, i5, i6, z2);
        if (a3.size() < 2) {
            return b;
        }
        if (z) {
            str = null;
        } else {
            java.util.HashSet hashSet = new java.util.HashSet();
            java.lang.String str2 = null;
            int i7 = 0;
            for (int i8 = 0; i8 < a3.size(); i8++) {
                java.lang.String str3 = aeVar.a(a3.get(i8).intValue()).h;
                if (hashSet.add(str3) && (a2 = a(aeVar, iArr, i, str3, i2, i3, i4, a3)) > i7) {
                    i7 = a2;
                    str2 = str3;
                }
            }
            str = str2;
        }
        b(aeVar, iArr, i, str, i2, i3, i4, a3);
        return a3.size() < 2 ? b : com.anythink.expressad.exoplayer.k.af.a(a3);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00f4 A[LOOP:1: B:19:0x003f->B:27:0x00f4, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.anythink.expressad.exoplayer.i.f[] a(com.anythink.expressad.exoplayer.i.e.a aVar, int[][][] iArr, int[] iArr2, com.anythink.expressad.exoplayer.i.c.C0201c c0201c) {
        com.anythink.expressad.exoplayer.i.e.a aVar2;
        int i;
        com.anythink.expressad.exoplayer.i.f[] fVarArr;
        int i2;
        boolean z;
        int i3;
        com.anythink.expressad.exoplayer.i.f fVar;
        boolean z2;
        java.lang.String str;
        int[] a2;
        java.util.HashSet hashSet;
        com.anythink.expressad.exoplayer.i.c cVar = this;
        com.anythink.expressad.exoplayer.i.e.a aVar3 = aVar;
        int a3 = aVar.a();
        com.anythink.expressad.exoplayer.i.f[] fVarArr2 = new com.anythink.expressad.exoplayer.i.f[a3];
        int i4 = 0;
        boolean z3 = false;
        boolean z4 = false;
        while (i4 < a3) {
            if (2 == aVar3.a(i4)) {
                if (z3) {
                    i = a3;
                    fVarArr = fVarArr2;
                    z = z4;
                    aVar2 = aVar;
                    i2 = i4;
                } else {
                    com.anythink.expressad.exoplayer.h.af b2 = aVar3.b(i4);
                    int[][] iArr3 = iArr[i4];
                    int i5 = iArr2[i4];
                    com.anythink.expressad.exoplayer.i.f.a aVar4 = cVar.d;
                    if (!c0201c.m && aVar4 != null) {
                        int i6 = c0201c.o ? 24 : 16;
                        boolean z5 = c0201c.n && (i5 & i6) != 0;
                        int i7 = 0;
                        while (i7 < b2.b) {
                            com.anythink.expressad.exoplayer.h.ae a4 = b2.a(i7);
                            int[] iArr4 = iArr3[i7];
                            int i8 = c0201c.f;
                            int i9 = c0201c.g;
                            int i10 = c0201c.h;
                            i = a3;
                            int i11 = c0201c.j;
                            z = z4;
                            int i12 = c0201c.k;
                            boolean z6 = c0201c.l;
                            fVarArr = fVarArr2;
                            i3 = i4;
                            if (a4.a < 2) {
                                a2 = b;
                            } else {
                                java.util.List<java.lang.Integer> a5 = a(a4, i11, i12, z6);
                                if (a5.size() < 2) {
                                    a2 = b;
                                } else {
                                    if (z5) {
                                        z2 = z5;
                                        str = null;
                                    } else {
                                        java.util.HashSet hashSet2 = new java.util.HashSet();
                                        z2 = z5;
                                        int i13 = 0;
                                        java.lang.String str2 = null;
                                        int i14 = 0;
                                        while (i13 < a5.size()) {
                                            java.lang.String str3 = a4.a(a5.get(i13).intValue()).h;
                                            if (hashSet2.add(str3)) {
                                                hashSet = hashSet2;
                                                int a6 = a(a4, iArr4, i6, str3, i8, i9, i10, a5);
                                                if (a6 > i14) {
                                                    i14 = a6;
                                                    str2 = str3;
                                                }
                                            } else {
                                                hashSet = hashSet2;
                                            }
                                            i13++;
                                            hashSet2 = hashSet;
                                        }
                                        str = str2;
                                    }
                                    b(a4, iArr4, i6, str, i8, i9, i10, a5);
                                    a2 = a5.size() < 2 ? b : com.anythink.expressad.exoplayer.k.af.a(a5);
                                    if (a2.length <= 0) {
                                        fVar = ((com.anythink.expressad.exoplayer.i.f.a) com.anythink.expressad.exoplayer.k.a.a(aVar4)).a(a4, a2);
                                        break;
                                    }
                                    i7++;
                                    a3 = i;
                                    z4 = z;
                                    fVarArr2 = fVarArr;
                                    i4 = i3;
                                    z5 = z2;
                                }
                            }
                            z2 = z5;
                            if (a2.length <= 0) {
                            }
                        }
                    }
                    i = a3;
                    fVarArr = fVarArr2;
                    i3 = i4;
                    z = z4;
                    fVar = null;
                    if (fVar == null) {
                        fVar = a(b2, iArr3, c0201c);
                    }
                    fVarArr[i3] = fVar;
                    z3 = fVar != null;
                    i2 = i3;
                    aVar2 = aVar;
                }
                z4 = z | (aVar2.b(i2).b > 0);
            } else {
                aVar2 = aVar3;
                i = a3;
                fVarArr = fVarArr2;
                i2 = i4;
            }
            i4 = i2 + 1;
            aVar3 = aVar2;
            a3 = i;
            fVarArr2 = fVarArr;
            cVar = this;
        }
        com.anythink.expressad.exoplayer.i.e.a aVar5 = aVar3;
        com.anythink.expressad.exoplayer.i.f[] fVarArr3 = fVarArr2;
        boolean z7 = z4;
        int i15 = a3;
        boolean z8 = false;
        boolean z9 = false;
        for (int i16 = 0; i16 < i15; i16++) {
            int a7 = aVar5.a(i16);
            if (a7 != 1) {
                if (a7 != 2) {
                    if (a7 != 3) {
                        fVarArr3[i16] = c(aVar5.b(i16), iArr[i16], c0201c);
                    } else if (!z9) {
                        com.anythink.expressad.exoplayer.i.f b3 = b(aVar5.b(i16), iArr[i16], c0201c);
                        fVarArr3[i16] = b3;
                        z9 = b3 != null;
                    }
                }
            } else if (!z8) {
                com.anythink.expressad.exoplayer.i.f a8 = a(aVar5.b(i16), iArr[i16], c0201c, z7 ? null : this.d);
                fVarArr3[i16] = a8;
                z8 = a8 != null;
            }
        }
        return fVarArr3;
    }

    private static int b(int i, int i2) {
        if (i == -1) {
            return i2 == -1 ? 0 : -1;
        }
        if (i2 == -1) {
            return 1;
        }
        return i - i2;
    }

    @androidx.annotation.Nullable
    @java.lang.Deprecated
    private com.anythink.expressad.exoplayer.i.c.e b(int i, com.anythink.expressad.exoplayer.h.af afVar) {
        return c().b(i, afVar);
    }

    @androidx.annotation.Nullable
    private static com.anythink.expressad.exoplayer.i.f b(com.anythink.expressad.exoplayer.h.af afVar, int[][] iArr, int i, com.anythink.expressad.exoplayer.i.c.C0201c c0201c, com.anythink.expressad.exoplayer.i.f.a aVar) {
        java.util.List<java.lang.Integer> list;
        int i2;
        int i3;
        int i4;
        java.lang.String str;
        int[] a2;
        int i5;
        int i6;
        java.util.HashSet hashSet;
        java.util.List<java.lang.Integer> list2;
        int i7;
        int i8;
        int i9;
        int i10 = c0201c.o ? 24 : 16;
        boolean z = c0201c.n && (i & i10) != 0;
        for (int i11 = 0; i11 < afVar.b; i11++) {
            com.anythink.expressad.exoplayer.h.ae a3 = afVar.a(i11);
            int[] iArr2 = iArr[i11];
            int i12 = c0201c.f;
            int i13 = c0201c.g;
            int i14 = c0201c.h;
            int i15 = c0201c.j;
            int i16 = c0201c.k;
            boolean z2 = c0201c.l;
            if (a3.a < 2) {
                a2 = b;
            } else {
                java.util.List<java.lang.Integer> a4 = a(a3, i15, i16, z2);
                if (a4.size() < 2) {
                    a2 = b;
                } else {
                    if (z) {
                        list = a4;
                        i2 = i14;
                        i3 = i13;
                        i4 = i12;
                        str = null;
                    } else {
                        java.util.HashSet hashSet2 = new java.util.HashSet();
                        java.lang.String str2 = null;
                        int i17 = 0;
                        int i18 = 0;
                        while (i18 < a4.size()) {
                            java.lang.String str3 = a3.a(a4.get(i18).intValue()).h;
                            if (hashSet2.add(str3)) {
                                i5 = i17;
                                i6 = i18;
                                hashSet = hashSet2;
                                list2 = a4;
                                i7 = i14;
                                i8 = i13;
                                i9 = i12;
                                i17 = a(a3, iArr2, i10, str3, i12, i13, i7, list2);
                                if (i17 > i5) {
                                    str2 = str3;
                                    i18 = i6 + 1;
                                    hashSet2 = hashSet;
                                    a4 = list2;
                                    i14 = i7;
                                    i13 = i8;
                                    i12 = i9;
                                }
                            } else {
                                i5 = i17;
                                i6 = i18;
                                hashSet = hashSet2;
                                list2 = a4;
                                i7 = i14;
                                i8 = i13;
                                i9 = i12;
                            }
                            i17 = i5;
                            i18 = i6 + 1;
                            hashSet2 = hashSet;
                            a4 = list2;
                            i14 = i7;
                            i13 = i8;
                            i12 = i9;
                        }
                        list = a4;
                        i2 = i14;
                        i3 = i13;
                        i4 = i12;
                        str = str2;
                    }
                    b(a3, iArr2, i10, str, i4, i3, i2, list);
                    a2 = list.size() < 2 ? b : com.anythink.expressad.exoplayer.k.af.a(list);
                }
            }
            if (a2.length > 0) {
                return ((com.anythink.expressad.exoplayer.i.f.a) com.anythink.expressad.exoplayer.k.a.a(aVar)).a(a3, a2);
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005b, code lost:
    
        if ((android.text.TextUtils.isEmpty(r11.A) || a(r11, "und")) != false) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008b A[SYNTHETIC] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static com.anythink.expressad.exoplayer.i.f b(com.anythink.expressad.exoplayer.h.af afVar, int[][] iArr, com.anythink.expressad.exoplayer.i.c.C0201c c0201c) {
        int i;
        com.anythink.expressad.exoplayer.h.ae aeVar = null;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < afVar.b; i4++) {
            com.anythink.expressad.exoplayer.h.ae a2 = afVar.a(i4);
            int[] iArr2 = iArr[i4];
            for (int i5 = 0; i5 < a2.a; i5++) {
                if (a(iArr2[i5], c0201c.p)) {
                    com.anythink.expressad.exoplayer.m a3 = a2.a(i5);
                    int i6 = a3.z & (~c0201c.e);
                    boolean z = (i6 & 1) != 0;
                    boolean z2 = (i6 & 2) != 0;
                    boolean a4 = a(a3, c0201c.c);
                    if (!a4) {
                        if (c0201c.d) {
                        }
                        if (z) {
                            i = 3;
                        } else if (z2) {
                            i = a(a3, c0201c.b) ? 2 : 1;
                        }
                        if (a(iArr2[i5], false)) {
                            i += 1000;
                        }
                        if (i <= i3) {
                            aeVar = a2;
                            i2 = i5;
                            i3 = i;
                        }
                    }
                    i = (z ? 8 : !z2 ? 6 : 4) + (a4 ? 1 : 0);
                    if (a(iArr2[i5], false)) {
                    }
                    if (i <= i3) {
                    }
                }
            }
        }
        if (aeVar == null) {
            return null;
        }
        return new com.anythink.expressad.exoplayer.i.d(aeVar, i2);
    }

    @java.lang.Deprecated
    private void b(int i) {
        a(d().a(i));
    }

    @java.lang.Deprecated
    private void b(int i, boolean z) {
        a(d().a(i, z));
    }

    private static void b(com.anythink.expressad.exoplayer.h.ae aeVar, int[] iArr, int i, @androidx.annotation.Nullable java.lang.String str, int i2, int i3, int i4, java.util.List<java.lang.Integer> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = list.get(size).intValue();
            if (!a(aeVar.a(intValue), str, iArr[intValue], i, i2, i3, i4)) {
                list.remove(size);
            }
        }
    }

    private static int c(int i, int i2) {
        if (i > i2) {
            return 1;
        }
        return i2 > i ? -1 : 0;
    }

    private com.anythink.expressad.exoplayer.i.c.C0201c c() {
        return this.e.get();
    }

    @androidx.annotation.Nullable
    private static com.anythink.expressad.exoplayer.i.f c(com.anythink.expressad.exoplayer.h.af afVar, int[][] iArr, com.anythink.expressad.exoplayer.i.c.C0201c c0201c) {
        com.anythink.expressad.exoplayer.h.ae aeVar = null;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < afVar.b; i3++) {
            com.anythink.expressad.exoplayer.h.ae a2 = afVar.a(i3);
            int[] iArr2 = iArr[i3];
            for (int i4 = 0; i4 < a2.a; i4++) {
                if (a(iArr2[i4], c0201c.p)) {
                    int i5 = (a2.a(i4).z & 1) != 0 ? 2 : 1;
                    if (a(iArr2[i4], false)) {
                        i5 += 1000;
                    }
                    if (i5 > i2) {
                        aeVar = a2;
                        i = i4;
                        i2 = i5;
                    }
                }
            }
        }
        if (aeVar == null) {
            return null;
        }
        return new com.anythink.expressad.exoplayer.i.d(aeVar, i);
    }

    @java.lang.Deprecated
    private void c(int i) {
        a(d().b(i));
    }

    @java.lang.Deprecated
    private void c(int i, com.anythink.expressad.exoplayer.h.af afVar) {
        a(d().a(i, afVar));
    }

    private com.anythink.expressad.exoplayer.i.c.d d() {
        return new com.anythink.expressad.exoplayer.i.c.d(c(), (byte) 0);
    }

    @java.lang.Deprecated
    private void e() {
        a(d().a());
    }

    @Override // com.anythink.expressad.exoplayer.i.e
    public final android.util.Pair<com.anythink.expressad.exoplayer.aa[], com.anythink.expressad.exoplayer.i.f[]> a(com.anythink.expressad.exoplayer.i.e.a aVar, int[][][] iArr, int[] iArr2) {
        com.anythink.expressad.exoplayer.i.e.a aVar2;
        int i;
        int i2;
        com.anythink.expressad.exoplayer.i.f[] fVarArr;
        int i3;
        boolean z;
        int i4;
        com.anythink.expressad.exoplayer.i.f fVar;
        java.lang.String str;
        int[] a2;
        java.util.HashSet hashSet;
        com.anythink.expressad.exoplayer.i.c cVar = this;
        com.anythink.expressad.exoplayer.i.e.a aVar3 = aVar;
        int[][][] iArr3 = iArr;
        com.anythink.expressad.exoplayer.i.c.C0201c c0201c = cVar.e.get();
        int a3 = aVar.a();
        int a4 = aVar.a();
        com.anythink.expressad.exoplayer.i.f[] fVarArr2 = new com.anythink.expressad.exoplayer.i.f[a4];
        int i5 = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (i5 < a4) {
            if (2 == aVar3.a(i5)) {
                if (z2) {
                    i = a3;
                    i2 = a4;
                    fVarArr = fVarArr2;
                    z = z3;
                    aVar2 = aVar;
                    i3 = i5;
                } else {
                    com.anythink.expressad.exoplayer.h.af b2 = aVar3.b(i5);
                    int[][] iArr4 = iArr3[i5];
                    int i6 = iArr2[i5];
                    com.anythink.expressad.exoplayer.i.f.a aVar4 = cVar.d;
                    if (!c0201c.m && aVar4 != null) {
                        int i7 = c0201c.o ? 24 : 16;
                        boolean z4 = c0201c.n && (i6 & i7) != 0;
                        int i8 = 0;
                        while (i8 < b2.b) {
                            com.anythink.expressad.exoplayer.h.ae a5 = b2.a(i8);
                            int[] iArr5 = iArr4[i8];
                            i = a3;
                            int i9 = c0201c.f;
                            int i10 = c0201c.g;
                            int i11 = c0201c.h;
                            i2 = a4;
                            int i12 = c0201c.j;
                            z = z3;
                            int i13 = c0201c.k;
                            boolean z5 = c0201c.l;
                            fVarArr = fVarArr2;
                            i4 = i5;
                            if (a5.a < 2) {
                                a2 = b;
                            } else {
                                java.util.List<java.lang.Integer> a6 = a(a5, i12, i13, z5);
                                if (a6.size() < 2) {
                                    a2 = b;
                                } else {
                                    if (z4) {
                                        str = null;
                                    } else {
                                        java.util.HashSet hashSet2 = new java.util.HashSet();
                                        int i14 = 0;
                                        int i15 = 0;
                                        java.lang.String str2 = null;
                                        while (i14 < a6.size()) {
                                            java.lang.String str3 = a5.a(a6.get(i14).intValue()).h;
                                            if (hashSet2.add(str3)) {
                                                hashSet = hashSet2;
                                                int a7 = a(a5, iArr5, i7, str3, i9, i10, i11, a6);
                                                if (a7 > i15) {
                                                    i15 = a7;
                                                    str2 = str3;
                                                }
                                            } else {
                                                hashSet = hashSet2;
                                            }
                                            i14++;
                                            hashSet2 = hashSet;
                                        }
                                        str = str2;
                                    }
                                    b(a5, iArr5, i7, str, i9, i10, i11, a6);
                                    a2 = a6.size() < 2 ? b : com.anythink.expressad.exoplayer.k.af.a(a6);
                                }
                            }
                            if (a2.length > 0) {
                                fVar = ((com.anythink.expressad.exoplayer.i.f.a) com.anythink.expressad.exoplayer.k.a.a(aVar4)).a(a5, a2);
                                break;
                            }
                            i8++;
                            a3 = i;
                            a4 = i2;
                            z3 = z;
                            fVarArr2 = fVarArr;
                            i5 = i4;
                        }
                    }
                    i = a3;
                    i2 = a4;
                    fVarArr = fVarArr2;
                    i4 = i5;
                    z = z3;
                    fVar = null;
                    if (fVar == null) {
                        fVar = a(b2, iArr4, c0201c);
                    }
                    fVarArr[i4] = fVar;
                    z2 = fVar != null;
                    i3 = i4;
                    aVar2 = aVar;
                }
                z3 = z | (aVar2.b(i3).b > 0);
            } else {
                aVar2 = aVar3;
                i = a3;
                i2 = a4;
                fVarArr = fVarArr2;
                i3 = i5;
            }
            i5 = i3 + 1;
            iArr3 = iArr;
            aVar3 = aVar2;
            a3 = i;
            a4 = i2;
            fVarArr2 = fVarArr;
            cVar = this;
        }
        com.anythink.expressad.exoplayer.i.e.a aVar5 = aVar3;
        int i16 = a3;
        com.anythink.expressad.exoplayer.i.f[] fVarArr3 = fVarArr2;
        boolean z6 = z3;
        int i17 = a4;
        boolean z7 = false;
        boolean z8 = false;
        for (int i18 = 0; i18 < i17; i18++) {
            int a8 = aVar5.a(i18);
            if (a8 != 1) {
                if (a8 != 2) {
                    if (a8 != 3) {
                        fVarArr3[i18] = c(aVar5.b(i18), iArr[i18], c0201c);
                    } else if (!z8) {
                        com.anythink.expressad.exoplayer.i.f b3 = b(aVar5.b(i18), iArr[i18], c0201c);
                        fVarArr3[i18] = b3;
                        z8 = b3 != null;
                    }
                }
            } else if (!z7) {
                com.anythink.expressad.exoplayer.i.f a9 = a(aVar5.b(i18), iArr[i18], c0201c, z6 ? null : this.d);
                fVarArr3[i18] = a9;
                z7 = a9 != null;
            }
        }
        for (int i19 = 0; i19 < i16; i19++) {
            if (c0201c.a(i19)) {
                fVarArr3[i19] = null;
            } else {
                com.anythink.expressad.exoplayer.h.af b4 = aVar5.b(i19);
                if (c0201c.a(i19, b4)) {
                    com.anythink.expressad.exoplayer.i.c.e b5 = c0201c.b(i19, b4);
                    if (b5 == null) {
                        fVarArr3[i19] = null;
                    } else {
                        if (b5.c == 1) {
                            fVarArr3[i19] = new com.anythink.expressad.exoplayer.i.d(b4.a(b5.a), b5.b[0]);
                        } else {
                            fVarArr3[i19] = ((com.anythink.expressad.exoplayer.i.f.a) com.anythink.expressad.exoplayer.k.a.a(this.d)).a(b4.a(b5.a), b5.b);
                        }
                    }
                }
            }
        }
        com.anythink.expressad.exoplayer.aa[] aaVarArr = new com.anythink.expressad.exoplayer.aa[i16];
        for (int i20 = 0; i20 < i16; i20++) {
            aaVarArr[i20] = !c0201c.a(i20) && (aVar5.a(i20) == 5 || fVarArr3[i20] != null) ? com.anythink.expressad.exoplayer.aa.a : null;
        }
        a(aVar5, iArr, aaVarArr, fVarArr3, c0201c.q);
        return android.util.Pair.create(aaVarArr, fVarArr3);
    }
}
