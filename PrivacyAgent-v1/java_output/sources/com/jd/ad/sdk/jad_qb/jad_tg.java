package com.jd.ad.sdk.jad_qb;

/* loaded from: classes23.dex */
public class jad_tg implements com.jd.ad.sdk.jad_ju.jad_dq<java.io.InputStream> {
    public final com.jd.ad.sdk.jad_ny.jad_bo jad_an;

    public jad_tg(com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
        this.jad_an = jad_boVar;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_dq
    public boolean jad_an(@androidx.annotation.NonNull java.io.InputStream inputStream, @androidx.annotation.NonNull java.io.File file, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        java.io.FileOutputStream fileOutputStream;
        byte[] bArr = (byte[]) this.jad_an.jad_an(65536, byte[].class);
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new java.io.FileOutputStream(file);
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    } catch (java.io.IOException e) {
                        e = e;
                        fileOutputStream2 = fileOutputStream;
                        if (android.util.Log.isLoggable("StreamEncoder", 3)) {
                            com.jd.ad.sdk.logger.Logger.d("StreamEncoder", "Failed to encode data onto the OutputStream", e);
                        }
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (java.io.IOException unused) {
                            }
                        }
                        this.jad_an.jad_an((com.jd.ad.sdk.jad_ny.jad_bo) bArr);
                        return false;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (java.io.IOException unused2) {
                            }
                        }
                        this.jad_an.jad_an((com.jd.ad.sdk.jad_ny.jad_bo) bArr);
                        throw th;
                    }
                }
                fileOutputStream.close();
                try {
                    fileOutputStream.close();
                } catch (java.io.IOException unused3) {
                }
                this.jad_an.jad_an((com.jd.ad.sdk.jad_ny.jad_bo) bArr);
                return true;
            } catch (java.lang.Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (java.io.IOException e2) {
            e = e2;
        }
    }
}
