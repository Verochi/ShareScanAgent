package com.xiaomi.push;

/* loaded from: classes19.dex */
final class cf {
    static java.lang.String b = "/MiPushLog";
    java.lang.String c;
    java.lang.String d;
    private boolean f;
    private int g;

    @android.annotation.SuppressLint({"SimpleDateFormat"})
    final java.text.SimpleDateFormat a = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    int e = 2097152;
    private java.util.ArrayList<java.io.File> h = new java.util.ArrayList<>();

    private void a(java.io.BufferedReader bufferedReader, java.io.BufferedWriter bufferedWriter, java.util.regex.Pattern pattern) {
        char[] cArr = new char[4096];
        int read = bufferedReader.read(cArr);
        boolean z = false;
        while (read != -1 && !z) {
            java.lang.String str = new java.lang.String(cArr, 0, read);
            java.util.regex.Matcher matcher = pattern.matcher(str);
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= read || !matcher.find(i)) {
                    break;
                }
                int start = matcher.start();
                java.lang.String substring = str.substring(start, this.c.length() + start);
                if (this.f) {
                    if (substring.compareTo(this.d) > 0) {
                        read = start;
                        z = true;
                        break;
                    }
                } else if (substring.compareTo(this.c) >= 0) {
                    this.f = true;
                    i2 = start;
                }
                int indexOf = str.indexOf(10, start);
                if (indexOf == -1) {
                    indexOf = this.c.length();
                }
                i = start + indexOf;
            }
            if (this.f) {
                int i3 = read - i2;
                this.g += i3;
                bufferedWriter.write(cArr, i2, i3);
                if (z || this.g > this.e) {
                    return;
                }
            }
            read = bufferedReader.read(cArr);
        }
    }

    public final com.xiaomi.push.cf a(java.io.File file) {
        if (file.exists()) {
            this.h.add(file);
        }
        return this;
    }

    public final void b(java.io.File file) {
        java.io.BufferedReader bufferedReader;
        java.util.regex.Pattern compile = java.util.regex.Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
        java.io.BufferedReader bufferedReader2 = null;
        try {
            try {
                java.io.BufferedWriter bufferedWriter = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(file)));
                try {
                    bufferedWriter.write("model :" + android.os.Build.MODEL + "; os :" + android.os.Build.VERSION.INCREMENTAL + "; uid :" + com.xiaomi.push.service.ay.e() + "; lng :" + java.util.Locale.getDefault().toString() + "; sdk :48; andver :" + android.os.Build.VERSION.SDK_INT + "\n");
                    this.g = 0;
                    java.util.Iterator<java.io.File> it = this.h.iterator();
                    while (it.hasNext()) {
                        bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(it.next())));
                        try {
                            a(bufferedReader, bufferedWriter, compile);
                            bufferedReader.close();
                            bufferedReader2 = bufferedReader;
                        } catch (java.io.FileNotFoundException e) {
                            e = e;
                            bufferedReader2 = bufferedWriter;
                            com.xiaomi.channel.commonutils.logger.b.c("LOG: filter error = " + e.getMessage());
                            com.xiaomi.push.c.a(bufferedReader2);
                            com.xiaomi.push.c.a(bufferedReader);
                            return;
                        } catch (java.io.IOException e2) {
                            e = e2;
                            bufferedReader2 = bufferedWriter;
                            com.xiaomi.channel.commonutils.logger.b.c("LOG: filter error = " + e.getMessage());
                            com.xiaomi.push.c.a(bufferedReader2);
                            com.xiaomi.push.c.a(bufferedReader);
                            return;
                        } catch (java.lang.Throwable th) {
                            th = th;
                            bufferedReader2 = bufferedWriter;
                            com.xiaomi.push.c.a(bufferedReader2);
                            com.xiaomi.push.c.a(bufferedReader);
                            throw th;
                        }
                    }
                    bufferedWriter.write(com.xiaomi.push.bv.a().d());
                    com.xiaomi.push.c.a(bufferedWriter);
                    com.xiaomi.push.c.a(bufferedReader2);
                } catch (java.io.FileNotFoundException e3) {
                    e = e3;
                    bufferedReader = bufferedReader2;
                } catch (java.io.IOException e4) {
                    e = e4;
                    bufferedReader = bufferedReader2;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
            }
        } catch (java.io.FileNotFoundException e5) {
            e = e5;
            bufferedReader = null;
        } catch (java.io.IOException e6) {
            e = e6;
            bufferedReader = null;
        } catch (java.lang.Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
    }
}
