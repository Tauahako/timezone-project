package com.tahitinumerique.tz.exception;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.util.Map;

import static com.tahitinumerique.tz.exception.ProblemType.NOT_FOUND;


public class NotFoundProblem extends AbstractThrowableProblem {
    public NotFoundProblem(String resourceType, String resourceId) {
        super(
                NOT_FOUND.toType(),
                "Not found",
                Status.NOT_FOUND,
                String.format("%s record (id=%s) cannot be found", resourceType, resourceId),
                null,
                null,
                Map.of(
                        "recordType", resourceType,
                        "identifier", resourceId
                )
        );
    }

    public NotFoundProblem(String resourceType, Long resourceId) {
        this(
                resourceType,
                (resourceId != null) ? resourceId.toString() : "?"
        );
    }
}
