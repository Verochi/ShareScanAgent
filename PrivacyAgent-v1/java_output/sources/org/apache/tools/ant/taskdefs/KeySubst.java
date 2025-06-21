package org.apache.tools.ant.taskdefs;

@java.lang.Deprecated
/* loaded from: classes25.dex */
public class KeySubst extends org.apache.tools.ant.Task {
    public java.io.File u = null;
    public java.io.File v = null;
    public java.lang.String w = "*";
    public java.util.Hashtable<java.lang.String, java.lang.String> x = new java.util.Hashtable<>();

    public static void main(java.lang.String[] strArr) {
        try {
            java.util.Hashtable hashtable = new java.util.Hashtable();
            hashtable.put("VERSION", "1.0.3");
            hashtable.put("b", "ffff");
            java.lang.System.out.println(replace("$f ${VERSION} f ${b} jj $", hashtable));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static java.lang.String replace(java.lang.String str, java.util.Hashtable<java.lang.String, java.lang.String> hashtable) throws org.apache.tools.ant.BuildException {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        int i = 0;
        while (true) {
            int indexOf = str.indexOf("${", i);
            if (indexOf <= -1) {
                stringBuffer.append(str.substring(i));
                return stringBuffer.toString();
            }
            int i2 = indexOf + 3;
            java.lang.String substring = str.substring(indexOf + 2, str.indexOf(com.alipay.sdk.m.u.i.d, i2));
            stringBuffer.append(str.substring(i, indexOf));
            if (hashtable.containsKey(substring)) {
                stringBuffer.append(hashtable.get(substring));
            } else {
                stringBuffer.append("${");
                stringBuffer.append(substring);
                stringBuffer.append(com.alipay.sdk.m.u.i.d);
            }
            i = substring.length() + i2;
        }
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        java.io.BufferedWriter bufferedWriter;
        java.lang.Throwable th;
        java.io.BufferedReader bufferedReader;
        java.io.IOException e;
        log("!! KeySubst is deprecated. Use Filter + Copy instead. !!");
        log("Performing Substitutions");
        if (this.u == null || this.v == null) {
            log("Source and destinations must not be null");
            return;
        }
        try {
            bufferedReader = new java.io.BufferedReader(new java.io.FileReader(this.u));
        } catch (java.io.IOException e2) {
            bufferedWriter = null;
            e = e2;
            bufferedReader = null;
        } catch (java.lang.Throwable th2) {
            bufferedWriter = null;
            th = th2;
            bufferedReader = null;
        }
        try {
            this.v.delete();
            bufferedWriter = new java.io.BufferedWriter(new java.io.FileWriter(this.v));
            try {
                try {
                    for (java.lang.String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                        if (readLine.length() == 0) {
                            bufferedWriter.newLine();
                        } else {
                            bufferedWriter.write(replace(readLine, this.x));
                            bufferedWriter.newLine();
                        }
                    }
                    bufferedWriter.flush();
                } catch (java.io.IOException e3) {
                    e = e3;
                    log(org.apache.tools.ant.util.StringUtils.getStackTrace(e), 0);
                    org.apache.tools.ant.util.FileUtils.close(bufferedWriter);
                    org.apache.tools.ant.util.FileUtils.close(bufferedReader);
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                org.apache.tools.ant.util.FileUtils.close(bufferedWriter);
                org.apache.tools.ant.util.FileUtils.close(bufferedReader);
                throw th;
            }
        } catch (java.io.IOException e4) {
            bufferedWriter = null;
            e = e4;
        } catch (java.lang.Throwable th4) {
            bufferedWriter = null;
            th = th4;
            org.apache.tools.ant.util.FileUtils.close(bufferedWriter);
            org.apache.tools.ant.util.FileUtils.close(bufferedReader);
            throw th;
        }
        org.apache.tools.ant.util.FileUtils.close(bufferedWriter);
        org.apache.tools.ant.util.FileUtils.close(bufferedReader);
    }

    public void setDest(java.io.File file) {
        this.v = file;
    }

    public void setKeys(java.lang.String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str, this.w, false);
        while (stringTokenizer.hasMoreTokens()) {
            java.util.StringTokenizer stringTokenizer2 = new java.util.StringTokenizer(stringTokenizer.nextToken().trim(), com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER, false);
            this.x.put(stringTokenizer2.nextToken(), stringTokenizer2.nextToken());
        }
    }

    public void setSep(java.lang.String str) {
        this.w = str;
    }

    public void setSrc(java.io.File file) {
        this.u = file;
    }
}
