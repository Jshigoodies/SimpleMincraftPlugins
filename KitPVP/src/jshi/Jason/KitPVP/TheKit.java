package jshi.Jason.KitPVP;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class TheKit {
	private ItemStack[] armor;
	private ItemStack[] items;
	
	public TheKit()
	{
		armor = new ItemStack[4]; // full armor
		items = new ItemStack[5]; // sword, shield, blocks, steak, pickaxe
		makeArmor();
		makeItems();
	}
	
	public void makeArmor()
	{
		armor[0] = new ItemStack(Material.NETHERITE_BOOTS);
		armor[1] = new ItemStack(Material.NETHERITE_LEGGINGS);
		armor[2] = new ItemStack(Material.NETHERITE_CHESTPLATE);
		armor[3] = new ItemStack(Material.NETHERITE_HELMET);
		
		for(int i = 0; i < armor.length; i++)
		{
			ItemMeta meta = armor[i].getItemMeta();
			meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "KIT PVP");
			
			
			//description
			List<String> lore = new ArrayList<String>();
			lore.add(ChatColor.WHITE + "made by Jshi");
			lore.add(ChatColor.WHITE + "for pvping");
			
			meta.setLore(lore);
			
			//enchants
			meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
			meta.addEnchant(Enchantment.DURABILITY, 10, true);
			meta.addEnchant(Enchantment.PROTECTION_FIRE, 3, true);
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			
			
			//setting that custom item
			armor[i].setItemMeta(meta);
		}
	}
	
	public void makeItems()
	{
		items[0] = new ItemStack(Material.NETHERITE_SWORD);
		items[1] = new ItemStack(Material.SHIELD);
		items[2] = new ItemStack(Material.COBBLESTONE, 64);
		items[4] = new ItemStack(Material.GOLDEN_APPLE, 5);
		items[5] = new ItemStack(Material.NETHERITE_PICKAXE);
	}
}
