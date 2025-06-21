package com.anythink.expressad.exoplayer.d;

/* loaded from: classes12.dex */
public final class e implements android.os.Parcelable, java.util.Comparator<com.anythink.expressad.exoplayer.d.e.a> {
    public static final android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.d.e> CREATOR = new com.anythink.expressad.exoplayer.d.e.AnonymousClass1();

    @androidx.annotation.Nullable
    public final java.lang.String a;
    public final int b;
    private final com.anythink.expressad.exoplayer.d.e.a[] c;
    private int d;

    /* renamed from: com.anythink.expressad.exoplayer.d.e$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.d.e> {
        private static com.anythink.expressad.exoplayer.d.e a(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.d.e(parcel);
        }

        private static com.anythink.expressad.exoplayer.d.e[] a(int i) {
            return new com.anythink.expressad.exoplayer.d.e[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.anythink.expressad.exoplayer.d.e createFromParcel(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.d.e(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.anythink.expressad.exoplayer.d.e[] newArray(int i) {
            return new com.anythink.expressad.exoplayer.d.e[i];
        }
    }

    public static final class a implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.d.e.a> CREATOR = new com.anythink.expressad.exoplayer.d.e.a.AnonymousClass1();

        @androidx.annotation.Nullable
        public final java.lang.String a;
        public final java.lang.String b;
        public final byte[] c;
        public final boolean d;
        private int e;
        private final java.util.UUID f;

        /* renamed from: com.anythink.expressad.exoplayer.d.e$a$1, reason: invalid class name */
        public class AnonymousClass1 implements android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.d.e.a> {
            private static com.anythink.expressad.exoplayer.d.e.a a(android.os.Parcel parcel) {
                return new com.anythink.expressad.exoplayer.d.e.a(parcel);
            }

            private static com.anythink.expressad.exoplayer.d.e.a[] a(int i) {
                return new com.anythink.expressad.exoplayer.d.e.a[i];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ com.anythink.expressad.exoplayer.d.e.a createFromParcel(android.os.Parcel parcel) {
                return new com.anythink.expressad.exoplayer.d.e.a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ com.anythink.expressad.exoplayer.d.e.a[] newArray(int i) {
                return new com.anythink.expressad.exoplayer.d.e.a[i];
            }
        }

        public a(android.os.Parcel parcel) {
            this.f = new java.util.UUID(parcel.readLong(), parcel.readLong());
            this.a = parcel.readString();
            this.b = parcel.readString();
            this.c = parcel.createByteArray();
            this.d = parcel.readByte() != 0;
        }

        private a(java.util.UUID uuid, @androidx.annotation.Nullable java.lang.String str, java.lang.String str2, byte[] bArr) {
            this.f = (java.util.UUID) com.anythink.expressad.exoplayer.k.a.a(uuid);
            this.a = str;
            this.b = (java.lang.String) com.anythink.expressad.exoplayer.k.a.a(str2);
            this.c = bArr;
            this.d = false;
        }

        public a(java.util.UUID uuid, java.lang.String str, byte[] bArr) {
            this(uuid, str, bArr, (byte) 0);
        }

        private a(java.util.UUID uuid, java.lang.String str, byte[] bArr, byte b) {
            this(uuid, (java.lang.String) null, str, bArr);
        }

        private boolean b(com.anythink.expressad.exoplayer.d.e.a aVar) {
            return a() && !aVar.a() && a(aVar.f);
        }

        public final boolean a() {
            return this.c != null;
        }

        public final boolean a(java.util.UUID uuid) {
            return com.anythink.expressad.exoplayer.b.bh.equals(this.f) || uuid.equals(this.f);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            if (!(obj instanceof com.anythink.expressad.exoplayer.d.e.a)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            com.anythink.expressad.exoplayer.d.e.a aVar = (com.anythink.expressad.exoplayer.d.e.a) obj;
            return com.anythink.expressad.exoplayer.k.af.a((java.lang.Object) this.a, (java.lang.Object) aVar.a) && com.anythink.expressad.exoplayer.k.af.a((java.lang.Object) this.b, (java.lang.Object) aVar.b) && com.anythink.expressad.exoplayer.k.af.a(this.f, aVar.f) && java.util.Arrays.equals(this.c, aVar.c);
        }

        public final int hashCode() {
            if (this.e == 0) {
                int hashCode = this.f.hashCode() * 31;
                java.lang.String str = this.a;
                this.e = ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.b.hashCode()) * 31) + java.util.Arrays.hashCode(this.c);
            }
            return this.e;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(android.os.Parcel parcel, int i) {
            parcel.writeLong(this.f.getMostSignificantBits());
            parcel.writeLong(this.f.getLeastSignificantBits());
            parcel.writeString(this.a);
            parcel.writeString(this.b);
            parcel.writeByteArray(this.c);
            parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
        }
    }

