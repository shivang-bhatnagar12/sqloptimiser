package com.shivang.sqloptimiser.rules;

import java.util.Optional;
import java.util.regex.Pattern;

import com.shivang.sqloptimiser.model.OptimisationIssue;
import com.shivang.sqloptimiser.model.Severity;

public class FunctionOnColumnRule implements OptimisationRule{

    private static final Pattern FUNCTION_ON_COLUMN = Pattern.compile("where\\s+\\w+\\s*\\(\\s*\\w+\\s*\\)", Pattern.CASE_INSENSITIVE);

    @Override
    public Optional<OptimisationIssue> analyse(String sql) {
        if(sql == null || sql.isBlank()){
            return Optional.empty();
        }

        if(FUNCTION_ON_COLUMN.matcher(sql).find()){
            return Optional.of(
                new OptimisationIssue(
                    getName(), 
                    "Function applied on column in WHERE clause may prevent index usage.",
                    Severity.MEDIUM)
            );
        }
        return Optional.empty();

    }

    @Override
    public String getName() {
        return "FUNCTION_ON_COLUMN";
    }

}
