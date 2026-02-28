package com.shivang.sqloptimiser.rules;

import java.util.Optional;
import java.util.regex.Pattern;

import com.shivang.sqloptimiser.model.OptimisationIssue;
import com.shivang.sqloptimiser.model.Severity;

public class LeadingWildcardLikeRule implements OptimisationRule{

    private static final Pattern LEADING_WILDCARD_LIKE =
            Pattern.compile("like\\s+'%[^']*'", Pattern.CASE_INSENSITIVE);
            
    @Override
    public Optional<OptimisationIssue> analyse(String sql) {
        // TODO Auto-generated method stub
        if(sql == null || sql.isBlank()){
            return Optional.empty();
        }
        if(LEADING_WILDCARD_LIKE.matcher(sql).find()){
            return Optional.of(
                new OptimisationIssue(
                    getName(), 
                    "Leading wildcard in LIKE prevents index usage.",
                    Severity.HIGH
                )
            );
        }

        return Optional.empty();
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "LEADING_WILDCARD_LIKE";
    }
    
}
