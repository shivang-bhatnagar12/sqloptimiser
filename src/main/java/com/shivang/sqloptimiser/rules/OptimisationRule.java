package com.shivang.sqloptimiser.rules;

import com.shivang.sqloptimiser.model.OptimisationIssue;
import java.util.Optional;

public interface OptimisationRule {
    /** 
     * @param sql raw SQL query
     * @return Optional issue if rule is violated
    */

    Optional<OptimisationIssue> analyse(String sql);

    /**
     * @return unique rule name
     */ 
    String getName();
}
