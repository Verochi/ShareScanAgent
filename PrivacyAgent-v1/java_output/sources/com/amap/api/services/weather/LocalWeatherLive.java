package com.amap.api.services.weather;

/* loaded from: classes12.dex */
public class LocalWeatherLive implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.weather.LocalWeatherLive> CREATOR = new com.amap.api.services.weather.LocalWeatherLive.AnonymousClass1();
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.String c;
    private java.lang.String d;
    private java.lang.String e;
    private java.lang.String f;
    private java.lang.String g;
    private java.lang.String h;
    private java.lang.String i;

    /* renamed from: com.amap.api.services.weather.LocalWeatherLive$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.weather.LocalWeatherLive> {
        private static com.amap.api.services.weather.LocalWeatherLive a(android.os.Parcel parcel) {
            return new com.amap.api.services.weather.LocalWeatherLive(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.weather.LocalWeatherLive createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.amap.api.services.weather.LocalWeatherLive[] newArray(int i) {
            return null;
        }
    }

    public LocalWeatherLive() {
    }

    public LocalWeatherLive(android.os.Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String getAdCode() {
        return this.c;
    }

    public java.lang.String getCity() {
        return this.b;
    }

    public java.lang.String getHumidity() {
        return this.h;
    }

    public java.lang.String getProvince() {
        return this.a;
    }

    public java.lang.String getReportTime() {
        return this.i;
    }

    public java.lang.String getTemperature() {
        return this.e;
    }

    public java.lang.String getWeather() {
        return this.d;
    }

    public java.lang.String getWindDirection() {
        return this.f;
    }

    public java.lang.String getWindPower() {
        return this.g;
    }

    public void setAdCode(java.lang.String str) {
        this.c = str;
    }

    public void setCity(java.lang.String str) {
        this.b = str;
    }

    public void setHumidity(java.lang.String str) {
        this.h = str;
    }

    public void setProvince(java.lang.String str) {
        this.a = str;
    }

    public void setReportTime(java.lang.String str) {
        this.i = str;
    }

    public void setTemperature(java.lang.String str) {
        this.e = str;
    }

    public void setWeather(java.lang.String str) {
        this.d = str;
    }

    public void setWindDirection(java.lang.String str) {
        this.f = str;
    }

    public void setWindPower(java.lang.String str) {
        this.g = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
    }
}
