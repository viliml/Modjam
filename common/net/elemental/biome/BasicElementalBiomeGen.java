package net.elemental.biome;

import net.minecraft.world.biome.BiomeGenBase;
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
		
		this.setDisableRain();
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
