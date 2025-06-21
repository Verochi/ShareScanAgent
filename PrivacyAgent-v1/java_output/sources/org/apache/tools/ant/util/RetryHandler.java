package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class RetryHandler {
    public int a;
    public org.apache.tools.ant.Task b;

    public RetryHandler(int i, org.apache.tools.ant.Task task) {
        this.a = i;
        this.b = task;
    }

    public void execute(org.apache.tools.ant.util.Retryable retryable, java.lang.String str) throws java.io.IOException {
        int i = 0;
        while (true) {
            try {
                retryable.execute();
                return;
            } catch (java.io.IOException e) {
                i++;
                if (i > this.a && this.a > -1) {
                    this.b.log("try #" + i + ": IO error (" + str + "), number of maximum retries reached (" + this.a + "), giving up", 1);
                    throw e;
                }
                this.b.log("try #" + i + ": IO error (" + str + "), retrying", 1);
            }
        }
    }
}
