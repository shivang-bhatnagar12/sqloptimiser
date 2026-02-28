package com.shivang.sqloptimiser.engine;

import com.shivang.sqloptimiser.model.OptimisationIssue;
import com.shivang.sqloptimiser.rules.OptimisationRule;

import java.util.ArrayList;
import java.util.List;

public class RuleEngine {
    private final List<OptimisationRule> rules;

    public RuleEngine(List<OptimisationRule> rules){
        this.rules = rules;
    }

    public List<OptimisationIssue> analyse(String sql){
        List<OptimisationIssue> issues = new ArrayList<OptimisationIssue>();

        for(OptimisationRule rule : rules){
            rule.analyse(sql).ifPresent(issues::add);
        }
        return issues;
    }
}
