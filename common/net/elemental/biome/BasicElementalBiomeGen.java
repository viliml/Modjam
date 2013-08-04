package net.elemental.biome;

import java.util.Random;

import net.elemental.block.Blocks;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BasicElementalBiomeGen extends BiomeGenBase
{
	private EnumBiomes biome;

	@SuppressWarnings("unchecked")
	public BasicElementalBiomeGen(int id, EnumBiomes theBiome) 
	{
		super(id);
		
		biomeName = theBiome.NAME;
		color = theBiome.COLOR;
		fillerBlock = theBiome.FILLER_BLOCK;
		topBlock = theBiome.TOP_BLOCK;
		waterColorMultiplier = theBiome.WATER_COLOR_MULTIPLIER;
		setTemperatureRainfall(theBiome.TEMPERATURE, theBiome.RAINFALL);

		biome = theBiome;
		
        theBiomeDecorator = createBiomeDecorator();
        
        //The Wisdom of the Elements banished all evil thousands of years ago
        spawnableMonsterList.clear();
		spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 5, 4, 4));
        spawnableCreatureList.add(new SpawnListEntry(EntityOcelot.class, 2, 1, 1));
        spawnableCreatureList.add(new SpawnListEntry(EntityHorse.class, 5, 2, 6));

		//addCreatures();
		//addCaveCreatures();
		//addWaterCreatures();
		//addMonsters();

	}
	
	@Override
	public BiomeDecorator createBiomeDecorator()
	{
		return new BiomeDecorator(this);
	}

	@Override
	public int getSkyColorByTemp(float temp)
	{
		super.getSkyColorByTemp(temp);

		return biome.SKY_COLOR;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getBiomeGrassColor()
	{
		super.getBiomeGrassColor();

		return biome.GRASS_COLOR;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getBiomeFoliageColor()
	{
		super.getBiomeFoliageColor();

		return biome.FOLIAGE_COLOR;
	}

	public byte getLiquidBlock()
	{
		return biome.LIQUID_BLOCK;
	}

	public byte getFrozenBlock()
	{
		return biome.FROZEN_BLOCK;
	}

	public EnumBiomes getBiome()
	{
		return biome;
	}
	
	@Override
	public void decorate(World world, Random random, int x, int z)
    {
        super.decorate(world, random, x, z);
        int k = 3 + random.nextInt(6);
        int l;
        int i1;
        int j1;

        for (l = 0; l < k; ++l)
        {
            i1 = x + random.nextInt(16);
            j1 = random.nextInt(28) + 4;
            int k1 = z + random.nextInt(16);
            int l1 = world.getBlockId(i1, j1, k1);

            if (l1 == Blocks.elementalStoneBlock.blockID)
            {
                world.setBlock(i1, j1, k1,
                		Blocks.elementalOreBlock2.blockID, 4 + biome.ordinal(), 2);
            }
        }
    }
	
	/*@SuppressWarnings("unchecked")
	private void addCaveCreatures()
	{
        spawnableCaveCreatureList.add(new SpawnListEntry(EntityElementalBat.class, 10, 8, 8));
	}

	@SuppressWarnings("unchecked")
	private void addMonsters()
	{
        //spawnableMonsterList.add(new SpawnListEntry(EntityElementalSpider.class, 10, 4, 4));
        //spawnableMonsterList.add(new SpawnListEntry(EntityElementalZombie.class, 10, 4, 4));
        //spawnableMonsterList.add(new SpawnListEntry(EntityElementalSkeleton.class, 10, 4, 4));
        //spawnableMonsterList.add(new SpawnListEntry(EntityElementalCreeper.class, 10, 4, 4));
        //spawnableMonsterList.add(new SpawnListEntry(EntityElementalSlime.class, 10, 4, 4));
        //spawnableMonsterList.add(new SpawnListEntry(EntityElementalEnderman.class, 1, 1, 4));
	}

	@SuppressWarnings("unchecked")
	private void addWaterCreatures()
	{
        spawnableWaterCreatureList.add(new SpawnListEntry(EntityElementalSquid.class, 10, 4, 4));
    }

	@SuppressWarnings("unchecked")
	private void addCreatures()
	{
		spawnableCreatureList.add(new SpawnListEntry(EntityElementalSheep.class, 12, 4, 4));
		spawnableCreatureList.add(new SpawnListEntry(EntityElementalPig.class, 10, 4, 4));
		spawnableCreatureList.add(new SpawnListEntry(EntityElementalChicken.class, 15, 4, 4));
		spawnableCreatureList.add(new SpawnListEntry(EntityElementalCow.class, 8, 4, 4));
        spawnableCreatureList.add(new SpawnListEntry(EntityElementalWolf.class, 5, 4, 4));
        spawnableMonsterList.add(new SpawnListEntry(EntityElementalOcelot.class, 2, 1, 1));
	}*/
}
