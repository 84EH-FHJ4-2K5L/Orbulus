package orbulus.framework.entityprops;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class EntityPropsExtendedDW  implements IExtendedEntityProperties {

	public final static String EXT_PROP_NAME = "EntityPropsExtendedDW";
	private final EntityPlayer player;
	private int currentMana, maxMana;
	public static final int MANA_WATCHER = 20;
	
	public EntityPropsExtendedDW(EntityPlayer player)
	{
		this.player = player;
		this.maxMana = 50;

		// This adds the new object at our defined index and sets the value to max mana,
		// since we should have full mana when first constructing
		this.player.getDataWatcher().addObject(MANA_WATCHER, this.maxMana);
	}
	
	public static final void register(EntityPlayer player)
	{
	player.registerExtendedProperties(EntityPropsExtendedDW.EXT_PROP_NAME, new EntityPropsExtendedDW(player));
	}
	
	public static final EntityPropsExtendedDW get(EntityPlayer player)
	{
	return (EntityPropsExtendedDW) player.getExtendedProperties(EXT_PROP_NAME);
	}
	
	@Override
	public void saveNBTData(NBTTagCompound compound)
	{
		NBTTagCompound properties = new NBTTagCompound();
		
		properties.setInteger("CurrentMana", this.player.getDataWatcher().getWatchableObjectInt(MANA_WATCHER));
		properties.setInteger("MaxMana", this.maxMana);
		compound.setTag(EXT_PROP_NAME, properties);
	
	}
	
	@Override
	public void loadNBTData(NBTTagCompound compound)
	{
	
	NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);

	this.currentMana = properties.getInteger("CurrentMana");
	this.maxMana = properties.getInteger("MaxMana");
	

	System.out.println("Mana from NBT: " + this.currentMana + "/" + this.maxMana);
	}
	
	@Override
	public void init(Entity entity, World world)
	{
	}
	
	public final boolean consumeMana(int amount)
	{
		// This variable makes it easier to write the rest of the method
		int mana = this.player.getDataWatcher().getWatchableObjectInt(MANA_WATCHER);

		// These two lines are the same as before
		boolean sufficient = amount <= mana;
		mana -= (amount < mana ? amount : mana);

		// Update the data watcher object with the new value
		this.player.getDataWatcher().updateObject(MANA_WATCHER, mana);

		// note that we no longer need to call 'sync()' to update the client

		return sufficient;
	}
	
	public final void replenishMana()
	{
	this.player.getDataWatcher().updateObject(MANA_WATCHER, this.maxMana);
	}
	
	public final int getCurrentMana()
	{
	return this.player.getDataWatcher().getWatchableObjectInt(MANA_WATCHER);
	}
	
	public final void setCurrentMana(int amount)
	{
	this.player.getDataWatcher().updateObject(MANA_WATCHER, (amount < this.maxMana ? amount : this.maxMana));
	}
	}