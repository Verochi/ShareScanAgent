package com.anythink.expressad.videocommon.b;

/* loaded from: classes12.dex */
public final class g {
    public static final java.lang.String a = "<anythinkloadend></anythinkloadend>";
    private static final java.lang.String b = "DownLoadUtils";
    private static final int c = 20000;
    private static final int d = 30000;

    /* renamed from: com.anythink.expressad.videocommon.b.g$1, reason: invalid class name */
    public class AnonymousClass1 extends com.anythink.expressad.foundation.g.g.a {
        final /* synthetic */ com.anythink.expressad.videocommon.b.i.c a;
        final /* synthetic */ java.lang.String e;
        final /* synthetic */ boolean f = true;

        public AnonymousClass1(com.anythink.expressad.videocommon.b.i.c cVar, java.lang.String str) {
            this.a = cVar;
            this.e = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00c9 A[Catch: all -> 0x00c5, TryCatch #3 {all -> 0x00c5, blocks: (B:51:0x00b4, B:54:0x00ba, B:56:0x00bd, B:33:0x00c9, B:35:0x00cf, B:37:0x00d5, B:39:0x00dd, B:41:0x00e1, B:45:0x00e7, B:47:0x00eb), top: B:50:0x00b4 }] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00eb A[Catch: all -> 0x00c5, TRY_LEAVE, TryCatch #3 {all -> 0x00c5, blocks: (B:51:0x00b4, B:54:0x00ba, B:56:0x00bd, B:33:0x00c9, B:35:0x00cf, B:37:0x00d5, B:39:0x00dd, B:41:0x00e1, B:45:0x00e7, B:47:0x00eb), top: B:50:0x00b4 }] */
        /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:77:0x009f A[Catch: Exception -> 0x00a3, TRY_ENTER, TryCatch #12 {Exception -> 0x00a3, blocks: (B:27:0x0080, B:29:0x0085, B:77:0x009f, B:79:0x00a7), top: B:2:0x0002 }] */
        /* JADX WARN: Removed duplicated region for block: B:79:0x00a7 A[Catch: Exception -> 0x00a3, TRY_LEAVE, TryCatch #12 {Exception -> 0x00a3, blocks: (B:27:0x0080, B:29:0x0085, B:77:0x009f, B:79:0x00a7), top: B:2:0x0002 }] */
        /* JADX WARN: Removed duplicated region for block: B:86:0x011f A[Catch: Exception -> 0x011b, TRY_LEAVE, TryCatch #9 {Exception -> 0x011b, blocks: (B:93:0x0117, B:86:0x011f), top: B:92:0x0117 }] */
        /* JADX WARN: Removed duplicated region for block: B:92:0x0117 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v12 */
        /* JADX WARN: Type inference failed for: r3v13 */
        /* JADX WARN: Type inference failed for: r3v15 */
        /* JADX WARN: Type inference failed for: r3v16 */
        /* JADX WARN: Type inference failed for: r3v17 */
        /* JADX WARN: Type inference failed for: r3v18 */
        /* JADX WARN: Type inference failed for: r3v5 */
        /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r6v8, types: [java.lang.String] */
        @Override // com.anythink.expressad.foundation.g.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void a() {
            java.io.InputStream inputStream;
            java.io.ByteArrayOutputStream byteArrayOutputStream;
            ?? r3;
            byte[] bArr;
            java.lang.String message;
            java.lang.Throwable th;
            com.anythink.expressad.videocommon.b.i.c cVar;
            boolean z;
            java.io.InputStream inputStream2 = null;
            boolean z2 = false;
            try {
                try {
                    java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(this.e).openConnection();
                    httpURLConnection.setReadTimeout(30000);
                    httpURLConnection.setConnectTimeout(20000);
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        inputStream = httpURLConnection.getInputStream();
                        try {
                            byte[] bArr2 = new byte[com.badlogic.gdx.graphics.GL30.GL_COLOR];
                            byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                            while (true) {
                                try {
                                    try {
                                        int read = inputStream.read(bArr2);
                                        if (read == -1) {
                                            break;
                                        } else {
                                            byteArrayOutputStream.write(bArr2, 0, read);
                                        }
                                    } catch (java.lang.Exception e) {
                                        e = e;
                                        bArr = null;
                                        inputStream2 = inputStream;
                                        r3 = 0;
                                    }
                                } catch (java.lang.Throwable th2) {
                                    th = th2;
                                    if (inputStream != null) {
                                    }
                                    if (byteArrayOutputStream != null) {
                                    }
                                    throw th;
                                }
                            }
                            if (byteArrayOutputStream.toByteArray() != null) {
                                bArr = byteArrayOutputStream.toByteArray();
                                try {
                                    if (!this.f) {
                                        inputStream2 = new java.lang.String(bArr);
                                    }
                                } catch (java.lang.Exception e2) {
                                    e = e2;
                                    r3 = 0;
                                    inputStream2 = inputStream;
                                    message = e.getMessage();
                                    e.getLocalizedMessage();
                                    if (inputStream2 != null) {
                                        inputStream2.close();
                                    }
                                    if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                    if (z2) {
                                    }
                                    if (z2) {
                                    }
                                    cVar = this.a;
                                    if (cVar != null) {
                                    }
                                }
                            } else {
                                bArr = null;
                            }
                            message = "";
                            z = true;
                            r3 = inputStream2;
                            inputStream2 = inputStream;
                        } catch (java.lang.Exception e3) {
                            e = e3;
                            bArr = null;
                            byteArrayOutputStream = null;
                            inputStream2 = inputStream;
                            r3 = 0;
                        } catch (java.lang.Throwable th3) {
                            th = th3;
                            byteArrayOutputStream = null;
                            th = th;
                            if (inputStream != null) {
                            }
                            if (byteArrayOutputStream != null) {
                            }
                            throw th;
                        }
                    } else {
                        message = "responseCode is ".concat(java.lang.String.valueOf(responseCode));
                        r3 = 0;
                        bArr = null;
                        byteArrayOutputStream = null;
                        z = false;
                    }
                    try {
                        try {
                            httpURLConnection.disconnect();
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            z2 = z;
                        } catch (java.lang.Exception e4) {
                            e = e4;
                            message = e.getMessage();
                            e.getLocalizedMessage();
                            if (inputStream2 != null) {
                            }
                            if (byteArrayOutputStream != null) {
                            }
                            if (z2) {
                            }
                            if (z2) {
                            }
                            cVar = this.a;
                            if (cVar != null) {
                            }
                        }
                    } catch (java.lang.Throwable th4) {
                        th = th4;
                        inputStream = inputStream2;
                        th = th;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (java.lang.Exception e5) {
                                e5.printStackTrace();
                                e5.getMessage();
                                throw th;
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        throw th;
                    }
                } catch (java.lang.Exception e6) {
                    e6.printStackTrace();
                    message = e6.getMessage();
                }
            } catch (java.lang.Exception e7) {
                e = e7;
                r3 = 0;
                bArr = null;
                byteArrayOutputStream = null;
            } catch (java.lang.Throwable th5) {
                th = th5;
                inputStream = null;
                byteArrayOutputStream = null;
            }
            if (z2) {
                try {
                    if (this.f && bArr != null && bArr.length > 0) {
                        this.a.a(bArr, this.e);
                        return;
                    }
                } catch (java.lang.Throwable th6) {
                    if (com.anythink.expressad.a.a) {
                        th6.printStackTrace();
                    }
                    com.anythink.expressad.videocommon.b.i.c cVar2 = this.a;
                    if (cVar2 != null) {
                        try {
                            cVar2.a(th6.getMessage());
                            return;
                        } catch (java.lang.Exception e8) {
                            e8.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
            }
            if (z2 || !com.anythink.expressad.foundation.h.w.b(r3) || r3.length() <= 0 || !r3.contains(com.anythink.expressad.videocommon.b.g.a)) {
                cVar = this.a;
                if (cVar != null) {
                    cVar.a("content write failed:".concat(java.lang.String.valueOf(message)));
                    return;
                }
                return;
            }
            com.anythink.expressad.videocommon.b.i.c cVar3 = this.a;
            if (cVar3 != null) {
                cVar3.a(bArr, this.e);
            }
        }

        @Override // com.anythink.expressad.foundation.g.g.a
        public final void b() {
        }

        @Override // com.anythink.expressad.foundation.g.g.a
        public final void c() {
        }
    }

    public static void a(java.lang.String str, com.anythink.expressad.videocommon.b.i.c cVar) {
        try {
            if (!com.anythink.expressad.foundation.h.w.a(str) && android.webkit.URLUtil.isNetworkUrl(str)) {
                com.anythink.expressad.videocommon.b.h.a.a.a(new com.anythink.expressad.videocommon.b.g.AnonymousClass1(cVar, str));
                return;
            }
            cVar.a("url is error");
        } catch (java.lang.Throwable th) {
            if (com.anythink.expressad.a.a) {
                th.printStackTrace();
            }
        }
    }
}
