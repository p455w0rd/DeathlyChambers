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

import java.io.File;

import net.minecraftforge.common.config.Configuration;

/**
 * @author p455w0rd on Jul 29, 2018
 *
 */
public class ModConfig {

	public static Configuration config;
	public static int dimID = 43;
	public static boolean allowSleeping = true;

	public static void load(File configFile) {
		config = new Configuration(configFile);
		config.load();
		dimID = config.get(Configuration.CATEGORY_GENERAL, "DimensionID", 420, "This is the ID of the dimension in the mod, this should be unique to Deathly Chambers").getInt();
		allowSleeping = config.get(Configuration.CATEGORY_GENERAL, "AllowSleeping", true, "Allow sleeping in the custom dimension").getBoolean();
		config.save();
	}

}
