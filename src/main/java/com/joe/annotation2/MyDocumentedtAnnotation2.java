package com.joe.annotation2;

import java.lang.annotation.Documented;

@Documented
public @interface MyDocumentedtAnnotation2 {

    String key() default "key";
    String str();
    String[] strArr();

}
