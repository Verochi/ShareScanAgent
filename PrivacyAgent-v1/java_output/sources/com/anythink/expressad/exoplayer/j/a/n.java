package com.anythink.expressad.exoplayer.j.a;

/* loaded from: classes12.dex */
final class n extends com.anythink.expressad.exoplayer.j.a.e {
    private static final java.lang.String g = ".v3.exo";
    private static final java.util.regex.Pattern h = java.util.regex.Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);
    private static final java.util.regex.Pattern i = java.util.regex.Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);
    private static final java.util.regex.Pattern j = java.util.regex.Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);

    private n(java.lang.String str, long j2, long j3, long j4, @androidx.annotation.Nullable java.io.File file) {
        super(str, j2, j3, j4, file);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x002a, code lost:
    
        if (r1 == null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0061, code lost:
    
        if (r16.renameTo(r1) == false) goto L11;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.anythink.expressad.exoplayer.j.a.n a(java.io.File file, com.anythink.expressad.exoplayer.j.a.h hVar) {
        java.io.File file2;
        java.lang.String group;
        java.io.File file3;
        java.lang.String name = file.getName();
        if (name.endsWith(g)) {
            file2 = file;
        } else {
            java.lang.String name2 = file.getName();
            java.util.regex.Matcher matcher = i.matcher(name2);
            if (matcher.matches()) {
                group = com.anythink.expressad.exoplayer.k.af.h(matcher.group(1));
            } else {
                matcher = h.matcher(name2);
                if (matcher.matches()) {
                    group = matcher.group(1);
                    file3 = a(file.getParentFile(), hVar.c(group), java.lang.Long.parseLong(matcher.group(2)), java.lang.Long.parseLong(matcher.group(3)));
                }
                file3 = null;
            }
            if (file3 == null) {
                return null;
            }
            file2 = file3;
            name = file3.getName();
        }
        java.util.regex.Matcher matcher2 = j.matcher(name);
        if (!matcher2.matches()) {
            return null;
        }
        long length = file2.length();
        java.lang.String a = hVar.a(java.lang.Integer.parseInt(matcher2.group(1)));
        if (a == null) {
            return null;
        }
        return new com.anythink.expressad.exoplayer.j.a.n(a, java.lang.Long.parseLong(matcher2.group(2)), length, java.lang.Long.parseLong(matcher2.group(3)), file2);
    }

    public static com.anythink.expressad.exoplayer.j.a.n a(java.lang.String str, long j2) {
        return new com.anythink.expressad.exoplayer.j.a.n(str, j2, -1L, -9223372036854775807L, null);
    }

    public static com.anythink.expressad.exoplayer.j.a.n a(java.lang.String str, long j2, long j3) {
        return new com.anythink.expressad.exoplayer.j.a.n(str, j2, j3, -9223372036854775807L, null);
    }

    public static java.io.File a(java.io.File file, int i2, long j2, long j3) {
        return new java.io.File(file, i2 + "." + j2 + "." + j3 + g);
    }

    public static com.anythink.expressad.exoplayer.j.a.n b(java.lang.String str, long j2) {
        return new com.anythink.expressad.exoplayer.j.a.n(str, j2, -1L, -9223372036854775807L, null);
    }

    @androidx.annotation.Nullable
    private static java.io.File b(java.io.File file, com.anythink.expressad.exoplayer.j.a.h hVar) {
        java.lang.String group;
        java.lang.String name = file.getName();
        java.util.regex.Matcher matcher = i.matcher(name);
        if (matcher.matches()) {
            group = com.anythink.expressad.exoplayer.k.af.h(matcher.group(1));
            if (group == null) {
                return null;
            }
        } else {
            matcher = h.matcher(name);
            if (!matcher.matches()) {
                return null;
            }
            group = matcher.group(1);
        }
        java.io.File a = a(file.getParentFile(), hVar.c(group), java.lang.Long.parseLong(matcher.group(2)), java.lang.Long.parseLong(matcher.group(3)));
        if (file.renameTo(a)) {
            return a;
        }
        return null;
    }

    public final com.anythink.expressad.exoplayer.j.a.n a(int i2) {
        com.anythink.expressad.exoplayer.k.a.b(this.d);
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        return new com.anythink.expressad.exoplayer.j.a.n(this.a, this.b, this.c, currentTimeMillis, a(this.e.getParentFile(), i2, this.b, currentTimeMillis));
    }
}
