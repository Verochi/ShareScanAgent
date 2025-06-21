package com.amap.api.services.district;

/* loaded from: classes12.dex */
public class DistrictSearch {
    private com.amap.api.services.interfaces.IDistrictSearch a;

    public interface OnDistrictSearchListener {
        void onDistrictSearched(com.amap.api.services.district.DistrictResult districtResult);
    }

    public DistrictSearch(android.content.Context context) throws com.amap.api.services.core.AMapException {
        if (this.a == null) {
            try {
                this.a = new com.amap.api.col.s.ay(context);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                if (e instanceof com.amap.api.services.core.AMapException) {
                    throw ((com.amap.api.services.core.AMapException) e);
                }
            }
        }
    }

    public com.amap.api.services.district.DistrictSearchQuery getQuery() {
        com.amap.api.services.interfaces.IDistrictSearch iDistrictSearch = this.a;
        if (iDistrictSearch != null) {
            return iDistrictSearch.getQuery();
        }
        return null;
    }

    public com.amap.api.services.district.DistrictResult searchDistrict() throws com.amap.api.services.core.AMapException {
        com.amap.api.services.interfaces.IDistrictSearch iDistrictSearch = this.a;
        if (iDistrictSearch != null) {
            return iDistrictSearch.searchDistrict();
        }
        return null;
    }

    public void searchDistrictAnsy() {
        com.amap.api.services.interfaces.IDistrictSearch iDistrictSearch = this.a;
        if (iDistrictSearch != null) {
            iDistrictSearch.searchDistrictAnsy();
        }
    }

    public void searchDistrictAsyn() {
        com.amap.api.services.interfaces.IDistrictSearch iDistrictSearch = this.a;
        if (iDistrictSearch != null) {
            iDistrictSearch.searchDistrictAsyn();
        }
    }

    public void setOnDistrictSearchListener(com.amap.api.services.district.DistrictSearch.OnDistrictSearchListener onDistrictSearchListener) {
        com.amap.api.services.interfaces.IDistrictSearch iDistrictSearch = this.a;
        if (iDistrictSearch != null) {
            iDistrictSearch.setOnDistrictSearchListener(onDistrictSearchListener);
        }
    }

    public void setQuery(com.amap.api.services.district.DistrictSearchQuery districtSearchQuery) {
        com.amap.api.services.interfaces.IDistrictSearch iDistrictSearch = this.a;
        if (iDistrictSearch != null) {
            iDistrictSearch.setQuery(districtSearchQuery);
        }
    }
}
