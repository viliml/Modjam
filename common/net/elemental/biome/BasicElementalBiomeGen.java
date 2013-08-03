package net.elemental.biome;

import net.elemental.entity.passive.*;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BasicElementalBiomeGen extends BiomeGenBase
{
	private EnumBiomes biome;

	public BasicElementalBiomeGen(int id, EnumBiomes theBiome) 
	{
		super(id);

		biomeName = biome.NAME;
		color = biome.COLOR;
		fillerBlock = biome.FILLER_BLOCK;
		topBlock = biome.TOP_BLOCK;
		waterColorMultiplier = biome.WATER_COLOR_MULTIPLIER;

		biome = theBiome;

		spawnableCaveCreatureList.clear();
		spawnableCreatureList.clear();
		spawnableMonsterList.clear();
		spawnableWaterCreatureList.clear();
		
		theBiomeDecorator = createBiomeDecorator();

		addCreatures();
		addCaveCreatures();
		addWaterCreatures();
		addMonsters();

		setDisableRain();
	}
	
	@Override
	public BiomeDecorator createBiomeDecorator()
	{
		return new ElementalBiomeDecorator(this);
	}
	
	@SuppressWarnings("unchecked")
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
}
