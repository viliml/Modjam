package net.elemental.biome;

import net.elemental.block.Blocks;
import net.minecraft.block.Block;

public enum EnumBiomes 
{
	Earth 
	(
		"Earth biome",
		0x996633,
		0x996633,
		0x996633,
		0x996633,
		0x996633,
		(byte) Blocks.elementalStoneBlock.blockID,
		(byte) Block.dirt.blockID,
		//TODO make these some kind of mud
		(byte) Block.waterStill.blockID,
		(byte) Block.ice.blockID
	),
	Air 
	(
		"Air biome",
		0xFFFFFF,
		0xFFFFFF,
		0xFFFFFF,
		0xFFFFFF,
		0xFFFFFF,
		(byte) Blocks.elementalStoneBlock.blockID,
		(byte) Block.web.blockID,
		(byte) Block.waterStill.blockID,
		(byte) Block.ice.blockID
	),
	Fire 
	(
		"Fire biome",
		0xFF8800,
		0xFF8800,
		0xFF8800,
		0xFF8800,
		0xFF8800,
		(byte) Blocks.elementalStoneBlock.blockID,
		(byte) Block.fire.blockID,
		(byte) Block.lavaStill.blockID,
		(byte) Block.obsidian.blockID
	),
	Water 
	(
		"Water biome",
		0x0000FF,
		0x0000FF,
		0x0000FF,
		0x0000FF,
		0x0000FF,
		(byte) Blocks.elementalStoneBlock.blockID,
		(byte) Block.waterMoving.blockID,
		(byte) Block.waterStill.blockID,
		(byte) Block.ice.blockID
	);
	
	public final String NAME;
	public final int COLOR;
	public final int WATER_COLOR_MULTIPLIER;
	public final int SKY_COLOR;
	public final int FOLIAGE_COLOR;
	public final int GRASS_COLOR;
	public final byte FILLER_BLOCK;
	public final byte TOP_BLOCK;
	public final byte LIQUID_BLOCK;
	public final byte FROZEN_BLOCK;
	
	EnumBiomes(String name, int color, int water_color_multiplier,
			int sky_color, int foliage_color, int grass_color,
			byte filler_block, byte top_block, byte liquid_block, byte frozen_block)
	{
		this.NAME = name;
		this.COLOR = color;
		this.WATER_COLOR_MULTIPLIER = water_color_multiplier;
		this.SKY_COLOR = sky_color;
		this.FOLIAGE_COLOR = foliage_color;
		this.GRASS_COLOR = grass_color;
		this.FILLER_BLOCK = filler_block;
		this.TOP_BLOCK = top_block;
		this.LIQUID_BLOCK = liquid_block;
		this.FROZEN_BLOCK = frozen_block;
	}
}
