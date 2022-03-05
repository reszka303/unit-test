package pl.javastart.taggingandrunningselectedtests;

import org.junit.jupiter.api.Tag;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Tag("important")
@Fast
@interface FastImportant {}
