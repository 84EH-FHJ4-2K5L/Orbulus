package orbulus;

import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import orbulus.framework.events.OrbulusEventHandler;
import orbulus.framework.keyhandler.KeyHandler;
import orbulus.framework.network.OpenGuiMessage;
import orbulus.framework.network.PacketDispatcher;
import orbulus.framework.proxy.CommonProxy;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.relauncher.Side;


@Mod(modid = orbulus.MODID, version = orbulus.VERSION)
public class orbulus
{
	@Instance
	public static orbulus instance;
	
	@SidedProxy
	(clientSide = "orbulus.framework.proxy.ClientProxy")
	public static CommonProxy proxy;
	
	public static final String MODID = "orbulus";
    public static final String VERSION = "";
    private static int modGuiIndex = 0;
    public static final int GUI_CUSTOM_INV = modGuiIndex++;

	
    
    @EventHandler
    public void preInit(FMLInitializationEvent event)
    {
    	
    	PacketDispatcher.registerPackets();
    	}
    	
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    
    }
    @EventHandler
	public void postLoad(FMLPostInitializationEvent event)
	{
	MinecraftForge.EVENT_BUS.register(new OrbulusEventHandler());
	}
}
