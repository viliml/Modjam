package net.elemental.biome;

import net.elemental.entity.passive.*;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BasicElementalBiomeGen extends BiomeGenBase
{
	private EnumBiomes biome;

	public BasicElementalBiomeGen(int id, EnumBiomes biome) 
	{
		super(id);

		this.biomeName = biome.NAME;
		this.color = biome.COLOR;
		this.fillerBlock = biome.FILLER_BLOCK;
		this.topBlock = biome.TOP_BLOCK;
		this.waterColorMultiplier = biome.WATER_COLOR_MULTIPLIER;

		this.biome = biome;

		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();

		addCreatures();
		addCaveCreatures();
		addWaterCreatures();
		addMonsters();

		this.setDisableRain();
	}

	@SuppressWarnings("unchecked")
	private void addCaveCreatures()
	{
        this.spawnableCaveCreatureList.add(new SpawnListEntry(EntityElementalBat.class, 10, 8, 8));
	}

	@SuppressWarnings("unchecked")
	private void addMonsters()
	{
        //this.spawnableMonsterList.add(new SpawnListEntry(EntityElementalSpider.class, 10, 4, 4));
        //this.spawnableMonsterList.add(new SpawnListEntry(EntityElementalZombie.class, 10, 4, 4));
        //this.spawnableMonsterList.add(new SpawnListEntry(EntityElementalSkeleton.class, 10, 4, 4));
        //this.spawnableMonsterList.add(new SpawnListEntry(EntityElementalCreeper.class, 10, 4, 4));
        //this.spawnableMonsterList.add(new SpawnListEntry(EntityElementalSlime.class, 10, 4, 4));
        //this.spawnableMonsterList.add(new SpawnListEntry(EntityElementalEnderman.class, 1, 1, 4));
	}

	@SuppressWarnings("unchecked")
	private void addWaterCreatures()
	{
        this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityElementalSquid.class, 10, 4, 4));
    }

	@SuppressWarnings("unchecked")
	private void addCreatures()
	{
		this.spawnableCreatureList.add(new SpawnListEntry(EntityElementalSheep.class, 12, 4, 4));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityElementalPig.class, 10, 4, 4));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityElementalChicken.class, 15, 4, 4));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityElementalCow.class, 8, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityElementalWolf.class, 5, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityElementalOcelot.class, 2, 1, 1));
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
