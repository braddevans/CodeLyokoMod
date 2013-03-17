package matt.lyoko.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;
import net.minecraft.src.*;
import matt.lyoko.*;

public class ItemLyokoSword extends ItemSword
{
	public ItemLyokoSword(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setCreativeTab(CodeLyoko.LyokoTabs);
	}
	
	@Override
	public void func_94581_a(IconRegister iconRegister)
	{
		if(this.itemID == CodeLyoko.Katana.itemID)
	         iconIndex = iconRegister.func_94245_a("lyoko:katana");
		if(this.itemID == CodeLyoko.Zweihander.itemID)
	         iconIndex = iconRegister.func_94245_a("lyoko:zweihander");
	}
}
