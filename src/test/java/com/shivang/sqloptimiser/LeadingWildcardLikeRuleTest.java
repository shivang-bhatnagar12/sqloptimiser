package com.shivang.sqloptimiser;

import java.util.Optional;

import com.shivang.sqloptimiser.model.OptimisationIssue;
import com.shivang.sqloptimiser.rules.LeadingWildcardLikeRule;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeadingWildcardLikeRuleTest {
    private final LeadingWildcardLikeRule rule = new LeadingWildcardLikeRule();

    @Test
    void detectsLeadingWildcardLikeRule(){
        Optional<OptimisationIssue> issue = rule.analyse("SELECT * FROM users WHERE name LIKE '%abc'");
        
        assertTrue(issue.isPresent());
    }

    @Test
    void ignoresTrailingWildcardLikeRule(){
        Optional<OptimisationIssue> issue = rule.analyse("SELECT * FROM users WHERE name LIKE 'abc%");

        assertTrue(issue.isEmpty());
    }
}
