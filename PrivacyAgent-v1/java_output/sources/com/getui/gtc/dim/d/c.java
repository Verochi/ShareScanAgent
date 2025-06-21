package com.getui.gtc.dim.d;

/* loaded from: classes22.dex */
public class c implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.getui.gtc.dim.d.c> CREATOR = new com.getui.gtc.dim.d.c.AnonymousClass1();
    private java.lang.String parcelableClass;
    private java.util.List<android.os.Parcelable> parcelables;

    /* renamed from: com.getui.gtc.dim.d.c$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.getui.gtc.dim.d.c> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.getui.gtc.dim.d.c createFromParcel(android.os.Parcel parcel) {
            return new com.getui.gtc.dim.d.c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.getui.gtc.dim.d.c[] newArray(int i) {
            return new com.getui.gtc.dim.d.c[i];
        }
    }

    public c(android.os.Parcel parcel) {
        try {
            java.lang.String readString = parcel.readString();
            this.parcelableClass = readString;
            java.lang.reflect.Field declaredField = java.lang.Class.forName(readString).getDeclaredField("CREATOR");
            declaredField.setAccessible(true);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            this.parcelables = arrayList;
            parcel.readTypedList(arrayList, (android.os.Parcelable.Creator) declaredField.get(null));
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
        }
    }

    public c(java.util.List<android.os.Parcelable> list) {
        try {
            this.parcelables = list;
            this.parcelableClass = list.get(0).getClass().getName();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.util.List<android.os.Parcelable> getParcelables() {
        return this.parcelables;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.parcelableClass);
        parcel.writeTypedList(this.parcelables);
    }
}
