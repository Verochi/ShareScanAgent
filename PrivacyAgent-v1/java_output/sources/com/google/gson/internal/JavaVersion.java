package com.google.gson.internal;

/* loaded from: classes22.dex */
public final class JavaVersion {
    private static final int majorJavaVersion = determineMajorJavaVersion();

    private JavaVersion() {
    }

    private static int determineMajorJavaVersion() {
        return getMajorJavaVersion(java.lang.System.getProperty("java.version"));
    }

    private static int extractBeginningInt(java.lang.String str) {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (!java.lang.Character.isDigit(charAt)) {
                    break;
                }
                sb.append(charAt);
            }
            return java.lang.Integer.parseInt(sb.toString());
        } catch (java.lang.NumberFormatException unused) {
            return -1;
        }
    }

    public static int getMajorJavaVersion() {
        return majorJavaVersion;
    }

    public static int getMajorJavaVersion(java.lang.String str) {
        int parseDotted = parseDotted(str);
        if (parseDotted == -1) {
            parseDotted = extractBeginningInt(str);
        }
        if (parseDotted == -1) {
            return 6;
        }
        return parseDotted;
    }

    public static boolean isJava9OrLater() {
        return majorJavaVersion >= 9;
    }

    private static int parseDotted(java.lang.String str) {
        try {
            java.lang.String[] split = str.split("[._]");
            int parseInt = java.lang.Integer.parseInt(split[0]);
            return (parseInt != 1 || split.length <= 1) ? parseInt : java.lang.Integer.parseInt(split[1]);
        } catch (java.lang.NumberFormatException unused) {
            return -1;
        }
    }
}
