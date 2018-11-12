package com.fastspring.pizza;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({OrderTest.class, PendingOrdersTest.class, PizzaTest.class, UserTest.class})
public class AllTests {

}
