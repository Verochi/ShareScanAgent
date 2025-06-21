package com.igexin.push.core;

/* loaded from: classes23.dex */
public final class n {
    private static final java.lang.String b = "PushMessageExecutor";
    private static java.util.Set<java.lang.String> d;
    private static volatile com.igexin.push.core.n f;
    private final java.util.Map<java.lang.String, com.igexin.push.extension.mod.PushMessageInterface> c;
    protected java.util.HashMap<java.lang.String, java.lang.String> a = new java.util.HashMap<>();
    private final java.util.Map<java.lang.String, java.lang.String> e = new java.util.concurrent.ConcurrentHashMap();

    /* renamed from: com.igexin.push.core.n$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.igexin.push.extension.mod.PushTaskBean a;

        public AnonymousClass1(com.igexin.push.extension.mod.PushTaskBean pushTaskBean) {
            this.a = pushTaskBean;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.igexin.sdk.main.FeedbackImpl.getInstance().feedbackMessageAction(this.a, "0");
        }
    }

    /* renamed from: com.igexin.push.core.n$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.igexin.push.extension.mod.PushTaskBean a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass2(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, java.lang.String str) {
            this.a = pushTaskBean;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.igexin.sdk.main.FeedbackImpl.getInstance().feedbackMessageAction(this.a, this.b);
        }
    }

    private n() {
        d = new java.util.HashSet();
        this.c = new java.util.HashMap();
        d.add(com.igexin.push.core.b.r);
        d.add(com.igexin.push.core.b.n);
        d.add(com.igexin.push.core.b.o);
        d.add(com.igexin.push.core.b.p);
        d.add(com.igexin.push.core.b.m);
        d.add(com.igexin.push.core.b.t);
        d.add(com.igexin.push.core.b.u);
        d.add(com.igexin.push.core.b.v);
        d.add(com.igexin.push.core.b.w);
        d.add(com.igexin.push.core.b.x);
        d.add(com.igexin.push.core.b.f386s);
        d.add(com.igexin.push.core.b.y);
    }

    public static com.igexin.push.core.n a() {
        if (f == null) {
            synchronized (com.igexin.push.core.n.class) {
                if (f == null) {
                    f = new com.igexin.push.core.n();
                }
            }
        }
        return f;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.igexin.push.extension.mod.PushMessageInterface a(java.lang.String str) {
        com.igexin.push.extension.mod.PushMessageInterface pushMessageInterface;
        java.lang.ClassLoader a;
        java.lang.Class<?> loadClass;
        if (this.c.containsKey(str)) {
            return this.c.get(str);
        }
        com.igexin.push.extension.mod.PushMessageInterface pushMessageInterface2 = null;
        try {
            if (!this.a.containsKey(str) || (a = com.igexin.push.core.e.a(str)) == null || (loadClass = a.loadClass(this.a.get(str))) == null) {
                pushMessageInterface = null;
            } else {
                pushMessageInterface = (com.igexin.push.extension.mod.PushMessageInterface) loadClass.newInstance();
                try {
                    this.c.put(str, pushMessageInterface);
                } catch (java.lang.Throwable th) {
                    th = th;
                    com.igexin.c.a.c.a.a(th);
                    if (pushMessageInterface == null) {
                    }
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            pushMessageInterface = null;
        }
        if (pushMessageInterface == null) {
            return pushMessageInterface;
        }
        if (!android.text.TextUtils.isEmpty(str) && d.contains(str) && (pushMessageInterface2 = this.c.get(str)) == null) {
            str.hashCode();
            switch (str) {
                case "updatedconfig":
                    this.c.put(com.igexin.push.core.b.f386s, new com.igexin.push.core.a.c.m());
                    break;
                case "disablelog":
                    this.c.put(com.igexin.push.core.b.x, new com.igexin.push.core.a.c.c());
                    break;
                case "startmyactivity":
                    this.c.put(com.igexin.push.core.b.o, new com.igexin.push.core.a.c.j());
                    break;
                case "terminatetask":
                    this.c.put(com.igexin.push.core.b.n, new com.igexin.push.core.a.c.l());
                    break;
                case "enablelog":
                    this.c.put(com.igexin.push.core.b.w, new com.igexin.push.core.a.c.d());
                    break;
                case "goto":
                    this.c.put(com.igexin.push.core.b.r, new com.igexin.push.core.a.c.f());
                    break;
                case "null":
                    this.c.put(com.igexin.push.core.b.m, new com.igexin.push.core.a.c.e());
                    break;
                case "popup":
                    this.c.put(com.igexin.push.core.b.q, new com.igexin.push.core.a.c.h());
                    break;
                case "cleanext":
                    this.c.put(com.igexin.push.core.b.v, new com.igexin.push.core.a.c.b());
                    break;
                case "gdoption":
                    this.c.put(com.igexin.push.core.b.y, new com.igexin.push.core.a.c.g());
                    break;
                case "startapp":
                    this.c.put(com.igexin.push.core.b.p, new com.igexin.push.core.a.c.i());
                    break;
                case "startweb":
                    this.c.put(com.igexin.push.core.b.t, new com.igexin.push.core.a.c.k());
                    break;
                case "checkapp":
                    this.c.put(com.igexin.push.core.b.u, new com.igexin.push.core.a.c.a());
                    break;
            }
            pushMessageInterface2 = this.c.get(str);
        }
        return pushMessageInterface2;
    }

    private boolean a(java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str, com.igexin.push.extension.mod.PushTaskBean pushTaskBean) {
        java.lang.String str2;
        if (!com.igexin.push.h.c.b(str)) {
            if (map != null && map.size() != 0) {
                if ((!map.containsKey("expireTime") || java.lang.Long.parseLong(map.get("expireTime")) >= java.lang.System.currentTimeMillis()) && (!map.containsKey("endTime") || java.lang.Long.parseLong(map.get("endTime")) >= java.lang.System.currentTimeMillis())) {
                    if (map.containsKey(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI)) {
                        int parseInt = java.lang.Integer.parseInt(map.get(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI));
                        com.igexin.push.h.c.c();
                        if (parseInt != com.igexin.push.core.e.x) {
                            return false;
                        }
                    }
                    if (map.containsKey("screenOn")) {
                        int parseInt2 = java.lang.Integer.parseInt(map.get("screenOn"));
                        com.igexin.push.h.c.d();
                        if (parseInt2 != com.igexin.push.core.e.y) {
                            return false;
                        }
                    }
                    if (map.containsKey("ssid")) {
                        str2 = map.get("ssid");
                        try {
                            java.util.List<android.net.wifi.ScanResult> j = com.igexin.push.h.n.j();
                            this.e.clear();
                            if (j != null && !j.isEmpty()) {
                                for (int i = 0; i < j.size(); i++) {
                                    this.e.put(j.get(i).BSSID, j.get(i).SSID);
                                    java.lang.String str3 = j.get(i).BSSID;
                                    java.lang.String str4 = j.get(i).SSID;
                                }
                            }
                        } catch (java.lang.Throwable th) {
                            com.igexin.c.a.c.a.a(th);
                        }
                        if (!this.e.containsValue(str2)) {
                            return false;
                        }
                    } else {
                        str2 = "";
                    }
                    if (map.containsKey("bssid")) {
                        java.lang.String str5 = map.get("bssid");
                        if (!this.e.containsKey(str5)) {
                            return false;
                        }
                        java.lang.String str6 = this.e.get(str5);
                        if (str6 != null && !str6.equals(str2)) {
                            return false;
                        }
                    }
                    if (map.containsKey(com.umeng.analytics.AnalyticsConfig.RTD_START_TIME) && java.lang.Long.parseLong(map.get(com.umeng.analytics.AnalyticsConfig.RTD_START_TIME)) > java.lang.System.currentTimeMillis()) {
                        return false;
                    }
                    if (map.containsKey("netConnected")) {
                        try {
                            if (java.lang.Integer.parseInt(map.get("netConnected")) != com.igexin.push.h.c.e()) {
                                return false;
                            }
                        } catch (java.lang.Exception e) {
                            com.igexin.c.a.c.a.a(e);
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        com.igexin.push.core.e.c.a();
        com.igexin.push.core.e.c.a(com.igexin.push.core.b.ah, str);
        pushTaskBean.setStatus(com.igexin.push.core.b.ag);
        return false;
    }

    private com.igexin.push.extension.mod.PushMessageInterface b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || !d.contains(str)) {
            return null;
        }
        com.igexin.push.extension.mod.PushMessageInterface pushMessageInterface = this.c.get(str);
        if (pushMessageInterface != null) {
            return pushMessageInterface;
        }
        str.hashCode();
        switch (str) {
            case "updatedconfig":
                this.c.put(com.igexin.push.core.b.f386s, new com.igexin.push.core.a.c.m());
                break;
            case "disablelog":
                this.c.put(com.igexin.push.core.b.x, new com.igexin.push.core.a.c.c());
                break;
            case "startmyactivity":
                this.c.put(com.igexin.push.core.b.o, new com.igexin.push.core.a.c.j());
                break;
            case "terminatetask":
                this.c.put(com.igexin.push.core.b.n, new com.igexin.push.core.a.c.l());
                break;
            case "enablelog":
                this.c.put(com.igexin.push.core.b.w, new com.igexin.push.core.a.c.d());
                break;
            case "goto":
                this.c.put(com.igexin.push.core.b.r, new com.igexin.push.core.a.c.f());
                break;
            case "null":
                this.c.put(com.igexin.push.core.b.m, new com.igexin.push.core.a.c.e());
                break;
            case "popup":
                this.c.put(com.igexin.push.core.b.q, new com.igexin.push.core.a.c.h());
                break;
            case "cleanext":
                this.c.put(com.igexin.push.core.b.v, new com.igexin.push.core.a.c.b());
                break;
            case "gdoption":
                this.c.put(com.igexin.push.core.b.y, new com.igexin.push.core.a.c.g());
                break;
            case "startapp":
                this.c.put(com.igexin.push.core.b.p, new com.igexin.push.core.a.c.i());
                break;
            case "startweb":
                this.c.put(com.igexin.push.core.b.t, new com.igexin.push.core.a.c.k());
                break;
            case "checkapp":
                this.c.put(com.igexin.push.core.b.u, new com.igexin.push.core.a.c.a());
                break;
        }
        return this.c.get(str);
    }

    public static void b() {
        try {
            if (!android.text.TextUtils.isEmpty(com.igexin.push.config.d.C) && !"none".equals(com.igexin.push.config.d.C)) {
                java.util.List<java.lang.String> asList = java.util.Arrays.asList(com.igexin.push.config.d.C.split(","));
                if (asList.isEmpty()) {
                    return;
                }
                java.util.ArrayList arrayList = new java.util.ArrayList();
                java.util.Iterator<java.util.Map.Entry<java.lang.String, com.igexin.push.extension.mod.PushTaskBean>> it = com.igexin.push.core.e.ah.entrySet().iterator();
                while (it.hasNext()) {
                    java.util.Map.Entry<java.lang.String, com.igexin.push.extension.mod.PushTaskBean> next = it.next();
                    java.lang.String key = next.getKey();
                    com.igexin.push.extension.mod.PushTaskBean value = next.getValue();
                    if (!android.text.TextUtils.isEmpty(key)) {
                        for (java.lang.String str : asList) {
                            if (!android.text.TextUtils.isEmpty(str) && key.startsWith(str)) {
                                arrayList.add(value.getTaskId());
                                it.remove();
                            }
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                java.lang.String[] strArr = new java.lang.String[arrayList.size()];
                for (int i = 0; i < arrayList.size(); i++) {
                    strArr[i] = (java.lang.String) arrayList.get(i);
                }
                com.igexin.push.core.d.a.a.i.a("message", new java.lang.String[]{"taskid"}, strArr);
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private static void b(java.lang.String str, java.lang.String str2) {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("taskid", str);
        bundle.putString("messageid", str2);
        android.os.Message obtain = android.os.Message.obtain();
        obtain.what = com.igexin.push.core.b.U;
        obtain.obj = bundle;
        com.igexin.push.core.d.a.a.a(obtain);
    }

    private static void b(org.json.JSONObject jSONObject, com.igexin.push.extension.mod.PushTaskBean pushTaskBean) {
        try {
            org.json.JSONObject jSONObject2 = jSONObject.getJSONObject("condition");
            java.util.HashMap hashMap = new java.util.HashMap();
            if (jSONObject2.has(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI)) {
                hashMap.put(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI, jSONObject2.getString(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI));
            }
            if (jSONObject2.has("screenOn")) {
                hashMap.put("screenOn", jSONObject2.getString("screenOn"));
            }
            if (jSONObject2.has("ssid")) {
                hashMap.put("ssid", jSONObject2.getString("ssid"));
                if (jSONObject2.has("bssid")) {
                    hashMap.put("bssid", jSONObject2.getString("bssid"));
                }
            }
            if (jSONObject2.has("duration")) {
                java.lang.String string = jSONObject2.getString("duration");
                if (string.contains(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                    int indexOf = string.indexOf(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    java.lang.String substring = string.substring(0, indexOf);
                    java.lang.String substring2 = string.substring(indexOf + 1, string.length());
                    hashMap.put(com.umeng.analytics.AnalyticsConfig.RTD_START_TIME, substring);
                    hashMap.put("endTime", substring2);
                }
            }
            if (jSONObject2.has("netConnected")) {
                hashMap.put("netConnected", jSONObject2.getString("netConnected"));
            }
            if (jSONObject2.has("expireTime")) {
                java.lang.String string2 = jSONObject2.getString("expireTime");
                if (!android.text.TextUtils.isEmpty(string2) && android.text.TextUtils.isDigitsOnly(string2)) {
                    hashMap.put("expireTime", string2);
                }
            }
            pushTaskBean.setConditionMap(hashMap);
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    private void c(java.lang.String str, java.lang.String str2) {
        if (str2 == null || str == null) {
            return;
        }
        try {
            com.igexin.push.core.a.b.d();
            java.lang.String a = com.igexin.push.core.a.b.a(str, str2);
            com.igexin.push.extension.mod.PushTaskBean pushTaskBean = com.igexin.push.core.e.ah.get(a);
            if (pushTaskBean == null) {
                return;
            }
            int status = pushTaskBean.getStatus();
            int i = com.igexin.push.core.b.ag;
            if (status == i) {
                com.igexin.c.a.c.a.b(b, " has execute ".concat(java.lang.String.valueOf(a)));
                return;
            }
            pushTaskBean.setStatus(i);
            com.igexin.c.a.c.a.b(b, " do processActionExecute ".concat(java.lang.String.valueOf(a)));
            if (a(str, str2) != com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.success) {
                pushTaskBean.setStatus(com.igexin.push.core.b.af);
                return;
            }
            com.igexin.push.core.e.c.a();
            com.igexin.push.core.e.c.a(com.igexin.push.core.b.ag, str);
            pushTaskBean.setStatus(com.igexin.push.core.b.ag);
            if (a(str, str2, "1")) {
                return;
            }
            com.igexin.push.core.e.c.a();
            com.igexin.push.core.e.c.a(com.igexin.push.core.b.af, str);
            pushTaskBean.setStatus(com.igexin.push.core.b.af);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00fd, code lost:
    
        if (r1 != null) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean e() {
        if (com.igexin.push.core.e.ah.isEmpty() && com.igexin.push.core.e.w.getAndSet(false)) {
            android.database.Cursor cursor = null;
            try {
                cursor = com.igexin.push.core.d.a.a.i.a("message", new java.lang.String[]{"status"}, new java.lang.String[]{"0"}, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        byte[] blob = cursor.getBlob(cursor.getColumnIndex("msgextra"));
                        try {
                            org.json.JSONObject jSONObject = new org.json.JSONObject(new java.lang.String(com.igexin.c.b.a.c(cursor.getBlob(cursor.getColumnIndex("info")))));
                            java.lang.String string = jSONObject.getString("id");
                            java.lang.String string2 = jSONObject.getString("appid");
                            java.lang.String string3 = jSONObject.getString("messageid");
                            java.lang.String string4 = jSONObject.getString("taskid");
                            java.lang.String string5 = jSONObject.getString("appkey");
                            org.json.JSONArray jSONArray = jSONObject.getJSONArray("action_chains");
                            com.igexin.push.core.a.b.d();
                            java.lang.String a = com.igexin.push.core.a.b.a(string4, string3);
                            com.igexin.push.extension.mod.PushTaskBean pushTaskBean = new com.igexin.push.extension.mod.PushTaskBean();
                            pushTaskBean.setAppid(string2);
                            pushTaskBean.setMessageId(string3);
                            pushTaskBean.setTaskId(string4);
                            pushTaskBean.setId(string);
                            pushTaskBean.setAppKey(string5);
                            pushTaskBean.setCurrentActionid(1);
                            pushTaskBean.setStatus(cursor.getInt(cursor.getColumnIndex("status")));
                            if (blob != null) {
                                pushTaskBean.setMsgExtra(blob);
                            }
                            if (jSONObject.has("condition")) {
                                b(jSONObject, pushTaskBean);
                            }
                            if (jSONArray.length() > 0) {
                                if (a(jSONObject, pushTaskBean)) {
                                    com.igexin.push.core.e.ah.put(a, pushTaskBean);
                                } else {
                                    com.igexin.c.a.c.a.a(b, "load task from db parseActionChains error, " + jSONObject.toString());
                                    com.igexin.c.a.c.a.a("PushMessageExecutor|load task from db parseActionChains error, " + jSONObject.toString(), new java.lang.Object[0]);
                                }
                            }
                        } catch (org.json.JSONException e) {
                            com.igexin.c.a.c.a.a(e);
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                try {
                    com.igexin.c.a.c.a.a(th);
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        }
        return com.igexin.push.core.e.ah.isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00f5, code lost:
    
        if (r1 != null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0107, code lost:
    
        return com.igexin.push.core.e.ah.isEmpty();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean f() {
        android.database.Cursor cursor = null;
        try {
            cursor = com.igexin.push.core.d.a.a.i.a("message", new java.lang.String[]{"status"}, new java.lang.String[]{"0"}, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    byte[] blob = cursor.getBlob(cursor.getColumnIndex("msgextra"));
                    try {
                        org.json.JSONObject jSONObject = new org.json.JSONObject(new java.lang.String(com.igexin.c.b.a.c(cursor.getBlob(cursor.getColumnIndex("info")))));
                        java.lang.String string = jSONObject.getString("id");
                        java.lang.String string2 = jSONObject.getString("appid");
                        java.lang.String string3 = jSONObject.getString("messageid");
                        java.lang.String string4 = jSONObject.getString("taskid");
                        java.lang.String string5 = jSONObject.getString("appkey");
                        org.json.JSONArray jSONArray = jSONObject.getJSONArray("action_chains");
                        com.igexin.push.core.a.b.d();
                        java.lang.String a = com.igexin.push.core.a.b.a(string4, string3);
                        com.igexin.push.extension.mod.PushTaskBean pushTaskBean = new com.igexin.push.extension.mod.PushTaskBean();
                        pushTaskBean.setAppid(string2);
                        pushTaskBean.setMessageId(string3);
                        pushTaskBean.setTaskId(string4);
                        pushTaskBean.setId(string);
                        pushTaskBean.setAppKey(string5);
                        pushTaskBean.setCurrentActionid(1);
                        pushTaskBean.setStatus(cursor.getInt(cursor.getColumnIndex("status")));
                        if (blob != null) {
                            pushTaskBean.setMsgExtra(blob);
                        }
                        if (jSONObject.has("condition")) {
                            b(jSONObject, pushTaskBean);
                        }
                        if (jSONArray.length() > 0) {
                            if (!a(jSONObject, pushTaskBean)) {
                                com.igexin.c.a.c.a.a(b, "load task from db parseActionChains error because load gkt, " + jSONObject.toString());
                                com.igexin.c.a.c.a.a("PushMessageExecutor|load task from db parseActionChains error because load gkt, " + jSONObject.toString(), new java.lang.Object[0]);
                            } else if (!com.igexin.push.core.e.ah.containsKey(a)) {
                                com.igexin.push.core.e.ah.put(a, pushTaskBean);
                            }
                        }
                    } catch (org.json.JSONException e) {
                        com.igexin.c.a.c.a.a(e);
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

    private void g() {
        try {
            java.util.List<android.net.wifi.ScanResult> j = com.igexin.push.h.n.j();
            this.e.clear();
            if (j == null || j.isEmpty()) {
                return;
            }
            for (int i = 0; i < j.size(); i++) {
                this.e.put(j.get(i).BSSID, j.get(i).SSID);
                java.lang.String str = j.get(i).BSSID;
                java.lang.String str2 = j.get(i).SSID;
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public final com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState a(java.lang.String str, java.lang.String str2) {
        com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState actionPrepareState = com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.success;
        com.igexin.push.core.a.b.d();
        com.igexin.push.extension.mod.PushTaskBean pushTaskBean = com.igexin.push.core.e.ah.get(com.igexin.push.core.a.b.a(str, str2));
        if (pushTaskBean == null) {
            return com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.stop;
        }
        int i = 0;
        boolean z = false;
        for (com.igexin.push.extension.mod.BaseActionBean baseActionBean : pushTaskBean.getActionChains()) {
            com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState actionPrepareState2 = com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.stop;
            if (baseActionBean == null) {
                return actionPrepareState2;
            }
            if (!z && com.igexin.push.core.b.q.equals(baseActionBean.getType())) {
                z = true;
            }
            com.igexin.push.extension.mod.PushMessageInterface a = a(baseActionBean.getType());
            if (a != null) {
                actionPrepareState2 = a.prepareExecuteAction(pushTaskBean, baseActionBean);
            } else {
                baseActionBean.getType();
            }
            if (actionPrepareState == com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.success) {
                actionPrepareState = actionPrepareState2;
            }
            if (actionPrepareState2 == com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.wait) {
                i++;
            }
        }
        return (i == 0 || z || com.igexin.push.core.e.a(str, java.lang.Integer.valueOf(i))) ? actionPrepareState : com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.success;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(android.content.Intent intent) {
        java.lang.String stringExtra = intent.getStringExtra("taskid");
        java.lang.String stringExtra2 = intent.getStringExtra("messageid");
        java.lang.String stringExtra3 = intent.getStringExtra("actionid");
        java.lang.String stringExtra4 = intent.getStringExtra("accesstoken");
        java.lang.String stringExtra5 = intent.getStringExtra("url");
        java.lang.String stringExtra6 = intent.getStringExtra(com.huawei.hms.push.constant.RemoteMessageConst.Notification.INTENT_URI);
        java.lang.String stringExtra7 = intent.getStringExtra("payload");
        java.lang.String stringExtra8 = intent.hasExtra("title") ? intent.getStringExtra("title") : "";
        java.lang.String stringExtra9 = intent.hasExtra("content") ? intent.getStringExtra("content") : "";
        int intExtra = intent.getIntExtra("notifID", 0);
        android.app.NotificationManager notificationManager = (android.app.NotificationManager) com.igexin.push.core.e.l.getSystemService(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION);
        if (intExtra == 0) {
            if (com.igexin.push.core.e.ai.containsKey(stringExtra)) {
                intExtra = com.igexin.push.core.e.ai.get(stringExtra).intValue();
            }
            com.igexin.push.core.e.ai.remove(stringExtra);
            if (stringExtra4.equals(com.igexin.push.core.e.an)) {
                return;
            }
            com.igexin.push.core.l.a().a(stringExtra, stringExtra2, stringExtra8, stringExtra9, stringExtra5, stringExtra6, stringExtra7);
            b(stringExtra, stringExtra2, stringExtra3);
            return;
        }
        notificationManager.cancel(intExtra);
        com.igexin.push.core.e.ai.remove(stringExtra);
        if (stringExtra4.equals(com.igexin.push.core.e.an)) {
        }
    }

    public final boolean a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (java.lang.Thread.currentThread().getId() == com.igexin.push.core.d.a.a.a()) {
            return b(str, str2, str3);
        }
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("taskid", str);
        bundle.putString("messageid", str2);
        bundle.putString("actionid", str3);
        android.os.Message obtain = android.os.Message.obtain();
        obtain.what = com.igexin.push.core.b.R;
        obtain.obj = bundle;
        return com.igexin.push.core.d.a.a.a(obtain);
    }

    public final boolean a(org.json.JSONObject jSONObject, com.igexin.push.extension.mod.PushTaskBean pushTaskBean) {
        com.igexin.c.a.c.a.a("PushMessageExecutor------parse pushmessage actionchain json start-------", new java.lang.Object[0]);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            org.json.JSONArray jSONArray = jSONObject.getJSONArray("action_chains");
            for (int i = 0; i < jSONArray.length(); i++) {
                java.lang.String string = ((org.json.JSONObject) jSONArray.get(i)).getString("type");
                if (!this.a.containsKey(string) && !d.contains(string)) {
                    com.igexin.c.a.c.a.a("PushMessageExecutor|" + string + " not support~", new java.lang.Object[0]);
                    return false;
                }
            }
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                org.json.JSONObject jSONObject2 = (org.json.JSONObject) jSONArray.get(i2);
                java.lang.String string2 = jSONObject2.getString("type");
                com.igexin.c.a.c.a.a("PushMessageExecutor|start parse type = ".concat(java.lang.String.valueOf(string2)), new java.lang.Object[0]);
                com.igexin.push.extension.mod.PushMessageInterface a = a(string2);
                if (a != null) {
                    arrayList.add(a.parseAction(jSONObject2));
                }
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        pushTaskBean.setActionChains(arrayList);
        com.igexin.c.a.c.a.b(b, "------parse pushmessage actionchain json end-------");
        return true;
    }

    public final boolean a(org.json.JSONObject jSONObject, byte[] bArr, boolean z) {
        int i;
        int i2;
        try {
            if (!jSONObject.has("action") || !jSONObject.getString("action").equals(com.igexin.push.core.b.D)) {
                return true;
            }
            if (jSONObject.has("appid") && jSONObject.has("messageid") && jSONObject.has("taskid") && (!jSONObject.has("appid") || jSONObject.getString("appid").equals(com.igexin.push.core.e.a))) {
                java.lang.String string = jSONObject.getString("id");
                java.lang.String string2 = jSONObject.getString("appid");
                java.lang.String string3 = jSONObject.getString("messageid");
                java.lang.String string4 = jSONObject.getString("taskid");
                java.lang.String string5 = jSONObject.getString("appkey");
                org.json.JSONArray jSONArray = jSONObject.getJSONArray("action_chains");
                com.igexin.c.a.c.a.a("pushmessage|" + string4 + "|" + string3 + "|" + string2 + "|" + z, new java.lang.Object[0]);
                com.igexin.push.extension.mod.PushTaskBean pushTaskBean = new com.igexin.push.extension.mod.PushTaskBean();
                pushTaskBean.setAppid(string2);
                pushTaskBean.setMessageId(string3);
                pushTaskBean.setTaskId(string4);
                pushTaskBean.setId(string);
                pushTaskBean.setAppKey(string5);
                pushTaskBean.setCurrentActionid(1);
                com.igexin.push.core.a.b.d();
                java.lang.String a = com.igexin.push.core.a.b.a(string4, string3);
                if (z) {
                    com.igexin.sdk.main.FeedbackImpl.getInstance().asyncFeedback(new com.igexin.push.core.n.AnonymousClass1(pushTaskBean));
                    if (com.igexin.push.h.c.b(string4)) {
                        com.igexin.c.a.c.a.a("PushMessageExecutor|" + string4 + " in blacklist ###", new java.lang.Object[0]);
                        return false;
                    }
                    if (com.igexin.push.h.c.a(jSONObject)) {
                        com.igexin.c.a.c.a.a("PushMessageExecutor|message have loop", new java.lang.Object[0]);
                        return false;
                    }
                    try {
                        com.igexin.push.core.e.c.a();
                        if (com.igexin.push.core.e.c.a(string4)) {
                            com.igexin.c.a.c.a.a(b, "taskid = " + string4 + ", has already process @@####");
                            return false;
                        }
                        android.content.ContentValues contentValues = new android.content.ContentValues();
                        contentValues.put("messageid", string3);
                        contentValues.put("taskid", string4);
                        contentValues.put("appid", string2);
                        contentValues.put("key", com.igexin.push.core.b.k.concat(java.lang.String.valueOf(a)));
                        contentValues.put("info", com.igexin.c.b.a.b(jSONObject.toString().getBytes()));
                        contentValues.put("createtime", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
                        if (bArr != null) {
                            contentValues.put("msgextra", bArr);
                            pushTaskBean.setMsgExtra(bArr);
                        }
                        if (jSONObject.has("condition")) {
                            b(jSONObject, pushTaskBean);
                        }
                        pushTaskBean.setStatus(com.igexin.push.core.b.af);
                        contentValues.put("status", java.lang.Integer.valueOf(com.igexin.push.core.b.af));
                        com.igexin.push.core.e.c a2 = com.igexin.push.core.e.c.a();
                        try {
                            if (a2.a == -1) {
                                a2.a = com.igexin.push.core.e.c.b();
                            }
                            if (a2.a >= 1000) {
                                int a3 = com.igexin.push.core.d.a.a.i.a("message", "id IN (SELECT id from message where status IS NULL or status=1 or status=2 order by id asc limit 250)");
                                a2.a -= a3;
                                if (a3 < 250) {
                                    a2.a -= com.igexin.push.core.d.a.a.i.a("message", "id IN (SELECT id from message where status=0 order by id asc limit " + (250 - a3) + ")");
                                }
                                if (com.igexin.push.core.d.a.a.i.a("message", contentValues) != -1) {
                                    i = a2.a;
                                    i2 = 1;
                                }
                            } else if (com.igexin.push.core.d.a.a.i.a("message", contentValues) != -1) {
                                i = a2.a;
                                i2 = 1;
                            }
                            a2.a = i + i2;
                        } catch (java.lang.Throwable th) {
                            com.igexin.c.a.c.a.a(th);
                        }
                    } catch (java.lang.Throwable th2) {
                        com.igexin.c.a.c.a.a(th2);
                    }
                }
                if (jSONArray.length() > 0 && !a(jSONObject, pushTaskBean)) {
                    com.igexin.c.a.c.a.a(b, "parseActionChains result = false #######");
                    com.igexin.c.a.c.a.a("PushMessageExecutor parseActionChains result = false #######", new java.lang.Object[0]);
                    return false;
                }
                if (!z) {
                    if (jSONObject.has("condition")) {
                        b(jSONObject, pushTaskBean);
                    }
                    com.igexin.push.core.e.ah.put(a, pushTaskBean);
                    return true;
                }
                com.igexin.push.core.e.ah.put(a, pushTaskBean);
                if (com.igexin.push.h.c.a(java.lang.System.currentTimeMillis())) {
                    com.igexin.c.a.c.a.b(b, "message in silent time, ignored...");
                    return false;
                }
                if (jSONObject.has("condition")) {
                    c();
                    return true;
                }
                b(string4, string3);
                return true;
            }
            com.igexin.c.a.c.a.a("PushMessageExecutor receive error pushmessage", new java.lang.Object[0]);
            return false;
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
            com.igexin.c.a.c.a.a("PushMessageExecutor " + e.toString(), new java.lang.Object[0]);
            return true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b6, code lost:
    
        if (r4 == null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.igexin.push.extension.mod.PushMessageInterface a;
        com.igexin.push.core.a.b.d();
        java.lang.String a2 = com.igexin.push.core.a.b.a(str, str2);
        com.igexin.c.a.c.a.b(b, "executePushMessageAction taskid:" + str + ", actionid:" + str3);
        com.igexin.push.extension.mod.PushTaskBean pushTaskBean = com.igexin.push.core.e.ah.get(a2);
        if (pushTaskBean == null) {
            android.database.Cursor cursor = null;
            try {
                cursor = com.igexin.push.core.d.a.a.i.a("message", new java.lang.String[]{"taskid", "messageid"}, new java.lang.String[]{str, str2}, null, null);
            } catch (java.lang.Throwable th) {
                try {
                    com.igexin.c.a.c.a.a(th);
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
            if (cursor != null && cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    a().a(new org.json.JSONObject(new java.lang.String(com.igexin.c.b.a.c(cursor.getBlob(cursor.getColumnIndexOrThrow("info"))))), cursor.getBlob(cursor.getColumnIndexOrThrow("msgextra")), false);
                    com.igexin.push.extension.mod.PushTaskBean pushTaskBean2 = com.igexin.push.core.e.ah.get(str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + str2);
                    if (pushTaskBean2 == null) {
                        cursor.close();
                        return false;
                    }
                    pushTaskBean = pushTaskBean2;
                }
                cursor.close();
            }
            return false;
        }
        int executeTimes = pushTaskBean.getExecuteTimes();
        if (executeTimes >= 50) {
            try {
                com.igexin.push.core.e.ah.remove(a2);
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
                com.igexin.c.a.c.a.a("PushMessageExecutor|" + e.toString(), new java.lang.Object[0]);
            }
            return true;
        }
        pushTaskBean.setExecuteTimes(executeTimes + 1);
        com.igexin.sdk.main.FeedbackImpl.getInstance().asyncFeedback(new com.igexin.push.core.n.AnonymousClass2(pushTaskBean, str3));
        try {
            com.igexin.push.extension.mod.BaseActionBean baseAction = pushTaskBean.getBaseAction(str3);
            if (baseAction != null && (a = a(baseAction.getType())) != null) {
                return a.executeAction(pushTaskBean, baseAction);
            }
        } catch (java.lang.Throwable th2) {
            com.igexin.c.a.c.a.a(th2);
        }
        return false;
    }

    public final void c() {
        try {
            if (com.igexin.push.h.c.a(java.lang.System.currentTimeMillis())) {
                com.igexin.c.a.c.a.b(b, "message in silent time , ignored...");
                return;
            }
            if (e()) {
                return;
            }
            for (java.util.Map.Entry<java.lang.String, com.igexin.push.extension.mod.PushTaskBean> entry : com.igexin.push.core.e.ah.entrySet()) {
                try {
                    entry.getKey();
                    com.igexin.push.extension.mod.PushTaskBean value = entry.getValue();
                    if (value != null && value.getStatus() == com.igexin.push.core.b.af) {
                        java.lang.String taskId = value.getTaskId();
                        java.util.Map<java.lang.String, java.lang.String> conditionMap = value.getConditionMap();
                        if (conditionMap == null) {
                            return;
                        }
                        if (a(conditionMap, taskId, value)) {
                            b(taskId, value.getMessageId());
                        }
                    }
                } catch (java.lang.Exception e) {
                    com.igexin.c.a.c.a.a(e);
                    com.igexin.c.a.c.a.a("PushMessageExecutor|" + e.toString(), new java.lang.Object[0]);
                }
            }
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            com.igexin.c.a.c.a.a("PushMessageExecutor|" + e2.toString(), new java.lang.Object[0]);
        }
    }

    public final void d() {
        com.igexin.c.a.c.a.a("PushMessageExecutor|--------checkConditionStatus the pushMessageMap from db because log gkt...", new java.lang.Object[0]);
        try {
            if (com.igexin.push.h.c.a(java.lang.System.currentTimeMillis())) {
                com.igexin.c.a.c.a.b(b, "message in silent time , ignored...");
                return;
            }
            if (f()) {
                return;
            }
            for (java.util.Map.Entry<java.lang.String, com.igexin.push.extension.mod.PushTaskBean> entry : com.igexin.push.core.e.ah.entrySet()) {
                try {
                    entry.getKey();
                    com.igexin.push.extension.mod.PushTaskBean value = entry.getValue();
                    if (value != null && value.getStatus() == com.igexin.push.core.b.af) {
                        java.lang.String taskId = value.getTaskId();
                        java.util.Map<java.lang.String, java.lang.String> conditionMap = value.getConditionMap();
                        if (conditionMap == null) {
                            return;
                        }
                        if (a(conditionMap, taskId, value)) {
                            b(taskId, value.getMessageId());
                        }
                    }
                } catch (java.lang.Exception e) {
                    com.igexin.c.a.c.a.a(e);
                    com.igexin.c.a.c.a.a("PushMessageExecutor|" + e.toString(), new java.lang.Object[0]);
                }
            }
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            com.igexin.c.a.c.a.a("PushMessageExecutor|" + e2.toString(), new java.lang.Object[0]);
        }
    }
}
