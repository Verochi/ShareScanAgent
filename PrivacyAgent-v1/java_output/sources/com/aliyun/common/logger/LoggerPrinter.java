package com.aliyun.common.logger;

/* loaded from: classes.dex */
public final class LoggerPrinter implements com.aliyun.common.logger.Printer {
    private static final int ASSERT = 7;
    private static final java.lang.String BOTTOM_BORDER = "╚════════════════════════════════════════════════════════════════════════════════════════";
    private static final char BOTTOM_LEFT_CORNER = 9562;
    private static final int CHUNK_SIZE = 4000;
    private static final int DEBUG = 3;
    private static final java.lang.String DOUBLE_DIVIDER = "════════════════════════════════════════════";
    private static final int ERROR = 6;
    private static final char HORIZONTAL_DOUBLE_LINE = 9553;
    private static final int INFO = 4;
    private static final int JSON_INDENT = 4;
    private static final java.lang.String MIDDLE_BORDER = "╟────────────────────────────────────────────────────────────────────────────────────────";
    private static final char MIDDLE_CORNER = 9567;
    private static final int MIN_STACK_OFFSET = 3;
    private static final java.lang.String SINGLE_DIVIDER = "────────────────────────────────────────────";
    private static final java.lang.String TOP_BORDER = "╔════════════════════════════════════════════════════════════════════════════════════════";
    private static final char TOP_LEFT_CORNER = 9556;
    private static final int VERBOSE = 2;
    private static final int WARN = 5;
    private com.aliyun.common.logger.Settings settings;
    private java.lang.String tag;
    private final java.lang.ThreadLocal<java.lang.String> localTag = new java.lang.ThreadLocal<>();
    private final java.lang.ThreadLocal<java.lang.Integer> localMethodCount = new java.lang.ThreadLocal<>();

    private java.lang.String createMessage(java.lang.String str, java.lang.Object... objArr) {
        return objArr.length == 0 ? str : java.lang.String.format(str, objArr);
    }

