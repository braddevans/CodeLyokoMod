/*
 * Code Lyoko Mod for Minecraft v@VERSION
 * Copyright 2013 Cortex Modders, Matthew Warren, Jacob Rhoda, and
 * other contributors.
 * Released under the MIT license
 * http://opensource.org/licenses/MIT
 */

package matt.lyoko.world;

import java.util.Random;

import matt.lyoko.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class StructureTower extends WorldGenerator
{
    protected Block[] GetValidSpawnBlocks()
    {
        return new Block[] {ModBlocks.Grass, ModBlocks.Stone, ModBlocks.Sand, ModBlocks.Ice, ModBlocks.Carthage, ModBlocks.SectorBlock};
    }

    public boolean LocationIsValidSpawn(World world, int x, int y, int z)
    {
        int distanceToAir = y + 1;
        while (distanceToAir < 256)
        {
        			// getBlock
            if(!world.func_147439_a(x, distanceToAir, z).equals(Block.func_149684_b("air")))
                return false;
            distanceToAir++;
        }

        for (int i = 0; i < 7; i++)
            for (int j = 0; j < 7; j++)
                if (!(i > 0 && i < 6 || j > 0 && j < 6))
                    if (world.func_147439_a(x + i, y, z + j).equals(Block.func_149684_b("air")))
                        return false;

        Block block = world.func_147439_a(x, y, z);
        Block blockAbove = world.func_147439_a(x, y + 1, z);
        Block blockBelow = world.func_147439_a(x, y - 1, z);
        for (Block b : this.GetValidSpawnBlocks())
        {
            if (!blockAbove.equals(Block.func_149684_b("air")))
                return false;
            if (block.equals(b))
                return true;
            else if (block.equals(Block.snow) && blockBelow.equals(b))
                return true;
        }
        return false;
    }

    @Override
    public boolean generate(World world, Random rand, int x, int y, int z)
    {
        if (!this.LocationIsValidSpawn(world, x, y, z))
            return false;

        this.makeTower(world, x, y, z);

        return true;
    }

    public void makeTower(World world, int x, int y, int z)
    {
        this.clearArea(world, x, y, z);
        this.makeWalls(world, x, y, z);
        this.makeBaseAndRoof(world, x, y, z);
    }

    private void makeWalls(World world, int x, int y, int z)
    {
        for (int i = 4; i < 23; i++)
            this.makeLayer(world, x, y + i, z);
    }

    private void makeBaseAndRoof(World world, int x, int y, int z)
    {
        // base
        for (int i = 1; i < 6; i++)
            for (int j = 1; j < 6; j++)
                world.setBlock(x + i, y - 6, z + j, ModBlocks.DigitalSeaBlock);
        for (int i = -5; i < 1; i++)
            this.makeUndergroundLayer(world, x, y + i, z);
        for (int i = 1; i < 4; i++)
            for (int j = 2; j < 5; j++)
                world.setBlock(x + i, y, z + j, ModBlocks.TowerFloor);
        world.setBlock(x + 4, y, z + 3, ModBlocks.TowerFloor);
        world.setBlock(x + 5, y, z + 3, ModBlocks.TowerFloor);
        this.makeBaseLayer(world, x, y + 1, z);
        this.makeBaseLayer(world, x, y + 2, z);
        this.makeBaseLayer(world, x, y + 3, z);

        // roof
        for (int i = 1; i < 4; i++)
            for (int j = 2; j < 5; j++)
                world.setBlock(x + i, y + 19, z + j, ModBlocks.TowerFloor, 1, 3);
        world.setBlock(x + 1, y + 21, z + 3, ModBlocks.TowerConsole, 1, 3);
        this.makeRoofLayer(world, x, y + 23, z);
    }

    private void clearArea(World world, int x, int y, int z)
    {
        for (int i = 0; i < 11; i++)
            for (int j = 1; j < 25; j++)
                for (int k = 0; k < 11; k++)
                    world.setBlock(x + i - 2, y + j, z + k - 2, 0);
        for (int i = 1; i < 6; i++)
            for (int j = 0; j > -6; j--)
                for (int k = 1; k < 6; k++)
                    world.setBlock(x + i, y + j, z + k, 0);
    }

    private void makeBaseLayer(World world, int x, int y, int z)
    {
        world.setBlock(x + 1, y, z, ModBlocks.TowerBase, 2, 2);
        world.setBlock(x + 2, y, z, ModBlocks.TowerBase, 2, 2);
        world.setBlock(x + 3, y, z, ModBlocks.TowerBase, 2, 2);
        world.setBlock(x + 4, y, z, ModBlocks.TowerBase, 2, 2);
        world.setBlock(x + 5, y, z, ModBlocks.TowerBase, 2, 2);
        world.setBlock(x, y, z + 1, ModBlocks.TowerBase, 1, 2);
        world.setBlock(x, y, z + 2, ModBlocks.TowerBase, 1, 2);
        world.setBlock(x, y, z + 3, ModBlocks.TowerBase, 1, 2);
        world.setBlock(x, y, z + 4, ModBlocks.TowerBase, 1, 2);
        world.setBlock(x, y, z + 5, ModBlocks.TowerBase, 1, 2);
        world.setBlock(x + 6, y, z + 1, ModBlocks.TowerBase, 3, 2);
        world.setBlock(x + 6, y, z + 2, ModBlocks.TowerBase, 8, 2);
        world.setBlock(x + 6, y, z + 3, ModBlocks.TowerBase, 8, 2);
        world.setBlock(x + 6, y, z + 4, ModBlocks.TowerBase, 8, 2);
        world.setBlock(x + 6, y, z + 5, ModBlocks.TowerBase, 3, 2);
        world.setBlock(x + 1, y, z + 6, ModBlocks.TowerBase, 0, 2);
        world.setBlock(x + 2, y, z + 6, ModBlocks.TowerBase, 0, 2);
        world.setBlock(x + 3, y, z + 6, ModBlocks.TowerBase, 0, 2);
        world.setBlock(x + 4, y, z + 6, ModBlocks.TowerBase, 0, 2);
        world.setBlock(x + 5, y, z + 6, ModBlocks.TowerBase, 0, 2);
    }

    private void makeUndergroundLayer(World world, int x, int y, int z)
    {
        world.setBlock(x + 1, y, z, ModBlocks.TowerBase, 2, 2);
        world.setBlock(x + 2, y, z, ModBlocks.TowerBase, 2, 2);
        world.setBlock(x + 3, y, z, ModBlocks.TowerBase, 2, 2);
        world.setBlock(x + 4, y, z, ModBlocks.TowerBase, 2, 2);
        world.setBlock(x + 5, y, z, ModBlocks.TowerBase, 2, 2);
        world.setBlock(x, y, z + 1, ModBlocks.TowerBase, 1, 2);
        world.setBlock(x, y, z + 2, ModBlocks.TowerBase, 1, 2);
        world.setBlock(x, y, z + 3, ModBlocks.TowerBase, 1, 2);
        world.setBlock(x, y, z + 4, ModBlocks.TowerBase, 1, 2);
        world.setBlock(x, y, z + 5, ModBlocks.TowerBase, 1, 2);
        world.setBlock(x + 6, y, z + 1, ModBlocks.TowerBase, 3, 2);
        world.setBlock(x + 6, y, z + 2, ModBlocks.TowerBase, 3, 2);
        world.setBlock(x + 6, y, z + 3, ModBlocks.TowerBase, 3, 2);
        world.setBlock(x + 6, y, z + 4, ModBlocks.TowerBase, 3, 2);
        world.setBlock(x + 6, y, z + 5, ModBlocks.TowerBase, 3, 2);
        world.setBlock(x + 1, y, z + 6, ModBlocks.TowerBase, 0, 2);
        world.setBlock(x + 2, y, z + 6, ModBlocks.TowerBase, 0, 2);
        world.setBlock(x + 3, y, z + 6, ModBlocks.TowerBase, 0, 2);
        world.setBlock(x + 4, y, z + 6, ModBlocks.TowerBase, 0, 2);
        world.setBlock(x + 5, y, z + 6, ModBlocks.TowerBase, 0, 2);
    }

    private void makeLayer(World world, int x, int y, int z)
    {
        world.setBlock(x + 1, y, z, ModBlocks.TowerBlock, 2, 2);
        world.setBlock(x + 2, y, z, ModBlocks.TowerBlock, 2, 2);
        world.setBlock(x + 3, y, z, ModBlocks.TowerBlock, 2, 2);
        world.setBlock(x + 4, y, z, ModBlocks.TowerBlock, 2, 2);
        world.setBlock(x + 5, y, z, ModBlocks.TowerBlock, 2, 2);
        world.setBlock(x, y, z + 1, ModBlocks.TowerBlock, 1, 2);
        world.setBlock(x, y, z + 2, ModBlocks.TowerBlock, 1, 2);
        world.setBlock(x, y, z + 3, ModBlocks.TowerBlock, 1, 2);
        world.setBlock(x, y, z + 4, ModBlocks.TowerBlock, 1, 2);
        world.setBlock(x, y, z + 5, ModBlocks.TowerBlock, 1, 2);
        world.setBlock(x + 6, y, z + 1, ModBlocks.TowerBlock, 3, 2);
        world.setBlock(x + 6, y, z + 2, ModBlocks.TowerBlock, 3, 2);
        world.setBlock(x + 6, y, z + 3, ModBlocks.TowerBlock, 3, 2);
        world.setBlock(x + 6, y, z + 4, ModBlocks.TowerBlock, 3, 2);
        world.setBlock(x + 6, y, z + 5, ModBlocks.TowerBlock, 3, 2);
        world.setBlock(x + 1, y, z + 6, ModBlocks.TowerBlock, 0, 2);
        world.setBlock(x + 2, y, z + 6, ModBlocks.TowerBlock, 0, 2);
        world.setBlock(x + 3, y, z + 6, ModBlocks.TowerBlock, 0, 2);
        world.setBlock(x + 4, y, z + 6, ModBlocks.TowerBlock, 0, 2);
        world.setBlock(x + 5, y, z + 6, ModBlocks.TowerBlock, 0, 2);
    }

    private void makeRoofLayer(World world, int x, int y, int z)
    {
        for (int i = 0; i < 7; i++)
            for (int j = 0; j < 7; j++)
                if (!((i == 0 || i == 6) && (j == 0 || j == 6)))
                    world.setBlock(x + i, y, z + j, ModBlocks.TowerBlock, 4, 2);
        for (int i = 1; i < 6; i++)
            for (int j = 1; j < 6; j++)
                world.setBlock(x + i, y + 1, z + j, ModBlocks.TowerBlock, 4, 2);
    }
}