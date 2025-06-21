package com.amap.api.services.busline;

/* loaded from: classes12.dex */
public class BusLineQuery implements java.lang.Cloneable {
    private java.lang.String a;
    private java.lang.String b;
    private com.amap.api.services.busline.BusLineQuery.SearchType e;
    private int c = 20;
    private int d = 1;
    private java.lang.String f = "base";

    public enum SearchType {
        BY_LINE_ID,
        BY_LINE_NAME
    }

    public BusLineQuery(java.lang.String str, com.amap.api.services.busline.BusLineQuery.SearchType searchType, java.lang.String str2) {
        this.a = str;
        this.e = searchType;
        this.b = str2;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public com.amap.api.services.busline.BusLineQuery m26clone() {
        com.amap.api.services.busline.BusLineQuery busLineQuery = new com.amap.api.services.busline.BusLineQuery(this.a, this.e, this.b);
        busLineQuery.setPageNumber(this.d);
        busLineQuery.setPageSize(this.c);
        busLineQuery.setExtensions(this.f);
        return busLineQuery;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.amap.api.services.busline.BusLineQuery busLineQuery = (com.amap.api.services.busline.BusLineQuery) obj;
        if (this.e != busLineQuery.e) {
            return false;
        }
        java.lang.String str = this.b;
        if (str == null) {
            if (busLineQuery.b != null) {
                return false;
            }
        } else if (!str.equals(busLineQuery.b)) {
            return false;
        }
        if (this.d != busLineQuery.d || this.c != busLineQuery.c) {
            return false;
        }
        java.lang.String str2 = this.a;
        if (str2 == null) {
            if (busLineQuery.a != null) {
                return false;
            }
        } else if (!str2.equals(busLineQuery.a)) {
            return false;
        }
        java.lang.String str3 = this.f;
        if (str3 == null) {
            if (busLineQuery.f != null) {
                return false;
            }
        } else if (!str3.equals(busLineQuery.f)) {
            return false;
        }
        return true;
    }

    public com.amap.api.services.busline.BusLineQuery.SearchType getCategory() {
        return this.e;
    }

    public java.lang.String getCity() {
        return this.b;
    }

    public java.lang.String getExtensions() {
        return this.f;
    }

    public int getPageNumber() {
        return this.d;
    }

    public int getPageSize() {
        return this.c;
    }

    public java.lang.String getQueryString() {
        return this.a;
    }

    public int hashCode() {
        com.amap.api.services.busline.BusLineQuery.SearchType searchType = this.e;
        int hashCode = ((searchType == null ? 0 : searchType.hashCode()) + 31) * 31;
        java.lang.String str = this.b;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.d) * 31) + this.c) * 31;
        java.lang.String str2 = this.a;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        java.lang.String str3 = this.f;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public void setCategory(com.amap.api.services.busline.BusLineQuery.SearchType searchType) {
        this.e = searchType;
    }

    public void setCity(java.lang.String str) {
        this.b = str;
    }

    public void setExtensions(java.lang.String str) {
        this.f = str;
    }

    public void setPageNumber(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.d = i;
    }

    public void setPageSize(int i) {
        this.c = i;
    }

    public void setQueryString(java.lang.String str) {
        this.a = str;
    }

    public boolean weakEquals(com.amap.api.services.busline.BusLineQuery busLineQuery) {
        if (this == busLineQuery) {
            return true;
        }
        if (busLineQuery == null) {
            return false;
        }
        if (this.a == null) {
            if (busLineQuery.getQueryString() != null) {
                return false;
            }
        } else if (!busLineQuery.getQueryString().equals(this.a)) {
            return false;
        }
        if (this.b == null) {
            if (busLineQuery.getCity() != null) {
                return false;
            }
        } else if (!busLineQuery.getCity().equals(this.b)) {
            return false;
        }
        return this.c == busLineQuery.getPageSize() && busLineQuery.getCategory().compareTo(this.e) == 0;
    }
}
