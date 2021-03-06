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
package p455w0rd.deathlychambers.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import p455w0rd.deathlychambers.world.DCWorldProvider;

/**
 * @author p455w0rd on Jul 29, 2018
 *
 */
public class CommonProxy {

	public void preInit(FMLPreInitializationEvent e) {
		DCWorldProvider.register();
		//ModConfig.preInit();
		//ModItems.preInit();
		//ModNetworking.preInit();
		//ModEvents.preInit();
		//ModIntegration.preInit();
	}

	public void init(FMLInitializationEvent e) {
	}

	public void postInit(FMLPostInitializationEvent e) {
		//ModNetworking.postInit();
	}

}
