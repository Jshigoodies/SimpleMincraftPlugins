package jshi.Jason.KitPVP;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.Banner;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class TheKit {
	private ItemStack[] armor;
	private ItemStack[] items;
	
	public TheKit()
	{
		armor = new ItemStack[4]; // full armor
		items = new ItemStack[5]; // sword, shield, blocks, golden apples, pickaxe
		makeArmor();
		makeItems();
	}
	
	//get methods
	public ItemStack[] getArmor()
	{
		return armor;
	}
	public ItemStack[] getItems()
	{
		return items;
	}
	//get methods
	
	
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
		items[3] = new ItemStack(Material.GOLDEN_APPLE, 5);
		items[4] = new ItemStack(Material.NETHERITE_PICKAXE);
		
		//------------------------------------------------------
		
		//sword
		ItemMeta swordMeta = items[0].getItemMeta();
		
		//description
		swordMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "KIT PVP");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.WHITE + "made by Jshi"); //i should've made this an instance variable :'c
		lore.add(ChatColor.WHITE + "for pvping");
		swordMeta.setLore(lore);
		
		
		//enchants
		swordMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
		swordMeta.addEnchant(Enchantment.DURABILITY, 10, true);
		swordMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		
		//set sword
		items[0].setItemMeta(swordMeta);
		
		//------------------------------------------------------
		
		//shield
		ItemMeta shieldMeta = items[1].getItemMeta();
		
		//description
		shieldMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "KIT PVP");
		shieldMeta.setLore(lore);
		
		//enchants
		shieldMeta.addEnchant(Enchantment.DURABILITY, 10, true);
		
		//pattern
		BlockStateMeta bmeta = (BlockStateMeta) shieldMeta;
		Banner banner = (Banner) bmeta.getBlockState();
        banner.setBaseColor(DyeColor.PINK);
        banner.addPattern(new Pattern(DyeColor.WHITE, PatternType.FLOWER));

        banner.update();

        bmeta.setBlockState(banner);
        
        //set shield
        items[1].setItemMeta(bmeta);
		
		//------------------------------------------------------
        
        //blocks
        ItemMeta blockMeta = items[2].getItemMeta();
        
        //description
        blockMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "KIT PVP");
		blockMeta.setLore(lore);
        
        //enchants
        blockMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        blockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        
        //set block
        items[2].setItemMeta(blockMeta);
        
        //------------------------------------------------------
        
        // i'm too lazy to deal the the golden apples
        //items[3]
        
        //------------------------------------------------------
        
        //pickaxe
        ItemMeta pickaxeMeta = items[4].getItemMeta();
        
        //description
        pickaxeMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "KIT PVP");
        pickaxeMeta.setLore(lore);
        
        //enchants
        pickaxeMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        pickaxeMeta.addEnchant(Enchantment.DIG_SPEED, 10, true);
        
        //set pickaxe
        items[4].setItemMeta(pickaxeMeta);
        
	}
}
