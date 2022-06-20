package site.orangefield.reflect.config.web;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// JVM은 어노테이션을 만들 때 범위를 지정해줘야 한다
@Target({ElementType.METHOD}) // 디폴트 - 모든 곳 (METHOD, CLASS, FIELD)
@Retention(RetentionPolicy.RUNTIME) // 인식 시점 : RUNTIME(실행시), SOURCE(컴파일시)
public @interface RequestMapping {
	String value(); // 어노테이션의 value 메서드가 디폴트 키값(키 생략 가능)
}
