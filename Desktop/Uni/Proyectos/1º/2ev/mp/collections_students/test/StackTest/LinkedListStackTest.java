package StackTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Stack.ArrayListStack;

public class LinkedListStackTest  extends ListStackTest{

	
	public LinkedListStackTest()
	{
		super(new ArrayListStack());
	}
	@Before
	public void setUp() throws Exception {
	}

}
