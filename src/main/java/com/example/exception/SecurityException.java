package com.example.exception;

import lombok.Getter;

@Getter
public class SecurityException extends RuntimeException{
    @Getter
    public enum CODE {
        TICKER_IN_USE("Security with such ticker existed"),
        NO_SUCH_SECURITY("Security with such id is not found");

        final String codeDescription;

        CODE(String codeDescription) {
            this.codeDescription = codeDescription;
        }

        public SecurityException get() {
            return new SecurityException(this, this.codeDescription);
        }

        public SecurityException get(String msg) {
            return new SecurityException(this, this.codeDescription + " : " + msg);
        }

        public SecurityException get(Throwable e) {
            return new SecurityException(this, this.codeDescription + " : " + e.getMessage());
        }

        public SecurityException get(Throwable e, String msg) {
            return new SecurityException(this, e, this.codeDescription + " : " + msg);
        }
    }

    protected final SecurityException.CODE code;

    protected SecurityException(SecurityException.CODE code, String msg) {
        this(code, null, msg);
    }

    protected SecurityException(SecurityException.CODE code, Throwable e, String msg) {
        super(msg, e);
        this.code = code;
    }
    
}
