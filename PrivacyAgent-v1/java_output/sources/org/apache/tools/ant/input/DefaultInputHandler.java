package org.apache.tools.ant.input;

/* loaded from: classes25.dex */
public class DefaultInputHandler implements org.apache.tools.ant.input.InputHandler {
    public java.io.InputStream getInputStream() {
        return org.apache.tools.ant.util.KeepAliveInputStream.wrapSystemIn();
    }

    public java.lang.String getPrompt(org.apache.tools.ant.input.InputRequest inputRequest) {
        java.lang.String prompt = inputRequest.getPrompt();
        java.lang.String defaultValue = inputRequest.getDefaultValue();
        if (!(inputRequest instanceof org.apache.tools.ant.input.MultipleChoiceInputRequest)) {
            if (defaultValue == null) {
                return prompt;
            }
            return prompt + " [" + defaultValue + "]";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(prompt);
        sb.append(" (");
        java.util.Iterator<java.lang.String> it = ((org.apache.tools.ant.input.MultipleChoiceInputRequest) inputRequest).getChoices().iterator();
        boolean z = true;
        while (it.hasNext()) {
            java.lang.String next = it.next();
            if (!z) {
                sb.append(", ");
            }
            if (next.equals(defaultValue)) {
                sb.append('[');
            }
            sb.append(next);
            if (next.equals(defaultValue)) {
                sb.append(']');
            }
            z = false;
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0038, code lost:
    
        throw new org.apache.tools.ant.BuildException("Failed to close input.", r6);
     */
    @Override // org.apache.tools.ant.input.InputHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleInput(org.apache.tools.ant.input.InputRequest inputRequest) throws org.apache.tools.ant.BuildException {
        java.lang.String prompt = getPrompt(inputRequest);
        java.io.BufferedReader bufferedReader = null;
        try {
            java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.InputStreamReader(getInputStream()));
            do {
                try {
                    java.lang.System.err.println(prompt);
                    java.lang.System.err.flush();
                    try {
                        java.lang.String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            throw new org.apache.tools.ant.BuildException("unexpected end of stream while reading input");
                        }
                        inputRequest.setInput(readLine);
                    } catch (java.io.IOException e) {
                        throw new org.apache.tools.ant.BuildException("Failed to read input from Console.", e);
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (java.io.IOException unused) {
                        }
                    }
                    throw th;
                }
            } while (!inputRequest.isInputValid());
            bufferedReader2.close();
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }
}
