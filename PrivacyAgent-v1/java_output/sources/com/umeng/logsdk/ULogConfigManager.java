package com.umeng.logsdk;

/* loaded from: classes19.dex */
public class ULogConfigManager {
    private android.content.Context b;
    private com.efs.sdk.base.EfsReporter c;
    private final java.lang.String a = "ULogConfigManager";
    private java.util.Vector<com.umeng.logsdk.b> d = new java.util.Vector<>();

    /* renamed from: com.umeng.logsdk.ULogConfigManager$1, reason: invalid class name */
    public class AnonymousClass1 implements com.efs.sdk.base.observer.IConfigCallback {
        public AnonymousClass1() {
        }

        @Override // com.efs.sdk.base.observer.IConfigCallback
        public final void onChange(java.util.Map<java.lang.String, java.lang.Object> map) {
            android.content.SharedPreferences.Editor edit;
            java.lang.String str;
            java.lang.String str2;
            java.lang.StringBuilder sb;
            if (map != null) {
                try {
                    com.efs.sdk.base.core.util.Log.i("ULogConfigManager", "[log register] call back config.");
                    android.content.SharedPreferences sharedPreferences = com.umeng.logsdk.ULogConfigManager.this.b.getSharedPreferences("efs_ulog", 0);
                    if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
                        return;
                    }
                    java.lang.Object obj = map.get(com.umeng.logsdk.a.d);
                    java.lang.String str3 = "";
                    if (obj != null) {
                        str = obj.toString();
                        edit.putString(com.umeng.logsdk.a.d, str);
                        com.efs.sdk.base.core.util.Log.i("ULogConfigManager", "[log register] save did is ".concat(java.lang.String.valueOf(str)));
                    } else {
                        str = "";
                    }
                    java.lang.Object obj2 = map.get(com.umeng.logsdk.a.c);
                    if (obj2 != null) {
                        java.lang.String obj3 = obj2.toString();
                        com.efs.sdk.base.core.util.Log.i("ULogConfigManager", "[log register] save uid before base64 is ".concat(java.lang.String.valueOf(obj3)));
                        str2 = com.umeng.logsdk.c.a(obj3.getBytes());
                        edit.putString(com.umeng.logsdk.a.c, str2);
                        com.efs.sdk.base.core.util.Log.i("ULogConfigManager", "[log register] save uid after base64 is ".concat(java.lang.String.valueOf(str2)));
                    } else {
                        str2 = "";
                    }
                    java.lang.Object obj4 = map.get(com.umeng.logsdk.a.g);
                    if (obj4 != null && str2.equals(com.umeng.logsdk.ULogManager.getUserID()) && str.equals(com.umeng.logsdk.ULogManager.getDeviceID())) {
                        java.lang.String obj5 = obj4.toString();
                        if (!android.text.TextUtils.isEmpty(obj5)) {
                            org.json.JSONArray jSONArray = new org.json.JSONArray(obj5);
                            for (int i = 0; i < jSONArray.length(); i++) {
                                org.json.JSONObject jSONObject = jSONArray.getJSONObject(i);
                                if (jSONObject != null) {
                                    java.lang.String optString = jSONObject.optString(com.umeng.logsdk.a.h, com.umeng.logsdk.a.p);
                                    if (!android.text.TextUtils.isEmpty(optString)) {
                                        if (android.text.TextUtils.isEmpty(str3)) {
                                            sb = new java.lang.StringBuilder();
                                            sb.append(str3);
                                            sb.append(optString);
                                        } else {
                                            sb = new java.lang.StringBuilder();
                                            sb.append(str3);
                                            sb.append("_");
                                            sb.append(optString);
                                        }
                                        str3 = sb.toString();
                                        edit.putString(optString, jSONObject.toString());
                                        com.efs.sdk.base.core.util.Log.i("ULogConfigManager", "[log register] save task id is " + optString + ", task is " + jSONObject.toString());
                                        com.umeng.logsdk.b bVar = new com.umeng.logsdk.b();
                                        int optInt = jSONObject.optInt(com.umeng.logsdk.a.i, -1);
                                        int optInt2 = jSONObject.optInt(com.umeng.logsdk.a.j, -1);
                                        if (optInt == 0) {
                                            java.lang.String str4 = optInt2 == 0 ? str2 : optInt2 == 1 ? str : null;
                                            if (!android.text.TextUtils.isEmpty(str4)) {
                                                bVar.a = optString;
                                                bVar.b = optInt;
                                                bVar.c = optInt2;
                                                bVar.d = str4;
                                                bVar.e = jSONObject.optLong(com.umeng.logsdk.a.l, 0L);
                                                bVar.f = jSONObject.optLong(com.umeng.logsdk.a.m, 0L);
                                                com.efs.sdk.base.core.util.Log.i("ULogConfigManager", "[log register] add mem task id is ".concat(java.lang.String.valueOf(optString)));
                                                com.umeng.logsdk.ULogConfigManager.this.d.add(bVar);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (!android.text.TextUtils.isEmpty(str3)) {
                        edit.putString(com.umeng.logsdk.a.e, str3);
                        com.efs.sdk.base.core.util.Log.i("ULogConfigManager", "[log register] save task id set is ".concat(java.lang.String.valueOf(str3)));
                    }
                    edit.commit();
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public ULogConfigManager(android.content.Context context, com.efs.sdk.base.EfsReporter efsReporter) {
        this.b = context.getApplicationContext();
        this.c = efsReporter;
        if (efsReporter != null) {
            com.efs.sdk.base.core.util.Log.i("ULogConfigManager", "[log register] begin.");
            this.c.getAllSdkConfig(new java.lang.String[]{com.umeng.logsdk.a.d, com.umeng.logsdk.a.c, com.umeng.logsdk.a.g}, new com.umeng.logsdk.ULogConfigManager.AnonymousClass1());
        }
    }

    public java.util.List<com.umeng.logsdk.b> getTaskList() {
        return this.d;
    }

    public void reMoveTaskFroSP(java.lang.String str) {
        java.lang.String[] split;
        try {
            com.efs.sdk.base.core.util.Log.i("ULogConfigManager", "[log remove] remove sp. delete task id is ".concat(java.lang.String.valueOf(str)));
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            android.content.SharedPreferences sharedPreferences = this.b.getSharedPreferences("efs_ulog", 0);
            if (sharedPreferences == null || sharedPreferences.edit() == null) {
                return;
            }
            android.content.SharedPreferences.Editor edit = sharedPreferences.edit();
            java.lang.String string = sharedPreferences.getString(com.umeng.logsdk.a.d, "");
            java.lang.String string2 = sharedPreferences.getString(com.umeng.logsdk.a.c, "");
            java.lang.String string3 = sharedPreferences.getString(com.umeng.logsdk.a.e, "");
            if (!string2.equals(com.umeng.logsdk.ULogManager.getUserID()) || !string.equals(com.umeng.logsdk.ULogManager.getDeviceID()) || android.text.TextUtils.isEmpty(string3) || (split = string3.split("_")) == null) {
                return;
            }
            for (int i = 0; i < split.length; i++) {
                java.lang.String str2 = split[i];
                if (!android.text.TextUtils.isEmpty(str2) && str2.equals(str)) {
                    com.efs.sdk.base.core.util.Log.i("ULogConfigManager", "[log remove] taskId is ".concat(str2));
                    if (string3.equals(str2)) {
                        string3 = "";
                    } else {
                        string3 = string3.replaceFirst(i == split.length - 1 ? "_".concat(str2) : str2 + "_", "");
                    }
                    com.efs.sdk.base.core.util.Log.i("ULogConfigManager", "[log remove] put id set is ".concat(java.lang.String.valueOf(string3)));
                    edit.putString(com.umeng.logsdk.a.e, string3);
                    edit.remove(str2);
                    edit.commit();
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void removeTask(com.umeng.logsdk.b bVar) {
        java.util.Vector<com.umeng.logsdk.b> vector = this.d;
        if (vector == null || !vector.contains(bVar)) {
            return;
        }
        com.efs.sdk.base.core.util.Log.i("ULogConfigManager", "[log remove] remove mem. task id is " + bVar.a);
        this.d.remove(bVar);
    }
}
