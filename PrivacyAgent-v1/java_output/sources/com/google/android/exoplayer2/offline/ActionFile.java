package com.google.android.exoplayer2.offline;

@java.lang.Deprecated
/* loaded from: classes22.dex */
final class ActionFile {
    public final com.google.android.exoplayer2.util.AtomicFile a;

    public ActionFile(java.io.File file) {
        this.a = new com.google.android.exoplayer2.util.AtomicFile(file);
    }

    public static java.lang.String b(android.net.Uri uri, @androidx.annotation.Nullable java.lang.String str) {
        return str != null ? str : uri.toString();
    }

    public static java.lang.String c(java.lang.String str) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode == 3680) {
            if (str.equals("ss")) {
                c = 2;
            }
            c = 65535;
        } else if (hashCode == 103407) {
            if (str.equals("hls")) {
                c = 1;
            }
            c = 65535;
        } else if (hashCode != 3075986) {
            if (hashCode == 1131547531 && str.equals("progressive")) {
                c = 3;
            }
            c = 65535;
        } else {
            if (str.equals("dash")) {
                c = 0;
            }
            c = 65535;
        }
        return c != 0 ? c != 1 ? c != 2 ? "video/x-unknown" : "application/vnd.ms-sstr+xml" : "application/x-mpegURL" : "application/dash+xml";
    }

    public static com.google.android.exoplayer2.offline.DownloadRequest e(java.io.DataInputStream dataInputStream) throws java.io.IOException {
        byte[] bArr;
        java.lang.String readUTF = dataInputStream.readUTF();
        int readInt = dataInputStream.readInt();
        android.net.Uri parse = android.net.Uri.parse(dataInputStream.readUTF());
        boolean readBoolean = dataInputStream.readBoolean();
        int readInt2 = dataInputStream.readInt();
        java.lang.String str = null;
        if (readInt2 != 0) {
            bArr = new byte[readInt2];
            dataInputStream.readFully(bArr);
        } else {
            bArr = null;
        }
        boolean z = true;
        boolean z2 = readInt == 0 && "progressive".equals(readUTF);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (!z2) {
            int readInt3 = dataInputStream.readInt();
            for (int i = 0; i < readInt3; i++) {
                arrayList.add(f(readUTF, readInt, dataInputStream));
            }
        }
        if (readInt >= 2 || (!"dash".equals(readUTF) && !"hls".equals(readUTF) && !"ss".equals(readUTF))) {
            z = false;
        }
        if (!z && dataInputStream.readBoolean()) {
            str = dataInputStream.readUTF();
        }
        java.lang.String b = readInt < 3 ? b(parse, str) : dataInputStream.readUTF();
        if (readBoolean) {
            throw new com.google.android.exoplayer2.offline.DownloadRequest.UnsupportedRequestException();
        }
        return new com.google.android.exoplayer2.offline.DownloadRequest.Builder(b, parse).setMimeType(c(readUTF)).setStreamKeys(arrayList).setCustomCacheKey(str).setData(bArr).build();
    }

    public static com.google.android.exoplayer2.offline.StreamKey f(java.lang.String str, int i, java.io.DataInputStream dataInputStream) throws java.io.IOException {
        int readInt;
        int readInt2;
        int i2;
        if (("hls".equals(str) || "ss".equals(str)) && i == 0) {
            readInt = dataInputStream.readInt();
            readInt2 = dataInputStream.readInt();
            i2 = 0;
        } else {
            int readInt3 = dataInputStream.readInt();
            int readInt4 = dataInputStream.readInt();
            int readInt5 = dataInputStream.readInt();
            i2 = readInt3;
            readInt = readInt4;
            readInt2 = readInt5;
        }
        return new com.google.android.exoplayer2.offline.StreamKey(i2, readInt, readInt2);
    }

    public boolean a() {
        return this.a.exists();
    }

    public com.google.android.exoplayer2.offline.DownloadRequest[] d() throws java.io.IOException {
        if (!a()) {
            return new com.google.android.exoplayer2.offline.DownloadRequest[0];
        }
        try {
            java.io.InputStream openRead = this.a.openRead();
            java.io.DataInputStream dataInputStream = new java.io.DataInputStream(openRead);
            int readInt = dataInputStream.readInt();
            if (readInt > 0) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder(44);
                sb.append("Unsupported action file version: ");
                sb.append(readInt);
                throw new java.io.IOException(sb.toString());
            }
            int readInt2 = dataInputStream.readInt();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (int i = 0; i < readInt2; i++) {
                try {
                    arrayList.add(e(dataInputStream));
                } catch (com.google.android.exoplayer2.offline.DownloadRequest.UnsupportedRequestException unused) {
                }
            }
            com.google.android.exoplayer2.offline.DownloadRequest[] downloadRequestArr = (com.google.android.exoplayer2.offline.DownloadRequest[]) arrayList.toArray(new com.google.android.exoplayer2.offline.DownloadRequest[0]);
            com.google.android.exoplayer2.util.Util.closeQuietly(openRead);
            return downloadRequestArr;
        } catch (java.lang.Throwable th) {
            com.google.android.exoplayer2.util.Util.closeQuietly((java.io.Closeable) null);
            throw th;
        }
    }

    public void delete() {
        this.a.delete();
    }
}
