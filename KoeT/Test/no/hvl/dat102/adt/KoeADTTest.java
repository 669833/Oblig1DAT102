package no.hvl.dat102.adt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public abstract class KoeADTTest {
private KoeADT <Integer> koe;


private Integer a0 = 1;
private Integer a1 = 2;
private Integer a2 = 3;
protected abstract KoeADT<Integer> reset();


@BeforeEach
public void setup() {
koe =reset();	
}
	



@Test
public void nyKoe() {
	assertTrue(koe.erTom());
}




@Test
public void innutSeforste() {
	koe.innKoe(a0);
	koe.innKoe(a1);
	
	
	try {
		assertEquals(a0,koe.foerste());
		assertEquals(a0,koe.utKoe());
		assertEquals(a1,koe.utKoe());
		
		
	}catch (no.hvl.dat102.exceptions.EmptyCollectionException e) {
		fail("Feil"+e.getMessage());
	}
}
@Test
public void erIkkeTom() {
	koe.innKoe(a2);
	assertFalse(koe.erTom());
}

@Test 
public void InnUtErTom() {
	try {
		koe.innKoe(a0);
		koe.utKoe();
		assertTrue(koe.erTom());
	} catch (no.hvl.dat102.exceptions.EmptyCollectionException e) {
		fail("Feil"+e.getMessage());
	}
}

public void Utkoe() {
	Assertions.assertThrows(no.hvl.dat102.exceptions.EmptyCollectionException.class, () -> {
		koe.utKoe();
	});

}
}
