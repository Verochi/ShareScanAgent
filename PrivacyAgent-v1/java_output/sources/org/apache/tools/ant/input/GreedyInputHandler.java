package org.apache.tools.ant.input;

/* loaded from: classes25.dex */
public class GreedyInputHandler extends org.apache.tools.ant.input.DefaultInputHandler {
    @Override // org.apache.tools.ant.input.DefaultInputHandler, org.apache.tools.ant.input.InputHandler
    public void handleInput(org.apache.tools.ant.input.InputRequest inputRequest) throws org.apache.tools.ant.BuildException {
        java.io.InputStream inputStream;
        java.lang.String prompt = getPrompt(inputRequest);
        try {
            inputStream = getInputStream();
            try {
                java.lang.System.err.println(prompt);
                java.lang.System.err.flush();
                java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                org.apache.tools.ant.taskdefs.StreamPumper streamPumper = new org.apache.tools.ant.taskdefs.StreamPumper(inputStream, byteArrayOutputStream);
                java.lang.Thread thread = new java.lang.Thread(streamPumper);
                thread.start();
                try {
                    try {
                        thread.join();
                    } catch (java.lang.InterruptedException unused) {
                    }
                } catch (java.lang.InterruptedException unused2) {
                    thread.join();
                }
                inputRequest.setInput(new java.lang.String(byteArrayOutputStream.toByteArray()));
                if (!inputRequest.isInputValid()) {
                    throw new org.apache.tools.ant.BuildException("Received invalid console input");
                }
                if (streamPumper.getException() != null) {
                    throw new org.apache.tools.ant.BuildException("Failed to read input from console", streamPumper.getException());
                }
                org.apache.tools.ant.util.FileUtils.close(inputStream);
            } catch (java.lang.Throwable th) {
                th = th;
                org.apache.tools.ant.util.FileUtils.close(inputStream);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }
}
