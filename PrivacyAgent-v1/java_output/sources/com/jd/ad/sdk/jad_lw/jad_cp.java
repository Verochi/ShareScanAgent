package com.jd.ad.sdk.jad_lw;

/* loaded from: classes23.dex */
public class jad_cp implements com.jd.ad.sdk.jad_kv.jad_dq<java.io.InputStream> {
    public final android.net.Uri jad_an;
    public final com.jd.ad.sdk.jad_lw.jad_er jad_bo;
    public java.io.InputStream jad_cp;

    public static class jad_an implements com.jd.ad.sdk.jad_lw.jad_dq {
        public static final java.lang.String[] jad_bo = {"_data"};
        public final android.content.ContentResolver jad_an;

        public jad_an(android.content.ContentResolver contentResolver) {
            this.jad_an = contentResolver;
        }

        @Override // com.jd.ad.sdk.jad_lw.jad_dq
        public android.database.Cursor jad_an(android.net.Uri uri) {
            return this.jad_an.query(android.provider.MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, jad_bo, "kind = 1 AND image_id = ?", new java.lang.String[]{uri.getLastPathSegment()}, null);
        }
    }

    public static class jad_bo implements com.jd.ad.sdk.jad_lw.jad_dq {
        public static final java.lang.String[] jad_bo = {"_data"};
        public final android.content.ContentResolver jad_an;

        public jad_bo(android.content.ContentResolver contentResolver) {
            this.jad_an = contentResolver;
        }

        @Override // com.jd.ad.sdk.jad_lw.jad_dq
        public android.database.Cursor jad_an(android.net.Uri uri) {
            return this.jad_an.query(android.provider.MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, jad_bo, "kind = 1 AND video_id = ?", new java.lang.String[]{uri.getLastPathSegment()}, null);
        }
    }

    @androidx.annotation.VisibleForTesting
    public jad_cp(android.net.Uri uri, com.jd.ad.sdk.jad_lw.jad_er jad_erVar) {
        this.jad_an = uri;
        this.jad_bo = jad_erVar;
    }

    public static com.jd.ad.sdk.jad_lw.jad_cp jad_an(android.content.Context context, android.net.Uri uri, com.jd.ad.sdk.jad_lw.jad_dq jad_dqVar) {
        com.jd.ad.sdk.jad_ny.jad_bo jad_boVar = com.jd.ad.sdk.jad_gr.jad_cp.jad_an(context).jad_er;
        return new com.jd.ad.sdk.jad_lw.jad_cp(uri, new com.jd.ad.sdk.jad_lw.jad_er(com.jd.ad.sdk.jad_gr.jad_cp.jad_an(context).jad_dq.jad_an(), com.jd.ad.sdk.jad_lw.jad_er.jad_er, jad_dqVar, jad_boVar, context.getContentResolver()));
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    @androidx.annotation.NonNull
    public java.lang.Class<java.io.InputStream> jad_an() {
        return java.io.InputStream.class;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    public void jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_gr.jad_jt jad_jtVar, @androidx.annotation.NonNull com.jd.ad.sdk.jad_kv.jad_dq.jad_an<? super java.io.InputStream> jad_anVar) {
        try {
            java.io.InputStream jad_er = jad_er();
            this.jad_cp = jad_er;
            jad_anVar.jad_an((com.jd.ad.sdk.jad_kv.jad_dq.jad_an<? super java.io.InputStream>) jad_er);
        } catch (java.io.FileNotFoundException e) {
            if (android.util.Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                com.jd.ad.sdk.logger.Logger.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e);
            }
            jad_anVar.jad_an((java.lang.Exception) e);
        }
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    public void jad_bo() {
        java.io.InputStream inputStream = this.jad_cp;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    public void jad_cp() {
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    @androidx.annotation.NonNull
    public com.jd.ad.sdk.jad_ju.jad_an jad_dq() {
        return com.jd.ad.sdk.jad_ju.jad_an.LOCAL;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0054, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x002a, code lost:
    
        if (r8 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0052, code lost:
    
        if (r8 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0057, code lost:
    
        r9 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x0025: MOVE (r7 I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY]), block:B:71:0x0025 */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x010a  */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.io.InputStream jad_er() {
        android.database.Cursor cursor;
        ?? r8;
        java.io.InputStream inputStream;
        int i;
        com.jd.ad.sdk.jad_lw.jad_er jad_erVar = this.jad_bo;
        android.net.Uri uri = this.jad_an;
        jad_erVar.getClass();
        ?? r7 = 0;
        java.io.InputStream inputStream2 = null;
        try {
            try {
                cursor = jad_erVar.jad_an.jad_an(uri);
            } catch (java.lang.Throwable th) {
                th = th;
                r7 = r8;
                if (r7 != 0) {
                    r7.close();
                }
                throw th;
            }
        } catch (java.lang.SecurityException e) {
            e = e;
            cursor = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (r7 != 0) {
            }
            throw th;
        }
        if (cursor != null) {
            try {
            } catch (java.lang.SecurityException e2) {
                e = e2;
                if (android.util.Log.isLoggable("ThumbStreamOpener", 3)) {
                    com.jd.ad.sdk.logger.Logger.d("ThumbStreamOpener", "Failed to query for thumbnail for Uri: " + uri, e);
                }
            }
            if (cursor.moveToFirst()) {
                java.lang.String str = cursor.getString(0);
                cursor.close();
                if (!android.text.TextUtils.isEmpty(str)) {
                    java.io.File file = new java.io.File(str);
                    if (file.exists() && 0 < file.length()) {
                        android.net.Uri fromFile = android.net.Uri.fromFile(file);
                        try {
                            inputStream = jad_erVar.jad_cp.openInputStream(fromFile);
                            if (inputStream != null) {
                                com.jd.ad.sdk.jad_lw.jad_er jad_erVar2 = this.jad_bo;
                                android.net.Uri uri2 = this.jad_an;
                                jad_erVar2.getClass();
                                try {
                                    try {
                                        inputStream2 = jad_erVar2.jad_cp.openInputStream(uri2);
                                        i = com.jd.ad.sdk.jad_ju.jad_jt.jad_an(jad_erVar2.jad_dq, inputStream2, jad_erVar2.jad_bo);
                                        if (inputStream2 != null) {
                                            try {
                                                inputStream2.close();
                                            } catch (java.io.IOException unused) {
                                            }
                                        }
                                    } catch (java.lang.Throwable th3) {
                                        if (0 != 0) {
                                            try {
                                                r7.close();
                                            } catch (java.io.IOException unused2) {
                                            }
                                        }
                                        throw th3;
                                    }
                                } catch (java.io.IOException | java.lang.NullPointerException e3) {
                                    if (android.util.Log.isLoggable("ThumbStreamOpener", 3)) {
                                        com.jd.ad.sdk.logger.Logger.d("ThumbStreamOpener", "Failed to open uri: " + uri2, e3);
                                    }
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (java.io.IOException unused3) {
                                        }
                                    }
                                }
                                return i != -1 ? new com.jd.ad.sdk.jad_kv.jad_jt(inputStream, i) : inputStream;
                            }
                            i = -1;
                            if (i != -1) {
                            }
                        } catch (java.lang.NullPointerException e4) {
                            throw ((java.io.FileNotFoundException) new java.io.FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e4));
                        }
                    }
                }
                inputStream = null;
                if (inputStream != null) {
                }
                i = -1;
                if (i != -1) {
                }
            }
        }
    }
}
