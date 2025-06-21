package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class ProcessUtil {
    public static java.lang.String getProcessId(java.lang.String str) {
        java.lang.String name = java.lang.management.ManagementFactory.getRuntimeMXBean().getName();
        int indexOf = name.indexOf(64);
        if (indexOf < 1) {
            return str;
        }
        try {
            return java.lang.Long.toString(java.lang.Long.parseLong(name.substring(0, indexOf)));
        } catch (java.lang.NumberFormatException unused) {
            return str;
        }
    }

    public static void main(java.lang.String[] strArr) {
        java.lang.System.out.println(getProcessId("<PID>"));
        try {
            java.lang.Thread.sleep(com.igexin.push.config.c.l);
        } catch (java.lang.Exception unused) {
        }
    }
}
