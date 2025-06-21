package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class aj extends com.amap.api.col.s.b<com.amap.api.services.routepoisearch.RoutePOISearchQuery, com.amap.api.services.routepoisearch.RoutePOISearchResult> {

    /* renamed from: com.amap.api.col.s.aj$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.amap.api.services.routepoisearch.RoutePOISearch.RoutePOISearchType.values().length];
            a = iArr;
            try {
                iArr[com.amap.api.services.routepoisearch.RoutePOISearch.RoutePOISearchType.TypeGasStation.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.amap.api.services.routepoisearch.RoutePOISearch.RoutePOISearchType.TypeMaintenanceStation.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.amap.api.services.routepoisearch.RoutePOISearch.RoutePOISearchType.TypeATM.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[com.amap.api.services.routepoisearch.RoutePOISearch.RoutePOISearchType.TypeToilet.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                a[com.amap.api.services.routepoisearch.RoutePOISearch.RoutePOISearchType.TypeFillingStation.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                a[com.amap.api.services.routepoisearch.RoutePOISearch.RoutePOISearchType.TypeServiceArea.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
        }
    }

    public aj(android.content.Context context, com.amap.api.services.routepoisearch.RoutePOISearchQuery routePOISearchQuery) {
        super(context, routePOISearchQuery);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public final com.amap.api.services.routepoisearch.RoutePOISearchResult a(java.lang.String str) throws com.amap.api.services.core.AMapException {
        java.util.ArrayList<com.amap.api.services.routepoisearch.RoutePOIItem> arrayList = new java.util.ArrayList<>();
        try {
            arrayList = com.amap.api.col.s.p.i(new org.json.JSONObject(str));
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return new com.amap.api.services.routepoisearch.RoutePOISearchResult(arrayList, (com.amap.api.services.routepoisearch.RoutePOISearchQuery) this.b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final java.lang.String a_() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(com.amap.api.col.s.bi.f(this.e));
        stringBuffer.append("&range=");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(((com.amap.api.services.routepoisearch.RoutePOISearchQuery) this.b).getRange());
        stringBuffer.append(sb.toString());
        java.lang.String str = "";
        try {
            switch (com.amap.api.col.s.aj.AnonymousClass1.a[((com.amap.api.services.routepoisearch.RoutePOISearchQuery) this.b).getSearchType().ordinal()]) {
                case 1:
                    str = "010100";
                    break;
                case 2:
                    str = "030000";
                    break;
                case 3:
                    str = "160300";
                    break;
                case 4:
                    str = "200300";
                    break;
                case 5:
                    str = "010300";
                    break;
                case 6:
                    str = "180300";
                    break;
            }
        } catch (java.lang.Exception unused) {
        }
        if (((com.amap.api.services.routepoisearch.RoutePOISearchQuery) this.b).getPolylines() == null || ((com.amap.api.services.routepoisearch.RoutePOISearchQuery) this.b).getPolylines().size() <= 0) {
            stringBuffer.append("&origin=");
            stringBuffer.append(com.amap.api.col.s.i.a(((com.amap.api.services.routepoisearch.RoutePOISearchQuery) this.b).getFrom()));
            stringBuffer.append("&destination=");
            stringBuffer.append(com.amap.api.col.s.i.a(((com.amap.api.services.routepoisearch.RoutePOISearchQuery) this.b).getTo()));
            stringBuffer.append("&strategy=");
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(((com.amap.api.services.routepoisearch.RoutePOISearchQuery) this.b).getMode());
            stringBuffer.append(sb2.toString());
        } else {
            stringBuffer.append("&polyline=");
            stringBuffer.append(com.amap.api.col.s.i.a(((com.amap.api.services.routepoisearch.RoutePOISearchQuery) this.b).getPolylines()));
        }
        stringBuffer.append("&types=");
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dd
    public final java.lang.String h() {
        return com.amap.api.col.s.h.a() + "/place/route?";
    }
}