    public e(android.os.Parcel parcel) {
        this.a = parcel.readString();
        com.anythink.expressad.exoplayer.d.e.a[] aVarArr = (com.anythink.expressad.exoplayer.d.e.a[]) parcel.createTypedArray(com.anythink.expressad.exoplayer.d.e.a.CREATOR);
        this.c = aVarArr;
        this.b = aVarArr.length;
    }

    private e(java.lang.String str, java.util.List<com.anythink.expressad.exoplayer.d.e.a> list) {
        this(str, false, (com.anythink.expressad.exoplayer.d.e.a[]) list.toArray(new com.anythink.expressad.exoplayer.d.e.a[list.size()]));
    }

    private e(@androidx.annotation.Nullable java.lang.String str, boolean z, com.anythink.expressad.exoplayer.d.e.a... aVarArr) {
        this.a = str;
        aVarArr = z ? (com.anythink.expressad.exoplayer.d.e.a[]) aVarArr.clone() : aVarArr;
        java.util.Arrays.sort(aVarArr, this);
        this.c = aVarArr;
        this.b = aVarArr.length;
    }

    private e(@androidx.annotation.Nullable java.lang.String str, com.anythink.expressad.exoplayer.d.e.a... aVarArr) {
        this(str, true, aVarArr);
    }

    public e(java.util.List<com.anythink.expressad.exoplayer.d.e.a> list) {
        this(null, false, (com.anythink.expressad.exoplayer.d.e.a[]) list.toArray(new com.anythink.expressad.exoplayer.d.e.a[list.size()]));
    }

    private e(com.anythink.expressad.exoplayer.d.e.a... aVarArr) {
        this((java.lang.String) null, aVarArr);
    }

    private static int a(com.anythink.expressad.exoplayer.d.e.a aVar, com.anythink.expressad.exoplayer.d.e.a aVar2) {
        java.util.UUID uuid = com.anythink.expressad.exoplayer.b.bh;
        return uuid.equals(aVar.f) ? uuid.equals(aVar2.f) ? 0 : 1 : aVar.f.compareTo(aVar2.f);
    }

    @java.lang.Deprecated
    private com.anythink.expressad.exoplayer.d.e.a a(java.util.UUID uuid) {
        for (com.anythink.expressad.exoplayer.d.e.a aVar : this.c) {
            if (aVar.a(uuid)) {
                return aVar;
            }
        }
        return null;
    }

    @androidx.annotation.Nullable
    public static com.anythink.expressad.exoplayer.d.e a(@androidx.annotation.Nullable com.anythink.expressad.exoplayer.d.e eVar, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.d.e eVar2) {
        java.lang.String str;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (eVar != null) {
            str = eVar.a;
            for (com.anythink.expressad.exoplayer.d.e.a aVar : eVar.c) {
                if (aVar.a()) {
                    arrayList.add(aVar);
                }
            }
        } else {
            str = null;
        }
        if (eVar2 != null) {
            if (str == null) {
                str = eVar2.a;
            }
            int size = arrayList.size();
            for (com.anythink.expressad.exoplayer.d.e.a aVar2 : eVar2.c) {
                if (aVar2.a() && !a(arrayList, size, aVar2.f)) {
                    arrayList.add(aVar2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new com.anythink.expressad.exoplayer.d.e(str, arrayList);
    }

    private static boolean a(java.util.ArrayList<com.anythink.expressad.exoplayer.d.e.a> arrayList, int i, java.util.UUID uuid) {
        for (int i2 = 0; i2 < i; i2++) {
            if (arrayList.get(i2).f.equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    public final com.anythink.expressad.exoplayer.d.e.a a(int i) {
        return this.c[i];
    }

    public final com.anythink.expressad.exoplayer.d.e a(@androidx.annotation.Nullable java.lang.String str) {
        return com.anythink.expressad.exoplayer.k.af.a((java.lang.Object) this.a, (java.lang.Object) str) ? this : new com.anythink.expressad.exoplayer.d.e(str, false, this.c);
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(com.anythink.expressad.exoplayer.d.e.a aVar, com.anythink.expressad.exoplayer.d.e.a aVar2) {
        com.anythink.expressad.exoplayer.d.e.a aVar3 = aVar;
        com.anythink.expressad.exoplayer.d.e.a aVar4 = aVar2;
        java.util.UUID uuid = com.anythink.expressad.exoplayer.b.bh;
        return uuid.equals(aVar3.f) ? uuid.equals(aVar4.f) ? 0 : 1 : aVar3.f.compareTo(aVar4.f);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && com.anythink.expressad.exoplayer.d.e.class == obj.getClass()) {
            com.anythink.expressad.exoplayer.d.e eVar = (com.anythink.expressad.exoplayer.d.e) obj;
            if (com.anythink.expressad.exoplayer.k.af.a((java.lang.Object) this.a, (java.lang.Object) eVar.a) && java.util.Arrays.equals(this.c, eVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.d == 0) {
            java.lang.String str = this.a;
            this.d = ((str == null ? 0 : str.hashCode()) * 31) + java.util.Arrays.hashCode(this.c);
        }
        return this.d;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeTypedArray(this.c, 0);
    }
}
