package magicbees.elec332.corerepack.item;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Elec332 on 21-8-2016.
 */
public interface IEnumItem {

    /**
     * Here you can initialize your item, like setting max uses, creative tab, ect...
     * This only gets called for the first Enum value (ordinal 0), because all values
     * use the same item.
     *
     * @param item The item
     */
    public void initializeItem(ItemEnumBased<? extends IEnumItem> item);

    default int getColorFromItemStack(ItemStack stack, int tintIndex) {
        return -1;
    }

    default public boolean shouldShow(){
        return true;
    }

    default public ResourceLocation[] getTextures(){
        return new ResourceLocation[]{
            getTextureLocation()
        };
    }

    public ResourceLocation getTextureLocation();

    default public String getTranslationKey(ItemStack stack){
        return stack.getItem().getTranslationKey(null)+"."+((Enum) this).name().toLowerCase();
    }

}
