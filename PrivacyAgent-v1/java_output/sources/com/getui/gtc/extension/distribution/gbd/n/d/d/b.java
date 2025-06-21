package com.getui.gtc.extension.distribution.gbd.n.d.d;

/* loaded from: classes22.dex */
public final class b {
    private java.util.Set<com.getui.gtc.extension.distribution.gbd.n.d.d.b.d> a = new java.util.HashSet();
    private java.util.Map<com.getui.gtc.extension.distribution.gbd.n.d.d.b.d, java.util.Set<com.getui.gtc.extension.distribution.gbd.n.d.d.b.a>> b = new java.util.HashMap();
    private java.util.Map<com.getui.gtc.extension.distribution.gbd.n.d.d.b.d, java.util.Map<com.getui.gtc.extension.distribution.gbd.n.d.d.b.a, com.getui.gtc.extension.distribution.gbd.n.d.d.b.C0324b>> c = new java.util.HashMap();
    private java.util.Map<com.getui.gtc.extension.distribution.gbd.n.d.d.b.d, java.util.Map<com.getui.gtc.extension.distribution.gbd.n.d.d.b.a, java.util.Set<com.getui.gtc.extension.distribution.gbd.n.d.d.b.c>>> d = new java.util.HashMap();
    private boolean e = false;

    public static class a extends com.getui.gtc.extension.distribution.gbd.n.d.d.b.e {
        private a(java.lang.String str) {
            super(str);
        }

