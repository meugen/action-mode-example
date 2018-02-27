package meugeninua.examples.actionmode.app.di.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author meugen
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerFragment {}
