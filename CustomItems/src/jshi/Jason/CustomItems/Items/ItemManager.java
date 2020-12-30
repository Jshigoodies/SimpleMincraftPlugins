package jshi.Jason.CustomItems.Items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemManager {
	public static ItemStack wand;
	
	public static void init()
	{
		createWand();
		
	}
	
	private static void createWand()
	{
		ItemStack item = new ItemStack(Material.STICK, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§6The Stick Of Power");
		
		List<String> lore = new ArrayList<String>();
		lore.add("§7This is my custom item");
		lore.add("§7Made by Jshi");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.LUCK, 1, false);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		
		wand = item;
		
		//Shaped
		ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("wand"), item);
		sr.shape("B  ", 
				 " S ", 
				 "  S");
		sr.setIngredient('B', Material.BLAZE_POWDER);
	}
}
