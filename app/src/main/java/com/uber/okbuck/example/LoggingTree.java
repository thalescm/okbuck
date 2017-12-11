package com.uber.okbuck.example;

import javax.inject.Inject;

import timber.log.Timber.DebugTree;

/** A Timber logging tree for debugging. */
public class LoggingTree extends DebugTree {

  /** Constructor. */
  @Inject
  public LoggingTree() {}
}
