package StackTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Stack.ArrayListStack;

public class ArrayListStackTest extends ListStackTest{

	
	public ArrayListStackTest()
	{
		super(new ArrayListStack());
	}
	@Before
	public void setUp() throws Exception {
	}


}
