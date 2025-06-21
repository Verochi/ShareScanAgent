package com.bytedance.pangle.res.a;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: com.bytedance.pangle.res.a.c$1, reason: invalid class name */
    public class AnonymousClass1 implements com.bytedance.pangle.res.a.h {
        final /* synthetic */ org.json.JSONObject a;
        final /* synthetic */ org.json.JSONObject b;
        final /* synthetic */ int[] c;
        final /* synthetic */ java.util.HashSet d;

        public AnonymousClass1(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2, int[] iArr, java.util.HashSet hashSet) {
            this.a = jSONObject;
            this.b = jSONObject2;
            this.c = iArr;
            this.d = hashSet;
        }

        @Override // com.bytedance.pangle.res.a.h
        public final int a(int i) {
            java.lang.String str = "0x" + java.lang.Integer.toHexString(i);
            java.lang.String str2 = (java.lang.String) this.a.opt(str);
            if (str2 == null) {
                return i;
            }
            int identifier = com.bytedance.pangle.Zeus.getAppApplication().getResources().getIdentifier(str2.split(" ")[1], str2.split(" ")[0], com.bytedance.pangle.Zeus.getAppApplication().getPackageName());
            if (identifier == 0) {
                identifier = com.bytedance.pangle.Zeus.getAppApplication().getResources().getIdentifier(str2.split(" ")[1].replaceAll("_", "."), str2.split(" ")[0], com.bytedance.pangle.Zeus.getAppApplication().getPackageName());
            }
            if (identifier == 0) {
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "getIdentifier failed. resName is ".concat(str2));
                return i;
            }
            java.lang.String str3 = "0x" + java.lang.Integer.toHexString(identifier);
            if (android.text.TextUtils.equals(this.b.optString(str), str2)) {
                this.b.remove(str);
            }
            try {
                this.b.put(str3, str2);
            } catch (java.lang.Throwable th) {
                com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "update resMappingBak failed.", th);
            }
            if (identifier != i) {
                int[] iArr = this.c;
                iArr[0] = iArr[0] + 1;
            }
            return identifier;
        }

        @Override // com.bytedance.pangle.res.a.h
        public final boolean a(java.lang.String str) {
            return this.d.contains(str);
        }
    }

    private static com.bytedance.pangle.util.e<java.lang.Integer, byte[]> a(java.nio.MappedByteBuffer mappedByteBuffer, int i, java.lang.String str) {
        if (mappedByteBuffer.getInt(i) != 67324752) {
            throw new java.lang.RuntimeException("Expected: 0x04034b50, got: " + mappedByteBuffer.getInt(i) + " FileName:" + str);
        }
        int i2 = mappedByteBuffer.getInt(i + 18);
        int i3 = mappedByteBuffer.getInt(i + 22);
        if (i2 != i3) {
            throw new java.lang.RuntimeException(str + " is compressed. compressSize:" + i2 + " size:" + i3);
        }
        byte[] bArr = new byte[i3];
        int i4 = i + 30 + mappedByteBuffer.getShort(i + 26) + mappedByteBuffer.getShort(i + 28);
        for (int i5 = 0; i5 < i3; i5++) {
            bArr[i5] = mappedByteBuffer.get(i4 + i5);
        }
        return new com.bytedance.pangle.util.e<>(java.lang.Integer.valueOf(i4), bArr);
    }

    private static java.nio.MappedByteBuffer a(java.io.File file) {
        java.io.RandomAccessFile randomAccessFile = null;
        try {
            java.io.RandomAccessFile randomAccessFile2 = new java.io.RandomAccessFile(file, "rw");
            try {
                java.nio.channels.FileChannel channel = randomAccessFile2.getChannel();
                long size = channel.size();
                java.nio.MappedByteBuffer map = channel.map(java.nio.channels.FileChannel.MapMode.READ_WRITE, 0L, size);
                byte[] bArr = new byte[4194304];
                long j = size / 4194304;
                int i = (int) (size % 4194304);
                for (int i2 = 0; i2 < j; i2++) {
                    map.get(bArr);
                }
                if (i > 0) {
                    map.get(new byte[i]);
                }
                map.order(java.nio.ByteOrder.LITTLE_ENDIAN);
                randomAccessFile2.close();
                return map;
            } catch (java.lang.Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private static void a(java.io.File file, java.util.HashSet<java.lang.String> hashSet, com.bytedance.pangle.res.a.h hVar) {
        int i;
        java.nio.MappedByteBuffer a = a(file);
        int capacity = a.capacity();
        if (capacity >= 22) {
            int i2 = capacity - 22;
            int min = java.lang.Math.min(i2, 65535);
            for (int i3 = 0; i3 < min; i3++) {
                i = i2 - i3;
                if (a.getInt(i) == 101010256 && a.getShort(i + 20) == i3) {
                    break;
                }
            }
        }
        i = -1;
        if (i == -1) {
            throw new java.lang.Throwable("endOfCentralPosition == -1");
        }
        int i4 = a.getInt(i + 12);
        int i5 = a.getInt(i + 16);
        int i6 = i4 + i5;
        while (i5 < i6) {
            if (a.getInt(i5) != 33639248) {
                throw new java.lang.RuntimeException("Expected: 0x02014b50, got: " + a.getInt(i5));
            }
            int i7 = a.getShort(i5 + 28);
            short s2 = a.getShort(i5 + 30);
            byte[] bArr = new byte[i7];
            for (int i8 = 0; i8 < i7; i8++) {
                bArr[i8] = a.get(i5 + 46 + i8);
            }
            java.lang.String str = new java.lang.String(bArr);
            int i9 = a.getInt(i5 + 20);
            int i10 = a.getInt(i5 + 24);
            if (hashSet.contains(str)) {
                if (i9 != i10) {
                    throw new java.lang.Throwable(str + " is compressed.");
                }
                com.bytedance.pangle.util.e<java.lang.Integer, byte[]> a2 = a(a, a.getInt(i5 + 42), str);
                try {
                    byte[] bArr2 = a2.b;
                    if (!android.text.TextUtils.isEmpty(str) && hVar.a(str)) {
                        if (str.equals("AndroidManifest.xml")) {
                            com.bytedance.pangle.res.a.k.a(bArr2, hVar);
                        } else if ((str.endsWith(".xml") && str.startsWith("res/")) || android.text.TextUtils.equals(str, "AndroidManifest.xml")) {
                            com.bytedance.pangle.res.a.k.a(bArr2, hVar);
                        } else if (str.equals("resources.arsc")) {
                            new com.bytedance.pangle.res.a.a(bArr2, hVar).a();
                        }
                    }
                    for (int i11 = 0; i11 < a2.b.length; i11++) {
                        a.put(a2.a.intValue() + i11, a2.b[i11]);
                    }
                } catch (java.lang.Throwable th) {
                    throw new java.lang.RuntimeException(th);
                }
            }
            i5 += i7 + 46 + s2;
        }
    }

    public final int a(java.io.File file, boolean z, java.lang.StringBuilder sb) {
        java.lang.String byteArrayOutputStream;
        java.util.zip.ZipFile zipFile = null;
        try {
            java.util.zip.ZipFile zipFile2 = new java.util.zip.ZipFile(file);
            try {
                java.util.zip.ZipEntry entry = zipFile2.getEntry("assets/ZeusResMapping");
                if (entry == null) {
                    com.bytedance.pangle.util.g.a(zipFile2);
                    return 200;
                }
                if (z) {
                    java.io.File file2 = new java.io.File(file.getParentFile(), "resMappingBak");
                    if (!file2.exists()) {
                        com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "resMappingBakFile is not exists. " + file2.getAbsolutePath());
                        sb.append("resMappingBakFile is not exists. ");
                        sb.append(file2.getAbsolutePath());
                        com.bytedance.pangle.util.g.a(zipFile2);
                        return 300;
                    }
                    java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file2);
                    java.nio.channels.FileChannel channel = fileInputStream.getChannel();
                    byteArrayOutputStream = java.nio.charset.Charset.defaultCharset().newDecoder().decode(channel.map(java.nio.channels.FileChannel.MapMode.READ_ONLY, 0L, channel.size()).asReadOnlyBuffer()).toString();
                    channel.close();
                    fileInputStream.close();
                } else {
                    java.io.ByteArrayOutputStream byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
                    java.io.InputStream inputStream = zipFile2.getInputStream(entry);
                    if (inputStream != null) {
                        java.nio.channels.ReadableByteChannel newChannel = java.nio.channels.Channels.newChannel(inputStream);
                        java.nio.channels.WritableByteChannel newChannel2 = java.nio.channels.Channels.newChannel(byteArrayOutputStream2);
                        com.bytedance.pangle.util.h.a(newChannel, newChannel2);
                        newChannel.close();
                        newChannel2.close();
                    }
                    byteArrayOutputStream = byteArrayOutputStream2.toString();
                }
                if (android.text.TextUtils.isEmpty(byteArrayOutputStream)) {
                    com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "zeusResMappingContent empty, useBakFile:".concat(java.lang.String.valueOf(z)));
                    sb.append("zeusResMappingContent isEmpty. useBakFile:");
                    sb.append(z);
                    com.bytedance.pangle.util.g.a(zipFile2);
                    return 300;
                }
                org.json.JSONObject jSONObject = new org.json.JSONObject(byteArrayOutputStream);
                org.json.JSONObject jSONObject2 = new org.json.JSONObject(byteArrayOutputStream);
                org.json.JSONArray jSONArray = (org.json.JSONArray) jSONObject.get("fileNames");
                java.util.HashSet hashSet = new java.util.HashSet();
                for (int i = 0; i < jSONArray.length(); i++) {
                    hashSet.add((java.lang.String) jSONArray.get(i));
                }
                int[] iArr = {0};
                a(file, (java.util.HashSet<java.lang.String>) hashSet, new com.bytedance.pangle.res.a.c.AnonymousClass1((org.json.JSONObject) jSONObject.get("resMapping"), (org.json.JSONObject) jSONObject2.get("resMapping"), iArr, hashSet));
                com.bytedance.pangle.log.ZeusLogger.d(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "modifyRes count = " + iArr[0]);
                if (com.bytedance.pangle.util.h.a(jSONObject2.toString(), new java.io.File(file.getParentFile(), "resMappingBak"), sb)) {
                    com.bytedance.pangle.util.g.a(zipFile2);
                    return 100;
                }
                com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "writeText failed." + sb.toString());
                sb.append("writeText failed.");
                com.bytedance.pangle.util.g.a(zipFile2);
                return 300;
            } catch (java.lang.Throwable th) {
                th = th;
                zipFile = zipFile2;
                try {
                    com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "modifyRes failed. catch: " + th.getMessage(), th);
                    sb.append("modifyRes failed. catch: ");
                    sb.append(th.getMessage());
                    return 300;
                } finally {
                    if (zipFile != null) {
                        com.bytedance.pangle.util.g.a(zipFile);
                    }
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }
}
