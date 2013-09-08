package htable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class HashTableTest {
		
	@Test
	public void addToHashTableFollowedByGet() {
		HashTable<String,String> hashTable = new HashTable<String, String>();
		hashTable.put("A","Alpha");
		
		assertEquals(1, hashTable.size());
		assertEquals("Alpha", hashTable.get("A"));
	}

	@Test
	public void removeFromEmptyTable() {
		HashTable<String,String> hashTable = new HashTable<String, String>();
		hashTable.remove("A");
		
		assertEquals(0, hashTable.size());
		assertNull(hashTable.get("A"));
	}

	@Test
	public void putNullIntoTable() {
		HashTable<String,String> hashTable = new HashTable<String, String>();
		hashTable.put("A", null);
		
		assertEquals(1, hashTable.size());
		assertNull(hashTable.get("A"));
	}

	@Test
	public void addItemsWithSameKeyRetrieveSecondItem() {
		HashTable<String,String> hashTable = new HashTable<String, String>();
		hashTable.put("A","Alpha");
		hashTable.put("A","Apple");
		
		assertEquals(1, hashTable.size());
		assertEquals("Apple", hashTable.get("A"));
	}

	@Test
	public void addTwoItemsAndRetrieve() {
		HashTable<String,String> hashTable = new HashTable<String, String>();
		hashTable.put("A","Alpha");
		hashTable.put("B","Bravo");
		
		assertEquals(2, hashTable.size());
		assertEquals("Alpha", hashTable.get("A"));
		assertEquals("Bravo", hashTable.get("B"));
	}

	@Test
	public void addTwoItemsAndRemoveOne() {
		HashTable<String,String> hashTable = new HashTable<String, String>();
		hashTable.put("A","Alpha");
		hashTable.put("B","Bravo");
		hashTable.remove("B");		
		
		assertEquals(1, hashTable.size());
		assertEquals("Alpha", hashTable.get("A"));
		assertNull(hashTable.get("B"));
	}

	@Test
	public void addTwoItemsInSameBucketAndRemoveOne() {
		HashTable<String,String> hashTable = new HashTable<String, String>();
		hashTable.put("A0","Alpha");
		hashTable.put("A11","Bravo");
		hashTable.remove("A11");		
		
		assertEquals("A0".hashCode() % 10,"A11".hashCode() % 10);
		assertEquals(1, hashTable.size());
		assertEquals("Alpha", hashTable.get("A0"));
		assertNull(hashTable.get("A11"));
	}

	@Test
	public void removeItemThatsNotThere() {
		HashTable<String,String> hashTable = new HashTable<String, String>();
		hashTable.put("A","Alpha");
		hashTable.remove("A12");		
		
		assertEquals(1, hashTable.size());
		assertEquals("Alpha", hashTable.get("A"));
		assertNull(hashTable.get("A12"));
	}

	@Test
	public void addThreeItemsInSameBucketAndRemoveMiddleOne() {
		HashTable<String,String> hashTable = new HashTable<String, String>();
		hashTable.put("A0","Alpha");
		hashTable.put("A11","Bravo");
		hashTable.put("A19","Charlie");
		hashTable.remove("A11");		
		
		assertEquals("A0".hashCode() % 10,"A11".hashCode() % 10);
		assertEquals("A0".hashCode() % 10,"A20".hashCode() % 10);
		assertEquals(2, hashTable.size());
		assertEquals("Alpha", hashTable.get("A0"));
		assertEquals("Charlie", hashTable.get("A19"));
		assertNull(hashTable.get("A11"));
	}

	@Test
	public void addTreeItemsAndRetrieveKeyAndValues() {
		HashTable<String,String> hashTable = new HashTable<String, String>();
		hashTable.put("A","Alpha");
		hashTable.put("B","Bravo");
		hashTable.put("C","Charlie");
		
		assertEquals(3, hashTable.size());
		assertEquals("Alpha", hashTable.get("A"));
		assertEquals("Bravo", hashTable.get("B"));
		assertEquals("Charlie", hashTable.get("C"));
		assertEquals("[A, B, C]", hashTable.keySet().toString());
		assertEquals("[Alpha, Bravo, Charlie]", hashTable.valueSet().toString());
	}

}
