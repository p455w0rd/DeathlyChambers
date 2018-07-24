package p455w0rd.deathlychambers.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
// import p455w0rd.deathlychambersinit.ModConfig;
// import p455w0rd.deathlychambersinit.ModEvents;
// import p455w0rd.deathlychambersinit.ModIntegration;
// import p455w0rd.deathlychambersinit.ModItems;
// import p455w0rd.deathlychambersinit.ModNetworking;

/**
 * @author p455w0rd
 *
 */
public class CommonProxy {

	public void preInit(FMLPreInitializationEvent e) {
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
