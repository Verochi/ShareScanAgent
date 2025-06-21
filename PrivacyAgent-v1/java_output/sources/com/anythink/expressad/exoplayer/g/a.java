package com.anythink.expressad.exoplayer.g;

/* loaded from: classes12.dex */
public final class a implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.g.a> CREATOR = new com.anythink.expressad.exoplayer.g.a.AnonymousClass1();
    private final com.anythink.expressad.exoplayer.g.a.InterfaceC0194a[] a;

    /* renamed from: com.anythink.expressad.exoplayer.g.a$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.anythink.expressad.exoplayer.g.a> {
        private static com.anythink.expressad.exoplayer.g.a a(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.a(parcel);
        }

        private static com.anythink.expressad.exoplayer.g.a[] a() {
            return new com.anythink.expressad.exoplayer.g.a[0];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.anythink.expressad.exoplayer.g.a createFromParcel(android.os.Parcel parcel) {
            return new com.anythink.expressad.exoplayer.g.a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.anythink.expressad.exoplayer.g.a[] newArray(int i) {
            return new com.anythink.expressad.exoplayer.g.a[0];
        }
    }

    /* renamed from: com.anythink.expressad.exoplayer.g.a$a, reason: collision with other inner class name */
    public interface InterfaceC0194a extends android.os.Parcelable {
    }

    public a(android.os.Parcel parcel) {
        this.a = new com.anythink.expressad.exoplayer.g.a.InterfaceC0194a[parcel.readInt()];
        int i = 0;
        while (true) {
            com.anythink.expressad.exoplayer.g.a.InterfaceC0194a[] interfaceC0194aArr = this.a;
            if (i >= interfaceC0194aArr.length) {
                return;
            }
            interfaceC0194aArr[i] = (com.anythink.expressad.exoplayer.g.a.InterfaceC0194a) parcel.readParcelable(com.anythink.expressad.exoplayer.g.a.InterfaceC0194a.class.getClassLoader());
            i++;
        }
    }

    public a(java.util.List<? extends com.anythink.expressad.exoplayer.g.a.InterfaceC0194a> list) {
        com.anythink.expressad.exoplayer.g.a.InterfaceC0194a[] interfaceC0194aArr = new com.anythink.expressad.exoplayer.g.a.InterfaceC0194a[list.size()];
        this.a = interfaceC0194aArr;
        list.toArray(interfaceC0194aArr);
    }

    public a(com.anythink.expressad.exoplayer.g.a.InterfaceC0194a... interfaceC0194aArr) {
        this.a = interfaceC0194aArr;
    }

    public final int a() {
        return this.a.length;
    }

    public final com.anythink.expressad.exoplayer.g.a.InterfaceC0194a a(int i) {
        return this.a[i];
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.anythink.expressad.exoplayer.g.a.class != obj.getClass()) {
            return false;
        }
        return java.util.Arrays.equals(this.a, ((com.anythink.expressad.exoplayer.g.a) obj).a);
    }

    public final int hashCode() {
        return java.util.Arrays.hashCode(this.a);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.a.length);
        for (com.anythink.expressad.exoplayer.g.a.InterfaceC0194a interfaceC0194a : this.a) {
            parcel.writeParcelable(interfaceC0194a, 0);
        }
    }
}
