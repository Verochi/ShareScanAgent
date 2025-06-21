package org.apache.tools.ant;

/* loaded from: classes25.dex */
public interface BuildLogger extends org.apache.tools.ant.BuildListener {
    void setEmacsMode(boolean z);

    void setErrorPrintStream(java.io.PrintStream printStream);

    void setMessageOutputLevel(int i);

    void setOutputPrintStream(java.io.PrintStream printStream);
}
