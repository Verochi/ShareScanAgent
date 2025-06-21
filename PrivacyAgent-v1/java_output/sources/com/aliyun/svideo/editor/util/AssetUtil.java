package com.aliyun.svideo.editor.util;

/* loaded from: classes12.dex */
public class AssetUtil {
    private static java.lang.String getStringFromInputStream(java.io.InputStream inputStream) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.io.BufferedReader bufferedReader = null;
        try {
            try {
                try {
                    java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream));
                    while (true) {
                        try {
                            java.lang.String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                            sb.append("\n");
                        } catch (java.io.IOException e) {
                            e = e;
                            bufferedReader = bufferedReader2;
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return sb.toString();
                        } catch (java.lang.Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (java.io.IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                    bufferedReader2.close();
                } catch (java.io.IOException e3) {
                    e3.printStackTrace();
                }
            } catch (java.io.IOException e4) {
                e = e4;
            }
            return sb.toString();
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static java.lang.String readAssertResource(android.content.Context context, java.lang.String str) {
        try {
            return getStringFromInputStream(context.getAssets().open(str));
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
