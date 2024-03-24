package com.tahitinumerique.tz.exception;

import java.net.URI;

public enum ProblemType {

    NOT_FOUND("not-found");

    ProblemType(String type) {
        this.subtype = type;
    }

    private final String subtype;

    public URI toType() {
        return URI.create(String.format("/issues/%s", subtype));
    }
}
