package com.sg;
import java.util.function.IntPredicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ContainsDigits implements Rule {
    private static final Logger logger = LoggerFactory.getLogger(ContainsDigits.class);

    @Override
    public boolean isSatisfiedOn(String string) {
        logger.debug("Evaluating {} against a string of length {}", getClass().getSimpleName(), string.length());

        boolean satisfied = string.chars().anyMatch(new IsDigit());
        logger.debug("{} evaluated to {}", getClass().getSimpleName(), satisfied);
        return satisfied;
    }

    private final class IsDigit implements IntPredicate {
        @Override
        public boolean test(int asciiValue) {
            return asciiValue >= 48 && asciiValue <= 57;
        }
    }
}