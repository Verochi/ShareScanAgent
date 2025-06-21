package com.getui.gtc.dyc.b;

/* loaded from: classes22.dex */
public class b implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.getui.gtc.dyc.b.b> CREATOR = new com.getui.gtc.dyc.b.b.AnonymousClass1();
    public static final java.lang.String a = "sdkconfig";
    private java.lang.String b;
    private java.lang.String c;
    private java.lang.String d;
    private java.lang.String e;
    private java.lang.String f;
    private java.lang.String g;
    private java.lang.String h;
    private long i;
    private com.getui.gtc.dyc.b.c j;

    /* renamed from: com.getui.gtc.dyc.b.b$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.getui.gtc.dyc.b.b> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final com.getui.gtc.dyc.b.b createFromParcel(android.os.Parcel parcel) {
            return new com.getui.gtc.dyc.b.b(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final com.getui.gtc.dyc.b.b[] newArray(int i) {
            return new com.getui.gtc.dyc.b.b[i];
        }
    }

    public static class a {
        private java.lang.String a;
        private java.lang.String b;
        private java.lang.String c;
        private java.lang.String e;
        private java.lang.String f;
        private com.getui.gtc.dyc.b.c h;
        private java.lang.String d = "sdkconfig";
        private long g = com.heytap.mcssdk.constant.a.g;

        public com.getui.gtc.dyc.b.b.a a(java.lang.String str) {
            this.a = str;
            return this;
        }

        public com.getui.gtc.dyc.b.b.a b(java.lang.String str) {
            this.b = str;
            return this;
        }

        public com.getui.gtc.dyc.b.b.a c(java.lang.String str) {
            this.c = str;
            return this;
        }

        public com.getui.gtc.dyc.b.b.a d(java.lang.String str) {
            this.e = str;
            return this;
        }

        public com.getui.gtc.dyc.b.b.a e(java.lang.String str) {
            this.d = str;
            return this;
        }

        public com.getui.gtc.dyc.b.b.a f(java.lang.String str) {
            this.f = str;
            return this;
        }

        public com.getui.gtc.dyc.b.b.a g(long j) {
            this.g = j;
            return this;
        }

        public com.getui.gtc.dyc.b.b.a h(com.getui.gtc.dyc.b.c cVar) {
            this.h = cVar;
            return this;
        }

        public com.getui.gtc.dyc.b.b i() {
            return new com.getui.gtc.dyc.b.b(this, null);
        }
    }

    public b(android.os.Parcel parcel) {
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.h = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.e = parcel.readString();
        this.i = parcel.readLong();
    }

    private b(com.getui.gtc.dyc.b.b.a aVar) {
        this.b = aVar.a;
        this.c = aVar.b;
        this.d = aVar.c;
        this.e = aVar.d;
        this.f = aVar.e;
        this.h = aVar.f;
        this.i = aVar.g;
        this.j = aVar.h;
    }

    public /* synthetic */ b(com.getui.gtc.dyc.b.b.a aVar, com.getui.gtc.dyc.b.b.AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    public java.lang.String a() {
        return this.b;
    }

    public void a(java.lang.String str) {
        this.b = str;
    }

    public java.lang.String b() {
        return this.c;
    }

    public void b(java.lang.String str) {
        this.c = str;
    }

    public java.lang.String c() {
        return this.d;
    }

    public void c(java.lang.String str) {
        this.d = str;
    }

    public java.lang.String d() {
        return this.e;
    }

    public void d(java.lang.String str) {
        this.e = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String e() {
        return this.f;
    }

    public void e(java.lang.String str) {
        this.f = str;
    }

    public java.lang.String f() {
        return this.g;
    }

    public void f(java.lang.String str) {
        this.g = str;
    }

    public java.lang.String g() {
        return this.h;
    }

    public void g(java.lang.String str) {
        this.h = str;
    }

    public long h() {
        return this.i;
    }

    public void h(long j) {
        this.i = j;
    }

    public com.getui.gtc.dyc.b.c i() {
        return this.j;
    }

    public void i(com.getui.gtc.dyc.b.c cVar) {
        this.j = cVar;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.h);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.e);
        parcel.writeLong(this.i);
    }
}
