package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class aq {
    public java.util.ArrayList<com.amap.api.maps.offlinemap.OfflineMapProvince> a = new java.util.ArrayList<>();
    private com.amap.api.mapcore.util.bb b;
    private android.content.Context c;

    public aq(android.content.Context context) {
        this.c = context;
        this.b = com.amap.api.mapcore.util.bb.a(context);
    }

    private void a(com.amap.api.mapcore.util.al alVar, com.amap.api.maps.offlinemap.OfflineMapCity offlineMapCity) {
        int b = alVar.c().b();
        if (alVar.c().equals(alVar.a)) {
            b(alVar.t());
        } else {
            if (alVar.c().equals(alVar.f)) {
                alVar.getCity();
                b(alVar);
                alVar.t().b();
            }
            if (a(alVar.getcompleteCode(), alVar.c().b())) {
                a(alVar.t());
            }
        }
        offlineMapCity.setState(b);
        offlineMapCity.setCompleteCode(alVar.getcompleteCode());
    }

    private void a(com.amap.api.mapcore.util.al alVar, com.amap.api.maps.offlinemap.OfflineMapProvince offlineMapProvince) {
        com.amap.api.mapcore.util.aw awVar;
        int b = alVar.c().b();
        if (b == 6) {
            offlineMapProvince.setState(b);
            offlineMapProvince.setCompleteCode(0);
            b(new com.amap.api.mapcore.util.aw(offlineMapProvince, this.c));
            try {
                com.amap.api.mapcore.util.bj.b(offlineMapProvince.getProvinceCode(), this.c);
                return;
            } catch (java.io.IOException e) {
                e.printStackTrace();
                return;
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (a(b) && a(offlineMapProvince)) {
            if (alVar.getPinyin().equals(offlineMapProvince.getPinyin())) {
                offlineMapProvince.setState(b);
                offlineMapProvince.setCompleteCode(alVar.getcompleteCode());
                offlineMapProvince.setVersion(alVar.getVersion());
                offlineMapProvince.setUrl(alVar.getUrl());
                awVar = new com.amap.api.mapcore.util.aw(offlineMapProvince, this.c);
                awVar.a(alVar.a());
                awVar.d(alVar.getCode());
            } else {
                offlineMapProvince.setState(b);
                offlineMapProvince.setCompleteCode(100);
                awVar = new com.amap.api.mapcore.util.aw(offlineMapProvince, this.c);
            }
            awVar.b();
            a(awVar);
            awVar.c();
        }
    }

    private void a(com.amap.api.mapcore.util.aw awVar) {
        com.amap.api.mapcore.util.bb bbVar = this.b;
        if (bbVar == null || awVar == null) {
            return;
        }
        bbVar.a(awVar);
    }

    private static void a(com.amap.api.maps.offlinemap.OfflineMapCity offlineMapCity, com.amap.api.maps.offlinemap.OfflineMapCity offlineMapCity2) {
        offlineMapCity.setUrl(offlineMapCity2.getUrl());
        offlineMapCity.setVersion(offlineMapCity2.getVersion());
        offlineMapCity.setSize(offlineMapCity2.getSize());
        offlineMapCity.setCode(offlineMapCity2.getCode());
        offlineMapCity.setPinyin(offlineMapCity2.getPinyin());
        offlineMapCity.setJianpin(offlineMapCity2.getJianpin());
    }

    private static void a(com.amap.api.maps.offlinemap.OfflineMapProvince offlineMapProvince, com.amap.api.maps.offlinemap.OfflineMapProvince offlineMapProvince2) {
        offlineMapProvince.setUrl(offlineMapProvince2.getUrl());
        offlineMapProvince.setVersion(offlineMapProvince2.getVersion());
        offlineMapProvince.setSize(offlineMapProvince2.getSize());
        offlineMapProvince.setPinyin(offlineMapProvince2.getPinyin());
        offlineMapProvince.setJianpin(offlineMapProvince2.getJianpin());
    }

    private static boolean a(int i) {
        return i == 4;
    }

    private static boolean a(int i, int i2) {
        return i2 != 1 || i <= 2 || i >= 98;
    }

    private static boolean a(com.amap.api.maps.offlinemap.OfflineMapProvince offlineMapProvince) {
        if (offlineMapProvince == null) {
            return false;
        }
        java.util.Iterator<com.amap.api.maps.offlinemap.OfflineMapCity> it = offlineMapProvince.getCityList().iterator();
        while (it.hasNext()) {
            if (it.next().getState() != 4) {
                return false;
            }
        }
        return true;
    }

    private void b(com.amap.api.mapcore.util.al alVar) {
        java.io.File[] listFiles = new java.io.File(com.amap.api.mapcore.util.dl.c(this.c)).listFiles();
        if (listFiles == null) {
            return;
        }
        for (java.io.File file : listFiles) {
            if (file.isFile() && file.exists() && file.getName().contains(alVar.getAdcode()) && file.getName().endsWith(".zip.tmp.dt")) {
                file.delete();
            }
        }
    }

    private void b(com.amap.api.mapcore.util.aw awVar) {
        com.amap.api.mapcore.util.bb bbVar = this.b;
        if (bbVar != null) {
            bbVar.b(awVar);
        }
    }

    private static boolean b(int i) {
        return i == 0 || i == 2 || i == 3 || i == 1 || i == 102 || i == 101 || i == 103 || i == -1;
    }

    private void h() {
        java.util.ArrayList<com.amap.api.maps.offlinemap.OfflineMapProvince> arrayList = this.a;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.a.clear();
            }
        }
    }

    public final com.amap.api.maps.offlinemap.OfflineMapCity a(java.lang.String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        synchronized (this.a) {
            java.util.Iterator<com.amap.api.maps.offlinemap.OfflineMapProvince> it = this.a.iterator();
            while (it.hasNext()) {
                java.util.Iterator<com.amap.api.maps.offlinemap.OfflineMapCity> it2 = it.next().getCityList().iterator();
                while (it2.hasNext()) {
                    com.amap.api.maps.offlinemap.OfflineMapCity next = it2.next();
                    if (next.getCode().equals(str)) {
                        return next;
                    }
                }
            }
            return null;
        }
    }

    public final java.util.ArrayList<com.amap.api.maps.offlinemap.OfflineMapProvince> a() {
        java.util.ArrayList<com.amap.api.maps.offlinemap.OfflineMapProvince> arrayList = new java.util.ArrayList<>();
        synchronized (this.a) {
            java.util.Iterator<com.amap.api.maps.offlinemap.OfflineMapProvince> it = this.a.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        return arrayList;
    }

    public final void a(com.amap.api.mapcore.util.al alVar) {
        java.lang.String pinyin = alVar.getPinyin();
        synchronized (this.a) {
            java.util.Iterator<com.amap.api.maps.offlinemap.OfflineMapProvince> it = this.a.iterator();
            loop0: while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.amap.api.maps.offlinemap.OfflineMapProvince next = it.next();
                if (next != null) {
                    for (com.amap.api.maps.offlinemap.OfflineMapCity offlineMapCity : next.getCityList()) {
                        if (offlineMapCity.getPinyin().trim().equals(pinyin.trim())) {
                            a(alVar, offlineMapCity);
                            a(alVar, next);
                            break loop0;
                        }
                    }
                }
            }
        }
    }

    public final void a(java.util.List<com.amap.api.maps.offlinemap.OfflineMapProvince> list) {
        com.amap.api.maps.offlinemap.OfflineMapProvince offlineMapProvince;
        com.amap.api.maps.offlinemap.OfflineMapCity offlineMapCity;
        synchronized (this.a) {
            if (this.a.size() > 0) {
                for (int i = 0; i < this.a.size(); i++) {
                    com.amap.api.maps.offlinemap.OfflineMapProvince offlineMapProvince2 = this.a.get(i);
                    java.util.Iterator<com.amap.api.maps.offlinemap.OfflineMapProvince> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            offlineMapProvince = null;
                            break;
                        }
                        offlineMapProvince = it.next();
                        if (offlineMapProvince2.getPinyin().equals(offlineMapProvince.getPinyin())) {
                            break;
                        }
                        if (offlineMapProvince2.getPinyin().equals("quanguogaiyaotu") || offlineMapProvince2.getProvinceCode().equals("000001") || offlineMapProvince2.getProvinceCode().equals(com.alimm.tanx.core.constant.AdConstants.PID_STYLE_DEFAULT_ID)) {
                            if (offlineMapProvince.getPinyin().equals("quanguogaiyaotu")) {
                                break;
                            }
                        }
                    }
                    if (offlineMapProvince != null) {
                        a(offlineMapProvince2, offlineMapProvince);
                        java.util.ArrayList<com.amap.api.maps.offlinemap.OfflineMapCity> cityList = offlineMapProvince2.getCityList();
                        java.util.ArrayList<com.amap.api.maps.offlinemap.OfflineMapCity> cityList2 = offlineMapProvince.getCityList();
                        for (int i2 = 0; i2 < cityList.size(); i2++) {
                            com.amap.api.maps.offlinemap.OfflineMapCity offlineMapCity2 = cityList.get(i2);
                            java.util.Iterator<com.amap.api.maps.offlinemap.OfflineMapCity> it2 = cityList2.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    offlineMapCity = it2.next();
                                    if (offlineMapCity2.getPinyin().equals(offlineMapCity.getPinyin())) {
                                        break;
                                    }
                                } else {
                                    offlineMapCity = null;
                                    break;
                                }
                            }
                            if (offlineMapCity != null) {
                                a(offlineMapCity2, offlineMapCity);
                            }
                        }
                    }
                }
            } else {
                java.util.Iterator<com.amap.api.maps.offlinemap.OfflineMapProvince> it3 = list.iterator();
                while (it3.hasNext()) {
                    this.a.add(it3.next());
                }
            }
        }
    }

    public final com.amap.api.maps.offlinemap.OfflineMapCity b(java.lang.String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        synchronized (this.a) {
            java.util.Iterator<com.amap.api.maps.offlinemap.OfflineMapProvince> it = this.a.iterator();
            while (it.hasNext()) {
                java.util.Iterator<com.amap.api.maps.offlinemap.OfflineMapCity> it2 = it.next().getCityList().iterator();
                while (it2.hasNext()) {
                    com.amap.api.maps.offlinemap.OfflineMapCity next = it2.next();
                    if (next.getCity().trim().equalsIgnoreCase(str.trim())) {
                        return next;
                    }
                }
            }
            return null;
        }
    }

    public final java.util.ArrayList<com.amap.api.maps.offlinemap.OfflineMapCity> b() {
        java.util.ArrayList<com.amap.api.maps.offlinemap.OfflineMapCity> arrayList = new java.util.ArrayList<>();
        synchronized (this.a) {
            java.util.Iterator<com.amap.api.maps.offlinemap.OfflineMapProvince> it = this.a.iterator();
            while (it.hasNext()) {
                java.util.Iterator<com.amap.api.maps.offlinemap.OfflineMapCity> it2 = it.next().getCityList().iterator();
                while (it2.hasNext()) {
                    arrayList.add(it2.next());
                }
            }
        }
        return arrayList;
    }

    public final com.amap.api.maps.offlinemap.OfflineMapProvince c(java.lang.String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        synchronized (this.a) {
            java.util.Iterator<com.amap.api.maps.offlinemap.OfflineMapProvince> it = this.a.iterator();
            while (it.hasNext()) {
                com.amap.api.maps.offlinemap.OfflineMapProvince next = it.next();
                if (next.getProvinceName().trim().equalsIgnoreCase(str.trim())) {
                    return next;
                }
            }
            return null;
        }
    }

    public final java.util.ArrayList<com.amap.api.maps.offlinemap.OfflineMapCity> c() {
        java.util.ArrayList<com.amap.api.maps.offlinemap.OfflineMapCity> arrayList;
        synchronized (this.a) {
            arrayList = new java.util.ArrayList<>();
            java.util.Iterator<com.amap.api.maps.offlinemap.OfflineMapProvince> it = this.a.iterator();
            while (it.hasNext()) {
                com.amap.api.maps.offlinemap.OfflineMapProvince next = it.next();
                if (next != null) {
                    for (com.amap.api.maps.offlinemap.OfflineMapCity offlineMapCity : next.getCityList()) {
                        if (offlineMapCity.getState() == 4 || offlineMapCity.getState() == 7) {
                            arrayList.add(offlineMapCity);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public final java.util.ArrayList<com.amap.api.maps.offlinemap.OfflineMapProvince> d() {
        java.util.ArrayList<com.amap.api.maps.offlinemap.OfflineMapProvince> arrayList;
        synchronized (this.a) {
            arrayList = new java.util.ArrayList<>();
            java.util.Iterator<com.amap.api.maps.offlinemap.OfflineMapProvince> it = this.a.iterator();
            while (it.hasNext()) {
                com.amap.api.maps.offlinemap.OfflineMapProvince next = it.next();
                if (next != null && (next.getState() == 4 || next.getState() == 7)) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public final java.util.ArrayList<com.amap.api.maps.offlinemap.OfflineMapCity> e() {
        java.util.ArrayList<com.amap.api.maps.offlinemap.OfflineMapCity> arrayList;
        synchronized (this.a) {
            arrayList = new java.util.ArrayList<>();
            java.util.Iterator<com.amap.api.maps.offlinemap.OfflineMapProvince> it = this.a.iterator();
            while (it.hasNext()) {
                com.amap.api.maps.offlinemap.OfflineMapProvince next = it.next();
                if (next != null) {
                    for (com.amap.api.maps.offlinemap.OfflineMapCity offlineMapCity : next.getCityList()) {
                        if (b(offlineMapCity.getState())) {
                            arrayList.add(offlineMapCity);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public final java.util.ArrayList<com.amap.api.maps.offlinemap.OfflineMapProvince> f() {
        java.util.ArrayList<com.amap.api.maps.offlinemap.OfflineMapProvince> arrayList;
        synchronized (this.a) {
            arrayList = new java.util.ArrayList<>();
            java.util.Iterator<com.amap.api.maps.offlinemap.OfflineMapProvince> it = this.a.iterator();
            while (it.hasNext()) {
                com.amap.api.maps.offlinemap.OfflineMapProvince next = it.next();
                if (next != null && b(next.getState())) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public final void g() {
        h();
        this.b = null;
        this.c = null;
    }
}
