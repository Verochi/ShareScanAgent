package com.bytedance.pangle.d;

/* loaded from: classes12.dex */
public final class b {
    private static java.lang.String a;
    private static java.util.Map<java.lang.String, java.lang.Integer> b;

    static {
        java.util.HashMap hashMap = new java.util.HashMap();
        b = hashMap;
        hashMap.put("arm64-v8a", 64);
        b.put("armeabi-v7a", 32);
        b.put("armeabi", 32);
        b.put("x86_64", 64);
        b.put("x86", 32);
        b.put("mips64", 64);
        b.put("mips", 32);
        a = c();
    }

    public static com.bytedance.pangle.util.e<java.lang.Boolean, java.util.Map<java.lang.String, java.util.List<java.util.zip.ZipEntry>>> a(java.io.File file) {
        java.util.zip.ZipFile zipFile;
        boolean z;
        java.util.HashMap hashMap = new java.util.HashMap();
        java.util.zip.ZipFile zipFile2 = null;
        try {
            try {
                zipFile = new java.util.zip.ZipFile(file);
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.io.IOException e) {
            e = e;
        }
        try {
            hashMap.putAll(a(zipFile));
            if (hashMap.isEmpty()) {
                com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [true] soEntries empty, ".concat(java.lang.String.valueOf(file)));
                z = true;
            } else {
                boolean a2 = a(hashMap, a);
                if (a2) {
                    com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [" + a2 + "], " + file);
                } else {
                    com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [" + a2 + "], " + file);
                }
                z = a2;
            }
            com.bytedance.pangle.util.e<java.lang.Boolean, java.util.Map<java.lang.String, java.util.List<java.util.zip.ZipEntry>>> eVar = new com.bytedance.pangle.util.e<>(java.lang.Boolean.valueOf(z), hashMap);
            try {
                zipFile.close();
            } catch (java.io.IOException unused) {
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
            }
            return eVar;
        } catch (java.io.IOException e2) {
            e = e2;
            zipFile2 = zipFile;
            com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, get sourceApk ZipFile failed!", e);
            com.bytedance.pangle.util.e<java.lang.Boolean, java.util.Map<java.lang.String, java.util.List<java.util.zip.ZipEntry>>> eVar2 = new com.bytedance.pangle.util.e<>(java.lang.Boolean.FALSE, hashMap);
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (java.io.IOException unused2) {
                    com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
                }
            }
            return eVar2;
        } catch (java.lang.Throwable th2) {
            th = th2;
            zipFile2 = zipFile;
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (java.io.IOException unused3) {
                    com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
                }
            }
            throw th;
        }
    }

    public static java.lang.String a() {
        java.lang.String str = a;
        if (str != null) {
            return str;
        }
        java.lang.String c = c();
        a = c;
        return c;
    }

    private static java.lang.String a(org.json.JSONObject jSONObject) {
        boolean is64Bit;
        if (!com.bytedance.pangle.util.i.a()) {
            return null;
        }
        try {
            java.lang.String str = (java.lang.String) com.bytedance.pangle.util.FieldUtils.readField(com.bytedance.pangle.Zeus.getAppApplication().getApplicationInfo(), "primaryCpuAbi");
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, primaryCpuAbi=".concat(java.lang.String.valueOf(str)));
            a(jSONObject, "primaryCpuAbi", str);
            if (str == null) {
                return null;
            }
            int i = 0;
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                try {
                    is64Bit = android.os.Process.is64Bit();
                    i = is64Bit ? 64 : 32;
                    com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, processMode=".concat(java.lang.String.valueOf(i)));
                } catch (java.lang.Exception unused) {
                    com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, processMode exception default=".concat(java.lang.String.valueOf(i)));
                }
            } else {
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, processMode default=0");
            }
            a(jSONObject, "processMode", java.lang.String.valueOf(i));
            if (i == 0) {
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto1, sHostAbi=".concat(str));
                return str;
            }
            if (b.get(str).intValue() != i) {
                return null;
            }
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto2, sHostAbi=".concat(str));
            return str;
        } catch (java.lang.Exception e) {
            com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto failed!", e);
            a(jSONObject, "autoError", "1");
            return null;
        }
    }

    private static java.util.Map<java.lang.String, java.util.List<java.util.zip.ZipEntry>> a(java.util.zip.ZipFile zipFile) {
        java.lang.String[] split;
        java.util.HashMap hashMap = new java.util.HashMap();
        java.util.Enumeration<? extends java.util.zip.ZipEntry> entries = zipFile.entries();
        java.util.regex.Pattern compile = java.util.regex.Pattern.compile("^lib/[^/]+/lib[^/]+.so$");
        while (entries.hasMoreElements()) {
            java.util.zip.ZipEntry nextElement = entries.nextElement();
            if (!nextElement.isDirectory() && !nextElement.getName().contains("../") && nextElement.getName().startsWith("lib/") && compile.matcher(nextElement.getName()).matches() && (split = nextElement.getName().split(java.io.File.separator)) != null && split.length >= 2) {
                java.lang.String str = split[split.length - 2];
                if (b.containsKey(str)) {
                    if (hashMap.get(str) == null) {
                        hashMap.put(str, new java.util.LinkedList());
                    }
                    ((java.util.List) hashMap.get(str)).add(nextElement);
                }
            }
        }
        com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_SO, "NativeLibHelper getAllSoZipEntries, zipFile=" + zipFile.getName() + ", soEntries=" + hashMap.toString());
        return hashMap;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0147, code lost:
    
        if (r1.isEmpty() == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x014e, code lost:
    
        if (r17.exists() != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0150, code lost:
    
        r17.mkdirs();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0153, code lost:
    
        r1 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x015b, code lost:
    
        if (r1.hasNext() == false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x015d, code lost:
    
        a(r2, (java.util.zip.ZipEntry) r1.next(), r17);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(java.io.File file, java.io.File file2, java.lang.String str, java.util.Map<java.lang.String, java.util.List<java.util.zip.ZipEntry>> map) {
        java.util.Map<java.lang.String, java.util.List<java.util.zip.ZipEntry>> a2;
        char c;
        java.util.zip.ZipFile zipFile = null;
        r1 = null;
        java.util.LinkedList linkedList = null;
        try {
            com.bytedance.pangle.plugin.Plugin plugin = com.bytedance.pangle.Zeus.getPlugin(str);
            if (plugin.mSharedHostSos.size() != 0) {
                java.util.ArrayList arrayList = new java.util.ArrayList(plugin.mSharedHostSos);
                java.lang.String str2 = com.bytedance.pangle.Zeus.getAppApplication().getApplicationInfo().nativeLibraryDir;
                if (!android.text.TextUtils.isEmpty(str2)) {
                    java.lang.String[] split = str2.split(java.io.File.pathSeparator);
                    for (java.lang.String str3 : plugin.mSharedHostSos) {
                        for (java.lang.String str4 : split) {
                            java.io.File file3 = new java.io.File(str4, str3);
                            if (arrayList.contains(str3) && file3.exists()) {
                                com.bytedance.pangle.util.h.a(file3.getAbsolutePath(), new java.io.File(file2, str3).getAbsolutePath());
                                com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "NativeLibHelper copySoFromHost, hostSoPath=" + file3.getAbsolutePath());
                                arrayList.remove(str3);
                            }
                        }
                    }
                }
            }
            java.util.zip.ZipFile zipFile2 = new java.util.zip.ZipFile(file);
            if (map == null) {
                try {
                    a2 = a(zipFile2);
                } catch (java.lang.Throwable th) {
                    th = th;
                    zipFile = zipFile2;
                    if (zipFile != null) {
                        zipFile.close();
                    }
                    throw th;
                }
            } else {
                a2 = map;
            }
            boolean a3 = a(a2, a);
            com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_SO, "NativeLibHelper copyNativeLib pre-verify-matchHostAbi[" + a3 + "], pkg=" + str);
            if (a3) {
                if (a2 != null && !a2.isEmpty()) {
                    linkedList = new java.util.LinkedList();
                    java.util.HashSet hashSet = new java.util.HashSet();
                    java.lang.String str5 = a;
                    switch (str5.hashCode()) {
                        case -1073971299:
                            if (str5.equals("mips64")) {
                                c = 5;
                                break;
                            }
                            c = 65535;
                            break;
                        case -806050265:
                            if (str5.equals("x86_64")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case -738963905:
                            if (str5.equals("armeabi")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case 117110:
                            if (str5.equals("x86")) {
                                c = 4;
                                break;
                            }
                            c = 65535;
                            break;
                        case 3351711:
                            if (str5.equals("mips")) {
                                c = 6;
                                break;
                            }
                            c = 65535;
                            break;
                        case 145444210:
                            if (str5.equals("armeabi-v7a")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1431565292:
                            if (str5.equals("arm64-v8a")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    switch (c) {
                        case 0:
                            a(a2, "arm64-v8a", linkedList, hashSet);
                            break;
                        case 1:
                            a(a2, "armeabi-v7a", linkedList, hashSet);
                            a(a2, "armeabi", linkedList, hashSet);
                            break;
                        case 2:
                            a(a2, "armeabi", linkedList, hashSet);
                            a(a2, "armeabi-v7a", linkedList, hashSet);
                            break;
                        case 3:
                            a(a2, "x86_64", linkedList, hashSet);
                            break;
                        case 4:
                            a(a2, "x86", linkedList, hashSet);
                            break;
                        case 5:
                            a(a2, "mips64", linkedList, hashSet);
                            break;
                        case 6:
                            a(a2, "mips", linkedList, hashSet);
                            break;
                    }
                }
                com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "NativeLibHelper copyNativeLib, supportedSoEntries empty, pkg=".concat(java.lang.String.valueOf(str)));
                zipFile2.close();
                return;
            }
            zipFile2.close();
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private static void a(java.util.Map<java.lang.String, java.util.List<java.util.zip.ZipEntry>> map, java.lang.String str, java.util.List<java.util.zip.ZipEntry> list, java.util.Set<java.lang.String> set) {
        java.util.List<java.util.zip.ZipEntry> list2 = map.get(str);
        if (list2 == null || list2.size() == 0) {
            return;
        }
        for (java.util.zip.ZipEntry zipEntry : list2) {
            java.lang.String substring = zipEntry.getName().substring(zipEntry.getName().lastIndexOf(java.io.File.separator) + 1);
            if (!set.contains(substring)) {
                list.add(zipEntry);
                set.add(substring);
            }
        }
    }

    private static void a(java.util.zip.ZipFile zipFile, java.util.zip.ZipEntry zipEntry, java.io.File file) {
        java.lang.String name = zipEntry.getName();
        if (name.contains("..")) {
            return;
        }
        java.io.File file2 = new java.io.File(file, name.substring(name.lastIndexOf(java.io.File.separator) + 1));
        int i = 0;
        boolean z = false;
        do {
            if (file2.exists()) {
                file2.delete();
            }
            try {
                com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "NativeLibHelper copySoZipEntry, soZipEntry=" + zipEntry + ", targetSoFile=" + file2);
                com.bytedance.pangle.util.g.a(zipFile.getInputStream(zipEntry), new java.io.FileOutputStream(file2));
                z = true;
            } catch (java.io.IOException e) {
                if (i >= 3) {
                    throw e;
                }
                i++;
            }
        } while (!z);
    }

    private static void a(org.json.JSONObject jSONObject, java.lang.String str, java.lang.String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    private static boolean a(java.util.Map<java.lang.String, java.util.List<java.util.zip.ZipEntry>> map, java.lang.String str) {
        return (android.text.TextUtils.equals(str, "armeabi") || android.text.TextUtils.equals(str, "armeabi-v7a")) ? map.containsKey("armeabi") || map.containsKey("armeabi-v7a") : map.containsKey(str);
    }

    public static int b() {
        return b.get(a()).intValue();
    }

    private static java.lang.String b(org.json.JSONObject jSONObject) {
        java.util.HashSet hashSet;
        java.lang.String[] strArr;
        try {
            java.util.zip.ZipFile zipFile = new java.util.zip.ZipFile(new java.io.File(com.bytedance.pangle.Zeus.getAppApplication().getPackageManager().getPackageInfo(com.bytedance.pangle.Zeus.getAppApplication().getPackageName(), 0).applicationInfo.sourceDir));
            hashSet = new java.util.HashSet(a(zipFile).keySet());
            try {
                zipFile.close();
            } catch (java.io.IOException unused) {
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual, close sourceApkZipFile error!");
            }
            strArr = com.bytedance.pangle.util.i.a() ? android.os.Build.SUPPORTED_ABIS : new java.lang.String[]{android.os.Build.CPU_ABI, android.os.Build.CPU_ABI2};
        } catch (java.lang.Throwable th) {
            com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual failed!", th);
            a(jSONObject, "manualError", "1");
        }
        if (hashSet.isEmpty()) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual, host source apk .so is empty, use supportedABIs[0]=" + strArr[0]);
            a(jSONObject, "supportedABI0", strArr[0]);
            return strArr[0];
        }
        for (java.lang.String str : strArr) {
            if (hashSet.contains(str)) {
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual, match cpuAbi=".concat(java.lang.String.valueOf(str)));
                a(jSONObject, "matchCpuAbi", str);
                return str;
            }
        }
        if (com.bytedance.pangle.util.i.a()) {
            java.lang.String[] strArr2 = android.os.Build.SUPPORTED_ABIS;
            a(jSONObject, "defaultABI0", strArr2[0]);
            return strArr2[0];
        }
        java.lang.String str2 = android.os.Build.CPU_ABI;
        a(jSONObject, "defaultABI", str2);
        return str2;
    }

    public static boolean b(java.io.File file) {
        java.util.zip.ZipFile zipFile;
        java.util.zip.ZipFile zipFile2 = null;
        try {
            try {
                zipFile = new java.util.zip.ZipFile(file);
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.io.IOException e) {
            e = e;
        }
        try {
            java.util.Enumeration<? extends java.util.zip.ZipEntry> entries = zipFile.entries();
            java.util.regex.Pattern compile = java.util.regex.Pattern.compile("^lib/[^/]+/lib[^/]+.so$");
            while (entries.hasMoreElements()) {
                java.util.zip.ZipEntry nextElement = entries.nextElement();
                if (!nextElement.isDirectory() && compile.matcher(nextElement.getName()).matches()) {
                    try {
                        zipFile.close();
                        return true;
                    } catch (java.io.IOException unused) {
                        com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                        return true;
                    }
                }
            }
            try {
                zipFile.close();
            } catch (java.io.IOException unused2) {
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
            }
            return false;
        } catch (java.io.IOException e2) {
            e = e2;
            zipFile2 = zipFile;
            com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, get sourceApk ZipFile failed!", e);
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (java.io.IOException unused3) {
                    com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                }
            }
            return false;
        } catch (java.lang.Throwable th2) {
            th = th2;
            zipFile2 = zipFile;
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (java.io.IOException unused4) {
                    com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                }
            }
            throw th;
        }
    }

    private static java.lang.String c() {
        org.json.JSONObject d = d();
        java.lang.String a2 = a(d);
        return a2 == null ? b(d) : a2;
    }

    private static org.json.JSONObject d() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("primaryCpuAbi", "0");
            jSONObject.put("processMode", "0");
            jSONObject.put("supportedABI0", "0");
            jSONObject.put("matchCpuAbi", "0");
            jSONObject.put("defaultABI0", "0");
            jSONObject.put("defaultABI", "0");
            jSONObject.put("autoError", "0");
            jSONObject.put("manualError", "0");
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
