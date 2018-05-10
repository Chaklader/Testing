package junitquickcheck;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeThat;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.When;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;


/*
JUnit QuickCheck 
————————————————

i.   Using Assume Class
ii.  @InRange Annotation
iii. @When Annotation
iv.  Using Seed

Shrinking
—————————

When a property is disproved for a given set of values, junit-quickcheck will 
attempt to find “smaller” sets of values that also disprove the property, and 
will report the smallest such set.

Various parameters used with shrinking process
——————————————————————————————————————————————

By default, shrinking is enabled. To disable it, set the shrink attribute of a 
@Property annotation to false. Example: @Property(shrink = false)

To reduce or increase the maximum number of shrink attempts made for a given 
property, set the maxShrinks attribute of that @Property. Example: 
@Property(maxShrinks = 5)

To reduce or increase the maximum “depth” of the shrink search “tree” for a given 
property, set the maxShrinkDepth attribute of that @Property. Example: 
@Property(maxShrinkDepth = 3)
*/

@RunWith(JUnitQuickcheck.class)
public class QuickCheck {

	@Property(trials = 5)
	public void simple(int num) {
		System.out.println("simple:" + num);
		assertTrue(num > 0);
	}

	@Property(trials = 5)
	public void assume(int num) {
		System.out.print(" | Before:" + num);
		assumeThat(num, greaterThan(0));
		System.out.println(" | Afer:" + num);
		assertTrue(num > 0);
	}

	@Property(trials = 5)
	public void inRange(@InRange(minInt = 0, maxInt = 100) int num) {
		System.out.println("InRange: " + num);
		assertTrue(num > 0);
	}

	@Property(trials = 5)
	public void when(@When(satisfies = "#_ > 1000 && #_ < 100000") int num) {
		System.out.println("when: " + num);
		assertTrue(num > 0);
	}
	

	/*
		For each property, junit-quickcheck uses a unique value as a seed for 
		the source of randomness for generating values. We can fix the seed to 
		some specific value with @When annotation . You may want to fix the seed 
		when a property fails, so that you can test the property over and over 
		again with the same set of generated values that caused the failure.
	*/
	@Property(trials = 5)
	public void seed(@When(seed = 1L) int num) {
		System.out.println("seed: " + num);
		assertTrue(num > 0);
	}

}
