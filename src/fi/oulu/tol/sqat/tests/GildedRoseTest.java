package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

// Example scenarios for testing
//   Item("+5 Dexterity Vest", 10, 20));
//   Item("Aged Brie", 2, 0));
//   Item("Elixir of the Mongoose", 5, 7));
//   Item("Sulfuras, Hand of Ragnaros", 0, 80));
//   Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
//   Item("Conjured Mana Cake", 3, 6));

	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_10_11() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(11, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_2_Days() {
		
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 10) );
		
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(12, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_QualityMax() {
		
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 50) );
		
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(50, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_DexterityVest() {
		
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 10, 20));
		
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item itemVest = items.get(0);
		assertEquals(19, itemVest.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_DexterityVest_0_Days() {
		
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 0, 10));
		
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item itemVest = items.get(0);
		assertEquals(8, itemVest.getQuality());
	}
	
	
	@Test
	public void testUpdateEndOfDay_Elixir() {
		
		GildedRose store = new GildedRose();
		store.addItem(new Item("Elixir of the Mongoose", 5, 7));
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item itemElixir = items.get(0);
		assertEquals(6, itemElixir.getQuality());
		
	}
	
	@Test
	public void testUpdateEndOfDay_Elixir_QualityMin() {
		
		GildedRose store = new GildedRose();
		store.addItem(new Item("Elixir of the Mongoose", 0, 2));
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item itemElixir = items.get(0);
		assertEquals(0, itemElixir.getQuality());
		
	}
    
	@Test
	public void testUpdateEndOfDay_BackStagePasses10Days() {
		
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 25) );
		
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item itemPass = items.get(0);
		assertEquals(27, itemPass.getQuality());
		
	}
	
	@Test
	public void testUpdateEndOfDay_BackStagePasses6Days() {
		
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 6, 33) );
		
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item itemPass = items.get(0);
		assertEquals(38, itemPass.getQuality());
		
	}
	
	
	@Test
	public void testUpdateEndOfDay_BackStagePasses4Days() {
		
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 35) );
		
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item itemPass = items.get(0);
		assertEquals(38, itemPass.getQuality());
		
	}
	
	@Test
	public void testUpdateEndOfDay_BackStagePasses0Days() {
		
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50) );
		
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item itemPass = items.get(0);
		assertEquals(0, itemPass.getQuality());
		
	}
	
	@Test
	public void testUpdateEndOfDay_Sulfuras() {
		
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80) );
		
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item itemSulfuras = items.get(0);
		assertEquals(80, itemSulfuras.getQuality());
		
	}
	
	@Test
	public void testUpdateEndOfDay_Cake() {
		
		GildedRose store = new GildedRose();
		store.addItem(new Item("Conjured Mana Cake", 3, 6));
		
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item itemCake = items.get(0);
		assertEquals(5, itemCake.getQuality());
		
	}
	
	@Test
	public void testUpdateEndOfDay_Cake_QualityMin() {
		
		GildedRose store = new GildedRose();
		store.addItem(new Item("Conjured Mana Cake", 0, 3));
		
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item itemCake = items.get(0);
		assertEquals(0, itemCake.getQuality());
		
	}
}
