package com.shivang.sqloptimiser.engine;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.shivang.sqloptimiser.model.OptimisationIssue;
import com.shivang.sqloptimiser.rules.SelectStarRule;

class RuleEngineTests {

    @Test
    void engineRunsSelectStarRule() {

        RuleEngine engine = new RuleEngine(List.of(new SelectStarRule()));

        List<OptimisationIssue> issues = engine.analyse("SELECT * FROM users");

        assertEquals(1, issues.size());
        assertEquals("SELECT_STAR_USAGE", issues.get(0).getRuleName());
    }
}

