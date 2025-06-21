package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public interface Retryable {
    public static final int RETRY_FOREVER = -1;

    void execute() throws java.io.IOException;
}
