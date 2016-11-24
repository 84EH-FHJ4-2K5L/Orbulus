package orbulus.framework.assemblers;

import net.minecraft.item.Item;
import orbulus.framework.enums.ItemList.Details;
import orbulus.framework.interfaces.IAssembler;

public class ItemAssembler extends Item
{
	
	ItemAssembler(String name, String itemType, int stack) 
	{
		this.setUnlocalizedName(name);
		this.setTextureName(name);
		this.setMaxStackSize(stack);
	}
	
	
	
	/**public String setitemType() {
		if (ItemType == null) {
			case 'Details' {
				
			}
		}
		return null;
	}*/
	
}