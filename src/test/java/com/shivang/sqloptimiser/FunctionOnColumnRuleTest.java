package com.shivang.sqloptimiser;

import com.shivang.sqloptimiser.model.OptimisationIssue;
import com.shivang.sqloptimiser.rules.FunctionOnColumnRule;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FunctionOnColumnRuleTest {
    private final FunctionOnColumnRule rule = new FunctionOnColumnRule();

    @Test
    void detectFunctionOnColumnRule(){
        Optional<OptimisationIssue> issue = rule.analyse("SELECT id FROM users WHERE UPPER(name) = 'JOHN'");

        assertTrue(issue.isPresent());
    }
}
