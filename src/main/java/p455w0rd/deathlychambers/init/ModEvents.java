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
package p455w0rd.deathlychambers.init;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author p455w0rd on Jul 29, 2018
 *
 */
@EventBusSubscriber
public class ModEvents {

	@SubscribeEvent
	public static void onBlockRegistryReady(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(ModBlocks.getList().toArray(new Block[ModBlocks.getList().size()]));
		ForgeRegistries.ITEMS.register(new ItemBlock(ModBlocks.PORTAL).setRegistryName(ModBlocks.PORTAL.getRegistryName()));
	}

	@SubscribeEvent
	public static void onBiomeRegistryReady(RegistryEvent.Register<Biome> event) {
		event.getRegistry().register(ModBiomes.DEATHLY_CHAMBERS);
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void onModelRegistryReady(ModelRegistryEvent event) {
		ModBlocks.registerModels();
	}

	@SubscribeEvent
	public static void onPlayerJoin(PlayerLoggedInEvent event) {
		if (ModGlobals.inDev) {
			event.player.addItemStackToInventory(new ItemStack(ModBlocks.PORTAL));
		}
	}

	@SubscribeEvent
	public static void onServerTick(TickEvent.ServerTickEvent event) {

	}

}
