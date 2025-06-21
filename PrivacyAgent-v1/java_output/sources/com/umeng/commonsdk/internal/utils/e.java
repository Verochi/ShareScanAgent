package com.umeng.commonsdk.internal.utils;

/* loaded from: classes19.dex */
public class e {

    public enum a {
        check_su_binary(new java.lang.String[]{"/system/xbin/which", com.getui.gtc.extension.distribution.gbd.n.aa.a});

        java.lang.String[] b;

        a(java.lang.String[] strArr) {
            this.b = strArr;
        }
    }

    public java.util.ArrayList a(com.umeng.commonsdk.internal.utils.e.a aVar) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (android.os.Build.VERSION.SDK_INT > 28) {
            return arrayList;
        }
        try {
            java.lang.Process exec = java.lang.Runtime.getRuntime().exec(aVar.b);
            new java.io.BufferedWriter(new java.io.OutputStreamWriter(exec.getOutputStream()));
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(exec.getInputStream()));
            while (true) {
                try {
                    java.lang.String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    arrayList.add(readLine);
                } catch (java.lang.Exception unused) {
                }
            }
            return arrayList;
        } catch (java.lang.Exception unused2) {
            return null;
        }
    }
}
