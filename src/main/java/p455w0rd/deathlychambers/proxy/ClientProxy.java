package p455w0rd.deathlychambers.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
// import p455w0rd.deathlychambersinit.ModCreativeTab;
// import p455w0rd.deathlychambersinit.ModIntegration;
// import p455w0rd.deathlychambersinit.ModItems;
// import p455w0rd.deathlychambersinit.ModKeybindings;

/**
 * @author p455w0rd
 *
 */
public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		//ModItems.preInitModels();
		//ModKeybindings.preInit();
		//ModCreativeTab.preInit();
	}

	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		//ModIntegration.postInit();
		super.postInit(e);
	}

}
