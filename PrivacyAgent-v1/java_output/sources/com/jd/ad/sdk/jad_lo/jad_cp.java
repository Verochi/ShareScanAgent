package com.jd.ad.sdk.jad_lo;

/* loaded from: classes23.dex */
public class jad_cp {
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003a, code lost:
    
        if (r1 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String jad_an(java.lang.String str, boolean z) {
        java.io.BufferedReader bufferedReader;
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        java.io.File file = new java.io.File(str);
        if (file.exists()) {
            try {
                bufferedReader = new java.io.BufferedReader(new java.io.FileReader(file));
            } catch (java.lang.Throwable unused) {
                bufferedReader = null;
            }
            while (true) {
                try {
                    java.lang.String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        if (z) {
                            readLine = readLine + "\n";
                        }
                        stringBuffer.append(readLine);
                    }
                } catch (java.lang.Throwable unused2) {
                }
                try {
                    break;
                } catch (java.io.IOException unused3) {
                }
            }
            bufferedReader.close();
        }
        java.lang.String trim = stringBuffer.toString().trim();
        return (z && trim.endsWith("\n")) ? trim.substring(0, trim.length() - 2) : trim;
    }
}
