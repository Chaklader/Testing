package com.javacodegeeks.hughwphamill.mockito.verification;

import java.util.Arrays;
import java.util.List;


import org.mockito.exceptions.Reporter;
import org.mockito.exceptions.verification.VerificationInOrderFailure;
import org.mockito.internal.debugging.LocationImpl;
import org.mockito.internal.invocation.InvocationMarker;
import org.mockito.internal.invocation.InvocationMatcher;
import org.mockito.internal.invocation.InvocationsFinder;
import org.mockito.internal.verification.api.VerificationData;
import org.mockito.invocation.Invocation;
import org.mockito.verification.VerificationMode;


/*
* Write a customized verification method 
* (i.e. namely first) with the Mockito
*/


/* VerificationMode: class or extension which is used to verify that the mock 
* invocations we are interested in happend correctly.
*
* InvocationsFinder: will return a list of all invocations with the mock of interest.
*
* InvocationMarker: can be used to mark the mock invocation as verified.
* 
* Reporter: exposes a number of shortcut methods for throwing various VerificationFailure
* errors.
* 
* InvocationMatcher: is used in conjunction with  InvocationsMarker  to find the desired 
* Invocations if they happened.
*/
public class First implements VerificationMode {
	

	private final InvocationsFinder finder = new InvocationsFinder();
	private final InvocationMarker marker = new InvocationMarker();
	private final Reporter reporter = new Reporter();
	
	public static VerificationMode first() {
		return new First();
	}


	/*In the verify method we will find all matching invocations and verify 
	two things:

	i. The invocation we wanted actually happened, if it did not we will use 
	Reporter to throw a “wanted but not invoked” error.

	ii. The invocation we wanted was the first invocation on the Mock, if it 
	was not we will throw a new exception with an appropriate message detailing 
	the expected invocation and the actual one.*/
	@Override
	public void verify(VerificationData data) {

		List<Invocation> invocations = data.getAllInvocations();
		InvocationMatcher matcher = data.getWanted();
		
		List<Invocation> chunk = finder.findInvocations(invocations, matcher);
		
		if (invocations.size() == 0 || chunk.size() == 0) {
			reporter.wantedButNotInvoked(matcher);
		} else if (!sameInvocation(invocations.get(0), chunk.get(0))) {			
			reportNotFirst(chunk.get(0), invocations.get(0));
		}
		
		marker.markVerified(chunk.get(0), matcher);	
	}

	private boolean sameInvocation(Invocation left, Invocation right) {
		
		if (left == right) {
			return true;			
		}	
		
		return left.getMock().equals(right.getMock()) 
					&& left.getMethod().equals(right.getMethod()) 
					&& Arrays.equals(left.getArguments(), right.getArguments());
	}
	
	private void reportNotFirst(Invocation wanted, Invocation unwanted) {
		
		StringBuilder message = new StringBuilder();
		
		message.append("\nWanted first:\n").append(wanted).append("\n").append(new LocationImpl());
		message.append("\nInstead got:\n").append(unwanted).append("\n").append(unwanted.getLocation()).append("\n");

		throw new VerificationInOrderFailure(message.toString());
	}
}
