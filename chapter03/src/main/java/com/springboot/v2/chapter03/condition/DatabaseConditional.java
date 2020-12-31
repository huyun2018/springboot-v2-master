package com.springboot.v2.chapter03.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class DatabaseConditional implements Condition {

	@Override
	/*
	 * 
	 * @param context 条件上下文
	 * @param 
	 */
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		Environment env = context.getEnvironment();
		return env.containsProperty("spring.datasource.driver") && env.containsProperty("spring.datasource.url")
				&& env.containsProperty("spring.datasource.username") && env.containsProperty("spring.datasource.password");
	}

}
