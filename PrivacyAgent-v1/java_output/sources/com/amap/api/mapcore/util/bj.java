package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class bj {
    public static long a() {
        if (!android.os.Environment.getExternalStorageState().equals("mounted")) {
            return 0L;
        }
        android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath());
        return statFs.getFreeBlocks() * statFs.getBlockSize();
    }

    public static long a(java.io.File file) {
        if (!file.isDirectory()) {
            return file.length();
        }
        java.io.File[] listFiles = file.listFiles();
        long j = 0;
        if (listFiles == null) {
            return 0L;
        }
        for (java.io.File file2 : listFiles) {
            j += file2.isDirectory() ? a(file2) : file2.length();
        }
        return j;
    }

    private static com.amap.api.maps.offlinemap.OfflineMapProvince a(org.json.JSONObject jSONObject) throws org.json.JSONException {
        if (jSONObject == null) {
            return null;
        }
        com.amap.api.maps.offlinemap.OfflineMapProvince offlineMapProvince = new com.amap.api.maps.offlinemap.OfflineMapProvince();
        offlineMapProvince.setUrl(a(jSONObject, "url"));
        offlineMapProvince.setProvinceName(a(jSONObject, "name"));
        offlineMapProvince.setJianpin(a(jSONObject, "jianpin"));
        offlineMapProvince.setPinyin(a(jSONObject, "pinyin"));
        offlineMapProvince.setProvinceCode(c(a(jSONObject, "adcode")));
        offlineMapProvince.setVersion(a(jSONObject, "version"));
        offlineMapProvince.setSize(java.lang.Long.parseLong(a(jSONObject, com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE)));
        offlineMapProvince.setCityList(b(jSONObject));
        return offlineMapProvince;
    }

    public static java.lang.String a(android.content.Context context, java.lang.String str) {
        try {
            return com.amap.api.mapcore.util.dl.a(com.amap.api.mapcore.util.df.a(context).open(str));
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "MapDownloadManager", "readOfflineAsset");
            th.printStackTrace();
            return null;
        }
    }

    private static java.lang.String a(org.json.JSONObject jSONObject, java.lang.String str) throws org.json.JSONException {
        return (jSONObject == null || !jSONObject.has(str) || "[]".equals(jSONObject.getString(str))) ? "" : jSONObject.optString(str).trim();
    }

    public static java.util.List<com.amap.api.maps.offlinemap.OfflineMapProvince> a(java.lang.String str, android.content.Context context) throws org.json.JSONException {
        return (str == null || "".equals(str)) ? new java.util.ArrayList() : a(new org.json.JSONObject(str), context);
    }

    public static java.util.List<com.amap.api.maps.offlinemap.OfflineMapProvince> a(org.json.JSONObject jSONObject, android.content.Context context) throws org.json.JSONException {
        org.json.JSONObject optJSONObject;
        org.json.JSONObject optJSONObject2;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (jSONObject.has("result")) {
            optJSONObject = jSONObject.optJSONObject("result");
        } else {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            try {
                jSONObject2.put("result", new org.json.JSONObject().put("offlinemap_with_province_vfour", jSONObject));
                c(jSONObject2.toString(), context);
                optJSONObject = jSONObject2.optJSONObject("result");
            } catch (org.json.JSONException e) {
                org.json.JSONObject optJSONObject3 = jSONObject.optJSONObject("result");
                com.amap.api.mapcore.util.gd.c(e, "Utility", "parseJson");
                e.printStackTrace();
                optJSONObject = optJSONObject3;
            }
        }
        if (optJSONObject != null) {
            org.json.JSONObject optJSONObject4 = optJSONObject.optJSONObject("offlinemap_with_province_vfour");
            if (optJSONObject4 == null) {
                return arrayList;
            }
            optJSONObject2 = optJSONObject4.optJSONObject("offlinemapinfo_with_province");
        } else {
            optJSONObject2 = jSONObject.optJSONObject("offlinemapinfo_with_province");
        }
        if (optJSONObject2 == null) {
            return arrayList;
        }
        if (optJSONObject2.has("version")) {
            com.amap.api.mapcore.util.am.d = a(optJSONObject2, "version");
        }
        org.json.JSONArray optJSONArray = optJSONObject2.optJSONArray("provinces");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            org.json.JSONObject optJSONObject5 = optJSONArray.optJSONObject(i);
            if (optJSONObject5 != null) {
                arrayList.add(a(optJSONObject5));
            }
        }
        org.json.JSONArray optJSONArray2 = optJSONObject2.optJSONArray("others");
        org.json.JSONObject jSONObject3 = (optJSONArray2 == null || optJSONArray2.length() <= 0) ? null : optJSONArray2.getJSONObject(0);
        if (jSONObject3 == null) {
            return arrayList;
        }
        arrayList.add(a(jSONObject3));
        return arrayList;
    }

    public static void a(java.lang.String str) {
        java.io.File[] listFiles;
        java.io.File file = new java.io.File(str);
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (java.io.File file2 : listFiles) {
                if (file2.exists() && file2.isDirectory()) {
                    java.lang.String[] list = file2.list();
                    if (list == null) {
                        file2.delete();
                    } else if (list.length == 0) {
                        file2.delete();
                    }
                }
            }
        }
    }

    public static java.lang.String b(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return null;
            }
            return str.substring(str.lastIndexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) + 1, str.indexOf(".zip"));
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "Utility", "getZipFileNameFromUrl");
            return null;
        }
    }

    private static java.util.ArrayList<com.amap.api.maps.offlinemap.OfflineMapCity> b(org.json.JSONObject jSONObject) throws org.json.JSONException {
        org.json.JSONArray optJSONArray = jSONObject.optJSONArray("cities");
        java.util.ArrayList<com.amap.api.maps.offlinemap.OfflineMapCity> arrayList = new java.util.ArrayList<>();
        if (optJSONArray == null) {
            return arrayList;
        }
        if (optJSONArray.length() == 0) {
            arrayList.add(c(jSONObject));
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            org.json.JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(c(optJSONObject));
            }
        }
        return arrayList;
    }

    public static void b(java.lang.String str, android.content.Context context) throws java.io.IOException, java.lang.Exception {
        java.io.File[] listFiles = new java.io.File(com.amap.api.mapcore.util.dl.c(context)).listFiles();
        if (listFiles == null) {
            return;
        }
        for (java.io.File file : listFiles) {
            if (file.exists() && file.getName().contains(str)) {
                b(file);
            }
        }
        a(com.amap.api.mapcore.util.dl.c(context));
    }

    public static boolean b(java.io.File file) throws java.io.IOException, java.lang.Exception {
        if (file == null || !file.exists()) {
            return false;
        }
        java.io.File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isFile()) {
                    if (!listFiles[i].delete()) {
                        return false;
                    }
                } else if (!b(listFiles[i])) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    private static com.amap.api.maps.offlinemap.OfflineMapCity c(org.json.JSONObject jSONObject) throws org.json.JSONException {
        com.amap.api.maps.offlinemap.OfflineMapCity offlineMapCity = new com.amap.api.maps.offlinemap.OfflineMapCity();
        offlineMapCity.setAdcode(c(a(jSONObject, "adcode")));
        offlineMapCity.setUrl(a(jSONObject, "url"));
        offlineMapCity.setCity(a(jSONObject, "name"));
        offlineMapCity.setCode(a(jSONObject, "citycode"));
        offlineMapCity.setPinyin(a(jSONObject, "pinyin"));
        offlineMapCity.setJianpin(a(jSONObject, "jianpin"));
        offlineMapCity.setVersion(a(jSONObject, "version"));
        offlineMapCity.setSize(java.lang.Long.parseLong(a(jSONObject, com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE)));
        return offlineMapCity;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public static java.lang.String c(java.io.File file) {
        java.io.FileInputStream fileInputStream;
        java.io.BufferedReader bufferedReader;
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        ?? r2 = 0;
        r2 = 0;
        try {
            try {
                try {
                    fileInputStream = new java.io.FileInputStream(file);
                } catch (java.lang.Throwable th) {
                    th = th;
                    r2 = file;
                }
            } catch (java.io.FileNotFoundException e) {
                e = e;
                bufferedReader = null;
                fileInputStream = null;
            } catch (java.io.IOException e2) {
                e = e2;
                bufferedReader = null;
                fileInputStream = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
                fileInputStream = null;
            }
            try {
                bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(fileInputStream, "utf-8"));
                while (true) {
                    try {
                        java.lang.String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    } catch (java.io.FileNotFoundException e3) {
                        e = e3;
                        com.amap.api.mapcore.util.gd.c(e, "MapDownloadManager", "readOfflineSD filenotfound");
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (java.io.IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return null;
                    } catch (java.io.IOException e5) {
                        e = e5;
                        com.amap.api.mapcore.util.gd.c(e, "MapDownloadManager", "readOfflineSD io");
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (java.io.IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return null;
                    }
                }
                java.lang.String stringBuffer2 = stringBuffer.toString();
                try {
                    bufferedReader.close();
                } catch (java.io.IOException e7) {
                    e7.printStackTrace();
                }
                try {
                    fileInputStream.close();
                } catch (java.io.IOException e8) {
                    e8.printStackTrace();
                }
                return stringBuffer2;
            } catch (java.io.FileNotFoundException e9) {
                e = e9;
                bufferedReader = null;
            } catch (java.io.IOException e10) {
                e = e10;
                bufferedReader = null;
            } catch (java.lang.Throwable th3) {
                th = th3;
                if (r2 != 0) {
                    try {
                        r2.close();
                    } catch (java.io.IOException e11) {
                        e11.printStackTrace();
                    }
                }
                if (fileInputStream == null) {
                    throw th;
                }
                try {
                    fileInputStream.close();
                    throw th;
                } catch (java.io.IOException e12) {
                    e12.printStackTrace();
                    throw th;
                }
            }
        } catch (java.io.IOException e13) {
            e13.printStackTrace();
        }
    }

    private static java.lang.String c(java.lang.String str) {
        return "000001".equals(str) ? com.alimm.tanx.core.constant.AdConstants.PID_STYLE_DEFAULT_ID : str;
    }

    public static void c(java.lang.String str, android.content.Context context) {
        java.io.FileOutputStream fileOutputStream;
        if ("".equals(com.amap.api.mapcore.util.dl.c(context))) {
            return;
        }
        java.io.File file = new java.io.File(com.amap.api.mapcore.util.dl.c(context) + "offlinemapv4.png");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (java.io.IOException e) {
                com.amap.api.mapcore.util.gd.c(e, "OfflineUpdateCityHandlerAbstract", "writeSD dirCreate");
                e.printStackTrace();
            }
        }
        if (a() > 1048576) {
            java.io.FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new java.io.FileOutputStream(file);
                } catch (java.lang.Throwable th) {
                    th = th;
                }
            } catch (java.io.FileNotFoundException e2) {
                e = e2;
            } catch (java.io.IOException e3) {
                e = e3;
            }
            try {
                fileOutputStream.write(str.getBytes("utf-8"));
                try {
                    fileOutputStream.close();
                } catch (java.io.IOException e4) {
                    e4.printStackTrace();
                }
            } catch (java.io.FileNotFoundException e5) {
                e = e5;
                fileOutputStream2 = fileOutputStream;
                com.amap.api.mapcore.util.gd.c(e, "OfflineUpdateCityHandlerAbstract", "writeSD filenotfound");
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (java.io.IOException e6) {
                        e6.printStackTrace();
                    }
                }
            } catch (java.io.IOException e7) {
                e = e7;
                fileOutputStream2 = fileOutputStream;
                com.amap.api.mapcore.util.gd.c(e, "OfflineUpdateCityHandlerAbstract", "writeSD io");
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (java.io.IOException e8) {
                        e8.printStackTrace();
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (java.io.IOException e9) {
                        e9.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }
}