        public static com.getui.gtc.extension.distribution.gbd.n.d.d.b.a a(java.lang.String str) {
            return new com.getui.gtc.extension.distribution.gbd.n.d.d.b.a(str);
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.d.d.b$b, reason: collision with other inner class name */
    public static class C0324b extends com.getui.gtc.extension.distribution.gbd.n.d.d.b.e {
        public C0324b(java.lang.String str) {
            super(str);
        }

        private static com.getui.gtc.extension.distribution.gbd.n.d.d.b.C0324b a(java.lang.String str) {
            return new com.getui.gtc.extension.distribution.gbd.n.d.d.b.C0324b(str);
        }
    }

    public static class c extends com.getui.gtc.extension.distribution.gbd.n.d.d.b.e {
        private c(java.lang.String str) {
            super(str);
        }

        public static com.getui.gtc.extension.distribution.gbd.n.d.d.b.c a(java.lang.String str) {
            return new com.getui.gtc.extension.distribution.gbd.n.d.d.b.c(str);
        }
    }

    public static class d extends com.getui.gtc.extension.distribution.gbd.n.d.d.b.e {
        private d(java.lang.String str) {
            super(str);
        }

        public static com.getui.gtc.extension.distribution.gbd.n.d.d.b.d a(java.lang.String str) {
            return new com.getui.gtc.extension.distribution.gbd.n.d.d.b.d(str);
        }
    }

    public static abstract class e {
        private java.lang.String a;

        public e(java.lang.String str) {
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str);
            this.a = str;
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            java.lang.String str = this.a;
            java.lang.String str2 = ((com.getui.gtc.extension.distribution.gbd.n.d.d.b.e) obj).a;
            if (str == null) {
                if (str2 != null) {
                    return false;
                }
            } else if (!str.equals(str2)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            java.lang.String str = this.a;
            return (str == null ? 0 : str.hashCode()) + 31;
        }

        public java.lang.String toString() {
            return this.a;
        }
    }

    private static com.getui.gtc.extension.distribution.gbd.n.d.d.b a() {
        return new com.getui.gtc.extension.distribution.gbd.n.d.d.b();
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.d.b a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str);
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str2);
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str3);
        com.getui.gtc.extension.distribution.gbd.n.d.d.b.d a2 = com.getui.gtc.extension.distribution.gbd.n.d.d.b.d.a(str);
        if (!this.a.contains(a2)) {
            this.a.add(a2);
        }
        com.getui.gtc.extension.distribution.gbd.n.d.d.b.a a3 = com.getui.gtc.extension.distribution.gbd.n.d.d.b.a.a(str2);
        com.getui.gtc.extension.distribution.gbd.n.d.d.b.C0324b c0324b = new com.getui.gtc.extension.distribution.gbd.n.d.d.b.C0324b(str3);
        if (this.c.containsKey(a2)) {
            this.c.get(a2).put(a3, c0324b);
        } else {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put(a3, c0324b);
            this.c.put(a2, hashMap);
        }
        return this;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.d.b a(java.lang.String str, java.lang.String str2, java.lang.String... strArr) {
        java.util.Map<com.getui.gtc.extension.distribution.gbd.n.d.d.b.a, java.util.Set<com.getui.gtc.extension.distribution.gbd.n.d.d.b.c>> map;
        java.util.Set<com.getui.gtc.extension.distribution.gbd.n.d.d.b.c> set;
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str);
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str2);
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) strArr);
        com.getui.gtc.extension.distribution.gbd.n.d.d.b.d a2 = com.getui.gtc.extension.distribution.gbd.n.d.d.b.d.a(str);
        com.getui.gtc.extension.distribution.gbd.n.d.d.b.a a3 = com.getui.gtc.extension.distribution.gbd.n.d.d.b.a.a(str2);
        if (this.d.containsKey(a2)) {
            map = this.d.get(a2);
        } else {
            java.util.HashMap hashMap = new java.util.HashMap();
            this.d.put(a2, hashMap);
            map = hashMap;
        }
        if (map.containsKey(a3)) {
            set = map.get(a3);
        } else {
            java.util.HashSet hashSet = new java.util.HashSet();
            map.put(a3, hashSet);
            set = hashSet;
        }
        for (java.lang.String str3 : strArr) {
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str3);
            set.add(com.getui.gtc.extension.distribution.gbd.n.d.d.b.c.a(str3));
        }
        return this;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.d.b a(java.lang.String str, java.lang.String... strArr) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str);
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) strArr);
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(strArr.length > 0, "No attributes supplied.");
        com.getui.gtc.extension.distribution.gbd.n.d.d.b.d a2 = com.getui.gtc.extension.distribution.gbd.n.d.d.b.d.a(str);
        if (!this.a.contains(a2)) {
            this.a.add(a2);
        }
        java.util.HashSet hashSet = new java.util.HashSet();
        for (java.lang.String str2 : strArr) {
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str2);
            hashSet.add(com.getui.gtc.extension.distribution.gbd.n.d.d.b.a.a(str2));
        }
        if (this.b.containsKey(a2)) {
            this.b.get(a2).addAll(hashSet);
        } else {
            this.b.put(a2, hashSet);
        }
        return this;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.d.b a(boolean z) {
        this.e = z;
        return this;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.d.b a(java.lang.String... strArr) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) strArr);
        for (java.lang.String str : strArr) {
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str);
            this.a.add(com.getui.gtc.extension.distribution.gbd.n.d.d.b.d.a(str));
        }
        return this;
    }

    private boolean a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.a aVar, java.util.Set<com.getui.gtc.extension.distribution.gbd.n.d.d.b.c> set) {
        java.lang.String s2 = gVar.s(aVar.a);
        if (s2.length() == 0) {
            s2 = aVar.b;
        }
        if (!this.e) {
            aVar.setValue(s2);
        }
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.d.b.c> it = set.iterator();
        while (it.hasNext()) {
            if (s2.toLowerCase().startsWith(it.next().toString() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
                return true;
            }
        }
        return false;
    }

    private static com.getui.gtc.extension.distribution.gbd.n.d.d.b b() {
        return new com.getui.gtc.extension.distribution.gbd.n.d.d.b().a("b", "em", "i", "strong", com.umeng.analytics.pro.bo.aN);
    }

    private static com.getui.gtc.extension.distribution.gbd.n.d.d.b c() {
        com.getui.gtc.extension.distribution.gbd.n.d.d.b a2 = new com.getui.gtc.extension.distribution.gbd.n.d.d.b().a("a", "b", "blockquote", "br", "cite", "code", "dd", "dl", com.amap.api.mapcore.util.dt.a, "em", "i", com.meizu.cloud.pushsdk.notification.model.AppIconSetting.LARGE_ICON_URL, "ol", "p", "pre", "q", "small", "strike", "strong", "sub", "sup", com.umeng.analytics.pro.bo.aN, "ul").a("a", "href").a("blockquote", "cite").a("q", "cite").a("a", "href", "ftp", com.alipay.sdk.m.l.a.q, "https", "mailto").a("blockquote", "cite", com.alipay.sdk.m.l.a.q, "https").a("cite", "cite", com.alipay.sdk.m.l.a.q, "https");
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a("a");
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a("rel");
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a("nofollow");
        com.getui.gtc.extension.distribution.gbd.n.d.d.b.d a3 = com.getui.gtc.extension.distribution.gbd.n.d.d.b.d.a("a");
        if (!a2.a.contains(a3)) {
            a2.a.add(a3);
        }
        com.getui.gtc.extension.distribution.gbd.n.d.d.b.a a4 = com.getui.gtc.extension.distribution.gbd.n.d.d.b.a.a("rel");
        com.getui.gtc.extension.distribution.gbd.n.d.d.b.C0324b c0324b = new com.getui.gtc.extension.distribution.gbd.n.d.d.b.C0324b("nofollow");
        if (a2.c.containsKey(a3)) {
            a2.c.get(a3).put(a4, c0324b);
        } else {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put(a4, c0324b);
            a2.c.put(a3, hashMap);
        }
        return a2;
    }

    private static com.getui.gtc.extension.distribution.gbd.n.d.d.b d() {
        com.getui.gtc.extension.distribution.gbd.n.d.d.b a2 = new com.getui.gtc.extension.distribution.gbd.n.d.d.b().a("a", "b", "blockquote", "br", "cite", "code", "dd", "dl", com.amap.api.mapcore.util.dt.a, "em", "i", com.meizu.cloud.pushsdk.notification.model.AppIconSetting.LARGE_ICON_URL, "ol", "p", "pre", "q", "small", "strike", "strong", "sub", "sup", com.umeng.analytics.pro.bo.aN, "ul").a("a", "href").a("blockquote", "cite").a("q", "cite").a("a", "href", "ftp", com.alipay.sdk.m.l.a.q, "https", "mailto").a("blockquote", "cite", com.alipay.sdk.m.l.a.q, "https").a("cite", "cite", com.alipay.sdk.m.l.a.q, "https");
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a("a");
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a("rel");
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a("nofollow");
        com.getui.gtc.extension.distribution.gbd.n.d.d.b.d a3 = com.getui.gtc.extension.distribution.gbd.n.d.d.b.d.a("a");
        if (!a2.a.contains(a3)) {
            a2.a.add(a3);
        }
        com.getui.gtc.extension.distribution.gbd.n.d.d.b.a a4 = com.getui.gtc.extension.distribution.gbd.n.d.d.b.a.a("rel");
        com.getui.gtc.extension.distribution.gbd.n.d.d.b.C0324b c0324b = new com.getui.gtc.extension.distribution.gbd.n.d.d.b.C0324b("nofollow");
        if (a2.c.containsKey(a3)) {
            a2.c.get(a3).put(a4, c0324b);
        } else {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put(a4, c0324b);
            a2.c.put(a3, hashMap);
        }
        return a2.a(com.tencent.open.SocialConstants.PARAM_IMG_URL).a(com.tencent.open.SocialConstants.PARAM_IMG_URL, com.sensorsdata.sf.ui.view.UIProperty.align, "alt", "height", "src", "title", "width").a(com.tencent.open.SocialConstants.PARAM_IMG_URL, "src", com.alipay.sdk.m.l.a.q, "https");
    }

    private static com.getui.gtc.extension.distribution.gbd.n.d.d.b e() {
        return new com.getui.gtc.extension.distribution.gbd.n.d.d.b().a("a", "b", "blockquote", "br", com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_CAPTION, "cite", "code", "col", "colgroup", "dd", "div", "dl", com.amap.api.mapcore.util.dt.a, "em", "h1", "h2", "h3", "h4", "h5", "h6", "i", com.tencent.open.SocialConstants.PARAM_IMG_URL, com.meizu.cloud.pushsdk.notification.model.AppIconSetting.LARGE_ICON_URL, "ol", "p", "pre", "q", "small", "strike", "strong", "sub", "sup", "table", "tbody", com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting.TIME_DISPLAY, "tfoot", "th", "thead", "tr", com.umeng.analytics.pro.bo.aN, "ul").a("a", "href", "title").a("blockquote", "cite").a("col", "span", "width").a("colgroup", "span", "width").a(com.tencent.open.SocialConstants.PARAM_IMG_URL, com.sensorsdata.sf.ui.view.UIProperty.align, "alt", "height", "src", "title", "width").a("ol", com.anythink.expressad.foundation.d.c.bT, "type").a("q", "cite").a("table", "summary", "width").a(com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting.TIME_DISPLAY, "abbr", "axis", "colspan", "rowspan", "width").a("th", "abbr", "axis", "colspan", "rowspan", com.tencent.connect.common.Constants.PARAM_SCOPE, "width").a("ul", "type").a("a", "href", "ftp", com.alipay.sdk.m.l.a.q, "https", "mailto").a("blockquote", "cite", com.alipay.sdk.m.l.a.q, "https").a(com.tencent.open.SocialConstants.PARAM_IMG_URL, "src", com.alipay.sdk.m.l.a.q, "https").a("q", "cite", com.alipay.sdk.m.l.a.q, "https");
    }

    public final boolean a(java.lang.String str) {
        return this.a.contains(com.getui.gtc.extension.distribution.gbd.n.d.d.b.d.a(str));
    }

    public final boolean a(java.lang.String str, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.a aVar) {
        com.getui.gtc.extension.distribution.gbd.n.d.d.b.d a2 = com.getui.gtc.extension.distribution.gbd.n.d.d.b.d.a(str);
        com.getui.gtc.extension.distribution.gbd.n.d.d.b.a a3 = com.getui.gtc.extension.distribution.gbd.n.d.d.b.a.a(aVar.a);
        if (!this.b.containsKey(a2) || !this.b.get(a2).contains(a3)) {
            return !str.equals(":all") && a(":all", gVar, aVar);
        }
        if (this.d.containsKey(a2)) {
            java.util.Map<com.getui.gtc.extension.distribution.gbd.n.d.d.b.a, java.util.Set<com.getui.gtc.extension.distribution.gbd.n.d.d.b.c>> map = this.d.get(a2);
            if (map.containsKey(a3) && !a(gVar, aVar, map.get(a3))) {
                return false;
            }
        }
        return true;
    }

    public final com.getui.gtc.extension.distribution.gbd.n.d.b.b b(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.b.b bVar = new com.getui.gtc.extension.distribution.gbd.n.d.b.b();
        com.getui.gtc.extension.distribution.gbd.n.d.d.b.d a2 = com.getui.gtc.extension.distribution.gbd.n.d.d.b.d.a(str);
        if (this.c.containsKey(a2)) {
            for (java.util.Map.Entry<com.getui.gtc.extension.distribution.gbd.n.d.d.b.a, com.getui.gtc.extension.distribution.gbd.n.d.d.b.C0324b> entry : this.c.get(a2).entrySet()) {
                bVar.a(entry.getKey().toString(), entry.getValue().toString());
            }
        }
        return bVar;
    }
}
