package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class CVSPass extends org.apache.tools.ant.Task {
    public java.io.File v;
    public java.lang.String u = null;
    public java.lang.String w = null;
    public final char[] x = {0, 1, 2, 3, 4, 5, 6, 7, '\b', '\t', '\n', 11, '\f', '\r', 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, com.alibaba.fastjson.parser.JSONLexer.EOI, 27, 28, 29, 30, 31, com.aliyun.svideo.editor.guide.customView.MultiLamp.RIGHT, 'x', '5', 'O', '`', 'm', 'H', com.aliyun.svideo.editor.guide.customView.MultiLamp.LEFT, 'F', '@', 'L', 'C', com.aliyun.svideo.editor.guide.customView.MultiLamp.TOP, 'J', 'D', 'W', 'o', '4', 'K', 'w', '1', kotlin.text.Typography.quote, 'R', 'Q', '_', 'A', 'p', 'V', 'v', 'n', 'z', 'i', ')', '9', 'S', '+', '.', 'f', '(', 'Y', kotlin.text.Typography.amp, 'g', '-', '2', '*', '{', '[', '#', '}', '7', '6', 'B', '|', '~', ';', '/', '\\', 'G', 's', 'N', 'X', 'k', 'j', '8', kotlin.text.Typography.dollar, 'y', 'u', 'h', 'e', 'd', 'E', 'I', 'c', '?', '^', ']', '\'', '%', com.alipay.sdk.m.n.a.h, '0', ':', 'q', ' ', 'Z', ',', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, kotlin.text.Typography.less, '3', '!', 'a', kotlin.text.Typography.greater, 'M', 'T', 'P', 'U', 223, 225, 216, 187, 166, 229, kotlin.text.Typography.half, 222, 188, 141, 249, 148, 200, 184, 136, 248, 190, 199, 170, 181, 204, 138, 232, 218, kotlin.text.Typography.middleDot, 255, 234, 220, 247, 213, 203, 226, 193, kotlin.text.Typography.registered, 172, 228, 252, 217, 201, 131, 230, 197, 211, 145, 238, 161, 179, kotlin.text.Typography.nbsp, 212, 207, 221, 254, 173, 202, 146, 224, 151, 140, 196, 205, 130, 135, 133, 143, 246, 192, 159, 244, 239, 185, 168, kotlin.text.Typography.times, 144, 139, 165, 180, 157, 147, 186, 214, kotlin.text.Typography.degree, 227, 231, 219, kotlin.text.Typography.copyright, 175, 156, 206, 198, 129, 164, 150, 210, 154, kotlin.text.Typography.plusMinus, 134, com.google.common.base.Ascii.MAX, kotlin.text.Typography.paragraph, 128, 158, 208, kotlin.text.Typography.cent, 132, kotlin.text.Typography.section, 209, 149, 241, 153, 251, 237, 236, 171, 195, 243, 233, 253, 240, 194, 250, 191, 155, 142, 137, 245, 235, kotlin.text.Typography.pound, 242, 178, 152};

    public CVSPass() {
        this.v = null;
        this.v = new java.io.File(java.lang.System.getProperty("cygwin.user.home", java.lang.System.getProperty(org.apache.tools.ant.launch.Launcher.USER_HOMEDIR)) + java.io.File.separatorChar + ".cvspass");
    }

    public final java.lang.String c(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (char c : str.toCharArray()) {
            sb.append(this.x[c]);
        }
        return sb.toString();
    }

    @Override // org.apache.tools.ant.Task
    public final void execute() throws org.apache.tools.ant.BuildException {
        java.lang.Throwable th;
        java.io.BufferedWriter bufferedWriter;
        java.io.IOException iOException;
        java.io.BufferedReader bufferedReader;
        java.lang.String str;
        if (this.u == null) {
            throw new org.apache.tools.ant.BuildException("cvsroot is required");
        }
        if (this.w == null) {
            throw new org.apache.tools.ant.BuildException("password is required");
        }
        log("cvsRoot: " + this.u, 4);
        log("password: " + this.w, 4);
        log("passFile: " + this.v, 4);
        java.io.BufferedReader bufferedReader2 = null;
        try {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            if (this.v.exists()) {
                bufferedReader = new java.io.BufferedReader(new java.io.FileReader(this.v));
                while (true) {
                    try {
                        java.lang.String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        } else if (!readLine.startsWith(this.u)) {
                            stringBuffer.append(readLine);
                            stringBuffer.append(org.apache.tools.ant.util.StringUtils.LINE_SEP);
                        }
                    } catch (java.io.IOException e) {
                        iOException = e;
                        bufferedWriter = null;
                        bufferedReader2 = bufferedReader;
                        try {
                            throw new org.apache.tools.ant.BuildException(iOException);
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            org.apache.tools.ant.util.FileUtils.close(bufferedReader2);
                            org.apache.tools.ant.util.FileUtils.close(bufferedWriter);
                            throw th;
                        }
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        bufferedWriter = null;
                        bufferedReader2 = bufferedReader;
                        org.apache.tools.ant.util.FileUtils.close(bufferedReader2);
                        org.apache.tools.ant.util.FileUtils.close(bufferedWriter);
                        throw th;
                    }
                }
            } else {
                bufferedReader = null;
            }
            str = stringBuffer.toString() + this.u + " A" + c(this.w);
            log("Writing -> " + str, 4);
            bufferedWriter = new java.io.BufferedWriter(new java.io.FileWriter(this.v));
        } catch (java.io.IOException e2) {
            iOException = e2;
            bufferedWriter = null;
        } catch (java.lang.Throwable th4) {
            th = th4;
            bufferedWriter = null;
        }
        try {
            bufferedWriter.write(str);
            bufferedWriter.newLine();
            org.apache.tools.ant.util.FileUtils.close(bufferedReader);
            org.apache.tools.ant.util.FileUtils.close(bufferedWriter);
        } catch (java.io.IOException e3) {
            iOException = e3;
            bufferedReader2 = bufferedReader;
            throw new org.apache.tools.ant.BuildException(iOException);
        } catch (java.lang.Throwable th5) {
            th = th5;
            bufferedReader2 = bufferedReader;
            org.apache.tools.ant.util.FileUtils.close(bufferedReader2);
            org.apache.tools.ant.util.FileUtils.close(bufferedWriter);
            throw th;
        }
    }

    public void setCvsroot(java.lang.String str) {
        this.u = str;
    }

    public void setPassfile(java.io.File file) {
        this.v = file;
    }

    public void setPassword(java.lang.String str) {
        this.w = str;
    }
}
