package orbulus.framework.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

import orbulus.framework.entityprops.EntityPropsExtendedDW;

public class OrbulusEventHandler
{
	
	
	@SubscribeEvent
	public void update(LivingUpdateEvent e) 
	{
		if (e.entity instanceof EntityAnimal)
		{
			System.out.println("Damn");
	
		}
	}
	
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event)
	{
		
		if (event.entity instanceof EntityPlayer && EntityPropsExtendedDW.get((EntityPlayer) event.entity) == null)
			
			EntityPropsExtendedDW.register((EntityPlayer) event.entity);
		
		if (event.entity instanceof EntityPlayer && event.entity.getExtendedProperties(EntityPropsExtendedDW.EXT_PROP_NAME) == null)
			event.entity.registerExtendedProperties(EntityPropsExtendedDW.EXT_PROP_NAME, new EntityPropsExtendedDW((EntityPlayer) event.entity));
	}
	
	/**@SubscribeEvent
	public void getYaw(LivingUpdateEvent e) {
		if(e.entity instanceof EntityPlayer)
		System.out.println("This is Yaw " + e.entity.rotationYaw);
	}*/
}