    private java.lang.String formatTag(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.equals(this.tag, str)) {
            return this.tag;
        }
        return this.tag + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str;
    }

    private int getMethodCount() {
        java.lang.Integer num = this.localMethodCount.get();
        int methodCount = this.settings.getMethodCount();
        if (num != null) {
            this.localMethodCount.remove();
            methodCount = num.intValue();
        }
        if (methodCount >= 0) {
            return methodCount;
        }
        throw new java.lang.IllegalStateException("methodCount cannot be negative");
    }

    private java.lang.String getSimpleClassName(java.lang.String str) {
        return str.substring(str.lastIndexOf(".") + 1);
    }

    private int getStackOffset(java.lang.StackTraceElement[] stackTraceElementArr) {
        for (int i = 3; i < stackTraceElementArr.length; i++) {
            java.lang.String className = stackTraceElementArr[i].getClassName();
            if (!className.equals(com.aliyun.common.logger.LoggerPrinter.class.getName()) && !className.equals(com.aliyun.common.logger.Logger.class.getName())) {
                return i - 1;
            }
        }
        return -1;
    }

    private java.lang.String getTag() {
        java.lang.String str = this.localTag.get();
        if (str == null) {
            return this.tag;
        }
        this.localTag.remove();
        return str;
    }

    private synchronized void log(int i, java.lang.String str, java.lang.Object... objArr) {
        if (this.settings.getLogLevel() == com.aliyun.common.logger.LogLevel.NONE) {
            return;
        }
        java.lang.String tag = getTag();
        java.lang.String createMessage = createMessage(str, objArr);
        int methodCount = getMethodCount();
        logTopBorder(i, tag);
        logHeaderContent(i, tag, methodCount);
        byte[] bytes = createMessage.getBytes();
        int length = bytes.length;
        if (length <= 4000) {
            if (methodCount > 0) {
                logDivider(i, tag);
            }
            logContent(i, tag, createMessage);
            logBottomBorder(i, tag);
            return;
        }
        if (methodCount > 0) {
            logDivider(i, tag);
        }
        for (int i2 = 0; i2 < length; i2 += 4000) {
            logContent(i, tag, new java.lang.String(bytes, i2, java.lang.Math.min(length - i2, 4000)));
        }
        logBottomBorder(i, tag);
    }

    private void logBottomBorder(int i, java.lang.String str) {
        logChunk(i, str, BOTTOM_BORDER);
    }

    private void logChunk(int i, java.lang.String str, java.lang.String str2) {
        java.lang.String formatTag = formatTag(str);
        if (i == 2) {
            this.settings.getLogTool().v(formatTag, str2);
            return;
        }
        if (i == 4) {
            this.settings.getLogTool().i(formatTag, str2);
            return;
        }
        if (i == 5) {
            this.settings.getLogTool().w(formatTag, str2);
            return;
        }
        if (i == 6) {
            this.settings.getLogTool().e(formatTag, str2);
        } else if (i != 7) {
            this.settings.getLogTool().d(formatTag, str2);
        } else {
            this.settings.getLogTool().wtf(formatTag, str2);
        }
    }

    private void logContent(int i, java.lang.String str, java.lang.String str2) {
        for (java.lang.String str3 : str2.split(java.lang.System.getProperty("line.separator"))) {
            logChunk(i, str, "║ " + str3);
        }
    }

    private void logDivider(int i, java.lang.String str) {
        logChunk(i, str, MIDDLE_BORDER);
    }

    private void logHeaderContent(int i, java.lang.String str, int i2) {
        java.lang.StackTraceElement[] stackTrace = java.lang.Thread.currentThread().getStackTrace();
        if (this.settings.isShowThreadInfo()) {
            logChunk(i, str, "║ Thread: " + java.lang.Thread.currentThread().getName());
            logDivider(i, str);
        }
        int stackOffset = getStackOffset(stackTrace) + this.settings.getMethodOffset();
        java.lang.String str2 = "";
        if (i2 + stackOffset > stackTrace.length) {
            i2 = (stackTrace.length - stackOffset) - 1;
        }
        while (i2 > 0) {
            int i3 = i2 + stackOffset;
            if (i3 < stackTrace.length) {
                logChunk(i, str, "║ " + str2 + getSimpleClassName(stackTrace[i3].getClassName()) + "." + stackTrace[i3].getMethodName() + "  (" + stackTrace[i3].getFileName() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + stackTrace[i3].getLineNumber() + ")");
                str2 = str2 + "   ";
            }
            i2--;
        }
    }

    private void logTopBorder(int i, java.lang.String str) {
        logChunk(i, str, TOP_BORDER);
    }

    @Override // com.aliyun.common.logger.Printer
    public void clear() {
        this.settings = null;
    }

    @Override // com.aliyun.common.logger.Printer
    public void d(java.lang.String str, java.lang.Object... objArr) {
        log(3, str, objArr);
    }

    @Override // com.aliyun.common.logger.Printer
    public void e(java.lang.String str, java.lang.Object... objArr) {
        e(null, str, objArr);
    }

    @Override // com.aliyun.common.logger.Printer
    public void e(java.lang.Throwable th) {
        e(th, null, new java.lang.Object[0]);
    }

    @Override // com.aliyun.common.logger.Printer
    public void e(java.lang.Throwable th, java.lang.String str, java.lang.Object... objArr) {
        if (th != null && str != null) {
            str = str + " : " + th.toString();
        }
        if (th != null && str == null) {
            str = th.toString();
        }
        if (str == null) {
            str = "No message/exception is set";
        }
        log(6, str, objArr);
    }

    @Override // com.aliyun.common.logger.Printer
    public com.aliyun.common.logger.Settings getSettings() {
        return this.settings;
    }

    @Override // com.aliyun.common.logger.Printer
    public void i(java.lang.String str, java.lang.Object... objArr) {
        log(4, str, objArr);
    }

    public com.aliyun.common.logger.Settings init(java.lang.String str) {
        if (str == null) {
            throw new java.lang.NullPointerException("tag may not be null");
        }
        if (str.trim().length() == 0) {
            throw new java.lang.IllegalStateException("tag may not be empty");
        }
        this.tag = str;
        com.aliyun.common.logger.Settings settings = new com.aliyun.common.logger.Settings();
        this.settings = settings;
        return settings;
    }

    @Override // com.aliyun.common.logger.Printer
    public void json(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            d("Empty/Null json content", new java.lang.Object[0]);
            return;
        }
        try {
            if (str.startsWith("{")) {
                d(new org.json.JSONObject(str).toString(4), new java.lang.Object[0]);
            } else if (str.startsWith("[")) {
                d(new org.json.JSONArray(str).toString(4), new java.lang.Object[0]);
            }
        } catch (org.json.JSONException e) {
            e(e.getCause().getMessage() + "\n" + str, new java.lang.Object[0]);
        }
    }

    @Override // com.aliyun.common.logger.Printer
    public com.aliyun.common.logger.Printer t(java.lang.String str, int i) {
        if (str != null) {
            this.localTag.set(str);
        }
        this.localMethodCount.set(java.lang.Integer.valueOf(i));
        return this;
    }

    @Override // com.aliyun.common.logger.Printer
    public void v(java.lang.String str, java.lang.Object... objArr) {
        log(2, str, objArr);
    }

    @Override // com.aliyun.common.logger.Printer
    public void w(java.lang.String str, java.lang.Object... objArr) {
        log(5, str, objArr);
    }

    @Override // com.aliyun.common.logger.Printer
    public void wtf(java.lang.String str, java.lang.Object... objArr) {
        log(7, str, objArr);
    }

    @Override // com.aliyun.common.logger.Printer
    public void xml(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            d("Empty/Null xml content", new java.lang.Object[0]);
            return;
        }
        try {
            javax.xml.transform.stream.StreamSource streamSource = new javax.xml.transform.stream.StreamSource(new java.io.StringReader(str));
            javax.xml.transform.stream.StreamResult streamResult = new javax.xml.transform.stream.StreamResult(new java.io.StringWriter());
            javax.xml.transform.Transformer newTransformer = javax.xml.transform.TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("indent", "yes");
            newTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            newTransformer.transform(streamSource, streamResult);
            d(streamResult.getWriter().toString().replaceFirst(">", ">\n"), new java.lang.Object[0]);
        } catch (javax.xml.transform.TransformerException e) {
            e(e.getCause().getMessage() + "\n" + str, new java.lang.Object[0]);
        }
    }
}
