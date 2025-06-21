package com.amap.api.services.core;

/* loaded from: classes12.dex */
public class SuggestionCity {
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.String c;
    private int d;

    public SuggestionCity() {
    }

    public SuggestionCity(java.lang.String str, java.lang.String str2, java.lang.String str3, int i) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = i;
    }

    public java.lang.String getAdCode() {
        return this.c;
    }

    public java.lang.String getCityCode() {
        return this.b;
    }

    public java.lang.String getCityName() {
        return this.a;
    }

    public int getSuggestionNum() {
        return this.d;
    }

    public void setAdCode(java.lang.String str) {
        this.c = str;
    }

    public void setCityCode(java.lang.String str) {
        this.b = str;
    }

    public void setCityName(java.lang.String str) {
        this.a = str;
    }

    public void setSuggestionNum(int i) {
        this.d = i;
    }
}
