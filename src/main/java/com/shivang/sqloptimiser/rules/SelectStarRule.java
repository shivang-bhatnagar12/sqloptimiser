package com.shivang.sqloptimiser.rules;

import com.shivang.sqloptimiser.model.OptimisationIssue;
import com.shivang.sqloptimiser.model.Severity;

import java.util.Optional;
import java.util.regex.Pattern;

public class SelectStarRule implements OptimisationRule{
    private static final Pattern SELECT_STAR_PATTERN =  
        Pattern.compile("^\\s*select\\s+\\*", Pattern.CASE_INSENSITIVE);

    @Override
    public Optional<OptimisationIssue> analyse(String sql) {
        // TODO Auto-generated method stub
        if(sql == null || sql.isBlank()){
            return Optional.empty();
        }

        if(SELECT_STAR_PATTERN.matcher(sql).find()){
            return Optional.of(
                new OptimisationIssue(
                    getName(), 
                    "Avoid using SELECT *. Specify only required columns.", 
                    Severity.MEDIUM)
            );
        }

        return Optional.empty();
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "SELECT_STAR_USAGE";
    }

    
}
