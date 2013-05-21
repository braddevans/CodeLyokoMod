package matt.lyoko.blocks;

import matt.lyoko.CodeLyoko;
import matt.lyoko.entities.tileentity.TileEntityScanner;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockScanner extends BlockContainer
{
	public BlockScanner(int par1)
	{
		super(par1, Material.iron);
		this.setCreativeTab(CodeLyoko.LyokoTabs);
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1)
	{
		return new TileEntityScanner();
	}
	
	@Override
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon("lyoko:scanner");
	}
	
	public boolean isMultiBlock(World world, int x, int y, int z)
    {
    	if(world.getBlockId(x+1, y, z+1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x+1, y, z) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x+1, y, z-1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x, y, z+1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x, y, z) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x, y, z-1) == CodeLyoko.TowerBlock.blockID
    			
    			&& world.getBlockId(x+1, y+1, z+1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x+1, y+1, z) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x+1, y+1, z-1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x, y+1, z+1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x, y+1, z-1) == CodeLyoko.TowerBlock.blockID
    			
    			&& world.getBlockId(x+1, y+2, z+1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x+1, y+2, z) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x+1, y+2, z-1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x, y+2, z+1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x, y+2, z-1) == CodeLyoko.TowerBlock.blockID
    			
    			&& world.getBlockId(x+1, y+3, z+1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x+1, y+3, z) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x+1, y+3, z-1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x, y+3, z+1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x, y+3, z-1) == CodeLyoko.TowerBlock.blockID
    			
    			&& world.getBlockId(x+1, y+4, z+1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x+1, y+4, z) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x+1, y+4, z-1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x, y+4, z+1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x, y+4, z) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x, y+4, z-1) == CodeLyoko.TowerBlock.blockID)
    	{
    		return true;
    	}
    	else if(world.getBlockId(x-1, y, z+1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x-1, y, z) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x-1, y, z-1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x, y, z+1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x, y, z) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x, y, z-1) == CodeLyoko.TowerBlock.blockID
    			
    			&& world.getBlockId(x-1, y+1, z+1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x-1, y+1, z) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x-1, y+1, z-1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x, y+1, z+1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x, y+1, z-1) == CodeLyoko.TowerBlock.blockID
    			
    			&& world.getBlockId(x-1, y+2, z+1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x-1, y+2, z) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x-1, y+2, z-1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x, y+2, z+1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x, y+2, z-1) == CodeLyoko.TowerBlock.blockID
    			
    			&& world.getBlockId(x-1, y+3, z+1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x-1, y+3, z) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x-1, y+3, z-1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x, y+3, z+1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x, y+3, z-1) == CodeLyoko.TowerBlock.blockID
    			
    			&& world.getBlockId(x-1, y+4, z+1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x-1, y+4, z) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x-1, y+4, z-1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x, y+4, z+1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x, y+4, z) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x, y+4, z-1) == CodeLyoko.TowerBlock.blockID)
    	{
    		return true;
    	}
    	else if(world.getBlockId(x+1, y, z+1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x, y, z+1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x-1, y, z+1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x+1, y, z) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x, y, z) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x-1, y, z) == CodeLyoko.TowerBlock.blockID
    			
    			&& world.getBlockId(x+1, y+1, z+1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x, y+1, z+1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x-1, y+1, z+1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x+1, y+1, z) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x-1, y+1, z) == CodeLyoko.TowerBlock.blockID
    			
    			&& world.getBlockId(x+1, y+2, z+1) == CodeLyoko.TowerBlock.blockID
    	    	&& world.getBlockId(x, y+2, z+1) == CodeLyoko.TowerBlock.blockID
    	    	&& world.getBlockId(x-1, y+2, z+1) == CodeLyoko.TowerBlock.blockID
    	    	&& world.getBlockId(x+1, y+2, z) == CodeLyoko.TowerBlock.blockID
    	    	&& world.getBlockId(x-1, y+2, z) == CodeLyoko.TowerBlock.blockID
    			
    	    	&& world.getBlockId(x+1, y+3, z+1) == CodeLyoko.TowerBlock.blockID
    	    	&& world.getBlockId(x, y+3, z+1) == CodeLyoko.TowerBlock.blockID
    	    	&& world.getBlockId(x-1, y+3, z+1) == CodeLyoko.TowerBlock.blockID
    	    	&& world.getBlockId(x+1, y+3, z) == CodeLyoko.TowerBlock.blockID
    	    	&& world.getBlockId(x-1, y+3, z) == CodeLyoko.TowerBlock.blockID
    			
    	    	&& world.getBlockId(x+1, y+4, z+1) == CodeLyoko.TowerBlock.blockID
    	    	&& world.getBlockId(x, y+4, z+1) == CodeLyoko.TowerBlock.blockID
    	    	&& world.getBlockId(x-1, y+4, z+1) == CodeLyoko.TowerBlock.blockID
    	    	&& world.getBlockId(x+1, y+4, z) == CodeLyoko.TowerBlock.blockID
    	    	&& world.getBlockId(x, y+4, z) == CodeLyoko.TowerBlock.blockID
    	    	&& world.getBlockId(x-1, y+4, z) == CodeLyoko.TowerBlock.blockID)
    	{
    		return true;
    	}
    	else if(world.getBlockId(x+1, y, z-1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x, y, z-1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x-1, y, z-1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x+1, y, z) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x, y, z) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x-1, y, z) == CodeLyoko.TowerBlock.blockID
    			
    			&& world.getBlockId(x+1, y+1, z-1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x, y+1, z-1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x-1, y+1, z-1) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x+1, y+1, z) == CodeLyoko.TowerBlock.blockID
    			&& world.getBlockId(x-1, y+1, z) == CodeLyoko.TowerBlock.blockID
    			
    			&& world.getBlockId(x+1, y+2, z-1) == CodeLyoko.TowerBlock.blockID
    	    	&& world.getBlockId(x, y+2, z-1) == CodeLyoko.TowerBlock.blockID
    	    	&& world.getBlockId(x-1, y+2, z-1) == CodeLyoko.TowerBlock.blockID
    	    	&& world.getBlockId(x+1, y+2, z) == CodeLyoko.TowerBlock.blockID
    	    	&& world.getBlockId(x-1, y+2, z) == CodeLyoko.TowerBlock.blockID
    			
    	    	&& world.getBlockId(x+1, y+3, z-1) == CodeLyoko.TowerBlock.blockID
    	    	&& world.getBlockId(x, y+3, z-1) == CodeLyoko.TowerBlock.blockID
    	    	&& world.getBlockId(x-1, y+3, z-1) == CodeLyoko.TowerBlock.blockID
    	    	&& world.getBlockId(x+1, y+3, z) == CodeLyoko.TowerBlock.blockID
    	    	&& world.getBlockId(x-1, y+3, z) == CodeLyoko.TowerBlock.blockID
    			
    	    	&& world.getBlockId(x+1, y+4, z-1) == CodeLyoko.TowerBlock.blockID
    	    	&& world.getBlockId(x, y+4, z-1) == CodeLyoko.TowerBlock.blockID
    	    	&& world.getBlockId(x-1, y+4, z-1) == CodeLyoko.TowerBlock.blockID
    	    	&& world.getBlockId(x+1, y+4, z) == CodeLyoko.TowerBlock.blockID
    	    	&& world.getBlockId(x, y+4, z) == CodeLyoko.TowerBlock.blockID
    	    	&& world.getBlockId(x-1, y+4, z) == CodeLyoko.TowerBlock.blockID)
    	{
    		return true;
    	}
    	return false;
    }
	
	public void activatePortal(World world, int x, int y, int z)
	{
		TileEntityScanner tile = (TileEntityScanner)world.getBlockTileEntity(x, y, z);
		if(tile != null)
		{
			int portal;
			switch(tile.sector)
			{
			case 0:
				portal = CodeLyoko.LyokoPolarPortal.blockID;
				break;
			case 1:
				portal = CodeLyoko.LyokoDesertPortal.blockID;
				break;
			case 2:
				portal = CodeLyoko.LyokoForestPortal.blockID;
				break;
			case 3:
				portal = CodeLyoko.LyokoMountainPortal.blockID;
				break;
			case 4:
				portal = CodeLyoko.LyokoCarthagePortal.blockID;
				break;
			default:
				portal = 0;
			}
			world.setBlock(x, y + 1, z, portal);
			world.setBlock(x, y + 2, z, portal);
		}
	}
	
	@Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int idk, float what, float these, float are)
    {
    	TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
    	if (tileEntity == null || player.isSneaking())
    	{
    		return false;
    	}
    	else
    	{
    		for(int i = -1; i < 2; i++)
    		{
    			for(int j = -1; j < 2; j++)
    			{
    				for(int k = -5; k < 0; k++)
    				{
    					if(this.isMultiBlock(world, x+i, y+k, z+j))
    					{
    						activatePortal(world, x+i, y+k, z+j);
    						return true;
    					}
    				}
    			}
    		}
    		return false;
    	}
    }
}
