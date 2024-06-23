package org.marcoantdev.app.utils;

import org.jboss.logging.Logger;

public class ExceptionUtil {

    public static Throwable print(Throwable throwable) {
        Throwable rootCause = ExceptionUtil.getRootCause(throwable);
        StringBuilder sb = new StringBuilder();

        sb.append(rootCause.getMessage() + "\n");
        for (StackTraceElement element : rootCause.getStackTrace()) {
            if (element.getClassName().contains("org.marcoantdev.app") && element.getLineNumber() > 0) {
                sb.append("    -> " + element.getFileName() + " (" + element.getMethodName() + ") : "
                        + element.getLineNumber() + "\n");
            }
        }

        Logger.getLogger("exception-util").error(sb.toString());
        return rootCause;
    }

    public static Throwable getRootCause(Throwable throwable) {
        Throwable rootCause = throwable;
        while (rootCause.getCause() != null && rootCause.getCause() != rootCause) {
            rootCause = rootCause.getCause();
        }
        return rootCause;
    }
}
