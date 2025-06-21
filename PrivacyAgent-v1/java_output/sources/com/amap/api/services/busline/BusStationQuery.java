package com.amap.api.services.busline;

/* loaded from: classes12.dex */
public class BusStationQuery implements java.lang.Cloneable {
    private java.lang.String a;
    private java.lang.String b;
    private int c = 20;
    private int d = 1;

    public BusStationQuery(java.lang.String str, java.lang.String str2) {
        this.a = str;
        this.b = str2;
        if (a()) {
            return;
        }
        new java.lang.IllegalArgumentException("Empty query").printStackTrace();
    }

    private boolean a() {
        return !com.amap.api.col.s.i.a(this.a);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public com.amap.api.services.busline.BusStationQuery m27clone() {
        com.amap.api.services.busline.BusStationQuery busStationQuery = new com.amap.api.services.busline.BusStationQuery(this.a, this.b);
        busStationQuery.setPageNumber(this.d);
        busStationQuery.setPageSize(this.c);
        return busStationQuery;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.amap.api.services.busline.BusStationQuery busStationQuery = (com.amap.api.services.busline.BusStationQuery) obj;
        java.lang.String str = this.b;
        if (str == null) {
            if (busStationQuery.b != null) {
                return false;
            }
        } else if (!str.equals(busStationQuery.b)) {
            return false;
        }
        if (this.d != busStationQuery.d || this.c != busStationQuery.c) {
            return false;
        }
        java.lang.String str2 = this.a;
        if (str2 == null) {
            if (busStationQuery.a != null) {
                return false;
            }
        } else if (!str2.equals(busStationQuery.a)) {
            return false;
        }
        return true;
    }

    public java.lang.String getCity() {
        return this.b;
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
        java.lang.String str = this.b;
        int hashCode = ((((((str == null ? 0 : str.hashCode()) + 31) * 31) + this.d) * 31) + this.c) * 31;
        java.lang.String str2 = this.a;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public void setCity(java.lang.String str) {
        this.b = str;
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

    public boolean weakEquals(com.amap.api.services.busline.BusStationQuery busStationQuery) {
        if (this == busStationQuery) {
            return true;
        }
        if (busStationQuery == null) {
            return false;
        }
        java.lang.String str = this.b;
        if (str == null) {
            if (busStationQuery.b != null) {
                return false;
            }
        } else if (!str.equals(busStationQuery.b)) {
            return false;
        }
        if (this.c != busStationQuery.c) {
            return false;
        }
        java.lang.String str2 = this.a;
        if (str2 == null) {
            if (busStationQuery.a != null) {
                return false;
            }
        } else if (!str2.equals(busStationQuery.a)) {
            return false;
        }
        return true;
    }
}
