/*
 * This file is part of Deathly Chambers Mod. Copyright (c) 2017, p455w0rd
 * (aka TheRealp455w0rd), All rights reserved unless otherwise stated.
 *
 * Deathly Chambers Mod is free software: you can redistribute it and/or
 * modify it under the terms of the MIT License.
 *
 * Deathly Chambers Mod is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the MIT License for
 * more details.
 *
 * You should have received a copy of the MIT License along with Deathly
 * Chambers Mod. If not, see <https://opensource.org/licenses/MIT>.
 */
package p455w0rd.deathlychambers.world;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.common.DimensionManager;
import p455w0rd.deathlychambers.init.ModConfig;
import p455w0rd.deathlychambers.init.ModGlobals;
import p455w0rd.deathlychambers.world.biome.DCBiomeProvider;

/**
 * @author p455w0rd on Jul 29, 2018
 *
 */
public class DCWorldProvider extends WorldProvider {

	public static DimensionType type;

	public static void register() {
		if (type == null) {
			type = DimensionType.register(ModGlobals.MODID, "chambers", ModConfig.dimID, DCWorldProvider.class, false);
			DimensionManager.registerDimension(ModConfig.dimID, type);
		}
	}

	@Override
	protected void init() {
		hasSkyLight = true;
		biomeProvider = new DCBiomeProvider();
	}

	@Override
	public DimensionType getDimensionType() {
		return type;
	}

	@Override
	public IChunkGenerator createChunkGenerator() {
		return new DCChunkGenerator(world);
	}

	@Override
	public boolean canRespawnHere() {
		return ModConfig.allowSleeping;
	}

	@Override
	public Vec3d getFogColor(float p_76562_1_, float p_76562_2_) {
		//if (ModConfig.darkSky) {
		return new Vec3d(0D, 0D, 0D);
		//}
		//return super.getFogColor(p_76562_1_, p_76562_2_);
	}

	@Override
	public Vec3d getSkyColor(Entity cameraEntity, float partialTicks) {
		//if (ModConfig.darkSky) {
		return new Vec3d(0D, 0D, 0D);
		//}
		//return super.getSkyColor(cameraEntity, partialTicks);
	}

	@Override
	public long getWorldTime() {
		//if (ModConfig.eternalDay) {
		return 18000;
		//}
		//return super.getWorldTime();
	}

	@Override
	public boolean isDaytime() {
		//if (ModConfig.eternalDay) {
		//	return true;
		//}
		//return super.isDaytime();
		return false;
	}

	@Nullable
	@Override
	public float[] calcSunriseSunsetColors(float celestialAngle, float partialTicks) {
		//if (ModConfig.darkSky) {
		return null;
		//}
		//return super.calcSunriseSunsetColors(celestialAngle, partialTicks);
	}

	@Override
	public int getRespawnDimension(net.minecraft.entity.player.EntityPlayerMP player) {
		if (ModConfig.allowSleeping) {
			return ModConfig.dimID;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean canDoRainSnowIce(net.minecraft.world.chunk.Chunk chunk) {
		return false;
	}

}