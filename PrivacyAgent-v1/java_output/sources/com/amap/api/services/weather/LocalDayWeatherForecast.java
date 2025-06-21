package com.amap.api.services.weather;

/* loaded from: classes12.dex */
public class LocalDayWeatherForecast implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.weather.LocalDayWeatherForecast> CREATOR = new com.amap.api.services.weather.LocalDayWeatherForecast.AnonymousClass1();
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.String c;
    private java.lang.String d;
    private java.lang.String e;
    private java.lang.String f;
    private java.lang.String g;
    private java.lang.String h;
    private java.lang.String i;
    private java.lang.String j;

    /* renamed from: com.amap.api.services.weather.LocalDayWeatherForecast$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.weather.LocalDayWeatherForecast> {
        private static com.amap.api.services.weather.LocalDayWeatherForecast a(android.os.Parcel parcel) {
            return new com.amap.api.services.weather.LocalDayWeatherForecast(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.weather.LocalDayWeatherForecast createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.amap.api.services.weather.LocalDayWeatherForecast[] newArray(int i) {
            return null;
        }
    }

    public LocalDayWeatherForecast() {
    }

    public LocalDayWeatherForecast(android.os.Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readString();
        this.j = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String getDate() {
        return this.a;
    }

    public java.lang.String getDayTemp() {
        return this.e;
    }

    public java.lang.String getDayWeather() {
        return this.c;
    }

    public java.lang.String getDayWindDirection() {
        return this.g;
    }

    public java.lang.String getDayWindPower() {
        return this.i;
    }

    public java.lang.String getNightTemp() {
        return this.f;
    }

    public java.lang.String getNightWeather() {
        return this.d;
    }

    public java.lang.String getNightWindDirection() {
        return this.h;
    }

    public java.lang.String getNightWindPower() {
        return this.j;
    }

    public java.lang.String getWeek() {
        return this.b;
    }

    public void setDate(java.lang.String str) {
        this.a = str;
    }

    public void setDayTemp(java.lang.String str) {
        this.e = str;
    }

    public void setDayWeather(java.lang.String str) {
        this.c = str;
    }

    public void setDayWindDirection(java.lang.String str) {
        this.g = str;
    }

    public void setDayWindPower(java.lang.String str) {
        this.i = str;
    }

    public void setNightTemp(java.lang.String str) {
        this.f = str;
    }

    public void setNightWeather(java.lang.String str) {
        this.d = str;
    }

    public void setNightWindDirection(java.lang.String str) {
        this.h = str;
    }

    public void setNightWindPower(java.lang.String str) {
        this.j = str;
    }

    public void setWeek(java.lang.String str) {
        this.b = str;
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
        parcel.writeString(this.j);
    }
}
